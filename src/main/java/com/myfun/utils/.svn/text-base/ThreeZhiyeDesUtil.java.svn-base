package com.myfun.utils;

import com.myfun.framework.config.AppConfig;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;


public class ThreeZhiyeDesUtil {
	public final static String priKey = AppConfig.getProperty("common.priKey.path");

	public static void main(String[] args) throws Exception {
		String json = "{\"uid\":\"123\",\"token\":\"eadss42352345678989744324%……￥#@4532214afsdfasdf23423\",\"pid\":\"288\"}";
		System.out.println("加密前：" + json.length() + ":" + json);

		System.out.println("加密密钥和解密密钥：" + priKey);

		String encrypt = aesEncrypt(json, priKey);
		System.out.println("加密后：" + encrypt);
		encrypt = bytesToHexString(StringUtil.getUtf8Byte(encrypt));
		System.out.println("签名要转成16进制  str2HexStr：长度" + encrypt.length() + "  sign=" + ":" + encrypt);
		encrypt = StringUtil.getUtf8String(hexStringToByte(encrypt));
		System.out.println("hexStr2Str：" + encrypt.length() + ":" + encrypt);

		String decrypt = aesDecrypt(encrypt, priKey);
		System.out.println("解密后：" + decrypt);
		

		String encrypt1 = "374475643262344C34766D4F4F6C666F6D38346C366C774A794C6C435034645A593836514532354F6B5A4B4571436F50647A6F744B6253535734382B562B4E554A7956567847564F5A6550416F724B4777375A48495455452F774555365A66764C69414E6D4579506E4D51734E52437136374638502F536641546A59644B436D";
		encrypt1 = StringUtil.getUtf8String(hexStringToByte(encrypt1));
		String decrypt1 = aesDecrypt(encrypt1, priKey);
		System.out.println("解密后：" + decrypt1);
		
		// String aa = null;
		// System.out.println(aa.toString());
	}

	/**
	 * 把字节数组转换成16进制字符串
	 * 
	 * @param bArray
	 * @return
	 */
	public static final String bytesToHexString(byte[] bArray) {
		StringBuffer sb = new StringBuffer(bArray.length);
		String sTemp;
		for (int i = 0; i < bArray.length; i++) {
			sTemp = Integer.toHexString(0xFF & bArray[i]);
			if (sTemp.length() < 2)
				sb.append(0);
			sb.append(sTemp.toUpperCase());
		}
		return sb.toString();
	}

	public static byte[] hexStringToByte(String hex) {
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++) {
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	private static byte toByte(char c) {
		byte b = (byte) "0123456789ABCDEF".indexOf(c);
		return b;
	}

	public static String aesEncrypt(String src, String key) throws Exception {
		DESedeKeySpec dks = new DESedeKeySpec(StringUtil.getUtf8Byte(key));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(dks);

		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, securekey);
		byte[] b = cipher.doFinal(StringUtil.getUtf8Byte(src));

		// BASE64Encoder encoder = new BASE64Encoder();
		// return encoder.encode(b);
		// Base64 en = new Base64();
		return Base64.getEncoder().encodeToString(b);

	}

	// 3DESECB解密,key必须是长度大于等于 3*8 = 24 位
	public static String aesDecrypt(String src, String key) throws Exception {
		// System.out.println(src);
		// --通过base64,将字符串转成byte数组
		// BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytesrc = Base64.getDecoder().decode(src);// .decodeBuffer(src);
		// --解密的key
		DESedeKeySpec dks = new DESedeKeySpec(StringUtil.getUtf8Byte(key));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(dks);

		// --Chipher对象解密
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		byte[] retByte = cipher.doFinal(bytesrc);

		return StringUtil.getUtf8String(retByte);
	}
}
