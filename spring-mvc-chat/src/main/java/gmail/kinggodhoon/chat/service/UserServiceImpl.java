package gmail.kinggodhoon.chat.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import gmail.kinggodhoon.chat.dao.UserDao;
import org.springframework.stereotype.Service;

import gmail.kinggodhoon.chat.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public boolean checkName(String username) {
		
		if(userDao.getUser(username) == null) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean checkNick(String nick) {
		
		if(userDao.checkNick(nick) == null) {
			return true;
		}
		
		return false;
	}

	@Override
	public User login(User user) {
		User regUser = userDao.getUser(user.getUsername());
		
		if(regUser != null) {
			if(BCrypt.checkpw(user.getUserpw(), regUser.getUserpw())) {
				regUser.setUserpw(null);
				
				return regUser;
			}
		}
		return null;
	}

}
