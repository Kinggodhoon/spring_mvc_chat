package gmail.kinggodhoon.chat.domain;

import lombok.Data;

@Data
public class Message {
	private int type;
	private int roomid;
	private String content;
	
	public Message() {}
	
	public Message(int type, int roomid, String content) {
		this.type = type;
		this.roomid = roomid;
		this.content = content;
	}
	
	
}
