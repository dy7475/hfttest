package com.myfun.utils.http.responseHandler;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 解析httpclient返回值
 * 
 * @ClassName: JsonResponseHandler
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:02:40
 * 
 * @param <T>
 */
public class JsonResponseHandler<T extends Object> implements ResponseHandler<T> {
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		HttpEntity entity = response.getEntity();
		if (entity == null) {
			throw new ClientProtocolException("Response contains no content");
		}
		String result = EntityUtils.toString(entity, Consts.UTF_8);
		T t = null;
		return (T) OBJECT_MAPPER.readValue(result, t.getClass());
	}

}
