<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.util.*, book.*, java.text.*"%>
<!-- cartShop.jsp -->
<%
		ArrayList<BookDTO> list = (ArrayList)session.getAttribute("cart");
		if(list != null && list.size() !=0) {
%>
<hr color="red">
<b>���� �ֹ��� ��������</b>
<table border="1">
	<tr>
		<th>��������</th>
		<th>�۰�</th>
		<th>����</th>
		<th>����</th>
		<th>����</th>
	</tr>
<%
		DecimalFormat df = new DecimalFormat("###,###");
		//10������ ���� ���ϴ� ������� ��Ÿ���� �ϴ� Ŭ���� : ###,###������ 3�ڸ����� , �� ����ּ���
		for(int i=0; i<list.size(); ++i){
			BookDTO dto = list.get(i); %>
	<tr>
		<td><%=dto.getTitle() %></td>
		<td><%=dto.getAuthor() %></td>
		<td align="right"><%=df.format(dto.getPrice())%>��</td>
		<td align="right"><%=dto.getQty()%>��</td>	
		<td>
			<form name="del" action="bookShop.do" method="post">
				<input type="hidden" name="index" value="<%=i%>"/>
				<input type="hidden" name="command" value="DEL"/>
				<input type="submit" value="����">
			</form>
	</tr>
<% 	} //for end
%>
</table>
<form name="chk" action="bookShop.do" method="post">
	<input type="hidden" name="command" value="CHK"/>
	<input type="submit" value="���������������� �̵�">
</form>
<%
      } //list != null �ϴ� �κ��� if end 
%>


