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
    <title>New Product</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container">

<h1>New Product</h1>

<div class="row">
    <div class="col">
        <form:form action="/products/new" method="post" modelAttribute="product">
            <div class="row">
                <label for="name" class="col label-control">Name:</label>
                <form:errors path="name"/>
                <input type="text" name="name" class="col form-control">
            </div>
            <div class="row">
                <label for="description" class="col label-control">Description:</label>
                <form:errors path="description"/>
                <textarea name="description" rows="10" class="col form-control"></textarea>
            </div>
            <div class="row">
                <label for="price" class="col label-control">Price:</label>
                <form:errors path="price"/>
                <input type="text" name="price" class="col form-control">
            </div>
            <button class="btn shadow align-end">Create</button>
        </form:form>
    </div>
    
    <div class="col">
        <table class="table table-striped table-active">
            <thead>
                <th>Product Name</th>
                <th>Product ID</th>
            </thead>
            <tbody>
                <c:forEach var="p" items="${ products }">
                    <tr>
                        <td><c:out value="${ p.name }"/></td>
                        <td><c:out value="${ p.id }"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</div>
</body>
<html>