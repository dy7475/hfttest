package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.employeeFiles.param.UploadEmployeeFileParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeDocMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeFileMapper;
import com.myfun.repository.erpdb.dao.ErpFunEmployeeLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunEmployeeLogDto;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunCompExample;
import com.myfun.repository.erpdb.po.ErpFunEmployeeDoc;
import com.myfun.repository.erpdb.po.ErpFunEmployeeFile;
import com.myfun.repository.erpdb.po.ErpFunEmployeeFileExample;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunOrganizationExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunEmployeeFileService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.SystemOperateUtil;

@Service
public class ErpFunEmployeeFileServiceImpl extends AbstractService<ErpFunEmployeeFile, ErpFunEmployeeFile> implements ErpFunEmployeeFileService {

	@Autowired
	ErpFunEmployeeFileMapper erpFunEmployeeFileMapper;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpFunEmployeeDocMapper erpFunEmployeeDocMapper;
	@Autowired
	ErpFunEmployeeLogMapper erpFunEmployeeLogMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunEmployeeFileMapper;
	}

	/**
	 * title ：删除员工档案
	 * athor：lcb
	 * date  : 2017/11/6
	 */
	@Transactional
	@Override
	public void delEmployeeFile(Integer cityId, String[] fildIds, Integer compId, Integer deptId, Integer userId, Integer refrenceUserId) {
		// 1: 修改员工档案数据
		// 2: 跟进日志
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, refrenceUserId);
		Integer refrenceDeptId = erpFunUsers.getDeptId();
		Set<Integer> fileId = new HashSet<>();
		for (String s: fildIds) {
			fileId.add(Integer.valueOf(s));
		}
		ErpFunEmployeeFileExample erpFunEmployeeFileExample = new ErpFunEmployeeFileExample();
		erpFunEmployeeFileExample.setShardCityId(cityId);
		erpFunEmployeeFileExample.createCriteria().andIdIn(new ArrayList<>(fileId));

		List<ErpFunEmployeeFile> fileList = erpFunEmployeeFileMapper.selectByExample(erpFunEmployeeFileExample);

		ErpFunEmployeeFile updateModel = new ErpFunEmployeeFile();
		updateModel.setFileStatus(Byte.valueOf("1"));
		String currUserName = erpFunUsersMapper.getCurrUserName(cityId, userId, deptId);
		int updateCount = erpFunEmployeeFileMapper.updateByExampleSelective(updateModel, erpFunEmployeeFileExample);
		if (updateCount > 0) {
			StringBuilder builder = new StringBuilder();
			Map<Byte, List<ErpFunEmployeeFile>> fileMap = fileList.stream().collect(Collectors.groupingBy(ErpFunEmployeeFile::getFileType));
			for (Entry<Byte, List<ErpFunEmployeeFile>> entry : fileMap.entrySet()) {
				if (entry.getKey() == 1) {
					builder.append("身份证：" + entry.getValue().size() + "张  ");
				} else if (entry.getKey() == 2) {
					builder.append("学历证书：" + entry.getValue().size() + "张  ");
				} else if (entry.getKey() == 3) {
					builder.append("荣誉证书：" + entry.getValue().size() + "张  ");
				} else if (entry.getKey() == 4) {
					builder.append("档案资料：" + entry.getValue().size() + "张  ");
				} else if (entry.getKey() == 5) {
					builder.append("其他资料：" + entry.getValue().size() + "张  ");
				}
			}
			erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.DELETE_EMPLOYEE_FILE, refrenceUserId,
					refrenceDeptId, currUserName + "删除了" + builder, null, null, cityId, compId, deptId, userId);
		}
	}

	@Override
	public PageInfo<ErpFunEmployeeLogDto> getEnclosureLogs(Integer cityId, Integer compId, Integer userId, BaseMapParam param) {
		ErpFunEmployeeDoc erpFunEmployeeDoc = erpFunEmployeeDocMapper.getErpFunEmployeeDocByUserId(cityId, compId, userId);
		if(null == erpFunEmployeeDoc){
			return null;
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunEmployeeLogDto> employeeLogList = erpFunEmployeeLogMapper.getLogListByEmployeeId(cityId, erpFunEmployeeDoc.getId());
		
		if (!employeeLogList.isEmpty()) {
			List<Integer> organizationIds = new ArrayList<Integer>();
			List<Integer> afterOrganizationIds = employeeLogList.stream().map(ErpFunEmployeeLogDto :: getAfterOrganizationId).collect(Collectors.toList());
			List<Integer> beforeOrganizationIds = employeeLogList.stream().map(ErpFunEmployeeLogDto :: getBeforeOrganizationId).collect(Collectors.toList());
			List<Integer> userIds = employeeLogList.stream().map(ErpFunEmployeeLogDto :: getCreateUid).collect(Collectors.toList());
			List<Integer> compIds = employeeLogList.stream().map(ErpFunEmployeeLogDto :: getCompId).collect(Collectors.toList());
			organizationIds.addAll(beforeOrganizationIds);
			organizationIds.addAll(afterOrganizationIds);
			ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
			erpFunOrganizationExample.setShardCityId(cityId);
			erpFunOrganizationExample.createCriteria().andOrganizationIdIn(organizationIds);
			List<ErpFunOrganization> organizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
			
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(cityId);
			erpFunUsersExample.createCriteria().andUserIdIn(userIds);
			List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
			Map<Integer, String> erpFunUsersMap = erpFunUsersList.stream().collect(Collectors.toMap(ErpFunUsers :: getUserId, val -> val.getUserName()));
			
			ErpFunCompExample erpFunCompExample = new ErpFunCompExample();
			erpFunCompExample.setShardCityId(cityId);
			erpFunCompExample.createCriteria().andCompIdIn(compIds);
			List<ErpFunComp> erpFunCompList = erpFunCompMapper.selectByExample(erpFunCompExample);
			Map<Integer, String> erpFunCompMap = erpFunCompList.stream().collect(Collectors.toMap(ErpFunComp :: getCompId, val -> val.getCompCname()));
			
			Map<Integer, String> organizationMap = organizations.stream().collect(Collectors.toMap(ErpFunOrganization :: getOrganizationId, val -> val.getOrganizationName()));
			employeeLogList.stream().forEach(a -> {
				Integer afterOrganizationId = a.getAfterOrganizationId();
				Integer beforeOrganizationId = a.getBeforeOrganizationId();
				if (null != organizationMap && null != afterOrganizationId) {
					String afterOrganizationName = organizationMap.get(afterOrganizationId);
					a.setAfterOrganizationName(afterOrganizationName);
				}
				if (null != organizationMap && null != beforeOrganizationId) {
					String beforeOrganizationName = organizationMap.get(beforeOrganizationId);
					a.setBeforeOrganizationName(beforeOrganizationName);
				}
				if (null != erpFunUsersMap) {
					String createUserName = erpFunUsersMap.get(a.getCreateUid());
					a.setCreateUserName(createUserName);
				}
				if (null != erpFunCompMap) {
					String compName = erpFunCompMap.get(a.getCompId());
					a.setCompName(compName);
				}
			});
		}
		
		return new PageInfo<>(employeeLogList);
	}

	@Transactional
	@Override
	public List<ErpFunEmployeeFile> uploadEmployeeFile(UploadEmployeeFileParam param) {
		List<ErpFunEmployeeFile> dataList = new ArrayList<ErpFunEmployeeFile>();
		Integer number = 1;
		if(param.getFileUrl().indexOf(",") > -1){
			String[] files = param.getFileUrl().split(",");
			if(files !=null && files.length > 0){
				number = files.length;
				for (String file : files) {
					ErpFunEmployeeFile erpFunEmployeeFile = new ErpFunEmployeeFile();
					erpFunEmployeeFile.setCompId(param.getCompId());
					erpFunEmployeeFile.setCreatorUid(param.getCreatorUid());
					erpFunEmployeeFile.setEmployeeDocId(param.getEmployeeDocId());
					erpFunEmployeeFile.setCreationTime(new Date());
					erpFunEmployeeFile.setFileStatus((byte) 0);
					erpFunEmployeeFile.setFileType(param.getFileType());
					erpFunEmployeeFile.setFileUrl(file);
					erpFunEmployeeFile.setArchiveId(param.getArchiveId());
					erpFunEmployeeFile.setShardCityId(param.getCityId());
					erpFunEmployeeFileMapper.insertSelective(erpFunEmployeeFile);
					dataList.add(erpFunEmployeeFile);
				}
			}
		}else{
			ErpFunEmployeeFile erpFunEmployeeFile = new ErpFunEmployeeFile();
			erpFunEmployeeFile.setCompId(param.getCompId());
			erpFunEmployeeFile.setCreatorUid(param.getCreatorUid());
			erpFunEmployeeFile.setEmployeeDocId(param.getEmployeeDocId());
			erpFunEmployeeFile.setCreationTime(new Date());
			erpFunEmployeeFile.setFileStatus((byte) 0);
			erpFunEmployeeFile.setFileType(param.getFileType());
			erpFunEmployeeFile.setFileUrl(param.getFileUrl());
			erpFunEmployeeFile.setArchiveId(param.getArchiveId());
			erpFunEmployeeFile.setShardCityId(param.getCityId());
			erpFunEmployeeFileMapper.insertSelective(erpFunEmployeeFile);
			dataList.add(erpFunEmployeeFile);
		}
		StringBuilder builder = new StringBuilder();
		if (param.getFileType() == 1) {
			builder.append("身份证："+number+"张 ");
		} else if (param.getFileType() == 2) {
			builder.append("学历证书："+number+"张");
		} else if (param.getFileType() == 3) {
			builder.append("荣誉证书："+number+"张");
		} else if (param.getFileType() == 4) {
			builder.append("档案资料："+number+"张");
		} else if (param.getFileType() == 5) {
			builder.append("其他资料："+number+"张");
		}
		ErpFunUsers refrenceUser = erpFunUsersMapper.selectByArchiveId(param.getArchiveId());
		String currUserName = erpFunUsersMapper.getCurrUserName(param.getCityId(), param.getCreatorUid(), param.getDeptId());
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.DELETE_EMPLOYEE_FILE, refrenceUser.getUserId(),
				refrenceUser.getDeptId(), currUserName + "上传了" + builder, null, null, param.getCityId(), param.getCompId(), param.getDeptId(), param.getCreatorUid());
		return dataList;
	}
}

