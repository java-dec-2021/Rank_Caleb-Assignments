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
    <title>New Category</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container">

<h1>New Category</h1>

<div class="row">
    <div class="col">
        <form:form action="/categories/new" method="post" modelAttribute="category">
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
                <th>Category Name</th>
                <th>Category ID</th>
            </thead>
            <tbody>
                <c:forEach var="c" items="${ categories }">
                    <tr>
                        <td><c:out value="${ c.name }"/></td>
                        <td><c:out value="${ c.id }"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</div>
</body>
<html>