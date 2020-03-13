package gmail.kinggodhoon.chat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gmail.kinggodhoon.chat.dao.LogDao;
import gmail.kinggodhoon.chat.domain.Log;
import gmail.kinggodhoon.chat.domain.Message;
import gmail.kinggodhoon.chat.domain.User;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDao logDao;
	
	@Override
	public int writeLog(User user, Message message) {
		int result = 0;
		
		//채팅
		if(message.getType() == 1) {
			Log log = new Log();
			
			log.setRoomid(message.getRoomid());
			log.setUserid(user.getUserid());
			log.setContent(message.getContent());
			
			result = logDao.chat(log);
		}
		//입장
		else if(message.getType() == 2) {
			Log log = new Log();
			
			log.setRoomid(message.getRoomid());
			log.setUserid(user.getUserid());
			
			result = logDao.enter(log);
		}
		//퇴장
		else {
			Log log = new Log();
			
			log.setRoomid(message.getRoomid());
			log.setUserid(user.getUserid());
			
			result = logDao.exit(log);
		}
		
		return result;
	}

}
