<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-4">
	<h1>My Page</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>USERNAME</th><th>NAME</th><th>EMAIL</th><th>PHONE</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><p>${myPage.username}</p></td>
					<td><p>${myPage.name}</p></td>
					<td><p>${myPage.email}</p></td>
					<td><p>${myPage.phone}</p></td>
				</tr>
			</tbody>
			</table>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>AccountNum</th><th>BookName</th><th>AccountDate</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${myPage.bankAccountDTOs}" var="dto">
						<tr>
							<td><p>${dto.accountNum}</p></td>
							<td><p>${dto.bankBookDTO.bookName}</p></td>
							<td><p>${dto.accountDate}</p></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="row">
				<img alt="" src="../resources/upload/member/${myPage.bankMembersFileDTO.fileName}">
			</div>
			
			${myPage}
	</section>
</body>
</html>