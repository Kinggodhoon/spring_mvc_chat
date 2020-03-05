<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>Chat</title>
	</head>

	<body>
	
		<div class="article" align="center">
			<form accept-charset="UTF-8" method="post" id="login">
			
				<p>
					<input type="text" id="username" name="username" size="24" placeholder="username" required="required" style="width:200px;height:30px;"><br/>
					<input type="text" id="nick" name="nick" size="24" placeholder="nickname" required="required" style="width:200px;height:30px;"><br/>
					<input type="password" id="userpw" name="userpw" size="24" placeholder="password" required="required" style="width:200px;height:30px;">
				</p>
				
				<p>
					<input type="submit" value="로그인"/><br/> 
					<input type="button" id="cancle" value="돌아가기">
				</p>
			</form>
		</div>
		
	</body>
</html>
