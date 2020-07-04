package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminFunExperienceAccount;
import com.myfun.repository.admindb.po.AdminFunExperienceAccountExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminFunExperienceAccountMapper extends BaseMapper<AdminFunExperienceAccount, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminFunExperienceAccountExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminFunExperienceAccountExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminFunExperienceAccount> selectByExample(AdminFunExperienceAccountExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminFunExperienceAccount record, @Param("example") AdminFunExperienceAccountExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminFunExperienceAccount record, @Param("example") AdminFunExperienceAccountExample example);
	
    /**
     * 修改最后登录时间
     * @param
     * @auther 胡坤
     * @since 2018/4/23
     * @return
     *
     */
	void updateLastLoginTime(@Param("id") Integer id,@Param("lastLoginTime") Date lastLoginTime);
 
	/**
	 * 通过macAddr获取数据
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/26
	 * @return
	 *
	 */
    AdminFunExperienceAccount getFunExperienceAccount(@Param("macAddr") String macAddr);
}