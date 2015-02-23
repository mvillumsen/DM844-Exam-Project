package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Category)
class CategorySpec extends Specification {

    def setup() {
        mockForConstraintsTests(Category)
    }

    def cleanup() {
    }

    void "CategoryValidation"() {
        expect:
        category.validate() == result

        where:
        category                            || result
        new Category()                      || false
        new Category(id: 1, name: "test")   || true
    }
}
