package com.myfun.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang.StringUtils;

import com.myfun.framework.config.AppConfig;

/**
 * 字符串操作类
 * 
 * @ClassName: StringUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:09:14
 *
 */
public final class StringUtil {
	private static char chars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private static int char_length = chars.length;

	private StringUtil() {
		throw new AssertionError();
	}

	/**
	 * <p>
	 * isEmpty(null) true<br/>
	 * isEmpty("") true<br/>
	 * isEmpty("null") false<br/>
	 * isEmpty(" ") false<br/>
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || str.length() == 0;
	}

	/**
	 * <p>
	 * isEmpty(null) false<br/>
	 * isEmpty("") false<br/>
	 * isEmpty("null") true<br/>
	 * isEmpty(" ") true<br/>
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * <p>
	 * isEmpty(null) true<br/>
	 * isEmpty("") true<br/>
	 * isEmpty("null") false<br/>
	 * isEmpty(" ") true<br/>
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int strLen;
		if (null == str || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	/**
	 * <p>
	 * isEmpty(null) false<br/>
	 * isEmpty("") false<br/>
	 * isEmpty("null") true<br/>
	 * isEmpty(" ") false<br/>
	 * </p>
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	/**
	 * 是否有不为空的字符串，有一个字符串不为空返回true
	 * @author 张宏利
	 * @since 2018年5月10日
	 * @param str
	 * @return
	 */
	public static boolean isHaveNotBlank(String... str) {
		boolean flag = false;
		for (String string : str) {
			if (isNotBlank(string)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	/**
	 * lcb 字符串检测
	 **/
	public static boolean isNotBlank(String... str) {
		boolean flag = true;
		for (String string : str) {
			if (isBlank(string)) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * 判断字符是否为中文字符
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
			return true;
		}
		return false;
	}

	/**
	 * 将第一个字符转换成大写<br/>
	 * 如：abc转换后：Abc,1ab转换后:1ab
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 转换后的字符串
	 */
	public static String capitalize(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return str;
		}
		return new StringBuilder(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
	}

	/**
	 * 生成随机字符串
	 * 
	 * @param length
	 *            字符串长度
	 * @return
	 */
	public static String randomString(int length) {
		StringBuilder builder = new StringBuilder(length);
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			builder.append(random.nextInt(char_length));
		}
		return builder.toString();
	}

	/**
	 * 将字符串转换成整形
	 * 
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public static Integer parseInteger(Object obj, Integer defVal) {
		if(obj == null) {
			return defVal;
		}
		if(obj instanceof Integer) {
			return (Integer) obj;
		}
		if(obj instanceof Double) {
			return ((Double) obj).intValue();
		}
		if(obj instanceof Byte) {
			return ((Byte) obj).intValue();
		}
		if(obj instanceof Float) {
			return ((Float) obj).intValue();
		}
		if(obj instanceof String) {
			if (StringUtils.isNotEmpty(obj.toString())) {
				return Integer.valueOf(obj.toString());
			} else {
				return defVal;
			}
		}
		
		String strTemp = (obj instanceof String) ? (String) obj : obj.toString();
		if (isEmpty(strTemp)) {
			return defVal;
		}
		try {
			return Double.valueOf(strTemp).intValue();
		} catch (Exception e) {
			return defVal;
		}
	}

	/**
	 * @see StringUtil#parseInteger(String, int)
	 * @param str
	 * @return
	 */
	public static Integer parseInteger(Object str) {
		return parseInteger(str, 0);
	}

	/**
	 * 字符串转换成double
	 * 
	 * @param str
	 * @param defVal
	 *            转换失败默认值
	 * @return
	 */
	public static Double parseDouble(String str, double defVal) {
		if (isEmpty(str)) {
			return defVal;
		}
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return defVal;
		}
	}

	/**
	 * @see StringUtil#parseDouble(String, double)
	 * @param str
	 * @return
	 */
	public static Double parseDouble(String str) {
		return parseDouble(str, 0.0);
	}

	public static BigDecimal parseBigDecimal(String str) {
		return parseBigDecimal(str, new BigDecimal(0.0));
	}

	public static BigDecimal parseBigDecimal(String str, BigDecimal def) {
		try {
			return BigDecimal.valueOf(parseDouble(str));
		} catch (Exception e) {
			return def;
		}
	}

	/**
	 * 获取uuid 并去掉-
	 * 
	 * @return
	 */
	public static String getUUIDBySub() {
		String result = getUUID();
		return result.replace("-", "");
	}

	/**
	 * 获取uuid
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static Long parseLong(String str, long defVal) {
		if (isEmpty(str)) {
			return defVal;
		}
		try {
			return Long.parseLong(str);
		} catch (Exception e) {
			return defVal;
		}
	}

	public static String getFileSub(String fileName) {
		String result = "";
		if (isNotEmpty(fileName)) {
			int index = fileName.lastIndexOf(".");
			if (index >= 0) {
				result = fileName.substring(index + 1, fileName.length());
			}
		}
		return result;
	}

	public static Long parseLong(String str) {
		return parseLong(str, 0);
	}

	public static Byte parseByte(String str) {
		return parseByte(str, (byte) 0);
	}

	public static Byte parseByte(String str, Byte def) {
		try {
			return Byte.parseByte(str);
		} catch (Exception e) {
			return def;
		}
	}

	public static boolean containerValue(Byte[] array, Byte value) {
		if (array != null && array.length > 0) {
			for (Byte val : array) {
				if (val == value) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 将一个给定的字符串，用给定的分隔符字符串（或字符串模式）分拆成字符串数组。 不使用中正则表达式
	 * 
	 * @param list
	 *            给定的字符串
	 * @param seperator
	 *            分隔符字符串
	 * @return 返回分隔成功后的字符串数组，如果字符串无法用给定的分隔符分拆，返回一 个大小为0的字符串数组。
	 */
	public static String[] split(String list, String seperator) {
		return split(list, seperator, false);
	}

	/**
	 * 将一个给定的字符串，用给定的分隔符字符串（或字符串模式）分拆成字符串数组。 不使用中正则表达式
	 * 
	 * @param list
	 *            给定的字符串
	 * @param seperator
	 *            分隔符字符串
	 * @param include
	 *            在新生成的数组中是否包含seperator串
	 * @return 返回分隔成功后的字符串数组，如果字符串无法用给定的分隔符分拆，返回一 个大小为0的字符串数组。
	 */
	public static String[] split(String list, String seperator, boolean include) {
		StringTokenizer tokens = new StringTokenizer(list, seperator, include);
		String[] result = new String[tokens.countTokens()];
		int i = 0;
		while (tokens.hasMoreTokens()) {
			result[i++] = tokens.nextToken();
		}
		return result;
	}

	/**
	 * 转json
	 * 
	 * @param <T>
	 * @param success
	 * @param msg
	 * @param data
	 * @return
	 */
	public static <T> String StringToJson(int success, String msg, List<T> data) {
		return "{\"code\" : \"" + success + "\", \"msg\" : \"" + msg + "\", \"data \": \"" + data + "\"}";
	}

	public static <T> String StringToJson(int success, String msg, List<T> data, String flag) {
		return "{\"code\" : \"" + success + "\", \"msg\" : \"" + msg + "\", \"data \": \"" + data + "\", \"flag \": \"" + flag + "\"}";
	}

	public static String htmlspecialchars(String str) {
		if (isEmpty(str)) {
			return str;
		}
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}

	/**
	 * 将异常信息转化为String
	 * 
	 * @param e
	 * @return
	 */
	public static String exceptionStackToString(Throwable e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (pw != null) {
				pw.close();
			}
		}
		return sw.toString();
	}

	/**
	 * 地址重复判断补位 参考： Constants_DIC.DIC_ROOF_REPEAT_LENGTH_LIMIT
	 * Constants_DIC.DIC_UNIT_REPEAT_LENGTH_LIMIT
	 * Constants_DIC.DIC_FLOOR_REPEAT_LENGTH_LIMIT
	 * Constants_DIC.DIC_NUM_REPEAT_LENGTH_LIMIT
	 * 
	 * @author 陈文超
	 * @date Dec 19, 2015 2:09:38 PM
	 */
	public static String convertStr(String sourceStr, int length) {
		if (sourceStr == null)
			return null;
		// 如果全是不复合规则的值，直接返回。
		if (!sourceStr.matches("^[A-Z0-9]+$")) {
			// 不满足规则的 举例：提交上来的数据全部是中文或者不是全部由字母和数字组成。符合规则的栋座号：ABCD1231
			return sourceStr;
		}
		while (sourceStr.length() < length) {
			sourceStr = "0" + sourceStr;
		}
		char[] sourceChars = sourceStr.toCharArray();
		for (int i = 0; i < sourceChars.length; i++) {
			if (sourceChars[i] >= 65 && sourceChars[i] <= 73) {
				sourceChars[i] = (char) ((int) sourceChars[i] - 16);
			}
		}
		return new String(sourceChars);
	}

	public static Object Copy(Object source, Object dest) throws Exception {
		// 获取属性
		BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), java.lang.Object.class);
		PropertyDescriptor[] sourceProperty = sourceBean.getPropertyDescriptors();

		BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), java.lang.Object.class);
		PropertyDescriptor[] destProperty = destBean.getPropertyDescriptors();

		try {
			for (int i = 0; i < sourceProperty.length; i++) {

				for (int j = 0; j < destProperty.length; j++) {

					if (sourceProperty[i].getName().equals(destProperty[j].getName())) {
						// 调用source的getter方法和dest的setter方法
						destProperty[j].getWriteMethod().invoke(dest, sourceProperty[i].getReadMethod().invoke(source));
						break;
					}
				}
			}
			return dest;
		} catch (Exception e) {
			throw new Exception("属性复制失败:" + e.getMessage());
		}
	}

	public static String replaceString(String source, String oldstring, String newstring) {
		Matcher m = Pattern.compile(oldstring, Pattern.CASE_INSENSITIVE).matcher(source);
		String result = m.replaceAll(newstring);
		return result;
	}

	/**
	 * 转换字符串，为空时返回defVal !=null && != "" && != "  "
	 * 
	 * @param source
	 *            需要判断的字段
	 * @param defVal
	 *            为空时返回的默认值
	 * @return
	 */
	public static String getBlankStr(Object source, String defVal) {
		if (source == null) {
			return defVal;
		}
		String val = String.valueOf(source);
		if (isBlank(val)) {
			return defVal;
		}
		return val;
	}

	public static String parseHTML(String source) {
		if (source != null && !"".equals(source)) {
			source = source.replaceAll("&lt;", "<");
			source = source.replaceAll("&gt;", ">");
			// source = source.replaceAll("&nbsp;"," ");//取消此项的原因是：网页中的半角空格会被忽略
			source = source.replaceAll("&quot;", "\"");
			source = source.replaceAll("&#39;", "'");
			source = source.replaceAll("&#34;", "\"");
			source = source.replaceAll("<BR><P>[\\s]*(?:&nbsp;)*[\\s]*</P><BR>|<br><p>[\\s]*(?:&nbsp;)*[\\s]*</p><br>", "");
			source = source.replaceAll("</P><BR>|</p><br>", "</p>");
			source = source.replaceAll("<P><BR>|<p><br>", "<p>");
			source = source.replaceAll("(<BR>|<BR/>|<br>|<br/>)+", "<br>");
		} else {
			source = "";
		}
		return source;
	}

	/**
	 * 将map翻译成字典序利
	 * 
	 * @param map
	 * @return
	 */
	public static String getMapSequenceUtil(HashMap<String, Object> map) {
		Collection<String> keyset = map.keySet();
		List<String> list = new ArrayList<String>(keyset);

		// 对key键值按字典升序排序
		Collections.sort(list);

		String param = "";
		for (int i = 0; i < list.size(); i++) {
			param += list.get(i) + "=" + map.get(list.get(i)) + "&";
		}
		if (!"".equals(param)) {
			param = param.substring(0, param.length() - 1);
		}
		return param;
	}

	public static String getRStr(String text, int len) {
		StringBuilder result = new StringBuilder();
		try {
			int strLen = text.getBytes("GBK").length;
			if (strLen >= len) {
				return text;
			}

			int leftLen = len - strLen;
			if (leftLen > 2) {
				result.append("&nbsp;&nbsp;");
				leftLen -= 2;
			}
			result.append(text);
			for (int i = 0; i < leftLen; i++) {
				result.append("&nbsp;");
			}
			return result.toString();
		} catch (UnsupportedEncodingException e) {
			return "&nbsp;";
		}
	}

	/**
	 * 金额保留两位小数
	 * 
	 * @param doubleVal
	 * @return
	 */
	public static double doubleFormat(double doubleVal) {
		DecimalFormat df = new DecimalFormat("######0.00");
		String str = df.format(doubleVal);
		return parseDouble(str);
	}

	/**
	 * 将电话加密
	 * 
	 * @param mobile
	 *            电话号码
	 * @param cha
	 *            替换的字符
	 * @param start
	 *            开始
	 * @param end
	 *            结束
	 * @return
	 */
	public static String encodeMobile(String mobile, String cha, int start, int length) {
		StringBuilder sb = new StringBuilder();
		if (StringUtil.isNotEmpty(mobile) && (mobile.length() >= 8)) {
			sb.append(mobile.substring(0, start));
			for (int i = 0; i < length; i++) {
				sb.append(cha);
			}
			sb.append(mobile.substring(start+length));
		}
		return sb.length() > 0 ? sb.toString() : mobile;
	}

	public static String encodeMobile(String mobile) {
		return encodeMobile(mobile, "*", 3, 5);
	}
	

	/**
	 * 讲字符串转换成整形
	 * 
	 * @param str
	 * @return
	 */
	public static Integer paseInteger(String str) {
		if ((str == null) || ("null".equals(str))) {
			return null;
		} else if ("".equals(str)) {
			return 0;
		} else {
			try {
				return Integer.parseInt(str);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	/**
	 * 讲字符串转换成整形
	 * 
	 * @param str
	 * @param defVal
	 *            转换失败默认值
	 * @return
	 */
	public static Integer paseInteger(String str, Integer defVal) {
		if ((str == null) || "null".equals(str) || "".equals(str)) {
			return defVal;
		} else {
			try {
				return Integer.parseInt(str);
			} catch (Exception e) {
				e.printStackTrace();
				return defVal;
			}
		}
	}
	
	/**
	 * 获取错误信息
	 * @author 张宏利
	 * @since 2017年4月1日
	 * @param e
	 * @return
	 */
	public static String getException(Throwable e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			pw.flush();
			sw.flush();
			return sw.toString();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			if (pw != null) {
				pw.close();
			}
		}
	}
	public static boolean contains(String str, String[] strings) {
		if(str == null || strings == null || strings.length <= 0){
			return false;
		}
		for (String string : strings) {
			if(str.equals(string)){
				return true;
			}
		}
		return false;
	}

	public static byte[] getUtf8Byte(String src) {
		try {
			return src.getBytes("utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getUtf8String(byte[] src) {
		try {
			return new String(src, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取6位长度的数字
	 * @author 张宏利
	 * @return
	 */
	public static String getCode6() {
		Integer randomKey = (int) (Math.random() * 900000 + 100000);
		return String.valueOf(randomKey);
	}
	
	/**
	 * 获取不为空的对象
	 * @param code
	 * @return
	 */
	public static Object getNotNullObj(Object source, Object defult) {
		if(source == null) {
			return defult;
		}
		return source;
	}
	
	/**
	 * 用于分割过长的IDs，用于解决in查询时超过2000个ID就会报错的问题
	 * @param keys 需要分割的长数组
	 * @param cutLen 分割后的小数组长度，如果 <=0 则默认1500
	 * @return
	 * @author 张宏利
	 */
	public static String[][] getCutArr(String[] keys, int cutLen){
		int subCloumLen = 1500;
		if(cutLen > 0) {
			subCloumLen = cutLen;
		}
		if(keys == null || keys.length <= 0){
			return new String[0][0];
		}
		int length = keys.length;
		int count = length / subCloumLen;
		int lastCount = length % subCloumLen;
		if(lastCount > 0) {
			count++;
		}
		String[][] arrResult = new String[count][];
		for (int i = 0; i < count; i++) {
			String[] subIds;
			if(i == count-1 && lastCount > 0) {
				subIds = new String[lastCount];// 末尾剩余的不足1500的部分
			} else {
				subIds = new String[subCloumLen];// 长度为1500的部分
			}
			for (int j = 0; j < subIds.length; j++) {
				subIds[j] = keys[(i*subCloumLen)+j];// 分割数组
			}
			arrResult[i] = subIds;
		}
		return arrResult;
	}

	public static String changeUnderLine(String tfStr) {
		if(tfStr.contains("_")) {
			tfStr = tfStr.toLowerCase();
			String[] split = tfStr.split("_");
			String field = split[0];
			for (Integer i=1;i<split.length;i++) {
				field = field + StringUtils.capitalize(split[i]);
			}
			return field;
		}
		return tfStr;
	}
	
	/**
	 * 将HTML标签替换为空串
	 * @author 陈文超
	 * @date 2017年2月14日 上午11:31:42
	 */
	public static String replaceHtmlToBlank(String sourceStr) {
		String textStr = "";
		if (!StringUtil.isEmpty(sourceStr)) {
			String htmlStr = sourceStr; // 含html标签的字符串
			java.util.regex.Pattern p_script;
			java.util.regex.Matcher m_script;
			java.util.regex.Pattern p_style;
			java.util.regex.Matcher m_style;
			java.util.regex.Pattern p_html;
			java.util.regex.Matcher m_html;
			
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;
		}
		return textStr;
	}


	/**
	 * @author 邓永洪
	 * @since 2018/4/13
	 * @tag 根域名+地址拼接
	 */
	public static String getPhotoUrl(String housePhoto) {
		if (StringUtils.isBlank(housePhoto)) {
			return null;
		}
		if (housePhoto.startsWith("http://")) {
			return housePhoto;
		}

		return (AppConfig.getPicDomainUrl()+housePhoto).replaceAll("\\\\", "/");
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/16
	 * @tag 拼接头像地址
	 */
	public static String getBbsPhoto(String bbsPhoto) {
		if (StringUtils.isBlank(bbsPhoto)) {
			return null;
		}
		if (bbsPhoto.startsWith("http://")) {
			return bbsPhoto;
		}
		if (bbsPhoto.startsWith("oss")) {
			return (AppConfig.getPicDomainUrl()+bbsPhoto).replaceAll("\\\\", "/");
		} else {
			return (AppConfig.getHousePicDomainUrl()+bbsPhoto).replaceAll("\\\\", "/");
		}
	}
	
	/**
	 * 处理字符串为整形list，必须是英文逗号分隔
	 * 传入：1,3,5，结果：Integer[]{1,3,5}
	 * @author 张宏利
	 * @since 2018年4月28日
	 * @param source
	 * @return
	 */
	public static List<Integer> toIntList(String source) {
		return toIntList(source, ",");
	}
	
	/**
	 * 处理字符串为整形list
	 * 传入：1,3,5，结果：List&lt;Integer&gt;{1,3,5}
	 * @author 张宏利
	 * @since 2018年4月28日
	 * @param source 1,3,5
	 * @param split 分隔方式
	 * @return
	 */
	public static List<Integer> toIntList(String source, String split) {
		List<Integer> intList = new ArrayList<>();
		if (StringUtils.isBlank(source)) {
			return intList;
		}
		String[] idsArr = source.split(split);
		for (String userIds : idsArr) {
			Integer intTmp = StringUtil.parseInteger(userIds);
			if (intTmp > 0) {
				intList.add(intTmp);
			}
		}
		return intList;
	}


	public static List<String> toStringList(String source, String split) {
		List<String> stringList = new ArrayList<>();
		if (StringUtils.isBlank(source)) {
			return stringList;
		}
		String[] idsArr = source.split(split);
		return Arrays.asList(idsArr);
	}


	/**
	 * 
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return
	 * 
	 */
	public static String toString(Object str) {
		return toString(str, null);
	}
	
	
	
	/**
	 *
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return
	 *
	 */
	public static String toString(Object str,String ref) {
		if (str == null) {
			return ref;
		}
		return str.toString();
	}

	/**
	 * @tag Int数组转字符串
	 * @author 邓永洪
	 * @since 2018/5/4
	 */
	public static String intArr2String(Integer [] arr,CharSequence sequence){
		StringJoiner joiner=new StringJoiner(sequence);
		for (Integer i:arr){
			joiner.add(String.valueOf(i));
		}
		return joiner.toString();
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/25
	 * @tag string数组转Integer数组
	 */
	public static Integer[] stringToInt(String[] arrs){
		Integer[] ints = new Integer[arrs.length];
		for(int i=0;i<arrs.length;i++){
			ints[i] = Integer.parseInt(arrs[i]);
		}
		return ints;
	}

	/**
	 * 字符串转换成double
	 *
	 * @param str
	 * @param defVal
	 *            转换失败默认值
	 * @return
	 */
	public static Double paseDouble(String str, Double defVal) {
		if ((str == null) || "null".equals(str) || "".equals(str)) {
			return defVal;
		} else {
			try {
				return Double.parseDouble(str);
			} catch (Exception e) {
				return defVal;
			}
		}
	}

	/**
	 * 字符串转换成double
	 *
	 * @param str
	 * @return
	 */
	public static Double paseDouble(String str) {
		if ((str == null) || ("null".equals(str))) {
			return null;
		} else if ("".equals(str)) {
			return 0D;
		} else {
			try {
				return Double.parseDouble(str);
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * 判定字符串第一个字符到非0字符的数量
	 * @author  He Wei
	 * @create  2019/10/9 19:02
	 **/
	public static String judgeZeroQuantity(String str){
		String zeroNum="";
		int num = 0;
		if(isEmpty(str)){
			return zeroNum ;
		}
		char[] chars = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if(!"0".equals(chars[i]+"")){
				break;
			}
			num++;
		}
		for (int i = 0; i < num; i++) {
			zeroNum+="0";
		}
		return zeroNum ;
	}

	public static String getMethodName(String filedName) {
		StringBuilder sb = new StringBuilder();
		filedName = filedName.toLowerCase();
		String[] split = filedName.split("_");
		for (Integer i = 0; i< split.length; i++) {
			sb.append(StringUtils.capitalize(split[i]));
		}
		return "get"+sb.toString();
	}

	public static String setMethodName(String filedName) {
		StringBuilder sb = new StringBuilder();
		filedName = filedName.toLowerCase();
		String[] split = filedName.split("_");
		for (Integer i = 0; i< split.length; i++) {
			sb.append(StringUtils.capitalize(split[i]));
		}
		return "set"+sb.toString();
	}

	/**
	 * 生成安装密码
	 */
	public static String generateInstallPwd(int strLength) throws Exception {
		// 因1与l不容易分清楚，所以去除

		String strChar = "1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,";
		String[] aryChar = strChar.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strLength; i++) {
			sb.append(aryChar[(int) (Math.random() * strChar.length() / 2)]);
		}
		return sb.toString();
	}

	/**
	 * 得到中文首字母,例如"专科"得到zk返回
	 *
	 * @param str 中文字符串
	 * @return
	 */
	public static String getPinYinHeadChar(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char word = str.charAt(i);
			String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
			if (pinyinArray != null) {
				sb.append(pinyinArray[0].charAt(0));
			} else {
				sb.append(word);
			}
		}
		return sb.toString();
	}

}
