package kr.co.narrator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.narrator.model.UserVO;
import kr.co.narrator.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Inject
	private UserService userService;

	/*
	private final UserService userService;
	
	@Inject
	public UserController(UserService userService) {
		this.userService = userService;
	}
	*/

	// 회원가입 페이지
	@RequestMapping(value = "/getRegister", method = RequestMethod.GET)
	public String getRegister() throws Exception {
		return "user/getRegister";
	}

	@RequestMapping(value = "/getUserList", method = RequestMethod.GET)
	public String getUserList(Model model) throws Exception {
		logger.info("getUserList();...");
		
		model.addAttribute("userList", userService.getUserList());
		
		return "user/userList";
	}

	// 회원가입 처리
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute("userVO") UserVO userVO, RedirectAttributes rttr) throws Exception {

		String hashedPw = BCrypt.hashpw(userVO.getPwd(),  BCrypt.gensalt());
		userVO.setPwd(hashedPw);
		userService.insertUser(userVO);
		rttr.addFlashAttribute("msg", "REGISTED");
		return "redirect:/user/getUserList";
	}

	@RequestMapping(value = "/signupForm", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		logger.info("LoginController - signupForm");
		model.addAttribute("userVO", new UserVO());
		return "user/signupForm";
	}

	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");
		
		HttpSession session = req.getSession();
		UserVO login = userService.login(userVO);
		
		if(login == null) {
			session.setAttribute("member",  null);
			rttr.addFlashAttribute("msg", false);
		} else {
			session.setAttribute("member",  login);
		}
		return "redirect:/login/login";
	}
	*/

}
