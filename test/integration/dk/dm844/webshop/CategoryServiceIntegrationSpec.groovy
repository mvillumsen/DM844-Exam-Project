package dk.dm844.webshop

import spock.lang.Specification
import webshop.CategoryService

class CategoryServiceIntegrationSpec extends Specification {

    CategoryService categoryService

    void "Test getCategories finds a few products (happy day)"() {
        setup:
        int countBefore = Category.count
        3.times {
            // TODO Is it ok for multiple categories to have the same name?
            new Category(name: "Category").save(failOnError: true)
        }

        when:
        List<Category> categories = categoryService.categories

        then:
        categories
        categories.size() == 3 + countBefore
        categories.every { it instanceof Category }
    }
}