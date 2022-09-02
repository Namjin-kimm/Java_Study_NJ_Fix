<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<thead>
			<tr>
				<th>AccountNum</th><th>UserName</th><th>BookNum</th><th>AccountDate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bookName}</td>
					<td>${dto.bookRate}</td>
					<td>${dto.bookSale}</td>
					<td>${dto.bookContents}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>