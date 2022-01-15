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

<h1 class="row">Questions Dashboard</h1>

<table class="table table-striped table-active">
    <thead>
        <th style="width: 65%;">Question</th>
        <th>Tags</th>
    </thead>
    <tbody>
        <c:forEach var="q" items="${ questions }">
            <tr>
                <td><a href="/questions/${q.id}"><c:out value="${ q.question }"/></a></td>
                <td>
                    <c:forEach var="t" items="${ q.tags }">
                        <c:out value="${ t.subject },"/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</div>
</body>
<html>