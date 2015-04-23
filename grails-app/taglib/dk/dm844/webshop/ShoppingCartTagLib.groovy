package dk.dm844.webshop

import com.metasieve.shoppingcart.Shoppable

class ShoppingCartTagLib {
    static namespace = "sc"

    CartService cartService

    def count = {
        out << "<span id=\"cart-count\">"
        out << cartService.count()
        out << "</span>"
    }

    def total = {
        out << cartService.total()
    }

    def price = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<span class="price $cssClasses">"""
        out << body() << " kr."
        out << "</span>"
    }

    def each = { attrs, body ->
        def items = cartService.getItems()

        items?.sort { a, b -> a.id <=> b.id }.each { item ->
            def itemInfo = [
                    'item': item,
                    'qty': cartService.getQuantity(item),
                    'product': Shoppable.findByShoppingItem(item)
            ]
            out << body(itemInfo)
        }
    }
}
