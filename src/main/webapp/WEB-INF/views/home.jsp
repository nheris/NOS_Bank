<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>     
	<title>Home</title>
	<c:import url="./temps/bootStrap_css.jsp"></c:import>
</head>
<body>
	<c:import url="./temps/header.jsp"></c:import>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


	<c:import url="./temps/bootStrap_js.jsp"></c:import>
</body>
</html>
