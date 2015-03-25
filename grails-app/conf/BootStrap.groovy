import dk.dm844.webshop.SecurityRole
import dk.dm844.webshop.UserAlias
import dk.dm844.webshop.UserAliasSecurityRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        def employeeRole = new SecurityRole(authority: 'ROLE_EMPLOYEE').save(failOnError: true, flush: true)
        def customerRole = new SecurityRole(authority: 'ROLE_CUSTOMER').save(failOnError: true, flush: true)

        def adminUser = new UserAlias(username: 'emp', password: 'emp', enabled: true).save(failOnError: true, flush: true)
        UserAliasSecurityRole.create adminUser, employeeRole, true

        def customer1 = new UserAlias(username: 'cus', password: 'cus', enabled: true).save(failOnError: true, flush: true)
        UserAliasSecurityRole.create customer1, customerRole, true

        assert UserAlias.count() == 2
        assert SecurityRole.count() == 2
    }

    def destroy = {
    }
}
