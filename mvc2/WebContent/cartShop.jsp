<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, book.*, java.text.*"%>
<!-- cartShop.jsp -->
<%
		ArrayList<BookDTO> list = (ArrayList)session.getAttribute("cart");
		if(list != null && list.size() !=0) {
%>
<hr color="red">
<b>현재 주문한 도서내역</b>
<table border="1">
	<tr>
		<th>도서제목</th>
		<th>작가</th>
		<th>가격</th>
		<th>수량</th>
		<th>삭제</th>
	</tr>
<%
		DecimalFormat df = new DecimalFormat("###,###");
		//10진수를 내가 원하는 모습으로 나타내게 하는 클래스 : ###,###패턴은 3자리마다 , 를 찍어주세요
		for(int i=0; i<list.size(); ++i){
			BookDTO dto = list.get(i); %>
	<tr>
		<td><%=dto.getTitle() %></td>
		<td><%=dto.getAuthor() %></td>
		<td align="right"><%=df.format(dto.getPrice())%>원</td>
		<td align="right"><%=dto.getQty()%>개</td>	
		<td>
			<form name="del" action="bookShop.do" method="post">
				<input type="hidden" name="index" value="<%=i%>"/>
				<input type="hidden" name="command" value="DEL"/>
				<input type="submit" value="삭제">
			</form>
	</tr>
<% 	} //for end
%>
</table>
<form name="chk" action="bookShop.do" method="post">
	<input type="hidden" name="command" value="CHK"/>
	<input type="submit" value="도서결재페이지로 이동">
</form>
<%
      } //list != null 하는 부분의 if end 
%>


