import dk.dm844.webshop.SecurityRole
import dk.dm844.webshop.UserAlias
import dk.dm844.webshop.UserAliasSecurityRole

class BootStrap {

    def init = { servletContext ->

        def adminRole = new SecurityRole(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new SecurityRole(authority: 'ROLE_USER').save(flush: true)

        def testUser = new UserAlias(username: 'anders', password: 'testpassword')
        testUser.save(flush: true)
        def testUser2 = new UserAlias(username: 'bruger', password: 'hejsa')
        testUser2.save(flush: true)

        UserAliasSecurityRole.create testUser, adminRole, true
        UserAliasSecurityRole.create testUser2, userRole, true

        assert UserAlias.count() == 2
        assert SecurityRole.count() == 2
        assert UserAlias.count() == 2 }

    def destroy = {
    }
}
