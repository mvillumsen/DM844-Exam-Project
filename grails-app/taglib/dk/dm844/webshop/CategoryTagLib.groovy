package dk.dm844.webshop

import webshop.CategoryService

class CategoryTagLib {
    static namespace = "cat"
    static defaultEncodeAs = [taglib: 'none']

    CategoryService categoryService

    def listCategories = { attrs, body ->
        List<Category> categories = categoryService.getCategories()

        categories?.each { Category cat ->
            out << """<li role="presentation">${g.link(controller: 'categories', action: 'show', id: cat.id){cat.name} }</li>"""
        }

        // You cannot use tags like this in taglibs. You will have to use them as regular methods
        /*
        out << """<g:each in="${categories}" var="cat">"""
        out << """<li role="presentation"><g:link controller="Category" action="show" id="${cat.id}">${cat.name}</g:link></li>"""
        out << """</g:each>"""
        */
    }
}
