package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.common.vo.AdminNPicWatermarkVo;
import com.myfun.repository.admindb.po.AdminNPicWatermark;
import com.myfun.repository.admindb.po.AdminNPicWatermarkExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminNPicWatermarkMapper extends BaseMapper<AdminNPicWatermark, AdminNPicWatermark> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminNPicWatermarkExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminNPicWatermarkExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminNPicWatermark> selectByExample(AdminNPicWatermarkExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminNPicWatermark record,
			@Param("example") AdminNPicWatermarkExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminNPicWatermark record,
			@Param("example") AdminNPicWatermarkExample example);
	List<AdminNPicWatermarkVo> getNpicWatermarkVoList();
}