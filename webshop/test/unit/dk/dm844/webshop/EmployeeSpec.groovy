package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Employee)
class EmployeeSpec extends Specification {

    @Shared Person p = new Person(name: "Martin", address: "Odense", email: "ma@ma.dk")
    @Shared Date d = new Date()

    def setup() {
        mockForConstraintsTests(Employee)
    }

    def cleanup() {
    }

    void "EmployeeValidation"() {
        expect:
        employee.validate() == result

        where:
        employee                                      ||  result
        new Employee()                                ||  false
        new Employee(credentials: p)                  ||  false
        new Employee(dateHired: d)                    ||  false
        new Employee(credentials: p, dateHired: d)    ||  true
    }
}
