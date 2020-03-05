package gmail.kinggodhoon.chat.service;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session){
		//로그 찍기
		System.out.println(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status){
		//로그 찍기
		System.out.println(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message){
		String msg = message.getPayload();		
		
		System.out.println(session.getId()+" : "+msg);
		
		try {
			session.sendMessage(new TextMessage("ReSend : "+message.getPayload()));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
