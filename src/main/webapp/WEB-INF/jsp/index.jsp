<%@ include file="common/header.jsp" %>

	<div class="link">
		<h2>Create User</h2>
		<c:if test="${status == 'success'}">
			<p class="success">User Created Successfully</p>
		</c:if>
		<c:if test="${status == 'exist'}">
			<p class="error">User Already Exist</p>
		</c:if>
		<form:form modelAttribute="user" action="/Spring3Hibernate4/user" method="post">
		<form:label path="userName">User Name</form:label><form:input path="userName" />
		<form:label path="firstName">First Name</form:label><form:input path="firstName" />
		<form:label path="lastName">Last Name</form:label><form:input path="lastName" />
		<form:label path="password">Password</form:label><form:password  path="password" />
		<button type="submit">Save User</button>
		</form:form>
	</div>

<%@ include file="common/footer.jsp" %>
