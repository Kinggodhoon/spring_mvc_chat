//websocket
var socket = new WebSocket("ws://localhost:8080/chat/chat");

//client
var send = document.getElementById("sendbtn");
var msg = document.getElementById("message");
var logbox = document.getElementById("chat-log");

var roomid = parseInt(window.location.href.split("/")[5]);

//user
var userid = document.getElementById("userid");
var nick = document.getElementById("nick");

//세션에 있는 유저 정보 떙겨오기
//경로에 있는 방번호 땡겨오기
//Json으로 웹소켓 서버에 보내기
//메세지 DTO 만들기
//로그 남기기

socket.addEventListener("message",function(e){
	var msgObj = JSON.parse(e.data);
	
	if(msgObj.roomid == roomid){
		logbox.innerHTML += msgObj.nick + " : " + msgObj.message+"\n";
	}
	
//	logbox.innerHTML += msgObj;
});

socket.addEventListener("open",function(e){
	logbox.innerHTML += "채팅 서버에 연결되었습니다.\n";
	
	message.value = "";
	var obj = makeJson(2);
	socket.send(obj);
});

socket.addEventListener("close",function(e){
	logbox.innerHTML += "채팅 서버와의 연결이 끊어졌습니다.\n";
	
	message.value = "";
	var obj = makeJson(3);
	socket.send(obj);
});

//전송 버튼
send.addEventListener("click",function(e){
	if(message.value.trim().length > 0){
		var obj = makeJson(1);
		
		message.value = "";
		
		socket.send(obj);
	}
});

//엔터로 전송
msg.addEventListener("keydown",function(e){
	if(e.keyCode == 13){
		if(message.value.trim().length > 0){
			var obj = makeJson(1);
			
			message.value = "";
			
			socket.send(obj);
		}
	}
});

//message type
//1 : send message
//2 : enter server
//3 : exit server
function makeJson(type){
	var user = {"userid":userid.innerHTML,"nick":nick.innerHTML};
	var message = {"type":type,"roomid":roomid,"message":msg.value};
	
	var object = {"user":user,"message":message};
	
	return JSON.stringify(object);
}
	