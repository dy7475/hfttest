package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminWeixinContract;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminWeixinContractMapper extends BaseMapper<AdminWeixinContract, Integer> {
	/**
	 *查询微信合同 
	 */
	AdminWeixinContract getRecordByCompId(Integer compId);
	
	/**
	 * 获得微信合同折扣和价格信?
	 * @param deptId
	 * @return
	 */
	AdminWeixinContract getRecordByWeiDeptId(Integer deptId);
	
	/**
	 * 根据公司修改微信合同
	 * @param weixin
	 */
	int updateByWeiCompId(AdminWeixinContract weixin);
	
	/**
	 * 统计该公司下微信合同的个?
	 * @param compId
	 * @return
	 */
	int countByWeixinCompId(String compId);

	/**
	 * 根据compId与contractStatus查询
	 * @param compId
	 * @param contractStatus
	 * @return
	 */
	AdminWeixinContract selectByCompIdAndstatus(@Param("compId") Integer compId, @Param("contractStatus") Integer contractStatus);

	/**
	 * 根据公司id删除微信合同
	 * @param compId
	 * @param notCompId
	 */
	void deleteByCompIdAndNoCompId(@Param("compId") Integer compId, @Param("notCompId") int notCompId);
}