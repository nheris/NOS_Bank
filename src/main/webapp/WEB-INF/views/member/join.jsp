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


		<section class="py-5">
			<div class="text-center mb-5">
				<h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">회원가입</span></h1>
			</div>
		
			<div class="row gx-5 justify-content-center">
	             	<div class="col-lg-11 col-xl-9 col-xxl-8">
           		    	<form action="./join" method="POST" enctype="multipart/form-data">
                      		<div class="input-group mb-3">
							  <span class="input-group-text" id="basic-addon1">ID</span>
							  <input type="text" class="form-control" id="userName" name="userName" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
							</div>
							
							  <div id="passwordResult" ></div>
	                       <div class="input-group mb-3">
							  <span class="input-group-text" id="basic-addon2">PW</span>
							  <input type="password" class="form-control" id="password" name="password" placeholder="Password" aria-label="Password" aria-describedby="basic-addon2">
							</div>
								<div id="passwordCheckResult"></div>
							<div class="input-group mb-3">
								<span class="input-group-text" id="basic-addon2">re:PW</span>
								<input type="password" class="form-control" id="passwordCheck" placeholder="Password" aria-label="Password" aria-describedby="basic-addon2">
							</div>


							<div class="input-group mb-3">
							  <span class="input-group-text" id="basic-addon3">이름</span>
							  <input type="text" class="form-control" id="name" name="name" placeholder="홍길동" aria-label="Name" aria-describedby="basic-addon3">
							</div>
							
							<div class="input-group mb-3">
							  <span class="input-group-text" id="basic-addon4">Email</span>
							  <input type="email" class="form-control" id="email" name="email" placeholder="Gildong@example.com" aria-label="Email" aria-describedby="basic-addon4">
							</div>
							
							<div class="input-group mb-3">
							  <span class="input-group-text" id="basic-addon5">PHONE</span>
							  <input type="text" class="form-control" id="phone" name="phone" placeholder="010-0000-0000" aria-label="Phone" aria-describedby="basic-addon5">
							</div>
							
							<div class="input-group mb-3">
							  <span class="input-group-text" id="basic-addon6">ADDRESS</span>
							  <input type="text" class="form-control" id="address" name="address" placeholder="Address" aria-label="Address" aria-describedby="basic-addon6">
							</div>
							
	                       <div class="mb-3">
	                       	<input class="form-control" type="file" name="attachs">
	                       </div>
	                       
	                       
	                       <div class="mb-3">
	                         	<button type="button" id="btn" class="btn btn-primary">등록</button>
	                       </div>
	                     </form>
	             	</div>
            	</div>
      	</section>







        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요/ -->
		<c:import url="../temps/footer.jsp"></c:import>
		<script src="../resources/js/member/joinCheck.js"></script>
    </body>
</html>
