package com.myfun.erpWeb.managecenter.commission;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.commission.param.ApplyCashWithdrawalParam;

/**
 * @author HuangJiang
 * @since 2019年7月30日 上午11:53:57
 * Modified XXX HuangJiang 2019年7月30日
 */
public class CommissionControllerTest extends BaseTestController {

	@Before
	public void init(){
		init("http://192.168.200.155:8080/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "1280436", "15182729709");
	}
	
	/**
	 * 申请提现保存接口
	 * @author HuangJiang
	 * @since 2019年7月30日 上午11:55:50
	 * @throws Exception
	 * Modified XXX HuangJiang 2019年7月30日
	 */
	@Test
	public void applyCashWithdrawal() throws Exception{
		ApplyCashWithdrawalParam param = new ApplyCashWithdrawalParam();
		param.setTotalApplyMoney(new BigDecimal("9800")); // 总金额
		param.setCashWithdrawalMoney(new BigDecimal("9104.2")); // 扣掉手续费后的金额
		param.setServiceChargeMoney(new BigDecimal("695.8")); // 手续费
		System.out.println(postNewErp(param, "/managerCenter/commission/applyCashWithdrawal"));
	}
	
}

