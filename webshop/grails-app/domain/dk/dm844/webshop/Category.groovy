package dk.dm844.webshop

class Category {

    String name
    String description
    Date dateCreated
    Date lastUpdated
    static hasMany = [products : Product]

    static constraints = {
        name blank: false
        description nullable: true
    }

    @Override
    String toString() {
        return name
    }

}
