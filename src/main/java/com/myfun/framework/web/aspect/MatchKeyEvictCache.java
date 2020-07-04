package com.myfun.framework.web.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateAwareExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * 李成兵 模糊匹配清除缓存
 *
 *
 * **/
//@Aspect
//@Component
public class MatchKeyEvictCache {

	@Resource(name = "redisTemplate")
	RedisTemplate<String, String> redis;
//	@Pointcut(value = "(execution(* *.*(..)) && "//截获标有@CacheRemove的方法
//			+ "@annotation(com.myfun.framework.web.aspect.CacheEvictMatchKey))")
//
	@Around(value = "@annotation(CacheEvictMatchKey) || @within(CacheEvictMatchKey)")
	public void process(ProceedingJoinPoint joinPoint){
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Object[] args = joinPoint.getArgs();//切面截获方法的参数
		Method method = signature.getMethod();//切面截获方法
		CacheEvictMatchKey cacheRemove = method.getAnnotation(CacheEvictMatchKey.class);//获得注解
		if (cacheRemove != null){
			String[] keys = cacheRemove.key(); //需要移除的正则key
			for(String key:keys) {
				System.out.println(key);
//				List<String> list = descFormat(key);//获得key里面"{?}"的值，我都用数字比如baseButtonList{0}*
//				for (String s : list) {
//					String arg = (String) args[Integer.valueOf(s)];//获得相应的参数
//					key = key.replace("{"+s+"}", arg);  //用参数的值替换key中的{数字}
//				}
//				Set<String> keys2 = redis.keys(key);//获得redis中符合正则的缓存
//				redis.delete(keys2);//删除缓存
			}
		}
	}

}