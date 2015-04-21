package dk.dm844.webshop

import grails.test.mixin.*
import spock.lang.*

@TestFor(OrderEntryController)
@Mock(OrderEntry)
class OrderEntryControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        Person p = new Person(name: "Martin", email: "ma@ma.dk", username: 'mar', password: 'mar')
        Category ca = new Category(name: "Food")

        params["price"] = 10
        params["amount"] = 1
        params["product"] = new Product(name: "Milk", category: ca)
        params["order"] = new ProductOrder(customer: p)
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.orderEntryInstanceList
            model.orderEntryInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.orderEntryInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def orderEntry = new OrderEntry()
            orderEntry.validate()
            controller.save(orderEntry)

        then:"The create view is rendered again with the correct model"
            model.orderEntryInstance != null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            orderEntry = new OrderEntry(params)

            controller.save(orderEntry)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/orderEntry/show/1'
            controller.flash.message != null
            OrderEntry.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def orderEntry = new OrderEntry(params)
            controller.show(orderEntry)

        then:"A model is populated containing the domain instance"
            model.orderEntryInstance == orderEntry
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def orderEntry = new OrderEntry(params)
            controller.edit(orderEntry)

        then:"A model is populated containing the domain instance"
            model.orderEntryInstance == orderEntry
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/orderEntry/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def orderEntry = new OrderEntry()
            orderEntry.validate()
            controller.update(orderEntry)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.orderEntryInstance == orderEntry

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            orderEntry = new OrderEntry(params).save(flush: true)
            controller.update(orderEntry)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/orderEntry/show/$orderEntry.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/orderEntry/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def orderEntry = new OrderEntry(params).save(flush: true)

        then:"It exists"
            OrderEntry.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(orderEntry)

        then:"The instance is deleted"
            OrderEntry.count() == 0
            response.redirectedUrl == '/orderEntry/index'
            flash.message != null
    }
}
