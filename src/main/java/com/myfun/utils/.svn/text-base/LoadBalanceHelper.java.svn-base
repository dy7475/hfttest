package com.myfun.utils;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 下载目录配置 简单负载均很器
 * 
 * @ClassName: LoadBalanceHelper
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年12月7日 上午11:22:16
 *
 */
public class LoadBalanceHelper {
	/** 企业版下载目录 **/
	private static final ConcurrentHashMap<String, Integer> ERP_DOMAIN_COUNT_MAP = new ConcurrentHashMap<String, Integer>();
	/** 精英版下载目录 **/
	private static final ConcurrentHashMap<String, Integer> PER_DOMAIN_COUNT_MAP = new ConcurrentHashMap<String, Integer>();
	/** 胡星僧用的下载地址不知道干嘛的 **/
	private static final ConcurrentHashMap<String, Integer> ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP = new ConcurrentHashMap<String, Integer>();
	/** 胡星僧用的下载地址不知道干嘛的 **/
	private static final ConcurrentHashMap<String, Integer> PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP = new ConcurrentHashMap<String, Integer>();
	/** 当前实例 **/
	private static LoadBalanceHelper instance = new LoadBalanceHelper();

	private LoadBalanceHelper() {
	}

	public static LoadBalanceHelper getInstance() {
		return instance;
	}

	public static synchronized boolean erpIsEmpty() {
		return ERP_DOMAIN_COUNT_MAP.isEmpty();
	}

	public static synchronized boolean perIsEmpty() {
		return PER_DOMAIN_COUNT_MAP.isEmpty();
	}

	public static synchronized boolean hxsErpIsEmpty() {
		return ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP.isEmpty();
	}

	public static synchronized boolean hxsPerIsEmpty() {
		return PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP.isEmpty();
	}

	public static synchronized void initErp(String domain) {
		if (!ERP_DOMAIN_COUNT_MAP.isEmpty()) {
			return;
		}
		if (domain == null || domain.length() == 0) {
			return;
		}
		String[] domains = domain.split(",");
		for (int i = 0; i < domains.length; i++) {
			ERP_DOMAIN_COUNT_MAP.put(domains[i], 0);
		}
	}

	public static synchronized void initPer(String domain) {
		if (!PER_DOMAIN_COUNT_MAP.isEmpty()) {
			return;
		}
		if (domain == null || domain.length() == 0) {
			return;
		}
		String[] domains = domain.split(",");
		for (int i = 0; i < domains.length; i++) {
			PER_DOMAIN_COUNT_MAP.put(domains[i], 0);
		}
	}

	public static synchronized void initHxsErp(String domain) {
		if (!ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP.isEmpty()) {
			return;
		}
		if (domain == null || domain.length() == 0) {
			return;
		}
		String[] domains = domain.split(",");
		for (int i = 0; i < domains.length; i++) {
			ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP.put(domains[i], 0);
		}
	}

	public static synchronized void initHxsPer(String domain) {
		if (!PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP.isEmpty()) {
			return;
		}
		if (domain == null || domain.length() == 0) {
			return;
		}
		String[] domains = domain.split(",");
		for (int i = 0; i < domains.length; i++) {
			PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP.put(domains[i], 0);
		}
	}

	public static String getErpOptimalDomain() {
		String minKey = "";
		int minCount = -1;
		Iterator<String> domainIt = ERP_DOMAIN_COUNT_MAP.keySet().iterator();
		while (domainIt.hasNext()) {
			String key = domainIt.next();
			int count = ERP_DOMAIN_COUNT_MAP.get(key);
			if (count < minCount || minCount == -1) {
				minCount = count;
				minKey = key;
			}
		}
		if (!"".equals(minKey)) {
			ERP_DOMAIN_COUNT_MAP.put(minKey, ++minCount);
		}
		return minKey;
	}

	public static String getPerOptimalDomain() {
		String minKey = "";
		int minCount = -1;
		Iterator<String> domainIt = PER_DOMAIN_COUNT_MAP.keySet().iterator();
		while (domainIt.hasNext()) {
			String key = domainIt.next();
			int count = PER_DOMAIN_COUNT_MAP.get(key);
			if (count < minCount || minCount == -1) {
				minCount = count;
				minKey = key;
			}
		}
		if (!"".equals(minKey)) {
			PER_DOMAIN_COUNT_MAP.put(minKey, ++minCount);
		}
		return minKey;
	}

	public static String getHxsErpDownloadDirectory() {
		String minKey = "";
		int minCount = -1;
		Iterator<String> domainIt = ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP.keySet().iterator();
		while (domainIt.hasNext()) {
			String key = domainIt.next();
			int count = ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP.get(key);
			if (count < minCount || minCount == -1) {
				minCount = count;
				minKey = key;
			}
		}
		if (!"".equals(minKey)) {
			ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP.put(minKey, ++minCount);
		}
		return minKey;
	}

	public static String getHxsPerDownloadDirectory() {
		String minKey = "";
		int minCount = -1;
		Iterator<String> domainIt = PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP.keySet().iterator();
		while (domainIt.hasNext()) {
			String key = domainIt.next();
			int count = PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP.get(key);
			if (count < minCount || minCount == -1) {
				minCount = count;
				minKey = key;
			}
		}
		if (!"".equals(minKey)) {
			PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP.put(minKey, ++minCount);
		}
		return minKey;
	}

	public static void clearErp() {
		ERP_DOMAIN_COUNT_MAP.clear();
	}

	public static void clearPer() {
		PER_DOMAIN_COUNT_MAP.clear();
	}

	public static void clearHxsErpDownload() {
		ERP_DOWNLOAD_DIRECTORY_BY_HXS_MAP.clear();
	}

	public static void clearHxsPerDownload() {
		PER_DOWNLOAD_DIRECTORY_BY_HXS_MAP.clear();
	}

	public static void clear() {
		clearErp();
		clearPer();
		clearHxsErpDownload();
		clearHxsPerDownload();
	}

	public static String getErpDownloadCount() {
		String countStr = ERP_DOMAIN_COUNT_MAP.toString();
		return countStr;
	}

	public static String getPerDownloadCount() {
		String countStr = PER_DOMAIN_COUNT_MAP.toString();
		return countStr;
	}
}
