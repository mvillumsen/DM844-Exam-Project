package dk.dm844.webshop

import spock.lang.Shared
import spock.lang.Specification
import webshop.CategoryService

class CategoryServiceIntegrationSpec extends Specification {

    CategoryService categoryService

    @Shared
    int countBefore = Category.count

    def setup() {
        createCategories()
    }

    void "Test getCategories finds a few categories"() {
        when:
        List<Category> categories = categoryService.getCategories()

        then:
        categories
        categories.size() == 5 + countBefore
        categories.every { it instanceof Category }
    }

    void "Test getProducts"() {
        setup:
        Category cat = Category.findByName("Category1")
        createProducts(cat)

        when:
        List<Product> products = categoryService.getProducts(cat)

        then:
        products
        products.size() == 3
        products.every { it instanceof Product }
        products.every { it.category == cat }
        products.every { it.description == "Test description" }
        products.get(0).name == "Prod1"
        products.get(1).name == "Prod2"
        products.get(2).name == "Prod3"
    }

    private static void createCategories() {
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

    private static void createProducts(Category c) {
        [
                ["Prod1", 1, "Test description", 10, c],
                ["Prod2", 2, "Test description", 10, c],
                ["Prod3", 3, "Test description", 10, c]
        ].each {
            new Product(name: it[0], price: (int)it[1], description: it[2], stock: (int)it[3], category: (Category)it[4]).save(failOnError: true)
        }
    }
}
