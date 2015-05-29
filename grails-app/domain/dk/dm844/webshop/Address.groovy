package dk.dm844.webshop

class Address {

    String address1
    String address2
    String zipCode
    String city
    String country

    static constraints = {
        address1 blank: false
        address2 nullable: true
        zipCode blank: false
        city blank: false
        country blank: false
    }

    @Override
    String toString() {
        String out = ""
        out += "$address1\n"
        if (address2) {
            out += "$address2\n"
        }
        out += "$zipCode $city\n$country"
        return out
    }
}
