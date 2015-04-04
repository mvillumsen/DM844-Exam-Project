package dk.dm844.webshop

import grails.plugin.springsecurity.annotation.Secured
import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_EMPLOYEE'])
class ProductController {

    def shoppingCartService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model:[productInstanceCount: Product.count()]
    }

    def show(Product productInstance) {
        respond productInstance
    }

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
            respond productInstance.errors, view:'create'
            return
        }

        productInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: CREATED] }
        }
    }

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
            respond productInstance.errors, view:'edit'
            return
        }

        productInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*'{ respond productInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        productInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def addToCart(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        Integer amount = 1
        def param = request.getParameter("amount")
        if (param && param.isInteger())
            amount = Math.max(1, param.toInteger())

        productInstance.addQuantityToShoppingCart(amount)
        productInstance.save flush: true

        redirect(uri: request.getHeader('referer') )
    }

    def removeFromCart(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        Integer amount = 1
        def param = request.getParameter("amount")
        if (param && param.isInteger())
            amount = Math.max(1, param.toInteger())

        productInstance.removeQuantityFromShoppingCart(amount);
        productInstance.save flush: true

        redirect(uri: request.getHeader('referer') )
    }

    def removeAllFromCart(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        int amount = shoppingCartService.getQuantity(productInstance);
        productInstance.removeQuantityFromShoppingCart(amount);
        productInstance.save flush: true

        redirect(uri: request.getHeader('referer') )
    }
}
