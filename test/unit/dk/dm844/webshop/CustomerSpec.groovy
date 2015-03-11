package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Customer)
class CustomerSpec extends Specification {

    @Shared Person p = new Person(name: "Martin", address: "Odense", email: "ma@ma.dk")

    def setup() {
        mockForConstraintsTests(Customer)
    }

    def cleanup() {
    }

    @Unroll
    void "CustomerValidation"() {
        expect:
        customer.validate() == result

        where:
        customer                        ||  result
        new Customer()                  ||  false
        new Customer(credentials: p)    ||  true
    }

    @Unroll
    void "toStringTest"() {
        expect:
        customer.toString() == name

        where:
        customer                            ||  name
        new Customer()                      ||  null
        new Customer(credentials: p)        ||  "Martin"
    }
}
