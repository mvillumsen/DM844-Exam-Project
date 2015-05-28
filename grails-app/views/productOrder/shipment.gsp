<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <title><g:message code="productOrder.orders.shipment.label" /></title>
</head>

<body>
<section>
    <tb:pLeadText><g:message code="productOrder.orders.shipment" /></tb:pLeadText>
    <g:render template="shipmentList" model="${[orders: orders]}"/>
</section>
</body>
</html>