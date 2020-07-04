package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.openApi.analysis.vo.RegHouseCountDto;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunDeptsExample;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Update;

@SwitchDB(type=SwitchDBType.COMP_NO)
public interface ErpFunDeptsMapper extends BaseMapper<ErpFunDepts, ErpFunDepts> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDepts> selectByExample(ErpFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDepts record, @Param("example") ErpFunDeptsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDepts record, @Param("example") ErpFunDeptsExample example);

	ErpFunDepts getDeptByCompNoAndDeptNo(@Param("shardCompNo") String shardCompNo, @Param("deptNo") String deptNo);

	List<ErpFunDepts> getValidDeptListByNotNull(ErpFunDepts erpFunDeptsCondition);
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	int count(@Param("shardCityId")Integer cityId, @Param("compNo")String compNo, @Param("deptNo")String deptNo);
	
	@SwitchDB(type=SwitchDBType.ARCHIVE_ID)
	ErpFunDepts queryDept(Integer shardArchiveId);

	
	/**
	 * 更新业务库用户数
	 * @param compNo
	 * @param deptNo
	 * @param
	 */
	void updateUserNumByCompNoAndDeptNo(@Param("shardCompNo")String compNo, @Param("deptNo")String deptNo, @Param("userNum")int userNum);
	
	/**
	 * 修改门店版本信息和漫游数??
	 * @param cityId 
	 * @param enterCompId
	 * @param softType
	 * @param nowTime
	 * @param proUserNum
	 * @param enterUserNum
	 */
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void updateRecordsByCompId(@Param("shardCityId")short cityId, @Param("enterCompId")String enterCompId, @Param("softType")String softType, 
			@Param("nowTime")String nowTime, @Param("userNum")String proUserNum,
			@Param("enterUserNum")String enterUserNum);

	/**
	 * 根据compNo与deptNo修改
	 * @param erpFunDepts
	 */
	void updateByCompNoAndDeptNo(ErpFunDepts erpFunDepts);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDeptsDto> getFunDeptsList(@Param("shardCityId")Integer shardCityId, @Param("regId")Integer regId);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunDepts getByDeptId(@Param("shardCityId")Integer cityId, @Param("deptId")Integer deptId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDepts> getDeptListByRange(@Param("shardCityId")Integer cityId, @Param("record")ErpFunDepts record);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDepts> getAllDeptListByRange(@Param("shardCityId")Integer cityId, @Param("record")ErpFunDepts record);

	void updateErpFunDepts(@Param("shardCityId")Integer cityId, @Param("record")ErpFunDepts record);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	int getRoamCount(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId);
	
	/**
	 * 根据公司ID和片区ID或者大区ID获取分店列表
	 * @author 臧铁
	 * @param
	 * @since 2017年6月28日
	 * @return
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDepts> 	getDeptListByCompId(ErpFunDepts erpFunDepts);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDepts> getDeptListByDeptIds(@Param("shardCityId")Integer cityId, @Param("deptIds")Set<Integer> deptIds);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDepts> getDeptListByDeptNos(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("deptNos")List<String> deptNos);
	
	/**
	 * 依据搜索
	 * @author 张宏利
	 * @since 2017年9月30日
	 * @param cityId
	 * @param compId
	 * @param serchRange
	 * @param serchRangeId
	 */
	List<ErpFunDepts> getDeptList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("partnerIds") List<Integer> partnerIds, @Param("serchRange")String serchRange, @Param("serchRangeId")Integer serchRangeId);

	List<ErpFunDepts> selectFunDeptsList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("manageRangeRangeType")Integer manageRangeRangeType, @Param("userManageRangeIds")Set<Integer> userManageRangeIds);
	
	List<ErpFunDepts> selectFunDeptsListRank(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("areaId")Integer areaId, @Param("regId")Integer regId);

	List<ErpFunDepts>  getCacheableDeptListByCompId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateDeptforArea(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("regId") Integer regId,@Param("areaId") Integer areaId);
	
	/**
	 * 获取门店列表数据
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return 
	 * 
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDepts> getDataList(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("regId") Integer regId);
	
	/**
	 * 有效门店数量
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	int getValidCount(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId);
	
	/**
	 * 
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return 
	 * 
	 */
	ErpFunDepts getDeptByCompNoAndDeptId(@Param("shardCityId") Integer cityId,@Param("deptId") Integer deptId);
	
	/**
	 * 通过部门和公司ID查询
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/7
	 * @return
	 *
	 */
	ErpFunDepts getDeptByCompIdAndDeptId(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId);

	List<ErpFunDeptsDto> getDeptDtoListByCompId(ErpFunDepts erpFunDepts);
	
	void updateByDeptInfoChange(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("areaId") Integer areaId, @Param("regId") Integer regId, @Param("deptId") Integer deptId);

	ErpFunDepts getAreaRegByDeptId(@Param("shardCityId")Integer cityId,@Param("deptId") Integer deptId);

    List<ErpFunDepts> getDeptListBynamicId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("columnName")String columnName, @Param("columnValue")String columnValue);


	List<RegHouseCountDto> getDeptAndPositionList(ErpFunDepts erpFunDepts);
	
	List<ErpFunDepts> getStopDeptList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
									  @Param("compNo")String compNo,@Param("deptNos") List<String> deptNos);

	List<ErpFunDeptsDto>  getDeptsDtoListByCompId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);

	String selectNameByPrimaryKey(ErpFunDepts erpFunDepts);

    List<ErpFunDepts> selectByPartnerIds(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("partnerIds") List<Integer> partnerIds);

    List<ErpFunDeptsDto> getDeptDtoListByPartnerId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("partnerId") Integer partnerId);

    ErpFunDepts getDeptByDeptNo(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptNo")String deptNo);

	void createNewDept(ErpFunDepts deptInfo);

    int insertSelectiveNew(ErpFunDepts erpFunDepts);

	@Update(value="INSERT INTO FUN_CONTRACT_TEMPLAE (TEMPLATE_NAME,TEMPLATE_CONTENT,CREATION_TIME,TEMPLATE_TYPE,COMP_ID,TEMPLATE_STATUS,LINE_HEIGHT,IS_YOUJIA_TEMPLATE,CITY_ID) SELECT TEMPLATE_NAME,TEMPLATE_CONTENT,CREATION_TIME,TEMPLATE_TYPE,#{compId},TEMPLATE_STATUS,LINE_HEIGHT,IS_YOUJIA_TEMPLATE,#{shardCityId} FROM  FUN_CONTRACT_TEMPLAE WHERE COMP_ID = 0 and TEMPLATE_TYPE in ('101','102') AND IS_YOUJIA_TEMPLATE = 0")
	@ResultType(Integer.class)
	int importFunContractTemplae(@Param("compId")Integer compId, @Param("shardCityId")Integer cityId);
}


