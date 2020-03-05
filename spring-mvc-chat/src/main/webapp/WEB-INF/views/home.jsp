<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Chat</title>
	</head>

	<body>
	
		<c:if test="${user == null}">
			<a href="./login">로그인</a>
		</c:if>
		
		<c:if test="${user != null }">
			<a href="./logout">로그아웃</a><br/>
			<a href="./server">채팅하러 가기</a>
		</c:if>
	
	</body>
</html>
