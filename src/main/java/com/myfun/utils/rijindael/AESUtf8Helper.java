package com.myfun.utils.rijindael;

import com.myfun.framework.config.AppConfig;

public class AESUtf8Helper {

	private static final int DEFAULT_BLOCK_SIZE = 16;
	public static String CHARSET = "UTF-8";
	private static String strDefaultKey = AppConfig.getProperty("common.aesgbkstrDefaultKey.path");

	public static String getStrDefaultKey() {
		return strDefaultKey;
	}

	public static byte[] getExcursionKey(String key) {
		byte[] keyByte = new byte[16];
		for (int i = 0; i < 16; i++) {
			int temp = key.charAt(i);
			temp = temp + temp % 5 - 16;
			keyByte[i] = (byte) temp;
		}
		return keyByte;
	}

	public static int getChipherLen(int srcLen) {
		int pad = srcLen % 16;
		if (pad == 0) {
			return srcLen + 16;
		}
		return srcLen + 16 - pad;
	}

	public static String encode(String src) throws Exception {
		byte[] encodeStr = encode(AESHelper.getExcursionKey(strDefaultKey),
				src.getBytes(CHARSET));
		return toHexString(encodeStr);
	}

	public static String encode(String key, String src) throws Exception {
		byte[] encodeStr = encode(AESHelper.getExcursionKey(key),
				src.getBytes(CHARSET));
		return toHexString(encodeStr);
	}

	public static byte[] encode(byte[] key, byte[] src) throws Exception {
		Object sKey = Rijndael_Algorithm.makeKey(key);

		int srcLen = src.length;
		int pad = srcLen % 16;
		int preix = srcLen - pad;

		int maxOutLen = getChipherLen(src.length);
		byte[] rst = new byte[maxOutLen];
		int offset = 0;

		if (preix > 0) {
			for (; offset < preix; offset += 16) {
				byte[] tmp = Rijndael_Algorithm.blockEncrypt(src, offset, sKey);
				rst = memcopy(rst, offset, tmp, tmp.length);
			}

		}

		byte[] padding = new byte[16];
		if (pad < 16) {
			padding = memcopy(padding, 0, src, offset, pad);
		}
		padding = memset(padding, pad, 16 - pad);
		byte[] tmp = Rijndael_Algorithm.blockEncrypt(padding, 0, sKey);

		rst = memcopy(rst, offset, tmp, tmp.length);

		return rst;
	}

	public static String decode(String sec) throws Exception {
		byte[] decodeStr = decode(AESHelper.getExcursionKey(strDefaultKey),
				convertHexString(sec));
		return new String(decodeStr, CHARSET);
	}

	public static String decode(String key, String sec) throws Exception {
		byte[] decodeStr = decode(AESHelper.getExcursionKey(key),
				convertHexString(sec));
		return toHexString(decodeStr);
	}

	public static byte[] decode(byte[] key, byte[] sec) throws Exception {
		Object sKey = Rijndael_Algorithm.makeKey(key);
		int len = sec.length;

		byte[] src = new byte[len];

		for (int offset = 0; offset < len; offset += 16) {
			byte[] tmp = Rijndael_Algorithm.blockDecrypt(sec, offset, sKey);
			src = memcopy(src, offset, tmp, 16);
		}

		int pad = src[(src.length - 1)];
		byte[] rst = new byte[len - pad];
		rst = memcopy(rst, 0, src, 0, rst.length);

		return rst;
	}

	public static byte[] memset(byte[] ctn, int offset, int val) {
		for (int i = 0; i < val; i++) {
			ctn[(i + offset)] = (byte) val;
		}
		return ctn;
	}

	public static byte[] memcopy(byte[] ctn, int offset, byte[] src, int len) {
		for (int i = 0; i < len; i++) {
			ctn[(offset + i)] = src[i];
		}
		return ctn;
	}

	public static byte[] memcopy(byte[] ctn, int offset, byte[] src,
			int srcOffset, int len) {
		for (int i = 0; i < len; i++) {
			ctn[(offset + i)] = src[(srcOffset + i)];
		}
		return ctn;
	}

	public static byte[] convertHexString(String text) {
		byte[] digest = new byte[text.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = text.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		return digest;
	}

	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}

	public static void main(String[] args) {
		try {
//			System.out.println(new String("大家好".getBytes(CHARSET)));
//			System.out.println(new String("大家好".getBytes()));
			String str = "f23f7cacbd9945f6bd4cb067989db8a9b181e94587e87c6109a4558a6c723bbff53a3e0976c7f84e5d2dd69b7765e3f5";
			System.out.println("加密后的字符：" + decode(str));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
