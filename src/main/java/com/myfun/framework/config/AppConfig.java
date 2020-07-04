package com.myfun.framework.config;

import com.myfun.framework.util.SpringContextUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.XMLDOMHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.ConfigurableEnvironment;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

/**
 * 获取配置文件
 *
 * @author jiangsonggui
 * @ClassName: AppConfig
 * @Description: TODO
 * @date 2015年11月30日 下午8:20:46
 */
public class AppConfig {
	private static ConfigurableEnvironment CONFIGURABLE_ENVIRONMENT;
	private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

	public static final Properties APP_CONFIG_PROPERTIS = new Properties();
	/** 测试环境地址 **/
	private static String[] DEBUG_CONFIG_PATH = new String[] { "application", "bootstrap" };

	static {
		// 加载默认配置文件获取默认属性
		Properties properties = new Properties();
		try {
			properties.load(AppConfig.class.getClassLoader().getResourceAsStream("bootstrap.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String active = properties.getProperty("spring.profiles.active");
		String isOnline = "online".equals(properties.getProperty("spring.profiles.active")) ? "true" : "false";
		APP_CONFIG_PROPERTIS.put("isOnline", isOnline);

		// 初始化APP_CONFIG_PROPERTIS 加载配置文件路径 获取图片路径 初始化图片属性
		String suffix = "";
		if (StringUtil.isNotEmpty(active) && !"default".equals(active)) {
			suffix = "-" + active;
		}

		for (String path : DEBUG_CONFIG_PATH) {
			loadPropertiesConfig(path + suffix + ".properties");
		}

		// 加载全局配置文件
		String picConfigPath = APP_CONFIG_PROPERTIS.getProperty("globalConfigPath");
		if (StringUtil.isNotEmpty(picConfigPath)) {
			loadConfigToProperties(picConfigPath);
		} else {
			LOGGER.error("RuntimeConfig#获取图片路径(picConfigPath)失败");
		}
	}

	public static void loadPropertiesConfig(String path) {
		try {
			URL url = AppConfig.class.getClassLoader().getResource(path);
			if (url != null) {
				Properties properties = new Properties();
				properties.load(AppConfig.class.getClassLoader().getResourceAsStream(path));
				Iterator<Object> iterator = properties.keySet().iterator();
				while (iterator.hasNext()) {
					Object key = iterator.next();
					Object value = properties.get(key);
					APP_CONFIG_PROPERTIS.put(key, value);
				}
			} else {
				LOGGER.error("RuntimeConfig#加载配置文件(" + path + ")失败");
			}
		} catch (Exception e) {
			LOGGER.error("RuntimeConfig#加载配置文件(" + path + ")失败", e);
		}
	}

	/**
	 * 加载全局配置文件
	 *
	 * @param picConfigPath
	 */
	public static void loadConfigToProperties(String picConfigPath) {
		LOGGER.error("RuntimeConfig#加载配置文件(图片配置文件)" + picConfigPath);
		try {
			XMLDOMHelper xmldomHelper = new XMLDOMHelper(picConfigPath);
			// 短信配置
			String sendMsgPath = xmldomHelper.getNodeStringValue("/MyfunConfig/system-sms/host-local");
			APP_CONFIG_PROPERTIS.setProperty("SEND_MSG_PATH", sendMsgPath);
		} catch (Exception e) {
			LOGGER.error("RuntimeConfig#加载配置文件(图片配置文件)失败" + picConfigPath, e);
		}
	}

	/**
	 * 短信配置
	 */
	public static String getSendMsgPath() {
		return String.valueOf(getProperty("SEND_MSG_PATH"));
	}

	public static String getProperty(String key) {
		if (CONFIGURABLE_ENVIRONMENT == null) {
			CONFIGURABLE_ENVIRONMENT = SpringContextUtil.getBean(ConfigurableEnvironment.class);
		}
		String value = CONFIGURABLE_ENVIRONMENT.getProperty(key);
		if (StringUtil.isNotEmpty(value)) {
			return value;
		}
		return APP_CONFIG_PROPERTIS.getProperty(key);
	}

	public static int getIntProperty(String key) {
		return StringUtil.parseInteger(getProperty(key), 0);
	}

	public static boolean getBooleanProperty(String key) {
		return Boolean.parseBoolean(getProperty(key));
	}

	public static boolean isOnline() {
		return getBooleanProperty("isOnline");
	}

	/**
	 * 语音地址
	 * 
	 * @author 陈文超
	 * @date 2016年6月3日 下午5:25:06
	 */
	public static String getVideoDomainUrl() {
		return getProperty("common.picDomain.url");
	}

	/**
	 * 图片根域名
	 */
	public static String getPicDomainUrl() {
		return getProperty("common.picDomain.url");
	}

	/**
	 * 房源图片根域名，不是oss开头的就用这个
	 */
	public static String getHousePicDomainUrl() {
		return getProperty("common.picBjDomain.url");
	}

	/**
	 * 获取SOSO图片根目录地址，http://pic.myfun7.com/pic/hftpic/net/ 兼容以前的代码，只有几个地方在用
	 */
	public static String getSoSoPicUrl() {
		return AppConfig.getHousePicDomainUrl() + "pic/hftpic/net/";
	}

	/**
	 * 获取房源图片根目录地址，http://pic.myfun7.com/pic/hftpic/house/ 兼容以前的代码，只有几个地方在用
	 */
	public static String getHousePicUrl() {
		return AppConfig.getHousePicDomainUrl() + "pic/hftpic/house/";
	}

	/**
	 * crm项目地址
	 * 
	 * @return
	 */
	public static String getCrmWebUrl() {
		return getProperty("common.crmWeb.path");
	}

	/**
	 * erpWeb项目外网地址
	 * 
	 * @author 张宏利
	 * @since 2017年5月19日
	 */
	public static String getErpWebUrl() {
		return getProperty("common.erpWeb.path");
	}

	/**
	 * adminWeb项目外网地址
	 * 
	 * @author 张宏利
	 * @since 2017年5月19日
	 */
	public static String getAdminWebUrl() {
		return getProperty("common.adminWeb.path");
	}

	/**
	 * @tag houseWeb项目地址
	 * @author 邓永洪
	 * @since 2018/7/19
	 */
	public static String getHouseWebUrl() {
		return getProperty("common.houseWeb.path");
	}

	public static String getHouseCustWeb() {
		Object pushWebPath = getProperty("common.houseCustWeb.path");
		if (pushWebPath != null) {
			return pushWebPath.toString();
		} else {
			return "http://hft.myfun7.com/houseCustWeb/";
		}
	}

	/**
	 * socket服务器地址
	 * 
	 * @author 张宏利
	 * @since 2017年11月14日
	 */
	public static String getSocketWebUrl() {
		return getProperty("common.socketWeb.path");
	}

	/**
	 * 文件服务器根域名
	 */
	public static String getFileWebUrl() {
		return getProperty("common.fileWeb.path");
	}

	/**
	 * 掌上好房通项目地址
	 * 
	 * @author 方李骥
	 * @since 2017年5月19日
	 */
	public static String getHftMoblieUrl() {
		return getProperty("common.mobileWeb.path");
	}

	/**
	 * @tag 获取taskWeb地址
	 * @author 邓永洪
	 * @since 2019/1/8
	 */
	public static String getTaskWebUrl() {
		return getProperty("common.taskWeb.path");
	}


	/**
	 * 获取uu好房的域名 如：http://uuhf.vfanghui.com/uuhfWeb/
	 *
	 * @return
	 */
	public static String getRootUuhfWebDomainPath() {
		Object uuhfWebUrlPath = getProperty("common.uuhfWeb.path");
		if (uuhfWebUrlPath != null) {
			return uuhfWebUrlPath.toString();
		} else {
			return null;
		}
	}

	/**
	 * 调houseWeb请求新盘顾问
	 * 
	 * @author 朱科
	 * @since 2018年4月11日
	 */
	public static String getHftHouseUrl() {
		return getProperty("common.houseWeb.path");
	}
	/**
	 * 获得app外网域名
	 * @return
	 */
	public static String getNewAppNetDomain() {
		Object newErpAppDomain = getProperty("common.mobileWeb.net.path");
		if (newErpAppDomain != null) {
			return newErpAppDomain.toString();
		} else {
			return null;
		}
	}

	/**
	 * 强制升级相关，需要拦截的url，多个逗号分隔
	 * 
	 * @author 张宏利
	 * @since 2017年9月7日
	 */
	public static String getForcedEscalationUrls() {
		return getProperty("forced.escalation.urls");
	}

	/**
	 * hftWebService项目地址
	 * @author 朱科
	 * @since 2018年11月19日
	 * @return
	 */
	public static String getErpDomainRoot() {
		return String.valueOf(getProperty("common.houseWeb.erpRootPath"));
	}
	/**
	 * hftWebService项目地址
	 * @author 朱科
	 * @since 2018年11月19日
	 * @return
	 */
	public static String gethftWebServiceDomainRoot() {
		return String.valueOf(getProperty("common.hftWebService.path"));
	}

	/**
	 * 前端最新版本，此版本及以上的才能使用
	 * 
	 * @author 张宏利
	 * @since 2017年9月7日
	 */
	public static Integer getForcedEscalationVersion() {
		return StringUtil.parseInteger(getProperty("forced.escalation.version"));
	}

	/**酷家乐相关 */
	public static String getKjlAppKey() {
		return getProperty("common.houseWeb.kujiale.appKey");
	}
	public static String getKjlAppSecret() {
		return getProperty("common.houseWeb.kujiale.appSecret");
	}

	/**
	 * 日志文件硬盘地址
	 * 
	 * @author 张宏利
	 * @since 2017年5月19日
	 */
	public static String getLogFileDiskPath(int index) {
		String[] split = getProperty("logFileDiskPath").split(";");
		if (split != null && split.length > index) {
			return split[index];
		}
		return null;
	}
	
	public static String treasureCoinIsOpen() {
		return getProperty("treasure.coin.isOpen");
	}

	public static String getUuHaofang() {
		return getProperty("common.uuweb.haofang.net.path");
	}

	/***
	 * 查询admin项目
	 * @author 尹振兴
	 * @since 2018年2月3日
	 * @return
	 */
	public static String getAdminProjectDomain(){
		Object adminWebDomai = getProperty("common.adminWeb.path");
		if(adminWebDomai != null){
			return adminWebDomai.toString();
		}else{
			return null;
		}
	}
	/***
	 * 用于用户头像图片的URL
	 * @author 尹振兴
	 * 2017年7月19日 上午10:28:03
	 * @param photoUrl
	 * @return
	 */
	public static String getUserPhotoPicDomainPath(String photoUrl){
		if(StringUtil.isEmpty(photoUrl)){
			return photoUrl;
		}
		return String.valueOf(getProperty("common.picDomain.url")) + photoUrl.replaceAll("\\\\", "/");
	}

	/**
	 * pushWeb
	 *
	 * @author 张宏利
	 * @since 2017年5月19日
	 */
	public static String getPushWebDomain() {
		String url = getProperty("common.pushWeb.path");
		return url;
	}

	public static String getFaFaTaskServiceRoot() {
		return getProperty("common.hftFaFaWebTask.path");
	}
	public static String getFaFaWebServiceRoot() {
		return getProperty("common.hftFaFaWebServiceRoot.path");
	}
	public static String getFaFaWebUrl() {
		return getProperty("common.fafaWeb.path");
	}
	
	/**
     * 用于拼接房源图片的URL
     * 
     * @author 尹振兴 2017年7月19日 上午10:26:30
     * @param photoUrl
     * @return
     */
    public static String getHousePicDomainPath(String photoUrl) {
    	
        if (StringUtil.isEmpty(photoUrl)) {
            return "";
        }
	    try {
			if (photoUrl.substring(0, 7).equals("http://")) {
				return photoUrl;
			}
			return getPicDomainUrl() + photoUrl.replaceAll("\\\\", "/");

    	} catch (Exception e) {
    		 LOGGER.error("图片地址解析异常" +e.getMessage());
		}
	    return "";
    }
    
    /***
     * 优优加盟优优好房分享appId
     * @author 尹振兴
     * @since Oct 8, 2018
     * @return
     */
    public static final String getShareAppId() {
        String shareAppId = getProperty("common.smallProgram.ShareAppId").toString();
        if(StringUtil.isNotEmpty(shareAppId)){
            return shareAppId;
        }else{
            return "gh_70add125ef99";
        }
    }
    
    /***
     * 普通门店最新优选好房分享appId
     * @author chenfeng
     * @since nov 29, 2018
     * @return
     */
    public static final String getFlagShipShareAppId() {
        String flagShipShareAppId = getProperty("common.smallProgram.flagShipShareAppId").toString();
        if(StringUtil.isNotEmpty(flagShipShareAppId)){
            return flagShipShareAppId;
        }else{
            return "gh_6d93bbb3fade";
        }
    }
    
    /**
     * 物业版的子弹找房分享appId
     * @author chenfeng
     * @since 2019/08/21
     * @return
     */
    public static final String getPropertyZdzfShareAppId() {
        String shareAppId = getProperty("common.smallProgram.KdbShareAppId").toString();
        if(StringUtil.isNotEmpty(shareAppId)){
            return shareAppId;
        }else{
            return "gh_95ddcbb8e622";
        }
    }
    
    /**
     * 获取玛雅好房appId
     * @return
     */
    public static final String getMyhfShareAppId() {
        String myhfShareAppId = getProperty("common.smallProgram.myhfShareAppId");
        if(StringUtil.isNotEmpty(myhfShareAppId)){
            return myhfShareAppId;
        }else{
            return "gh_d65c2592a72d";
        }
    }
    
    /**
     * 获取房基地appId
     * @return
     */
    public static final String getFjdShareAppId() {
        String myhfShareAppId = getProperty("common.smallProgram.fjdShareAppId");
        if(StringUtil.isNotEmpty(myhfShareAppId)){
            return myhfShareAppId;
        }else{
            return "gh_d65c2592a72d";// 小程序线上还未通过，所以线上的id还是用玛雅好房的，等房基地的小程序审核通过就可以改成gh_90f8502cf4c1，并且刷新配置
        }
    }
    
    public static String getUploadFileServerUrl() {
        Object serverUrl = getProperty("common.houseWeb.fastDfsServer");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return null;
        }
    }

	public static String getZxWeb() {
	//	return "http://192.168.200.159:9010/zxWeb/";
		Object serverUrl = getProperty("common.zxWeb.path");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return "http://hft.myfun7.com/zxWeb/";
        }
	}
	public static String getHftBuildBiddingUrl() {
		Object serverUrl = getProperty("commin.hftBuildBiddingUrl");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return "http://uuweb.haofang.net/B/Erp/Index/index/";
        }
	}

	public static String getMoveApiBanRightUrlLong() {
		Object serverUrl = getProperty("commin.moveApiBanRightUrlLong");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return "http://hftmobile.haofang.net/download.jsp?";
        }
	}

	public static String getMoveApiBanRightUrlWyj() {
		Object serverUrl = getProperty("commin.moveApiBanRightUrlWyj");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return "http://www.hftsoft.com/customDownload/wyj";
        }
	}

	public static String getMoveApiBanRightUrlJgzx() {
		Object serverUrl = getProperty("commin.moveApiBanRightUrlJgzx");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return "http://www.hftsoft.com/customDownload/jgzx";
        }
	}

	public static String getZyloginPage() {
		Object serverUrl = getProperty("zhiye.loginPage");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return "http://hft.zhiyecn.com/login.html?sign=";
        }
	}

	public static String getMoveApiBanRightUrlFdd() {
		Object serverUrl = getProperty("common.moveApiBanRightUrlFdd");
        if (serverUrl != null) {
            return serverUrl.toString();
        } else {
            return "http://e.fangdd.com/";
        }
	}

	public static String getSosoWebPathHft() {
		return getProperty("common.hftgateway.domain")+"sosoWeb/";
	}
	
	/**
     * 获取美联全景展示php域名
     * @detail [2020-03-11]	陈峰	全景展示域名的获取  需求id#0
     * @return
     */
    public static String getVrShowPhpDomainUrlMl() {
    	Object vrShowPhpDomain = getProperty("common.vrShow.phpDomainUrl");
        if (vrShowPhpDomain != null) {
            return String.valueOf(vrShowPhpDomain);
        } else {
            return null;
        }
    }
}
