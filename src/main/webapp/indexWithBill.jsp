<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.example.demo.model.*"%>
   <jsp:include page="index.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div margin='10px' align="center" >
<br>
<% List<BillProduct> a = (List<BillProduct>)request.getAttribute("bill");%>

<table  class="table table-striped" >
	<tr>
	<th>S. No.</th>
	<th>Product</th>
	<th>Quantity</th>
	<th>Price</th>
	</tr>
	<%for(BillProduct p:a){ %>
	<tr>
	<td><%=p.getSerialNumber() %></td>
	<td><%=p.getProductName() %></td>
	<td><%=p.getQuantity() %>
	<td><%=p.getProductPrice() %></td>
	</tr>
	<%} %>
	<tr>
	<td colspan="3">Total</td>
	<td>${total}</td>
	</tr>
	</table>
	<br>
	</div>
</body>
</html>