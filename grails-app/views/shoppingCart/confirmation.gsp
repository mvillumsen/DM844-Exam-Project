<%--
  Created by IntelliJ IDEA.
  User: martin
  Date: 29/04/15
  Time: 15:34
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="template">
    <title><g:message code="productOrder.comfirmation.title.label" /></title>
</head>

<body>
    Thank you for your order!
    <section>
        <dl>
            <dt><g:message code="productOrder.id.label" /></dt>
            <dd>${order.id}</dd>

            <dt><g:message code="productOrder.address.label" /></dt>
            <dd>${order.address}</dd>

            <dt><g:message code="productOrder.entries.label" /></dt>
            <dd>
                <ul>
                    <g:each in="${order.orderEntries}" var="entry">
                        <li>${entry}</li>
                    </g:each>
                </ul>
            </dd>
        </dl>
    </section>
</body>
</html>