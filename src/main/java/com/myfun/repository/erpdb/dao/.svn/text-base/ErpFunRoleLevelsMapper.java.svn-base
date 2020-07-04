package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunRoleLevels;
import com.myfun.repository.erpdb.po.ErpFunRoleLevelsExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunRoleLevelsMapper extends BaseMapper<ErpFunRoleLevels, ErpFunRoleLevels> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRoleLevelsExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRoleLevelsExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunRoleLevels> selectByExample(ErpFunRoleLevelsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunRoleLevels record,
			@Param("example") ErpFunRoleLevelsExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunRoleLevels record, @Param("example") ErpFunRoleLevelsExample example);

	/**
	 * 获取角色下最大的职级序号
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年7月30日 下午8:12:21
	 */
	Integer getMaxRoleLevelSeqNo(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("roleId") String roleId);

    Integer getRoleLowRoleLeveLId(@Param("shardCityId")Integer cityId,@Param("roleId") String roleId,@Param("compId") Integer compId);
}