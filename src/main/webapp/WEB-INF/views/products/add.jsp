<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temps/bootStrap_css.jsp"></c:import>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
</head>
<body>
<c:import url="../temps/header.jsp"></c:import>
	<h1>Product Add</h1>
	
	<section id="contents" class="container-fluid">
		<div class="row mt-4">
			<form action="./add" method="post" enctype="multipart/form-data">
				<div class="mb-3">
					<label for="productName" class="form-label">상품명</label>
					<input type="text" class="form-control" id="name" name="productName">
				</div>
				<div class="mb-3">
					<label for="productContents" class="form-label">상품설명</label>
					<textarea class="form-control" id="pContents" name="productContents" rows="3"></textarea>
				</div>
				<div class="mb-3">
					<label for="productRate" class="form-label">이자율</label>
					<input type="number" class="form-control" id="rate" name="productRate">
				</div>
				<div class="mb-4">
					<label for="productJumsu" class="form-label">평점</label>
					<input type="number" class="form-control" id="jumsu" name="productJumsu">
				</div>
				
				<!-- 파일첨부-->
				<div class="mb-5">
					<input type="file" name="file">
					<input type="file" name="file">
					<input type="file" name="file">
				</div>

				
				<button type="submit" class="btn btn-primary">Add</button>
			</form>

		</div>
		
	</section>
<script>
	$('#pContents').summernote()
</script>
<c:import url="../temps/bootStrap_js.jsp"></c:import>
</body>
</html>