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
	<section class="container-fluid col-lg-8">
		<form action="update.iu" method = "post">
			<p>Title</p>
			<p><input class="form-control form-control-lg" type="text" aria-label=".form-control-lg example" value = "${boardDTO.title}" name="title"></p>
			<p>Contents</p>
			<textarea class="form-control form-control-lg" aria-label=".form-control-lg example" name="contents">${boardDTO.contents}</textarea><br>
			<button type="submit" class="btn btn-primary">수정</button>
		</form>
	</section>	



<c:import url="../template/footer.jsp"></c:import>
</body>
</html>