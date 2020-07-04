package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpOutLogMapper;
import com.myfun.repository.erpdb.dto.ErpOutLogDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpOutLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpOutLogService;
import com.myfun.service.business.erpdb.bean.param.CreateOutLogParam;
import com.myfun.service.business.erpdb.bean.param.QueryOutLogParam;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpOutLogServiceImpl extends AbstractService<ErpOutLog, ErpOutLog> implements ErpOutLogService {
	@Autowired
	private ErpOutLogMapper erpOutLogMapper;
	@Autowired
	private ErpFunDeptsService erpFunDeptsService;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = this.erpOutLogMapper;

	}

	@Override
	public List<ErpOutLogDto> getMgrOutLogList(Integer cityId, QueryOutLogParam param) {
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();
		String[] deptIds = null;
		ErpFunDepts queryDeptCondition = new ErpFunDepts();
		queryDeptCondition.setCompId(param.getCompId());
		queryDeptCondition.setShardCityId(cityId);
		if (areaId != null) {
			queryDeptCondition.setAreaId(param.getAreaId());
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getAllDeptListByRange(cityId, queryDeptCondition);
			deptIds = BeanUtil.buildQueryKeysNoRepeat(deptList, "deptId");
		}
		if (regId != null) {
			queryDeptCondition.setRegId(param.getRegId());
			List<ErpFunDepts> deptList = erpFunDeptsMapper.getAllDeptListByRange(cityId, queryDeptCondition);
			deptIds = BeanUtil.buildQueryKeysNoRepeat(deptList, "deptId");
		}
		if (deptId != null) {
			deptIds = new String[] { deptId.toString() };
		}
		if (deptIds != null && deptIds.length <= 0) {
			deptIds = null;
		}
		List<ErpOutLogDto> list = erpOutLogMapper.selectOutLogList(cityId, param, deptIds);
		ErpFunDepts condition = new ErpFunDepts();
		condition.setCompId(param.getCompId());

		Map<Object, ErpFunDepts> map = erpFunDeptsService.getAllDeptListByRange(cityId, condition);
		if (!list.isEmpty()) {
			for (ErpOutLogDto dto : list) {
				if (dto != null) {
					if (map.get(dto.getDeptId()) != null) {
						dto.setDeptName(map.get(dto.getDeptId()).getDeptName());
					}
				}
			}
		}
		return list;
	}

	@Override
	public void createOutLog(Integer cityId, CreateOutLogParam param) {
		checkCurrentUserOutLogStatus(cityId, param.getCurrentUserId());
		ErpOutLog erpOutLog = new ErpOutLog();
		erpOutLog.setCompId(param.getCompId());
		erpOutLog.setDeptId(param.getCurrentDeptId());
		erpOutLog.setOutUser(param.getCurrentUserId());
		erpOutLog.setOutDesc(param.getOutDesc());
		erpOutLog.setOutTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpOutLog.setExpectBacktime(param.getExpectBackTime());
		erpOutLog.setShardCityId(cityId);
		erpOutLogMapper.insertSelective(erpOutLog);
	}

	@Override
	public void createOutLog(Integer cityId, Integer compId, Integer deptId, Integer userId, String outReason,
			Date startTime, Date endTime, Integer auditId) {
		ErpOutLog erpOutLog = new ErpOutLog();
		erpOutLog.setCompId(compId);
		erpOutLog.setDeptId(deptId);
		erpOutLog.setOutUser(userId);
		erpOutLog.setOutDesc(outReason);
		erpOutLog.setOutTime(DateTimeHelper.formatDateTimetoString(startTime));
		erpOutLog.setBackTime(null);
		erpOutLog.setAuditId(auditId);
		erpOutLog.setShardCityId(cityId);
		erpOutLog.setAssessmentMonth(DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM"));
		// 计算时长
		Double minutesOfTwoDate = DateTimeHelper.getMinutesOfTwoDate(endTime, startTime);
		erpOutLog.setExpectBacktime(minutesOfTwoDate.intValue());
		erpOutLogMapper.insertSelective(erpOutLog);
	}
	
	@Override
	public void outBack(Integer cityId,Integer userId) {
		/*Condition condition = new Condition();
		condition.add(new ConditionItem("OUT_USER", "=", getOperator().getUserId()));
		condition.add(new ConditionItem("BACK_TIME", "IS", "NULL"));
		HashMap<String,String> fieldsHM = new HashMap<String,String>();
		fieldsHM.put("BACK_TIME", getTimeNow());*/
		erpOutLogMapper.updateBackTimeByUserId(cityId,userId, new Date());
	}
	
	private void checkCurrentUserOutLogStatus(Integer cityId, Integer currentUserId) {
		ErpOutLog erpOutLog = erpOutLogMapper.selectOutLogByUserIdAndBlankBackTime(cityId, currentUserId);
		if (erpOutLog != null) {
			throw new BusinessException("对不起，你已经登记了外出日志！");
		}
	}

}
