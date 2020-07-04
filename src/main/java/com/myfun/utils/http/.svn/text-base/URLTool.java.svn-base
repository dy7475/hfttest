package com.myfun.utils.http;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 * url工具类
 * @author 陈文超
 * @throws Exception 
 * @date Aug 11, 2015 3:44:02 PM
 */
public class URLTool {
	
    private CookieStore cs = new CookieStore();
    private static final char [] RANS = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
    private String [][] initHeader = null;
    private List<String[]> defHeader = new ArrayList<String[]>();
    private Map<String,String> responseHeader = new HashMap<String,String>();
    private Map<String,List<String>> allResponseHeader = new HashMap<String,List<String>>();
    private String encodeType = "ISO-8859-1";
    private Map<String,List<String>> realHeader = null;
	
	public URLTool(){
		//默认的请求头
		initHeader  = new String[][]{
			new String[]{"Accept", "text/html, application/xhtml+xml, */*"},
			new String[]{"User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)"},
			new String[]{"Accept-Encoding", "gzip, deflate"},
			new String[]{"Accept-Language", "zh-CN,zh;q=0.8"},
			new String[]{"Accept-Charset", "gb2312,utf-8;q=0.5,*;q=0.5"},
		};
	}
	
	public Map<String,List<String>> getAllResponseHeader(){
		return allResponseHeader;
	}
	
	public void setDefaultHeader(List<String[]> param){
        defHeader.addAll(param);
    }
	
	/**
	 * 表单数据对象
	 */
	public class FormObj{
		private String name = null;//字段名
		private Object value = null;//字段值
		private String memiType = null;//memi类型
		private String encode = null;//编码
		private String dataType = null;//数据类型
		private String uploadFileName = null;//上传文件时指定文件名，不填写就随机产生。格式：d:\\pic\\1.jpg
		
		public String getName() {
			return name;
		}
		public String getDataType() {
			return dataType;
		}
		public void setDataType(String dataType) {
			this.dataType = dataType;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		public String getMemiType() {
			return memiType;
		}
		public void setMemiType(String memiType) {
			this.memiType = memiType;
		}
		public String getEncode() {
			return encode;
		}
		public void setEncode(String encode) {
			this.encode = encode;
		}
        public String getUploadFileName() {
            return uploadFileName;
        }
        public void setUploadFileName(String uploadFileName) {
            this.uploadFileName = uploadFileName;
        }
        @Override
        public String toString() {
            return "FormObj [name=" + name + ", value=" + value + ", memiType=" + memiType + ", encode=" + encode
                    + ", dataType=" + dataType + "]";
        }
	}
	
	/**
	 * POST发送时数据使用
	 * 内部类
	 */
	public class PostData{
		
		private List<FormObj> list = new ArrayList<FormObj>();
		private String encode = "UTF-8";
		private String contentType = "text/plain";
		private boolean needUrlcoder = true;//是否需要编码
		
		public void setNeedUrlcoder(boolean needUrlcoder) {
			this.needUrlcoder = needUrlcoder;
		}
		
		public String getEncode() {
			return encode;
		}

		public void setEncode(String encode) {
			this.encode = encode;
		}
		
		public void put(String key ,String value) throws Exception{
			FormObj fobj = new FormObj();
			fobj.setDataType("TEXT");
			fobj.setName(key);
			if(this.needUrlcoder){
				fobj.setValue(URLEncoder.encode(new String(value.getBytes(this.encode),this.encode),this.encode));
			}else{
				fobj.setValue(new String(value.getBytes(this.encode),this.encode));
			}
			list.add(fobj);
		}
		
		public void multiput(String key ,String value, String filePathName){
			FormObj fobj = new FormObj();
			fobj.setDataType("FILE");
			fobj.setName(key);
			fobj.setValue(value);
			fobj.setUploadFileName(filePathName);
			list.add(fobj);
		}
		
		public void multiStream(String key ,Object value, String filePathName){
			FormObj fobj = new FormObj();
			fobj.setDataType("STREAM");
			fobj.setName(key);
			fobj.setValue(value);
			fobj.setUploadFileName(filePathName);
			list.add(fobj);
		}
		
		public List<FormObj> getReqParam(){
			return list;
		}

		public String getContentType() {
			return contentType;
		}

		public void setContentType(String contentType) {
			this.contentType = contentType;
		}
		
		public void clearPostData(){
			list.removeAll(list);
		}

        @Override
        public String toString() {
            return "PostData [list=" + list + ", encode=" + encode + ", contentType=" + contentType + ", needUrlcoder="
                    + needUrlcoder + "]";
        }
	}
	
	public void setEncodeType(String encodeType) {
		this.encodeType = encodeType;
	}
	
	/**
	 * 返回URL的原始响应头信息
	 * 如果连接超时可能返回NULL
	 */
	public Map<String,List<String>> getRealResponseHeader(){
		return realHeader;
	}
	
	/**
	 * 返回响应头,目前还没处理重复的头信息.
	 * 里面不包括Set-Cookie值,如果需要获得请使用getRealResponseHeader
	 * @param key
	 * @return
	 */
	public String getResponseHeader(String key){
		return responseHeader.get(key);
	}
	
	//GET
	public String exeGetRequest(String urlStr,String charset) throws SocketTimeoutException,IOException{
		HttpURLConnection huc = this.createUrl(urlStr,false,null);
		cs.addCookieInfo(huc);
		return this.getResponseStr(huc,charset);
	}
	
	//GET
	public String exeGetRequest(String urlStr,Map<String,String> headers,String charset) throws SocketTimeoutException,IOException{
		HttpURLConnection huc = this.createUrl(urlStr,false,headers);
		cs.addCookieInfo(huc);
		return this.getResponseStr(huc,charset);
	}
	
	//GET
	public String exeGetRequest(String urlStr,String referer,String charset) throws SocketTimeoutException,IOException{
		HashMap<String,String> headers = null;
		if(referer!=null && !"".equals(referer)){
			headers = new HashMap<String,String>();
			headers.put("Referer", referer);
		}
		HttpURLConnection huc = this.createUrl(urlStr,false,headers);
		//huc.connect();
		cs.addCookieInfo(huc);
		return this.getResponseStr(huc,charset);
	}
	
	/**
	 * 下载文件的流文件
	 * @param urlStr
	 * @param headers
	 * @return
	 * @throws Exception
	 */
	public byte[] exeDownloadByte(String urlStr,Map<String,String> headers) throws SocketTimeoutException,IOException{
		HttpURLConnection huc = this.createUrl(urlStr,false,headers);
		cs.addCookieInfo(huc);
		byte [] tmp = new byte[1024];
		InputStream is = huc.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try{
			while(true){
				int readIndex = is.read(tmp, 0, tmp.length);
				if(readIndex<=0){
					break;
				}
				baos.write(tmp,0,readIndex);
				baos.flush();
			}
			return baos.toByteArray();
		}finally{
			baos.close();
			is.close();
		}
	}
	
	/**
	 * 下载图片并保存
	 * @throws Exception 
	 */
	public void getFile(String urlStr,Map<String,String> headers,String desFile) throws Exception{
		byte [] byteStream = this.exeDownloadByte(urlStr, headers);
		FileOutputStream os = new FileOutputStream(desFile,true);
		try{
			os.flush();
			os.write(byteStream);
		}finally{
			os.close();
		}
	}
	
	/**
	 * 普通POST
	 * @param urlStr
	 * @param pd
	 * @param referer
	 * @return
	 * @throws Exception
	 */
	public String exePostRequest(String urlStr,PostData pd,String charset) throws SocketTimeoutException,IOException{
		HashMap<String,String> headers = null;
		return this.exePostRequest(urlStr, pd, headers, charset);
	}
	
	/**
	 * 普通POST
	 * @param urlStr
	 * @param pd
	 * @param referer
	 * @return
	 * @throws Exception
	 */
	public String exePostRequest(String urlStr,PostData pd,String referer,String charset) throws SocketTimeoutException,IOException{
		HashMap<String,String> headers = null;
		if(referer!=null && !"".equals(referer)){
			headers = new HashMap<String,String>();
			headers.put("Referer", referer);
		}
		return this.exePostRequest(urlStr, pd, headers,charset);
	}
	
	
	/**
	 * 普通POST
	 * @param urlStr
	 * @param pd
	 * @param referer
	 * @return
	 * @throws Exception
	 */
	public String exePostRequest(String urlStr,PostData pd,Map<String,String> headers,String charset) throws SocketTimeoutException,IOException{
		List<FormObj> isOk = pd.getReqParam();
		String queryParam = "";
		for(FormObj tmp : isOk){
			queryParam = queryParam + tmp.getName()+"="+tmp.getValue()+"&";
		}
		//拼装上传的参数
		if(!"".equals(queryParam)){
			queryParam = queryParam.substring(0,queryParam.lastIndexOf("&"));
		}
		
		if(headers == null){
			headers = new HashMap<String,String>();
		}
		
		headers.put("Content-type", "application/x-www-form-urlencoded");
		HttpURLConnection huc = this.createUrl(urlStr,true,headers);
		OutputStream os = null;
		try{
			os = huc.getOutputStream();
			os.write(queryParam.getBytes());
			os.flush();
		}finally{
			if(os != null){
				os.close();
			}
		}
		cs.addCookieInfo(huc);
		return this.getResponseStr(huc,charset);
	}
	
	/**
	 * 发送JSON格式的POST请求
	 * @param urlStr
	 * @param json
	 * @param headers
	 * @param charset
	 * @return
	 * @throws Exception
	 */
	public String exePostJSONRequest(String urlStr,String json,Map<String,String> headers,String charset) throws SocketTimeoutException,IOException{
		if(headers == null){
			headers = new HashMap<String,String>();
		}
		headers.put("Content-type", "application/json");
		HttpURLConnection huc = this.createUrl(urlStr,true,headers);
		OutputStream os = null;
		try{
			os = huc.getOutputStream();
			os.write(json.getBytes());
			os.flush();
		}finally{
			if(os != null){
				os.close();
			}
		}
		cs.addCookieInfo(huc);
		return this.getResponseStr(huc,charset);
	}
	
	/**
	 * 传文件数据类型POST
	 * @param urlStr
	 * @param pd
	 * @param referer
	 * @return
	 * @throws Exception
	 */
	public String exeMultipartPost(String urlStr,PostData pd,String charset) throws SocketTimeoutException,IOException{
		HashMap<String,String> headers = null;
		return this.exeMultipartPost(urlStr, pd, headers,charset);
	}
	
	/**
	 * 传文件数据类型POST
	 * @param urlStr
	 * @param pd
	 * @param referer
	 * @return
	 * @throws Exception
	 */
	public String exeMultipartPost(String urlStr,PostData pd,String referer,String charset) throws SocketTimeoutException,IOException{
		HashMap<String,String> headers = null;
		if(referer!=null && !"".equals(referer)){
			headers = new HashMap<String,String>();
			headers.put("Referer", referer);
		}
		return this.exeMultipartPost(urlStr, pd, headers,charset);
	}
	/**
	 * 传文件数据类型POST
	 * @param urlStr
	 * @param pd
	 * @param referer
	 * @return
	 * @throws Exception
	 */
	public String exeMultipartPost(String urlStr,PostData pd,Map<String,String> headers,String charset) throws SocketTimeoutException,IOException{
		HttpURLConnection huc = this.createUrl(urlStr,true,headers);
		String boundary =  "---------------------------" + URLTool.getRandomStr(13, null);
		huc.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
		DataOutputStream  dosIn = new DataOutputStream(huc.getOutputStream());
		try{
			//生成表单数据
			List<FormObj> isOk = pd.getReqParam();
			//拼装上传的参数
			for(FormObj tmp : isOk){
				String type = tmp.getDataType();
				String queryParam = "";
				if("TEXT".equals(type)){
					queryParam = queryParam + "--" + boundary + "\r\n";
					queryParam = queryParam + "Content-Disposition: form-data; name=\""+tmp.getName()+"\"\r\n\r\n";
					queryParam = queryParam + tmp.getValue() + "\r\n";
					dosIn.write(queryParam.getBytes());
				}else if("FILE".equals(type)){
				    String tmpFile = URLTool.getRandomStr(1, new String [] {"c","d","e","f","g"})+":\\"+ URLTool.getRandomStr(5, null) + ".jpg";
				    if(tmp.getUploadFileName() != null){
				        tmpFile = tmp.getUploadFileName();
				    }
					queryParam = queryParam + "--" + boundary + "\r\n";
					queryParam = queryParam + "Content-Disposition: form-data; name=\""+tmp.getName()+"\"; filename=\""+tmpFile+"\"\r\n";
					queryParam = queryParam + "Content-Type: "+pd.getContentType()+"\r\n\r\n";
					dosIn.write(queryParam.getBytes());
					dosIn.write(URLTool.getFileData(String.valueOf(tmp.getValue())));
					dosIn.write("\r\n".getBytes());
				}else if("STREAM".equals(type)){
					byte [] baos = (byte [])tmp.getValue();
					String tmpFile = URLTool.getRandomStr(1, new String [] {"c","d","e","f","g"})+":\\"+ URLTool.getRandomStr(5, null) + ".jpg";
					if(tmp.getUploadFileName() != null){
                        tmpFile = tmp.getUploadFileName();
                    }
					queryParam = queryParam + "--" + boundary + "\r\n";
					queryParam = queryParam + "Content-Disposition: form-data; name=\""+tmp.getName()+"\"; filename=\""+tmpFile+"\"\r\n";
					queryParam = queryParam + "Content-Type: "+pd.getContentType()+"\r\n\r\n";
					dosIn.write(queryParam.getBytes());
					dosIn.write(baos);
					dosIn.write("\r\n".getBytes());
				}
			}
			dosIn.write(("--" + boundary+ "--" +"\r\n").getBytes());
			dosIn.flush();
		}finally{
			if(dosIn!=null){
				dosIn.close();
			}
		}
		cs.addCookieInfo(huc);
		return this.getResponseStr(huc,charset);
	}
	
	/**
	 * 产生一个随机数
	 * @param getLength 获得多长
	 * @param src 自己定义随机字符数组,如果长度为0或者NULL使用默认数组.
	 * @return
	 */
	public static String getRandomStr(int getLength,String [] src){
		Random random = new Random();
		if(getLength == 0){
			getLength = 10;
		}
		String returnS = "";
		int tmp = 0;
		if(src != null && src.length>0){
			for(int index=0;index<getLength;index++){
				tmp = random.nextInt(src.length);
				returnS = returnS + src[tmp];
			}
		}else{
			for(int index=0;index<getLength;index++){
				tmp = random.nextInt(RANS.length);
				returnS = returnS + RANS[tmp];
			}
		}
		return returnS;
	}
	
	public static byte[] getFileData(String path) throws IOException{
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		try{
			is = new FileInputStream(path);
			baos = new ByteArrayOutputStream();
			byte [] tmp = new byte[4096];
			while(true){
				int i = is.read(tmp, 0, tmp.length);
				if(i <= 0){
					break;
				}
				baos.write(tmp,0,i);
			}
		}finally{
			if(is != null){
				is.close();
			}
			if(is != null){
				baos.close();
			}
		}
		return baos.toByteArray();
	}
	
	/**
	 * 创建URL
	 * @throws Exception 
	 */
	private HttpURLConnection createUrl(String urlStr,boolean isPost,Map<String,String> header) throws SocketTimeoutException,IOException{
		URL url = new URL(urlStr);
		HttpURLConnection huc = (HttpURLConnection)url.openConnection();
		huc.setInstanceFollowRedirects(false);
		if(isPost){
			huc.setAllowUserInteraction(false);
			huc.setDoOutput(true); // 需要向服务器写数据
			huc.setUseCaches(false); // 为false时,每次获得服务器最新的信息
			huc.setRequestMethod("POST");
		}
		huc.setReadTimeout(10000);
		huc.setConnectTimeout(10000);
		this.addHeader(urlStr, huc, header);
		return huc;
	}
	
	/**
	 * 重置COOKIE
	 */
	public void resetCookie(String cookieStrS){
		List<String[]> list = this.cs.getCurrCookie();
		list.removeAll(list);
		
		String [] tmp1 = cookieStrS.split(";");
		for(String tmp2 : tmp1){
			String key = tmp2.substring(0,tmp2.indexOf("=")).trim();
			String value = tmp2.substring(tmp2.indexOf("=")+1,tmp2.length()).trim();
			list.add(new String[]{key,value});
		}
	}
	
	/**
	 * 添加COOKIE
	 */
	public void addCookie(String cookieStrS){
		List<String[]> list = this.cs.getCurrCookie();
		String [] tmp1 = cookieStrS.split(";");
		for(String tmp2 : tmp1){
			String key = tmp2.substring(0,tmp2.indexOf("=")).trim();
			String value = tmp2.substring(tmp2.indexOf("=")+1,tmp2.length()).trim();
			boolean isExist = false;
			for(String [] tmp4 : list){
				if(key.equals(tmp4[0])){
					isExist = true;
					tmp4[0] = key;
					tmp4[1] = value;
					break;
				}
			}
			if(!isExist){
				list.add(new String[]{key,value});
			}
		}
	}
	
	/**
	 * 返回的HTML页面字符串
	 * @param uc
	 * @return
	 * @throws IOException
	 */
	private String getResponseStr(URLConnection uc,String encodeParam) throws IOException{
		String encode = null;
		String ce = uc.getHeaderField("Content-Encoding");
		//获取页面的字符编码集
		if(encodeParam != null && !"".equals(encodeType.replaceAll("[\\s]+?", ""))){
			encode = encodeParam;
		}else{
			String value  = uc.getHeaderField("Content-Type");
			if(value!=null){
				String [] contentTypes = value.split(";");
				for(String ss : contentTypes){
					String key = ss.split("=")[0];
					if(key.matches("[\\s\\S]*charset[\\s\\S]*")){
						encode = ss.split("=")[1];
					}
				}
			}else{
				if(encodeType == null || "".equals(encodeType.replaceAll("[\\s]+?", ""))){
					encode = "ISO-8859-1";
				}else{
					encode = encodeType;
				}
			}
		}
		if(encode == null || "".equals(encode)){
			encode = encodeType;
		}
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		GZIPInputStream gs = null;
		StringBuilder sb = new StringBuilder(1024 * 10);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte [] tmpS = new byte[4096];
		//int i = 0;
		try{
			is = uc.getInputStream();
			//对方网站是压缩流的情况.
			if(ce!= null && "gzip".equals(ce.toLowerCase())){
				gs = new GZIPInputStream(is);
				while(true){
					int ilnength = gs.read(tmpS,0,tmpS.length);
					if(ilnength <= 0){
						break;
					}
					baos.write(tmpS, 0, ilnength);
				}
			}else{
				while(true){
					int ilnength = is.read(tmpS,0,tmpS.length);
					if(ilnength <= 0){
						break;
					}
					baos.write(tmpS, 0, ilnength);
				}
			}
			sb.append(new String(baos.toByteArray(),encode));
		}finally{
			if(br!= null){
				br.close();
			}
			if(isr!= null){
				isr.close();
			}
			if(gs!= null){
				gs.close();
			}
			if(is!= null){
				is.close();
			}
		}
		return sb.toString();
	}
	
	/**
	 * 加入自定义请求头和初始化请求头.
	 * @param urlc
	 */
	private void addHeader(String urlStr,URLConnection urlc,Map<String,String> headers){
		for(String [] tmp : initHeader){
			urlc.setRequestProperty(tmp[0],tmp[1]);
		}
		for(String [] tmp : defHeader){//用户自定义的请求头
			urlc.setRequestProperty(tmp[0],tmp[1]);
		}
		if(headers != null && urlc != null){
			for(Map.Entry<String, String> tmp : headers.entrySet()){
				urlc.setRequestProperty(tmp.getKey(), tmp.getValue());
			}
		}
		List<String[]> tmpCookie = cs.getCurrCookie();
		if(tmpCookie != null){
			String cookS = "";
			for(String [] tmp : tmpCookie){
				cookS = cookS + tmp[0] + "=" + tmp[1]+"; ";
			}
			urlc.setRequestProperty("Cookie",cookS.substring(0,cookS.lastIndexOf(";")));
		}
	}
	
	/**
	 * 私有的COOKIE仓库类
	 * @author 陈
	 */
	private class CookieStore{
		
		private Map<String,List<String[]>> cookieMap = new HashMap<String,List<String[]>>();
		
		/**
		 * 根据域名得到自身的COOKIE
		 * @param url
		 * @return
		 */
		public List<String[]> getCurrCookie(){
			return cookieMap.get("CURR_COOKIE");
		}
		
		/**
		 * 把COOKIE和返回的响应头对应好并装入内存,并且与自身的域名对应.
		 * @param huc
		 * @throws IOException 
		 */
		public void addCookieInfo(HttpURLConnection huc) throws IOException{
			responseHeader = new HashMap<String, String>();
			Map<String,List<String>> map = huc.getHeaderFields();
			if(map != null && !map.isEmpty()){
			    allResponseHeader.putAll(map);
			}
			for(Map.Entry<String, List<String>> tmp : map.entrySet()){
				String responseKey = tmp.getKey();
				List<String> list = tmp.getValue();
				for(String tmpS : list){
				    try{
				        if("Set-Cookie".equalsIgnoreCase(tmp.getKey())){
	                        //COOKIE的作用域
	                        String nameValue = null;
	                        //COOKIE的过期时间--这里不用指定
	                        String [] arrayS = tmpS.split(";");
	                        //COOKIE的键值对
	                        nameValue = arrayS[0];
	                        if(cookieMap.isEmpty()){
	                            List<String[]> tmpcook = new ArrayList<String[]>();
	                            String [] tmpSA = new String[2];
	                            tmpSA[0] = nameValue.substring(0,nameValue.indexOf("="));
	                            tmpSA[1] = nameValue.substring(nameValue.indexOf("=")+1,nameValue.length());
	                            tmpcook.add(tmpSA);
	                            cookieMap.put("CURR_COOKIE", tmpcook);
	                        }else{
	                            List<String[]> tmpcook = cookieMap.get("CURR_COOKIE");
	                            String [] tmpSA = new String[2];
	                            tmpSA[0] = nameValue.substring(0,nameValue.indexOf("="));
	                            tmpSA[1] = nameValue.substring(nameValue.indexOf("=")+1,nameValue.length());
	                            boolean isExist = false;
	                            for(String [] tmp1 : tmpcook){
	                                if(tmpSA[0].equals(tmp1[0])){
	                                    isExist = true;
	                                    tmp1[0] = tmpSA[0];
	                                    tmp1[1] = tmpSA[1];
	                                    break;
	                                }
	                            }
	                            if(!isExist){
	                                tmpcook.add(tmpSA);
	                            }
	                        }
	                    }else{
	                        realHeader = map;
	                        responseHeader.put(responseKey, tmpS);
	                    }
				    }catch(Exception e){
				        e.printStackTrace();
				    }
				}
			}
		}
	}
}