package com.myfun.service.business.admindb;


import com.myfun.repository.admindb.po.AdminContactInfo;
import com.myfun.repository.admindb.po.AdminFunPaidKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminContactInfoService extends BaseMapper<AdminContactInfo, Integer> {
	
	
	void updateByArchiveId(Integer archiveId, String contactFlag, Date updateDate);
}
