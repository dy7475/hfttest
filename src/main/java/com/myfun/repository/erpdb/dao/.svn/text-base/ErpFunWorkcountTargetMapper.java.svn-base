package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.profit.param.AppFunWorkCountTargetSubParam;
import com.myfun.repository.erpdb.dto.ErpFunWorkCountTargetDto;
import com.myfun.repository.erpdb.param.ErpFunWorkCountTargetParam;
import com.myfun.repository.erpdb.po.ErpFunWorkcountTarget;
import com.myfun.repository.erpdb.po.ErpFunWorkcountTargetExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ErpFunWorkcountTargetMapper extends BaseMapper<ErpFunWorkcountTarget, ErpFunWorkcountTarget> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunWorkcountTargetExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunWorkcountTargetExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunWorkcountTarget> selectByExample(ErpFunWorkcountTargetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunWorkcountTarget record,
			@Param("example") ErpFunWorkcountTargetExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunWorkcountTarget record,
			@Param("example") ErpFunWorkcountTargetExample example);

	//	@Cacheable(value=CacheStructure.hfterpdb_funWorkCountTypeCache,
//			key="'"+CacheStructure.hfterpdb_funWorkCountTypeCacheByCompId+"'+#p1.cityId+'_'+#p1.compId+'_'+#p1.targetType+'_'+#p1.areaId+'_'+#p1.regId+'_'+#p1.deptId" +
//					"+'_'+#p1.grId+'_'+#p1.userId+'_'+#p1.userPosition")
//	@CacheEvictMatchKey(key = {"baseButtonPermissionList"})
	@AccessReadonlyDb
	List<ErpFunWorkCountTargetDto> getWorkCountTargetList(@Param("shardCityId")Integer cityId, @Param("param")ErpFunWorkCountTargetParam param);

	@AccessReadonlyDb
	Map<String,Object> getSumWorkCountTargetList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
													   @Param("rangeType") Integer groupRange,
													   @Param("manageRangId") Integer manageRangId, @Param("targetType") Integer targetType,
													   @Param("startTime") String startTime );
	@AccessReadonlyDb
	Map<String,Object> getAppSumWorkCountTargetList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
												 @Param("deptId") Integer deptId, @Param("rangeType") Integer groupRange,
												 @Param("rangeIds") Set<Integer> rangeIdset, @Param("targetType") Integer targetType,
												 @Param("startTime") String startTime , @Param("endTime") String endTime, @Param("separationConfig") boolean separationConfig, @Param("partnerIdRange") Integer partnerIdRange);
	@AccessReadonlyDb
	Map<String,Object> getAppSumWorkCountTargetListForOrg(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("targetType") Integer targetType,
														  @Param("separationConfig") boolean separationConfig, @Param("partnerIdRange") Integer partnerIdRange,
														  @Param("whereCause") String whereCause,@Param("startTime") String startTime, @Param("endTime") String endTime);
	@AccessReadonlyDb
	List<Map<String, Object>> getSumWorkCountTargetListReport(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

    @AccessReadonlyDb
	Map<String,Integer> getUcenterWorkCountTarget(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
									  @Param("rangeType") Integer groupRange,
									  @Param("manageRangId") Integer manageRangId, @Param("targetType") Integer targetType,
									  @Param("startTime") String startTime ,@Param("workColumns") String workColumns);

    @AccessReadonlyDb
	List<Map<String,Object>> getRangeNameList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
											  @Param("rangeType") Integer groupRange,
											  @Param("rangeIds") Set<Integer> rangeIds, @Param("targetType") Integer targetType,
											  @Param("startTime") String startTime);

	@AccessReadonlyDb
	List<Map<String,Integer>> getUcenterWorkCountTargetList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
															@Param("rangeType") Integer rangeType,
															@Param("rangeIds") Set<Integer> rangeIds, @Param("targetType") Integer targetType,
															@Param("startTime") String startTime, @Param("workColumns") String workColumns,@Param("deptId") Integer deptId);
	
	@AccessReadonlyDb
	List<Map<String,Integer>> getTargetList(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds,
															@Param("rangeType") Integer rangeType,
															@Param("rangeIds") Set<Integer> rangeIds, @Param("targetType") Integer targetType,
															@Param("startTime") String startTime, @Param("workColumns") String workColumns, @Param("deptId") Integer deptId, @Param("lookType") Integer lookType);

	@AccessReadonlyDb
	@MapKey("rangeId")
	Map<Integer,Map<String,Integer>> getTargetListForOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("partnerIds") List<Integer> partnerIds,
											  @Param("targetType") Integer targetType, @Param("startTime") String startTime, @Param("workColumns") String workColumns,
											  @Param("whereCause") String whereCause, @Param("groupByColumn") String groupByColumn);

	void createTarget(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds, @Param("areaId") Integer areaId, @Param("regId") Integer regId, @Param("deptId") Integer deptId,
			@Param("grId") Integer grId, @Param("targetType") Integer targetType, @Param("userPosition") List<String> userPosition, @Param("userId") Integer userId, @Param("param")AppFunWorkCountTargetSubParam param);


	void createTargetForOrg(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,@Param("partnerIds") List<Integer> partnerIds, @Param("targetType") Integer targetType,
							@Param("userPositionList") List<String> userPosition, @Param("userId") Integer userId, @Param("param")AppFunWorkCountTargetSubParam param,@Param("orgPath") String orgPath);

	/**
	 * 获取角色下有人的考核配置数据
	 * @param cityId
	 * @param compId
	 * @param deptId
	 * @param userPosition
	 * @return 到人级别的考核配置列表
	 */
	List<ErpFunWorkcountTarget> getWorkCountTarget(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeType") Byte rangeType, @Param("deptId") Integer deptId, @Param("userPosition") String userPosition);
	
	/**
	 * 获取角色下没人的考核配置数据
	 * @param cityId
	 * @param compId
	 * @param rangeType
	 * @param deptId
	 * @param userPosition
	 * @return 到公司或门店级别的考核配置列表
	 */
	List<ErpFunWorkcountTarget> getWorkCountOutOfUseTarget(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("rangeType") Byte rangeType, @Param("rangeId") Integer rangeId, @Param("userPosition") String userPosition);
	
	/**
	 * 考核配置对应的角色下没有人员时的通用方法，配置只到公司或门店级别
	 * @param cityId
	 * @param compId
	 * @param deptId
	 * @param targetType
	 * @param userPosition
	 * @param param
	 */
	void createCommNobodyTarget(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId, @Param("targetType") Integer targetType, @Param("userPosition") String userPosition, @Param("param") AppFunWorkCountTargetSubParam param);

}