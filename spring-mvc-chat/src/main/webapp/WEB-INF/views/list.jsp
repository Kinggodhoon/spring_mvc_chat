<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>	
		<title>Chat</title>
	</head>

	<body>
		<ul>
			<c:forEach var="i" begin="1" end="5">
				<li>
					<a href="./server/${i}">${i} 번방 </a>
				</li>
			</c:forEach>
		</ul>
	
	</body>
</html>
