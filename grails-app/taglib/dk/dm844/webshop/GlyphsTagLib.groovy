package dk.dm844.webshop

class GlyphsTagLib {
    static defaultEncodeAs = [taglib: 'none']
    static namespace = "glyph"

    def badge = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<span class="badge ${cssClasses}">"""
        out << body()
        out << """</span>"""
    }

    def logout = { attrs, body ->
        out << """<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>"""
    }

    def admin = { attrs, body ->
        out << """<span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>"""
    }

    def shoppingCart = { attrs, body ->
        out << """<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>"""
    }

    def myTasks = { attrs, body ->
        out << """<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>"""
    }

    def users = { attrs, body ->
        out << """<span class="glyphicon glyphicon-user" aria-hidden="true"></span>"""
    }

    def products = { attrs, body ->
        out << """<span class="glyphicon glyphicon-apple" aria-hidden="true"></span>"""
    }

    def orders = { attrs, body ->
        out << """<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>"""
    }
}
