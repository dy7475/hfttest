package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.businesstools.builddic.param.DeleteIdParam;
import com.myfun.erpWeb.businesstools.builddic.param.UpdateRoomInfoParam;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpBuildingSetRoomLayoutVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpRegisterBuildingSetRoomLaYouTVO;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoomLayout;
import com.myfun.repository.erpdb.po.ErpBuildingSetRoomLayoutExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpBuildingSetRoomLayoutMapper extends BaseMapper<ErpBuildingSetRoomLayout, ErpBuildingSetRoomLayout> {

    /**
	 * @mbggenerated
	 */
	int countByExample(ErpBuildingSetRoomLayoutExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpBuildingSetRoomLayoutExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpBuildingSetRoomLayout> selectByExample(ErpBuildingSetRoomLayoutExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpBuildingSetRoomLayout record,
			@Param("example") ErpBuildingSetRoomLayoutExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpBuildingSetRoomLayout record,
			@Param("example") ErpBuildingSetRoomLayoutExample example);

	/**
     * 删除房间户型图
     *
     * @param cityId Integer
     * @param param  DeleteIdParam
     * @param compId Integer
     * @author czq
     * @since 2018年12月17日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void delBuildRoomLayout(@Param("shardCityId") Integer cityId, @Param("param") DeleteIdParam param, @Param("compId") Integer compId);

    /**
     * 获取房间户型图
     *
     * @param cityId Integer
     * @param buildingSetRoomId  Integer
     * @param compId Integer
     * @author czq
     * @since 2018年12月18日
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpBuildingSetRoomLayoutVo> selectRoomLayoutListVo(@Param("shardCityId") Integer cityId, @Param("buildId") Integer buildId,
                                                          @Param("buildingSetRoomId") Integer buildingSetRoomId, @Param("compId") Integer compId);

    /**
     * 更改标志(删除)
     * @author wangchun
     * @param cityId
     * @param compId
     * @param buildingSetRoomIds
     */
    void updateLayoutFlag(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,
						  @Param("buildingSetRoomIds") List<Integer> buildingSetRoomIds);

    /**
     * 插入户型图
     * @author wangchun
     * @param cityId
     * @param layouts
     */
    void insertLayoutUrl(@Param("shardCityId")Integer cityId,@Param("layouts") List<ErpBuildingSetRoomLayout> layouts);

    /**
     * 获取模板
     * @author wangchun
     * @param cityId
     * @param buildingSetRoomId
     * @param compId
     * @return
     */
    List<ErpBuildingSetRoomLayout> getLayoutTmps(@Param("shardCityId") Integer cityId, @Param("buildingSetRoomId") Integer buildingSetRoomId, @Param("compId") Integer compId);

	/**
	 *	根据房间id回去户型图
	 * @param  * @param cityId
	 * @param compId
	 * @param buildId
	 * @param buildingSetRoomId
	 * @author 黄建海
	 * @since 2018/12/21 0021
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpRegisterBuildingSetRoomLaYouTVO> selectByBuildIdAndBuildSetRoomId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("buildId") Integer buildId,@Param("buildingSetRoomId") Integer buildingSetRoomId);

	/**
	 * 户型图应用到本栋本单元同房号
	 *
	 * @author czq
	 * @since 2018年12月22日
	 */
	void batchAddLayoutUrl(@Param("shardCityId")Integer cityId, @Param("buildId") Integer buildId, @Param("buildingSetRoomId") Integer buildingSetRoomId,
						   @Param("needAddLayoutRoomId") Integer needAddLayoutRoomId,  @Param("compId") Integer compId);
}