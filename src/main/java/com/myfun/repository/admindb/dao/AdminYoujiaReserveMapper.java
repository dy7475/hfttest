package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.dto.AdminYoujiaReserveDto;
import com.myfun.repository.admindb.po.AdminYoujiaReserve;
import com.myfun.repository.admindb.po.AdminYoujiaReserveExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminYoujiaReserveMapper extends BaseMapper<AdminYoujiaReserve, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminYoujiaReserveExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminYoujiaReserveExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminYoujiaReserve> selectByExample(AdminYoujiaReserveExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminYoujiaReserve record,
			@Param("example") AdminYoujiaReserveExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminYoujiaReserve record,
			@Param("example") AdminYoujiaReserveExample example);

	List<AdminYoujiaReserveDto> getDaiKanList(@Param("cityId")Integer cityId, @Param("compId") Integer compId,
											  @Param("deptId")Integer deptId, @Param("grId")Integer grId, @Param("keyWords")String keyWords,
											  @Param("userId")Integer userId, @Param("startTime")Date startTime, @Param("endTime")Date endTime);

	AdminYoujiaReserve selectNotFinish(@Param("cityId")Integer cityId, @Param("compId")Integer compId, @Param("cellEncode")String cellEncode);
}