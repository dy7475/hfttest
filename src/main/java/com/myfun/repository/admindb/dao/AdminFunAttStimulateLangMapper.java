package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunAttStimulateImg;
import com.myfun.repository.admindb.po.AdminFunAttStimulateLang;
import com.myfun.repository.admindb.po.AdminFunAttStimulateLangExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunAttStimulateLangMapper extends BaseMapper<AdminFunAttStimulateLang, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunAttStimulateLangExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunAttStimulateLangExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunAttStimulateLang> selectByExample(AdminFunAttStimulateLangExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunAttStimulateLang record,
			@Param("example") AdminFunAttStimulateLangExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunAttStimulateLang record,
			@Param("example") AdminFunAttStimulateLangExample example);

	List<AdminFunAttStimulateLang> selectBySceneId(@Param("sceneId") int sceneId);
}