/**
 * @author 方李骥
 * @since 2016年8月29日
 */
package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.transaction.param.UpdateOrInsertDealTaxesParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomerExample.Criteria;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.*;

import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpCityshareHouseMapper;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.report.ReportFunSaleMinService;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

/**
 * @author 方李骥
 * @since 2016年8月29日
 */
@Service
public class ErpFunBuyCustomerServiceImpl extends AbstractService<ErpFunBuyCustomer, ErpFunBuyCustomer> implements ErpFunBuyCustomerService{
	
	@Autowired private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpSysParaService erpSysParaService;
	@Autowired private ErpFunTaskService erpFunTaskService;
	@Autowired private AdminFunArchiveService adminFunArchiveService;
	@Autowired private ErpFunPhoneMapper erpFunPhoneMapper;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ReportFunSaleMinService reportFunSaleMinService;
	@Autowired private ErpFunTrackService erpFunTrackService;
	@Autowired private ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
	@Autowired private ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired private ErpCityshareHouseMapper erpCityshareHouseMapper;
	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 */
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunBuyCustomerMapper;

	}

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param buyCustId
	 * @return
	 */
	@Override
	public ErpFunBuyCustomer getFunBuyCustomer(Integer cityId, Integer buyCustId) {
		return erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, buyCustId);
	}

	@Override
	public boolean countShareHouse(Integer cityId,Integer compId) {
		Integer count = erpFunBuyCustomerMapper.countShareHouse(cityId,compId);
		return count > 0;
	}

	@Override
	public void updateHouseRunModelForPrivate(Integer cityId, Integer compId) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId);
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		updateModel.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date()));
		updateModel.setSpecialTime(DateTimeHelper.formatDateTimetoString(new Date()));
		updateModel.setScheduleTime(DateTimeHelper.formatDateTimetoString(new Date()));
		updateModel.setSecrecyTime(DateTimeHelper.formatDateTimetoString(new Date()));
		updateModel.setCommendTime(DateTimeHelper.formatDateTimetoString(new Date()));
		updateModel.setActionTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHousePlateTypeByRunModel(Integer cityId, Integer compId) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId);
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseActionTimeBySysPara(Integer cityId, Integer compId) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId).andPublicCountEqualTo(0).andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setActionTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseActionTimeBySysParaByOrg(Integer cityId, Integer compId, List<Integer> orgIds) {
		
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if (CollectionUtils.isNotEmpty(orgIds)) {
			criteria.andOrganizationIdIn(orgIds);
		}
		criteria.andPublicCountEqualTo(0);
		criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setActionTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseTrackTime(Integer cityId, Integer compId, String string) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		boolean fromPublic = "0".equals(string)?false:true;
		example.createCriteria().andCompIdEqualTo(compId).andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue()).andFromPublicEqualTo(fromPublic);
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds, Integer custIntention) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		boolean fromPublic = !"0".equals(string);
		Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		criteria.andCustIntentionEqualTo(custIntention);
		if (CollectionUtils.isNotEmpty(orgIds)) {
			criteria.andOrganizationIdIn(orgIds);
		}
		criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		criteria.andFromPublicEqualTo(fromPublic);
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHousePublicTime(Integer cityId, Integer compId) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId).andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setPublicTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHousePublicTimeByOrg(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		example.setShardCityId(cityId);
		Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if (CollectionUtils.isNotEmpty(orgIds)) {
			criteria.andOrganizationIdIn(orgIds);
		}
		criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setPublicTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateCustomerSourceNotCooperate(Integer cityId, Integer compId) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId).andCityShareFlagGreaterThan((byte)0);
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setCityShareFlag((byte)0);
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateCustomerSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunBuyCustomerExample example = new ErpFunBuyCustomerExample();
		example.createCriteria()
				.andCompIdEqualTo(compId)
				.andOrganizationIdIn(orgIds)
				.andCityShareFlagGreaterThan((byte)0);
		example.setShardCityId(cityId);
		ErpFunBuyCustomer updateModel = new ErpFunBuyCustomer();
		updateModel.setCityShareFlag((byte)0);
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, example);
	}
	
	@Override
	public boolean getIdCardRepeat(Integer cityId, Integer compId, Integer selfUserId, Integer custId, 
			boolean isPersonalVersion, Integer caseType, String idCard, Integer idCardType) {
		selfUserId = isPersonalVersion ? selfUserId : null;// 非精英版不使用用户ID条件
		int repeatCount = 0;
		if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			repeatCount = erpFunBuyCustomerMapper.getIdCardRepeat(cityId, compId, selfUserId, custId, idCard, idCardType);
		} else {
			repeatCount = erpFunRentCustomerMapper.getIdCardRepeat(cityId, compId, selfUserId, custId, idCard, idCardType);
		}
		return repeatCount > 0;
	}

	@Transactional
	@Override
	public void createTrack4TransData(ErpCreateTrackInfoParam param) {
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		
		Date dateNow = new Date();
		String dateTimeNow = DateTimeHelper.formatDateTimetoString(new Date());
		ErpFunBuyCustomer buyUpdate = new ErpFunBuyCustomer();
		buyUpdate.setShardCityId(param.getCityId());
		buyUpdate.setBuyCustId(param.getCaseId());
		buyUpdate.setRedFlag(false);
		buyUpdate.setBuyCustSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		buyUpdate.setBuyCustLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		buyUpdate.setUpdateTime(dateNow);
		buyUpdate.setSyncTime(dateNow);
		buyUpdate.setActionTime(dateTimeNow);
		buyUpdate.setTrackTime(dateTimeNow);
		// 移交之后的信息
		buyUpdate.setUserId(createAuditUser.getUserId());
		buyUpdate.setArchiveId(createAuditUser.getArchiveId());
		buyUpdate.setAreaId(createAuditUser.getAreaId());
		buyUpdate.setRegId(createAuditUser.getRegId());
		buyUpdate.setDeptId(createAuditUser.getDeptId());
		buyUpdate.setGrId(createAuditUser.getGrId());
		boolean sysRunModelIsPrivate = erpSysParaService.getSysRunModelIsPrivate(param.getCaseType(), param.getCityId(), param.getCompId());
		if (sysRunModelIsPrivate) {
			buyUpdate.setPrivateTime(dateTimeNow);
			buyUpdate.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		} else {
			buyUpdate.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}
		boolean isUserRight = adminFunArchiveService.isUserRight(createAuditUser.getArchiveId());
		if (!isUserRight) {
			buyUpdate.setCityShareFlag((byte) 0);
		}
		// 任务失效
		erpFunTaskService.cancelAuditTaskForWriteoff(param.getCityId(), param.getCompId(), param.getCaseId(),
				param.getCaseType(), param.getTrackType());
		// 更新数据
		erpFunBuyCustomerMapper.updateByPrimaryKeySelective(buyUpdate);
		// 更新电话表所属人
		erpFunPhoneMapper.updateBelongUser(param.getCityId(), param.getCaseId(), param.getCaseType(), createAuditUser);
		// 修改城市大工盘数据
		ErpCityshareHouse shareHouseUpdate = new ErpCityshareHouse();
		shareHouseUpdate.setShardCityId(param.getCityId());
		shareHouseUpdate.setUserId(createAuditUser.getUserId());
		shareHouseUpdate.setArchiveId(createAuditUser.getArchiveId());
		shareHouseUpdate.setDeptId(createAuditUser.getDeptId());
		shareHouseUpdate.setCaseId(param.getCaseId());
		shareHouseUpdate.setCaseType(Const.DIC_CASE_TYPE_BUY_CUST.byteValue());
		erpCityshareHouseMapper.transDataByCaseId(param.getCityId(), shareHouseUpdate);
		// 修改跟进
//		erpFunTrackMapper.updateTrackByCaseId(param.getCityId(), Const.DIC_CASE_TYPE_BUY_CUST, createAuditUser);
	}

	/**
	* @author 邓永洪
	* @since 2018/4/23
	* @tag 求购客源移交
	*/
	@Transactional
	@Override
	public void dataTranslate(Integer cityId, ErpFunBuyCustomer updateModel, ErpFunUsers acceptUser,
			List<Integer> caseIds, String[] caseNos, DataTranslateParam param) {
		Integer compId = param.getCompId();
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer srcDeptId = param.getSrcDeptId();// 来源DEPT_ID
		Integer caseType = Const.DIC_CASE_TYPE_BUY_CUST;
		if (acceptUser != null) {
			boolean userRightFlag = adminFunArchiveService.isUserRight(acceptUser.getArchiveId());
			if (!userRightFlag) {
				updateModel.setCooperateFlag(0);
			}
		}
		// 服务器端验证可能已经被转为抢盘或者公盘的数据
		String tmpUserId = null;
		Integer plateType = null;
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			tmpUserId = srcUserId;
		} else if ("public".equalsIgnoreCase(srcUserId)) {
			plateType = Const.DIC_PLATE_TYPE_PUBLIC;
		} else if ("share".equalsIgnoreCase(srcUserId)) {
			plateType = Const.DIC_PLATE_TYPE_SHARE;
		}
		int casePOCount = erpFunBuyCustomerMapper.countFunBuyCustomer(cityId, param.getCompId(), param.getSrcDeptId(),
				tmpUserId, plateType, caseIds);
		// 实际转抢盘数据过程中数量不一致，则按照查询出来的实际数据进行操作，因为前端页面用户看到的抢盘数据可能已经被他人转为私盘了，所以必须做后端验证，
		if (casePOCount == 0 || casePOCount != caseIds.size()) {
			throw new BusinessException("数据错误，请重新查询后再进行移交！");
		}
		// STEP1 写跟进
		erpFunTrackService.createTrackForTransData(cityId, acceptUser, caseType, caseIds, caseNos,
				updateModel.getPlateType(), param);
		// STEP 2. 处理相关提醒任务
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			// 移交原始人不是公盘或抢盘,移交目标是经纪人时才更新提醒任务
			erpFunTaskService.updateTaskForTransData(acceptUser, caseType, param, caseIds);
		}
		// STEP 3. 写提醒任务
		if (acceptUser != null) {// 当移交目标是经纪人时才写提醒任务,并且只写一条
			erpFunTaskService.createTaskForTransData(cityId, caseIds, acceptUser, caseNos, caseType, caseIds.size(), param);
		}
		// STEP 4. 进行数据移交
		ErpFunBuyCustomerExample funBuyCustomerExample = new ErpFunBuyCustomerExample();
		funBuyCustomerExample.setShardCityId(cityId);
		ErpFunBuyCustomerExample.Criteria criteria = funBuyCustomerExample.createCriteria();
		criteria.andCompIdEqualTo(compId);
		criteria.andDeptIdEqualTo(srcDeptId);
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			criteria.andUserIdEqualTo(StringUtil.parseInteger(srcUserId));
		} else if ("public".equals(srcUserId)) {
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		} else if ("share".equals(srcUserId)) {
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}
		// 服务器端验证可能已经被转为抢盘或者公盘的数据
		criteria.andBuyCustIdIn(caseIds);
		erpFunBuyCustomerMapper.updateByExampleSelective(updateModel, funBuyCustomerExample);
		// STEP 5. 业主电话跟着房源门店走
		ErpFunPhone funPhone = new ErpFunPhone();
		funPhone.setAreaId(updateModel.getAreaId());
		funPhone.setRegId(updateModel.getRegId());
		funPhone.setDeptId(updateModel.getDeptId());
		funPhone.setGrId(updateModel.getGrId());
		funPhone.setUserId(updateModel.getUserId());
		ErpFunPhoneExample erpFunPhoneExample = new ErpFunPhoneExample();
		erpFunPhoneExample.setShardCityId(cityId);
		erpFunPhoneExample.createCriteria().andCompIdEqualTo(compId).andCaseIdIn(caseIds).andCaseTypeEqualTo(caseType);
		erpFunPhoneMapper.updateByExampleSelective(funPhone, erpFunPhoneExample);
		// 写移交记录
		String acceptUserName = "";
		Integer tempSrcUserId = null;
		Integer tempSrcDeptId = null;
		if ("public".equalsIgnoreCase(srcUserId)) {
			acceptUserName = "抢盘";
		} else if ("share".equalsIgnoreCase(srcUserId)) {
			acceptUserName = "公盘";
		} else if (acceptUser != null) {
			tempSrcUserId = acceptUser.getUserId();
			acceptUserName = acceptUser.getUserName();
			tempSrcDeptId = acceptUser.getDeptId();
		}
		String content = "将" + caseIds.size() + "条数据移交给 " + acceptUserName;
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.TRANS_BUY_DATA, tempSrcUserId, tempSrcDeptId, content,
				null, null, cityId, compId, param.getDeptId(), param.getCurrentUserId());
	}

	/**
	 * @tag 合同税费修改客户电话更新客源数据
	 * @author 邓永洪
	 * @since 2018/6/6
	 */
	@Transactional
	@Override
	public void updateCustomerSourceInfoByDealTaxes(UpdateOrInsertDealTaxesParam param, ErpFunBuyCustomer updateModel, String oldCellphone, String newCellPhone) {
		Integer cityId=param.getCityId();
//		ErpFunBuyCustomer oldCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, updateModel.getBuyCustId());
		Integer	caseType = Const.DIC_CASE_TYPE_BUY_CUST;
		Integer	caseId =updateModel.getBuyCustId();
		String	caseNo = updateModel.getBuyCustNo();
		ErpFunBuyCustomer updateBuyCustomer = new ErpFunBuyCustomer();
		updateBuyCustomer.setUpdateTime(new Date());
		updateBuyCustomer.setTrackTime(getTimeNow());
		updateBuyCustomer.setSyncTime(new Date());
		updateBuyCustomer.setShardCityId(cityId);
		updateBuyCustomer.setBuyCustId(updateModel.getBuyCustId());
//		updateModel.setUpdateTime(new Date());
//		updateModel.setTrackTime(getTimeNow());
//		updateModel.setSyncTime(new Date());
//		updateModel.setShardCityId(cityId);
		erpFunBuyCustomerMapper.updateByPrimaryKeySelective(updateBuyCustomer);
//		String cellPhone = updateModel.getCellPhone();
		String newPhoneValue = "";
		String newValue = "";
		String oldPhoneValue = "";
		String oldValue = "";

		// 新的需要修改的号码
		String[] newPhones = StringHelper.split(newCellPhone, "&&&");
		for (int p = 0; p < newPhones.length; p++) {
			String[] phoneValues = StringHelper.split(newPhones[p], "|||");
			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
			newPhoneValue += phoneValues[0] + ":" + phoneValues[1] + " ";
		}
		// 以前的老的号码
		String[] oldCellphones = StringHelper.split(oldCellphone, "&&&");
		for (int p = 0; p < oldCellphones.length; p++) {
			String[] phoneValues = StringHelper.split(oldCellphones[p], "|||");
			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
			oldPhoneValue += phoneValues[0] + ":" + phoneValues[1] + " ";
		}

		newValue = newPhoneValue.trim();
		oldValue = oldPhoneValue.trim();

		if (StringUtils.isNotBlank(newValue)) {
			String[] phones = StringHelper.split(newValue, " ");
			String[] beforePhones = StringHelper.split(oldValue, " ");
			String[] beforePhoneValues = StringHelper.split(beforePhones[0], ":");
			String beforePhone = EnCodeHelper.encode(beforePhoneValues[1]);

			// 如果本次提交的电话与以前的不一致，那么先删除原先的房东联系方式然后再次添加。
//			ErpFunPhoneExample phoneExample=new ErpFunPhoneExample();
//			phoneExample.setShardCityId(cityId);
//			phoneExample.createCriteria().andCompIdEqualTo(param.getCompId()).andCityIdEqualTo(cityId).andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType);
//			erpFunPhoneMapper.deleteByExample(phoneExample);

			if (StringUtils.isNotBlank(beforePhone)) {
				for (String phoneValue : phones) {
					ErpFunPhoneExample phoneExample = new ErpFunPhoneExample();
					phoneExample.setShardCityId(cityId);
					phoneExample.createCriteria().andCompIdEqualTo(param.getCompId()).andCityIdEqualTo(cityId)
							.andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType).andPhoneEqualTo(beforePhone);

					String[] phoneValues = StringHelper.split(phoneValue, ":");
					ErpFunPhone phone = new ErpFunPhone();
					phone.setPhone(EnCodeHelper.encode(phoneValues[1]));
//					phone.setCaseId(caseId);
//					phone.setCaseType(caseType);
//					phone.setAreaId(updateModel.getAreaId());
//					phone.setRegId(updateModel.getRegId());
//					phone.setDeptId(updateModel.getDeptId());
//					phone.setUserId(updateModel.getUserId());
//					phone.setGrId(updateModel.getGrId());
//					phone.setCityId(cityId);
//					phone.setCompId(param.getCompId());
//					phone.setCreationTime(DateUtil.StringToDate(updateModel.getCreationTime()));
//					phone.setShardCityId(cityId);
//					erpFunPhoneMapper.insertSelective(phone);
					erpFunPhoneMapper.updateByExampleSelective(phone, phoneExample);
				}
			}
		}
		ErpFunTrack trackInsertModel = new ErpFunTrack();
		trackInsertModel.setCaseId(caseId);
		trackInsertModel.setCaseType(caseType.byteValue());
		trackInsertModel.setTrackType(Const.DIC_TRACK_TYPE_EDIT);
		trackInsertModel.setTrackClassic(Const.DIC_TRACKCLASSIC_7);
		trackInsertModel.setTrackContent(param.getCurrUserName()+ " 今日在合同税费中修改了客户电话。\n跟进内容：电话:" +
				SyncUtil.decodePhoneForHouseDetailOfFirst(oldCellphone, false) + " >> " +
				SyncUtil.decodePhoneForHouseDetailOfFirst(newCellPhone, false));
		trackInsertModel.setCaseNo(caseNo);
		trackInsertModel.setCaseStatus(Const.DIC_HOUSE_STATUS_AVAILABLE);
		trackInsertModel.setTrackWarm(false);
		trackInsertModel.setCreatorUid(param.getUserId());
		trackInsertModel.setCaseUserId(updateModel.getUserId());
		trackInsertModel.setCaseDeptId(updateModel.getDeptId());
		trackInsertModel.setDeptId(param.getDeptId());
		trackInsertModel.setShardCityId(cityId);
		erpFunTrackMapper.insertSelective(trackInsertModel);
	}
}
