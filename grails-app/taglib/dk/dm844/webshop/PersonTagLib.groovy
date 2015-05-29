package dk.dm844.webshop

class PersonTagLib {
    static defaultEncodeAs = [taglib: 'none']
    static namespace = "person"

    PersonService personService

    def getRole = { attrs, body ->
        Person person = attrs.person
        out << body(personService.getSecurityRole(person))
    }
}
