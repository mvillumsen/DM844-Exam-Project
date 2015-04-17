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

    @Shared Person p = new Person(name: "Martin", email: "ma@ma.dk")

    def setup() {
        mockForConstraintsTests(ProductOrder)
    }

    def cleanup() {
    }

    @Unroll
    void "ProductOrderValidate"() {
        expect:
        order.validate() == result

        where:
        order                                               ||  result
        new ProductOrder()                                  ||  false
        new ProductOrder(customer: p)                       ||  true
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
