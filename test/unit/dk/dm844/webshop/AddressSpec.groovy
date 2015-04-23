package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Address)
class AddressSpec extends Specification {

    @Unroll
    void "AddressValidation"() {
        expect:
        address.validate() == result

        where:
        address                                                                                                         || result
        new Address()                                                                                                   || false
        new Address(name: "test", address2: 'gade')                                                                     || false
        new Address(address1: "test", zipCode: "312", city: "by")                                                       || false
        new Address(address1: "test", zipCode: "312", country: "denmark")                                               || false
        new Address(address1: "test", country: "denmark", city: "denmark")                                              || false
        new Address(address1: "name", zipCode: "321", city: "by", country: "denmark")                                   || true
        new Address(name: "name", address1: "adr1", zipCode: "321", city: "by", country: "denmark")                     || true
        new Address(name: "name", address1: "adr1", address2: "adr2", zipCode: "321", city: "by", country: "denmark")   || true
    }
}
