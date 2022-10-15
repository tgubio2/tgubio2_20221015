package kr.co.narrator.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.narrator.model.LoginDTO;
import kr.co.narrator.model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Inject
	private SqlSession sqlSession;
/*
	private final SqlSession sqlSession;

	@Inject
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
*/

	@Override
	public List<UserVO> getUserList() throws Exception {
		return sqlSession.selectList("kr.co.narrator.userMapper.getUserList");
	}
	
	@Override
	public UserVO getUserInfo(String uid) throws Exception {
		return sqlSession.selectOne("kr.co.narrator.userMapper.getUserInfo", uid);
	}
	
	// 회원가입처리
	@Override
	public int insertUser(UserVO userVO) throws Exception {
		return sqlSession.insert("kr.co.narrator.userMapper.insertUser", userVO);
	}
	
	@Override
	public int updateUser(UserVO userVO) throws Exception {
		return sqlSession.update("kr.co.narrator.userMapper.updateUser", userVO);
	}
	
	@Override
	public int deleteUser(String uid) throws Exception {
		return sqlSession.delete("kr.co.narrator.userMapper.deleteUser", uid);
	}

	// 회원가입
	@Override
	public void register(UserVO userVO) throws Exception {
		sqlSession.insert("kr.co.narrator.userMapper.insertUser", userVO);
	}

	// 로그인
	@Override
	//public UserVO login(UserVO userVO) throws Exception {
	//	return sqlSession.selectOne("kr.co.narrator.userMapper.login", userVO);
	//}
	public UserVO login(LoginDTO loginDTO) throws Exception {
		return sqlSession.selectOne("kr.co.narrator.userMapper.login", loginDTO);
	}

}