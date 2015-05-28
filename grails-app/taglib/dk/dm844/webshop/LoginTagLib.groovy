package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService

class LoginTagLib {
    static namespace = "login"
    static defaultEncodeAs = [taglib:'none']

    SpringSecurityService springSecurityService

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
        out << """<input type="checkbox">"""
        out << body()
        out << """</label>"""
        out << """</div>"""
    }

    def signInButton = { attrs, body ->
        out << """<button class="btn btn-primary" type="submit" id="sign-in">"""
        out << body()
        out << """</button>"""
    }

    // TODO: Test this!
    def printUserInfo = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        Person currUser = springSecurityService.currentUser

        out << """<div class="col-xs-2"><label class="${cssClasses}"><strong>${message(code: 'delivery.name.label')}:</strong></label></div>"""
        out << """<div class="col-xs-8 name">${currUser.name}</div><br>"""
        out << """<div class="col-xs-2"><label class="${cssClasses}"><strong>${message(code: 'delivery.address1.label')}:</strong></label></div>"""
        out << """<div class="col-xs-8 address1">${currUser.address.address1}</div><br>"""

        if (currUser.address.address2) {
            out << """<div class="col-xs-2"><label class="${cssClasses}"><strong>${message(code: 'delivery.address2.label')}:</strong></label></div>"""
            out << """<div class="col-xs-8 address2">${currUser.address.address2}</div><br>"""
        }

        out << """<div class="col-xs-2"><label class="${cssClasses}"><strong>${message(code: 'delivery.zipCode')}:</strong></label></div>"""
        out << """<div class="col-xs-8 zipCode">${currUser.address.zipCode}</div><br>"""

        out << """<div class="col-xs-2"><label class="${cssClasses}"><strong>${message(code: 'delivery.city')}:</strong></label></div>"""
        out << """<div class="col-xs-8 city">${currUser.address.city}</div><br>"""

        out << """<div class="col-xs-2"><label class="${cssClasses}"><strong>${message(code: 'delivery.country')}:</strong></label></div>"""
        out << """<div class="col-xs-8 country">${currUser.address.country}</div><br>"""
    }

    def getUserInfo = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        Person currUser = springSecurityService.currentUser
        Address address = currUser.address
        Map<String> userInfo = [name: currUser.name, address1: address.address1, address2: address.address2, zipCode: address.zipCode, city: address.city, country: address.country]
        out << body(userInfo)
    }
}
