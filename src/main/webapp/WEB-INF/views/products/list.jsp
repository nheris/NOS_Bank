<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="../temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="../temps/header.jsp"></c:import>
	
	<h1>Product List</h1>
	
	<table class="table table-hover">
		<thead class="table-light">
			<tr>
				<th>상품번호</th>
				<th>상품명</th>
				<th>이자율</th>
				<th>평점</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${pageScope.dto.productNum}</td>
					<td>${dto.productName}</td>
					<td>${dto.productRate}</td>
					<td>${dto.productJumsu}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	
	<a href="./add" class="btn btn-primary">Add</a>
	
	<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>