package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Person)
class PersonSpec extends Specification {

    @Shared String cmail = "ma@ma.dk"
    @Shared String wmail = "maaa@@ma"

    def setup() {
        mockForConstraintsTests(Person)
    }

    def cleanup() {
    }

    @Unroll
    void "PersonValidation"() {
        expect:
        person.validate() == result

        where:
        person                                                                                          ||  result
        new Person()                                                                                    ||  false
        new Person(name: "ma")                                                                          ||  false
        new Person(name: "ma", address: "am")                                                           ||  false
        new Person(name: "ma", address: "am", email: cmail)                                             ||  false
        new Person(name: "ma", address: "am", email: wmail)                                             ||  false
        new Person(name: "ma", address: "am", email: cmail, username: "user1")                          ||  false
        new Person(name: "ma", address: "am", email: cmail, username: "user1", password: "pass123")     ||  true
        new Person(name: "ma", address: "am", email: wmail, username: "user1", password: "pass123")     ||  false
    }

    @Unroll
    void "toStringTest"() {
        expect:
        person.toString() == name

        where:
        person                                              ||  name
        new Person()                                        ||  null
        new Person(name: "ma")                              ||  "ma"
    }
}
