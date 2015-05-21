<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <title><g:message code="productOrder.completed" /></title>
</head>

<body>
<section>
    <tb:pLeadText><g:message code="productOrder.shippedToCustomer" /></tb:pLeadText>

    <g:if test="${orders.size() > 0}">
        <g:render template="accordionList" model="${[orders: orders, id: "packingAccordion"]}"/>
    </g:if>
    <g:else>
        <g:message code="productOrder.noOrders" />
    </g:else>

</section>
</body>
</html>
