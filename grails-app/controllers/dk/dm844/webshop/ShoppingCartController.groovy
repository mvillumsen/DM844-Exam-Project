package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import org.springframework.http.HttpStatus
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
        [ productCount: cartService.count() ]
    }

    @Secured([SecurityRole.CUSTOMER])
    def delivery() {
        if (cartService.count() == 0) {
            response.sendError(HttpStatus.BAD_REQUEST.value())
            return
        }
    }

    @Secured([SecurityRole.CUSTOMER])
    def checkout() {
        if (cartService.count() == 0) {
            response.sendError(HttpStatus.BAD_REQUEST.value())
            return
        }
    }

    @Transactional
    @Secured([SecurityRole.CUSTOMER])
    def confirmation(Address addressInstance) {
        if (cartService.count() == 0) {
            response.sendError(HttpStatus.BAD_REQUEST.value())
            return
        }

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
