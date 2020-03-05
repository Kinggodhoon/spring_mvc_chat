var username = document.getElementById("username");
var nick = document.getElementById("nick");

var chkname = false;
var chknick = false;

var disp = document.getElementById("disp");

username.addEventListener("focusout",function(e){
	$.ajax({
		url:'register/checkname?username='+username.value,
		data:'json',
		success:function(data){
			if(data.result == true){
				chkname = true;
			}
		}
	});
	
});

nick.addEventListener("focusout",function(e){
	$.ajax({
		url:'register/checknick?nick='+nick.value,
		data:'json',
		success:function(data){
			if(data.result == true){
				chknick = true;
			}
		}
	});
	
});



//유효성 검사를 통과하지 못했을 때 submit 이벤트가 넘어가는 것을 막는 코드
document.getElementById("register").addEventListener("submit",function(e){
	
	if(chkname == false){
		disp.innerHTML = "사용 불가능한 아이디입니다.";
		disp.style.color = 'red';
		
		e.preventDefault();
	}
	
	if(chknick == false){
		disp.innerHTML = "사용 불가능한 닉네임입니다.";
		disp.style.color = 'red';
		
		e.preventDefault();
	}
	
});