package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunEmployeeDocDto;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDoc;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDocExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface ErpFunEmployeeDocMapper extends BaseMapper<ErpFunEmployeeDoc, ErpFunEmployeeDoc> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEmployeeDocExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEmployeeDocExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEmployeeDoc> selectByExample(ErpFunEmployeeDocExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEmployeeDoc record,
			@Param("example") ErpFunEmployeeDocExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEmployeeDoc record, @Param("example") ErpFunEmployeeDocExample example);

	ErpFunEmployeeDoc getErpFunEmployeeDocByArchiveId(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("archiveId")Integer archiveId);

	ErpFunEmployeeDoc getErpFunEmployeeDocByUserId(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("userId")Integer userId);

    List<ErpFunEmployeeDocDto> getEmployeeDocList(@Param("shardCityId")Integer cityId, @Param("paramMap")Map<String, Object> paramMap);

    ErpFunEmployeeDocDto getEmployeeDocDetail(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("compId")Integer compId);
    ErpFunEmployeeDocDto getEmployeeDocDetailNewOrg(@Param("shardCityId")Integer cityId, @Param("userId")Integer userId, @Param("compId")Integer compId);

    /**
     * 通过archiveId跟新
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/5/25
     */	
	void updateByArchiveId(ErpFunEmployeeDoc erpFunEmployeeDocPO);

	void updateWriteoffTime(ErpFunEmployeeDoc erpFunEmployeeDoc);
	
	/**
	 * 通过userIds查询员工档案
	 * @author 朱科
	 * @since 2018年11月6日
	 * @return
	 */
	List<ErpFunEmployeeDoc> getEmployeeDocByUserIds(@Param("shardCityId") Integer cityId,@Param("compId")Integer compId,@Param("userIds")List<Integer> userIds);
}