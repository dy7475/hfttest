package com.myfun.utils;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.config.AppConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * 链接处理类
 * **/
public class UrlUtils {


    public static String genShortUrl(String url){
        Map<String, String> param = new HashMap<String, String>();
        param.put("longUrl", url);
        String ret = HttpUtil.postJson(AppConfig.getPushWebDomain()+"/systemApi/shortUrl/createShortUrl", param);
        return JSON.parseObject(ret).getJSONObject("data").getString("shortUrl");
    }

    public static void main(String[] args) {
        System.out.println(genShortUrl("https://www.baidu.com/"));
    }
}
