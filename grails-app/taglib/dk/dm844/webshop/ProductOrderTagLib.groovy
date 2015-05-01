package dk.dm844.webshop

class ProductOrderTagLib {

    ProductOrderService productOrderService

    static namespace = "po"

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

    def count = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        Integer count = productOrderService.getOrdersByStatus((ProductOrder.Status) attrs.status).size()
        out << "<span class=\"${cssClasses}\">${count}</span>"
    }

    // TODO: Test this
    def calcTotalPrice = { attrs, body ->
        Integer total = productOrderService.calcTotalPrice(attrs.order)
        out << """${total}"""
    }
}
