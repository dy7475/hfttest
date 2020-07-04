package com.myfun.repository.admindbRpt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.myfun.repository.admindbRpt.po.AdminRptVInquiryDianhua;
import com.myfun.repository.admindbRpt.po.AdminRptVInquiryDianhuaExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminRptVInquiryDianhuaMapper extends BaseMapper<AdminRptVInquiryDianhua, String> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminRptVInquiryDianhuaExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminRptVInquiryDianhuaExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminRptVInquiryDianhua> selectByExample(AdminRptVInquiryDianhuaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminRptVInquiryDianhua record, @Param("example") AdminRptVInquiryDianhuaExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminRptVInquiryDianhua record, @Param("example") AdminRptVInquiryDianhuaExample example);
    
    @ResultType(AdminRptVInquiryDianhua.class)
    @Select("select top 100 InquiryID inquiryid,cell_phone cellPhone,cell_phone_r cellPhoneR from v_Inquiry_dianhua where cell_phone_r is null or len(cell_phone_r) <= 0")
	List<AdminRptVInquiryDianhua> getTop100List();

	void updateWaitingToNull();
}