package com.myfun.utils;

import java.math.BigDecimal;

/**
 * 算法帮助类
 * 
 * @ClassName: MathHelper
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月23日 上午11:07:46
 *
 */
public class MathUtil {
	/** 默认除法运算精度 **/
	private static final int DEF_DIV_SCALE = 4;

	/** 地球半径 **/
	public static final double EARTH_RADIUS = 6378.137;
	public static double DEF_PI = 3.14159265359; // PI
	public static double DEF_2PI = 6.28318530712; // 2*PI
	public static double DEF_PI180 = 0.01745329252; // PI/180.0
	public static double DEF_R = 6370693.5; // radius of earth
	public static double X_PI = 6378.137 * 3000.0 / 180.0;

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */

	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */

	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后4位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */

	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 将科学计数法转换为double类型
	 * 
	 * @param num
	 * @return
	 */
	public static BigDecimal convertDouble(double num) {
		BigDecimal big = new BigDecimal(num);
		return big.setScale(10, 2);
	}

	/**
	 * 获得地球上任意两点之间的距离 单位(千米)
	 * 
	 * @param startLon
	 * @param startLat
	 * @param endLon
	 * @param endLat
	 * @return
	 */
	public static long getDistance1(double startLon, double startLat, double endLon, double endLat) {
		double x, y, distance;
		x = (endLon - startLon) * Math.PI * EARTH_RADIUS * Math.cos(((startLat + endLat) / 2) * Math.PI / 180) / 180;
		y = (endLat - startLat) * Math.PI * EARTH_RADIUS / 180;
		distance = Math.hypot(x, y);
		return Math.round(distance);
	}

	/**
	 * 获得地球上任意两点之间的距离 单位(米)
	 * 
	 * @param startLon
	 * @param startLat
	 * @param endLon
	 * @param endLat
	 * @return
	 */
	public static long getDistance(double startLat, double startLon, double endLat, double endLon) {
		return Math
				.round(EARTH_RADIUS * 2
						* Math.asin(
								Math.sqrt(Math.pow(Math.sin((startLat * Math.PI / 180 - endLat * Math.PI / 180) / 2), 2)
										+ Math.cos(startLat * Math.PI / 180) * Math.cos(endLat * Math.PI / 180)
												* Math.pow(Math.sin(
														(startLon * Math.PI / 180 - endLon * Math.PI / 180) / 2), 2)))
				* 1000);
	}

	/**
	 * 格式化距离
	 * 
	 * @param startLon
	 * @param startLat
	 * @param endLon
	 * @param endLat
	 * @return
	 */
	public static String formatDistance(double startLon, double startLat, double endLon, double endLat) {
		long distance = getDistance(startLon, startLat, endLon, endLat);
		if (distance < 1000) {
			return "距你" + distance + "米";
		}
		double km = div(distance, 1000, 2);
		return "距你" + km + "公里";
	}

	public static double GetShortDistance(double lat1, double lon1, double lat2, double lon2) {
		double ew1, ns1, ew2, ns2;
		double dx, dy, dew;
		double distance;
		// 角度转换为弧度
		ew1 = lon1 * DEF_PI180;
		ns1 = lat1 * DEF_PI180;
		ew2 = lon2 * DEF_PI180;
		ns2 = lat2 * DEF_PI180;
		// 经度差
		dew = ew1 - ew2;
		// 若跨东经和西经180 度，进行调整
		if (dew > DEF_PI)
			dew = DEF_2PI - dew;
		else if (dew < -DEF_PI)
			dew = DEF_2PI + dew;
		dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
		dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
		// 勾股定理求斜边长
		distance = Math.sqrt(dx * dx + dy * dy);
		return distance;
	}

	public static double GetLongDistance(double lat1, double lon1, double lat2, double lon2) {
		double ew1, ns1, ew2, ns2;
		double distance;
		// 角度转换为弧度
		ew1 = lon1 * DEF_PI180;
		ns1 = lat1 * DEF_PI180;
		ew2 = lon2 * DEF_PI180;
		ns2 = lat2 * DEF_PI180;
		// 求大圆劣弧与球心所夹的角(弧度)
		distance = Math.sin(ns1) * Math.sin(ns2) + Math.cos(ns1) * Math.cos(ns2) * Math.cos(ew1 - ew2);
		// 调整到[-1..1]范围内，避免溢出
		if (distance > 1.0)
			distance = 1.0;
		else if (distance < -1.0)
			distance = -1.0;
		// 求大圆劣弧长度
		distance = DEF_R * Math.acos(distance);
		return distance;
	}

	/**
	 * 百度坐标转火星坐标
	 * 
	 * @param bdLat
	 * @param bdLng
	 * @return [lat,lng]
	 */
	public static Double[] bdToGcj(Double bdLat, Double bdLng) {
		Double x = bdLng - 0.0065;
		Double y = bdLat - 0.006;
		Double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * X_PI);
		Double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * X_PI);
		Double gcjLon = z * Math.cos(theta);
		Double gcjLat = z * Math.sin(theta);
		return new Double[] { gcjLat, gcjLon };
	}

	/**
	 * gcj转化为bd坐标
	 * 
	 * @param bdLat
	 * @param bdLng
	 * @return
	 */
	public static Double[] gcjToBd(Double gcjLat, Double gcjLng) {
		Double x = gcjLng;
		Double y = gcjLat;
		Double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * X_PI);
		Double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * X_PI);
		gcjLng = z * Math.cos(theta) + 0.0065;
		gcjLat = z * Math.sin(theta) + 0.006;
		return new Double[] { gcjLat, gcjLng };
	}
}
