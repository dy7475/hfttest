package com.myfun.utils;

import java.util.regex.Pattern;

/**
 * 电话号码验证工具类
 */
public class PhoneUtils {
    /**
     * 中国移动号码格式验证
     * 手机段：134,135,136,137,138,139,150,151,152,157,158,159,182,183,184
     * ,187,188,147,178,1705
     *
     *
     **/
    private static final String CHINA_MOBILE_PATTERN = "(?:^(?:\\+86)?1(?:3[4-9]|4[7]|5[0-27-9]|7[8]|8[2-478])\\d{8}$)|(?:^(?:\\+86)?1705\\d{7}$)";
    public static boolean isChinaMobilePhoneNum(String str) {
        return match(CHINA_MOBILE_PATTERN, str);
    }
    /**
     * 匹配函数
     *
     * @param regex
     * @param input
     * @return
     */
    private static boolean match(String regex, String input) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        boolean chinaMobilePhoneNum = isChinaMobilePhoneNum("13626662222");
        System.out.println(chinaMobilePhoneNum);
    }
}
