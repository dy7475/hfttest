package com.myfun.framework.web.interceptor;

import com.myfun.erpWeb.openApi.suport.OpenApiConfig;
import com.myfun.erpWeb.openApi.suport.OpenApiConfig.ThirdUserData;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.SessionTimeoutException;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.utils.AuthenticationHelper;
import com.myfun.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 安全检查拦截器
 * 
 * @ClassName: UserSecurityInterceptor
 * @author jiangsonggui
 * @date 2015年11月25日 下午5:01:29
 *
 */
@Component
public class OpenApiSecurityInterceptor implements HandlerInterceptor {
	private transient static final Logger logger = LoggerFactory.getLogger(OpenApiSecurityInterceptor.class);
	private Timer timer = null;
	private static final Set<String> AUTH_URL = new HashSet<String>();
	private static final Set<String> NOT_AUTH_URL = new HashSet<String>();
	private static final Set<String> NOT_NEED_CHECK_URL = new HashSet<String>();

	static {
		AUTH_URL.add(".*openApi.*");
		
		NOT_AUTH_URL.add(".*openApi/apartment/getAccessToken$");
		
		NOT_NEED_CHECK_URL.add(".*openApi/test/.*");// 所有测试页面不拦截
		NOT_NEED_CHECK_URL.add(".*openApi/soSoPhoto/.*");// soso图片处理
		NOT_NEED_CHECK_URL.add(".*openApi/score4WeiDian/.*");// 微店刷新优秀员工
		NOT_NEED_CHECK_URL.add(".*openApi/houseUnit/.*");// 重新生成单元和MD5
		NOT_NEED_CHECK_URL.add(".*openApi/trueHouse/.*");// 真房源统计
		NOT_NEED_CHECK_URL.add(".*openApi/photoDeal/.*");// 图片处理
		NOT_NEED_CHECK_URL.add(".*openApi/dealFile/.*");// 文件上传开放接口
		NOT_NEED_CHECK_URL.add(".*openApi/videoDeal/.*");// 视频开放接口
		NOT_NEED_CHECK_URL.add(".*openApi/buildRuleLimitDeal/.*");// 楼盘规则限制
		NOT_NEED_CHECK_URL.add(".*openApi/zhiye/.*");// 知业开放接口
		NOT_NEED_CHECK_URL.add(".*openApi/inviteRegist/.*");// 邀请注册
		NOT_NEED_CHECK_URL.add(".*openApi/sysManage/.*");// 系统管理相关
		NOT_NEED_CHECK_URL.add(".*openApi/funPhone/.*");// 手机号处理
		NOT_NEED_CHECK_URL.add(".*openApi/encode/.*");// 栋，单元
		NOT_NEED_CHECK_URL.add(".*openApi/testWorkCount.*");// 测试工作量
		NOT_NEED_CHECK_URL.add(".*openApi/adress.*");// 获取地址
		NOT_NEED_CHECK_URL.add(".*openApi/salePhone.*");// 依据fun_phone表修改房源表的cell_phone信息
		NOT_NEED_CHECK_URL.add(".*openApi/dealDealTrack.*");// 依据跟进处理合同
		NOT_NEED_CHECK_URL.add(".*openApi/flowRepair.*");// 房客源流转分析
		NOT_NEED_CHECK_URL.add(".*openApi/cache/.*");// 缓存相关
		NOT_NEED_CHECK_URL.add(".*openApi/adminJrFinancePhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/adminFunInvoiseEnclosure.*");
		NOT_NEED_CHECK_URL.add(".*openApi/adminFunArchivePhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/adminTemplateFunVideo.*");
		NOT_NEED_CHECK_URL.add(".*openApi/adminMakeOrderSkillPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/adminCrmFunContractPhtot.*");
		NOT_NEED_CHECK_URL.add(".*openApi/adminWMicroshopArticlePhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/AdminWMicroshopAttachPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/AdminWMicroshopNewsmsgPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/adminWeixinOpenCompPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/agencySpreadPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/AgencyFunUsersPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/agencyWfCollectPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/agencyBuildLayoutPhoto.*");
		NOT_NEED_CHECK_URL.add(".*openApi/agencyWfBuildHistory.*");
		NOT_NEED_CHECK_URL.add(".*openApi/dealGoodNews.*");
		NOT_NEED_CHECK_URL.add(".*openApi/dealEarbestMoney.*");
		NOT_NEED_CHECK_URL.add(".*openApi/autoAudit.*");
		NOT_NEED_CHECK_URL.add(".*openApi/updateFunHouseInfo/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/updateFunHouseInfoUnit/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/trueHouse/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/user/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/alipayRentHouse/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/projectCheckModule/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/aes/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/inviteRegist/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/attendanceSignInModule/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/attendanceStatisticalAnalysisModule/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/workPlan/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/onlineSign/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/onlineCollect/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/dealAudit/.*");
		NOT_NEED_CHECK_URL.add(".*openApi/vStore/.*");
		NOT_NEED_CHECK_URL.add(".*/openApi/buildRule/.*");
		NOT_NEED_CHECK_URL.add(".*/openApi/houseEntrust/.*");
		NOT_NEED_CHECK_URL.add(".*/openApi/moveOrganization.*");
		NOT_NEED_CHECK_URL.add(".*/openApi/etlInviteRegist.*");
		NOT_NEED_CHECK_URL.add(".*openApi/mlEntrustApi/*.*");
		NOT_NEED_CHECK_URL.add(".*openApi/initRoomMd5/*.*");
		NOT_NEED_CHECK_URL.add(".*openApi/switchPosition/*.*");
		NOT_NEED_CHECK_URL.add(".*openApi/organizationMoudle/*.*");
	}

	public OpenApiSecurityInterceptor() {
		logger.info("初始化OpenApiSecurityInterceptor...");
		timer = new Timer("accessToken timer", true);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for (ThirdUserData thirdUserData : OpenApiConfig.THIRD_USER_DATA.values()) {
					thirdUserData.currentAccessCount = 0;
				}
			}
		}, 1000, 1000);
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
		String requestUri = request.getRequestURI();
		// 验证会话是否有效
 		if (!isNotAuth(request) && isAuth(request)) {
			// 不同的路径验证方式不同的处理
			if(requestUri.contains("/apartment/")) {
				// 获取accessToken
				String accessToken = request.getParameter("accessToken");
				if (StringUtil.isEmpty(accessToken)) {
					throw new BusinessException("非法访问");
				} else if (!AuthenticationHelper.tokenIsValid(accessToken)) {
					throw new SessionTimeoutException("accessToken过期", ResponseCode.TOKEN_TIMEOUT);
				}
				// 验证访问频率
				String appId = AuthenticationHelper.getAppId(accessToken);
				ThirdUserData thirdUserData = OpenApiConfig.THIRD_USER_DATA.get(appId);
				if (thirdUserData != null) {
					++thirdUserData.currentAccessCount;
					logger.info("当前访问次数->" + thirdUserData.currentAccessCount);
					if (thirdUserData.currentAccessCount > thirdUserData.getAccessLimit()) {
						throw new SessionTimeoutException("访问频率过高", ResponseCode.CALL_FREQUENCY_GAUGE);
					}
				}
			} else if(isNotNeedCheckUrl(requestUri)) {
				// 不需要检查或特殊处理的地址放里面，自动通过
			} else {
				throw new BusinessException("非法访问");
			}
		}
		return true;
	}
	
	/**
	 * 判断当前请求是否需要验证回话
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isNotNeedCheckUrl(String requestUri) {
		Iterator<String> notAuthUrlIt = NOT_NEED_CHECK_URL.iterator();
		while (notAuthUrlIt.hasNext()) {
			Pattern pattern = Pattern.compile(notAuthUrlIt.next());
			Matcher matcher = pattern.matcher(requestUri);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断当前请求是否需要验证回话
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isAuth(HttpServletRequest request) {
		String reqUrl = request.getRequestURI();
		Iterator<String> notAuthUrlIt = AUTH_URL.iterator();
		while (notAuthUrlIt.hasNext()) {
			Pattern pattern = Pattern.compile(notAuthUrlIt.next());
			Matcher matcher = pattern.matcher(reqUrl);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断当前请求是否需要验证回话
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isNotAuth(HttpServletRequest request) {
		String reqUrl = request.getRequestURI();
		Iterator<String> notAuthUrlIt = NOT_AUTH_URL.iterator();
		while (notAuthUrlIt.hasNext()) {
			Pattern pattern = Pattern.compile(notAuthUrlIt.next());
			Matcher matcher = pattern.matcher(reqUrl);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isNotNeedCheckUrl("http://erpweb/test/openApi/soSoPhoto/dasd"));
	}
}
