package dk.dm844.webshop

import org.springframework.security.access.annotation.Secured

@Secured(['permitAll'])
class HomeController {

    def beforeInterceptor = { ->
        log.info """<log-entry><time>${new Date()}</time><sessionid>${session.id}</sessionid><info>${params}</info></log-entry>"""
    }

    def index() {
        [ ]
    }
}
