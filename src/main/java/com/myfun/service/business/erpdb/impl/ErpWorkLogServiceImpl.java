/**
 * @author 方李骥
 * @since 2016年9月19日
 */
package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpWorkLogMapper;
import com.myfun.repository.erpdb.dto.ErpWorkLogDto;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpWorkLog;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.erpdb.ErpWorkLogService;
import com.myfun.service.business.erpdb.ErpWorkPlanService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateWorkLogParam;
import com.myfun.service.business.erpdb.bean.param.QueryWorkLogListParam;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;

/**
 * @author 方李骥
 * @since 2016年9月19日
 */
@Service
public class ErpWorkLogServiceImpl extends AbstractService<ErpWorkLog, ErpWorkLog> implements ErpWorkLogService{
	@Autowired private ErpWorkLogMapper erpWorkLogMapper;
	@Autowired private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;
	@Autowired private ErpWorkPlanService erpWorkPlanService;
	@Autowired private ErpUserOpersService erpUserOpersService;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	
	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 */
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpWorkLogMapper;
		
	}

	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 * @param param
	 * @throws Exception
	 */
	@Transactional
	@Override
	public void createOrUpdateWorkLog(CreateOrUpdateWorkLogParam param) throws Exception {
		if(param.getWlId()==null){
			Date date = DateTimeHelper.getSystemDate();
			String nowTime = DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMddHHmmssS);
			String nowDay = DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMdd);
			if(param.getOtherCount()==null){
				param.setOtherCount(BigDecimal.ZERO);
			}
			ErpWorkLog record = new ErpWorkLog();
			record.setWlTime(nowDay);
			record.setCreatorUid(param.getCreatorUid());
			record.setCompId(param.getCompId());
			record.setWlUser(param.getCurrentUserId());
			record.setDeptId(param.getCurrentDeptId());
			record.setWlSubmit(nowTime);
			record.setExplrthCount(0);
			record.setLookCount(0);
			record.setExaminFlag((byte)0);
			record.setCreatorUid(param.getCurrentUserId());
			record.setCreationTime(nowTime);
			record.setOtherCount(param.getOtherCount());
			record.setTotalCount(param.getTotalCount());
			record.setWlSummary(param.getWlSummary());
			record.setShardCityId(param.getCityId());
			erpWorkLogMapper.insertSelective(record);
			param.setWlId(record.getWlId());
		}else{
			updateWorkLog(param);
		}
		erpWorkPlanService.insertByWorkLog(param);
	}
	
	private void updateWorkLog(CreateOrUpdateWorkLogParam param){
		erpWorkLogMapper.updateWorkLog(param.getCityId(), param);
		erpWorkPlanService.deleteOldWorkPlan(param.getCityId(), param.getWlId());
	}
	
	@Transactional
	@Override
	public void adultWorkLog(CreateOrUpdateWorkLogParam param, String nowTime) throws Exception {
		Integer otherCount = 0;
		Integer explrthCount = 0; 
		Integer lookCount = 0 ;
		Integer userId = param.getWlUser();
		updateWorkLog(param);
		erpWorkPlanService.insertByWorkLog(param);
		Map<String,Object> returnMap = reportFunStatisticTotleMapper.countTodayExplrthAndLook(param.getCityId(),param.getCompId(),userId,DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd 00:00:00"),DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd 23:59:59"));
		if (returnMap == null) {
			otherCount = param.getOtherCount().intValue();
			explrthCount = 0;
			lookCount = 0;
		} else {
			otherCount = param.getOtherCount().intValue();
			explrthCount = Integer.valueOf(String.valueOf(returnMap.get("EXPLRTH_COUNT"))); 
			lookCount = Integer.valueOf(String.valueOf(returnMap.get("LOOK_COUNT"))); 
		}
		param.setExplrthCount(explrthCount);
		param.setTotalCount(new BigDecimal(otherCount+explrthCount+lookCount));
		param.setLookCount(lookCount);
		param.setExaminUser(param.getCurrentUserId());
		param.setExaminTime(nowTime);
		param.setExaminFlag(Byte.valueOf("1"));
		erpWorkLogMapper.updateWorkLog(param.getCityId(), param);
	}

	@Override
	public Map<String, Object> detectExistLog(BaseMapParam param) throws Exception {
		Integer nowUser = param.getInteger("currentUserId");
		Integer cityId = param.getInteger("cityId");
		Integer mark = null;
		if (!erpUserOpersService.judgePermission(cityId, nowUser, "DAY_JOB_LOGS")) {
			mark = 1;
		}
		String nowTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		String timeEnd = nowTime + " 23:59:59";
		int count = erpWorkLogMapper.countWorkLogOffUser(cityId, nowUser, nowTime, timeEnd);
		if (count >= 1) {
			mark = 2;
		} else {
			mark = 0;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		// 此处修改,和老版本不一样
		map.put("permission", count);
		if (mark == 0) {
			Map<String, Object> returnMap = reportFunStatisticTotleMapper.countTodayExplrthAndLook(cityId,
					param.getInteger("compId"), nowUser,
					DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd 00:00:00"),
					DateTimeHelper.formatDateTimetoString(nowTime, "yyyy-MM-dd 23:59:59"));
			if (returnMap != null) {
				map.put("explrthCount", returnMap.get("EXPLRTH_COUNT"));
				map.put("lookCount", returnMap.get("LOOK_COUNT"));
			}
		}
		return map;
	}

	@Override
	public Map<String,Object> getBizWorkLogList(Integer cityId,
			QueryWorkLogListParam param) throws Exception {
		Map<String,Object> returnMap = new HashMap<String,Object>();
		Integer total = erpWorkLogMapper.countWorkLogList(cityId, param);
		returnMap.put("total", total);
		if(total>0){
			List<ErpWorkLogDto> workLogList = erpWorkLogMapper.selectWorkLogList(cityId, param);
			Map<Object,ErpFunUsers> userMap = null;
			Set<Integer> userSet = new HashSet<Integer>();
			for(ErpWorkLogDto dto:workLogList){
				if(dto.getWlUser()!=null){
					userSet.add(dto.getWlUser());
				}
			}
			if(!userSet.isEmpty()){
				List<ErpFunUsers> list = erpFunUsersMapper.getUserListByUserIds(cityId, userSet);
				userMap = BeanUtilsHelper.listToMapObjectOffKeyType(list,"userId");
			}
			for(ErpWorkLogDto dto:workLogList){
				ErpFunUsers erpFunUsers = userMap.get(dto.getWlUser());
				if(erpFunUsers!=null){
					dto.setUserName(erpFunUsers.getUserName());
					dto.setSex(erpFunUsers.getUserSex());
				}
			}
			returnMap.put("workLogList", workLogList);
		}
		return returnMap;
	}

	@Override
	public ErpWorkLogDto selectWorkLogInfo(Integer cityId, Integer wlId)
			throws Exception {
		return erpWorkLogMapper.selectWorkLogInfo(cityId, wlId);
	}

}
