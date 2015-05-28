<section class="orderView">
<tb:label><h4><g:message code="address.delivery"/></h4></tb:label>
<tb:address cssClasses="address">
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="delivery.name.label"/>:</strong></tb:label></tb:col2>
        <tb:col8>${order.customer.name}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="delivery.address1.label"/>:</strong></tb:label></tb:col2>
        <tb:col8>${order.address.address1}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="delivery.address2.label"/>:</strong></tb:label></tb:col2>
        <tb:col8> ${order.address.address2}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="delivery.address.zipCode"/>:</strong></tb:label></tb:col2>
        <tb:col8>${order.address.zipCode}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="delivery.address.city"/>:</strong></tb:label></tb:col2>
        <tb:col8>${order.address.city}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="delivery.address.country"/>:</strong></tb:label></tb:col2>
        <tb:col8>${order.address.country}</tb:col8>
    </tb:row>
</tb:address>
<tb:tableStriped>
    <thead>
    <tr>
        <th><g:message code="shoppingCart.product"/></th>
        <th><g:message code="shoppingCart.amount"/></th>
        <th><g:message code="product.price"/></th>
        <th><g:message code="shoppingCart.total"/></th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${order.orderEntries}" var="entry">
        <tr>
            <td>
                ${entry.product}
            </td>
            <td>
                x ${entry.amount}
            </td>
            <td>
                <sc:price>
                    ${entry.product.price}
                </sc:price>
            </td>
            <td>
                <sc:price>
                    ${entry.product.price * entry.amount}
                </sc:price>
            </td>
        </tr>
    </g:each>
    </tbody>
    <tfoot>
    <tr>
        <td><g:message code="shoppingCart.total"/></td>
        <td/>
        <td/>
        <td>
            <sc:price><po:calcTotalPrice order="${order}"/></sc:price>
        </td>
    </tr>
    </tfoot>
</tb:tableStriped>
</section>