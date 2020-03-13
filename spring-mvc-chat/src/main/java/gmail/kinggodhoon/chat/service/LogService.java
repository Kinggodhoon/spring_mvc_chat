package gmail.kinggodhoon.chat.service;

import gmail.kinggodhoon.chat.domain.Message;
import gmail.kinggodhoon.chat.domain.User;

public interface LogService {
	public int writeLog(User user, Message message);
	
}
