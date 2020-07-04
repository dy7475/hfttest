package com.myfun.erpWeb.deal.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.erpWeb.build.param.UploadSealLogoPhotoParam;
import com.myfun.erpWeb.build.param.UploadSealPhotoParam;
import com.myfun.erpWeb.deal.param.UploadDealPhotoParam;
import com.myfun.erpWeb.deal.param.UploadFailureCausePhotoParam;
import com.myfun.erpWeb.deal.vo.AdminFunInvoiceEnclosureListVO;
import com.myfun.erpWeb.deal.vo.ErpFunDealPhotoListVO;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "合同图片控制器", value = "合同图片控制器")
@RequestMapping(value = "/dealPhoto")
public interface DealPhotoApi {
	
	@ApiOperation(value = "上传合同相关图片[移植uploadFunDealPhoto]")
	@ApiImplicitParam(dataTypeClass = UploadDealPhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "上传成功", response=ErpFunDealPhotoListVO.class)
	})
	@PostMapping("/uploadFunDealPhoto")
	ResponseJson uploadFunDealPhoto(@RequestBody UploadDealPhotoParam uploadDealPhotoParam)throws Exception;

	
	@ApiOperation(value = "上传合同印章图片[移植uploadSealPhoto]")
	@ApiImplicitParam(dataTypeClass = UploadSealPhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "上传成功", response=ErpFunDealPhotoListVO.class)
	})
	@PostMapping("/uploadSealPhoto")
	ResponseJson uploadSealPhoto(@RequestBody UploadSealPhotoParam uploadSealPhotoParam)throws Exception;

	@ApiOperation(value = "上传合同印章logo图片[移植uploadDealLogoPhoto]")
	@ApiImplicitParam(dataTypeClass = UploadSealLogoPhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "上传成功", response=ErpFunDealPhotoListVO.class)
	})
	@PostMapping("/uploadDealLogoPhoto")
	ResponseJson uploadDealLogoPhoto(@RequestBody UploadSealLogoPhotoParam uploadSealLogoPhotoParam)throws Exception;

	@ApiOperation(value = "上传发票图片[移植uploadFailureCauseEdit]")
	@ApiImplicitParam(dataTypeClass = UploadFailureCausePhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "上传成功", response=AdminFunInvoiceEnclosureListVO.class)
	})
	@PostMapping("/uploadFailureCauseEdit")
	ResponseJson uploadFailureCauseEdit(@RequestBody UploadFailureCausePhotoParam uploadSealLogoPhotoParam)throws Exception;
}

