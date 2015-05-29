package dk.dm844.webshop

import geb.spock.GebReportingSpec
import spock.lang.*

/**
 * Created by anders on 5/21/15.
 */
class LoginWrongFunctionalSpec extends GebReportingSpec {
    @Shared
    String shoptitle = "The Grocery Shop"

    void "enter front page"() {
        when:
        go 'http://localhost:8088/webshop/'
        then:
        title == shoptitle
    }

    void "login with incorrect crecentials"() {
        when:
        $("a", class: "dropdown-toggle").click()

        and:
        $("form").j_username = "duck"
        $("form").j_password = "xxx"
        $("button", id: "sign-in").click()

        then:
        title == "Login"
    }
}