//websocket
var socket = new WebSocket("ws://localhost:8080/chat/chat");

//client
var send = document.getElementById("sendbtn");
var msg = document.getElementById("message");
var logbox = document.getElementById("chat-log");

//user
var userid = document.getElementById("userid");
var nick = document.getElementById("nick");

//세션에 있는 유저 정보 떙겨오기
//경로에 있는 방번호 땡겨오기
//Json으로 웹소켓 서버에 보내기
//메세지 DTO 만들기
//로그 남기기

socket.addEventListener("message",function(e){
	logbox.innerHTML += e.data;
});

socket.addEventListener("open",function(e){
	console.log("Server Connected");
	
	message.value = "";
	var obj = makeJson(2);
	socket.send(obj);
});

socket.addEventListener("close",function(e){
	console.log("Server Disconnected");
	
	message.value = "";
	var obj = makeJson(3);
	socket.send(obj);
});

//전송 버튼
send.addEventListener("click",function(e){
	var obj = makeJson(1);
	
	message.value = "";
	
	socket.send(obj);
});

//엔터로 전송
msg.addEventListener("keydown",function(e){
	if(e.keycode == 13){
		var obj = makeJson(1);
		
		message.value = "";
		
		socket.send(obj);
	}
});

//message type
//1 : send message
//2 : enter server
//3 : exit server
function makeJson(type){
	var user = {"userid":userid.innerHTML,"nick":nick.innerHTML};
	var message = {"type":type,"roomid":parseInt(window.location.href.split("/")[5]),"message":msg.value};
	
	var object = {"user":user,"message":message};
	
	return JSON.stringify(object);
}
	