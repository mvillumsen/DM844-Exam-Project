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

    @Override
    boolean equals(Object o) {
        return name == o.name &&
                address1 == o.address1 &&
                address2 == o.address2 &&
                zipCode == o.zipCode &&
                city == o.city &&
                country == o.country
    }

    @Override
    String toString() {
        String out = ""
        if (name) {
            out += "$name\n"
        }
        out += "$address1\n"
        if (address2) {
            out += "$address2\n"
        }
        out += "$zipCode $city\n$country"
        return out
    }
}
