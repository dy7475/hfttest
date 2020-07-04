package com.myfun.utils;

/**
 * 身份认证帮助类
 * 
 * @ClassName: AuthenticationHelper
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午10:43:38
 *
 */
@SuppressWarnings("all")
public class AuthenticationHelper {

	private static final String DEFAULT_ASE_KEY = "DEFAULT_KEY";

	/**
	 * 根据字符串生成token 生成规则 appId:secret:timeout:timestamp token里面包含用户信息和超时时间<br>
	 * 对加密信息在md5(验证加密数据是否被篡改) 返回md5+加密字符串
	 * 
	 * @param appId
	 * @param secret
	 * @param timestamp
	 * @param timeout
	 *            秒
	 * @return
	 */
	public static String generateToken(String appId, String secret, long timestamp, long timeout, String key) {
		if (StringUtil.isEmpty(appId) || StringUtil.isEmpty(secret)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(appId).append(":").append(secret).append(":").append(timeout).append(":").append(timestamp);
		String encodeStr = EncryptHelper.encryptAES(sb.toString(), key);
		String md5Str = EncryptHelper.encryptMD5(encodeStr);
		return md5Str + encodeStr;
	}

	/**
	 * 生成token 默认失效时间是2小时
	 * 
	 * @param appId
	 * @param secret
	 * @return
	 */
	public static String generateToken(String appId, String secret, String key) {
		return generateToken(appId, secret, System.currentTimeMillis() / 1000, 7200, key);
	}

	public static String generateToken(String appId, String secret) {
		return generateToken(appId, secret, System.currentTimeMillis() / 1000, 7200, DEFAULT_ASE_KEY);
	}

	/**
	 * 验证token是否是否有效 appId:secret:timeout（秒）:timestamp(是标准的时间戳 10（位）)
	 * 
	 * @param token
	 * @return
	 */
	public static boolean tokenIsValid(String token, String key) {
		try {
			if (StringUtil.isEmpty(token)) {
				return false;
			}
			String md5Str = token.substring(0, 32);
			String encodeStr = token.substring(32, token.length());
			// 判断签名是否被篡改
			if (!md5Str.equals(EncryptHelper.encryptMD5(encodeStr))) {
				return false;
			}
			String[] tokenGroup = new String(EncryptHelper.decryptAES(encodeStr, key)).split(":");
			if (tokenGroup == null || tokenGroup.length != 4) {
				return false;
			}
			long misTiming = System.currentTimeMillis() / 1000 - Long.parseLong(tokenGroup[3]);
			return misTiming >= 0 && misTiming < Integer.parseInt(tokenGroup[2]);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean tokenIsValid(String token) {
		return tokenIsValid(token, DEFAULT_ASE_KEY);
	}

	public static String getAppId(String token, String key) {
		if (tokenIsValid(token, key)) {
			String encodeStr = token.substring(32, token.length());
			String[] tokenGroup = new String(EncryptHelper.decryptAES(encodeStr, key)).split(":");
			return tokenGroup[0];
		} else {
			return null;
		}
	}
	
	public static String getAppId(String token) {
		if (tokenIsValid(token, DEFAULT_ASE_KEY)) {
			String encodeStr = token.substring(32, token.length());
			String[] tokenGroup = new String(EncryptHelper.decryptAES(encodeStr, DEFAULT_ASE_KEY)).split(":");
			return tokenGroup[0];
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		String appId = "jsg";
		String appSecret = "123456";
		System.out.println(generateToken(appId, appSecret));
		String accessToken = "59c5e2a2f9d08e174c6f8a34a03f1759811caa96e5e79902e8db44b5f841a7f76b76fd5575235c12d13a5b474e20d62e903f30cbf7de6b053778115a581df781";
		System.out.println(tokenIsValid(accessToken));
		
		System.out.println(getAppId("1e04501d2a39226b2c98d92a83339700ef42ee462d98ff29d6f3d75e9c04fbdec8958225ab37e2fb76001df2091a0b78"));
	}

}
