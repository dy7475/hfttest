package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpCooperateComplaintMapper;
import com.myfun.repository.erpdb.dao.ErpFunTaskMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.param.ErpCooperateComplaintParam;
import com.myfun.repository.erpdb.po.ErpCooperateComplaint;
import com.myfun.repository.erpdb.po.ErpFunTask;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpCooperateComplainService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

@Service
public class ErpCooperateComplainServiceImpl extends AbstractService<ErpCooperateComplaint, ErpCooperateComplaint> implements ErpCooperateComplainService {
	@Autowired
	private ErpCooperateComplaintMapper erpCooperateComplaintMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunTaskService erpFunTaskService;
	@Autowired
	private ErpFunTaskMapper erpFunTaskMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpCooperateComplaintMapper;
	}

	@Override
	public PageInfo<ErpCooperateComplaint> getRecords(ErpCooperateComplaintParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize(), true);
		List<ErpCooperateComplaint> list = erpCooperateComplaintMapper.getRecords(param);
		PageInfo<ErpCooperateComplaint> resPageInfo = new PageInfo<>(list);
		return resPageInfo;
	}

	@Transactional
	@Override
	public void dealProcess(ErpCooperateComplaint complaint, String result, String NOREMNUM, String useage) {
		//查询用户表
		ErpFunUsers users = erpFunUsersMapper.getUserInfoByUserId(complaint.getCityId().intValue(), complaint.getCcUserId());
		
		// 奖励条数
		String hortationAdd = adminSysParaMapper.selectByPrimaryKey("REWARD_BYCOMPLAINT").getParamValue();
		// 处罚条数
		String hortationSub =  adminSysParaMapper.selectByPrimaryKey("PENALTY_BYCOMPLAINT").getParamValue(); 
		String caseType = String.valueOf(complaint.getCaseType());
		String taskStr = "";
		String cnCaseType = "";
		String tableName = "";
		String	columnName = "";
		String columnName2 = "";
		String dateTime = DateUtil.StringToString(complaint.getCcTime(), "yyyy-MM-dd");
		if("1".equals(caseType)){//出售
			cnCaseType = "出售";
			tableName = "FUN_SALE_HOUSING";
			columnName = "SALE_NO";
			columnName2 = "SALE_COOPERATE";
			if("3".equals(useage)){tableName = "FUN_SALE_TRADE";}
			if("3".equals(useage)){tableName = "FUN_SALE_OFFICE";}
		}else if("2".equals(caseType)){//出租
			cnCaseType = "出租";
			tableName = "FUN_LEASE_HOUSING";
			columnName = "LEASE_NO";
			columnName2 = "LEASE_COOPERATE";
			if("3".equals(useage)){tableName = "FUN_LEASE_TRADE";}
			if("3".equals(useage)){tableName = "FUN_LEASE_OFFICE";}
		}
		
		if("1".equals(result)){
			taskStr = "你于"+dateTime+"对"+complaint.getCaseId()+"的" + cnCaseType + "房源的投诉已被成功受理,系统已为你增加 " + hortationAdd + " 条合作信息查看权.";
		}else if("2".equals(result)){
			taskStr =  "你于"+dateTime+"对"+complaint.getCaseId()+"的" + cnCaseType + "房源的投诉经好房通ERP系统后台审查,认为投诉理由不够充分予以撤消投诉. <br />感谢你对好房通联网平台的支持!";
		}
		//新增task
		Integer id = erpFunTaskMapper.getId(complaint.getCityId());
		if(id == null || "".equalsIgnoreCase(String.valueOf(id))){
			id = 0;
		}
		
		ErpFunTask record = new ErpFunTask();
		record.setShardCityId(StringUtil.parseInteger(String.valueOf(complaint.getCityId())));
		record.setTaskId(id);
		record.setCaseId(complaint.getCaseId());
		record.setCaseNo("");
		record.setWarmTime(DateUtil.DateToString(new Date()));
		record.setCaseType(StringUtil.parseByte(caseType));
		record.setIsRead(false);
		record.setDeptId(users.getDeptId());
		record.setCompId(users.getCompId());
		record.setTaskType(Const.DIC_TASK_TYPE_REMIND_TASK);
		record.setTaskOwner(users.getUserId());
		record.setTaskStatus((byte)1);
		record.setCreatorUid(999);
		record.setCreationTime(DateUtil.DateToString(new Date()));
		record.setTaskSubject(Const.DIC_TASK_TYPE_REMIND_TASK_STR + " 请查看投诉处理结果!");
		record.setTaskDesc(taskStr);
		record.setUseage(StringUtil.parseByte(useage));
		record.setTypeFlag(Byte.valueOf("0"));
		erpFunTaskService.insertTask(complaint.getCityId().intValue(), record, (byte) 0);
		
		//给被投诉者写一条记录
		users = erpFunUsersMapper.getUserInfoByUserId(complaint.getCityId().intValue(), complaint.getDefUserId());
		if("1".equals(result)){
			//是否需要进行统计
			if(NOREMNUM != null && "ON".equals(NOREMNUM.toUpperCase())){
				taskStr = dateTime + "对你编号为"+complaint.getCaseId()+"的"+cnCaseType+"房源的投诉经好房通ERP系统后台审查予以确认,系统已扣除你"+hortationSub+" 条合作信息查看量.由于您已经对信息进行了下架处理,所以没有累计被投诉次数.";
			}else{
				taskStr = dateTime + "对你编号为"+complaint.getCaseId()+"的"+cnCaseType+"房源的投诉经好房通ERP系统后台审查予以确认,系统已扣除你 "+hortationSub+" 条合作信息查看量..";
			}
		}else if("2".equals(result)){
			taskStr =  "你于"+dateTime+"对"+complaint.getCaseId()+"的" + cnCaseType + "房源的投诉经好房通ERP系统后台审查,认为投诉理由不够充分予以撤消投诉. <br />感谢你对好房通联网平台的支持!";
		}
		ErpFunTask record2 = new ErpFunTask();
		record2.setShardCityId(StringUtil.parseInteger(String.valueOf(complaint.getCityId())));
		record2.setTaskId(id);
		record2.setCaseId(complaint.getCaseId());
		record2.setCaseNo("");
		record2.setWarmTime(DateUtil.DateToString(new Date()));
		record2.setCaseType(StringUtil.parseByte(caseType));
		record2.setIsRead(false);
		record2.setDeptId(users.getDeptId());
		record2.setCompId(users.getCompId());
		record2.setTaskType(Const.DIC_TASK_TYPE_REMIND_TASK);
		record2.setTaskOwner(users.getUserId());
		record2.setTaskStatus((byte)1);
		record2.setCreatorUid(999);
		record2.setCreationTime(DateUtil.DateToString(new Date()));
		record2.setTaskSubject(Const.DIC_TASK_TYPE_REMIND_TASK_STR + " 请查看投诉处理结果!");
		record2.setTaskDesc(taskStr);
		record2.setUseage(StringUtil.parseByte(useage));
		record2.setTypeFlag(Byte.valueOf("0"));
		erpFunTaskService.insertTask(complaint.getCityId().intValue(), record, (byte) 0);
		String sql = "UPDATE " + tableName + " set " + columnName2 + " = 0 ,COMPLAINT_FLAG = 1 WHERE  " + columnName + " = " ;
		//由于tableName的表不存在，先不执行 
		//修改本表数据
		ErpCooperateComplaint update = new ErpCooperateComplaint();
		update.setCityId(complaint.getCityId());
		update.setShardCityId(StringUtil.parseInteger(String.valueOf(complaint.getCityId())));
		update.setCcId(complaint.getCcId());
		update.setCcResult(StringUtil.parseByte(result));
		update.setResultCon(complaint.getResultCon());
		update.setDealType((byte)2);
		update.setDealTime(DateUtil.DateToString(new Date()));
		
		erpCooperateComplaintMapper.updateByPrimaryKeySelective(update);
		
	}

	

}
