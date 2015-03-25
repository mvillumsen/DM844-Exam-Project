package dk.dm844.webshop

import grails.plugin.springsecurity.annotation.Secured
@Secured(['ROLE_EMPLOYEE','ROLE_CUSTOMER'])
class SecureController {

    def index() {
        render 'Hello there, you wizard of safety...'
        render '<p><a href="webshop/logout">Logout</a></p>'
    }

}