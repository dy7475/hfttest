package com.myfun.erpWeb.fafa;

import javax.validation.Valid;

import com.myfun.repository.admindb.dao.AdminContactInfoMapper;
import com.myfun.repository.admindb.po.AdminContactInfo;
import com.myfun.service.business.admindb.AdminContactInfoService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.service.business.searchdb.SearchSosoViewService;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 发发控制器
 * @author 张宏利
 * @since 2017年3月8日
 */
@RestController
@RequestMapping(value="/fafun", method=RequestMethod.POST)
public class FaFunController extends BaseController{
	
	@Autowired
	SearchSosoViewService searchSosoViewService;
	@Autowired
	AdminContactInfoMapper adminContactInfoMapper;
	@Autowired
	AdminContactInfoService adminContactInfoService;
	/**
	 * 获取群发的列表数据,单条房源对多个站点发布
	 * @author 张宏利
	 * @since 2017年3月8日
	 * @param houseIds 房源IDs
	 * @return
	 */
	@RequestMapping(value="/getGroupSingleHouseData")
	public ResponseJson getGroupSingleHouseData(@Valid @RequestBody BaseMapParam param){
		String houseIds = param.getString("houseIds");
		houseIds = houseIds.replaceAll("#FF#", "#");
		if(houseIds.length() > 0){
			houseIds = houseIds.substring(0, houseIds.length() - 1);
		}
		String[] houseIdArr = houseIds.split("#");
		
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取参数 个人信息 选择 修改联系方式 修改发布信息的联系电话
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/18
	 */
//	@RequestMapping(value = "/getFFContactData")
//	public ResponseJson getFFContactData(@Valid @RequestBody BaseMapParam param) {
//		Integer archiveId = getOperator().getArchiveId();
//		AdminContactInfo adminContactInfo = adminContactInfoMapper.selectByPrimaryKey(archiveId);
//		List<AdminContactInfo> list = new ArrayList<>();
//		list.add(adminContactInfo);
//		return ErpResponseJson.ok(list);
//	}
	
	/**
	 * 参数 个人信息 选择 修改联系方式 修改发布信息的联系电话
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/4/18
	 */
//	@RequestMapping(value = "/updateFFContactData")
//	public ResponseJson updateFFContactData(@Valid @RequestBody BaseMapParam param) {
//		String contactFlag = param.getString("contactFlag");
//		Integer archiveId = getOperator().getArchiveId();
//		//2为使用对方网站的联系方式
//		AdminContactInfo adminContactInfo = new AdminContactInfo();
//		adminContactInfo.setContactFlag(StringUtil.parseInteger(contactFlag));
//		adminContactInfo.setUpdateDate(new Date());
//		adminContactInfo.setArchiveId(archiveId);
//		int isExist = adminContactInfoMapper.count(archiveId);
//		if (isExist <= 0) {
//			adminContactInfoService.insertSelective(adminContactInfo);
//		} else if (isExist > 0) {
//			adminContactInfoService.updateByArchiveId(archiveId, contactFlag, new Date());
//		}
//		return ErpResponseJson.ok();
//	}
}


