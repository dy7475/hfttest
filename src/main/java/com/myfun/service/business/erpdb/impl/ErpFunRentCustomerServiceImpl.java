package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunRentCustomerDto;
import com.myfun.repository.erpdb.param.ErpFunRentCustomerParam;
import com.myfun.service.business.admindb.AdminFunCityService;
import com.myfun.service.business.admindb.AdminMobileKeyService;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpCityshareHouse;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomerExample;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.erpdb.po.ErpFunPhone;
import com.myfun.repository.erpdb.po.ErpFunPhoneExample;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunRentCustomerExample;
import com.myfun.repository.erpdb.po.ErpFunRentCustomerKey;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomerExample.Criteria;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunArchiveService;
import com.myfun.service.business.report.ReportFunSaleMinService;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

@Service
public class ErpFunRentCustomerServiceImpl extends AbstractService<ErpFunRentCustomer, ErpFunRentCustomerKey>
		implements ErpFunRentCustomerService {
	@Autowired ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired private ErpSysParaService erpSysParaService;
	@Autowired private ErpFunTaskService erpFunTaskService;
	@Autowired private AdminFunArchiveService adminFunArchiveService;
	@Autowired private ErpFunPhoneMapper erpFunPhoneMapper;
	@Autowired private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ReportFunSaleMinService reportFunSaleMinService;
	@Autowired private ErpFunTrackService erpFunTrackService;
	@Autowired private ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired private ErpCityshareHouseMapper erpCityshareHouseMapper;
	@Autowired private ErpFunTrackMapper erpFunTrackMapper;
	@Autowired private AdminFunCityMapper adminFunCityMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Autowired private ErpFunPolicyControlService erpFunPolicyControlService;
	@Autowired private ErpYouBuildDetailViewService erpYouBuildDetailViewService;
	@Autowired private ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired private AdminMobileKeyService adminMobileKeyService;


	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunRentCustomerMapper;

	}

	@Override
	public ErpFunRentCustomer getFunRentCustomer(Integer cityId, Integer rentCustId) {
		ErpFunRentCustomerKey key = new ErpFunRentCustomerKey();
		key.setShardCityId(cityId);
		key.setRentCustId(rentCustId);
		return erpFunRentCustomerMapper.selectByPrimaryKey(key);
	}

	@Override
	public boolean countShareHouse(Integer cityId,Integer compId) {
		Integer count = erpFunRentCustomerMapper.countShareHouse(cityId,compId);
		return count>0;
	}

	@Override
	public void updateHouseRunModelForPrivate(Integer cityId, Integer compId) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId);
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		updateModel.setTrackTime(new Date());
		updateModel.setSpecialTime(new Date());
		updateModel.setScheduleTime(new Date());
		updateModel.setSecrecyTime(new Date());
		updateModel.setCommendTime(new Date());
		updateModel.setActionTime(new Date());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHousePlateTypeByRunModel(Integer cityId, Integer compId) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId);
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setRedFlag(false);
		updateModel.setOrangeFlag(false);
		updateModel.setPublicCount(0);
		updateModel.setFromPublic(false);
		updateModel.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseActionTimeBySysPara(Integer cityId, Integer compId) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId).andPublicCountEqualTo(0).andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setActionTime(new Date());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseActionTimeBySysParaByPartner(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		com.myfun.repository.erpdb.po.ErpFunRentCustomerExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if (CollectionUtils.isNotEmpty(orgIds)) {
			criteria.andOrganizationIdIn(orgIds);
		}
		criteria.andPublicCountEqualTo(0);
		criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setActionTime(new Date());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseTrackTime(Integer cityId, Integer compId, String string) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		boolean fromPublic = "0".equals(string)?false:true;
		example.createCriteria().andCompIdEqualTo(compId).andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue()).andFromPublicEqualTo(fromPublic);
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setTrackTime(new Date());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		boolean fromPublic = !"0".equals(string);
		com.myfun.repository.erpdb.po.ErpFunRentCustomerExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if (CollectionUtils.isNotEmpty(orgIds)) {
			criteria.andOrganizationIdIn(orgIds);
		}
		criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		criteria.andFromPublicEqualTo(fromPublic);
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setTrackTime(new Date());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHousePublicTime(Integer cityId, Integer compId) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId).andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setPublicTime(new Date());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateHousePublicTimeByOrg(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		com.myfun.repository.erpdb.po.ErpFunRentCustomerExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if (CollectionUtils.isNotEmpty(orgIds)) {
			criteria.andOrganizationIdIn(orgIds);
		}
		criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setPublicTime(new Date());
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateCustomerSourceNotCooperate(Integer cityId, Integer compId) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		example.createCriteria().andCompIdEqualTo(compId).andCityShareFlagGreaterThan((byte)0);
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setCityShareFlag((byte)0);
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Override
	public void updateCustomerSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds) {
		ErpFunRentCustomerExample example = new ErpFunRentCustomerExample();
		example.createCriteria()
				.andCompIdEqualTo(compId)
				.andOrganizationIdIn(orgIds)
				.andCityShareFlagGreaterThan((byte) 0);
		example.setShardCityId(cityId);
		ErpFunRentCustomer updateModel = new ErpFunRentCustomer();
		updateModel.setCityShareFlag((byte) 0);
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, example);
	}

	@Transactional
	@Override
	public void createTrack4TransData(ErpCreateTrackInfoParam param) {
		ErpFunUsers createAuditUser = param.getCreateAuditUser();

		Date dateNow = new Date();
		ErpFunRentCustomer rentUpdate = new ErpFunRentCustomer();
		rentUpdate.setShardCityId(param.getCityId());
		rentUpdate.setRentCustId(param.getCaseId());
		rentUpdate.setRedFlag(false);
		rentUpdate.setRentCustSource(Const.DIC_HOUSE_SOURCE_ALLOT);
		rentUpdate.setRentCustLevel(Const.DIC_HOUSE_LEVEL_COMMON);
		rentUpdate.setUpdateTime(dateNow);
		rentUpdate.setSyncTime(dateNow);
		rentUpdate.setActionTime(dateNow);
		rentUpdate.setTrackTime(dateNow);
		// 移交之后的信息
		rentUpdate.setUserId(createAuditUser.getUserId());
		rentUpdate.setArchiveId(createAuditUser.getArchiveId());
		rentUpdate.setAreaId(createAuditUser.getAreaId());
		rentUpdate.setRegId(createAuditUser.getRegId());
		rentUpdate.setDeptId(createAuditUser.getDeptId());
		rentUpdate.setGrId(createAuditUser.getGrId());
		boolean sysRunModelIsPrivate = erpSysParaService.getSysRunModelIsPrivate(param.getCaseType(), param.getCityId(), param.getCompId());
		if (sysRunModelIsPrivate) {
			rentUpdate.setPrivateTime(dateNow);
			rentUpdate.setPlateType(Const.DIC_PLATE_TYPE_PRIVATE.byteValue());
		} else {
			rentUpdate.setPlateType(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}
		boolean isUserRight = adminFunArchiveService.isUserRight(createAuditUser.getArchiveId());
		if (!isUserRight) {
			rentUpdate.setCityShareFlag((byte) 0);
		}
		// 任务失效
		erpFunTaskService.cancelAuditTaskForWriteoff(param.getCityId(), param.getCompId(), param.getCaseId(),
				param.getCaseType(), param.getTrackType());
		// 更新数据
		erpFunRentCustomerMapper.updateByPrimaryKeySelective(rentUpdate);
		// 更新电话表所属人
		erpFunPhoneMapper.updateBelongUser(param.getCityId(), param.getCaseId(), param.getCaseType(), createAuditUser);
		// 修改城市大工盘数据
		ErpCityshareHouse shareHouseUpdate = new ErpCityshareHouse();
		shareHouseUpdate.setShardCityId(param.getCityId());
		shareHouseUpdate.setUserId(createAuditUser.getUserId());
		shareHouseUpdate.setArchiveId(createAuditUser.getArchiveId());
		shareHouseUpdate.setDeptId(createAuditUser.getDeptId());
		shareHouseUpdate.setCaseId(param.getCaseId());
		shareHouseUpdate.setCaseType(Const.DIC_CASE_TYPE_RENT_CUST.byteValue());
		erpCityshareHouseMapper.transDataByCaseId(param.getCityId(), shareHouseUpdate);
		// 修改跟进
//		erpFunTrackMapper.updateTrackByCaseId(param.getCityId(), Const.DIC_CASE_TYPE_RENT_CUST, createAuditUser);
	}

	/**
	 * @tag 求租客户数据移交
	 * @author 邓永洪
	 * @since 2018/4/27
	 */
	@Transactional
	@Override
	public void dataTranslate(ErpFunRentCustomer updateModel, ErpFunUsers acceptUser, List<Integer> caseIds, String[] caseNos, DataTranslateParam param) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String srcUserId = param.getSrcUserId();// 来源USER_ID
		Integer srcDeptId = param.getSrcDeptId();// 来源DEPT_ID
		Integer caseType = Const.DIC_CASE_TYPE_RENT_CUST;
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
		int casePOCount = erpFunRentCustomerMapper.countFunRentCustomer(cityId, param.getCompId(), param.getSrcDeptId(), tmpUserId, plateType, caseIds);
		// 实际转抢盘数据过程中数量不一致，则按照查询出来的实际数据进行操作，因为前端页面用户看到的抢盘数据可能已经被他人转为私盘了，所以必须做后端验证，
		if (casePOCount == 0 || casePOCount != caseIds.size()) {
			throw new BusinessException("数据错误，请重新查询后再进行移交！");
		}
		// STEP 1. 写跟进
		erpFunTrackService.createTrackForTransData(cityId, acceptUser, caseType, caseIds, caseNos,
				updateModel.getPlateType(), param);
		// STEP 2. 处理相关提醒任务
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			// 移交原始人不是公盘或抢盘,移交目标是经纪人时才更新提醒任务
			erpFunTaskService.updateTaskForTransData(acceptUser, caseType, param, caseIds);
		}
		// STEP 3. 写提醒任务
		if (acceptUser != null) {
			// 当移交目标是经纪人时才写提醒任务,并且只写一条
			erpFunTaskService.createTaskForTransData(cityId, caseIds, acceptUser, caseNos, caseType, caseIds.size(), param);
		}
		// STEP 4. 进行数据移交
		ErpFunRentCustomerExample updateRentCustomerExample = new ErpFunRentCustomerExample();
		updateRentCustomerExample.setShardCityId(cityId);
		ErpFunRentCustomerExample.Criteria criteria = updateRentCustomerExample.createCriteria();
		criteria.andCompIdEqualTo(compId);
		criteria.andDeptIdEqualTo(srcDeptId);
		if (!"public".equalsIgnoreCase(srcUserId) && !"share".equalsIgnoreCase(srcUserId)) {
			criteria.andUserIdEqualTo(StringUtil.parseInteger(srcUserId));
		} else if ("public".equalsIgnoreCase(srcUserId)) {
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		} else if ("share".equalsIgnoreCase(srcUserId)) {
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		}
		// 服务器端验证可能已经被转为抢盘或者公盘的数据
		criteria.andRentCustIdIn(caseIds);
		erpFunRentCustomerMapper.updateByExampleSelective(updateModel, updateRentCustomerExample);
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
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.TRANS_RENT_DATA, tempSrcUserId, tempSrcDeptId, content,
				null, null, cityId, compId, param.getDeptId(), param.getCurrentUserId());
	}

	@Transactional
	@Override
	public String[] createHouseOrCustInfo(ErpFunRentCustomerParam param,boolean isPersonalVersion,Integer grId) {
		param.setCreationTime(new Date());
		param.setUpdateTime(new Date());
		param.setSyncTime(new Date());
		param.setTrackTime(new Date());
		param.setActionTime(new Date());
		param.setInfoType((byte)0);
		param.setShareFlag(false);
		param.setFriendHouse((byte)0);
		param.setComplaintFlag(false);
		param.setFromPublic(false);
		param.setRedFlag(false);
		param.setOrangeFlag(false);
		param.setPublicCount(0);
		String no = this.generateCustNo(param.getCityId());
		Integer phoneCaseType =Const.DIC_CASE_TYPE_RENT_CUST;
		param.setRentCustNo(no);
		String ownerName = param.getRentCustName();
		Boolean ownerSex = param.getRentCustSex();
		String cellPhone=param.getCellPhone();//		String jointCellPhone = getString("JOINT_CELL_PHONE");
		String jointCellPhone =param.getJointCellPhone();


		// 有限私判 公盘无id,公房 ，房有id,公客 客有id,全公盘制 有id
		if (!isPersonalVersion) {
			boolean isPublidModel = this.getSysRunModelIsPublic(param.getCityId(),param.getCompId(),phoneCaseType);
			Integer plateType = StringUtil.parseInteger(param.getPlateType());
			if (plateType != null && !plateType.equals(Const.DIC_PLATE_TYPE_SHARE) && !plateType.equals(Const.DIC_PLATE_TYPE_PUBLIC) || isPublidModel){
				param.setArchiveId(param.getCreateArchiveId());
				param.setUserId(param.getCreatorUid());
				param.setGrId(grId);
			} else if ((plateType.equals(Const.DIC_PLATE_TYPE_SHARE) || plateType.equals(Const.DIC_PLATE_TYPE_PUBLIC)) && !isPublidModel) {
				// 私盘制下 登记公盘和抢盘 不需要设置GR_ID
				param.setGrId(Const.DIC_DEFAULT_GROUP_ID);
				param.setPrivateUserId(param.getCreateArchiveId());// 登记抢盘数据时，把抢盘USER_ID设置到当前用户的名下
			}
			if (plateType != null && plateType.equals(Const.DIC_PLATE_TYPE_PUBLIC)) {
				param.setPublicTime(new Date());
				param.setPublicCount(1);
			}
		} else {
			param.setArchiveId(param.getCreateArchiveId());
			param.setUserId(param.getCreatorUid());
		}
		ErpFunRentCustomer erpFunRentCustomer=param;
		erpFunRentCustomerMapper.insertSelective(erpFunRentCustomer);

		// 创建跳抢剩余天数
		erpFunPolicyControlService.insertFunPolicyContro(erpFunRentCustomer.getRentCustId(), erpFunRentCustomer.getCompId(),erpFunRentCustomer.getCityId(),phoneCaseType,param.getCreatorUid());

		// 这是从好房优家楼盘资料来的数据
		if ("1".equals(param.getFromYoujiaBuild())) {
			erpYouBuildDetailViewService.updateYouJia4TransferSystem(param, phoneCaseType, no);
		}

		// 保存电话明文 主要用于列表页查询，避免like匹配查询
		List<ErpFunPhone> createPhones = new ArrayList<>();
		this.createPhones(createPhones,cellPhone,phoneCaseType,param);//业主电话
		this.createPhones(createPhones,jointCellPhone, phoneCaseType,param);//共有人电话
		if (createPhones.size() > 0) {
			for (ErpFunPhone erpFunPhone:createPhones){
				erpFunPhoneMapper.insertSelective(erpFunPhone);
			}
		}

		erpFunTrackService.writeTrackByCreateHouseInfo(param);
        // 搜搜转入
//		if ("1".equals(fromSoso)) {
//			searchSosoViewService.sosoConvertHouseSouce();
//			// 楼盘规则保存 从楼盘资料中转入
//		} else if ("1".equals(fromBuildRule)) {
//			if (!CommonUtil.isnull(getString("ENTITY_ID"))) {
//				if (tableName.contains("SALE")) {
//					funBuildRuleService.updateSaleIdByCreateSale(id);
//				} else if (tableName.contains("LEASE")) {
//					funBuildRuleService.updateLeaseIdByCreateLease(id);
//				}
//			}
//			// 该条信息更新来至发发同步数据 陈文超写
//		} else if ("1".equals(fromFafa)) {
//			if (!CommonUtil.isnull(deleteId) && !CommonUtil.isnull(sId)) {
//				if (tableName.contains("SALE")) {
//					fafaWebHouseService.updateWebHouseLocalId(sId, Constants_DIC.DIC_CASE_TYPE_SALE_FUN, deleteId, id, "0", Constants_DIC.DIC_FAFA_HOUSE_SOURCE_WAY_3);
//				} else if (tableName.contains("LEASE")) {
//					fafaWebHouseService.updateWebHouseLocalId(sId, Constants_DIC.DIC_CASE_TYPE_LEASE_FUN, deleteId, id, "0", Constants_DIC.DIC_FAFA_HOUSE_SOURCE_WAY_3);
//				}
//			}
//		}
		// 优家门店创建房客源时自动发送短信
		//adminMobileKeyService.sendSmsForYouJiaCreateHouseCust(param.getCellPhone(), ownerName, ownerSex);


		return new String[0];
	}

	/**
	 * 保存电话
	 * @param createPhones
	 * @param cellPhone
	 * @param caseType
	 */
	private void createPhones(List<ErpFunPhone> createPhones, String cellPhone, Integer caseType,ErpFunRentCustomerParam param) {
		if (cellPhone==null) {
			return;
		}
		Integer caseId=param.getRentCustId();
		Integer areaId=param.getAreaId();
		Integer regId=param.getRegId();
		Integer deptId=param.getDeptId();
		Integer grId=param.getGrId();
		Integer userId=param.getUserId();
		Integer compId=param.getCompId();
		Integer cityId=param.getCityId();
		String[] phones = StringHelper.split(cellPhone, " ");
		for (String phoneValue : phones) {
			String[] phoneValues = StringHelper.split(phoneValue, ":");
			if (phoneValues.length > 1) {
				ErpFunPhone phonePo = new ErpFunPhone();
				phonePo.setPhone(EnCodeHelper.encode(phoneValues[1]));
				phonePo.setCaseId(caseId);
				phonePo.setCaseType(caseType);
				phonePo.setAreaId(areaId);
				phonePo.setRegId(regId);
				phonePo.setCityId(cityId);
				phonePo.setDeptId(deptId);
				phonePo.setUserId(userId);// 精英版中用于判断个人房源是否有重复
				phonePo.setGrId(grId);
				phonePo.setCompId(compId);
				phonePo.setCreationTime(new Date());
				createPhones.add(phonePo);
			}
		}
	}

	/**
	 * 
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */	
	private boolean getSysRunModelIsPublic(Integer cityId,Integer compId,Integer caseType) {
		String sysRunModel = erpSysParaMapper.getParamValue(cityId,compId,"SYSTEM_RUN_MODEL");
		//是否是公盘模式
		boolean isPublicModel = ((caseType.equals(Const.DIC_CASE_TYPE_SALE_FUN) || caseType.equals(Const.DIC_CASE_TYPE_LEASE_FUN))
				&& sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBFUN))//仅公房制
				|| ((caseType.equals(Const.DIC_CASE_TYPE_BUY_CUST) || caseType.equals(Const.DIC_CASE_TYPE_RENT_CUST))
				&& sysRunModel.equals(Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBCUST))//仅公客制
				|| Const.DIC_SYSRUNMODEL_DEPT_TYPE_PUBLIC.equals(sysRunModel);//全公盘制
		return isPublicModel;
	}

	/**
	 * 生成客源编号
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/10
	 */
	private String generateCustNo(Integer cityId) {
		AdminFunCity adminFunCity = adminFunCityMapper.getDataByCityId(cityId);
		Integer compId=null;
		if (adminFunCity!=null){
			compId=adminFunCity.getCompId();
		}
		List<ErpFunRentCustomer> erpFunRentCustomerDtoList=erpFunRentCustomerMapper.getFunRentCustomerByCompNo(cityId,compId);
		String no=erpFunRentCustomerDtoList.size() > 0 ? erpFunRentCustomerDtoList.get(0).getRentCustNo() : null;
		return no;
	}

	/**
	 * @tag //判断是否共享到城市公盘
	 * @author 邓永洪
	 * @since 2018/4/27
	 */
	private boolean getIsSharedCityPlate(DataTranslateParam param, String caseIds) {
		ErpFunRentCustomerExample funRentCustomerExample = new ErpFunRentCustomerExample();
		funRentCustomerExample.setShardCityId(param.getCityId());
		ErpFunRentCustomerExample.Criteria criteria = funRentCustomerExample.createCriteria();
		criteria.andRentCustIdIn(StringUtil.toIntList(caseIds,",")).andCompIdEqualTo(param.getCompId()).andYouShareFlagEqualTo((byte) 1);
		List<ErpFunRentCustomer> funRentCustomers = erpFunRentCustomerMapper.selectByExample(funRentCustomerExample);
		return funRentCustomers .size()==0;
	}

	/**
	 * @tag //判断是否已经分享到城市公盘
	 * @author 邓永洪
	 * @since 2018/4/27
	 */
	private boolean getIsSharedCityPlate(DataTranslateParam param) {
		String srcUserId = param.getSrcUserId();
		ErpFunRentCustomerExample funRentCustomerExample = new ErpFunRentCustomerExample();
		funRentCustomerExample.setShardCityId(param.getCityId());
		ErpFunRentCustomerExample.Criteria criteria = funRentCustomerExample.createCriteria();
		criteria.andCompIdEqualTo(param.getCompId()).andDeptIdEqualTo(param.getDeptId());
		if (!CommonUtil.isnull(srcUserId) && !"share".equalsIgnoreCase(srcUserId) && !"public".equalsIgnoreCase(srcUserId)) {
			criteria.andUserIdEqualTo(Integer.valueOf(srcUserId));
		} else if ("share".equalsIgnoreCase(srcUserId)) { // 公盘
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_SHARE.byteValue());
		} else if ("public".equalsIgnoreCase(srcUserId)) { // 抢盘
			criteria.andPlateTypeEqualTo(Const.DIC_PLATE_TYPE_PUBLIC.byteValue());
		}
		criteria.andYouShareFlagEqualTo((byte) 1);
		List<ErpFunRentCustomer> funRentCustomers = erpFunRentCustomerMapper.selectByExample(funRentCustomerExample);
		return funRentCustomers.size()==0;
	}
}

