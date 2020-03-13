var main = document.getElementById("mainbtn");
var list = document.getElementById("listbtn");

main.addEventListener("click",function(e){
	window.location.href="/chat";
})

list.addEventListener("click",function(e){
	window.location.href="/chat/server"
})