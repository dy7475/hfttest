package com.myfun.repository.searchdb.dao;

import com.myfun.repository.searchdb.po.SearchSosoViewCount;
import com.myfun.repository.searchdb.po.SearchSosoViewCountExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchSosoViewCountMapper extends BaseMapper<SearchSosoViewCount, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(SearchSosoViewCountExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(SearchSosoViewCountExample example);

    /**
     *
     * @mbggenerated
     */
    List<SearchSosoViewCount> selectByExample(SearchSosoViewCountExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") SearchSosoViewCount record, @Param("example") SearchSosoViewCountExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") SearchSosoViewCount record, @Param("example") SearchSosoViewCountExample example);

	/**
	 * 获取查看条数
	 * 
	 * @author 张宏利
	 * @since 2018年5月29日
	 * @param archiveId
	 * @param deptId
	 * @param timeArr
	 * @param dataType
	 * @return
	 */
	int getViewCount(@Param("archiveId") Integer archiveId, @Param("deptId") Integer deptId,
			@Param("viewTimeStart") String viewTimeStart, @Param("dataType") Byte dataType);
	
	/**
	 * 查看门店已查看历史数据的总量
	 * @param deptId
	 * @param viewTimeStart
	 * @param viewTimeEnd
	 * @return
	 */
	int getDeptViewCount(@Param("deptId") Integer deptId, @Param("viewTimeStart") String viewTimeStart, @Param("viewTimeEnd") String viewTimeEnd);

}


