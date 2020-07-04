package com.myfun.framework.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.utils.log.MybatisLogThreadLocal;

/**
 * 请求返回值监控
 * 使用{@link ControllerAspect}类拦截
 * @author lcb
 *
 */
// @Aspect
// @Component
public class ControllerResultMonitorAspect {
	@Around(value = "@annotation(requestMapping) || @within(requestMapping)")
	public Object authController(ProceedingJoinPoint pjp, RequestMapping requestMapping) throws Throwable {
		Object proceed = pjp.proceed();
		if (proceed instanceof ResponseJson) {
			MybatisLogThreadLocal.setThreadLocalAttr("httpRequestResult", JSON.toJSONString(proceed));
		}
		return proceed;
	}
}
