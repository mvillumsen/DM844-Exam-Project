package dk.dm844.webshop

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured([SecurityRole.EMPLOYEE])
class CategoryController {

    def beforeInterceptor = {
        log.info """<log-entry><time>${new Date()}</time><sessionid>${session.getId()}</sessionid><info>${params}</info></log-entry>"""
    }

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Category.list(params), model: [categoryInstanceCount: Category.count()]
    }

    @Secured(['permitAll'])
    def show(Category categoryInstance) {
        respond categoryInstance
    }

    @Secured([SecurityRole.Employee.ADMIN])
    def create() {
        respond new Category(params)
    }

    @Transactional
    def save(Category categoryInstance) {
        if (categoryInstance == null) {
            notFound()
            return
        }

        if (categoryInstance.hasErrors()) {
            respond categoryInstance.errors, view: 'create'
            return
        }

        categoryInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'category.label', default: 'Category'), categoryInstance.id])
                redirect action: 'index'
            }
            '*' { respond categoryInstance, [status: CREATED] }
        }
    }

    @Secured([SecurityRole.Employee.ADMIN])
    def edit(Category categoryInstance) {
        respond categoryInstance
    }

    @Transactional
    def update(Category categoryInstance) {
        if (categoryInstance == null) {
            notFound()
            return
        }

        if (categoryInstance.hasErrors()) {
            respond categoryInstance.errors, view: 'edit'
            return
        }

        categoryInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Category.label', default: 'Category'), categoryInstance.id])
                redirect categoryInstance
            }
            '*' { respond categoryInstance, [status: OK] }
        }
    }

    @Secured([SecurityRole.Employee.ADMIN])
    @Transactional
    def delete(Category categoryInstance) {

        if (categoryInstance == null) {
            notFound()
            return
        }

        categoryInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Category.label', default: 'Category'), categoryInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'category.label', default: 'Category'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
