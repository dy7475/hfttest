package com.myfun.service.business.admindb.impl;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminZhiYeViewLogMapper;
import com.myfun.repository.admindb.po.AdminZhiYeViewLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminZhiYeViewLogService;

/**
 * 知业查看记录表相关操作
 * @author 张宏利
 * @since 2017年6月22日
 */
@Service
public class AdminZhiYeViewLogServiceImpl extends AbstractService<AdminZhiYeViewLog, Integer> implements AdminZhiYeViewLogService {
	@Autowired
	private AdminZhiYeViewLogMapper adminZhiYeViewLogMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminZhiYeViewLogMapper;
	}

	@Override
	public Integer createViewLog(Integer archiveId, String coursesType, String coursesId, String mediaId, String subjectId) {
		AdminZhiYeViewLog viewLog = new AdminZhiYeViewLog();
		viewLog.setArchiveId(archiveId);
		viewLog.setCreateTime(new Date());
		viewLog.setErrCode(0);
		viewLog.setErrMsg("success");
		viewLog.setViewSource(Byte.valueOf("0"));// 0知业 1Erp
		viewLog.setCoursesType(coursesType);
		viewLog.setCoursesId(coursesId);
		viewLog.setMediaId(mediaId);
		viewLog.setSubjectId(subjectId);
		int insertCount = adminZhiYeViewLogMapper.insertSelective(viewLog);
		return insertCount;
	}
}


