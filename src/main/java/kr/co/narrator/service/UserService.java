package kr.co.narrator.service;

import java.util.List;

import kr.co.narrator.model.LoginDTO;
import kr.co.narrator.model.UserVO;

public interface UserService {

	public List<UserVO> getUserList() throws Exception;
	public UserVO getUserInfo(String uid) throws Exception;
	public void insertUser(UserVO userVO) throws Exception;
	public void updateUser(UserVO userVO) throws Exception;
	public void deleteUser(String uid) throws Exception;

	// 회원가입
	public void register(UserVO userVO) throws Exception;

	// 로그인
	//public UserVO login(UserVO userVO) throws Exception;
	UserVO login(LoginDTO loginDTO) throws Exception;

}
