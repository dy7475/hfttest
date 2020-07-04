package com.myfun.repository.support.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 访问只读数据库 谨慎使用 使用不好会出问题 <br/>
 * 注意：仅用于控制层和service层实现类，不能和更新事物一起
 * 
 * @ClassName: AccessReadonlyDb
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年5月25日 下午10:44:05
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessReadonlyDb {

}
