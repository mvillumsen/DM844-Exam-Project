package dk.dm844.webshop.admin

import dk.dm844.webshop.Person
import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor
import org.springframework.http.HttpStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeController)
class EmployeeControllerSpec extends Specification {

    def setup() {
        controller.springSecurityService = Mock(SpringSecurityService)
    }

    void "Test index without authorities"() {
        when:
        controller.index()

        then:
        response.status == HttpStatus.UNAUTHORIZED.value()
    }

    void "Test index with authorities"() {
        setup:
        controller.springSecurityService.currentUser >> new Person()

        when:
        controller.index()

        then:
        response.status == HttpStatus.OK.value()
    }

    void "Test assignments without authorities"() {
        when:
        controller.assignments()

        then:
        response.status == HttpStatus.UNAUTHORIZED.value()
    }

    void "Test assignments with authorities"() {
        setup:
        controller.springSecurityService.currentUser >> new Person()
        controller.employeeService = Mock(EmployeeService)

        when:
        controller.assignments()

        then:
        response.status == HttpStatus.OK.value()
    }
}
