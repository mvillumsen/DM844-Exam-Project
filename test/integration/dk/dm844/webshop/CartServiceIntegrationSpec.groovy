package dk.dm844.webshop

import spock.lang.Specification
import webshop.CategoryService

class CartServiceIntegrationSpec extends Specification {

    CategoryService categoryService

    void "Test getCategories finds a few categories"() {
        setup:
        int countBefore = Category.count
        createCategories()

        when:
        List<Category> categories = categoryService.getCategories()

        then:
        categories
        categories.size() == 5 + countBefore
        categories.every { it instanceof Category }
    }

    private static createCategories() {
        [
                "Category1",
                "Category2",
                "Category3",
                "Category4",
                "Category5"
        ].each {
            new Category(name: it).save(failOnError: true)
        }
    }
}
