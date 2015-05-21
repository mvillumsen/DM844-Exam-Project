<po:ordersAccordion id="${id}">
    <g:each in="${orders}" var="order">
        <po:orderAccordionPanel title="${order} | Status: ${order.status}" id="panel${order.id}" parentId="${id}">
            <g:render template="/productOrder/view" model="${[order: order]}"/>
            <g:link controller="productOrder" action="finishAssignment" id="${order.id}" class="btn btn-success">
                <g:message code="employee.assignments.finish"/>
            </g:link>
        </po:orderAccordionPanel>
    </g:each>
</po:ordersAccordion>
