package com.myfun.repository.admindb.dao;

import java.util.List;

import com.myfun.repository.admindb.dto.AdminApartmentCountDto;
import com.myfun.repository.admindb.po.AdminFunApartmentRoom;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunApartmentRoomMapper extends BaseMapper<AdminFunApartmentRoom, String> {

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminFunApartmentRoom record);

	List<AdminFunApartmentRoom> getRoomNumList(AdminFunApartmentRoom adminFunApartmentRoom);

	AdminApartmentCountDto getRoomGirlBoyCount(String apartmentUuid);

	void updateByApartmentUuid(AdminFunApartmentRoom room);
}