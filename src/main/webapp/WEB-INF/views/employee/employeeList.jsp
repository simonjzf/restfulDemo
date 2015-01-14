<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>雇员列表</title>
</head>
<body>
<table border=1>
	<thead>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>邮箱</th>
		</tr>
	</thead>		
	<c:forEach var="employee" items="${employeeList}">
	<tr>
		<td><a href="<c:url value="/content/employee/${employee.staffId }" />"><c:out value="${employee.staffId}" /></a></td>
		<td><c:out value="${employee.name}" /></td>
		<td><c:out value="${employee.email}" /></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>