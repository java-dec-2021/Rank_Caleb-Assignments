<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/results.css"/>
	<title>Secret Code</title>
</head>
</head>
<body>

<div id="form">
        <h1>Submitted Info</h1>
        <div class="flex">
            <p class="flex-1">Name:</p>
            <p class="flex-1"><c:out value="${ name }"/></p>
        </div>
        <div class="flex">
            <p class="flex-1">Dojo Location:</p>
            <p class="flex-1"><c:out value="${ location }"/></p>
        </div>
        <div class="flex">
            <p class="flex-1">Favorite Language:</p>
            <p class="flex-1"><c:out value="${ language }"/></p>
        </div>
        <div class="flex">
            <p class="flex-1">Comment:</p>
            <p class="flex-1"><c:out value="${ comment }"/></p>
        </div>
        <form action="/">
            <button>Save & Exit</button>
        </form>
    </div>

</body>
</html>