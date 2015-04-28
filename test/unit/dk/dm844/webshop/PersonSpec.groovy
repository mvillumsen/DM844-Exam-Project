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

    @Unroll
    void "PersonValidation for Person with name: '#person'"() {
        expect:
        person.validate() == result

        where:
        person                                                                               ||  result
        new Person()                                                                         ||  false
        new Person(name: "ma")                                                               ||  false
        new Person(name: "ma2", address: "am")                                               ||  false
        new Person(name: "ma3", address: null, email: cmail, username: 'ma', password: 'ma') ||  true
        new Person(name: "ma4", address: null, email: wmail, username: 'ma', password: 'ma') ||  false
        new Person(name: "ma4", address: new Address(address1: 'test street 13', zipCode: '2', city: 'metropolis', country: 'mouseguard'),
                email: wmail, username: 'ma', password: 'ma')                                ||  false
    }

    @Unroll
    void "toStringTest for Person with name: '#person'"() {
        expect:
        person.toString() == name

        where:
        person                                              ||  name
        new Person()                                        ||  null
        new Person(name: "ma")                              ||  "ma"
    }
}
