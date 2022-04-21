<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<!--  result.jsp -->
<html>
<head>
	<title>선택결과</title>
</head>
<body>
	<h1>학과 선택에 따른 결과</h1>
<%
		List<String> list = (List)request.getAttribute("advice");
		for(String msg : list){
%>
			<h2><%=msg%></h2>
<% 
		}
%>
</body>
</html>