package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(NavBarTagLib)
class NavBarTagLibSpec extends Specification {

    @Unroll
    void "Testing tag: #tag with cssClass: '#cssClass' and body: '#bodyClosure'"() {
        expect:
        tagLib."$tag"( cssClasses: cssClass, bodyClosure ) == result

        where:
        tag                     | cssClass      | bodyClosure               || result
        'navbarLeftContent'     | ''            | {}                        || '<ul class="nav navbar-nav"></ul>'
        'navbarLeftContent'     | ''            | { -> 'My Body Closure' }  || '<ul class="nav navbar-nav">My Body Closure</ul>'
        'navbarRightContent'    | ''            | {}                        || '<ul class="nav navbar-nav navbar-right"></ul>'
        'navbarRightContent'    | ''            | { -> 'My Body Closure' }  || '<ul class="nav navbar-nav navbar-right">My Body Closure</ul>'
        'navbarText'            | ''            | {}                        || '<p class="navbar-text "></p>'
        'navbarText'            | ''            | { -> 'My Body Closure' }  || '<p class="navbar-text ">My Body Closure</p>'
        'navbarText'            | 'myClass'     | { -> 'My Body Closure' }  || '<p class="navbar-text myClass">My Body Closure</p>'
        'signinDropdown'        | ''            | {}                        || '<li class="dropdown"><a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a><div class="dropdown-menu" style="padding: 15px; padding-bottom: 15px;"></div></li>'
        'breadcrumb'            | ''            | {}                        || '<ol class="breadcrumb "></ol>'
        'breadcrumb'            | ''            | { -> 'My Body Closure' }  || '<ol class="breadcrumb ">My Body Closure</ol>'
        'breadcrumb'            | 'myClass'     | { -> 'My Body Closure' }  || '<ol class="breadcrumb myClass">My Body Closure</ol>'
    }

    @Unroll
    void "Testing tag: navbarLink with cssClass: '#cssClass', href: '#href' and body: '#bodyClosure'"() {
        expect:
        tagLib.navbarLink( cssClasses: cssClass, url: href, bodyClosure ) == result

        where:
        cssClass        | href                      | bodyClosure               || result
        ''              | ''                        | {}                        || '<a class="navbar-link " href=""></a>'
        ''              | '#'                       | {}                        || '<a class="navbar-link " href="#"></a>'
        ''              | '#'                       | { -> "Empty link"}        || '<a class="navbar-link " href="#">Empty link</a>'
        'myClass'       | 'http://www.dr.dk'        | {}                        || '<a class="navbar-link myClass" href="http://www.dr.dk"></a>'
        'myClass'       | 'http://www.dr.dk'        | { -> "Visit dr.dk" }      || '<a class="navbar-link myClass" href="http://www.dr.dk">Visit dr.dk</a>'
        ''              | 'http://www.dr.dk'        | { -> "Visit dr.dk" }      || '<a class="navbar-link " href="http://www.dr.dk">Visit dr.dk</a>'
    }

    @Unroll
    void "Testing tag: navbar with body: '#bodyClosure'"() {
        expect:
        tagLib.navbar() == '<nav class="navbar navbar-default navbar-fixed-top">' +
                            '<div class="container">' +
                            '<div class="navbar-header">' +
                            '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">' +
                            '<span class="sr-only">Toggle navigation</span>' +
                            '<span class="icon-bar"></span>' +
                            '<span class="icon-bar"></span>' +
                            '<span class="icon-bar"></span>' +
                            '</button>' +
                            '<a class="navbar-brand" href="/webshop">WEBSHOP</a>' +
                            '</div>' +
                            '<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">' +
                            '</div></div></nav>'

        tagLib.navbar( { -> 'My Body Closure' } ) == '<nav class="navbar navbar-default navbar-fixed-top">' +
                '<div class="container">' +
                '<div class="navbar-header">' +
                '<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">' +
                '<span class="sr-only">Toggle navigation</span>' +
                '<span class="icon-bar"></span>' +
                '<span class="icon-bar"></span>' +
                '<span class="icon-bar"></span>' +
                '</button>' +
                '<a class="navbar-brand" href="/webshop">WEBSHOP</a>' +
                '</div>' +
                '<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">' +
                'My Body Closure</div></div></nav>'
    }
}
