<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Secret Code</title>
</head>
</head>
<body>

<div class="container items-align-center">
	<h3 class="danger"><c:out value="${error}"/></h3>
	<form action="/submit" method="post">
		<label for="code" class="label-control">What is the code?</label>
		<input type="text" name="code" class="form-control"/>
		<button class="btn shadow">Try Code</button>
	</form>
</div>

</body>
</html>