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
    <form action="/languages/${language.id}" method="post" class="col">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
    <a href="/languages" class="col">Dashboard</a>
</div>

<div class="container">
    <form:form action="" method="post">
        <div class="row">
            <label for="name" class="col label-control">Name:</label>
            <form:errors path="name"/>
            <input type="text" name="name" value="${language.name}" class="col form-control">
        </div>
        <div class="row">
            <label for="creator" class="col label-control">Creator:</label>
            <form:errors path="creator"/>
            <input type="text" name="creator" value="${language.creator}" class="col form-control">
        </div>
        <div class="row">
            <label for="currentVersion" class="col label-control">Current Version:</label>
            <form:errors path="currentVersion"/>
            <input type="text" name="currentVersion" value="${language.currentVersion}" class="col form-control">
        </div>
        <button class="btn shadow align-end">Submit</button>
    </form:form>
</div>

</body>
</html>