package com.myfun.erpWeb.openApi;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.admindb.dao.AdminGoodNewsTempleteMapper;
import com.myfun.repository.admindb.po.AdminBulletWithBLOBs;
import com.myfun.repository.admindb.po.AdminGoodNewsTemplete;
import com.myfun.repository.erpdb.dao.ErpFunCityMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpFunDealDtoTemp;
import com.myfun.repository.erpdb.dto.ErpUsersInfoDto;
import com.myfun.repository.erpdb.po.ErpFunCity;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.service.business.admindb.AdminBulletService;
import com.myfun.service.business.erpdb.ErpBuildInfoService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
@RestController
@RequestMapping(value = "/openApi/dealGoodNews")
public class DealGoodNewsController {
	@Autowired private AdminGoodNewsTempleteMapper adminGoodNewsTempleteMapper;
	@Autowired private AdminBulletService adminBulletService;
	@Autowired private ErpFunUsersService erpFunUsersService;
	@Autowired private ErpBuildInfoService erpBuildInfoService;
	@Autowired private ErpFunDealMapper erpFunDealMapper;
	@Autowired private ErpFunCityMapper erpFunCityMapper;
	@Autowired private AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	
	/**
	 * jms处理喜报数据
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/dealData")
	public String dealBillingNews() throws Exception{
	/*	List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		for(String dbName:configs){
			List<ErpFunCity> cityList = erpFunCityMapper.selectCityList(dbName);
			for(ErpFunCity funCity:cityList){*/
				Short cityId = 194;
				
				List<ErpFunDealDtoTemp> dealList = erpFunDealMapper.getDealListNotHaveBullet(cityId);
				for(ErpFunDealDtoTemp erpFunDeal:dealList){
					Boolean areaFlag = erpFunDeal.getAreaFlag();
					createBillingNews(194, (ErpFunDeal)erpFunDeal, erpFunDeal.getAdminCompId(), erpFunDeal.getAdminDeptId(), erpFunDeal.getCompName(),areaFlag);
				}
	/*		}
		} */
		return "success";
	}
	private void createBillingNews(Integer cityId,ErpFunDeal erpFunDeal,Integer adminCompId,Integer adminDeptId,String compName,boolean areaFlagVal) throws Exception{
		AdminBulletWithBLOBs adminBullet = new AdminBulletWithBLOBs();
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
		adminBullet.setBulletTime(nowTime);
		adminBullet.setEditTime(nowTime);// 创建记录时，把更新时间设置为创建时间。以后查询按更新时间排序
		adminBullet.setClickCount(0);
		adminBullet.setStick(false);
		adminBullet.setUserId(StringUtil.parseInteger(Constants_DIC.DIC_SYSTEM_USERID_999));
		adminBullet.setElite(false);
		adminBullet.setIsDelete(false);
		adminBullet.setRecommend(false);
		adminBullet.setReplyCount(new Short("0"));
		adminBullet.setShowTel(false);
		adminBullet.setOrderTime(nowTime);
		adminBullet.setIsvote(false);
		adminBullet.setBulletBound(Byte.valueOf("8"));
		adminBullet.setCompId(adminCompId);
		adminBullet.setDeptId(adminDeptId);
		adminBullet.setCompName(compName);
		adminBullet.setDealId(erpFunDeal.getDealId());
		adminBullet.setReleaseStatus(Byte.valueOf("0"));
		adminBullet.setContract("系统发布");
		adminBullet.setCityId(cityId);
		String dealTypeName = Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(erpFunDeal.getDealType().toString())?"出售":"出租";
		//1.生成喜报标题
		String subject = "【成交喜报】"+getBuildRegSectionName(erpFunDeal.getBuildId(),cityId, false)+dealTypeName+"房源签单喜报";
		adminBullet.setBulletSubject(subject);
		AdminGoodNewsTemplete templete = null;
		String templeteContent = null;
		//为空就使用默认值
		if (templete == null) {
			templete = adminGoodNewsTempleteMapper.selectByPrimaryKey(1);
		}
		templeteContent = templete.getTempleteContent();
		adminBullet.setNewsBackUrl(templete.getTempleteBackground());
		adminBullet.setTempleteId(templete.getId());
		//2.生成喜报内容
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		StringBuilder content = new StringBuilder();
		content.append("恭喜<br/>");
		content.append(calendar.get(Calendar.YEAR));
		content.append("年");
		content.append(calendar.get(Calendar.MONTH) + 1);
		content.append("月");
		content.append(calendar.get(Calendar.DAY_OF_MONTH));
		content.append("日 ");
		content.append(getBuildRegSectionName(erpFunDeal.getBuildId(),cityId, true)+"签单报喜");
		content.append("<br/><br/>签约人员：<br/>");
		content.append(getUserDetailGroupByUserId(cityId,erpFunDeal.getCompId(),erpFunDeal.getSignUserId(),erpFunDeal.getSignUserDeptName(),areaFlagVal));
		content.append("<br/>");
		content.append(getUserDetailGroupByUserId(cityId,erpFunDeal.getCompId(),erpFunDeal.getSignManagerId(),erpFunDeal.getSignManagerDeptName(),areaFlagVal));
		templeteContent = templeteContent.replace("#TEMPLETE_CONTENT#", content);
		adminBullet.setBulletContent(templeteContent);
		//3.生成喜报
		adminBulletService.insertSelective(adminBullet);
	}
	private String getUserDetailGroupByUserId(Integer cityId,Integer compId,Integer userId,String deptName,boolean areaFlagVal) throws Exception {
		StringBuilder returnStrBuilder = new StringBuilder();
		if (userId == null) {
			return "";
		}
		boolean areaFlag = "1".equals(areaFlagVal)?true:false;
		ErpUsersInfoDto erpUsersInfoDto = erpFunUsersService.getUserInfoByUserId(cityId,compId,userId,areaFlagVal);
		String userName = erpUsersInfoDto.getUserName();
		String areaName = erpUsersInfoDto.getAreaName();
		String regName = erpUsersInfoDto.getRegName();
		String grName = erpUsersInfoDto.getGrName();
		if(!StringUtil.isBlank(areaName) && areaFlag){
			returnStrBuilder.append(" ");
			returnStrBuilder.append(areaName);
		}
		if(!StringUtil.isBlank(regName)){
			returnStrBuilder.append(" ");
			returnStrBuilder.append(regName);
		}
		if(!StringUtil.isBlank(deptName)){
			returnStrBuilder.append(" ");
			returnStrBuilder.append(deptName);
		}
		if(!StringUtil.isBlank(grName)){
			returnStrBuilder.append(" ");
			returnStrBuilder.append(grName);
		}
		returnStrBuilder.append(" ");
		returnStrBuilder.append(userName);
		return returnStrBuilder.toString();
	}

	private String getDealPrice(Map<String,String> dataMap) {
		String dealType = dataMap.get("DEAL_TYPE");
		String dealPrice = "";
		boolean flag = Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)?true:false;
		if(flag){
			String priceUnit = dataMap.get("SALE_PRICE_UNIT");
			dealPrice = dataMap.get("SELL_DEAL_MONEY");
			if("0".equals(priceUnit)){
				dealPrice = StringUtil.parseDouble(dealPrice, 0.00)/10000.0 + "万元";
			}else if("1".equals(priceUnit)){
				dealPrice = dealPrice + "元";
			}
		}else{
			String priceUnit = dataMap.get("RENT_PRICE_UNIT");
			dealPrice = dataMap.get("RENT_DEAL_MONEY");
			if(Constants_DIC.DIC_PRICE_UNIT_PERMONTH.equals(priceUnit)){
				dealPrice = dealPrice + "元/每月";
			}else if(Constants_DIC.DIC_PRICE_UNIT_PERDAY.equals(priceUnit)){
				dealPrice = dealPrice + "元/每天";	
			}else if(Constants_DIC.DIC_PRICE_UNIT_PERCENTIARE.equals(priceUnit)){
				dealPrice = dealPrice + "元/平米*每月";
			}else if(Constants_DIC.DIC_PRICE_UNIT_PERDAYCENT.equals(priceUnit)){
				dealPrice = dealPrice + "元/平米*每天";	
			}
		}
		return dealPrice;
	}

	private String getBuildRegSectionName(Integer buildId,Integer cityId, boolean needSrction) throws Exception{
		ErpBuildingInfoDto dto = erpBuildInfoService.getBuildInfoById(buildId.toString(),cityId);
		if(dto!=null){
			if(needSrction && !StringUtil.isBlank(dto.getSectionName())){
				return dto.getRegName()+dto.getSectionName();
			}
			return dto.getRegName();
		}
		return "";
	}
}
