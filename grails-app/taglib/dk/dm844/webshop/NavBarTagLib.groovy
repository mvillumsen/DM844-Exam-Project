package dk.dm844.webshop

class NavBarTagLib {
    static namespace = "tb"
    static defaultEncodeAs = [taglib:'none']

    // Navigation bar tags
    def navbar = { attrs, body ->
        out << """<nav class="navbar navbar-default navbar-fixed-top">"""
        out << """<div class="container">"""
        out << """<div class="navbar-header">"""
        out << """<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">"""
        out << """<span class="sr-only">Toggle navigation</span>"""
        out << """<span class="icon-bar"></span>"""
        out << """<span class="icon-bar"></span>"""
        out << """<span class="icon-bar"></span>"""
        out << """</button>"""
        out << """<a class="navbar-brand" href="/webshop">WEBSHOP</a>"""
        out << """</div>"""
        out << """<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">"""
        out << body()
        out << """</div>"""
        out << """</div>"""
        out << """</nav>"""
    }

    def navbarLeftContent = { attrs, body ->
        out << """<ul class="nav navbar-nav">"""
        out << body()
        out << """</ul>"""
    }

    def navbarRightContent = { attrs, body ->
        out << """<ul class="nav navbar-nav navbar-right">"""
        out << body()
        out << """</ul>"""
    }

    def navbarText = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<p class="navbar-text ${cssClasses}">"""
        out << body()
        out << """</p>"""
    }

    def navbarLink = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<a class="navbar-link ${cssClasses}" href="${attrs.url}">"""
        out << body()
        out << """</a>"""
    }

    def signinDropdown = { attrs, body ->
        out << """<li class="dropdown">"""
        out << """<a class="dropdown-toggle" href="#" data-toggle="dropdown">Sign In <strong class="caret"></strong></a>"""
        out << """<div class="dropdown-menu" style="padding: 15px; padding-bottom: 15px;">"""
        out << body()
        out << """</div>"""
        out << """</li>"""
    }

    def breadcrumb = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<ol class="breadcrumb ${cssClasses}">"""
        out << body()
        out << """</ol>"""
    }

    def breadcrumbActive = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<li class="active ${cssClasses}">"""
        out << body()
        out << """</li>"""
    }
}
