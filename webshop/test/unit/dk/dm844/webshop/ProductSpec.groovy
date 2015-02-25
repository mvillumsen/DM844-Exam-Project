package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductSpec extends Specification {

    @Shared Category c = new Category(name: "Food")

    def setup() {
        mockForConstraintsTests(Product)
    }

    def cleanup() {
    }

    void "ProductValidation"() {
        expect:
        product.validate() == result

        where:
        product                                                         ||  result
        new Product()                                                   ||  false
        new Product(name: "Milk")                                       ||  false
        new Product(name: "Milk", category: c)                          ||  true
        new Product(name: "   ", category: c)                           ||  false
        new Product(name: "Milk", category: c, description: "desc")     ||  true
    }
}
