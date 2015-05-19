package dk.dm844.webshop.admin

class AdminTagLib {
    static defaultEncodeAs = [taglib: 'none']
    static namespace = "admin"

    def tableStriped = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<table class="table table-striped table-hover ${cssClasses}">"""
        out << body()
        out << """</table>"""
    }
}
