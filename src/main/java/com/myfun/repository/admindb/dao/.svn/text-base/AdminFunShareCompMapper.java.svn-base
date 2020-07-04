package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.common.vo.JoinCircleListVO;
import com.myfun.repository.admindb.po.AdminFunShareComp;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.myfun.repository.admindb.po.AdminFunShareCompExample;
import java.util.List;

public interface AdminFunShareCompMapper extends BaseMapper<AdminFunShareComp, Integer> {
	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunShareCompExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunShareCompExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunShareComp> selectByExample(AdminFunShareCompExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunShareComp record,
			@Param("example") AdminFunShareCompExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunShareComp record, @Param("example") AdminFunShareCompExample example);

	/**
	 * 通过compNo获取楼盘资料审核权
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/2
	 * @return
	 *
	 */
	AdminFunShareComp getDataByLogin(@Param("compNo")String compNo);

    List<JoinCircleListVO> getShareCompList(@Param("compNo")String compNo);
}