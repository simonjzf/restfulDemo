<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Users</h1>
<table border="1">
	<thead>
		<tr>
			<td>Staff Id</td>
			<td>Name</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><a href="<c:url value="/content/user/${user.staffid }" />"><c:out value="${user.staffid }" /></a></td>
				<td><c:out value="${user.name }" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
