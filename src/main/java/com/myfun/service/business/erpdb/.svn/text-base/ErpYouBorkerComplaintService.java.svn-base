package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.admindb.param.YouComplaintProcessParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.erpdb.dto.ErpYouBorkerComplaintDto;
import com.myfun.repository.erpdb.po.ErpYouBorkerComplaint;
import com.myfun.repository.erpdb.po.ErpYouShareHouseStatus;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouBorkerComplaintService  extends BaseMapper<ErpYouBorkerComplaint, ErpYouBorkerComplaint>{

	int getNotComPlainCounts(Integer cityId, Integer shareId);

	int getHouseComPlainCounts(Integer cityId, Integer shareId);

	int getPurchasePersonNumber(Integer cityId, Integer shareId);

	List<ErpYouBorkerComplaintDto> getCompalinListByShareId(ErpYouShareHouseStatus erpYouShareHouseStatus);

	ErpYouBorkerComplaint getByPrimaryKey(Integer cityId, Integer complainId);

	String saveProcess(YouComplaintProcessParam param, AdminCrmUser adminCrmUser);

}
