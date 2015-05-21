/**
 * Created by anders on 5/19/15.
 */
package dk.dm844.webshop

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class CategoryFunctionalSpec extends GebReportingSpec {
    def "Check product listing for category 1 'Dairy'"() {
        when: "We load Dairy category"
        go 'http://localhost:8080/webshop/category/show/1'

        then: "The title is 'Dairy'"
        title == "Dairy"
    }
}

