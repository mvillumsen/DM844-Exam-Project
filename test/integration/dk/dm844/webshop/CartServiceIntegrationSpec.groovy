package dk.dm844.webshop

import grails.test.mixin.integration.Integration
import spock.lang.Shared
import spock.lang.Specification

@Integration
class CartServiceIntegrationSpec extends Specification {

    CartService cartService

    @Shared
    Product p

    @Shared
    Product p2

    def setup() {
        saveProductInDatabase()
        savePersonInDatabase()
        p = Product.get(1)
        p2 = Product.get(2)
    }

    void "Test count"() {
        when:
        cartService.createShoppingCart()

        then:
        cartService.count() == 0

        when:
        cartService.addToShoppingCart(p, 10)

        then:
        cartService.count() == 10

        when:
        cartService.addToShoppingCart(p, 1)

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

        then:
        cartService.total() == 10 * p.price

        when:
        cartService.addToShoppingCart(p, 1)
        cartService.addToShoppingCart(p2, 5)

        then:
        cartService .total() == 11 * p.price + 5 * p2.price
    }

    void "Test checkout"() {
        setup:
        Person person = Person.get(1)
        int orderCountBefore = ProductOrder.count()
        int entryCountBefore = OrderEntry.count()

        when:
        cartService.createShoppingCart()

        then:
        cartService.doCheckout(person, person.address).isEmpty()
        ProductOrder.count() == orderCountBefore + 1
        OrderEntry.count() == entryCountBefore

        when:
        cartService.addToShoppingCart(p, 10)
        cartService.addToShoppingCart(p2, 20)
        orderCountBefore = ProductOrder.count()
        entryCountBefore = OrderEntry.count()

        then:
        cartService.doCheckout(person, person.address).size() == 2
        ProductOrder.count() == orderCountBefore + 1
        OrderEntry.count() == entryCountBefore + 2
    }

    private saveProductInDatabase() {
        Category ca = new Category(name: "Food").save(failOnError: true)
        new Product(name: "Milk", category: ca, price: 10, stock: 1).save(failOnError: true)
        new Product(name: "Milk", category: ca, price: 14, stock: 1).save(failOnError: true)
    }

    private savePersonInDatabase() {
        new Person(
                name: 'Martin',
                address: new Address(address1: 'gade', zipCode: '2', city: 'by', country: 'UK').save(failOnError: true, flush: true),
                username: 'ma',
                password: 'ma',
                enabled: true,
                email: 'mail@example.com'
        ).save(failOnError: true, flush: true)
    }
}
