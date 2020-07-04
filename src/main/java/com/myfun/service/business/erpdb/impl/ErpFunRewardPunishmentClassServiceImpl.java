package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunRewardPunishmentClassMapper;
import com.myfun.repository.erpdb.dao.ErpFunRewardPunishmentMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentClassParam;
import com.myfun.repository.erpdb.param.ErpFunRewardPunishmentParam;
import com.myfun.repository.erpdb.po.ErpFunAttendanceUserClassDetail;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishment;
import com.myfun.repository.erpdb.po.ErpFunRewardPunishmentClass;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunRewardPunishmentClassService;
import com.myfun.service.business.erpdb.ErpFunRewardPunishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunRewardPunishmentClassServiceImpl extends AbstractService<ErpFunRewardPunishmentClass, ErpFunRewardPunishmentClass> implements ErpFunRewardPunishmentClassService {

	@Autowired
	ErpFunRewardPunishmentClassMapper erpFunRewardPunishmentClassMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunRewardPunishmentClassMapper;
	}

	@Transactional
	@Override
	public void addEditRewardPunishmentClass(Integer cityId, Integer compId, ErpFunRewardPunishmentClassParam erpFunRewardPunishmentClassParam) {

		List<ErpFunRewardPunishmentClass> erpFunAttendanceGroupBizList = JSON.parseObject(erpFunRewardPunishmentClassParam.getRewardPunishmentClassList(), new TypeReference<List<ErpFunRewardPunishmentClass>>() {});

		Integer dataLength = erpFunAttendanceGroupBizList.size();
		if(dataLength == 0) {
			throw new BusinessException("至少保留一个奖罚类型");
		}
		dataLength ++ ;

		for (ErpFunRewardPunishmentClass erpFunRewardPunishmentClass : erpFunAttendanceGroupBizList) {
			if(null == erpFunRewardPunishmentClass.getAmount()) {
				erpFunRewardPunishmentClass.setAmount(new BigDecimal(0));
			}
			erpFunRewardPunishmentClass.setClassSeq(dataLength);
			erpFunRewardPunishmentClass.setShardCityId(cityId);
			if(null != erpFunRewardPunishmentClass.getId()) {
				erpFunRewardPunishmentClassMapper.updateByPrimaryKeySelective(erpFunRewardPunishmentClass);
			}else {
				erpFunRewardPunishmentClass.setCompId(compId);
				erpFunRewardPunishmentClass.setCreateTime(new Date());
				erpFunRewardPunishmentClassMapper.insertSelective(erpFunRewardPunishmentClass);
			}
			dataLength -- ;
		}
	}

	/**
	 * @Title 删除奖罚类别
	 * @Author lcb
	 * @Date 2017/12/26
	 * @Param
	 **/
	@Override
	public void delRewardPunishmentClass(Integer cityId, Integer compId, ErpFunRewardPunishmentClassParam erpFunRewardPunishmentClassParam) {
		ErpFunRewardPunishmentClass erpFunRewardPunishmentClass = new ErpFunRewardPunishmentClass();
		erpFunRewardPunishmentClass.setShardCityId(cityId);
		erpFunRewardPunishmentClass.setId(erpFunRewardPunishmentClassParam.getId());
		erpFunRewardPunishmentClass.setIsDel((byte) 1);
		erpFunRewardPunishmentClassMapper.updateByPrimaryKeySelective(erpFunRewardPunishmentClass);
	}
}
