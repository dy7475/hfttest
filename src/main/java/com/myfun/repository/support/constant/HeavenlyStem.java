package com.myfun.repository.support.constant;
/**
 * 天干地支
 * @param
 * @auther 胡坤
 * @since 2018/5/9
 * @return
 *
 */

import java.util.HashMap;
import java.util.Map;

public class HeavenlyStem {
	public static final String[] heavenlyStem = new String[] {
			"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸", "子",
			"丑", "寅", "卯", "辰", "巳", "午", "申", "酉", "戌", "亥"
		};
	
	public static final Map<String, Integer> heavenlyStemMap;
	
	static{
		heavenlyStemMap = new HashMap<>();
		for (int i = 0; i < heavenlyStem.length; i++) {
			heavenlyStemMap.put(heavenlyStem[i], i);
		}
	}
}
