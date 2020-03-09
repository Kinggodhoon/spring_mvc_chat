<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>	
		<title>Chat</title>
		
		<link rel="stylesheet" type="text/css" href="/chat/resources/css/chat.css"/>
	</head>

	<body>
		
		<div class="article" align="center">
		    
			<div id="div-chat-log">
				<textarea id="chat-log" readonly="readonly" disabled="disabled"></textarea>
			</div>
			<p/>
			<div id="div-chat-input">
				<div hidden="hidden" id="userid">${user.userid}</div>
				<div hidden="hidden" id="nick">${user.nick}</div>
				<input type="text" id="message" size="120"/>&nbsp;
				<input type="button" id="sendbtn" value="전송">
			</div>
			<p/>
			<div id="div-util">
				<input type="button" id="backbtn" value="방 목록으로">
				<input type="button" id="mainbtn" value="메인으로">
			</div>
		
		</div>
		
	
	</body>
	
	<script src="/chat/resources/js/chat.js"></script>
</html>
