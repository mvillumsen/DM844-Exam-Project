package dk.dm844.webshop

import webshop.CategoriesService

class CategoriesTagLib {
    static namespace = "cat"
    static defaultEncodeAs = [taglib: 'none']

    def listCategories = { attrs, body ->
        out << """<g:each in="${dk.dm844.webshop.Category.list()}" var="category">"""
        out << body()
        out << """</g:each>"""
    }
}
