
package com.myfun.utils;

import java.util.Collection;
import java.util.Map;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.myfun.framework.exception.AssertException;


/**
 * 断言，会以提示性的文案返回给前端
 * @author 张宏利
 * @since 2017年2月25日
 */
public abstract class Assert {
	
	/**
	 * 为true时抛异常
	 * @author 张宏利
	 * @param expression
	 * @param message
	 */
	public static void isTrueThrow(boolean expression, String message) {
		if (expression) {
			throw new AssertException(message);
		}
	}

	public static void isTrueThrow(boolean expression) {
		isTrueThrow(expression, "对象必须为真");
	}
	
	/**
	 * 为空时抛异常
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	public static void isNullThrow(Object object, String message) {
		if (object == null) {
			throw new AssertException(message);
		}
	}


	/**
	 * @tag 字符串不能为空
	 * @author 邓永洪
	 * @since 2019/1/9
	 */
	public static void isBlankThrow(String str, String message) {
		if (StringUtils.isEmpty(str)) {
			throw new AssertException(message);
		}
	}

	/**
	 * 为空时抛异常
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	public static void isNullThrow(Object object) {
		isNullThrow(object, "对象不能为空");
	}

	/**
	 * 不为空时抛异常
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	public static void notNullThrow(Object object, String message) {
		if (object != null) {
			throw new AssertException(message);
		}
	}

	/**
	 * 不为空时抛异常
	 * @author 张宏利
	 * @since 2017年10月16日
	 */
	public static void notNullThrow(Object object) {
		notNullThrow(object, "对象必须为空");
	}

	public static void hasLength(String text, String message) {
		if (!StringUtils.hasLength(text)) {
			throw new AssertException(message);
		}
	}

	public static void hasLength(String text) {
		hasLength(text, "对象长度不满足");
	}

	public static void hasText(String text, String message) {
		if (!StringUtils.hasText(text)) {
			throw new AssertException(message);
		}
	}

	public static void hasText(String text) {
		hasText(text, "对象必须包含字符串");
	}

	public static void doesNotContain(String textToSearch, String substring, String message) {
		if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) &&
				textToSearch.contains(substring)) {
			throw new AssertException(message);
		}
	}

	public static void doesNotContain(String textToSearch, String substring) {
		doesNotContain(textToSearch, substring, "对象必须包含字符串");
	}

	public static void notEmpty(Object[] array, String message) {
		if (ObjectUtils.isEmpty(array)) {
			throw new AssertException(message);
		}
	}

	public static void notEmpty(Object[] array) {
		notEmpty(array, "对象不能为空");
	}

	public static void noNullElements(Object[] array, String message) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new AssertException(message);
				}
			}
		}
	}

	public static void noNullElements(Object[] array) {
		noNullElements(array, "存在为空对象");
	}

	public static void isEmptyThrow(Collection<?> collection, String message) {
		if (CollectionUtils.isEmpty(collection)) {
			throw new AssertException(message);
		}
	}

	public static void isEmptyThrow(Collection<?> collection) {
		isEmptyThrow(collection, "对象不能为空");
	}

	public static void notEmpty(Map<?, ?> map, String message) {
		if (CollectionUtils.isEmpty(map)) {
			throw new AssertException(message);
		}
	}

	public static void notEmpty(Map<?, ?> map) {
		notEmpty(map, "对象不能为空");
	}

	public static void isInstanceOf(Class<?> clazz, Object obj) {
		isInstanceOf(clazz, obj, "");
	}

	public static void isInstanceOf(Class<?> type, Object obj, String message) {
		isNullThrow(type, "对象不能为空");
		if (!type.isInstance(obj)) {
			throw new AssertException(
					(StringUtils.hasLength(message) ? message + " " : "") +
					"Object of class [" + (obj != null ? obj.getClass().getName() : "null") +
					"] must be an instance of " + type);
		}
	}

	public static void isAssignable(Class<?> superType, Class<?> subType) {
		isAssignable(superType, subType, "");
	}

	public static void isAssignable(Class<?> superType, Class<?> subType, String message) {
		isNullThrow(superType, "对象不能为空");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw new AssertException((StringUtils.hasLength(message) ? message + " " : "") +
					subType + " is not assignable to " + superType);
		}
	}

	public static void state(boolean expression, String message) {
		if (!expression) {
			throw new AssertException(message);
		}
	}

	public static void state(boolean expression) {
		state(expression, "状态必须为真");
	}

}
