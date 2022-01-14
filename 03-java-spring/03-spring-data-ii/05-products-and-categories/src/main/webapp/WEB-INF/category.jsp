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

<h1 class="row"><c:out value="${ category.name }"/></h1>

<div class="row">
    <div class="col">
        <h2>Categories</h2>
        <ul>
            <c:forEach var="p" items="${ products }">
                <li>- <c:out value="${ p.name }"/></li>
            </c:forEach>
        </ul>
    </div>

    <div class="col">
        <form:form action="/categories/${ category.id }" method="post" modelAttribute="product">
            <div class="row">
                <label for="product" class="col label-control">Add Product:</label>
                <form:errors path="product"/>
                <select name="product" class="form-select">
                    <c:forEach var="p" items="${ nonProducts }">
                        <option value="${ p.id }"><c:out value="${ p.name }"/></option>
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