package com.myfun.erpWeb.house;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.repository.erpdb.dto.TrackIdAndTableDto;
import com.myfun.utils.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunKeyMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunStickTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackExtendMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackHisMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpFunViewLogMapper;
import com.myfun.repository.erpdb.dao.ErpMakeLookHouseMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dao.ErpTrackPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpTrackVideoMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dto.ErpFunTrackDto;
import com.myfun.repository.erpdb.dto.ErpFunTrackDto.MkHouseInfo;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsExample;
import com.myfun.repository.erpdb.po.ErpFunKey;
import com.myfun.repository.erpdb.po.ErpFunKeyExample;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunLeaseExample;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunSaleExample;
import com.myfun.repository.erpdb.po.ErpFunStickTrack;
import com.myfun.repository.erpdb.po.ErpFunStickTrackExample;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.repository.erpdb.po.ErpFunTrackExtend;
import com.myfun.repository.erpdb.po.ErpFunTrackExtendExample;
import com.myfun.repository.erpdb.po.ErpFunTrackHis;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.erpdb.po.ErpFunViewLog;
import com.myfun.repository.erpdb.po.ErpFunViewLogExample;
import com.myfun.repository.erpdb.po.ErpMakeLookHouse;
import com.myfun.repository.erpdb.po.ErpMakeLookHouseExample;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.erpdb.po.ErpTrackPhoto;
import com.myfun.repository.erpdb.po.ErpTrackVideo;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunPartnerConfigService;
import com.myfun.service.business.erpdb.ErpSysParaService;

@Controller
@RequestMapping(value="/house",method= RequestMethod.POST)
public class FunTrackController extends BaseController{
	@Autowired ErpFunTrackMapper erpFunTrackMapper;
	@Autowired ErpTrackPhotoMapper erpTrackPhotoMapper;
	@Autowired ErpTrackVideoMapper erpTrackVideoMapper;
	@Autowired
	ErpFunStickTrackMapper erpFunStickTrackMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunTrackHisMapper erpFunTrackHisMapper;
	@Autowired
	ErpFunTrackExtendMapper erpFunTrackExtendMapper;
	@Autowired
	ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunViewLogMapper erpFunViewLogMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpMakeLookHouseMapper erpMakeLookHouseMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpFunPartnerConfigService erpFunPartnerConfigService;
	@Autowired
	ErpSysParaService erpSysParaService;


	@ResponseBody
	@RequestMapping(value = "/getTrackVideoImageList")
	public ResponseJson getTrackVideoImageList(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer cityId = getOperator().getCityId();
		Integer trackId = param.getInteger("trackId");
		ErpFunTrack  erpfuntrack= erpFunTrackMapper.getTrackResultById(cityId,trackId);
		if(erpfuntrack == null) {
			return ErpResponseJson.ok();
		}
		// 有视频或者图片
		if(Constants_DIC.DIC_TRACK_RESULT_1_BYTE.equals(erpfuntrack.getTrackResult())){
			if(erpfuntrack.getTrackType().equals(Const.DIC_TRACK_TYPE_KONGKAN)
					|| erpfuntrack.getTrackType().equals(Const.DIC_TRACK_TYPE_FUNCAN)){// 查询房勘图片
				List<ErpTrackPhoto> erpTrackPhotoList = erpTrackPhotoMapper.getPhotoListByTrackId(cityId, trackId);
				for (ErpTrackPhoto erpTrackPhoto : erpTrackPhotoList) {
					erpTrackPhoto.setPhotoAddr(CommonUtil.getHousePhoto(erpTrackPhoto.getPhotoAddr()));
				}
				return ErpResponseJson.ok(erpTrackPhotoList);
			} else if(erpfuntrack.getTrackType().equals(Const.DIC_TRACK_TYPE_DAIKAN)){// 查询带看视频
				List<ErpTrackVideo> erpTrackVideoList = erpTrackVideoMapper.getErpTrackVideoListByTrackId(cityId, trackId);
				for (ErpTrackVideo erpTrackVideo : erpTrackVideoList) {
					erpTrackVideo.setVideoAddr(CommonUtil.getHousePhoto(erpTrackVideo.getVideoAddr()));
				}
				return ErpResponseJson.ok(erpTrackVideoList);
			}
		}
		return ErpResponseJson.ok();
	}

	/**
	 * 置顶跟进列表
	 * @author lcb
	 * @date 2018/6/7
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getStickTrackList")
	public ResponseJson getStickTrackList(@Valid @RequestBody BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<Integer> caseIds = new ArrayList<>();
		Integer caseId = param.getInteger("caseId");
		caseIds.add(caseId);
		Byte caseType = param.getByte("caseType");
		Integer filterType = param.getInteger("filterType");
		Byte trackType = param.getByte("trackType");
		boolean isSaleLeaseHouse = false;
		Byte saleLeaseType = null;
		Integer saleLeaseId = null;
		// 判断是否是租售房源
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType + "")) {
			ErpFunSale funSaleBySaleId = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			Byte isSaleLease = funSaleBySaleId.getIsSaleLease();
			saleLeaseId = funSaleBySaleId.getSaleLeaseId();
			if (null != isSaleLease && 1 == isSaleLease.intValue() && null != saleLeaseId) {
				caseIds.add(saleLeaseId);
				isSaleLeaseHouse = true;
				saleLeaseType = Const.DIC_CASE_TYPE_LEASE_FUN_BYTE;
			}
		} else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType + "")){
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			Byte isSaleLease = erpFunLease.getIsSaleLease();
			saleLeaseId = erpFunLease.getSaleLeaseId();
			if (null != isSaleLease && 1 == isSaleLease.intValue() && null != saleLeaseId) {
				caseIds.add(saleLeaseId);
				isSaleLeaseHouse = true;
				saleLeaseType = Const.DIC_CASE_TYPE_SALE_FUN_BYTE;
			}
		}

		ErpFunStickTrackExample example = new ErpFunStickTrackExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(operator.getCompId()).andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType).andTopStatusEqualTo((byte) 1);
		example.setOrderByClause(" CREATE_TIME DESC");
		List<ErpFunStickTrack> resList = erpFunStickTrackMapper.selectByExample(example);
		//flj修改　2020-06-27 判断出售房源，如果是租售房源，单独查询另外一边的置顶跟进，不能直接用caseId不带caseType去查询
		if (isSaleLeaseHouse) {
			example = new ErpFunStickTrackExample();
			example.setShardCityId(cityId);
			example.createCriteria().andCompIdEqualTo(operator.getCompId()).andCaseIdEqualTo(saleLeaseId).andCaseTypeEqualTo(saleLeaseType).andTopStatusEqualTo((byte) 1);
			example.setOrderByClause(" CREATE_TIME DESC");
			List<ErpFunStickTrack> tempResList = erpFunStickTrackMapper.selectByExample(example);
			if (!resList.isEmpty()) {
				if (!tempResList.isEmpty()) {
					resList.addAll(tempResList);
				}
			} else {
				resList = tempResList;
			}
		}
		List<TrackIdAndTableDto> trackIdAndTableDtos = new ArrayList<>();
		List<String> queryTables = new ArrayList<>();
		for (ErpFunStickTrack erpFunStickTrack : resList) {
			Date trackCreateTime = erpFunStickTrack.getTrackCreateTime();
			if (trackCreateTime != null) {
				// 当前月查 FUN_TRACK 表
				boolean isThisMonth = DateUtil.isThisMonth(trackCreateTime.getTime());
				String queryTable;
				if (isThisMonth) {
					queryTable = "FUN_TRACK";
				} else {
					queryTable = "FUN_TRACK" + DateUtil.getTimeList(DateUtil.DateToString(trackCreateTime), DateUtil.DateToString(trackCreateTime)).get(0);
				}
				TrackIdAndTableDto trackIdAndTableDto = new TrackIdAndTableDto();
				trackIdAndTableDto.setTrackId(erpFunStickTrack.getTrackId());
				trackIdAndTableDto.setQueryTable(queryTable);
				trackIdAndTableDtos.add(trackIdAndTableDto);
				queryTables.add(queryTable);
			}
		}
		queryTables = queryTables.stream().distinct().collect(Collectors.toList());

		// 这个不查询跟进了，前端跟进trackId 去跟进列表取，免得代码重复
		// 最多5条，容错限制10条
		List<ErpFunTrackDto> erpFunTrackDtos = new ArrayList<>(10);
		if(resList.size() > 0) {
			List<Byte> trackTypeList = new ArrayList<>();
			if(null != trackType) {
				trackTypeList.add(trackType);
			}else {
				trackTypeList = getTrackType(filterType);
			}

			// 过滤历史跟进还是正常跟进
			List<Integer> historyTrackList = resList.stream().filter(val -> val.getIsHisTrack().intValue() == 1).map(ErpFunStickTrack::getTrackId).collect(Collectors.toList());
			List<Integer> currentTrackList = resList.stream().filter(val -> val.getIsHisTrack().intValue() == 0).map(ErpFunStickTrack::getTrackId).collect(Collectors.toList());
			List<Integer> trackIdsList = resList.stream().map(ErpFunStickTrack::getTrackId).collect(Collectors.toList());
			// 2013-1-1之前算历史数据
			if(historyTrackList.size() > 0) {
				// 查询跟进
				erpFunTrackDtos=erpFunTrackHisMapper.getErpFunTrackDtoList(operator.getCityId(),trackIdsList,trackTypeList);
			}
			Map<Integer,ErpMakeLookHouse> makeLookMap = null;
			if(currentTrackList.size() > 0) {
				// 查询跟进
				for (String queryTable : queryTables) {
					List<Integer> currentTrackIdsList = trackIdAndTableDtos.stream()
							.filter(it -> queryTable.equals(it.getQueryTable())).map(TrackIdAndTableDto::getTrackId).collect(Collectors.toList());
					List<ErpFunTrackDto> currentErpFunTrackDtos = erpFunTrackMapper.getErpFunTrackDtoList(operator.getCityId(), currentTrackIdsList, trackTypeList, queryTable);
					erpFunTrackDtos.addAll(currentErpFunTrackDtos);
				}

				List<Integer> makeLookIdList = erpFunTrackDtos.stream()
						.filter(trackDto -> trackDto.getMakeLookId() != null).map(ErpFunTrackDto::getMakeLookId).collect(Collectors.toList());
				List<ErpMakeLookHouse> makeLookHouseList = null;
				if (!makeLookIdList.isEmpty()) {
					ErpMakeLookHouseExample makeLookHouseExample = new ErpMakeLookHouseExample();
					makeLookHouseExample.setShardCityId(cityId);
					makeLookHouseExample.createCriteria().andIdIn(makeLookIdList);
					makeLookHouseList = erpMakeLookHouseMapper.selectByExample(makeLookHouseExample);
					makeLookMap = makeLookHouseList.stream().collect(Collectors.toMap(ErpMakeLookHouse::getId, val -> val));
				}
			}
			Map<Integer, ErpFunStickTrack> erpFunStickTrackMap = resList.stream().collect(HashMap::new, (m,p) -> m.put(p.getTrackId(), p), HashMap::putAll);
			// 房基地的钥匙凭证处理
			List<Integer> keyTrackIdList = erpFunTrackDtos.stream().filter(val -> Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(val.getTrackType())).collect(Collectors.mapping(ErpFunTrackDto::getTrackId, Collectors.toList()));
			if (adminFunCompService.judgerIsFangjidi(operator.getAdminCompId())) {
				if (!keyTrackIdList.isEmpty()) {
					dealkeyVoucher(erpFunTrackDtos, keyTrackIdList);
				}
			}
			for (ErpFunTrackDto erpFunTrackDto : erpFunTrackDtos) {
				ErpFunStickTrack erpFunStickTrack = erpFunStickTrackMap.get(erpFunTrackDto.getTrackId());
				if(null != erpFunStickTrack) {
					erpFunTrackDto.setTrackStickTime(erpFunStickTrack.getCreateTime());
					erpFunTrackDto.setIsHisTrack(erpFunStickTrack.getIsHisTrack());
				}
				if (makeLookMap!=null) {
					ErpMakeLookHouse makeHouse = makeLookMap.get(erpFunTrackDto.getMakeLookId());
					if (makeHouse!=null) {
						if (Byte.valueOf("1").equals(makeHouse.getLookType())) {
							erpFunTrackDto.setMakeLookId(null);
						} else {
							if (Byte.valueOf("0").equals(makeHouse.getIsAudit()) && !operator.getUserId().equals(makeHouse.getUserId())) {
								erpFunTrackDto.setMakeLookId(null);
							}
						}
						erpFunTrackDto.setTargetTime(makeHouse.getLookTime());
						String ids = makeHouse.getHouseIds();
						if (StringUtil.isNotEmpty(ids)) {
							String idArr[] = ids.split(",");
							List<Integer> houseIds = new ArrayList<>();
							for (String id : idArr) {
								houseIds.add(Integer.parseInt(id));
							}
							List<ErpFunTrackDto.MkHouseInfo> mkHouseInfos = new ArrayList<>(houseIds.size());
							if (erpFunTrackDto.getCaseType() == Const.DIC_CASE_TYPE_BUY_CUST.byteValue()) {
								List<ErpFunSale> houseByIds = erpFunSaleMapper.getHouseByIds(operator.getCityId(), houseIds);
								for (ErpFunSale houseById : houseByIds) {
									ErpFunTrackDto.MkHouseInfo mkHouseInfo = new ErpFunTrackDto.MkHouseInfo();
									mkHouseInfo.setArea(houseById.getSaleArea());
									mkHouseInfo.setBuildName(houseById.getBuildName());
									mkHouseInfo.setHall(houseById.getSaleHall());
									mkHouseInfo.setPrice(houseById.getSaleTotalPrice());
									mkHouseInfo.setRoom(houseById.getSaleRoom());
									mkHouseInfo.setUsage(houseById.getSaleUseage());
									if (makeHouse.getLookType() == 1) {
										mkHouseInfo.setCooperateCaseId(houseById.getSaleId());
									} else {
										mkHouseInfo.setCaseId(houseById.getSaleId());
									}
									mkHouseInfos.add(mkHouseInfo);
								}
								if (makeHouse.getLookType() == 1) {
									this.setCooperateInfo(mkHouseInfos, houseByIds, null);
								}
							} else {
								List<ErpFunLease> houseByIds = erpFunLeaseMapper.getHouseByIds(operator.getCityId(), houseIds);
								for (ErpFunLease houseById : houseByIds) {
									ErpFunTrackDto.MkHouseInfo mkHouseInfo = new ErpFunTrackDto.MkHouseInfo();
									mkHouseInfo.setArea(houseById.getLeaseArea());
									mkHouseInfo.setBuildName(houseById.getBuildName());
									mkHouseInfo.setHall(houseById.getLeaseHall());
									mkHouseInfo.setPrice(houseById.getLeaseTotalPrice());
									mkHouseInfo.setRoom(houseById.getLeaseRoom());
									mkHouseInfo.setUsage(houseById.getLeaseUseage());
									if (makeHouse.getLookType() == 1) {
										mkHouseInfo.setCooperateCaseId(houseById.getLeaseId());
									} else {
										mkHouseInfo.setCaseId(houseById.getLeaseId());
									}
									mkHouseInfos.add(mkHouseInfo);
								}
								if (makeHouse.getLookType() == 1) {
									this.setCooperateInfo(mkHouseInfos, null, houseByIds);
								}
							}
							erpFunTrackDto.setMkLookHouses(mkHouseInfos);
						}
					}
				}
				// 设置租售标记
				if (isSaleLeaseHouse) {
					// 除去不需要的跟进类型
					if (!Const.SHOW_SALE_LEASE_TYPE_SET.contains(erpFunTrackDto.getTrackType())) {
						if (caseId.equals(erpFunTrackDto.getCaseId())) {
							if (caseType == Const.HouseCustType.SALE) {
								erpFunTrackDto.setSaleLeaseType(Const.HouseCustType.SALE);
		            		} else if (caseType == Const.HouseCustType.LEASE) {
		            			erpFunTrackDto.setSaleLeaseType(Const.HouseCustType.LEASE);
		            		}
			            } else {
			            	if (caseType == Const.HouseCustType.SALE) {
			            		erpFunTrackDto.setSaleLeaseType(Const.HouseCustType.LEASE);
		            		} else if (caseType == Const.HouseCustType.LEASE) {
		            			erpFunTrackDto.setSaleLeaseType(Const.HouseCustType.SALE);
		            		}
			            }
					}
				}
			}
		}

		addProperties(cityId, compId, caseId, caseType, erpFunTrackDtos, operator.isPersonalVersion());

		SortUtil.collectionsSortTrackList(erpFunTrackDtos);
		this.setCooperateInfo(erpFunTrackDtos, caseType);
		return ErpResponseJson.ok(erpFunTrackDtos);
	}
	
	/**
	 * 处理钥匙凭证
	 * @param trackVoList
	 */
	private void dealkeyVoucher(List<ErpFunTrackDto> trackVoList, List<Integer> keyTrackIdList) {
		ErpFunKeyExample erpFunKeyExample = new ErpFunKeyExample();
		erpFunKeyExample.setShardCityId(getOperator().getCityId());
		erpFunKeyExample.createCriteria().andTrackIdIn(keyTrackIdList);
		List<ErpFunKey> erpFunKeyList = erpFunKeyMapper.selectByExample(erpFunKeyExample);
		Map<Integer, String> keyVoucherMap = erpFunKeyList.stream().filter(val -> StringUtil.isNotBlank(val.getKeyVoucher())).collect(Collectors.toMap(ErpFunKey :: getTrackId, val -> val.getKeyVoucher(), (oldVal, newVal) -> oldVal));
		if (null != keyVoucherMap) {
			trackVoList.stream().forEach(a -> {
				if (Const.DIC_TRACK_TYPE_SUBMIT_KEY.equals(a.getTrackType()) && null != keyVoucherMap.get(a.getTrackId())) {
					a.setHasKeyVoucher(Byte.valueOf("1"));
				}
			});
		}
	}

	/**
	 * 房勘填充字段
	 * @author lcb
	 * @date 2018/6/20
	 * @return
	 */
	private List<ErpFunTrackDto> addProperties(Integer cityId, Integer compId, Integer caseId, Byte caseType, List<ErpFunTrackDto> erpFunTrackDtos, Boolean isPersonalVersion) {

		Integer userId = null;
		String delTrackcontent = "该房源跟进已被管理员删除";
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)){
			delTrackcontent = "该房源跟进已被管理员删除";
			ErpFunSale funSaleBySaleId = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			if(null != funSaleBySaleId){
				userId = funSaleBySaleId.getUserId();
			}
		} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)){
			delTrackcontent = "该房源跟进已被管理员删除";
			ErpFunLease funLeaseByLeaseId = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			if(null != funLeaseByLeaseId){
				userId = funLeaseByLeaseId.getUserId();
			}
		} else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST_BYTE.equals(caseType)){
			delTrackcontent = "该客源跟进已被管理员删除";
			ErpFunBuyCustomer funBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(cityId, caseId);
			if(null != funBuyCustomer){
				userId = funBuyCustomer.getUserId();
			}
		} else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST_BYTE.equals(caseType)){
			delTrackcontent = "该客源跟进已被管理员删除";
			ErpFunRentCustomer funRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(cityId, caseId);
			if(null != funRentCustomer){
				userId = funRentCustomer.getUserId();
			}
		}
		List<Integer> trackIdList = new ArrayList<>(erpFunTrackDtos.size());
		if(erpFunTrackDtos.size() > 0 && !isPersonalVersion){
			trackIdList = erpFunTrackDtos.stream().collect(Collectors.mapping(val->val.getTrackId(), Collectors.toList()));

			ErpFunTrackExtendExample extendExample = new ErpFunTrackExtendExample();
			extendExample.setShardCityId(cityId);
			extendExample.createCriteria().andTrackIdIn(trackIdList);
			List<ErpFunTrackExtend> erpFunTrackExtends = erpFunTrackExtendMapper.selectByExample(extendExample);

			Map<Integer, ErpFunTrackExtend> trackExtendMap = new HashMap<>(erpFunTrackExtends.size());

			if(erpFunTrackExtends.size() > 0) {
				trackExtendMap = erpFunTrackExtends.stream().collect(HashMap::new, (m,p) -> m.put(p.getTrackId(), p), HashMap::putAll);
			}
			for(ErpFunTrackDto funTrackDto : erpFunTrackDtos){
				funTrackDto.setProxyUrl(StringUtils.isBlank(funTrackDto.getProxyUrl())?"0":"1");
				if(null != trackExtendMap){
					ErpFunTrackExtend erpFunTrackExtend = trackExtendMap.get(funTrackDto.getTrackId());
					if(null != erpFunTrackExtend){
						funTrackDto.setFitmentDescribe(erpFunTrackExtend.getFitmentDescribe());
						funTrackDto.setCoreSellPoint(erpFunTrackExtend.getCoreSellPoint());
						funTrackDto.setLayoutIntroduce(erpFunTrackExtend.getLayoutIntroduce());
						funTrackDto.setPropertyRights(erpFunTrackExtend.getPropertyRights());
						funTrackDto.setOtherInfo(erpFunTrackExtend.getOtherInfo());
					}
				}
			}
		}
		if(erpFunTrackDtos.size() == 0 || isPersonalVersion){
			return erpFunTrackDtos;
		}

		boolean isSelfInfo = getOperator().getUserId().equals(userId);
		//是否明文显示电话--目前租售房源还没分开，只分了房源客源， 考虑后期可能要分开
		boolean saleShowPhone = false;
		boolean buyShowPhone = false;
		// 只分房客源，没分租售，暂时这样
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)){
			saleShowPhone = showAllOwnerPhoneInfo(cityId, compId, Constants_DIC.DIC_CASE_TYPE_SALE_FUN, isSelfInfo, isPersonalVersion);
			//leaseShowPhone = userOpersService.showAllOwnerPhoneInfo(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN, isSelfInfo);
		}else if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)){
			buyShowPhone = showAllOwnerPhoneInfo(cityId, compId, Constants_DIC.DIC_CASE_TYPE_BUY_CUST, isSelfInfo, isPersonalVersion);
			//rentShowPhone = userOpersService.showAllOwnerPhoneInfo(Constants_DIC.DIC_CASE_TYPE_RENT_CUST, isSelfInfo);
		}
		// 当前用户，同一房源，同一类型  只需要查询一次是否查看过就行了，提出来  zhl
		boolean detected = getCacheViewId(cityId, compId, caseId, caseType, getOperator().getUserId());//今天查看过核心信息才显示

		Set<Integer> creatorUidList = erpFunTrackDtos.stream().collect(Collectors.mapping(val->val.getCreatorUid(), Collectors.toSet()));

		// 查询跟进人列表
		Map<Integer, String> userNameMap = userNameList(cityId, creatorUidList);

		for (ErpFunTrackDto erpFunTrackDto : erpFunTrackDtos) {
			boolean isShowPhone = false;
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)){
				isShowPhone = saleShowPhone;
				//isShowPhone = (saleShowPhone || leaseShowPhone);
			}else if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)){
				isShowPhone = buyShowPhone;
				//isShowPhone = (buyShowPhone || rentShowPhone);
			}
			//加盟圈总经理可以随意查看其他加盟公司的核心数据,不是本公司的肯定是加盟圈模式，需要判断权限
			if(erpFunTrackDto.getCompId().equals(getOperator().getCompId())){// 跟进是本公司并且是总经理，才无需判断当天是否查看
				if (Const.DIC_TRACK_TYPE_EDIT.equals(erpFunTrackDto.getTrackType())) {// 检测当天记录是否有权限查看核心信息，如果没有。则将核心跟踪信息加密
					if (!detected) {// 没有查看权限加密核心信息
						String encryptedText = convertSecretInfo(erpFunTrackDto.getTrackContent(), erpFunTrackDto.getCaseType(), isShowPhone);
						erpFunTrackDto.setTrackContent(encryptedText);
						erpFunTrackDto.setCanViewCoreChange("1");
					}else if(!isShowPhone){
						//及时已查看了核心信息，如果没有明文查看则还要限制
						String encryptedText = onlyConverOwnerPhone(erpFunTrackDto.getTrackContent(), isShowPhone);
						erpFunTrackDto.setTrackContent(encryptedText);
						erpFunTrackDto.setCanViewCoreChange("2");
					}
				}
			}

			if(null != erpFunTrackDto.getIsDel() && 1 == erpFunTrackDto.getIsDel().intValue()){
				if(getOperator().getUserId().equals(userId) || getOperator().getUserId().equals(erpFunTrackDto.getCreatorUid())){
					erpFunTrackDto.setCanView("1");
				}else{
					String trackConent = erpFunTrackDto.getTrackContent();
					trackConent = buildDelTrackContent(trackConent);
					trackConent += delTrackcontent;
					erpFunTrackDto.setTrackContent(trackConent);
				}
			}
			erpFunTrackDto.setTrackUserName(userNameMap.get(erpFunTrackDto.getCreatorUid()));
		}
		return null;
	}

	/**
	 * 没有明文显示电话权限的不显示业主电话
	 * @author 陈文超
	 * @param trackContent 跟进内容
	 * @return
	 */
	protected static String onlyConverOwnerPhone(String trackContent,boolean phoneShow) {
		String result = "";
		String [] contents = StringHelper.split(trackContent, "\n");
		if(contents.length <= 0){
			result = trackContent;
		}
		for(int j=0; j<contents.length; j++) {
			String [] items = StringHelper.split(contents[j], ":");
			if (items.length > 0) {
				if (!phoneShow && items[0].contains("电话") && contents[j].indexOf(">>") >= 0) {
					contents[j] = "电话: *** >> ***";
				}
			}
		}
		for (int i = 0; i < contents.length; i++) {
			result += contents[i] + "\n";
		}
		return result;
	}

	/**
	 * 核心信息转换
	 * @author lcb
	 * @date 2018/6/20
	 * @return
	 */

	public static String convertSecretInfo(String trackContent, Byte caseType, boolean phoneShow) {
		String result = "";
		String [] contents = StringHelper.split(trackContent, "\n");
		if(contents.length <= 0){
			result = trackContent;
		}
		Set<String> decodeFieldsSet = new HashSet<>();
		String[] decodeFieldsCN = TBDefinetionUtil.getSecretFields();
		for(int i=0; i < decodeFieldsCN.length; i++){
			String enCodeField = decodeFieldsCN[i];//需要加密的字段
			if("楼".equals(enCodeField)&&
					(Constants_DIC.DIC_CASE_TYPE_BUY_CUST_BYTE.equals(caseType) || Constants_DIC.DIC_CASE_TYPE_RENT_CUST_BYTE.equals(caseType))){
				//客源数据楼不属于加密范围
				continue;
			}
			for(int j=0; j<contents.length; j++) {
				String [] items = StringHelper.split(contents[j], ":");
				if (items.length > 0) {
					if(items[0].contains("核验编号")||items[0].contains("权证编号")||items[0].contains("产权证号")){
						continue;
					}
					if ((items[0].contains(enCodeField) && contents[j].indexOf(">>") >= 0)
							|| (!phoneShow && items[0].contains("电话") && contents[j].indexOf(">>") >= 0)) {
						if(!decodeFieldsSet.contains(items[0])) {
							contents[j] = enCodeField + ": *** >> ***";
							decodeFieldsSet.add(enCodeField);
						}
					}
				}
			}
		}
		for (int i = 0; i < contents.length; i++) {
			result += contents[i] + "\n";
		}
		return result;
	}

	private String buildDelTrackContent(String trackContent){
		int startIndex = trackContent.lastIndexOf("跟进内容：");
		if(startIndex!=-1){
			trackContent = trackContent.substring(0, startIndex+"跟进内容：".length());
		}else{
			startIndex = trackContent.lastIndexOf("查看原因：");
			if(startIndex!=-1){
				trackContent = trackContent.substring(0, startIndex+"查看原因：".length());
			}
		}
		return trackContent;
	}

	/**
	 * 员工相关
	 * @author lcb
	 * @date 2018/6/20
	 * @return
	 */
	private Map<Integer, String> userNameList(Integer cityId, Set<Integer> userIds) {
		Map<Integer, String> userNameMap = new HashMap<>(userIds.size());
		List<ErpFunUsers> userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userIds);
		if (userListByUserIds.size() > 0) {
			userNameMap = userListByUserIds.stream().collect(Collectors.toMap(val->val.getUserId(), val->val.getUserName()));
		}

		return userNameMap;
	}

	private Boolean getCacheViewId(Integer cityId, Integer compId, Integer caseId, Byte caseType ,Integer viewUserId) {
		Boolean viewId = getCacheResultForQueryCoreInfo(cityId, compId, caseId, caseType, viewUserId);
		if(!viewId) {
			// 判断租售数据
			if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE.equals(caseType)) { // 出售
				ErpFunSale baseInfoFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
				if(null != baseInfoFunSale.getIsSaleLease() && 1 == baseInfoFunSale.getIsSaleLease().byteValue() && null != baseInfoFunSale.getSaleLeaseId()) {
					viewId = getCacheResultForQueryCoreInfo(cityId, compId, baseInfoFunSale.getSaleLeaseId(), Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE, viewUserId);
				}
			}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN_BYTE.equals(caseType)) { // 出租
				ErpFunLease baseInfoFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
				if(null != baseInfoFunLease.getIsSaleLease() && 1 == baseInfoFunLease.getIsSaleLease().byteValue() && null != baseInfoFunLease.getSaleLeaseId()) {
					viewId = getCacheResultForQueryCoreInfo(cityId, compId, baseInfoFunLease.getSaleLeaseId(), Constants_DIC.DIC_CASE_TYPE_SALE_FUN_BYTE, viewUserId);
				}
			}
		}
		return viewId;
	}

	private Boolean getCacheResultForQueryCoreInfo(Integer cityId, Integer compId, Integer caseId, Byte caseType, Integer viewUserId) {
		ErpFunViewLogExample example = new ErpFunViewLogExample();
		example.setShardCityId(cityId);
		ErpFunViewLogExample.Criteria criteria = example.createCriteria();

		criteria.andTargetTypeEqualTo(caseType).andTargetIdEqualTo(caseId).andViewUserEqualTo(viewUserId).andCompIdEqualTo(compId);
		criteria.andViewTimeBetween(DateUtil.formatDateTimetoString(new Date(),"yyyy-MM-dd 00:00:00"), DateUtil.formatDateTimetoString(new Date(),"yyyy-MM-dd 23:59:59"));
		example.setOrderByClause(" VIEW_ID DESC ");
		PageHelper.startPage(1, 1, false);
		List<ErpFunViewLog> viewLogList = erpFunViewLogMapper.selectByExample(example);
		return viewLogList.size() > 0;
	}

	/**
	 * 是否明文显示业主的手机号
	 * true:显示业主手机号(关闭隐号拨打)
	 * false:不显示业主手机号(开启隐号拨打)
	 * @throws Exception
	 */
	public boolean showAllOwnerPhoneInfo(Integer cityId, Integer compId, String caseType, boolean isSelfInfo, Boolean ispersonalVersion) {
		//纯精英版默认直接显示业主手机号 陈文超
		if(ispersonalVersion){
			return true;
		}
		Map<String, ErpSysPara> sysParaMap = new HashMap<>(2);
		// 这个系统参数控制此公司是否使用权限控制
		List<ErpSysPara> erpSysParas = erpSysParaService.getMLSysParamList(cityId, compId, getOperator().getUserId(), Arrays.asList(new String[]{"IS_OPEN_HIDEPHONE","IS_OPEN_HIDE_SELF_PHONE"}));
		if (erpSysParas.size() > 0) {
			sysParaMap = erpSysParas.stream().collect(Collectors.toMap(val->val.getParamId(), val->val));
		}
		boolean haveShowPhone = false;
		//2016-01-21改版之前是用权限控制的---2016-05-17又要这个权限来控制了zhl
		// 如果租售分开控制了，请一定要改调用这个的地方！
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			haveShowPhone = judgePermission(cityId, getOperator().getUserId(), "HOUSE_VOIP_SHOW_PHONE");
		}else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType) ||Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			haveShowPhone = judgePermission(cityId, getOperator().getUserId(), "CUSTOMER_VOIP_SHOW_PHONE");
		}
		// 如果有权限看明文直接返回，否则判断是否开启隐号模式
		if(haveShowPhone){
			return true;
		}
		// 判断隐号拨打模式--开启则不能明文显示
		ErpSysPara isOpenHiddenPhone = sysParaMap.get("IS_OPEN_HIDEPHONE");
		if(isOpenHiddenPhone != null && Constants_DIC.IS_OPEN_HIDEPHONE_1.equals(isOpenHiddenPhone.getParamValue())){//隐号拨打
			if(getOperator().isGeneralManager()) {
				return true;// 隐号拨打时总经理账号可看明文电话
			}
			ErpSysPara isOpenHiddenOwnerPhone = sysParaMap.get("IS_OPEN_HIDE_SELF_PHONE");
			if(isOpenHiddenOwnerPhone != null && isSelfInfo
					&& !Constants_DIC.IS_OPEN_HIDE_SELF_PHONE_1.equals(isOpenHiddenOwnerPhone.getParamValue())
					){
				return true;// 参数：个人不是隐号，而且数据是自己的则直接返回明文号码
			}
			return false;
		} else {
			return true;
		}
	}

	private Boolean judgePermission(Integer cityId, Integer userId, String operId) {
		ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, operId);
		return erpUserOpers != null;
	}


	/**
	 * 跟进分类
	 * @author lcb
	 * @date 2018/6/20
	 * @return
	 */
	private List<Byte> getTrackType(Integer filterType) {
		List<Byte> trackTypeList = new ArrayList<>();
		//型1分佣人员 2=业务跟进,3=系统日志 4=修改日志,5= 普通跟进,6=钥匙管理
		//新需求 1=业务跟进,2=状态日志,3=电话查看
		if(null != filterType) {
			switch (filterType) {
			case 1:
				trackTypeList.add(Const.DIC_TRACK_TYPE_REGISTER);//信息登记
				trackTypeList.add(Const.DIC_TRACK_TYPE_REG_HOUSE);//房源登记
				trackTypeList.add(Const.DIC_TRACK_TYPE_DAIKAN);  //带看
				trackTypeList.add(Const.DIC_TRACK_TYPE_FUNCAN); //房勘
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_SPECIAL );//封盘
				trackTypeList.add(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD);//级别-加密
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL);//内成交
				trackTypeList.add(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND);//级别-推荐
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_OUTDEAL);//外成交
				trackTypeList.add(Const.DIC_TRACK_TYPE_LIMITED);//限时
				trackTypeList.add(Const.DIC_TRACK_TYPE_ALONE);//独家
				trackTypeList.add(Const.DIC_TRACK_TYPE_RENT );//包租
				trackTypeList.add(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT );//普通委托
				trackTypeList.add(Const.DIC_TRACK_TYPE_BARGAIN );//议价
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_SCHEDULE );//预定
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_RESPITE );//暂缓
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_WRITEOFF  );//注销
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_INVALID  );//无效
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_TRANSSALE  );//转售
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_TRANSPRIVATE  );//转私盘
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE  );//转有效
				trackTypeList.add(Const.DIC_TRACK_TYPE_KONGKAN );//空看
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_TRANSLEASE );//转租
				trackTypeList.add(Const.DIC_TRACK_TYPE_OTHER);//其他
				trackTypeList.add(Const.DIC_TRACK_TYPE_SUBMIT_KEY);//钥匙提交
				trackTypeList.add(Const.DIC_TRACK_TYPE_BORROW_KEY);//借用钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_KEYPASSWORD);//查看密码钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_SUBMIT_PASSWORD_KEY);//提交密码钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_EDIT_PASSWORD_KEY);//密码钥匙信息修改
				trackTypeList.add(Const.DIC_TRACK_TYPE_RETURN_KEY);//归还钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_DESTROY_KEY);//钥匙注销
				trackTypeList.add(Const.DIC_TRACK_TYPE_KEY_EXPLAIN);//钥匙说明
				trackTypeList.add(Const.DIC_TRACK_TYPE_CANCEL_WEITUO);//取消委托
				trackTypeList.add(Const.DIC_TRACK_TYPE_DAIL_PHONE_COMMON);//去电
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_AVAILABLE);//转普通
				trackTypeList.add(Const.DIC_TRACK_TYPE_TALK);// 面谈
				trackTypeList.add(Const.DIC_TRACK_TYPE_YUE_KAN);// 约看
				trackTypeList.add(Const.DIC_TRACK_TYPE_RETURN_VISIT);// 回访
				trackTypeList.add(Const.DIC_TRACK_TYPE_CANCEL_SCHEDULE);// 取消预订
				trackTypeList.add(Const.DIC_TRACK_TYPE_CANCEL_SPECIAL);// 取消封盘
				trackTypeList.add(Const.DIC_TRACK_TYPE_CANCEL_RESPITE);// 取消暂缓
				trackTypeList.add(Const.DIC_TRACK_TYPE_CANCEL_PASSWORD);// 取消加密
				trackTypeList.add(Const.DIC_TRACK_TYPE_CANCEL_COMMEND);// 取消推荐
				trackTypeList.add(Const.DIC_TRACK_TYPE_HEZUODAI_KAN);//合作带看
				trackTypeList.add(Const.DIC_TRACK_TYPE_KEY_BORROW_OUT); // (物业版)外借钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_PROPERTY_RETURN_KEY); // (物业版)外借钥匙归还
				trackTypeList.add(Const.DIC_TRACK_TYPE_BORROW_TIME_OUT); // (物业版)外借超时
				trackTypeList.add(Const.DIC_TRACK_TYPE_EDIT_HOUSE_AREA); // 修改面积
				trackTypeList.add(Const.DIC_TRACK_TYPE_ENTRUST_RECORD_ADD); // 委托备案
				trackTypeList.add(Const.DIC_TRACK_TYPE_ENTRUST_RECORD_UPDATE); // 修改备案
				trackTypeList.add(Const.DIC_TRACK_TYPE_ENTRUST_RECORD_DEL); // 清空备案

				//段成伟添加
				trackTypeList.add(Const.DIC_TRACK_TYPE_REPAEAT_REMIND);//重盘提醒
				//定金
				trackTypeList.add(Const.DIC_TRACK_TYPE_COLLECT_DEPOSIT);//收定
				break;
			case 2:
				trackTypeList.add(Const.DIC_TRACK_TYPE_UPDATE_HOUSE_BUILD);//修改房源所属楼盘
				trackTypeList.add(Const.DIC_TRACK_TYPE_VR_UPLOAD);//上传VR
				trackTypeList.add(Const.DIC_TRACK_TYPE_VR_DELETE);//删除VR
				trackTypeList.add(Const.DIC_TRACK_TYPE_SYSTEM);//系统
				trackTypeList.add(Const.DIC_TRACK_TYPE_PHOTO_UPLOAD);//上传图片
				trackTypeList.add(Const.DIC_TRACK_TYPE_PHOTO_DELETE);//删除图片
				trackTypeList.add(Const.DIC_TRACK_TYPE_PHOTO_EDIT);//图片编辑
				trackTypeList.add(Const.DIC_TRACK_TYPE_PHOTO_TOP);//设置首图
				trackTypeList.add(Const.DIC_TRACK_TYPE_PHOTO_IMPORT);//图片导入
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIDEO_UPLOAD);//上传视频
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIDEO_DELETE);//删除视频
				trackTypeList.add(Const.DIC_TRACK_TYPE_JUMP_PUBLIC);//跳抢盘
				trackTypeList.add(Const.DIC_TRACK_TYPE_JUMP_SHARE);//跳公盘
				trackTypeList.add(Const.DIC_TRACK_TYPE_RELATIVE_PEOPLE_CHANGE);//房源相关人变更
				trackTypeList.add(Const.DIC_TRACK_TYPE_EDIT);//修改
				trackTypeList.add(Const.DIC_TRACK_TYPE_CASE_TRANSFER);//数据移交
				trackTypeList.add(Const.DIC_TRACK_TYPE_PRIVATE_TRANSFER);//私盘数据移交
//				trackTypeList.add(Const.DIC_TRACK_TYPE_REPAEAT_REMIND);//重盘提醒
				
				//段成伟添加
				trackTypeList.add(Const.DIC_TRACK_TYPE_LIMITED);//限时
				trackTypeList.add(Const.DIC_TRACK_TYPE_ALONE);//独家
				trackTypeList.add(Const.DIC_TRACK_TYPE_RENT );//包租
				trackTypeList.add(Const.DIC_TRACK_TYPE_GENERAL_ENTRUSTMENT );//普通委托
				
				trackTypeList.add(Const.DIC_TRACK_TYPE_CANCEL_WEITUO);//取消委托
				trackTypeList.add(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_COMMEND);//推荐
				trackTypeList.add(Const.DIC_TRACK_TYPE_HOUSE_LEVEL_PASSWORD);//级别-加密
				trackTypeList.add(Const.DIC_TRACK_TYPE_BARGAIN );//议价
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_INNERDEAL);//内成交
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_OUTDEAL);//外成交
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_SCHEDULE );//预定
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_RESPITE );//暂缓
				trackTypeList.add(Const.DIC_TRACK_TYPE_STATUS_TRANSAVAILABLE  );//转有效
				trackTypeList.add(Const.DIC_TRACK_TYPE_DAIKAN);  //带看
				trackTypeList.add(Const.DIC_TRACK_TYPE_SUBMIT_KEY);//钥匙提交
				trackTypeList.add(Const.DIC_TRACK_TYPE_BORROW_KEY);//借用钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_KEYPASSWORD);//查看密码钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_SUBMIT_PASSWORD_KEY);//提交密码钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_EDIT_PASSWORD_KEY);//密码钥匙信息修改
				trackTypeList.add(Const.DIC_TRACK_TYPE_RETURN_KEY);//归还钥匙
				trackTypeList.add(Const.DIC_TRACK_TYPE_DESTROY_KEY);//钥匙注销
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE);//查看电话
				trackTypeList.add(Const.DIC_TRACK_TYPE_YUE_KAN);//约看
				trackTypeList.add(Const.DIC_TRACK_TYPE_FUNCAN); //房勘
				//定金
				trackTypeList.add(Const.DIC_TRACK_TYPE_COLLECT_DEPOSIT);//收定
				break;
			case 3:
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_SCHEDULE);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_SPECIAL);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_RESPITE);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_INNERDEAL);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_OUTDEAL);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_AVAILABLE);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_ALONE);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_LIMITED);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_RENT);
				trackTypeList.add(Const.DIC_TRACK_TYPE_VIEW_PHONE_ENTRUST_COMMON);
				break;
			default:
				break;
			}
		}
		return trackTypeList;
	}

	/**
	 * 设置/取消跟进置顶
	 * @author lcb
	 * @date 2018/6/7
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStickTrack")
	public ResponseJson updateStickTrack(@Valid @RequestBody BaseMapParam param) throws Exception {
		Integer trackId = param.getInteger("trackId");
		// 0 取消置顶， 1：新增置顶
		Integer opType = param.getInteger("opType");
		// 1 历史跟进， 0：正常跟进
		Byte isHisTrack = param.getByte("isHisTrack");
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Assert.isNullThrow(trackId,"参数错误！");

		// 该跟进创建时间
		String creationTime = param.getString("creationTime");

		// 当前月查 FUN_TRACK 表
		boolean isThisMonth = false;
		try {
			isThisMonth = DateUtil.isThisMonth(new SimpleDateFormat("yyyy-MM-dd").parse(creationTime).getTime());
		} catch (Exception pe) {
			System.out.println(pe.getMessage());
		}

		String queryTable;
		if (isThisMonth) {
			queryTable = "FUN_TRACK";
		} else {
			// 查询 2013-01-01 之前的数据, 默认查询历史数据
			try {
				if (org.apache.commons.lang.StringUtils.isNotBlank(creationTime)
						&& new SimpleDateFormat("yyyy-MM-dd").parse(creationTime)
						.before(DateUtil.StringToDate(DateTimeHelper.formatDateTimetoString("2013-01-01", "yyyy-MM-dd")))) {
					isHisTrack = 1;
				}
			} catch (Exception pe) {
				System.out.println(pe.getMessage());
			}

			queryTable = "FUN_TRACK" + DateUtil.getTimeList(creationTime, creationTime).get(0);
		}

		Integer caseId = null;
		Byte caseType = null;
		String trackCreationTime = null;

		if(null == isHisTrack || 0 == isHisTrack) {
			ErpFunTrack erpFunTrack = erpFunTrackMapper.getTrackByIdAndTable(cityId, compId, trackId, queryTable);
			if(null == erpFunTrack) {
				throw new BusinessException("所选跟进不存在！");
			}

			caseId = erpFunTrack.getCaseId();
			caseType = erpFunTrack.getCaseType();
			trackCreationTime = erpFunTrack.getCreationTime();
		}else {
			ErpFunTrackHis erpFunTrackHis = new ErpFunTrackHis();
			erpFunTrackHis.setShardCityId(cityId);
			erpFunTrackHis.setTrackId(trackId);
			erpFunTrackHis = erpFunTrackHisMapper.selectByPrimaryKey(erpFunTrackHis);
			if(null == erpFunTrackHis) {
				throw new BusinessException("所选跟进不存在！");
			}
			caseId = erpFunTrackHis.getCaseId();
			caseType = erpFunTrackHis.getCaseType();
			trackCreationTime = erpFunTrackHis.getCreationTime();
		}

		// 判断此跟进是否有置顶记录
		ErpFunStickTrackExample stickTrackExample = new ErpFunStickTrackExample();
		stickTrackExample.setShardCityId(operator.getCityId());
		stickTrackExample.createCriteria().andTrackIdEqualTo(trackId).andCompIdEqualTo(operator.getCompId());
		List<ErpFunStickTrack> resList = erpFunStickTrackMapper.selectByExample(stickTrackExample);

		ErpFunStickTrack updateStickTrack = new ErpFunStickTrack();
		updateStickTrack.setTopStatus((byte) 1);
		updateStickTrack.setShardCityId(operator.getCityId());
		updateStickTrack.setCreateTime(new Date());

		if(resList.size() > 0) {
			ErpFunStickTrack erpFunStickTrack = resList.get(0);
			if(null != opType && 0 == opType) {
				// 取消置顶
				updateStickTrack.setId(erpFunStickTrack.getId());
				updateStickTrack.setTopStatus((byte) 0);
			}else {
				if(countStickTrack(cityId, compId, caseId, caseType, erpFunStickTrack.getId())) {
					// 更新置顶
					updateStickTrack.setId(erpFunStickTrack.getId());
				}else {
					throw new BusinessException("跟进置顶条数不能超过5条");
				}
			}
			updateStickTrack.setTrackCreateTime(DateUtil.StringToDate(trackCreationTime, "yyyy-MM-dd HH:mm"));
			erpFunStickTrackMapper.updateByPrimaryKeySelective(updateStickTrack);
		}else {
			if(!countStickTrack(cityId, compId, caseId, caseType, null)) {
				throw new BusinessException("跟进置顶条数不能超过5条");
			}
			// 新增置顶
			updateStickTrack.setCaseId(caseId);
			updateStickTrack.setCaseType(caseType);
			updateStickTrack.setCompId(operator.getCompId());
			updateStickTrack.setDeptId(operator.getDeptId());
			updateStickTrack.setTrackId(trackId);
			updateStickTrack.setUserId(operator.getUserId());
			updateStickTrack.setIsHisTrack(isHisTrack);
			updateStickTrack.setTrackCreateTime(DateUtil.StringToDate(trackCreationTime, "yyyy-MM-dd HH:mm"));
			erpFunStickTrackMapper.insertSelective(updateStickTrack);
		}
		return ErpResponseJson.ok();
	}

	private Boolean countStickTrack(Integer cityId, Integer compId, Integer caseId, Byte caseType, Integer stickId) {
		List<Integer> caseIds = new ArrayList<>();
		caseIds.add(caseId);
		// 判断是否是租售房源
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType + "")) {
			ErpFunSale funSaleBySaleId = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
			Byte isSaleLease = funSaleBySaleId.getIsSaleLease();
			Integer saleLeaseId = funSaleBySaleId.getSaleLeaseId();
			if (null != isSaleLease && 1 == isSaleLease.intValue() && null != saleLeaseId) {
				caseIds.add(saleLeaseId);
			}
		}else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType + "")) {
			ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
			Byte isSaleLease = erpFunLease.getIsSaleLease();
			Integer saleLeaseId = erpFunLease.getSaleLeaseId();
			if (null != isSaleLease && 1 == isSaleLease.intValue() && null != saleLeaseId) {
				caseIds.add(saleLeaseId);
			}
		}

		ErpFunStickTrackExample example = new ErpFunStickTrackExample();
		example.setShardCityId(cityId);
		ErpFunStickTrackExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId).andCaseIdIn(caseIds).andTopStatusEqualTo((byte) 1);
		if(null != stickId) {
			criteria.andIdNotEqualTo(stickId);
		}
		Integer i = erpFunStickTrackMapper.countByExample(example);
		return i < 5;
	}
	
	private void setCooperateInfo(List<ErpFunTrackDto> erpFunTrackDtos, Byte caseType) {
		Operator operator = getOperator();
		List<Integer> cooperateIdList = new ArrayList<>();
		for (ErpFunTrackDto erpFunTrackDto : erpFunTrackDtos) {
			if (Const.DIC_TRACK_TYPE_DAIKAN.equals(erpFunTrackDto.getTrackType()) && erpFunTrackDto.getCooperateTargetId() != null) {
				cooperateIdList.add(erpFunTrackDto.getCooperateTargetId());
			}
		}
		if (!cooperateIdList.isEmpty()) {
			List<Integer> userIdList = new ArrayList<>();
			List<Integer> deptIdList = new ArrayList<>();
			Map<Integer, ErpFunUsers> userMap = new HashMap<>();
			Map<Integer, ErpFunDepts> deptMap = new HashMap<>();
			Map<Integer,Map<String,String>> coopUserDeptMap = new HashMap<Integer, Map<String,String>>();
			List<ErpFunSale> saleList = null;
			List<ErpFunLease> leaseList = null;
			if (Const.HouseCustType.BUY_CUST == caseType) {
				ErpFunSaleExample erpFunSaleExample = new ErpFunSaleExample();
				erpFunSaleExample.setShardCityId(operator.getCityId());
				erpFunSaleExample.createCriteria().andSaleIdIn(cooperateIdList);
				saleList = erpFunSaleMapper.selectByExample(erpFunSaleExample);
				for (ErpFunSale erpFunSale : saleList) {
					if (erpFunSale.getUserId() != null) {
						userIdList.add(erpFunSale.getUserId());
					}
					if (erpFunSale.getDeptId() != null && erpFunSale.getDeptId() > 1000) {
						deptIdList.add(erpFunSale.getDeptId());
					}
				}
			} else if (Const.HouseCustType.RENT_CUST == caseType) {
				ErpFunLeaseExample erpFunLeaseExample = new ErpFunLeaseExample();
				erpFunLeaseExample.setShardCityId(operator.getCityId());
				erpFunLeaseExample.createCriteria().andLeaseIdIn(cooperateIdList);
				leaseList = erpFunLeaseMapper.selectByExample(erpFunLeaseExample);
				for (ErpFunLease erpFunLease : leaseList) {
					if (erpFunLease.getUserId() != null) {
						userIdList.add(erpFunLease.getUserId());
					}
					if (erpFunLease.getDeptId() != null && erpFunLease.getDeptId() > 1000) {
						deptIdList.add(erpFunLease.getDeptId());
					}
				}
			}
			if (!userIdList.isEmpty()) {
				ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
				erpFunUsersExample.setShardCityId(operator.getCityId());
				erpFunUsersExample.createCriteria().andUserIdIn(userIdList);
				List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
				userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
			}
			if (!deptIdList.isEmpty()) {
				ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
				erpFunDeptsExample.setShardCityId(operator.getCityId());
				erpFunDeptsExample.createCriteria().andDeptIdIn(deptIdList);
				List<ErpFunDepts> deptList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
				deptMap = deptList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val));
			}
			if (Const.HouseCustType.BUY_CUST == caseType) {
				for (int i = 0; i < saleList.size(); i++) {
					ErpFunSale erpFunSale = saleList.get(i);
					Integer userId = erpFunSale.getUserId();
					Integer deptId = erpFunSale.getDeptId();
					Map<String, String> userDeptMap = new HashMap<>();
					if (userId != null) {
						userDeptMap.put("userName", userMap.get(userId).getUserName());
					} else {
						userDeptMap.put("userName", "");
					}
					if (deptId != null && deptId > 1000) {
						userDeptMap.put("deptName", deptMap.get(deptId).getDeptName());
					} else {
						userDeptMap.put("deptName", "");
					}
					coopUserDeptMap.put(erpFunSale.getSaleId(), userDeptMap);
				}
			} else if (Const.HouseCustType.RENT_CUST == caseType) {
				for (int i = 0; i < leaseList.size(); i++) {
					ErpFunLease erpFunLease = leaseList.get(i);
					Integer userId = erpFunLease.getUserId();
					Integer deptId = erpFunLease.getDeptId();
					Map<String, String> userDeptMap = new HashMap<>();
					if (userId != null) {
						userDeptMap.put("userName", userMap.get(userId).getUserName());
					} else {
						userDeptMap.put("userName", "");
					}
					if (deptId != null && deptId > 1000) {
						userDeptMap.put("deptName", deptMap.get(deptId).getDeptName());
					} else {
						userDeptMap.put("deptName", "");
					}
					coopUserDeptMap.put(erpFunLease.getLeaseId(), userDeptMap);
				}
			}
			for (ErpFunTrackDto erpFunTrackDto : erpFunTrackDtos) {
				if (Const.DIC_TRACK_TYPE_DAIKAN.equals(erpFunTrackDto.getTrackType()) && erpFunTrackDto.getCooperateTargetId() != null) {
					Map<String, String> userDeptMap = coopUserDeptMap.get(erpFunTrackDto.getCooperateTargetId());
					if (userDeptMap != null) {
						erpFunTrackDto.setCooperateDeptName(userDeptMap.get("deptName"));
						erpFunTrackDto.setCooperateUserName(userDeptMap.get("userName"));
					}
				}
			}
		}
	}

	private void setCooperateInfo(List<ErpFunTrackDto.MkHouseInfo> mkHouseInfos, List<ErpFunSale> saleList, List<ErpFunLease> leaseList) {
		Operator operator = getOperator();
		List<Integer> userIdList = new ArrayList<>();
		List<Integer> deptIdList = new ArrayList<>();
		Map<Integer, ErpFunUsers> userMap = new HashMap<>();
		Map<Integer, ErpFunDepts> deptMap = new HashMap<>();
		Map<Integer,Map<String,String>> coopUserDeptMap = new HashMap<Integer, Map<String,String>>();
		if (saleList != null) {
			for (ErpFunSale erpFunSale : saleList) {
				if (erpFunSale.getUserId() != null) {
					userIdList.add(erpFunSale.getUserId());
				}
				if (erpFunSale.getDeptId() != null && erpFunSale.getDeptId() > 1000) {
					deptIdList.add(erpFunSale.getDeptId());
				}
			}
		} else if (leaseList != null) {
			for (ErpFunLease erpFunLease : leaseList) {
				if (erpFunLease.getUserId() != null) {
					userIdList.add(erpFunLease.getUserId());
				}
				if (erpFunLease.getDeptId() != null && erpFunLease.getDeptId() > 1000) {
					deptIdList.add(erpFunLease.getDeptId());
				}
			}
		}
		if (!userIdList.isEmpty()) {
			ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
			erpFunUsersExample.setShardCityId(operator.getCityId());
			erpFunUsersExample.createCriteria().andUserIdIn(userIdList);
			List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
			userMap = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val -> val));
		}
		if (!deptIdList.isEmpty()) {
			ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
			erpFunDeptsExample.setShardCityId(operator.getCityId());
			erpFunDeptsExample.createCriteria().andDeptIdIn(deptIdList);
			List<ErpFunDepts> deptList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
			deptMap = deptList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val));
		}
		if (saleList != null) {
			for (int i = 0; i < saleList.size(); i++) {
				ErpFunSale erpFunSale = saleList.get(i);
				Integer userId = erpFunSale.getUserId();
				Integer deptId = erpFunSale.getDeptId();
				Map<String, String> userDeptMap = new HashMap<>();
				if (userId != null) {
					userDeptMap.put("userName", userMap.get(userId).getUserName());
				} else {
					userDeptMap.put("userName", "");
				}
				if (deptId != null && deptId > 1000) {
					userDeptMap.put("deptName", deptMap.get(deptId).getDeptName());
				} else {
					userDeptMap.put("deptName", "");
				}
				coopUserDeptMap.put(erpFunSale.getSaleId(), userDeptMap);
			}
		} else if (leaseList != null) {
			for (int i = 0; i < leaseList.size(); i++) {
				ErpFunLease erpFunLease = leaseList.get(i);
				Integer userId = erpFunLease.getUserId();
				Integer deptId = erpFunLease.getDeptId();
				Map<String, String> userDeptMap = new HashMap<>();
				if (userId != null) {
					userDeptMap.put("userName", userMap.get(userId).getUserName());
				} else {
					userDeptMap.put("userName", "");
				}
				if (deptId != null && deptId > 1000) {
					userDeptMap.put("deptName", deptMap.get(deptId).getDeptName());
				} else {
					userDeptMap.put("deptName", "");
				}
				coopUserDeptMap.put(erpFunLease.getLeaseId(), userDeptMap);
			}
		}
		for (ErpFunTrackDto.MkHouseInfo mkHouseInfo : mkHouseInfos) {
			Map<String, String> userDeptMap = coopUserDeptMap.get(mkHouseInfo.getCooperateCaseId());
			if (userDeptMap != null) {
				mkHouseInfo.setCooperateDeptName(userDeptMap.get("deptName"));
				mkHouseInfo.setCooperateUserName(userDeptMap.get("userName"));
			}
		}
	}
	
}
