package dk.dm844.webshop

import dk.dm844.webshop.ProductOrder.Status
import grails.transaction.Transactional

@Transactional
class EmployeeService {

    List<ProductOrder> getAssignedOrdersByStatus(Person employee, Status status) {
        return ProductOrder.findAllByAssignedEmployeeAndStatus(employee, status, [sort: 'dateCreated', order: 'asc'])
    }
}
