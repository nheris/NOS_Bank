<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
	
    <c:forEach items="${list}" var="dto">
        <tr>
            <td>${dto.userName}</td>
            <td>${dto.replyContents}</td>
            <td>${dto.replyDate}</td>
            <td>${dto.replyJumsu}</td>
            
        </tr>
    </c:forEach>

</table>

<div>
	<button id="more">더보기(${pager.page}/${pager.totalPage})</button>
</div>