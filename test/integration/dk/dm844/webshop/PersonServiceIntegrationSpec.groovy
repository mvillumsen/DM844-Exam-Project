package dk.dm844.webshop

import spock.lang.Specification

class PersonServiceIntegrationSpec extends Specification {

    PersonService personService

    void "Test getSecurityRole"() {
        setup:
        Address adr = new Address(address1: 'TestAdr', zipCode: '5000', city: 'Odense', country: 'Denmark').save(failOnError: true, flush: true)
        Person p1 = new Person(name: 'testUser', address: adr, email: 'alice@email.dk', username: 'testUser1', password: 'test111').save(failOnError: true,
                flush: true)
        SecurityRole customerRoleTest = SecurityRole.findByAuthority(SecurityRole.CUSTOMER).save(failOnError: true, flush: true)
        UserAliasSecurityRole.create(p1, customerRoleTest, true)

        when:
        SecurityRole.Role role1 = personService.getSecurityRole(p1)

        then:
        role1
        role1.toString() == 'Customer'
        role1.getKey() == SecurityRole.Role.CUSTOMER.getKey()

        when:
        SecurityRole.Role role2 = personService.getSecurityRole()

        then:
        !role2
    }
}
