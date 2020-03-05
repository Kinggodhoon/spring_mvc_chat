var socket = new WebSocket("ws://localhost:8080/chat/chat");

var send = document.getElementById("sendbtn");
var message = document.getElementById("message");
var chatbox = document.getElementById("chat-log");


socket.addEventListener("message",function(e){
	chatbox.innerHTML += e.data;
});

socket.addEventListener("open",function(e){
	console.log("Server Connected");
});

socket.addEventListener("close",function(e){
	console.log("Server Disconnected");
});
