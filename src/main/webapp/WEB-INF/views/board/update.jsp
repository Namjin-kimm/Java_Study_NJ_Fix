<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Update</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<!-- Jquery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8">
		<h1>${board} Update Page</h1>
		<form action="update.iu" method = "post" enctype="multipart/form-data">
			<div>
				<input type="hidden" value="${boardDTO.num}" name="num">
			</div>
			<p>Title</p>
			<p><input class="form-control form-control-lg" type="text" aria-label=".form-control-lg example" value = "${boardDTO.title}" name="title"></p>
			<p>Contents</p>
			<textarea class="form-control form-control-lg" aria-label=".form-control-lg example" name="contents" id="contents">${boardDTO.contents}</textarea><br>
			
			<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
            	<div class="mb-3">
					<span class="form-control">${fileDTO.oriName}</span>
					<button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
               	</div>
         	</c:forEach>

			<div id="addFiles">
				<button type="button" id="fileAdd">파일 추가</button>
			</div>
         
			<button type="submit" class="btn btn-primary">수정</button>
		</form>
	</section>	



<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/board_file.js"></script>
<script>
	setCount(${boardDTO.boardFileDTOs.size()});
	$("#contents").summernote();
</script>
</body>
</html>