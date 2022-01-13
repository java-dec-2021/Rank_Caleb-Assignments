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
    <title>Show Dormitory</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container">

<div class="row">
    <h1><c:out value="${ dorm.name }"/></h1>
    <form:form action="/dorms/${dorm.id}/add" method="post" modelAttribute="dorm">
        <div class="row">
            <label for="student" class="col label-control">Name:</label>
            <form:errors path="student"/>
            <select name="student" class="col form-select">
                <c:forEach var="s" items="${students}">
                    <option value="${ s.id }"><c:out value="${ s.firstName } ${ s.lastName }"/></option>
                </c:forEach>
            </select>
        </div>
        <button class="btn shadow align-end">Add</button>
    </form:form>
</div>

<div class="row">
    <table class="table table-striped table-active">
        <thead>
            <th>Name</th>
            <th>Action</th>
        </thead>
        <tbody>
            <c:forEach var="s" items="${dorm.students}">
                <tr>
                    <td><c:out value="${ s.firstName } ${ s.lastName }"/></td>
                    <td><a href="/dorms/${dorm.id}/${s.id}">Remove</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</div>
</body>
<html>