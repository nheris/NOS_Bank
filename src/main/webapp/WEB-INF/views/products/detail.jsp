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
        <title>Board Detail</title>
	<!-- 사용전 경로를 꼭 수정하세요/ -->
	<c:import url="../temps/head_css.jsp"></c:import>
	
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정하세요/ -->
            <c:import url="../temps/header.jsp"></c:import>
            <section class="py-5">
                <div class="container px-5 mb-5">
                    <div class="text-center mb-5">
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${board}Detail</span></h1>
                    </div>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-11 col-xl-9 col-xxl-8">

                            <!--project-->
                            <div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
                                <div class="card-body p-0">
                                    <div class="d-flex align-items-center">
                                        <div class="p-5">
                                        	<c:if test="${empty dto}">
								    			<h3>없는 제품입니다.</h3>
								    		</c:if>
								    		
								    		<c:if test="${not empty dto}">
								    			<h2 class="fw-bolder">${dto.productName}</h2>
	                                            <div>${dto.productContents}</div>
	                                            <div>${dto.productRate}</div>
	                    
	                                            <div>
	                                            	<c:forEach items="${dto.fileDTOs}" var="f">
	                                            		<a href="/resources/upload/product/${f.fileName}">${f.oriName}</a>
	                                            	</c:forEach>
	                           
	                                            </div>
								    		</c:if>
									    		
									    		
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
							<c:if test="${not empty dto}">
							<div>
								
								<a id="add" class="btn btn-primary" href="/account/add?productNum=${dto.productNum}">상품가입</a>
								
                                <a id="update" class="btn btn-success" data-product-num="${dto.productNum}" href="#">Update</a>
                                <a id="delete" class="btn btn-danger" href="#">Delete</a>
                                
                                <a id="wishlist" class="btn btn-dark" href="#">♥</a>
                                

                                <form id="frm" action="./update" method="get">
                                    <input type="hidden" name="productNum" id="productNum" value="${dto.productNum}">
                                </form>
							</div>
                            </c:if>
							

                        </div>

                        <div class="my-3">
							<table>
								<thead>
									<tr>
										<th>Contents</th>
										<th>Writer</th>
										<th>Date</th>
										<th>Score</th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody id="replyList" data-user="${member.userName}">
									
								</tbody>
							</table>
		
							<div>
								<%-- <button id="more" data-replyList-page="${pager.page}" data-replyList-totalPage="${pager.totalPage}">더보기</button> --%>
								<button id="more" data-replyList-page="1" data-replyList-totalPage="1">더보기</button>
							</div>
                        </div>


                        <div class="my-3">
                            <form id="replyForm">
                                    <input type="hidden" name="productNum" value="${dto.productNum}">


                                    <div class="mb-3">
                                        <textarea class="form-control" id="replyContents" rows="3" name="replyContents"></textarea>
                                    </div>
                                    <div class="mb-3">
                                        <select class="form-select" name="replyJumsu" aria-label="Default select example">
                                            <option value="5">★★★★★</option>
                                            <option value="4">★★★★</option>
                                            <option value="3">★★★</option>
                                            <option value="2">★★</option>
                                            <option value="1">★</option>
                                        </select>
                                    </div>

                                    <div>
                                        <button type="button" id="replyAdd" class="btn btn-primary">댓글달기</button>
                                    </div>
                            </form>

                        </div>


                    </div>
                </div>
            </section>
            


        </main>
        
        <!-- Modal -->
        <div class="modal fade" id="replyUpdateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form method="post" id="replyUpdateForm">
                        <textarea class="form-control" name="replyContents" id="replyUpdateContents" rows="3"></textarea>
                        <input type="hidden" value="" name="replyNum" id="replyUpdateNum">
                        <input type="hidden" value="" name="userName" id="replyWriter">
                    </form>
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="replyCloseButton">Close</button>
                <button type="button" class="btn btn-primary" id="replyUpdateButton">Update</button>
                </div>
            </div>
            </div>
        </div>
  
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정하세요/ -->
		<c:import url="../temps/footer.jsp"></c:import>
        <script src="/resources/js/boardDetail.js"></script>
    </body>
</html>
