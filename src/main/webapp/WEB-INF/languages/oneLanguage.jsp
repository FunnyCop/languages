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
	
	<h3 id = "coner-home-link"><a href = "/languages">Home</a></h3>
	<h3>ID: <c:out value="${id}" /></h3>
	<h3>Name: <c:out value="${name}" /></h3>
	<h3>Creator: <c:out value="${creator}" /></h3>
	<h3>Version: <c:out value="${version}" /></h3>
	<h3><a href = "/languages/update/${id}">Update</a></h3>
	<h3><a href = "/languages/delete/${id}">Delete</a></h3>

</body>

</html>