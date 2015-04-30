package dk.dm844.webshop

import grails.transaction.Transactional

class ProductOrderService {
    static transactional = false

    List<ProductOrder> listOrdersForAssignment() {
        def c = ProductOrder.createCriteria()
        def results = c.list {
            or {
                eq("status", ProductOrder.Status.CREATED)
                eq("status", ProductOrder.Status.READY_TO_SHIP)
            }
            order("dateCreated", "asc")
        }
        return results
    }

    List<OrderEntry> getOrderEntries(ProductOrder productOrder) {
        return OrderEntry.findAllByOrder( productOrder, [sort: 'id', order: 'asc'] )
    }
}
