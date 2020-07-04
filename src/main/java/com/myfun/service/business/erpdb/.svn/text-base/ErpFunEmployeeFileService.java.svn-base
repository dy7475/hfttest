package com.myfun.service.business.erpdb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.employeeFiles.param.UploadEmployeeFileParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunEmployeeLogDto;
import com.myfun.repository.erpdb.po.ErpFunEmployeeFile;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunEmployeeFileService extends BaseMapper<ErpFunEmployeeFile, ErpFunEmployeeFile>{

	void delEmployeeFile(Integer cityId, String[] fildIds, Integer compId, Integer deptId, Integer userId, Integer refrenceUserId);
	
	PageInfo<ErpFunEmployeeLogDto> getEnclosureLogs(Integer cityId, Integer compId, Integer userId, BaseMapParam param);
	
	List<ErpFunEmployeeFile> uploadEmployeeFile(UploadEmployeeFileParam param);
}
