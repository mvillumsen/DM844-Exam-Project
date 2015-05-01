package dk.dm844.webshop.admin

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.http.HttpStatus
import dk.dm844.webshop.Person

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(AdminController)
class AdminControllerSpec extends Specification {



    void "Test admin without authorities"() {
        setup:
        controller.springSecurityService = Mock(SpringSecurityService)

        when:
        println controller.index()

        then:
        response.status == HttpStatus.UNAUTHORIZED.value()
    }

    void "Test admind with authorities"() {
        setup:
        controller.springSecurityService = Mock(SpringSecurityService)
        controller.springSecurityService.currentUser >> new Person()

        when:
        controller.index()

        then:
        response.status == HttpStatus.OK.value()
    }
}
