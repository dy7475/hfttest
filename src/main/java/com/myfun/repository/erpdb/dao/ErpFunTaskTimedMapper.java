package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunTaskTimed;
import com.myfun.repository.erpdb.po.ErpFunTaskTimedExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ErpFunTaskTimedMapper extends BaseMapper<ErpFunTaskTimed, ErpFunTaskTimed> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunTaskTimedExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunTaskTimedExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunTaskTimed> selectByExample(ErpFunTaskTimedExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunTaskTimed record, @Param("example") ErpFunTaskTimedExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunTaskTimed record, @Param("example") ErpFunTaskTimedExample example);

	void insertList(@Param("shardCityId")Integer cityId,@Param("list") List<ErpFunTaskTimed> taskTimedList);

	List<Map<String, Object>> selectTaskTimedUserInfoListByTaskId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("taskId")Integer taskId);

    void updateTaskTimedByCondition(@Param("shardCityId")Integer cityId,@Param("param") Map<String,Object> param);
}