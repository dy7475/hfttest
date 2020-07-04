package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyCommisionDto;
import com.myfun.repository.agencydb.dto.AgencyFunCustCountDto;
import com.myfun.repository.agencydb.dto.AgencyFunCustDto;
import com.myfun.repository.agencydb.param.AgencyFunCustParam;
import com.myfun.repository.agencydb.po.AgencyCommisionParam;
import com.myfun.repository.agencydb.po.AgencyFunCust;
import com.myfun.repository.agencydb.po.AgencyFunCustKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunCustMapper extends BaseMapper<AgencyFunCust, AgencyFunCustKey> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyFunCust record);

  //脱离门店版 将联动分销数据移交给总经理
	int updateByArchiveId(Map<String, Object> agencyMap);
	
	/**
	 * 获取客户
	 * @param custId
	 * @return
	 */
	AgencyFunCust getRecord(String custId);

	List<AgencyFunCustDto> getFunCustList(AgencyFunCustParam agencyFunCustParam);
	
	/**
	 * 获取佣金管理列表
	 * @param agencyCommisionParam
	 * @return
	 */
	List<AgencyCommisionDto> getCommisionList(AgencyCommisionParam agencyCommisionParam);

	AgencyFunCustCountDto getFunCustCount(Map<String, Object> paramMap);

	AgencyFunCustCountDto getFunCustCountWithTime(Map<String, Object> paramMap);
	
	/**
	 * 获取佣金详细
	 * @param cityId
	 * @param custId
	 * @return
	 */
	AgencyFunCustDto getCommisionView(@Param("cityId")String cityId, @Param("custId")String custId);
	
	/**
	 * 更新带看与成交数
	 * @param buildId
	 * @param cityId
	 */
	void updateNum(@Param("buildId")Integer buildId, @Param("cityId")Integer cityId);
	
	/**
	 * 修改数量
	 * @param buildId
	 * @param cityId
	 */
	void updateDealNUm(@Param("buildId")Integer buildId, @Param("cityId")Integer cityId);
	
	/**
	 * 修改记录
	 * @param up
	 */
	void update(AgencyFunCust up);
	
	/**
	 * 统计楼盘电话号码是否被查看过
	 * @param custMobile
	 * @param buildId
	 * @return
	 */
	int count(@Param("custMobile")String custMobile, @Param("buildId")Integer buildId);
	
	/**
	 * 查询客户列表
	 * @param bCityId
	 * @param buildId
	 * @param custId
	 * @param flag
	 * @param custMobile
	 * @param _custmobile
	 * @return
	 */
	List<AgencyFunCust> getRecords(@Param("bCityId")short bCityId, @Param("buildId")Integer buildId, @Param("custId")String custId,
			@Param("flag")String flag, @Param("custMobile")String custMobile,
			@Param("_custmobile")String _custmobile);
	
	/**
	 * 修改状态
	 * @param bCityId
	 * @param buildId
	 * @param custId
	 * @param flag
	 * @param custMobile
	 * @param _custmobile
	 */
	void updateCustStatus(@Param("bCityId")short bCityId, @Param("buildId")Integer buildId, @Param("custId")String custId,
			@Param("flag")String flag, @Param("custMobile")String custMobile,
			@Param("_custmobile")String _custmobile);

	/**
	 * @TODO 新房联动->我的客户数据
	 * @author lcb
	 * @2016-8-31 下午6:20:43
	 */
	Map<String, String> getDistCountCustInfo(Integer archiveId);

	/**
	 * @TODO 新房联动->查询成交数
	 * @author lcb
	 * @2016-9-1 下午2:18:38
	 */
	Integer getSuccessCount(Integer archiveId);

	/**
	 * @TODO 新房联动
	 * @author lcb
	 * @2016-9-2 上午10:32:30
	 */
	Map<String, Object> getCountCustInfo(Integer countPersonNum);

	List<Map<String, String>> getDistCountOfferToBuy(@Param("archiveId")Integer archiveId, @Param("startTime")String startTime, @Param("endTime")String endTime);

	List<AgencyFunCustDto> getAgencyFunCustList(Map<String, Object> pMap);

	Integer updateColumn(Map<String, Object> pMap);

	Integer updateFunCustByCondition(Map<String, Object> map);

	void updateFuncustArchiveId(Map<String, Object> pMap);

	List<AgencyFunCust> getDistFunCustTrackList(Map<String, Object> pMap);

	AgencyFunCustDto getFunCustDetail(Map<String, Object> pMap);

	List<Map<String, String>> getBorkerCount(Map<String, Object> pMap);

	List<Map<String, String>> getFinishedFee(Map<String, Object> pMap);

	Integer countMobile(Map<String, Object> pMap);

	Integer countModelData(Map<String, Object> pMap);

	AgencyFunCustDto getDistCustInfo(Map<String, Object> pMap);
	
	/**
	 * 获取分销客户数量
	 * @author 张宏利
	 * @since 2018年1月30日
	 * @param cityId
	 * @param compId
	 * @param archiveId
	 * @return
	 */
	Integer getCustCount(@Param("cityId") Integer cityId, @Param("compId") Integer compId, @Param("archiveId") Integer archiveId);

}