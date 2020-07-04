package com.myfun.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dyplsapi.model.v20170525.BindAxnRequest;
import com.aliyuncs.dyplsapi.model.v20170525.BindAxnResponse;
import com.aliyuncs.dyplsapi.model.v20170525.QueryRecordFileDownloadUrlRequest;
import com.aliyuncs.dyplsapi.model.v20170525.QueryRecordFileDownloadUrlResponse;
import com.aliyuncs.dyplsapi.model.v20170525.ReleaseSecretNoRequest;
import com.aliyuncs.dyplsapi.model.v20170525.ReleaseSecretNoResponse;
import com.aliyuncs.dyplsapi.model.v20170525.UnbindSubscriptionRequest;
import com.aliyuncs.dyplsapi.model.v20170525.UnbindSubscriptionResponse;
import com.aliyuncs.dyplsapi.model.v20170525.UpdateSubscriptionRequest;
import com.aliyuncs.dyplsapi.model.v20170525.UpdateSubscriptionResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.myfun.framework.config.AppConfig;
import com.myfun.utils.StringUtil;

public class AliyunPhoneNumberProtectionUtil {

	 
	private static DefaultProfile profile = null;
	private static IAcsClient client = null;
	
	
	public static IAcsClient getIAcsClient() throws ClientException {
		if(client==null) {
			profile = DefaultProfile.getProfile("cn-hangzhou", AppConfig.getProperty("common.aliyun.axn.accessKeyId"), AppConfig.getProperty("common.aliyun.axn.secret"));
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dyplsapi", "dyplsapi.aliyuncs.com");
			client = new DefaultAcsClient(profile);
		}
		return client;
	}
	
	/**
	 * 绑定人员A和X 之间的关系
	 * @param phoneNoA
	 * @param phoneNoX
	 * @param poolKey
	 * @param expiration
	 * {"requestId":"7570809D-037B-4835-BEA0-4F97E1C90749","code":"isv.BIND_CONFLICT","message":"isv.BIND_CONFLICT","secretBindDTO":{}}
	 * {"code":"OK","requestId":"E15B264D-F611-45E3-83B8-0D0EB0E514E1","secretBindDTO":{"extension":"1576822942407","subsId":"1000010210420107","secretNo":"17137611962"},"message":"OK"}
	 * @return
	 */
    public static JSONObject bindAxn(String phoneNoA,String phoneNoX,String poolKey,String expiration) {
    	BindAxnRequest request = new BindAxnRequest();
	    request.setPhoneNoA(phoneNoA); //A
        request.setPoolKey(poolKey);// 号池key
        request.setPhoneNoX(phoneNoX);//X 不填随机选择一个绑定
       // request.setPhoneNoB(phoneNoB);//N 
       // IsRecordingEnabled	Boolean	否	true	
        request.setIsRecordingEnabled(true);// 开启录音
        
        if(StringUtil.isEmpty(expiration)) {//为空
	    	request.setExpiration("2099-1-31 23:59:59"); //过期时间 设置一个不可能到达的时间
	    }
	    try {
	        BindAxnResponse response = getIAcsClient().getAcsResponse(request);
	        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(response));
	        System.out.println(jsonObject);
	        return jsonObject;
	    } catch (ServerException e) {
	        e.printStackTrace();
	    } catch (ClientException e) {
	        System.out.println("ErrCode:" + e.getErrCode());
	        System.out.println("ErrMsg:" + e.getErrMsg());
	        System.out.println("RequestId:" + e.getRequestId());
	    }
	    
		return null;
	}
    
    /**
     * {"requestId":"EECCA19E-1FB7-4961-BA2E-9C8A16222088","code":"OK","message":"OK"}
     * {"code":"isv.ILLEGAL_ARGUMENT","requestId":"BDAA7481-DD53-497C-8324-C906714CD1AF","message":"subs not exist"}
     * @param subsId
     * @param phoneNoX
     * @param poolKey
     * @param phoneNoB
     * @param outId
     * @return
     */
    public static JSONObject updateSubscription(String subsId,String phoneNoX,String poolKey,String phoneNoB,String outId) {
    	
        UpdateSubscriptionRequest request = new UpdateSubscriptionRequest();
        request.setSubsId(subsId);// 绑定关系的ID 来源于第一次绑定
        request.setOperateType("updateNoB");
        request.setPhoneNoX(phoneNoX);// 中间号
        request.setPoolKey(poolKey); // 号池KEY
        request.setPhoneNoB(phoneNoB);   //准备更新绑定的B号码  
//        request.setOutId(outId); //外部标识id customer 客户  owner
//        request.setCallDisplayType(1);
        try {
            UpdateSubscriptionResponse response = getIAcsClient().getAcsResponse(request);
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(response));
	        System.out.println(jsonObject);
	        return jsonObject;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
		return null;

    }
    
    /**
     * {"requestId":"C7060FDB-D652-4DE8-B610-3276DA22A17C","chargeId":"true","code":"OK","message":"OK"}
     * {"code":"isv.ILLEGAL_ARGUMENT","requestId":"0215546E-2FB2-45E4-B9EC-E5BD3667FCF3","message":"subs not exist"}
     * @param subsId
     * @param phoneNoX
     * @param poolKey
     * @return
     */
    public static JSONObject unbindSubscription(String subsId,String phoneNoX,String poolKey) {
    	
        UnbindSubscriptionRequest request = new UnbindSubscriptionRequest();
        request.setSubsId(subsId);
        request.setSecretNo(phoneNoX);
        request.setPoolKey(poolKey);
        try {
            UnbindSubscriptionResponse response = getIAcsClient().getAcsResponse(request);
            JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(response));
	        System.out.println(jsonObject);
	        return jsonObject;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
		return null;
    }

	public static QueryRecordFileDownloadUrlResponse queryRecordFileDownloadUrl(String callId,String poolKey,String callTime) {
		// TODO Auto-generated method stub
			QueryRecordFileDownloadUrlRequest request = new QueryRecordFileDownloadUrlRequest();
	        request.setCallId(callId);
	        request.setPoolKey(poolKey);
	        request.setCallTime(callTime);

	        try {
	            QueryRecordFileDownloadUrlResponse response = getIAcsClient().getAcsResponse(request);
	            System.out.println(JSONObject.toJSON(response));
	            return response;
	        } catch (ServerException e) {
	            e.printStackTrace();
	        } catch (ClientException e) {
	            System.out.println("ErrCode:" + e.getErrCode());
	            System.out.println("ErrMsg:" + e.getErrMsg());
	            System.out.println("RequestId:" + e.getRequestId());
	        }
			return null;
	}

	public static ReleaseSecretNoResponse releaseSecretNo(String secretNo,String poolKey) {
		// TODO Auto-generated method stub
        ReleaseSecretNoRequest request = new ReleaseSecretNoRequest();
        request.setPoolKey(poolKey);
        request.setSecretNo(secretNo);
        try {
            ReleaseSecretNoResponse response = getIAcsClient().getAcsResponse(request);
            return response;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return null;
	}
        
    public static void main(String[] args) {
//    	bindAxn("13408505238", "17137611962", "FC100000080284310", null);
//    	updateSubscription("1000010209778510", "17137611962", "FC100000080284310", "18108264227", "");
    	unbindSubscription("1000010210420107", "17137611962", "FC100000080284310");
//    	queryRecordFileDownloadUrl("67713256699911712741576572114521", "FC100000080284310", "2019-12-17 16:41:53");

	}
	
}
