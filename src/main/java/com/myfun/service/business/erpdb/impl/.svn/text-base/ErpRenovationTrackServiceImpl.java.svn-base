package com.myfun.service.business.erpdb.impl;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerTrackMapper;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.RenovationCustomerParam;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpRenovationCustomer;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrack;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.service.business.erpdb.ErpRenovationTrackService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

@Service
public class ErpRenovationTrackServiceImpl extends AbstractService<ErpRenovationCustomerTrack, ErpRenovationCustomerTrack>implements ErpRenovationTrackService {
	
	@Autowired
	private ErpRenovationCustomerMapper erpRenovationCustomerMapper;
	@Autowired
	private ErpRenovationCustomerTrackMapper erpRenovationCustomerTrackMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunTaskService erpFunTaskService;
	
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpRenovationCustomerTrackMapper;
	}
	
	/**
	 * 装修客户写跟进
	 *@author 朱科
	 *@param 
	 *@return void
	 *@since 2018年2月26日
	 */
	@Transactional
	@Override
	public void createTrack(Integer cityId, Integer compId, Integer userId, Integer archiveId, BaseMapParam param) {
		Integer id = param.getInteger("id");// 装修客户主键ID
		Byte trackType = param.getByte("trackType"); //跟进类型，0=普通跟进 1=带访 2=有效 3=暂缓 4=无效 5=已装修
		String lastTrackContent = param.getString("lastTrackContent"); //最后跟进内容
		Integer isImmediate = param.getInteger("isImmediate"); //立即发送1，定时发送0
		String warmTime = param.getString("warmTime"); //提醒时间
		Date sendDate = null;
		Byte tempType = null; //客户状态
		Byte tempVisit = null; //是否已带访
		if(StringUtil.isNotBlank(warmTime)){
			sendDate = DateTimeHelper.parseToDate(warmTime);
		}
		// 提醒数据
		String userIds = param.getString("warmedUsers"); // 提醒人
		String warmContent = param.getString("warmContent"); // 提醒内容
		// 修改状态
		ErpRenovationCustomer updateParam = new ErpRenovationCustomer();
		updateParam.setId(id);
		updateParam.setShardCityId(cityId);
		// 写跟进
		if(null != trackType){
			ErpRenovationCustomerTrack erpRenovationCustomerTrack = new ErpRenovationCustomerTrack();
			erpRenovationCustomerTrack.setUserId(userId);
			erpRenovationCustomerTrack.setArchiveId(archiveId);
			erpRenovationCustomerTrack.setShardCityId(cityId);
			erpRenovationCustomerTrack.setTrackContent(lastTrackContent);
			erpRenovationCustomerTrack.setCreationTime(new Date());
			erpRenovationCustomerTrack.setTrackType(trackType);
			erpRenovationCustomerTrack.setCompId(compId);
			erpRenovationCustomerTrack.setRenovationCustomerId(id);
			erpRenovationCustomerTrackMapper.insertSelective(erpRenovationCustomerTrack);
			if(trackType == 5){ //已装修
				tempType =3;
			}else if(trackType == 4){ //无效
				tempType =1;
			}else if(trackType == 3){ //暂缓
				tempType =2;
			}else if(trackType == 2){ //有效
				tempType =0;
			}else if(trackType == 1){ //带访
				tempVisit =1;
			}
			updateParam.setCustStatus(tempType);
			updateParam.setCustVisit(tempVisit);
			updateParam.setLastTrackUid(userId);
			updateParam.setLastTrackTime(new Date());
			updateParam.setLastTrackContent(lastTrackContent);
			erpRenovationCustomerMapper.updateByPrimaryKeySelective(updateParam);
		}
		// 为后面提供caseNo所使用
		ErpRenovationCustomer erpRenovationCustomer = erpRenovationCustomerMapper.selectByPrimaryKey(updateParam);
		// 提醒任务
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.queryDept(archiveId);
		ErpCreateTrackInfoParam erpCreateTrackInfoParam = new ErpCreateTrackInfoParam();
		erpCreateTrackInfoParam.setWarmedUsers(userIds);
		erpCreateTrackInfoParam.setWarmContent(warmContent);
		erpCreateTrackInfoParam.setCreateCurrUserName(erpFunDepts.getDeptName() + " " +erpFunUsers.getUserName());
		erpCreateTrackInfoParam.setIsImmediate(isImmediate.byteValue());
		erpCreateTrackInfoParam.setCreateAuditUser(erpFunUsers);
		erpCreateTrackInfoParam.setCompId(compId);
		erpCreateTrackInfoParam.setCityId(cityId);
		erpCreateTrackInfoParam.setCaseType(0);
		erpCreateTrackInfoParam.setCaseId(id);
		erpCreateTrackInfoParam.setCaseNo(erpRenovationCustomer.getRenovationNo());
		erpCreateTrackInfoParam.setTrackType((byte) 3);
		erpCreateTrackInfoParam.setWarmTime(sendDate);
		erpFunTaskService.createWarmTask(erpCreateTrackInfoParam, Const.DIC_TASK_TYPE_RENOVATION_REMIND, (byte) 0);
	}

	@Override
	public void createUpdateCustomeTrack(RenovationCustomerParam param) {
		ErpRenovationCustomerTrack erpRenovationCustomerTrack = new ErpRenovationCustomerTrack();
		erpRenovationCustomerTrack.setUserId(param.getUserId());
		erpRenovationCustomerTrack.setArchiveId(param.getArchiveId());
		erpRenovationCustomerTrack.setShardCityId(param.getShardCityId());
		erpRenovationCustomerTrack.setTrackContent(param.getUserName() + " 编辑了装修客户资料");
		erpRenovationCustomerTrack.setCreationTime(new Date());
		erpRenovationCustomerTrack.setTrackType((byte)0);
		erpRenovationCustomerTrack.setCompId(param.getCompId());
		erpRenovationCustomerTrack.setRenovationCustomerId(param.getId());
		erpRenovationCustomerTrackMapper.insertSelective(erpRenovationCustomerTrack);
	}
}
