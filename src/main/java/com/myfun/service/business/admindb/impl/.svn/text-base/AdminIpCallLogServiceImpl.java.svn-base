package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminIpCallLogMapper;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunDeptsDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminIpCallLogService;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.VoipUtil;

/**
 * 
 * @ClassName: AdminIpCallLogServiceImpl
 * @Description: TODO
 * @author jiangsonggui
 * @date 2016年3月30日 上午9:45:59
 *
 */
@Service
public class AdminIpCallLogServiceImpl extends AbstractService<AdminIpCallLog, String>implements AdminIpCallLogService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminIpCallLogServiceImpl.class);
	@Autowired
	private AdminIpCallLogMapper adminIpCallLogMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsService erpFunDeptsService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminIpCallLogMapper;
	}

	/**
	 * 获取录音记录
	 */
	@Override
	public List<AdminIpCallLog> getCallRecordingList(AdminIpCallLog adminIpCallLog) {
		return adminIpCallLogMapper.getCallRecordingList(adminIpCallLog);
	}

	@Override
	public List<AdminIpCallLog> getRecordingByIds(String substring) {
		return adminIpCallLogMapper.getRecordingByIds(substring);
	}

	@Override
	public PageInfo<AdminIpCallLog> getMgrVoiceNoteLog(BaseMapParam param) throws Exception {
		param.setInteger("callCityId",param.getInteger("cityId"));
		param.setString("time1",DateTimeHelper.getFullTimeStr(param.getString("time1"),true));
		param.setString("time2",DateTimeHelper.getFullTimeStr(param.getString("time2"),false));
		if(param.getInteger("callDeptId")!=null){
			param.setObject("deptIds", new Object[]{param.getInteger("callDeptId")});
		} else if(param.getInteger("regId")!=null) {
			List<ErpFunDeptsDto> list = erpFunDeptsService.getDeptsList(param.getInteger("cityId"),param.getInteger("regId"));
			Object[] deptIds = BeanUtilsHelper.buildQueryKeys(list,"deptId");
			if(deptIds!=null&&deptIds.length>0){
				param.setObject("deptIds", deptIds);
			}
		}else if(param.getInteger("areaId")!=null) {
			List<ErpFunDepts> list = erpFunDeptsService.getDeptListByArea(param.getInteger("cityId"),param.getInteger("compId"),param.getInteger("areaId"));
			Object[] deptIds = BeanUtilsHelper.buildQueryKeys(list, "deptId");
			if(deptIds!=null&&deptIds.length>0){
				param.setObject("deptIds", deptIds);
			}
		}else if(param.getInteger("grId")!=null) {
			ErpFunUsers erpFunUsers = new ErpFunUsers();
			erpFunUsers.setShardCityId(param.getInteger("cityId"));
			erpFunUsers.setCompId(param.getInteger("compId"));
			erpFunUsers.setGrId(param.getInteger("grId"));
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getRangeUserList(param.getInteger("cityId"), erpFunUsers);
			if(erpFunUsersList != null && erpFunUsersList.size() > 0){
				String[] userIds = BeanUtilsHelper.buildQueryKeys(erpFunUsersList, "USER_ID");
				param.setObject("userIds",userIds);
			}
		}
		if(param.getInteger("userId")!=null){
			param.setObject("userIds", new Object[]{param.getInteger("userId")});
		}
		List<AdminIpCallLog> list = adminIpCallLogMapper.getMgrVoiceNoteLog(param.getMap());
		for(AdminIpCallLog adminIpCallLog:list){
			if(adminIpCallLog.getCallRecordUrl() != null) {
				adminIpCallLog.setCallRecordUrl(VoipUtil.VOIP_URL + adminIpCallLog.getCallRecordUrl().replaceAll("\\\\", "/"));
			}
			adminIpCallLog.setCalledPhone(encodePhone(adminIpCallLog.getCalledPhone()));
		}
		if(param.getInteger("exportFlag")==0){
			PageHelper.startPage(param.getPageOffset(),param.getPageRows(),true);
		}
		PageInfo<AdminIpCallLog> dataInfo = new PageInfo<AdminIpCallLog>(list);
		return dataInfo;
	}

	private String encodePhone(String calledPhone) {
		String resultStr = null;
		if(!StringUtil.isBlank(calledPhone)){
			if(calledPhone.length()>6){
				resultStr=calledPhone.substring(0, 3)+"****"+calledPhone.substring(calledPhone.length()-4, calledPhone.length());
			}
		}
		return resultStr;
		
	}

}
