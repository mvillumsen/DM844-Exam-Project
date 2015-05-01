package dk.dm844.webshop

import grails.test.mixin.TestFor
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(ProductOrderTagLib)
class ProductOrderTagLibSpec extends Specification {

    @Unroll
    void "Testing ordersAccordion with cssClass: '#cssClass' and body: '#bodyClosure'"() {
        expect:
        tagLib.ordersAccordion( id: id, bodyClosure ) == result

        where:
        id      | bodyClosure                       || result
        ''            | { }                         || '<div class="panel-group" id=""></div>'
        ''            | { 'some-body' }             || '<div class="panel-group" id="">some-body</div>'
        'some-id'     | { 'some-body' }             || '<div class="panel-group" id="some-id">some-body</div>'
    }

    @Unroll
    void "Testing orderAccordionPanel with cssClass: '#cssClass' and body: '#bodyClosure'"() {
        when:
        String result = applyTemplate("<po:orderAccordionPanel id=\"my-id\" parentId=\"my-parent-id\" title=\"my-title\">my-body</po:orderAccordionPanel>")
        Document document = Jsoup.parse(result)

        then:
        document.select(".panel .panel-heading a").hasAttr("data-parent")
        document.select(".panel .panel-heading a").attr("data-parent") == "#my-parent-id"
        document.select(".panel .panel-heading a").hasAttr("href")
        document.select(".panel .panel-heading a").attr("href") == "#my-id"
        document.select(".panel .panel-heading a").text().trim() == "my-title"

        document.select(".panel #my-id").hasClass("panel-collapse")
        document.select(".panel #my-id .panel-body").text().trim() == "my-body"
    }

    @Unroll
    void "Testing count with cssClass: '#cssClass' and body: '#bodyClosure'"() {
        setup:
        tagLib.productOrderService = Mock(ProductOrderService)
        tagLib.productOrderService.getOrdersByStatus(_) >> { [1, 2, 3] }

        expect:
        tagLib.count( cssClasses: cssClass, bodyClosure ) == result

        where:
        cssClass    | bodyClosure                 || result
        ''            | { }                         || '<span class="">3</span>'
        ''            | { 'some-body' }             || '<span class="">3</span>'
        'some-id'     | { 'some-body' }             || '<span class="some-id">3</span>'
    }
}
