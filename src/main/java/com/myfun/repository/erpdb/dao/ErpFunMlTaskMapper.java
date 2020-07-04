package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.task.param.TaskListParam;
import com.myfun.repository.erpdb.po.ErpFunMlTask;
import com.myfun.repository.erpdb.po.ErpFunMlTaskExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunMlTaskMapper extends BaseMapper<ErpFunMlTask, ErpFunMlTask> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunMlTaskExample example);
	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunMlTaskExample example);
	/**
	 * @mbggenerated
	 */
	List<ErpFunMlTask> selectByExample(ErpFunMlTaskExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunMlTask record, @Param("example") ErpFunMlTaskExample example);
	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunMlTask record, @Param("example") ErpFunMlTaskExample example);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void  insertRecieveTaskBatch(@Param("shardCityId")Integer shardCityId ,@Param("erpFunMlTaskList") List<ErpFunMlTask> erpFunMlTaskList);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getDelayTaskId(@Param("shardCityId")Integer shardCityId ,@Param("sendUserId") Integer sendUserId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getNotCompleteTaskId(@Param("shardCityId")Integer shardCityId ,@Param("sendUserId") Integer sendUserId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getUnableCompleteTaskId(@Param("shardCityId")Integer shardCityId ,@Param("sendUserId") Integer sendUserId);
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<Integer> getCompleteTaskid(@Param("shardCityId")Integer shardCityId ,@Param("sendUserId") Integer sendUserId);
	List<ErpFunMlTask> getTaskList(@Param("shardCityId")Integer cityId, @Param("param")TaskListParam sendTaskParam);
	int countTaskCount(@Param("shardCityId")Integer cityId, @Param("param")TaskListParam sendTaskParam);
	
	void updateCompleteStatus(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("completeTaskTime") Date completeTaskTime, @Param("taskId")Integer sendTaskId);
}