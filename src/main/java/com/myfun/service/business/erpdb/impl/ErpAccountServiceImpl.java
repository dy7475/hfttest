package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpAccountMapper;
import com.myfun.repository.erpdb.param.AccountParam;
import com.myfun.repository.erpdb.po.ErpAccount;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAccountService;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpAccountServiceImpl extends AbstractService<ErpAccount, ErpAccount> implements ErpAccountService{
	@Autowired private ErpAccountMapper erpAccountMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAccountMapper;
	}
	
	@Override
	public List<ErpAccount> getAccountList(BaseMapParam param) {
		List<ErpAccount> list = erpAccountMapper.selectAccountList(param.getInteger("cityId"),param.getMap());
		return list;
	}
	
	@Override
	public void insertAccount(AccountParam param) {
		if (param.getAtId() == null) {
			throw new BusinessException("该账务信息未选择账套！");
		}
		ErpAccount erpAccount = new ErpAccount();
		BeanUtils.copyProperties(param,erpAccount);
		erpAccount.setAuditFlag(false);
		erpAccount.setShardCityId(param.getCityId());
		BigDecimal balance = getLastBalance(param.getCityId(), param.getCompId(), param.getAtId(), param.getPartnerId(), param.getOpenPartner());
		BigDecimal actAmount = erpAccount.getActAmount();
		if (erpAccount.getActFlag() != null) {
			if (erpAccount.getActFlag()) {
				balance = balance.add(actAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else {
				balance = balance.subtract(actAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
		}
		erpAccount.setActBalance(balance);
		erpAccountMapper.insertSelective(erpAccount);
	}
	
	/**
	 * 查询出上一笔余额
	 * @author 陈文超
	 * @date Nov 3, 2015 1:47:48 PM
	 */
	private BigDecimal getLastBalance(Integer cityId, Integer compId, Integer atId, Integer partnerId, Integer openPartner) {
		BigDecimal bigDecimal = new BigDecimal("0");
		if (atId == null) {
			return bigDecimal;
		}
		ErpAccount erpAccount = erpAccountMapper.selectByAtIdAndCompId(cityId, compId, atId, partnerId, openPartner);
		if (erpAccount != null) {
			return erpAccount.getActBalance();
		}
		return bigDecimal;
	}
	
	@Transactional
	@Override
	public void updateAccount(AccountParam param) {
		if (param.getActId() == null) {
			throw new BusinessException("actId参数没有传!请检查参数");
		}
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer atId = param.getAtId();
		Integer actId = param.getActId();
		BigDecimal actAmount = param.getActAmount();
		
		ErpAccount accountSel = new ErpAccount();
		accountSel.setShardCityId(cityId);
		accountSel.setActId(actId);
		ErpAccount erpAccount = erpAccountMapper.selectByPrimaryKey(accountSel);
		if (erpAccount.getAuditFlag()) {
			throw new BusinessException("该记录已经复核，不能修改！ ");
		}
		// 找到上一条的余额
		BigDecimal balance = BigDecimal.ZERO;
		ErpAccount erpAccountSel = erpAccountMapper.selectPreAccount(cityId, compId, atId, erpAccount.getCreationTime());
		if (erpAccountSel != null) {
			balance = erpAccountSel.getActBalance();
		}
		// 判断是借还是贷款
		if (param.getActFlag()) {
			balance = balance.add(actAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
		} else {
			balance = balance.subtract(actAmount).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		ErpAccount accountUp = new ErpAccount();
		BeanUtils.copyProperties(param, accountUp);
		accountUp.setActBalance(balance);
		accountUp.setShardCityId(param.getCityId());
		erpAccountMapper.updateByPrimaryKeySelective(accountUp);
		// 更新记录的余额
		List<ErpAccount> accountList = erpAccountMapper.selectPreAccountList(cityId, compId, atId, erpAccount.getCreationTime());
		for (ErpAccount accountTmp : accountList) {
			BigDecimal actAmountTmp = accountTmp.getActAmount();
			if (accountTmp.getActFlag()) {
				balance = balance.add(actAmountTmp).setScale(2, BigDecimal.ROUND_HALF_UP);
			} else {
				balance = balance.subtract(actAmountTmp).setScale(2, BigDecimal.ROUND_HALF_UP);
			}
			accountTmp.setActBalance(balance);
			accountTmp.setShardCityId(cityId);
			erpAccountMapper.updateByPrimaryKeySelective(accountTmp);
		}
	}
	
	/**
	 * 获取账务详情
	 * @param cityId
	 * @param compId
	 * @param atId
	 * @param creationTime
	 * @param balance
	 * @throws Exception
	 */
	@Override
	public ErpAccount getAccountInfo(BaseMapParam param) {
		ErpAccount key = new ErpAccount();
		key.setShardCityId(param.getInteger("cityId"));
		key.setActId(param.getInteger("actId"));
		ErpAccount record = erpAccountMapper.selectByPrimaryKey(key);
		return record;
	}
	
	/**
	 * 删除账务
	 * @param cityId
	 * @param compId
	 * @param atId
	 * @param creationTime
	 * @param balance
	 * @throws Exception
	 */
	@Override
	public void deleteAccount(Integer cityId, Integer actId) {
		ErpAccount key = new ErpAccount();
		key.setShardCityId(cityId);
		key.setActId(actId);
		ErpAccount account = erpAccountMapper.selectByPrimaryKey(key);
		erpAccountMapper.updateAcountAfterThisOne(cityId,account.getCompId(),account.getAtId(), account.getCreationTime(),account.getActAmount(),account.getActFlag());
		erpAccountMapper.deleteByPrimaryKey(key);
	}
	
	/**
	 * 复核一条记录，在复核该记录时将时间在本记录以前的所有记录复核
	 * @param cityId
	 * @param compId
	 * @param atId
	 * @param creationTime
	 * @param balance
	 * @throws Exception
	 */
	@Override
	public void reviewAccount(BaseMapParam param) {
		ErpAccount key = new ErpAccount();
		key.setShardCityId(param.getInteger("cityId"));
		key.setActId(param.getInteger("actId"));
		ErpAccount record = erpAccountMapper.selectByPrimaryKey(key);
		if(record!=null){
			if(record.getAuditFlag()){
				throw new BusinessException("该记录已经复核！");
			}
		}
		erpAccountMapper.updateBeforeAccount(param.getInteger("cityId"),DateTimeHelper.formatDateTimetoString(new Date()),param.getInteger("userId"),record);
	}

}
