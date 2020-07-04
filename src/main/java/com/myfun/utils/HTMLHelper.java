/*
 * HTMLHelper.java	2004-3-5
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

import org.apache.regexp.RE;
import org.jdom.Element;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 提供HTML相关操作的方法。
 *
 * <p>Copyright (c) 2002-2004 美森软件系统有限公司,
 * http://www.mission-apps.com</p>
 * @author wenjian@free-think.org
 * @version 1.00
 */
/**
 * HTML操作助手。提供HTML相关操作的方法。
 * 
 * 
 * <p><pre><b>
 * 历史更新记录:</b>
 * 2004-03-05  创建此类型
 * 
 * </pre></p>
 * 
 * 
 * @author   abnerchai, wenjian
 * @version  1.0
 * @since    JThink 1.0
 * 
 */

public final class HTMLHelper {
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符
    private HTMLHelper() {}

  /**
   * 默认转义字符序列定义,用于输入
   */
  public static final String[][] ES_DEF$INPUT =
      {
	      {"'",  "&#39;"},
	      {"\"",  "&#34;"},
	      {"<",  "&lt;"},
	      {">",  "&gt;"}
      };
  /**
   * 默认转义字符序列定义,用于输出
   */
  public static final String[][] ES_DEF$OUTPUT =
          {
	          {"'",  "&#39;"},
	          {"\"", "&quot;"},
	          {"<",  "&lt;"},
	          {">",  "&gt;"},
	          {"\n",  "<BR>"},
	          {" ",  "&nbsp;"}
          };
  

    /**
     * 将字符串中的某些特殊字符转换为HTML表示格式，如果str==null 或者str=="", 返回：&nbsp;
     * 目前实现了：格式化字符串中的回车换行符(\n)为HTML回车换行符, 单引号('),双引号(")，小于(<)，大于(>)，空格
     * 
     * @param str 要被转换的字符串
     * 
     * @return  返回转换后的字符串
     */
    public static String toHTMLString(String str) {
        String s = str;
        if (str == null || str.trim().length() == 0) {
            s = "&nbsp;";
        } else {
            s = StringHelper.convert(str, ES_DEF$OUTPUT);
        }
        return s;
    }


    /**
     * 将字符串中的某些特殊字符转换为HTML表示格式，如果str是""返回也是"",  给的是null返回也是null, 
     * 但是，如果输入的转义序列esDef是ES_DEF$INPUT,返回空串""或null都返回"",
     * 如果是ES_DEF$OUTPUT,返回&nbsp;
     *
     * @param str   被转换的字符串
     * @param esDef 两维数组数据，定义的转义序列。
     * 
     * @return 返回转换后的字符串
     * 
     * @see StringHelper#convert(String, String[][])
     */
    public static String toHTMLString(String str, String[][] esDef) {
      if (str != null && str.trim().length() != 0) {
        str = StringHelper.convert(str, esDef);
      }else{
      	if(esDef==ES_DEF$INPUT){
      		str = "";
      	}else if(esDef==ES_DEF$OUTPUT){
      		str = "&nbsp;";
      	}
      }
      return str;
    }

    /**
     * 将字符串中的某些特殊字符转换为HTML表示格式，如果str==null 或者str=="", 返回:&nbsp;
     *
     * @param str    被转换的字符串
     * @param esDef  XML格式的转义序列, 以org.jdom.Element为载体的数据定义方式
     * @return       返回转换后的字符串
     * 
     * @see StringHelper#convert(String, Element)
     */
    public static String toHTMLString(String str, Element esDef) {
      if (str != null && str.trim().length() != 0) {
        str = StringHelper.convert(str, esDef);
      }
      return str;
    }


  /**
   * BBS标记转换到HTML标记
   *
   * @param srcText 包含有BBS标记的源文本
   *                <BR> BBS格式：[标记名 属性列表] 或 [标记名 属性列表/] 或 [标记名 属性列表]内容[/标记名]
   *                <BR>HTML格式：<标记名 属性列表> 或 <标记名 属性列表/> 或 <标记名 属性列表>内容</标记名>
   *                <BR>例：BBS格式文本：[IMG SRC="http://10.0.0.22/ITWorking/images/4.gif"][/IMG]
   *                <BR>轮换为HTML格式后：<IMG SRC="http://10.0.0.22/ITWorking/images/4.gif"></IMG>
   * @param tagName 标记名
   * @return 已经被转换成了HTML了的文本
   */
  public static String bbsToHTMLTag(String srcText, String tagName){
      RE patt = new RE("\\["+tagName+"([^\\]]*)\\]([^\\]]*)\\[/"+tagName+"\\]|\\["+tagName+"([^\\]]*)\\]", RE.MATCH_CASEINDEPENDENT);
      while (patt.match(srcText)){
        if(patt.getParenCount()==4){
          srcText = StringHelper.replaceOnce(srcText, patt.getParen(0), "<"+tagName+""+patt.getParen(3)+">");
        }else{
          srcText = StringHelper.replaceOnce(srcText, patt.getParen(0), "<"+tagName+""+patt.getParen(1)+">"+patt.getParen(2)+"</"+tagName+">");
        }
      }
      return srcText;
  }

//  public static String encoding(){
//    
//  }
  /**
   * 编码为HTML标准内部字符编码形式
   */
  public static String encode(String str){
    char[] ch=str.toCharArray();
    String htmlStr="";
    for(int i=0;i<ch.length;i++){
      htmlStr+="&#x"+Integer.toHexString((int)ch[i])+";";
    }
    return htmlStr;
  }

    /**
     * @param htmlStr
     * @return
     *  删除Html标签
     */
    public static String delHTMLTag(String htmlStr) {
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        return htmlStr.trim(); // 返回文本字符串
    }

    public static String getTextFromHtml(String htmlStr){
        htmlStr = delHTMLTag(htmlStr);
        htmlStr = htmlStr.replaceAll("&nbsp;", "");
//        htmlStr = htmlStr.substring(0, htmlStr.indexOf("。")+1);
        return htmlStr;
    }

    public static void main(String[] args) {
        String str = "恭喜李俊签单成功，佣金20000元&nbsp;";
        System.out.println(getTextFromHtml(str));
    }
  
}
