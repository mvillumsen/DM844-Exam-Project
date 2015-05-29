package dk.dm844.webshop

import grails.test.mixin.TestFor
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(PersonTagLib)
class PersonTagLibSpec extends Specification {

    @Unroll
    void "Test getRole"() {
        setup:
        tagLib.personService = Mock(PersonService)
        tagLib.personService.getSecurityRole(_) >> { SecurityRole.Role.CUSTOMER }

        when:
        String result = applyTemplate('<person:getRole person="${p}">${it.toString()}</person:getRole>')
        Document document = Jsoup.parse(result)

        then:
        document.text() == 'Customer'
    }
}
