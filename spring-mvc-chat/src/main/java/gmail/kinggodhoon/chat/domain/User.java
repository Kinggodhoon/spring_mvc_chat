package gmail.kinggodhoon.chat.domain;

import lombok.Data;

@Data
public class User {

	private int userid;
	private String username;
	private String nick;
	private String userpw;
	
	
	public User() {}
	public User(int userid, String nick) {
		this.userid = userid;
		this.nick = nick;
	}
}
