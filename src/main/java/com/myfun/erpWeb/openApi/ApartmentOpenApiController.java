package com.myfun.erpWeb.openApi;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myfun.repository.admindb.dao.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.openApi.suport.OpenApiConfig;
import com.myfun.erpWeb.openApi.suport.OpenApiConfig.ThirdUserData;
import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dto.AdminApartmentCountDto;
import com.myfun.repository.admindb.param.AdminFunApartmentRoomParam;
import com.myfun.repository.admindb.param.AdminFunCooperateApartmentParam;
import com.myfun.repository.admindb.po.AdminFunApartmentPhoto;
import com.myfun.repository.admindb.po.AdminFunApartmentRoom;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunCooperateApartment;
import com.myfun.repository.admindb.po.AdminFunReg;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.AuthenticationHelper;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rest.EncryptUtil;

/**
 * 第三方公寓推送接口
 * 
 * @author jsg
 *
 */
@Controller
@RequestMapping(value = "/openApi/apartment")
public class ApartmentOpenApiController {
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	@Autowired
	private AdminFunRegMapper adminFunRegMapper;
	@Autowired
	private AdminFunSectionMapper adminFunSectionMapper;
	@Autowired
	private AdminFunCooperateApartmentMapper adminFunCooperateApartmentMapper;
	@Autowired
	private AdminFunApartmentRoomMapper adminFunApartmentRoomMapper;
	@Autowired
	private AdminFunApartmentPhotoMapper adminFunApartmentPhotoMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(ApartmentOpenApiController.class);
	
	/**
	 * 获取accessToken
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAccessToken")
	public ResponseJson getAccessToken(HttpServletRequest request, HttpServletResponse response) {
		try {
			String appId = request.getParameter("appId");
			String appSecret = request.getParameter("appSecret");
			ThirdUserData thirdUserData = OpenApiConfig.THIRD_USER_DATA.get(appId);
			// 验证是否有效
			if (thirdUserData != null && thirdUserData.getAppSecret().equals(appSecret)) {
				String token = AuthenticationHelper.generateToken(thirdUserData.getAppId(), thirdUserData.getAppSecret());
				return new DefaultResponseJson(Const.ResponseCode.SUCCESS, null, token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new DefaultResponseJson(Const.ResponseCode.OTHER_FAIL, "非法访问");
	}
	
	/**
	 * 同步公寓、房源、图片下架
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/downSync")
	public ResponseJson downSync(String accessToken, String apartmentUuid, String roomUuid, String photoUuid) throws Exception {
		String appId = AuthenticationHelper.getAppId(accessToken);
		if(StringUtils.isBlank(appId)) {
			return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "未找到该appId");
		}
		if(StringUtils.isNotBlank(apartmentUuid)){
			AdminFunCooperateApartment oldApartment = adminFunCooperateApartmentMapper.selectByPrimaryKey(apartmentUuid);
			if(oldApartment == null || !appId.equals(oldApartment.getAppId())) {
				return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "该房源不属于您，不能更新");
			}
			AdminFunCooperateApartment apartment = new AdminFunCooperateApartment();
			apartment.setUuid(apartmentUuid);
			apartment.setHouseStatus(2);
			apartment.setIsRent((byte) 1);
			apartment.setUpdateTime(new Date());
			adminFunCooperateApartmentMapper.updateByPrimaryKeySelective(apartment);
			AdminFunApartmentRoom room = new AdminFunApartmentRoom();
			room.setApartmentUuid(apartmentUuid);
			room.setIsRent((byte) 1);
			room.setRoomStatus((byte) 0);
			room.setUpdateTime(new Date());
			adminFunApartmentRoomMapper.updateByApartmentUuid(room);
		}
		if(StringUtils.isNotBlank(roomUuid)){
			AdminFunApartmentRoom oldRoom = adminFunApartmentRoomMapper.selectByPrimaryKey(roomUuid);
			if(oldRoom == null) {
				return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "该房间不属于您，不能更新");
			}
			AdminFunCooperateApartment oldApartment = adminFunCooperateApartmentMapper.selectByPrimaryKey(oldRoom.getApartmentUuid());
			if(oldApartment == null || !appId.equals(oldApartment.getAppId())) {
				return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "该房间不属于您，不能更新");
			}
			AdminFunApartmentRoom room = new AdminFunApartmentRoom();
			room.setUuid(roomUuid);
			room.setIsRent((byte) 1);
			room.setRoomStatus((byte) 0);
			room.setUpdateTime(new Date());
			adminFunApartmentRoomMapper.updateByPrimaryKeySelective(room);
		}
		if(StringUtils.isNotBlank(photoUuid)){
			AdminFunApartmentPhoto oldPhoto = adminFunApartmentPhotoMapper.selectByPrimaryKey(photoUuid);
			if(oldPhoto == null) {
				return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "该图片不属于您，不能更新");
			}
			AdminFunCooperateApartment oldApartment = adminFunCooperateApartmentMapper.selectByPrimaryKey(oldPhoto.getApartmentUuid());
			if(oldApartment == null || !appId.equals(oldApartment.getAppId())) {
				return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "该图片不属于您，不能更新");
			}
			AdminFunApartmentPhoto photo = new AdminFunApartmentPhoto();
			photo.setUuid(photoUuid);
			photo.setPhotoStatus((byte) 0);
			adminFunApartmentPhotoMapper.updateByPrimaryKeySelective(photo);
		}
		return new DefaultResponseJson(Const.ResponseCode.SUCCESS);
	}

	/**
	 * 同步公寓
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "/syncApartment")
	public ResponseJson syncApartment(HttpServletRequest request, HttpServletResponse response, @RequestBody String postJson) throws Exception {
		// 验证数据有效性
		if(StringUtils.isBlank(postJson)){
			return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "参数不能为空");
		}
		AdminFunCooperateApartmentParam adminFunCooperateApartmentParam = null;
		try {
			adminFunCooperateApartmentParam = JSON.parseObject(postJson, AdminFunCooperateApartmentParam.class);
		} catch (Exception e) {
			logger.error("参数格式错误:" + e.getMessage() + postJson);
			return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "参数格式错误:" + e.getMessage());
		}
		if(adminFunCooperateApartmentParam == null || StringUtils.isBlank(adminFunCooperateApartmentParam.getUuid())){
			return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "uuid为必传参数");
		}
		String accessToken = request.getParameter("accessToken");
		String appId = AuthenticationHelper.getAppId(accessToken);
		if(StringUtils.isBlank(appId)) {
			return new DefaultResponseJson(Const.ResponseCode.CONFIRM_CODE, "未找到该appId");
		}
		adminFunCooperateApartmentParam.setAppId(appId);
		adminFunCooperateApartmentParam.setAptPostJson(postJson);
		// 暂时的解决方案，不是整形时不保存，为了app端不报错，app修改上线后删除这个逻辑
		if(adminFunCooperateApartmentParam.getOutHouseId() != null) {
			int outHouseId = StringUtil.parseInteger(adminFunCooperateApartmentParam.getOutHouseId(), 0);
			adminFunCooperateApartmentParam.setOutHouseId(String.valueOf(outHouseId));
		}
		if(adminFunCooperateApartmentParam.getOutRoomId() != null) {
			int outRoomId = StringUtil.parseInteger(adminFunCooperateApartmentParam.getOutRoomId(), 0);
			adminFunCooperateApartmentParam.setOutRoomId(String.valueOf(outRoomId));
		}
		
		// 传过来的C端和B端都上架状态还是保留，本来下架的数据就不会查出来
		// 分佣比例计算为金额
		Integer rate = adminFunCooperateApartmentParam.getCommissionRate();
		Integer rateType = adminFunCooperateApartmentParam.getCommissionType();
		if(rate != null && rateType != null) {
			if(rateType == 1) {
				adminFunCooperateApartmentParam.setCommissionRate((int) (rate * ((float)rateType/100)));
				adminFunCooperateApartmentParam.setCommissionType(2);
			}
		}
		// 优客才重新计算城市那些，之后也会去掉
		if(OpenApiConfig.THIRD_USER_DATA.get("G1AT9S").getAppId().equals(appId)) {
			// 修改城市ID和区域ID为我们系统的，通过城市名和匹配
			// 没传城市名直接修改为空，防止查询时出错
			adminFunCooperateApartmentParam.setCityId(null);
			adminFunCooperateApartmentParam.setHftRegId(null);
			adminFunCooperateApartmentParam.setHftSectionId(null);
			// 设置城市ID
			if(StringUtils.isNotBlank(adminFunCooperateApartmentParam.getCityName())) {
				AdminFunCity adminFunCity = adminFunCityMapper.selectCitybyCityName(adminFunCooperateApartmentParam.getCityName());
				if (adminFunCity != null) {
					adminFunCooperateApartmentParam.setCityId(adminFunCity.getCityId().intValue());
					// 设置片区ID
					if(StringUtils.isNotBlank(adminFunCooperateApartmentParam.getHftRegName())) {
						AdminFunReg adminFunReg = adminFunRegMapper.selectByCityAndRegName(adminFunCity.getCityId().intValue(), adminFunCooperateApartmentParam.getHftRegName());
						if (adminFunReg != null) {
							adminFunCooperateApartmentParam.setHftRegId(adminFunReg.getRegId());
							// 设置板块ID
							if(StringUtils.isNotBlank(adminFunCooperateApartmentParam.getHftSectionName())) {
								List<SelectDto> sectionList = adminFunSectionMapper.selectSectionByRegIdAndSectionName(adminFunReg.getRegId(),adminFunCooperateApartmentParam.getHftSectionName());
								if (sectionList != null && sectionList.size() > 0) {
									SelectDto selectDto = sectionList.get(0);
									adminFunCooperateApartmentParam.setHftSectionId(selectDto.getText());
									adminFunCooperateApartmentParam.setHftSectionName(selectDto.getValue());
								}
							}
						}
					}
				}
			}
		}
		// x坐标不能转换则不保存
		if(adminFunCooperateApartmentParam.getxCoord() != null) {
			Double parseDouble = StringUtil.parseDouble(adminFunCooperateApartmentParam.getxCoord(), 0);
			if(parseDouble == null || parseDouble == 0) {
				adminFunCooperateApartmentParam.setxCoord(null);
			}
		}
		// y坐标不能转换则不保存
		if(adminFunCooperateApartmentParam.getyCoord() != null) {
			Double parseDouble = StringUtil.parseDouble(adminFunCooperateApartmentParam.getyCoord(), 0);
			if(parseDouble == null || parseDouble == 0) {
				adminFunCooperateApartmentParam.setyCoord(null);
			}
		}
		// 整租，但是有多个房间的数据--合并房间到房源表
		if(adminFunCooperateApartmentParam.getRentType() != null && adminFunCooperateApartmentParam.getRentType() == 1) {
			List<AdminFunApartmentRoomParam> apartmentRoomList = adminFunCooperateApartmentParam.getRoomList();
			if(apartmentRoomList != null && apartmentRoomList.size() > 0) {
				AdminFunApartmentRoomParam adminFunApartmentRoomParam = apartmentRoomList.get(0);
				adminFunApartmentRoomParam.setListShow((byte)1);
				// 复制多个房间成多个房源
				adminFunApartmentRoomParam.setIsRentList((byte) 0);
				AdminFunCooperateApartmentParam apartmentTemp = new AdminFunCooperateApartmentParam();
				apartmentTemp.setRealUuid(adminFunCooperateApartmentParam.getUuid());
				// 先复制以前房源的信息
				this.copyApartmentToApartment(apartmentTemp, adminFunCooperateApartmentParam);
				// 再复制房间信息，顺序不能改
				this.copyRoomToApartment(apartmentTemp, adminFunApartmentRoomParam);
				apartmentTemp.setUuid(adminFunApartmentRoomParam.getUuid());// 房源ID改为房间ID
				// 复制房源图片
				List<AdminFunApartmentPhoto> photoList = new LinkedList<AdminFunApartmentPhoto>();
				photoList.addAll(adminFunCooperateApartmentParam.getPhotoList());
				photoList.addAll(adminFunApartmentRoomParam.getPhotoList());// 复制所有的房间图片
				// 改所有房源图片为当前房源id关联
				for (AdminFunApartmentPhoto photo : photoList) {
					if(photo == null) {
						continue;
					}
					photo.setApartmentUuid(apartmentTemp.getUuid());
					// 重置uuid，不然多个房间不会复制新的图片，一直是一套，而且有问题
					photo.setUuid(EncryptUtil.md5Digest(photo.getUuid()+"_"+apartmentTemp.getUuid()));
				}
				apartmentTemp.setPhotoList(photoList);
				// 插入房源列表
				this.insertApartment(apartmentTemp, appId);
				// 返回了，不再重复插入
				return new DefaultResponseJson(Const.ResponseCode.SUCCESS);
			}
		}
		this.insertApartment(adminFunCooperateApartmentParam, appId);
		return new DefaultResponseJson(Const.ResponseCode.SUCCESS);
	}
	
	/**
	 * 复制房间信息到房源
	 * @author 张宏利
	 * @since 2016年12月21日
	 * @param apartment
	 * @param room
	 */
	private void copyRoomToApartment(AdminFunCooperateApartmentParam apartment, AdminFunApartmentRoomParam room) {
		if(room.getBedRoomType() != null) {
			apartment.setBedRoomType(room.getBedRoomType());//": "出租屋类型，枚举值。 1=主卧 2=次卧 例如（主卧）：1",
		}
		if(room.getCheckInTime() != null) {
			apartment.setCheckInTime(room.getCheckInTime());//": "入住时间",
		}
		if(StringUtils.isNotBlank(room.getHouseDesc())) {
			apartment.setHouseDesc(room.getHouseDesc());//": "房间描述（50-500字以内）",
		}
		if(room.getImmediatelyCheckIn() != null) {
			apartment.setImmediatelyCheckIn(room.getImmediatelyCheckIn());//": "是否能立即入住 1=是",
		}
		if(StringUtils.isNotBlank(room.getHouseNum())) {
			apartment.setHouseNum(room.getHouseNum());//": "房间编号，单间出租时的编号",
		}
		if(room.getIsRent() != null) {
			apartment.setIsRent(room.getIsRent());//": "是否已租出 1=已租出",
		}
		if(room.getMonthRent() != null) {
			apartment.setMonthRent(room.getMonthRent());//": "以元为单位 例如（2100元/月）：2100",
		}
		if(room.getCommissionRate() != null) {
			apartment.setCommissionRate(room.getCommissionRate());//": "分佣比例列如：30（代表30%）",
		}
		if(room.getCommissionType() != null) {
			apartment.setCommissionType(room.getCommissionType());//": "分佣类型",
		}
		if(room.getRentCustSex() != null) {
			apartment.setRentCustSex(room.getRentCustSex().intValue());//": "租客性别 0=男生 1=女生",
		}
		if(room.getRentRoomArea() != null) {
			apartment.setRentRoomArea(room.getRentRoomArea());//": "对于单间出租的，为出租间面积 对于整租的为房屋总面积 单位（㎡）不支持小数 例如：110",
		}
		if(room.getRentStartDate() != null) {
			apartment.setRentStartDate(room.getRentStartDate());//": "起租时间 例：2015-12-31 12:10:00",
		}
		if(room.getRoomStatus() != null) {
			apartment.setHouseStatus(room.getRoomStatus().intValue());//": "房间状态 0=无效 1=有效 2=已出租",
		}
		if(room.getSexRequire() != null) {
			apartment.setSexRequire(room.getSexRequire());//": "租客性别要求，0=全男生，1=全女生，2=无所谓",
		}
		if(room.getShortRent() != null) {
			apartment.setShortRent(room.getShortRent());//": "是否支持短租，枚举值 0=不支持 1=支持 例如(支持短租)：1",
		}
		apartment.setUuid(room.getUuid());//": "房间唯一UUID",
		if(StringUtils.isNotBlank(room.getDetailPoint())) {
			apartment.setDetailPoint(room.getDetailPoint());//":"房屋配置，枚举值，可多选，以逗号分隔 1=床 2=衣柜 3=书桌 4=空调 5=暖气 6=电视机 7=燃气 8=微波炉 9=电磁炉 10=热水器 11=洗衣机 12=冰箱",
		}
		if(StringUtils.isNotBlank(room.getFeatureTag())) {
			apartment.setFeatureTag(room.getFeatureTag());//":"房间标签，枚举值，可多选，以
		}
		if(room.getOutRoomId() != null) {
			apartment.setOutRoomId(room.getOutRoomId());//第三方房间ID
		}
	}
	
	/**
	 * 复制原始房源信息到房源
	 * @author 张宏利
	 * @since 2016年12月21日
	 * @param apartment
	 */
	private void copyApartmentToApartment(AdminFunCooperateApartmentParam apartment, AdminFunCooperateApartmentParam source) {
		apartment.setRoomList(source.getRoomList());
		apartment.setAppId(source.getAppId());
		apartment.setAptPostJson(source.getAptPostJson());
		apartment.setHouseStatus(source.getHouseStatus());//房屋状态 1=有效 2=已下架",
		apartment.setAgentName(source.getAgentName());//房管员姓名",
		apartment.setAgentPhoto(source.getAgentPhoto());//房管员头像地址url",
		apartment.setAgentPhone(source.getAgentPhone());//房管员手机号例如：13466666666",
		apartment.setHouseTitle(source.getHouseTitle());//房源标题（100个中文字符以内）",
		apartment.setApartmentFitment(source.getApartmentFitment());//装修，枚举 1=毛坯 2=普通 3=精装 4=中等 5=高档 6=豪装 7=均可",
		apartment.setAptBuildId(source.getAptBuildId());//第3方公寓楼盘ID",
		apartment.setAptBuildName(source.getAptBuildName());//第3方公寓楼盘名称",
		apartment.setBedRoomNum(source.getBedRoomNum());//房屋户型-室 例如（2室）：2",
		apartment.setCheckInTime(source.getCheckInTime());//入住时间",
		apartment.setCityId(source.getCityId());//城市ID",
		apartment.setCityName(source.getCityName());//城市名字",
		apartment.setCommissionRate(source.getCommissionRate());//分佣比例列如：30（代表30%）",
		apartment.setCommissionType(source.getCommissionType());//": "分佣类型",
		apartment.setDetailPoint(source.getDetailPoint());//房屋配置，枚举值，可多选，以逗号分隔 1=床 2=衣柜 3=书桌 4=空调 5=暖气 6=电视机 7=燃气 8=微波炉 9=电磁炉 10=热水器 11=洗衣机 12=冰箱",
		apartment.setFaceToType(source.getFaceToType());//朝向，枚举值。 0=东 1=南 2=西 3=北 4=东南 5=西南 6=东北 7=西北 8=东西 9=南北 例如（朝南）：1",
		apartment.setFeatureTag(source.getFeatureTag());//房间标签，枚举值，可多选，以逗号分隔 1=离地铁近 2=独立阳台 3=独立卫生间 4=厨房 5=公共阳台 6=公共卫生间 例如（离地铁近，有阳台）：1,2",
		apartment.setHftBuildId(source.getHftBuildId());//合作公寓楼盘所在楼盘的ID",
		apartment.setHftBuildName(source.getHftBuildName());//公寓楼盘名称对应好房通楼盘系统名称 如：红树湾",
		apartment.setHftRegId(source.getHftRegId());//楼盘所在区域的ID对应好房通区域ID",
		apartment.setHftRegName(source.getHftRegName());//公寓楼盘所在区域的名称对应好房通系统名称 如：高新区",
		apartment.setHftSectionId(source.getHftSectionId());//公寓楼盘所在板块ID对应好房通板块ID",
		apartment.setHftSectionName(source.getHftSectionName());//公寓楼盘所在板块的名称对应好房通系统板块名称 如：红星路南延线",
		apartment.setHouseDesc(source.getHouseDesc());//房间描述（50-500字以内）",
		apartment.setHouseFloor(source.getHouseFloor());//房间所在楼层 例如（房屋在5楼）：5",
		apartment.setImmediatelyCheckIn(source.getImmediatelyCheckIn());//是否可以立即入住 0=不能 1=能",
		apartment.setIsBProducts(source.getIsBProducts());//是否在B端展示 0=不展示 1=展示",
		apartment.setIsCProducts(source.getIsCProducts());//是否在C端展示 0=不展示 1=展示",
		apartment.setIsRent(source.getIsRent());//是否出租 0=未租 1=已租",
		apartment.setLivingRoomNum(source.getLivingRoomNum());//房屋户型-厅 例如（1室）：1 可以为0",
		apartment.setMonthRent(source.getMonthRent());//月租金，以元为单位 例如（2100元/月）：2100",
		apartment.setOutHouseId(source.getOutHouseId());//合作公寓系统的房屋id",
		apartment.setOutHouseNo(source.getOutHouseNo());//合作公寓编号",
		apartment.setRentCustSex(source.getRentCustSex());//租客性别 0=男生 1=女生",
		apartment.setRentRoomArea(source.getRentRoomArea());//对于单间出租的，为出租间面积 对于整租的为房屋总面积 单位（㎡）不支持小数 例如：110",
		apartment.setRentStartDate(source.getRentStartDate());//起租时间 例：2015-12-31 12:00:12",
		apartment.setRentType(source.getRentType());//出租方式，枚举值 1=整套出租 2=单间出租 例如：1",
		apartment.setServicePoint(source.getServicePoint());//公寓配套服务，枚举值，可多选，以逗号分隔 1=健身房 2=公寓超市 3=智能门锁 4=ATM机 5=代收快递 6=专属客服 7=房间清洁",
		apartment.setServicePublic(source.getServicePublic());//公共区域设施，当公寓出租方式为整租时，才有该值，枚举值 1=公共储物区 2=餐桌 3=餐椅 4=冰箱 5=洗衣机 6=热水器 7=浴霸 8=公用厨房",
		apartment.setSexRequire(source.getSexRequire());//租客性别要求，0=全男生，1=全女生，2=无所谓",
		apartment.setShortRent(source.getShortRent());//是否支持短租，枚举值 0=不支持 1=支持 例如(支持短租)：1",
		apartment.setStreet(source.getStreet());//房屋所在小区详细地址 例如：高新中和二街22号",
		apartment.setSubwayLine(source.getSubwayLine());//房屋附近地铁站所在线路名 例如：1号线",
		apartment.setSubwayStation(source.getSubwayStation());//房屋附近地铁站名 例如：上海南站",
		apartment.setToiletNum(source.getToiletNum());//房屋户型-卫 例如（1卫）：1 可以为0",
		apartment.setTotalFloor(source.getTotalFloor());//楼层总数 例如（18层高的楼房）：18",
		apartment.setUpdateTime(source.getUpdateTime());//合作公寓更新时间",
		apartment.setUuid(source.getUuid());//每条信息一个唯一的UUID",
		apartment.setVideoUrl(source.getVideoUrl());//合作公寓系统的房屋视频url",
		apartment.setxCoord(source.getxCoord());//房间位置标注-经度 例如：116.506584",
		apartment.setyCoord(source.getyCoord());//房间位置标注-纬度 例如：39.973175"
		apartment.setOutRoomId(source.getOutRoomId());//第三方房间ID
	}
	
	private void insertApartment(AdminFunCooperateApartmentParam adminFunCooperateApartmentParam, String appId) {
		String apartmentUuid = adminFunCooperateApartmentParam.getUuid();
		AdminFunCooperateApartment oldApartment = adminFunCooperateApartmentMapper.selectByPrimaryKey(apartmentUuid);
		//------复制老数据处理-----只写字段参与了逻辑控制，如果第三方没传就会导致一些逻辑出问题，没传时使用老数据来处理
		Byte rentType = null;
		String livingRoomNum = null;
		String toiletNum = null;
		String featureTag = null;
		Byte isBProducts = null;
		String agentPhone = null;
		String houseNum = null;
		if(oldApartment != null) {
			rentType = oldApartment.getRentType();
			livingRoomNum = oldApartment.getLivingRoomNum();
			toiletNum = oldApartment.getToiletNum();
			featureTag = oldApartment.getFeatureTag();
			isBProducts = oldApartment.getIsBProducts();
			agentPhone = oldApartment.getAgentPhone();
			houseNum = oldApartment.getHouseNum();
		}
		if(adminFunCooperateApartmentParam.getRentType() != null) {
			rentType = adminFunCooperateApartmentParam.getRentType();
		}
		rentType = Optional.ofNullable(rentType).orElse((byte)0);
		if(adminFunCooperateApartmentParam.getLivingRoomNum() != null) {
			livingRoomNum = adminFunCooperateApartmentParam.getLivingRoomNum();
		}
		if(adminFunCooperateApartmentParam.getToiletNum() != null) {
			toiletNum = adminFunCooperateApartmentParam.getToiletNum();
		}
		if(adminFunCooperateApartmentParam.getFeatureTag() != null) {
			featureTag = adminFunCooperateApartmentParam.getFeatureTag();
		}
		if(adminFunCooperateApartmentParam.getIsBProducts() != null) {
			isBProducts = adminFunCooperateApartmentParam.getIsBProducts();
		}
		if(adminFunCooperateApartmentParam.getAgentPhone() != null) {
			agentPhone = adminFunCooperateApartmentParam.getAgentPhone();
		}
		if(adminFunCooperateApartmentParam.getHouseNum() != null) {
			houseNum = adminFunCooperateApartmentParam.getHouseNum();
		}
		//------复制老数据处理-----
		// 默认首图为空，之后重新生成
		adminFunCooperateApartmentParam.setThumbUrl(null);
		// 清空合租时不需要的字段
		if(rentType != null && rentType == 2) {
			adminFunCooperateApartmentParam.setCheckInTime(null);//": "入住时间",
			adminFunCooperateApartmentParam.setImmediatelyCheckIn(null);//": "是否能立即入住 1=是",
			adminFunCooperateApartmentParam.setIsRent(null);//": "是否已租出 1=已租出",
			adminFunCooperateApartmentParam.setMonthRent(null);//": "以元为单位 例如（2100元/月）：2100",
			adminFunCooperateApartmentParam.setRentCustSex(null);//": "租客性别 0=男生 1=女生",
			adminFunCooperateApartmentParam.setDetailPoint(null);//":"房屋配置，枚举值，可多选，以逗号分隔 1=床 2=衣柜 3=书桌 4=空调 5=暖气 6=电视机 7=燃气 8=微波炉 9=电磁炉 10=热水器 11=洗衣机 12=冰箱",
			adminFunCooperateApartmentParam.setFeatureTag(null);//":"房间标签，枚举值，可多选，以
			// 没传厅时默认1
			if(StringUtils.isBlank(livingRoomNum)) {
				adminFunCooperateApartmentParam.setLivingRoomNum("1");
			}
			// 没传卫时默认1
			if(StringUtils.isBlank(toiletNum)) {
				adminFunCooperateApartmentParam.setToiletNum("1");
			}
		} else {
			// 处理标签
			featureTag = getFeatureTag(featureTag, appId);
			adminFunCooperateApartmentParam.setFeatureTag(featureTag);
		}
		// 是B端数据
		if(isBProducts == null || isBProducts == 1) {
			adminFunCooperateApartmentParam.setIsBProducts((byte) 1);
			// 400电话开头的数据不能在B端展示
			if(StringUtils.isNotBlank(agentPhone) && agentPhone.startsWith("400")) {
				adminFunCooperateApartmentParam.setIsBProducts((byte) 0);
			}
		}

		// 存在时更新，不存在是新增
		if(oldApartment == null){
			adminFunCooperateApartmentParam.setSexNow((byte) 0);
			adminFunCooperateApartmentParam.setCreationTime(new Date());

			// 默认c 展示
			if(null == adminFunCooperateApartmentParam.getIsCProducts()) {
				adminFunCooperateApartmentParam.setIsCProducts((byte) 1);
			}
			adminFunCooperateApartmentMapper.insertSelective(adminFunCooperateApartmentParam);
		} else {
			adminFunCooperateApartmentMapper.updateByPrimaryKeySelective(adminFunCooperateApartmentParam);
		}
		List<AdminFunApartmentPhoto> apartmentPhotoList = adminFunCooperateApartmentParam.getPhotoList();
		if(apartmentPhotoList != null){
			for(AdminFunApartmentPhoto apartmentPhoto : apartmentPhotoList){
				if(apartmentPhoto == null || StringUtils.isBlank(apartmentPhoto.getUuid())){
					continue;
				}
				if (apartmentPhoto.getPhotoAddr() != null && apartmentPhoto.getPhotoAddr().startsWith("//image")) {
					apartmentPhoto.setPhotoAddr("http:" + apartmentPhoto.getPhotoAddr());
				}
				apartmentPhoto.setPhotoType((byte) 0);
				apartmentPhoto.setHouseNum(houseNum);
				apartmentPhoto.setApartmentUuid(apartmentUuid);
				AdminFunApartmentPhoto photoSelect = adminFunApartmentPhotoMapper.selectByPrimaryKey(apartmentPhoto.getUuid());
				//判断该条记录数据库是否存在,不存在插入,存在则更新
				if (photoSelect != null) {
					adminFunApartmentPhotoMapper.updateByPrimaryKeySelective(apartmentPhoto);
				} else {
					apartmentPhoto.setCreateTime(new Date());
					adminFunApartmentPhotoMapper.insertSelective(apartmentPhoto);
				}
			}
		}
		// 处理房间和房间的图片
		List<AdminFunApartmentRoomParam> apartmentRoomList = adminFunCooperateApartmentParam.getRoomList();
		if(apartmentRoomList != null && apartmentRoomList.size() > 0){
			for (AdminFunApartmentRoomParam adminFunApartmentRoomParam : apartmentRoomList) {
				if(adminFunApartmentRoomParam == null || StringUtils.isBlank(adminFunApartmentRoomParam.getUuid())){
					continue;
				}
				// 分佣比例计算为金额
				Integer rate = adminFunApartmentRoomParam.getCommissionRate();
				Integer rateType = adminFunApartmentRoomParam.getCommissionType();
				if(rate != null && rateType != null) {
					if(rateType == 1) {
						adminFunApartmentRoomParam.setCommissionRate((int) (rate * ((float)rateType/100)));
						adminFunApartmentRoomParam.setCommissionType(2);
					}
				}
				AdminFunApartmentRoom roomSelect = adminFunApartmentRoomMapper.selectByPrimaryKey(adminFunApartmentRoomParam.getUuid());
				// 不是B端的数据强制清空分拥金额
				//------复制老数据处理-----
				Integer houseIsBProducts = null;
				String outRoomId = null;
				if(roomSelect != null) {
					houseIsBProducts = roomSelect.getIsBProducts();
					outRoomId = roomSelect.getOutRoomId();
					featureTag = roomSelect.getFeatureTag();
				}
				if(adminFunApartmentRoomParam.getIsBProducts() != null) {
					houseIsBProducts = adminFunApartmentRoomParam.getIsBProducts();
				}
				if(adminFunApartmentRoomParam.getOutRoomId() != null) {
					outRoomId = adminFunApartmentRoomParam.getOutRoomId();
				}
				if(adminFunApartmentRoomParam.getFeatureTag() != null) {
					featureTag = adminFunApartmentRoomParam.getFeatureTag();
				}
				if(houseIsBProducts == null || houseIsBProducts == 0) {
					adminFunApartmentRoomParam.setCommissionRate(0);
				}
				//------复制老数据处理-----
				// 暂时的解决方案，不是整形时不保存，为了app端不报错，app修改上线后删除这个逻辑
				int outRoomIdInt = StringUtil.parseInteger(outRoomId, 0);
				adminFunApartmentRoomParam.setOutRoomId(String.valueOf(outRoomIdInt));
				
				adminFunApartmentRoomParam.setThumbUrl(null);
				// 处理标签
				featureTag = getFeatureTag(featureTag, appId);
				adminFunApartmentRoomParam.setFeatureTag(featureTag);
				adminFunApartmentRoomParam.setApartmentUuid(apartmentUuid);
				// 房间插入到数据库
				//判断该条记录数据库是否存在,不存在插入,存在则更新

				// 整租
				if (1 == rentType) {
					Integer houseStatus = Optional.ofNullable(adminFunCooperateApartmentParam.getHouseStatus()).orElse(1);
					adminFunApartmentRoomParam.setMonthRentList(adminFunCooperateApartmentParam.getMonthRent());
					adminFunApartmentRoomParam.setRoomStatusList(houseStatus.byteValue());
					adminFunApartmentRoomParam.setMonthRentList(adminFunCooperateApartmentParam.getMonthRent());
					String immediatelyCheckInList = adminFunApartmentRoomParam.getImmediatelyCheckInList();
					if(StringUtils.isBlank(immediatelyCheckInList) || "null".equals(immediatelyCheckInList.toLowerCase())) {
						immediatelyCheckInList = "0";
					}
					adminFunApartmentRoomParam.setImmediatelyCheckInList(immediatelyCheckInList);
					adminFunApartmentRoomParam.setCheckInTimeList(adminFunCooperateApartmentParam.getCheckInTime());
					adminFunApartmentRoomParam.setRentRoomAreaList(adminFunCooperateApartmentParam.getRentRoomArea());
					adminFunApartmentRoomParam.setFeatureTagList(adminFunCooperateApartmentParam.getFeatureTag());
					adminFunApartmentRoomParam.setPhotoCountList(adminFunCooperateApartmentParam.getPhotoCount());
				}else {
					// 合租
					adminFunApartmentRoomParam.setListShow((byte)1);
					adminFunApartmentRoomParam.setRoomStatusList(adminFunApartmentRoomParam.getRoomStatus());
					adminFunApartmentRoomParam.setMonthRentList(adminFunApartmentRoomParam.getMonthRent());
					String immediatelyCheckInList = adminFunApartmentRoomParam.getImmediatelyCheckInList();
					if(StringUtils.isBlank(immediatelyCheckInList) || "null".equals(immediatelyCheckInList.toLowerCase())) {
						immediatelyCheckInList = "0";
					}
					adminFunApartmentRoomParam.setImmediatelyCheckInList(immediatelyCheckInList);
					adminFunApartmentRoomParam.setCheckInTimeList(adminFunApartmentRoomParam.getCheckInTime());
					adminFunApartmentRoomParam.setRentRoomAreaList(adminFunApartmentRoomParam.getRentRoomArea());
					adminFunApartmentRoomParam.setFeatureTagList(adminFunApartmentRoomParam.getFeatureTag());
					adminFunApartmentRoomParam.setPhotoCountList(adminFunApartmentRoomParam.getPhotoCount());
				}
				if (roomSelect != null) {
					if(2 == rentType) {
						Byte isRent = Optional.ofNullable(adminFunApartmentRoomParam.getIsRent()).orElse((byte)0);
						Byte roomStatus = Optional.ofNullable(adminFunApartmentRoomParam.getRoomStatus()).orElse((byte)0);
						if(isRent != 1 && roomStatus == 1) {
							adminFunApartmentRoomParam.setIsRentList((byte) 0);
						}else if(isRent == 1 || roomStatus == 0) {
							adminFunApartmentRoomParam.setIsRentList((byte) 1);
						}
					}else {
						Integer houseStatus = Optional.ofNullable(adminFunCooperateApartmentParam.getHouseStatus()).orElse(1);
						adminFunApartmentRoomParam.setIsRentList(1== houseStatus ? (byte)0: (byte)1);
					}
					adminFunApartmentRoomParam.setUpdateTime(new Date());
					adminFunApartmentRoomMapper.updateByPrimaryKeySelective(adminFunApartmentRoomParam);
				} else {
					adminFunApartmentRoomParam.setCreationTime(new Date());
					adminFunApartmentRoomMapper.insertSelective(adminFunApartmentRoomParam);
				}
				List<AdminFunApartmentPhoto> photoList = adminFunApartmentRoomParam.getPhotoList();
				if(photoList == null) {
					continue;
				}
				// 处理房间图片列表
				for (AdminFunApartmentPhoto apartmentPhoto : photoList) {
					if(apartmentPhoto == null || StringUtils.isBlank(apartmentPhoto.getUuid())) {
						continue;
					}
					if (apartmentPhoto.getPhotoAddr() != null && apartmentPhoto.getPhotoAddr().startsWith("//image")) {
						apartmentPhoto.setPhotoAddr("http:" + apartmentPhoto.getPhotoAddr());
					}
					apartmentPhoto.setPhotoType((byte) 1);
					apartmentPhoto.setHouseNum(adminFunApartmentRoomParam.getHouseNum());
					apartmentPhoto.setApartmentUuid(apartmentUuid);
					apartmentPhoto.setRoomUuid(adminFunApartmentRoomParam.getUuid());
					AdminFunApartmentPhoto photoSelect = adminFunApartmentPhotoMapper.selectByPrimaryKey(apartmentPhoto.getUuid());
					if(photoSelect != null) {
						adminFunApartmentPhotoMapper.updateByPrimaryKeySelective(apartmentPhoto);
					} else {
						apartmentPhoto.setCreateTime(new Date());
						adminFunApartmentPhotoMapper.insertSelective(apartmentPhoto);
					}
				}
				// 修改首图和图片总数
				AdminFunApartmentPhoto mainPhoto = adminFunApartmentPhotoMapper.getMainPhoto(apartmentUuid, adminFunApartmentRoomParam.getUuid());
				AdminFunApartmentRoom roomUpdate = new AdminFunApartmentRoom();
				if(mainPhoto != null) {
					roomUpdate.setThumbUrl(mainPhoto.getPhotoAddr());
					// 1-2-3排序，查询出来的一张图片都是户型图，那就说明全是户型图，那就不在C端展示了
					if(mainPhoto.getPhotoClassic() == 3) {
						roomUpdate.setIsCProducts(0);
					}
				} else {
					roomUpdate.setIsCProducts(0);// 没图不在c端展示
				}
				int photoCount = adminFunApartmentPhotoMapper.getPhotoCount(apartmentUuid, adminFunApartmentRoomParam.getUuid());
				roomUpdate.setPhotoCount(photoCount);
				roomUpdate.setUuid(adminFunApartmentRoomParam.getUuid());
				adminFunApartmentRoomMapper.updateByPrimaryKeySelective(roomUpdate);
			}
		}
		AdminFunCooperateApartment apartmentUpdate = new AdminFunCooperateApartment();
		// 合租才会有有效房间列表和全男女
		if(rentType != null && rentType == 2) {
			// 修改有效房间到房源
			AdminFunApartmentRoom roomSelect = new AdminFunApartmentRoom();
			roomSelect.setApartmentUuid(apartmentUuid);
			List<AdminFunApartmentRoom> roomNumList = adminFunApartmentRoomMapper.getRoomNumList(roomSelect);
			if(roomNumList != null && !roomNumList.isEmpty()) {
				StringBuilder sb = new StringBuilder();
				int index = 0;
				for (AdminFunApartmentRoom adminFunApartmentRoom : roomNumList) {
					if(adminFunApartmentRoom == null) {
						continue;
					}
					// 有效的房间
					if(adminFunApartmentRoom.getRoomStatus() == 1) {
						if(index++ > 0) {
							sb.append(",");
						}
						sb.append(adminFunApartmentRoom.getHouseNum());
					}
				}
				if(sb.length() > 0) {
					apartmentUpdate.setRentRooms(sb.toString());
				}
				// 计算几室
				apartmentUpdate.setBedRoomNum(String.valueOf(roomNumList.size()));
			}
			// 全男，全女计算
			AdminApartmentCountDto countDto = adminFunApartmentRoomMapper.getRoomGirlBoyCount(apartmentUuid);
			if(countDto != null && countDto.getTotleCount() > 1) {
				if(countDto.getBoyCount() == countDto.getTotleCount()-1) {
					apartmentUpdate.setSexNow((byte) 1);
				} else if(countDto.getGirlCount() == countDto.getTotleCount()-1) {
					apartmentUpdate.setSexNow((byte) 2);
				} else {
					apartmentUpdate.setSexNow((byte) 0);
				}
			}
		}
		// 修改首图和图片总数
		AdminFunApartmentPhoto mainPhoto = adminFunApartmentPhotoMapper.getMainPhoto(apartmentUuid, null);
		if(mainPhoto != null) {
			apartmentUpdate.setThumbUrl(mainPhoto.getPhotoAddr());
			// 1-2-3排序，查询出来的一张图片都是户型图，那就说明全是户型图，那就不在C端展示了
			if(mainPhoto.getPhotoClassic() == 3) {
				apartmentUpdate.setIsCProducts((byte) 0);
			}
		} else {
			apartmentUpdate.setIsCProducts((byte) 0);// 没图不在c端展示
			apartmentUpdate.setThumbUrl(null);
		}
		int photoCount = adminFunApartmentPhotoMapper.getPhotoCount(apartmentUuid, null);
		apartmentUpdate.setPhotoCount(photoCount);
		apartmentUpdate.setUuid(apartmentUuid);
		adminFunCooperateApartmentMapper.updateByPrimaryKeySelective(apartmentUpdate);
	}
	
	private String getFeatureTag(String featureTag, String appId) {
		// 优客增加可月付标签
		if(OpenApiConfig.THIRD_USER_DATA.get("G1AT9S").getAppId().equals(appId)) {
			if(StringUtils.isBlank(featureTag)) {
				featureTag = "7";
			} else {
				featureTag = featureTag+",7";
			}
		}
		if(StringUtils.isNotBlank(featureTag)) {
			return ","+featureTag+",";
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(String.valueOf(null));
	}
}

// 房源没有uuid = 返回
// 查询数据库这个uuid的房源
// 有=通过uuid更新房源，没有=插入房源到数据库
//   有图片列表
//   图片没有uuid = 继续
//   查询数据库这个uuid的房源图片
//   有=通过uuid更新房源图片地址，没有=插入房源图片到数据库

//   有房间列表
//   房源房间没有uuid = 继续
//   查询数据库这个uuid的房源房间
//   有=通过uuid更新房源房间，没有=插入房源的房间到数据库
//      有图片列表
//      图片没有uuid = 继续
//      查询数据库这个uuid的房源房间图片
//      有=通过uuid更新房源房间图片地址，没有=插入房源房间图片到数据库



//厨房		19
//独立卫生间	18
//离地铁近		17
//公用厨房		16
//浴霸		15
//热水器		14
//洗衣机		13
//冰箱		12
//餐椅		11
//餐桌		10
//公共储物区	9
//无线WIFI	8
//挂钩		7
//穿衣镜		6
//台灯		5
//折叠椅		4
//衣柜		3
//书桌		2
//床			1
//----新加的----
//空调		20
//梳妆台		21
//穿衣镜		22
//电磁炉		23
//微波炉		24
//暖气		25
//沙发		26
//电视		27
//智能锁		28
//房屋清洁		29


//床			1
//桌子		10
//椅子		11
//衣柜		3
//WIFI		8
//热水器		14
//洗衣机		13
//冰箱		12
//厨房		16
//浴霸		15
//----新加的----
//空调		20
//梳妆台		21
//穿衣镜		22
//电磁炉		23
//微波炉		24
//暖气		25
//沙发		26
//电视		27
//智能锁		28
//房屋清洁		29







