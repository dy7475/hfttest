package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunEmployeeDocMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeLogMapper;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDoc;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDocExample;
import com.myfun.repository.erpdb.po.ErpFunEmployeeLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunEmployeeLogService;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpFunEmployeeLogServiceImpl extends AbstractService<ErpFunEmployeeLog, ErpFunEmployeeLog> implements ErpFunEmployeeLogService {
	
	@Autowired 
	private ErpFunEmployeeLogMapper erpFunEmployeeLogMapper;
	
	@Autowired 
	private ErpFunEmployeeDocMapper erpFunEmployeeDocMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunEmployeeLogMapper;
	}
	
	@Override
	public void insertLog(Integer cityId, Integer compId, 
											Byte logType, 
											String content, 
											Integer archiveId, 
											Integer selfUserId, 
											Integer beforeDept, 
											Integer afterDept, 
											String beforeRole, 
											String afterRole, 
											Integer beforeGr, 
											Integer afterGr) {
		
		ErpFunEmployeeLog erpFunEmployeeLog = new ErpFunEmployeeLog();
		if (null != archiveId) {
			ErpFunEmployeeDocExample docExample = new ErpFunEmployeeDocExample();
			docExample.createCriteria().andArchiveIdEqualTo(archiveId).andCompIdEqualTo(compId);
			docExample.setShardCityId(cityId);
			List<ErpFunEmployeeDoc> erpFunEmployeeDocList = erpFunEmployeeDocMapper.selectByExample(docExample);
			if (null != erpFunEmployeeDocList && erpFunEmployeeDocList.size() > 0) {
				erpFunEmployeeLog.setEmployeeId(erpFunEmployeeDocList.get(0).getId());
			}
		}
		erpFunEmployeeLog.setArchiveId(archiveId);
		erpFunEmployeeLog.setCompId(compId);
		erpFunEmployeeLog.setCreateUid(selfUserId);
		erpFunEmployeeLog.setCreationTime(DateTimeHelper.getSystemDate());
		erpFunEmployeeLog.setBeforeDept(beforeDept);
		erpFunEmployeeLog.setAfterDept(afterDept);
		erpFunEmployeeLog.setLogType(logType);
		erpFunEmployeeLog.setBeforeRole(beforeRole);
		erpFunEmployeeLog.setAfterRole(afterRole);
		erpFunEmployeeLog.setContent(content);
		erpFunEmployeeLog.setBeforeGr(beforeGr);
		erpFunEmployeeLog.setAfterGr(afterGr);
		erpFunEmployeeLog.setShardCityId(cityId);
		erpFunEmployeeLogMapper.insertSelective(erpFunEmployeeLog);
	}
	
	
	@Override
	public void insertLogAddCreateUser(Integer cityId, Integer compId,  //目前仅编辑员工和更换员工角色在使用
											Byte logType, 
											String content, 
											Integer archiveId, 
											Integer selfUserId, 
											Integer beforeDept, 
											Integer afterDept, 
											String beforeRole, 
											String afterRole, 
											Integer beforeGr, 
											Integer afterGr,String createUserName) {
		
		ErpFunEmployeeLog erpFunEmployeeLog = new ErpFunEmployeeLog();
		if (null != archiveId) {
			ErpFunEmployeeDocExample docExample = new ErpFunEmployeeDocExample();
			docExample.createCriteria().andArchiveIdEqualTo(archiveId).andCompIdEqualTo(compId);
			docExample.setShardCityId(cityId);
			List<ErpFunEmployeeDoc> erpFunEmployeeDocList = erpFunEmployeeDocMapper.selectByExample(docExample);
			if (null != erpFunEmployeeDocList && erpFunEmployeeDocList.size() > 0) {
				erpFunEmployeeLog.setEmployeeId(erpFunEmployeeDocList.get(0).getId());
			}
		}
		erpFunEmployeeLog.setArchiveId(archiveId);
		erpFunEmployeeLog.setCompId(compId);
		erpFunEmployeeLog.setCreateUid(selfUserId);
		erpFunEmployeeLog.setCreationTime(DateTimeHelper.getSystemDate());
		erpFunEmployeeLog.setBeforeDept(beforeDept);
		erpFunEmployeeLog.setAfterDept(afterDept);
		erpFunEmployeeLog.setLogType(logType);
		erpFunEmployeeLog.setBeforeRole(beforeRole);
		erpFunEmployeeLog.setAfterRole(afterRole);
		erpFunEmployeeLog.setContent(content);
		erpFunEmployeeLog.setBeforeGr(beforeGr);
		erpFunEmployeeLog.setAfterGr(afterGr);
		erpFunEmployeeLog.setShardCityId(cityId);
		erpFunEmployeeLog.setCreateUsername(createUserName);  //新增创建人名字和公司名字段
		erpFunEmployeeLogMapper.insertSelective(erpFunEmployeeLog);
	}
	
	
	
	

	@Override
	public void insertLogNew(Integer cityId, Integer compId,
						  Byte logType,
						  String content,
						  Integer archiveId,
						  Integer selfUserId,
						  Integer beforeOrgId,
						  Integer afterOrgId,
						  String beforeRole,
						  String afterRole) {

		ErpFunEmployeeLog erpFunEmployeeLog = new ErpFunEmployeeLog();
		if (null != archiveId) {
			ErpFunEmployeeDocExample docExample = new ErpFunEmployeeDocExample();
			docExample.createCriteria().andArchiveIdEqualTo(archiveId).andCompIdEqualTo(compId);
			docExample.setShardCityId(cityId);
			List<ErpFunEmployeeDoc> erpFunEmployeeDocList = erpFunEmployeeDocMapper.selectByExample(docExample);
			if (null != erpFunEmployeeDocList && erpFunEmployeeDocList.size() > 0) {
				erpFunEmployeeLog.setEmployeeId(erpFunEmployeeDocList.get(0).getId());
			}
		}
		erpFunEmployeeLog.setArchiveId(archiveId);
		erpFunEmployeeLog.setCompId(compId);
		erpFunEmployeeLog.setCreateUid(selfUserId);
		erpFunEmployeeLog.setCreationTime(DateTimeHelper.getSystemDate());
		erpFunEmployeeLog.setLogType(logType);
		erpFunEmployeeLog.setBeforeRole(beforeRole);
		erpFunEmployeeLog.setAfterRole(afterRole);
		erpFunEmployeeLog.setContent(content);
		erpFunEmployeeLog.setAfterOrganizationId(afterOrgId);
		erpFunEmployeeLog.setShardCityId(cityId);
		erpFunEmployeeLogMapper.insertSelective(erpFunEmployeeLog);
	}
	
	@Override
	public void insertLogNewNew(Integer cityId, Integer compId,
						  Byte logType,
						  String content,
						  Integer archiveId,
						  Integer selfUserId,
						  Integer beforeOrgId,
						  Integer afterOrgId,
						  String beforeRole,
						  String afterRole,
						  String userName) {

		ErpFunEmployeeLog erpFunEmployeeLog = new ErpFunEmployeeLog();
		if (null != archiveId) {
			ErpFunEmployeeDocExample docExample = new ErpFunEmployeeDocExample();
			docExample.createCriteria().andArchiveIdEqualTo(archiveId).andCompIdEqualTo(compId);
			docExample.setShardCityId(cityId);
			List<ErpFunEmployeeDoc> erpFunEmployeeDocList = erpFunEmployeeDocMapper.selectByExample(docExample);
			if (null != erpFunEmployeeDocList && erpFunEmployeeDocList.size() > 0) {
				erpFunEmployeeLog.setEmployeeId(erpFunEmployeeDocList.get(0).getId());
			}
		}
		erpFunEmployeeLog.setArchiveId(archiveId);
		erpFunEmployeeLog.setCompId(compId);
		erpFunEmployeeLog.setCreateUid(selfUserId);
		erpFunEmployeeLog.setCreationTime(DateTimeHelper.getSystemDate());
		erpFunEmployeeLog.setLogType(logType);
		erpFunEmployeeLog.setBeforeRole(beforeRole);
		erpFunEmployeeLog.setAfterRole(afterRole);
		erpFunEmployeeLog.setContent(content);
		erpFunEmployeeLog.setAfterOrganizationId(afterOrgId);
		erpFunEmployeeLog.setShardCityId(cityId);
		erpFunEmployeeLog.setCreateUsername(userName);   //新增的用户名和公司名
		erpFunEmployeeLogMapper.insertSelective(erpFunEmployeeLog);
	}

	@Override
	public void insertLog4RoleLevel(Integer cityId, Integer compId, Byte logType, String content, Integer archiveId, Integer selfUserId, Integer beforeRoleLevelId, Integer afterRoleLevelId) {
		ErpFunEmployeeLog erpFunEmployeeLog = new ErpFunEmployeeLog();
		if (null != archiveId) {
			ErpFunEmployeeDocExample docExample = new ErpFunEmployeeDocExample();
			docExample.createCriteria().andArchiveIdEqualTo(archiveId).andCompIdEqualTo(compId);
			docExample.setShardCityId(cityId);
			List<ErpFunEmployeeDoc> erpFunEmployeeDocList = erpFunEmployeeDocMapper.selectByExample(docExample);
			if (null != erpFunEmployeeDocList && erpFunEmployeeDocList.size() > 0) {
				erpFunEmployeeLog.setEmployeeId(erpFunEmployeeDocList.get(0).getId());
			}
		}
		erpFunEmployeeLog.setCompId(compId);
		erpFunEmployeeLog.setLogType(logType);
		erpFunEmployeeLog.setContent(content);
		erpFunEmployeeLog.setShardCityId(cityId);
		erpFunEmployeeLog.setArchiveId(archiveId);
		erpFunEmployeeLog.setBeforeRoleLevelId(beforeRoleLevelId);
		erpFunEmployeeLog.setAfterRoleLevelId(afterRoleLevelId);
		erpFunEmployeeLog.setCreateUid(selfUserId);
		erpFunEmployeeLog.setCreationTime(DateTimeHelper.getSystemDate());
		erpFunEmployeeLogMapper.insertSelective(erpFunEmployeeLog);
	}
}
