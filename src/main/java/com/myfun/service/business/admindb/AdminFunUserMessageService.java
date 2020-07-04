package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunUserMessageService extends BaseMapper<AdminFunUserMessage, Integer> {

	AdminFunUserMessage getUserMessage(CaseInfoDto caseInfoDto, Integer caseType, boolean judgeNowUser,
			Integer archiveId, String userName);
	
	
	void createWriteTrackByViewMessage(Integer cityId, Integer compId, Integer archiveId, Integer caseId, Integer caseType, Byte caseUseage, Integer msgModule);
	
	public void insertMessage(AdminFunUserMessage insert, Integer invalidHour);
}
