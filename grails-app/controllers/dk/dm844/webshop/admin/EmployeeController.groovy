package dk.dm844.webshop.admin

import dk.dm844.webshop.EmployeeService
import dk.dm844.webshop.Person
import dk.dm844.webshop.ProductOrder
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.http.HttpStatus

@Transactional(readOnly = true)
@Secured(['ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
class EmployeeController {

    EmployeeService employeeService
    SpringSecurityService springSecurityService

    def index() {
        println "hello"
        render "Hello"
    }

    def assignments() {
        render HttpStatus.OK

//        Person employee = springSecurityService.currentUser
//
//        if (!employee) {
//            respond { status: HttpStatus.UNAUTHORIZED }
//            return
//        }
//
//        List<ProductOrder> packingOrders = employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKING)
//        List<ProductOrder> deliveringOrders = employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.DELIVERING)
//
//        print packingOrders
//        print deliveringOrders
//
//        [packingOrders: packingOrders, deliveringOrders: deliveringOrders]
    }
}
