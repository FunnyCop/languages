<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <title>Languages</title>
    
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <!-- <script type = "text/js" src = "/js/script.js"></script> -->
    <link rel = "stylesheet" type = "text/css" href = "/css/index.css" />
    <link rel = "stylesheet" type = "text/css" href = "/css/languages.css" />
</head>

<body>

	<table class = "table" id = "language-table">
		<thead class = "thead-dark">
			<tr>
				<th scope = "col">ID</th>
				<th scope = "col">Name</th>
				<th scope = "col">Creator</th>
				<th scope = "col">Version</th>
				<th scope = "col">Actions</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${languages}" var="language">
				<tr>
					<th scope = "row"><c:out value="${language.id}" /></th>
					<td><a href = "/languages/id/${language.id}"><c:out value="${language.name}" /></a></td>
					<td><c:out value="${language.creator}" /></td>
					<td><c:out value="${language.version}" /></td>
					<td>
						<div>
							<a href = "/languages/update/${language.id}">Update</a>
							<p> | </p>
							<a href = "/languages/delete/${language.id}">Delete</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action = "/languages/create" method = "post" modelAttribute = "language" class = "form-group" id = "create-language">

		<form:label path = "name">Name</form:label>
		<form:errors path = "name" style = "color: red;" />
		<form:input path = "name" class = "form-control" required = "true" />
		
		<form:label path = "creator">Creator</form:label>
		<form:errors path = "creator" style = "color: red;" />
		<form:input path = "creator" class = "form-control" required = "true" />
		
		<form:label path = "version">Version</form:label>
		<form:errors path = "version" style = "color: red;" />
		<form:input path = "version" class = "form-control" required = "true" />
		
		<form:button class = "btn btn-primary">Submit</form:button>

    </form:form>

</body>

</html>