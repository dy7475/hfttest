package com.myfun.repository.admindbRpt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.myfun.repository.admindbRpt.po.AdminRptVInquiryDianhua;
import com.myfun.repository.admindbRpt.po.AdminRptVPropertyDongzuo;
import com.myfun.repository.admindbRpt.po.AdminRptVPropertyDongzuoExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminRptVPropertyDongzuoMapper extends BaseMapper<AdminRptVPropertyDongzuo, String> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminRptVPropertyDongzuoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminRptVPropertyDongzuoExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminRptVPropertyDongzuo> selectByExample(AdminRptVPropertyDongzuoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminRptVPropertyDongzuo record, @Param("example") AdminRptVPropertyDongzuoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminRptVPropertyDongzuo record, @Param("example") AdminRptVPropertyDongzuoExample example);
    
	List<AdminRptVPropertyDongzuo> getTop100List();

	void updateWaitingToNull();
}