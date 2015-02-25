package dk.dm844.webshop

class Person {

    int id
    String name
    String address
    String phone
    String email
    Date dateCreated
    Date lastUpdated

    static constraints = {
        id unique: true, blank: false
        name blank: false
        address blank: false
        phone nullable: true
        email blank: false, email: true
    }
}
