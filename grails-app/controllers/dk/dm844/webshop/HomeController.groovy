package dk.dm844.webshop

import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_EMPLOYEE'])
class HomeController {

    def index() {
        //Do nothing
    }
}
