<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, book.*"%>
<!-- result.jsp -->
<html>
<head>
	<title>����������</title>
</head>
<body>
	<h1>���� ���� ������</h1>
	<hr color="blue">
	<b>�ֹ��� ����ǰ��</b>
	<table border="1">
		<tr>
			<th>��������</th>
			<th>�۰�</th>
			<th>�ܰ�</th>
			<th>����</th>
			<th>����</th>
		</tr>
<%
			Hashtable<String, BookDTO> ht = (Hashtable)request.getAttribute("check");
			int sum = 0;
			Enumeration<String> enu = ht.keys();
			while(enu.hasMoreElements()){
				String key = enu.nextElement();
				BookDTO dto = ht.get(key);
				int price = dto.getPrice() * dto.getQty();
				sum += price;
%>
		<tr>
			<td><%=dto.getTitle()%></td>
			<td><%=dto.getAuthor()%></td>
			<td><%=dto.getPrice()%></td>
			<td><%=dto.getQty()%></td>
			<td><%=price%></td>
		</tr>
<%		} %>
		<tr>
			<td colspan="4" align="right">�ѱݾ�</td>
			<td><%=sum%></td>
		</tr>
	</table>			
</body>
</html>
