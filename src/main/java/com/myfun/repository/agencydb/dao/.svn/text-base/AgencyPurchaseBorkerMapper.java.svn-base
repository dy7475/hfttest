package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyPurchaseBorker;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyPurchaseBorkerMapper extends BaseMapper<AgencyPurchaseBorker, Integer> {
	/**
	 * 统计是否支付
	 * @param agencyPurchaseBorker
	 * @return
	 */
	public int count(AgencyPurchaseBorker agencyPurchaseBorker);
	
	/**
	 * 更新购买表上架标记(恢复400白名单上线)
	 * @param record
	 * @return
	 */
	public int updatePbFlagAndIsUsed(AgencyPurchaseBorker record);
	
	/**
	 * 获取经纪人列表
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @return
	 */
	public List<AgencyPurchaseBorker> getPurchaseList(@Param("cityId")String cityId, @Param("caseId")Integer caseId,
			@Param("caseType")String caseType);
	
	/**
	 * 获取经纪人数据
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @param archiveId
	 * @return
	 */
	public AgencyPurchaseBorker getPurchaseBorker(@Param("cityId")int cityId, @Param("caseId")Integer caseId,
			@Param("caseType")String caseType,@Param("archiveId") int archiveId);
	
	/**
	 * 查看搜搜电话修改
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param buyPrice
	 * @param caseId
	 * @param caseType
	 * @param cityId
	 * @param archiveId
	 */
	public void procPurchaseVipinfo(AgencyPurchaseBorker borker);
}