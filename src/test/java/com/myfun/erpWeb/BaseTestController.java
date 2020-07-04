/**
 * @author 方李骥
 * @since 2016年9月5日
 */
package com.myfun.erpWeb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.HttpUtil;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 方李骥
 * @since 2016年9月5日
 */
public class BaseTestController {
	private UnitTest unitTest;
	
	public void init(String url, String accessToken){
		unitTest = UnitTest.getNewInstance();
		unitTest.setHost(url);
		unitTest.setClientKey(accessToken);
	}
	
	public void init(String url,String archiveId,String userMobile){
		unitTest = UnitTest.getNewInstance();
		unitTest.setHost(url);
		unitTest.setArchiveId(archiveId);
		unitTest.setUserMobile(userMobile);
		setClientKey();
	}
	
	public void initOnlyAddr(String url,String simulatedLandingUrl,String archiveId,String userMobile){
		unitTest = UnitTest.getNewInstance();
		unitTest.setHost(url);
		unitTest.setArchiveId(archiveId);
		unitTest.setUserMobile(userMobile);
		unitTest.setSimulatedLandingUrl(simulatedLandingUrl);
	}
	
	public void init(String url,String simulatedLandingUrl,String archiveId,String userMobile){
		unitTest = UnitTest.getNewInstance();
		unitTest.setHost(url);
		unitTest.setArchiveId(archiveId);
		unitTest.setUserMobile(userMobile);
		unitTest.setSimulatedLandingUrl(simulatedLandingUrl);
		setClientKey();
	}

	public void initNew(String url,String serverAddr,String userMobile, String password){
		unitTest = UnitTest.getNewInstance();
		unitTest.setHost(url);
		unitTest.setPassword(password);
		unitTest.setUserMobile(userMobile);
		unitTest.setSimulatedLandingUrl(serverAddr);
		unitTest.setClientKey(loginNew(unitTest.getUserMobile(), unitTest.getPassword()));
	}

	private String loginNew(String userMobile,String password){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("passwordType",0);
		paramMap.put("userMobile",userMobile);
		paramMap.put("loginPassword",password);
		String loginResult = HttpUtil.postJson(unitTest.getSimulatedLandingUrl(), paramMap);
		JSONObject loginJosnObject = JSONObject.parseObject(loginResult);
		Integer errcode = loginJosnObject.getInteger("errCode");
		if (Const.ResponseCode.SUCCESS != errcode) {
			if (errcode.equals("1")) {
				throw new BusinessException("系统错误");
			} else {
				throw new BusinessException(loginJosnObject.getString("errMsg"));
			}
		}
		String dataStr = loginJosnObject.getString("data");
		JSONObject dataJsonObject = JSONObject.parseObject(dataStr);
		return dataJsonObject.getString("clientKey");
	}


	private String login(String userMobile,String archiveId){
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("USER_MOBILE",userMobile);
		paramMap.put("ARCHIVE_ID",archiveId);
		paramMap.put("TOKEN", createToken());
		paramMap.put("action","simulatedLanding");
		String post = HttpUtil.post(unitTest.getSimulatedLandingUrl(), paramMap);
		return post;
	}
	
	private String createToken(){
		String tokenCreate = EnCodeHelper.encode(unitTest.getUserMobile()+"HFT_OPEN_API_"+new Date().getDay());
		return tokenCreate;
	}
	
	public String getClientKey() {
		return unitTest.getClientKey();
	}
	
	public void setClientKey(String clientKey) {
		unitTest.setClientKey(clientKey);
	}
	
	/**
	 * @author 方李骥
	 * @since 2016年9月5日
	 * @param archiveId
	 */
	 
	private void setClientKey() {
		unitTest.setClientKey(login(unitTest.getUserMobile(), unitTest.getArchiveId()));
	}
	
	public String getResult(){
		return unitTest.getResult();
	}
	
	public String postNewErp(Object param,String interfaceName) throws Exception {
		URL url = new URL(unitTest.getHost()+"/"+interfaceName);
		URLConnection urlConnection = url.openConnection();
		// 设置doOutput属性为true表示将使用此urlConnection写入数据
		urlConnection.setDoOutput(true);
		// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
		urlConnection.setRequestProperty("content-type", "application/json");
		urlConnection.setRequestProperty("CLIENTKEY", unitTest.getClientKey());
		// 得到请求的输出流对象
		OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
		// 把数据写入请求的Body
		if(param instanceof BaseMapParam){ 
			BaseMapParam paramMap = (BaseMapParam)param;
			paramMap.setInteger("pageOffset", paramMap.getPageOffset());
			paramMap.setInteger("pageRows", paramMap.getPageRows());
			param = paramMap.getMap();
		}
		String jsonStr = JSON.toJSONString(param);
		System.out.println("请求参数：" + jsonStr);
		//out.write(jsonStr);
		out.write(jsonStr);
//		out.write(jsonStr);
		out.flush();
		out.close();
		// 从服务器读取响应
		InputStream inputStream =  urlConnection.getInputStream();
		String encoding = urlConnection.getContentEncoding();
		String body = IOUtils.toString(inputStream, encoding);
		/*unitTest.setResult(body);*/
		return body;
	}
	
	public String sendGet(String url, String param) {
		StringBuilder result = new StringBuilder();
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result.toString();
	}
}
