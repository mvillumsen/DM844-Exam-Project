package dk.dm844.webshop.admin

import dk.dm844.webshop.Person
import grails.plugin.springsecurity.SpringSecurityService

class EmployeeTagLib {
    static namespace = "emp"
    static defaultEncodeAs = [taglib: 'none']

    EmployeeService employeeService
    SpringSecurityService springSecurityService

    def assignedCount = { attrs, body ->
        String cssClasses = attrs.cssClasses ?: ''
        Person person = attrs.person ?: springSecurityService.currentUser
        Integer count = employeeService.getAssignedCount(person)
        out << "<span class=\"${cssClasses}\">${count}</span>"
    }
}
