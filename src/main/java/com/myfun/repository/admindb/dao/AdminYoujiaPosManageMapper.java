package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminYoujiaPosManage;
import com.myfun.repository.admindb.po.AdminYoujiaPosManageExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminYoujiaPosManageMapper extends BaseMapper<AdminYoujiaPosManage, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminYoujiaPosManageExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminYoujiaPosManageExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminYoujiaPosManage> selectByExample(AdminYoujiaPosManageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminYoujiaPosManage record,
			@Param("example") AdminYoujiaPosManageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminYoujiaPosManage record,
			@Param("example") AdminYoujiaPosManageExample example);
	
    /**
     * 通过公司和门店编号查询POS机数量
     * @param
     * @auther 胡坤
     * @since 2018/4/24
     * @return
     *
     */
	int getPosCount(@Param("compNo")String compNo,@Param("deptNo") String deptNo);
}