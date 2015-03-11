package dk.dm844.webshop

class Customer {

    Date dateCreated
    Date lastUpdated
    Person credentials

    static hasMany = [orders : ProductOrder]

    static constraints = {
    }

    @Override
    String toString() {
        return credentials?.name
    }
}
