package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunWorkcountTargetTemplate;
import com.myfun.repository.erpdb.po.ErpFunWorkcountTargetTemplateExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunWorkcountTargetTemplateMapper extends BaseMapper<ErpFunWorkcountTargetTemplate, ErpFunWorkcountTargetTemplate> {
    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunWorkcountTargetTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunWorkcountTargetTemplateExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunWorkcountTargetTemplate> selectByExample(ErpFunWorkcountTargetTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunWorkcountTargetTemplate record,
			@Param("example") ErpFunWorkcountTargetTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunWorkcountTargetTemplate record,
			@Param("example") ErpFunWorkcountTargetTemplateExample example);

	/**
     * 批量插入组装好的数据
     */
    @SwitchDB(type=SwitchDBType.CITY_ID)
	void insertBatch(@Param("shardCityId") Integer cityId, @Param("targetList") List<ErpFunWorkcountTargetTemplate> insertTargetList);

    /**
     * 插入一个配置数据
     */
    @SwitchDB(type=SwitchDBType.CITY_ID)
	void insertOne(@Param("shardCityId") Integer cityId, @Param("param") ErpFunWorkcountTargetTemplate param);

    /**
     * 通过条件查询考核配置模板数据
     */
    @SwitchDB(type=SwitchDBType.CITY_ID)
	List<ErpFunWorkcountTargetTemplate> getWorkcountTargetTemplate(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId, @Param("separationConfig") boolean  separationConfig,@Param("partnerId") Integer partnerId,
			@Param("rangeType") Byte rangeType, @Param("deptId") Integer deptId, @Param("userPosition") String userPosition);
}