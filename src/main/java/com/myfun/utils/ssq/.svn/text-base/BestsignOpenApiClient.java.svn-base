package com.myfun.utils.ssq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;

import java.io.IOException;
import java.util.HashMap;

/**
 * 上上签混合云SDK客户端
 */
public class BestsignOpenApiClient {

	public static String developerId =  AppConfig.getProperty("common.ssq.developerId"); //"1575542148012377857";

	public static String privateKey =  AppConfig.getProperty("common.ssq.privateKey"); //"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDMaA/G+p4Mgm9CSYSjJR6OofbxsPO/ocas4x+pmYtsCbVLUN+hBdS5gur8kXmVcS71hKlfm7LN5PDzjMZS5/AfZHTnxTIEzBv+Qoq8LUMEDEWjBrtD92oQ81jthTUeBzhgvWBody327nycjYbp3m96Ee/6wK4rhSgFnO7BaDOAGWvdk4ah+S2g1u+0EeHjmUmnBlkhMETJpsnV50sjueGht095XGDUFWP82oaGtVtz9BwF7K1HQXqyAeuLMZuMoZjJeu+F7yiRDQX8ykMJ4pbQmYLsYd2cYPMigK/BNfh8LqUhs1RZRfyJiBjCzijrYjhLeaorpL8El268JV+m2f+FAgMBAAECggEAWO/SJY535BOAm0PnrSCCeibojmKiu7eE/UZZSW7gZeKXeiy3EJW75/eZjMkzMJ2tg+/zzgCtvL4nRKD0za/TH6WS5CE90S6J44hKWvQKm6FHT1andjwZb0SiZb42zVjw486iOvHYEv/TQj6l++3nbSKO2vipD5CBSGfuzkIrXklqB1EukQLsdiQoGfcbIyRnpCIJXVR5CIhbzRNGqvvwkJaDX3GSZtMHhBLdFlynFx2XRZuUIQUFt25Sp5hCJBUEpSBY7RGIbAY1wDMLFN3btyQI0DEoik9DNksGZR3M0UAsxLBCeK3w/8uMfeoFfpK2VaoiIf49+x+DHBf9nFV6xQKBgQDv0mhs5K24F/LBEPl2xQyNA7E0JNsCz5QvWiZkYqmQ5GgBcUOY48Xxcd6KJViqL7QzyIF2h4Gqc6mEDdC01FzLX8n7CVxbdgpJN4ahjfvsG1qgVokMwTnq3NuoxakOnSJ87gLWgkHRtdcY+FGs1xPJunCqTnQMN7HnvdFGdcvpRwKBgQDaMgyM5SIvKqxpC4ym9nD9F+JnlEYL0rhB7qHCi2zhPYUiuTN0in++nDxxzExUueol/vZKTl4+71T7pBmqUtP0a3gJJk1j09/cZTsyvEo06UPOKLIo/sci8J1KkNJI+xyobpwqH4RIS1CTZg6H3uesclhWZjR6caIu6p8Z3K520wKBgDK0KZ/cOV5SseBf1l5mCuFFhpGfuS4+9PWN+c//jBo2MEcdy0zn21HQ4VwTyUsyCsdn/Pcybxe6nHxu71FMFNJqzillMUGlE0enla9SdZDVt7NumEs6DyS4zThBkhyk3EXNjIwNvhy4dWGyHpKMZoKgCHH5ZE+w9swoNbbP8OzBAoGAdXPniZh2FEm2UT1kUyPponPO7c7E/exKP0ODU8PVslF5bz2eUyeSqDpV1zQQCrOhNR7P2SPiW6Jdbq/hGOxJKBMJpHM3yXrt0Ce1/BObJmxCkaEadjLfYxF+ufrHF34E6S3RZmNcw8W29AFF5SG6N/u9TZTqvtaYZQTq6/L8/v0CgYEAw74VY3npcp1BBZlJIir8bRQb5qxcDTRmrlKA1/FGqvhrLyHWeUUPK0iUyanQiWDlVR7dkgC34WTCtGI5ZEKrGmV2ky7Dy1n/j7YFZreJ08Wyady2lqMY7s/8fSGxfQo/iSCtEswroNSJwKFWzeN9zoZxTciNuYxUj9Fx7Kyv/Dg=";

	public static String serverHost =  AppConfig.getProperty("common.ssq.serverHost"); // "https://openapi.bestsign.cn/openapi/v2";
	
	public static String appId = AppConfig.getProperty("common.ssq.appId");
	
	public static String secret = AppConfig.getProperty("common.ssq.secret");
	
	public static String urlSignParams = "?developerId=%s&rtick=%s&signType=rsa&sign=%s";


	// ***************常规接口start*****************************************************
	/***
	 * 个人用户注册
	 * @param account 账号，手机号
	 * @param name 姓名
	 * @param identity 身份证
	 * 
	 * @return
	 * {
		    "account": "test@bestsign.cn",     
		    "name": "张三", 
		    "userType": "1", 
		    "mail": "test@bestsign.cn", 
		    "mobile": "13800001234", 
		    "credential": {
		        "identity": "100123199001010011", 
		        "identityType": "0", 
		        "contactMail": "test@bestsign.cn", 
		        "contactMobile": "13800001234", 
		        "province": "浙江省", 
		        "city": "杭州市", 
		        "address": "xx路xx号"
		    }, 
		    "applyCert": "1"
		}
	 * @throws Exception
	 */
	public static String userPersonalReg(String account, String name, String identity) throws Exception {
		String host = serverHost;
		String method = "/user/reg/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("name", name);
		requestBody.put("userType", "1");

		JSONObject credential = new JSONObject();
		credential.put("identity", identity);
		credential.put("identityType", "0");
		requestBody.put("credential", credential);
		requestBody.put("applyCert", "1");

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			JSONObject data = jsonObj.getJSONObject("data");
			if (data != null) {
				return data.getString("taskId");
			}
			return null;
		} else {
			throw new Exception(jsonObj.getIntValue("errno") + ":"
					+ jsonObj.getString("errmsg"));
		}
	}
	
	/***
	 * 注册企业用户
	 * @param account 账号adminCompId
	 * @param name 企业名称
	 * @param regCode 工商注册号
	 * @param orgCode 组织机构代码
	 * @param taxCode 税务登记证号
	 * @param legalPerson 法人代表姓名
	 * @param legalPersonIdentity 法人代表证件号
	 * @param contactMobile 联系手机必填，为CA年检抽查时联系使用
	 * @return
	 * {
		    "account": "test@bestsign.cn", 
		    "mail": "test@bestsign.cn", 
		    "mobile": "13800001234", 
		    "name": "浙江xx公司", 
		    "userType": "2", 
		    "credential": {
		        "regCode": "5566789", 
		        "taxCode": "5566789", 
		        "orgCode": "5566789", 
		        "contactMail": "test@bestsign.cn", 
		        "contactMobile": "13800001234", 
		        "legalPerson": "张三", 
		        "legalPersonIdentity": "100123199001010011", 
		        "legalPersonIdentityType": "0", 
		        "legalPersonMobile": "17712341234", 
		        "province": "浙江省", 
		        "city": "杭州市", 
		        "address": "xx路xx号"
		    }, 
		    "applyCert": "1"
		}
	 * @throws IOException
	 */
	public static String userEnterpriseReg(String account, String name, String regCode,
			String orgCode, String taxCode, String legalPerson,
			String legalPersonIdentity, String contactMobile) throws IOException {
		String host = serverHost;
		String method = "/user/reg/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("name", name);
		requestBody.put("userType", "2");

		JSONObject credential = new JSONObject();
		credential.put("regCode", regCode);
		credential.put("orgCode", orgCode);
		credential.put("taxCode", taxCode);
		credential.put("legalPerson", legalPerson);
		credential.put("legalPersonIdentity", legalPersonIdentity);
		credential.put("legalPersonIdentityType", "0");
		credential.put("contactMobile", contactMobile);
		requestBody.put("credential", credential);
		requestBody.put("applyCert", "1");

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			JSONObject data = jsonObj.getJSONObject("data");
			if (data != null) {
				return data.getString("taskId");
			}
		} 
		throw new BusinessException("注册失败"+jsonObj.getString("errmsg"));
	}
	
	
	/***
	 * 生成印章
	 * @param account 账户
	 * @return
	 * {
		    "account": "13456833929", 
		    "text": "",
		    "fontName":"",
		    "fontSize":"",
		    "fontColor":""
		}
	 * @throws Exception
	 */
	public static String signatureImageCreate(String account) throws Exception {
		String host = serverHost;
		String method = "/signatureImage/user/create/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		return responseBody;
	}
	
	/***
	 * 查询证书
	 * @param account
	 * @return
	 * {
		    "errno": 0, 
		    "errmsg": "", 
		    "cost": 233, 
		    "data": {
		        "account": "1674224491900698632", 
		        "certId": "CFCA-33-20171010142326279-12345"
		    }
		}
	 * @throws Exception
	 */
	public static String getCert(String account) throws Exception {
		String host = serverHost;
		String method = "/user/getCert/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			return responseBody;
		} else {
			throw new Exception(jsonObj.getIntValue("errno") + ":"
					+ jsonObj.getString("errmsg"));
		}
	}
	
	
	
	/**
	 * 2.3 下载用户默认签名
	 * 
	 * @param account
	 *            用户账号
	 * @param imageName
	 *            签名图片名称 传空或default为默认签名图片。 企业用户传自定义印章名称则下载指定的图片。
	 * @return
	 * @throws Exception
	 */
	public static byte[] signatureImageDownload(String account, String imageName)
			throws Exception {
		String host = serverHost;
		String method = "/storage/signatureImage/user/download/";

		// 组装url参数
		String urlParams = "account=" + account + "&imageName=" + imageName;

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, urlParams, null);
		// 签名参数追加为url参数
		urlParams = String.format(urlSignParams, developerId, rtick,
				paramsSign) + "&" + urlParams;
		// 发送请求
		byte[] responseBody = HttpClientSender.sendHttpGet(host, method,
				urlParams);
		// 返回结果解析
		return responseBody;
	}	
	
	/**
	 * 上传并创建合同
	 * @param account 用户账号
	 * @param fmd5 文件MD5值
	 * @param fname 文件名称 文件名必须带上后缀名，例如“XXXX.pdf”
	 * @param fpages 文件总页数
	 * @param fdata 文件内容
	 * @param description 合同内容描述
	 * @param title 合同标题
	 * @return
	 * {
		  "errno": 0,
		  "data": {
		    "contractId": "150347846001000001"
		  },
		  "errmsg": ""
		}
	 * @throws Exception
	 */
	public static String contractUpload(String account,String fmd5,String fname,String fpages,String fdata,String description,String title) throws Exception {
		String host = serverHost;
		String method = "/storage/contract/upload/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("expireTime", String.valueOf(System.currentTimeMillis() / 1000 + 3600 * 24 * 365 * 5)); //有效期
		requestBody.put("description", description);
		requestBody.put("title", title);
		requestBody.put("fdata", fdata);
		requestBody.put("fpages", fpages);
		requestBody.put("fname", fname);
		requestBody.put("ftype", "pdf");
		requestBody.put("account", account);
		requestBody.put("fmd5", fmd5);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			return responseBody;
		} else {
			throw new Exception(jsonObj.getIntValue("errno") + ":"
					+ jsonObj.getString("errmsg"));
		}
	}
	
	/***
	 * 自动签名，一般生成合同时，公司就自动签名了
	 * @param contractId 合同ID
	 * @param signerAccount 签署者账号
	 * @param pageNum 签名页码
	 * @param x 签名x坐标
	 * @param y 签名y坐标
	 * @return
	* {
	    "errno":0,
	    "data":{},
	    "errmsg":""
	 }
	 * @throws Exception
	 */
	public static String cert(String contractId, String signerAccount, String pageNum, String signX, String signY) throws Exception {
		String host = serverHost;
		String method = "/contract/sign/cert/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("signerAccount", signerAccount);
		requestBody.put("contractId", contractId);
		JSONArray signaturePositionsArray = new JSONArray();
		JSONObject signaturePositionsObject = new JSONObject();
		signaturePositionsObject.put("pageNum", pageNum);
		signaturePositionsObject.put("x", signX);
		signaturePositionsObject.put("y", signY);
		signaturePositionsArray.add(signaturePositionsObject);
		requestBody.put("signaturePositions", signaturePositionsArray);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		return responseBody;
	}
	
	/***
	 * 发送合同（即手动签）
	 * @param signer 账号
	 * @param contractId 合同id
	 * @return
	 * {
		    "contractId": "cU34344234", 
		    "expireTime": "0", 
		    "dpi": "120", 
		    "signer": "", 
		    "signaturePositions": [
		        {
		            "pageNum": "1", 
		            "x": "0.4622", 
		            "y": "0.5852999973297119", 
		            "rptPageNums": "", 
		            "type": "date", 
		            "dateTimeFormat": "MM-dd-yyyy", 
		            "fontSize": "18"
		        }, 
		        {
		            "pageNum": "6", 
		            "x": "0.4622", 
		            "y": "0.7852999973297119"
		        }
		    ], 
		    "isAllowChangeSignaturePosition": "0", 
		    "returnUrl": "", 
		    "vcodeMobile": "", 
		    "isDrawSignatureImage": "1", 
		    "signatureImageName": "default", 
		"pushUrl": "https://xxxxxxx"
		}
	 * @throws Exception
	 */
	public static String send(String signer,String contractId, String pageNum, String signX, String signY, String dateX, String dateY, String pushUrl, String returnUrl) throws Exception {
		String host = serverHost;
		String method = "/contract/send/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("expireTime", String.valueOf(System.currentTimeMillis() / 1000 + 3600*24));
		requestBody.put("signer", signer);
		requestBody.put("contractId", contractId);
//		requestBody.put("isShowHandwrittenTime", "1"); //是否显示手写时间
		requestBody.put("isDrawSignatureImage", "2"); // 2强制必须手绘签名
		requestBody.put("pushUrl", pushUrl);//此处有配置则签署推送消息优先使用此配置，如果此处没有配置，则取开发者统一配置的异步推送地址
		requestBody.put("returnUrl", returnUrl);//手动签署时，当用户签署完成后，签署页面指定回跳的页面地址，如果没填此参数则签署完成后跳转到合同预览页面。
		JSONArray signaturePositionsArray = new JSONArray();
		// 签名
		JSONObject signaturePositionsObject = new JSONObject();
		signaturePositionsObject.put("pageNum", pageNum);
		signaturePositionsObject.put("x", signX);
		signaturePositionsObject.put("y", signY);
		signaturePositionsObject.put("signatureImageWidth", "65");
		signaturePositionsObject.put("signatureImageHeight", "24");
		signaturePositionsArray.add(signaturePositionsObject);
		// 时间
		JSONObject signaturePositionsDateObject = new JSONObject();
		signaturePositionsDateObject.put("pageNum", pageNum);
		signaturePositionsDateObject.put("x", dateX);
		signaturePositionsDateObject.put("y", dateY);
		signaturePositionsDateObject.put("type", "date");
		signaturePositionsDateObject.put("dateTimeFormat", "yyyy-MM-dd");
		signaturePositionsDateObject.put("fontSize", "18");
		signaturePositionsArray.add(signaturePositionsDateObject);
		requestBody.put("signaturePositions", signaturePositionsArray);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		return responseBody;
	}
	
	
	public static String sendSignVCode(String account,String contractId) throws Exception {
		String host = serverHost;
		String method = "/contract/sendSignVCode/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("contractId", contractId);
		requestBody.put("sendTarget", account);
		requestBody.put("sendType", "sms");
		requestBody.put("seconds", "180");

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println(responseBody);
		return responseBody;
	}
	
	/***
	 * 锁定并结束合同
	 * @param contractId 合同id
	 * @return
	 * {
		  "errno": 0,
		  "data": {
		  },
		  "errmsg": ""
		}
	 * @throws Exception
	 */
	public static String lock(String contractId) throws Exception {
		String host = serverHost;
		String method = "/storage/contract/lock/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("contractId", contractId);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		return responseBody;
	}
	
	public static String face(String account,String name, String identity, String returnUrl,String sid) throws Exception {
		String host = serverHost;
		String method = "/realName/personal/identity2/face";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("name", name);
		requestBody.put("identity", identity);
		requestBody.put("returnUrl", returnUrl);
		requestBody.put("sid", sid);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println(responseBody);
		return responseBody;
	}
	
	public static String getTemplateVars(String tid) throws Exception {
		String host = serverHost;
		String method = "/template/getTemplateVars/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("tid", tid);
		requestBody.put("isRetrieveAllVars", "1");

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println(responseBody);
		return responseBody;
	}
	
	public static String templateCreateContractPdf(String account, String tid) throws Exception {
		String host = serverHost;
		String method = "/template/createContractPdf/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("tid", tid);
		requestBody.put("account", account);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("text", "测试变量");
		requestBody.put("templateValues", jsonObject);
		

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println(responseBody);
		return responseBody;
	}
	
	
	public static String createByTemplate(String account, String tid,String templateToken) throws Exception {
		String host = serverHost;
		String method = "/contract/createByTemplate/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("tid", tid);
		requestBody.put("account", account);
		requestBody.put("templateToken", templateToken);
		requestBody.put("expireTime", String.valueOf(System.currentTimeMillis() / 1000 + 3600*24));
		requestBody.put("title", "在线电子签约");
		requestBody.put("description", "在线电子签约");
		

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println(responseBody);
		return responseBody;
	}
	
	public static String getPreviewURL(String account, String contractId) throws Exception {
		String host = serverHost;
		String method = "/contract/getPreviewURL/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("contractId", contractId);
		requestBody.put("account", account);
		

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println(responseBody);
		return responseBody;
	}
	
	public static String sendByTemplate(String contractId, String tid, String signer, String pushUrl) throws Exception {
		String host = serverHost;
		String method = "/contract/sendByTemplate/";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("contractId", contractId);
		requestBody.put("tid", tid);
		requestBody.put("signer", signer);
		requestBody.put("pushUrl", pushUrl);
		requestBody.put("isDrawSignatureImage", "2");
		
		requestBody.put("varNames", "sign");

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println(responseBody);
		return responseBody;
	}
	
	/***
	 * 刷脸
	 * @param account
	 * @param orderNo
	 * @return 
	 * {
		    "errno":0,
		    "cost":1350,
		    "data": {
		        "orderNo":"***",
		        "webankUserid":"***",
		        "randomStr":"ewberbhwqoubforntijwnrqfmzkfcb123",
		        "faceAuthSign":"EAD817B9634AC4852A181D403F84333ADF4B6416"
		    },
		"errmsg":"" 
		}
	 * @throws Exception
	 */
	public static String idcardFaceVerify(String account, String orderNo) throws Exception {
		String host = serverHost;
		String method = "/webank/getFaceAuthSign/idcardFaceVerify";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("orderNo", orderNo);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		return responseBody;
	}
	
	/***
	 * 验证刷脸
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public static String getFaceAuthResult(String orderNo) throws Exception {
		String host = serverHost;
		String method = "/webank/getFaceAuthResult";
		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("orderNo", orderNo);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		return responseBody;
	}
	
	/***
	 * 下载合同
	 * @param contractId
	 * @return
	 * @throws Exception
	 */
	public static byte[] contractDownload(String contractId)
			throws Exception {
		String host = serverHost;
		String method = "/storage/contract/download/";

		// 组装url参数
		String urlParams = "contractId=" + contractId;

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, urlParams, null);
		// 签名参数追加为url参数
		urlParams = String.format(urlSignParams, developerId, rtick,
				paramsSign) + "&" + urlParams;
		// 发送请求
		byte[] responseBody = HttpClientSender.sendHttpGet(host, method,
				urlParams);
		// 返回结果解析
		return responseBody;
	}	
	
	
	public static String addPdfElements(String account,String fmd5,String fname,String fpages,String fdata,String isCleanup) throws Exception {
		String host = serverHost;
		String method = "/storage/addPdfElements/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("fmd5", fmd5);
		requestBody.put("fname", fname);
		requestBody.put("fpages", fpages);
		requestBody.put("fdata", fdata);
		requestBody.put("isCleanup", isCleanup);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			return responseBody;
		} else {
			throw new Exception(jsonObj.getIntValue("errno") + ":"
					+ jsonObj.getString("errmsg"));
		}
	}
	
	/**
	 * 企业三要素验证
	 * @param name
	 * @param identity
	 * @param legalPerson
	 * @return
	 * @throws Exception
	 * responseBody:{"errno":0,"cost":225,"data":{"result":"1","msg":"success"},"errmsg":""}
	 * responseBody:{"errno":0,"cost":133,"data":{"result":"0","msg":"查询无结果"},"errmsg":""}
	 */
	public static String identity3(String name,String identity,String legalPerson) throws Exception {
		String host = serverHost;
		String method = "/credentialVerify/enterprise/identity3";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", name);
		requestBody.put("identity", identity);
		requestBody.put("legalPerson", legalPerson);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			return responseBody;
		} else {
			throw new Exception(jsonObj.getIntValue("errno") + ":"
					+ jsonObj.getString("errmsg"));
		}
	}
	
	/**
	 * 发送短信验证
	 * @param account
	 * @param name
	 * @param identity
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static String vcodeSender(String account,String name,String identity,String mobile) throws Exception {
		String host = serverHost;
		String method = "/realName/personal/identity3/vcode/sender/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("name", name);
		requestBody.put("identity", identity);
		requestBody.put("mobile", mobile);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			return responseBody;
		} else {
			throw new Exception(jsonObj.getIntValue("errno") + ":"
					+ jsonObj.getString("errmsg"));
		}
	}
	
	/**
	 * 验证短信
	 * @param account
	 * @param name
	 * @param identity
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public static String vcodeVerify(String vcode,String personalIdentity3Key) throws Exception {
		String host = serverHost;
		String method = "/realName/personal/identity3/vcode/verify/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("vcode", vcode);
		requestBody.put("personalIdentity3Key", personalIdentity3Key);

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		System.out.println("host:" + host);
		System.out.println("method:" + method);
		System.out.println("urlParams:" + urlParams);
		System.out.println("requestBody:" + requestBody.toJSONString());
		System.out.println("responseBody:" + responseBody);
		// 返回结果解析
		JSONObject jsonObj = JSON.parseObject(responseBody);
		// 返回errno为0，表示成功，其他表示失败
		if (jsonObj.getIntValue("errno") == 0) {
			return responseBody;
		} else {
			throw new Exception(jsonObj.getIntValue("errno") + ":"
					+ jsonObj.getString("errmsg"));
		}
	}
	
	public static HashMap<String, String> userPersonalRegTest(String account, String name, String identity) throws Exception {
		String host = serverHost;
		String method = "/user/reg/";

		// 组装请求参数，作为requestbody
		JSONObject requestBody = new JSONObject();
		requestBody.put("account", account);
		requestBody.put("name", name);
		requestBody.put("userType", "1");

		JSONObject credential = new JSONObject();
		credential.put("identity", identity);
		credential.put("identityType", "0");
		requestBody.put("credential", credential);
		requestBody.put("applyCert", "1");

		// 生成一个时间戳参数
		String rtick = RSAUtils.getRtick();
		// 计算参数签名
		String paramsSign = RSAUtils.calcRsaSign(developerId,
				privateKey, host, method, rtick, null,
				requestBody.toJSONString());
		// 签名参数追加为url参数
		String urlParams = String.format(urlSignParams, developerId,
				rtick, paramsSign);
		// 发送请求
		String responseBody = HttpClientSender.sendHttpPost(host, method,
				urlParams, requestBody.toJSONString());
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("developerId", developerId);
		hashMap.put("privateKey", privateKey);
		hashMap.put("rtick", rtick);
		hashMap.put("host", host);
		hashMap.put("method", method);
		hashMap.put("paramsSign", paramsSign);
		hashMap.put("urlParams", urlParams);
		hashMap.put("requestBody", requestBody.toJSONString());
		hashMap.put("responseBody", responseBody);
		return hashMap;
	}
	
}
