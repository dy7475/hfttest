package com.myfun.erpWeb.openApi;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.admindb.param.AdminFunApartmentRoomParam;
import com.myfun.repository.admindb.param.AdminFunCooperateApartmentParam;
import com.myfun.repository.admindb.po.AdminFunApartmentPhoto;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

public class ApartmentOpenApiControllerTest extends BaseTestController{
	//public static String DOMAIN = "http://gray-erp.myfun7.com:9041/erpWeb";
	public static String DOMAIN = "http://192.168.0.249:8080/erpWeb";
	public static String accessToken = "2aaa112f059c55aaf25dcc9fb1d08bfff7ec99d18a6d86e97fd584c078b6007155244cfb0f0a5258d412e6f198b2f2400b2f1f0c1f658a5fe56aa88ffd1328d8";

	@Before
	public void init(){
		init(DOMAIN, accessToken);
	}
	
	@Test
	public void getAccessToken() {
		try {
			//for (int i = 0; i < 100; i++) {
				Map<String, String> param = new HashMap<String, String>();
				param.put("appId", "G1AT9S");
				param.put("appSecret", "968431345921");
				String result = HttpUtil.post(DOMAIN + "/openApi/getAccessToken", param);
				System.out.println(result);
			//}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void brokerShareRegister() throws Exception {
		
	}
	@Test
	public void syncApartmentData() throws Exception {
		try {
			String roomUuid = StringUtil.getUUIDBySub();
			String apratmentUuid = "123456789";
			AdminFunApartmentPhoto adminFunApartmentPhoto = new AdminFunApartmentPhoto();
			adminFunApartmentPhoto.setUuid(StringUtil.getUUIDBySub());
			adminFunApartmentPhoto.setPhotoAddr("http://www.baidu.com");
			adminFunApartmentPhoto.setPhotoStatus(Byte.valueOf("1"));
			adminFunApartmentPhoto.setPhotoType(Byte.valueOf("0"));
			adminFunApartmentPhoto.setPhotoClassic(Byte.valueOf("0"));
			adminFunApartmentPhoto.setPicTag(Byte.valueOf("0"));
			adminFunApartmentPhoto.setApartmentUuid(apratmentUuid);
			AdminFunApartmentPhoto adminFunApartmentPhoto1 = new AdminFunApartmentPhoto();
			adminFunApartmentPhoto1.setUuid(StringUtil.getUUIDBySub());
			adminFunApartmentPhoto1.setPhotoAddr("http://www.baidu.com");
			adminFunApartmentPhoto1.setPhotoStatus(Byte.valueOf("1"));
			adminFunApartmentPhoto1.setPhotoType(Byte.valueOf("1"));
			adminFunApartmentPhoto1.setApartmentUuid(apratmentUuid);
			AdminFunApartmentRoomParam adminFunApartmentRoomParam = new AdminFunApartmentRoomParam();
			adminFunApartmentRoomParam.getPhotoList().add(adminFunApartmentPhoto);
			adminFunApartmentRoomParam.getPhotoList().add(adminFunApartmentPhoto1);
			adminFunApartmentRoomParam.setUuid(roomUuid);
			adminFunApartmentRoomParam.setHouseNum("B");
			adminFunApartmentRoomParam.setCheckInTime(new Date());
			adminFunApartmentRoomParam.setHouseDesc("优质房间");
			adminFunApartmentRoomParam.setImmediatelyCheckIn(Byte.valueOf("0"));
			adminFunApartmentRoomParam.setIsRent(Byte.valueOf("0"));
			adminFunApartmentRoomParam.setMonthRent(BigDecimal.ONE);
			adminFunApartmentRoomParam.setRentCustSex(Byte.valueOf("0"));
			adminFunApartmentRoomParam.setRentRoomArea(new BigDecimal("10"));
			adminFunApartmentRoomParam.setRentStartDate(new Date());
			adminFunApartmentRoomParam.setRoomStatus(Byte.valueOf("0"));
			adminFunApartmentRoomParam.setSexRequire(Byte.valueOf("0"));
			adminFunApartmentRoomParam.setShortRent(Byte.valueOf("0"));
			AdminFunCooperateApartmentParam adminFunCooperateApartmentParam = new AdminFunCooperateApartmentParam();
			adminFunCooperateApartmentParam.getRoomList().add(adminFunApartmentRoomParam);
			adminFunCooperateApartmentParam.getPhotoList().add((AdminFunApartmentPhoto) BeanUtilsHelper.cloneBean(adminFunApartmentPhoto));
			adminFunCooperateApartmentParam.setStreet("天府一街");
			adminFunCooperateApartmentParam.setAgentName("李先生");
			adminFunCooperateApartmentParam.setAgentPhone("18515660454");
			adminFunCooperateApartmentParam.setApartmentFitment(Byte.valueOf("1"));
			adminFunCooperateApartmentParam.setAptBuildId(1);
			adminFunCooperateApartmentParam.setAptBuildName("红城");
			adminFunCooperateApartmentParam.setBedRoomNum("12");
			adminFunCooperateApartmentParam.setCheckInTime(new Date());
			adminFunCooperateApartmentParam.setCityName("成都市");
			adminFunCooperateApartmentParam.setCommissionRate(50);
			adminFunCooperateApartmentParam.setDetailPoint("1,2");
			adminFunCooperateApartmentParam.setFaceToType(Byte.valueOf("0"));
			adminFunCooperateApartmentParam.setFeatureTag("1,2");
			adminFunCooperateApartmentParam.setHftRegName("武侯区");
			adminFunCooperateApartmentParam.setHftSectionName("板块名称");
			adminFunCooperateApartmentParam.setHouseDesc("高档优质小区,交通方便...........");
			adminFunCooperateApartmentParam.setHouseFloor("12");
			adminFunCooperateApartmentParam.setImmediatelyCheckIn(Byte.valueOf("0"));
			adminFunCooperateApartmentParam.setIsBProducts(Byte.valueOf("0"));
			adminFunCooperateApartmentParam.setIsRent(Byte.valueOf("0"));
			adminFunCooperateApartmentParam.setLivingRoomNum("4");
			adminFunCooperateApartmentParam.setMonthRent(new BigDecimal(1000));
			adminFunCooperateApartmentParam.setOutHouseId("1201");
			adminFunCooperateApartmentParam.setOutHouseNo("cdsdkak000");
			adminFunCooperateApartmentParam.setRentCustSex(0);
			adminFunCooperateApartmentParam.setUuid("7e823b1de3394876a589c316e832d091");
			adminFunCooperateApartmentParam.setOutHouseId("1");
			adminFunCooperateApartmentParam.setVideoUrl("1");
			adminFunCooperateApartmentParam.setServicePoint("1");
			adminFunCooperateApartmentParam.setMonthRent(BigDecimal.ONE);
			adminFunCooperateApartmentParam.setRentStartDate(new Date());
			adminFunCooperateApartmentParam.setShortRent((byte) 1);
			adminFunCooperateApartmentParam.setStreet("1");
			adminFunCooperateApartmentParam.setSubwayLine("1");
			adminFunCooperateApartmentParam.setSubwayStation("1");
			adminFunCooperateApartmentParam.setxCoord("1");
			adminFunCooperateApartmentParam.setyCoord("1");
			adminFunCooperateApartmentParam.setAgentPhone("1");
			adminFunCooperateApartmentParam.setRentType((byte) 1);
			adminFunCooperateApartmentParam.setBedRoomNum("1");
			adminFunCooperateApartmentParam.setLivingRoomNum("1");
			adminFunCooperateApartmentParam.setToiletNum("1");
			adminFunCooperateApartmentParam.setRentRoomArea(BigDecimal.ONE);
			adminFunCooperateApartmentParam.setFaceToType((byte) 1);
			adminFunCooperateApartmentParam.setTotalFloor(1);
			adminFunCooperateApartmentParam.setHouseFloor("1");
			adminFunCooperateApartmentParam.setFeatureTag("1");
			adminFunCooperateApartmentParam.setAgentName("1");
			adminFunCooperateApartmentParam.setRentCustSex(1);
			adminFunCooperateApartmentParam.setSexRequire((byte) 1);
			adminFunCooperateApartmentParam.setIsRent((byte) 1);
			adminFunCooperateApartmentParam.setHftRegId(1);
			adminFunCooperateApartmentParam.setHftRegName("1");
			adminFunCooperateApartmentParam.setCommissionRate(1);
			adminFunCooperateApartmentParam.setApartmentFitment((byte) 1);
			adminFunCooperateApartmentParam.setServicePublic("1");
			adminFunCooperateApartmentParam.setUpdateTime(new Date());
			adminFunCooperateApartmentParam.setOutHouseNo("1");
			adminFunCooperateApartmentParam.setDetailPoint("1");
			adminFunCooperateApartmentParam.setCheckInTime(new Date());
			adminFunCooperateApartmentParam.setImmediatelyCheckIn((byte) 1);
			adminFunCooperateApartmentParam.setCityId(1);
			adminFunCooperateApartmentParam.setCityName("1");
			adminFunCooperateApartmentParam.setIsBProducts((byte) 1);
			adminFunCooperateApartmentParam.setHftBuildId(1);
			adminFunCooperateApartmentParam.setHftBuildName("1");
			adminFunCooperateApartmentParam.setHftSectionId("1");
			adminFunCooperateApartmentParam.setHftSectionName("1");
			adminFunCooperateApartmentParam.setAptBuildId(1);
			adminFunCooperateApartmentParam.setAptBuildName("1");
			adminFunCooperateApartmentParam.setHouseDesc("1");
			String result = postNewErp(adminFunCooperateApartmentParam, "openApi/syncApartment?accessToken=" + accessToken);
			System.out.println(result);
		} catch (Exception e) {
		}
	/*	String str ="{\"photoList\":[{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-31/6c394303-ca25-4b67-8cbc-2fc3d4cb7b29.png\",\"photoClassic\":1,\"photoStatus\":1,\"photoType\":1,\"picTag\":1,\"uuid\":\"adb109610b9f41798eed2f4fc2899957\"},{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-27/cb4e7a33-64e5-4638-ae0a-77b387920210.png\",\"photoClassic\":3,\"photoStatus\":1,\"photoType\":1,\"picTag\":1,\"uuid\":\"8198e1f39e634648a0d3929371ede547\"}],\"roomList\":[{\"checkInTime\":1481280376519,\"houseDesc\":\"\",\"houseNum\": \"A\",\"immediatelyCheckIn\":0,\"isRent\":0,\"monthRent\":820,\"photoList\":[{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-31/9476bc9d-f52e-4525-a5d7-6b2fcc9e5a1f.png\",\"photoClassic\":1,\"photoStatus\":1,\"photoType\":1,\"picTag\":1,\"uuid\":\"6842293478684518855be7dcc1678e49\"},{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-27/cb4e7a33-64e5-4638-ae0a-77b387920210.png\",\"photoClassic\":3,\"photoStatus\":1,\"photoType\":1,\"picTag\":2,\"uuid\":\"4681ce098d324487960aa1943bbb793s\"}],\"rentCustSex\":0,\"rentRoomArea\":22,\"rentStartDate\":1481280376519,\"roomStatus\":1,\"sexRequire\":2,\"shortRent\":0,\"uuid\":\"d335d269d933464484404ef326e073a8\"},{\"checkInTime\":1481280376520,\"houseDesc\":\"\",\"immediatelyCheckIn\":0,\"isRent\":1,\"monthRent\":900,\"photoList\":[{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-31/f604dd90-1d6b-4640-94a8-c2d22e8bed5a.png\",\"photoClassic\":1,\"photoStatus\":1,\"photoType\":1,\"picTag\":1,\"uuid\":\"2e91d1adffd743b788bcf13b45440a7a\"},{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-27/cb4e7a33-64e5-4638-ae0a-77b387920210.png\",\"photoClassic\":3,\"photoStatus\":1,\"photoType\":1,\"picTag\":2,\"uuid\":\"885f2211b89c4a1db32e11e14269f4d4\"}],\"rentCustSex\":0,\"rentRoomArea\":33,\"rentStartDate\":1481280376520,\"roomStatus\":1,\"sexRequire\":2,\"shortRent\":0,\"uuid\":\"b00f6d69148d43c5b4736dc6ae346bc9\"},{\"checkInTime\":1481280376520,\"houseDesc\":\"\",\"immediatelyCheckIn\":0,\"isRent\":0,\"monthRent\":750,\"photoList\":[{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d4\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-31/6e93ef33-9e17-4610-81ff-2f3b7fa8f76c.png\",\"photoClassic\":1,\"photoStatus\":1,\"photoType\":1,\"picTag\":1,\"uuid\":\"07864528878c45e3848d7acdf9f8e48a\"},{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-27/cb4e7a33-64e5-4638-ae0a-77b387920210.png\",\"photoClassic\":3,\"photoStatus\":1,\"photoType\":1,\"picTag\":2,\"uuid\":\"1e18fc9e4118424aab5890139e911869\"}],\"rentCustSex\":0,\"rentRoomArea\":44,\"rentStartDate\":1481280376520,\"roomStatus\":1,\"sexRequire\":2,\"shortRent\":0,\"uuid\":\"b1ace92f8c054bbaa85a1df4105b07ds\"},{\"checkInTime\":1481280376520,\"houseDesc\":\"\",\"immediatelyCheckIn\":0,\"isRent\":0,\"monthRent\":1200,\"photoList\":[{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-31/c32bbc9c-d6bd-4f09-8e4e-de85f8f96dd3.png\",\"photoClassic\":1,\"photoStatus\":1,\"photoType\":1,\"picTag\":1,\"uuid\":\"e0437e97ebb04ada9805825982a25e92\"},{\"apartmentUuid\":\"36b375d46c15428ca91dee0d1b0131d7\",\"photoAddr\":\"http://image.uoko.com/Upload/ShareImages/2016-10-27/cb4e7a33-64e5-4638-ae0a-77b387920210.png\",\"photoClassic\":3,\"photoStatus\":1,\"photoType\":1,\"picTag\":2,\"uuid\":\"93cb3a01b1e640f7afea51ecaa633f91\"}],\"rentCustSex\":0,\"rentRoomArea\":55,\"rentStartDate\":1481280376520,\"roomStatus\":1,\"sexRequire\":2,\"shortRent\":0,\"uuid\":\"c8edbc8e7f8d4ddb8e4f49a8e3ffda7b\"}],\"agentName\":\"优客小蜜\",\"agentPhone\":\"400-000-4170\",\"houseTitle\":null,\"apartmentFitment\":7,\"aptBuildId\":0,\"aptBuildName\":\"金沙海棠\",\"bedRoomNum\":\"\",\"bedRoomType\":2,\"checkInTime\":1481280376503,\"cityId\":278,\"cityName\":\"成都市\",\"commissionRate\":0,\"detailPoint\":\"1,3,2,12,11,10,7,4\",\"faceToType\":0,\"featureTag\":\"4,6\",\"hftBuildId\":0,\"hftBuildName\":\"\",\"hftRegId\":0,\"hftRegName\":\"\",\"hftSectionId\":\"\",\"hftSectionName\":\"\",\"houseDesc\":\"高新区 布鲁明顿 挑夫好房\",\"houseFloor\":12,\"houseNum\":\"A\",\"immediatelyCheckIn\":0,\"isBProducts\":0,\"isRent\":1,\"livingRoomNum\":\"0\",\"monthRent\":700,\"outHouseId\":28668,\"outHouseNo\":\"CDZ04472\",\"rentCustSex\":1,\"rentRoomArea\":11,\"rentStartDate\":1481280376518,\"rentType\":1,\"servicePoint\":\"7\",\"servicePublic\":\"1,2,3,4,5,6,7,8\",\"sexRequire\":2,\"shortRent\":0,\"street\":\"青羊区蜀鑫东路88号\",\"subwayLine\":\"\",\"subwayStation\":\"\",\"toiletNum\":\"1\",\"totalFloor\":30,\"updateTime\":1481280376518,\"uuid\":\"2684b5ff1ca3496386b90e2a8862b21f\",\"videoUrl\":\"\",\"xCoord\":\"103.999317\",\"yCoord\":\"30.688281\"}";
		String result = postNewErp(str, "openApi/syncApartment?accessToken=" + accessToken);
		System.out.println(result);*/
	}

}
