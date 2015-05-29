package dk.dm844.webshop

import com.metasieve.shoppingcart.Quantity
import com.metasieve.shoppingcart.Shoppable
import com.metasieve.shoppingcart.ShoppingCart
import com.metasieve.shoppingcart.ShoppingCartService
import com.metasieve.shoppingcart.ShoppingItem
import grails.transaction.Transactional

@Transactional
class CartService extends ShoppingCartService {

    int count() {
        Set<ShoppingItem> items = getItems()
        int count = 0

        items?.each {
            count += getQuantity(it)
        }
        return count
    }

    int total() {
        Set<ShoppingItem> items = getItems()

        int total = 0

        items?.each {
            int quantity = getQuantity(it)
            Product p = Shoppable.findByShoppingItem(it)
            total += p.price * quantity
        }
        return total
    }

    @Override
    def addToShoppingCart(Shoppable product, Integer qty = 1, ShoppingCart previousShoppingCart = null) {
        if (!product.shoppingItem) {
            def shoppingItem = new ShoppingItem()
            shoppingItem.save()
            product.shoppingItem = shoppingItem
            product.save()
        }

        def shoppingCart = getShoppingCart()

        def quantity = Quantity.findByShoppingCartAndShoppingItem(shoppingCart, product.shoppingItem)
        if (quantity) {
            quantity.value += qty
        } else {
            shoppingCart.addToItems(product.shoppingItem)
            quantity = new Quantity(shoppingCart:shoppingCart, shoppingItem:product.shoppingItem, value:qty)
        }
        quantity.save()
        shoppingCart.save()
    }

    ProductOrder doCheckout(Person customer, Address address) {
        ProductOrder order = new ProductOrder(customer: customer, address: address)
        Set<ShoppingItem> items = checkOut()
        items?.each {
            Product product = Shoppable.findByShoppingItem(it['item'])
            order.addToOrderEntries(
                    product: product,
                    price: product.price,
                    amount: it['qty']
            )
        }
        order.save(failOnError: true, flush: true)
        return order
    }
}
