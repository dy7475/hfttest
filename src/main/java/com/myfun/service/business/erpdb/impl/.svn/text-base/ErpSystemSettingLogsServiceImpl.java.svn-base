package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetLogListParam;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSystemSettingLogsMapper;
import com.myfun.repository.erpdb.dto.ErpSystemSettingLogsDto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import com.myfun.utils.SystemOperateUtil;

@Service
public class ErpSystemSettingLogsServiceImpl extends AbstractService<ErpSystemSettingLogs, ErpSystemSettingLogs> implements ErpSystemSettingLogsService {

	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;

	@Override
	public void setBaseMapper() {

		
	}
	
	@Override
	public void insertSysLog(SystemOperateUtil.SSL_TYPE systemRunModel, Integer refrenceUserId, Integer refrenceDeptId,
							 String content, Object before, Object after,
			Integer cityId, Integer compId, Integer deptId, Integer userId) {
		try {
			ErpSystemSettingLogs insertModel = new ErpSystemSettingLogs();
			insertModel.setCompId(compId);
			insertModel.setShardCityId(cityId);
			insertModel.setCreateDept(deptId);
			insertModel.setCreateUid(userId);
			insertModel.setCreateTime(DateUtil.DateToString(new Date()));
			if (refrenceUserId != null) {
				insertModel.setInfluenceUid(refrenceUserId);
				ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(cityId, refrenceUserId);
				if(usersPO != null){
					insertModel.setInfluenceDept(usersPO.getDeptId());
				}
			}
			if (null != before) {
				insertModel.setBeforeModification(buildContent(before, systemRunModel));
			}
			if (null != after) {
				insertModel.setAfterModification(buildContent(after, systemRunModel));
			}
			insertModel.setSslType(new Byte(systemRunModel.getIndex()));
			insertModel.setModular(Integer.valueOf(systemRunModel.getModular()));
			if (StringUtils.isNotBlank(content)) {
				insertModel.setLogContent(content);// 自定义消息内容
			} else {
				insertModel.setLogContent(systemRunModel.getName());// 模板消息内容
			}
			erpSystemSettingLogsMapper.insertSelective(insertModel);
		} catch (Exception e) {
		}
	}
	
	
	@Override
	public void insertSysLogNew(SystemOperateUtil.SSL_TYPE systemRunModel, Integer refrenceUserId, Integer refrenceDeptId,
							 String content, Object before, Object after,
			Integer cityId, Integer compId, Integer deptId, Integer userId,String userName) {
		try {
			ErpSystemSettingLogs insertModel = new ErpSystemSettingLogs();
			insertModel.setCompId(compId);
			insertModel.setShardCityId(cityId);
			insertModel.setCreateDept(deptId);
			insertModel.setCreateUid(userId);
			insertModel.setCreateTime(DateUtil.DateToString(new Date()));
			insertModel.setCreateUsername(userName);   //设置新加的用户名和公司名字段
			if (refrenceUserId != null) {
				insertModel.setInfluenceUid(refrenceUserId);
				ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(cityId, refrenceUserId);
				if(usersPO != null){
					insertModel.setInfluenceDept(usersPO.getDeptId());
				}
			}
			if (null != before) {
				insertModel.setBeforeModification(buildContent(before, systemRunModel));
			}
			if (null != after) {
				insertModel.setAfterModification(buildContent(after, systemRunModel));
			}
			insertModel.setSslType(new Byte(systemRunModel.getIndex()));
			insertModel.setModular(Integer.valueOf(systemRunModel.getModular()));
			if (StringUtils.isNotBlank(content)) {
				insertModel.setLogContent(content);// 自定义消息内容
			} else {
				insertModel.setLogContent(systemRunModel.getName());// 模板消息内容
			}
			erpSystemSettingLogsMapper.insertSelective(insertModel);
		} catch (Exception e) {
		}
	}
	
	
	
	

	@Override
	public void insertLog(SystemOperateUtil.SSL_TYPE systemRunModel, String refrenceUserId, String content,
						  Object before, Object after, BaseMapParam param) {
		Integer compId= param.getInteger("compId");
		ErpSystemSettingLogs insertModel = new ErpSystemSettingLogs();
		insertModel.setCompId(compId);
		insertModel.setShardCityId(param.getInteger("cityId"));
		insertModel.setCreateDept(param.getInteger("deptId"));
		insertModel.setCreateUid(param.getInteger("userId"));
		insertModel.setCreateTime(DateUtil.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		if(StringUtils.isNotBlank(refrenceUserId)){
			insertModel.setInfluenceUid(Integer.valueOf(refrenceUserId));
			ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(param.getInteger("cityId"), Integer.valueOf(refrenceUserId));
			if(usersPO != null){
				insertModel.setInfluenceDept(usersPO.getDeptId());
			}
		}
		if(null != before){
			insertModel.setBeforeModification(buildContent(before, systemRunModel));
		}
		if(null != after){
			insertModel.setAfterModification(buildContent(after, systemRunModel));
		}
		insertModel.setSslType(new Byte(systemRunModel.toString()));
		insertModel.setModular(Integer.valueOf(systemRunModel.getModular()));
		if(StringUtils.isNotBlank(content)){
			insertModel.setLogContent(content);// 自定义消息内容
		}
		else{
			insertModel.setLogContent(systemRunModel.getName());// 模板消息内容
		}
		erpSystemSettingLogsMapper.insertSelective(insertModel);
	}
	
	
	@Override
	public void insertLogNew(SystemOperateUtil.SSL_TYPE systemRunModel, String refrenceUserId, String content,
						  Object before, Object after, BaseMapParam param,String userName) {
		Integer compId= param.getInteger("compId");
		ErpSystemSettingLogs insertModel = new ErpSystemSettingLogs();
		insertModel.setCompId(compId);
		insertModel.setShardCityId(param.getInteger("cityId"));
		insertModel.setCreateDept(param.getInteger("deptId"));
		insertModel.setCreateUid(param.getInteger("userId"));
		insertModel.setCreateUsername(userName);  //新增
		insertModel.setCreateTime(DateUtil.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		if(StringUtils.isNotBlank(refrenceUserId)){
			insertModel.setInfluenceUid(Integer.valueOf(refrenceUserId));
			ErpFunUsers usersPO = erpFunUsersMapper.getUserInfoByUserId(param.getInteger("cityId"), Integer.valueOf(refrenceUserId));
			if(usersPO != null){
				insertModel.setInfluenceDept(usersPO.getDeptId());
			}
		}
		if(null != before){
			insertModel.setBeforeModification(buildContent(before, systemRunModel));
		}
		if(null != after){
			insertModel.setAfterModification(buildContent(after, systemRunModel));
		}
		insertModel.setSslType(new Byte(systemRunModel.toString()));
		insertModel.setModular(Integer.valueOf(systemRunModel.getModular()));
		if(StringUtils.isNotBlank(content)){
			insertModel.setLogContent(content);// 自定义消息内容
		}
		else{
			insertModel.setLogContent(systemRunModel.getName());// 模板消息内容
		}
		erpSystemSettingLogsMapper.insertSelective(insertModel);
	}
	
	

	private String buildContent(Object obj,SystemOperateUtil.SSL_TYPE type) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<Map<String, String>> mapList = new ArrayList();
		switch (type) {
			case OPERS_SETTING:
				List<ErpUserOpersDto> list = (List<ErpUserOpersDto>) obj;
				for(ErpUserOpersDto userOpersVO : list){
					mapList.add(mapKeyToUp(BeanUtil.objToMapAndunPackBaseBean(new HashMap<String,String>(),userOpersVO)));
				}
				paramMap.put("USER_OPERS_LIST", mapList);
				break;
			case UPDATE_AREA:
				ErpFunArea funAreaPO = (ErpFunArea) obj;
				Map<String, Object> funAreaMap = new HashMap<>();
				BeanUtil.beanToMap(funAreaPO, funAreaMap);
				paramMap.put("FUN_AREA", mapKeyToUp(funAreaMap));
				break;
			case UPDATE_REGION:
				ErpFunRegion funRegionPO = (ErpFunRegion) obj;
				paramMap.put("FUN_REGION", mapKeyToUp(BeanUtil.objToMap(funRegionPO)));
				break;
			case UPDATE_DEPT:
				ErpFunDepts funDeptPO = (ErpFunDepts) obj;
				Map<String, Object> pMap = new HashMap<>();
				BeanUtil.beanToMap(funDeptPO, pMap);
				paramMap.put("FUN_DEPTS", mapKeyToUp(pMap));
				break;
			case CHANGE_PARAMETER:
				List<ErpSysPara> sysList = (List<ErpSysPara>) obj;
				for(ErpSysPara sysParaPO : sysList){
					mapList.add(mapKeyToUp(BeanUtil.objToMap(sysParaPO)));
				}
				paramMap.put("SYSPARA_LIST", mapList);
				break;
			case UPDATE_USER:
				paramMap.put("FUN_USERS", mapKeyToUp(BeanUtil.objToMapAndunPackBaseBean(new HashMap<String, String>(), obj)));
				break;
			case UPDATE_EMPLOYEE_DOC:
				paramMap.put("EMPLOYEE_DOC_DATA", obj);
			case OPEN_FACE_RECOGNITION_FLAG:
				paramMap.put("FACE_RECOGNITION_FLAG", obj);
			case CLOSE_FACE_RECOGNITION_FLAG:
				paramMap.put("FACE_RECOGNITION_FLAG", obj);
				break;
			default: {
				break;
			}
		}
		return JSON.toJSONString(paramMap);
	}

	/**
	 * @tag 把map的Key改为大写下划线模式
	 * @author 邓永洪
	 * @since 2018/5/21
	 */
	private  <T> Map<String, T>  mapKeyToUp(Map<String, T> map){
		Map<String, T> resultMap = new HashMap<>();
		for (Map.Entry<String,T> element : map.entrySet()) {
			resultMap.put(BeanUtil.camelToUnderline(element.getKey()), element.getValue());
		}
		return resultMap;
	}

	@Override
	public PageInfo<ErpSystemSettingLogsDto> getLogList(GetLogListParam param, Integer compId, Integer cityId) {
		param.setCompId(compId);
		if(param.getTime2()!=null){
			if(StringUtils.isNotBlank(param.getTime2())){
				param.setTime2(param.getTime2()+" 23:59:59");
			}
		}
		String order = "CREATE_TIME DESC";
		if(param.getOrderEnum()!=null && param.getOrderRule()!=null){
			String orderEnum = param.getOrderEnum();
			Integer orderRule = param.getOrderRule(); // 0:升序 1:降序
			/**  处理排序 **/
			// 时间:CREATION_TIME 操作人CREATE_UID  类型SSL_TYPE 影响人INFLUENCE_UID
			if(StringUtils.isNotBlank(orderEnum) && orderRule!=null) {
				String orderStr = orderRule == 1 ? "DESC" : "ASC";
				if("CREATION_TIME".equals(orderEnum)) {
					order = " CREATE_TIME " + orderStr;
				}
				if("CREATE_UID".equals(orderEnum)) {
					order = " CREATE_UID " + orderStr;
				}
				if("SSL_TYPE".equals(orderEnum)) {
					order = " SSL_TYPE " + orderStr;
				}
				if("INFLUENCE_UID".equals(orderEnum)) {
					order = " INFLUENCE_UID " + orderStr;
				}
			}
		}
		param.setOrderBy(order);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpSystemSettingLogsDto> erpSystemSettingLogs = erpSystemSettingLogsMapper.getLogList(param,cityId);
		Set<Integer> userIds = new HashSet<Integer>();
		for(ErpSystemSettingLogsDto dto:erpSystemSettingLogs){
			userIds.add(dto.getCreateUid());
			userIds.add(dto.getInfluenceUid());
		}
		if (!userIds.isEmpty()) {
			List<ErpFunUsers> list = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
			Map<Integer, ErpFunUsers> userMap = list.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
			Byte[] haveDetail = new Byte[] { 1, 3, 14, 15, 16, 19 };
			for (ErpSystemSettingLogsDto dto : erpSystemSettingLogs) {
				ErpFunUsers user = userMap.get(dto.getCreateUid());
				if (user != null) {
					dto.setCreateUname(user.getUserName());
				}
				user = userMap.get(dto.getInfluenceUid());
				if (user != null) {
					dto.setInfluenceUname(user.getUserName());
				}
				if (StringUtil.containerValue(haveDetail, dto.getSslType())) {
					dto.setHaveDetail(1);// 表示有详情
				}
			}
		}
		PageInfo<ErpSystemSettingLogsDto> pageInfo = new PageInfo<ErpSystemSettingLogsDto>(erpSystemSettingLogs);
		return pageInfo;
	}
	
}
