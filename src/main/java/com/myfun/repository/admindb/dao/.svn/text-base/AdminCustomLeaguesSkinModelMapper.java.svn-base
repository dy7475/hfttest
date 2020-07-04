package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminCustomLeaguesSkinModel;
import com.myfun.repository.admindb.po.AdminCustomLeaguesSkinModelExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminCustomLeaguesSkinModelMapper extends BaseMapper<AdminCustomLeaguesSkinModel, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminCustomLeaguesSkinModelExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminCustomLeaguesSkinModelExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminCustomLeaguesSkinModel> selectByExample(AdminCustomLeaguesSkinModelExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminCustomLeaguesSkinModel record,
			@Param("example") AdminCustomLeaguesSkinModelExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminCustomLeaguesSkinModel record,
			@Param("example") AdminCustomLeaguesSkinModelExample example);
	
	/**
     * 通过组织类型和skinType查询配置的值
     * @param leaguesType 组织类型
     * @param skinType 
     * @return
     */
	String selectSkinPicUrlByLeaguesTypeAndSkinType(@Param("leaguesType") Integer leaguesType, @Param("skinType") String skinType);

    List<AdminCustomLeaguesSkinModel> getSkinModelByLeaguesType(@Param("leaguesType") Integer leaguesType);
}