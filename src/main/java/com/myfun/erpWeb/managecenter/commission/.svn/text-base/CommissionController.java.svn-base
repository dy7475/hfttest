package com.myfun.erpWeb.managecenter.commission;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.erpWeb.managecenter.commission.param.ApplyCashWithdrawalParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminBankFourElementMapper;
import com.myfun.repository.admindb.dao.AdminPropertyWithdrawManageMapper;
import com.myfun.repository.admindb.po.AdminBankFourElement;
import com.myfun.repository.admindb.po.AdminBankFourElementExample;
import com.myfun.repository.admindb.po.AdminPropertyWithdrawManage;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 物业分账
 * @author HuangJiang
 * @since 2019年7月30日 上午10:05:56
 * Modified XXX HuangJiang 2019年7月30日
 */
@RestController
@RequestMapping(value="/managerCenter/commission")
public class CommissionController extends BaseController {

	/**************************黄江start*********************************/
	@Autowired
	private AdminPropertyWithdrawManageMapper adminPropertyWithdrawManageMapper;
	@Autowired
	private AdminBankFourElementMapper adminBankFourElementMapper;
	
	/**
	 * 申请提现保存接口
	 * @author HuangJiang
	 * @since 2019年7月31日 上午11:16:55
	 * @param param
	 * @return
	 * Modified XXX HuangJiang 2019年7月31日
	 */
	@ApiOperation("申请提现保存接口")
	@ApiResponses(value = {
		@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@PostMapping("/applyCashWithdrawal")
	public ResponseJson applyCashWithdrawal(@Valid @RequestBody ApplyCashWithdrawalParam param){
		// 验证手续费
		if (null == param.getTotalApplyMoney() || null == param.getCashWithdrawalMoney() || null == param.getServiceChargeMoney()) {
			return ErpResponseJson.warn("参数异常");
		} else {
			BigDecimal serviceCharge = param.getTotalApplyMoney().multiply(new BigDecimal("0.071")).setScale(2, BigDecimal.ROUND_HALF_UP);
			//可以通过BigDecimal的compareTo方法来进行比较。返回的结果是int类型，-1表示小于，0是等于，1是大于。
			if (param.getServiceChargeMoney().compareTo(serviceCharge) != 0) {
				return ErpResponseJson.warn("手续费异常");
			}
		}
		AdminPropertyWithdrawManage adminPropertyWithdrawManage = new AdminPropertyWithdrawManage();
		Operator operator = getOperator();
		Date date = new Date();
		adminPropertyWithdrawManage.setCityId(operator.getCityId());
		adminPropertyWithdrawManage.setCompNo(operator.getCompNo());
		adminPropertyWithdrawManage.setCompId(operator.getCompId());
		adminPropertyWithdrawManage.setDeptId(operator.getDeptId());
		adminPropertyWithdrawManage.setDeptNo(operator.getDeptNo());
		adminPropertyWithdrawManage.setWithdrawStatus((byte) 0); // 打款状态 0:待打款 1已打款 2：已到账
		adminPropertyWithdrawManage.setApplyTime(date);
		adminPropertyWithdrawManage.setCreationTime(date);
		adminPropertyWithdrawManage.setWithdrawAmount(param.getCashWithdrawalMoney());
		adminPropertyWithdrawManage.setApplyUserId(operator.getUserId());
		adminPropertyWithdrawManage.setBrokerageFee(param.getServiceChargeMoney());
		adminPropertyWithdrawManage.setTotalApplyMoney(param.getTotalApplyMoney());
		adminPropertyWithdrawManage.setDeptName(operator.getDeptName());
		
		// 获取银行卡相关信息,姓名和电话都取银行卡上的信息
		AdminBankFourElementExample adminBankFourElementExample = new AdminBankFourElementExample();
		adminBankFourElementExample.createCriteria().andArchiveIdEqualTo(operator.getArchiveId());
		adminBankFourElementExample.setOrderByClause(" ID DESC ");
		AdminBankFourElement adminBankFourElement = adminBankFourElementMapper.selectOneByExample(adminBankFourElementExample);
		if(null == adminBankFourElement){
			return ErpResponseJson.warn("未获取到您的银行卡相关信息");
		}
		adminPropertyWithdrawManage.setApplyUserName(adminBankFourElement.getUserName()); // 姓名
		adminPropertyWithdrawManage.setApplyUserMobile(adminBankFourElement.getUserMobile()); // 电话
		adminPropertyWithdrawManage.setReceiveBankName(adminBankFourElement.getBankNameAll()); // 银行
		adminPropertyWithdrawManage.setReceiveBankNo(adminBankFourElement.getBankCardNumber()); // 银行卡号
		adminPropertyWithdrawManageMapper.insertSelective(adminPropertyWithdrawManage);
		return ErpResponseJson.ok();
	}
	
	/**************************黄江end*********************************/
	
	
	
	/**************************熊财start*********************************/
	
	
	/**************************熊财end*********************************/
}

