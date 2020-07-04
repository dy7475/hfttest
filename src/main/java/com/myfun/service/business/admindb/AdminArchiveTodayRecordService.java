package com.myfun.service.business.admindb;

import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.po.AdminArchiveTodayRecord;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminArchiveTodayRecordService extends BaseMapper<AdminArchiveTodayRecord, Integer> {

	String getArchiveTodayData(Operator operator, String biddingType);
}
