package dk.dm844.webshop

import grails.test.mixin.TestFor
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import spock.lang.Specification
import sun.org.mozilla.javascript.internal.json.JsonParser

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(ShoppingCartTagLib)
class ShoppingCartTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test price tagLib"() {
        when:
        String result = applyTemplate("<sc:price>100</sc:price>")
        Document document = Jsoup.parse(result)

        then:
        document.select("span").hasClass("price")
        document.select("span").text().trim() == "100 kr."


        when:
        result = applyTemplate("<sc:price>10</sc:price>")
        document = Jsoup.parse(result)

        then:
        document.select("span").hasClass("price")
        document.select("span").text().trim() == "10 kr."


        when:
        result = applyTemplate("<sc:price>1.40</sc:price>")
        document = Jsoup.parse(result)

        then:
        document.select("span").hasClass("price")
        document.select("span").text().trim() == "1.40 kr."
    }

}
