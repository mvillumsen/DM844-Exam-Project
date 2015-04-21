package dk.dm844.webshop

import grails.test.mixin.TestFor
import org.jsoup.Jsoup
import spock.lang.Specification
import webshop.CategoryService

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
        document.select('li').every { it.select('a') }
        // TODO more checks needed
    }
}
