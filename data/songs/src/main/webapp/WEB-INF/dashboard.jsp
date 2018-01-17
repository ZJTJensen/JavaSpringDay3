<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">	
		<script src="/js/main.js"></script>
	</head>

	<body>
		<a href="/songs/new">Add a song</a>
		<a href="/dashboard/topTen">Top ten songs</a>
		<form method ="POST" action="/searh">
		<label>Search: <input name="search"><input type="submit" value="search"></label>
		</form>

		<div>
			<table>
				<th>
					<tr>Name</tr>
					<tr>Rating</tr>
					<tr>Actions</tr>
				</th>
				<c:forEach items="${songs}" var="song" varStatus="loop">
				<tr>    
					<td> <a href="/songs/${loop.index}"><c:out value="${song.title}"/></a></td>
					<td><c:out value="${song.rating}"/></td>
					<td><a href="/dashboard/delete/${loop.index}">delete</a>  </td>
				</tr>
			</c:forEach>
			</table>
		</div>
	</body>
</html>