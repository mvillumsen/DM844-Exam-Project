package dk.dm844.webshop

class Category {

    int id
    String name
    String description

    static constraints = {
        id unique: true, blank: false
        name blank: false
        description nullable: true
    }
}
