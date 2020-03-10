package gmail.kinggodhoon.chat.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import gmail.kinggodhoon.chat.domain.Message;
import gmail.kinggodhoon.chat.domain.User;

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
		//JSON 파싱
		try {
			String jsonMsg = message.getPayload();
			
			JsonParser parser = new JsonParser();
			
			JsonObject jsonObject = (JsonObject)parser.parse(jsonMsg);
			
			JsonObject userJson = (JsonObject)jsonObject.get("user");
			JsonObject messageJson = (JsonObject)jsonObject.get("message");
			
			//유저 JSON 파싱
			int userid = Integer.parseInt(userJson.get("userid").getAsString());
			String nick = userJson.get("nick").getAsString();
			User user = new User(userid,nick);
			
			//메세지 JSON 파싱
			int type = Integer.parseInt(messageJson.get("type").getAsString());
			int roomid = Integer.parseInt(messageJson.get("roomid").getAsString());
			String content = messageJson.get("message").getAsString();
			Message msg = new Message(type, roomid, content);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//웹 소켓 세션에 메세지 전송
		try {
			for(WebSocketSession ss : userList) {
//				ss.sendMessage(new TextMessage(msg));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
