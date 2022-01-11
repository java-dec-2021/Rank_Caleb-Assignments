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
<body style="padding: 10px 20%;">
<div class="container row">

<div class="col">
    <h1>New Ninja</h1>
    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
        <div class="row">
            <label for="dojo" class="col label-control">Dojo:</label>
            <form:errors path="dojo"/>
            <input type="text" name="dojo" class="col form-control">
        </div>
        <div class="row">
            <label for="firstName" class="col label-control">First Name:</label>
            <form:errors path="firstName"/>
            <input type="text" name="firstName" class="col form-control">
        </div>
        <div class="row">
            <label for="lastName" class="col label-control">Last Name:</label>
            <form:errors path="lastName"/>
            <input type="text" name="lastName" class="col form-control">
        </div>
        <div class="row">
            <label for="age" class="col label-control">Age:</label>
            <form:errors path="age"/>
            <input type="text" name="age" class="col form-control">
        </div>
        <button class="btn shadow align-end">Create</button>
    </form:form>
</div>

</div>
</body>
<html>