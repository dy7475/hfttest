package com.myfun.framework.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainsiteErrorController implements ErrorController {

	Logger logger = LoggerFactory.getLogger(MainsiteErrorController.class);
	@RequestMapping(value="/error")
	public String handleError(HttpServletRequest request, HttpServletResponse response, Exception e){
		if(response.getStatus() == HttpStatus.NOT_FOUND.value()) {
			logger.error("请求错误，可能的原因：1、请求路径错误，2、页面不存在，错误来源地址："
					+ "\r\nforward_uri=" + request.getAttribute("javax.servlet.forward.request_uri")
					+ "\r\nerror_uri=" + request.getAttribute("javax.servlet.error.request_uri"));
		}else {
			logger.error("导致错误的可能原因:\r\n 1:缺少RequestBody注解");
		}
		return "pages/index";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
