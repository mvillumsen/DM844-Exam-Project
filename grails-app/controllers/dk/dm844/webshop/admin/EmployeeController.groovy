package dk.dm844.webshop.admin

import dk.dm844.webshop.EmployeeService
import dk.dm844.webshop.Person
import dk.dm844.webshop.ProductOrder
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.http.HttpStatus

@Secured(['ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
class EmployeeController {

    EmployeeService employeeService
    SpringSecurityService springSecurityService

    def assignments() {
        Person employee = springSecurityService.currentUser

        if (!employee) {
            response.sendError(HttpStatus.UNAUTHORIZED.value())
            return
        }

        List<ProductOrder> packingOrders = employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKING)
        List<ProductOrder> deliveringOrders = employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.DELIVERING)

        print packingOrders
        print deliveringOrders

        [packingOrders: packingOrders, deliveringOrders: deliveringOrders]
    }
}
