package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_CUSTOMER'])
class ShoppingCartController {

    CartService cartService
    SpringSecurityService securityService

    @Secured(['permitAll'])
    def index() {
        respond { }
    }

    def checkout() {
        respond { }
    }

    def doCheckout() {
        Person person = securityService.currentUser
        cartService.doCheckout(person, person.address)
        redirect(controller: "Home", action: "index")
    }
}
