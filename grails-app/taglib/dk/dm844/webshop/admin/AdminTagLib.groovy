package dk.dm844.webshop.admin

class AdminTagLib {
    static defaultEncodeAs = [taglib: 'html']
    static namespace = "admin"

    def tableStriped = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<table class="table-striped table-hover ${cssClasses}">"""
        out << body()
        out << """</table>"""
    }
}
