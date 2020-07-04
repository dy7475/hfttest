package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminJrFinancePhoto;
import com.myfun.repository.admindb.po.AdminJrFinancePhotoExample;
import com.myfun.repository.erpdb.po.ErpFunVideo;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AdminJrFinancePhotoMapper extends BaseMapper<AdminJrFinancePhoto, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminJrFinancePhotoExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminJrFinancePhotoExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminJrFinancePhoto> selectByExample(AdminJrFinancePhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminJrFinancePhoto record,
			@Param("example") AdminJrFinancePhotoExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminJrFinancePhoto record,
			@Param("example") AdminJrFinancePhotoExample example);

	List<Map<String, String>> getPhotoListByFinanceId(Integer id);


	void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> fastdfsFileList);
}