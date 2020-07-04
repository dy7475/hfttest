package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminBulletYouUsers;
import com.myfun.repository.admindb.po.AdminBulletYouUsersExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminBulletYouUsersMapper extends BaseMapper<AdminBulletYouUsers, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminBulletYouUsersExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminBulletYouUsersExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminBulletYouUsers> selectByExample(AdminBulletYouUsersExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminBulletYouUsers record, @Param("example") AdminBulletYouUsersExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminBulletYouUsers record, @Param("example") AdminBulletYouUsersExample example);

    void updateIsView(@Param("bulletId")Integer bulletId, @Param("cityId")Integer cityId, @Param("userId") Integer userId);
}