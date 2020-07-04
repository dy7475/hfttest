package com.myfun.framework.web.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.myfun.framework.util.SpringContextUtil;
import com.myfun.repository.admindb.dao.AdminMgFrontTestMapper;
@Component
public class FrontUnitTestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String isFrontTest = request.getHeader("isFrontTest");//是否是前端的单元测试
		if ("1".equals(isFrontTest)) {
			String userMobile = request.getHeader("userMobile");//电话号码
			String requestUrl = request.getRequestURI();
			AdminMgFrontTestMapper adminMgFrontTestMapper = SpringContextUtil.getBean(AdminMgFrontTestMapper.class);
			String responseJson = adminMgFrontTestMapper.selectResponseJsonByUrl(userMobile,requestUrl);
			if (StringUtils.isBlank(responseJson)) {
				return true;
			}
			response.setCharacterEncoding("utf-8");
			PrintWriter writer = response.getWriter();
			writer.print(responseJson);
			writer.flush();
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
