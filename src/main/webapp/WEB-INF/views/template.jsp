<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
	response.setHeader("Pragma", "No-cache");
	response.setDateHeader("Expires", 1);
%>
<!DOCTYPE HTML>
<html>
<body>
	<tiles:insertAttribute name="header" />
	<hr>
	<tiles:insertAttribute name="body" />
	<hr>
	<tiles:insertAttribute name="footer" />
</body>
</html>