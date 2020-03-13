package gmail.kinggodhoon.chat.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gmail.kinggodhoon.chat.domain.Log;

@Repository
public class LogDao {

	@Autowired
	private SqlSession sqlSession;
	
	//입장 로그 저장
	public int enter(Log log) {
		return sqlSession.insert("log.enter", log);
	}
	
	//퇴장 로그 저장
	public int exit(Log log) {
		return sqlSession.insert("log.exit", log);
	}
	
	//채팅 로그 저장
	public int chat(Log log) {
		return sqlSession.insert("log.chat",log);
	}
	
}
