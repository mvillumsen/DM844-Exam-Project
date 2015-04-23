package dk.dm844.webshop

import org.springframework.security.access.annotation.Secured

@Secured(['permitAll'])
class HomeController {

    def index() {
        render()
    }
}
