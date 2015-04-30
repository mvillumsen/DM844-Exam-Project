databaseChangeLog = {

	changeSet(author: "anders (generated)", id: "1430214153367-1") {
		createTable(tableName: "address") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "address_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "address1", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "address2", type: "VARCHAR(255)")

			column(name: "city", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)")

			column(name: "zip_code", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-2") {
		createTable(tableName: "category") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "category_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "VARCHAR(255)")

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-3") {
		createTable(tableName: "order_entry") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "order_entry_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "amount", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "order_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "int4") {
				constraints(nullable: "false")
			}

			column(name: "product_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-4") {
		createTable(tableName: "person") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "person_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "int8")

			column(name: "date_created", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "date_hired", type: "TIMESTAMP WITH TIME ZONE")

			column(name: "email", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "VARCHAR(255)")

			column(name: "salary", type: "int4")

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-5") {
		createTable(tableName: "product_order") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "product_order_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "int8")

			column(name: "assigned_employee_id", type: "int8")

			column(name: "customer_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-6") {
		createTable(tableName: "quantity") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "quantity_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "shopping_cart_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "shopping_item_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "value", type: "int4") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-7") {
		createTable(tableName: "security_role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "security_role_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-8") {
		createTable(tableName: "shoppable") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "shoppable_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "shopping_item_id", type: "int8")

			column(name: "class", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "category_id", type: "int8")

			column(name: "date_created", type: "TIMESTAMP WITH TIME ZONE")

			column(name: "description", type: "VARCHAR(255)")

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE")

			column(name: "name", type: "VARCHAR(255)")

			column(name: "price", type: "int4")

			column(name: "stock", type: "int4")
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-9") {
		createTable(tableName: "shopping_cart") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "shopping_cart_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "checked_out", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "lasturl", type: "VARCHAR(255)")

			column(name: "last_updated", type: "TIMESTAMP WITH TIME ZONE") {
				constraints(nullable: "false")
			}

			column(name: "sessionid", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-10") {
		createTable(tableName: "shopping_cart_interface_test_product") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "shopping_cart_interface_test_product_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "shopping_item_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-11") {
		createTable(tableName: "shopping_cart_shopping_item") {
			column(name: "shopping_cart_items_id", type: "int8")

			column(name: "shopping_item_id", type: "int8")
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-12") {
		createTable(tableName: "shopping_item") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "shopping_item_pkey")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-13") {
		createTable(tableName: "user_alias_security_role") {
			column(name: "security_role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "person_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "anders (generated)", id: "1430214153367-14") {
		addPrimaryKey(columnNames: "security_role_id, person_id", constraintName: "user_alias_security_role_pkey", tableName: "user_alias_security_role")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-15") {
		addUniqueConstraint(columnNames: "name", constraintName: "uk_46ccwnsi9409t36lurvtyljak", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "category")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-16") {
		addUniqueConstraint(columnNames: "username", constraintName: "uk_n0i6d7rc1hqkjivk494g8j2qd", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "person")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-17") {
		addUniqueConstraint(columnNames: "authority", constraintName: "uk_psmo398ojf018igs83e8yyp9a", deferrable: "false", disabled: "false", initiallyDeferred: "false", tableName: "security_role")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-33") {
		createSequence(schemaName: "public", sequenceName: "hibernate_sequence")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-18") {
		addForeignKeyConstraint(baseColumnNames: "order_id", baseTableName: "order_entry", baseTableSchemaName: "public", constraintName: "fk_ib5b21f720n83jnlu64ta4c1m", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "product_order", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-19") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "order_entry", baseTableSchemaName: "public", constraintName: "fk_k7g09j2p31y4fyueqr471i1ag", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "shoppable", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-20") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "person", baseTableSchemaName: "public", constraintName: "fk_o8tnkglv9n1eeqmo7de7em37n", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "address", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-21") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "product_order", baseTableSchemaName: "public", constraintName: "fk_q9tm1slot8ig0khfjxuduxl5a", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "address", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-22") {
		addForeignKeyConstraint(baseColumnNames: "assigned_employee_id", baseTableName: "product_order", baseTableSchemaName: "public", constraintName: "fk_a84t8ocv6gr9x5900h2k5xw1n", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "person", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-23") {
		addForeignKeyConstraint(baseColumnNames: "customer_id", baseTableName: "product_order", baseTableSchemaName: "public", constraintName: "fk_f1heq6dqsqx46ajqth9vb4nx2", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "person", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-24") {
		addForeignKeyConstraint(baseColumnNames: "shopping_cart_id", baseTableName: "quantity", baseTableSchemaName: "public", constraintName: "fk_6ae09hdu13pvhtumycci4cx66", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "shopping_cart", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-25") {
		addForeignKeyConstraint(baseColumnNames: "shopping_item_id", baseTableName: "quantity", baseTableSchemaName: "public", constraintName: "fk_ecyv48wstofxoh761gb908qfe", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "shopping_item", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-26") {
		addForeignKeyConstraint(baseColumnNames: "category_id", baseTableName: "shoppable", baseTableSchemaName: "public", constraintName: "fk_jxuf2s6r0fww43ag7wfq3iylq", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "category", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-27") {
		addForeignKeyConstraint(baseColumnNames: "shopping_item_id", baseTableName: "shoppable", baseTableSchemaName: "public", constraintName: "fk_so6pam9v2vnyvd5u02hrsukrc", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "shopping_item", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-28") {
		addForeignKeyConstraint(baseColumnNames: "shopping_item_id", baseTableName: "shopping_cart_interface_test_product", baseTableSchemaName: "public", constraintName: "fk_g09b14o6fcth5kcaj1tbobii4", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "shopping_item", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-29") {
		addForeignKeyConstraint(baseColumnNames: "shopping_cart_items_id", baseTableName: "shopping_cart_shopping_item", baseTableSchemaName: "public", constraintName: "fk_bficxqy76totq9tuq7ujacill", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "shopping_cart", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-30") {
		addForeignKeyConstraint(baseColumnNames: "shopping_item_id", baseTableName: "shopping_cart_shopping_item", baseTableSchemaName: "public", constraintName: "fk_ehy2pj0pgwxnuk3hwuh1gga16", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "shopping_item", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-31") {
		addForeignKeyConstraint(baseColumnNames: "person_id", baseTableName: "user_alias_security_role", baseTableSchemaName: "public", constraintName: "fk_38f5vy9x4srb18oe70dsrqeoi", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "person", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}

	changeSet(author: "anders (generated)", id: "1430214153367-32") {
		addForeignKeyConstraint(baseColumnNames: "security_role_id", baseTableName: "user_alias_security_role", baseTableSchemaName: "public", constraintName: "fk_gl4hf4vehvkqtripr1677x5ki", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "security_role", referencedTableSchemaName: "public", referencesUniqueColumn: "false")
	}
}
