package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ShoppingCartController)
class ShoppingCartControllerSpec extends Specification {

    void setup() {
        CartService cartService = Mock(CartService)
        cartService.count() >> 0
        controller.cartService = cartService
    }

    void "Test the index action"() {
        when: "The index action is executed"
        controller.index()

        then: "The status code 200 is returned"
        response.status == 200
    }

    void "Test checkout action on empty shopping cart"() {
        when: "The checkout action is executed "
        controller.checkout()

        then: "The status code 400 is returned"
        response.status == 400

    }

    void "Test checkout action with nonempty cart"() {
        setup:
        controller.cartService = Mock(CartService)
        controller.cartService.count() >> 1

        when: "The checkout action is executed"
        controller.checkout()

        then: "The status code 200 is returned"
        response.status == 200
    }

}
