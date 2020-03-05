package gmail.kinggodhoon.chat.service;

import gmail.kinggodhoon.chat.domain.User;

public interface UserService {

//	회원가입
	public int insert(User user);
	
//	아이디 중복 검사
	public boolean checkName(String username);
	
//	닉네임 중복 검사
	public boolean checkNick(String nick);
	
//	로그인
	public User login(User user);
	
}
