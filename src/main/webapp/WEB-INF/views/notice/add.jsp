<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<form action="add.iu" method="post">
			<section class="container-fluid col-lg-8 mt-4">
				<h1>Add Page</h1>
				<p>Writer</p>
				<p><input class="form-control form-control-lg" readonly="readonly" type="text" aria-label=".form-control-lg example" value="${member.username}" name="writer"></p>
				<p>Title</p>
				<p><input class="form-control form-control-lg" type="text" placeholder="Title" aria-label=".form-control-lg example" name="title"></p>
				<p>Contents</p>
				<p><textarea input class="form-control form-control-lg" type="text" placeholder="Contents" aria-label=".form-control-lg example" name="contents"></textarea></p>
				<button type="submit" class="btn btn-primary">Submit</button>
			</section>
		</form>

</body>
</html>