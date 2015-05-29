<td>
    <g:fieldValue field="id" bean="${productOrderInstance}"/>
</td>

<td>
    <g:fieldValue field="address" bean="${productOrderInstance}"/>
</td>

<td>
    <g:fieldValue field="dateCreated" bean="${productOrderInstance}"/>
</td>

<td>
    <g:link controller="person" action="show"
            id="${productOrderInstance.customer.id}">${fieldValue(bean: productOrderInstance, field: "customer")}</g:link>
</td>
