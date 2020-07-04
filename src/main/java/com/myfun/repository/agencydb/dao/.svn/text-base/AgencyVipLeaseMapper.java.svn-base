package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyVipLeaseDto;
import com.myfun.repository.agencydb.param.AgencyVipLeaseParam;
import com.myfun.repository.agencydb.param.AgencyVipSaleParam;
import com.myfun.repository.agencydb.po.AgencyVipLease;
import com.myfun.repository.agencydb.po.AgencyVipLeaseKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.agencydb.po.AgencyVipLeaseExample;

public interface AgencyVipLeaseMapper extends BaseMapper<AgencyVipLease, AgencyVipLeaseKey> {
	/**
	 * 获取出租列表
	 * 
	 * @param vipLeaseParam
	 * @return
	 */
	public List<AgencyVipLeaseDto> getAgencyVipLeaseDtoList(AgencyVipLeaseParam vipLeaseParam);

	/**
	 * 获取主键ID
	 * 
	 * @return
	 */
	public Integer getId();

	/**
	 * 创建出租信息
	 * 
	 * @param vipLeaseParam
	 */
	public void createRecord(AgencyVipLeaseParam vipLeaseParam);

	/**
	 * 查询委托楼盘信息
	 * 
	 * @param vipSaleParam
	 * @return
	 */
	List<AgencyVipLease> getEntrustBuildList(AgencyVipSaleParam vipSaleParam);
	
	/**
	 * 登记房源是否重复
	 * @param agencyVipLease
	 * @return
	 */
	public int countHouse(AgencyVipLease agencyVipLease);
	
	/**
	 * 查询优优委托数据
	 * @author 陈文超
	 * @date 2016年6月17日 下午5:27:29
	 */
	List<AgencyVipLease> getYouYouEntrustInfoList(@Param("caseIds")List<Integer> caseIds,@Param("cityId")Short cityId) throws Exception;
	/**
	 * 获取出租房源信息
	 * @author 何传强
	 * @since 2017年8月22日
	 * @param caseId
	 * @param cityId
	 * @return
	 */
	public AgencyVipLeaseDto getvipLeaseDetail(@Param("caseId") String caseId, @Param("cityId") String cityId);
}