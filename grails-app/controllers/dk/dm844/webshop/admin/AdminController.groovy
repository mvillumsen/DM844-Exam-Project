package dk.dm844.webshop.admin

import dk.dm844.webshop.Person
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService
import org.springframework.http.HttpStatus

@Secured(['ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
class AdminController {

    SpringSecurityService springSecurityService

    def index() {
        Person employee = springSecurityService.currentUser

        if (!employee) {
            response.sendError(HttpStatus.UNAUTHORIZED.value())
            return
        }
    }
}
