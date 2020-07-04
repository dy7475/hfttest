package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.param.VStoreEntrustParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.managecenter.vstore.param.GetEmployeeDynamicsListParam;
import com.myfun.erpWeb.managecenter.vstore.param.GetVStoreEntrustListParam;
import com.myfun.repository.agencydb.dto.AgencyWfPushLogDto;
import com.myfun.repository.agencydb.dto.EntrustCountDto;
import com.myfun.repository.agencydb.po.AgencyWfPushLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfPushLogMapper extends BaseMapper<AgencyWfPushLog, Integer> {
	/**
	 * 我的委托列表 查询委托记录关联的推荐信�?
	 * @author 陈文�?
	 * @date 2016�?6�?20�? 下午7:50:45
	 */
	public List<EntrustCountDto> getEntrustCountInfo(@Param("cityId")Integer cityId, @Param("wxId")Integer wxId) throws Exception;
	/**
	 * 委托列表详情
	 * @author 何传�?
	 * @since 2017�?8�?17�?
	 * @param param
	 * @return
	 */
	public List<AgencyWfPushLogDto> getWfPushLogList(@Param("param") GetVStoreEntrustListParam param);
	public List<AgencyWfPushLog> getWfPushLogInfo(@Param("caseId") String caseId);
	
	public  List<AgencyWfPushLogDto> getWfPushLogListByDeptId(@Param("param") GetEmployeeDynamicsListParam param);
	public  int getCountOffWfPushLogListByDeptId(@Param("param") GetEmployeeDynamicsListParam param);

	List<AgencyWfPushLog> getWfPushLogByIds(@Param("wfIds") List<Integer> wfIds);

}