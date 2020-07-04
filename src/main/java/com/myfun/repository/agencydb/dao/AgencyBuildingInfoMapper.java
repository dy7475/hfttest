package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.dto.AgencyBuildingInfoDto;
import com.myfun.repository.agencydb.param.AgencyBuildingInfoParam;
import com.myfun.repository.agencydb.po.AgencyBuildingInfo;
import com.myfun.repository.agencydb.po.AgencyBuildingInfoKey;
import com.myfun.repository.agencydb.po.AgencyBuildingInfoWithBLOBs;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AgencyBuildingInfoMapper extends BaseMapper<AgencyBuildingInfo, AgencyBuildingInfoKey> {
    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(AgencyBuildingInfoWithBLOBs record);

	List<AgencyBuildingInfoDto> getBuildingInfoList(AgencyBuildingInfoParam agencyBuildingInfoParam);

	Integer insertBuildInfo(AgencyBuildingInfo agencyBuildingInfo);

	Integer getMaxSeq(Map<String, Object> paramMap);

	Integer updateSeqAdd(Map<String, Object> paramMap);

	AgencyBuildingInfoDto getBuildingInfo(Map<String, Object> pMap);
	
	/**
	 * 获取楼盘名称
	 * @param cityId
	 * @param buildId
	 * @return
	 */
	AgencyBuildingInfo getBuildNameByCityIdAndBuildId(@Param("cityId")String cityId, @Param("buildId")String buildId);

	Integer updateSeqSubOne(Map<String, Object> paramMap);

	Integer updateSeqAddOne(Map<String, Object> paramMap);

	List<AgencyBuildingInfoDto> getDistBuildingList(Map<String, Object> pMap);

	List<AgencyBuildingInfo> getDistBuildByComp(Map<String, Object> pMap);

	/**
	 * @TODO 分销楼盘详情
	 * @author lcb
	 * @2016-9-24 下午4:02:42
	 */
	AgencyBuildingInfoDto getBuildInfoDetailed(Map<String, Object> pMap);

	List<AgencyBuildingInfoDto> getBuildInfoList(Map<String, Object> pMap);

	AgencyBuildingInfo selectMaxSeq(Integer cityId);

	void updateAddSeqNo(@Param("cityId")Integer cityId, @Param("seqNo")Integer seqNo, @Param("oldSeqNo")Integer oldSeqNo);
	void updateSubSeqNo(@Param("cityId")Integer cityId, @Param("seqNo")Integer seqNo, @Param("oldSeqNo")Integer oldSeqNo);
	
	/**
	 * 获取分销楼盘列表
	 * @author 张宏利
	 * @since 2017年11月22日
	 * @param pMap
	 * @return
	 */
	List<AgencyBuildingInfoDto> getBuildInfoListOnIndex(Map<String, Object> pMap);
	
	Integer getBuildingInfoByUserId(@Param("cityId") Integer cityId,@Param("userId") Integer userId);
}