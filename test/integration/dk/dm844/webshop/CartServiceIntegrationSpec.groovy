package dk.dm844.webshop

import com.metasieve.shoppingcart.Shoppable
import grails.test.mixin.integration.Integration
import org.hibernate.SessionFactory
import spock.lang.Shared
import spock.lang.Specification

@Integration
class CartServiceIntegrationSpec extends Specification {

    CartService cartService
    SessionFactory sessionFactory

    @Shared
    Product p

    @Shared
    Product p2

    def setup() {
        saveProductInDatabase()
    }

    void "Test count"() {
        when:
        cartService.createShoppingCart()

        then:
        cartService.count() == 0

        when:
        cartService.addToShoppingCart((Shoppable) p, 10)

        then:
        cartService.count() == 10

        when:
        cartService.addToShoppingCart((Shoppable) p, 1)

        then:
        cartService .count() == 11
    }

    void "Test total"() {
        when:
        cartService.createShoppingCart()

        then:
        cartService.total() == 0

        when:
        cartService.addToShoppingCart(p, 10)
        sessionFactory.getCurrentSession().flush()

        then:
        cartService.total() == 10 * p.price

        when:
        cartService.addToShoppingCart(p, 1)
        cartService.addToShoppingCart(p2, 5)
        sessionFactory.getCurrentSession().flush()

        then:
        cartService .total() == 11 * p.price + 5 * p2.price
    }

    void "Test checkout"() {
        setup:
        Person person = savePersonInDatabase()
        int orderCountBefore = ProductOrder.count()
        int entryCountBefore = OrderEntry.count()

        when:
        cartService.createShoppingCart()

        then:
        OrderEntry.count() == entryCountBefore

        when:
        cartService.addToShoppingCart(p, 10)
        cartService.addToShoppingCart(p2, 20)
        sessionFactory.getCurrentSession().flush()
        orderCountBefore = ProductOrder.count()
        entryCountBefore = OrderEntry.count()

        then:
        cartService.doCheckout(person, person.address).orderEntries.size() == 2
        ProductOrder.count() == orderCountBefore + 1
        OrderEntry.count() == entryCountBefore + 2
    }

    private saveProductInDatabase() {
        Category ca = new Category(name: "Food").save(failOnError: true)
        p = new Product(name: "Milk", category: ca, price: 10, stock: 1).save(failOnError: true)
        p2 = new Product(name: "Milk", category: ca, price: 14, stock: 1).save(failOnError: true)
    }

    private savePersonInDatabase() {
        return new Person(
                name: 'Martin',
                address: new Address(address1: 'gade', zipCode: '2', city: 'by', country: 'UK').save(failOnError: true, flush: true),
                username: 'ma',
                password: 'ma',
                enabled: true,
                email: 'mail@example.com'
        ).save(failOnError: true, flush: true)
    }
}
