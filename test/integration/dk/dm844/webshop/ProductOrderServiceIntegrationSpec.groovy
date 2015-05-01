package dk.dm844.webshop

import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
class ProductOrderServiceIntegrationSpec extends Specification {

    ProductOrderService productOrderService

    @Shared
    Person employee

    @Shared
    Integer beforeCount = ProductOrder.count

    @Shared
    Integer packingBeforeCount = ProductOrder.findAllByStatus(ProductOrder.Status.PACKING).size()

    @Shared
    Integer deliveringBeforeCount = ProductOrder.findAllByStatus(ProductOrder.Status.DELIVERING).size()

    def setup() {
        employee = createEmployee()
    }

    void "test getOrders returns orders"() {
        when: "Saving 5 orders"
        (1..5).each { createProductOrder() }
        List<ProductOrder> orders = productOrderService.getOrders()

        then: "getOrders includes these"
        orders.size() == beforeCount + 5
        orders.each { it instanceof ProductOrder }
    }

    void "test get orders by status"() {
        when: "Saving 5 orders with different status"
        (1..5).each {
            ProductOrder order = createProductOrder()
            order.status = ProductOrder.Status.PACKING
            order.save(failOnError: true, flush: true)
        }
        (1..3).each {
            ProductOrder order = createProductOrder()
            order.status = ProductOrder.Status.DELIVERING
            order.save(failOnError: true, flush: true)
        }
        List<ProductOrder> packing =
                productOrderService.getOrdersByStatus(ProductOrder.Status.PACKING)
        List<ProductOrder> delivering =
                productOrderService.getOrdersByStatus(ProductOrder.Status.DELIVERING)

        then: "getOrders includes these"
        packing.size() == packingBeforeCount + 5
        packing.each { it instanceof ProductOrder }
        delivering.size() == deliveringBeforeCount + 3
        delivering.each { it instanceof ProductOrder }
    }

    void "test assign employee for task"() {
        when: "assigning employee for packing"
        ProductOrder order = createProductOrder()
        productOrderService.assignEmployeeFor(employee, order, ProductOrder.Status.PACKING)

        then: "the order changes status and employee is assigned"
        order.assignedEmployee == employee
        order.status == ProductOrder.Status.PACKING

        when: "assigning employee to order with illegal status"
        productOrderService.assignEmployeeFor(employee, order, ProductOrder.Status.PACKING)

        then: "expect assertion failure"
        thrown(AssertionError)

        when: "trying to assign an employee for delivery"
        order = createProductOrder()
        order.status = ProductOrder.Status.PACKED
        order.save(failOnError: true, flush: true)
        productOrderService.assignEmployeeFor(employee, order, ProductOrder.Status.DELIVERING)

        then: "the status and assigned employee are updated accordingly"
        order.assignedEmployee == employee
        order.status == ProductOrder.Status.DELIVERING
    }

    void "test assigning employees to invalid statuses"() {
        when: "trying to assign an employee using a status not NEW or PACKED"
        ProductOrder order = createProductOrder()
        productOrderService.assignEmployeeFor(employee, order, ProductOrder.Status.COMPLETED)

        then: "an assertion error is thrown"
        thrown(AssertionError)
    }

    void "test finishAssignment"() {
        when: "finishing a packing assignment"
        ProductOrder order = createProductOrder()
        order.status = ProductOrder.Status.PACKING
        order.assignedEmployee = employee
        order.save(failOnError: true, flush: true)
        productOrderService.finishAssignment(employee, order)

        then: "status and assigned employee is updated"
        order.status == ProductOrder.Status.PACKED
        order.assignedEmployee == null

        when: "finishing a delivery assignment"
        order = createProductOrder()
        order.status = ProductOrder.Status.DELIVERING
        order.assignedEmployee = employee
        order.save(failOnError: true, flush: true)
        productOrderService.finishAssignment(employee, order)

        then: "status and assigned employee is updated"
        order.status == ProductOrder.Status.COMPLETED
        order.assignedEmployee == null

        when: "trying to finish an order which does not have type PACKING or DELIVERING"
        productOrderService.finishAssignment(employee, order)

        then:
        thrown(AssertionError)
    }

    void "test finishing unassigned orders"() {
        when: "trying to finish an order which has not been assigned"
        ProductOrder order = createProductOrder()
        productOrderService.finishAssignment(employee, order)

        then: "an assertion error is thrown"
        thrown(AssertionError)
    }

    void "test finishing orders with invalid status"() {
        when: "trying to finish an order with status not PACKING or DELIVERING"
        ProductOrder order = createProductOrder()
        order.status = ProductOrder.Status.PACKED
        order.assignedEmployee = employee
        order.save(flush: true, failOnError: true)
        productOrderService.finishAssignment(employee, order)

        then: "an assertion error is thrown"
        thrown(AssertionError)
    }

    private Person createEmployee() {
        new Person(
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
