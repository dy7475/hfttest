package com.myfun.repository.erpdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.businesstools.blackList.param.GetBlackListParam;
import com.myfun.repository.erpdb.param.ErpFunBlackListParam;
import com.myfun.repository.erpdb.po.ErpFunBlackList;
import com.myfun.repository.erpdb.po.ErpFunBlackListExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunBlackListMapper extends BaseMapper<ErpFunBlackList, ErpFunBlackList> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunBlackListExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunBlackListExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunBlackList> selectByExample(ErpFunBlackListExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunBlackList record,
			@Param("example") ErpFunBlackListExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunBlackList record, @Param("example") ErpFunBlackListExample example);

	/**
	 * 查询黑名单列表
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @param param keywordQuery ：关键字 电话1和电话2和名字和公司的模糊查询
	 * @return
	 * @throws Exception
	 */
    List<ErpFunBlackList> getBlackList(@Param("shardCityId")Integer cityId,@Param("param")GetBlackListParam param);

    /**
     * 修改黑名单
     * @author 臧铁
     * @since 2017年8月23日
     * @param insertModel
     */
	void updateById(ErpFunBlackListParam param);


}