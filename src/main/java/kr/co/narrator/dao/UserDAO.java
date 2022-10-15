package kr.co.narrator.dao;

import java.util.List;

import kr.co.narrator.model.LoginDTO;
import kr.co.narrator.model.UserVO;

public interface UserDAO {

	public List<UserVO> getUserList() throws Exception;
	public UserVO getUserInfo(String uid) throws Exception;
	public int insertUser(UserVO userVO) throws Exception;
	public int updateUser(UserVO userVO) throws Exception;
	public int deleteUser(String uid) throws Exception;

	// 회원가입
	public void register(UserVO userVO) throws Exception;
	// 로그인
	//public UserVO login(UserVO userVO) throws Exception;
	public UserVO login(LoginDTO loginDTO) throws Exception;

}
