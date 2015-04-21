package dk.dm844.webshop

class Address {

    String name
    String address1
    String address2
    String zipCode
    String city
    String country

    static constraints = {
        name nullable: true
        address1 blank: false
        address2 nullable: true
        zipCode blank: false
        city blank: false
        country blank: false
    }
}
