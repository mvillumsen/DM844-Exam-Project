package dk.dm844.webshop

class ProductOrderTagLib {

    static namespace = "po"
    static defaultEncodeAs = [taglib: 'None']

    def ordersAccordion = { attrs, body ->
        out << '<div class="panel-group" id="' << attrs.id << '">'
        out << body()
        out << '</div>'
    }

    def orderAccordionPanel = { attrs, body ->
        out << """
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse"
                            data-parent="#""" << attrs.parentId << """"
                            href="#""" << attrs.id << """">
                        """ << attrs.title << """
                    </a>
                </h4>
            </div>
            <div id=\"""" << attrs.id << """" class="panel-collapse collapse">
                <div class="panel-body">
                    """ << body() << """
                </div>
            </div>
        </div>"""
    }

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
