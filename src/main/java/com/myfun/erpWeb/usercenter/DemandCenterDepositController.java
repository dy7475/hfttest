package com.myfun.erpWeb.usercenter;

import java.util.List;

import javax.validation.Valid;

import com.myfun.erpWeb.usercenter.param.GetDistBuildingListParam;
import com.myfun.erpWeb.usercenter.vo.DistBuildingListVo;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminDiscountConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunDemandCenterDepositMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dto.AdminFunDeptsDto;
import com.myfun.repository.admindb.po.AdminDiscountConfig;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.utils.StringUtil;

/**
 * 需求中心隐号合作保证金相关接口
 * @author 张宏利
 * @since 2017年3月21日
 */
@Api(tags ="需求中心隐号合作保证金模块")
@Controller
@RequestMapping("/usercenter")
public class DemandCenterDepositController extends BaseController{
	
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	AdminFunDemandCenterDepositMapper adminFunDemandCenterDepositMapper;
	@Autowired
	AdminDiscountConfigMapper adminDiscountConfigMapper;
	
	/**
	 * 获取保证金门店列表
	 * @author 张宏利
	 * @since 2017年3月21日
	 * @param deptName 匹配门店名称
	 * @return
	 */
	@ApiOperation("获取保证金门店列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = DistBuildingListVo.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getDepositDeptList")
	public ErpResponseJson getDistBuildingList(@Valid @RequestBody GetDistBuildingListParam param) {
		AdminDiscountConfig discountConfig = adminDiscountConfigMapper.getRecordByCityLevelAndType((byte) 0, "DEMAND_CENTER_DEPOSIT");
		String deptName = param.getDeptName();
		String compNo = getOperator().getCompNo();
		AdminFunDepts depts = new AdminFunDepts();
		depts.setCompNo(compNo);
		depts.setDeptFlag(2);
		if(StringUtils.isNotBlank(deptName)) {
			depts.setDeptName("%"+deptName+"%");
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AdminFunDeptsDto> resultList = adminFunDeptsMapper.getVaildDeptList(depts);
		for (AdminFunDeptsDto adminFunDeptsDto : resultList) {
			if((adminFunDeptsDto.getPaidAmount() == null || adminFunDeptsDto.getPaidAmount() <= 0) 
					&& discountConfig != null) {
				adminFunDeptsDto.setPaidAmount(StringUtil.parseLong(discountConfig.getOption1(), 5000));
				adminFunDeptsDto.setPayStatus((byte) -1);
			}
		}
		PageInfo<AdminFunDeptsDto> pageInfo = new PageInfo<AdminFunDeptsDto>(resultList);
		return ErpResponseJson.ok(pageInfo);
	}
}

