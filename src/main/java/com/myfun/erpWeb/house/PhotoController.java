package com.myfun.erpWeb.house;

import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.house.param.GetHousePhotoParam;
import com.myfun.erpWeb.house.vo.GetHousePhotoVo;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationManagerMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMlMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dto.ErpFunPhotoDto;
import com.myfun.repository.erpdb.dto.ErpFunUsersDto;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManagerExample;
import com.myfun.repository.erpdb.po.ErpFunPhoto;
import com.myfun.repository.erpdb.po.ErpFunPhotoMl;
import com.myfun.repository.erpdb.po.ErpFunPhotoMlExample;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunPhotoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value="/house",method= RequestMethod.POST)
public class PhotoController extends BaseController{

	@Autowired
	ErpFunPhotoService erpFunPhotoService;
	@Autowired
	ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpFunPhotoMlMapper erpFunPhotoMlMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;

	/**
	 * 获取房源图片列表
	 * @author 臧铁
	 * @param param caseId:房客源ID  caseType:房客源类型  trackId:跟进id
	 * @since 2017年5月17日
	 * @return
	 */
	@ApiOperation("获取房源图片列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetHousePhotoVo.class, message = "成功")
	})
	@ResponseBody
	@NotBlank({"caseId", "caseType"})
	@RequestMapping("/getHousePhoto")
	public ResponseJson getHousePhoto(@Valid @RequestBody GetHousePhotoParam param) {
		Operator operator = getOperator();
		Integer compId = operator.getCompId();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		param.setCityId(cityId);
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		Integer houseCompId = null;
		//判断是否是美联
		if(adminFunCompService.judgerIsMeiLian(null, getOperator().getCompNo())){
			param.setIsMeiLian(1);
		}
		
		// 通过caseId，caseType，trackId获取房源图片列表
		List<ErpFunPhotoDto> mainPhotoList = this.getHousePhotoByCaseIdAndCaseType(cityId, param);
		// 查询是否是租售房源
		Byte shareFlag = 0;
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			// 查询出售信息
			ErpFunSale erpFunSale = erpFunSaleMapper.getHouseBaseInfo(cityId, caseId);
			shareFlag = erpFunSale.getCityShareFlag();
			houseCompId = erpFunSale.getCompId();
			// saleLeaseId不为空就是租售房源
			if (erpFunSale != null && null != erpFunSale.getIsSaleLease() && erpFunSale.getSaleLeaseId() != null) {
				param.setCaseId(erpFunSale.getSaleLeaseId());
				param.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
				// 查询对应出租图片列表
				mainPhotoList.addAll(this.getHousePhotoByCaseIdAndCaseType(cityId, param));
				//非租售房源
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			// 查询出租信息
			ErpFunLease erpFunLease = erpFunLeaseMapper.getHouseBaseInfo(cityId, caseId);
			shareFlag = erpFunLease.getCityShareFlag();
			houseCompId = erpFunLease.getCompId();
			// saleLeaseId不为空就是租售房源
			if (erpFunLease != null && null != erpFunLease.getIsSaleLease()  && erpFunLease.getSaleLeaseId() != null) {
				param.setCaseId(erpFunLease.getSaleLeaseId());
				param.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN);
				// 查询对应出售图片列表
				mainPhotoList.addAll(this.getHousePhotoByCaseIdAndCaseType(cityId, param));
			}
		}
		if(mainPhotoList == null || mainPhotoList.isEmpty()) {
			return ErpResponseJson.ok();
		}
		Set<Integer> photoIds = mainPhotoList.stream().filter(val -> (val.getPhotoId() != null))
				.collect(Collectors.mapping(ErpFunPhotoDto::getPhotoId, Collectors.toSet()));
		Map<Integer,Integer> uploadSourceUserMap = new  HashMap<Integer,Integer>();
		Set<Integer> uploadSourceUsers = new HashSet<Integer>();
		if("1".equals(param.getIsMeiLian().toString())){
			//查询操作人
			ErpFunPhotoMlExample erpFunPhotoMlExample = new ErpFunPhotoMlExample();
			erpFunPhotoMlExample.setShardCityId(cityId);
			erpFunPhotoMlExample.createCriteria().andPhotoIdIn(new ArrayList<>(photoIds)).andPhotographerFlagEqualTo((byte)1);
			List<ErpFunPhotoMl> erpFunPhotoMls = erpFunPhotoMlMapper.selectByExample(erpFunPhotoMlExample);
			if(erpFunPhotoMls !=null){
				uploadSourceUserMap = erpFunPhotoMls.stream().filter(val -> (val.getUploadSourceUser() != null))
						.collect(Collectors.toMap(ErpFunPhotoMl::getPhotoId, a->a.getUploadSourceUser()));
				uploadSourceUsers = erpFunPhotoMls.stream().filter(val -> (val.getUploadSourceUser() != null))
						.collect(Collectors.mapping(ErpFunPhotoMl::getUploadSourceUser, Collectors.toSet()));
			}
		} 
		
		Set<Integer> userIds = mainPhotoList.stream().filter(val -> (val.getUploadUser() != null))
				.collect(Collectors.mapping(ErpFunPhotoDto::getUploadUser, Collectors.toSet()));
		userIds.addAll(mainPhotoList.stream().filter(val -> (val.getDelUser() != null))
				.collect(Collectors.mapping(ErpFunPhotoDto::getDelUser, Collectors.toSet())));
		
		if(uploadSourceUsers.size() > 0){
			userIds.addAll(uploadSourceUsers);
		}	
		if(houseCompId == null){
			houseCompId = 0;
		}
		
		if(!Byte.valueOf("1").equals(shareFlag) ||  houseCompId.toString().equals(getOperator().getCompId().toString())){
			//查询是否有删除权限
			ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "DEL_HOUSE_MATERIAL");
			
			//合作房源不返回上传人信息
			List<ErpFunUsersDto> userList = erpFunUsersMapper.getUserNameAndDeptNameByIds(cityId, userIds);
			// 算了，这里面不判空了。。让他抛异常，太严了也不好是吧
			Map<Integer, ErpFunUsersDto> userNameMap = userList.stream().collect(Collectors.toMap(ErpFunUsersDto::getUserId, val -> val));
			Set<Integer> updloadUserList = mainPhotoList.stream().collect(Collectors.mapping(ErpFunPhotoDto::getUploadUser, Collectors.toSet()));
			List<ErpFunUsers> tempUserList = erpFunUsersMapper.getUserListByUserIds(cityId, updloadUserList);
			Map<Integer,String> userMap = tempUserList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getTissueLine));
			Set<String> orgPathSet = tempUserList.stream().collect(Collectors.mapping(ErpFunUsers::getTissueLine, Collectors.toSet()));
			Set<Integer> orgIds = new HashSet<Integer>();
			for (String orgPath:orgPathSet) {
				String[] orgStrArr = orgPath.split(":");
				for (String orgStr : orgStrArr) {
					Integer orgId = StringUtil.parseInteger(orgStr, 0);
					if (orgId>0) {
						orgIds.add(orgId);
					}
				}
			}
			Map<Integer,ErpFunOrganizationManager> orgManagerMap = new HashMap<>();
			if (!orgIds.isEmpty()) {
				ErpFunOrganizationManagerExample orgManagerExample = new ErpFunOrganizationManagerExample();
				orgManagerExample.setShardCityId(cityId);
				orgManagerExample.createCriteria().andCompIdEqualTo(compId).andOrganizationIdIn(new ArrayList<>(orgIds)).andUserIdEqualTo(userId);
				List<ErpFunOrganizationManager> orgManagerList = erpFunOrganizationManagerMapper.selectByExample(orgManagerExample);
				orgManagerMap = orgManagerList.stream().collect(Collectors.toMap(ErpFunOrganizationManager::getOrganizationId, orgManager ->orgManager));
			}
			for (ErpFunPhotoDto erpFunPhotoDto : mainPhotoList) {
				if(erpUserOpers !=null){
					erpFunPhotoDto.setDelFlag(1);
				}
				if(uploadSourceUserMap != null && uploadSourceUserMap.containsKey(erpFunPhotoDto.getPhotoId())){
					Integer uploadUsers = uploadSourceUserMap.get(erpFunPhotoDto.getPhotoId());
					if(userId.toString().equals(uploadUsers.toString())){
						erpFunPhotoDto.setDelFlag(1);
					}
					erpFunPhotoDto.setUploadSourceUser(uploadUsers);
					ErpFunUsersDto uploadUsersDto = userNameMap.get(uploadUsers);
					if(uploadUsersDto != null) {
						erpFunPhotoDto.setUploadSourceUserName(uploadUsersDto.getUserName());
					}
				}else{
					Integer uploadUserId = erpFunPhotoDto.getUploadUser();
					if(userId.toString().equals(uploadUserId.toString())){
						erpFunPhotoDto.setDelFlag(1);
					}
				}
				//2020-06-23 flj修改 storyId 12334 当前如果没有删除权限的话，则判断当前人员是否是所在组织架构线的主管
				if (!Integer.valueOf("1").equals(erpFunPhotoDto.getDelFlag())) {
					String tissueLine = userMap.get(erpFunPhotoDto.getUploadUser());
					if (StringUtils.isNotBlank(tissueLine)) {
						String[] orgStrArr = tissueLine.split(":");
						for (String orgStr : orgStrArr) {
							Integer orgId = StringUtil.parseInteger(orgStr, 0);
							if (orgId>0) {
								//如果当前组织线里面有当前人是主管的，那么直接判断为有删除权限，跳过循环就行
								if (orgManagerMap.get(orgId)!=null) {
									erpFunPhotoDto.setDelFlag(1);
									break;
								}
							}
						}
					}
				}
				ErpFunUsersDto funUsersDto = userNameMap.get(erpFunPhotoDto.getUploadUser());
				if(funUsersDto != null) {
					erpFunPhotoDto.setUserName(funUsersDto.getUserName());
//					erpFunPhotoDto.setDeptName(funUsersDto.getDeptName());	注释起来，使用查询出来的门店信息
//					erpFunPhotoDto.setDeptId(funUsersDto.getDeptId());	注释起来，使用查询出来的门店信息
				}
				funUsersDto = userNameMap.get(erpFunPhotoDto.getDelUser());
				if(funUsersDto != null) {
					erpFunPhotoDto.setDeluserName(funUsersDto.getUserName());
					erpFunPhotoDto.setDeldeptName(funUsersDto.getDeptName());
					erpFunPhotoDto.setDeldeptId(funUsersDto.getDeptId());
				}
			}
		}

		//[2020/05/20] 李中国 房间图：除了首图，其余房间图按最新上传时间排序，历史图片库恢复的按最新操作时间（加了个upload_date desc） 需求id#12259 5.20上线PC&APP 楼盘字典、房源、客源、业主电话、房间图，要求排最新登记时间排序
		/*mainPhotoList.sort((val1, val2) -> {
			Integer type1 = Optional.ofNullable(val1.getPhotoType()).orElse((byte) 0).intValue();
			Integer type2 = Optional.ofNullable(val2.getPhotoType()).orElse((byte) 0).intValue();
			if (!type1.equals(type2)) {
				return type1 - type2;
			}
			Integer seq1 = Optional.ofNullable(val1.getPhotoSeq()).orElse(0);
			Integer seq2 = Optional.ofNullable(val2.getPhotoSeq()).orElse(0);
			return seq1 - seq2;
		});*/
		mainPhotoList.sort((val1, val2) -> {
			Date d1 = DateUtil.StringToDate(val1.getUploadDate(), "yyyy-MM-dd HH:mm:ss");
			Date d2 = DateUtil.StringToDate(val2.getUploadDate(), "yyyy-MM-dd HH:mm:ss");

			return d2.compareTo(d1);
		});
		mainPhotoList.sort((val1, val2) -> {
			byte top1 = Optional.ofNullable(val1.getIsTop()).orElse((byte) 99);
			byte top2 = Optional.ofNullable(val2.getIsTop()).orElse((byte) 99);
			top1 = (top1 <= 0) ? (byte) 99 : 0;
			top2 = (top2 <= 0) ? (byte) 99 : 0;
			return top1 - top2;
		});
		return ErpResponseJson.ok(mainPhotoList);
	}
	
	/**
	 * 获取房源图片列表
	 * @author 臧铁
	 * @since 2017年9月14日
	 * @param cityId
	 * @param param caseId:房客源ID  caseType:房客源类型  trackId:跟进id
	 * @return
	 */
	private List<ErpFunPhotoDto> getHousePhotoByCaseIdAndCaseType(Integer cityId, GetHousePhotoParam param) {
		List<ErpFunPhotoDto> resList = erpFunPhotoMapper.getHousePhoto(cityId, param);
		for (ErpFunPhoto erpFunPhoto : resList) {
			String photoAddr = erpFunPhoto.getPhotoAddr();
			erpFunPhoto.setPhotoAddr(CommonUtil.getHousePhoto(photoAddr));
		}
		return resList;
	}
}
