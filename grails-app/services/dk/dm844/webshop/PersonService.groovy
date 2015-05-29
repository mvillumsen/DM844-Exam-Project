package dk.dm844.webshop

class PersonService {

    SecurityRole.Role getSecurityRole(Person person) {

        if (!person?.id) {
            return null
        }
        return SecurityRole.Role.getRole(UserAliasSecurityRole.findByPerson(person)?.securityRole?.authority)
    }
}
