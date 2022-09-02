<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BankBook List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th><th>Rate</th><th>Sale</th><th>Contents</th>
			</tr>
		</thead>
		<tbody>
			<!-- <tr>
				<td>Name1</td>
				<td>0.012</td>
			</tr>
			<tr>
				<td>Name2</td>
				<td>3.14</td>
			</tr> -->
			
			<c:forEach items="${list}" var="dto">
				<tr>
					<td><a href ="detail?bookNum=${dto.bookNum}">${dto.bookName}</a></td>
					<td>${dto.bookRate}</td>
					<td>${dto.bookSale}</td>
					<td>${dto.bookContents}</td>
				</tr>
			</c:forEach>
			<%-- <%ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list"); %>
			<% for(BankBookDTO bankBookDTO : ar){ %>
				<tr>
					<td><a href ="detail?bookNum=<%= bankBookDTO.getBookNum()%>"><%=bankBookDTO.getBookName() %></a></td>
					<td><%=bankBookDTO.getBookRate() %></td>
					<td><%=bankBookDTO.getBookSale() %></td>
				</tr>
			<% } %> --%>
		</tbody>
	
	</table>
	
	<a href="add">상품등록</a>
	</section>
	

</body>
</html>