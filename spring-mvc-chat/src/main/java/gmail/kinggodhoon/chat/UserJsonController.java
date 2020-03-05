package gmail.kinggodhoon.chat;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gmail.kinggodhoon.chat.service.UserService;

@RestController
public class UserJsonController {

	@Autowired
	private UserService userService;
	
//	아이디 중복 검사
	@GetMapping("/register/checkname")
	public Map<String,Object> checkName(HttpServletRequest request){
		String username = request.getParameter("username");
		
		Map<String,Object> result = new HashMap<>();
		
		boolean r = userService.checkName(username);
		
		result.put("result", r);
		
		return result;
	}
	
	
//	닉네임 중복 검사
	@GetMapping("/register/checknick")
	public Map<String,Object> checkNick(HttpServletRequest request){
		String nick = request.getParameter("nick");
		
		Map<String,Object> result = new HashMap<>();
		
		boolean r = userService.checkNick(nick);
		
		result.put("result", r);
		
		return result;
		
	}
}
