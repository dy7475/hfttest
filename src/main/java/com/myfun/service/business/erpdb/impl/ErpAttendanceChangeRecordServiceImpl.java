package com.myfun.service.business.erpdb.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpAttendanceChangeRecordMapper;
import com.myfun.repository.erpdb.dto.ErpAttendanceChangeRecordDto;
import com.myfun.repository.erpdb.po.ErpAttendanceChangeRecord;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAttendanceChangeRecordService;
import com.myfun.service.business.erpdb.ErpSysParaService;
@Service
public class ErpAttendanceChangeRecordServiceImpl extends AbstractService<ErpAttendanceChangeRecord, ErpAttendanceChangeRecord> implements ErpAttendanceChangeRecordService{
	@Autowired
	ErpAttendanceChangeRecordMapper erpAttendanceChangeRecordMapper;
	@Autowired
	ErpSysParaService erpSysParaService;
	@Override
	public void setBaseMapper() {
	}

	@Override
	public PageInfo<ErpAttendanceChangeRecordDto> getAttendanceRecordList(BaseMapParam param, Integer compId,Integer cityId) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("compId", compId);
		if(pMap.get("date2")!=null){
			if(org.apache.commons.lang.StringUtils.isNotBlank(String.valueOf(pMap.get("date2")))){
				pMap.put("date2", pMap.get("date2")+" 23:59:59");
			}
		}
		ErpSysPara erpSysPara = erpSysParaService.getErpSysPara(compId, cityId, "ATTENDANCE_MODEL");
		boolean attendanceFlag = false;
		if(erpSysPara!=null){
			attendanceFlag = "1".equals(erpSysPara.getParamValue()) ;
		}
		System.out.println("pageOffSet:"+param.getInteger("pageOffSet"));
		System.out.println("pageRows:"+param.getInteger("pageRows"));
		PageHelper.startPage(param.getInteger("pageOffset"), param.getInteger("pageRows"));
		List<ErpAttendanceChangeRecordDto> attendanceRecordList = erpAttendanceChangeRecordMapper.getAttendanceRecordList(pMap,cityId);
		for(ErpAttendanceChangeRecordDto dto : attendanceRecordList){
			String type = dto.getWorkType();//上班类型
			if(StringUtils.isBlank(type)){
				type = "";
			}
			if("0".equals(type)){
				type = "上班";
			}else{
				type = "下班";
			}
			String workDetailType = dto.getWorkDetailType();
			if(Const.DIC_WORK_TYPE_ONWORK.equals(workDetailType)||Const.DIC_WORK_TYPE_FREE.equals(workDetailType)){
				if(attendanceFlag&&Const.DIC_WORK_TYPE_ONWORK.equals(workDetailType)){
					dto.setWorkDetailType("早班");
				}else{
					dto.setWorkDetailType("正常");
				}
			}else if(Const.DIC_WORK_TYPE_DUTYWORK.equals(workDetailType)||Const.DIC_WORK_TYPE_DUTYFREE.equals(workDetailType)){
				dto.setWorkDetailType("值班");
			}else if(Const.DIC_WORK_TYPE_LATEWORK.equals(workDetailType)||Const.DIC_WORK_TYPE_EARYFREE.equals(workDetailType)){
				dto.setWorkDetailType("晚班");
			}else{
				dto.setWorkDetailType("空");
			}
		}
		PageInfo<ErpAttendanceChangeRecordDto> pageInfo = new PageInfo<ErpAttendanceChangeRecordDto>(attendanceRecordList);
		return pageInfo;
	}

}
