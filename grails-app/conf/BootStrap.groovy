import dk.dm844.webshop.Product
import dk.dm844.webshop.Category
import dk.dm844.webshop.SecurityRole
import dk.dm844.webshop.UserAlias
import dk.dm844.webshop.UserAliasSecurityRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

        /* Setup users */
        def employeeRole = new SecurityRole(authority: 'ROLE_EMPLOYEE').save(failOnError: true, flush: true)
        def customerRole = new SecurityRole(authority: 'ROLE_CUSTOMER').save(failOnError: true, flush: true)

        def adminUser = new UserAlias(
                name: 'Employee',
                address: 'My Address 4',
                username: 'emp',
                password: 'emp',
                enabled: true,
                email: 'emp@email.com').save(failOnError: true, flush: true)
        UserAliasSecurityRole.create adminUser, employeeRole, true

        def customer1 = new UserAlias(
                name: 'cus',
                address: 'add',
                username: 'cus',
                password: 'cus',
                enabled: true,
                email: 'cus@email.com').save(failOnError: true, flush: true)
        UserAliasSecurityRole.create customer1, customerRole, true

        assert UserAlias.count() == 2
        assert SecurityRole.count() == 2

        /* Initialize products */
        Category dairy = new Category(name: "Dairy").save(failOnError: true, flush: true)
        new Product(name: "Milk, low-fat", price: 8, description: "1 liter of organic low-fat milk.", stock: 10, category: dairy).save(failOnError: true, flush: true)
        new Product(name: "Milk, whole", price: 10, description: "1 liter of organic whole milk.", stock: 10, category: dairy).save(failOnError: true, flush: true)
        new Product(name: "Milk, Skim", price: 6, description: "1 liter of organic skim milk.", stock: 10, category: dairy).save(failOnError: true, flush: true)
        new Product(name: "Milk, fat-free", price: 5, description: "1 liter of organic fat-free milk.", stock: 10, category: dairy).save(failOnError: true, flush: true)
        new Product(name: "Lurpak butter, 250g", price: 20, description: "250 g of fresh butter from Lurpak.", stock: 20, category: dairy).save(failOnError: true, flush: true)
        new Product(name: "Free range eggs, 6 Pack", price: 22, description: "6 medium-sized free range eggs.", stock: 8, category: dairy).save(failOnError: true, flush: true)
        new Product(name: "Free range eggs, 10 Pack", price: 30, description: "10 medium-sized free range eggs.", stock: 12, category: dairy).save(failOnError: true, flush: true)
        new Product(name: "Free range eggs, 12 Pack", price: 35, description: "12 medium-sized free range eggs.", stock: 16, category: dairy).save(failOnError: true, flush: true)

        Category meat = new Category(name: "Meat").save(failOnError: true, flush: true)
        new Product(name: "Minced beef 3-7% fat, 500g", price: 40, description: "500 grams of minced beef with 3-7% fat.", stock: 35, category: meat).save(failOnError: true, flush: true)
        new Product(name: "Minced beef 8-12% fat, 500g", price: 35, description: "500 grams of minced beef with 8-12% fat.", stock: 50, category: meat).save(failOnError: true, flush: true)
        new Product(name: "Minced lamb 6-12% fat, 500g", price: 50, description: "500 grams of minced lamb with 6-12% fat.", stock: 22, category: meat).save(failOnError: true, flush: true)
        new Product(name: "Lamb chops, 6 pcs.", price: 80, description: "6 lamb chops from local organic lambs. Approximately 500g.", stock: 11, category: meat).save(failOnError: true, flush: true)
        new Product(name: "Lamb chops, 12 pcs.", price: 150, description: "12 lamb chops from local organic lambs. Approximately 1000g.", stock: 7, category: meat).save(failOnError: true, flush: true)
        new Product(name: "Pork chops on bone, 4 pcs.", price: 65, description: "4 pork chops on bone from some of the country's best pigs.", stock: 18, category: meat).save(failOnError: true, flush: true)
        new Product(name: "Bacon, 8 slices", price: 26, description: "8 slices of bacon, ummmm, BACON!", stock: 90, category: meat).save(failOnError: true, flush: true)
        new Product(name: "Bacon, 400g", price: 32, description: "One piece of bacon, approximately 400g. Umm more bacon!", stock: 83, category: meat).save(failOnError: true, flush: true)

    }

    def destroy = {
    }
}
