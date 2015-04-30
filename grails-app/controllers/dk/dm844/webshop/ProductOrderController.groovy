package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured([SecurityRole.Employee.DRIVER, SecurityRole.Employee.PACKER, SecurityRole.Employee.ADMIN])
class ProductOrderController {

    ProductOrderService productOrderService
    SpringSecurityService springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProductOrder.list(params), model:[productOrderInstanceCount: ProductOrder.count()]
    }

    def show(ProductOrder productOrderInstance) {
        respond productOrderInstance
    }

    def create() {
        respond new ProductOrder(params)
    }

    @Transactional
    def save(ProductOrder productOrderInstance) {
        if (productOrderInstance == null) {
            notFound()
            return
        }

        if (productOrderInstance.hasErrors()) {
            respond productOrderInstance.errors, view:'create'
            return
        }

        productOrderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message',
                                        args: [message(code: 'productOrder.label', default: 'ProductOrder'), productOrderInstance.id])
                redirect productOrderInstance
            }
            '*' { respond productOrderInstance, [status: CREATED] }
        }
    }

    def edit(ProductOrder productOrderInstance) {
        respond productOrderInstance
    }

    @Transactional
    def update(ProductOrder productOrderInstance) {
        if (productOrderInstance == null) {
            notFound()
            return
        }

        if (productOrderInstance.hasErrors()) {
            respond productOrderInstance.errors, view:'edit'
            return
        }

        productOrderInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message',
                                        args: [message(code: 'ProductOrder.label', default: 'ProductOrder'), productOrderInstance.id])
                redirect productOrderInstance
            }
            '*' { respond productOrderInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ProductOrder productOrderInstance) {

        if (productOrderInstance == null) {
            notFound()
            return
        }

        productOrderInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message',
                                        args: [message(code: 'ProductOrder.label', default: 'ProductOrder'), productOrderInstance.id])
                redirect action:"index", method:"GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured([SecurityRole.Employee.PACKER, SecurityRole.Employee.ADMIN])
    def packaging() {
        List<ProductOrder> orders = productOrderService.getOrdersByStatus(ProductOrder.Status.NEW)
        [orders: orders]
    }

    @Secured([SecurityRole.Employee.PACKER, SecurityRole.Employee.ADMIN])
    def assignPackaging(ProductOrder productOrderInstance) {
        if (!productOrderInstance) {
            notFound()
            return
        }
        Person employee = springSecurityService.currentUser
        productOrderService.assignEmployeeFor(employee, productOrderInstance, ProductOrder.Status.PACKING)
        redirect uri: request.getHeader('referer')
    }

    @Secured([SecurityRole.Employee.DRIVER, SecurityRole.Employee.ADMIN])
    def shipment() {
        List<ProductOrder> orders = productOrderService.getOrdersByStatus(ProductOrder.Status.PACKED)
        [orders: orders]
    }

    @Secured([SecurityRole.Employee.DRIVER, SecurityRole.Employee.ADMIN])
    def assignShipment(ProductOrder productOrderInstance) {
        if (!productOrderInstance) {
            notFound()
            return
        }

        Person employee = springSecurityService.currentUser
        productOrderService.assignEmployeeFor(employee, productOrderInstance, ProductOrder.Status.DELIVERING)
        redirect uri: request.getHeader('referer')
    }

    def finishAssignment(ProductOrder productOrderInstance) {
        if (!productOrderInstance) {
            notFound()
            return
        }

        Person employee = springSecurityService.currentUser
        if  (employee != productOrderInstance.assignedEmployee)
            return render { status: UNAUTHORIZED }

        productOrderService.finishAssignment(employee, productOrderInstance)
        redirect uri: request.getHeader('referer')
    }


    @Secured([SecurityRole.Employee.ADMIN])
    def completed() {
        List<ProductOrder> orders = productOrderService.getOrdersByStatus(ProductOrder.Status.COMPLETED)
        [orders: orders]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message',
                                        args: [message(code: 'productOrder.label', default: 'ProductOrder'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
