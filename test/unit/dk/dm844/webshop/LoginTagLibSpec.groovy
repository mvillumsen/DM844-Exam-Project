package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(LoginTagLib)
class LoginTagLibSpec extends Specification {

    void "Test tag: 'form' with action: '#resource'"() {
        expect:
        tagLib.form(resource: resource, bodyClosure) == result

        where:
        resource   | bodyClosure              || result
        ''         | {}                       || '<form action="" method="POST" accept-charset="UTF-8"></form>'
        ''         | { -> 'My Body Closure' } || '<form action="" method="POST" accept-charset="UTF-8">My Body Closure</form>'
        'myAction' | {}                       || '<form action="myAction" method="POST" accept-charset="UTF-8"></form>'
        'myAction' | { -> 'My Body Closure' } || '<form action="myAction" method="POST" accept-charset="UTF-8">My Body Closure</form>'
    }

    void "Test tag: 'checkbox' with cssClass: '#cssClass'"() {
        expect:
        tagLib.checkbox(cssClasses: cssClass, bodyClosure) == result

        where:
        cssClass  | bodyClosure              || result
        ''        | {}                       || '<div class="checkbox "><label><input type="checkbox"></label></div>'
        ''        | { -> 'My Body Closure' } || '<div class="checkbox "><label><input type="checkbox">My Body Closure</label></div>'
        'myClass' | {}                       || '<div class="checkbox myClass"><label><input type="checkbox"></label></div>'
        'myClass' | { -> 'My Body Closure' } || '<div class="checkbox myClass"><label><input type="checkbox">My Body Closure</label></div>'
    }

    void "Test tag: 'signInButton'"() {
        expect:
        tagLib.signInButton() == '<button class="btn btn-primary" type="submit" id="sign-in"></button>'
        tagLib.signInButton({ -> 'My Body Closure' }) == '<button class="btn btn-primary" type="submit" id="sign-in">My Body Closure</button>'
    }
}
