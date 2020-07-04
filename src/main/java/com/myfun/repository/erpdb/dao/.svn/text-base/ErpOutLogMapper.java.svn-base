package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;

import com.myfun.service.business.erpdb.bean.param.QueryOutLogParam;
import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.openApi.attendance.vo.ErpOutLogVO;
import com.myfun.repository.erpdb.dto.ErpOutLogDto;
import com.myfun.repository.erpdb.param.OutLogRecordParam;
import com.myfun.repository.erpdb.po.ErpOutLog;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.DaoBaseParam;
import com.myfun.service.business.erpdb.bean.param.QueryOutLogParam;
import com.myfun.repository.erpdb.po.ErpOutLogExample;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpOutLogMapper extends BaseMapper<ErpOutLog, ErpOutLog> {
	/**
	 * @mbggenerated
	 */
	int countByExample(ErpOutLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpOutLogExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpOutLog> selectByExample(ErpOutLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpOutLog record, @Param("example") ErpOutLogExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpOutLog record, @Param("example") ErpOutLogExample example);

	List<ErpOutLogDto> selectOutLogList(@Param("shardCityId")Integer cityId, @Param("param")QueryOutLogParam param, @Param("deptIds") String[] deptIds);
	
	/**
	 * 
	 * @param cityId
	 * @param param
	 * @param deptIds
	 * @return
	 */
	List<ErpOutLogDto> selectOutLogListByDeptAndUserId(@Param("shardCityId") Integer cityId, @Param("param") QueryOutLogParam param, @Param("userIds") List<Integer> userIds, @Param("deptIds") List<Integer> deptIds);

	ErpOutLog selectOutLogByUserIdAndBlankBackTime(@Param("shardCityId")Integer cityId,
			@Param("outUser")Integer currentUserId);
	
	/**
	 * 
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/25
	 * @return 
	 * 
	 */
	void updateBackTimeByUserId(@Param("shardCityId")Integer cityId,@Param("userId")Integer userId,@Param("date") Date date);
	
	/**
	 * 外出统计记录
	 * @author 朱科
	 * @since 2018年7月19日
	 * @return
	 */
	List<ErpOutLogDto> getOutLogRecordList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("param")OutLogRecordParam param);
	
	
	List<ErpOutLogVO> getOutLogRecordVoList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("param")OutLogRecordParam param);
	
	/**
	 * 外出审核签到记录
	 * @author 朱科
	 * @since 2018年7月19日
	 * @return
	 */
	List<ErpOutLogDto> getOutLogAuditCheckRecordList(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("auditId")Integer auditId);
}