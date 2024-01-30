<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${list}" var="r">
	<tr>
		<td>${r.replyContents}</td>
		<td>${r.userName}</td>
		<td>${r.replyDate}</td>
		<td>${r.replyJumsu}</td>
	</tr>
</c:forEach>

