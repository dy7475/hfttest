package com.myfun.framework.web.aspect;

import java.lang.reflect.Method;

import com.myfun.repository.param.EncryParamIfc;
import com.myfun.utils.BeanUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;

@Aspect
@Component

public class NotBlankAspect {

	@SuppressWarnings("unchecked")
	@Around(value = "@annotation(NotBlank) || @within(NotBlank)")
	public Object authController(ProceedingJoinPoint pjp) throws Throwable {
		Method mth = ((MethodSignature) pjp.getSignature()).getMethod();
		NotBlank auth = mth.getAnnotation(NotBlank.class);// 方法上定义的
		if (auth == null) {
			auth = (NotBlank) pjp.getSignature().getDeclaringType().getAnnotation(NotBlank.class);// 类上定义的
		}
		if (auth != null && auth.value().length > 0) {
			Object[] obj = pjp.getArgs();
			for (Object object : obj) {
				if(object instanceof BaseMapParam) {
					BaseMapParam param = (BaseMapParam)object;
					for (String key : auth.value()) {
						String val = param.getString(key);
						if(StringUtils.isBlank(val)) {
							throw new HttpMessageNotReadableException("Unrecognized field \""+key+"\"");
						}
					}
				}else if (object instanceof EncryParamIfc){// dyh -- 解决新版param NotBlank不生效问题
					for (String key : auth.value()) {
						Object val = BeanUtil.invokeMethodByBaseBeanField(key, object);
						if (val instanceof String) {
							if (StringUtils.isBlank((String) val)) {
								throw new HttpMessageNotReadableException("Unrecognized field \"" + key + "\"");
							}
						}else if(null == val) {
							throw new HttpMessageNotReadableException("Unrecognized field \""+key+"\"");
						}
					}
				}
			}
		}
		return pjp.proceed();
	}
}
