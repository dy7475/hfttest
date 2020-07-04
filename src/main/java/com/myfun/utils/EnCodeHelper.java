package com.myfun.utils;

import java.security.MessageDigest;
import java.util.Calendar;

public class EnCodeHelper {
    
    /**
     * 仅用于核心业务数据加密
     * AES加密   CFB模式
     * @param content
     * @param password
     * @return
     */
    public static String encode(String content) {
        return content;
    }

    /**
     * 仅用于核心业务数据解密
     * AES解密  CFB模式
     * @param content
     * @param password
     * @return
     */
    public static String decode(String content) {
        return content;
    }
    
    public static String MD5Encode(String sourceString) {
        String resultString = null;
        try {
            sourceString = "m%y#f^u@n)7" + sourceString + "7-n_u+f!y?m";
            resultString = new String(sourceString);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byte2hexString(md.digest(resultString.getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    public static final String byte2hexString(byte[] bytes) {
        StringBuffer bf = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            if ((bytes[i] & 0xff) < 0x10) {
                bf.append("0");
            }
            bf.append(Long.toString(bytes[i] & 0xff, 16));
        }
        return bf.toString();
    }
    
    public static String ecodeByMD5(String originstr) {
        String result = null;
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        if (originstr != null) {
            try {
                // 返回实现指定摘要算法的 MessageDigest 对象
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用utf-8编码将originstr字符串编码并保存到source字节数组
                byte[] source = originstr.getBytes("utf-8");
                // 使用指定的 byte 数组更新摘要
                md.update(source);
                // 通过执行诸如填充之类的最终操作完成哈希计算，结果是一个128位的长整数
                byte[] tmp = md.digest();
                // 用16进制数表示需要32位
                char[] str = new char[32];
                for (int i = 0, j = 0; i < 16; i++) {
                    // j表示转换结果中对应的字符位置
                    // 从第一个字节开始，对 MD5 的每一个字节
                    // 转换成 16 进制字符
                    byte b = tmp[i];
                    // 取字节中高 4 位的数字转换
                    // 无符号右移运算符>>> ，它总是在左边补0
                    // 0x代表它后面的是十六进制的数字. f转换成十进制就是15
                    str[j++] = hexDigits[b >>> 4 & 0xf];
                    // 取字节中低 4 位的数字转换
                    str[j++] = hexDigits[b & 0xf];
                }
                result = new String(str);// 结果转换成字符串用于返回
            } catch (Exception e) {
                // 不支持字符编码异常
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String getToken(String userMobile) {
        String token = encode(userMobile + "HFT_OPEN_API_"
                + (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)-Calendar.SUNDAY));
        return token;
    }
}
