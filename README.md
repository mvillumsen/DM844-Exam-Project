# README #

This project is for the course DM844 at SDU from group 05.

### Business idea: ###

The goal of this project is to build a simple webshop consisting of a back-end
for employees, and a front end for customers.

The back-end is used to assign product orders to employees that are suited for 
handling specific (parts of) orders, and completeing them.

The front-end must allow users to select products and make orders.

## Comments for project 1

* Fine modelling and description
* You have not tagged the release or branched it (at least not described in the report)
* Short but relevant coding style guide
* No login for jenkins provided, but otherwise ok setup
* For product, the constraints are not properly tested (stock)
* Be carefull with your toString methods. They should also be tested, and not throw exceptions

## Comments for project 2

* Funny usage of role names. I would think a customer should be allowed to order items?
* Wireframes not in report
* Only 1 weekly report received in the 4 week span
* Access to database in view - not allowed.
* You have not extracted the bootstrap specific classes to a taglib. This is not dry, and harder to maintain.
* You could have desribed the use of the shopping cart plugin
* You violate your own coding guidelines
* Lots of violations in codenarc
* Test failing at time of handing in
* As you conclude yourself, this part of the project is not quite done - not able to complete an order :(
* Check the commit for a few comments placed in the code

## Info
* Test-reports: 188.226.206.170/test-reports/standard
* Test-reports (Code Coverage): http://188.226.206.170/test-reports/cobertura/
* Test-reports (CodeNarc): http://188.226.206.170/test-reports/codenarc
* Jenkins: 188.226.206.170:8090/jenkins/
* Tomcat: 188.226.206.170:8080

## Deployed Web App
* Available at: http://188.226.206.170
### Users:
* Admin
    * Username: erik
    * Password: er456
* Driver
    * Username: den
    * Password: de456
* Packer
    * Username: cas
    * Password: ca345
* Customer
    * Username: alice
    * Password: al123