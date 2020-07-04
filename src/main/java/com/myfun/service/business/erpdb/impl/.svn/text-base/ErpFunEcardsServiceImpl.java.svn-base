package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpCompRolesMapper;
import com.myfun.repository.erpdb.dao.ErpFunEcardsMapper;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpCompRolesExample;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunEcards;
import com.myfun.repository.erpdb.po.ErpFunEcardsExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunEcardsService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateErpFunEcardsParam;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
@Service
public class ErpFunEcardsServiceImpl extends AbstractService<ErpFunEcards, ErpFunEcards> implements
		ErpFunEcardsService {
	@Autowired private ErpFunEcardsMapper erpFunEcardsMapper;
	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired private ErpCompRolesMapper erpCompRolesMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunEcardsMapper;
		
	}
	/**
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: insertErpFunEcards 
	* @Description: (创建新的电子名片) 
	* @param param
	* @throws Exception   
	* @return 返回类型 
	* @throws
	 */
	@Transactional
	@Override
	public void insertErpFunEcards(CreateOrUpdateErpFunEcardsParam param) throws Exception{
		ErpFunEcards insertModel = new ErpFunEcards();
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
		String phone = param.getPhone();
		insertModel.setCompId(param.getCompId());
		insertModel.setDeptId(param.getCurrentDeptId());
		insertModel.setArchiveId(param.getArchiveId());
		insertModel.setEcardsName(param.getEcardsName());
		insertModel.setEcardsSex(param.getEcardsSex());
		insertModel.setEcardsPost(param.getEcardsPost());
		insertModel.setEcardsMail(param.getEcardsMail());
		insertModel.setEcardsQq(param.getEcardsQq());
		insertModel.setEcardsTel(phone);
		insertModel.setEcardsComp(param.getEcardsComp());
		insertModel.setEcardsPos(param.getEcardsPos());
		insertModel.setCompAdd(param.getCompAdd());
		insertModel.setCompUrl(param.getCompUrl());
		insertModel.setEcardsRemarks(param.getEcardsRemarks());
		insertModel.setCreateTime(nowTime);
		insertModel.setShardCityId(param.getCityId());
		//IS_PUBLIC 没传值 0为公开，1为不公开。默认公开
		if(param.getIsPublic() == null){
			insertModel.setIsPublic(false);
		}
		// 设置名片对应的archive_id，在修改用户时好同步公司和职位
		if(StringUtils.isNotBlank(phone)){
			String[] phoneNameArr = phone.trim().split(" ");
			if(phoneNameArr.length > 0){
				String[] phoneArr = new String[phoneNameArr.length];
				for (int i=0; i<phoneNameArr.length; i++) {
					String[] temp =  phoneNameArr[i].split(":");
					if(temp.length == 2){
						phoneArr[i] = temp[1];
					}
				}
				// 所有员工查出来匹配电子名片中的电话
				ErpFunUsers user = erpFunUsersService.selectUserByUserMobile(param.getCityId(),param.getCompId(),phoneArr);
				if(user != null){
					insertModel.setEcardsArchiveId(user.getArchiveId());
				}
			}
		}
		erpFunEcardsMapper.insertSelective(insertModel);
	}
	/**
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: updateErpFunEcards 
	* @Description: TODO(更新电子名片) 
	* @param param
	* @throws Exception   
	* @return 返回类型 
	* @throws
	 */
	@Override
	public void updateErpFunEcards(CreateOrUpdateErpFunEcardsParam param) throws Exception {
		ErpFunEcards erpFunEcards = new ErpFunEcards();
		erpFunEcards.setEcardId(param.getEcardId());
		erpFunEcards.setEcardsName(param.getEcardsName());
		erpFunEcards.setEcardsSex(param.getEcardsSex());
		erpFunEcards.setEcardsPost(param.getEcardsPost());
		erpFunEcards.setEcardsTel(param.getPhone());
		erpFunEcards.setEcardsMail(param.getEcardsMail());
		erpFunEcards.setEcardsQq(param.getEcardsQq());
		erpFunEcards.setEcardsComp(param.getEcardsComp());
		erpFunEcards.setCompUrl(param.getCompUrl());
		erpFunEcards.setCompAdd(param.getCompAdd());
		erpFunEcards.setEcardsRemarks(param.getEcardsRemarks());
		erpFunEcards.setShardCityId(param.getCityId());
		erpFunEcardsMapper.updateById(erpFunEcards);
	}

	@Override
	public int updateCompAndRole(Integer archiveId, String deptName, String roleId, Integer compId, String roleName) {
		ErpFunEcards funEcardsPO = new ErpFunEcards();
		funEcardsPO.setEcardsComp(deptName);
		funEcardsPO.setEcardsPost(roleName);
		funEcardsPO.setShardArchiveId(archiveId);
		ErpFunEcardsExample updateExample = new ErpFunEcardsExample();
		updateExample.createCriteria().andEcardsArchiveIdEqualTo(archiveId)
		.andCompIdEqualTo(compId);
		updateExample.setShardArchiveId(archiveId);
		return erpFunEcardsMapper.updateByExampleSelective(funEcardsPO, updateExample);
	}
	
	@Override
	public void insertEcards(ErpFunUsers erpFunUsers, ErpFunDepts erpFunDepts) {
		ErpCompRolesExample example = new ErpCompRolesExample();
		example.createCriteria().andRoleIdEqualTo(erpFunUsers.getUserPosition());
		example.setShardCityId(erpFunUsers.getCityId().intValue());
		List<ErpCompRoles> funOpersPOS = erpCompRolesMapper.selectByExample(example);
		ErpFunEcards funEcardsPO = new ErpFunEcards();
		if(funOpersPOS != null && funOpersPOS.size() > 0) {
			ErpCompRoles erpCompRoles = funOpersPOS.get(0);
			int count = this.updateCompAndRole(erpFunUsers.getArchiveId(), erpFunDepts.getDeptName(), erpFunUsers.getUserPosition(), erpFunUsers.getCompId(), erpCompRoles.getRoleName());
			// 通过公司ID和archive_id能改到电子名片，则说明有这个人的名片，就不再创建了
			if(count > 0){
				return;
			}
			funEcardsPO.setEcardsPost(erpCompRoles.getRoleName());
		}
		funEcardsPO.setShardCityId(erpFunUsers.getCityId().intValue());
		funEcardsPO.setCompId(erpFunUsers.getCompId());
		funEcardsPO.setDeptId(erpFunUsers.getDeptId());
		funEcardsPO.setArchiveId(erpFunUsers.getArchiveId());
		funEcardsPO.setEcardsArchiveId(erpFunUsers.getArchiveId());
		funEcardsPO.setCreateTime(DateTimeHelper.formatDateTimetoString(new Date()));
		funEcardsPO.setEcardsTel("手机:"+erpFunUsers.getUserMobile());
		funEcardsPO.setEcardsComp(erpFunDepts.getDeptName());
		funEcardsPO.setCompAdd(erpFunDepts.getDeptAddr());
		funEcardsPO.setIsPublic(false);
		funEcardsPO.setEcardsSex(erpFunUsers.getUserSex());
		funEcardsPO.setEcardsName(erpFunUsers.getUserName());
		erpFunEcardsMapper.insertSelective(funEcardsPO);
	}
	

}
