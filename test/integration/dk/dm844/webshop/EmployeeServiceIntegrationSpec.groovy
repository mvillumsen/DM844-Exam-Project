package dk.dm844.webshop

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class EmployeeServiceIntegrationSpec extends Specification {

    EmployeeService employeeService

    @Shared
    Person employee

    def setup() {
        createEmployee()
    }

    @Unroll
    void "Test assigned count"() {
        when: "No orders have been assigned"

        then: "The count should be zero"
        employeeService.getAssignedCount(employee) == 0

        when: "One order is assigned"
        ProductOrder order = createProductOrder()
        order.assignedEmployee = employee
        order.save(failOnError: true, flush: true)

        then: "The right count is returned"
        employeeService.getAssignedCount(employee) == 1

        when: "One order is assigned"
        order = createProductOrder()
        order.assignedEmployee = employee
        order.save(failOnError: true, flush: true)

        then: "The right count is returned"
        employeeService.getAssignedCount(employee) == 2
    }

    @Unroll
    void "Test get assigned orders by status"() {
        when: "no orders have been assigned"

        then: "the count should be zero"
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.NEW).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKED).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.DELIVERING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.COMPLETED).size() == 0


        when: "one order is assigned"
        ProductOrder order = createProductOrder()
        order.assignedEmployee = employee
        order.save(failOnError: true, flush: true)

        then: "the right count is returned"
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.NEW).size() == 1
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKED).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.DELIVERING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.COMPLETED).size() == 0


        when: "two orders are assigned"
        order = createProductOrder()
        order.assignedEmployee = employee
        order.save(failOnError: true, flush: true)

        then: "the right count is returned"
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.NEW).size() == 2
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKED).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.DELIVERING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.COMPLETED).size() == 0

        when: "an order changes status"
        order.status = ProductOrder.Status.PACKED
        order.save(failOnError: true, flush: true)

        then: "the right counts is returned"
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.NEW).size() == 1
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.PACKED).size() == 1
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.DELIVERING).size() == 0
        employeeService.getAssignedOrdersByStatus(employee, ProductOrder.Status.COMPLETED).size() == 0

    }

    private void createEmployee() {
        employee = new Person(
                name: 'Erik',
                address: new Address(address1: 'road', zipCode: '5000', city: 'od', country: 'dk').save(failOnError: true, flush: true),
                username: 'er',
                password: 'er',
                enabled: true,
                email: 'test@mail.dk'
        ).save(failOnError: true, flush: true)
    }

    private ProductOrder createProductOrder() {
        new ProductOrder(
                address: employee.address,
                customer: employee
        ).save(failOnError: true, flush: true)
    }
}
