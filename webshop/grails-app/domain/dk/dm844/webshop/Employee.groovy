package dk.dm844.webshop

class Employee {

    int salary
    Date dateHired
    Date dateCreated
    Date lastUpdated
    static hasOne = [credentials : Person]
    static hasMany = [assignedOrders : Order]

    static constraints = {
    }
}
