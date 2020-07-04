package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpFunTrackDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunTrackHis;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpFunTrackHisExample;

public interface ErpFunTrackHisMapper extends BaseMapper<ErpFunTrackHis, ErpFunTrackHis> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunTrackHisExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunTrackHisExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunTrackHis> selectByExample(ErpFunTrackHisExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunTrackHis record,
			@Param("example") ErpFunTrackHisExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunTrackHis record, @Param("example") ErpFunTrackHisExample example);

	/**
	 * 通过主键集合获取跟进列表
	 * @author 张宏利
	 * @since 2017年8月1日
	 * @param cityId
	 * @param map
	 * @return
	 */
	public List<ErpFunTrackHis> getByTrackIds(@Param("shardCityId")Integer cityId, @Param("recordIds") String[] recordIds);

	List<ErpFunTrackDto> getErpFunTrackDtoList(@Param("shardCityId")Integer cityId, @Param("trackIdsList")List<Integer> trackIdsList,@Param("trackTypeList") List<Byte> trackTypeList);
}