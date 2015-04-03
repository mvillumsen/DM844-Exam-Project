package dk.dm844.webshop

class Person {

    String name
    String address
    String phone
    String email
    Date dateCreated
    Date lastUpdated

    transient springSecurityService

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static transients = ['springSecurityService']

    static mapping = {
        password column: '`password`'
    }

    Set<SecurityRole> getAuthorities() {
        UserAliasSecurityRole.findAllByUserAlias(this).collect { it.securityRole }
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static constraints = {
        name blank: false
        address blank: false
        phone nullable: true
        email blank: false, email: true
        username blank: false, unique: true
        password blank: false
    }

    @Override
    String toString() {
        return name
    }
}
