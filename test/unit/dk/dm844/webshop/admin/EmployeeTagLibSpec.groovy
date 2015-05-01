package dk.dm844.webshop.admin

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(EmployeeTagLib)
class EmployeeTagLibSpec extends Specification {

    @Unroll
    void "Testing assignedCount with cssClass: '#cssClass' and body: '#bodyClosure'"() {
        setup:
        tagLib.employeeService = Mock(EmployeeService)
        tagLib.springSecurityService = Mock(SpringSecurityService)
        tagLib.employeeService.getAssignedCount(_) >> { 1337 }

        expect:
        tagLib.assignedCount( cssClasses: cssClass, bodyClosure ) == result

        where:
        cssClass      | bodyClosure               || result
        ''            | { }                       || "<span class=\"\">1337</span>"
        ''            | { 'My Body Closure' }     || "<span class=\"\">1337</span>"
        'myClass'            | { }                || "<span class=\"myClass\">1337</span>"
    }
}
