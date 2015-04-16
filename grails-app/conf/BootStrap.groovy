import dk.dm844.webshop.SecurityRole
import dk.dm844.webshop.UserAlias
import dk.dm844.webshop.UserAliasSecurityRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        def packerRole = new SecurityRole(authority: 'ROLE_EMPLOYEE_PACKER').save(failOnError: true, flush: true)
        def customerRole = new SecurityRole(authority: 'ROLE_CUSTOMER').save(failOnError: true, flush: true)
        def driverRole =  new SecurityRole(authority: 'ROLE_EMPLOYEE_DRIVER').save(failOnError: true, flush: true)
        def adminRole =  new SecurityRole(authority: 'ROLE_EMPLOYEE_ADMIN').save(failOnError: true, flush: true)

        [
                ['Alice', 'Al Street 1', 'alice', 'al123','alice@email.dk'],
                ['Bob', 'Bob Boulevard 2', 'bob', 'bo234', 'bob@email.dk'],
                ['Cassie', 'City Town 12', 'cas', 'ca345', 'cas@email.dk'],
                ['Dennis', 'Deal Street 1', 'den', 'de456', 'dennis@email.dk'],
                ['Erik', 'Elm Street 4', 'erik','er567','erik@email.dk']
        ].each {
            new UserAlias(
                    name: it[0],
                    address: it[1],
                    username: it[2],
                    password: it[3],
                    enabled: true,
                    email: it[4]
            ).save(failOnError: true, flush: true)
        }

        UserAliasSecurityRole.create( UserAlias.findByName('Alice'), customerRole )
        UserAliasSecurityRole.create( UserAlias.findByName('Bob'), customerRole )
        UserAliasSecurityRole.create( UserAlias.findByName('Cassie'), packerRole )
        UserAliasSecurityRole.create( UserAlias.findByName('Dennis'), driverRole )
        UserAliasSecurityRole.create( UserAlias.findByName('Erik'), adminRole )
        UserAliasSecurityRole.create( UserAlias.findByName('Erik'), driverRole )


        assert UserAlias.count() == 5
        assert SecurityRole.count() == 4
    }

    def destroy = {
    }
}
