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
        'navbarLeftContent'     | ''            | { }                       || '<ul class="nav navbar-nav navbar-left"></ul>'
        'navbarLeftContent'     | ''            | { -> 'My Body Closure' }  || '<ul class="nav navbar-nav navbar-left">My Body Closure</ul>'
        'navbarRightContent'    | ''            | { }                       || '<ul class="nav navbar-nav navbar-right"></ul>'
        'navbarRightContent'    | ''            | { -> 'My Body Closure' }  || '<ul class="nav navbar-nav navbar-right">My Body Closure</ul>'
        'navbarText'            | ''            | { }                       || '<p class="navbar-text "></p>'
        'navbarText'            | ''            | { -> 'My Body Closure' }  || '<p class="navbar-text ">My Body Closure</p>'
        'navbarText'            | 'myClass'     | { -> 'My Body Closure' }  || '<p class="navbar-text myClass">My Body Closure</p>'
        'signinDropdown'        | ''            | { }                       || '<li class="dropdown">' +
                '<a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret">' +
                '</strong></a><div class="dropdown-menu" style="padding: 15px; padding-bottom: 15px;"></div></li>'
        'breadcrumb'            | ''            | { }                       || '<ol class="breadcrumb "></ol>'
        'breadcrumb'            | ''            | { -> 'My Body Closure' }  || '<ol class="breadcrumb ">My Body Closure</ol>'
        'breadcrumb'            | 'myClass'     | { -> 'My Body Closure' }  || '<ol class="breadcrumb myClass">My Body Closure</ol>'
    }

    @Unroll
    void "Testing tag: navbarLink with cssClass: '#cssClass', href: '#href' and body: '#bodyClosure'"() {
        expect:
        tagLib.navbarLink( cssClasses: cssClass, url: href, bodyClosure ) == result

        where:
        cssClass        | href                      | bodyClosure               || result
        ''              | ''                        | { }                       || '<a href="/" class="navbar-link "></a>'
        ''              | '#'                       | { }                       || '<a href="#" class="navbar-link "></a>'
        ''              | '#'                       | { -> "Empty link" }       || '<a href="#" class="navbar-link ">Empty link</a>'
        'myClass'       | 'http://www.dr.dk'        | { }                       || '<a href="http://www.dr.dk" class="navbar-link myClass"></a>'
        'myClass'       | 'http://www.dr.dk'        | { -> "Visit dr.dk" }      || '<a href="http://www.dr.dk" class="navbar-link myClass">Visit dr.dk</a>'
        ''              | 'http://www.dr.dk'        | { -> "Visit dr.dk" }      || '<a href="http://www.dr.dk" class="navbar-link ">Visit dr.dk</a>'
    }

    @Unroll
    void "Testing tag: progressBar with percentate completed: '#completed'"() {
        expect:
        tagLib.progressBar( percentCompleted: completed ) == result

        where:
        completed   || result
        ''          || '<div class="progress">' +
                '<div class="progress-bar" role="progressbar" aria-valuenow="" aria-valuemin="0" aria-valuemax="100" style="width: %;">%' +
                '</div></div>'

        '50'        || '<div class="progress">' +
                '<div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">50%' +
                '</div></div>'
    }
}
