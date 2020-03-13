package gmail.kinggodhoon.chat.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Log {
	private int userid;
	private int roomid;
	private String content;
	private Date timestamp;
}
