/**
 * Created by anders on 5/19/15.
 */
package dk.dm844.webshop

import geb.spock.GebReportingSpec
import spock.lang.*

@Stepwise
class CategoryFunctionalSpec extends GebReportingSpec {

    @Unroll
    def "Check product listing for category '#cat'"() {

        when: "Go to front page"
        go 'http://localhost:8088/webshop/'

        then: "The title is 'Welcome to The Grocery Shop'"
        title == "The Grocery Shop"

        when: "Locate and click on #cat category"
        $("a", text:"$cat").click()

        then:
        title == cat

        where:
        cat << ["Dairy", "Meat", "Crisps & Candy"]
    }
}

