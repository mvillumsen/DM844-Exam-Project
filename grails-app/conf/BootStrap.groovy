import dk.dm844.webshop.Address
import dk.dm844.webshop.Product
import dk.dm844.webshop.Category
import dk.dm844.webshop.Person
import dk.dm844.webshop.SecurityRole
import dk.dm844.webshop.UserAliasSecurityRole

class BootStrap {

    def springSecurityService

    def init = { servletContext ->

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

        [
                'Special Offers',
                'Fruit & Vegetables',
                'Cold Cuts & Sausages',
                'Bakery',
                'Colonial',
                'Frozen Food',
                'Drinks',
                'Crisps & Candy',
                'Household',
                'Health & Beauty',
                'Home & Ents'
        ].each {
            new Category(name: it).save(failOnError: true, flush: true)
        }

        Category.findAll().each {
            for (i in (1..10)) {
                new Product(name: "$it.name product $i", price: 10+2*i, description: "Random description for $it.name", stock: 10+i, category: it).save(failOnError: true, flush: true)
            }
        }


        SecurityRole customerRole = new SecurityRole(authority: SecurityRole.CUSTOMER).save(failOnError: true, flush: true)
        new SecurityRole(authority: SecurityRole.EMPLOYEE).save(failOnError: true, flush: true)
        SecurityRole packerRole = new SecurityRole(authority: SecurityRole.Employee.PACKER).save(failOnError: true, flush: true)
        SecurityRole driverRole =  new SecurityRole(authority: SecurityRole.Employee.DRIVER).save(failOnError: true, flush: true)
        SecurityRole adminRole =  new SecurityRole(authority: SecurityRole.Employee.ADMIN).save(failOnError: true, flush: true)

        [
                ['Alice', new Address(address1: 'Al Street 1', address2: 'My Address 2', zipCode: '5000', city: 'Odense', country: 'Denmark').save(failOnError: true, flush: true), 'alice', 'al123','alice@email.dk'],
                ['Bob', new Address(address1: 'Bob Boulevard 2', zipCode: '5000', city: 'Odense', country: 'Denmark').save(failOnError: true, flush: true), 'bob', 'bo234', 'bob@email.dk'],
                ['Cassie', new Address(address1: 'City Town 12', zipCode: '5000', city: 'Odense', country: 'Denmark').save(failOnError: true, flush: true), 'cas', 'ca345', 'cas@email.dk'],
                ['Dennis', new Address(address1: 'Deal Street 1', zipCode: '5000', city: 'Odense', country: 'Denmark').save(failOnError: true, flush: true), 'den', 'de456', 'dennis@email.dk'],
                ['Erik', new Address(address1: 'Elm Street 4', zipCode: '5000', city: 'Odense', country: 'Denmark').save(failOnError: true, flush: true), 'erik','er567','erik@email.dk']
        ].each {
            new Person(
                    name: it[0],
                    address: it[1],
                    username: it[2],
                    password: it[3],
                    enabled: true,
                    email: it[4]
            ).save(failOnError: true, flush: true)
        }

        UserAliasSecurityRole.create( Person.findByName('Alice'), customerRole, true )
        UserAliasSecurityRole.create( Person.findByName('Bob'), customerRole, true )
        UserAliasSecurityRole.create( Person.findByName('Cassie'), packerRole, true )
        UserAliasSecurityRole.create( Person.findByName('Dennis'), driverRole, true )
        UserAliasSecurityRole.create( Person.findByName('Erik'), adminRole, true )


        assert Person.count() == 5
        assert SecurityRole.count() == 5
        assert UserAliasSecurityRole.count() == 5
    }
}
