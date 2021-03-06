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
		<table>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${languages}" var="language" varStatus="loop">
				<tr>    
					<td><a href="/languages/${loop.index}"><c:out value="${language.name}"/></a></td>
					<td><c:out value="${language.creator}"/></td>
					<td><c:out value="${language.version}"/></td>
					<td><a href="/languages/delete/${loop.index}">delete</a>  |  <a href="/languages/edit/${loop.index}">edit</a></td>
				</tr>
			</c:forEach>
		</table>

		<form:form method="POST" action="/languages/new" modelAttribute="language">
			<form:label path="name">Name
			<form:errors path="name"/>
			<form:input path="name"/></form:label>

			<form:label path="creator">Creator
			<form:errors path="creator"/>
			<form:input path="creator"/></form:label>

			<form:label path="version">Version
			<form:errors path="version"/>
			<form:input path="version"/></form:label>

			<input type="submit" value="Submit"/>

		</form:form>
	</body>
</html>