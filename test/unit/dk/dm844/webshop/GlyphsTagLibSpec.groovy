package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(GlyphsTagLib)
class GlyphsTagLibSpec extends Specification {

    @Unroll
    void "Testing tag: '#tag'"() {
        expect:
        tagLib."$tag"() == result

        where:
        tag             || result
        'logout'        || '<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>'
        'admin'         || '<span class="glyphicon glyphicon-dashboard" aria-hidden="true"></span>'
        'shoppingCart'  || '<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>'
        'myTasks'       || '<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>'
        'users'         || '<span class="glyphicon glyphicon-user" aria-hidden="true"></span>'
        'products'      || '<span class="glyphicon glyphicon-apple" aria-hidden="true"></span>'
        'orders'        || '<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>'
    }

    @Unroll
    void "Testing tag: '#tag' with cssClass: '#cssClass' and body: '#body'"() {
        expect:
        tagLib."$tag"( cssClasses: cssClass, body ) == result

        where:
        tag             | cssClass      | body                      || result
        'badge'         | ''            | { }                       || '<span class="badge "></span>'
        'badge'         | ''            | { -> 'My Body Closure' }  || '<span class="badge ">My Body Closure</span>'
        'badge'         | 'myClass'     | { -> 'My Body Closure' }  || '<span class="badge myClass">My Body Closure</span>'
    }
}
