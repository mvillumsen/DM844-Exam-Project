package dk.dm844.webshop

class ShoppingCartTagLib {
    static namespace = "sc"
    static defaultEncodeAs = [taglib:'html']

    def shoppingCartService

    def count = { attrs, body ->
        def items = shoppingCartService.getItems()
        int count = 0
        items?.each { count += shoppingCartService.getQuantity(it) }
        out << count
    }
}
