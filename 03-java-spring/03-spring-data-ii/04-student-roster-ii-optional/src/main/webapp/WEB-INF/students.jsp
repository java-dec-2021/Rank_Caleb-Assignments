<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Students</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container row">

<table class="table table-striped table-active">
    <thead>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
        <th>City</th>
        <th>State</th>
    </thead>
    <tbody>
        <c:forEach var="student" items="${students}">
            <tr>
                <td><c:out value="${ student.firstName }"/> <c:out value="${ student.lastName }"/></td>
                <td><c:out value="${ student.age }"/></td>
                <td><c:out value="${ student.contactInfo.address }"/></td>
                <td><c:out value="${ student.contactInfo.city }"/></td>
                <td><c:out value="${ student.contactInfo.state }"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</div>
</body>
<html>