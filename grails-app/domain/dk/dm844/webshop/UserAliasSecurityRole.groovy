package dk.dm844.webshop

import org.apache.commons.lang.builder.HashCodeBuilder

class UserAliasSecurityRole implements Serializable {

	private static final long serialVersionUID = 1

	UserAlias userAlias
	SecurityRole securityRole

	boolean equals(other) {
		if (!(other instanceof UserAliasSecurityRole)) {
			return false
		}

		other.userAlias?.id == userAlias?.id &&
		other.securityRole?.id == securityRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (userAlias) builder.append(userAlias.id)
		if (securityRole) builder.append(securityRole.id)
		builder.toHashCode()
	}

	static UserAliasSecurityRole get(long userAliasId, long securityRoleId) {
		UserAliasSecurityRole.where {
			userAlias == UserAlias.load(userAliasId) &&
			securityRole == SecurityRole.load(securityRoleId)
		}.get()
	}

	static boolean exists(long userAliasId, long securityRoleId) {
		UserAliasSecurityRole.where {
			userAlias == UserAlias.load(userAliasId) &&
			securityRole == SecurityRole.load(securityRoleId)
		}.count() > 0
	}

	static UserAliasSecurityRole create(UserAlias userAlias, SecurityRole securityRole, boolean flush = false) {
		def instance = new UserAliasSecurityRole(userAlias: userAlias, securityRole: securityRole)
		instance.save(flush: flush, insert: true)
		instance
	}

	static boolean remove(UserAlias u, SecurityRole r, boolean flush = false) {
		if (u == null || r == null) return false

		int rowCount = UserAliasSecurityRole.where {
			userAlias == UserAlias.load(u.id) &&
			securityRole == SecurityRole.load(r.id)
		}.deleteAll()

		if (flush) { UserAliasSecurityRole.withSession { it.flush() } }

		rowCount > 0
	}

	static void removeAll(UserAlias u, boolean flush = false) {
		if (u == null) return

		UserAliasSecurityRole.where {
			userAlias == UserAlias.load(u.id)
		}.deleteAll()

		if (flush) { UserAliasSecurityRole.withSession { it.flush() } }
	}

	static void removeAll(SecurityRole r, boolean flush = false) {
		if (r == null) return

		UserAliasSecurityRole.where {
			securityRole == SecurityRole.load(r.id)
		}.deleteAll()

		if (flush) { UserAliasSecurityRole.withSession { it.flush() } }
	}

	static constraints = {
		securityRole validator: { SecurityRole r, UserAliasSecurityRole ur ->
			if (ur.userAlias == null) return
			boolean existing = false
			UserAliasSecurityRole.withNewSession {
				existing = UserAliasSecurityRole.exists(ur.userAlias.id, r.id)
			}
			if (existing) {
				return 'userRole.exists'
			}
		}
	}

	static mapping = {
		id composite: ['securityRole', 'userAlias']
		version false
	}
}
