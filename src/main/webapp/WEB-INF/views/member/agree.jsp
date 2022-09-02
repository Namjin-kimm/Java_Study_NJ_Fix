<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agree</title>
</head>
<body>
	<h1>약관동의 Page</h1>
	<form action="./join.iu" id="form">
		<div>
    		전체동의<input type="checkbox" name="" id="all">
    		동의 1<input type="checkbox" name="" id="" class="ch req">
		    동의 2<input type="checkbox" name="" id="" class="ch req">
		    동의 3<input type="checkbox" name="" id="" class="ch">
		</div>
		<button type="button" id="join">회원가입</button>
	</form>
<script src="/resources/js/agree.js"></script>
<script>
	check();
</script>
</body>
</html>