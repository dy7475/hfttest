package com.myfun.erpWeb.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.house.param.DeletePanoramaPhotoParam;
import com.myfun.erpWeb.house.param.PanoramaPhotoListParam;
import com.myfun.erpWeb.house.vo.ErpFunPanoramaPhotoVo;
import com.myfun.erpWeb.house.vo.ErpFunVideoVo;
import com.myfun.erpWeb.house.vo.GetPanoramaPhotoListVo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunPanoramaPhotoMapper;
import com.myfun.repository.erpdb.dao.ErpFunPanoramaPhotoMlMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhoto;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhotoExample;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhotoMl;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhotoMlExample;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunVideo;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunPanoramaPhotoService;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.KafkaBizUtils;
import com.myfun.utils.StringUtil;
import com.myfun.utils.poCovert.utils.PoConverterToView;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags ="房源图片控制器")
@Controller
@RequestMapping(value="/house",method= RequestMethod.POST)
public class PanoramaPhotoController extends BaseController{

	@Autowired
	AdminSysParaMapper adminSysParaMapper;
	@Autowired
	ErpFunPanoramaPhotoService erpFunPanoramaPhotoService;
	@Autowired
	ErpFunPanoramaPhotoMapper erpFunPanoramaPhotoMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpFunPanoramaPhotoMlMapper erpFunPanoramaPhotoMlMapper;

	/**
	 * 获取720图片列表
	 * @author 臧铁
	 * @param param  caseId:房客源ID  caseType:房客源类型
	 * @since 2017年5月11日
	 * @return
	 */
	@ApiOperation("获取720图片列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetPanoramaPhotoListVo.class, message = "成功")
	})
	@ResponseBody
	@NotBlank({"caseId", "caseType"})
	@RequestMapping("/getPanoramaPhotoList")
	public ResponseJson getPanoramaPhotoList(@Valid @RequestBody PanoramaPhotoListParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		param.setCityId(cityId);
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		if(adminFunCompService.judgerIsMeiLian(null, getOperator().getCompNo())){
			param.setIsMeiLian(1);
		}
		// 获取720图片列表
		List<ErpFunPanoramaPhotoVo> panoramaList = getPanoramaPhotoListByCaseIdAndCaseType(cityId, param);
		// 查询是否是租售房源
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			// 查询出售信息
			ErpFunSale erpFunSale = erpFunSaleMapper.getHouseBaseInfo(cityId, caseId);
			// saleLeaseId不为空就是租售房源
			if (null != erpFunSale.getIsSaleLease() &&  null != erpFunSale.getSaleLeaseId()) {
				param.setCaseId(erpFunSale.getSaleLeaseId());
				param.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
				// 查询对应出租图片列表
				panoramaList.addAll(getPanoramaPhotoListByCaseIdAndCaseType(cityId, param));
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			// 查询出租信息
			ErpFunLease erpFunLease = erpFunLeaseMapper.getHouseBaseInfo(cityId, caseId);
			// saleLeaseId不为空就是租售房源
			if (null != erpFunLease.getIsSaleLease() && erpFunLease.getSaleLeaseId() != null) {
				param.setCaseId(erpFunLease.getSaleLeaseId());
				param.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN);
				// 查询对应出售图片列表
				panoramaList.addAll(getPanoramaPhotoListByCaseIdAndCaseType(cityId, param));
			}
		}
		List<ErpFunPanoramaPhotoVo> erpFunPanoramaPhotoVos = new ArrayList<ErpFunPanoramaPhotoVo>();
		if("1".equals(param.getIsMeiLian().toString())){
			if(panoramaList !=null && panoramaList.size() > 0){
				//查询操作人
				List<Integer> photoIds = panoramaList.stream().map(ErpFunPanoramaPhoto::getPhotoId).collect(Collectors.toList());
				//查询是否有删除权限
				ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "DEL_HOUSE_MATERIAL");
				
				ErpFunPanoramaPhotoMlExample erpFunPanoramaPhotoMlExample = new ErpFunPanoramaPhotoMlExample();
				erpFunPanoramaPhotoMlExample.setShardCityId(cityId);
				erpFunPanoramaPhotoMlExample.createCriteria().andPhotoIdIn(photoIds).andPhotographerFlagEqualTo((byte)1);
				List<ErpFunPanoramaPhotoMl> erpFunPanoramaPhotoMls = erpFunPanoramaPhotoMlMapper.selectByExample(erpFunPanoramaPhotoMlExample);
				Map<Integer,Integer> panoramaUserMap = new HashMap<Integer,Integer>();
				if(erpFunPanoramaPhotoMls !=null && erpFunPanoramaPhotoMls.size() > 0){
					panoramaUserMap = erpFunPanoramaPhotoMls.stream().collect(Collectors.toMap(ErpFunPanoramaPhotoMl::getPhotoId, a->a.getUploadSourceUser()));
				}
				for (ErpFunPanoramaPhotoVo erpFunPanoramaPhotoVo : panoramaList) {
					if(erpUserOpers != null){
						erpFunPanoramaPhotoVo.setDelFlag(1);
					}
					if(panoramaUserMap.containsKey(erpFunPanoramaPhotoVo.getPhotoId())){
						erpFunPanoramaPhotoVo.setUploadSourceUser(panoramaUserMap.get(erpFunPanoramaPhotoVo.getPhotoId()));
						Integer actionUser = panoramaUserMap.get(erpFunPanoramaPhotoVo.getPhotoId());
						if(userId.toString().equals(actionUser.toString())){
							erpFunPanoramaPhotoVo.setDelFlag(1);
						}
					}else{
						Integer uploadUserId = erpFunPanoramaPhotoVo.getUploadUser();
						if(userId.toString().equals(uploadUserId.toString())){
							erpFunPanoramaPhotoVo.setDelFlag(1);
						}
					}
					erpFunPanoramaPhotoVos.add(erpFunPanoramaPhotoVo);
				}
			}
		}
		GetPanoramaPhotoListVo getPanoramaPhotoListVo = new GetPanoramaPhotoListVo();
		getPanoramaPhotoListVo.setPanoramaPhotoList(erpFunPanoramaPhotoVos);
		return ErpResponseJson.ok(getPanoramaPhotoListVo);
	}

	/**
	 * 获取720图片列表
	 * @author 臧铁
	 * @since 2017年9月15日
	 * @param cityId
	 * @param param caseId:房客源ID  caseType:房客源类型
	 * @return
	 */
	private List<ErpFunPanoramaPhotoVo> getPanoramaPhotoListByCaseIdAndCaseType(Integer cityId, PanoramaPhotoListParam param) {
		List<ErpFunPanoramaPhotoVo> resList = erpFunPanoramaPhotoMapper.getPanoramaPhotoList(param.getCityId(), param);
		for (ErpFunPanoramaPhoto erpFunPanoramaPhoto : resList) {
			String photoAddr = erpFunPanoramaPhoto.getPhotoAddr();
			if (StringUtil.isNotBlank(photoAddr)) {
				photoAddr = photoAddr.replaceAll("\\\\", "/");
				if (!photoAddr.endsWith("/")) {
					photoAddr += '/';
				}
				erpFunPanoramaPhoto.setPhotoAddr(photoAddr + "front.jpg");
			}
		}
		return resList;
	}
	
	/**
	 * 删除720图片
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型  photoId 被删除的图片ID
	 * @since 2017年5月11日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getFkVrList")
	public ResponseJson getFkVrList(@Valid @RequestBody BaseMapParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer trackId = param.getInteger("trackId");
		ErpFunPanoramaPhotoExample example = new ErpFunPanoramaPhotoExample();
		example.setShardCityId(cityId);
		example.createCriteria().andTrackIdEqualTo(trackId);
		List<ErpFunPanoramaPhoto> resList = erpFunPanoramaPhotoMapper.selectByExample(example);
		for (ErpFunPanoramaPhoto erpFunPanoramaPhoto : resList) {
			String photoAddr = erpFunPanoramaPhoto.getPhotoAddr();
			if (StringUtil.isNotBlank(photoAddr)) {
				photoAddr = photoAddr.replaceAll("\\\\", "/");
				if (!photoAddr.endsWith("/")) {
					photoAddr += '/';
				}
				erpFunPanoramaPhoto.setPhotoAddr(photoAddr + "front.jpg");
			}
		}
		return ErpResponseJson.ok(resList);
	}
	
	/**
	 * 删除720图片
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型  photoId 被删除的图片ID
	 * @since 2017年5月11日
	 * @return
	 */
	@ApiOperation("删除720图片")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/deletePanoramaPhoto")
	public ResponseJson deletePanoramaPhoto(@Valid @RequestBody DeletePanoramaPhotoParam param) throws Exception{
		param.setCityId(getOperator().getCityId());
		param.setCurrentUserId(getOperator().getUserId());
		param.setCurrentCompId(getOperator().getCompId());
		param.setCompId(getOperator().getCompId());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setDeptName(getOperator().getDeptName());
		param.setUserName(getOperator().getUserName());
		erpFunPanoramaPhotoService.deletePanoramaPhoto(param);
		recreateVRfile(param);
		if (param.getSaleLeaseId()!=null) {
			KafkaBizUtils.syncHouse(param.getCityId(), param.getSaleLeaseId(), param.getSaleLeaseType());
		}
		KafkaBizUtils.syncHouse(param.getCityId(), param.getCaseId(), param.getCaseType());
		return ErpResponseJson.ok();
	}

	private void recreateVRfile(DeletePanoramaPhotoParam param)throws Exception{
		AdminSysPara adminSysPara = adminSysParaMapper.selectByPrimaryKey("APP_DEL_VR_URL");
		String url = adminSysPara.getParamValue();
		Map<String,String> mapParam = new HashMap<String,String>();
		mapParam.put("action", "createPanorama");
		mapParam.put("USER_MOBILE", getOperator().getUserMobile());
		mapParam.put("TOKEN", EnCodeHelper.encode(getOperator().getUserMobile()));
		mapParam.put("CASE_ID", param.getCaseId().toString());
		mapParam.put("CASE_TYPE", param.getCaseType().toString());
		HttpUtil.post(url, mapParam);
	}
}

