<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 28/04/15
  Time: 21:24
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="template">
    <title>Ready for packaging</title>
</head>

<body>
<section>
    These orders are ready for shipment.
    <g:render template="packingList" model="${[orders: orders]}" />
</section>
</body>
</html>