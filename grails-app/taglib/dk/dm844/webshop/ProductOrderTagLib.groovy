package dk.dm844.webshop

class ProductOrderTagLib {
    static namespace = "ord"
    static defaultEncodeAs = [taglib: 'none']

    ProductOrderService productOrderService

    def listOrdersForAssignment = { attrs, body ->
        List<ProductOrder> orders = productOrderService.listOrdersForAssignment()

        orders?.each { ProductOrder order ->
            out << body(order)
        }
    }

    def listOrderEntries = { attrs, body ->
        List<OrderEntry> entries = productOrderService.getOrderEntries(attrs.order)

        entries?.each { OrderEntry entry ->
            out << body(entry)
        }
    }
}
