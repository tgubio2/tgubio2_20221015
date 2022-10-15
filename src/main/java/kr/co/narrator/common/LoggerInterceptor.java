package kr.co.narrator.common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	protected final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@SuppressWarnings("rawtypes")
	public boolean perHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("========================= LoggerInterceptor START ===================");
		logger.debug(" URI [{}], " + request.getRequestURI());
		
		Enumeration paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String key = (String) paramNames.nextElement();
			String value = request.getParameter(key);
			logger.debug(" RequestParameter Data ==> " + key + " : " + value + "");
		}
		return super.preHandle(request, response, handler);
	}
	
	public void posHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.debug("=================== LoggerInterceptor END ====================");
	}

}
