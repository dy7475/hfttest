package com.myfun.erpWeb.house.cityshare;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminCityshareBorkerComplaintMapper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dto.AdminCityshareBorkerComplaintDto;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.ErpCityshareBorkerPurchaseMapper;
import com.myfun.repository.erpdb.dao.ErpCityshareHouseMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpCityshareBorkerPurchase;
import com.myfun.repository.erpdb.po.ErpCityshareBorkerPurchaseExample;
import com.myfun.repository.erpdb.po.ErpCityshareHouse;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.admindb.AdminCityshareBorkerComplaintService;
import com.myfun.service.business.admindb.bean.param.CityshareBorkerComplaintParam;

/**
 * 
 * @author 朱科
 * @since 2018年4月79日
 */
@Controller
@RequestMapping("/cityShare")
public class CityShareController extends BaseController{

	@Autowired
	AdminCityshareBorkerComplaintMapper adminCityshareBorkerComplaintMapper;
	@Autowired
	AdminCityshareBorkerComplaintService adminCityshareBorkerComplaintService;
	@Autowired
	ErpCityshareHouseMapper erpCityshareHouseMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	ErpCityshareBorkerPurchaseMapper erpCityshareBorkerPurchaseMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	
	/**
	 * 城市公盘写投诉
	 * @author 朱科
	 * @since 2018年4月9日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/createCityshareBorkerComplain")
	public ResponseJson createCityshareBorkerComplain(@RequestBody CityshareBorkerComplaintParam param){
		Operator operator = getOperator();
		Integer selfArchiveId = operator.getArchiveId();
		Integer selfUserId = operator.getUserId();
		Integer selfCompId = operator.getCompId();
		Integer selfDeptId = operator.getDeptId();
		Integer cityId = operator.getCityId();
		adminCityshareBorkerComplaintService.addCityshareBorkerComplaint(selfArchiveId, selfUserId, selfCompId, selfDeptId, cityId, param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 大公盘获取投诉列表
	 * @author 朱科
	 * @since 2018年4月10日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCityshareHomeComplaintList")
	public ResponseJson getCityshareHomeComplaintList(@RequestBody BaseMapParam param){
		Integer shareHouseId = param.getInteger("shareHouseId");
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer userId = operator.getUserId();
		ErpCityshareHouse cityshareHouse = new ErpCityshareHouse();
		cityshareHouse.setSharehouseId(shareHouseId);
		cityshareHouse.setShardCityId(cityId);
		cityshareHouse = erpCityshareHouseMapper.selectByPrimaryKey(cityshareHouse);
		if(null != cityshareHouse){
			return ErpResponseJson.ok();
		}
		List<AdminCityshareBorkerComplaintDto> resultList = adminCityshareBorkerComplaintMapper.getListForBaseBeans(cityId, cityshareHouse.getCaseId(), cityshareHouse.getCaseType(), userId);
		List<Integer> archiveIdList = new ArrayList<Integer>();
		for (AdminCityshareBorkerComplaintDto adminCityshareBorkerComplaintDto : resultList) {
			Integer targetArchiveId = adminCityshareBorkerComplaintDto.getTargetArchiveId();
			if(!archiveIdList.contains(targetArchiveId)) {
				archiveIdList.add(targetArchiveId);
			}
			Integer sourceArchiveId = adminCityshareBorkerComplaintDto.getSourceArchiveId();
			if(!archiveIdList.contains(sourceArchiveId)) {
				archiveIdList.add(sourceArchiveId);
			}
		}
		if(archiveIdList.size() > 0) {
			List<AdminFunArchive> archiveList = adminFunArchiveMapper.selectUserName(archiveIdList);
			for(AdminFunArchive adminFunArchive:archiveList){
				for(AdminCityshareBorkerComplaintDto adminCityshareBorkerComplaintDto : resultList){
					if(adminCityshareBorkerComplaintDto.getTargetArchiveId().equals(adminFunArchive.getArchiveId())){
						adminCityshareBorkerComplaintDto.setTargetUserName(adminFunArchive.getUserName());
					}
					if(adminCityshareBorkerComplaintDto.getSourceArchiveId().equals(adminFunArchive.getArchiveId())){
						adminCityshareBorkerComplaintDto.setSourceUserName(adminFunArchive.getUserName());
					}
				}
			}
		}
		return ErpResponseJson.ok(resultList);
	}
	
	/**
	 * 获取经纪人电话
	 * @author 朱科
	 * @since 2018年4月10日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getHouseShareMobile")
	public ResponseJson getHouseShareMobile(@RequestBody BaseMapParam param){
		Integer shareHouseId = param.getInteger("shareHouseId");
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		ErpCityshareBorkerPurchaseExample example = new ErpCityshareBorkerPurchaseExample();
		example.createCriteria().andSharehouseIdEqualTo(shareHouseId).andUserIdEqualTo(operator.getUserId());
		example.setShardCityId(cityId);
		List<ErpCityshareBorkerPurchase> borkerPurchaseList = erpCityshareBorkerPurchaseMapper.selectByExample(example);
		// 还没有查看过
		if(null == borkerPurchaseList || borkerPurchaseList.size() <= 0){
			ErpCityshareBorkerPurchase erpCityshareBorkerPurchase = new ErpCityshareBorkerPurchase();
			erpCityshareBorkerPurchase.setArchiveId(operator.getArchiveId());
			erpCityshareBorkerPurchase.setCompId(operator.getCompId());
			erpCityshareBorkerPurchase.setCityId(cityId);
			erpCityshareBorkerPurchase.setSharehouseId(shareHouseId);
			erpCityshareBorkerPurchase.setCreationTime(new Date());
			erpCityshareBorkerPurchase.setReturnStatus((byte) 0);// 未退换
			erpCityshareBorkerPurchase.setPurchaseType((byte) 1);// 免费
			erpCityshareBorkerPurchase.setShareGetMoney(new BigDecimal(0.0));
			erpCityshareBorkerPurchase.setManagerGetMoney(new BigDecimal(0.0));
			erpCityshareBorkerPurchase.setUserId(operator.getUserId());// 查看人
			erpCityshareBorkerPurchase.setViewStatus((byte) 1);
			erpCityshareBorkerPurchase.setShardCityId(cityId);
			erpCityshareBorkerPurchaseMapper.insertSelective(erpCityshareBorkerPurchase);
		}
		ErpCityshareHouse erpCityshareHouse = new ErpCityshareHouse();
		erpCityshareHouse.setSharehouseId(shareHouseId);
		erpCityshareHouse.setShardCityId(cityId);
		erpCityshareHouse = erpCityshareHouseMapper.selectByPrimaryKey(erpCityshareHouse);
		if (null == erpCityshareHouse) {
			return ErpResponseJson.ok();
		}
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, erpCityshareHouse.getUserId());
		Map<String, String> result = new HashMap<String, String>(1);
		result.put("USER_MOBILE", erpFunUsers.getUserMobile());
		return ErpResponseJson.ok(result);
	}
	
	/**
	 * 城市大公盘跟进列表
	 * @author 朱科
	 * @since 2018年4月10日
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCityshareTrackList")
	public ResponseJson getCityshareTrackList(@RequestBody BaseMapParam param){
		Integer shareHouseId = param.getInteger("shareHouseId");
		// TODO 好像现在没有使用这个接口
		return ErpResponseJson.ok();
	}

	
	public ResponseJson getCityShareSaleDetail(@RequestBody BaseMapParam param){
		Integer caseId = param.getInteger("caseId");
		Integer caseType = param.getInteger("caseType");
		// TODO
		return ErpResponseJson.ok();
	}
}
