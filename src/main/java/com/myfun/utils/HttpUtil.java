package com.myfun.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.RequestTimeoutException;
import com.myfun.utils.http.Method;
import com.myfun.utils.http.responseHandler.StringResponseHandler;
import com.myfun.utils.rijindael.AESHelper;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * http操作类
 * 
 * @ClassName: HttpUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:03:50
 *
 */
public class HttpUtil {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static String get(String url, Object param) {
		String result = null;
		try {
			result = _execute(url, param, Method.GET, new StringResponseHandler());
		} catch (SocketTimeoutException e) {
			throw new RequestTimeoutException(url);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static <T extends Object> T getByHandler(String url, Object param, ResponseHandler<T> handler) {
		T result = null;
		try {
			result = _execute(url, param, Method.GET, handler);
		} catch (SocketTimeoutException e) {
			throw new RequestTimeoutException(url);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String post(String url, Object param) {
		String result = null;
		try {
			result = _execute(url, param, Method.POST, new StringResponseHandler());
		} catch (SocketTimeoutException e) {
			throw new RequestTimeoutException(url);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static String postNewErp(String url, Object param,String clientKey) {
		try {
			return _executeNewErp(url, param,clientKey);
		} catch (SocketTimeoutException e) {
			throw new RequestTimeoutException(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String postFile(String url, Object param) {
		String result = null;
		try {
			result = _execute(url, param, Method.UPLOAD_TO_DIST, new StringResponseHandler());
		} catch (SocketTimeoutException e) {
			throw new RequestTimeoutException(url);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static <T extends Object> T postByHandler(String url, Object param, ResponseHandler<T> handler) {
		T result = null;
		try {
			result = _execute(url, param, Method.POST, handler);
		} catch (SocketTimeoutException e) {
			throw new RequestTimeoutException(url);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String postJson(String url, Object param) {
		String result = null;
		try {
			result = _execute(url, param, Method.POST_JSON, new StringResponseHandler());
		} catch (SocketTimeoutException e) {
			throw new RequestTimeoutException(url);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 执行http请求
	 * 
	 * @param url
	 *            请求路径
	 * @param param
	 *            参数
	 * @param method
	 *            请求方法
	 * @param handler
	 *            解析结果回调
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public static <T> T _execute(String url, Object param, Method method, ResponseHandler<T> handler) throws ParseException, IOException, SocketTimeoutException {
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10000).
				setConnectTimeout(10000).build();
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpRequestBase httpRequest = null;
		if (param != null) {
			HttpEntity entity = getEntity(method, param);
			if (Method.GET == method) {
				String paramStr = EntityUtils.toString(entity, Consts.UTF_8.name());
				HttpGet get = new HttpGet(url + "?" + paramStr);
				httpRequest = get;
			} else {
				HttpPost post = new HttpPost(url);
				post.setEntity(entity);
				httpRequest = post;
			}
		} else {
			httpRequest = new HttpGet(url);
		}
		httpRequest.setConfig(requestConfig);
		httpRequest.setHeader("SOAPAction", "http://ws.haofang.net");
		httpRequest.setHeader("source", "1");
		T t = httpclient.execute(httpRequest, handler);
		return t;
	}
	/**
	 * 新版Erphttp请求单元测试接口
	 * @param url
	 *            请求路径
	 * @param param
	 *            参数
	 * @param method
	 *            请求方法
	 * @param handler
	 *            解析结果回调
	 * @return
	 * @throws Exception 
	 */
	public static String _executeNewErp(String urlStr, Object param,String clientKey) throws SocketTimeoutException,IOException {
		  URL url = new URL(urlStr);  
          URLConnection urlConnection = url.openConnection();
		  urlConnection.setConnectTimeout(10000);
		  urlConnection.setReadTimeout(10000);
          // 设置doOutput属性为true表示将使用此urlConnection写入数据  
          urlConnection.setDoOutput(true);  
          // 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型  
          urlConnection.setRequestProperty("content-type", "application/json; charset=utf-8");  
          urlConnection.setRequestProperty("CLIENTKEY", clientKey);  
          // 得到请求的输出流对象  
          OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());  
          // 把数据写入请求的Body  
          writeParamInBody(out,param);
          out.flush();  
          out.close();  
            
          // 从服务器读取响应  
          InputStream inputStream =  urlConnection.getInputStream();  
          String encoding = urlConnection.getContentEncoding();  
          String body = IOUtils.toString(inputStream, encoding);  
          return body; 
	}

	/**
	 * @author 方李骥
	 * @since 2016年9月5日
	 * @param out
	 * @param param
	 * @throws Exception 
	 */
	
	
	@SuppressWarnings("unused")
	private static void writeParamInBody(OutputStreamWriter out, Object param) throws IOException {
		Map<String, Object> paramMap = getParamByObject(param);
		out.write(JSON.toJSONString(param));
	}

	/**
	 * 获取请求实体
	 * 
	 * @param method
	 * @param param
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static HttpEntity getEntity(Method method, Object param) {
		HttpEntity entity = null;
		if (Method.GET == method) {
			entity = new StringEntity(getEncodeParamStr(param), Consts.UTF_8.name());
		} else if (Method.POST == method) {
			entity = getPostFormEntity(param);
		} else if (Method.POST_JSON == method) {
			entity = getPostJsonEntity(param);
		} else if (Method.UPLOAD == method) {
			if (param != null && param instanceof File) {
				File file = (File) param;
				entity = new FileEntity(file);
			} else {
				entity = getPostFormEntity(param);
			}
		} else if (Method.UPLOAD_TO_DIST == method) {
			if (param != null && param instanceof Map) {
				Map<Object, Object> p = (Map<Object, Object>) param;
				@SuppressWarnings("unused")
				Collection<Object> collection = p.values();
				MultipartEntity multipartEntity = new MultipartEntity();
				Iterator<Object> iterator = p.keySet().iterator();
				while (iterator.hasNext()) {
					Object key = iterator.next();
					Object value = p.get(key);
					if (value != null && value instanceof File) {
						File file = (File) value;
						FileBody body = new FileBody(file);
						multipartEntity.addPart(key.toString(), body);
					} else {
						try {
							StringBody stringBody = new StringBody(value.toString());
							multipartEntity.addPart(key.toString(), stringBody);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				}
				entity = multipartEntity;
			}
		}
		return entity;
	}

	/**
	 * 获取post参数
	 * 
	 * @param param
	 * @return
	 */
	public static HttpEntity getPostFormEntity(Object param) {
		// 将参数转换成map
		Map<String, Object> paramMap = getParamByObject(param);
		if (paramMap == null) {
			return null;
		}
		// 创建参数队列
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		Iterator<String> paramIt = paramMap.keySet().iterator();
		while (paramIt.hasNext()) {
			String key = paramIt.next();
			if (paramMap.get(key) == null) {
				continue;
			} else {
				String value = String.valueOf(paramMap.get(key));
				formparams.add(new BasicNameValuePair(key, value));
			}
		}
		UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		return uefEntity;
	}

	/**
	 * 获取post json参数
	 * 
	 * @param param
	 * @return
	 */
	public static HttpEntity getPostJsonEntity(Object param) {
		String jsonStr = getJsonParamStr(param);
		StringEntity stringEntity = new StringEntity(jsonStr, Consts.UTF_8);
		stringEntity.setContentEncoding(Consts.UTF_8.name());
		stringEntity.setContentType("application/json;charset=UTF-8");
		return stringEntity;
	}

	/**
	 * url编码
	 * 
	 * @param url
	 * @return
	 */
	public static String urlEncode(String url) {
		try {
			url = URLEncoder.encode(url, Consts.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}

	/**
	 * 获取urlencode后的字符串参数
	 * 
	 * @param param
	 * @return
	 */
	public static String getEncodeParamStr(Object param) {
		Map<String, Object> paramMap = getParamByObject(param);
		String paramStr = BeanUtilsHelper.map2Str(paramMap);
		return urlEncode(paramStr);
	}

	/**
	 * 把对象转化成json格式
	 * 
	 * @param param
	 * @return
	 */
	public static String getJsonParamStr(Object param) {
		String jsonStr = "";
		if (String.class.isAssignableFrom(param.getClass())) {
			jsonStr = String.valueOf(param);
		} else {
			try {
				jsonStr = OBJECT_MAPPER.writeValueAsString(param);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return jsonStr;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getParamByObject(Object param) {
		Map<String, Object> paramMap = null;
		if (param != null) {
			if (Map.class.isAssignableFrom(param.getClass())) {
				paramMap = (Map<String, Object>) param;
			} else {
				paramMap = BeanUtilsHelper.bean2Map(param);
			}
		}
		return paramMap;
	}
	
	public static boolean isRealImg(String urlPath) {
		try {
			urlPath = urlPath.replaceAll("\\\\", "/");
			URL url = new URL(urlPath);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setDoInput(true);
			httpURLConnection.setRequestMethod("GET");
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode == 200) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * 远程读取图片
	 **/
	public final static byte[] getRemoteImage(String imgUrl) {
		ByteArrayOutputStream baos = null;
		try {
			// "http://192.168.11.171/group1/M00/00/00/wKgLq1jyaTaAIzKtAAAX4fr6QDo823.png"
			URL u = new URL(imgUrl);
			BufferedImage image = ImageIO.read(u);
			baos = new ByteArrayOutputStream();
			String fileExt = imgUrl.substring(imgUrl.lastIndexOf(".") + 1).toLowerCase();
			ImageIO.write(image, fileExt, baos);
			baos.flush();
			return baos.toByteArray();
		} catch (Exception e) {
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
				}
			}
		}
		return new byte[]{};
	}
	/**
	 * 读取网络文件
	 * @param args
	 */
	public final static byte[] getFileByUrl(String videoUrl) {
		BufferedInputStream inputStream = null;
		ByteArrayOutputStream outputStream = null;
		try {
			URLConnection connection = new URL(videoUrl).openConnection();
			inputStream = new BufferedInputStream(connection.getInputStream());
			outputStream = new ByteArrayOutputStream();
			int readCount = 0;
			byte[] buffer = new byte[4*1024];
			while ((readCount = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, readCount);
			}
			byte[] byteArray = outputStream.toByteArray();
			return byteArray;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			try {
				outputStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return new byte[]{};
	}

	

	
	/**
	 * 生成短地址
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @param url
	 * @return
	 */
	public static String createDdz(String url) {
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("longUrl", url);
			String ret = HttpUtil.postJson(AppConfig.getPushWebDomain()+"/systemApi/shortUrl/createShortUrl", param);
			return JSON.parseObject(ret).getJSONObject("data").getString("shortUrl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 上传文件
	 * @author lcb
	 * @date 2018/6/19
	 * @return
	 */
	public static String postFileToFastdfs(String destUrl, String source, List<String> fileName, List<byte[]> fileByte, String watermarkFlag) {
		if (StringUtil.isEmpty(destUrl)) {
			throw new RuntimeException("目标地址不能为空");
		}
		if (fileByte.size() < 1) {
			throw new RuntimeException("上传文件不能为空");
		}
		if (fileName.size() == 0) {
			throw new RuntimeException("文件名不能为空");
		}

		CloseableHttpClient httpClient = HttpClients.createDefault();
		//destUrl = "http://192.168.5.187:8091/fileWeb/uploadFile";
		String result = "";
		try {
			HttpPost httpPost = new HttpPost(destUrl+"?source=" + source);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addTextBody("source", source);// 来源
			for (int i = 0; i < fileByte.size(); i++) {
				builder.addBinaryBody(fileName.get(i), fileByte.get(i), ContentType.MULTIPART_FORM_DATA, fileName.get(i));// 文件流
				builder.addTextBody("filename", fileName.get(i));// 类似浏览器表单提交，对应input的name和value
				builder.addTextBody("watermarkFlag", watermarkFlag);
			}
			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);// 执行提交
			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {
				result = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	/**
	 * 上传文件
	 * @author lcb
	 * @date 2018/6/19
	 * @return
	 */
	public static String postFileToFastdfs(String destUrl, String source, String fileName, byte[] fileByte, String watermarkFlag) {
		List<String> fileNameList = new ArrayList<>();
		fileNameList.add(fileName);
		List<byte[]> fileByteList = new ArrayList<>();
		fileByteList.add(fileByte);
		return postFileToFastdfs(destUrl, source, fileNameList, fileByteList, watermarkFlag);
	}

	/**
	 * 调取掌通
	 * @author 熊刚
	 * @since 2017年9月15日
	 * @param postUrl
	 * @param archiveId
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> postHftMobileUrlBody(String postUrl, Integer archiveId, String clientKey, Map<String, Object> param) throws Exception {
		// 得到请求的输出流对象  
		URL url = new URL(postUrl);
		URLConnection openConnection = url.openConnection();
		openConnection.setDoOutput(true);
		openConnection.setRequestProperty("Content-Type", "application/encrypt-gbk-json; charset=utf-8");
		openConnection.setRequestProperty("clientKey", clientKey);
		OutputStreamWriter out = new OutputStreamWriter(openConnection.getOutputStream());
		// 把数据写入请求的Body
		out.write(AESHelper.encode(JSON.toJSONString(param)));
		out.flush();
		out.close();
		InputStream inputStream = openConnection.getInputStream();
		return transHftMobileReturnData(IOUtils.toString(inputStream, "utf-8"));
	}
	
	public static String postToWebService(String urlPath, String action, Map<String, Object> paramMap) {
		try{
			String paramStr = JSON.toJSONString(paramMap);
			String paramEncode = AESHelper.encode(paramStr);
			URLConnection urlConnection = new URL(urlPath).openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestProperty("SOAPAction", "SOAPAction");
			urlConnection.setRequestProperty("Content-Type", "text/xml");
			OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
			out.write(String.format("action=%s&params=%s", action, paramEncode));
			out.flush();
			out.close();
			String result = IOUtils.toString(urlConnection.getInputStream(), "UTF-8");
			return result;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 调取掌通
	 * @author 朱科
	 * @since 2018年4月12日
	 * @param postUrl
	 * @param archiveId
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> postHftMobileUrl(String postUrl, Integer archiveId, String clientKey, Map<String, Object> param) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpEntity entity = getEntity(Method.POST, param);
		HttpPost post = new HttpPost(postUrl);
		post.setEntity(entity);
		HttpRequestBase httpRequest = post;
		httpRequest.setHeader("SOAPAction", "http://ws.haofang.net");
		httpRequest.setHeader("U-FS", "erpWeb");
		httpRequest.setHeader("clientKey", clientKey);
		httpRequest.setHeader("OPEN-API-AT", archiveId.toString());
		String resultStr = httpclient.execute(httpRequest, new StringResponseHandler());
		return transHftMobileReturnData(resultStr);
	}
	/**
	 * 封装数据
	 * @author 熊刚
	 * @since 2017年9月15日
	 * @param bodyStr
	 * @return
	 * @throws Exception
	 */
	public static Map<String,Object> transHftMobileReturnData(String bodyStr) throws Exception{
		Map<String, Object> dataMap = JSON.parseObject(bodyStr, new TypeReference<Map<String, Object>>() {});
		String status = dataMap.get("errCode").toString();
		Map<String, Object> returnData = new HashMap<String, Object>();
		if ("200".equals(status)) {
			returnData.put("data", dataMap.get("data"));
			returnData.put("errCode", 200);
		} else {
			returnData.put("errCode", 300);
			returnData.put("errMsg", dataMap.get("errMsg"));
		}
		return returnData;
	}
	
	/**
	 * 判断是否是内网IP
	 * @author 张宏利
	 * @since 2018年6月28日
	 * @param ip
	 * @return
	 */
	public static boolean isInnerIp(String ip) {
		String reg = "^(10|172|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})$";
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(ip);
		return matcher.find();
	}
	/**
	 * 推送消息
	 * @param urlStr
	 * @param pMap
	 * @return
	 */
	public static String post2NewJson(String urlStr, Map<String, Object> pMap) {
		try {
			URL url = new URL(urlStr);
			URLConnection urlConnection = url.openConnection();
			// 设置doOutput属性为true表示将使用此urlConnection写入数据
			urlConnection.setDoOutput(true);
			// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型
			// application/encrypt-gbk-json
			urlConnection.setRequestProperty("Content-type", " application/json; charset=utf-8");
			// 得到请求的输出流对象
			OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8");
			String jsonStr = JSON.toJSONString(pMap);
			out.write(jsonStr);
			out.flush();
			out.close();
			// 从服务器读取响应
			InputStream inputStream = urlConnection.getInputStream();
			String returnData = IOUtils.toString(inputStream, "UTF-8");
			return returnData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		String localhost = HttpUtil.post("http://localhost:8080/service/i", new HashMap<>());
		System.out.println("x"+localhost);
	}
}
