package com.myfun.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.RequestTimeoutException;
import com.myfun.utils.http.Method;
import com.myfun.utils.http.URLTool;
import com.myfun.utils.http.URLTool.PostData;
import com.myfun.utils.http.responseHandler.StringResponseHandler;
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
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.Map.Entry;

/**
 * http操作类
 * 
 * @ClassName: HttpUtil
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:03:50
 *
 */
public class HttpUtilNew {
	
	private static String GLOBAL_HTTP_HFT_CHARSET = "utf-8";
	
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private final static ThreadLocal<String> currentProject = new ThreadLocal<String>();
	private final static ThreadLocal<String> currentUrl = new ThreadLocal<String>();
	private final static ThreadLocal<String> httpParam = new ThreadLocal<String>();
	private final static ThreadLocal<Map<String,String>> httpHeader = new ThreadLocal<Map<String,String>>();

	/**
     * 获取当前请求参数和返回参数
     * @author 陈文超
     * @date 2017年7月3日 下午3:54:02
     */
    public static String getCurrInfo(){
        return httpParam.get();
    }
    
    /**
     * 清空本次请求的参数
     * @author 陈文超
     * @date 2017年7月3日 下午3:55:50
     */
    public static void clear(){
        httpParam.remove();
        httpHeader.remove();
        currentProject.remove();
        currentUrl.remove();
    }
    
  
    public static void setRequestUrl(String url){
    	currentUrl.set(url);
    }
    
    public static void setCurrentProject(String projectName){
    	currentProject.set(projectName);
    }
    /**
     * 清空本次请求的参数
     * @author 陈文超
     * @date 2017年7月3日 下午3:55:50
     */
    public static void setCurrentRequestHeader(Map<String, String> headerMap){
        httpHeader.set(headerMap);
    }
    public static Map<String,String> getHeaderByRequest(HttpServletRequest request) {
    	Map<String, String> map = new HashMap<String, String>();
    	Enumeration<String> headerNames = request.getHeaderNames();
    	while (headerNames.hasMoreElements()) {
    		String key = (String) headerNames.nextElement();
    		String value = request.getHeader(key);
    		map.put(key, value);
    	}
    	return map;
    }
    
    /**
     * 清空本次请求的参数
     * @author 陈文超
     * @date 2017年7月3日 下午3:55:50
     */
    public static Map<String,String> getCurrentHeader(){
    	return httpHeader.get();
    }
	
	/**
     * get请求
     * 注意：get的url中不要带?和请求参数
     * 例如：http://hftsoft.com?cityId=1&regId=2 错误的写法
     * @author 陈文超
     * @date 2017年6月29日 下午2:33:38
     */
	public static String get(String url, LinkedHashMap<String, String> textParam, Map<String, String> header) {
		String result = _execute(url, textParam, "get", header);
		return result;
	}
	
	/**
	 * post请求
	 * @author 陈文超
	 * @date 2017年6月29日 下午2:33:50
	 */
	public static String post(String url, LinkedHashMap<String, String> textParam, Map<String, String> header) {
		String result = _execute(url, textParam, "post", header);
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
	public static <T> T _execute(String url, Object param, Method method, ResponseHandler<T> handler) throws ParseException, IOException,SocketTimeoutException {
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
	 * 发送json数据
	 * @author 陈文超
	 * @date 2017年6月29日 下午2:42:46
	 */
	public static String postJson(String url, String jsonParam, Map<String, String> header) {
		String result = _execute(url, jsonParam, "jsonPost", header);
		return result;
	}

	/**
	 * 执行http请求方法
	 * @author 陈文超
	 * @date 2017年6月29日 下午2:28:47
	 */
	private static String _execute(String url, Object param, String method, Map<String, String> header) {
	    List<String[]> defHeader = new ArrayList<String[]>();
	    defHeader.add(new String[]{"U-FS","houseWeb"});
	    if(header != null){
	        for(Entry<String, String> tmp : header.entrySet()){
	            defHeader.add(new String[]{tmp.getKey(), tmp.getValue()});
	        }
	    }
	    URLTool httpe = new URLTool();
	    httpe.setDefaultHeader(defHeader);

	    Map<String, Object> jsonParam = new HashMap<String, Object>();
	    jsonParam.put("url", url);
	    //上传文件暂不记录日志
	    if(!"multiPartPost".equals(method)){
	        jsonParam.put("requestBody", param);
	    }else{
	        jsonParam.put("requestBody", "igonre_biggest_size_content");
	    }
	    jsonParam.put("method", method);

	    String resultStr = "";
	    try{
	        if("jsonPost".equals(method)){
	            resultStr = httpe.exePostJSONRequest(url, param.toString(), null, GLOBAL_HTTP_HFT_CHARSET);
	        }else if("multiPartPost".equals(method)){
	            resultStr = httpe.exeMultipartPost(url, HttpUtilNew.parseMultipartPostBody(httpe, param), GLOBAL_HTTP_HFT_CHARSET);
	        }else if("post".equals(method)){
	            resultStr = httpe.exePostRequest(url, HttpUtilNew.parsePostBody(httpe, param), GLOBAL_HTTP_HFT_CHARSET);
	        }else if("get".equals(method)){
	            resultStr = httpe.exeGetRequest(url + HttpUtilNew.parseRequestBody(param), GLOBAL_HTTP_HFT_CHARSET);
	        }
	        jsonParam.put("response", resultStr);
	        jsonParam.put("allResponseHeader", httpe.getAllResponseHeader());
	    } catch (SocketTimeoutException e) {
			jsonParam.put("allResponseHeader", httpe.getAllResponseHeader());
			httpParam.set(JSON.toJSONString(jsonParam));
			throw new RequestTimeoutException(url);
		} catch(Exception e){
	        jsonParam.put("allResponseHeader", httpe.getAllResponseHeader());
	        httpParam.set(JSON.toJSONString(jsonParam));
	        throw new RuntimeException(e);
	    }
	    httpParam.set(JSON.toJSONString(jsonParam));
		return resultStr;
	}

	/**
	 * 解析LinkedHashMap 得到 请参数字串
	 * @author 陈文超
	 * @date 2017年7月3日 下午3:16:37
	 */
	private static String parseRequestBody(Object arg){
	    LinkedHashMap<String, String> param = (LinkedHashMap<String, String>) arg;
	    if(param == null || param.isEmpty()){
	        return "";
	    }
	    StringBuilder sb = new StringBuilder();
	    for(Entry<String, String> tmp : param.entrySet()){
	        sb.append("&").append(tmp.getKey()).append("=").append(tmp.getValue());
	    }
	    return "?" + sb.toString().replaceFirst("&", "");
	}

	/**
     * 解析LinkedHashMap 得到post请参数字串
     * @author 陈文超
	 * @throws Exception
     * @date 2017年7月3日 下午3:16:37
     */
    private static PostData parsePostBody(URLTool httpe, Object arg) throws Exception{
        LinkedHashMap<String, String> param = (LinkedHashMap<String, String>) arg;
        if(param == null || param.isEmpty()){
            return null;
        }
        PostData pd = httpe.new PostData();
        for(Entry<String, String> tmp : param.entrySet()){
        	if(tmp.getValue() == null){
        		continue;
        	}
            pd.put(tmp.getKey(), tmp.getValue());
        }
        return pd;
    }

    /**
     * 解析LinkedHashMap 得到post请参数字串
     * @author 陈文超
     * @throws Exception
     * @date 2017年7月3日 下午3:16:37
     */
    private static PostData parseMultipartPostBody(URLTool httpe, Object arg) throws Exception{
        LinkedHashMap<String, Object> param = (LinkedHashMap<String, Object>) arg;
        if(param == null || param.isEmpty()){
            return null;
        }
        PostData pd = httpe.new PostData();
        for(Entry<String, Object> tmp : param.entrySet()){
            if(tmp.getValue() instanceof Object []){
                Object [] formInfo = (Object[]) tmp.getValue();
                pd.multiStream(tmp.getKey(), ((byte[]) formInfo[1]), formInfo[0].toString());
            }else if(tmp.getValue() instanceof byte[]){
                pd.multiStream(tmp.getKey(), tmp.getValue(), null);
            }else{
                pd.put(tmp.getKey(), tmp.getValue().toString());
            }
        }
        return pd;
    }
    
	/**
	 * @author 方李骥
	 * @since 2016年9月5日
	 * @param out
	 * @param param
	 * @throws Exception 
	 */
	
	
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
	 * 上传文件到fastdfs
	 *
	 * @param destUrl
	 * @param source
	 * @param fileName
	 *            只用后缀名
	 * @param fileByte
	 * @returnasdfasdf
	 */
	public static String postFileToFastdfs(String destUrl, String source, String fileName, byte[]... fileByte) {
		if (StringUtil.isEmpty(destUrl)) {
			throw new RuntimeException("目标地址不能为空");
		}
		if (fileByte.length < 1) {
			throw new RuntimeException("上传文件不能为空");
		}
		if (StringUtil.isEmpty(fileName)) {
			throw new RuntimeException("文件名不能为空");
		}

		CloseableHttpClient httpClient = HttpClients.createDefault();
		String result = "";
		try {
			HttpPost httpPost = new HttpPost(destUrl+"?source=" + source);
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addTextBody("source", source);// 来源
			for (int i = 0; i < fileByte.length; i++) {
				builder.addBinaryBody("file" + i, fileByte[i], ContentType.MULTIPART_FORM_DATA, fileName);// 文件流
			}
			builder.addTextBody("filename", fileName);// 类似浏览器表单提交，对应input的name和value
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
	 * 调取掌通
	 * @author 熊刚
	 * @since 2017年9月15日
	 * @param postUrl
	 * @param archiveId
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> postHftMobileUrl(String postUrl, Integer archiveId, Map<String, Object> param) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpEntity entity = getEntity(Method.POST, param);
		HttpPost post = new HttpPost(postUrl);
		post.setEntity(entity);
		HttpRequestBase httpRequest = post;
		httpRequest.setHeader("SOAPAction", "http://ws.haofang.net");
		httpRequest.setHeader("U-FS", "erpWeb");
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
		String status = dataMap.get("status").toString();
		Map<String, Object> returnData = new HashMap<String, Object>();
		if ("1".equals(status)) {
			returnData.put("data", dataMap.get("data"));
			returnData.put("errCode", 200);
		} else if ("0".equals(status)) {
			returnData.put("data", null);
			returnData.put("errCode", 300);
			Map<String, Object> errorMap = (Map<String, Object>) dataMap.get("error");
			if (errorMap != null) {
				returnData.put("errMsg", errorMap.get("title"));
			} else {
				returnData.put("errMsg", "系统错误");
			}
		}
		return returnData;
	}
	
    /***
     * 上传vr图片
     * @author 尹振兴
     * 2017年11月10日 下午8:10:48
     * @param url
     * @param files
     */
    public static void panoramaUpload(String url, List<File> files) {  
        try {  
        	CloseableHttpClient httpClient = HttpClients.createDefault();  
            // 组装提交信息  
            MultipartEntity reqEntity = new MultipartEntity();  
            for(File file : files) {  
               reqEntity.addPart("file", new FileBody(file));  
            }  
            // 设置提交信息  
            HttpPost httppost = new HttpPost(url);  
            httppost.setEntity(reqEntity);  
            HttpResponse httpResponse = httpClient.execute(httppost);  
              
		    // 若状态码为200 ok  
		   if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {  
		       String strResult = EntityUtils.toString(httpResponse.getEntity());  
		   } else {  
		   }  
        } catch (Exception e) {  
        	e.printStackTrace();  
        }
    } 
    
    /***
     * 获得短链接
     * @author 尹振兴
     * @since 2018年2月8日
     * @param url
     * @return
     */
	public static String getShortUrl(String url) {
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("longUrl", url);
			String ret = HttpUtil.postJson(AppConfig.getPushWebDomain()+"/systemApi/shortUrl/createShortUrl", param);
			return JSON.parseObject(ret).getJSONObject("data").getString("shortUrl");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[] args) {
		try {
			String paramStr ="{\"caseId\":\"6631551\",\"caseType\":\"1\",\"trackContent\":\"1111\",\"trackType\":\"2\",\"caseStatus\":\"6\",\"date\":\"2017-09-05\"}";
			Map param = (Map) JSON.parseObject(paramStr, Map.class);
			URL url = new URL("http://192.168.0.246:8080/mobileWeb/funTrack/outerTrade");  
			URLConnection urlConnection = url.openConnection();  
			// 设置doOutput属性为true表示将使用此urlConnection写入数据  
			urlConnection.setDoOutput(true);  
			// 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型  
			urlConnection.setRequestProperty("content-type", "application/json; charset=utf-8");  
			urlConnection.setRequestProperty("T-AT", "507481");  
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
			System.out.println(body);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
