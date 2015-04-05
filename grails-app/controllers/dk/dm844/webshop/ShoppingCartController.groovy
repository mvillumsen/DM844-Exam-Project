package dk.dm844.webshop

import static org.springframework.http.HttpStatus.*
import org.springframework.security.access.annotation.Secured

@Secured(['ROLE_EMPLOYEE'])
class ShoppingCartController {

    def shoppingCartService

    def index() {
    }

    // Er dette testet? I førlge coverage rapporten er det ikke ;)

    def count() {
        // I jeres egen coding style skriver i at i bruger eksplicitte typer!
        def items = shoppingCartService.getItems()
        def count = items ? items.size() : 0
        render(contentType: 'text/json') {[
                'count': count
        ]}
    }

    // Gør denne noget?
    def show() {

    }
}
