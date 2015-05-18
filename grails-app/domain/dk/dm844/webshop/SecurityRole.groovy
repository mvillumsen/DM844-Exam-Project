package dk.dm844.webshop

class SecurityRole {

	final static String CUSTOMER = "ROLE_CUSTOMER"
	final static String EMPLOYEE = "ROLE_EMPLOYEE"

	final static class Employee {
		final static String DRIVER = "ROLE_EMPLOYEE_DRIVER"
		final static String PACKER = "ROLE_EMPLOYEE_PACKER"
		final static String ADMIN = "ROLE_EMPLOYEE_ADMIN"
	}

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
