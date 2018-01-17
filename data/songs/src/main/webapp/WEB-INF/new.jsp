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
		<form:form method="POST" action="/songs/new/new" modelAttribute="language">
				
		<form:label path="title">title
			<form:errors path="title"/>
			<form:input path="title"/></form:label>

			<form:label path="artist">artist
			<form:errors path="artist"/>
			<form:input path="artist"/></form:label>

			<form:label path="rating">rating (1-10)
			<form:errors path="rating"/>
			<form:input path="rating"/></form:label>

			<input type="submit" value="Add Song"/>

		</form:form>
	</body>
</html>