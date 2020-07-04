package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.businesstools.Attendance.param.AttendanceOnAndOffParam;
import com.myfun.erpWeb.businesstools.Attendance.param.AttendanceParam;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dto.ErpAttendanceDto;
import com.myfun.repository.erpdb.po.ErpAttendance;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.mybatis.common.BaseMap;
import com.myfun.repository.support.mybatis.query.Columns;
import com.myfun.repository.support.mybatis.query.Condition;
import com.myfun.repository.support.mybatis.query.ConditionItem;
import com.myfun.repository.support.mybatis.query.SQL;
import com.myfun.repository.support.mybatis.query.SQLBuilderSupport;
import com.myfun.repository.support.mybatis.query.SqlFactory;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.repository.erpdb.po.ErpAttendanceExample;
import org.apache.ibatis.annotations.Param;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAttendanceMapper extends BaseMapper<ErpAttendance, ErpAttendance> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAttendanceExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAttendanceExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAttendance> selectByExample(ErpAttendanceExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAttendance record, @Param("example") ErpAttendanceExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAttendance record, @Param("example") ErpAttendanceExample example);

	@SelectProvider(method = "selectAttendanceListByParam", type = AttendanceSqlProvider.class)
	@ResultMap(value = { "DtoBaseResultMap" })
	List<ErpAttendanceDto> selectAttendanceListByParam(@Param("shardCityId")Integer cityId,
			@Param("param")Map<String, Object> map);

	ErpAttendance selectByDateAndUserId(@Param("shardCityId")Integer cityId, @Param("nowDate")String nowDate, @Param("userId")Integer userId,@Param("workOnType")String workOnType,@Param("workOffType")String workOffType);

	List<ErpAttendance> selectStatList(@Param("shardCityId")Integer cityId,@Param("param") Map<String,Object> param);
	@SelectProvider(method = "getAttendanceOnAndOff", type = AttendanceSqlProvider.class)
	@ResultType(Map.class)
	Map<String, Object> getAttendanceOnAndOff(@Param("shardCityId")Integer cityId,@Param("param") AttendanceOnAndOffParam param);
	
	/**
	 * 根据用户获取上班打卡次数和下班打卡次数
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return 
	 * 
	 */
	@ResultType(Map.class)
	Map<String,String> getAttendanceByUserId(@Param("shardCityId") Integer cityId,@Param("compId")  Integer compId,@Param("deptId") Integer deptId,@Param("userId") Integer userId,@Param("date") Date date);

	List<ErpAttendanceDto> getAttendanceList(@Param("shardCityId")Integer cityId,@Param("param") AttendanceParam param);

	class AttendanceSqlProvider{
		public String selectAttendanceListByParam(Map<String,Object> pMap) throws Exception{
			BaseMap param = (BaseMap) pMap.get("param");
			String workStatus = param.getString("workStatus");
			String attendanceModel = param.getString("attendanceModel");
			String workType = param.getString("workType");
			String orderBy = param.getString("orderBy");
			String tableName = " ATTENDANCE ";
			Condition condition = new Condition();
			if(!StringUtils.isBlank(workStatus)){
	  			Condition cond = new Condition();
	  			cond.add(new  ConditionItem("ATT_ON_STATUS","=", workStatus));
	  			cond.add(condition.OR, new  ConditionItem("ATT_OFF_STATUS","=", workStatus));
	  			condition.add(cond);
	  		}
	  		condition.add(new ConditionItem("COMP_ID","=", param.getInteger("compId")));
	  		if("1".equals(attendanceModel)){
				if(StringUtils.isNotBlank(workType)){
					Condition queryCondition = new Condition();
					queryCondition.add(new ConditionItem("WORK_ON_TYPE","=",workType));
					queryCondition.add(Condition.OR,new ConditionItem("WORK_OFF_TYPE","=",Constants_DIC.WORKONTOOFF.get(workType)));
					condition.add(queryCondition);
				}
			}
	  		String attDate1 = param.getString("attDate1");
	  		String attDate2 = param.getString("attDate2");
	  		if(!StringUtils.isBlank(param.getString("attDate1")) && !StringUtils.isBlank(param.getString("attDate2"))){
	  			condition.add(new ConditionItem("ATT_DATE", ">=", DateTimeHelper.formatDateTimetoString(attDate1, "yyyy-MM-dd 00:00:00"),true));
	  			condition.add(new ConditionItem("ATT_DATE", "<=", DateTimeHelper.formatDateTimetoString(attDate2, "yyyy-MM-dd 23:59:59"),true));
			}
	  		String userId = param.getString("userId");
	  		if(StringUtils.isNotBlank(userId)){
	  			condition.add(new ConditionItem("ATT_USER","=",userId));
	  		}
	  		String[] deptIds = (String[]) param.getObject("deptIds");
	  		if(deptIds!=null){
	  			condition.add(new ConditionItem("DEPT_ID","IN",deptIds));
	  		}
	  		Columns columns = new Columns(
	  		new String[]{
	  			" ATT_ID, COMP_ID, DEPT_ID, ATT_USER, ATT_DATE, WORK_ON_TYPE, ATT_ON_STATUS, ATT_ON_TIME,  ATT_LATE_TIME, ATT_LATE_REASON, WORK_OFF_TYPE, ATT_OFF_STATUS, ATT_OFF_TIME, ATT_EARLY_TIME,  ATT_EARLY_REASON, UPDATE_USER, UPDATE_TIME, CREATE_WORKON_USER, CREATE_WORKOFF_USER"
	  		});
	  		if(StringUtils.isBlank(orderBy)){
	  			orderBy = "ATT_DATE desc,ATT_ID desc";
	  		}
	  		SQL sql = SqlFactory.createDelFaultSelectSql(tableName, false, condition, columns, orderBy, null);
			SQLBuilderSupport.constructSQLForSelect(sql);
	  		return SQLBuilderSupport.constructSQLForSelect(sql).toString();
			
		}
		public String getAttendanceOnAndOff(Map<String,Object> pMap) throws Exception{
			AttendanceOnAndOffParam param = (AttendanceOnAndOffParam) pMap.get("param");
			String[] deptIds = param.getDeptIds();
			String attendanceModel = param.getAttendanceModel();
			String workType = param.getWorkType();
			Condition condition = new Condition();
			condition.add(new ConditionItem("COMP_ID", "=",param.getCompId()));
			condition.add(new ConditionItem("ATT_DATE", ">=", DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd 00:00:00"),true));
			condition.add(new ConditionItem("ATT_DATE", "<=", DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd 23:59:59"),true));
			if(deptIds!=null){
				condition.add(new ConditionItem("DEPT_ID","IN",deptIds));
			}
			Columns columns = new Columns(
					new String[]{
							"sum(iif(ATT_ON_TIME IS NULL,0,1)) as ON_WORK",
							"sum(iif(ATT_OFF_TIME IS NULL,0,1)) as OFF_WORK"
							});
			if("1".equals(attendanceModel)){
				if(StringUtils.isNotBlank(workType)){
					Condition queryCondition = new Condition();
					queryCondition.add(new ConditionItem("WORK_ON_TYPE","=",workType));
					queryCondition.add(Condition.OR,new ConditionItem("WORK_OFF_TYPE","=",Constants_DIC.WORKONTOOFF.get(workType)));
					condition.add(queryCondition);
				}
				StringBuilder sqlBuilder = new StringBuilder();
				sqlBuilder.append(" with t_count as(")
				.append(" select ATT_USER,sum(iif(ATT_ON_TIME IS NULL,0,1)) as ON_WORK,sum(iif(ATT_OFF_TIME IS NULL,0,1)) as OFF_WORK from ATTENDANCE where ");
				sqlBuilder.append(condition.getConditionStatement(1));
				sqlBuilder.append(" group by ATT_USER");
				sqlBuilder.append(")");
				sqlBuilder.append("select sum(iif(ON_WORK>0,1,0)) as onWork,sum(iif(OFF_WORK>0,1,0)) as offWork from t_count ");
				return sqlBuilder.toString();
			}
			SQL sql = SqlFactory.createDelFaultSelectSql("ATTENDANCE", false, condition, columns, null,null);
			return SQLBuilderSupport.constructSQLForSelect(sql).toString();
		}
		
	}
}