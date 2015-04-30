package dk.dm844.webshop

class SecurityRole {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}

    @Override
    String toString() {
        return authority
    }
}
