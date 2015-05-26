package dk.dm844.webshop

import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import org.hibernate.SessionFactory
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import spock.lang.Shared
import spock.lang.Specification

@Integration
@TestFor(ShoppingCartTagLib)
class ShoppingCartTagLibIntegrationSpec extends Specification {

    CartService cartService
    SessionFactory sessionFactory

    @Shared
    Product p

    @Shared
    Product p2

    def setup() {
        saveProductInDatabase()
        savePersonInDatabase()
        tagLib.cartService = cartService
    }

    void "Test count"() {
        when:
        String result = applyTemplate("<sc:count>it</sc:count>")
        Document document = Jsoup.parse(result)

        then:
        document.select("span").hasAttr("id")
        document.select("span").attr("id") == "cart-count"
        document.select("span").text().trim() == "0"

        when:
        cartService.addToShoppingCart(p, 10)
        result = applyTemplate("<sc:count />")
        document = Jsoup.parse(result)

        then:
        document.select("span").hasAttr("id")
        document.select("span").attr("id") == "cart-count"
        document.select("span").text().trim() == "10"

        when:
        cartService.addToShoppingCart(p, 1)
        cartService.addToShoppingCart(p2, 1)
        result = applyTemplate("<sc:count />")
        document = Jsoup.parse(result)

        then:
        document.select("span").hasAttr("id")
        document.select("span").attr("id") == "cart-count"
        document.select("span").text().trim() == "12"
    }

    void "Test total"() {
        when:
        String result = applyTemplate("<sc:total />")
        Document document = Jsoup.parse(result)

        then:
        document.text().trim() == "0"

        when:
        cartService.addToShoppingCart(p, 10)
        sessionFactory.getCurrentSession().flush()
        result = applyTemplate("<sc:total />")
        document = Jsoup.parse(result)

        then:
        document.text().trim() == (10 * p.price).toString()

        when:
        cartService.addToShoppingCart(p, 1)
        cartService.addToShoppingCart(p2, 5)
        sessionFactory.getCurrentSession().flush()
        result = applyTemplate("<sc:total />")
        document = Jsoup.parse(result)

        then:
        document.text().trim() == (11 * p.price + 5 * p2.price).toString()
    }

    void "Test each"() {

        when:
        String result = applyTemplate("""<sc:each>it['product']</sc:each>""")
        Document document = Jsoup.parse(result)

        then:
        document.text().trim() == ""

        when:
        cartService.addToShoppingCart(p, 10)
        sessionFactory.getCurrentSession().flush()
        result = applyTemplate("""
            <sc:each>
                <article>
                    <div class="product">
                        \${it['product']}
                    </div>
                    <div class="qty">
                        \${it['qty']}
                    </div>
                </article>
            </sc:each>""")
        document = Jsoup.parse(result)

        then:
        document.select("article").size() == 1
        document.select(".product").first().text().trim() == p.toString()
        document.select(".qty").first().text().trim() == "10"

        when:
        cartService.addToShoppingCart(p, 1)
        cartService.addToShoppingCart(p2, 5)
        sessionFactory.getCurrentSession().flush()
        result = applyTemplate("""
            <sc:each>
                <article>
                    <div class="product">
                        \${it['product']}
                    </div>
                    <div class="qty">
                        \${it['qty']}
                    </div>
                </article>
            </sc:each>""")
        document = Jsoup.parse(result)

        then:
        document.select("article").size() == 2
        document.select("article").eachWithIndex { article, idx ->
            article.select(".product").text().trim() == idx == 1 ? p.toString() : p2.toString()
            article.select(".qty").text().trim() == idx == 1 ? "1" : "5"
        }
    }

    private saveProductInDatabase() {
        Category ca = new Category(name: "something extremely unique" + System.currentTimeMillis()).save(flush: true)
        println "Category: $ca (${ca.id})"
        p = new Product(name: "Milk", category: ca, price: 10, stock: 1).save(flush: true)
        p2 = new Product(name: "Milk", category: ca, price: 14, stock: 1).save(flush: true)
    }

    private savePersonInDatabase() {
        new Person(
                name: 'Martin',
                address: new Address(address1: 'gade', zipCode: '2', city: 'by', country: 'UK').save(flush: true),
                username: 'ma',
                password: 'ma',
                enabled: true,
                email: 'mail@example.com'
        ).save(failOnError: true, flush: true)
    }
}
