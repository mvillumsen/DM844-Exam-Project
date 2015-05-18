package dk.dm844.webshop.admin

import dk.dm844.webshop.Person
import dk.dm844.webshop.ProductOrder
import dk.dm844.webshop.SecurityRole
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured([SecurityRole.EMPLOYEE])
class EmployeeController {

    EmployeeService employeeService
    SpringSecurityService springSecurityService

    def index() {
        Person employee = springSecurityService.currentUser

        if (!employee) {
            response.sendError(HttpStatus.UNAUTHORIZED.value())
            return
        }
    }

    def assignments() {
        Person employee = springSecurityService.currentUser

        if (!employee) {
            response.sendError(HttpStatus.UNAUTHORIZED.value())
            return
        }

        List<ProductOrder> packingOrders = employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKING)
        List<ProductOrder> deliveringOrders = employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.DELIVERING)

        [packingOrders: packingOrders, deliveringOrders: deliveringOrders]
    }
}
