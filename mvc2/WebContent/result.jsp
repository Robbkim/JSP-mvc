<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, book.*"%>
<!-- result.jsp -->
<html>
<head>
	<title>결제페이지</title>
</head>
<body>
	<h1>도서 결제 페이지</h1>
	<hr color="blue">
	<b>주문한 도서품목</b>
	<table border="1">
		<tr>
			<th>도서제목</th>
			<th>작가</th>
			<th>단가</th>
			<th>수량</th>
			<th>가격</th>
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
			<td colspan="4" align="right">총금액</td>
			<td><%=sum%></td>
		</tr>
	</table>			
</body>
</html>
