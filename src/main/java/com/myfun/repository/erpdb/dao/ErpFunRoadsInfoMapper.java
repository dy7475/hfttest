package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.house.param.GetRoadsMenuParam;
import com.myfun.repository.erpdb.po.ErpFunRoadsInfo;
import com.myfun.repository.erpdb.po.ErpFunRoadsInfoExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunRoadsInfoMapper extends BaseMapper<ErpFunRoadsInfo, ErpFunRoadsInfo> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRoadsInfoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRoadsInfoExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRoadsInfo> selectByExample(ErpFunRoadsInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRoadsInfo record,
			@Param("example") ErpFunRoadsInfoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRoadsInfo record, @Param("example") ErpFunRoadsInfoExample example);

	/**
     * 查询交通干道菜单
     * @author 臧铁
     * @param map roadsName
     * @since 2017年6月3日
     * @return
     */
    List<ErpFunRoadsInfo> getRoadsMenu(@Param("shardCityId") Integer cityId, @Param("param") GetRoadsMenuParam map);
}