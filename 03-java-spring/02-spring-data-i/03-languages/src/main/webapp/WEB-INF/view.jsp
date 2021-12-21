<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${language.name}</title>
</head>
<body style="padding: 20px 20%;">

<div class="row align-end">
    <a href="/languages">Dashboard</a>
</div>

<h1><c:out value="${language.name}"/></h1>
<p>Description: <c:out value="${language.creator}"/></p>
<p>Language: <c:out value="${language.currentVersion}"/></p>

<a href="/languages/edit/${language.id}">Edit Book</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>

</body>
</html>