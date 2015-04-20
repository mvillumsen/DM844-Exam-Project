package dk.dm844.webshop

import webshop.CategoryService

class CategoryTagLib {
    static namespace = "cat"
    static defaultEncodeAs = [taglib: 'none']

    CategoryService categoryService

    def listCategories = { attrs, body ->
        List<Category> categories = categoryService.getCategories()

        categories?.each { Category cat ->
            out << """<li role="presentation">${g.link(controller: 'categories', action: 'show', id: cat.id) { cat.name } }</li>"""
        }
    }

    /*
    def listProducts = { attrs, body ->
        List<Product> products = categoryService.getProducts(Category)

        products?.each { Product prod ->
            out << """"""
        }
    }
    */
}
