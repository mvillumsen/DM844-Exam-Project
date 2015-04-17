package dk.dm844.webshop

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
class OrderEntryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond OrderEntry.list(params), model:[orderEntryInstanceCount: OrderEntry.count()]
    }

    def show(OrderEntry orderEntryInstance) {
        respond orderEntryInstance
    }

    def create() {
        respond new OrderEntry(params)
    }

    @Transactional
    def save(OrderEntry orderEntryInstance) {
        if (orderEntryInstance == null) {
            notFound()
            return
        }

        if (orderEntryInstance.hasErrors()) {
            respond orderEntryInstance.errors, view:'create'
            return
        }

        orderEntryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orderEntry.label', default: 'OrderEntry'), orderEntryInstance.id])
                redirect orderEntryInstance
            }
            '*' { respond orderEntryInstance, [status: CREATED] }
        }
    }

    def edit(OrderEntry orderEntryInstance) {
        respond orderEntryInstance
    }

    @Transactional
    def update(OrderEntry orderEntryInstance) {
        if (orderEntryInstance == null) {
            notFound()
            return
        }

        if (orderEntryInstance.hasErrors()) {
            respond orderEntryInstance.errors, view:'edit'
            return
        }

        orderEntryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'OrderEntry.label', default: 'OrderEntry'), orderEntryInstance.id])
                redirect orderEntryInstance
            }
            '*'{ respond orderEntryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(OrderEntry orderEntryInstance) {

        if (orderEntryInstance == null) {
            notFound()
            return
        }

        orderEntryInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'OrderEntry.label', default: 'OrderEntry'), orderEntryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderEntry.label', default: 'OrderEntry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
