package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencySpreadPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.agencydb.po.AgencySpreadPhotoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface AgencySpreadPhotoMapper extends BaseMapper<AgencySpreadPhoto, Integer> {
	/**
	 * @mbggenerated
	 */
	int countByExample(AgencySpreadPhotoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AgencySpreadPhotoExample example);

	/**
	 * @mbggenerated
	 */List<AgencySpreadPhoto> selectByExample(AgencySpreadPhotoExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AgencySpreadPhoto record,@Param("example") AgencySpreadPhotoExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AgencySpreadPhoto record,@Param("example") AgencySpreadPhotoExample example);

	/**
	 * 获取图片地址
	 * @param spreadId
	 * @return
	 */
	AgencySpreadPhoto getPhotoBySpreadId(String spreadId);

	void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> pMap);
}