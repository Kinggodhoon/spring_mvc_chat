package gmail.kinggodhoon.chat.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.chat.domain.User;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
//	회원가입
	public int insert(User user) {
		return sqlSession.insert("user.insert",user);
	}
	
//	유저 한명 조회
	public User getUser(String username) {
		return sqlSession.selectOne("user.getUser",username);
	}
	
//	닉네임 중복 체크
	public String checkNick(String nick) {
		return sqlSession.selectOne("user.chkNick",nick);
	}
	
}
