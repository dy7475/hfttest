package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpRenovationCustomerFile;
import com.myfun.service.business.BaseService;

public interface ErpRenovationFileService extends BaseService<ErpRenovationCustomerFile, ErpRenovationCustomerFile> {

	void addRenovationFile(Integer cityId, Integer compId, Integer userId, Integer archiveId, Integer renovationCustomerId,
			String custPhotos, String otherPhotos, String userName);
}
