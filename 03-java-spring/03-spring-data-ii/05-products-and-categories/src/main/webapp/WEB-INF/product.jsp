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
    <title>Product Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 30px 20%;">
<div class="container">

<h1 class="row"><c:out value="${ product.name }"/></h1>

<div class="row">
    <div class="col">
        <h2>Categories</h2>
        <ul>
            <c:forEach var="c" items="${ categories }">
                <li>- <c:out value="${ c.name }"/></li>
            </c:forEach>
        </ul>
    </div>

    <div class="col">
        <form:form action="/products/${ product.id }" method="post" modelAttribute="category">
            <div class="row">
                <label for="category" class="col label-control">Add Category:</label>
                <form:errors path="category"/>
                <select name="category" class="form-select">
                    <c:forEach var="c" items="${ nonCategories }">
                        <option value="${ c.id }"><c:out value="${ c.name }"/></option>
                    </c:forEach>
                </select>
            </div>
            <button class="btn shadow align-end">Add</button>
        </form:form>
    </div>
</div>

</div>
</body>
<html>