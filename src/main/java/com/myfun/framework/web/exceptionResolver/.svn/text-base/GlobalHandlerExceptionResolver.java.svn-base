package com.myfun.framework.web.exceptionResolver;

import com.alibaba.fastjson.JSON;
import com.dianping.cat.Cat;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.*;
import com.myfun.framework.session.ActionUrl;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.ThreadLocalHelper;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.po.AdminServerErrorLog;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.KafkaBizUtils;
import com.myfun.utils.StringUtil;
import com.myfun.utils.log.MybatisLogThreadLocal;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 全局异常处理器
 *
 * @author jiangsonggui
 * @ClassName: GlobalHandlerExceptionResolver
 * @date 2015年11月25日 下午5:01:08
 */
@Component
public class GlobalHandlerExceptionResolver extends SimpleMappingExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalHandlerExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        request.setAttribute("throwable", ex);
        ModelAndView mv = new ModelAndView();
        response.setStatus(HttpStatus.OK.value());// 设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);// 设置ContentType
        response.setCharacterEncoding("UTF-8");// 避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        ErpResponseJson responseJson = null;
        String exceptionStr = StringUtil.getException(ex);
        ThreadLocalHelper.addErrorInfoLocal(exceptionStr);

        if (ex instanceof SessionTimeoutException) {// 会话过期异常
            SessionTimeoutException vaEx = (SessionTimeoutException) ex;
            int errCode = null != vaEx.getErrorCode() ? vaEx.getErrorCode() : ResponseCode.CONFIRM_CODE;
            responseJson = new ErpResponseJson(errCode, vaEx.getErrorMsg());

        } else if (ex instanceof HttpMessageNotReadableException) {// 参数验证异常
            String exField = getExceptionField(ex.getMessage()) + "参数错误";
            responseJson = new ErpResponseJson(ResponseCode.MISSING_PARAMETER, exField);

        } else if (ex instanceof MethodArgumentNotValidException) {// 参数验证异常
            String exField = getExceptionField(ex.getMessage()) + "参数错误";
            responseJson = new ErpResponseJson(ResponseCode.MISSING_PARAMETER, exField);

        } else if (ex instanceof AssertException) {// 不满足条件异常
			AssertException vaEx = (AssertException)ex;
			Integer errCode = ResponseCode.CONFIRM_CODE;
			if(null != vaEx.getErrCode()) {
				errCode = Integer.valueOf(vaEx.getErrCode());
			}
			responseJson = new ErpResponseJson(errCode, ex.getMessage());
        } else if (ex instanceof BusinessException) {// 业务异常
            BusinessException vaEx = (BusinessException) ex;
            int errCode = null != vaEx.getErrCode() ? Integer.parseInt(vaEx.getErrCode()) : ResponseCode.CONFIRM_CODE;
            responseJson = new ErpResponseJson(errCode, ex.getMessage());
			if (vaEx.getExtMap() != null) {
				responseJson.setExtra(vaEx.getExtMap());
			}
        } else if (ex instanceof ConfirmException) {// 提示性异常
            responseJson = new ErpResponseJson(ResponseCode.CONFIRM_CODE, ex.getMessage());

        } else if (ex instanceof RequestTimeoutException) { // 连接超时异常
            // 发送kafka消息到msgBug
            KafkaBizUtils.projectWarmingMsg(AppConfig.getProperty("spring.application.name"), "请求超时", ex.getMessage());
            Cat.logError("HTTP CALL TIMEOUT", ex);
            responseJson = new ErpResponseJson(ResponseCode.CONFIRM_CODE, ex.getMessage());

        } else {// 其他异常cho
            responseJson = new ErpResponseJson(ResponseCode.OTHER_FAIL, "系统错误");
//            this.sendDingTalkWarnMessage(request, ex);
        }
        
        LOGGER.error("WebExceptionHandle Request 全局异常捕获...", ex);
        Cat.logError(ex);
//        // 框架进行全局异常处理的相关数据采集
//        this.globalExceptionExtensionOperation(request, responseJson, ex);

        boolean isResponseBody = isResponseBody(handler);// 是否返回body
        // 返回页面或者返回内容处理
        if (!isResponseBody) {
            mv.addObject("errJson", responseJson);
            if (ex instanceof SessionTimeoutException) {
                mv.addObject("isSessionTimeOut", "1");
            }
            String customErrPage = (String) request.getAttribute("customErrPage");
            // 有定义过错误页面的直接返回自定义的错误页面
            if (StringUtils.isNotBlank(customErrPage)) {
                mv.setViewName(customErrPage);
            } else {// 否则返回默认的错误页面
                mv.setViewName("common/error");
            }
        } else {
            try {
            	String deviceType = request.getHeader("deviceType");
				//如果是移动的请求,返回值加一个error
				if ("1".equals(deviceType) || "2".equals(deviceType)) {
					int errCode = responseJson.getErrCode();
					if (errCode !=Const.ResponseCode.SUCCESS) {
						Map<String,Object> error = new HashMap<>();
						error.put("code", errCode);
						error.put("title", responseJson.getErrMsg());
						if(responseJson.getExtra() != null){
							error.put("ext", responseJson.getExtra());
						}
						responseJson.setError(error);
					}
				}
                String jsonStr = JSON.toJSONString(responseJson);
                ThreadLocalHelper.getACTION_URL_LOCAL().setReparams(jsonStr);
                response.getWriter().write(jsonStr);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mv;
    }

    /**
     * 如果是HttpMessageNotReadableException 则获取错误字段
     *
     * @param exception
     * @return
     */
    public static String getExceptionField(String exception) {
        Pattern pattern = Pattern.compile("Unrecognized field \"(\\w*)[$\"]");
        Matcher matcher = pattern.matcher(exception);
        String field = "";
        if (matcher.find()) {
            field = matcher.group(1);
        } else {
            pattern = Pattern.compile("Field error in object '.+' on field '(\\w+)'");
            matcher = pattern.matcher(exception);
            if (matcher.find()) {
                field = matcher.group(1);
            }
        }
        return field;
    }

    /**
     * 是否返回body
     *
     * @param handler
     * @return
     * @author 张宏利
     * @since 2017年5月11日
     */
    private boolean isResponseBody(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod mathod = (HandlerMethod) handler;
            ResponseBody body = mathod.getMethodAnnotation(ResponseBody.class);
            if (body == null) {
                RestController restController = mathod.getMethod().getDeclaringClass().getAnnotation(RestController.class);
                if (restController == null) {
                    if (!mathod.getMethod().getReturnType().isAssignableFrom(ResponseJson.class)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 插入系统错误日志
     *
     * @param responseJson
     */
    private AdminServerErrorLog createServerErrorLog(ErpResponseJson responseJson, String requestUrl, String exceptionStr) {
        AdminServerErrorLog record = new AdminServerErrorLog();

        record.setErrorCode(responseJson.getErrCode());
        record.setErrorMsg(responseJson.getErrMsg());
        record.setCreationTime(new Date());

        try {
            String sqlStr = MybatisLogThreadLocal.getLogRecordByStr();
            ActionUrl actionUrl = ThreadLocalHelper.getACTION_URL_LOCAL();
            record.setExceptionText(DateTimeHelper.formatDateTimetoString(new Date()) + "\n" + requestUrl + "\n"
                    + actionUrl.getParams() + "\n" + sqlStr + "\n" + exceptionStr);

            Operator operator = ThreadLocalHelper.getOperator();
            if (operator != null) {
                record.setCityId(operator.getCityId());
                record.setArchiveId(operator.getArchiveId());
            }
            record.setServerType(2);// erpWeb

        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }
}
