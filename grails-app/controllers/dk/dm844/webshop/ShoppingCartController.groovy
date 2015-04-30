package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_CUSTOMER'])
class ShoppingCartController {

    CartService cartService
    SpringSecurityService springSecurityService

    @Secured(['permitAll'])
    def index() {
        respond { }
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
    def checkout() {
        respond { }
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
    def delivery() {
	respond { }
    }

    @Secured(['ROLE_CUSTOMER', 'ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
    @Transactional
    def doCheckout(Address addressInstance) {
        if (addressInstance.hasErrors()) {
            respond addressInstance.errors, view:'delivery'
            return
        }

        addressInstance.save flush:true

        Person person = springSecurityService.currentUser
        cartService.doCheckout(person, addressInstance)
        redirect(controller: "Home", action: "index")
    }
}
