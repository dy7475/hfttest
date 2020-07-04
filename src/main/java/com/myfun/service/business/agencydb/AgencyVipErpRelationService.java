package com.myfun.service.business.agencydb;

import com.myfun.repository.agencydb.po.AgencyVipErpRelation;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyVipErpRelationService extends BaseMapper<AgencyVipErpRelation, AgencyVipErpRelation> {

	/**
	 * 因为是从滴滴上转来的，大家的都是一套房源，有一套成交了，其他人拥有的就变为外成交
	 * @param caseId 房源ID
	 * @param caseType 房源类型
	 * @throws Exception
	 */
	public void creatDiDiHouseDealTrack(Integer cityId,Integer caseId, Byte caseType);

	/**
	 * 租转售或售转租时将关联表的记录变为失效
	 * @author 张宏利
	 * @since 2016年1月22日
	 */
	public void updateStautsByTransData(Integer cityId,Integer oldCaseId, Byte oldCaseType);
}
