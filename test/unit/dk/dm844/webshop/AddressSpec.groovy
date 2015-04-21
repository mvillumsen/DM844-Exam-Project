package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
class AddressSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll
    void "AddressValidation"() {
        expect:
        address.validate() == result

        where:
        address                                                                                 || result
        new Address()                                                                           || false
        new Address(address1: "test", zipCode: '321', city: 'by', country: 'denmark')           || true
        new Address(name: "test", address2: 'gade')                                             || false
    }
}
