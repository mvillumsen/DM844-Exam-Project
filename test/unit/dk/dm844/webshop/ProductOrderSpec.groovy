package dk.dm844.webshop

import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class ProductOrderSpec extends Specification {

    @Shared Address a = new Address(address1: 'gade', zipCode: '5', city: 'by', country: 'DK')
    @Shared Person p = new Person(name: "Martin", address: a, email: "ma@ma.dk", username: 'mar', password: 'mar')

    def setup() {
        mockForConstraintsTests(ProductOrder)
    }

    @Unroll
    void "ProductOrderValidate"() {
        expect:
        order.validate() == result

        where:
        order                                               ||  result
        new ProductOrder()                                  ||  false
        new ProductOrder(customer: p, address: a)           ||  true
    }

    @Unroll
    void "toStringTest"() {
        expect:
        order.toString() == id

        where:
        order                           ||  id
        new ProductOrder()              ||  "Order no.: null"
    }
}
