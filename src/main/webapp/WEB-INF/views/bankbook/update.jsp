<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Page</h1>
	

	<form action="update" method="post">
		<div>
			<input type="hidden" value="${dto.bookNum}" name="bookNum" readonly="readonly">
		</div>
		<div>
			Name : <input type="text" value="${dto.bookName}" name="bookName">
		</div>
		<div>
			Rate : <input type="text" value="${dto.bookRate}" name="bookRate">
		</div>
		
		<button type="submit">수정</button>
	</form>

</body>
</html>