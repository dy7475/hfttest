package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminPropertyModuleControl;
import com.myfun.repository.admindb.po.AdminPropertyModuleControlExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPropertyModuleControlMapper extends BaseMapper<AdminPropertyModuleControl, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminPropertyModuleControlExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminPropertyModuleControlExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminPropertyModuleControl> selectByExample(AdminPropertyModuleControlExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminPropertyModuleControl record, @Param("example") AdminPropertyModuleControlExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminPropertyModuleControl record, @Param("example") AdminPropertyModuleControlExample example);
	
    /**
     * 获取物业版本控制数据
     * @param
     * @auther 胡坤
     * @since 2018/4/23
     * @return
     *
     */
	AdminPropertyModuleControl getPropertyModuleControl(@Param("compNo") String compNo,@Param("deptNo") String deptNo);
}