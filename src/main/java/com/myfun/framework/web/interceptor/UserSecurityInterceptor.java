package com.myfun.framework.web.interceptor;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.SessionTimeoutException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.ThreadLocalHelper;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 安全检查拦截器
 * 
 * @ClassName: UserSecurityInterceptor
 * @author jiangsonggui
 * @date 2015年11月25日 下午5:01:29
 *
 */
@Component
public class UserSecurityInterceptor implements HandlerInterceptor {
	private transient static final Logger logger = LoggerFactory.getLogger(UserSecurityInterceptor.class);
	private static final Set<String> NOT_AUTH_URL = new HashSet<String>();
	@Autowired
	private CacheUtil cacheUtil;
	static {
		NOT_AUTH_URL.add("getLoginInfo");
		NOT_AUTH_URL.add("userLogin");
		NOT_AUTH_URL.add("openLogin");
		NOT_AUTH_URL.add("per_updateUserLogin");
		NOT_AUTH_URL.add("getAppInitData");
		NOT_AUTH_URL.add("per_getAppInitData");
		NOT_AUTH_URL.add("getClientKeyByArchiveId");
		NOT_AUTH_URL.add("posAsynchronousNotify");
		NOT_AUTH_URL.add("houseCheckQrCode");
		NOT_AUTH_URL.add("houseCheckQrCodeData");
		NOT_AUTH_URL.add("swagger-resources");
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	/**
	 * 判断当前连接是否需要验证登录<br/>
	 * 如果需要验证 则判断用户是否登录<br/>
	 * 如果请求非法则返回抛出异常由异常拦截器处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String servletPath = request.getServletPath();
		if(servletPath.contains("openApi/")){
			return true;
		}
		String clientkey = request.getHeader("CLIENTKEY");
		if(clientkey == null) {// 网页访问的情况
			clientkey = request.getParameter("CLIENTKEY");
		}
		// 电脑端精英版登录
		String isPcPerApi = request.getHeader("isPcPerApi");
		String isMobileApi = request.getHeader("isMobileApi");
		String mobileUfs = request.getHeader("U-FS");
		if(StringUtils.isBlank(isMobileApi)) {// 网页访问的情况
			isMobileApi = request.getParameter("isMobileApi");
		}
		if ("erpappv1".equals(mobileUfs)) {
			isMobileApi = "1";
		}
		
//		Cookie[] cookies = request.getCookies();
//		for (Cookie cookie : cookies) {
//			if(cookie.getName().equals("CLIENTKEY")){
//				clientkey = cookie.getValue();
//			}
//		}
		ErpResponseJson responseJson = new ErpResponseJson();
		Operator operator = new Operator();
		servletPath = servletPath.substring(servletPath.lastIndexOf("/") + 1);
		logger.debug("地址：" + request.getRequestURI());
		// 验证会话是否有效
		if(!NOT_AUTH_URL.contains(servletPath)){
			if(!isValid(responseJson, operator, clientkey, servletPath, mobileUfs)){
				String serverIpAddr = BaseController.getServerIpAddr(request);
				// 线上很多无效请求，打印看下到底是什么鬼
				logger.error("invalid request:"
					+ "requestURI=" + request.getRequestURI()
					+ ",extra=" + responseJson.getExtra()
					+ ",clientkey=" + clientkey
					+ ",ip=" + serverIpAddr
					+ ",inputStream=" + IOUtils.toString(request.getInputStream(), Charset.forName("UTF-8"))
					+ ",requestParam=" + BaseController.getRequestParamToString(request)
					+ ",forward_uri=" + request.getAttribute("javax.servlet.forward.request_uri")
					+ ",error_uri=" + request.getAttribute("javax.servlet.error.request_uri")
				);
				// 返回body或是内网直接返回JSON
				if (isResponseBody(handler)) {
					response.setStatus(HttpStatus.OK.value());// 设置状态码
					response.setContentType(MediaType.APPLICATION_JSON_VALUE);// 设置ContentType
					response.setCharacterEncoding("UTF-8");// 避免乱码
					response.setHeader("Cache-Control", "no-cache, must-revalidate");
					response.getWriter().write(responseJson.toJson());
				} else {
					throw new SessionTimeoutException(responseJson.getErrMsg(), 0, responseJson.getErrMsg());
				}
				return false;
			}
		}
		operator.setIsPerLogin(isPcPerApi);// pc端精英版登录判断
		operator.setIsMobileApi(isMobileApi);// 手机端判断
		// 设置到会话线程中
		ThreadLocalHelper.setOperator(operator);
		request.setAttribute("sessionIdForLog", operator.getArchiveId());
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(HttpUtil.isInnerIp("172.16.140.138"));
	}
	
	private boolean isResponseBody(Object handler){
		ResponseBody responseBody = null;
		if (handler instanceof HandlerMethod) {
			HandlerMethod mathod = (HandlerMethod) handler;
			responseBody = mathod.getMethodAnnotation(ResponseBody.class);
			if(responseBody == null){
				RestController restController = mathod.getMethod().getDeclaringClass().getAnnotation(RestController.class);
				if(restController != null){
					return true;
				}
			}
		}
		return responseBody != null;
	}
	/**
	 * 判断当前请求是否需要验证回话
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean isValid(ErpResponseJson responseJson, Operator operator, String clientKey, String servletPath , String isMobileApi) {
		responseJson.setErrCode(ResponseCode.TOKEN_TIMEOUT);
		if (clientKey == null || clientKey.trim().length() <= 0) {
			responseJson.setErrMsg("获取会话连接失败，请重新登录！");
			responseJson.setExtra("1");
			return false;
		}
		String clientKeyValue = (String)cacheUtil.get(clientKey);
		if (clientKeyValue == null) {
			responseJson.setErrMsg("登录已失效，请重新登录！");// 和真实的被挤少了个：已经，以前是：登录已失效，请重新登录！
			responseJson.setExtra("2");
			return false;
		}
		String[] clientKeySplit = clientKeyValue.split("_");
		if(clientKeySplit.length < 2) {
		    cacheUtil.del(clientKey);// 删除这个key的数据，一直不可能会用到这个可以了，不然会缓存很久
			String clientKeyObjVal = (String) clientKeyValue;
			if (clientKeyObjVal.equals(LogInEnum.SystemPara_UP.getValue())) {
				responseJson.setErrMsg("管理员修改了系统参数，请重新登录！");
			} else if (clientKeyObjVal.equals(LogInEnum.RoleOrOper_UP.getValue())) {
				responseJson.setErrMsg("你的用户权限已被管理员修改，请重新登录！");
			} else if (clientKeyObjVal.equals(LogInEnum.UserStatus_UP.getValue())) {
				responseJson.setErrMsg("你的账号已经被停用，请联系管理员！");
			} else if (clientKeyObjVal.equals(LogInEnum.WriteOff_UP.getValue())) {
				responseJson.setErrMsg("你账号已被门店管理员注销，请使用精英版再登陆！");
			} else if (clientKeyObjVal.equals(LogInEnum.DEPT_DOWN.getValue())) {
				responseJson.setErrMsg("您所在门店已被管理员关停，如有疑问请联系门店管理员！");
			} else if (clientKeyObjVal.equals(LogInEnum.MAC_CHANGE.getValue())) {
				responseJson.setErrMsg("您所在门店路由地址已经更改，请联系门店管理员后重新登录！");
			} else if (clientKeyObjVal.equals(LogInEnum.VERSION_CHANGE.getValue())) {
				responseJson.setErrMsg("您门店使用的软件已经更换版本，请重新登录后体验！");
			} else if (clientKeyObjVal.equals(LogInEnum.DEPT_FORMALLY.getValue())) {
				responseJson.setErrMsg("您的门店已转为正式门店，请重新登录后体验！");
			} else if (clientKeyObjVal.equals(LogInEnum.DEPT_CHANGE.getValue())) {
				responseJson.setErrMsg("您所在门店已被管理员调动，请重新登录！");
			} else if (clientKeyObjVal.equals(LogInEnum.AREA_CHANGE.getValue())) {
				responseJson.setErrMsg("您门店所在大区已被管理员调动，请重新登录！");
			} else if (clientKeyObjVal.equals(LogInEnum.UA_ID_CHANGE.getValue())) {
				responseJson.setErrMsg("您的资金账户已被他人绑定，若不是本人操作请联系客服！");
			} else if (clientKeyObjVal.equals(LogInEnum.LEAVE_DEPT.getValue())) {
				responseJson.setErrMsg("您所在已被管理员从门店注销，请使用精英版再登陆！");
			}
			else {
				responseJson.setErrMsg("你的帐号已经在其他地方登录，请注意帐号安全！");
			}
			responseJson.setExtra("3." + clientKeyObjVal);
			return false;
		}
		// 获取有效的key
		Object clientKeyValid = cacheUtil.get(clientKeyValue);
		if(clientKeyValid == null || !((String)clientKeyValid).equals(clientKey)) {
			responseJson.setErrMsg("登录已失效，请重新登录！");
			responseJson.setExtra("4");
			return false;
		}
		// archiveId生成规则，app_xxx_xxx_archiveId 或者 erp_xxx_xxx_archiveId，最后一个下划线后面的必须是archiveId
		String archiveId = clientKeySplit[clientKeySplit.length - 1];
		Object operatorTableObj = cacheUtil.get(CacheStructure.ARCHIVE_ID_OPERATOR + archiveId);
		if(operatorTableObj == null) {
			responseJson.setErrMsg("登录已失效，请重新登录！");
			responseJson.setExtra("5");
			return false;
		}
		Hashtable hashtable = (Hashtable<String, Object>) operatorTableObj ;
		operator.setAllAttribute(hashtable);

		// 判断登录版本是否能访问接口
		String[] loginVersonArr = String.valueOf(operator.getAttribute("LOGIN_VERSON")).split(" ");
		Integer loginVerson = StringUtil.paseInteger(loginVersonArr[loginVersonArr.length - 1], 0);
		String forcedEscalationUrls = AppConfig.getForcedEscalationUrls();
		//如果是掌通请求就不走erp的升级逻辑
		boolean isMobileRequest = "erpappv1".equals(isMobileApi);
		if (!isMobileRequest) {
			if (StringUtils.isNotBlank(forcedEscalationUrls)
					&& loginVerson < AppConfig.getForcedEscalationVersion()) {// 当前版本比配置的小
				// 如果包含当前接口则提示升级
				if (forcedEscalationUrls.contains(servletPath)) {
					responseJson.setErrCode(ResponseCode.NEED_UPGRADE);
					responseJson.setErrMsg("该功能已经优化，请升级到新版后使用！");
					return false;
				}
			}
		}
		// 会话续期，key-用户的key，keyVal-有效的key记录，operator-会话数据
		cacheUtil.expire(clientKey, CacheUtilExt.SESSION_TIME_OUT);
		cacheUtil.expire(clientKeyValue, CacheUtilExt.SESSION_TIME_OUT);
		cacheUtil.expire(CacheStructure.ARCHIVE_ID_OPERATOR + operator.getArchiveId(), CacheUtilExt.SESSION_TIME_OUT);
		return true;
	}
}

