package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.common.vo.AdminFunTagsVo;
import com.myfun.repository.admindb.po.AdminFunTags;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunTagsMapper extends BaseMapper<AdminFunTags, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunTagsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunTagsExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunTags> selectByExample(AdminFunTagsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunTags record, @Param("example") AdminFunTagsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunTags record, @Param("example") AdminFunTagsExample example);

	List<AdminFunTagsVo> getFunTagsVoList();
}