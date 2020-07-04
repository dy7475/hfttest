package com.myfun.service.business.erpdb.impl;


import com.myfun.repository.erpdb.dao.*;

import com.myfun.repository.erpdb.po.*;

import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.*;

import com.myfun.utils.DateTimeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;


@Service
public class ErpFunUserResumeServiceImpl extends AbstractService<ErpFunUserResume, ErpFunUserResume>implements ErpFunUserResumeService {
	@Autowired
	ErpFunUserResumeMapper erpFunUserResumeMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunUserResumeMapper;
	}

	/**
	 * 添加跟新员工历程
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/8
	 */
	@Override
	public void addOrUpdateUserResume(Integer cityId, Integer compId, Integer userId,Integer id, Integer userIdSelf, Integer archiveId, String occurrenceTime, String eventExplain) {
		ErpFunUserResume erpFunUserResume=new ErpFunUserResume();
		erpFunUserResume.setArchiveId(archiveId);
		erpFunUserResume.setCompId(compId);
		erpFunUserResume.setUpdateTime(new Date());
		erpFunUserResume.setEventExplain(eventExplain);
		erpFunUserResume.setUserId(userId);
		erpFunUserResume.setOccurrenceTime(DateTimeHelper.parseToDate(occurrenceTime));
		erpFunUserResume.setShardCityId(cityId);
		if (id!=null){
			erpFunUserResume.setId(id);
			erpFunUserResumeMapper.updateByPrimaryKeySelective(erpFunUserResume);
		}else {
			erpFunUserResume.setCreateUid(userIdSelf);
			erpFunUserResume.setCreateTime(new Date());
			erpFunUserResume.setIsDel((byte)0);
			erpFunUserResumeMapper.insertSelective(erpFunUserResume);
		}
	}
}