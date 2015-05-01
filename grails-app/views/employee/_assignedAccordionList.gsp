<po:ordersAccordion id="${id}">
    <g:each in="${orders}" var="order">
        <po:orderAccordionPanel title="${order}" id="panel${order.id}" parentId="${id}">
        <%-- TODO: INDSÆT VIEW AF PRODUCT ORDER HERE! --%>
            <g:link controller="productOrder" action="finishAssignment" id="${order.id}" class="btn btn-success">
                <g:message code="employee.assignments.finish"/>
            </g:link>
        </po:orderAccordionPanel>
    </g:each>
</po:ordersAccordion>
