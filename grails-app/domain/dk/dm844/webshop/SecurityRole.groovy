package dk.dm844.webshop

class SecurityRole {

	final static String CUSTOMER = "ROLE_CUSTOMER"
	final static String EMPLOYEE = "ROLE_EMPLOYEE"

	final static class Employee {
		final static String DRIVER = "ROLE_EMPLOYEE_DRIVER"
		final static String PACKER = "ROLE_EMPLOYEE_PACKER"
		final static String ADMIN = "ROLE_EMPLOYEE_ADMIN"
	}

	enum Role {
        CUSTOMER("Customer"),
        DRIVER("Driver"),
        PACKER("Packer"),
        ADMIN("Admin"),

        final String value

        Role(String value) {
            this.value = value
        }

        static Role getRole(String role) {
            switch (role) {
                case SecurityRole.CUSTOMER:
                    return CUSTOMER
                case SecurityRole.Employee.ADMIN:
                    return ADMIN
                case SecurityRole.Employee.PACKER:
                    return PACKER
                case SecurityRole.Employee.DRIVER:
                    return DRIVER
                default: return null
            }
        }

        @Override
        String toString() {
            return value
        }

        String getKey() {
            return name()
        }
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
