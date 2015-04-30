package dk.dm844.webshop.admin

import dk.dm844.webshop.EmployeeService
import dk.dm844.webshop.Person
import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor
import org.springframework.http.HttpStatus
import spock.lang.IgnoreRest
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeController)
class EmployeeControllerSpec extends Specification {



    @IgnoreRest
    void "test assignments uden rettighed"() {
        setup:
        controller.springSecurityService = Mock(SpringSecurityService)

        when:
        println controller.dump()
        controller.index()

        then:
        response.status == HttpStatus.UNAUTHORIZED
    }

    void "test assigments med rettighed"() {
        setup:
        controller.springSecurityService = Mock(SpringSecurityService)
        controller.springSecurityService.currentUser >> new Person()
        controller.employeeService = Mock(EmployeeService)

        when:
        controller.assignments()

        then:
        response.status == HttpStatus.OK
    }



}
