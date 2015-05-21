package dk.dm844.webshop

import geb.spock.GebReportingSpec
import spock.lang.*

/**
 * Created by anders on 5/21/15.
 */
@Stepwise
class OrderBeforeLoginFunctionalSpec extends GebReportingSpec {

    void "Order some meat groceries"() {
        setup:
        go 'http://localhost:8080/webshop/'

        when:
        $("a", text: "Meat").click()
        and:
        $("input", 3, id: "amount").value(4)
        and:
        $("button", 3, class: "btn btn-primary btn-sm").click()

        then:
        $("span", id: "cart-count").text() == "4"


        when: "Order some more meat groceries"
        $("input", 8, id: "amount").value(7)
        and:
        $("button", 8, class: "btn btn-primary btn-sm").click()

        then:
        $("span", id: "cart-count").text() == "11"

        when: "Logging in"
        $("a", class: "dropdown-toggle").click()
        $("form").j_username = "alice"
        $("form").j_password = "al123"
        $("button", id: "sign-in").click()

        then: "All items are still in shopping cart"
        $("span", id: "cart-count").text() != "11"

        when: "Click on shopping cart"
        $("a", text: "Shopping Cart").click()

        then: "We begin checkout"
        title == "hej"
    }

    String message(String code) {
        getBean ('messageSource').getMessage (code, null, null)
    }
}
