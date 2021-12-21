<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<title>Languages</title>
</head>
<body style="padding: 20px 20%;">

<table class="table table-active table-striped table-bordered">
    <thead>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
        <th>action</th>
    </thead>
    <tbody>
        <c:forEach var="language" items="${languages}">
            <tr>
                <td><a href="/languages/${language.id}"><c:out value="%{ language.name }"/></a></td>
                <td><c:out value="%{ language.creator }"/></td>
                <td><c:out value="%{ language.currentVersion }"/></td>
                <td class="row">
                    <form action="/languages/${language.id}" method="post" class="col">
                        <input type="hidden" name="_method" value="delete">
                        <input type="submit" value="Delete">
                    </form>
                    <a href="/languages/edit/${language.id}" class="col">Edit Book</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name" class="label-control">Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name" class="form-control"/>
    </p>
    <p>
        <form:label path="creator" class="col label-control">Creator:</form:label>
        <form:errors path="creator"/>
        <form:input type="text" path="creator" class="col form-control"/>
    </p>
    <p>
        <form:label path="currentVersion" class="col label-control">Current Version:</form:label>
        <form:errors path="currentVersion"/>
        <form:input type="text" path="currentVersion" class="col form-control"/>
    </p>
    <input type="submit" value="Submit" class="btn shadow"/>
</form:form>

</body>
</html>