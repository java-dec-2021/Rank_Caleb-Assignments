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
    <title>Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container">

<h1>New Ninja</h1>
<form:form action="/contact/new" method="post" modelAttribute="contactInfo">
    <div class="row">
        <label for="student" class="col label-control">Student:</label>
        <form:errors path="student"/>
        <select name="student" class="col form-select">
            <c:forEach var="student" items="${students}">
                <option value="${ student.id }"><c:out value="${ student.firstName } ${ student.lastName }"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="row">
        <label for="address" class="col label-control">Address:</label>
        <form:errors path="address"/>
        <input type="text" name="address" class="col form-control">
    </div>
    <div class="row">
        <label for="city" class="col label-control">City:</label>
        <form:errors path="city"/>
        <input type="text" name="city" class="col form-control">
    </div>
    <div class="row">
        <label for="state" class="col label-control">State:</label>
        <form:errors path="state"/>
        <input type="text" name="state" class="col form-control">
    </div>
    <button class="btn shadow align-end">Create</button>
</form:form>

</div>
</body>
<html>