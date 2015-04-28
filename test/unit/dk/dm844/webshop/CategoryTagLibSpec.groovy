package dk.dm844.webshop

import grails.test.mixin.TestFor
import org.jsoup.Jsoup
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(CategoryTagLib)
class CategoryTagLibSpec extends Specification {

    void "test listCategories"() {
        setup:
        tagLib.categoryService = Mock(CategoryService)
        tagLib.categoryService.getCategories() >> [new Category(id: 1, name: "Cat 1"), new Category(id: 2, name: "Cat 2")]

        when:
        String result = tagLib.listCategories()
        def document = Jsoup.parse(result)

        then:
        document.select('li').size() == 2
        document.select('li').every {
            it.select('a')
            it.hasAttr("role")
            it.attr("role").trim() == "presentation"
        }
        document.select('li')[0].select('a').text() == "Cat 1"
        document.select('li')[1].select('a').text() == "Cat 2"
    }

    // TODO: FIX THIS (move to integration test)
    /*
    void "test listProducts()"() {
        setup:
        Category c = new Category(name: "Cat1")
        tagLib.categoryService = Mock(CategoryService)
        tagLib.categoryService.getProducts(c) >> [ new Product(name: "Prod1", price: 1, description: "Test description", stock: 10, category: c),
                                                   new Product(name: "Prod2", price: 2, description: "Test description", stock: 10, category: c) ]

        where:
        String result = tagLib.listProducts()
        def document = Jsoup.parse(result)

        then:

    }
    */
}
