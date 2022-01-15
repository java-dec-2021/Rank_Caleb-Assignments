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
    <title>Category Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container">

<h1 class="row">What is your question?</h1>

<div class="row">
    <form:form action="/questions/new" method="post" modelAttribute="question">
        <div class="row">
            <label for="question" class="col label-control">Question:</label>
            <form:errors path="question"/>
            <textarea name="question" rows="10" class=" col form-control"></textarea>
        </div>
        <div class="row">
            <label for="tags" class="col label-control">Tags:</label>
            <form:errors path="tags"/>
            <input type="text" name="tags" class="col form-control">
        </div>
        <button class="btn shadow align-end">Submit</button>
    </form:form>
</div>

</div>
</body>
<html>