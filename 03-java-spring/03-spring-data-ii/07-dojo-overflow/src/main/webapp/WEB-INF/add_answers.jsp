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

<h1 class="row mb-5"><c:out value="${ question.question }"/></h1>

<div class="row">
    <div class="col" style="margin-right: 5%;">
        <div class="row">
            <h2 class="col">Tags: </h2>
            <c:forEach var="t" items="${ question.tags }">
                <a href="#" style="margin-left: 5px;" class="btn shadow col">
                    <c:out value="${t.subject}"/>
                </a>
            </c:forEach>
        </div>
        <div class="row mt-5">
            <table class="table table-striped table-active">
                <thead>
                    <th>Answers</th>
                </thead>
                <tbody>
                    <c:forEach var="a" items="${ question.answers }">
                        <tr>
                            <td><c:out value="${ a.answer }"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col" style="margin-left: 5%;">
        <h2 class="row">Add your answer:</h2>
        
        <form:form action="/questions/${question.id}" method="post" modelAttribute="answer">
            <div class="row">
                <label for="answer" class="col-3 label-control">Answer:</label>
                <form:errors path="answer"/>
                <textarea name="answer" rows="7" class="col form-control"></textarea>
            </div>
            <button class="btn shadow align-end">Answer It!</button>
        </form:form>
    </div>
</div>

</div>
</body>
<html>