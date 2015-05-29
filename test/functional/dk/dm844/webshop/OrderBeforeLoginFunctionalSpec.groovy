package dk.dm844.webshop

import geb.spock.GebReportingSpec
import org.openqa.selenium.JavascriptExecutor
import spock.lang.*

/**
 * Created by anders on 5/21/15.
 */
@Stepwise
class OrderBeforeLoginFunctionalSpec extends GebReportingSpec {


    void "Order some meat groceries"() {
        setup:
        go 'http://localhost:8088/webshop/'

        when: "ordering"
        $("a", text: "Meat").click()
        and:
        $("input", 3, id: "amount").value(4)
        $("button", 3, class: "btn btn-primary btn-sm").click()

        and: "Order some more meat groceries"
        $("input", 8, id: "amount").value(7)
        $("button", 8, class: "btn btn-primary btn-sm").click()

        and: "Logging in"
        $("a", class: "dropdown-toggle").click()
        $("form").j_username = "alice"
        $("form").j_password = "al123"
        $("button", id: "sign-in").click()

        then: "All items are still in shopping cart"
        $("span", id: "cart-count").text() == "11"

        when: "Click on shopping cart and order"
        $("a", text: startsWith("Shopping Cart")).click()

        then:
        title == "Shopping Cart"

        when:
        $("input", name: startsWith("Order")).click()

        then:
        title == "Checkout"

        when: "we click confirm"
        $("input", name: "Confirm").click()

        then:
        title == "Enter delivery address"

        when: "we click next"
        JavascriptExecutor executor = (JavascriptExecutor) driver
        executor.executeScript("window.scrollBy(0,500)")
        $("input", name: "Next").click()

        then:
        title == "Order Confirmation"

    }

    String message(String code) {
        getBean ('messageSource').getMessage (code, null, null)
    }
}
