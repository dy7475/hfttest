package com.myfun.erpWeb.house;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.utils.KafkaBizUtils;
import com.myfun.utils.poCovert.utils.PoConverterToView;
import com.extension.framework.web.ExceptionResolver.exception.BusinessException;
import com.myfun.erpWeb.house.param.DeleteVideoParam;
import com.myfun.erpWeb.house.param.GetVideoListParam;
import com.myfun.erpWeb.house.vo.ErpFunVideoVo;
import com.myfun.erpWeb.house.vo.GetVideoListVo;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunVideoMapper;
import com.myfun.repository.erpdb.dao.ErpFunVideoMlMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunVideo;
import com.myfun.repository.erpdb.po.ErpFunVideoExample;
import com.myfun.repository.erpdb.po.ErpFunVideoMl;
import com.myfun.repository.erpdb.po.ErpFunVideoMlExample;
import com.myfun.repository.erpdb.po.ErpUserOpers;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunVideoService;
import com.myfun.utils.Constants_DIC;

@Controller
@RequestMapping(value="/house",method= RequestMethod.POST)
public class VideoController extends BaseController{

	@Autowired
	ErpFunVideoService erpFunVideoService;
	@Autowired
	ErpFunVideoMapper erpFunVideoMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpFunVideoMlMapper erpFunVideoMlMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	
	/**
	 * 获取视频列表
	 * @author 臧铁
	 * @param param  caseId:房客源ID  caseType:房客源类型
	 * @since 2017年5月16日
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation("获取视频列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetVideoListVo.class, message = "成功")
	})
	@ResponseBody
	@NotBlank({"caseId", "caseType"})
	@RequestMapping("/getVideoList")
	public ResponseJson getVideoList(@Valid @RequestBody GetVideoListParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer userId = getOperator().getUserId();
		param.setCityId(cityId);
		Integer caseId = param.getCaseId();
		Integer caseType = param.getCaseType();
		if(adminFunCompService.judgerIsMeiLian(null, getOperator().getCompNo())){
			param.setIsMeiLian(1);
		}
		// 获取视频列表
		List<ErpFunVideoVo> mainVideoList = getVideoListByCaseIdAndCaseType(cityId, param);
		// 查询是否是租售房源
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			// 查询出售信息
			ErpFunSale erpFunSale = new ErpFunSale();
			erpFunSale.setSaleId(caseId);
			erpFunSale.setShardCityId(cityId);
			erpFunSale = erpFunSaleMapper.selectByPrimaryKey(erpFunSale);
			//这里严格一点 funSale 为null直接返回
			if (erpFunSale == null){
				return ErpResponseJson.ok();
			}
			// saleLeaseId不为空就是租售房源
			if (erpFunSale.getSaleLeaseId() != null) {
				param.setCaseId(erpFunSale.getSaleLeaseId());
				param.setCaseType(Const.DIC_CASE_TYPE_LEASE_FUN);
				// 查询对应出租视频列表
				mainVideoList.addAll(getVideoListByCaseIdAndCaseType(cityId, param));
			}
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			// 查询出租信息
			ErpFunLease erpFunLease = new ErpFunLease();
			erpFunLease.setLeaseId(caseId);
			erpFunLease.setShardCityId(cityId);
			erpFunLease = erpFunLeaseMapper.selectByPrimaryKey(erpFunLease);
			//这里严格一点 funLease 为null直接返回
			if (null == erpFunLease){
				return ErpResponseJson.ok();
			}
			// saleLeaseId不为空就是租售房源
			if (erpFunLease.getSaleLeaseId() != null) {
				param.setCaseId(erpFunLease.getSaleLeaseId());
				param.setCaseType(Const.DIC_CASE_TYPE_SALE_FUN);
				// 查询对应出售视频列表
				mainVideoList.addAll(getVideoListByCaseIdAndCaseType(cityId, param));
			}
		}
		List<ErpFunVideoVo> erpFunVideoVos = new ArrayList<ErpFunVideoVo>();
		if(mainVideoList !=null && mainVideoList.size() > 0){
			
			if("1".equals(param.getIsMeiLian().toString())){
				//查询操作人
				List<Integer> videoIds = mainVideoList.stream().map(ErpFunVideo::getVideoId).collect(Collectors.toList());
				//查询是否有删除权限
				ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(cityId, userId, "DEL_HOUSE_MATERIAL");
				ErpFunVideoMlExample erpFunVideoMlExample = new ErpFunVideoMlExample();
				erpFunVideoMlExample.setShardCityId(cityId);
				erpFunVideoMlExample.createCriteria().andVideoIdIn(videoIds).andPhotographerFlagEqualTo((byte)1);
				List<ErpFunVideoMl> erpFunVideoMls = erpFunVideoMlMapper.selectByExample(erpFunVideoMlExample);
				Map<Integer,Integer> videoUserMap = new HashMap<Integer,Integer>();
				if(erpFunVideoMls !=null ){
					videoUserMap = erpFunVideoMls.stream().collect(Collectors.toMap(ErpFunVideoMl::getVideoId, a->a.getUploadSourceUser()));
				}
				for (ErpFunVideoVo erpFunVideoVo : mainVideoList) {
					if(erpUserOpers != null){
						erpFunVideoVo.setDelFlag(1);
					}
					if(videoUserMap.containsKey(erpFunVideoVo.getVideoId())){
						erpFunVideoVo.setUploadSourceUser(videoUserMap.get(erpFunVideoVo.getVideoId()));
						Integer actionUser = videoUserMap.get(erpFunVideoVo.getVideoId());
						if(userId.toString().equals(actionUser.toString())){
							erpFunVideoVo.setDelFlag(1);
						}
					}else{
						Integer uploadUserId = erpFunVideoVo.getUploadUser();
						if(userId.toString().equals(uploadUserId.toString())){
							erpFunVideoVo.setDelFlag(1);
						}
					}
					erpFunVideoVos.add(erpFunVideoVo);
				}
			}
			
		}
		GetVideoListVo getVideoListVo = new GetVideoListVo();
		getVideoListVo.setMainVideoList(erpFunVideoVos);
		return ErpResponseJson.ok(getVideoListVo);
	}

	
	/**
	 * 获取视频列表
	 * @author 臧铁
	 * @since 2017年9月15日
	 * @param cityId
	 * @param param caseId:房客源ID  caseType:房客源类型
	 * @return
	 */
	private List<ErpFunVideoVo> getVideoListByCaseIdAndCaseType(Integer cityId, GetVideoListParam param) {
		List<ErpFunVideoVo> resList = erpFunVideoMapper.getVideoList(param.getCityId(), param);
		for (ErpFunVideo erpFunVideo : resList) {
			erpFunVideo.setPhotoAddr(CommonUtil.getVideoUrl(erpFunVideo.getPhotoAddr()));
			erpFunVideo.setVideoAddr(CommonUtil.getVideoUrl(erpFunVideo.getVideoAddr()));
		}
		return resList;
	}
	
	/**
	 * 获取视频列表
	 * @author 臧铁
	 * @since 2017年9月15日
	 * @param cityId
	 * @param param caseId:房客源ID  caseType:房客源类型
	 * @return
	 */
	@ResponseBody
	@NotBlank({"trackId"})
	@RequestMapping("/getFkVideoList")
	public ResponseJson getFkVideoList(@Valid @RequestBody BaseMapParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer trackId = param.getInteger("trackId");
		param.setInteger("cityId", cityId);
		ErpFunVideoExample example = new ErpFunVideoExample();
		example.setShardCityId(cityId);
		example.createCriteria().andTrackIdEqualTo(trackId);
		List<ErpFunVideo> videoList = erpFunVideoMapper.selectByExample(example);
		for (ErpFunVideo erpFunVideo : videoList) {
			erpFunVideo.setPhotoAddr(CommonUtil.getVideoUrl(erpFunVideo.getPhotoAddr()));
			erpFunVideo.setVideoAddr(CommonUtil.getVideoUrl(erpFunVideo.getVideoAddr()));
		}
		return ErpResponseJson.ok(videoList);
	}

	/**
	 * 删除视频
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型  videoId 视频Id caseNo 房客源编号 uploadDeptName uploadUserName cancelTrueFlag
	 * @since 2017年5月18日
	 * @return
	 */
    @ApiOperation("删除视频")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
	@ResponseBody
	@RequestMapping("/deleteVideo")
	public ResponseJson deleteVideo(@Valid @RequestBody DeleteVideoParam param) throws Exception{
		param.setCityId(getOperator().getCityId());
		param.setCurrentUserId(getOperator().getUserId());
		param.setCurrentCompId(getOperator().getCompId());
		param.setCurrentDeptId(getOperator().getDeptId());
		param.setDeptName(getOperator().getDeptName());
		param.setUserName(getOperator().getUserName());
		param.setCityShareName(getOperator().getAttribute("cityShareName"));
		
		if(adminFunCompService.judgerIsMeiLian(null, getOperator().getCompNo())){
			/*ErpUserOpers erpUserOpers = erpUserOpersMapper.selectPerPermissionByName(getOperator().getCityId(), getOperator().getUserId(), "DEL_HOUSE_MATERIAL");
			if(erpUserOpers == null){
				throw new BusinessException("您没有权限删除此房源视频！");
			}*/
			param.setIsMeiLian(1);
		} 
		erpFunVideoService.deleteVideo(param);
		KafkaBizUtils.syncHouse(param.getCityId(), param.getCaseId(), param.getCaseType());
		if (param.getSaleLeaseId()!=null) {
			KafkaBizUtils.syncHouse(param.getCityId(), param.getSaleLeaseId(), param.getSaleLeaseType());
		}
		return ErpResponseJson.ok();
	}

}
