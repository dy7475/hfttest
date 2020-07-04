package com.myfun.erpWeb.build.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.myfun.erpWeb.build.param.DeleteBuildingPhotoParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.utils.KafkaBizUtils;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atomikos.util.DateHelper;
import com.myfun.erpWeb.build.api.BuildingInfoApi;
import com.myfun.erpWeb.build.param.UploadBuildingPhotoParam;
import com.myfun.erpWeb.build.param.UploadDistBuildPhotoParam;
import com.myfun.erpWeb.build.vo.AgencyBuildingPhotoListVO;
import com.myfun.erpWeb.build.vo.ErpBuildingPhotoListVO;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.agencydb.dao.AgencyBuildingPhotoMapper;
import com.myfun.repository.agencydb.po.AgencyBuildingPhoto;
import com.myfun.repository.erpdb.dao.ErpBuildingPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpBuildingPhoto;
import com.myfun.utils.DateTimeHelper;

@RestController
public class BuildingInfoController extends BaseController implements BuildingInfoApi {
	@Autowired
	private ErpBuildingPhotoMapper erpBuildingPhotoMapper;
	@Autowired
	private AgencyBuildingPhotoMapper agencyBuildingPhotoMapper;
	@Autowired
	private ErpFunPhotoMapper erpFunPhotoMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	private ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
	private ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	private ErpFunTrackMapper erpFunTrackMapper;

	@Override
	public ResponseJson uploadBuildingPhoto(@RequestBody UploadBuildingPhotoParam uploadBuildingPhotoParam)
			throws Exception {
		String[] photoAddrArr = uploadBuildingPhotoParam.getPhotoAddr().split(",");
		List<ErpBuildingPhoto> list = new ArrayList<>();
		for (String photoAddr : photoAddrArr) {
			ErpBuildingPhoto erpBuildingPhoto = new ErpBuildingPhoto();
			erpBuildingPhoto.setCityId(getOperator().getCityId().shortValue());
			erpBuildingPhoto.setShardCityId(getOperator().getCityId());
			erpBuildingPhoto.setBuildId(uploadBuildingPhotoParam.getBuildId());
			erpBuildingPhoto.setIsFirst(false);
			erpBuildingPhoto.setPhotoType(uploadBuildingPhotoParam.getPhotoType());
			erpBuildingPhoto.setUploadDate(DateHelper.format(new Date()));
			erpBuildingPhoto.setUploadUser(getOperator().getUserId());
			erpBuildingPhoto.setVertifyFlag(true);
			erpBuildingPhoto.setPhotoAddr(photoAddr);
			Integer photoId = generatePhotoId("erp");
			erpBuildingPhoto.setPhotoId(photoId);
			erpBuildingPhotoMapper.insertSelective(erpBuildingPhoto);

			KafkaBizUtils.updateBuildPhoto(getOperator().getCityId(), erpBuildingPhoto.getPhotoId(), "1");
			ErpBuildingPhoto erpBuildingPhotoVo = new ErpBuildingPhoto();
			erpBuildingPhotoVo.setPhotoAddr(photoAddr);
			erpBuildingPhotoVo.setPhotoId(photoId);
			list.add(erpBuildingPhotoVo);
		}
		ErpBuildingPhotoListVO listVO = new ErpBuildingPhotoListVO();
		listVO.setErpBuildingPhotoList(list);
		return ErpResponseJson.ok(listVO);
	}

	@Override
	public ResponseJson upDistBuildPhoto(@RequestBody UploadDistBuildPhotoParam uploadDistBuildPhotoParam) throws Exception {
		Operator operator = getOperator();
		byte photoType = uploadDistBuildPhotoParam.getPhotoType();
		String[] photoAddrArr = uploadDistBuildPhotoParam.getPhotoAddr().split(",");

		List<AgencyBuildingPhoto> list = new ArrayList<>();
		for (String photoAddr : photoAddrArr) {
			AgencyBuildingPhoto agencyBuildingPhoto = new AgencyBuildingPhoto();
			agencyBuildingPhoto.setBuildId(uploadDistBuildPhotoParam.getBuildId());
			agencyBuildingPhoto.setPhotoId(generatePhotoId("agency"));
			agencyBuildingPhoto.setCityId(Short.valueOf(operator.getCityId().toString()));
			agencyBuildingPhoto.setBuildId(uploadDistBuildPhotoParam.getBuildId());
			agencyBuildingPhoto.setPhotoType(photoType);
			agencyBuildingPhoto.setPhotoAddr(photoAddr);
			agencyBuildingPhoto.setUploadUser(operator.getUserId());
			agencyBuildingPhoto.setEditFlag((byte) 0);
			agencyBuildingPhoto.setUploadDate(DateTimeHelper.getSystemDate());
			agencyBuildingPhotoMapper.insertSelective(agencyBuildingPhoto);
			list.add(agencyBuildingPhoto);
		}
		AgencyBuildingPhotoListVO listVO = new AgencyBuildingPhotoListVO();
		listVO.setAgencyBuildingPhotoList(list);
		return ErpResponseJson.ok(list);
	}


	public ResponseJson delBuildingPhoto(@RequestBody DeleteBuildingPhotoParam deleteBuildingPhotoParam) throws Exception {
		Operator operator = getOperator();
		String[] photoIdsStr = deleteBuildingPhotoParam.getPhotoIds().split(",");
		Set<Integer> photoIds = Stream.of(photoIdsStr).filter(StringUtil::isNotBlank).map(Integer::parseInt).collect(Collectors.toSet());
		Optional.of(photoIds).filter(obj -> !obj.isEmpty()).orElseThrow(() -> new BusinessException("请选择删除的图片"));
		erpBuildingPhotoMapper.deleteByPhotoIds(operator.getCityId(), photoIds);
		return ErpResponseJson.ok();
	}

	/**
	 * 生成AGENCY库BUILDING_PHOTO的PHOTO_ID
	 */
	private Integer generatePhotoId(String type) {
		Integer photoId = 0;
		if(type.equals("erp")) {
			photoId = erpBuildingPhotoMapper.getMaxPhotoId(getOperator().getCityId());
		}else if(type.equals("agency")){
			photoId = agencyBuildingPhotoMapper.getMaxPhotoId();
		}
		if(photoId < 1000) {
			photoId = 1000;
		}
		return photoId;
	}
}
