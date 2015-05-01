<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 28/04/15
  Time: 21:23
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <title>Completed</title>
</head>

<body>
<section>
    <tb:pLeadText>These orders have been handled and shipped off to the customer.</tb:pLeadText>
    <tb:table cssClasses="table-hover table-striped">
        <thead>
        <tr>
            <th><g:message code="productOrder.id.label"/></th>
            <th><g:message code="productOrder.status.label"/></th>
            <th><g:message code="productOrder.address.label"/></th>
            <th><g:message code="productOrder.dateCreated.label"/></th>
            <th><g:message code="productOrder.customer.label"/></th>
            <th><g:message code="productOrder.assignedEmployee.label"/></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${orders}" status="i" var="order">
            <tr>
                <g:render template="/productOrder/productOrderRow" model="${[productOrderInstance: order]}"/>
            </tr>
        </g:each>
        </tbody>
    </tb:table>
</section>
</body>
</html>