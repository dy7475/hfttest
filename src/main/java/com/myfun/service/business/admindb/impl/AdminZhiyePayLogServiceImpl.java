package com.myfun.service.business.admindb.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminZhiyePayLogMapper;
import com.myfun.repository.admindb.po.AdminZhiyePayLog;
import com.myfun.repository.admindb.po.AdminZhiyePayLogExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminZhiYeViewLogService;
import com.myfun.service.business.admindb.AdminZhiyePayLogService;

/**
 * 知业支付记录操作
 * @author 张宏利
 * @since 2017年6月22日
 */
@Service
public class AdminZhiyePayLogServiceImpl extends AbstractService<AdminZhiyePayLog, Integer> implements AdminZhiyePayLogService {
	@Autowired
	private AdminZhiyePayLogMapper adminZhiyePayLogMapper;
	@Autowired
	private AdminZhiYeViewLogService adminZhiYeViewLogService;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminZhiyePayLogMapper;
	}

	@Transactional
	@Override
	public int createPayLog(Integer archiveId, String coursesType, String coursesId, String mediaId, String subjectId, BigDecimal payAmount) {
		adminZhiYeViewLogService.createViewLog(archiveId, coursesType, coursesId, mediaId, subjectId);
		AdminZhiyePayLog record = new AdminZhiyePayLog();
		record.setMediaId(mediaId);
		record.setCoursesType(coursesType);
		record.setCoursesId(coursesId);
		record.setSubjectId(subjectId);
		record.setArchiveId(archiveId);
		record.setCreateTime(new Date());
		record.setPrice(payAmount);
		int insertCount = adminZhiyePayLogMapper.insertSelective(record);
		return insertCount;
	}

	@Override
	public boolean isPay(Integer archiveId, String mediaId) {
		// 判断是否在有效期内
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, -24);
		AdminZhiyePayLogExample example = new AdminZhiyePayLogExample();
		example.createCriteria().andArchiveIdEqualTo(archiveId)
		.andMediaIdEqualTo(mediaId).andCreateTimeGreaterThan(calendar.getTime());
		int count = adminZhiyePayLogMapper.countByExample(example);
		return count > 0;
	}
}

