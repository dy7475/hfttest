package com.myfun.repository.support.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.datasource.AccessReadonlyDbHolder;
/**
 * 
* @ClassName: AccessReadonlyDbAspect 
* @Description: TODO
* @author jiangsonggui
* @date 2016年6月5日 上午10:32:26 
*
 */
@Aspect
@Component
public class AccessReadonlyDbAspect {
	@Around("@annotation(readonlyDb)")
	public Object accessReadonlyDb(ProceedingJoinPoint pjp, AccessReadonlyDb readonlyDb) throws Throwable {
		try {
			AccessReadonlyDbHolder.incrAccessDatabaseReadonlyFlag();
			return pjp.proceed();
		} catch (Exception e) {
			throw e;
		} finally {
			AccessReadonlyDbHolder.decrAccessDatabaseReadonlyFlag();
		}
	}
}
