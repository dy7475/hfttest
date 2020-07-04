package com.myfun.service.business.agencydb.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunUserAccountMapper;
import com.myfun.repository.admindb.dao.AdminVoipPaidMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunUserAccount;
import com.myfun.repository.admindb.po.AdminVoipPaid;
import com.myfun.repository.agencydb.dao.AgencyVoipAmountLogMapper;
import com.myfun.repository.agencydb.dao.AgencyVoipAmountMapper;
import com.myfun.repository.agencydb.dao.AgencyVoipCardMapper;
import com.myfun.repository.agencydb.po.AgencyVoipAmount;
import com.myfun.repository.agencydb.po.AgencyVoipAmountLog;
import com.myfun.repository.agencydb.po.AgencyVoipCard;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyVoipAmountService;
import com.myfun.utils.rest.VOIPTools;

@Service
public class AgencyVoipAmountServiceImpl extends AbstractService<AgencyVoipAmount, String>
		implements AgencyVoipAmountService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AgencyVoipAmountServiceImpl.class);
	@Autowired
	private AgencyVoipAmountMapper agencyVoipAmountMapper;
	@Autowired
	private AgencyVoipAmountLogMapper agencyVoipAmountLogMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private AdminVoipPaidMapper adminVoipPaidMapper;
	@Autowired
	private AgencyVoipCardMapper agencyVoipCardMapper;

	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyVoipAmountMapper;
	}

	@Transactional
	@Override
	public BigDecimal syncVoipAmount(String mobile) {
		// 取下来的账户
		Double sysIpAmount = VOIPTools.queryIpAmount(mobile);
		// 我们账户的
		AgencyVoipAmount agencyVoipAmount = agencyVoipAmountMapper.selectByPrimaryKey(mobile);

		BigDecimal ipAmount = agencyVoipAmount.getIpAmount();
		if (ipAmount.compareTo(BigDecimal.valueOf(sysIpAmount)) != 0) {
			// 存入每次取得的日志记录
			AgencyVoipAmountLog agencyVoipAmountLog = new AgencyVoipAmountLog();
			agencyVoipAmountLog.setUserMobile(mobile);
			agencyVoipAmountLog.setIpAmount(ipAmount);
			agencyVoipAmountLog.setSysIpAmount(BigDecimal.valueOf(sysIpAmount));
			agencyVoipAmountLog.setCreateTime(new Date());
			agencyVoipAmountLogMapper.insertSelective(agencyVoipAmountLog);

			// 写入账户表
			AgencyVoipAmount upVoipAmount = new AgencyVoipAmount();
			upVoipAmount.setIpAmount(BigDecimal.valueOf(sysIpAmount));
			upVoipAmount.setUserMobile(mobile);
			agencyVoipAmountMapper.updateByPrimaryKeySelective(upVoipAmount);

			// 更新好房币 扣除好房币
			AdminFunArchive archive = adminFunArchiveMapper.getArchiveByMobile(mobile);
			AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(archive.getUaId());

			BigDecimal price = ipAmount.subtract(BigDecimal.valueOf(sysIpAmount));

			AdminFunUserAccount upUserAccount = new AdminFunUserAccount();
			upUserAccount.setUaId(archive.getUaId());
			upUserAccount.setHaofangAmount(adminFunUserAccount.getHaofangAmount().subtract(price));
			upUserAccount.setHaofangBuy(adminFunUserAccount.getHaofangBuy().subtract(price));
			adminFunUserAccountMapper.updateByPrimaryKeySelective(upUserAccount);

			// 写入消费记录
			AdminVoipPaid adminVoipPaid = new AdminVoipPaid();
			adminVoipPaid.setUaId(archive.getUaId());
			adminVoipPaid.setArchiveId(archive.getArchiveId());
			adminVoipPaid.setCityId(archive.getCityId());
			adminVoipPaid.setPaidCatigory("PAY");
			adminVoipPaid.setAmount(price);
			adminVoipPaid.setPadiTime(new Date());
			adminVoipPaidMapper.insertSelective(adminVoipPaid);
		}
		return BigDecimal.valueOf(sysIpAmount);
	}

	@Override
	public void createVoipAmount(String mobile) {
		try {
			// 调用第三方创建账户
			VOIPTools.createSysIpAmount(mobile);
		} catch (Exception e) {
			LOGGER.error("", e);
		}

		// 判断是否有账户记录了
		AgencyVoipAmount agencyVoidAmount = agencyVoipAmountMapper.selectByPrimaryKey(mobile);
		// 没有就创建
		if (agencyVoidAmount == null) {
			AdminFunArchive archive = adminFunArchiveMapper.getArchiveByMobile(mobile);
			Integer uaId = archive.getUaId();
			Integer archiveId = archive.getArchiveId();
			AgencyVoipAmount amount = new AgencyVoipAmount();
			amount.setUserMobile(mobile);
			amount.setUaId(uaId);
			amount.setArchiveId(archiveId);
			amount.setIpAmount(new BigDecimal(0));
			amount.setCreateTime(new Date());
			agencyVoipAmountMapper.insertSelective(amount);
		}
	}

	@Transactional
	@Override
	public String callPhone(String caller, String called) {
		// 创建账户
		createVoipAmount(caller);

		// 拨打之前同步一下余额
		BigDecimal IpAmount = syncVoipAmount(caller);

		// 查询好房币余额
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveByMobile(caller);
		AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper
				.selectByPrimaryKey(adminFunArchive.getUaId());
		if (adminFunUserAccount == null
				|| (adminFunUserAccount.getHaofangBuy().compareTo(BigDecimal.valueOf(0.0)) <= 0)) {
			return "0";
		}

		// 如果小于1块钱就查询电话卡充值
		if (IpAmount.compareTo(BigDecimal.valueOf(1)) < 0) {
			AgencyVoipCard agencyVoipCard = agencyVoipCardMapper.selectOneValidVoipCard();
			if (agencyVoipCard != null) {
				AgencyVoipCard upVoipCard = new AgencyVoipCard();
				upVoipCard.setCardNo(agencyVoipCard.getCardNo());
				agencyVoipCard.setUseTime(new Date());
				agencyVoipCardMapper.updateByPrimaryKeySelective(upVoipCard);

				// 充值
				String result = VOIPTools.rechargeSys(caller, agencyVoipCard.getCardNo(), agencyVoipCard.getCardPw());
				LOGGER.info("第三方ip电话返回结果:" + result);
				if ("0".equals(result)) {
					AgencyVoipAmount agencyVoipAmount = agencyVoipAmountMapper.selectByPrimaryKey(caller);
					AgencyVoipAmount upVoipAmount = new AgencyVoipAmount();
					upVoipAmount.setUserMobile(caller);
					upVoipAmount.setIpAmount(agencyVoipAmount.getIpAmount().add(upVoipCard.getPrice()));
					agencyVoipAmountMapper.updateByPrimaryKeySelective(agencyVoipAmount);
				}
			}
		}

		// 拨打
		VOIPTools.call(caller, called);
		return "1";
	}

	public static void main(String[] args) {
		BigDecimal one = new BigDecimal(0.32);
		System.out.println(one.compareTo(BigDecimal.valueOf(0.0)));
	}

}
