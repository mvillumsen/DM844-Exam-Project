package dk.dm844.webshop

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured([SecurityRole.EMPLOYEE])
class ProductController {

    def beforeInterceptor = {
        log.info """<log-entry><time>${new Date()}</time><sessionid>${session.getId()}</sessionid><info>${params}</info></log-entry>"""
    }

    def cartService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model: [productInstanceCount: Product.count()]
    }

    def show(Product productInstance) {
        respond productInstance
    }

    @Secured([SecurityRole.Employee.ADMIN])
    def create() {
        respond new Product(params)
    }

    @Transactional
    def save(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view: 'create'
            return
        }

        productInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
                redirect action: 'index'
            }
            '*' { respond productInstance, [status: CREATED] }
        }
    }

    @Secured([SecurityRole.Employee.ADMIN])
    def edit(Product productInstance) {
        respond productInstance
    }

    @Transactional
    def update(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view: 'edit'
            return
        }

        productInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: OK] }
        }
    }

    @Secured([SecurityRole.Employee.ADMIN])
    @Transactional
    def delete(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        productInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    @Secured(['permitAll'])
    @Transactional
    def addToCart(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        Integer amount = 1
        String param = request.getParameter("amount")
        if (param && param.isInteger()) {
            amount = Math.max(1, param.toInteger())
        }

        cartService.addToShoppingCart(productInstance, amount)
        productInstance.save(flush: true)

        if (request.xhr) {
            render(contentType: 'text/json') {
                ['count': cartService.count()]
            }
        } else {
            redirect(uri: request.getHeader('referer'))
        }
    }

    @Secured(['permitAll'])
    @Transactional
    def removeAllFromCart(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        int amount = cartService.getQuantity(productInstance)
        cartService.removeFromShoppingCart(productInstance, amount)
        productInstance.save flush: true

        if (request.xhr) {
            render(contentType: 'text/json') {
                ['count': cartService.count()]
            }
        } else {
            redirect(uri: request.getHeader('referer'))
        }
    }
}
