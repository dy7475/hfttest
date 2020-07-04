package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunAttStimulateImg;
import com.myfun.repository.admindb.po.AdminFunAttStimulateImgExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunAttStimulateImgMapper extends BaseMapper<AdminFunAttStimulateImg, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunAttStimulateImgExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunAttStimulateImgExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunAttStimulateImg> selectByExample(AdminFunAttStimulateImgExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunAttStimulateImg record,
			@Param("example") AdminFunAttStimulateImgExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunAttStimulateImg record,
			@Param("example") AdminFunAttStimulateImgExample example);

	List<AdminFunAttStimulateImg> selectBySceneId(@Param("sceneId") int sceneId);
}