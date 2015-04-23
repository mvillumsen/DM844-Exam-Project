package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService

class LoginTagLib {
    static namespace = "login"
    static defaultEncodeAs = [taglib:'none']

    SpringSecurityService securityService

    def form = { attrs, body ->
        String res = attrs.resource ?: ''
        out << """<form action="${res}" method="POST" accept-charset="UTF-8">"""
        out << body()
        out << """</form>"""
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

    def getUserInfo = { attrs, body ->
        Person person = securityService.currentUser

        out << """<strong>${person.name}</strong><br>"""
        out << """${person.address.address1}<br>"""

        if (person.address.address2) {
            out << """${person.address.address2}<br>"""
        }

        out << """${person.address.zipCode}<br>"""
        out << """${person.address.city}<br>"""
        out << """${person.address.country}<br>"""
    }
}
