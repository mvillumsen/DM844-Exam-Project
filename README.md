# Exam Project for DM844 Web Development with Groovy and Grails

This is an exam project made for the course DM844 Web Development with Groovy and Grails at IMADA, University of Southern Denmark, taught by [Jacob Aae Mikkelse](http://grydeske.net). The project was made in colaboration with two co-students. The purpose of the course was to learn the use of good craftmanship for software development. The main goals of this project was to:

* Design and implement an application in an MVC framework (using [Groovy](http://www.groovy-lang.org) and [Grails](https://grails.org))
* Implement testing of the code (using [Spock](http://spockframework.org/spock/docs/1.1-rc-2/index.html) and [Geb](http://www.gebish.org))
* Apply and demonstrate the use of tools for static code analysis (using [CodeNarc](http://codenarc.sourceforge.net))
* Apply and demonstrate the use of tools for test coverage (using [Cobertura](http://cobertura.github.io/cobertura/))
* Configure a cloud based hosting server for a web application (using [DigitalOcean](https://www.digitalocean.com))
* Use continous integration and automate the process of testing and deploying the application (using [Jenking](https://jenkins.io))

## Project Idea

The goal of this project was to build a simple webshop consisting of aa admin interface for employees and a frontend for customers.

The admin interface is used to assign product orders to employees that are suited for handling specific parts of orders (e.g. packing, delivery, etc.) and completeing them.

The frontend must allow users to select products and place orders.

## Build
In order to build and run this project you need to have Groovy and Grails installed.

In order to run this application locally, navigate to the root of this project and run `grails run-app`.

