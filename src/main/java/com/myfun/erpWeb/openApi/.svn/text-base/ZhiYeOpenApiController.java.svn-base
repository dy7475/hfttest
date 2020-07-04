package com.myfun.erpWeb.openApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.businesstools.zhiye.param.AdminZhiyeSynchronousPlayRecordsParam;
import com.myfun.erpWeb.businesstools.zhiye.param.AdminZhiyeSynchronousTestRecordsParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminZhiyeSynchronousPlayRecordsMapper;
import com.myfun.repository.admindb.dao.AdminZhiyeSynchronousTestRecordsMapper;
import com.myfun.repository.admindb.po.AdminZhiyeSynchronousPlayRecords;
import com.myfun.repository.admindb.po.AdminZhiyeSynchronousTestRecords;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 知业相关接口
 * @author 朱科
 * @since 2018年9月21日
 * @return
 */
@Controller
@RequestMapping(value = "/openApi/zhiyeUnit")
public class ZhiYeOpenApiController extends BaseController{

	@Autowired
	private AdminZhiyeSynchronousPlayRecordsMapper adminZhiyeSynchronousPlayRecordsMapper;
	@Autowired
	private AdminZhiyeSynchronousTestRecordsMapper adminZhiyeSynchronousTestRecordsMapper;
	
	/**
	 * 知业用户同步播放记录
	 * @author 朱科
	 * @since 2018年9月21日
	 * @return
	 */
	@ApiOperation("获取用户同步测试记录")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@ResponseBody
	@RequestMapping(value="/createZhiYePlayRecords")
	public ResponseJson createZhiYePlayRecords(@RequestBody AdminZhiyeSynchronousPlayRecordsParam param){
		AdminZhiyeSynchronousPlayRecords adminZhiyeSynchronousPlayRecords = getParamObj(AdminZhiyeSynchronousPlayRecords.class);
		adminZhiyeSynchronousPlayRecordsMapper.insertSelective(adminZhiyeSynchronousPlayRecords);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 知业用户同步测试记录
	 * @author 朱科
	 * @since 2018年9月21日
	 * @return
	 */
	@ApiOperation("获取用户同步测试记录")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, message = "成功")
	})
	@ResponseBody
	@RequestMapping(value="/createZhiYeTestRecords")
	public ResponseJson createZhiYeTestRecords(@RequestBody AdminZhiyeSynchronousTestRecordsParam param){
		AdminZhiyeSynchronousTestRecords adminZhiyeSynchronousTestRecords = getParamObj(AdminZhiyeSynchronousTestRecords.class);
		adminZhiyeSynchronousTestRecordsMapper.insertSelective(adminZhiyeSynchronousTestRecords);
		return ErpResponseJson.ok();
	}
}
