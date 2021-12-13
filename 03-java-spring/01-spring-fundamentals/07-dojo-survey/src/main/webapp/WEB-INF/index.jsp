<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="/css/style.css"/>
	<title>Secret Code</title>
</head>
</head>
<body>

<div id="form">
        <h1>Dojo Survey</h1>
        <form action="/submit" method="post">
            <div class="flex row">
                <label for="name" class="flex-1">Your Name: </label>
                <input type="text" name="name" class="flex-1">
            </div>
            <div class="flex row">
                <label class="flex-1">Dojo Location: </label>
                <select name="location" class="flex-1">
                    <option value="Chicago">Chicago</option>
                    <option value="Seattle">Seattle</option>
                    <option value="Online">Online</option>
                    <option value="Burbank">Burbank</option>
                </select>
            </div>
            <div class="flex row">
                <label class="flex-1">Favorite Language: </label>
                <select name="language" class="flex-1">
                    <option value="Python">Python</option>
                    <option value="Java">Java</option>
                    <option value="MERN">MERN</option>
                    <option value="C#">C#</option>
                </select>
            </div>
            <div class="row">
                <label>Comment (optional):
                    <textarea name="comment" cols="50" rows="10" class="block"></textarea>
                </label>
                <button>Submit</button>
            </div>
        </form>
    </div>

</body>
</html>