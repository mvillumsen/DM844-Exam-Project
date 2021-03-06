package dk.dm844.webshop

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.*
import org.springframework.http.HttpStatus
import spock.lang.*

@TestFor(ProductOrderController)
@Mock(ProductOrder)
class ProductOrderControllerSpec extends Specification {

    def setup() {
        controller.productOrderService = Mock(ProductOrderService)
        controller.springSecurityService = Mock(SpringSecurityService)
        controller.springSecurityService.currentUser >> new Person()
        controller.productOrderService.getOrdersByStatus(_) >> { [] }
    }

    def populateValidParams(params) {
        assert params != null
        params["customer"] = new Person(name: "Martin", address: new Address(address1: 'g', zipCode: '2', city: 'c', country: 'd'), email: "ma@ma.dk",
                username: 'mar', password: 'mar')
        params["address"] = new Address(address1: 'g', zipCode: '2', city: 'c', country: 'd')
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.productOrderInstanceList
        model.productOrderInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.productOrderInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def productOrder = new ProductOrder()
        productOrder.validate()
        controller.save(productOrder)

        then: "The create view is rendered again with the correct model"
        model.productOrderInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        productOrder = new ProductOrder(params)

        controller.save(productOrder)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/productOrder/show/1'
        controller.flash.message != null
        ProductOrder.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def productOrder = new ProductOrder(params)
        controller.show(productOrder)

        then: "A model is populated containing the domain instance"
        model.productOrderInstance == productOrder
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def productOrder = new ProductOrder(params)
        controller.edit(productOrder)

        then: "A model is populated containing the domain instance"
        model.productOrderInstance == productOrder
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/productOrder/index'
        flash.message != null

        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def productOrder = new ProductOrder()
        productOrder.validate()
        controller.update(productOrder)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.productOrderInstance == productOrder

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        productOrder = new ProductOrder(params).save(flush: true)
        controller.update(productOrder)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/productOrder/show/$productOrder.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/productOrder/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def productOrder = new ProductOrder(params).save(flush: true)

        then: "It exists"
        ProductOrder.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(productOrder)

        then: "The instance is deleted"
        ProductOrder.count() == 0
        response.redirectedUrl == '/productOrder/index'
        flash.message != null
    }

    void "Test packaging"() {
        when:
        controller.packaging()

        then:
        response.status == HttpStatus.OK.value()
    }

    void "Test completed"() {
        when:
        controller.packaging()

        then:
        response.status == HttpStatus.OK.value()
    }

    void "Test shipment"() {
        when:
        controller.shipment()

        then:
        response.status == HttpStatus.OK.value()
    }

    void "Test assign packaging"() {
        when:
        controller.assignPackaging(new ProductOrder())

        then:
        response.status == HttpStatus.MOVED_TEMPORARILY.value()

        when:
        controller.assignPackaging(null)

        then:
        response.status == HttpStatus.NOT_FOUND.value()
    }

    void "Test assign shipment"() {
        when:
        controller.assignShipment(new ProductOrder())

        then:
        response.status == HttpStatus.MOVED_TEMPORARILY.value()

        when:
        controller.assignShipment(null)

        then:
        response.status == HttpStatus.NOT_FOUND.value()
    }

    void "Test finish assignment"() {
        when:
        controller.finishAssignment(null)

        then:
        response.status == HttpStatus.NOT_FOUND.value()

        when:
        response.reset()
        controller.finishAssignment(new ProductOrder())

        then:
        response.status == HttpStatus.UNAUTHORIZED.value()

        when:
        response.reset()
        ProductOrder order = new ProductOrder(id:1)
        Person person = new Person(id:1)
        controller.springSecurityService.currentUser >> person
        order.assignedEmployee = person
        controller.finishAssignment(order)

        then:
        response.status == HttpStatus.MOVED_TEMPORARILY.value()
    }
}
