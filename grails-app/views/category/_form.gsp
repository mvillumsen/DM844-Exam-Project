<%@ page import="dk.dm844.webshop.Category" %>

<tb:col12>

<%-- Name --%>
    <tb:formGroup>
        <tb:col2 cssClasses="deliveryAddress">
            <tb:label><strong><g:message code="category.name.label"/></strong>:</tb:label>
        </tb:col2>
        <tb:col8>
            <tb:inputForm id="name" name="name" type="text" placeholder="${g.message(code: "category.name.label")}" value="${categoryInstance?.name}" required="required"/>
        </tb:col8>
    </tb:formGroup>

<%-- Description --%>
    <tb:formGroup>
        <tb:col2 cssClasses="deliveryAddress">
            <tb:label><strong><g:message code="category.description.label"/></strong>:</tb:label>
        </tb:col2>
        <tb:col8>
            <g:textArea class="form-control" name="description" placeholder="${g.message(code: "category.description.label")}" value="${categoryInstance?.description}"/>
        </tb:col8>
    </tb:formGroup>
</tb:col12>
