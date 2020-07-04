package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunErpUserGuide;
import com.myfun.repository.admindb.po.AdminFunErpUserGuideExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunErpUserGuideMapper extends BaseMapper<AdminFunErpUserGuide, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunErpUserGuideExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunErpUserGuideExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunErpUserGuide> selectByExample(AdminFunErpUserGuideExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunErpUserGuide record, @Param("example") AdminFunErpUserGuideExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunErpUserGuide record, @Param("example") AdminFunErpUserGuideExample example);
	
    /**
     * 获取所有的待引导页面列表
     * @param 
     * @auther 胡坤
     * @since 2018/4/25
     * @return 
     * 
     */
	List<AdminFunErpUserGuide> getAllGuideListByArchiveId(@Param("archiveId") Integer archiveId);
	
	/**
	 * 修改引导状态
	 * @author 朱科
	 * @since 2018年7月13日
	 * @return
	 */
	int updateUserGuide(@Param("status")Integer status, @Param("archiveId")Integer archiveId, @Param("guideType")String guideType, @Param("updateTime")String updateTime);
}