package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.common.vo.ErpFunDeptsGroupBaseInfoVO;
import com.myfun.erpWeb.managecenter.sysmanager.param.InsertGroupData;
import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewGroupParam;
import com.myfun.repository.erpdb.dto.ErpFunDeptsgroupDto;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroupExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ErpFunDeptsgroupMapper extends BaseMapper<ErpFunDeptsgroup, ErpFunDeptsgroup> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDeptsgroupExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDeptsgroupExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunDeptsgroup> selectByExample(ErpFunDeptsgroupExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDeptsgroup record,
			@Param("example") ErpFunDeptsgroupExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDeptsgroup record, @Param("example") ErpFunDeptsgroupExample example);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer updateBaseInfo(@Param("shardCityId")Integer integer, @Param("pMap")InsertGroupData pMap);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	Integer insertBaseInfo(@Param("shardCityId")Integer integer, @Param("pMap")Map<String, Object> pMap);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunDeptsgroup> getGroupListByCondition(@Param("shardCityId")Integer integer, @Param("pMap")Map<String, Object> pMap);

	/**
	 * 获取公司分组数量
	 * @author 张宏利
	 * @since 2018年2月5日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	List<ErpFunDeptsgroup> getAllGroupCount(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("deptId")Integer deptId);

	List<ErpFunDeptsgroup> getDeptGroupsByGrIds(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("grIds")Set<Integer> manageRangIds);
	List<ErpFunDeptsgroup> getGrByGrIdsDel(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("grIds")Set<Integer> manageRangIds);

	List<ErpFunDeptsgroup> selectGroupList(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,  @Param("manageRangeRangeType")Integer manageRangeRangeType,  @Param("userManageRangeIds")Set<Integer> userManageRangeIds);
	
	List<ErpFunDeptsgroup> selectGroupListRank(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId,@Param("updateTime") String updateTime);

	List<ErpFunDeptsgroup> getCacheableGroupListByCompId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("updateTime") String updateTime);
	
	/**
	 * 通过grId获取分公司组数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	ErpFunDeptsgroup getDataByGrId(@Param("shardCityId") Integer cityId, @Param("grId") Integer grId);

	void updateByDeptGrId(@Param("shardCityId")Integer cityId,@Param("param") MoveUserToNewGroupParam param);

	Integer countGroupByGrName(@Param("shardCityId") Integer cityId,@Param("compId") Integer compId,@Param("deptId") Integer deptId,@Param("grName") String grName);

	ErpFunDeptsgroup getModelDataById(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("grId") Integer grId);

    List<ErpFunDeptsgroup> getGroupListByGrIdSet(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("grIdSet")Set<Integer> grIdSet);

    List<ErpFunDeptsgroup> getGroupListBynamicId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("columnName") String columnName, @Param("columnValue")String columnValue);

	List<ErpFunDeptsgroupDto> getGroupListByDeptId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("deptId") Integer deptId);

	List<ErpFunDeptsGroupBaseInfoVO> getGroupBaseInfoList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
}