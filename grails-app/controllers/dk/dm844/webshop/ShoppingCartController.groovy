package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Secured([SecurityRole.CUSTOMER])
class ShoppingCartController {

    def beforeInterceptor = {
        log.info """<log-entry><time>${new Date()}</time><sessionid>${session.getId()}</sessionid><info>${params}</info></log-entry>"""
    }

    CartService cartService
    SpringSecurityService springSecurityService

    @Secured(['permitAll'])
    def index() {
        respond { }
    }

    @Secured(['permitAll'])
    def delivery() {
        respond { }
    }

    @Secured([SecurityRole.CUSTOMER])
    def checkout() {
        respond { }
    }

    @Transactional
    @Secured([SecurityRole.CUSTOMER])
    def confirmation(Address addressInstance) {
        if (addressInstance.hasErrors()) {
            respond addressInstance.errors, view:'delivery'
            return
        }

        addressInstance.save flush:true

        Person person = (Person) springSecurityService.currentUser
        ProductOrder order = cartService.doCheckout(person, addressInstance)

        redirect(controller: 'productOrder', action: 'confirmation', id: order.id)
    }
}
