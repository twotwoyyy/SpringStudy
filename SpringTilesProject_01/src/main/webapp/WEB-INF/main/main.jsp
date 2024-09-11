<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border=1 bordercolor=black width=800 height=700>
			<tr>
				<td align="center" colspan="2" height="100">
					<tiles:insertAttribute name="header"/>
				</td>
			</tr>
			<tr>
				<td align="center" height="500" width="200">
					<tiles:insertAttribute name="nav"/>
				</td>
				<td align="center" height="500" width="600">
				<%--
					<jsp:include ~>
				 --%>
					<tiles:insertAttribute name="content"/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2" height="100">
					<tiles:insertAttribute name="footer"/>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>