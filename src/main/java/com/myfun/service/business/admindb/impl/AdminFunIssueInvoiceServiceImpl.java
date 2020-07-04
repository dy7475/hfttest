package com.myfun.service.business.admindb.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import com.myfun.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.erpWeb.usercenter.param.DelFunInvoiceEnclosureParam;
import com.myfun.erpWeb.usercenter.vo.ApplyIssueInvoiceVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunInvoiceEnclosureMapper;
import com.myfun.repository.admindb.dao.AdminFunIssueInvoiceMapper;
import com.myfun.repository.admindb.dao.AdminFunPaidInvoicerelativeMapper;
import com.myfun.repository.admindb.dao.AdminFunPaidMapper;
import com.myfun.repository.admindb.dto.AdminFunIssueInvoiceDto;
import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosure;
import com.myfun.repository.admindb.po.AdminFunIssueInvoice;
import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.repository.admindb.po.AdminFunPaidExample;
import com.myfun.repository.admindb.po.AdminFunPaidInvoicerelative;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunInvoiceEnclosureService;
import com.myfun.service.business.admindb.AdminFunIssueInvoiceService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
@Service
public class AdminFunIssueInvoiceServiceImpl extends AbstractService< AdminFunIssueInvoice, Integer> implements AdminFunIssueInvoiceService{
	@Autowired private AdminFunIssueInvoiceMapper adminFunIssueInvoiceMapper;
	@Autowired private AdminFunInvoiceEnclosureService adminFunInvoiceEnclosureService; 
	@Autowired private AdminFunPaidMapper adminFunPaidMapper;
	@Autowired private AdminSysParaService adminSysParaService;
	@Autowired private AdminFunInvoiceEnclosureMapper adminFunInvoiceEnclosureMapper;
	@Autowired private AdminFunPaidInvoicerelativeMapper adminFunPaidInvoicerelativeMapper;
	
	private Object service;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunIssueInvoiceMapper;
	}
	
	@Override
	@AccessReadonlyDb
	public List<AdminFunIssueInvoiceDto> getInvoiceDetail(Integer invoiceId) {
		BaseMap baseMap = new BaseMap();
		baseMap.put("invoiceId", invoiceId);
		return adminFunIssueInvoiceMapper.getInvoiceDetail(baseMap);
	}

	/**
	 * @tag 检查发票的数量
	 * @author 邓永洪
	 * @since 2018/5/25
	 */
	@Override
	public List<ApplyIssueInvoiceVo> checkInvoiceCount() {
		List<ApplyIssueInvoiceVo> list = new ArrayList<ApplyIssueInvoiceVo>();
		ApplyIssueInvoiceVo applyIssueInvoiceVo = new ApplyIssueInvoiceVo();
		list.add(applyIssueInvoiceVo);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH,-1);
		String endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		String aduitDate=DateTimeHelper.formatDateTimetoString(calendar.getTime());
		int currentMonthCount = adminFunIssueInvoiceMapper.countEffectiveInvoice(startTime,endTime,aduitDate);

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, 1);
		startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH,-1);
		endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		String sysCount = adminSysParaService.getSysParamToString("PERMONTH_INVOICECOUNT");
		applyIssueInvoiceVo.setMonthCount(sysCount);
		if(currentMonthCount<StringUtil.paseInteger(sysCount, 0)){
			applyIssueInvoiceVo.setFlag("0");
		}else{
			int nextMonthCount = adminFunIssueInvoiceMapper.countEffectiveInvoice(startTime,endTime,aduitDate);
			if(nextMonthCount<StringUtil.paseInteger(sysCount, 0)){
				applyIssueInvoiceVo.setFlag("1");
			}else{
				applyIssueInvoiceVo.setFlag("2");
			}
		}
		return list;
	}

	@Transactional
	@Override
	public List<ApplyIssueInvoiceVo> addIssueInvoice(@Valid AddOrUpdateIssueInvoiceParam param) {
		String paidId = param.getPaidId();
		String[] paidIds = paidId.split(",");
		List<Integer> paidIdList = new ArrayList<Integer>();
		if (paidIds.length > 1) {
			for (int i = 0; i < paidIds.length; i++) {
				paidIdList.add(Integer.parseInt(paidIds[i]));
			}
			Map<String, Integer> deptAndVipcountByPaidMap = adminFunPaidMapper.getDeptAndVipcountByPaid(paidIdList);
			if (deptAndVipcountByPaidMap != null) {
				Integer deptCount = deptAndVipcountByPaidMap.get("deptcount");
				Integer vipCount = deptAndVipcountByPaidMap.get("vipcount");
				if (deptCount > 0 && vipCount > 0) {
					throw new BusinessException("VIP和门店消费不可组合开具");
				}
			}
		}else {
			paidIdList.add(Integer.parseInt(paidIds[0]));
		}
		AdminFunPaidExample adminFunPaidExample = new AdminFunPaidExample();
		adminFunPaidExample.createCriteria().andPaidIdIn(paidIdList);
		List<AdminFunPaid> paidList = adminFunPaidMapper.selectByExample(adminFunPaidExample);
		Byte invoiceType = param.getInvoiceType();
		String invoiceTypeName = Byte.valueOf("2").equals(invoiceType) ? "收据":"发票";
		if(!(paidList.size() == paidIds.length)){
			throw new BusinessException("没有找到该交易信息");
		}
		
		for (AdminFunPaid funPaid:paidList) {
			if (!isCanIssueInvoiceType(funPaid.getPaidType(), DateTimeHelper.formatDateTimetoString(funPaid.getPadiTime()))) {
				throw new BusinessException("此交易类型不支持开具" + invoiceTypeName);
			}
			if (!param.isGeneralManager() && !StringUtil.toString(param.getUaid()).equals(StringUtil.toString(funPaid.getUaId()))) {
				throw new BusinessException("只能开具自己消费的" + invoiceTypeName);
			}
			List<Byte> invoiceTypes = new ArrayList<Byte>();
			//判断是否是收据类型
			if (Byte.valueOf("2").equals(invoiceType)) {
				invoiceTypes.add(Byte.valueOf("2"));
			} else {
				// 查询发票
				invoiceTypes.add(Byte.valueOf("0"));
				invoiceTypes.add(Byte.valueOf("1"));
			}
			
			Integer invoiceCount = adminFunIssueInvoiceMapper.getInvoiceCount(funPaid.getPaidId(), invoiceTypes);
			if (invoiceCount > 0) {
				throw new BusinessException("此订单" + invoiceTypeName + "已开具，不能再次提交申请");
			}
		}
		
		List<ApplyIssueInvoiceVo> list = new ArrayList<ApplyIssueInvoiceVo>();
		ApplyIssueInvoiceVo applyIssueInvoiceVo = new ApplyIssueInvoiceVo();
		AdminFunIssueInvoice adminFunIssueInvoice = new AdminFunIssueInvoice();
		list.add(applyIssueInvoiceVo);
		BeanUtils.copyProperties(param, adminFunIssueInvoice);
		if (!Objects.equals(Byte.valueOf("2"), invoiceType)) {
			applyIssueInvoiceVo = checkInvoiceCount().get(0);
			adminFunIssueInvoice.setInvoiceStatus((byte)Const.DIC_INVOICE_STATUS_6);
			//根据申请月份标志再做一次校验
			boolean flag = countCurrentMonthInvoiceCounts(param.getMonthFlag(), adminFunIssueInvoice, applyIssueInvoiceVo);
			if (flag) {
				//如果可以开，则发票状态为待审核
				adminFunIssueInvoice.setInvoiceStatus((byte)Const.DIC_INVOICE_STATUS_0);
			}
		} else {
			adminFunIssueInvoice.setInvoiceStatus((byte)Const.DIC_INVOICE_STATUS_0);
			applyIssueInvoiceVo.setFlag("0");
		}
		
		Double amount = adminFunPaidMapper.getAmountByPaidId(paidIdList);
		if(null != amount) {
			adminFunIssueInvoice.setCityId(param.getCityId());
			adminFunIssueInvoice.setArchiveId(param.getArchiveId());
			adminFunIssueInvoice.setCompNo(param.getCompNo());
			adminFunIssueInvoice.setDeptNo(param.getDeptNo());
			adminFunIssueInvoice.setCreationTime(new Date());
			adminFunIssueInvoice.setConsumptionAmount(new BigDecimal(amount));
			adminFunIssueInvoice.setApplyUid(param.getUserId());
			adminFunIssueInvoice.setApplyName(param.getUserName());
			adminFunIssueInvoiceMapper.insertSelective(adminFunIssueInvoice);
			applyIssueInvoiceVo.setInvoiceId(adminFunIssueInvoice.getInvoiceId());
			
			// 判断是否是收据类型，如果是收据类型，那么就更新FUN_PAID表，已经开了收据了
			for (Integer paid:paidIdList) {
				AdminFunPaidInvoicerelative adminFunPaidInvoicerelative = new AdminFunPaidInvoicerelative();
				adminFunPaidInvoicerelative.setPaidId(paid);
				adminFunPaidInvoicerelative.setInvoiceId(adminFunIssueInvoice.getInvoiceId());
				adminFunPaidInvoicerelativeMapper.insertSelective(adminFunPaidInvoicerelative);
			}
			if (Objects.equals(Byte.valueOf("2"), adminFunIssueInvoice.getInvoiceType())) {
				AdminFunPaidExample adminFunPaidExampleTwo = new AdminFunPaidExample();
				adminFunPaidExampleTwo.createCriteria().andPaidIdIn(paidIdList);
				AdminFunPaid adminFunPaid = new AdminFunPaid();
				adminFunPaid.setHasReceipt(Byte.valueOf("1"));
				adminFunPaidMapper.updateByExampleSelective(adminFunPaid, adminFunPaidExampleTwo);
			} else {
				// 判断是否是收据类型
				Integer invoiceCount = adminFunIssueInvoiceMapper.getInvoiceCountByOneType(paidIdList);
				if (invoiceCount > 0) {
					AdminFunPaidExample adminFunPaidExampleThree = new AdminFunPaidExample();
					adminFunPaidExampleThree.createCriteria().andPaidIdIn(paidIdList);
					AdminFunPaid adminFunPaid = new AdminFunPaid();
					adminFunPaid.setHasReceipt(Byte.valueOf("2"));
					adminFunPaidMapper.updateByExampleSelective(adminFunPaid, adminFunPaidExampleThree);
				}
			}
			if(StringUtil.isNotBlank(param.getEsList())) {
				adminFunInvoiceEnclosureService.conectInvoiceId(adminFunIssueInvoice.getInvoiceId(), param.getEsList(), param);
			}
		}
		return list;
	}
	
	private boolean countCurrentMonthInvoiceCounts(String monthFlag, AdminFunIssueInvoice funIssueInvoicePO, ApplyIssueInvoiceVo applyIssueInvoiceVo) {
		if (StringUtil.isBlank(monthFlag)) {
			throw new BusinessException("MONTH_FLAG为必传参数！");
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String applyTime = null;
		boolean currentMonthFlag = "0".equals(monthFlag);//是否是当月 
		//如果是当月，则申请时间就是当月
		if(currentMonthFlag){
			applyTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		}
		String endTime = applyTime;
		//否则申请时间是下月
		if(!currentMonthFlag){
			calendar.add(Calendar.MONTH, 1);
			applyTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		}
		funIssueInvoicePO.setApplyTime(DateTimeHelper.parseToDate(applyTime));
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH,-1);
		endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		Calendar aduitDate = Calendar.getInstance();// 计算3天前的时间,方便查询在3天内重新提交的
		aduitDate.add(Calendar.DAY_OF_MONTH, -3);
		String aduitDateStr=DateTimeHelper.formatDateTimetoString(aduitDate.getTime());
		int count = adminFunIssueInvoiceMapper.countEffectiveInvoice(applyTime, endTime, aduitDateStr);
		String sysCount = adminSysParaService.getSysParamToString("PERMONTH_INVOICECOUNT");
		applyIssueInvoiceVo.setMonthCount(sysCount);
		if (currentMonthFlag) {
			if (count < StringUtil.paseInteger(sysCount, 0)) {
				applyIssueInvoiceVo.setFlag("0");
				return true;
			} else {
				applyIssueInvoiceVo.setFlag("1");
				return false;
			}
		} else {
			if (count < StringUtil.paseInteger(sysCount, 0)) {
				applyIssueInvoiceVo.setFlag("0");
				return true;
			} else {
				applyIssueInvoiceVo.setFlag("2");
				return false;
			}
		}
		
	}
	/**
	 * 是否可以开具发票判断
	 * @author flj
	 * @since 2017年4月22日
	 * @param paidType
	 * 软件购买：BUYDEPT
	 * OTO续费：O2O
	 * VIP购买：SRV_SUPER  SRV--待问
	 * 白金会员：UPGRADE_SRV
	 * 软件升级：UPGRADE_SRV
	 * 企业微店购买：PAY_WEIXIN
	 * @return
	 */
	public static boolean isCanIssueInvoiceType(String paidType, String paidTime)  {
		/*
			根据当前月份判断padiTime时间范围
			1.1月1日（含1日）~10月31日（含31日）内的发票为当年开具。
			2.11月1日（含1日）~12月31日（含31日）内的发票最晚在次年3月1日（不含1日）前开具
			int paidMonth = DateUtil.getMonth(DateTimeHelper.parseToDate(paidTime));
			int paidYear = DateUtil.getYear(DateTimeHelper.parseToDate(paidTime));
			int month = Calendar.getInstance().get(Calendar.MONTH)+1;
			int year = Calendar.getInstance().get(Calendar.YEAR);
			if (paidMonth > 10 && year <= paidYear + 1 && month < 3) {
				return StringUtil.contains(paidType, new String[]{
						"O2O","UPGRADE_SRV","PAY_WEIXIN","PAY_WEIXIN","BUYDEPT","SRV","DEPT_RENT"// 新加了 "DEPT_RENT"
				});
			}else if(year == paidYear){
				return StringUtil.contains(paidType, new String[]{
						"O2O","UPGRADE_SRV","PAY_WEIXIN","PAY_WEIXIN","BUYDEPT","SRV","DEPT_RENT"// 新加了 "DEPT_RENT"
				});
			}
		 */
		
		/**
		 * 开发票时间为改为消费后一年内均可开具发票
		 */
		Date canIssueInvoiceDate = DateTimeHelper.addYears(new Date(), -1);
		Date paidDate = DateTimeHelper.parseToDate(paidTime);
        int compareTwoDate = DateTimeHelper.compareTwoDate(canIssueInvoiceDate, paidDate);  //如果时间d1在d2之前，返回1,
        if(compareTwoDate == 1){
			return StringUtil.contains(paidType, new String[]{
					"O2O","UPGRADE_SRV","PAY_WEIXIN","PAY_WEIXIN","BUYDEPT","SRV","DEPT_RENT"// 新加了 "DEPT_RENT"
			});
        }
		return false;
	}
	
	@Override
	public void delIssueInvoice(DelFunInvoiceEnclosureParam param) {
		Integer esId = param.getEsId();
		if (esId > 0) {
			AdminFunInvoiceEnclosure adminFunInvoiceEnclosure = new AdminFunInvoiceEnclosure();
			adminFunInvoiceEnclosure.setEsId(esId);
			adminFunInvoiceEnclosure.setEsStatus(Byte.valueOf("0"));
			adminFunInvoiceEnclosureMapper.updateByPrimaryKeySelective(adminFunInvoiceEnclosure);
		}
	}

	@Transactional
	@Override
	public List<ApplyIssueInvoiceVo> editIssueInvoice(AddOrUpdateIssueInvoiceParam param) {
		AdminFunIssueInvoice model = new AdminFunIssueInvoice();
		BeanUtils.copyProperties(param, model);
		AdminFunIssueInvoice latestModel = adminFunIssueInvoiceMapper.selectByPrimaryKey(param.getInvoiceId());
		String monthFlag = param.getMonthFlag();
		List<ApplyIssueInvoiceVo> list = new ArrayList<ApplyIssueInvoiceVo>();
		ApplyIssueInvoiceVo applyIssueInvoiceVo = new ApplyIssueInvoiceVo();
		list.add(applyIssueInvoiceVo);
		if (!Objects.equals(Byte.valueOf("2"), param.getInvoiceType())) {
			if (Byte.valueOf("1").equals(latestModel.getInvoiceStatus())) {
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_MONTH, -3);
				if (DateTimeHelper.compareTwoDate(latestModel.getAduitDate(), calendar.getTime()) > 0) {
					applyIssueInvoiceVo = checkInvoiceCount().get(0);
					Calendar applyCalendar = Calendar.getInstance();
					applyCalendar.set(Calendar.DAY_OF_MONTH, 1);
					//如果当月可以 FLAG 0代表当月可用，1代表下月可用，2代表都不可用
					if ("0".equals(applyIssueInvoiceVo.getFlag())) {
						model.setInvoiceStatus(Byte.valueOf(Constants_DIC.DIC_INVOICE_STATUS_0));
						model.setApplyTime(DateTimeHelper.parseToDate(DateTimeHelper
								.formatDateTimetoString(applyCalendar.getTime(), DateTimeHelper.FMT_yyyyMMdd)));
						applyIssueInvoiceVo.setFlag("0");
					} else if ("1".equals(applyIssueInvoiceVo.getFlag())) {
						applyCalendar.add(Calendar.MONTH, 1);
						model.setInvoiceStatus(Byte.valueOf(Constants_DIC.DIC_INVOICE_STATUS_0));
						model.setApplyTime(DateTimeHelper.parseToDate(DateTimeHelper
								.formatDateTimetoString(applyCalendar.getTime(), DateTimeHelper.FMT_yyyyMMdd)));
						applyIssueInvoiceVo.setFlag("0");
					} else {
						applyIssueInvoiceVo.setFlag("2");
					}
					adminFunIssueInvoiceMapper.updateByPrimaryKeySelective(model);
					return list;
				} else {
					model.setInvoiceStatus(Byte.valueOf(Constants_DIC.DIC_INVOICE_STATUS_0));
					adminFunIssueInvoiceMapper.updateByPrimaryKeySelective(model);
					applyIssueInvoiceVo.setFlag("0");
				}
			} else {
				if (countCurrentMonthInvoiceCounts(monthFlag, model, applyIssueInvoiceVo)) {
					model.setInvoiceStatus(Byte.valueOf(Constants_DIC.DIC_INVOICE_STATUS_0));
					adminFunIssueInvoiceMapper.updateByPrimaryKeySelective(model);
				}
			}
		} else {
			model.setInvoiceStatus(Byte.valueOf(Constants_DIC.DIC_INVOICE_STATUS_0));
			adminFunIssueInvoiceMapper.updateByPrimaryKeySelective(model);
			applyIssueInvoiceVo.setFlag("0");
		}
		return list;
	}

	@Override
	public ApplyIssueInvoiceVo applyIssueInvoice(AddOrUpdateIssueInvoiceParam param) {
		AdminFunIssueInvoice model =new AdminFunIssueInvoice();
		model.setInvoiceId(param.getInvoiceId());
		ApplyIssueInvoiceVo applyIssueInvoiceVo = new ApplyIssueInvoiceVo();
	
		if(countCurrentMonthInvoiceCounts("1",model,applyIssueInvoiceVo)){
			model.setInvoiceStatus(Byte.valueOf(Constants_DIC.DIC_INVOICE_STATUS_0));
			model.setFailureCause("null");
			adminFunIssueInvoiceMapper.updateByPrimaryKeySelective(model);
		}
		return applyIssueInvoiceVo;
	}
}
