package com.myfun.repository.searchdb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.searchdb.dto.SearchSosoViewDto;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.repository.searchdb.po.SearchSosoViewKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.searchdb.po.SearchSosoViewExample;

public interface SearchSosoViewMapper extends BaseMapper<SearchSosoView, SearchSosoViewKey> {

	/**
	 * @mbggenerated
	 */
	int countByExample(SearchSosoViewExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(SearchSosoViewExample example);

	/**
	 * @mbggenerated
	 */
	List<SearchSosoView> selectByExample(SearchSosoViewExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") SearchSosoView record,
			@Param("example") SearchSosoViewExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") SearchSosoView record, @Param("example") SearchSosoViewExample example);

	List<SearchSosoView> getSoSoViewList(@Param("sosoIds") Integer[] sosoIds,@Param("repeatId") Integer repeatId,@Param("archiveId") Integer archiveId);

	int getViewCount(@Param("archiveId")Integer archiveId,@Param("deptId") Integer deptId,@Param("timeArr") String[] timeArr,@Param("dataType") Byte dataType);
	
	/**
	 * 将标记改为1
	 * @author 张宏利
	 * @since 2016年8月30日
	 * @param caseId
	 * @param sosoType
	 * @param archiveId
	 */
	void updatePerpetualFlag(@Param("caseId")Integer caseId,@Param("sosoType") String sosoType,@Param("archiveId") int archiveId);
	
	/**
	 * 修改投诉标记
	 * @author 张宏利
	 * @since 2017年4月7日
	 * @param sosoViewKey
	 */
	void updateComplaintFlag(SearchSosoView sosoViewKey);
	
	/**
	 * 修改专属手机号
	 * @param integer
	 * @param integer2
	 * @param archiveId
	 */
	void updateExclusiveMobile(@Param("sosoId")Integer sosoId, @Param("sosoType")Integer sosoType, @Param("exclusiveMobile")String exclusiveMobile, @Param("archiveId")Integer archiveId);

	/**
	 * 统计搜搜转入次数
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/7
	 */
	Integer getConvertCount(@Param("compId")Integer compId,@Param("sosoId") Integer sosoId);

	List<SearchSosoViewDto> getConvertCountList(@Param("compId") Integer adminCompId,@Param("sosoIds") List<Integer> sosoIds);

	List<SearchSosoView> getSosoViewBySosoId(@Param("compId") Integer adminCompId,@Param("sosoId") Integer sosoId);
	
	/**
	 * 统计搜搜最後转入時間
	 * @param
	 * @return
	 * @auther 朱科
	 * @since 2018/09/12
	 */
	SearchSosoView getLastConvertTime(@Param("compId")Integer compId,@Param("sosoId") Integer sosoId);
}