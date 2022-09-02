<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<form action="add" method="post">
		<section class="container-fluid col-lg-8 mt-4">
		<h1>BankBook Add List</h1>
    	<p>BookName</p>
    	<p><input class="form-control form-control-lg" type="text" aria-label=".form-control-lg example" name="bookName"></p>
    	<p><button type="reset" class="btn btn-primary">Reset</button></p>
    	<p>BookRate</p>
    	<p><input class="form-control form-control-lg" type="text" aria-label=".form-control-lg example" name="bookRate"></p>
    	<p>BookContents</p>
    	<p><input class="form-control form-control-lg" type="text" aria-label=".form-control-lg example" name="bookContents"></p>
    	<p><button type="submit" class="btn btn-primary">Submit</button></p>
    	</section>
	</form>
</body>
</html>