package com.myfun.utils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang.StringUtils;

public class Pinyin4jUtil {

	/**
	 * 字符串集合转换字符串(逗号分隔)
	 * 
	 * @author wyh
	 * @param stringSet
	 * @return
	 */
	public static String makeStringByStringSet(Set<String> stringSet) {
		StringBuilder str = new StringBuilder();
		int i = 0;
		for (String s : stringSet) {
			if (i == stringSet.size() - 1) {
				str.append(s);
			} else {
				str.append(s + ",");
			}
			i++;
		}
		return str.toString().toLowerCase();
	}

	/**
	 * 获取拼音集合
	 * 
	 * @author wyh
	 * @param src
	 * @return Set<String>
	 */
	public static Set<String> getPinyin(String src) {
		if (StringUtils.isNotBlank(src)) {
			char[] srcChar;
			srcChar = src.toCharArray();
			// 汉语拼音格式输出类
			HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();

			// 输出设置，大小写，音标方式等
			hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
			hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			hanYuPinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);

			String[][] temp = new String[src.length()][];
			for (int i = 0; i < srcChar.length; i++) {
				char c = srcChar[i];
				// 是中文或者a-z或者A-Z转换拼音(我的需求，是保留中文或者a-z或者A-Z)
				if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {
					try {
						temp[i] = PinyinHelper.toHanyuPinyinStringArray(srcChar[i], hanYuPinOutputFormat);
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						e.printStackTrace();
					}
				} else if (((int) c >= 65 && (int) c <= 90) || ((int) c >= 97 && (int) c <= 122)) {
					temp[i] = new String[] { String.valueOf(srcChar[i]) };
				} else {
					temp[i] = new String[] { "" };
				}
			}
			String[] pingyinArray = Exchange(temp);
			Set<String> pinyinSet = new HashSet<String>();
			for (int i = 0; i < pingyinArray.length; i++) {
				pinyinSet.add(pingyinArray[i]);
			}
			return pinyinSet;
		}
		return null;
	}

	/**
	 * 递归
	 * 
	 * @author wyh
	 * @param strJaggedArray
	 * @return
	 */
	public static String[] Exchange(String[][] strJaggedArray) {
		String[][] temp = DoExchange(strJaggedArray);
		return temp[0];
	}

	/**
	 * 递归
	 * 
	 * @author wyh
	 * @param strJaggedArray
	 * @return
	 */
	private static String[][] DoExchange(String[][] strJaggedArray) {
		int len = strJaggedArray.length;
		if (len >= 2) {
			int len1 = strJaggedArray[0].length;
			int len2 = strJaggedArray[1].length;
			int newlen = len1 * len2;
			String[] temp = new String[newlen];
			int Index = 0;
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					temp[Index] = strJaggedArray[0][i] + strJaggedArray[1][j];
					Index++;
				}
			}
			String[][] newArray = new String[len - 1][];
			for (int i = 2; i < len; i++) {
				newArray[i - 1] = strJaggedArray[i];
			}
			newArray[0] = temp;
			return DoExchange(newArray);
		} else {
			return strJaggedArray;
		}
	}

	public static String getTopPinyin(String chinese) {
		return getPinyin(chinese).iterator().next();

	}

	/**
	 * 汉字转换位汉语拼音首字母，英文字符不变
	 * 
	 * @param chines
	 *            汉字
	 * @return 拼音
	 */
	public static String converterToFirstSpell(String chines) {
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);
				} catch (Exception e) {
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return StringUtil.isEmpty(pinyinName) ? "" : pinyinName.toUpperCase();
	}

	/**
	 * 汉字转换位汉语拼音，英文字符不变
	 * 
	 * @param chines
	 *            汉字
	 * @return 拼音
	 */
//	static String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t" +
//			"";
	public static String converterToSpell(String chines) {
		String pinyinName = "";
		char[] nameChar = chines.toCharArray();
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		for (int i = 0; i < nameChar.length; i++) {
			if (nameChar[i] > 128) {
				try {
//					String s = String.valueOf(nameChar[i]);
//					if(regEx.contains(s)){// 有特殊字符，不转拼音
//						continue;
//					}

					// 判读字符是不是汉字
					boolean matches = String.valueOf(nameChar[i]).matches("[\u4e00-\u9fa5]");
					if(!matches){
						continue;
					}
					pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];
				} catch (BadHanyuPinyinOutputFormatCombination e) {
					e.printStackTrace();
				}
			} else {
				pinyinName += nameChar[i];
			}
		}
		return pinyinName;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "c";
		String keyWordFirst = converterToFirstSpell(str);

		List<String> list = new LinkedList<String>();
		list.add("陈文超");
		list.add("李四");
		list.add("张三");
		list.add("张三的");
		list.add("张三我");
		list.add("C");
		list.add("曾旺");
		for (int i = 0; i < list.size(); i++) {
			String userNameFirst = Pinyin4jUtil.converterToFirstSpell(list.get(i));
			System.out.println(list.get(i) + "  " + userNameFirst + "  " + keyWordFirst);
			if (!list.get(i).startsWith(str) || !userNameFirst.startsWith(keyWordFirst)) {
				list.remove(i);
				i--;
				continue;
			}
		}
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println(Character.isLetter('c'));
		System.out.println(Character.isLetter('C'));
	}

}
