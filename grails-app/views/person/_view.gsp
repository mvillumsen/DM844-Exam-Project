<tb:address cssClasses="address">
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="person.username.label"
                                                                         default="Username"/></strong></tb:label></tb:col2>
        <tb:col8>${person?.username}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message
                code="delivery.name.label"/>:</strong></tb:label></tb:col2>
        <tb:col8>${person?.name}</tb:col8>
    </tb:row>

    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message
                code="delivery.address1.label"/>:</strong></tb:label></tb:col2>
        <tb:col8>${person?.address.address1}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message
                code="delivery.address2.label"/>:</strong></tb:label></tb:col2>
        <tb:col8>${person?.address.address2}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message
                code="delivery.address.zipCode"/>:</strong></tb:label></tb:col2>
        <tb:col8>${person?.address.zipCode}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message
                code="delivery.address.city"/>:</strong></tb:label></tb:col2>
        <tb:col8>${person?.address.city}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message
                code="delivery.address.country"/>:</strong></tb:label></tb:col2>
        <tb:col8>${person?.address.country}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="person.phone.label"
                                                                         default="Phone"/></strong></tb:label></tb:col2>
        <tb:col8>${person?.phone}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="person.email.label"
                                                                         default="Email"/></strong></tb:label></tb:col2>
        <tb:col8>${person?.email}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="person.salary.label"
                                                                         default="Salary"/></strong></tb:label></tb:col2>
        <tb:col8>${person?.salary}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="person.dateHired.label"
                                                                         default="Date Hired"/></strong></tb:label></tb:col2>
        <tb:col8>${person?.dateHired}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="person.dateCreated.label"
                                                                         default="Date Created"/></strong></tb:label></tb:col2>
        <tb:col8>${person?.dateCreated}</tb:col8>
    </tb:row>
    <tb:row>
        <tb:col2><tb:label cssClasses="deliveryLabel"><strong><g:message code="person.lastUpdated.label"
                                                                         default="Last Updated"/></strong></tb:label></tb:col2>
        <tb:col8>${person?.lastUpdated}</tb:col8>
    </tb:row>
</tb:address>