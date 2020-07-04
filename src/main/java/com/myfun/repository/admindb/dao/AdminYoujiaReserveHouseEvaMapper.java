package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.dto.AdminYoujiaReserveHouseEvaDto;
import com.myfun.repository.admindb.po.AdminYoujiaReserveHouseEva;
import com.myfun.repository.admindb.po.AdminYoujiaReserveHouseEvaExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.annotations.Param;

public interface AdminYoujiaReserveHouseEvaMapper extends BaseMapper<AdminYoujiaReserveHouseEva, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminYoujiaReserveHouseEvaExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminYoujiaReserveHouseEvaExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminYoujiaReserveHouseEva> selectByExample(AdminYoujiaReserveHouseEvaExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminYoujiaReserveHouseEva record,
			@Param("example") AdminYoujiaReserveHouseEvaExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminYoujiaReserveHouseEva record,
			@Param("example") AdminYoujiaReserveHouseEvaExample example);

	List<AdminYoujiaReserveHouseEvaDto> getList(@Param("resIds") Set<Integer> resIds);

	List<AdminYoujiaReserveHouseEva> getListByHouseIds(@Param("cityId") Integer cityId, @Param("houseIds") List<Integer> houseIds,
													   @Param("caseType") Byte  caseType, @Param("userMobile") String userMobile);
}