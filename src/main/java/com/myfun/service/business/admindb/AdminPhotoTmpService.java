package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminPhotoTmp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminPhotoTmpService extends BaseMapper<AdminPhotoTmp, String>{

	void deleteByEcardAddr(String ecardAddr);
	void updatePhotoTmp(String[] urlsArr);

}
