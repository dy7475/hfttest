package com.myfun.service.business.admindb.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.BusinessExceptionUtils;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.dto.AdminFunUsersAccountDto;
import com.myfun.repository.admindb.param.AdminPaidCountParam;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpSysParaKey;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.admindb.AdminFunUserAccountService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminFunUserAccountServiceImpl extends AbstractService<AdminFunUserAccount, Integer>implements AdminFunUserAccountService {

	@Autowired
	AdminFunUserAccountMapper adminFunUserAccountMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpSysParaMapper erpSysParaMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	AdminFunPaidMapper adminFunPaidMapper;
	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	AdminSysParaService adminSysParaService;
	@Autowired
	AdminFunArchiveService adminFunArchiveService;
	@Autowired
	ErpSysParaService erpSysParaService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunUserAccountMapper;
	}

	/**
	 * 清除公司数据---------------老版查询条件有问题，等待后期修改。
	 */
	@Override
	public String clearCompData(String deptName) {
		adminFunUserAccountMapper.selectByUserMoblie(deptName);
		return null;
	}

	@Override
	public List<AdminFunUsersAccountDto> selectByTypeAndOther(AdminPaidCountParam adminPaidCountParam) {
		PageHelper.startPage(adminPaidCountParam.getPageNum(), Const.PAGE_NUMBER, true);
		Page<AdminFunUsersAccountDto> list = adminFunUserAccountMapper.selectByTypeAndOther(adminPaidCountParam);
		return list;
	}

	/**
	 * @see AdminFunUserAccountService#checkVoipUseCompMoney(int, double,
	 *      boolean)
	 */
	@Override
	public Map<String, String> checkVoipUseCompMoney(int archiveId, double money, boolean isUseCompMoney) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("compPrice", "0");
		result.put("personalPrice", "0");
		result.put("status", "0");

		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);

		// 没有资金账户时返回false--个人需要资金账户是最基本条件
		if (adminFunArchive.getUaId() == null || adminFunArchive.getUaId().equals(0)) {
			result.put("status", "2");
			return result;
		}

		// 获取用户公司信息
		ErpFunUsers funUsers = erpFunUsersMapper.selectByArchiveId(adminFunArchive.getArchiveId());

		// 可以使用的公司额度
		BigDecimal useCompBalance = new BigDecimal(0.0);
		if (isUseCompMoney) {
			String compNo = erpFunUsersMapper.getCompNoByArchiveId(archiveId);
			AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
			Date nowDate = new Date();

			if (adminFunComp != null && adminFunComp.getUaId() != null && adminFunComp.getUaId() > 0) {
				result.put("compUaId", adminFunComp.getUaId().toString());

				// 个人每天可用公司好房币
				/*ErpSysParaKey sysParaKey = new ErpSysParaKey();
				sysParaKey.setShardArchiveId(adminFunArchive.getArchiveId());
				sysParaKey.setCompId(funUsers.getCompId());
				sysParaKey.setParamId("VOIP_USE_COMP_MONEY");
				ErpSysPara erpSysPara = erpSysParaMapper.selectByPrimaryKey(sysParaKey);*/
				BigDecimal compLimitPrice = StringUtil.parseBigDecimal(erpSysParaService.getMLSysParamValByUserDefZero(funUsers.getCityId().intValue(), funUsers.getCompId(), funUsers.getUserId(), "VOIP_USE_COMP_MONEY"));

				AdminFunUserAccount compAccount = adminFunUserAccountMapper.selectByPrimaryKey(adminFunComp.getUaId());

				// 个人当天可以使用公司额度
				BigDecimal compBalance = new BigDecimal(0.0);
				// 如果最后使用时间是当天 则说明已经使用了X个 否则说明当前公司还没有使用过
				if (compAccount.getVoipAvailableDate() != null && DateUtil.DateToString(compAccount.getVoipAvailableDate(), "yyyy-MM-dd").equals(DateUtil.DateToString(nowDate, "yyyy-MM-dd"))) {
					compBalance = compLimitPrice.subtract(compAccount.getVoipUsedCompHf());
				} else {
					compBalance = compLimitPrice;
				}

				// 计算可以扣除公司的个数
				useCompBalance = compAccount.getHaofangBuy().compareTo(compBalance) > 0 ? compBalance : compAccount.getHaofangBuy();
			}
		}

		// 判断公司余额是否够本次支付
		if (useCompBalance.compareTo(BigDecimal.valueOf(money)) >= 0) {
			result.put("compPrice", String.valueOf(money));
			result.put("status", "1");
			return result;
		} else {
			// 检查自己余额
			AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(adminFunArchive.getUaId());

			if (adminFunUserAccount == null) {
				result.put("status", "2");
				return result;
			}

			BigDecimal totalBalance = useCompBalance.add(adminFunUserAccount.getHaofangBuy());

			if (totalBalance.compareTo(BigDecimal.valueOf(money)) >= 0) {
				result.put("compPrice", useCompBalance.toString());
				result.put("personalPrice", BigDecimal.valueOf(money).subtract(useCompBalance).toString());
				result.put("personalUaId", adminFunArchive.getUaId().toString());
				result.put("status", "1");
				return result;
			} else {
				return result;
			}
		}
	}

	@Override
	public boolean checkBalance(int archiveId, double money, boolean isUseCompMoney) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
		// 检查余额
		AdminFunUserAccount adminFunUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(adminFunArchive.getUaId());
		if (isUseCompMoney && (adminFunArchive.getUaIdComp() != null && adminFunArchive.getUaIdComp() != 0)) {
			// 获取用户公司信息
			ErpFunUsers funUsers = erpFunUsersMapper.selectByArchiveId(adminFunArchive.getArchiveId());

			// 个人每天可用公司好房币
//			ErpSysPara para = new ErpSysPara();
//			para.setShardArchiveId(adminFunArchive.getArchiveId());
//			para.setCompId(funUsers.getCompId());
//			para.setParamId("HF_AMOUNT_CANUSE");
			double compLimitPrice = StringUtil.parseDouble(erpSysParaMapper.getParamValue(adminFunArchive.getCityId().intValue(), funUsers.getCompId(), "HF_AMOUNT_CANUSE"));

			// 检查公司可用余额
			AdminFunUsersAccountDto usersAccountDto = adminFunUserAccountMapper.getUsableCompPrice(compLimitPrice, adminFunArchive.getUaId());

			// 查询公司资金账户
			AdminFunUserAccount compUserAccount = adminFunUserAccountMapper.selectByPrimaryKey(adminFunArchive.getUaIdComp());

			// 公司好房币余额
			double compPriceLimit = compUserAccount.getHaofangBuy().doubleValue();

			// 个人当天还可用公司好房币
			Double priceRs = usersAccountDto.getPriceRs();

			// 为2说明当天未使用
			Integer avaDateFlag = usersAccountDto.getAvaDateFlag();
			if (2 == avaDateFlag) {
				priceRs = compLimitPrice;
			}
			if (compLimitPrice <= 0 || compPriceLimit <= 0 || (compLimitPrice > 0 && compPriceLimit > 0 && priceRs <= 0)) {
				if ((adminFunUserAccount == null) || (adminFunUserAccount.getHaofangBuy().compareTo(BigDecimal.valueOf(money)) <= 0)) {
					return false;
				}
			} else if ((adminFunUserAccount == null) || (adminFunUserAccount.getHaofangBuy().compareTo(BigDecimal.valueOf(money)) <= 0)) {
				return false;
			}
		} else {
			if ((adminFunUserAccount == null) || (adminFunUserAccount.getHaofangBuy().compareTo(BigDecimal.valueOf(money)) <= 0)) {
				return false;
			}
		}
		return true;
	}

	public Double[] deductBalance(Integer archiveId, double money, boolean isUseCompMoney, String paydType, String desc) {
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);

		Integer uaId = adminFunArchive.getUaId();

		double haofangAmount = 0.0;
		double haofangBuy = 0.0;

		double compHaofangAmount = 0.0;
		double compHaofangBuy = 0.0;

		return new Double[] {};

	}

	/**
	 * @see AdminFunUserAccountService#deductVoipUseCompMoney(int, double,
	 *      boolean)
	 */
	@Transactional
	@Override
	public Map<String, String> deductVoipUseCompMoney(int archiveId, double money, boolean isUseCompMoney) {
		Map<String, String> result = checkVoipUseCompMoney(archiveId, money, isUseCompMoney);
		System.out.println(money + "---------" + result);
		if (result.get("status").equals("1")) {
			BigDecimal compPrice = StringUtil.parseBigDecimal(result.get("compPrice"));
			BigDecimal personalPrice = StringUtil.parseBigDecimal(result.get("personalPrice"));

			if (compPrice.compareTo(BigDecimal.valueOf(0.0)) > 0) {
				Integer compUaId = StringUtil.parseInteger(result.get("compUaId"));

				AdminFunUserAccount compAccount = adminFunUserAccountMapper.selectByPrimaryKey(compUaId);

				BigDecimal amountAfter = compAccount.getHaofangBuy().subtract(compPrice);

				AdminFunUserAccount upUserAccount = new AdminFunUserAccount();
				upUserAccount.setUaId(compUaId);
				upUserAccount.setHaofangBuy(amountAfter);
				adminFunUserAccountMapper.updateByPrimaryKeySelective(upUserAccount);

				// 写消费记录
				AdminFunPaid adminFunPaid = getDefaultVoipFunPaid();
				adminFunPaid.setArchiveId(archiveId);
				adminFunPaid.setUaId(compUaId);
				adminFunPaid.setAmount(compPrice.doubleValue());
				adminFunPaid.setAmountBefore(compAccount.getHaofangBuy().doubleValue());
				adminFunPaid.setAmountAfter(amountAfter.doubleValue());
				adminFunPaidMapper.insertSelective(adminFunPaid);
			}

			if (personalPrice.compareTo(BigDecimal.valueOf(0.0)) > 0) {
				Integer personalUaId = StringUtil.parseInteger(result.get("personalUaId"));

				AdminFunUserAccount personalAccount = adminFunUserAccountMapper.selectByPrimaryKey(personalUaId);

				BigDecimal amountAfter = personalAccount.getHaofangBuy().subtract(personalPrice);

				AdminFunUserAccount upUserAccount = new AdminFunUserAccount();
				upUserAccount.setUaId(personalUaId);
				upUserAccount.setHaofangBuy(amountAfter);
				adminFunUserAccountMapper.updateByPrimaryKeySelective(upUserAccount);

				// 写消费记录
				AdminFunPaid adminFunPaid = getDefaultVoipFunPaid();
				adminFunPaid.setArchiveId(archiveId);
				adminFunPaid.setUaId(personalUaId);
				adminFunPaid.setAmount(personalPrice.doubleValue());
				adminFunPaid.setAmountBefore(upUserAccount.getHaofangBuy().doubleValue());
				adminFunPaid.setAmountAfter(amountAfter.doubleValue());
				adminFunPaidMapper.insertSelective(adminFunPaid);
			}
		}
		return result;
	}

	private AdminFunPaid getDefaultVoipFunPaid() {
		AdminFunPaid adminFunPaid = new AdminFunPaid();
		adminFunPaid.setPaidCatigory("PAY");
		adminFunPaid.setPaidType("VOIP");
		adminFunPaid.setPadiTime(new Date());
		adminFunPaid.setPaidSource((byte) 0);
		adminFunPaid.setDesc("IP电话拨打消费现金");
		return adminFunPaid;
	}

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal(1.0);
		BigDecimal bigDecimal1 = new BigDecimal(1.0);

		System.out.println(bigDecimal1.compareTo(bigDecimal));
		System.out.println(bigDecimal.subtract(bigDecimal1));
	}

	/**
	 * 查询账户信息
	 * **/
	@Override
	public AdminFunUserAccount selectAccountByArchiveId(Integer archiveId) {
		// TODO Auto-generated method stub
		return adminFunUserAccountMapper.getAccountByArchiveId(archiveId);
	}



	/**
	 * 资金账户检查扣费 并存放总金额
	 * **/
	@Override
	public Integer checkSendSMSAndCharge(Integer smsNum, BaseMapParam param) throws Exception{
		AdminSysPara adminSysParaPO = adminSysParaMapper.selectByPrimaryKey("SMS_PRICE");
		// 检查发送短信需要的多少钱
		double price = Double.parseDouble(adminSysParaPO.getParamValue()) * smsNum;

		AdminFunUserAccount funUserAccountPO = adminFunUserAccountMapper.selectByPrimaryKey(param.getInteger("uaId"));
		// 格式化小数点
		double balance = Double.parseDouble(NumberHelper.formatNumber(funUserAccountPO.getHaofangBuy().doubleValue(), NumberHelper.NUMBER_IN_2));
//		String pay = String.valueOf(price);
		// 记录当前总扣费 暂时不用这样的写法
		// setAttribute("sendSmsTotalPrice", pay);
		if (balance < price) {
			throw new BusinessException("余额不足，你的余额还剩：" +NumberHelper.formatNumber(balance) + "元，本次发送短信共" + smsNum
					+ "条，需要" + price + "元，请充值。");
		} else {
			// 发送成功 更新记录
			adminFunUserAccountMapper.subtractMoney(price, param.getInteger("uaId"));
			AdminFunPaid funPaidPO = new AdminFunPaid();
			funPaidPO.setAmount(price);
			funPaidPO.setAmountCoin(price);
			funPaidPO.setAmountAfter(balance - price);
			funPaidPO.setAmountBefore(balance);
			funPaidPO.setArchiveId(param.getInteger("archiveId"));
			funPaidPO.setUaId(param.getInteger("uaId"));
			funPaidPO.setCityId(param.getInteger("cityId").shortValue());
			funPaidPO.setPaidType("SMS");
			funPaidPO.setPaidCatigory("PAY");
			funPaidPO.setDesc("短信服务扣费");
			funPaidPO.setPadiTime(new Date());
			funPaidPO.setDeptId(param.getInteger("adminDeptId"));
			adminFunPaidMapper.insertSelective(funPaidPO);
			return funPaidPO.getPaidId();
		}
	}

	@Override
	public Map<String, String> getBiddPrice(String uaId, String compUaId, Boolean isPerLogin, Integer cityId, Integer compId, Double currMoney) throws Exception{
		String compLimitPrice = "0";
		if (!isPerLogin) {// 这里判断是否是精英版登录，用于代码统一，精英版登录的不允许使用公司资金账户
			compLimitPrice = erpSysParaMapper.getParamValue(cityId, compId, "HF_AMOUNT_CANUSE");// 每天可用公司多好优惠券和好房币
		}
		compLimitPrice = StringUtils.isBlank(compLimitPrice) ? "0" : compLimitPrice;
		// 计算需要补充的余额 1、没有历史出价的话historyPrice = 0
		// 说明是第一次预约或者挤掉其他人的竞价排名，2、历史出过价的这次只支付余额。
		// 计算差额
		double compPrice = 0.0d;// 公司资金账户的扣费情况 -- 好房币加优惠券
		double haofangMoneyComp = 0.0d;// 公司资金账户的扣费情况 -- 好房币
		double personalPrice = 0.0d;// 个人资金账户的扣费情况 -- 好房币加优惠券
		double haofangMoney = 0.0d;// 个人资金账户的扣费情况 -- 好房币
		if (currMoney > 0) {
			// 这里加入 扣费的逻辑-------------------------------------------------
			// this.payPrice(currMoney);
			Map<String, String> priceElement = this.queryMoneyIsEnough(uaId, compUaId,currMoney.toString(), compLimitPrice);
			String selfPriceFlag = priceElement.get("SELF_PRICE_FLAG");
			// 为2说明不是在当天使用
			String avaDateFlagTmp = priceElement.get("AVA_DATE_FLAG");
			// 还可以使用的金额，用于扣费
			double priceRsTmp = Double.parseDouble(priceElement.get("USED_COMP_HF"));
			// 公司资金账户的余额
			double compAmountTmp = Double.parseDouble(priceElement.get("COMP_AMOUNT"));
			// 公司对个人账号的使用额度，检查额度是否足以支付当前竞价费用。
			double compLimitPriceTmp = Double.parseDouble(compLimitPrice);
			// 允许使用的公司金额
			if (priceRsTmp > 0 && priceRsTmp <= compLimitPriceTmp && "1".equals(avaDateFlagTmp)) {
				// 如果公司余额足以支付，并且在公司限额适用范围内，那么就使用公司账户金额支付
				if (compAmountTmp >= currMoney && currMoney <= priceRsTmp) {// 公司的好房币足以支付扣费，并且当天公司额度还没有达到限制。
					compPrice = currMoney;
					// 当天使用还没有达到公司的限额，但是公司的余额只能支付一部分费用
				} else if (priceRsTmp > 0 && compAmountTmp >= currMoney) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
					// 当天使用还没有达到公司的限额，但是公司的余额只够支付小于扣费的部分费用,尽量把公司的扣完.
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp <= priceRsTmp) {
					compPrice = compAmountTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp >= priceRsTmp) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				}
			} else if ("2".equals(avaDateFlagTmp)) {// 如果当天还没有使用过公司的资金账户
				if (compAmountTmp >= currMoney && currMoney <= compLimitPriceTmp) {
					compPrice = currMoney;
				} else if (compLimitPriceTmp > 0 && compAmountTmp >= currMoney) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp <= priceRsTmp) {
					compPrice = compAmountTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp >= priceRsTmp) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else {
					personalPrice = currMoney;
				}
			} else if ("1".equals(avaDateFlagTmp)) {
				personalPrice = currMoney;
			}

			if (compPrice == 0) {
				if ("1".equals(selfPriceFlag)) {
					personalPrice = currMoney;
				}
			}
			if (compPrice > 0) {
				haofangMoneyComp = this.getPayBiddUseComp(compPrice, uaId, compUaId);
			}
			if (personalPrice > 0) {
				haofangMoney = this.getPayBiddUseSelf(personalPrice, uaId, compUaId);
			}
			Map<String, String> map = new HashMap<>();
//			if (personalPrice == 0 && compPrice == 0) {
//				//C++前端余额不足，ERRCODE不返回-1
//				throw new JthinkBusinessWarnException("没有足够的金额用于竞价！", JthinkExceptionUtils.ERROR_CODE_BALANCE_LACK);
//			}
			map.put("COMP_PRICE", NumberHelper.formatNumber(compPrice,NumberHelper.NUMBER_IN_1));
			map.put("COMP_COIN", NumberHelper.formatNumber(haofangMoneyComp,NumberHelper.NUMBER_IN_1));

			map.put("PERSONAL_PRICE", NumberHelper.formatNumber(personalPrice,NumberHelper.NUMBER_IN_1));
			map.put("PERSONAL_COIN", NumberHelper.formatNumber(haofangMoney,NumberHelper.NUMBER_IN_1));

			if (compPrice > 0 && personalPrice > 0) {// 两者都有
				map.put("UA_TYPE", Constants_DIC.DIC_BIDD_ALL_UA_TYPE);
			} else if (personalPrice > 0) {
				map.put("UA_TYPE", Constants_DIC.DIC_BIDD_PER_UA_TYPE);// 个人
			} else if (compPrice > 0) {
				map.put("UA_TYPE", Constants_DIC.DIC_BIDD_COMP_UA_TYPE);// 公司
			}
			return map;
		} else {
			throw new BusinessException("请输入正确的竞价价格！");
		}
	}

	/**
	 * 获取本人的扣费部分查询
	 * @param biddPrice
	 * @param uaId
	 * @throws Exception
	 *             陈文超
	 */
	private double getPayBiddUseSelf(double biddPrice, String uaId, String compUaId) throws Exception {
		// 检测钱是不是够的,先查询出公司的金额
		double[] balance = this.queryBalance("SELF", uaId, compUaId);
		if(balance[1] <= 0){
			balance[0] = NumberHelper.sub(balance[0], balance[1]);
			if(biddPrice > balance[0]){
				throw new BusinessException("个人账户好房豆余额不足！NO.1", BusinessExceptionUtils.ERROR_CODE_BALANCE_LACK);
			}
		}
		// 如果赠送的减去此次竞价的费用小于购买的，就更新购买的好房币。
		double haofangMoney = 0.0d;// 这里表示购买好房币，区分优惠券
		double surplusMoney = NumberHelper.sub(balance[0], biddPrice);
		// HAOFANG_AMOUNT 减去 本次使用的好房币 = 10 - 5 = 5，购买的好房币为7 此时7 >
		// 5说明已经开始使用购买好房币了，并使用了5 - (7 - 5) = 3个好房币和5 - 3 = 2个优惠券
		// 没扣之前还有优惠券的情况
		if (balance[1] > 0 && balance[1] >= surplusMoney) {//购买的大于等于剩余的说明已经开始使用购买的好房币了、等于说明这次扣费 优惠券刚好全部使用完
			// 如果购买的好房币和赠送的已经相同了那么就不需要再计算优惠券了,说明优惠券已经扣完了。
			// 这里就需要判断使用的优惠券和好房币的区分。
			haofangMoney = NumberHelper.sub(balance[1], surplusMoney); // 使用了多少购买好房币，减负的差价相当于加上差价，就是要扣的好房币
			// 优惠券已经使用完的情况或者购买部分为0，只使用赠送的优惠券
		} else if (NumberHelper.sub(balance[0], biddPrice) > balance[1] || balance[0] == balance[1] || balance[1] == 0) {
			haofangMoney = 0;
			if(biddPrice > balance[0]){
				haofangMoney = NumberHelper.sub(biddPrice, balance[0]);
			}
		} else{
			// 这种情况不允许发生
			throw new BusinessException("个人账户好房豆余额不足！NO.5");
		}

		if (haofangMoney < 0) {
			throw new BusinessException("个人账号好房豆余额错误！额度：" + haofangMoney);
		}
		return haofangMoney;
	}

	/**
	 * 获取公司的扣费部分查询
	 * @throws Exception
	 * lcb
	 */
	private double getPayBiddUseComp(double biddPrice, String uaId, String compUaId) throws Exception{
		// 检测钱是不是够的
		double[] balance = this.queryBalance("COMP",uaId, compUaId);
		// 如果赠送的减去此次竞价的费用小于购买的，就更新购买的好房币。
		double haofangMoney = 0.0d;// 这里表示购买好房币，区分优惠券
		double surplusMoney = NumberHelper.sub(balance[0], biddPrice);
		// HAOFANG_AMOUNT 减去 本次使用的好房币 = 10 - 5 = 5，购买的好房币为7 此时7 >
		// 5说明已经开始使用购买好房币了，并使用了5 - (7 - 5) = 3个好房币和5 - 3 = 2个优惠券
		// 没扣之前还有优惠券的情况
		if (balance[1] > 0 && balance[1] >= surplusMoney) {// 购买的大于等于了剩余的说明已经开始使用购买的好房币了 、等于说明这次扣费 优惠券刚好全部使用完
			// 如果购买的好房币和赠送的已经相同了那么就不需要再计算优惠券了,说明优惠券已经扣完了。
			// 这里就需要判断使用的优惠券和好房币的区分。
			haofangMoney = NumberHelper.sub(balance[1], surplusMoney); // 使用了多少购买好房币
			// 优惠券已经使用完的情况或者购买部分为0，只使用赠送的优惠券
		} else if (NumberHelper.sub(balance[0], biddPrice) > balance[1] || balance[0] == balance[1] || balance[1] == 0) {
			haofangMoney = 0;
		} else if(balance[1] == surplusMoney){//优惠券已经全部使用完
			haofangMoney = 0;
		} else {
			// 这种情况不允许发生
			throw new BusinessException("公司账户好房豆额不足！NO.5");
		}
		if (haofangMoney < 0) {
			throw new BusinessException("公司账号好房豆额错误！额度：" + haofangMoney);
		}
		return haofangMoney;
	}


	/**
	 * 查询现有的好房币 0：优惠券 1：个人购买的好房币
	 *
	 * @return
	 * @throws Exception
	 * lcb
	 */
	private double[] queryBalance(String type, String uaId, String compUaId) throws Exception {
		double[] result = new double[2];
		String[] amount = null;
		if ("COMP".equals(type)) {// 查询公司的资金账户
			amount = this.getAmount(compUaId);// 公司的资金账户ID
		} else if ("SELF".equals(type)) {// 查询个人的资金账户
			amount = this.getAmount(uaId);
		}
		double all = Double.parseDouble(NumberHelper.formatNumber(amount[0], NumberHelper.NUMBER_IN_2));// 好房币加优惠券
		double selfBuy = Double.parseDouble(NumberHelper.formatNumber(amount[1], NumberHelper.NUMBER_IN_2));// 个人购买的部分
		//理论上个人购买的部分不能超过 优惠券加好房币的金额
		if(selfBuy > all){
			throw new BusinessException("资金账户数据错误！");
		}
		result[0] = all;
		result[1] = selfBuy;
		return result;
	}

	/**
	 * 获得用户的账号资金情况--公司资金账号或者个人资金账户 lcb
	 *
	 * @return
	 * @throws Exception
	 */
	private String[] getAmount(String uaId)  {
		try {
			AdminFunUserAccount accountPo = adminFunUserAccountMapper.selectByPrimaryKey(Integer.valueOf(uaId));
			return new String[] {
					NumberHelper.formatNumber(accountPo.getHaofangAmount().doubleValue(), NumberHelper.NUMBER_IN_1), // 0 为优惠券+好房币数量
					NumberHelper.formatNumber(accountPo.getHaofangBuy().doubleValue(), NumberHelper.NUMBER_IN_1) // 1 为购买的好房币
			};
		} catch (Exception e) {
			return new String[] { "0", "0" };
		}
	}

	/** 查询是否有足够的金币 **/
	private Map<String, String> queryMoneyIsEnough(String uaId, String compUaId, String biddPrice, String compLimitPrice){
		// AVAILABLE_DATE的格式为：2014-01-01 ，判断一天的结束是：2014-01-02 00:00:00 ,在当天范围内
		// 为：1 否则为：2
		// 先查询个人资金账户的一个使用公司金额的情况
		Map<String, Object> userRes = adminFunUserAccountMapper.queryMoneyIsEnough(compLimitPrice, uaId);
		// 查询用户的现金是否足够
		String usermoney = "0";
		String compmoney = "0";
		double priceRs = -1.0d;// 该数据小于0，则说明使用公司资金已经超额。
		String avaDateFlag = "2"; // 1 说明是在当天时间范围内 2 说明当天是第一次竞价扣费

		usermoney = userRes.get("HAOFANG_AMOUNT").toString();
		usermoney = "".equals(usermoney) ? "0" : usermoney;
		double haofangBuy = Double.parseDouble(NumberHelper.formatNumber(userRes.get("HAOFANG_BUY").toString(), NumberHelper.NUMBER_IN_2));// 好房币加优惠券
		if(haofangBuy < 0){
			usermoney = String.valueOf(Double.parseDouble(usermoney) - haofangBuy);
		}

		String priceRsTmp = userRes.get("PRICE_RS")+"";
		if (!"".equals(priceRsTmp)) {
			priceRs = Double.parseDouble(priceRsTmp);
		}
		avaDateFlag = userRes.get("AVA_DATE_FLAG").toString();// =1 说明是在当天时间范围内
		if (StringUtils.isNotBlank(compUaId) && !"0".equals(compUaId)) {// 这里判断是否是精英版，用于代码统一
			// 公司的资金金额
			Map<String, Object> compRes = adminFunUserAccountMapper.queryMoneyIsEnough(compLimitPrice, compUaId);
			compmoney = compRes.get("HAOFANG_AMOUNT").toString();
			compmoney = "".equals(compmoney) ? "0" : compmoney;
		}
		Map<String, String> mapTmp = new HashMap<>();
		// 查询消费成功后对用户账号进行扣费.
		if (!"".equals(usermoney) && !"".equals(biddPrice)) {
			if (("1".equals(avaDateFlag) && priceRs >= 0)) {// 当天没有使用过公司的资金账户，或者
				// 如果使用判断是否超过限额，
				// 都进入公司资金账户金额判断
				if (Double.parseDouble(compmoney) >= Double
						.parseDouble(biddPrice)) {// 公司余额足以支付
					mapTmp.put("COMP_PRICE_FLAG", "1");// 个人使用公司资金账户还足以支付
					mapTmp.put("SELF_PRICE_FLAG", "0");// 不需要个人支付金额
				} else if (Double.parseDouble(compmoney) > 0
						&& Double.parseDouble(compmoney) < Double
						.parseDouble(biddPrice)) {
					mapTmp.put("COMP_PRICE_FLAG", "1");// 个人使用公司资金账户还足以支付部分
					mapTmp.put("SELF_PRICE_FLAG", "1");// 需要个人支付金额
				} else {
					mapTmp.put("COMP_PRICE_FLAG", "0");// 个人使用公司资金账户还足以支付
					if (Double.parseDouble(usermoney) >= Double
							.parseDouble(biddPrice)) {
						mapTmp.put("SELF_PRICE_FLAG", "1");
					} else {
						mapTmp.put("SELF_PRICE_FLAG", "0");// 个人的金额不足以支付
					}
				}
			} else {
				mapTmp.put("COMP_PRICE_FLAG", "0");// 个人使用公司资金账户还足以支付
				if (Double.parseDouble(usermoney) >= Double.parseDouble(biddPrice)) {
					mapTmp.put("SELF_PRICE_FLAG", "1");
				} else {
					mapTmp.put("SELF_PRICE_FLAG", "0");// 个人的金额不足以支付
				}
			}

			if ("2".equals(avaDateFlag)) {
				priceRs = Double.parseDouble(compLimitPrice);
				mapTmp.put("COMP_PRICE_FLAG", "1");// 公司资金账户还足以支付
			}
			mapTmp.put("USED_COMP_HF", priceRs + "");// 用户当天还可以使用公司账户金额支付的额度，用于扣费
			mapTmp.put("AVA_DATE_FLAG", avaDateFlag);// 为2说明不是在当天使用
			mapTmp.put("COMP_AMOUNT", compmoney);
		}
		return mapTmp;
	}
	
	/**
	 * 执行竞价扣费
	 * @author ZangTie
	 * @since 2018年7月20日 下午4:12:05
	 * @param uaId=个人资金账户ID
	 * @param compUaId=公司资金账户ID
	 * @param isPerLogin=是否是精英版
	 * @param cityId=城市ID
	 * @param compId=公司ID
	 * @param newBiddPirce=本次出价
	 * @param historyPrice=历史出价 没有历史出价的情况下该值为：0
	 * @param biddType=BUILD、HOUSE
	 * @param superUser
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 * @throws Exception 
	 */
	@Transactional
	@Override
	public Map<String, String> updateBuildBiddPrice(Map<String, String> operatorMap,Boolean isPerLogin, double newBiddPirce, double historyPrice,String biddType) throws Exception{
		String uaId = operatorMap.get("uaId");
		String compUaId = operatorMap.get("compUaId");
		Integer cityId = Integer.valueOf(operatorMap.get("cityId"));
		Integer compId = Integer.valueOf(operatorMap.get("compId"));
		String superUser = operatorMap.get("superUser");
		String compLimitPrice = "0";
		if (!isPerLogin) {// 这里判断是否是精英版登录，用于代码统一，精英版登录的不允许使用公司资金账户
			compLimitPrice = erpSysParaMapper.getParamValue(cityId, compId, "HF_AMOUNT_CANUSE");// 每天可用公司多好优惠券和好房币
		}
		compLimitPrice = StringUtils.isBlank(compLimitPrice) ? "0" : compLimitPrice;
		// 计算需要补充的余额 1、没有历史出价的话historyPrice = 0
		// 说明是第一次预约或者挤掉其他人的竞价排名，2、历史出过价的这次只支付余额。
		// 计算差额
		// 接口不一致开始
		double currMoney = NumberHelper.sub(newBiddPirce, historyPrice);
		if("1".equals(superUser)){
			currMoney = Math.ceil(currMoney/2);
		}
		double compPrice = 0.0d;// 公司资金账户的扣费情况 -- 好房币加优惠券
		double haofangMoneyComp = 0.0d;// 公司资金账户的扣费情况 -- 好房币
		double personalPrice = 0.0d;// 个人资金账户的扣费情况 -- 好房币加优惠券
		double haofangMoney = 0.0d;// 个人资金账户的扣费情况 -- 好房币
		if (currMoney > 0) {
			// 这里加入 扣费的逻辑-------------------------------------------------
			// this.payPrice(currMoney);
			Map<String, String> priceElement = this.queryMoneyIsEnoughConfirm(uaId, compUaId,String.valueOf(currMoney), compLimitPrice);
			// 接口不一致结束
			String selfPriceFlag = priceElement.get("SELF_PRICE_FLAG");
			// 为2说明不是在当天使用
			String avaDateFlagTmp = priceElement.get("AVA_DATE_FLAG");
			// 还可以使用的金额，用于扣费
			double priceRsTmp = Double.parseDouble(priceElement.get("USED_COMP_HF"));
			// 公司资金账户的余额
			double compAmountTmp = Double.parseDouble(priceElement.get("COMP_AMOUNT"));
			// 公司对个人账号的使用额度，检查额度是否足以支付当前竞价费用。
			double compLimitPriceTmp = Double.parseDouble(compLimitPrice);
			// 允许使用的公司金额
			if (priceRsTmp > 0 && priceRsTmp <= compLimitPriceTmp && "1".equals(avaDateFlagTmp)) {
				// 如果公司余额足以支付，并且在公司限额适用范围内，那么就使用公司账户金额支付
				if (compAmountTmp >= currMoney && currMoney <= priceRsTmp) {// 公司的好房币足以支付扣费，并且当天公司额度还没有达到限制。
					compPrice = currMoney;
					// 当天使用还没有达到公司的限额，但是公司的余额只能支付一部分费用
				} else if (priceRsTmp > 0 && compAmountTmp >= currMoney) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
					// 当天使用还没有达到公司的限额，但是公司的余额只够支付小于扣费的部分费用,尽量把公司的扣完.
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp <= priceRsTmp) {
					compPrice = compAmountTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp >= priceRsTmp) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				}
			} else if ("2".equals(avaDateFlagTmp)) {// 如果当天还没有使用过公司的资金账户
				if (compAmountTmp >= currMoney && currMoney <= compLimitPriceTmp) {
					compPrice = currMoney;
				} else if (compLimitPriceTmp > 0 && compAmountTmp >= currMoney) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp <= priceRsTmp) {
					compPrice = compAmountTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else if (priceRsTmp > 0 && compAmountTmp > 0
						&& compAmountTmp <= currMoney && compAmountTmp >= priceRsTmp) {
					compPrice = priceRsTmp;
					personalPrice = NumberHelper.sub(currMoney, compPrice);
				} else {
					personalPrice = currMoney;
				}
			} else if ("1".equals(avaDateFlagTmp)) {
				personalPrice = currMoney;
			}

			if (compPrice == 0) {
				if ("1".equals(selfPriceFlag)) {
					personalPrice = currMoney;
				}
			}
			if (compPrice > 0) {
				// 接口不一致开始
				haofangMoneyComp = this.updatePayBiddUseComp(compPrice,avaDateFlagTmp, biddType,operatorMap);
			}
			if (personalPrice > 0) {
				haofangMoney = this.updatePayBiddUseSelf(personalPrice,biddType,operatorMap);
				// 接口不一致结束
			}
			Map<String, String> map = new HashMap<>();
//			if (personalPrice == 0 && compPrice == 0) {
//				//C++前端余额不足，ERRCODE不返回-1
//				throw new JthinkBusinessWarnException("没有足够的金额用于竞价！", JthinkExceptionUtils.ERROR_CODE_BALANCE_LACK);
//			}
			map.put("COMP_PRICE", NumberHelper.formatNumber(compPrice,NumberHelper.NUMBER_IN_1));
			map.put("COMP_COIN", NumberHelper.formatNumber(haofangMoneyComp,NumberHelper.NUMBER_IN_1));

			map.put("PERSONAL_PRICE", NumberHelper.formatNumber(personalPrice,NumberHelper.NUMBER_IN_1));
			map.put("PERSONAL_COIN", NumberHelper.formatNumber(haofangMoney,NumberHelper.NUMBER_IN_1));

			if (compPrice > 0 && personalPrice > 0) {// 两者都有
				map.put("UA_TYPE", Constants_DIC.DIC_BIDD_ALL_UA_TYPE);
			} else if (personalPrice > 0) {
				map.put("UA_TYPE", Constants_DIC.DIC_BIDD_PER_UA_TYPE);// 个人
			} else if (compPrice > 0) {
				map.put("UA_TYPE", Constants_DIC.DIC_BIDD_COMP_UA_TYPE);// 公司
			}
			return map;
		} else {
			throw new BusinessException("请输入正确的竞价价格！");
		}
	}
	
	/**
	 * 房源竞价付费,使用的个人的资金账户 biddType ['BUILD','HOUSE'] 表示是楼盘竞价扣费还是房源竞价扣费
	 * @author ZangTie
	 * @since 2018年7月20日 下午7:54:27
	 * @param biddPrice
	 * @param biddType
	 * @param operatorMap
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 * @throws Exception 
	 */
	private double updatePayBiddUseSelf(double biddPrice, String biddType, Map<String, String> operatorMap) throws Exception {
		String uaId = operatorMap.get("uaId");
		String compUaId = operatorMap.get("compUaId");
		Integer cityId = Integer.valueOf(operatorMap.get("cityId"));
		Integer archiveId = Integer.valueOf(operatorMap.get("archiveId"));
		// 检测钱是不是够的
		double[] balance = this.queryBalance("SELF",uaId, compUaId);
		// 检测钱是不是够的,先查询出公司的金额
		if (biddPrice > balance[0]) {
			// 如果好房币小于0了，总额 = HAOFANG_AMOUNT - HAOFANG_BUY
			if (balance[1] <= 0) {
				balance[0] = NumberHelper.sub(balance[0], balance[1]);
				if (biddPrice > balance[0]) {
					throw new BusinessException("个人账户好房豆余额不足！", Constants_DIC.ERROR_CODE_BALANCE_LACK);
				}
			} else {
				throw new BusinessException("个人账户好房豆余额不足！", Constants_DIC.ERROR_CODE_BALANCE_LACK);
			}
		}
		// 如果赠送的减去此次竞价的费用小于购买的，就更新购买的好房币。
		double haofangMoney = 0.0d;// 这里表示购买好房币，区分优惠券
		double couponMoney = 0.0d;// 优惠券
		double surplusMoney = NumberHelper.sub(balance[0], biddPrice);
		// HAOFANG_AMOUNT 减去 本次使用的好房币 = 10 - 5 = 5，购买的好房币为7 此时7 >
		// 5说明已经开始使用购买好房币了，并使用了5 - (7 - 5) = 3个好房币和5 - 3 = 2个优惠券
		// 没扣之前还有优惠券的情况
		if (balance[1] > 0 && balance[1] >= surplusMoney) {// 购买的大于了剩余的说明已经开始使用购买的好房币了
			// 如果购买的好房币和赠送的已经相同了那么就不需要再计算优惠券了,说明优惠券已经扣完了。
			// 这里就需要判断使用的优惠券和好房币的区分。
			haofangMoney = NumberHelper.sub(balance[1], surplusMoney); // 使用了多少购买好房币
			couponMoney = NumberHelper.sub(NumberHelper.sub(balance[0], surplusMoney), haofangMoney);// 使用了多少优惠券
			// 优惠券已经使用完的情况或者购买部分为0，只使用赠送的优惠券
		} else if (NumberHelper.sub(balance[0], biddPrice) > balance[1] || balance[0] == balance[1] || balance[1] == 0) {
			haofangMoney = 0;
			couponMoney = biddPrice;
		} else {
			// 这种情况不允许发生
			throw new BusinessException("个人账户好房豆余额不足！");
		}

		if (haofangMoney < 0) {
			throw new BusinessException("个人账号好房豆余额错误！额度：" + haofangMoney);
		}
		// 扣费
		// 扣费--个人账号
		if ("HOUSE".equals(biddType)) {// 小区竞价扣费时需要冻结
			adminFunUserAccountMapper.updateHaoFangAmountByBiddType(uaId,biddPrice,1);
		} else {// 房源竞价实时扣费
			adminFunUserAccountMapper.updateHaoFangAmountByBiddType(uaId,biddPrice,2);
		}
		if (balance[1] > surplusMoney) {// 当购买好房币已经大于优惠券和好房币之和时，更新好房币
			adminFunUserAccountMapper.updateHaoFangBuyByUaId(uaId);
		}

		if ("HOUSE".equals(biddType)) {// 房房源竞价才直接写PAID记录，小区竞价是在400服务上进行统一处理
			// 向FUN_PAID表中写入消费记录
			AdminFunPaid adminFunPaid = new AdminFunPaid();
			adminFunPaid.setUaId(Integer.valueOf(compUaId));
			adminFunPaid.setArchiveId(Integer.valueOf(archiveId));
			adminFunPaid.setCityId(Short.valueOf(cityId.toString()));
			adminFunPaid.setPaidCatigory("PAY");
			adminFunPaid.setPaidType("HOUSE_BIDDING");
			adminFunPaid.setAmountBefore(balance[0]);
			adminFunPaid.setAmountAfter(NumberHelper.sub(balance[0], biddPrice));
			adminFunPaid.setAmountCoin(haofangMoney);
			adminFunPaid.setAmountQuan(couponMoney);
			adminFunPaid.setAmount(biddPrice);
			adminFunPaid.setPadiTime(new Date());
			adminFunPaid.setPaidSource(Byte.valueOf(Constants_DIC.DIC_PAID_SOURCE_0));
			String desc = "";
			if (haofangMoney > 0) {
				if (couponMoney > 0) {
					desc = "房源竞价花费：" + NumberHelper.formatNumber(haofangMoney, NumberHelper.NUMBER_IN_1) + "好房豆";
					desc = desc + "、" + NumberHelper.formatNumber(couponMoney, NumberHelper.NUMBER_IN_1) + "优惠券";
				}else{
					desc = "房源竞价花费：" + NumberHelper.formatNumber(biddPrice, NumberHelper.NUMBER_IN_1) + "好房豆";
				}
			} else if (couponMoney > 0) {
				desc = "房源竞价花费：" + NumberHelper.formatNumber(biddPrice,NumberHelper.NUMBER_IN_1) + "优惠券";
			}
			adminFunPaid.setDesc(desc);
			adminFunPaidMapper.insertSelective(adminFunPaid);
		}
		return haofangMoney;
		
	}

	/**
	 * 房源竞价付费,使用的公司的资金账户 biddType ['BUILD','HOUSE'] 表示是楼盘竞价扣费还是房源竞价扣费
	 * @author ZangTie
	 * @since 2018年7月20日 下午5:23:29
	 * @param compPrice
	 * @param avaDateFlagTmp
	 * @param biddType
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 * @throws Exception 
	 */
	private double updatePayBiddUseComp(double biddPrice, String type, String biddType,Map<String, String> operatorMap) throws Exception {
		String uaId = operatorMap.get("uaId");
		String compUaId = operatorMap.get("compUaId");
		Integer cityId = Integer.valueOf(operatorMap.get("cityId"));
		Integer archiveId = Integer.valueOf(operatorMap.get("archiveId"));
		// 检测钱是不是够的
		double[] balance = this.queryBalance("COMP",uaId, compUaId);
		if (biddPrice > balance[0]) {
			throw new BusinessException("公司账户好房豆余额不足！NO.0");
		}

		// 如果赠送的减去此次竞价的费用小于购买的，就更新购买的好房币。
		double haofangMoney = 0.0d;// 这里表示购买好房币，区分优惠券
		double couponMoney = 0.0d;// 优惠券
		double surplusMoney = NumberHelper.sub(balance[0], biddPrice);
		// HAOFANG_AMOUNT 减去 本次使用的好房币 = 10 - 5 = 5，购买的好房币为7 此时7 >
		// 5说明已经开始使用购买好房币了，并使用了5 - (7 - 5) = 3个好房币和5 - 3 = 2个优惠券
		// 没扣之前还有优惠券的情况
		if (balance[1] > 0 && balance[1] >= surplusMoney) {// 购买的大于了剩余的说明已经开始使用购买的好房币了
			// 如果购买的好房币和赠送的已经相同了那么就不需要再计算优惠券了,说明优惠券已经扣完了。
			// 这里就需要判断使用的优惠券和好房币的区分。
			haofangMoney = NumberHelper.sub(balance[1], surplusMoney); // 使用了多少购买好房币
			couponMoney = NumberHelper.sub(NumberHelper.sub(balance[0], surplusMoney), haofangMoney);// 使用了多少优惠券
			// 优惠券已经使用完的情况或者购买部分为0，只使用赠送的优惠券
		} else if (NumberHelper.sub(balance[0], biddPrice) > balance[1] || balance[0] == balance[1]
				|| balance[1] == 0) {
			haofangMoney = 0;
			couponMoney = biddPrice;
		} else {
			// 这种情况不允许发生
			throw new BusinessException("公司账户好房豆余额不足！NO.1");
		}
		if (haofangMoney < 0) {
			throw new BusinessException("公司账号好房豆余额错误！额度：" + haofangMoney);
		}
		// 扣费
		// 扣费--公司账户
		if ("BUILD".equals(biddType)) {// 小区竞价扣费时需要冻结
			adminFunUserAccountMapper.updateHaoFangAmountByBiddType(compUaId,biddPrice,1);
		} else {// 房源竞价实时扣费
			adminFunUserAccountMapper.updateHaoFangAmountByBiddType(compUaId,biddPrice,2);
		}
		// 当使用公司的资金账号金额时，要在用户自己的资金账户上写操作记录
		adminFunUserAccountMapper.updateUsedCompHfByUaId(uaId,biddPrice);
		if (balance[1] > surplusMoney) {// 当购买好房币已经大于优惠券和好房币之和时，更新好房币
			adminFunUserAccountMapper.updateHaoFangBuyByUaId(compUaId);
		}

		if ("HOUSE".equals(biddType)) {// 房房源竞价才直接写PAID记录，小区竞价是在400服务上进行统一处理
			// 向FUN_PAID表中写入消费记录
			AdminFunPaid adminFunPaid = new AdminFunPaid();
			adminFunPaid.setUaId(Integer.valueOf(compUaId));
			adminFunPaid.setArchiveId(Integer.valueOf(archiveId));
			adminFunPaid.setCityId(Short.valueOf(cityId.toString()));
			adminFunPaid.setPaidCatigory("PAY");
			adminFunPaid.setPaidType("HOUSE_BIDDING");
			adminFunPaid.setAmountBefore(balance[0]);
			adminFunPaid.setAmountAfter(NumberHelper.sub(balance[0], biddPrice));
			adminFunPaid.setAmountCoin(haofangMoney);
			adminFunPaid.setAmountQuan(couponMoney);
			adminFunPaid.setAmount(biddPrice);
			adminFunPaid.setPadiTime(new Date());
			adminFunPaid.setPaidSource(Byte.valueOf(Constants_DIC.DIC_PAID_SOURCE_0));
			String desc = "";
			if (haofangMoney > 0) {
				if (couponMoney > 0) {
					desc = "房源竞价花费公司账户：" + NumberHelper.formatNumber(haofangMoney, NumberHelper.NUMBER_IN_1) + "好房豆";
					desc = desc + "、" + NumberHelper.formatNumber(couponMoney, NumberHelper.NUMBER_IN_1) + "优惠券";
				} else {
					desc = "房源竞价花费公司账户：" + NumberHelper.formatNumber(biddPrice, NumberHelper.NUMBER_IN_1) + "好房豆";
				}
			} else if (couponMoney > 0) {
				desc = "房源竞价花费公司账户：" + NumberHelper.formatNumber(biddPrice, NumberHelper.NUMBER_IN_1) + "优惠券";
			}
			adminFunPaid.setDesc(desc);
			adminFunPaidMapper.insertSelective(adminFunPaid);
		}
		return haofangMoney;
	}
	

	/**
	 * 扣费时查询用户是否有足够的现金
	 * @author ZangTie
	 * @since 2018年7月20日 下午2:58:31
	 * @param uaId=个人资金账户
	 * @param compUaId=公司资金账户
	 * @param biddPrice=竞价金额  当次用户竞价的价格，小于 0 则说明是 已经超过了公司指定的个人使用的资金范围
	 * @param compLimitPrice=公司指定的个人使用的资金范围
	 * @return
	 * Modified XXX ZangTie 2018年7月20日
	 */
	private Map<String, String> queryMoneyIsEnoughConfirm(String uaId, String compUaId, String biddPrice, String compLimitPrice){
		// AVAILABLE_DATE的格式为：2014-01-01 ，判断一天的结束是：2014-01-02 00:00:00 ,在当天范围内
		// 为：1 否则为：2
		// 先查询个人资金账户的一个使用公司金额的情况
		Map<String, Object> userRes = adminFunUserAccountMapper.queryMoneyIsEnough(compLimitPrice, uaId);
		// 查询用户的现金是否足够
		String usermoney = "0";
		String compmoney = "0";
		double priceRs = -1.0d;// 该数据小于0，则说明使用公司资金已经超额。
		String avaDateFlag = "2"; // 1 说明是在当天时间范围内 2 说明当天是第一次竞价扣费

		usermoney = userRes.get("HAOFANG_AMOUNT").toString();
		usermoney = "".equals(usermoney) ? "0" : usermoney;
		double haofangBuy = Double.parseDouble(NumberHelper.formatNumber(userRes.get("HAOFANG_BUY").toString(), NumberHelper.NUMBER_IN_2));// 好房币加优惠券
		if(haofangBuy < 0){
			usermoney = String.valueOf(Double.parseDouble(usermoney) - haofangBuy);
		}

		String priceRsTmp = userRes.get("PRICE_RS")+"";
		if (!"".equals(priceRsTmp)) {
			priceRs = Double.parseDouble(priceRsTmp);
		}
		avaDateFlag = userRes.get("AVA_DATE_FLAG").toString();// =1 说明是在当天时间范围内
		// 现在判断纯精英版才不能使用公司账户，精英版登录也可以用公司账户（20180117大白）
		if (StringUtils.isNotBlank(compUaId) && !"0".equals(compUaId)) {// 这里判断是否是精英版，用于代码统一
			// 公司的资金金额
			Map<String, Object> compRes = adminFunUserAccountMapper.queryMoneyIsEnough(compLimitPrice, compUaId);
			compmoney = compRes.get("HAOFANG_AMOUNT").toString();
			compmoney = "".equals(compmoney) ? "0" : compmoney;
			// 接口不一致开始
			if("2".equals(avaDateFlag)){
				priceRs = Double.parseDouble(compLimitPrice);
			}
		}
		double biddingAmount = 0.0d;
		if (Double.parseDouble(compLimitPrice) <= 0 || priceRs <= 0) {
			biddingAmount = Double.parseDouble(usermoney);
		} else {
			biddingAmount = NumberHelper.add(Double.parseDouble(usermoney), priceRs);
		}
		double tempPrice = Double.parseDouble(biddPrice);
		if (biddingAmount < tempPrice) {
			throw new BusinessException("没有足够的金额用于竞价！", Constants_DIC.ERROR_CODE_BALANCE_LACK);
		}
		// 接口不一致结束
		Map<String, String> mapTmp = new HashMap<>();
		// 查询消费成功后对用户账号进行扣费.
		if (!"".equals(usermoney) && !"".equals(biddPrice)) {
			if (("1".equals(avaDateFlag) && priceRs >= 0)) {// 当天没有使用过公司的资金账户，或者
				// 如果使用判断是否超过限额，
				// 都进入公司资金账户金额判断
				if (Double.parseDouble(compmoney) >= Double
						.parseDouble(biddPrice)) {// 公司余额足以支付
					mapTmp.put("COMP_PRICE_FLAG", "1");// 个人使用公司资金账户还足以支付
					mapTmp.put("SELF_PRICE_FLAG", "0");// 不需要个人支付金额
				} else if (Double.parseDouble(compmoney) > 0
						&& Double.parseDouble(compmoney) < Double
						.parseDouble(biddPrice)) {
					mapTmp.put("COMP_PRICE_FLAG", "1");// 个人使用公司资金账户还足以支付部分
					mapTmp.put("SELF_PRICE_FLAG", "1");// 需要个人支付金额
				} else {
					mapTmp.put("COMP_PRICE_FLAG", "0");// 个人使用公司资金账户还足以支付
					if (Double.parseDouble(usermoney) >= Double
							.parseDouble(biddPrice)) {
						mapTmp.put("SELF_PRICE_FLAG", "1");
					} else {
						mapTmp.put("SELF_PRICE_FLAG", "0");// 个人的金额不足以支付
					}
				}
			} else {
				mapTmp.put("COMP_PRICE_FLAG", "0");// 个人使用公司资金账户还足以支付
				if (Double.parseDouble(usermoney) >= Double.parseDouble(biddPrice)) {
					mapTmp.put("SELF_PRICE_FLAG", "1");
				} else {
					mapTmp.put("SELF_PRICE_FLAG", "0");// 个人的金额不足以支付
				}
			}

			if ("2".equals(avaDateFlag)) {
				priceRs = Double.parseDouble(compLimitPrice);
				mapTmp.put("COMP_PRICE_FLAG", "1");// 公司资金账户还足以支付
			}
			mapTmp.put("USED_COMP_HF", priceRs + "");// 用户当天还可以使用公司账户金额支付的额度，用于扣费
			mapTmp.put("AVA_DATE_FLAG", avaDateFlag);// 为2说明不是在当天使用
			mapTmp.put("COMP_AMOUNT", compmoney);
		}
		return mapTmp;
	}

	@Transactional
	@Override
	public void createByCreateUser(ErpFunUsers erpFunUsers) {
		AdminFunUserAccount funUserAccount = adminFunUserAccountMapper.selectByUserMoblie(erpFunUsers.getUserMobile());
		if(funUserAccount != null) {
			return;
		}
		Integer uaId = createUa(erpFunUsers.getUserMobile(), erpFunUsers.getCityId(), erpFunUsers.getArchiveId());
		adminFunArchiveService.updateUaIdBycreateUser(uaId, erpFunUsers.getArchiveId(), erpFunUsers.getUserMobile(), erpFunUsers.getUserName());
	}

	// 新建资金账户
	private Integer createUa(String mobile, Short cityId, Integer archiveId) {
//		String totleAmount = adminSysParaService.getSysParamToString("GIVE_HAOFANG_QUAN_NUM");
//		if (StringUtils.isBlank(totleAmount)) {
//			totleAmount = "0";// 如果失败了给个默认，现在送200优惠券2016-10-21
//		}
		String totleAmount = "0";
		// 判断是否已经赠送过优惠券
//		AdminFunPaidExample example = new AdminFunPaidExample();
//		example.createCriteria().andDescEqualTo("首次注册经纪人赠送")
//		.andArchiveIdEqualTo(archiveId)
//		.andPaidTypeEqualTo("SRV_QUAN");
//		int countByExample = adminFunPaidMapper.countByExample(example);
//		if (countByExample > 0) {
//			totleAmount = "0";
//		}
		BigDecimal bigTotleAmount = new BigDecimal(totleAmount);
		AdminFunUserAccount record = new AdminFunUserAccount();
		record.setUserMobile(mobile);
		record.setEnable(true);
		record.setAmount(BigDecimal.ZERO);
		record.setConsumpt(BigDecimal.ZERO);
		record.setScores(0);
		record.setCityId(cityId);
		record.setUaType((byte)2);
		// 新建资金账户，默认赠送优惠券2016-09-20
		record.setHaofangAmount(BigDecimal.ZERO);
		record.setHighAmount(new BigDecimal(2));
		record.setAmountSmslock(BigDecimal.ZERO);
		record.setBalance(BigDecimal.ZERO);
		record.setUsedCompHf(BigDecimal.ZERO);
		record.setHaofangAmountTicket(BigDecimal.ZERO);
		int count = adminFunUserAccountMapper.insertSelective(record);
//		if (countByExample == 0) {
//			Double parseDouble = StringUtil.parseDouble(totleAmount, 0.0);
//			// 写收入记录
//			AdminFunPaid funPaidPO = new AdminFunPaid();
//			funPaidPO.setAmount(parseDouble);
//			funPaidPO.setAmountAfter(parseDouble);
//			funPaidPO.setAmountBefore(0.0);
//			funPaidPO.setAmountQuan(parseDouble);
//			funPaidPO.setArchiveId(archiveId);
//			funPaidPO.setUaId(record.getUaId());
//			funPaidPO.setCityId(cityId);
//			funPaidPO.setPaidType("SRV_QUAN");
//			funPaidPO.setPaidCatigory("GIFT");
//			funPaidPO.setDesc("首次注册经纪人赠送");
//			funPaidPO.setPadiTime(new Date());
//			adminFunPaidMapper.insertSelective(funPaidPO);
//		}
		return record.getUaId();
	}

	@Override
	public String getAvailableShareMoney(Integer archiveId) {
		String useShareMoney = "0";
		try {
			Map<String, String> map = new HashMap<>();
			map.put("archiveId", archiveId.toString());
			map.put("queryUseShareMonye", "1");
			String result = HttpUtil.post(AppConfig.getAdminProjectDomain() + "lookShareTrueHouse/getMoneyInfo", map);
			JSONObject shareMoneyObject = JSONObject.parseObject(result);
			JSONObject dataObject = shareMoneyObject.getJSONObject("data");
			if (dataObject.getString("useShareMoney") != null) {
				useShareMoney = dataObject.getString("useShareMoney");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return "1000";
		return useShareMoney;
	}

}
