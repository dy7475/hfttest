package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.param.DeleteIdParam;
import com.myfun.erpWeb.businesstools.builddic.param.ErpBuildingSetRoofUpdateParam;
import com.myfun.erpWeb.businesstools.builddic.param.UpdateBuildRoofUnitsAndDoorsParam;
import com.myfun.erpWeb.businesstools.builddic.vo.BuildRoofNameInMobileVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpBuildingSetRoofNameVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpBuildingSetRoofRuleVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpRegisterBuildingSetRoofVO;
import com.myfun.repository.erpdb.dto.RoofInfoDto;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoof;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoofExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import io.swagger.annotations.ApiModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author czq
 * @since 2018/12/11
 */
public interface ErpBuildingSetRoofMapper extends BaseMapper<ErpBuildingSetRoof, ErpBuildingSetRoof> {

    /**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetRoofExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetRoofExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingSetRoof> selectByExample(ErpBuildingSetRoofExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingSetRoof record,
			@Param("example") ErpBuildingSetRoofExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingSetRoof record,
			@Param("example") ErpBuildingSetRoofExample example);

	/**
     * 修改楼盘栋座信息
     *
     * @param cityId Integer
     * @param param  ErpBuildingSetRoofUpdateParam
     * @author czq
     * @since 2018年12月11日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void updateBuildingSetRoof(@Param("shardCityId") Integer cityId, @Param("param") ErpBuildingSetRoofUpdateParam param, @Param("compId") Integer compId);

    /**
     * 查询该楼盘该栋名称是否重复, 大于0表示有重复
     *
     * @param cityId    Integer
     * @param compId    Integer
     * @param buildId   Integer
     * @param buildRoof String
     * @author czq
     * @since 2018年12月11日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    Integer getRoofUnitNameRepeatCount(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
                                       @Param("buildRoof") String buildRoof, @Param("buildingSetRoofId") Integer buildingSetRoofId);

    /**
     * 添加楼盘栋座信息
     *
     * @param cityId Integer
     * @param param  ErpBuildingSetRoof
     * @author czq
     * @since 2018年12月11日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    Integer insertSelective(@Param("shardCityId") Integer cityId, ErpBuildingSetRoof param);

//    /**
//     * 添加楼盘栋座信息
//     *
//     * @param cityId Integer
//     * @param param  ErpBuildingSetRoof
//     * @author czq
//     * @since 2018年12月11日
//     */
//    @SwitchDB(type = SwitchDBType.CITY_ID)
//    Integer addRoof(@Param("shardCityId") Integer cityId, ErpBuildingSetRoof param);

    /**
     * 删除楼盘栋座信息
     *
     * @param cityId Integer
     * @param param  DeleteIdParam
     * @param compId Integer
     * @author czq
     * @since 2018年12月17日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void delBuildRoof(@Param("shardCityId") Integer cityId, @Param("param") DeleteIdParam param, @Param("compId") Integer compId);

    /**
     * 修改楼盘栋座单元数,户数
     *
     * @param cityId                 Integer
     * @param roofUnitsAndDoorsParam UpdateBuildRoofUnitsAndDoorsParam
     * @param compId                 Integer
     * @author czq
     * @since 2018年12月17日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void updateBuildRoofUnitsAndDoors(@Param("shardCityId") Integer cityId, @Param("param") UpdateBuildRoofUnitsAndDoorsParam roofUnitsAndDoorsParam,
                                      @Param("compId") Integer compId);
	/**
	 * 查询包含栋维护人的栋信息
	 * @param cityId
	 * @param compId
	 * @param buildId
	 * @author wangchun
	 * @since 2018-12-17
	 */
	List<RoofInfoDto> getRoofInfos(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId , @Param("buildId")Integer buildId);

	RoofInfoDto getRoofInfo(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId , @Param("buildId")Integer buildId,@Param("buildingSetRoof")String buildingSetRoof);

    /**
     * 查询栋维护人ID
     * @author wangchun
     * @return
     */
    Integer getRoofManager(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId, @Param("buildingSetRoof")String buildingSetRoof);

    /**
     * 获取没有维护人的栋
     * @author wangchun
     */
    List<Integer> getNoManagerRoofs(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("buildId")Integer buildId);

    /**
     * 批量设置栋的维护人
     * @author wangchun
     */
    void updateRoofManager(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,
                            @Param("ids")List<Integer> ids,@Param("managerId")Integer managerId);

    void updateAllRoofManager(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,
                            @Param("buildId")Integer buildId,@Param("managerId")Integer managerId);

    /**
     * 获取楼盘栋座名称Vo列表
     *
     * @author czq
     * @since 2018年12月19日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingSetRoofNameVo> getBuildRoofNameVo(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId, @Param("buildId")Integer buildId);

    /**
     * 获取楼盘栋座名称Vo列表
     *
     * @author czq
     * @since 2018年1月10日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingSetRoofNameVo> getRoofNameAndMarketingControlCount(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,
                                                                       @Param("buildId")Integer buildId);

    /**
     * 获取楼盘栋座名称Vo列表
     *
     * @author czq
     * @since 2018年12月19日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetRoofRuleVo getBuildingSetRoofRuleVo(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
                                                      @Param("buildId") Integer buildId, @Param("buildingSetRoofId")Integer buildingSetRoofId);

    /**
     * 系统模板应用到当前楼盘
     *
     * @param cityId Integer
     * @param sourceCompId Integer (值为0,指从compId为0的规则拷贝到copyToCompId)
     * @param buildId Integer
     * @param copyToCompId Integer
     * @param copyToCompNo String
     *
     * @author czq
     * @since 2018年12月20日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void copyTempBuildRule(@Param("shardCityId") Integer cityId, @Param("sourceCompId") Integer sourceCompId,
                           @Param("buildId") Integer buildId, @Param("copyToCompId") Integer copyToCompId,
                           @Param("copyToCompNo") String copyToCompNo, @Param("provenceId") Integer provenceId);
    /**
     *根据楼盘查询栋座
     * @param  * @param cityId
     * @param compId
     * @param buildId
     * @author 黄建海
     * @since 2018/12/21 0021
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpRegisterBuildingSetRoofVO> selectRegisterByBuildId(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId, @Param("list") List<Integer> list);

    /**
     * 系统模板应用到当前楼盘关联ID的修改
     *
     * @param cityId Integer
     * @param sourceCompId Integer (值为0,指从compId为0的规则拷贝到copyToCompId)
     * @param buildId Integer
     * @param copyToCompId Integer
     * @param copyToCompNo String
     *
     * @author czq
     * @since 2018年12月20日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void updateIdAfterCopyTempBuildRule(@Param("shardCityId") Integer cityId, @Param("sourceCompId") Integer sourceCompId,
                           @Param("buildId") Integer buildId, @Param("copyToCompId") Integer copyToCompId,
                           @Param("copyToCompNo") String copyToCompNo, @Param("provenceId") Integer provenceId);

    /**
     * 系统模板应用到当前楼盘关联ID的修改
     *
     * @param cityId Integer
     * @param sourceCompId Integer (值为0,指从compId为0的规则拷贝到copyToCompId)
     * @param buildId Integer
     * @param copyToCompId Integer
     * @param copyToCompNo String
     *
     * @author czq
     * @since 2018年12月20日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void updateIdAfterCopyTempBuildRuleByNumber(@Param("shardCityId") Integer cityId, @Param("sourceCompId") Integer sourceCompId,
                                        @Param("buildId") Integer buildId, @Param("copyToCompId") Integer copyToCompId,
                                        @Param("copyToCompNo") String copyToCompNo, @Param("provenceId") Integer provenceId);

    /**
     * 清空楼盘规则
     *
     * @param cityId Integer
     * @param compId Integer
     * @param buildId Integer
     *
     * @author czq
     * @since 2018年12月20日
     */
//    @SwitchDB(type = SwitchDBType.CITY_ID)
//    void delBuildRuleById(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
//                          @Param("buildId") Integer buildId);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void updateRoomAndUnitCountInRoof(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
                               @Param("buildingSetRoofId") Integer buildingSetRoofId);

    void delRoomCountInRoof(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
                      @Param("buildingSetRoofId") Integer buildingSetRoofId,@Param("roomChangeCount") Integer roomChangeCount);

    void addRoomCountInRoof(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId,
                      @Param("buildingSetRoofId") Integer buildingSetRoofId,@Param("changeCount") Integer changeCount);

    /**
     * 获取楼盘栋座列表
     *
     * @author czq
     * @since 2018年12月19日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingSetRoof> getBuildingSetRoofs(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId,
                                                @Param("buildId") Integer buildId, @Param("distinctBuildRoofList") List<String> distinctBuildRoofList);
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void batchAddRoof(@Param("shardCityId")Integer cityId, @Param("roofs") List<ErpBuildingSetRoof> roofs);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    void batchUpdateRoof(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId,
                         @Param("buildId") Integer buildId, @Param("record") ErpBuildingSetRoof record,
                         @Param("needUpdateBuildRoofs") List<String> needUpdateBuildRoofs);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    ErpBuildingSetRoof getRepeatRoof(@Param("shardCityId") Integer cityId, @Param("compId")Integer compId,
                                     @Param("buildId") Integer buildId, @Param("condition") String condition);

    List<BuildRoofNameInMobileVo> getBuildRoofNames(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("buildId") Integer buildId);


}
