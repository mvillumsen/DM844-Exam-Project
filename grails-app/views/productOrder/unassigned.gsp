<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 28/04/15
  Time: 21:24
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Unassigned orders</title>
</head>

<body>
<section>
    These orders are waiting to be handled.
    <g:each in="${productOrderInstanceList}" status="i" var="productOrderInstance">
        <li class="${(i % 2) == 0 ? 'even' : 'odd'}">

            <g:render template="productOrderRow" model="productOrderInstance" />

        </li>
    </g:each>
</section>
</body>
</html>