package com.myfun.utils;

/**
 * Created by Lcb on 2016-10-27.
 * 密码类
 */
public class PassWordUtil {

    /**
     * 生成密码
     * **/
    public final static String generatePwd(int strLength) {

        //因1与l不容易分清楚，所以去除
        String strChar = "1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,";
        String[] aryChar= strChar.split(",");
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<strLength; i++){
            sb.append(aryChar[(int)(Math.random()*strChar.length()/2)]);
        }
        return sb.toString();
    }
}
