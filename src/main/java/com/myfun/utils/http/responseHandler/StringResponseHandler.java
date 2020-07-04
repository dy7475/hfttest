package com.myfun.utils.http.responseHandler;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/**
 * 解析httpclient返回值
 * 
 * @ClassName: StringResponseHandler
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:03:07
 *
 */
public class StringResponseHandler implements ResponseHandler<String> {
	@Override
	public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		HttpEntity entity = response.getEntity();
		if (entity == null) {
			throw new ClientProtocolException("Response contains no content");
		}
		String result = EntityUtils.toString(entity, Consts.UTF_8);
		return result;
	}
}
