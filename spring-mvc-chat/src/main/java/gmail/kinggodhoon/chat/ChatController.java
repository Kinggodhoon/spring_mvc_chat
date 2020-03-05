package gmail.kinggodhoon.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

	@GetMapping("/server")
	public String list() {
		return "list";
	}
	
	@GetMapping("/server/{roomid}")
	public String chat(@PathVariable int roomid) {
		return "chat";
	}
	
}
