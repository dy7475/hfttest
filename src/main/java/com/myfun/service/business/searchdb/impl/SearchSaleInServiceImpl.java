package com.myfun.service.business.searchdb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.exception.ConfirmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.dao.AdminCrmBrokerTrackMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.po.AdminCrmBrokerTrack;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.agencydb.dao.AgencyVipLeaseMapper;
import com.myfun.repository.agencydb.dao.AgencyVipSaleMapper;
import com.myfun.repository.agencydb.dto.AgencyCommentDto;
import com.myfun.repository.agencydb.dto.AgencyVipSaleDto;
import com.myfun.repository.agencydb.po.AgencyVipLease;
import com.myfun.repository.agencydb.po.AgencyVipSale;
import com.myfun.repository.searchdb.dao.SearchLeaseInMapper;
import com.myfun.repository.searchdb.dao.SearchSaleInMapper;
import com.myfun.repository.searchdb.dao.SearchSosoViewMapper;
import com.myfun.repository.searchdb.dto.SearchSaleInDataInfoDto;
import com.myfun.repository.searchdb.dto.SearchSaleInDto;
import com.myfun.repository.searchdb.dto.SearchRepeatDto;
import com.myfun.repository.searchdb.param.SaleInParam;
import com.myfun.repository.searchdb.po.SearchLeaseIn;
import com.myfun.repository.searchdb.po.SearchSaleIn;
import com.myfun.repository.searchdb.po.SearchSosoView;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.searchdb.SearchSaleInService;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleDataInfoParam;
import com.myfun.service.business.searchdb.bean.param.SoSoSaleListParam;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

@Service
public class SearchSaleInServiceImpl extends AbstractService<SearchSaleIn, Integer>implements SearchSaleInService {
	@Autowired
	private SearchSaleInMapper searchSaleInMapper;
	@Autowired
	private AdminCrmBrokerTrackMapper adminCrmBrokerTrackMapper;
	@Autowired
	private SearchLeaseInMapper searchLeaseInMapper;
	@Autowired
	private AgencyVipSaleMapper agencyVipSaleMapper;
	@Autowired
	private AgencyVipLeaseMapper agencyVipLeaseMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	@Autowired
	private SearchSosoViewMapper searchSosoViewMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = searchSaleInMapper;
	}

	@Override
	public List<SearchSaleIn> getSaleInList(SaleInParam saleIn) {
		PageHelper.startPage(saleIn.getPageNum(), saleIn.getPageSize(), true);
		return searchSaleInMapper.getSaleInList(saleIn);
	}

	@Override
	public boolean isDelete(String[] ids, String tableName) {
		int count = searchSaleInMapper.getStatueFlag(ids, tableName);
		if (count > 0) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isVipFlag(String[] ids, String tableName) {
		int count = searchSaleInMapper.getVipFlag(ids, tableName);
		if (count > 0) {
			return false;
		}
		return true;
	}

	@Transactional
	@Override
	public int updateStatusFlag(String[] ids, String tableName, AdminCrmBrokerTrack record) {
		searchSaleInMapper.updateStatusByids(ids, tableName);
		// 写根据
		adminCrmBrokerTrackMapper.insertSelective(record);
		return 1;
	}

	@Override
	public boolean isUpHouse(String[] ids, String tableName) {
		int count = searchSaleInMapper.isUpHouse(ids, tableName);
		if (count > 0) {
			return false;
		}
		return true;
	}

	@Override
	public int updateStatusFlagForUp(String[] ids, String tableName) {
		// TODO Auto-generated method stub
		return searchSaleInMapper.updateStatusForUpByids(ids, tableName);
	}

	@Override
	public SearchSaleIn getSearchSaleInById(String id, Date inTime) {
		return searchSaleInMapper.getSaleInByid(id, "sale_in");
	}

	@Override
	public SearchLeaseIn getSearchLeaseInById(String id, String tableName) {
		// TODO Auto-generated method stub
		return searchLeaseInMapper.getSearchLeaseInById(id, tableName);
	}

	@Transactional
	@Override
	public void SyncVipSosoUgc(String caseType, Short cityId, Integer caseId, Integer sosoId){
		boolean isUpdate = sosoId != null && !sosoId.equals("") && !sosoId.equals("0");
		// 获取查询名称
		String tableName = getTableNameByType("vip", caseType);
		// 获取主键
		String fieldId = getTableNameByType("vip", caseType, "sale_id");
		// 查询出直供信息
		AgencyVipSaleDto vipSale = agencyVipSaleMapper.getVipInfo(tableName, fieldId, cityId, caseId);
		// 哪些字段需要更新到搜搜 给soso表赋值
		SearchSaleIn salein = copyValueToVipSaleDto(vipSale);
		salein.setId(caseId);
		String repeatFlag = String.valueOf(vipSale.getRepeatFlag());
		// 如果是重复数据则同步到搜搜显示重复
		if ("1".equals(repeatFlag)) {
			salein.setVipRepeat((byte)1);
		} else {
			salein.setVipRepeat((byte)0);
		}

		// 如果没有对应信息则插入一条信息
		if (isUpdate) {
			String hasRefund = String.valueOf(vipSale.getHasRefund());
			String refundTime = String.valueOf(vipSale.getRefundTime());
			if (hasRefund.equals("1")) {
				salein.setVipRefundTime(DateUtil.StringToDate(refundTime));
			}
			// 判断上架下架逻辑
			String vipCaseStatus = String.valueOf(vipSale.getCaseStatus());
			String vipDownTime = String.valueOf(vipSale.getDownTime());
			if (vipCaseStatus.equals("2")) {
				salein.setStatusFlag(0);
			} else if (vipCaseStatus.equals("5")) {
				salein.setStatusFlag(10);
				salein.setVipDownTime(DateUtil.StringToDate(vipDownTime));
			}
			// 执行更新soso SALE_IN库操作
			salein.setId(sosoId);
			if ("SALE_FUN".equals(caseType) || "1".equals(caseType)) {
				searchSaleInMapper.updateByPrimaryKeySelectiveById(salein);
			} else if ("LEASE_FUN".equals(caseType) || "2".equals(caseType)) {
				SearchLeaseIn searchLeaseIn = copyValueToLease(salein);
				searchLeaseInMapper.updateByPrimaryKeySelective(searchLeaseIn);
			}

		} else {
			// 获取search库中 SEQ_SOSO_RES_ID
//			sosoId = searchSaleInMapper.getSEQSOSOId();
			if (!"".equals(sosoId) && !"0".equals(sosoId)) {
			
			String vipInfoSource = String.valueOf(vipSale.getInfoSource());
			AdminFunCity city = adminFunCityMapper.selectByPrimaryKey(cityId);
			Short provinceId = city.getProvinceId();
			salein.setDataSource(Integer.parseInt(vipInfoSource));
			salein.setRelateId(caseId);
//			
			salein.setProvinceId(Byte.parseByte(String.valueOf(provinceId)));
//			salein.setId(sosoId);
			salein.setInTime(new Date());
			salein.setSiteId(0);
			salein.setVipFlag((byte)1);
			salein.setStatusFlag(10);
			if (null != salein.getHouseType() && "OTHER".equals(salein.getHouseType())) {
				salein.setHouseType(null);
			}
			// 执行插入数据
			if ("SALE_FUN".equals(caseType) || "1".equals(caseType)) {
				searchSaleInMapper.insertSelective(salein);
				//修改某个值
				
				salein.setPrimitiveId("tencent_" + salein.getId());
				searchSaleInMapper.updateByPrimaryKeySelective(salein);
				
				// 把搜搜id更新回去
				AgencyVipSale vipsale = new AgencyVipSale();
				vipsale.setSosoId(salein.getId());
				vipsale.setCityId(cityId);
				vipsale.setSaleId(caseId);
				agencyVipSaleMapper.updateByPrimaryKeySelective(vipsale);
			} else if ("LEASE_FUN".equals(caseType) || "2".equals(caseType)) {
//				salein.setPrimitiveId("tencent_" + salein.getId());
				SearchLeaseIn searchLeaseIn = copyValueToLease(salein);
				searchLeaseIn.setId(null);
				searchLeaseInMapper.insertSelective(searchLeaseIn);
				//修改某个字段
				salein.setPrimitiveId("tencent_" + searchLeaseIn.getId());
				searchLeaseInMapper.updateByPrimaryKeySelective(searchLeaseIn);
				sosoId = searchLeaseIn.getId();
				// 把搜搜id更新回去
				AgencyVipLease vipLease = new AgencyVipLease();
				vipLease.setSosoId(sosoId);
				vipLease.setCityId(cityId);
				vipLease.setLeaseId(caseId);
				agencyVipLeaseMapper.updateByPrimaryKeySelective(vipLease);
			}
			}
		}
	}

	public SearchLeaseIn copyValueToLease(SearchSaleIn vipSale) {
		SearchLeaseIn searchLeaseIn = new SearchLeaseIn();
		searchLeaseIn.setCityId(vipSale.getCityId());
		searchLeaseIn.setTitle(vipSale.getTitle());
		searchLeaseIn.setOwner(vipSale.getOwner());
		searchLeaseIn.setMobilePhone(vipSale.getMobilePhone());
		searchLeaseIn.setBuildName(vipSale.getBuildName());
		searchLeaseIn.setArea(vipSale.getArea());
		searchLeaseIn.setDirect(vipSale.getDirect());
		searchLeaseIn.setFitment(vipSale.getFitment());
		searchLeaseIn.setFloor(vipSale.getFloor());
		searchLeaseIn.setFloors(vipSale.getFloors());
		searchLeaseIn.setHall(vipSale.getHall());
		searchLeaseIn.setHouseRight(vipSale.getHouseRight());
		searchLeaseIn.setHouseStruct(vipSale.getHouseStruct());
		searchLeaseIn.setHouseYear(vipSale.getHouseYear());
		searchLeaseIn.setRoom(vipSale.getRoom());
		searchLeaseIn.setTotalPrice(vipSale.getTotalPrice());
		searchLeaseIn.setUseage(vipSale.getUseage());
		searchLeaseIn.setWei(vipSale.getWei());
		searchLeaseIn.setCharact(vipSale.getCharact());
		searchLeaseIn.setVipRepeat(Byte.valueOf(String.valueOf(vipSale.getVipRepeat())));
		searchLeaseIn.setRegion(vipSale.getRegion());
		searchLeaseIn.setSection(vipSale.getSection());
		searchLeaseIn.setSectors(vipSale.getSectors());
		searchLeaseIn.setHouseType(vipSale.getHouseType());
		searchLeaseIn.setVipRefundTime(vipSale.getVipRefundTime());
		searchLeaseIn.setStatusFlag(vipSale.getStatusFlag());
		searchLeaseIn.setVipDownTime(vipSale.getVipDownTime());
		searchLeaseIn.setHouseType(vipSale.getHouseType());
		searchLeaseIn.setDataSource(vipSale.getDataSource());
		searchLeaseIn.setRelateId(vipSale.getRelateId());
		searchLeaseIn.setPrimitiveId(vipSale.getPrimitiveId());
		searchLeaseIn.setProvinceId(vipSale.getProvinceId());
		searchLeaseIn.setId(vipSale.getId());
		searchLeaseIn.setInTime(new Date());
		searchLeaseIn.setSiteId(vipSale.getSiteId());
		searchLeaseIn.setVipFlag(Byte.valueOf(String.valueOf(vipSale.getVipFlag())));
		return searchLeaseIn;
	}

	/**
	 * 给soso需要更新的字段赋值
	 * 
	 * @param vipSale
	 * @return
	 */
	public SearchSaleIn copyValueToVipSaleDto(AgencyVipSaleDto vipSale) {
		SearchSaleIn salein = new SearchSaleIn();
		salein.setCityId(vipSale.getCityId());
		salein.setTitle(vipSale.getHouseSubject());
		salein.setOwner(vipSale.getClientName());
		salein.setMobilePhone(vipSale.getClientMobile());
		salein.setBuildName(vipSale.getBuildName());
		salein.setArea(StringUtil.parseDouble(String.valueOf(vipSale.getHouseArea())));
		salein.setDirect(vipSale.getHouseDirect());
		salein.setFitment(vipSale.getHouseFitment());
		salein.setFloor(StringUtil.parseInteger(String.valueOf(vipSale.getHouseFloor())));
		salein.setFloors(StringUtil.parseInteger(String.valueOf(vipSale.getHouseFloors())));
		salein.setHall(StringUtil.parseInteger(String.valueOf(vipSale.getHouseHall())));
		salein.setHouseRight(vipSale.getHouseRight());
		salein.setHouseStruct(vipSale.getHouseStruct());
		salein.setHouseYear(vipSale.getHouseYear());
		salein.setRoom(StringUtil.parseInteger(String.valueOf(vipSale.getHouseRoom())));
		salein.setTotalPrice(StringUtil.parseDouble(String.valueOf(vipSale.getPrice())));
		salein.setUseage(vipSale.getHouseUseage());
		salein.setWei(StringUtil.parseInteger(String.valueOf(vipSale.getHouseHall())));
		salein.setCharact(vipSale.getDescp());
		salein.setVipRepeat(vipSale.getRepeatFlag());
		salein.setRegion(vipSale.getRegionName());
		salein.setSection(vipSale.getSectionName());
		salein.setSectors(vipSale.getBuildAddr());
		salein.setHouseType(vipSale.getHouseType());
		return salein;
	}

	@Override
	public AgencyCommentDto getCaseInfo(String tableName, String fieldName, String cityId, String caseId) {
		return searchSaleInMapper.getCaseInfo(tableName, fieldName, cityId, caseId);
	}

	/**
	 * 获取表名字或主键id名
	 * 
	 * @param tableType
	 *            获取那种表名
	 * @param caseType
	 *            获取表的类型
	 * @param filed
	 *            获取的字段名
	 * @return
	 * @throws Exception
	 */
	public static String getTableNameByType(String tableType, String caseType, String... filed) {
		int index = 0;
		if ("SALE_FUN".equals(caseType)) {
			index = 0;
		} else if ("LEASE_FUN".equals(caseType)) {
			index = 1;
		} else if ("BUY_CUST".equals(caseType)) {
			index = 2;
		} else if ("RENT_CUST".equals(caseType)) {
			index = 3;
		}

		String tbName = null;
		String fieldId = null;
		if (SOSO_TB_NAME_TYPE.equals(tableType)) {
			tbName = SOSO_TB_NAME[index];
			fieldId = SOSO_TB_ID[index];
		} else if (UGC_TB_NAME_TYPE.equals(tableType)) {
			tbName = UGC_TB_NAME[index];
			fieldId = UGC_TB_ID[index];
		} else if (VIP_TB_NAME_TYPE.equals(tableType.toUpperCase())) {
			tbName = VIP_TB_NAME[index];
			fieldId = VIP_TB_ID[index];
		}

		return filed.length > 0 ? fieldId : tbName;
	}

	/** SOSO **/
	private static final String SOSO_TB_NAME_TYPE = "SOSO";

	/** VIP **/
	private static final String VIP_TB_NAME_TYPE = "VIP";

	/** UGC **/
	private static final String UGC_TB_NAME_TYPE = "UGC";
	/** 搜搜表名 **/
	private static final String[] SOSO_TB_NAME = { "SALE_IN", "LEASE_IN", "SHOP_MAIN", "HEZU" };

	/** 直供表名 **/
	private static final String[] VIP_TB_NAME = { "VIP_SALE", "VIP_LEASE", "VIP_BUY", "VIP_RENT" };

	/** ugc表名 **/
	private static final String[] UGC_TB_NAME = { "T_ESF_SALE_CHK", "T_ESF_LEASE_CHK", "T_ESF_BUY_CHK", "T_ESF_RENT_CHK" };

	/** 搜搜ID **/
	private static final String[] SOSO_TB_ID = { "ID", "ID", "ID", "ID" };

	/** 直供ID **/
	private static final String[] VIP_TB_ID = { "SALE_ID", "LEASE_ID", "BUY_ID", "RENT_ID" };

	/** ugc ID **/
	private static final String[] UGC_TB_ID = { "FId", "FId", "FId", "FId" };

	@Override
	public void deleteSeleInById(Integer id, Date inTime) {
		searchSaleInMapper.deleteSeleInById(id);
	}

	@Override
	public void updateSaleInNotNullById(SearchSaleIn searchSaleIn) {
		searchSaleInMapper.updateNotNullById(searchSaleIn);
	}
	
	@Override
	public PageInfo<SearchSaleInDto> getSOSOViewedSaleList(SoSoSaleListParam param) {
		String[] tables = CommonUtil.getSaleTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<SearchSaleInDto> resultList = searchSaleInMapper.getSOSOViewedSaleList(param);
		for(SearchSaleInDto searchSaleInDto :resultList){
			Integer tatusFlag = searchSaleInDto.getStatusFlag();
			//判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			searchSaleInDto.setHouseFlag(tatusFlag);
		}
		PageInfo<SearchSaleInDto> pageInfo = new PageInfo<SearchSaleInDto>(resultList);
		return pageInfo;
	}

	@Override
	public PageInfo<SearchSaleInDto> getSoSoSaleList(SoSoSaleListParam param, Integer archiveId) {
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		String[] tables = CommonUtil.getSaleTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		List<SearchSaleInDto> resultList = searchSaleInMapper.getSoSoSaleList(param);
		if (resultList != null && resultList.size() > 0) {
			Set<Integer> idSet = new HashSet<Integer>();
			for (SearchSaleInDto searchSaleInDto : resultList) {
				idSet.add(searchSaleInDto.getId());
			}
			List<SearchSosoView> viewInfo = searchSosoViewMapper.getSoSoViewList(idSet.toArray(new Integer[idSet.size()]),null, archiveId);
			Map<Integer, SearchSosoView> viewMap = new HashMap<Integer, SearchSosoView>();
			for (SearchSosoView searchSosoView : viewInfo) {
				viewMap.put(searchSosoView.getSosoId(), searchSosoView);
			}
			for (int i = 0; i < resultList.size(); i++) {
				SearchSaleInDto saleInViewDto = resultList.get(i);
				Integer id = saleInViewDto.getRepeatId();
				if (id == null || id <= 10) {
					id = saleInViewDto.getId();
				}
				SearchSosoView sosoView = viewMap.get(id);
				if (sosoView != null) {
					if ("1".equals(sosoView.getIsConvert())) {
						saleInViewDto.setConerted("1");
						saleInViewDto.setReaded("1");
					} else {
						saleInViewDto.setReaded("1");
						saleInViewDto.setConerted("0");
					}
					saleInViewDto.setComplaintFlag(sosoView.getComplaintFlag());
					saleInViewDto.setComplaintTime(sosoView.getComplaintTime());
				} else {
					saleInViewDto.setReaded("0");
					saleInViewDto.setConerted("0");
				}
			}
			for(SearchSaleInDto searchSaleInDto :resultList){
				Integer tatusFlag = searchSaleInDto.getStatusFlag();
				//判断中介虚假房源
				tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
				searchSaleInDto.setHouseFlag(tatusFlag);
			}
		}
		PageInfo<SearchSaleInDto> pageInfo = new PageInfo<SearchSaleInDto>(resultList);
		return pageInfo;
	}

	@Override
	public SearchSaleInDataInfoDto getDataInfoById(SoSoSaleDataInfoParam param) {
		String[] tables = CommonUtil.getSaleTableNameAndDetailName(param.getTime());
		param.setTbName(tables[0]);
		param.setTbNameDetail(tables[1]);
		// 查询数据
		SearchSaleInDataInfoDto dataInfoDto = searchSaleInMapper.getSaleInDataInfoById(param);
		if(dataInfoDto!= null){
			Integer tatusFlag = dataInfoDto.getStatusFlag();
			// 判断中介虚假房源
			tatusFlag = CommonUtil.getHouseFlg(tatusFlag);
			dataInfoDto.setHouseFlag(tatusFlag);
		}
		return dataInfoDto;
	}
	
	@Transactional
	@Override
	public void complaintSosoData(String time, Integer sosoId,Integer repeatId, Integer complaintType, Integer archiveId, Integer provinceId, Integer cityId) {
		sosoId = (repeatId == null || repeatId <= 10) ? sosoId : repeatId;
		List<SearchSosoView> soSoViewList = searchSosoViewMapper.getSoSoViewList(new Integer[]{sosoId},repeatId, archiveId);
		if(soSoViewList == null || soSoViewList.isEmpty()) {
			throw new ConfirmException("获取查看记录失败");
		}
		// 已经标记过
		SearchSosoView searchSosoView = soSoViewList.get(0);
		Byte complaintFlag = searchSosoView.getComplaintFlag();
		if(complaintFlag != null && complaintFlag != 0) {
			return;
		}
		String[] tables = CommonUtil.getSaleTableNameAndDetailName(time);
		SearchSosoView sosoViewKey = new SearchSosoView();
		sosoViewKey.setArchiveId(archiveId);
		sosoViewKey.setSosoId(sosoId);
		sosoViewKey.setSosoProperty(searchSosoView.getSosoProperty());
		sosoViewKey.setSosoType(searchSosoView.getSosoType());
		sosoViewKey.setComplaintFlag(complaintType.byteValue());
		searchSosoViewMapper.updateComplaintFlag(sosoViewKey);
		searchSaleInMapper.addComplaintCount(tables[0], sosoId, complaintType, provinceId, cityId);
	}
}
