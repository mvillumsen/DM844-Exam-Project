package dk.dm844.webshop.admin

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_EMPLOYEE_DRIVER', 'ROLE_EMPLOYEE_PACKER', 'ROLE_EMPLOYEE_ADMIN'])
class AdminController {

    def index() { }
}
