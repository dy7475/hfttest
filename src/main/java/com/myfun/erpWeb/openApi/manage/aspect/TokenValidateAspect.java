package com.myfun.erpWeb.openApi.manage.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.exception.SessionTimeoutException;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const.ResponseCode;

@Aspect
@Component
public class TokenValidateAspect {
    @Autowired
    private CacheUtil cacheUtil;
    
	@SuppressWarnings("unchecked")
	@Around(value = "@annotation(TokenValidate) || @within(TokenValidate)")
	public Object authController(ProceedingJoinPoint pjp) throws Throwable {
		Method mth = ((MethodSignature) pjp.getSignature()).getMethod();
		TokenValidate auth = mth.getAnnotation(TokenValidate.class);// 方法上定义的
		if (auth == null) {
			auth = (TokenValidate) pjp.getSignature().getDeclaringType().getAnnotation(TokenValidate.class);// 类上定义的
		}
		String accessToken = null;
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (requestAttributes != null) {
			HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
			if (request != null) {
				accessToken = request.getRequestedSessionId();
			}
		}
		String cacheLogin = cacheUtil.get(CacheStructure.MANAGE_USER_ID + accessToken, String.class);
		if (!"1".equals(cacheLogin)) {
			throw new SessionTimeoutException("获取会话失败", ResponseCode.TOKEN_TIMEOUT);
		}
		return pjp.proceed();
	}
}
