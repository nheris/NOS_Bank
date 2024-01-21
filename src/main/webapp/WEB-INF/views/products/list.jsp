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
               	 	<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">Product List</span></h1>
                </div>
				
				
				<!-- 서치 -->
				<div>
					<form class="row g-3" action="./list">
					  <div class="col-auto">
						  <select name="kind" class="form-select" aria-label="Default select example">
							  <option class="a" value="kind1">상품명</option>
							  <option class="a" value="kind2">상품설명</option>
						</select>
					  </div>		
					
					  <div class="col-auto">
					    <label for="search" class="visually-hidden">Search</label>
					    <input type="text" name="search" class="form-control" id="search">
					  </div>
					  <div class="col-auto">
					    <button type="submit" class="btn btn-primary mb-3">검색</button>
					  </div>
					</form>
				</div>
				
				<!-- 테이 -->
				<table class="table table-hover">
					<thead>
						<tr>
							<th>상품번호</th>
							<th>상품명</th>
							<th>상품설명</th>
							<th>이자율</th>
							<th>평점</th>
							<th>누적판매량</th>
							<th>판매유무</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="dto" >
							<tr>
								<td>${dto.productNum}</td>
								<td>
									<a href="./detail?productNum=${dto.productNum}">${dto.productName}</a>
								</td>
								<td>${dto.productContents}</td>
								<td>${dto.productRate}</td>
								<td>${dto.productJumsu}</td>
								<td>${dto.productCount}</td>
								<td>${dto.productSale}</td>
							</tr>
						</c:forEach>
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
				
				
				<div>
					<a href="./add" class="btn btn-danger">상품등록</a>
					
				</div>
				
			</div>
			
			
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요/ -->
		<c:import url="../temps/footer.jsp"></c:import>
    </body>
</html>
