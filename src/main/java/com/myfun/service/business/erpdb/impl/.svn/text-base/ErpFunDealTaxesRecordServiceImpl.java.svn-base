package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateOrInsertDealTaxesParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

import static com.myfun.framework.session.ThreadLocalHelper.getOperator;
import static com.myfun.utils.DateTimeHelper.getTimeNow;

@Service
public class ErpFunDealTaxesRecordServiceImpl extends AbstractService<ErpFunDealTaxesRecord, ErpFunDealTaxesRecord> implements ErpFunDealTaxesRecordService {
	@Autowired
	ErpFunDealTaxesRecordMapper erpFunDealTaxesRecordMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunBuyCustomerService erpFunBuyCustomerService;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunSaleService erpFunSaleService;
	@Autowired
	ErpFunDealTaxesMapper erpFunDealTaxesMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpFunTaskService erpFunTaskService;
	@Autowired ErpFunDealRecordService erpFunDealRecordService;
	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunDealTaxesRecordMapper;
	}

	@Transactional
	@Override
	public void updateOrInsertDealTaxes(UpdateOrInsertDealTaxesParam param, ErpFunDealTaxesRecord dealTaxesRecord) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer dealId = param.getDealId();

		ErpFunDeal funDeal = erpFunDealMapper.selectByDealId(cityId,dealId,null);
		Integer customerId = funDeal.getDealCustomerId();
		Integer houseId = funDeal.getDealHouseId();
		Byte caseType = funDeal.getDealType();
		String sellOwnerPhone = funDeal.getSellOwnerPhone();
		String buyCustomerPhone = funDeal.getBuyCustomerPhone();

		sellOwnerPhone = StringUtils.isNotBlank(sellOwnerPhone) ? sellOwnerPhone.trim() : sellOwnerPhone;
		buyCustomerPhone = StringUtils.isNotBlank(buyCustomerPhone) ? buyCustomerPhone.trim() : buyCustomerPhone;

		dealTaxesRecord.setFeeType(param.getPayType().byteValue());
		dealTaxesRecord.setCompId(compId);
		// 判断是否是第一次保存税费单 税费日志类型为创建税费
		ErpFunDealTaxesRecord oldRecord = erpFunDealTaxesRecordMapper.getDealTaxesRecord(cityId,dealTaxesRecord.getDealId()
				,dealTaxesRecord.getCompId(),dealTaxesRecord.getFeeType());
		ErpFunDealTaxesRecordExample recordExample = new ErpFunDealTaxesRecordExample();
		recordExample.setShardCityId(cityId);
		recordExample.createCriteria().andDealIdEqualTo(dealTaxesRecord.getDealId()).andCompIdEqualTo(dealTaxesRecord.getCompId())
				.andFeeTypeEqualTo(dealTaxesRecord.getFeeType());
		erpFunDealTaxesRecordMapper.deleteByExample(recordExample);
		dealTaxesRecord.setTaxesRecordId(null);
		if (StringUtils.isNotBlank(dealTaxesRecord.getFillUserName())){
			String[] nameArr = dealTaxesRecord.getFillUserName().split(",");
			if (nameArr.length == 2) {
				dealTaxesRecord.setFillUserName(nameArr[1] + "," + param.getUserName());
			} else {
				dealTaxesRecord.setFillUserName(nameArr[0] + "," + param.getUserName());
			}
		}else {
			dealTaxesRecord.setFillUserName (param.getUserName());
		}
		// 第一次保存时 前端不传电话 编辑只有改动电话时前端才传电话
		if (StringUtils.isBlank(dealTaxesRecord.getCallPhone())) {
			if (param.getPayType() == 0) {
				dealTaxesRecord.setCallPhone(buyCustomerPhone);// 买方客户
			}
			if (param.getPayType() == 1) {
				dealTaxesRecord.setCallPhone(sellOwnerPhone);// 卖方业主
			}
		}
		dealTaxesRecord.setShardCityId(cityId);
		erpFunDealTaxesRecordMapper.insertSelective(dealTaxesRecord);
		if (null == oldRecord) {// 第一次保存时
			String trackContent = null;
			GeneralParam generalParam = new GeneralParam();
			generalParam.setUserName(param.getUserName());
			generalParam.setUserId(param.getUserId());
			generalParam.setDeptId(param.getDeptId());
			generalParam.setCompId(param.getCompId());
			generalParam.setCityId(cityId);
			if ("0".equals(param.getPayType())) {
				trackContent = param.getCurrUserName() + " 创建了买方税费";
				erpFunDealRecordService.writeDealRecord(generalParam, param.getDealId(), null, Const.DIC_DEAL_UPDATE_CLASSIC_TAXESCREATE,
						new Byte("4"), trackContent, 1, null, true, param.getPayType() + "");
			}
			if ("1".equals(param.getPayType())) {
				trackContent = param.getCurrUserName() + " 创建了卖方税费";
				erpFunDealRecordService.writeDealRecord(generalParam, param.getDealId(), null, Const.DIC_DEAL_UPDATE_CLASSIC_TAXESCREATE,
						new Byte("5"), trackContent, 1, null, true, param.getPayType() + "");
			}
		}
		// 税费单创建或修改业主、客户电话 同步手机号至合同上
		if (StringUtils.isNotBlank(dealTaxesRecord.getCallPhone()) &&
				((oldRecord != null && !dealTaxesRecord.getCallPhone().equals(oldRecord.getCallPhone()))||oldRecord==null)){
			ErpFunDeal updateModel = new ErpFunDeal();
			String callPhone = dealTaxesRecord.getCallPhone();// 明文手机号
			String[] phoneArr = callPhone.split(":");
			if (param.getPayType() == 0) {// 买方 客户
				updateModel.setBuyCustomerPhone(callPhone);
				updateModel.setBuyCustomerPhoneencode(callPhone);
				// 税费修改客户电话 同步到客源上
				if (phoneArr != null && phoneArr.length > 1 && null != customerId) { // 空的时候是外成交
					if (101 == caseType) {// 出售合同
						ErpFunBuyCustomer buyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, customerId);
						String phoneResult = "&&&";
						String oldCellPhone = buyCustomer.getCellPhone();
						if (StringUtils.isNotBlank(oldCellPhone)) {
							String[] phones = StringHelper.split(oldCellPhone, "&&&");
							for (int i = 0; i < phones.length; i++) {
								String[] phoneValues = StringHelper.split(phones[i], "|||");
								// ["手机","13=3531393;1=504>60744"]
								if (phoneValues.length > 1) {
									// 解密
									if (i == 0 && !phoneArr[1].equals(EnCodeHelper.decode(phoneValues[1]))) {
										phoneValues[0] = "手机";
										phoneValues[1] = EnCodeHelper.encode(phoneArr[1]);
									}
									phoneResult += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
								}
							}
						}
						if("&&&".equals(phoneResult)) {
							phoneResult = "&&&手机|||" + EnCodeHelper.encode(phoneArr[1]) + "&&&";
						}
						buyCustomer.setCellPhone(phoneResult);
						erpFunBuyCustomerService.updateCustomerSourceInfoByDealTaxes(param,buyCustomer, oldCellPhone, phoneResult);
					}
				}
			}else if (1 == param.getPayType())  {// 卖方 业主
				updateModel.setSellOwnerPhone(callPhone);
				updateModel.setSellOwnerPhoneencode(callPhone);
				// 税费修改业主电话 同步到房源上
				if (null!=houseId && 101 == caseType.intValue()) {
					ErpFunSale sale = erpFunSaleMapper.getFunSaleBySaleId(cityId,houseId);
					String phoneResult = "&&&";
					String oldCellPhone = sale.getCellPhone();
					if (StringUtils.isNotBlank(oldCellPhone)) {
						String[] phones = StringHelper.split(oldCellPhone, "&&&");
						for (int i = 0; i < phones.length; i++) {
							String[] phoneValues = StringHelper.split(phones[i], "|||");
							// ["手机","13=3531393;1=504>60744"]
							if (phoneValues.length > 1) {
								// 解密
								if (i == 0 && !phoneArr[1].equals(EnCodeHelper.decode(phoneValues[1]))) {
									phoneValues[0] = "手机";
									phoneValues[1] = EnCodeHelper.encode(phoneArr[1]);
								}
								phoneResult += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
							}
						}
						if("&&&".equals(phoneResult)) {
							phoneResult = "&&&手机|||" + EnCodeHelper.encode(phoneArr[1]) + "&&&";
						}
						sale.setCellPhone(phoneResult);
						erpFunSaleService.updateHouseSourceInfoByDealTaxes(param, sale, oldCellPhone, phoneResult);
					}
				}
			}
			updateModel.setDealId(param.getDealId());
			updateModel.setShardCityId(cityId);
			erpFunDealMapper.updateByPrimaryKeySelective(updateModel);
		}
		ErpFunDealTaxesExample taxesExample=new ErpFunDealTaxesExample();
		taxesExample.setShardCityId(cityId);
		taxesExample.createCriteria().andCompIdEqualTo(param.getCompId()).andDealIdEqualTo(param.getDealId()).andPayTypeEqualTo(param.getPayType().byteValue());
		erpFunDealTaxesMapper.deleteByExample(taxesExample);
		Integer count=param.getCount();
		if (null==count){
			count=0;
		}
		if (count > 0) {
			Byte taskType = Const.DIC_TASK_TYPE_CONTRACT_REMIND;
			ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getFunDealById(cityId,compId,param.getDealId());
			String taskSubJect = taskType + " " + param.getCurrUserName() + " 修改了编号" + funBaseInfoDealPo.getContractNo()
					+ "的合同的税费";
			List<ErpFunUsers> list = erpFunUsersService.getTaskUserList(cityId,param.getDealId(), 2, param.getCompId(),param.getUserId());
			//合同相关提醒任务
			erpFunTaskService.createDealWarmTask(funBaseInfoDealPo.getDealType(), param.getDealId(),
					funBaseInfoDealPo.getContractNo(), list, taskSubJect, Const.DIC_TASK_TYPE_CONTRACT_REMIND,
					taskSubJect, param.getUserId(), param.getCityId(),param.getDeptId(), param.getCompId());
		}
		HashSet<String> set = new HashSet<>();
		if (StringUtils.isNotBlank(param.getTaxesJson())) {
			List<ErpFunDealTaxes> list = JSON.parseArray(param.getTaxesJson(), ErpFunDealTaxes.class);
			for (ErpFunDealTaxes funDealTaxes : list) {
				set.add(funDealTaxes.getTaxesFatherId() + "_" + funDealTaxes.getTaxesSubId());
			}
			for (ErpFunDealTaxes funDealTaxes : list) {
				funDealTaxes.setCompId(param.getCompId());
				funDealTaxes.setId(null);
				funDealTaxes.setDealId(param.getDealId());
				funDealTaxes.setCreateTime(getTimeNow());
				funDealTaxes.setUpdateUser(param.getUserId());
				funDealTaxes.setUpdateUserName(param.getUserName());
				funDealTaxes.setShardCityId(cityId);
				// 防止一个FATHER_ID和SUB_ID重复，多次insert
				if (set.contains(funDealTaxes.getTaxesFatherId() + "_" + funDealTaxes.getTaxesSubId())) {
					erpFunDealTaxesMapper.insertSelective(funDealTaxes);
					set.remove(funDealTaxes.getTaxesFatherId() + "_" + funDealTaxes.getTaxesSubId());
				}
			}
		}

		// 税费更新日志 税费日志类型为更新日志
		GeneralParam generalParam=new GeneralParam();
		generalParam.setCityId(cityId);
		generalParam.setCompId(param.getCompId());
		generalParam.setDeptId(param.getDeptId());
		generalParam.setUserId(param.getUserId());
		generalParam.setUserName(param.getUserName());
		if (null != oldRecord) {
			String trackContent = null;
			if (0 == param.getPayType()) {
				trackContent = param.getCurrUserName() + " 更新了买方税费列表信息";
				erpFunDealRecordService.writeDealRecord(generalParam,param.getDealId(), null,
						Const.DIC_DEAL_UPDATE_CLASSIC_TAXESUPDATE, (byte) 4, trackContent, 1,null,true,param.getPayType() + "");
			}
			if (1 == param.getPayType()) {
				trackContent = param.getCurrUserName() + " 更新了卖方税费列表信息";
				erpFunDealRecordService.writeDealRecord(generalParam,param.getDealId(), null,
						Const.DIC_DEAL_UPDATE_CLASSIC_TAXESUPDATE, (byte) 5, trackContent, 1,null,true,param.getPayType() + "");
			}
		}
	}

}
