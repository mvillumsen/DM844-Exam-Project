package dk.dm844.webshop

import org.apache.commons.lang.builder.HashCodeBuilder

class UserAliasSecurityRole implements Serializable {

	private static final long serialVersionUID = 1

	Person person
	SecurityRole securityRole

	boolean equals(other) {
		if (!(other instanceof UserAliasSecurityRole)) {
			return false
		}

		other.person?.id == person?.id &&
		other.securityRole?.id == securityRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (person) {
            builder.append(person.id)
        }
		if (securityRole) {
            builder.append(securityRole.id)
        }
		builder.toHashCode()
	}

	static UserAliasSecurityRole get(long personId, long securityRoleId) {
		UserAliasSecurityRole.where {
			person == Person.load(personId) &&
			securityRole == SecurityRole.load(securityRoleId)
		}.get()
	}

	static boolean exists(long personId, long securityRoleId) {
		UserAliasSecurityRole.where {
			person == Person.load(personId) &&
			securityRole == SecurityRole.load(securityRoleId)
		}.count() > 0
	}

	static UserAliasSecurityRole create(Person person, SecurityRole securityRole, boolean flush = false) {
		def instance = new UserAliasSecurityRole(person: person, securityRole: securityRole)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(Person p, SecurityRole r, boolean flush = false) {
		if (p == null || r == null) {
            return false
        }

		int rowCount = UserAliasSecurityRole.where {
			person == Person.load(p.id) &&
			securityRole == SecurityRole.load(r.id)
		}.deleteAll()

		if (flush) { UserAliasSecurityRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(Person p, boolean flush = false) {
		if (p == null) {
            return
        }

		UserAliasSecurityRole.where {
			person == Person.load(p.id)
		}.deleteAll()

		if (flush) { UserAliasSecurityRole.withSession { it.flush() } }
	}

	static void removeAll(SecurityRole r, boolean flush = false) {
		if (r == null) {
            return
        }

		UserAliasSecurityRole.where {
			securityRole == SecurityRole.load(r.id)
		}.deleteAll()

		if (flush) { UserAliasSecurityRole.withSession { it.flush() } }
	}

	static constraints = {
		securityRole validator: { SecurityRole r, UserAliasSecurityRole ur ->
			if (ur.person == null) {
                return
            }
			boolean existing = false
			UserAliasSecurityRole.withNewSession {
				existing = UserAliasSecurityRole.exists(ur.person.id, r.id)
			}
			if (existing) {
				return 'person.exists'
			}
		}
	}

	static mapping = {
		id composite: ['securityRole', 'person']
		version false
	}

    String toString() {
        return "N/A"
    }
}
