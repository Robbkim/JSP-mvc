<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*"%>
<!--  result.jsp -->
<html>
<head>
	<title>���ð��</title>
</head>
<body>
	<h1>�а� ���ÿ� ���� ���</h1>
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