<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <title><g:message code="productOrder.ready"/></title>
</head>

<body>
<section>
    <tb:pLeadText><g:message code="productOrder.orders.ready"/></tb:pLeadText>
    <g:render template="packingList" model="${[orders: orders]}"/>
</section>
</body>
</html>