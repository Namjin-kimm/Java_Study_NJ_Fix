<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA Detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-4">
		<div>
  			<input type="text" readonly class="form-control-plaintext" id="floatingEmptyPlaintextInput">
  			<label for="floatingEmptyPlaintextInput">Writer : ${boardDTO.writer}</label>
		</div>
		<div class="form-floating mb-3">
  			<textarea readonly class="form-control-plaintext" id="floatingPlaintextInput" placeholder="name@example.com ">${boardDTO.contents}</textarea>
  			<label for="floatingPlaintextInput">Contents</label>
		</div>
		<a href="update.iu?num=${boardDTO.num}">수정하기</a>
	</section>
<c:import url="../template/footer.jsp"></c:import>

</body>
</html>