import dk.dm844.webshop.Person
import dk.dm844.webshop.SecurityRole
import dk.dm844.webshop.UserAliasSecurityRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        def customerRole = new SecurityRole(authority: 'ROLE_CUSTOMER').save(failOnError: true, flush: true)
        def packerRole = new SecurityRole(authority: 'ROLE_EMPLOYEE_PACKER').save(failOnError: true, flush: true)
        def driverRole =  new SecurityRole(authority: 'ROLE_EMPLOYEE_DRIVER').save(failOnError: true, flush: true)
        def adminRole =  new SecurityRole(authority: 'ROLE_EMPLOYEE_ADMIN').save(failOnError: true, flush: true)

        [
                ['Alice', 'Al Street 1', 'alice', 'al123','alice@email.dk'],
                ['Bob', 'Bob Boulevard 2', 'bob', 'bo234', 'bob@email.dk'],
                ['Cassie', 'City Town 12', 'cas', 'ca345', 'cas@email.dk'],
                ['Dennis', 'Deal Street 1', 'den', 'de456', 'dennis@email.dk'],
                ['Erik', 'Elm Street 4', 'erik','er567','erik@email.dk']
        ].each {
            new Person(
                    name: it[0],
                    address: null,
                    username: it[2],
                    password: it[3],
                    enabled: true,
                    email: it[4]
            ).save(failOnError: true, flush: true)
        }

        UserAliasSecurityRole.create( Person.findByName('Alice'), customerRole, true )
        UserAliasSecurityRole.create( Person.findByName('Bob'), customerRole, true )
        UserAliasSecurityRole.create( Person.findByName('Cassie'), packerRole, true )
        UserAliasSecurityRole.create( Person.findByName('Dennis'), driverRole, true )
        UserAliasSecurityRole.create( Person.findByName('Erik'), adminRole, true )
        UserAliasSecurityRole.create( Person.findByName('Erik'), driverRole, true )


        assert Person.count() == 5
        assert SecurityRole.count() == 4
        assert UserAliasSecurityRole.count() == 6
    }

    def destroy = {
    }
}
