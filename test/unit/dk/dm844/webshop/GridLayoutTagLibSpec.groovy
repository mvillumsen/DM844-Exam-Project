package dk.dm844.webshop

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(GridLayoutTagLib)
class GridLayoutTagLibSpec extends Specification {

    @Unroll
    void "Testing tag: #tag with cssClass: '#cssClass' and body: '#bodyClosure'"() {
        expect:
        tagLib."$tag"( cssClasses: cssClass , bodyClosure )  == result

        where:
        tag                     | cssClass      | bodyClosure                   || result
        'container'             | ''            | {}                            || '<div class="container "></div>'
        'container'             | ''            | { -> 'My Body Closure' }      || '<div class="container ">My Body Closure</div>'
        'container'             | 'myClass'     | { -> 'My Body Closure' }      || '<div class="container myClass">My Body Closure</div>'
        'header'                | ''            | {}                            || '<div class="page-header "></div>'
        'header'                | ''            | { -> 'My Body Closure' }      || '<div class="page-header ">My Body Closure</div>'
        'header'                | 'myClass'     | { -> 'My Body Closure' }      || '<div class="page-header myClass">My Body Closure</div>'
        'row'                   | ''            | {}                            || '<div class="row "></div>'
        'row'                   | ''            | { -> 'My Body Closure' }      || '<div class="row ">My Body Closure</div>'
        'row'                   | 'myClass'     | { -> 'My Body Closure' }      || '<div class="row myClass">My Body Closure</div>'
        'sidebar'               | ''            | {}                            || '<div class="hidden-xs col-sm-3 "><ul class="nav nav-pills nav-stacked"></ul></div>'
        'sidebar'               | ''            | { -> 'My Body Closure' }      || '<div class="hidden-xs col-sm-3 "><ul class="nav nav-pills nav-stacked">My Body Closure</ul></div>'
        'sidebar'               | 'myClass'     | { -> 'My Body Closure' }      || '<div class="hidden-xs col-sm-3 myClass"><ul class="nav nav-pills nav-stacked">My Body Closure</ul></div>'
        'contentFrame'          | ''            | {}                            || '<div class="col-xs-12 col-sm-9 "></div>'
        'contentFrame'          | ''            | { -> 'My Body Closure' }      || '<div class="col-xs-12 col-sm-9 ">My Body Closure</div>'
        'contentFrame'          | 'myClass'     | { -> 'My Body Closure' }      || '<div class="col-xs-12 col-sm-9 myClass">My Body Closure</div>'
        'productsGridLayout'    | ''            | {}                            || '<div class="col-xs-6 col-md-4 col-lg-3 "></div>'
        'productsGridLayout'    | ''            | { -> 'My Body Closure' }      || '<div class="col-xs-6 col-md-4 col-lg-3 ">My Body Closure</div>'
        'productsGridLayout'    | 'myClass'     | { -> 'My Body Closure' }      || '<div class="col-xs-6 col-md-4 col-lg-3 myClass">My Body Closure</div>'
        'thumbnails'            | ''            | {}                            || '<div class="thumbnail "></div>'
        'thumbnails'            | ''            | { -> 'My Body Closure' }      || '<div class="thumbnail ">My Body Closure</div>'
        'thumbnails'            | 'myClass'     | { -> 'My Body Closure' }      || '<div class="thumbnail myClass">My Body Closure</div>'
        'col2'                  | ''            | {}                            || '<div class="col-xs-2 "></div>'
        'col2'                  | ''            | { -> 'My Body Closure' }      || '<div class="col-xs-2 ">My Body Closure</div>'
        'col2'                  | 'myClass'     | { -> 'My Body Closure' }      || '<div class="col-xs-2 myClass">My Body Closure</div>'
        'col6'                  | ''            | {}                            || '<div class="col-xs-6 "></div>'
        'col6'                  | ''            | { -> 'My Body Closure' }      || '<div class="col-xs-6 ">My Body Closure</div>'
        'col6'                  | 'myClass'     | { -> 'My Body Closure' }      || '<div class="col-xs-6 myClass">My Body Closure</div>'
        'col8'                  | ''            | {}                            || '<div class="col-xs-8 "></div>'
        'col8'                  | ''            | { -> 'My Body Closure' }      || '<div class="col-xs-8 ">My Body Closure</div>'
        'col8'                  | 'myClass'     | { -> 'My Body Closure' }      || '<div class="col-xs-8 myClass">My Body Closure</div>'
        'col12'                 | ''            | {}                            || '<div class="col-xs-12 "></div>'
        'col12'                 | ''            | { -> 'My Body Closure' }      || '<div class="col-xs-12 ">My Body Closure</div>'
        'col12'                 | 'myClass'     | { -> 'My Body Closure' }      || '<div class="col-xs-12 myClass">My Body Closure</div>'
        'buyButton'             | ''            | {}                            || '<button type="submit" class="btn btn-primary btn-sm" role="button"></button>'
        'buyButton'             | ''            | { -> 'My Body Closure' }      || '<button type="submit" class="btn btn-primary btn-sm" role="button">My Body Closure</button>'
        'pLeadText'             | ''            | {}                            || '<p class="lead "></p>'
        'pLeadText'             | ''            | { -> 'My Body Closure' }      || '<p class="lead ">My Body Closure</p>'
        'pLeadText'             | 'myClass'     | { -> 'My Body Closure' }      || '<p class="lead myClass">My Body Closure</p>'
        'liActive'              | ''            | {}                            || '<li class="active "></li>'
        'liActive'              | ''            | { -> 'My Body Closure' }      || '<li class="active ">My Body Closure</li>'
        'liActive'              | 'myClass'     | { -> 'My Body Closure' }      || '<li class="active myClass">My Body Closure</li>'
        'address'               | ''            | {}                            || '<address class=""></address>'
        'address'               | ''            | { -> 'My Body Closure' }      || '<address class="">My Body Closure</address>'
        'address'               | 'myClass'     | { -> 'My Body Closure' }      || '<address class="myClass">My Body Closure</address>'
        'formHorizontal'        | ''            | {}                            || '<form class="form-horizontal "></form>'
        'formHorizontal'        | ''            | { -> 'My Body Closure' }      || '<form class="form-horizontal ">My Body Closure</form>'
        'formHorizontal'        | 'myClass'     | { -> 'My Body Closure' }      || '<form class="form-horizontal myClass">My Body Closure</form>'
        'formGroup'             | ''            | {}                            || '<div class="form-group"></div>'
        'formGroup'             | ''            | { -> 'My Body Closure' }      || '<div class="form-group">My Body Closure</div>'
        'footer'                | ''            | {}                            || '<footer class="footer"></footer>'
        'footer'                | ''            | { -> 'My Body Closure' }      || '<footer class="footer">My Body Closure</footer>'
        'radio'                 | ''            | {}                            || '<div class="radio "></div>'
        'radio'                 | ''            | { -> 'My Body Closure' }      || '<div class="radio ">My Body Closure</div>'
        'radio'                 | 'myClass'     | { -> 'My Body Closure' }      || '<div class="radio myClass">My Body Closure</div>'
    }

    @Unroll
    void "Testing tag: label with cssClass: '#cssClass', for: '#f' and body: '#bodyClosure'"() {
        expect:
        tagLib.label( cssClasses: cssClass , for: f, bodyClosure )  == result

        where:
        cssClass    | f         | bodyClosure                   || result
        ''          | ''        | {}                            || '<label class="" for=""></label>'
        ''          | ''        | { -> 'My Body Closure' }      || '<label class="" for="">My Body Closure</label>'
        ''          | 'myFor'   | { -> 'My Body Closure' }      || '<label class="" for="myFor">My Body Closure</label>'
        'myClass'   | 'myFor'   | { -> 'My Body Closure' }      || '<label class="myClass" for="myFor">My Body Closure</label>'
        'myClass'   | 'myFor'   | {}                            || '<label class="myClass" for="myFor"></label>'
        'myClass'   | ''        | {}                            || '<label class="myClass" for=""></label>'
        'myClass'   | ''        | { -> 'My Body Closure' }      || '<label class="myClass" for="">My Body Closure</label>'
    }

    @Unroll
    void "Testing tag: inputForm with cssClass: '#cssClass', type: '#type', id: '#id', name: '#name' and placeholder: '#placeholder'"() {
        expect:
        tagLib.inputForm( cssClasses: cssClass, type: type, id: id, name: name, placeholder: placeholder )  == result

        where:
        cssClass    | type      | id        | name      | placeholder       || result
        ''          | ''        | ''        | ''        | ''                || '<input class="form-control " type="" id="" name="" placeholder="">'
        'myClass'   | ''        | ''        | ''        | ''                || '<input class="form-control myClass" type="" id="" name="" placeholder="">'
        'myClass'   | 'myType'  | ''        | ''        | ''                || '<input class="form-control myClass" type="myType" id="" name="" placeholder="">'
        'myClass'   | 'myType'  | 'id1'     | ''        | ''                || '<input class="form-control myClass" type="myType" id="id1" name="" placeholder="">'
        'myClass'   | 'myType'  | 'id1'     | 'myName'  | ''                || '<input class="form-control myClass" type="myType" id="id1" name="myName" placeholder="">'
        'myClass'   | 'myType'  | 'id1'     | 'myName'  | 'My Placeholder'  || '<input class="form-control myClass" type="myType" id="id1" name="myName" placeholder="My Placeholder">'
    }
}
