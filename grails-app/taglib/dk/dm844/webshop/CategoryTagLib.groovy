package dk.dm844.webshop

class CategoryTagLib {
    static namespace = "cat"
    static defaultEncodeAs = [taglib: 'none']

    CategoryService categoryService

    def listCategories = { attrs, body ->
        List<Category> categories = categoryService.getCategories()

        categories?.each { Category cat ->
            out << """<li role="presentation">${g.link(controller: 'Category', action: 'show', id: cat.id) { cat.name } }</li>"""
        }
    }

    def listProducts = { attrs, body ->
        List<Product> products = categoryService.getProducts(attrs.category)

        products?.each { Product prod ->
            out << body(prod)
        }
    }
}
