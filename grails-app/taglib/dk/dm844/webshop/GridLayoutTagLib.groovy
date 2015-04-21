package dk.dm844.webshop

class GridLayoutTagLib {
    static namespace = "tb"
    static defaultEncodeAs = [taglib:'none']

    def content = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div id="wrap">"""
        out << """<div class="container ${cssClasses}">"""
        out << body()
        out << """</div>"""
        out << """<div id="push"></div>"""
        out << """</div>"""
    }

    def container = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="container ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def header = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="page-header ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def row = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="row ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    // TODO: Style sidebar for xs (extra small) devices
    def sidebar = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="hidden-xs col-sm-3 col-md-3 ${cssClasses}">"""
        out << """<ul class="nav nav-pills nav-stacked">"""
        out << body()
        out << """</ul>"""
        out << """</div>"""
    }

    def contentFrame = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-12 col-sm-9 col-md-9 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def productsGridLayout = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-6 col-sm-6 col-md-4 col-lg-3 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def thumbnails = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="thumbnail ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def col6of12 = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-6 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def col12 = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-12 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def buyButton = { attrs, body ->
        out << """<button type="submit" class="btn btn-primary btn-sm" role="button">"""
        out << body()
        out << """</button>"""
    }

    def pLeadText = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<p class="lead ${cssClasses}">"""
        out << body()
        out << """</p>"""
    }

    def activeli = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<li class="active ${cssClasses}">"""
        out << body()
        out << """</li>"""
    }

    def address = { attrs, body ->
        out << """<address>"""
        out << body()
        out << """</address>"""
    }

    def formHorizontal = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<form class="form-horizontal ${cssClasses}">"""
        out << body()
        out << """</form>"""
    }

    def formGroup = { attrs, body ->
        out << """<div class="form-group">"""
        out << body()
        out << """</div>"""
    }

    def label = { attrs, body ->
        String f = attrs.for ?: ''
        out << """<label for="${f}">"""
        out << body()
        out << """</label>"""
    }

    def inputForm = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        String type = attrs.type ?: ''
        String id = attrs.id ?: ''
        String name = attrs.name ?: ''
        String placeholder = attrs.placeholder ?: ''

        out << """<input class="form-control ${cssClasses}" type="${type}" id="${id}" name="${name}" placeholder="${placeholder}">"""
    }
}
