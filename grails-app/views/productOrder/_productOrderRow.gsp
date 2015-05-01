<td>
    <g:fieldValue field="id" bean="${productOrderInstance}"/>
</td>

<td>
    <g:fieldValue field="status" bean="${productOrderInstance}"/>
</td>

<td>
    <g:fieldValue field="address" bean="${productOrderInstance}"/>
</td>

<td>
    <g:fieldValue field="dateCreated" bean="${productOrderInstance}"/>
</td>

<td>
    <g:link action="show"
            id="${productOrderInstance.id}">${fieldValue(bean: productOrderInstance, field: "customer")}</g:link>
</td>

<td>
    <g:link action="show"
            id="${productOrderInstance.id}">${fieldValue(bean: productOrderInstance, field: "assignedEmployee")}</g:link>
</td>
