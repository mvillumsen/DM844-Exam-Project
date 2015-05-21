<po:ordersAccordion id="${id}">
    <g:each in="${orders}" var="order">
        <po:orderAccordionPanel title="${order} | Status: ${order.status}" id="panel${order.id}" parentId="${id}">
            <g:render template="/productOrder/view" model="${[order: order]}"/>
        </po:orderAccordionPanel>
    </g:each>
</po:ordersAccordion>
