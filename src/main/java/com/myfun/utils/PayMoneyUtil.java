package com.myfun.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.support.constant.Const;

public class PayMoneyUtil {
	
	/**
	 * 调用admin的扣费，没抛异常就说明扣费成功了<br/>
	 * paidType需要在admin项目里面备案！
	 * @author 张宏利
	 * @since 2018年5月31日
	 * @param archiveId
	 * @param payAmount
	 * @param paidType
	 */
	public static void deductTelecastMoney(Integer archiveId, BigDecimal payAmount, String paidType) {
		String payUrl = AppConfig.getAdminWebUrl()+"/pay/deductTelecastMoney";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("archiveId", archiveId);
		paramMap.put("money", payAmount);
		paramMap.put("paidType", paidType);
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
		if(payFlag == 0) {// 购买成功
			return;
		} else if(payFlag == 1) {// 账户余额不足
			throw new BusinessException("购买失败，账户余额不足", Const.ResponseErrorCode.USER_RECHARGE_COIN);
		} else if(payFlag == 2) {// 资金账户不存在
			throw new ConfirmException("购买失败，资金账户不存在");
		} else {
			throw new ConfirmException("购买失败，请稍候再试");
		}
	}
	
}
