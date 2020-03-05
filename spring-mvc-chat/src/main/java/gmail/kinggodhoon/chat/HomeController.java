package gmail.kinggodhoon.chat;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gmail.kinggodhoon.chat.domain.User;
import gmail.kinggodhoon.chat.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,HttpSession session,RedirectAttributes attr ) {
		String username = request.getParameter("username");
		String userpw = request.getParameter("userpw");
		
		User loginUser = new User();
		
		loginUser.setUsername(username);
		loginUser.setUserpw(userpw);
		
		User user = userService.login(loginUser);
		
		if(user != null) {
			session.setAttribute("user", user);
			
			return "redirect:/";
		}
		
		attr.addFlashAttribute("error", "없는 계정이거나, 일치하지 않는 비밀번호입니다.");
		 
		return "redirect:/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(HttpServletRequest request) {
		String username = request.getParameter("username");
		String nick = request.getParameter("nick");
		String userpw = request.getParameter("userpw");
		
		User user = new User();
		
		user.setUsername(username);
		user.setNick(nick);
		user.setUserpw(BCrypt.hashpw(userpw, BCrypt.gensalt()));
		
		userService.insert(user);
		
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/";
	}
	
	
	
}

