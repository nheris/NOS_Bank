<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Personal - Start Bootstrap Theme</title>
	<!-- 사용전 경로를 꼭 수정하세요/ -->
	<c:import url="../temps/head_css.jsp"></c:import>
	
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정하세요/ -->
            <c:import url="../temps/header.jsp"></c:import>
			<div class="container px-5 my-5">
               	<div class="text-center mb-5">
               	 	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Wish List</span></h1>
                </div>
				
				
				<!-- 서치 -->
				<%-- <form class="col row g-3 mb-3">
					<div class="col-auto">
						<select class="form-select" name="kind">
							<option value="kind1">이름</option>
							<option value="kind2">내용</option>
							<option value="kind3">이름&내용</option>
						</select>
					</div>
					<div class="col-auto">
						<label for="search" class="visually-hidden">Search</label> <input
							type="text" name="search" class="form-control" id="search"
							value="${pager.search}">
					</div>
					<div class="col-auto">
						<button type="submit" class="btn btn-light">Search</button>
					</div>
				</form> --%>
				
				<div>
					<button id="del">삭제</button>
				</div>
			
				<!-- 테이블 -->
				<table class="table table-hover">
					<thead>
						<tr class="table-dark">
							<th>
								<div class="form-check">
									<input class="form-check-input" type="checkbox" value="" id="checkAll">
									<label class="form-check-label" for="checkAll">
										전체선택
									</label>
							  	</div>
							</th>
							<th>No</th>
							<th>상품명</th>
							<th>이자율</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td>
									<div class="form-check">
										<input class="form-check-input checks" type="checkbox" value="${dto.productNum}" >
									</div>
								</td>
								<td>${dto.productNum}</td>
								<td><a href="../products/detail?productNum=${dto.productNum}">${dto.productName}</a></td>
								<td>${dto.productRate}</td>
	
							</tr>
						</c:forEach>
						<%-- <c:if test="${list.size() != 10}">
								<c:forEach begin="1" end="${11-list.size()}">
									<tr>
										<td style="color : white" disable>빈셀</td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</c:forEach>
							</c:if> --%>
					</tbody>
				</table>
				
				<!-- 페이징 -->
				<nav aria-label="Page navigation example">
				  <ul class="pagination">
				  
				  	<c:if test="${!pager.start}">
				    <li class="page-item">
				      <a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				  	</c:if>
				    
				    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				    <li class="page-item"><a class="page-link" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
				    </c:forEach>

				    <c:if test="${!pager.last}">
				    <li class="page-item">
				      <a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				    </c:if>
				    
				  </ul>
				</nav>

				
			</div>
			
			
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요/ -->
		<c:import url="../temps/footer.jsp"></c:import>
		<script src="/resources/js/wish/whislist.js"></script>
    </body>
</html>
