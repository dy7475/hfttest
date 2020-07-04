package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunTaskDto;
import com.myfun.repository.erpdb.po.ErpFunTask;
import com.myfun.repository.erpdb.po.ErpFunTaskExample;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunTaskMapper extends BaseMapper<ErpFunTask, ErpFunTask> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunTaskExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunTaskExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunTask> selectByExample(ErpFunTaskExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunTask record, @Param("example") ErpFunTaskExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunTask record, @Param("example") ErpFunTaskExample example);

	Integer getId(Short shardCityId);

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param compId
	 * @param conditionModel
	 */
	List<ErpFunTask> selectFunTaskByConditionModel(@Param("shardCityId")Integer shardCityId, @Param("conditionModel")ErpFunTask conditionModel);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param shardCityId
	 * @param insertModel
	 */
	void insertModel(@Param("shardCityId")Integer shardCityId,@Param("insertModel") ErpFunTask insertModel);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param updateModel
	 * @param conditionModel
	 * @param trackTypes
	 */
	void updateFunTask(@Param("shardCityId")Integer cityId, @Param("updateModel")ErpFunTask updateModel, @Param("conditionModel")ErpFunTask conditionModel,@Param("trackTypes")Object[] trackTypes);

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param compId
	 */
	void updateKeyTaskByKeyId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("keyIds")Object[] keyIds);

	/**
	 * @author 方李骥
	 * @since 2016年9月6日
	 * @param cityId
	 * @param conditionModel
	 * @return
	 */
	Integer countFunTask(@Param("shardCityId")Integer cityId,@Param("conditionModel")ErpFunTask conditionModel);

	/**
	 * 获取审核任务列表
	 * @author 臧铁
	 * @param param  
	 * @since 2017年6月28日
	 * @return
	 */
	List<ErpFunTaskDto> getNewExaminTask(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> map);

	/**
	 * 查询提醒任务列表
	 * @author 臧铁
	 * @since 2017年7月4日
	 * @param map  time 时间（全部=空 一周=2 一月=3 一季=4）	taskOwner   任务主管
	 * @param map  deptId  部门ID	caseType   出售=1 出租=2 求购=3 求租=4 出售合同=101 出租合同=102
	 * @param map  caseNO   任务编号		isRead   已读标记，1=是0=否
	 * @return
	 */
	List<ErpFunTaskDto> getWarmTaskList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 通过taskId查询单个任务对象
	 * @author 臧铁
	 * @since 2017年7月4日
	 * @param erpFunTaskDto  taskId 任务ID
	 * @return
	 */
	ErpFunTaskDto selectDtoByPrimaryKey(ErpFunTaskDto erpFunTaskDto);
	
	/**
	 * 钥匙任务处理之后把另外的钥匙任务失效
	 * @author 张宏利
	 * @since 2017年10月27日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 * @param taskSolute
	 */
	void updateKeyTaskToClose(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseId")Integer caseId,@Param("caseType")Integer caseType,@Param("taskSolute")String taskSolute);

	void updateFunTaskByTrackIds(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,
			@Param("trackIds")Integer[] trackIds,@Param("typeFlag")String typeFlag,
			@Param("taskStatus")Byte taskStatus,@Param("taskTypes")Byte[] taskTypes,
			@Param("content")String content);
	
	void updateStatusToCancelByPhone(@Param("shardCityId")Integer cityId,@Param("nweTaskStatus")Byte nweTaskStatus,
			@Param("content")String content,@Param("typeFlag")String typeFlag,@Param("taskStatus")Byte taskStatus,
			@Param("taskType")Byte[] taskType,@Param("caseType")Integer caseType,@Param("caseIds")Integer[] caseIds,
			@Param("compId")Integer compId);

	void updateErpFunTask(@Param("shardCityId")Integer cityId,@Param("updateTypeStatus")String updateTypeStatus,@Param("content")String content,@Param("compId") Integer compId, @Param("idArr")String[] idArr,@Param("typeFlag")String typeFlag,
			@Param("typeStatus")String typeStatus, @Param("taskType")String[] taskType);
	
	/**
	 * 查询提醒任务列表
	 * @author 熊刚
	 * @since 2017年11月8日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @return
	 */
	List<ErpFunTaskDto> getErpFunTaskList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("param") Map<String, Object> param);

	ErpFunTaskDto getErpFunTaskById(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("taskId") Integer taskId);
	
	/**
	 * 获取未读人员数量
	 * @author 张宏利
	 * @since 2017年12月12日
	 * @param taskIdSet
	 * @return
	 */
	List<Map<String, Object>> getNotReadUserCount(@Param("shardCityId")Integer cityId, @Param("taskIdSet") Set<Integer> taskIdSet);

	@AccessReadonlyDb
	List<ErpFunTask> getBulletinWarmTask(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("compId") Integer compId,
							 @Param("startTime") String startTime,@Param("endTime") String endTime);


	void updateTaskStatus(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> param);

	void updateTaskReadFlag(@Param("shardCityId") Integer cityId,@Param("param") Map<String,Object> param);

	@AccessReadonlyDb
	int getWarmTaskCount(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userId") Integer userId,@Param("time1") String time1,@Param("time2") String time2);
}