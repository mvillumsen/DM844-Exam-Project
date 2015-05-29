<%@ page import="dk.dm844.webshop.SecurityRole" %>
<%@ page import="dk.dm844.webshop.Person" %>

<%-- First Column --%>
<tb:colMd6Xs12>

<%-- Full name --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="name"><strong><g:message code="delivery.name.label"/>:</strong></tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="name" name="name" type="text" placeholder="${g.message(code: "delivery.name.label")}" value="${personInstance?.name}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Address1 --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="address1"><strong><g:message code="delivery.address1.label"/>:</strong></tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="address1" name="address1" type="address" placeholder="${g.message(code: "delivery.address1.label")}" value="${personInstance?.address?.address1}"/>
        </tb:col8>
    </tb:formGroup>

<%-- ZipCode --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="zipCode"><strong><g:message code="delivery.address.zipCode"/>:</strong></tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="zipCode" name="zipCode" type="text" placeholder="${g.message(code: "delivery.address.zipCode")}" value="${personInstance?.address?.zipCode}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Country --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="country"><strong><g:message code="delivery.address.country"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <g:select class="form-control" name="country" from="${Country.values()}" optionKey="key" valueMessagePrefix="enum.country" value="${personInstance?.address?.country}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Username --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="username"><strong><g:message code="person.username.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="username" name="username" type="username" placeholder="${g.message(code: "person.username.label")}" value="${personInstance?.username}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Salary --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="salary"><strong><g:message code="person.salary.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="salary" name="salary" type="number" placeholder="${g.message(code: "person.salary.label")}" value="${personInstance?.salary}"/>
        </tb:col8>
    </tb:formGroup>



</tb:colMd6Xs12>

<%-- Second Column --%>
<tb:colMd6Xs12>

<%-- E-Mail --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="email"><strong><g:message code="person.email.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="email" name="email" type="email" placeholder="${g.message(code: "person.email.label")}" value="${personInstance?.email}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Address2--%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="address2"><strong><g:message code="delivery.address2.label"/>:</strong></tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="address2" name="address2" type="text" placeholder="${g.message(code: "delivery.address2.label")}" value="${personInstance?.address?.address2}"/>
        </tb:col8>
    </tb:formGroup>

<%-- City --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="city"><strong><g:message code="delivery.address.city"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="city" name="city" type="text" placeholder="${g.message(code: "delivery.address.city")}" value="${personInstance?.address?.city}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Phone --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="phone"><strong><g:message code="person.phone.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="phone" name="phone" type="tel" placeholder="${g.message(code: "person.phone.label")}" value="${personInstance?.phone}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Password --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="password"><strong><g:message code="person.password.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <tb:inputForm id="password" name="password" type="password" placeholder="${g.message(code: "person.password.label")}" value="${personInstance?.password}"/>
        </tb:col8>
    </tb:formGroup>

<%-- Role --%>
    <tb:formGroup>
        <tb:col3 cssClasses="deliveryAddress">
            <tb:label cssClasses="deliveryLabel" for="Role"><strong><g:message code="person.role.label"/></strong>:</tb:label>
        </tb:col3>
        <tb:col8>
            <person:getRole person="${personInstance}">
                <g:select class="form-control" name="Role" from="${SecurityRole.Role.values()}" optionKey="key" valueMessagePrefix="enum.userRole" value="${it?.getKey()}"/>
            </person:getRole>
        </tb:col8>
    </tb:formGroup>
</tb:colMd6Xs12>
