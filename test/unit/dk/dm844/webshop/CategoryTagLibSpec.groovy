package dk.dm844.webshop

import grails.test.mixin.TestFor
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
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
        }
        document.select('li')[0].select('a').text() == "Cat 1"
        document.select('li')[1].select('a').text() == "Cat 2"
    }

    void "test listProducts"() {
        setup:
        tagLib.categoryService = Mock(CategoryService)
        tagLib.categoryService.getProducts(_) >> [new Product(name: 'TestProduct1'), new Product(name: 'TestProduct2')]

        when:
        String result = applyTemplate('<cat:listProducts category="${c}"><h5 class="text-center">${it.name}</h5></cat:listProducts>')
        Document document = Jsoup.parse(result)

        then:
        document.select("h5").hasClass("text-center")
        document.select("h5").text().trim() == "TestProduct1 TestProduct2"

    }
}
