<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Member List</h1>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-4">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>USERNAME</th><th>NAME</th><th>EMAIL</th><th>PHONE</th>
			</tr>
		</thead>
		
		<tbody>
			<%-- <c:forEach begin="0" end="10" var="i">
			<!-- for(int i = 0; i<= 10, i++) -->
				<h3>${i}</h3>
			</c:forEach> --%>
			
			<c:forEach items="${search}" var="dto">
				<tr>
					<td>${pageScope.dto.username}</td>
					<td>${pageScope.dto.password}</td>
					<td>${pageScope.dto.name}</td>
					<td>${pageScope.dto.email}</td>
					<td>${pageScope.dto.phone}</td>
				</tr>
			
			</c:forEach>
			<%-- <%ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>)request.getAttribute("search"); %>
			<%for(BankMembersDTO bankMembersDTO: ar){ %> --%>
				<%-- <tr>
					<td><%=bankMembersDTO.getUsername() %></td>
					<td><%=bankMembersDTO.getName() %></td>
					<td><%=bankMembersDTO.getEmail() %></td>
					<td><%=bankMembersDTO.getPhone() %></td>
				</tr> --%>
			<%-- <%} %> --%>
			</tbody>
		</table>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
</body>
</html>