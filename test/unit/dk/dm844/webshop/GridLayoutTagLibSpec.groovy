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
        tagLib."$tag"(cssClasses: cssClass, bodyClosure) == result

        where:
        tag                  | cssClass  | bodyClosure              || result
        'container'          | ''        | { }                      || '<div class="container "></div>'
        'container'          | ''        | { -> 'My Body Closure' } || '<div class="container ">My Body Closure</div>'
        'container'          | 'myClass' | { -> 'My Body Closure' } || '<div class="container myClass">My Body Closure</div>'
        'containerFluid'     | ''        | { }                      || '<div class="container-fluid "></div>'
        'containerFluid'     | ''        | { -> 'My Body Closure' } || '<div class="container-fluid ">My Body Closure</div>'
        'containerFluid'     | 'myClass' | { -> 'My Body Closure' } || '<div class="container-fluid myClass">My Body Closure</div>'
        'header'             | ''        | { }                      || '<div class="page-header "></div>'
        'header'             | ''        | { -> 'My Body Closure' } || '<div class="page-header ">My Body Closure</div>'
        'header'             | 'myClass' | { -> 'My Body Closure' } || '<div class="page-header myClass">My Body Closure</div>'
        'row'                | ''        | { }                      || '<div class="row "></div>'
        'row'                | ''        | { -> 'My Body Closure' } || '<div class="row ">My Body Closure</div>'
        'row'                | 'myClass' | { -> 'My Body Closure' } || '<div class="row myClass">My Body Closure</div>'
        'sidebar'            | ''        | { }                      || '<div class="hidden-xs col-sm-3 "></div>'
        'sidebar'            | ''        | { -> 'My Body Closure' } || '<div class="hidden-xs col-sm-3 ">My Body Closure</div>'
        'sidebar'            | 'myClass' | { -> 'My Body Closure' } || '<div class="hidden-xs col-sm-3 myClass">My Body Closure</div>'
        'navPills'           | ''        | { }                      || '<ul class="nav nav-pills nav-stacked "></ul>'
        'navPills'           | ''        | { -> 'My Body Closure' } || '<ul class="nav nav-pills nav-stacked ">My Body Closure</ul>'
        'navPills'           | 'myClass' | { -> 'My Body Closure' } || '<ul class="nav nav-pills nav-stacked myClass">My Body Closure</ul>'
        'sidebarHeader'      | ''        | { }                      || '<li class="navbar-brand "></li><hr>'
        'sidebarHeader'      | ''        | { -> 'My Body Closure' } || '<li class="navbar-brand ">My Body Closure</li><hr>'
        'sidebarHeader'      | 'myClass' | { -> 'My Body Closure' } || '<li class="navbar-brand myClass">My Body Closure</li><hr>'
        'contentFrame'       | ''        | { }                      || '<div class="col-xs-12 col-sm-9 "></div>'
        'contentFrame'       | ''        | { -> 'My Body Closure' } || '<div class="col-xs-12 col-sm-9 ">My Body Closure</div>'
        'contentFrame'       | 'myClass' | { -> 'My Body Closure' } || '<div class="col-xs-12 col-sm-9 myClass">My Body Closure</div>'
        'contentFrameAdmin'  | ''        | { }                      || '<div class="col-xs-10 col-xs-offset-2 "></div>'
        'contentFrameAdmin'  | ''        | { -> 'My Body Closure' } || '<div class="col-xs-10 col-xs-offset-2 ">My Body Closure</div>'
        'contentFrameAdmin'  | 'myClass' | { -> 'My Body Closure' } || '<div class="col-xs-10 col-xs-offset-2 myClass">My Body Closure</div>'
        'productsGridLayout' | ''        | { }                      || '<div class="col-xs-6 col-md-4 col-lg-3 "></div>'
        'productsGridLayout' | ''        | { -> 'My Body Closure' } || '<div class="col-xs-6 col-md-4 col-lg-3 ">My Body Closure</div>'
        'productsGridLayout' | 'myClass' | { -> 'My Body Closure' } || '<div class="col-xs-6 col-md-4 col-lg-3 myClass">My Body Closure</div>'
        'thumbnails'         | ''        | { }                      || '<div class="thumbnail "></div>'
        'thumbnails'         | ''        | { -> 'My Body Closure' } || '<div class="thumbnail ">My Body Closure</div>'
        'thumbnails'         | 'myClass' | { -> 'My Body Closure' } || '<div class="thumbnail myClass">My Body Closure</div>'
        'col2'               | ''        | { }                      || '<div class="col-xs-2 "></div>'
        'col2'               | ''        | { -> 'My Body Closure' } || '<div class="col-xs-2 ">My Body Closure</div>'
        'col2'               | 'myClass' | { -> 'My Body Closure' } || '<div class="col-xs-2 myClass">My Body Closure</div>'
        'col6'               | ''        | { }                      || '<div class="col-xs-6 "></div>'
        'col6'               | ''        | { -> 'My Body Closure' } || '<div class="col-xs-6 ">My Body Closure</div>'
        'col6'               | 'myClass' | { -> 'My Body Closure' } || '<div class="col-xs-6 myClass">My Body Closure</div>'
        'col8'               | ''        | { }                      || '<div class="col-xs-8 "></div>'
        'col8'               | ''        | { -> 'My Body Closure' } || '<div class="col-xs-8 ">My Body Closure</div>'
        'col8'               | 'myClass' | { -> 'My Body Closure' } || '<div class="col-xs-8 myClass">My Body Closure</div>'
        'col12'              | ''        | { }                      || '<div class="col-xs-12 "></div>'
        'col12'              | ''        | { -> 'My Body Closure' } || '<div class="col-xs-12 ">My Body Closure</div>'
        'col12'              | 'myClass' | { -> 'My Body Closure' } || '<div class="col-xs-12 myClass">My Body Closure</div>'
        'buyButton'          | ''        | { }                      || '<button type="submit" class="btn btn-primary btn-sm" role="button">' +
                '</button>'
        'buyButton'          | ''        | { -> 'My Body Closure' } || '<button type="submit" class="btn btn-primary btn-sm" role="button">' +
                'My Body Closure</button>'
        'pLeadText'          | ''        | { }                      || '<p class="lead "></p>'
        'pLeadText'          | ''        | { -> 'My Body Closure' } || '<p class="lead ">My Body Closure</p>'
        'pLeadText'          | 'myClass' | { -> 'My Body Closure' } || '<p class="lead myClass">My Body Closure</p>'
        'liActive'           | ''        | { }                      || '<li class="active "></li>'
        'liActive'           | ''        | { -> 'My Body Closure' } || '<li class="active ">My Body Closure</li>'
        'liActive'           | 'myClass' | { -> 'My Body Closure' } || '<li class="active myClass">My Body Closure</li>'
        'address'            | ''        | { }                      || '<address class=""></address>'
        'address'            | ''        | { -> 'My Body Closure' } || '<address class="">My Body Closure</address>'
        'address'            | 'myClass' | { -> 'My Body Closure' } || '<address class="myClass">My Body Closure</address>'
        'formHorizontal'     | ''        | { }                      || '<form class="form-horizontal "></form>'
        'formHorizontal'     | ''        | { -> 'My Body Closure' } || '<form class="form-horizontal ">My Body Closure</form>'
        'formHorizontal'     | 'myClass' | { -> 'My Body Closure' } || '<form class="form-horizontal myClass">My Body Closure</form>'
        'formGroup'          | ''        | { }                      || '<div class="form-group"></div>'
        'formGroup'          | ''        | { -> 'My Body Closure' } || '<div class="form-group">My Body Closure</div>'
        'footer'             | ''        | { }                      || '<footer class="footer "></footer>'
        'footer'             | ''        | { -> 'My Body Closure' } || '<footer class="footer ">My Body Closure</footer>'
        'footer'             | 'myClass' | { -> 'My Body Closure' } || '<footer class="footer myClass">My Body Closure</footer>'
        'radio'              | ''        | { }                      || '<div class="radio "></div>'
        'radio'              | ''        | { -> 'My Body Closure' } || '<div class="radio ">My Body Closure</div>'
        'radio'              | 'myClass' | { -> 'My Body Closure' } || '<div class="radio myClass">My Body Closure</div>'
        'table'              | ''        | { }                      || '<table class="table "></table>'
        'table'              | ''        | { -> 'My Body Closure' } || '<table class="table ">My Body Closure</table>'
        'table'              | 'myClass' | { -> 'My Body Closure' } || '<table class="table myClass">My Body Closure</table>'
        'pullRight'          | ''        | { }                      || '<div class="pull-right "></div>'
        'pullRight'          | ''        | { -> 'My Body Closure' } || '<div class="pull-right ">My Body Closure</div>'
        'pullRight'          | 'myClass' | { -> 'My Body Closure' } || '<div class="pull-right myClass">My Body Closure</div>'
        'pullLeft'           | ''        | { }                      || '<div class="pull-left "></div>'
        'pullLeft'           | ''        | { -> 'My Body Closure' } || '<div class="pull-left ">My Body Closure</div>'
        'pullLeft'           | 'myClass' | { -> 'My Body Closure' } || '<div class="pull-left myClass">My Body Closure</div>'
        'button'             | ''        | { }                      || '<button type="button" class="btn btn-primary "></button>'
        'button'             | ''        | { -> 'My Body Closure' } || '<button type="button" class="btn btn-primary ">My Body Closure</button>'
        'button'             | 'myClass' | { -> 'My Body Closure' } || '<button type="button" class="btn btn-primary myClass">My Body Closure' +
                '</button>'
    }

    @Unroll
    void "Testing tag: label with cssClass: '#cssClass', for: '#f' and body: '#bodyClosure'"() {
        expect:
        tagLib.label(cssClasses: cssClass, for: f, bodyClosure) == result

        where:
        cssClass  | f       | bodyClosure              || result
        ''        | ''      | { }                      || '<label class="" for=""></label>'
        ''        | ''      | { -> 'My Body Closure' } || '<label class="" for="">My Body Closure</label>'
        ''        | 'myFor' | { -> 'My Body Closure' } || '<label class="" for="myFor">My Body Closure</label>'
        'myClass' | 'myFor' | { -> 'My Body Closure' } || '<label class="myClass" for="myFor">My Body Closure</label>'
        'myClass' | 'myFor' | { }                      || '<label class="myClass" for="myFor"></label>'
        'myClass' | ''      | { }                      || '<label class="myClass" for=""></label>'
        'myClass' | ''      | { -> 'My Body Closure' } || '<label class="myClass" for="">My Body Closure</label>'
    }

    @Unroll
    void "Testing tag: inputForm with cssClass: '#cssClass', type: '#type', id: '#id', name: '#name', placeholder: '#placeholder' and value: '#value'"() {
        expect:
        tagLib.inputForm(cssClasses: cssClass, type: type, id: id, name: name, placeholder: placeholder, value: value) == result

        where:
        cssClass  | type     | id    | name     | placeholder      | value     || result
        ''        | ''       | ''    | ''       | ''               | ''        || '<input class="form-control " type="" id="" name="" ' +
                'placeholder="" value="">'
        'myClass' | ''       | ''    | ''       | ''               | ''        || '<input class="form-control myClass" type="" id="" name="" ' +
                'placeholder="" value="">'
        'myClass' | 'myType' | ''    | ''       | ''               | ''        || '<input class="form-control myClass" type="myType" id="" name="" ' +
                'placeholder="" value="">'
        'myClass' | 'myType' | 'id1' | ''       | ''               | ''        || '<input class="form-control myClass" type="myType" id="id1" ' +
                'name="" placeholder="" value="">'
        'myClass' | 'myType' | 'id1' | 'myName' | ''               | ''        || '<input class="form-control myClass" type="myType" id="id1" ' +
                'name="myName" placeholder="" value="">'
        'myClass' | 'myType' | 'id1' | 'myName' | 'My Placeholder' | ''        || '<input class="form-control myClass" type="myType" id="id1" ' +
                'name="myName" placeholder="My Placeholder" value="">'
        'myClass' | 'myType' | 'id1' | 'myName' | 'My Placeholder' | 'myValue' || '<input class="form-control myClass" type="myType" id="id1" ' +
                'name="myName" placeholder="My Placeholder" value="myValue">'
    }

    @Unroll
    void "Testing tag: preFilledInputForm with cssClass: '#cssClass', type: '#type', id: '#id', name: '#name' and value: '#value'"() {
        expect:
        tagLib.preFilledInputForm(cssClasses: cssClass, type: type, id: id, name: name, value: value) == result

        where:
        cssClass  | type     | id    | name     | value      || result
        ''        | ''       | ''    | ''       | ''         || '<input class="form-control " type="" id="" name="" value="">'
        'myClass' | ''       | ''    | ''       | ''         || '<input class="form-control myClass" type="" id="" name="" value="">'
        'myClass' | 'myType' | ''    | ''       | ''         || '<input class="form-control myClass" type="myType" id="" name="" value="">'
        'myClass' | 'myType' | 'id1' | ''       | ''         || '<input class="form-control myClass" type="myType" id="id1" name="" value="">'
        'myClass' | 'myType' | 'id1' | 'myName' | ''         || '<input class="form-control myClass" type="myType" id="id1" name="myName" value="">'
        'myClass' | 'myType' | 'id1' | 'myName' | 'My Value' || '<input class="form-control myClass" type="myType" id="id1" name="myName"' +
                ' value="My Value">'
    }
}
