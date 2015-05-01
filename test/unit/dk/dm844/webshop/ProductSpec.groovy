package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductSpec extends Specification {

    @Shared Category c = new Category(name: "Food")

    def setup() {
        mockForConstraintsTests(Product)
    }

    @Unroll
    void "ProductValidation for Product with name: '#product'"() {
        expect:
        product.validate() == result

        where:
        product                                                                             ||  result
        new Product()                                                                       ||  false
        new Product(name: "Milk")                                                           ||  false
        new Product(name: "Milk", category: c, price: 100)                                  ||  false
        new Product(name: "Milk", category: c, price: 100, stock: 1)                        ||  true
        new Product(name: "   ", category: c)                                               ||  false
        new Product(name: "Milk", category: c, price: 100, description: "desc", stock: 0)   ||  true
        new Product(name: "Milk", category: c, stock: -1)                                   ||  false
        new Product(name: "Milk", category: c, price: 10, stock: 0)                         ||  true
        new Product(name: "Milk", category: c, stock: 8)                                    ||  false
    }

    @Unroll
    void "toStringTest for Product with name: '#product'"() {
        expect:
        product.toString() == name

        where:
        product                                             ||  name
        new Product()                                       ||  null
        new Product(name: "Milk")                           ||  "Milk"
        new Product(name: "Milk", category: c)              ||  "Milk"
        new Product(name: "  ", category: c)                ||  null
    }

    @Unroll
    void "Test getPicture with name: '#product'"() {
        expect:
        product.getPicture() == result

        where:
        product                                                                    || result
        new Product(name: "Milk", category: c, price: 100, stock: 1)               || 'http://lorempixel.com/150/150/food/Milk'
        new Product(name: "Minced Beef", category: c, price: 100, stock: 1)        || 'http://lorempixel.com/150/150/food/Minced Beef'
        new Product(name: "Bacon, 8 slices", category: c, price: 100, stock: 1)    || 'http://lorempixel.com/150/150/food/Bacon 8 slices'
    }
}
