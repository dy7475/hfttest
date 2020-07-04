package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.erpdb.dto.ErpTrackUsersDto;
import com.myfun.repository.erpdb.po.ErpTrackUsers;
import com.myfun.repository.erpdb.po.ErpTrackUsersKey;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;

public interface ErpTrackUsersMapper extends BaseMapper<ErpTrackUsers, ErpTrackUsersKey> {	
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	@SelectProvider(type=FunTrackUsersSqlProvider.class,method="getTrackUsersListByTrackIds")
	@ResultMap(value="DtoBaseResultMap")
	List<ErpTrackUsersDto> getTrackUsersListByTrackIds(@Param("shardCityId")Integer cityId,@Param("queryIds") Integer[] queryIds,@Param("queryColumn") String[] queryColumn,@Param("compId") Integer compId);
	class FunTrackUsersSqlProvider{
		public String getTrackUsersListByTrackIds(Map<String, Object> paramMap) throws Exception{
			Integer[] trackIds = (Integer[]) paramMap.get("queryIds");
			String[] buyCustColumns = (String[]) paramMap.get("queryColumn");
			Condition condition = new Condition();
			condition.add(new ConditionItem("COMP_ID","=","#{compId}")); 
			condition.add(new ConditionItem("TRACK_ID","IN",trackIds)); 
			Columns columns = new Columns(buyCustColumns);
			return SQLBuilderSupport.selectByCondition( "TRACK_USERS",false, columns, condition, null, null).toString();
		}
	}
	
	/**
	 * 通过跟进ID和公司ID获取列表
	 * @author 臧铁
	 * @since 2017年7月12日
	 * @param cityId
	 * @param trackId
	 * @param curCompId
	 * @return
	 */
	List<ErpTrackUsers> getListByTrackIdAndCompId(@Param("shardCityId")Integer cityId, @Param("trackId")Integer trackId, @Param("compId")Integer curCompId);
}