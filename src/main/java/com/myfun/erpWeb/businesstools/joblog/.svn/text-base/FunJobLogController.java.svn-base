package com.myfun.erpWeb.businesstools.joblog;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpWorkLogMapper;
import com.myfun.repository.erpdb.dao.ErpWorkPlanMapper;
import com.myfun.repository.erpdb.dto.ErpWorkLogDto;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpWorkPlan;
import com.myfun.service.business.erpdb.ErpWorkLogService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateWorkLogParam;
import com.myfun.service.business.erpdb.bean.param.QueryWorkLogListParam;
import com.myfun.utils.DateTimeHelper;

/**
 * @author 方李骥
 * @since 2016年9月19日
 */
@RequestMapping(value="/businesstools/jobLog",method=RequestMethod.POST)
@RestController
public class FunJobLogController extends BaseController{
	@Autowired
	ErpWorkPlanMapper erpWorkPlanMapper;
	@Autowired
	ErpWorkLogService erpWorkLogService;
	@Autowired
	ErpWorkLogMapper erpWorkLogMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	
	/**
	* @Date:2016-10-12
	* @Athor:方李骥
	* @Title: getBizWorkLogList 
	* @Description: 获取工作日志列表
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/getBizWorkLogList")
	public ResponseJson getBizWorkLogList(@Valid @RequestBody QueryWorkLogListParam param) throws Exception{
		param.setCompId(getOperator().getCompId());
		Integer cityId = getOperator().getCityId();
		param.setOrderBy("WL_ID DESC");
		Map<String,Object> returnMap = new HashMap<String,Object>();
		Integer total = erpWorkLogMapper.countWorkLogList(cityId, param);
		returnMap.put("total", total);
		if (total > 0) {
			param.setNewOrganization(getOperator().newOrganizationType());
			List<ErpWorkLogDto> workLogList = erpWorkLogMapper.selectWorkLogList(cityId, param);
			if(workLogList != null && workLogList.size() > 0) {
				Set<Integer> wlIds = workLogList.stream().collect(Collectors.mapping(ErpWorkLogDto::getWlId, Collectors.toSet()));
				List<ErpWorkLogDto> lookExplrthList = erpWorkLogMapper.selectLookExplrthCount(cityId, wlIds.toArray(new Integer[]{}));
				Map<Integer, ErpWorkLogDto> logMap = lookExplrthList.stream().collect(Collectors.toMap(ErpWorkLogDto::getWlId, val -> val));
				Set<Integer> userSet = workLogList.stream().collect(Collectors.mapping(ErpWorkLogDto::getWlUser, Collectors.toSet()));
				List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId, userSet);
				Map<Object, ErpFunUsers> userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
				for (ErpWorkLogDto dto : workLogList) {
					ErpFunUsers erpFunUsers = userMap.get(dto.getWlUser());
					if (erpFunUsers != null) {
						dto.setUserName(erpFunUsers.getUserName());
						dto.setSex(erpFunUsers.getUserSex());
					}
					ErpWorkLogDto workLogDto = logMap.get(dto.getWlId());
					if (workLogDto != null) {
						dto.setExplrthCount(workLogDto.getExplrthCount());
						dto.setLookCount(workLogDto.getLookCount());
					}
				}
				returnMap.put("workLogList", workLogList);
			}
		}
		ErpResponseJson erpResponseJson = new ErpResponseJson(returnMap.get("workLogList"));
		String totalStr = String.valueOf(returnMap.get("total"));
		if(StringUtils.isNotBlank(totalStr)){
			erpResponseJson.setTotal(Long.valueOf(totalStr));
		}
		erpResponseJson.setPageNum(param.getPageOffset());
		erpResponseJson.setPageSize(param.getPageRows());
		return erpResponseJson;
	}
	
	/**
	* @Date:2016-10-12
	* @Athor:方李骥
	* @Title: getBizWorkLogInfo 
	* @Description: 工作日志详情
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/getBizWorkLogInfo")
	public ResponseJson getBizWorkLogInfo(@Valid @RequestBody BaseMapParam param) throws Exception{
		Integer wlId = param.getInteger("wlId");
		ErpWorkLogDto workLog = erpWorkLogMapper.selectWorkLogInfo(getOperator().getCityId(), wlId);
		List<ErpWorkPlan> workPlanList = erpWorkPlanMapper.selectWorKPlanListByWlid(getOperator().getCityId(),wlId);
		List<ErpWorkLogDto> lookExplrthList = erpWorkLogMapper.selectLookExplrthCount(getOperator().getCityId(), new Integer[]{wlId});
		if (lookExplrthList != null && lookExplrthList.size() > 0) {
			ErpWorkLogDto erpWorkLogDto = lookExplrthList.get(0);
			workLog.setExplrthCount(erpWorkLogDto.getExplrthCount());
			workLog.setLookCount(erpWorkLogDto.getLookCount());
		}
		ErpResponseJson json = new ErpResponseJson();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("workLog", workLog);
		returnMap.put("workPlan", workPlanList);
		json.setData(returnMap);
		return ErpResponseJson.ok(returnMap);
	}
	
	/**
	* @Date:2016-10-12
	* @Athor:方李骥
	* @Title: createWorkLog 
	* @Description: 创建工作日志
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/createOrUpdateWorkLog")
	public ResponseJson createWorkLog(@Valid @RequestBody CreateOrUpdateWorkLogParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		erpWorkLogService.createOrUpdateWorkLog(param);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-10-12
	* @Athor:方李骥
	* @Title: updateWorkLog 
	* @Description: 更新工作日志
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/updateWorkLog")
	public ResponseJson updateWorkLog(@Valid @RequestBody CreateOrUpdateWorkLogParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		erpWorkLogService.createOrUpdateWorkLog(param);
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-10-12
	* @Athor:方李骥
	* @Title: adultWorkLog 
	* @Description: 审核工作日志
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/adultWorkLog")
	public ResponseJson adultWorkLog(@Valid @RequestBody CreateOrUpdateWorkLogParam param) throws Exception{
		param.setCurrentUserName(getCurrentUserName());
		param.setUserName(getOperator().getUserName());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentUserId(getOperator().getUserId());
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
		String wlTime = param.getWlTime();
		erpWorkLogService.adultWorkLog(param,wlTime); 
		return ErpResponseJson.ok();
	}
	
	/**
	* @Date:2016-10-12
	* @Athor:方李骥
	* @Title: detectExistLog 
	* @Description: 检查今天是否写了工作日志
	* @param param
	* @return
	* @throws Exception   
	* @return ResponseJson    返回类型 
	* @throws
	 */
	@RequestMapping("/detectExistLog")
	public ResponseJson detectExistLog(@Valid @RequestBody BaseMapParam param) throws Exception{
		param.setInteger("cityId", getOperator().getCityId());
		param.setInteger("compId", getOperator().getCompId());
		param.setInteger("currentUserId", getOperator().getUserId());
		Map<String,Object> dataMap = erpWorkLogService.detectExistLog(param);
		return ErpResponseJson.ok(dataMap);
	}

}
