package com.myfun.service.business.admindb;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.usercenter.param.CashRecordParam;
import com.myfun.erpWeb.usercenter.param.GetPaidListParam;
import com.myfun.erpWeb.usercenter.vo.AdminFunPaidVo;
import com.myfun.repository.admindb.dto.AdminFunPaidDto;
import com.myfun.repository.admindb.param.AdminPaidCountParam;
import com.myfun.repository.admindb.po.AdminFunPaid;
import com.myfun.repository.admindb.po.AdminFunPaidKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface AdminFunPaidService extends BaseMapper<AdminFunPaid, AdminFunPaidKey> {

	/**
	 * ERP、CRM查询统计
	 * @param faaType
	 * @param adminPaidCountParam
	 * @param currentPage
	 * @param paidSource
	 * @return
	 */
	List<AdminFunPaidDto> selectByTypeAndOther(AdminPaidCountParam adminPaidCountParam, String paidSource);
	
	/**
	 * 
	 * @param archiveId
	 * @return
	 */
	List<AdminFunPaid> getFunPaidByArchiveId(Integer archiveId);

	PageInfo<AdminFunPaidVo> getPaidList(GetPaidListParam param);

	PageInfo<AdminFunPaidVo> getCashRecordList(CashRecordParam param);

	PageInfo<AdminFunPaidVo> getHfCoinRecordList(CashRecordParam param);
	
	PageInfo<AdminFunPaidVo> getTrueHouseLightRecordList(CashRecordParam param);
	
	PageInfo<AdminFunPaidVo> getBrokerInvitePrizeRecordList(CashRecordParam param);

	PageInfo<AdminFunPaidVo> getO2ORecordList(CashRecordParam param);
	
	PageInfo<AdminFunPaidVo> getSRVRecordList(CashRecordParam param);
	/***
	 * 门店达到3人送40元钱
	 * @author 尹振兴
	 * @since 2018年6月5日
	 * @param archiveId
	 */
	void peopleSaleGiftUserRight(Integer archiveId);
}
