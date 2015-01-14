<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1>员工列表</h1>

<form:form commandName="employee" method="DELETE" action="${employee.staffId}"></form:form>
<table border="1">
	<tr>
		<td>工号</td>
		<td>${employee.staffId }</td>
	</tr>
	<tr>
		<td>姓名</td>
		<td>${employee.name }</td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td>${employee.email }</td>
	</tr>
	<tr>
		<td colspan="2"><a href="<c:url value="${employee.staffId }/edit" />">更新</a>/ <a href="" onclick="if (confirm('您确定要删除选中的问题吗？')) {employee.submit();};return false;">删除</a></td>
	</tr>
</table>
