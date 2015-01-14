<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1>编辑用户信息</h1>

<form:form method="POST" commandName="employee">
	<table border="1">
		<tr>
			<td>工号</td>
			<td><form:input path = "staffId" /></td>
		</tr>
		<tr>
			<td>姓名</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><input type="submit" value="新增"></td>
		</tr>
	</table>
</form:form>