package dk.dm844.webshop

class Category {

    String name
    String description
    Date dateCreated
    Date lastUpdated
    static hasMany = [products : Product]

    static constraints = {
        name blank: false, unique: true
        description nullable: true
    }

    @Override
    String toString() {
        return name
    }

    @Override
    boolean equals(Object o) {
        return name == o.name
    }
}
