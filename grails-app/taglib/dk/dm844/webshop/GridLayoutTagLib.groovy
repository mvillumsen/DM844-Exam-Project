package dk.dm844.webshop

class GridLayoutTagLib {
    static namespace = "tb"
    static defaultEncodeAs = [taglib:'none']

    def container = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="container ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def containerFluid = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="container-fluid ${cssClasses}">"""
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
        out << """<div class="hidden-xs col-sm-3 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def navPills = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<ul class="nav nav-pills nav-stacked ${cssClasses}">"""
        out << body()
        out << """</ul>"""
    }

    def sidebarHeader = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<li class="navbar-brand ${cssClasses}">"""
        out << body()
        out << """/li><hr>"""
    }

    def contentFrame = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-12 col-sm-9 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def contentFrameAdmin = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-10 col-xs-offset-2 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def productsGridLayout = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-6 col-md-4 col-lg-3 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def thumbnails = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="thumbnail ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def col2 = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-2 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def col6 = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-6 ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def col8 = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="col-xs-8 ${cssClasses}">"""
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

    def liActive = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<li class="active ${cssClasses}">"""
        out << body()
        out << """</li>"""
    }

    def address = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<address class="${cssClasses}">"""
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
        String cssClasses = attrs.cssClasses ?: ''
        String f = attrs.for ?: ''
        out << """<label class="${cssClasses}" for="${f}">"""
        out << body()
        out << """</label>"""
    }

    def inputForm = { attrs ->
        String cssClasses = attrs.cssClasses ?: ''
        String type = attrs.type ?: ''
        String id = attrs.id ?: ''
        String name = attrs.name ?: ''
        String placeholder = attrs.placeholder ?: ''

        out << """<input class="form-control ${cssClasses}" type="${type}" id="${id}" name="${name}" placeholder="${placeholder}">"""
    }

    def footer = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<footer class="footer ${cssClasses}">"""
        out << body()
        out << """</footer>"""
    }

    def radio = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<div class="radio ${cssClasses}">"""
        out << body()
        out << """</div>"""
    }

    def table = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<table class="table ${cssClasses}">"""
        out << body()
        out << """</table>"""
    }
}
