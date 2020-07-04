package com.myfun.repository.agencydb.dao;

import com.myfun.repository.agencydb.po.AgencyWfUserb;
import com.myfun.repository.agencydb.po.AgencyWfUserbExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AgencyWfUserbMapper extends BaseMapper<AgencyWfUserb, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AgencyWfUserbExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AgencyWfUserbExample example);

    /**
     *
     * @mbggenerated
     */
    List<AgencyWfUserb> selectByExample(AgencyWfUserbExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AgencyWfUserb record, @Param("example") AgencyWfUserbExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AgencyWfUserb record, @Param("example") AgencyWfUserbExample example);
	
	/**
	 * 是否关注好房精英会
	 * @author 张宏利
	 * @since 2018年4月9日
	 * @param archiveId
	 * @return
	 */
	AgencyWfUserb getByArchiveId(@Param("archiveId") Integer archiveId);
}