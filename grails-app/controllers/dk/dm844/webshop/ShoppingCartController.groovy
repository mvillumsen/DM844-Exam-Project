package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.security.access.annotation.Secured

@Secured(['permitAll'])
class ShoppingCartController {

    CartService cartService

    def index() {
        //Do nothing
    }

    def checkout() {
        //Do nothing
    }

    def doCheckout() {
        Person person = Person.findOrCreateWhere(
                name: "Martin",
                address: "Rosenbæk Torv 15.2.8, 5000 Odense C",
                username: "maan511",
                password: "1234",
                email: "martinandersen@live.dk").save()
        cartService.doCheckout(person)
        redirect(controller: "Home", action: "index")
    }
}
