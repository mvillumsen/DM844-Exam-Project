package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(CartService)
class CartServiceSpec extends Specification {

    Product p = mockDomain(Product)

    def setup() {
    }

    def cleanup() {
    }

    void "Test count"() {
//        when:
//        service.createShoppingCart()
//
//        then:
//        service.count() == 0
//
//        when:
//        service.addToShoppingCart(p, 10)
//
//        then:
//        service.count() == 10
//
//        when:
//        service.addToShoppingCart(p, 1)
//
//        then:
//        servic .count() == 11
    }
}
