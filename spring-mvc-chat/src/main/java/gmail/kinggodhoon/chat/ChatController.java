package gmail.kinggodhoon.chat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

	@GetMapping("/server")
	public String list(HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		
		return "list";
	}
	
	@GetMapping("/server/{roomid}")
	public String chat(@PathVariable int roomid,HttpSession session) {
		if(session.getAttribute("user") == null) {
			return "redirect:/login";
		}
		
		return "chat";
	}
	
}
