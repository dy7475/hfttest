package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.myfun.utils.EnCodeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.AdminCrmUserMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminYouPaidMapper;
import com.myfun.repository.admindb.dao.ErpYouBorkerArchiveMapper;
import com.myfun.repository.admindb.dao.ErpYouComplaintTypeMapper;
import com.myfun.repository.admindb.dao.ErpYouPunishTypeMapper;
import com.myfun.repository.admindb.param.YouComplaintProcessParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminYouPaid;
import com.myfun.repository.admindb.po.ErpYouBorkerArchive;
import com.myfun.repository.admindb.po.ErpYouComplaintType;
import com.myfun.repository.admindb.po.ErpYouPunishType;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunMsgMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpYouBorkerComplaintMapper;
import com.myfun.repository.erpdb.dao.ErpYouBorkerPurchaseMapper;
import com.myfun.repository.erpdb.dao.ErpYouShareHouseStatusMapper;
import com.myfun.repository.erpdb.dto.ErpYouBorkerComplaintDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunMsg;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpYouBorkerComplaint;
import com.myfun.repository.erpdb.po.ErpYouBorkerPurchase;
import com.myfun.repository.erpdb.po.ErpYouShareHouseStatus;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpYouBorkerComplaintService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.EncryptHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.rest.EncryptUtil;

@Service
public class ErpYouBorkerComplaintServiceImpl extends AbstractService<ErpYouBorkerComplaint, ErpYouBorkerComplaint> implements ErpYouBorkerComplaintService {

	@Autowired
	private ErpYouBorkerComplaintMapper borkerComplaintMapper;
	@Autowired
	private ErpYouComplaintTypeMapper erpYouComplaintTypeMapper;
	@Autowired
	private AdminCrmUserMapper adminCrmUserMapper;
	@Autowired
	private ErpYouBorkerPurchaseMapper erpYouBorkerPurchaseMapper;
	@Autowired
	private ErpYouPunishTypeMapper erpYouPunishTypeMapper;
	@Autowired
	private ErpYouBorkerArchiveMapper erpYouBorkerArchiveMapper;
	@Autowired
	private AdminYouPaidMapper adminYouPaidMapper;
	@Autowired
	private ErpYouShareHouseStatusMapper erpYouShareHouseStatusMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper=borkerComplaintMapper;
	}
	
	/**
	 * 房源方被投诉成功
	 */
	private String shareHousesCoverSuccessStr = "您的%s房源于%s被投诉【%s】，经确认情况属实，处理结果：%s%s%s%s。";
	/**
	 * 购买方投诉成功
	 */
	private String purchaseSuccessStr = "您于%s对%s房源的投诉经确认情况属实，对房源方处理结果：%s%s%s%s。";
	/**
	 * 购买方被他人投诉成功
	 */
	private String purchaseOtherStr = "您查看过的%s房源，于%s被投诉【%s】，退还您查看积分";
	/**
	 * 购买方投诉失败
	 */
	private String purchaseFailStr = "您于%s对%s房源的投诉经好房通ERP系统后台审查，认为投诉理由不够充分予以撤消投诉. 感谢您对好房通YOU+平台的支持!";
	/**
	 * 房源方投诉成功
	 */
	private String shareHousesSuccessStr = "您于%s对%s投诉【%s】，经确认情况属实，处理结果：%s%s。";
	/**
	 * 购买方被投诉成功
	 */
	private String purchaseCoverSuccessStr = "您于%s被%s投诉【%s】，经确认情况属实，处理结果：%s%s。";
	/**
	 * 房源方投诉失败
	 */
	private String shareHousesFailStr = "您于%s对%s投诉【%s】，经好房通ERP系统后台审查,认为投诉理由不够充分予以撤消投诉. 感谢您对好房通YOU+平台的支持!";

	/**
	 * 统计房源投诉未处理的条数
	 * 
	 */
	@Override
	public int getNotComPlainCounts(Integer cityId, Integer shareId) {
		return borkerComplaintMapper.getNotComPlainCounts(cityId, shareId);
	}

	/**
	 * 统计房源投诉次数
	 * 
	 */
	@Override
	public int getHouseComPlainCounts(Integer cityId, Integer shareId) {
		return borkerComplaintMapper.getHouseComPlainCounts(cityId, shareId);
	}

	@Override
	public int getPurchasePersonNumber(Integer cityId, Integer shareId) {
		return borkerComplaintMapper.getPurchasePersonNumber(cityId, shareId);
	}

	@Override
	public List<ErpYouBorkerComplaintDto> getCompalinListByShareId(ErpYouShareHouseStatus erpYouShareHouseStatus) {
		List<ErpYouBorkerComplaintDto> list = borkerComplaintMapper.getCompalinListByShareId(erpYouShareHouseStatus.getCityId(), erpYouShareHouseStatus);
		for (ErpYouBorkerComplaintDto erpYouBorkerComplaintDto : list) {
			ErpYouComplaintType complaintType = erpYouComplaintTypeMapper.selectByYctId(erpYouBorkerComplaintDto.getComplainType());
			erpYouBorkerComplaintDto.setComplainTypeName(complaintType.getYctName());
			AdminCrmUser adminCrmUser = adminCrmUserMapper.selectByPrimaryKey(erpYouBorkerComplaintDto.getDealCrmUser());
			if(adminCrmUser!=null){
				erpYouBorkerComplaintDto.setCrmUserName(adminCrmUser.getUserName());
			}
			erpYouBorkerComplaintDto.setShareId(erpYouShareHouseStatus.getShareId());
		}
		return list;
	}

	@Override
	public ErpYouBorkerComplaint getByPrimaryKey(Integer cityId, Integer complainId) {
		return borkerComplaintMapper.getByPrimaryKey(cityId, complainId);
	}

	@Transactional
	@Override
	public String saveProcess(YouComplaintProcessParam param, AdminCrmUser adminCrmUser) {
		//根据投诉信息ID获得一个投诉信息
		Date date = new Date();
		ErpFunMsg erpFunMsg = new ErpFunMsg();
		String time = DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss");
		//根据投诉ID获取经纪人投诉记录
		ErpYouBorkerComplaint borkerComplaint = borkerComplaintMapper.getByPrimaryKey(param.getCityId(), param.getComplaintId());
		int purchaseId = borkerComplaint.getSourceInfoId();
		// 修改投诉标记
		if("1".equals(borkerComplaint.getCinfoType())){
			purchaseId = borkerComplaint.getTargetInfoId();
		}
		// 处理意见
		String resultContent = param.getDealDesc();
		//获取投诉人的购买记录
		ErpYouBorkerPurchase borkerPurchase = erpYouBorkerPurchaseMapper.selectByPurchaseId(param.getCityId(), purchaseId);
		//获取对被投诉人的处罚类型//查询惩罚规则
		ErpYouPunishType erpYouPunishType = erpYouPunishTypeMapper.selectByPrimaryKey(param.getYptId());
		
		//初始化FUN_MSG的基本信息字段
		erpFunMsg.setCompId(borkerComplaint.getSourceCompId());
		erpFunMsg.setReceiveDept(borkerComplaint.getSourceDeptId());
		erpFunMsg.setReceiveUser(borkerComplaint.getSourceUserId());
		
		String cinfoType = borkerComplaint.getCinfoType()+"";
		String caseType = borkerComplaint.getCaseType()+"";
		
		
		//如果投诉成功对被投诉人进行惩罚  
		if(param.getProcessResult() == 1){
			// 是否累积投诉次数
			if(param.getIsAddComplaintNu() == 1){
				erpYouBorkerArchiveMapper.addComplainNumber(borkerComplaint.getTargetArchiveId());
			}
			//分享房源是否下架
			if(erpYouPunishType.getYptShareFlag() == 1 && borkerComplaint.getCinfoType() == 0){
				//批量处理该条房源的其他投诉，标记为处理失败，
				resultContent = "此房源已被其他人投诉成功并下架，此次投诉无效！";
				ErpYouBorkerComplaint complaint = borkerComplaint;
				complaint.setComplainContent(resultContent);
				complaint.setDealStatus((byte) 2);
				borkerComplaintMapper.updateComplaint(param.getCityId(), complaint);
				//批量处理该条房源的其他购买者的投诉标记
				erpYouBorkerPurchaseMapper.updateBorkerPurchaseAll(param.getCityId(), borkerComplaint.getTargetInfoId());
			}
			//执行处罚
			resultContent = this.executionYouPunish(erpYouPunishType, borkerComplaint, purchaseId, erpFunMsg);
			
			if(borkerPurchase.getIsReturnIntegral() !=1){
				this.updateBorkerPurchase(borkerComplaint.getCityId(), purchaseId, borkerComplaint.getCinfoType(), "2", erpYouPunishType.getYptReturnObject()==1?"1":"0");
			}else{
				this.updateBorkerPurchase(borkerComplaint.getCityId(), purchaseId, borkerComplaint.getCinfoType(), "2", String.valueOf(erpYouPunishType.getYptReturnObject()));
			}
		}else{
			//修改购买方投诉标记
			if(borkerPurchase.getIsReturnIntegral() !=1){
				this.updateBorkerPurchase(borkerComplaint.getCityId(), purchaseId, borkerComplaint.getCinfoType(), "2", erpYouPunishType.getYptReturnObject()==1?"1":"0");
			}else{
				this.updateBorkerPurchase(borkerComplaint.getCityId(), purchaseId, borkerComplaint.getCinfoType(), "2", String.valueOf(erpYouPunishType.getYptReturnObject()));
			}
			
			erpFunMsg.setMsgContent(String.format(purchaseFailStr, borkerComplaint.getComplainTime(), ("1".equals(caseType)?"出售":"出租")));
			if("1".equals(cinfoType)){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(borkerComplaint.getCityId(), borkerComplaint.getSourceUserId());
				erpFunMsg.setMsgContent(String.format(shareHousesFailStr, borkerComplaint.getComplainTime(), erpFunUsers.getUserName(), borkerComplaint.getComplainType()));
			}
			this.createMsg(borkerComplaint.getCityId(), erpFunMsg);
			resultContent = "经好房通ERP系统后台审查，认为投诉理由不够充分予以撤消投诉，感谢您对好房通YOU+平台的支持!";
		}
		//最后跟新YOU_BORKER_COMPLAINT即完结
		ErpYouBorkerComplaint complaint = new ErpYouBorkerComplaint();
		complaint.setDealCrmUser(adminCrmUser.getUserId());
		complaint.setDealStatus(Byte.valueOf(String.valueOf(param.getProcessResult())));
		complaint.setDealType(Byte.valueOf(String.valueOf(param.getYptId())));
		complaint.setDealDesc(resultContent);
		complaint.setDealTime(DateUtil.StringToDate(time));
		complaint.setComplaintId(borkerComplaint.getComplaintId());
		complaint.setShardCityId(borkerComplaint.getCityId());
		borkerComplaintMapper.updateByPrimaryKeySelective(complaint);
		return "true";
	}

	/**
	 * 修改购买方投诉标记
	 * @param cityId
	 * @param purchaseId
	 * @param cinfoType
	 * @param complainFlag
	 * @param yptReturnObject
	 */
	private void updateBorkerPurchase(Integer cityId, Integer purchaseId, Byte cinfoType, String complainFlag, String yptReturnObject) {
		ErpYouBorkerPurchase purchase = new ErpYouBorkerPurchase();
		purchase.setShardCityId(cityId);
		if(cinfoType==1){
			purchase.setTargetComplainFlag(Integer.parseInt(complainFlag));
		}else{
			purchase.setComplainFlag(Byte.valueOf(complainFlag));
		}
		purchase.setIsReturnIntegral(Byte.valueOf(yptReturnObject));
		purchase.setPurchaseId(purchaseId);
		erpYouBorkerPurchaseMapper.updateByPrimaryKeySelective(purchase);
	}

	/**
	 * 执行处罚
	 * @param erpYouPunishType
	 * @param borkerComplaint
	 * @param purchaseId
	 * @param erpFunMsg 
	 * @return
	 */
	private String executionYouPunish(ErpYouPunishType erpYouPunishType, ErpYouBorkerComplaint borkerComplaint, int purchaseId, ErpFunMsg erpFunMsg) {
		StringBuffer result = new StringBuffer("经好房通ERP系统后台审查确认投诉情况属实，");
		Date date = new Date();
		String time = DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss");
		//积分扣罚并写消费记录
		if(erpYouPunishType.getYptIntegral() !=null){
			ErpYouBorkerArchive borkerArchive = erpYouBorkerArchiveMapper.selectByPrimaryKey(borkerComplaint.getTargetArchiveId());
			ErpYouBorkerArchive archive = new ErpYouBorkerArchive();
			archive.setYouAmount(BigDecimal.valueOf(erpYouPunishType.getYptIntegral()));
			archive.setArchiveId(borkerComplaint.getTargetArchiveId());
			erpYouBorkerArchiveMapper.buckleIntegral(archive);	//扣除积分
			AdminYouPaid youPaid = new  AdminYouPaid();
			youPaid.setArchiveId(borkerComplaint.getTargetArchiveId());
			youPaid.setPaidCatigory("0");	//支出
			youPaid.setPaidType("4");
			youPaid.setYouAmount(BigDecimal.valueOf(erpYouPunishType.getYptIntegral()));
			youPaid.setAmountBefore(borkerArchive.getYouAmount());
			youPaid.setAmountAfter(borkerArchive.getYouAmount() .multiply(BigDecimal.valueOf(erpYouPunishType.getYptIntegral())));
			youPaid.setPaidDesc(borkerComplaint.getComplainType()+"投诉扣罚");
			youPaid.setCreationTime(date);
			adminYouPaidMapper.insertSelective(youPaid);//写一条消费记录
			result.append("扣罚积分" + erpYouPunishType.getYptIntegral() + "分");
		}
		
		BigDecimal purchaseIntegral = BigDecimal.valueOf(0);
		//积分退还并写消费记录
		if(erpYouPunishType.getYptReturnObject() ==1 && borkerComplaint.getCinfoType() ==0){
			//获取购买记录
			ErpYouBorkerPurchase borkerPurchase = erpYouBorkerPurchaseMapper.selectByPurchaseId(borkerComplaint.getCityId(), purchaseId);
			purchaseIntegral = borkerPurchase.getCostIntegral() ==null ?BigDecimal.valueOf(0): borkerPurchase.getCostIntegral();
			//投诉成功，退还积分
			if(borkerPurchase.getIsReturnIntegral() !=1){
				this.returnIntegral(borkerComplaint.getSourceArchiveId(), borkerPurchase.getCostIntegral(), "投诉成功退还");
			}
		}
		
		//房源是否下架
		//写被投诉人提醒
		ErpFunMsg funMsg = new ErpFunMsg();
		funMsg.setCompId(borkerComplaint.getTargetCompId());
		funMsg.setReceiveDept(borkerComplaint.getTargetDeptId());
		funMsg.setReceiveUser(borkerComplaint.getTargetUserId());
		String caseType = borkerComplaint.getCaseType()+"";
		String yptReturnObject = erpYouPunishType.getYptReturnObject()+"";
		String yptShareFlag = erpYouPunishType.getYptShareFlag()+"";
		String yptIntegral =erpYouPunishType.getYptIntegral()+"";
		String yptStopDays =erpYouPunishType.getYptStopDays()+"";
		
		ErpYouShareHouseStatus erpYouShareHouseStatus = erpYouShareHouseStatusMapper.getRecordByShareId(borkerComplaint.getCityId(),borkerComplaint.getTargetInfoId());
		//房源赚取积分（只包含他人购买后赚取的）
		BigDecimal shareIntegral = erpYouShareHouseStatus.getTotalIntegral();
		//分享所得积分
		BigDecimal awardIntegral = erpYouShareHouseStatus.getAwardIntegral();
		//分享额外所得积分
		BigDecimal awardPicIntegral = erpYouShareHouseStatus.getAwardPicIntegral();
		if(borkerComplaint.getCinfoType()==0){
			erpFunMsg.setMsgContent(String.format(purchaseSuccessStr, DateUtil.DateToString(borkerComplaint.getComplainTime(), "yyyy-MM-dd HH:mm:ss"), ("1".equals(borkerComplaint.getCaseType())?"出售":"出租"), ("1".equals(erpYouPunishType.getYptReturnObject())?"退还您查看积分":""), ("1".equals(erpYouPunishType.getYptShareFlag())?"，房源下架":""), !"0".equals(erpYouPunishType.getYptIntegral())?"、并扣罚积分"+erpYouPunishType.getYptIntegral()+"分":"", (erpYouPunishType.getYptStopDays() !=null && erpYouPunishType.getYptStopDays()!= 0)?"，停止好房YOU+分享、合作"+erpYouPunishType.getYptStopDays()+"天":""));
			this.createMsg(borkerComplaint.getCityId(), erpFunMsg);
			if(erpYouPunishType.getYptShareFlag()==1){
				// 下架房源
				this.updateShareHouse(borkerComplaint.getCityId(), borkerComplaint.getCaseId(), borkerComplaint.getCaseType(), time, borkerComplaint.getTargetInfoId());
				//查询该房源的购买记录
				List<ErpYouBorkerPurchase> elements = this.getHousePurchaseList(borkerComplaint.getCityId(), borkerComplaint.getTargetInfoId());
				for (ErpYouBorkerPurchase erpYouBorkerPurchase : elements) {
					//退还积分对象
					
					//消费积分
					if(erpYouBorkerPurchase.getArchiveId() == borkerComplaint.getShardArchiveId()){
						this.returnIntegral(erpYouBorkerPurchase.getArchiveId(), erpYouBorkerPurchase.getCostIntegral(), "已查看的房源被投诉下架退还");
						
						//写投诉人提醒
						//this.createMsg(hashMapMsg);
					}else if(erpYouPunishType.getYptReturnObject()==1){
						this.returnIntegral(erpYouBorkerPurchase.getArchiveId(), erpYouBorkerPurchase.getCostIntegral(), "投诉成功退还");
					}
				}
				funMsg.setMsgContent(String.format(shareHousesCoverSuccessStr, ("1".equals(caseType)?"出售":"出租"), DateUtil.DateToString(borkerComplaint.getComplainTime(), "yyyy-MM-dd HH:mm:ss"), borkerComplaint.getComplainType(), ("1".equals(yptReturnObject)?"退还该房源全部已获积分，":""), ("1".equals(yptShareFlag)?"房源下架、并":""), !"0".equals(yptIntegral)?"扣罚积分"+yptIntegral+"分":"", ((!yptStopDays.isEmpty() && !"0".equals(yptStopDays))?"，停止好房YOU+分享、合作"+yptStopDays+"天":"")));
				
				BigDecimal integralAll = awardIntegral==null?BigDecimal.valueOf(0):awardIntegral.add(awardPicIntegral==null?BigDecimal.valueOf(0):awardPicIntegral).add(shareIntegral==null?BigDecimal.valueOf(0):shareIntegral);
				if(integralAll.compareTo(BigDecimal.valueOf(0))==-1){
					integralAll = BigDecimal.valueOf(0.0);
				}
				//被投诉人退还查看人积分
				this.buckleIntegral(borkerComplaint.getTargetArchiveId(), integralAll, borkerComplaint.getComplainType()+"投诉，退还该房源全部获赠积分");
				//被投诉房源退还积分
				this.buckleHouseIntegral(borkerComplaint.getCityId(), borkerComplaint.getTargetInfoId(), BigDecimal.valueOf(0.0));
				result.append("，房源下架，并退还该房源全部已获积分");
			}else{
				
				funMsg.setMsgContent(String.format(shareHousesCoverSuccessStr, ("1".equals(caseType)?"出售":"出租"), DateUtil.DateToString(borkerComplaint.getComplainTime(), "yyyy-MM-dd HH:mm:ss"), borkerComplaint.getComplainType(), ("1".equals(yptReturnObject)?"退还投诉人积分，":""), ("1".equals(yptShareFlag)?"房源下架、并":""), !"0".equals(yptIntegral)?"扣罚积分"+yptIntegral+"分":"", ((!yptStopDays.isEmpty() && !"0".equals(yptStopDays))?"，停止好房YOU+分享、合作"+yptStopDays+"天":"")));
				BigDecimal integralAll = shareIntegral.multiply(purchaseIntegral);
				if(integralAll.compareTo(BigDecimal.valueOf(0))==-1){
					integralAll = BigDecimal.valueOf(0.0);
				}
				//被投诉人退还查看人积分
				this.buckleIntegral(borkerComplaint.getTargetArchiveId(), purchaseIntegral, borkerComplaint.getComplainType()+"投诉，退还投诉人");
				//被投诉房源退还积分
				this.buckleHouseIntegral(borkerComplaint.getCityId(), borkerComplaint.getTargetInfoId(), integralAll);
				if(erpYouPunishType.getYptReturnObject() ==1 && borkerComplaint.getCinfoType() ==0){
					result.append("，退还投诉人积分");
				}
			}
		}else{
			//被投诉人
			ErpFunUsers erpFunUsers = null;
			erpFunUsers = erpFunUsersMapper.selectByUserId(borkerComplaint.getCityId(), borkerComplaint.getSourceUserId());
			funMsg.setMsgContent(String.format(purchaseCoverSuccessStr, DateUtil.DateToString(borkerComplaint.getComplainTime(), "yyyy-MM-dd HH:mm:ss"), erpFunUsers.getUserName(), erpYouPunishType.getYctComplainType(), !"0".equals(yptIntegral)?"扣罚积分"+yptIntegral+"分":"", ((!yptStopDays.isEmpty() && !"0".equals(yptStopDays))?"，停止好房YOU+分享、合作"+yptStopDays+"天":"")));
			//投诉人
			erpFunUsers = erpFunUsersMapper.selectByUserId(borkerComplaint.getCityId(), borkerComplaint.getTargetUserId());
			erpFunMsg.setMsgContent(String.format(shareHousesSuccessStr, DateUtil.DateToString(borkerComplaint.getComplainTime(), "yyyy-MM-dd HH:mm:ss"), erpFunUsers.getUserName(), erpYouPunishType.getYctComplainType(), !"0".equals(yptIntegral)?"扣罚积分"+yptIntegral+"分":"", ((!yptStopDays.isEmpty() && !"0".equals(yptStopDays))?"，停止好房YOU+分享、合作"+yptStopDays+"天":"")));
			this.createMsg(borkerComplaint.getCityId(), erpFunMsg);
		}
		
		//停权
		if(erpYouPunishType.getYptStopDays() !=null && erpYouPunishType.getYptStopDays() !=0){
			//停权对象
			HashMap<String, String> hashMap = new HashMap<String, String>();
			AdminFunArchive funArchive = adminFunArchiveMapper.selectByPrimaryKey(borkerComplaint.getTargetArchiveId());
			hashMap.put("SOURCES", "3");
			hashMap.put("DEPT_ID", borkerComplaint.getTargetDeptId()+"");
			hashMap.put("USER_MOBILE", funArchive.getUserMobile());
			hashMap.put("ARCHIVE_ID", borkerComplaint.getTargetArchiveId()+"");
			hashMap.put("action", "updateBanRight");
			hashMap.put("TOKEN", EnCodeHelper.encode(funArchive.getUserMobile()));
			
			if(erpYouPunishType.getYptStopObject()==0){//个人停权
				ErpYouBorkerArchive archive = new ErpYouBorkerArchive();
				archive.setLimitStartTime(DateUtil.StringToDate(time));
				archive.setLimitEndTime(DateUtil.addDay(DateUtil.StringToDate(time), erpYouPunishType.getYptStopDays()));
				archive.setArchiveId(borkerComplaint.getTargetArchiveId());
				erpYouBorkerArchiveMapper.updateByPrimaryKeySelective(archive);
				
				hashMap.put("YPT_STOP_OBJECT", erpYouPunishType.getYptStopObject()+"");
			}else if(erpYouPunishType.getYptStopObject()==1){
				//查询门店编号DEPT_NO
				ErpFunDepts dept = this.getDeptNo(borkerComplaint.getCityId(), borkerComplaint.getTargetDeptId());
				AdminFunDepts adminFunDepts = new AdminFunDepts();
				adminFunDepts.setYouLimitStartTime(DateUtil.StringToDate(time));
				adminFunDepts.setYouLimitEndTime(DateUtil.addDay(DateUtil.StringToDate(time), erpYouPunishType.getYptStopDays()));
				adminFunDepts.setDeptNo(dept.getDeptNo());
				adminFunDepts.setCompNo(dept.getCompNo());
				adminFunDeptsMapper.stopObject(adminFunDepts);
				
				hashMap.put("YPT_STOP_OBJECT", erpYouPunishType.getYptStopObject()+"");
			}
			result.append("，停止好房YOU+分享、合作" + erpYouPunishType.getYptStopDays() + "天");
			
			/****************暂时屏蔽，等待和ERP联调*******************/
			//HttpUtil.post(AppConfig.getErpObjectUrl()+"web/api/authentication/per.do", hashMap);
		}
		//写被投诉人提醒
		this.createMsg(borkerComplaint.getCityId(), funMsg);
		
		return result.toString();
	}

	/**
	 * 写提醒
	 * @param erpFunMsg
	 */
	private void createMsg(Integer cityId, ErpFunMsg erpFunMsg) {
		Date date = new Date();
		String time = DateUtil.DateToString(date, "yyyy-MM-dd HH:mm:ss");
		erpFunMsg.setSendUser(999);
		erpFunMsg.setSendTime(date);
		erpFunMsg.setReadFlag(false);
		erpFunMsg.setSendDel(false);
		erpFunMsg.setReceiveDel(false);
		erpFunMsg.setShardCityId(cityId);
		erpFunMsgMapper.insertSelective(erpFunMsg);
	}

	private ErpFunDepts getDeptNo(Integer cityId, Integer targetDeptId) {
		return erpFunDeptsMapper.getByDeptId(cityId, targetDeptId);
	}

	/**
	 * 被投诉房源退还积分
	 * @param targetInfoId
	 * @param d
	 */
	private void buckleHouseIntegral(Integer cityId, Integer targetInfoId, BigDecimal integralAll) {
		ErpYouShareHouseStatus houseStatus = new ErpYouShareHouseStatus();
		houseStatus.setShareId(targetInfoId);
		houseStatus.setTotalIntegral(integralAll);
		erpYouShareHouseStatusMapper.buckleHouseIntegral(cityId, houseStatus);
	}

	/**
	 * 积分扣罚
	 * @param targetArchiveId
	 * @param valueOf
	 * @param string
	 */
	private void buckleIntegral(Integer targetArchiveId, BigDecimal costIntegral, String paidDesc) {
		Date date=new Date();
		ErpYouBorkerArchive borkerArchive = erpYouBorkerArchiveMapper.selectByPrimaryKey(targetArchiveId);
		ErpYouBorkerArchive archive = new ErpYouBorkerArchive();
		archive.setYouAmount(costIntegral);
		archive.setArchiveId(targetArchiveId);
		erpYouBorkerArchiveMapper.buckleIntegral(archive);	//扣除积分
		
		AdminYouPaid youPaid = new  AdminYouPaid();
		youPaid.setArchiveId(targetArchiveId);
		youPaid.setPaidCatigory("0");	//支出
		youPaid.setPaidType("4");
		youPaid.setYouAmount(costIntegral);
		youPaid.setAmountBefore(borkerArchive.getYouAmount());
		youPaid.setAmountAfter(borkerArchive.getYouAmount() .multiply(costIntegral));
		youPaid.setPaidDesc(paidDesc);
		youPaid.setCreationTime(date);
		adminYouPaidMapper.insertSelective(youPaid);//写一条消费记录
	}

	/**
	 * 查询该房源的购买记录
	 * @param targetInfoId
	 * @return
	 */
	private List<ErpYouBorkerPurchase> getHousePurchaseList(Integer cityId, Integer targetInfoId) {
		return erpYouBorkerPurchaseMapper.getHousePurchaseList(cityId, targetInfoId);
	}

	/**
	 * 下架房源
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @param time
	 * @param targetInfoId
	 */
	private void updateShareHouse(Integer cityId, Integer caseId, Byte caseType, String time, Integer targetInfoId) {
		ErpYouShareHouseStatus houseStatus = new ErpYouShareHouseStatus();
		houseStatus.setDownTime(DateUtil.StringToDate(time));
		houseStatus.setShareId(targetInfoId);
		erpYouShareHouseStatusMapper.downShareHouse(cityId, houseStatus);
		
		ErpYouBorkerPurchase borkerPurchase = new ErpYouBorkerPurchase();
		borkerPurchase.setShardCityId(cityId);
		borkerPurchase.setYouShareFlag((byte) 0);
		borkerPurchase.setYouShareId(targetInfoId);
		erpYouBorkerPurchaseMapper.updateByShareId(borkerPurchase);
		
		if(caseType==1){
			ErpFunSale erpFunSale =new ErpFunSale();
			erpFunSale.setShardCityId(cityId);
			erpFunSale.setYouShareId(targetInfoId);
			erpFunSale.setYouShareFlag((byte) 0);
			erpFunSale.setSaleId(caseId);
			erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
		}else{
			ErpFunLease funLease =new ErpFunLease();
			funLease.setShardCityId(cityId);
			funLease.setYouShareId(targetInfoId);
			funLease.setYouShareFlag((byte) 0);
			funLease.setLeaseId(caseId);
			erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
		}
		
	}

	/**
	 * 积分退还
	 * @param sourceArchiveId
	 * @param costIntegral
	 * @param paidDesc
	 */
	private void returnIntegral(Integer sourceArchiveId, BigDecimal costIntegral, String paidDesc) {
		Date date=new Date();
		ErpYouBorkerArchive sourseBorkerArchive = erpYouBorkerArchiveMapper.selectByPrimaryKey(sourceArchiveId);
		ErpYouBorkerArchive archive = new ErpYouBorkerArchive();
		archive.setYouAmount(costIntegral);
		archive.setArchiveId(sourceArchiveId);
		erpYouBorkerArchiveMapper.returnIntegral(archive);	//退还积分
		
		//写一条消费记录
		AdminYouPaid youPaid = new  AdminYouPaid();
		youPaid.setArchiveId(sourceArchiveId);
		youPaid.setPaidCatigory("1");	//收入
		youPaid.setPaidType("3");
		youPaid.setYouAmount(costIntegral);
		youPaid.setAmountBefore(sourseBorkerArchive.getYouAmount());
		youPaid.setAmountAfter(sourseBorkerArchive.getYouAmount() .add(costIntegral));
		youPaid.setPaidDesc(paidDesc);
		youPaid.setCreationTime(date);
		adminYouPaidMapper.insertSelective(youPaid);
		
	}

}
