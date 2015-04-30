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
        address                                                                                           || result
        new Address()                                                                                     || false
        new Address(address2: 'gade')                                                                     || false
        new Address(address1: "test", zipCode: "312", city: "by")                                         || false
        new Address(address1: "test", zipCode: "312", country: "denmark")                                 || false
        new Address(address1: "test", country: "denmark", city: "denmark")                                || false
        new Address(address1: "name", zipCode: "321", city: "by", country: "denmark")                     || true
        new Address(address1: "adr1", zipCode: "321", city: "by", country: "denmark")                     || true
        new Address(address1: "adr1", address2: "adr2", zipCode: "321", city: "by", country: "denmark")   || true
    }

    @Unroll
    void "toStringTest for Address with #address1/#address2/#zipCode/#city/#country"() {
        expect:
        new Address(address1: address1, address2: address2, zipCode: zip, city: city, country: country).toString() == result

        where:
        address1           |address2        | zip       | city              |country            ||  result
        "Test1"            |null            | "5000"    | "Odense"          |"Danmark"          ||  "Test1\n5000 Odense\nDanmark"
        'Test2'            |'Test323'       | '6789'    | "Berlin"          |"Sverige"          ||  "Test2\nTest323\n6789 Berlin\nSverige"


    }
}
