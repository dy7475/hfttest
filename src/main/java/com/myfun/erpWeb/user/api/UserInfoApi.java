package com.myfun.erpWeb.user.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.erpWeb.user.param.UploadUserPhotoParam;
import com.myfun.erpWeb.user.vo.UserInfoPhotoVO;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "用户信息控制器", value = "用户信息控制器")
@RequestMapping(value = "/userInfo")
public interface UserInfoApi {
	
	@ApiOperation(value = "上传用户头像等图片[移植uploadUserHeadPic]")
	@ApiImplicitParam(dataTypeClass = UploadUserPhotoParam.class)
	@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "")
	@ApiResponses(value={
			@ApiResponse(code = 200, message = "上传成功", response=UserInfoPhotoVO.class)
	})
	@PostMapping("/uploadUserHeadPic")
	ResponseJson uploadUserHeadPic(@RequestBody UploadUserPhotoParam uploadUserPhotoParam)throws Exception;
}

