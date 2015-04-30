<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 28/04/15
  Time: 21:24
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="adminTemplate"/>
    <title>Ready for shipment</title>
</head>

<body>
    <section>
        These orders are ready for shipment.
        <g:render template="shipmentList" model="${[orders: orders]}" />
    </section>
</body>
</html>