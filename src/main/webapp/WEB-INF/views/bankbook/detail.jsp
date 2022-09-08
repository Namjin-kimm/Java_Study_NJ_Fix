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
			<!-- link 주소는 상대경로 작성 -->
			
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
		
		<a href="list.iu">리스트보기</a>
		<a href="update?bookNum=${detail.bookNum}">수정</a>
		<a href="delete?bookNum=${detail.bookNum}">삭제</a>

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
			<div>
				<table id="commentList">

				</table>
			</div>
			
			<button id="more" class="btn btn-primary" data-page="">더보기</button>

		</div>
		<!-- comment 영역 -->
		<div class="row">
			<%-- <%}else{ %>
			<h3>Data가 없다</h3>
			<%} %> --%>

			<c:if test="${not empty sessionScope.member}">
			<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">가입하기</a>
			</c:if>
		</div>

		<div>
			<button type="button" style="display: none;" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@fat" id="up">Open modal for @fat</button>

			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">New message</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form>
							<input type="hidden" id="num">
						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">Writer:</label>
							<input type="text" class="form-control" id="updateWriter" name="writer">
						</div>
						<div class="mb-3">
							<label for="message-text" class="col-form-label">Contents:</label>
							<textarea class="form-control" id="updateContents" name="contents"></textarea>
						</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="sendUpdateBtn">Send message</button>
					</div>
					</div>
				</div>
			</div>


	</section>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<c:import url="../template/footer.jsp"></c:import>
<script src="/resources/js/bankBookComment.js"></script>
</body>
</html>