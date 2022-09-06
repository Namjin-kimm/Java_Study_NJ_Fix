<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Detail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-4">
		<h1>${board} Detail Page</h1>
		<div>
  			<input type="text" readonly class="form-control-plaintext" id="floatingEmptyPlaintextInput">
  			<label for="floatingEmptyPlaintextInput">Writer : ${boardDTO.writer}</label>
		</div>
		<div class="form-floating mb-3">
  			<p>${boardDTO.contents}</p>
  			<label for="floatingPlaintextInput">Contents</label>
		</div>
		
		<div class="row">
			<a href="reply.iu?num=${boardDTO.num}" class="btn btn-primary">Reply</a>
		</div>
		
		<!--  쌤 깃허브 보기 -->
		<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
			<p>
			<a href="../resources/upload/${board}/${fileDTO.fileName}">${fileDTO.oriName}</a>
			</p>
		</c:forEach>
		
		<a href="update.iu?num=${boardDTO.num}">수정</a>
		<a href="delete.iu?num=${boardDTO.num}">삭제</a>
	</section>
<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/js/board_file.js"></script>
</body>
</html>