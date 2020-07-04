package com.myfun.framework.web.json;

import java.util.HashMap;
import java.util.Map;

/**
 * map json格式
 * 
 * @ClassName: MapResponseJson
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午5:59:09
 *
 */
public class MapResponseJson extends HashMap<Object, Object>implements ResponseJson {
	private static final long serialVersionUID = 4284590656827497047L;

	public MapResponseJson() {

	}

	public MapResponseJson(String action, String msg, String errCode) {
		put("ACTION", action);
		put("ERRCODE", errCode);
		put("ERRMSG", msg);
	}

	public MapResponseJson(String action, String url, Integer type) {
		put("ACTION", action);
		put("URL", url);
		put("TYPE", type);
	}

	public MapResponseJson(String result, String msg) {
		put("result", result);
		put("msg", msg);
	}

	public MapResponseJson(Map<? extends Object, ? extends Object> map) {
		putAll(map);
	}
}
