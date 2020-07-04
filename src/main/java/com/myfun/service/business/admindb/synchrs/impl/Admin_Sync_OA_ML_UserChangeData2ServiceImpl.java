package com.myfun.service.business.admindb.synchrs.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.myfun.framework.config.mybatis.service.JsonPageResponse;
import com.myfun.repository.admindb.dao.Admin_Sync_OA_ML_UserChangeData2Mapper;
import com.myfun.repository.admindb.param.Admin_Sync_OA_ML_UserChangeDataParam;
import com.myfun.repository.admindb.po.Admin_Sync_OA_ML_UserChangeData2;
import com.myfun.repository.admindb.vo.Admin_Sync_OA_ML_UserVO;
import com.myfun.repository.admindb.vo.UserTransferVo;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.synchrs.Admin_Sync_OA_ML_UserChangeData2Service;
import com.myfun.service.business.admindb.synchrs.enums.DeptAndEmpTransferConstants.EmpChangTypeEnum;
import com.myfun.service.business.admindb.synchrs.enums.DeptAndEmpTransferConstants.EmpChangType_joinEnum;


/**
 * 
* @ClassName: Admin_Sync_OA_ML_UserChangeDataServiceImpl 
* @Description:同步HRS人员信息异动服务
* @author tangliang1
* @date 2020年6月24日 下午2:52:14 
*
 */
@Service
public class Admin_Sync_OA_ML_UserChangeData2ServiceImpl extends AbstractService<Admin_Sync_OA_ML_UserChangeData2, Integer>
		implements Admin_Sync_OA_ML_UserChangeData2Service {

	@Autowired
	private Admin_Sync_OA_ML_UserChangeData2Mapper userChangeMapper;
	

	/**
	 * 获取当前用户的调迁信息
	 */
	@Override
	public JSONObject getUserTransferInfo(Integer userId) {
		// entryInfo(入职) transferInfo(调迁信息)
		
		JSONObject resultJson=new JSONObject();
		
		// 获取当前用户职级信息
		Admin_Sync_OA_ML_UserVO userVo=userChangeMapper.getSyncUserByHftUserId(userId);
		Preconditions.checkNotNull(userVo, "无效的人员信息");
		resultJson.put("userInfo", userVo);
		
		// 获取当前用户的调迁列表
		Admin_Sync_OA_ML_UserChangeDataParam queryParam=new Admin_Sync_OA_ML_UserChangeDataParam();
		queryParam.setHftUserId(userId);
		List<UserTransferVo>  userTransferList=userChangeMapper.getUserTransferList(queryParam);
		if (Objects.isNull(userTransferList)) {
			userTransferList=Lists.newArrayList();
		}
		
		UserTransferVo entryInfo=null;// 入职记录
		if (userTransferList.size()>0) {
			UserTransferVo tempJoinUserVo=userTransferList.get(0);// 检查第一条是否入职记录
			if ("join".equals(tempJoinUserVo.getTypeCode())) {
				entryInfo=tempJoinUserVo;
			}
		}
		
		if (Objects.isNull(entryInfo)) {
			entryInfo=new UserTransferVo();
			// 设置类型为入职
			entryInfo.setTypeCode(EmpChangTypeEnum.EMP_JOIN.getTypeCode());
			entryInfo.setChangeId(EmpChangType_joinEnum.XIN_PIN.getChangeCode().toString());
			entryInfo.setChageDate(userVo.getJoinDate());
			entryInfo.setInvalidDate(null);
			entryInfo.setNewEmpCode(userVo.getBadge());// 员工编号
			entryInfo.setNewEmpGrade(userVo.getHftRuleDesc());
			entryInfo.setNewJobName(userVo.getPositionName());
			entryInfo.setNewOrgName(userVo.getOrgName());//组织（部门）名称
			
			entryInfo.setOldEmpCode("");
			entryInfo.setOldEmpGrade("");// 职位
			entryInfo.setOldJobName("");//职级
			entryInfo.setOldOrgName("");
			// 在第一个位置入围入职信息（调迁信息以时间倒序排列）
			userTransferList.add(0, entryInfo);
		}
		resultJson.put("transferInfo", userTransferList);
		resultJson.put("changeTypeEnum",EmpChangTypeEnum.getValues());
		return resultJson;
	}


	/**
	 * 获取人员调迁列表
	 */
	@Override
	public JsonPageResponse<UserTransferVo> getUserTransferList(Admin_Sync_OA_ML_UserChangeDataParam userChangeDataParam) {

		
		int pageNo = userChangeDataParam.getPageOffset();
		int pageSize = userChangeDataParam.getPageRows();
		// 执行分页查询
		Page<UserTransferVo> pageData = PageHelper.startPage(pageNo, pageSize);
		List<UserTransferVo> list = userChangeMapper.getUserTransferList(userChangeDataParam);
		JsonPageResponse<UserTransferVo> jpRsp = new JsonPageResponse<UserTransferVo>(list, pageData);
		return jpRsp;
	}


	@Override
	public void setBaseMapper() {
		super.baseMapper=userChangeMapper;
	}
	
}
