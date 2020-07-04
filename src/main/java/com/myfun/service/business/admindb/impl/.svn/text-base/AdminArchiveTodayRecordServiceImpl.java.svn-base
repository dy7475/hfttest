package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.dao.AdminArchiveTodayRecordMapper;
import com.myfun.repository.admindb.po.AdminArchiveTodayRecord;
import com.myfun.repository.admindb.po.AdminArchiveTodayRecordExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminArchiveTodayRecordService;

/**
 * 城市
 * 
 * @author Administrator
 *
 */
@Service
public class AdminArchiveTodayRecordServiceImpl extends AbstractService<AdminArchiveTodayRecord, Integer>implements AdminArchiveTodayRecordService {
	@Autowired
	private AdminArchiveTodayRecordMapper adminArchiveTodayRecordMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminArchiveTodayRecordMapper;
	}

	@Override
	public String getArchiveTodayData(Operator operator, String biddingType) {
		Integer archiveId = operator.getArchiveId();
		if (operator.isPersonalVersion()) {
			AdminArchiveTodayRecordExample adminArchiveTodayRecordExample = new AdminArchiveTodayRecordExample();
			adminArchiveTodayRecordExample.createCriteria().andArchiveIdEqualTo(archiveId).andBiddingTypeEqualTo(Integer.valueOf(biddingType))
					.andCreationTimeGreaterThanOrEqualTo(new Date());
			List<AdminArchiveTodayRecord> listOne = adminArchiveTodayRecordMapper.selectByExample(adminArchiveTodayRecordExample);
			if (listOne.size() <= 0) {
				AdminArchiveTodayRecord adminArchiveTodayRecord = new AdminArchiveTodayRecord();
				adminArchiveTodayRecord.setArchiveId(archiveId);
				adminArchiveTodayRecord.setBiddingType(Integer.valueOf(biddingType));
				adminArchiveTodayRecord.setCreationTime(new Date());
				adminArchiveTodayRecordMapper.insertSelective(adminArchiveTodayRecord);
				return "1";
			}
		}
		return "0";
	}
}
