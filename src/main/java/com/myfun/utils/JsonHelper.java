package com.myfun.utils;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static ObjectMapper getMapper() {
		return MAPPER;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Object> parseMap(String str) {
		ObjectMapper mapper = getMapper();
		Map map = null;
		try {
			map = mapper.readValue(str, Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
}
