package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.vo.BuildingInfoInMobileVo;
import com.myfun.erpWeb.businesstools.builddic.vo.BuildingInfoVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpDetailsBuildingInfoVO;
import com.myfun.erpWeb.managecenter.vo.BuildInfoVO;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.param.ErpBuildingInfoParam;
import com.myfun.repository.erpdb.param.QueryBuildingListParam;
import com.myfun.repository.erpdb.po.ErpBuildingInfo;
import com.myfun.repository.erpdb.po.ErpBuildingInfoExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpBuildingInfoMapper extends BaseMapper<ErpBuildingInfo, ErpBuildingInfo> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingInfoExample example);

	/**
	 * @mbggenerated
	 */List<ErpBuildingInfo> selectByExampleWithBLOBs(ErpBuildingInfoExample example);

	/**
	 * @mbggenerated
	 */List<ErpBuildingInfo> selectByExample(ErpBuildingInfoExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpBuildingInfo record,@Param("example") ErpBuildingInfoExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleWithBLOBs(@Param("record") ErpBuildingInfo record,@Param("example") ErpBuildingInfoExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpBuildingInfo record,@Param("example") ErpBuildingInfoExample example);

	/**
	 * 根据城市和houseId获取楼盘信息
	 * 
	 * @param cityId
	 * @param fhouseid
	 * @return
	 */
	public ErpBuildingInfo getObjectByFhouseId(@Param("shardCityId") Short cityId, @Param("fhouseid") Integer fhouseid);

	/**
	 * 查询数据列表
	 * 
	 * @return
	 */
	List<ErpBuildingInfo> getModelList(ErpBuildingInfoParam buildingInfoParam);

	/**
	 * 验证楼盘名是否重??
	 * 
	 * @param buildingInfo
	 * @return
	 */
	public int checkBuildName(ErpBuildingInfo buildingInfo);

	Integer getId(ErpBuildingInfo buildingInfo);

	void updateInfo(@Param("shardCityId") Short shardCityId, @Param("count") int count, @Param("buildId") Integer buildId, @Param("vertifyCount") int vertifyCount, @Param("photoCol") String photoCol, @Param("size") int size);

	void updatePhotoType(@Param("shardCityId") Short cityId, @Param("buildStr") String buildStr);

	@AccessReadonlyDb
	List<ErpBuildingInfo> getBuildingInfoBySolrForPage(DaoBaseParam param);

	List<ErpBuildingInfoDto> getErpBuildingInfo(@Param("shardCityId") Short cityId, @Param("buildCode") String buildCode);

	/**
	 * 获取楼盘资料
	 * @author 臧铁
	 * @param cityId
	 * @param buildId
	 * @since 2017年5月31日
	 * @return
	 */
	ErpBuildingInfoDto getErpBuildInfoByid(@Param("shardCityId") Integer cityId, @Param("buildId") Integer buildId);

	/**
	 * @author 方李?
	 * @since 2016?8?30?
	 * @param cityId
	 * @param daoParam
	 * @return 
	 */
	
	
	List<ErpBuildingInfoDto> getBuildingListOffsetPage(@Param("shardCityId")Integer cityId,@Param("param") QueryBuildingListParam daoParam);

	List<BuildingInfoVo> getBuildingList(@Param("shardCityId")Integer cityId, @Param("param") DaoBaseParam daoParam, @Param("buildList")Set<String> buildList);

	/**
	 * @author 方李?
	 * @since 2016?8?31?
	 * @param cityId
	 * @param param
	 */


	void updateBuildInfo(@Param("shardCityId")Integer cityId,@Param("updateModel") DaoBaseParam param);

	/**
	 * @author 方李?
	 * @since 2016?9?1?
	 * @param cityId
	 * @param erpBuildingInfo
	 */

	
	void updateCheckTimeByUpdateBuildingInfoTmp(@Param("shardCityId")Short cityId, @Param("erpBuildingInfo")ErpBuildingInfo erpBuildingInfo);

	/**
	 * @author 方李?
	 * @since 2016?10?10?
	 * @param cityId
	 * @param buildName
	 */
	ErpBuildingInfo selectTopOneBuildingInfoOffBuildName(@Param("shardCityId")Integer cityId, @Param("buildName")String buildName);
	ErpBuildingInfo selectTopOneBuildingInfoOffPromotionName(@Param("shardCityId")Integer cityId,  @Param("promotionName")String promotionName, @Param("buildId")Integer buildId);
	
	List<ErpBuildingInfoDto> getBuildingListFlag(@Param("shardCityId")Integer cityId,@Param("buildName")String buildName);
	List<Map<String, Object>> getBuildingName(@Param("shardCityId")Integer cityId, @Param("param") Map<String, Object> param);

	ErpBuildingInfoDto getBuildInfoById(@Param("shardCityId") Integer cityId, @Param("buildId") String buildId);
	
	/**
	 * 获取修改房源楼盘时需要的楼盘信息
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param cityId
	 * @param buildId
	 * @return
	 */
	ErpBuildingInfoDto getInfoForChangeBuild(@Param("shardCityId") Integer cityId, @Param("buildId") Integer buildId);


    List<ErpBuildingInfoDto> selectBuildingInfoList(@Param("shardCityId")Integer cityId, @Param("searchKey")String searchKey, @Param("buildingFlag") Integer buildingFlag);

	void UpdateFloorSection(@Param("shardCityId")Integer cityId,@Param("sectionId") Integer sectionId,@Param("buildId") Integer buildId);

	List<ErpBuildingInfo> getBuildInfoByByParam(@Param("shardCityId")Integer cityId,@Param("buildAttentions")Integer buildAttentions,@Param("buildIds") List<Integer> buildIds,@Param("buildRegion") String[] buildRegion,@Param("sectionId") String[] sectionId);

    ErpBuildingInfo getBaseInfoByBuildId(@Param("shardCityId")Integer cityId, @Param("buildId")Integer buildId);

	ErpDetailsBuildingInfoVO getDetailInfoByBuildId(@Param("shardCityId")Integer cityId, @Param("buildId")Integer buildId);

	String getBuildCode(@Param("shardCityId")Integer cityId, @Param("buildId")Integer buildId);

    List<ErpBuildingInfoDto> getBuildingListOffsetPages(@Param("shardCityId")Integer cityId,@Param("param") QueryBuildingListParam param,@Param("page") Map<String, Integer> pages);

	int count(@Param("shardCityId")Integer cityId,@Param("param") QueryBuildingListParam param);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpBuildingInfo getTempCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("buildId")Integer buildId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<BuildInfoVO> getbuildBySearchField(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
											@Param("keyWord") String keyWord, @Param("buildId") Integer buildId, @Param("buildingFlag")Boolean buildingFlag);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<BuildInfoVO> getRegNameById(@Param("shardCityId") Integer cityId, @Param("regIds") List<Integer> regIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<BuildInfoVO> getSectionNameById(@Param("shardCityId") Integer cityId, @Param("sectionIds") List<Integer> sectionIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<BuildInfoVO> getBuildLockById(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("buildIds") List<Integer> buildIds);

	List<BuildingInfoInMobileVo> getBuildingListInMobile(@Param("shardCityId")Integer cityId, @Param("param") DaoBaseParam daoParam, @Param("buildList")Set<String> buildList);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingInfo> getTempCompIdByBuildIds(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildIds") List<Integer> buildIds);

	ErpBuildingInfo getBuildingInfoByBuildName(@Param("shardCityId") Integer cityId, @Param("buildName") String buildName);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingInfo> getAllBuild(@Param("shardCityId") Integer cityId,@Param("buildId") Integer buildId,@Param("buildRegion") Integer buildRegion,@Param("buildUseage") Integer buildUseage);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpBuildingInfo> getBuildListByIdList(@Param("shardCityId") Integer cityId,@Param("buildIdList") List<Integer> buildIdList);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<BuildInfoVO> getMeiLianbuildBySearchField(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
											@Param("keyWord") String keyWord, @Param("buildId") Integer buildId, @Param("buildingFlag")Boolean buildingFlag
											,@Param("orgId") Integer orgId,@Param("myOrgId") Integer myOrgId,@Param("houseUseage") String houseUseage,@Param("myOrgIds") String myOrgIds);

	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingInfo> selectByBuildIds(@Param("shardCityId")Integer cityId,@Param("split") String[] split);
}

