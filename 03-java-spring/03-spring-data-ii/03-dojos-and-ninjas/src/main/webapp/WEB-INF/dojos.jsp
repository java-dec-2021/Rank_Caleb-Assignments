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
    <title>Dojos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container row">

<div class="col">
    <h1>New Dojo</h1>
    <form:form action="/dojos/new" method="post" modelAttribute="dojo">
        <div class="row">
            <label for="name" class="col label-control">Name:</label>
            <form:errors path="name"/>
            <input type="text" name="name" class="col form-control">
        </div>
        <button class="btn shadow align-end">Create</button>
    </form:form>
</div>

<div class="col">
    <table class="table table-striped table-active">
        <thead>
            <th>Dojo Name</th>
            <th>Dojo ID</th>
        </thead>
        <tbody>
            <c:forEach var="dojo" items="${dojos}">
                <tr>
                    <td><c:out value="${ dojo.name }"/></td>
                    <td><c:out value="${ dojo.id }"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</div>
</body>
<html>