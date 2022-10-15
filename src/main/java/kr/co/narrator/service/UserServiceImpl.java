package kr.co.narrator.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.narrator.dao.UserDAO;
import kr.co.narrator.model.LoginDTO;
import kr.co.narrator.model.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Inject
	private UserDAO userDAO;
	
	/*
	private final UserDAO userDAO;
	
	@Inject
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	*/
	
	@Override
	public List<UserVO> getUserList() throws Exception {
		return userDAO.getUserList();
	}
	
	@Override
	public UserVO getUserInfo(String uid) throws Exception {
		return userDAO.getUserInfo(uid);
	}
	
	// 회원 가입 처리
	@Override
	public void insertUser(UserVO userVO) throws Exception {
		userDAO.insertUser(userVO);
	}
	
	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userDAO.updateUser(userVO);
	}
	
	@Override
	public void deleteUser(String uid) throws Exception {
		userDAO.deleteUser(uid);
	}

	// 회원가입
	@Override
	public void register(UserVO userVO) throws Exception {
		userDAO.register(userVO);
	}

	// 로그인
	@Override
	//public UserVO login(UserVO userVO) throws Exception {
	//	return userDAO.login(userVO);
	//}
	public UserVO login(LoginDTO loginDTO) throws Exception {
		logger.info("UserServiceImpl -> UserVO");
		return userDAO.login(loginDTO);
	}

}
