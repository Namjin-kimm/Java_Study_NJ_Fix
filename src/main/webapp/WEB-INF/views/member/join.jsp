<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
		<form action="join.iu" method="post" enctype="multipart/form-data" id="form">
		
			<section class="container-fluid col-lg-8 mt-4">
				<h1>Join Page</h1>
				
				<div>
				<p>ID</p>
				<p><input class="form-control form-control-lg-8" type="text" placeholder="ID" aria-label=".form-control-lg example" name="username" id="id"></p>
				</div>
				<div id="idm"></div>
				
				<p>PW</p>
				<p><input class="form-control form-control-lg" type="password" placeholder="PW" aria-label=".form-control-lg example" name="password" id="pw"></p>
				<div id="pwm"></div>
				
				<p>PW</p>
				<p><input class="form-control form-control-lg" type="password" placeholder="PW" aria-label=".form-control-lg example" name="password" id="pw2"></p>
				<div id="pwm2"></div>

				<p>Name</p>
				<p><input class="form-control form-control-lg cb" type="text" placeholder="Name" aria-label=".form-control-lg example" name="name" id="name"></p>
				<div class="ch"></div>

				<p>Email</p>
				<p><input class="form-control form-control-lg cb" type="email" placeholder="Email" aria-label=".form-control-lg example" name="email" id="email" required></p>
				<div class="ch"></div>

				<p>Phone</p>
				<p><input class="form-control form-control-lg cb" type="text" placeholder="Phone" aria-label=".form-control-lg example" name="phone" id="phone"></p>
				<div class="ch"></div>
				
				<div>
				<p>Photo</p>
				<p><input class="form-control form-control-lg" type="file" aria-label=".form-control-lg example" name="photo" id="files"></p>
				</div>
				<div>

				</div>
				
				<button type="button" class="btn btn-primary" id="btn">Submit</button>
			</section>
		</form>
		<script src="/resources/js/member.js"></script>
		<script>
			joincheck();
		</script>
</body>
</html>