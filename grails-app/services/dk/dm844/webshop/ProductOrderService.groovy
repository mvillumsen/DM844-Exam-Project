package dk.dm844.webshop

import dk.dm844.webshop.ProductOrder.Status
import grails.transaction.Transactional

@Transactional
class ProductOrderService {

    static transactional = false

    List<ProductOrder> getOrders() {
        return ProductOrder.list([sort: 'dateCreated', order: 'asc'])
    }

    List<ProductOrder> getOrdersByStatus(Status status) {
        return ProductOrder.findAllByStatus(status, [sort: 'dateCreated', order: 'asc'])
    }

    void assignEmployeeFor(Person employee, ProductOrder order, Status status) {
        switch (status) {
            case Status.PACKING:
                assert order.status == Status.NEW
                break
            case Status.DELIVERING:
                assert order.status == Status.PACKED
                break
            default:
                assert false
        }

        order.status = status
        order.assignedEmployee = employee
        order.save(failOnError: true, flush: true)
    }

    void finishAssignment(Person employee, ProductOrder order) {
        assert order.assignedEmployee == employee

        switch (order.status) {
            case Status.PACKING:
                order.status = Status.PACKED
                break
            case Status.DELIVERING:
                order.status = Status.COMPLETED
                break
            default:
                assert false
        }

        order.assignedEmployee = null
        order.save(failOnError: true, flush: true)
    }

    // TODO: Return type ???
    def listOrdersForAssignment() {
        def c = ProductOrder.createCriteria()
        def results = c.list {
            or {
                eq("status", Status.CREATED)
                eq("status", Status.READY_TO_SHIP)
            }
            order("dateCreated", "asc")
        }
        return results
    }

    List<OrderEntry> getOrderEntries(ProductOrder productOrder) {
        return OrderEntry.findAllByOrder(productOrder, [sort: 'id', order: 'asc'])
    }
}