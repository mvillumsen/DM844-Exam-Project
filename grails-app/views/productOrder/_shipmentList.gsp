<tb:table cssClasses="table-hover table-striped">
    <thead>
    <tr>
        <th><g:message code="productOrder.id.label"/></th>
        <th><g:message code="productOrder.address.label"/></th>
        <th><g:message code="productOrder.dateCreated.label"/></th>
        <th><g:message code="productOrder.customer.label"/></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${orders}" status="i" var="order">
        <tr>
            <g:render template="/productOrder/productOrderRow" model="${[productOrderInstance: order]}"/>

            <td>
                <g:link action="assignShipment" id="${order.id}">
                    <g:message code="productOrder.assignEmployee"/>
                </g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</tb:table>