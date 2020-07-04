package com.myfun.service.business.admindb;

import java.util.List;

import com.myfun.repository.admindb.po.AdminTrueHouseComplaint;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminTrueHouseComplaintService extends BaseMapper<AdminTrueHouseComplaint, Integer> {

	// 查询列表
	List<AdminTrueHouseComplaint> getListByCondition(AdminTrueHouseComplaint adminTrueHouseComplaint);

	void updateDownAll(AdminTrueHouseComplaint complaint);


}
