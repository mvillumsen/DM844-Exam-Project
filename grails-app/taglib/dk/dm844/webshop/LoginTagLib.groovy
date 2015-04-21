package dk.dm844.webshop

class LoginTagLib {
    static namespace = "login"
    static defaultEncodeAs = [taglib:'none']

    def form = { attrs, body ->
        String res = attrs.resource ?: ''
        out << """<form action="${res}" method="POST" accept-charset="UTF-8">"""
        out << body()
        out << """</form>"""
    }

    def formGroup = { attrs, body ->
        out << """<div class="form-group">"""
        out << body()
        out << """</div>"""
    }

    def checkbox = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="checkbox ${cssClasses}">"""
        out << """<label>"""
        out << """<input type="checkbox"> """
        out << body()
        out << """</label>"""
        out << """</div>"""
    }

    def signInButton = { attrs, body ->
        out << """<button class="btn btn-primary" type="submit" id="sign-in">"""
        out << body()
        out << """</button>"""
    }

    def label = { attrs, body ->
        String f = attrs.for ?: ''
        out << """<label for="${f}">"""
        out << body()
        out << """</label>"""
    }

    def inputForm = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        String type = attrs.type ?: ''
        String id = attrs.id ?: ''
        String name = attrs.name ?: ''
        String placeholder = attrs.placeholder ?: ''

        out << """<input class="form-control ${cssClasses}" type="${type}" id="${id}" name="${name}" placeholder="${placeholder}">"""

    }
}
