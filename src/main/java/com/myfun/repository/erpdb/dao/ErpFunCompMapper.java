package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.managecenter.sysmanager.param.UpdateCompNameParam;
import com.myfun.repository.admindb.po.AdminFunComp;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunCompDto;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunCompExample;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

@SwitchDB(type=SwitchDBType.COMP_NO)
public interface ErpFunCompMapper extends BaseMapper<ErpFunComp, ErpFunComp> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunCompExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunCompExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunComp> selectByExample(ErpFunCompExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunComp record, @Param("example") ErpFunCompExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunComp record, @Param("example") ErpFunCompExample example);

	ErpFunComp getCompByCompNo(@Param("shardCompNo") String shardCompNo);
	
	@SwitchDB(type=SwitchDBType.CITY_ID)
	ErpFunCompDto getCompInfoByCompNo(@Param("shardCityId")Integer cityId, @Param("compNo")String compNo);

	@SwitchDB(type=SwitchDBType.ARCHIVE_ID)
	ErpFunComp queryComp(Integer archiveId);
	
	ErpFunComp getCompInfoByCompId(ErpFunComp comp);
	
	/**
	 * 修改公司版本信息
	 * @param cityId 
	 * @param softType
	 * @param nowTime
	 * @param enterCompId
	 */
	@SwitchDB(type=SwitchDBType.CITY_ID)
	void updateRecordsByCompId(@Param("shardCityId") short cityId, @Param("softType")String softType, @Param("nowTime")String nowTime, @Param("enterCompId")String enterCompId);

	/**
	 * 根据compNo修改
	 * @param erpFunComp
	 */
	void updateByCompNo(ErpFunComp erpFunComp);

	/**
	 * 加试用数据
	 * @param compNo
	 * @param deptNo
	 */
	String addTryData(@Param("shardCompNo") String compNo, @Param("deptNo") String deptNo);

	List<Integer> getCityIdsGroup(@Param("shardDbName")String shardDbName);

	List<Integer> selectCompIdsByCityId(@Param("shardDbName")String shardDbName, @Param("cityId")Integer cityId);
	/**
	 * 获取指定公司的注册标记
	 * @author 熊刚
	 * @since 2017年9月25日
	 * @param cityId
	 * @param compId
	 * @return
	 */
	List<Map<String,Object>> getMgrRegistFlag(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);

	//AdminFunComp getAdminFunCompByCompId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);
	
	/**
	 *
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return
	 *
	 */
	@SwitchDB(type=SwitchDBType.CITY_ID)
	ErpFunComp selectByCompId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);

	List<Integer> getCompIdsByCompNos(@Param("shardCityId")Integer cityId, @Param("shareCompNos")List<String> shareCompNos);

	List<Integer> getErpCompIdListByCrmCompId(@Param("shardCityId")Integer cityId, @Param("crmCompId")Integer crmCompId);

	void updatePlctSwotch(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("plotSwitch") String plotSwitch);

	/**
	 * zhaoyang
	 * 更新头部名称或者业务组织名称
	 * @param updateCompNameParam
	 */
	void updateCompHeadNameOrBusinessNameByCompId(@Param("shardCityId")Integer cityId,@Param("headName") String headName,@Param("businessName") String businessName,@Param("compId") Integer compId);

	@SwitchDB(type=SwitchDBType.CITY_ID)
	void insertCompRoles(@Param("shardCityId") Integer cityId, @Param("erpCompId") Integer erpCompId);

	@Select(value="{CALL hft_sysdb..proc_AlterGeneralmanager(#{compNo},#{userIdOld},#{userIdNew},#{crmUserId})}")
	@ResultType(value=Integer.class)
	Integer proc_AlterGeneralmanager(@Param("shardCompNo") String shardCompNo, @Param("compNo")String compNo,@Param("userIdOld")Integer userIdOld,@Param("userIdNew")Integer userIdNew,@Param("crmUserId")Integer crmUserId);

    int insertSelectiveNew(ErpFunComp erpFunComp);

    ErpFunComp getBaseCompInfo(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId);
}