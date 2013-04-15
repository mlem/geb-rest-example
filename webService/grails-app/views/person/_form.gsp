<%@ page import="org.gebish.example.Person" %>



<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'birthday', 'error')} required">
	<label for="birthday">
		<g:message code="person.birthday.label" default="Birthday" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthday" precision="day"  value="${personInstance?.birthday}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'city', 'error')} ">
	<label for="city">
		<g:message code="person.city.label" default="City" />
		
	</label>
	<g:textField name="city" value="${personInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="person.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${personInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: personInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="person.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${personInstance?.lastName}"/>
</div>

