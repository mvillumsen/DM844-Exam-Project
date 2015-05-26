package dk.dm844.webshop

import org.springframework.web.servlet.support.RequestContextUtils

class NavBarTagLib {
    static namespace = "tb"
    static defaultEncodeAs = [taglib: 'none']

    // Navigation bar tags
    def navbarDefault = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<nav class="navbar navbar-default navbar-fixed-top ${cssClasses}">"""
        out << body()
        out << """</nav>"""
    }

    def navbarInverse = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        out << """<nav class="navbar navbar-inverse navbar-fixed-top ${cssClasses}">"""
        out << body()
        out << """</nav>"""
    }

    def navbarHeader = { attrs, body ->
        out << """<div class="navbar-header">"""
        out << body()
        out << """</div>"""
    }

    def navbarCollapse = { attrs, body ->
        String brand = attrs.brand ?: ''
        String url = attrs.url ?: ''
        out << """<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">"""
        out << """<span class="sr-only">Toggle navigation</span>"""
        out << """<span class="icon-bar"></span>"""
        out << """<span class="icon-bar"></span>"""
        out << """<span class="icon-bar"></span>"""
        out << """</button>"""
        out << """<a class="navbar-brand" href="${url}">${brand}</a>"""
        out << """</div>"""
        out << """<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">"""
        out << body()
        out << """</div>"""
    }

    def navbarLeftContent = { attrs, body ->
        out << """<ul class="nav navbar-nav navbar-left">"""
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
        out << """${g.link(url: attrs.url, class: "navbar-link ${cssClasses}", body())}"""
    }

    def signinDropdown = { attrs, body ->
        out << """<li class="dropdown">"""
        out << """<a class="dropdown-toggle" href="#" data-toggle="dropdown"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> ${
            g.message(code: "default.signIn.label")
        }<strong class="caret"></strong></a>"""
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

    def progressBar = { attrs, body ->
        String percentCompleted = attrs.percentCompleted ?: ''
        out << """<div class="progress">"""
        out << """<div class="progress-bar" role="progressbar" aria-valuenow="${percentCompleted}" aria-valuemin="0" aria-valuemax="100" style="width: ${
            percentCompleted
        }%;">"""
        out << """${percentCompleted}%"""
        out << """</div>"""
        out << """</div>"""
    }

    // TODO: Test this!
    def language = { attrs, body ->
        Locale currLang = RequestContextUtils.getLocale(request)

        out << """<li class="lang ${isActive(currLang, 'en')}">${g.link(url: '?lang=en', 'EN')}</li>"""
        out << """<li class="lang ${isActive(currLang, 'da')}">${g.link(url: '?lang=da', 'DA')}</li>"""
    }

    String isActive(Locale locale, String lang) {

        if (locale.toString().startsWith(lang)) {
            return 'active'
        }

        return ''
    }
}
