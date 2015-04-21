package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Category)
class CategorySpec extends Specification {

    @Shared
    Category cat1

    def setup() {
        mockForConstraintsTests(Category)
        cat1 = new Category(name: "uniqueName")
    }

    @Unroll
    void "Test uniqueness of category names"() {
        when:
        Category cat2 = new Category(name: "uniqueName")
        mockForConstraintsTests(Category, [cat2])

        then:
        assertFalse cat1.validate()

        when:
        cat1 = new Category(name: "uniqueName1")

        then:
        assertTrue cat1.validate()
    }

    @Unroll
    void "CategoryValidation"() {
        expect:
        category.validate() == result

        where:
        category                                                || result
        new Category()                                          || false
        new Category(name: "test")                              || true
        new Category(name: "test", description: "Description")  || true
    }

    @Unroll
    void "toStringTest"() {
        expect:
        category.toString() == name

        where:
        category                                                ||  name
        new Category()                                          ||  null
        new Category(name: "Test")                              ||  "Test"
        new Category(name: "Test", description: "Desc.")        ||  "Test"
    }
}
