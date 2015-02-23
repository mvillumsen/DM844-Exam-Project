package dk.dm844.webshop

class Category {

    int id
    String name
    String description
    Date dateCreated
    Date lastUpdated
    static hasMany = [products : Product]

    static constraints = {
        id unique: true, blank: false
        name blank: false
        description nullable: true
    }

}
