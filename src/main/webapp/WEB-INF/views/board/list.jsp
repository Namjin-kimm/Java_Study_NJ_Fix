<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board} List</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class = "container-fluid col-lg-8 mt-4">
		<h1>${board} List Page</h1>
		
		
		<div class = "row">
			<form action="list.iu" method="get" class="row row-cols-lg-auto g-3 align-items-center">
				
				<div class="col-12">
					<label class="visually-hidden" for="kind">Preference</label>
					<select name="kind" class="form-select" id="kind">
						<option class="kinds" value="contents">Contents</option>
						<option class="kinds" value="title">Title</option>
						<option class="kinds" value="writer">Writer</option>
					</select>
				</div>
				
				<div class="col-12">
					<label class="visually-hidden" for="search">검색어</label>
					<div class="input-group">
						<input type="text" name="search" value="${param.search}" class="form-control" id="search">
					</div>
				</div>
				
				<div class="col-12">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
		
		<table class="table table-striped">
			<thead>
				<tr>
					<th>NUM</th><th>TITLE</th><th>WRITER</th><th>REGDATE</th>
					<th>HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num}</td>
						<td>
							<c:catch>
								<c:forEach begin="1" end="${dto.depth}">&ensp;</c:forEach>
							</c:catch>
							<a href="detail.iu?num=${dto.num}">${dto.title}</a>
						</td>
						<td>${dto.writer}</td>
						<td>${dto.regDate}</td>
						<td>${dto.hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add.iu">${board} 등록</a>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${pager.pre}">
					<li class="page-item">
						<a class="page-link" href="./list.iu?page=${pager.startNum - 1}&kind=${pager.kind}&search=${pager.search}">Previous</a>
					</li>
				</c:if>
				
				
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item">
						<a class="page-link" href="./list.iu?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
					</li>
				</c:forEach>
				
				<c:choose>
					<c:when test="">
					</c:when>
				</c:choose>
				<!-- <c:if test="${pager.next}"> -->
					<li class="page-item ${pager.next?'':'disabled'}">
						<a class="page-link" href="./list.iu?page=${pager.lastNum + 1}&kind=${pager.kind}&search=${pager.search}">Next</a>
					</li>
					<!-- </c:if> -->
				</ul>
			</nav>
		</section>
		<c:import url="../template/footer.jsp"></c:import>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
		<script src="/resources/js/board.js"></script>
		<script>
			let k = '${param.kind}'; //title, kind, writer

			//parameter로 받은 값 하고 option에서 받은 값과 비교해서 
			const kinds = document.getElementsByClassName('kinds');

			for(let i = 0; i <kinds.length; i++){
				if(kinds[i].value == k){
					kinds[i].selected = true;
					break;
				}
			}

		</script>
	</body>
		</html>