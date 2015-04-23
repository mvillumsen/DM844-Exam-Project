package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ShoppingCartController)
class ShoppingCartControllerSpec extends Specification {

    void "Test the index action"() {
        when: "The index action is executed"
        controller.index()

        then: "The status code 200 is returned"
        response.status == 200
    }

    void "Test checkout action"() {
        when: "The checkout action is executed"
        controller.checkout()

        then: "The status code 200 is returned"
        response.status == 200
    }

}
