package com.myfun.utils.rijindael;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密
 * 采用CFB模式
 * @author 陈文超 2015-01-18
 *
 */
public class AESHelperFaFa {

	public static String CHARSET = "utf-8";
	private final static String AES_KEY = "=ff_crypt_param";
	private final static String AES_VI = "0123456789abcdef";
	private final static String AES_MODEL = "AES/CFB/NOPADDING";

	/**
	 * 将16进制的byte数组转换成字符串
	 * @param b
	 * @return
	 */
	private static  String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}

	/**
	 * 将16进制的字符串转换成byte数组
	 * @param text
	 * @return
	 */
	private static  byte[] fromHexString(String text) {
		byte[] digest = new byte[text.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = text.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		return digest;
	}

	/**
	 * AES加密   CFB模式
	 * @param content
	 * @param password
	 * @return
	 */
	public static String encrypt(String content) {
		try {
			byte[] tmp = new byte[16];
			byte[] tmp2 = AES_KEY.getBytes();
			for (int i = 0; i < tmp2.length; i++) {
				tmp[i] = tmp2[i];
			}
			SecretKeySpec key = new SecretKeySpec(tmp, "AES");
			IvParameterSpec paramSpec = new IvParameterSpec(AES_VI.getBytes());
			Cipher cipher = Cipher.getInstance(AES_MODEL);
			byte[] byteContent = content.getBytes(CHARSET);
			cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return toHexString(result); // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * AES解密  CFB模式
	 * @param content
	 * @param password
	 * @return
	 */
	public static  String decrypt(String content) {
		try {
			byte[] tmp = new byte[16];
			byte[] tmp2 = AES_KEY.getBytes();
			for (int i = 0; i < tmp2.length; i++) {
				tmp[i] = tmp2[i];
			}
			SecretKeySpec key = new SecretKeySpec(tmp, "AES");
			IvParameterSpec paramSpec = new IvParameterSpec(AES_VI.getBytes());
			Cipher cipher = Cipher.getInstance(AES_MODEL);
			byte[] byteContent = fromHexString(content);
			cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);// 初始化
			byte[] result = cipher.doFinal(byteContent);
			return new String(result, CHARSET); // 加密
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}