package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(OrderEntry)
class OrderEntrySpec extends Specification {

    @Shared Person p = new Person(name: "Martin", address: "Odense", email: "ma@ma.dk")
    @Shared Customer c = new Customer(credentials: p)
    @Shared ProductOrder o = new ProductOrder(customer: c)
    @Shared Category ca = new Category(name: "Food")
    @Shared Product pr = new Product(name: "Milk", category: ca)

    def setup() {
        mockForConstraintsTests(OrderEntry)
    }

    def cleanup() {
    }

    void "OrderEntryValidation"() {
        expect:
        entry.validate() == result

        where:
        entry                                               ||  result
        new OrderEntry()                                    ||  false
        new OrderEntry(amount: 1, product: pr, order: o)    ||  true
        // TODO: More tests
    }
}
