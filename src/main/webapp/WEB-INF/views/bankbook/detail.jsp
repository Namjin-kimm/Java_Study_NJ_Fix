<%@page import="com.iu.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid col-lg-8 mt-4" >
	<h1>BankBook Detail</h1>
	
	<!-- /bankbook/detail -->
	<!-- link 주소는 상대경로 작 -->
	
	<%-- <%BankBookDTO bankBookDTO = (BankBookDTO)request.getAttribute("detail"); %> --%>
	
	<%-- <%if(bankBookDTO != null){ %> --%>
<table class="table table-striped">
	<thead>
		<tr>
			<th>BookNum</th><th>BookName</th><th>BookRate</th><th>BookSale</th><th>BookContents</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.detail.getBookNum()}</td>
			<td>${requestScope.detail.bookName}</td>
			<td>${detail.bookRate}</td>
			<td>${detail.bookSale}</td>
			<td>${detail.bookContents}</td>
			
			<%-- <td><%=bankBookDTO.getBookNum() %></td>
			<td><%=bankBookDTO.getBookName() %></td>
			<td><%=bankBookDTO.getBookRate() %></td>
			<td><%=bankBookDTO.getBooksale() %></td> --%>
		</tr>
	</tbody>
</table>

<!-- comment 영역 -->
<div class="row">
	<div class="mb-3">
		<label for="writer" class="form-label">UserName</label>
		<input type="text" class="form-control" id="writer">
	  </div>

	  <div class="mb-3">
		<label for="contents" class="form-label">Comment</label>
		<textarea class="form-control" id="contents" rows="3"></textarea>
	  </div>

	  <div class="mb-3">
		<button type="button" id="btn" data-booknum="${detail.bookNum}">댓글 작성</button>
	  </div>

	  <!-- Comment List 출력 -->
	  <div id="commentList">
		
	  </div>

</div>
<!-- comment 영역 -->
<div class="row">
	<%-- <%}else{ %>
	<h3>Data가 없다</h3>
	<%} %> --%>
	<a href="list.iu">리스트보기</a>
	<a href="update?bookNum=${detail.bookNum}">수정</a>
	<a href="delete?bookNum=${detail.bookNum}">삭제</a>

	<c:if test="${not empty sessionScope.member}">
	<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">가입하기</a>
	</c:if>
</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/js/bankBookComment.js"></script>
</body>
</html>