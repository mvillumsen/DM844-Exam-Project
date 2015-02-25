package dk.dm844.webshop

class Employee {

    int id
    int salary
    Date dateHired
    Date dateCreated
    Date lastUpdated
    static belongsTo = [credentials : Person]
    static hasMany = [assignedOrders : Order]

    static constraints = {

    }
}
