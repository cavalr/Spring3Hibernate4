<%@ include file="common/header.jsp" %>

	<div class="link">
		<h2>Create User</h2>
		<c:if test="${saved == 'success'}">
			<p class="success">User Created Successfully</p>
		</c:if>
		<c:if test="${deleted == 'success'}">
			<p class="success">User Deleted Successfully</p>
		</c:if>
		<c:if test="${status == 'exist'}">
			<p class="error">User Already Exist</p>
		</c:if>
		<form:form modelAttribute="user" action="/Spring3Hibernate4/create" method="post">
			<form:label path="userName">User Name</form:label><form:input path="userName" />
			<form:label path="firstName">First Name</form:label><form:input path="firstName" />
			<form:label path="lastName">Last Name</form:label><form:input path="lastName" />
			<form:label path="password">Password</form:label><form:password  path="password" />
			<button type="submit" id="save">Save User</button><button type="submit" id="search">Search User</button>
		</form:form>
	</div>

	<c:if test="${not empty users}">
	<table>	
	<tr>
	<th>User Name</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th colspan="2">Actions</th>
	</tr>
	<c:forEach var="current" items="${users}">
		<tr>
		<td>${current.userName}</td>
		<td>${current.firstName}</td>
		<td>${current.lastName}</td>
		<td><a href="/Spring3Hibernate4/edit/${current.userName}">Edit</a></td>
		<td><a href="/Spring3Hibernate4/delete/${current.userName}">Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	</c:if>

<script type="text/javascript">

	$(function() {
		$("#save").click(function(event) {
        	$("#user").attr("action", "/Spring3Hibernate4/create")
			$("#user").submit();
		});

		$("#search").click(function(event) {
        	$("#user").attr("action", "/Spring3Hibernate4/search")
			$("#user").submit();

		});
	});
</script>

<%@ include file="common/footer.jsp" %>
