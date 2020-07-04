package com.myfun.erpWeb.businesstools.zhiye;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.businesstools.vo.ValidateUserVo;
import com.myfun.erpWeb.businesstools.zhiye.param.AdminZhiyeSynchronousTestRecordsParam;
import com.myfun.erpWeb.businesstools.zhiye.param.AdminZhiyeTestRecordsParam;
import com.myfun.erpWeb.businesstools.zhiye.vo.AdminZhiyeTestRecordsVo;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dao.AdminZhiyeSynchronousTestRecordsMapper;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.admindb.po.AdminZhiyeSynchronousTestRecords;
import com.myfun.repository.admindb.po.AdminZhiyeSynchronousTestRecordsExample;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.param.AdminZhiYeViewLogParam;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.service.business.admindb.AdminZhiYeViewLogService;
import com.myfun.service.business.admindb.AdminZhiyePayLogService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.DateUtil.DateStyle;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 知页相关接口开发
 * @author 张宏利
 * @since 2017年5月18日
 */
@Api(tags ="知页相关接口开发模块")
@Controller
@RequestMapping("/businesstools/zhiye")
public class ZhiYeController extends BaseController {

	@Autowired
	private AdminZhiYeViewLogService adminZhiYeViewLogService;
	@Autowired
	private AdminZhiyePayLogService adminZhiyePayLogService;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private AdminZhiyeSynchronousTestRecordsMapper adminZhiyeSynchronousTestRecordsMapper;

	/**
	 * 验证用户是否有效和扣费等逻辑
	 * 视频播放30s后调用此方法
	 * @author 张宏利
	 * @since 2017年5月18日
	 */
	@ApiOperation("验证用户是否有效和扣费等逻辑")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ValidateUserVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping(value = "/validateUser")
	public ErpResponseJson validateUser(@RequestBody AdminZhiYeViewLogParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		ValidateUserVo validateUserVo = new ValidateUserVo();
		Integer playFlag = 0;// 是否可以播放，默认为0，可以播放；0=可以播放 1=还不是OTO或vip或过期，不播放
		// 非VIP用户才判断是否看过，VIP直接看，不要钱
		if (!"1".equals(getOperator().getSUPER_USER())) {
			boolean isPay = adminZhiyePayLogService.isPay(getOperator().getArchiveId(), param.getMediaId());
			if (!isPay) {// 没有支付
				playFlag = 1;
			}
		}
		// 成功观看之后写一条观看记录
		if (playFlag == 0) {
			adminZhiYeViewLogService.createViewLog(getOperator().getArchiveId(), param.getCoursesType(),
					param.getCoursesId(), param.getMediaId(), param.getSubjectId());
		}
		AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.getAccountByArchiveId(getOperator().getArchiveId());
		if(funUserAccount != null) {
			String hfAmountCanuse = erpSysParaMapper.getParamValue(cityId, compId, "HF_AMOUNT_CANUSE");
			if(StringUtils.isBlank(hfAmountCanuse)) {
				hfAmountCanuse = "0";
			}
			BigDecimal compCanuse = new BigDecimal(hfAmountCanuse);
			Date availableDate = funUserAccount.getAvailableDate();
			BigDecimal totalCompCanUse = compCanuse;
			if (availableDate != null && compCanuse.compareTo(BigDecimal.ZERO) > 0) {
				availableDate = DateUtil.StringToDate(DateUtil.DateToString(availableDate), DateStyle.YYYY_MM_DD);
				Date dateNow = DateUtil.StringToDate(DateUtil.DateToString(new Date()), DateStyle.YYYY_MM_DD);
				if (availableDate.getTime() >= dateNow.getTime()) {
					totalCompCanUse = compCanuse.subtract(funUserAccount.getUsedCompHf());
				}
			}
			validateUserVo.setCouponAmount(totalCompCanUse.add(funUserAccount.getHaofangAmount()));
		}
		validateUserVo.setPlayFlag(playFlag);
		return ErpResponseJson.ok(validateUserVo);
	}
	
	/**
	 * 知业扣费逻辑
	 * @author 张宏利
	 * @since 2017年5月18日
	 */
	@ApiOperation("知业扣费逻辑")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ValidateUserVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping(value = "/paymentForPlay")
	public ErpResponseJson paymentForPlay(@RequestBody AdminZhiYeViewLogParam param) {
		AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("ZHIYE_PLAY_AMOUNT");
		if (adminSysPara != null) {
			String zhiyePlayAmount =  adminSysPara.getParamValue();
			Double amountDouble = StringUtil.parseDouble(zhiyePlayAmount, 0.0);
			if(amountDouble <= 0) {
				amountDouble = 10.0;// 默认值
			}
			BigDecimal payAmountDecimal = BigDecimal.valueOf(amountDouble);
			String payUrl = AppConfig.getAdminWebUrl()+"/pay/deductTelecastMoney";
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("archiveId", getOperator().getArchiveId());
			paramMap.put("money", payAmountDecimal);
			paramMap.put("paidType", "ZHIYE");
			String payResult = HttpUtil.post(payUrl, paramMap);
			int payFlag = -1;
			if(StringUtils.isNotBlank(payResult)) {
				Map<String, Object> payMap = JSON.parseObject(payResult, new TypeReference<Map<String, Object>>(){});
				String errCode = String.valueOf(payMap.get("errCode"));
				if("200".equals(errCode)) {
					Object data = payMap.get("data");
					if(Map.class.isAssignableFrom(data.getClass())) {
						@SuppressWarnings("unchecked")
						Map<String, Object> dataMap = (Map<String, Object>) data;
						String status = String.valueOf(dataMap.get("status"));
						// 把状态码转换成自己的
						if("1".equals(status)) {
							payFlag = 0;// 购买成功
						} else if("0".equals(status)) {
							payFlag = 1;// 账户余额不足
						} else if("2".equals(status)) {
							payFlag = 2;// 资金账户不存在
						}
					}
				}
			}
			if(payFlag < 0) {
				return new ErpResponseJson(ResponseCode.CONFIRM_CODE, "购买失败，请稍候再试");
			} else if(payFlag == 0) {// 购买成功写购买记录
				adminZhiyePayLogService.createPayLog(getOperator().getArchiveId(), param.getCoursesType(),
						param.getCoursesId(), param.getMediaId(), param.getSubjectId(), payAmountDecimal);
			}
			ValidateUserVo validateUserVo = new ValidateUserVo();
			validateUserVo.setPlayFlag(payFlag);
			return ErpResponseJson.ok(validateUserVo);
		}
		return ErpResponseJson.ok();
	}
	
	@ApiOperation("获取用户同步测试记录")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AdminZhiyeTestRecordsVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping(value = "/getUsersTestRecords")
	public ErpResponseJson getUsersTestRecords(@RequestBody AdminZhiyeTestRecordsParam param) {
		AdminZhiyeSynchronousTestRecordsExample example = new AdminZhiyeSynchronousTestRecordsExample();
		example.createCriteria().andBrokerIdEqualTo(param.getBrokerId()).andExamIdEqualTo(param.getExamId()).andSubjectIdEqualTo(param.getSubjectId());
		List<AdminZhiyeSynchronousTestRecords> recordsList = adminZhiyeSynchronousTestRecordsMapper.selectByExample(example);
		AdminZhiyeTestRecordsVo adminZhiyeTestRecordsVo = new AdminZhiyeTestRecordsVo();
		adminZhiyeTestRecordsVo.setList(recordsList);
		return ErpResponseJson.ok(adminZhiyeTestRecordsVo);
	}
}
