package com.myfun.erpWeb.build.api;

import com.myfun.erpWeb.build.param.DeleteBuildingPhotoParam;
import com.myfun.framework.web.json.ErpResponseJson;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.erpWeb.build.param.UploadBuildingPhotoParam;
import com.myfun.erpWeb.build.param.UploadDistBuildPhotoParam;
import com.myfun.erpWeb.build.vo.AgencyBuildingPhotoListVO;
import com.myfun.erpWeb.build.vo.ErpBuildingPhotoListVO;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "楼盘信息控制器", value = "楼盘信息控制器")
@RequestMapping(value = "/buildingInfo")
public interface BuildingInfoApi {

	@ApiOperation(value = "上传楼盘图片[移植build_uploadBuildPhoto]")
	@ApiImplicitParam(dataTypeClass = UploadBuildingPhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "上传成功", response = ErpBuildingPhotoListVO.class) })
	@PostMapping("/uploadBuildingPhoto")
	ResponseJson uploadBuildingPhoto(@RequestBody UploadBuildingPhotoParam uploadBuildingPhotoParam) throws Exception;

	@ApiOperation(value = "上传楼盘分销广告图片[移植distBuildPhoto]")
	@ApiImplicitParam(dataTypeClass = UploadDistBuildPhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "上传成功", response = AgencyBuildingPhotoListVO.class) })
	@PostMapping("/upDistBuildPhoto")
	ResponseJson upDistBuildPhoto(@RequestBody UploadDistBuildPhotoParam uploadDistBuildPhotoParam) throws Exception;

	@ApiOperation(value = "删除楼盘分销广告图片[移植distBuildPhoto]")
	@ApiImplicitParam(dataTypeClass = DeleteBuildingPhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "上传成功", response = ErpResponseJson.class) })
	@PostMapping(value = "/delBuildingPhoto")
	ResponseJson delBuildingPhoto(@RequestBody DeleteBuildingPhotoParam deleteBuildingPhotoParam) throws Exception;
}
