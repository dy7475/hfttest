package com.myfun.service.business.erpdb.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.businesstools.builddic.param.InsertComBuildParam;
import com.myfun.erpWeb.businesstools.builddic.vo.BuildingInfoInMobileVo;
import com.myfun.erpWeb.businesstools.builddic.vo.BuildingListInMobileVo;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.AdminErpBuildingInfoTmpMapper;
import com.myfun.repository.admindb.po.AdminErpBuildingInfoTmp;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.param.ErpBuildingInfoParam;
import com.myfun.repository.erpdb.param.QueryBuildingListParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBuildInfoService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateBuildInfoParam;
import com.myfun.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpBuildInfoServiceImpl extends AbstractService<ErpBuildingInfo, ErpBuildingInfo> implements ErpBuildInfoService {
	@Autowired
	private ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired
	private ErpBuildingPhotoMapper buildingPhotoMapper;
	@Autowired
	private ErpFunSectionMapper erpFunSectionMapper;
	@Autowired
	private ErpFunRegMapper erpFunRegMapper;
	@Autowired 
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private AdminErpBuildingInfoTmpMapper adminErpBuildingInfoTmpMapper;
	@Autowired
	private ErpBuildRoadsRelationMapper erpBuildRoadsRelationMapper;
	@Resource
	private ErpBuildingManagerMapper erpBuildingManagerMapper;
	@Resource
	private ErpBuildingMarketingControlMinMapper erpBuildingMarketingControlMinMapper;
	@Resource
	private ErpFunUsersMapper erpFunUsersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpBuildingInfoMapper;
	}

	@Override
	public PageInfo<ErpBuildingInfo> getModelList(ErpBuildingInfoParam buildingInfoParam) {
		PageHelper.startPage(buildingInfoParam.getPageNum(), buildingInfoParam.getPageSize(), true);
		List<ErpBuildingInfo> pages = erpBuildingInfoMapper.getModelList(buildingInfoParam);
		PageInfo<ErpBuildingInfo> pageInfo = new PageInfo<>(pages);
		return pageInfo;
	}
	@Override
	public int checkBuildName(ErpBuildingInfo buildingInfo) {
		return erpBuildingInfoMapper.checkBuildName(buildingInfo);
	}
	
	/**
	 * 更新房源
	 * 如果楼盘核心字段被修改，同步三库中的该楼盘的所有房源相关信息
	 * @param buildingInfo  buildId
	 * @param buildingInfo  cityId
	 */
	private void updateFunByBuild(ErpBuildingInfo buildingInfo) {
		ErpFunSale funSale = new ErpFunSale();
		ErpFunLease funLease = new ErpFunLease();
		funSale.setSaleRound(buildingInfo.getBuildRound());
		funLease.setLeaseRound(buildingInfo.getBuildRound());
		funSale.setSaleReg(buildingInfo.getBuildRegion());
		funLease.setLeaseReg(buildingInfo.getBuildRegion());
		funSale.setRegionName(buildingInfo.getBuildName());
		funLease.setRegionName(buildingInfo.getBuildName());
		funSale.setBuildCode(buildingInfo.getBuildCode());
		funLease.setBuildCode(buildingInfo.getBuildCode());
		funSale.setBuildName(buildingInfo.getBuildName());
		funLease.setBuildName(buildingInfo.getBuildName());
		funSale.setSectionId(buildingInfo.getSectionId());
		funLease.setSectionId(buildingInfo.getSectionId());
		//查询sextion
		ErpFunSection key = new ErpFunSection();
		key.setCityId(buildingInfo.getCityId());
		key.setSectionId(buildingInfo.getSectionId());
		ErpFunSection funSection = erpFunSectionMapper.selectByPrimaryKey(key);
		
		funSale.setSectionName(funSection.getSectionName());
		funLease.setSectionName(funSection.getSectionName());
		funSale.setCityId(StringUtil.parseInteger(String.valueOf(buildingInfo.getCityId())));
		funSale.setShardCityId(StringUtil.parseInteger(String.valueOf(buildingInfo.getCityId())));
		funLease.setCityId(StringUtil.parseInteger(String.valueOf(buildingInfo.getCityId())));
		funLease.setShardCityId(StringUtil.parseInteger(String.valueOf(buildingInfo.getCityId())));
		//修改数据
		erpFunSaleMapper.updateByPrimaryKeySelective(funSale);
		erpFunLeaseMapper.updateByPrimaryKeySelective(funLease);
		
	}
	
	@Transactional
	@Override
	public Integer moveBuildToCity(ErpBuildingInfo buildingInfo, Short oldCityId) {
		Integer oldBuildId= buildingInfo.getBuildId();
		//查询楼盘信息
		ErpBuildingInfo obj = new ErpBuildingInfo();
		obj.setCityId(oldCityId.shortValue());
		obj.setShardCityId(oldCityId.intValue());
		obj.setBuildId(oldBuildId);
		ErpBuildingInfo info = erpBuildingInfoMapper.selectByPrimaryKey(obj);
		//查询楼盘相册信息
		List<ErpBuildingPhoto> photos = buildingPhotoMapper.getRecords(oldCityId, buildingInfo.getBuildId(), "");
		//转移楼盘
		buildingInfo.setBuildPhoto(info.getBuildPhoto());
		buildingInfo.setTypicFlag(info.getTypicFlag());
		buildingInfo.setVertifyFlag((short)0);
		String date = DateUtil.DateToString(new Date(), "yyy-MM-dd HH:mm:ss");
		buildingInfo.setCreateTime(date);
		buildingInfo.setUpdateTime(date);
		buildingInfo.setAddrCount((byte)0);
		buildingInfo.setPhotoExterior(info.getPhotoExterior());
		buildingInfo.setPhotoEffects(info.getPhotoEffects());
		buildingInfo.setPhotoModel(info.getPhotoModel());
		buildingInfo.setPhotoTraffic(info.getPhotoTraffic());
		buildingInfo.setPhotoPlan(info.getPhotoPlan());
		buildingInfo.setPhotoSet(info.getPhotoSet());
		buildingInfo.setPhotoTemplet(info.getPhotoTemplet());
		buildingInfo.setExamPhoto(info.getExamPhoto());
		buildingInfo.setNewFlag(info.getNewFlag());
		if(buildingInfo.getPositionX() != null && !buildingInfo.getPositionX().equals("")) {
			buildingInfo.setPositionFlag((short)1);
		} else {
			buildingInfo.setPositionFlag((short)0);
		}
		
		String examFlag = String.valueOf(buildingInfo.getExamFlag());
		if (!examFlag.equals("")) {
			buildingInfo.setExamFlag(buildingInfo.getExamFlag());
		}
		String buildStatus = String.valueOf(buildingInfo.getBuildStatus());
		if (buildStatus.equals("1") || buildStatus.equals("2")
				|| buildStatus.equals("4")) {
			buildingInfo.setNewFlag((byte)1);
		} else {
			buildingInfo.setNewFlag((byte)0);
		}
		//获取Id
		/*Integer id =  erpBuildingInfoMapper.getId(buildingInfo);
		buildingInfo.setBuildId(id+1);*/
		erpBuildingInfoMapper.insertSelective(buildingInfo);
		 //转移图片
		for(ErpBuildingPhoto photo : photos){
			//获取序列ID
			Integer photoId = buildingPhotoMapper.getId(buildingInfo.getCityId());
			ErpBuildingPhoto record = new ErpBuildingPhoto();
			record.setPhotoId(photoId);
			record.setBuildId(buildingInfo.getBuildId());
			record.setPhotoAddr(photo.getPhotoAddr());
			record.setUploadUser(photo.getUploadUser());
			record.setUploadDate(photo.getUploadDate());
			record.setVertifyFlag(photo.getVertifyFlag());
			record.setRelativeId(photo.getRelativeId());
			record.setIsFirst(photo.getIsFirst());
			record.setPhotoType(photo.getPhotoType());
			record.setCityId(buildingInfo.getCityId());
			record.setShardCityId(StringUtil.parseInteger(String.valueOf(buildingInfo.getCityId())));
			buildingPhotoMapper.insertSelective(record);
		}
		  //删除原有信息
		erpBuildingInfoMapper.deleteByPrimaryKey(obj);
		return buildingPhotoMapper.deleteByBuildId(oldCityId, oldBuildId);
	}
	
	@Override
	public void setFirst(Integer provinceId, Integer userId, String photoids, String photoType, Short cityId,
			Integer buildId, boolean flag) {
		String[] ids = photoids.split(",");
		List<ErpBuildingPhoto> photos = buildingPhotoMapper.getPhotosByids(cityId, buildId, ids);
		for(ErpBuildingPhoto buildingPhoto : photos){
			//更新首图
			ErpBuildingPhoto record = new ErpBuildingPhoto();
			record.setCityId(cityId.shortValue());
			record.setPhotoId(buildingPhoto.getPhotoId());
			record.setShardCityId(cityId.intValue());
			record.setBuildId(buildId);
			record.setIsFirst(flag);
			buildingPhotoMapper.updateByPrimaryKeySelective(record);
		}
		 String docPath = "";//文件物理路径
		 //文件操作
		
	}
	@Override
	public void examinPhoto(Integer provinceId, String photoids, String photoType, Short cityId, Integer buildId) {
		String[] ids = photoids.split(",");
		List<ErpBuildingPhoto> photos = buildingPhotoMapper.getPhotosByids(cityId, buildId, ids);
		for(ErpBuildingPhoto buildingPhoto : photos){
			//更新首图
			ErpBuildingPhoto record = new ErpBuildingPhoto();
			record.setCityId(cityId.shortValue());
			record.setPhotoId(buildingPhoto.getPhotoId());
			record.setShardCityId(cityId.intValue());
			record.setBuildId(buildId);
			record.setVertifyFlag(true);
			buildingPhotoMapper.updateByPrimaryKeySelective(record);
		}
		if(!photoType.equals("3")){	//排除户型图
			ErpBuildingInfo key = new ErpBuildingInfo();
			key.setCityId(cityId.shortValue());
			key.setShardCityId(cityId.intValue());
			key.setBuildId(buildId);
			ErpBuildingInfo obj = erpBuildingInfoMapper.selectByPrimaryKey(key);
			byte num = (byte) (StringUtil.parseByte(String.valueOf(obj.getExamPhoto()))  + StringUtil.parseByte(String.valueOf(ids.length)));
			key.setExamPhoto(num);
			erpBuildingInfoMapper.updateByPrimaryKeySelective(key);
		}
	}
	
	/**
	 * 获取楼盘信息
	 * **/
	@Override
	public List<ErpBuildingInfoDto> getErpBuildingInfo(Short cityId, String buildCode) {
		return erpBuildingInfoMapper.getErpBuildingInfo(cityId, buildCode);
	}

//	@Override
//	public ErpBuildingInfoDto getErpBuildInfoByid(String cityId, String buildId) {
//		ErpBuildingInfo erpBuildingInfo = erpBuildingInfoMapper.getErpBuildInfoByid(cityId, buildId);
//		ErpBuildingInfoDto erpBuildingInfoDto = null;
//		if(erpBuildingInfo!=null){
//			erpBuildingInfoDto = new ErpBuildingInfoDto();
//			org.springframework.beans.BeanUtils.copyProperties(erpBuildingInfo, erpBuildingInfoDto);
//			if(erpBuildingInfo.getSectionId()!=null){
//				ErpFunSection key = new ErpFunSection();
//				key.setShardCityId(Integer.valueOf(cityId));
//				key.setSectionId(erpBuildingInfo.getSectionId());
//				ErpFunSection erpFunSection = erpFunSectionMapper.selectByPrimaryKey(key);
//				if(erpFunSection!=null){
//					erpBuildingInfoDto.setSectionName(erpFunSection.getSectionName());
//				}
//			}
//			if(erpBuildingInfo.getBuildRegion()!=null){
//				ErpFunReg key = new ErpFunReg();
//				key.setShardCityId(Integer.valueOf(cityId));
//				key.setRegId(erpBuildingInfo.getBuildRegion());
//				ErpFunReg erpFunReg = ErpFunRegMapper.selectByPrimaryKey(key);
//				if(erpFunReg!=null){
//					erpBuildingInfoDto.setRegName(erpFunReg.getRegName());
//				}
//			}
//		}
//		return erpBuildingInfoDto;
//	}

	/**
	 * 获取楼盘资料
	 * @author 臧铁
	 * @since 2017年5月31日
	 * @return
	 */
	@Override
	public ErpBuildingInfoDto getErpBuildInfoByid(String cityId,String buildId) {
		ErpBuildingInfoDto erpBuildingInfoDto = erpBuildingInfoMapper.getErpBuildInfoByid(Integer.valueOf(cityId), Integer.valueOf(buildId));
		if (null != erpBuildingInfoDto) {
			ErpFunSection erpFunSection = new ErpFunSection();
			erpFunSection.setShardCityId(Integer.valueOf(cityId));
			erpFunSection.setSectionId(erpBuildingInfoDto.getSectionId());
			erpFunSection.setVertifyFlag((byte)1);
			ErpFunSection funSection = erpFunSectionMapper.selectByPrimaryKey(erpFunSection);
			if (null != funSection) {
				erpBuildingInfoDto.setSectionName(funSection.getSectionName());
			}
			ErpFunReg erpFunReg = new ErpFunReg();
			erpFunReg.setShardCityId(Integer.valueOf(cityId));
			erpFunReg.setRegId(erpBuildingInfoDto.getBuildRegion());
			erpFunReg.setVertifyFlag((byte)1);
			ErpFunReg funReg = erpFunRegMapper.selectByPrimaryKey(erpFunReg);
			if (null != funReg) {
				erpBuildingInfoDto.setRegName(funReg.getRegName());
			}
			ErpBuildRoadsRelation erpBuildRoadsRelation = new ErpBuildRoadsRelation();
			erpBuildRoadsRelation.setShardCityId(Integer.valueOf(cityId));
			erpBuildRoadsRelation.setBuildId(erpBuildingInfoDto.getBuildId());
			List<ErpBuildRoadsRelation> list =  erpBuildRoadsRelationMapper.getListByBuildId(erpBuildRoadsRelation);
			if (list.size() > 0) {
				StringBuilder sbTemp = new StringBuilder();
				for (ErpBuildRoadsRelation relation : list) {
					if(sbTemp.length() > 0) {
						sbTemp.append("、");
					}
					sbTemp.append(relation.getRoadsName());
				}
				erpBuildingInfoDto.setRoadsName(sbTemp.toString());
			}
		}
		return erpBuildingInfoDto;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString("2|11".split("\\|")));
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月31日
	 * @param cityId
	 * @param param
	 * @return
	 */
	@Transactional
	@Override
	public CreateOrUpdateBuildInfoParam updateBuildTmpInfo(Integer cityId, CreateOrUpdateBuildInfoParam param) {
		String sectionName = param.getSectionName();
		//楼盘纠错之后需要在重新审核
		param.setCheckFlag(Byte.valueOf("0"));
		Integer sectionId = param.getSectionId();
		if (sectionId == null && sectionName != null) {
			ErpFunSection funSectionPO = createSectionByupdateBuildInfo(param);
			sectionId=funSectionPO.getSectionId();
		}
		if(sectionId!=null){
			param.setSectionId(sectionId);
		}
		AdminErpBuildingInfoTmp erpBuildingInfoTmp = getTopOneBuildInfoTmp(param);
		ErpBuildingInfo erpBuildingInfoPO = erpBuildingInfoMapper.getObjectByFhouseId(Short.valueOf(param.getCityId().toString()), param.getBuildId());
		param.setBuildCode(erpBuildingInfoPO.getBuildCode());
		param.setBuildName(erpBuildingInfoPO.getBuildName());
		if (erpBuildingInfoTmp != null) {
			AdminErpBuildingInfoTmp conditionModel = new AdminErpBuildingInfoTmp();
			conditionModel.setSid(erpBuildingInfoTmp.getSid());
			conditionModel.setBuildId(param.getBuildId());
			adminErpBuildingInfoTmpMapper.updateAdminErpBuildingInfoTmp(param, conditionModel);
		} else {
			adminErpBuildingInfoTmpMapper.insertAdminErpBuildingInfoTmp(param);
		}
		updateCheckTimeByUpdateBuildingInfoTmp(param);
		return param;
	}

	/**
	 * @author 方李骥
	 * @since 2016年9月1日
	 * @param param
	 */
	private void updateCheckTimeByUpdateBuildingInfoTmp(CreateOrUpdateBuildInfoParam param) {
		ErpBuildingInfo erpBuildingInfo = new ErpBuildingInfo();
		erpBuildingInfo.setCheckTime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpBuildingInfoMapper.updateCheckTimeByUpdateBuildingInfoTmp(param.getCityId(),erpBuildingInfo);
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月31日
	 * @return
	 */
	private AdminErpBuildingInfoTmp getTopOneBuildInfoTmp(CreateOrUpdateBuildInfoParam param) {
		return adminErpBuildingInfoTmpMapper.selectTopOneBuildInfoTmp(param.getBuildId());
	}

	/**
	 * @author 方李骥
	 * @since 2016年8月31日
	 * @param param
	 * @return
	 */
	private ErpFunSection createSectionByupdateBuildInfo(CreateOrUpdateBuildInfoParam param) {
		String sectionName = param.getSectionIdText();
		List<ErpFunSection> funSectionPOs =  erpFunSectionMapper.selectSectionListByName(param.getCityId(),sectionName.toUpperCase());
		// 检测是否与原有片区同名
		if(funSectionPOs!=null){
			if(funSectionPOs.size()>0){
				return funSectionPOs.get(0);
			}
		}
		ErpFunSection insertModel = new ErpFunSection();
		insertModel.setRegId(param.getBuildRegion());
		insertModel.setCityId(param.getCityId());
		insertModel.setSectionName(sectionName);
		insertModel.setVertifyFlag(Byte.valueOf("0"));
		insertModel.setSectionCode(Pinyin4jUtil.getTopPinyin(sectionName));
		erpFunSectionMapper.insertErpFunSection(param.getCityId(),insertModel);
		return insertModel;
	}

	@Override
	public Object createBuildInfo(Integer cityId, CreateOrUpdateBuildInfoParam param) {
		ErpBuildingInfo erpBuildingInfo = erpBuildingInfoMapper.selectTopOneBuildingInfoOffBuildName(cityId,param.getBuildName());
		if(erpBuildingInfo != null){
			CreateOrUpdateBuildInfoParam returnCord = new CreateOrUpdateBuildInfoParam();
			try {
				BeanUtilsHelper.copyProperties(returnCord, erpBuildingInfo);
			} catch (Exception e) {

			}
			returnCord.setHasBuild("1");
			return returnCord;
		}

		erpBuildingInfo = new ErpBuildingInfo();
		if(param.getSectionId() == null && StringUtils.isNotBlank(param.getSectionIdText())){
			Integer sectionId = this.createSectionByBuildInfo(cityId,param.getSectionIdText(), param.getBuildRegion());
			if(sectionId!=null){
				erpBuildingInfo.setSectionId(sectionId);
			}
		}
		try {
			BeanUtilsHelper.copyProperties(erpBuildingInfo, param);
		} catch (Exception e) {

		}
		erpBuildingInfo.setUpdateTime(erpBuildingInfo.getCreateTime());
		erpBuildingInfo.setBuildPhoto(0);
		String buildCode = Pinyin4jUtil.converterToFirstSpell(param.getBuildName());
		erpBuildingInfo.setBuildCode(buildCode);
		erpBuildingInfo.setBuildPhoto(0);
		erpBuildingInfo.setTypicFlag(Short.valueOf("0"));
		erpBuildingInfo.setVertifyFlag(Short.valueOf("0"));
		erpBuildingInfo.setShardCityId(param.getCityId().intValue());
		// 更新综合字段
		// 简拼
		String quanPin = Pinyin4jUtil.converterToSpell(erpBuildingInfo.getBuildName());
		// 全拼，简拼，楼盘名，别名，别名全拼，别名简拼
		StringBuilder searchFiled = new StringBuilder(erpBuildingInfo.getBuildName());
		if(StringUtils.isNotBlank(quanPin)) {
			searchFiled.append("|").append(quanPin);
		}
		if(StringUtils.isNotBlank(buildCode)) {
			searchFiled.append("|").append(buildCode);
		}
		erpBuildingInfo.setSearchField(searchFiled.toString());
		erpBuildingInfoMapper.insertSelective(erpBuildingInfo);
		return erpBuildingInfo;
	}

	@Override
	public Object insertComBuild(Integer cityId, InsertComBuildParam param, Operator operator) {
		ErpBuildingInfo erpBuildingInfo = erpBuildingInfoMapper.selectTopOneBuildingInfoOffPromotionName(cityId,param.getPromotionName(),null);
		if(erpBuildingInfo != null){
			InsertComBuildParam returnCord = new InsertComBuildParam();
			try {
				BeanUtilsHelper.copyProperties(returnCord, erpBuildingInfo);
			} catch (Exception e) {
			}
			returnCord.setHasBuild(1);
			return returnCord;
		}

		erpBuildingInfo = new ErpBuildingInfo();
		try {
			BeanUtilsHelper.copyProperties(erpBuildingInfo, param);
		} catch (Exception e) {

		}
		erpBuildingInfo.setPositionY(param.getPostionY());
		erpBuildingInfo.setUpdateTime(erpBuildingInfo.getCreateTime());
		erpBuildingInfo.setBuildPhoto(0);
		String buildCode = Pinyin4jUtil.converterToFirstSpell(param.getBuildName());
		erpBuildingInfo.setBuildCode(buildCode);
		erpBuildingInfo.setBuildPhoto(0);
		erpBuildingInfo.setTypicFlag(Short.valueOf("0"));
		erpBuildingInfo.setVertifyFlag(Short.valueOf("1"));
		erpBuildingInfo.setShardCityId(param.getCityId().intValue());

		// 更新综合字段
		// 简拼
		String quanPin = Pinyin4jUtil.converterToSpell(erpBuildingInfo.getBuildName());

		// 全拼，简拼，楼盘名，别名，别名全拼，别名简拼
		StringBuilder searchFiled = new StringBuilder(erpBuildingInfo.getBuildName());
		if(StringUtils.isNotBlank(quanPin)) {
			searchFiled.append("|").append(quanPin);
		}
		if(StringUtils.isNotBlank(buildCode)) {
			searchFiled.append("|").append(buildCode);
		}
		// 美联的增加推广名全拼 和简拼 开始
//		if(operator.isMeiLianApi()){
			String promotionName = erpBuildingInfo.getPromotionName();
			if(StringUtil.isNotEmpty(promotionName)){
				String quanpinpromotionName = Pinyin4jUtil.converterToSpell(promotionName);
				String buildCodepromotionName = Pinyin4jUtil.converterToFirstSpell(promotionName);
				if(StringUtils.isNotBlank(promotionName)){
					searchFiled.append("|");
					searchFiled.append(promotionName);
				}
				if(StringUtils.isNotBlank(quanpinpromotionName)) {
					searchFiled.append("|").append(quanpinpromotionName);
				}
				if(StringUtils.isNotBlank(buildCodepromotionName)) {
					searchFiled.append("|").append(buildCodepromotionName);
				}
			}
			// 美联房源楼盘字典无需审核
			erpBuildingInfo.setVertifyFlag(Short.valueOf("1"));
//		}
		// 美联的增加推广名全拼 和简拼 结束
		erpBuildingInfo.setSearchField(searchFiled.toString());

		erpBuildingInfoMapper.insertSelective(erpBuildingInfo);
		return erpBuildingInfo;
	}

	private Integer createSectionByBuildInfo(Integer cityId, String sectionName, Integer buildRegion) {
		// 检测是否与原有片区同名
		List<ErpFunSection> list = erpFunSectionMapper.selectSectionListByName(cityId.shortValue(), sectionName);
		if(list.size()>0){
			return	list.get(0).getSectionId();
		}
		ErpFunSection erpFunSection = new ErpFunSection();
		erpFunSection.setRegId(buildRegion);
		erpFunSection.setCityId(cityId.shortValue());
		//没有PROVINCE_ID字段
		erpFunSection.setSectionName(sectionName);
		erpFunSection.setVertifyFlag((byte)0);
		erpFunSection.setShardCityId(cityId);
		erpFunSectionMapper.insertSelective(erpFunSection);
		return erpFunSection.getSectionId();
	}

	@Override
	public ErpBuildingInfoDto getBuildInfoById(String buildId, Integer cityId) {
		return erpBuildingInfoMapper.getBuildInfoById(cityId, buildId);
	}

	@Override
	public  PageInfo<ErpBuildingInfoDto> getBuildingListOffsetPages(QueryBuildingListParam param) {
		Integer page = param.getPageOffset() == null ? Const.CURRENT_PAGE : param.getPageOffset();
		Integer pageNum = (param.getPageRows() == null || param.getPageRows() < 0) ? Const.PAGE_NUMBER : param.getPageRows();
		Map<String, Integer> pages = new HashMap<>();
		pages.put("start", (page - 1) * pageNum);
		pages.put("end", page * pageNum);
		List<ErpBuildingInfoDto> erpBuildingInfoDtoList = erpBuildingInfoMapper.getBuildingListOffsetPages(param.getCityId(), param, pages);
		List<Integer> list = erpBuildingInfoDtoList.stream().map(ErpBuildingInfo::getBuildId).collect(Collectors.toList());
//        for (ErpBuildingInfoDto erpBuildingInfoDto : erpBuildingInfoDtoList) {
//            list.add(erpBuildingInfoDto.getBuildId());
//            erpBuildingInfoDtoMap.put(erpBuildingInfoDto.getBuildId(), erpBuildingInfoDto);
//        }

		if (list.size() > 0) {
			List<ErpBuildingPhoto> erpBuildingPhotoList = buildingPhotoMapper.getFirstPhotoAddr(param.getCityId(), list, pages);
			Map<Integer, ErpBuildingPhoto> erpBuildingInfoDtoMap = erpBuildingPhotoList.stream().collect(Collectors.toMap(ErpBuildingPhoto::getBuildId, account -> account));
			for (ErpBuildingInfoDto erpBuildingInfoDto : erpBuildingInfoDtoList) {
				if (erpBuildingInfoDtoMap.containsKey(erpBuildingInfoDto.getBuildId())) {
					ErpBuildingPhoto erpBuildingPhoto = erpBuildingInfoDtoMap.get(erpBuildingInfoDto.getBuildId());
					if (erpBuildingPhoto.getPhotoAddr() != null) {
						erpBuildingInfoDto.setFirstPicAddr(CommonUtil.getHousePhoto(erpBuildingPhoto.getPhotoAddr()));
					}
				}
			}
		}
		PageInfo<ErpBuildingInfoDto> pageInfo = new PageInfo<>(erpBuildingInfoDtoList);
		return pageInfo;
	}


	@Override
	public BuildingListInMobileVo getBuildingListInMobile(QueryBuildingListParam param, GeneralParam generalParam, Integer buildingFlag) {
		Integer cityId = generalParam.getCityId();
		Integer compId = generalParam.getCompId();
		param.setCityId(cityId);

		// 审核标志，1=是（纠正：入库标记 1-是； 0-否）
		param.setBuildingFlag(buildingFlag);

		// 片区ID
		if (StringUtil.isNotBlank(param.getSectionIds())) {
			param.setSectionIdList(param.getSectionIds().split(","));
		}

		// 是否搜索了楼盘信息,输入楼盘信息时,忽略区域,锁定状态和维护人条件
		boolean searchBuildFlag = false;

		// 楼盘搜索综合字段（全拼，简拼，楼盘名，别名，别名全拼，别名简拼） 顺序相同|分割
		// 输入楼盘信息时,忽略区域,锁定状态和维护人条件
		if (StringUtil.isNotBlank(param.getBuildName())) {
			param.setBuildName("%" + param.getBuildName() + "%");
			param.setSectionIdList(null);
			param.setBuildStatus(null);

			searchBuildFlag = true;
		}

		Set<String> buildListTrance = new HashSet<>();
		// 输入楼盘信息时,忽略区域,锁定状态和维护人条件
		if (StringUtil.isNotBlank(param.getBuildIds())) {
			param.setBuildName(null);
			param.setSectionIdList(null);
			param.setBuildStatus(null);

			String[] buildIds = param.getBuildIds().split(",");
			buildListTrance.addAll(Arrays.asList(buildIds));

			searchBuildFlag = true;
		}

		boolean userFlag = false;

		// 用户ID，由我维护与选人时传该值，由我店维护传deptId
		Integer userId = param.getUserId();
		// 门店ID，由我店维护传该值，由我维护与选人时传userId
		Integer deptId = param.getDeptId();

		Integer organizationId = param.getOrganizationId();

		// 得到由我维护或者由我店维护的所有楼盘的ID
		Set<String> userOrDeptBuildIdList = new HashSet<>();

		if (!searchBuildFlag) {
			if (null != userId) {
				userFlag = true;
				// 1.楼盘管理员
				ErpBuildingManagerExample example = new ErpBuildingManagerExample();
				example.setShardCityId(cityId);
				example.setOrderByClause(" CREATION_TIME DESC ");
				example.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(userId).andManagerTypeEqualTo((byte) 1);
				List<ErpBuildingManager> bExampleList = erpBuildingManagerMapper.selectByExample(example);
				if (!CollectionUtils.isEmpty(bExampleList)) {
					userOrDeptBuildIdList = bExampleList.stream().filter(val -> val.getBuildId() != null).map(val -> val.getBuildId().toString()).collect(Collectors.toSet());
				}
				// 2.栋座管理员 需联表 BUILDING_SET_ROOF
				List<Integer> userIdList = new ArrayList<>();
				userIdList.add(userId);
				List<ErpBuildingManager> rList = erpBuildingManagerMapper.getBuildListByUserId(cityId, compId, userIdList, (byte) 2);
				if (!CollectionUtils.isEmpty(rList)) {
					userOrDeptBuildIdList.addAll(rList.stream().filter(val -> val.getBuildId() != null).map(val -> (val.getBuildId() + "")).collect(Collectors.toSet()));
				}
			} else if (null != deptId) {
				userFlag = true;
				ErpFunUsersExample example = new ErpFunUsersExample();
				example.setShardCityId(cityId);
				example.setOrderByClause(" USER_ID DESC ");
				example.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andUserWriteoffEqualTo(false);
				List<ErpFunUsers> usersList = erpFunUsersMapper.selectByExample(example);
				if (CollectionUtils.isNotEmpty(usersList)) {
					List<Integer> userIds = usersList.stream().map(ErpFunUsers::getUserId).collect(Collectors.toList());
					ErpBuildingManagerExample example1 = new ErpBuildingManagerExample();
					example1.setShardCityId(cityId);
					example1.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIds).andManagerTypeEqualTo((byte) 1);
					List<ErpBuildingManager> exampleList = erpBuildingManagerMapper.selectByExample(example1);
					if (!CollectionUtils.isEmpty(exampleList)) {
						userOrDeptBuildIdList = exampleList.stream().filter(val -> val.getBuildId() != null).map(val -> val.getBuildId().toString()).collect(Collectors.toSet());
					}
					List<ErpBuildingManager> rList = erpBuildingManagerMapper.getBuildListByUserId(cityId, compId, userIds, (byte) 2);
					if (!CollectionUtils.isEmpty(rList)) {
						userOrDeptBuildIdList.addAll(rList.stream().filter(val -> val.getBuildId() != null).map(val -> (val.getBuildId() + "")).collect(Collectors.toSet()));
					}
				}
			} else if (null != organizationId) {
				userFlag = true;
				ErpFunUsersExample example = new ErpFunUsersExample();
				example.setShardCityId(cityId);
				example.setOrderByClause(" USER_ID DESC ");
				example.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false).andTissueLineLike(":"+organizationId+":");
				List<ErpFunUsers> usersList = erpFunUsersMapper.selectByExample(example);
				if (CollectionUtils.isNotEmpty(usersList)) {
					List<Integer> userIds = usersList.stream().map(ErpFunUsers::getUserId).collect(Collectors.toList());
					ErpBuildingManagerExample example1 = new ErpBuildingManagerExample();
					example1.setShardCityId(cityId);
					example1.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIds).andManagerTypeEqualTo((byte) 1);
					List<ErpBuildingManager> exampleList = erpBuildingManagerMapper.selectByExample(example1);
					if (!CollectionUtils.isEmpty(exampleList)) {
						userOrDeptBuildIdList = exampleList.stream().filter(val -> val.getBuildId() != null).map(val -> val.getBuildId().toString()).collect(Collectors.toSet());
					}
					List<ErpBuildingManager> rList = erpBuildingManagerMapper.getBuildListByUserId(cityId, compId, userIds, (byte) 2);
					if (!CollectionUtils.isEmpty(rList)) {
						userOrDeptBuildIdList.addAll(rList.stream().filter(val -> val.getBuildId() != null).map(val -> (val.getBuildId() + "")).collect(Collectors.toSet()));
					}
				}
			}
		}

		Set<String> buildIdList = new HashSet<>();

		// 输入楼盘信息时,忽略区域,锁定状态和维护人条件
		if (searchBuildFlag && CollectionUtils.isNotEmpty(buildListTrance)) {
			buildIdList.addAll(buildListTrance);
		} else {
			if (CollectionUtils.isNotEmpty(userOrDeptBuildIdList)) {
				buildIdList.addAll(userOrDeptBuildIdList);
			}
		}

		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		// 获取楼盘基本信息列表
		if (userFlag && CollectionUtils.isEmpty(buildIdList)) {
			return new BuildingListInMobileVo(new PageInfo());
		}

		List<BuildingInfoInMobileVo> buildingList = erpBuildingInfoMapper.getBuildingListInMobile(param.getCityId(), param, buildIdList);
		if (CollectionUtils.isEmpty(buildingList)) {
			return new BuildingListInMobileVo(new PageInfo());
		}
		// 楼盘字典列表的楼盘ID
		List<Integer> buildIds = buildingList.stream().map(BuildingInfoInMobileVo::getBuildId).collect(Collectors.toList());

		// 获取每个楼盘的右侧静态信息（在租，在售，内外成交）
		List<ErpBuildingMarketingControlMin> conInfos = erpBuildingMarketingControlMinMapper.getControlInfo(cityId, buildIds, compId);
		Map<Integer, ErpBuildingMarketingControlMin> controlInfos = new HashMap<>();
		if (conInfos != null) {
			controlInfos = conInfos.stream().collect(Collectors.toMap(ErpBuildingMarketingControlMin::getBuildId, val -> val));
		}

		// 封装结果数据
		for (BuildingInfoInMobileVo dto : buildingList) {
			Integer buildId = dto.getBuildId();
			dto.setFirstPicAddr(CommonUtil.getHousePhoto(dto.getFirstPicAddr()));
			if (controlInfos.get(buildId) != null) {
				dto.setSaleCount(controlInfos.get(buildId).getSaleCount());
				dto.setLeaseCount(controlInfos.get(buildId).getLeaseCount());
			}
		}

		PageInfo<BuildingInfoInMobileVo> pageInfo = new PageInfo<>(buildingList);
		return new BuildingListInMobileVo(pageInfo);
	}

}
