package com.myfun.framework.web.aspect;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheEvictMatchKey {
	String[] key() default{};
}
