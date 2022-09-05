<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} Add</title>
<!-- Jquery -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- BootStrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<!-- include summernote css/js-->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<form action="add.iu" method="post"	enctype="multipart/form-data">
			<section class="container-fluid col-lg-8 mt-4">
				<div>
					<h1>${board} Add Page</h1>
					<p>Writer</p>
					<p><input class="form-control form-control-lg" readonly="readonly" type="text" aria-label=".form-control-lg example" value="${member.username}" name="writer"></p>
					<p>Title</p>
					<p><input class="form-control form-control-lg" type="text" placeholder="Title" aria-label=".form-control-lg example" name="title"></p>
					<p>Contents</p>
					<p><textarea input class="form-control form-control-lg" type="text" placeholder="Contents" aria-label=".form-control-lg example" name="contents" id="contents"></textarea></p>
				</div>
				
				<div id="addFiles">
					<button type="button" id="fileAdd">파일 추가</button>
				</div>


				<!-- <p>Image</p>
				<p><input class="form-control form-control-lg" type="file" aria-label=".form-control-lg example" name="files"></p>
				<p>Image</p>
				<p><input class="form-control form-control-lg" type="file" aria-label=".form-control-lg example" name="files"></p> -->
				<button type="submit" class="btn btn-primary">Submit</button>
			</section>
		</form>
<c:import url="../template/footer.jsp"></c:import>
<script type="text/javascript">
	$("#contents").summernote();
</script>
<script src="/resources/js/board_file.js"></script>
</body>
</html>