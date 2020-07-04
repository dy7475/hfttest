/*
 * StringHelper.java	2004-3-5
 *
 * 版权所有: 自由思考组织(FTO)软件团队 2000-2005, 保留所有权利.
 * 这个软件是自由思考组织(FTO)软件团队开发的，如果要使用这个软件，请首先阅读并接受许可协议。
 *
 * Copyright 2000-2005 FTO Software Team, Inc. All Rights Reserved.
 * This software is the proprietary information of FTO Software Team, Inc.
 * Use is subject to license terms.
 *
 * FTO站点：http://www.free-think.org
 */
package com.myfun.utils;

import java.io.Reader;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.regexp.RE;
import org.jdom.Element;
/**
 * 字符串操作助手。提供一些JDK1.3类库中没有提供的一些对字符串操作的方法，<br>
 * 如字符串的正则匹配，查找，分割，连接，格式化等。
 * 
 * 
 * <p><pre><b>
 * 历史更新记录:</b>
 * 2004-03-05  创建此类型
 * 2004-10-02  修改方法: convert(String str, Element esDef)
 * 2008-08-20  增加方法：contains（）
 * 2008-08-20  增加方法：join(),增加additive参数
 * 2008-08-21  增加方法：substring()
 * 
 * </pre></p>
 * 
 * 
 * @author   abnerchai, wenjian
 * @version  1.0
 * @since    JThink 1.0
 * 
 */

public final class StringHelper {

  /** 空串 */
  public static final String EMPTY = ""; 
  
  /** 一个空格 */
  public static final String SPACE = " "; 

	/**
	 *私有化构造器，使之不能获得对象，该类的所有方法均为静态的
	 */
	private StringHelper() {}

	  /**
	   * 串数组的包含检查，检查一个串是否被包含在指定数组中
	   * 
	   * @param strs 被检查的串数组
	   * @param str 被检查的串
	   */
	  public static boolean contains(String[] strs, String str){
	    for(int i=strs.length-1;i>=0;i--){
	      String s = strs[i];
	      if(s==null || str==null){
	        if(s==str){
	          return true;
	        }
	      }else  if(s.equals(str)){
	        return true;
	      }
	    }
	    return false;
	  }
	
    /**
     * 将两个串数组中的对应项连接起来，生成一个新的串数组
     * @param x 串数组
     * @param sep 分隔符
     * @param y 串数组
     * @return 通过数组连接后的串
     */
    public static String[] add(String[] x, String sep, String[] y) {
            String[] result = new String[ x.length ];
            for ( int i=0; i<x.length; i++ ) {
                    result[i] = x[i] + sep + y[i];
            }
            return result;
    }

    /**
     * 重复字符串
     * @param string 串
     * @param times 次数
     * @return 新串
     */
    public static String repeat(String string, int times) {
            StringBuffer buf = new StringBuffer( string.length() * times );
            for (int i=0; i<times; i++) buf.append(string);
            return buf.toString();
    }

    /**
     * 字符串替换, 在串template中查找字串placeholder，并用replacement串替换之。
     * 不支持正则表达式
     * @param template 原串
     * @param placeholder 被替换的串
     * @param replacement 用于替换的串
     * @return 新的被替换过的串
     */
    public static String replace(String template, String placeholder, String replacement) {
            return replace(template, placeholder, replacement, false);
    }

    /**
    * 字符串替换, 在串template中查找字串placeholder，并用replacement串替换之。
    * 不支持正则表达式
    * @param template 原串
    * @param placeholder 被替换的串
    * @param replacement 用于替换的串
    * @param wholeWords 是否匹配整个单字
    * @return 新的被替换过的串
    */
   public static String replace(String template, String placeholder, String replacement, boolean wholeWords) {
      if (template == null || replacement == null || placeholder == null) {
      	throw new IllegalArgumentException("参数不正确,不能是null对象!");
      }

      int loc = template.indexOf(placeholder);
      if (loc<0) {
              return template;
      }
      else {
              final boolean actuallyReplace = !wholeWords ||
                      loc + placeholder.length() == template.length() ||
                      !Character.isJavaIdentifierPart( template.charAt( loc + placeholder.length() ) );
              String actualReplacement = actuallyReplace ? replacement : placeholder;
              return new StringBuffer( template.substring(0, loc) )
                      .append(actualReplacement)
                      .append( replace(
                              template.substring( loc + placeholder.length() ),
                              placeholder,
                              replacement,
                              wholeWords
                      ) ).toString();
      }
    }

   /**
   * 字符串替换, 在串template中查找第一次出现的字符串placeholder，并用replacement串替换之。
   * 不支持正则表达式
   * @param template 原串
   * @param placeholder 被替换的串
   * @param replacement 用于替换的串
   * @return 新的被替换过的串
   */
    public static String replaceOnce(String template, String placeholder, String replacement) {
      if (template == null || replacement == null || placeholder == null) {
      	throw new IllegalArgumentException("参数不正确,不能是null对象!");
      }
      int loc = template.indexOf(placeholder);
            if ( loc<0 ) {
                    return template;
            }
            else {
                    return new StringBuffer( template.substring(0, loc) )
                    .append(replacement)
                    .append( template.substring( loc + placeholder.length() ) )
                    .toString();
            }
    }

    /**
     * 将一个给定的字符串，用给定的分隔符字符串（或字符串模式）分拆成字符串数组。
     * 不使用中正则表达式
     * @param list 给定的字符串
     * @param seperator 分隔符字符串
     * @return 返回分隔成功后的字符串数组，如果字符串无法用给定的分隔符分拆，返回一
     *          个大小为0的字符串数组。
     */
    public static String[] split(String list, String seperator) {
        return split(list, seperator, false);
    }
    /**
     * 将一个给定的字符串，用给定的分隔符字符串（或字符串模式）分拆成字符串数组。
     * 不使用中正则表达式
     * @param list 给定的字符串
     * @param seperator 分隔符字符串
     * @param include 在新生成的数组中是否包含seperator串
     * @return 返回分隔成功后的字符串数组，如果字符串无法用给定的分隔符分拆，返回一
     *          个大小为0的字符串数组。
     */
    public static String[] split(String list, String seperator, boolean include) {
        StringTokenizer tokens = new StringTokenizer(list, seperator, include);
        String[] result = new String[ tokens.countTokens() ];
        int i=0;
        while ( tokens.hasMoreTokens() ) {
            result[i++] = tokens.nextToken();
        }
        return result;
    }


	/**
	 * 连接字符串，将一个串数组用给定的连接词连接成一个字符串
	 * @param strs 串数组
	 * @param separator 连接词字符串(分隔符)
	 * @return 返回连接后的字符串
	 */
	public static String join(String[] strs, String separator) {
      int length = strs.length;
      if (length==0) return "";
      StringBuffer buf = new StringBuffer( length * strs[0].length() )
      .append(strs[0]);
      for (int i=1; i<length; i++) {
          buf.append(separator).append(strs[i]);
      }
      return buf.toString();
	}

  /**
   * 连接字符串，将一个串数组用给定的连接词连接成一个字符串
   * <pre>
   * additive参数指定添加到串的两边的字符，比如可连接得到的串为：
   * 's1','s2','s3','s4' , 
   * 如果不给此参数，连接得到的串是：s1,s2,s3,s4
   * </pre>
   * 
   * @param strs 串数组
   * @param separator 连接词字符串(分隔符)
   * @param additive 添加到串两边的字符
   * @return 返回连接后的字符串
   */
  public static String join(String[] strs, String separator, String additive) {
      int length = strs.length;
      if (length==0) return "";
      StringBuffer buf = new StringBuffer( length * strs[0].length()+(additive.length()*2)*length )
        .append(additive).append(strs[0]).append(additive);
      for (int i=1; i<length; i++) {
        buf.append(separator).append(additive).append(strs[i]).append(additive);
      }
      return buf.toString();
  }
	
    /**
     * 连接字符串，将一个Iterator中的对象用给定的连接词连接成一个字符串
     * @param objects Iterator对象
     * @param separator 连接词字符串(分隔符)
     * @return 返回连接后的字符串
     */
    public static String join(Iterator objects, String separator) {
        StringBuffer buf = new StringBuffer();
        if ( objects.hasNext() ) buf.append( objects.next() );
        while ( objects.hasNext() ) {
            buf.append(separator).append( objects.next() );
        }
        return buf.toString();
    }
    /**
     * 连接字符串，将一个Iterator中的对象用给定的连接词连接成一个字符串
     * <pre>
     * additive参数指定添加到串的两边的字符，比如可连接得到的串为：
     * 's1','s2','s3','s4' , 
     * 如果不给此参数，连接得到的串是：s1,s2,s3,s4
     * </pre>
     * 
     * @param objects Iterator对象
     * @param separator 连接词字符串(分隔符)
     * @param additive 添加到串两边的字符
     * @return 返回连接后的字符串
     */
    public static String join(Iterator objects, String separator, String additive) {
      StringBuffer buf = new StringBuffer();
      if ( objects.hasNext() ) buf.append(additive).append( objects.next() ).append(additive);
      while ( objects.hasNext() ) {
          buf.append(separator).append(additive).append( objects.next() ).append(additive);
      }
      return buf.toString();
    }
    
    
    /**
     * 将字符串中的某些特殊字符转换为HTML表示格式，如果str==null 或者str=="", 同样也返回null或""
     *
     * @param str   被转换的字符串
     * @param esDef 两维数组数据，定义了转义序列。
     * <pre>
     * 二维数组定义的转义序列格式是:
     * {{原串,目标串}, {原串,目标串}, ...};
     * 例如:
      {
	      {"'",  "&#39;"},
	      {"\"",  "&#34;"},
	      {"<",  "&lt;"},
	      {">",  "&gt;"}
      };
     * 
     * </pre>
     * 
     * @return 返回转换后的字符串
     */
    public static String convert(String str, String[][] esDef) {
        if (str != null && str.trim().length() != 0) {
          for(int i=0; i<esDef.length; i++){
            if("\n".equals(esDef[i][0])){
              str = StringHelper.replace(str, "\r\n", esDef[i][1]);
              str = StringHelper.replace(str, "\n", esDef[i][1]);
            }else{
              str = StringHelper.replace(str, esDef[i][0], esDef[i][1]);
            }
          }
        }
        return str;
    }

    /**
     * 将字符串中的某些特殊字符转换为HTML表示格式，如果str==null 或者str=="", 同样也返回null或""
     *
     * @param str    被转换的字符串
     * @param esDef  XML org.jdom.Element，定义了转义序列。
     *  <pre>
     *  XML转义序列定义：
     * 		
     *   < !ELEMENT escapes(escape *) >
     *   < !ATTLIST escapes 
     *      id     CDATA # REQUIRED  //转义序列的唯一标识
     *   / >
     * 
     *  < !ELEMENT escape(source,target) >  //source,target 分别定义了原串和目标串
     *  例如:
					< escapes id="ES_COMMON_INPUT">
						< escape>
							< source>< ![CDATA[']]>< /source>
							< target>< ![CDATA[& #39;]]>< /target>
						< /escape>
						< escape>
							< source>< ![CDATA["]]>< /source>
							< target>< ![CDATA[& #34;]]>< /target>
						< /escape>
            ...
					< /escapes>
     *  </pre>
     * @return       返回转换后的字符串
     */
    public static String convert(String str, Element esDef) {
        if (str != null && str.trim().length() != 0) {
          List esDefs = esDef.getChildren();
          int len = esDefs.size();
            for (int i = 0; i < len; i++) {
              Element esEL = (Element) esDefs.get(i);
              String srcStr = esEL.getChild("source").getText();
              String tgtStr = esEL.getChild("target").getText();
              if("\n".equals(srcStr)){
                str = StringHelper.replace(str, "\r\n", tgtStr);
                str = StringHelper.replace(str, "\n", tgtStr);
              }else{
                str = StringHelper.replace(str, srcStr, tgtStr);
              }
            }
        }
        return str;
    }

    /**
     * 取子串, 当beginIndex+len大于str的长度时，会返回从beginIndex开始位置到最后的所有子串
     * 
     * @param str 串
     * @param beginIndex 开始位置
     * @param len 取多少个字符
     * @return 返回子串
     */
    public static String substring(String str, int beginIndex, int len){
      int endIndex = beginIndex+len;
      endIndex = endIndex>str.length()?str.length():endIndex;
      return str.substring(beginIndex, endIndex);
    }

    
    /**
     * 取子串,从beginIndex开始，取与endStr之间的子串
     * 
     * @param str 串
     * @param beginIndex 开始位置
     * @param endStr 子串的结束位置
     * @return 如果没有找到返回null
     */
    public static String substring(String str, int beginIndex, String endStr){
      int endIndex = str.indexOf(endStr, beginIndex);
      if(endIndex<0){
        return null;
      }
      return str.substring(beginIndex, endIndex);
    }

    
    /**
     * 取子串，以beginStr开始，取len长度的子串
     * 
     * @param str 串
     * @param beginStr 开始串
     * @param len 长度
     * @return 如果没有找到返回null
     */
    public static String substring(String str, String beginStr, int len){
      int beginIndex = str.indexOf(beginStr);
      if(beginIndex<0){
        return null;
      }
      return substring(str, beginIndex+beginStr.length(),len);
    }
    
    /**
     * 取beginStr与endStr之间的串
     * 
     * @param str 串
     * @param beginStr 开始串
     * @param endStr 结束串
     * @return 如果没有找到返回null
     */
    public static String substring(String str, String beginStr, String endStr){
      int beginIndex = str.indexOf(beginStr);
      if(beginIndex<0){
        return null;
      }
      beginIndex = beginIndex+beginStr.length();
      int endIndex = str.indexOf(endStr, beginIndex);
      if(endIndex<0){
        return null;
      }
      return str.substring(beginIndex, endIndex);
    }
    
    /**
     * 给定一个字符串，并给定一个新字符串和一个旧字符串，用新字符串替代该字符串的所
     * 有的给定的旧字符串。并且支持正则表达式。
     * @param str 给定的原始的字符串。
     * @param oldStr 给定的要被替代掉的旧字符串
     * @param newStr 给定的用于替代旧字符串的新字符串(这个可以是正则模式，如“a[bcd]t”可以替代abt,ac,adt)
     * @return 返回被替换后的新的字符串，如果原字符串中没有给定的oldStr，则返回原字符串
     */
    public static String replaceAll(String str, String oldStr, String newStr) {
        if (str == null || newStr == null || oldStr == null) {
        	throw new IllegalArgumentException("参数不正确,不能是null对象!");
        }
        String reStr = str;
        String patt = oldStr;
        RE r = new RE(patt);
        if (r.match(str)) {
            reStr = r.subst(str, newStr);
        }
        return reStr;
    }
}
