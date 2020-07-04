package com.myfun.framework.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Message;
import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.session.ActionUrl;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.ThreadLocalHelper;
import com.myfun.framework.util.SpringContextUtil;
import com.myfun.repository.mongodb.po.MongoAccessLogBean;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.utils.KafkaBizUtils;
import com.myfun.utils.StringUtil;
import com.myfun.utils.log.MybatisLogThreadLocal;


/**
 * 捕获请求和返回值过滤器
 * 
 * @ClassName: CaptureFilter
 * @author jiangsonggui
 * @date 2016年8月23日 下午5:28:49
 *
 */
@Component
@WebFilter(urlPatterns = { "/*", }, filterName = "captureFilter")
public class CaptureFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(CaptureFilter.class);
	private static final Set<String> SAVE_ACCESS_CONTENT_TYPE = new HashSet<String>();
	private static final Set<String> NOT_SAVE_URL_SET = new HashSet<String>();
	private static final LinkedBlockingQueue<MongoAccessLogBean> ACCESS_LOG_BLOCKING_QUERY = new LinkedBlockingQueue<MongoAccessLogBean>();
	private static final LinkedBlockingQueue<Map<String,String>> ATTENCE_RECORD_DETAIL_SYNC = new LinkedBlockingQueue<>();
	private static final ConcurrentHashMap<String, AtomicInteger> INTERFACE_ACCECC_NUM = new ConcurrentHashMap<String, AtomicInteger>();
	private static final ConcurrentHashMap<String, AtomicInteger> TOTAL_ACCECC_NUM = new ConcurrentHashMap<String, AtomicInteger>();
	@Value("${spring.profiles.active}")
	private String springProfilesActive;
	@Autowired
	private CacheUtil cacheUtil;
	static {
		SAVE_ACCESS_CONTENT_TYPE.add(".*APPLICATION/JSON.*");

		NOT_SAVE_URL_SET.add("js");
		NOT_SAVE_URL_SET.add("css");
		NOT_SAVE_URL_SET.add("html");
		NOT_SAVE_URL_SET.add("gif");
		NOT_SAVE_URL_SET.add("png");
		NOT_SAVE_URL_SET.add("ttf");
		NOT_SAVE_URL_SET.add("woff");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
//		new Timer(true).schedule(new TimerTask() {
//			@Override
//			public void run() {
//				new KafkaWriteAccessLogThread().start();
//			}
//		}, 30 * 1000);
	}

	public static LinkedBlockingQueue<MongoAccessLogBean> getAccessLogBlockingQuery() {
		return ACCESS_LOG_BLOCKING_QUERY;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    ThreadLocalHelper.clear();
	    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,clientKey,Content-Type");
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
		Long startTime = System.currentTimeMillis();
		Exception exception = null;

		String requestUri = httpServletRequest.getRequestURI();
		String requestQueryStr = getRequestQueryStr(httpServletRequest);
		// 请求次数监控
		try{
			totalAcceccNum("PROJECT_ACCESS", true);
			if(!addInterfaceAcceccNum(requestUri, true, requestQueryStr)){
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("", 0);
				jsonObject.put("errCode", 1);
				jsonObject.put("errMsg", "system error");
				jsonObject.put("data", null);
				response.setCharacterEncoding("UTF-8");
				response.getOutputStream().write(jsonObject.toJSONString().getBytes("UTF-8"));
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}
			chain.doFilter(httpServletRequest, httpServletResponse);
		}catch (Exception ignored) {
		    exception = ignored;
		    ignored.printStackTrace();
		} finally {
			totalAcceccNum("PROJECT_ACCESS", false);
			addInterfaceAcceccNum(requestUri, false, requestQueryStr);
		}

		Long endTime = System.currentTimeMillis();
		try {
			if (StringUtil.isNotEmpty(requestUri)
					&& !NOT_SAVE_URL_SET.contains(StringUtil.getFileSub(requestUri))) {
				MongoAccessLogBean accessLogMongoBean = new MongoAccessLogBean();
				accessLogMongoBean.setIfaceName(requestUri);
				String encrypParam = ThreadLocalHelper.getACTION_URL_LOCAL().getParams();
                if(StringUtil.isNotEmpty(encrypParam)){
                    requestQueryStr += encrypParam;
                }
				accessLogMongoBean.setUrlParam(requestQueryStr);
				accessLogMongoBean.setExecuteLength(endTime - startTime);
				accessLogMongoBean.setCreateTime(new Date());
				accessLogMongoBean.setProject(Const.AccessLogProject.ACCESS_LOG_1);
				accessLogMongoBean.setSqlInfos(MybatisLogThreadLocal.getLogRecord());
				accessLogMongoBean.setAccessDataBaseCount(MybatisLogThreadLocal.getLogRecord()!=null?MybatisLogThreadLocal.getLogRecord().size():0);
				accessLogMongoBean.setBussnessLogRecord(MybatisLogThreadLocal.getBusinessLogRecord());
				accessLogMongoBean.setExceptionStr(ThreadLocalHelper.getErrorInfoLocal().toString());
				
				//记录会话信息 方便根据会话信息查询日志记录
                Object sessionId = httpServletRequest.getAttribute("sessionIdForLog");
                if (null != sessionId && StringUtil.isNotEmpty(sessionId.toString())) {
                    accessLogMongoBean.setSessionId(sessionId.toString());
                } else {
                    String userMobile = httpServletRequest.getHeader("userMobile");
                    userMobile = StringUtils.isBlank(userMobile) ? "-1" : userMobile;
                    accessLogMongoBean.setSessionId(userMobile);
                }
                
                //记录返回值 用于客服拍错
                Operator operator = ThreadLocalHelper.getOperator();
                if (operator != null && cacheUtil != null) {
                    if(cacheUtil.exists(CacheStructure.DEBUG_LOCK_ARCHIVE_ID + operator.getArchiveId())){
                        accessLogMongoBean.setResult(ThreadLocalHelper.getACTION_URL_LOCAL().getReparams());
                    } else if(!"online".equals(springProfilesActive)){
                        accessLogMongoBean.setResult(ThreadLocalHelper.getACTION_URL_LOCAL().getReparams());
                    }
                } 
                
				ACCESS_LOG_BLOCKING_QUERY.offer(accessLogMongoBean);
				//recordRedisLogSql(httpServletRequest, accessLogMongoBean);
			}
		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			MybatisLogThreadLocal.clear();
		}

		if (exception != null) {
			throw new ServletException(exception);
		}
	}

	public static String getRequestQueryStr(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException {
		Enumeration<String> keys = httpServletRequest.getParameterNames();

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = httpServletRequest.getParameter(key);

			sb.append("\"").append(key).append("\":\"").append(value).append("\",");
		}
		if (sb.lastIndexOf(",") >= 0) {
			sb.delete(sb.length() - 1, sb.length());
		}
		sb.append("}");
		return sb.toString();
	}


	private void recordRedisLogSql(HttpServletRequest httpServletRequest, MongoAccessLogBean accessLogMongoBean) {
		Operator operator = ThreadLocalHelper.getOperator();
		if (operator == null) {
			return;
		}
		Object cacheObj = cacheUtil.get(CacheStructure.DEBUG_LOCK_ARCHIVE_ID + operator.getArchiveId());
		if (cacheObj == null) {
			return;
		}
		String sqlStr = MybatisLogThreadLocal.getLogRecordByStr().replaceAll("</br>", "</br></br>");
		String url = httpServletRequest.getRequestURI();
		String action = StringUtil.getBlankStr(httpServletRequest.getHeader("action"), "");
		String tempStr = null;
		if (StringUtils.isBlank(action)) {
			action = url;
			sqlStr = "访问总时长：" + accessLogMongoBean.getExecuteLength() + "ms<br/>" + sqlStr;
			ActionUrl actionUrl = ThreadLocalHelper.getACTION_URL_LOCAL();
			actionUrl.setActionName(action);
			actionUrl.setSqlString(sqlStr);
			actionUrl.setErrorInfo(ThreadLocalHelper.getErrorInfoLocal().toString());
			tempStr = JSON.toJSONString(actionUrl);
		} else {
			Map<String, Object> debugMap = new HashMap<>();
			debugMap.put("sqlString", "新版接口url：" + url + "<br/>" + sqlStr);
			debugMap.put("errorInfo", ThreadLocalHelper.getErrorInfoLocal());
			tempStr = JSON.toJSONString(debugMap);
		}
		cacheUtil.put(CacheStructure.debug_ActionPack_Cache_map_BY_archiveId + operator.getArchiveId() + action, tempStr, 15);
	}

	@Override
	public void destroy() {

	}

	/**
	 * 是否记录当前请求信息
	 * 
	 * @param contentType
	 * @return
	 */
	public static boolean isSaveAccess(String contentType) {
		if (contentType == null || contentType.length() == 0) {
			return true;
		}

		contentType = contentType.toUpperCase();

		Iterator<String> notAuthUrlIt = SAVE_ACCESS_CONTENT_TYPE.iterator();
		while (notAuthUrlIt.hasNext()) {
			Pattern pattern = Pattern.compile(notAuthUrlIt.next());
			Matcher matcher = pattern.matcher(contentType);
			if (matcher.matches()) {
				return false;
			}
		}
		return false;
	}

	public void initKafkaWriteAccessLogThread() {
		new KafkaWriteAccessLogThread().start();
		new KafkaFunAttenceRecordDetailThread().start();
	}

	/**
	 * 写入日志
	 *
	 * @author jsg
	 *
	 */
	public class KafkaWriteAccessLogThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;
		Logger logger = LoggerFactory.getLogger(KafkaWriteAccessLogThread.class);

		@SuppressWarnings("unchecked")
		public KafkaWriteAccessLogThread() {
			logger.error("启动kafka日志线程.........");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}

		@Override
		public void run() {
			while (true) {
				try {
					MongoAccessLogBean mongoAccessLogBean = ACCESS_LOG_BLOCKING_QUERY.take();
					if (mongoAccessLogBean != null) {
						kafkaTemplate.send("erpWebAccessLogTopic", JSON.toJSONString(mongoAccessLogBean));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 写入日志
	 *
	 * @author jsg
	 *
	 */
	public class KafkaFunAttenceRecordDetailThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;
		Logger logger = LoggerFactory.getLogger(KafkaWriteAccessLogThread.class);
		
		@SuppressWarnings("unchecked")
		public KafkaFunAttenceRecordDetailThread() {
			logger.error("启动kafka日志线程.........");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					Map<String,String> attInfoMap = ATTENCE_RECORD_DETAIL_SYNC.take();
					if (attInfoMap != null) {
						kafkaTemplate.send("funAttendanceRecordDetailSyncTopic", JSON.toJSONString(attInfoMap));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 同步考勤信息
	 * flj 2018-10-30
	 */
	public static void syncFunAttendanceRecordDetail (Map<String,String> attendanceInfoMap) {
		if (attendanceInfoMap== null) {
			return;
		}
		ATTENCE_RECORD_DETAIL_SYNC.offer(attendanceInfoMap);
	}

	/**
	 * 记录接口访问次数
	 * @param url
	 * @param isAdd
	 */
	public synchronized static boolean addInterfaceAcceccNum(String url, boolean isAdd, String requestQueryStr){
		AtomicInteger atomicInteger = INTERFACE_ACCECC_NUM.get(url);
		if(atomicInteger == null){
			atomicInteger = new AtomicInteger(0);
			INTERFACE_ACCECC_NUM.put(url, atomicInteger);
		}
		int num = 0;
		if(isAdd){
			num = atomicInteger.getAndIncrement();
		}else{
			num = atomicInteger.getAndDecrement();
		}
		if(num >= 15){
			KafkaBizUtils.projectWarmingMsg(AppConfig.getProperty("spring.application.name"),"接口断路", url);
			return false;
		}else{
			if(num >= 10) {
				Cat.logEvent("ACCESS.OVERFLOW", url, Message.SUCCESS, requestQueryStr);
				KafkaBizUtils.projectWarmingMsg(AppConfig.getProperty("spring.application.name"),"并发过高", url+",并发数"+num);
			}
			return true;
		}
	}

	/**
	 * 总并发
	 * @param isAdd
	 */
	public synchronized static void totalAcceccNum(String key, boolean isAdd){
		AtomicInteger atomicInteger = TOTAL_ACCECC_NUM.get(key);
		if(atomicInteger == null){
			atomicInteger = new AtomicInteger(0);
			TOTAL_ACCECC_NUM.put(key, atomicInteger);
		}
		int num = 0;
		if(isAdd){
			num = atomicInteger.getAndIncrement();
		}else{
			num = atomicInteger.getAndDecrement();
		}
		Cat.logEvent("ACCESS.OVERFLOW_TOTAL", num + "", Message.SUCCESS, "");
		if(num >= 100) {
			KafkaBizUtils.projectWarmingMsg(AppConfig.getProperty("spring.application.name"),"项目并发过高", "/并发数"+num);
		}
	}
}
