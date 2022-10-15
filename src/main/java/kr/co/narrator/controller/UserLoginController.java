package kr.co.narrator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.narrator.model.LoginDTO;
import kr.co.narrator.model.UserVO;
import kr.co.narrator.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class UserLoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private final UserService userService;
	
	//@Inject
	//private UserService userService;

	@Inject
	public UserLoginController(UserService userService) {
		this.userService = userService;
	}
		
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
		logger.info("login............................");
		return "/login/login";
	}
		
	// 로그인 처리
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO loginDTO, HttpSession httpSession, Model model) throws Exception {
		logger.info("loginPost...............................");
		UserVO userVO = userService.login(loginDTO);
		if(userVO == null || !BCrypt.checkpw(loginDTO.getPwd(),  userVO.getPwd())) {
			return;
		}
		model.addAttribute("user", userVO);
	}

}
