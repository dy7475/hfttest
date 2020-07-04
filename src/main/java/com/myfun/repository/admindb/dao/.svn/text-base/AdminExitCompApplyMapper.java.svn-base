package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminExitCompApply;
import com.myfun.repository.admindb.po.AdminExitCompApplyExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminExitCompApplyMapper extends BaseMapper<AdminExitCompApply, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminExitCompApplyExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminExitCompApplyExample example);

	/**
	 * @mbggenerated
	 */List<AdminExitCompApply> selectByExample(AdminExitCompApplyExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminExitCompApply record,@Param("example") AdminExitCompApplyExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminExitCompApply record,@Param("example") AdminExitCompApplyExample example);

	/**
     * 通过用户ID和公司ID查询提交信息
     * @author 何传强
     * @since 2017年8月25日
     * @param userId
     * @param compId
     * @return
     */
	AdminExitCompApply getAuditInfo(@Param("userId") Integer userId, @Param("compId") Integer compId,@Param("cityId") Integer cityId);

}