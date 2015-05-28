package dk.dm844.webshop

import geb.spock.GebReportingSpec
import spock.lang.*

/**
 * Created by anders on 5/21/15.
 */
@Stepwise
class LoginLogoutFunctionalSpec extends GebReportingSpec{

    @Shared
    String shoptitle = "The Grocery Shop"

    void "enter front page"() {
        when:
        go 'http://localhost:8080/webshop/'
        then:
        title == shoptitle
    }

    void "login as erik"() {
        when:
        $("a", class: "dropdown-toggle").click()

        and:
        $("form").j_username = "erik"
        $("form").j_password = "er567"
        $("button", id: "sign-in").click()

        then:
        title == shoptitle
    }

    void "go to admin section"() {
        when:
        $("a", text: "Admin").click()

        then:
        title == "Welcome to Admin Interface"
    }

    void "logout"() {
        when:
        $("a", text: "Logout").click()
        then:
        title == shoptitle
    }
}
