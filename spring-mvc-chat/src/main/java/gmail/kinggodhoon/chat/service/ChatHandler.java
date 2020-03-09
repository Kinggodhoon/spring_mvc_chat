package gmail.kinggodhoon.chat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {
	private List<WebSocketSession> userList = new ArrayList<WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session){
		userList.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
		userList.remove(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message){
		String msg = message.getPayload();
		
		try {
			for(WebSocketSession ss : userList) {
				ss.sendMessage(new TextMessage(msg));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
