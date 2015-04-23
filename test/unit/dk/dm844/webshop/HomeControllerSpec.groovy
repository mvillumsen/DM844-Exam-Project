package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HomeController)
class HomeControllerSpec extends Specification {

    void "Test index action"() {
        when:
        controller.index()

        then:
        response.status == 200
    }
}
