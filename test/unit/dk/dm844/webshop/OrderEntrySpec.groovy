package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

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

    @Unroll
    void "OrderEntryValidation"() {
        expect:
        entry.validate() == result

        where:
        entry                                                               ||  result
        new OrderEntry()                                                    ||  false
        new OrderEntry(order: o)                                            ||  false
        new OrderEntry(product: pr)                                         ||  false
        new OrderEntry(product: pr, order: o)                               ||  false
        new OrderEntry(amount: 1, product: pr, order: o)                    ||  false
        new OrderEntry(price: 10, product: pr, order: o)                    ||  true
        new OrderEntry(amount: 1, price: 10, product: pr, order: o)         ||  true
        new OrderEntry(amount: 0, price: 10, product: pr, order: o)         ||  false
    }

    @Unroll
    void "toStringTest"() {
        expect:
        entry.toString() == results

        where:
        entry                                                               ||  result
        new OrderEntry(product: pr, order: o)                               ||  "Name: $pr.name\tnull\tnull"
        new OrderEntry(amount: 0, price: 10, product: pr, order: o)         ||  "Name: $pr.name\t10\t0"
        new OrderEntry(amount: 0, product: pr, order: o)                    ||  "Name: $pr.name\tnull\t0"
        new OrderEntry(price: 10, product: pr, order: o)                    ||  "Name: $pr.name\t10\tnull"
    }
}
