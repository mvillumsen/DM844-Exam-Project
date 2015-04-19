package dk.dm844.webshop

import com.metasieve.shoppingcart.Shoppable
import com.metasieve.shoppingcart.ShoppingCartService
import com.metasieve.shoppingcart.ShoppingItem
import grails.transaction.Transactional
import liquibase.exception.CustomPreconditionErrorException

@Transactional
class CartService extends ShoppingCartService {

    def count() {
        Set<ShoppingItem> items = getItems()
        int count = 0

        items?.each {
            count += getQuantity(it)
        }
        return count
    }

    def total() {
        Set<ShoppingItem> items = getItems()
        int total = 0

        items?.each {
            int quantity = getQuantity(it)
            Product p = Shoppable.findByShoppingItem(it)
            total += p.price * quantity
        }
        return total
    }

    def doCheckout(Customer customer) {
        ProductOrder order = new ProductOrder(customer: customer)
        Set<ShoppingItem> items = checkOut()
        items?.each {
            Product product = Shoppable.findByShoppingItem(it['item']);
            order.addToOrderEntries(
                    product: product,
                    price: product.price,
                    amount: it['qty']
            )
        }
        order.save(flush: true)
    }
}