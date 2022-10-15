package kr.co.narrator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.narrator.model.UserVO;

@Controller
@RequestMapping(value = "/loginTemp")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/loginTemp", method = RequestMethod.GET)
	public String loginForm(Model model) throws Exception {
		logger.info("LoginController - login");
		model.addAttribute("userVO", new UserVO());
		return "login/login";
	}
	
	@RequestMapping(value = "/signupFormTemp", method = RequestMethod.GET)
	public String signupForm(Model model) throws Exception {
		logger.info("LoginController - signupForm");
		model.addAttribute("userVO", new UserVO());
		return "login/signupForm";
	}

}
