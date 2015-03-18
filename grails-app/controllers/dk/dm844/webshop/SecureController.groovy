package dk.dm844.webshop

import grails.plugin.springsecurity.annotation.Secured

class SecureController {

    @Secured(['ROLE_ADMIN'])
    def index() {
        render 'Hello there, you wizard of safety...'
        render '<p><a href="webshop/j_spring_security_logout">Logout</a></p>'
    }

}