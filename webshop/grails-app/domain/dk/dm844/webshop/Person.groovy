package dk.dm844.webshop

class Person {

    String name
    String address
    String phone
    String email
    Date dateCreated
    Date lastUpdated

    static constraints = {
        name blank: false
        address blank: false
        phone nullable: true
        email blank: false, email: true
    }

    @Override
    String toString() {
        return name
    }
}
