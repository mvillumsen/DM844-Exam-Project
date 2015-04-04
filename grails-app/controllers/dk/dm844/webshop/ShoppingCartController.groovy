package dk.dm844.webshop

import static org.springframework.http.HttpStatus.*
import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_EMPLOYEE'])
class ShoppingCartController {

    def shoppingCartService

    def index() {
    }

    def count() {
        def items = shoppingCartService.getItems()
        def count = items ? items.size() : 0
        render(contentType: 'text/json') {[
                'count': count
        ]}
    }

    def show() {

    }
}
