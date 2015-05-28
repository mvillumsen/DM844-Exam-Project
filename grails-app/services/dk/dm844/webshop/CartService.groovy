package dk.dm844.webshop

import com.metasieve.shoppingcart.Shoppable
import com.metasieve.shoppingcart.ShoppingCartService
import com.metasieve.shoppingcart.ShoppingItem
import grails.transaction.Transactional
import org.grails.datastore.mapping.core.Session

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

        items?.each {
            println Product.findByShoppingItem(it)
        }

        Shoppable.all.each {
            println it.shoppingItem
        }

        int total = 0

        items?.each {
            int quantity = getQuantity(it)
            Product p = Shoppable.findByShoppingItem(it)
            total += p.price * quantity
        }
        return total
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
