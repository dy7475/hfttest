package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.erpdb.dto.ErpWorkLogDto;
import com.myfun.repository.erpdb.po.ErpWorkLog;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.param.DaoBaseParam;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpWorkLogMapper extends BaseMapper<ErpWorkLog, ErpWorkLog> {

	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 * @param cityId
	 * @param param
	 * @return
	 */
	List<ErpWorkLogDto> selectWorkLogList(@Param("shardCityId")Integer cityId,@Param("conditionModel") DaoBaseParam conditionModel);
	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 * @param cityId
	 * @param param
	 * @return
	 */
	Integer countWorkLogList(@Param("shardCityId")Integer cityId,@Param("conditionModel") DaoBaseParam conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 * @param cityId
	 * @param wlId
	 * @return
	 */
	ErpWorkLogDto selectWorkLogInfo(@Param("shardCityId")Integer cityId,@Param("wlId") Integer wlId);
	
	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 * @param cityId
	 * @param wlId
	 * @return
	 */
	List<ErpWorkLogDto> selectLookExplrthCount(@Param("shardCityId")Integer cityId,@Param("wlIds") Integer[] wlIds);
	
	/**
	 * @author 方李骥
	 * @since 2016年9月22日
	 * @param cityId
	 * @param wlId
	 * @return
	 */
	void createWorkLog(@Param("shardCityId")Integer cityId,@Param("insertModel")DaoBaseParam param);
	/**
	 * @author 方李骥
	 * @since 2016年9月22日
	 * @param cityId
	 * @param wlId
	 * @return
	 */
	
	void updateWorkLog(@Param("shardCityId")Integer cityId,@Param("updateModel")DaoBaseParam param);
	/**
	 * @author 方李骥
	 * @since 2016年10月11日
	 * @param cityId
	 * @param wlId
	 * @return
	 */
	int countWorkLogOffUser(@Param("shardCityId")Integer cityId,@Param("nowUser")Integer nowUser,@Param("nowTime")String nowTime,
			@Param("timeEnd")String timeEnd);
}