/**
 * @author 方李骥
 * @since 2016年9月5日
 */
package com.myfun.erpWeb.businesstools.builddic;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.businesstools.builddic.param.ErpRegisterBuildingSetRoofparam;
import com.myfun.repository.erpdb.param.ErpBuildingSetRoomParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetFloorParam;
import com.myfun.erpWeb.businesstools.builddic.param.ErpBuildingSetRoofParam;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;
import com.myfun.service.business.erpdb.bean.param.QueryBuildingListParam;

/**
 * @author 方李骥
 * @since 2016年9月5日
 */
public class FunBuildDicControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.175:8080/erpWeb", "http://192.168.0.175:80/hftWebService/web/api/authentication/per.do", "506504", "15114014557");
//		init("http://192.168.0.179:8001/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
//		init("http://192.168.0.137:8080/erpWeb", "http://192.168.11.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
		//init("http://192.168.5.175:8080/erpWeb", "http://192.168.5.175:8090/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://localhost:8080/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "508387", "13877776666");
		init("http://192.168.5.208:8080/erpWeb", "http://192.168.5.208:8080/hftWebService/web/api/authentication/per.do", "670483", "18381306721");//总经理账号
		
	}
	
	/**
	 * 楼盘字典列表
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	//{"BUILD_NAME":"A","CLIENTKEY":"ee464e6763d449472ac1b3cfa12fd636","PAGE_OFFSET":"1","PAGE_ROWS":"10","PAGE_ROW_TOTAL":"0"}
	@Test
	public void getBuildingList() throws Exception{
		QueryBuildingListParam  param = new QueryBuildingListParam();
		param.setBuildName("3");
		//param.setBuildId(2039175);
		//param.setPageOffset(1);
		//param.setPageRows(10);
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildingList"));
	}
	/**
	 * 
	 * @author 熊刚
	 * @since 2017年7月7日
	 * @throws Exception
	 */
	@Test
	public void getBuildDicInfo() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("buildId","2042504");
		System.out.println(postNewErp(paramMap,"businesstools/buildDic/getBuildDicInfo"));
	}
	
	/**
	 * 修改楼盘
	 * @author 熊刚
	 * @since 2017年7月7日
	 * @throws Exception
	 */
	@Test
	public void updateBuildDicInfo() throws Exception{
		BuildingInfoTmpParam buildingInfoTmpParam =new BuildingInfoTmpParam();
//		buildingInfoTmpParam.setBuildName("蓝谷地");
//		buildingInfoTmpParam.setBuildAddr("锦江区国槐街");
//		buildingInfoTmpParam.setBuildId(2044721);
//		buildingInfoTmpParam.setArchiveId(508357);
//		buildingInfoTmpParam.setProvinceId(123);
		buildingInfoTmpParam.setDataType((byte)1);
		buildingInfoTmpParam.setSectionName("测试");
		buildingInfoTmpParam.setRegionName("测试");
		buildingInfoTmpParam.setBuildRegion(1);
		buildingInfoTmpParam.setBuildRound("1");
		buildingInfoTmpParam.setBuildRound("1");
		buildingInfoTmpParam.setSectionMark("就是测试");
		System.out.println(postNewErp(buildingInfoTmpParam,"businesstools/buildDic/updateBuildDicInfo"));
	}
	
	/**
	 * 更新楼盘字典详细信息
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	//{"BUILD_NAME":"A","CLIENTKEY":"ee464e6763d449472ac1b3cfa12fd636","PAGE_OFFSET":"1","PAGE_ROWS":"10","PAGE_ROW_TOTAL":"0"}
	@Test
	public void updateComBuild() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("buildId","2022541");
		System.out.println(postNewErp(param,"buildDic/updateComBuild"));
	}
	/**
	 * 更新楼盘字典详细信息
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	//{"BUILD_NAME":"A","CLIENTKEY":"ee464e6763d449472ac1b3cfa12fd636","PAGE_OFFSET":"1","PAGE_ROWS":"10","PAGE_ROW_TOTAL":"0"}
	@Test
	public void getBuildDicPhotoList() throws Exception{
		 Calendar c = Calendar.getInstance();
	        //过去一月
	        c.setTime(new Date());
	        c.add(Calendar.MONTH, -1);
//	        Date monDate = c.getTime();
//	        String frontmonDate = DateTimeHelper.formatDateTimetoString(monDate, DateTimeHelper.FMT_yyyyMMdd);
		Map<String,String> param = new HashMap<String,String>();
		param.put("buildId","114");
		param.put("bound","1");
		System.out.println(postNewErp(param,"businesstools/buildDic/" +
				""));
	}
	
	/**
	 * 获取楼盘规则列表
	 * @author 臧铁
	 * @since 2017年8月9日
	 * @param  buildId 楼盘ID isLock 规则是否锁定
	 * @throws Exception
	 */
	@Test
	public void getBuildingRuleList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2042527");
//		pMap.put("houseUseage", "1");
		pMap.put("isLock", "1");
		System.out.println(postNewErp(pMap,"businesstools/buildDic/getBuildingRuleList"));
	}

	@Test
	public void getBuildingInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "1112725");
		//pMap.put("isLock", "1");
		System.out.println(postNewErp(pMap,"businesstools/buildDic/getBuildingInfo"));
	}

	/**
	 * 批量添加规则
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 * @return
	 */
	@Test
	public void batchImporFunBuildRules() throws Exception {
		//
		ErpBuildingSetParam param = new ErpBuildingSetParam();
		//param.setBuildRoof("5");		//是	栋座（名称）
		//param.setBuildUnitNum(3);	//	是	单元数，批量添加时必传
		param.setBuildFloors("10");	//	是	楼层数
		param.setBuildLadder("2");	//	是	梯数
		param.setBuildDoors("3");		//是	几户
//		param.setHouseType(houseType);		//是	建筑类型
		param.setHouseStruct((byte) 2);	//	是	建筑结构
		param.setHouseYear(2017);		//是	建筑年代
		param.setNumberRule((byte) 1);		//否	排号规则 1=按楼层排号，2=按单元排号
		param.setCompriseRule((byte) 1);	//	否	组成规则 1=户号，2=楼层+户号
		param.setBuildId(2043987);		//是	楼盘ID
		//param.setBuildUnit("4");		//否	单元（名称），单个添加时必填
		param.setRoofSuffixType(3);
		param.setRoofPrefix("A");
		param.setRoofSuffixStart("甲");
		param.setRoofSuffixEnd("丙");
		param.setUnitSuffixType(3);
		param.setUnitPrefix("A");
		param.setUnitSuffixStart("甲");
		param.setUnitSuffixEnd("丙");
		System.out.println(postNewErp(param,"businesstools/buildDic/batchImporFunBuildRules"));
	}
	
	/**
	 * 修改栋信息
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 * @return
	 */
	@Test
	public void updateBuildRoof() throws Exception {
		ErpBuildingSetParam param = new ErpBuildingSetParam();
		param.setOldBuildRoof("3");		//是	老的栋座（名称）
		param.setBuildRoof("2");		//是	栋座（名称）
		param.setBuildId(2043987);		//是	楼盘ID
		System.out.println(postNewErp(param,"businesstools/buildDic/updateBuildRoof"));
	}
	
	/**
	 * 修改栋座规则
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 * @return
	 */
	@Test
	public void updateBuildRule() throws Exception {
		ErpBuildingSetParam param = new ErpBuildingSetParam();
		param.setBuildRoof("2");		//是	栋座（名称）
		param.setBuildUnitNum(3);	//	是	单元数，批量添加时必传
		param.setBuildFloors("10");	//	是	楼层数
		param.setBuildLadder("2");	//	是	梯数
		param.setBuildDoors("3");		//是	几户
//		param.setHouseType(houseType);		//是	建筑类型
		param.setHouseStruct((byte) 2);	//	是	建筑结构
		param.setHouseYear(2017);		//是	建筑年代
		param.setNumberRule((byte) 1);		//否	排号规则 1=按楼层排号，2=按单元排号
		param.setCompriseRule((byte) 1);	//	否	组成规则 1=户号，2=楼层+户号
		param.setBuildId(2043987);		//是	楼盘ID
		param.setBuildUnit("4");		//否	单元（名称），单个添加时必填
		param.setBsId(1930);		//主键ID
		System.out.println(postNewErp(param,"businesstools/buildDic/updateBuildRule"));
	}
	
	/**
	 * 修改房间信息
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 * @return
	 */
	@Test
	public void updateRoomInfo() throws Exception {
		ErpBuildingSetRoomParam param = new ErpBuildingSetRoomParam();
		param.setBuildId(2043987);		//是	楼盘ID
		param.setSysRoomId("101");		//是	前端计算出的房间ID
		param.setRoomId("A101");			//是	用户填的的房间ID
		param.setHouseRoom((byte) 3);		//否	几室
		param.setHouseHall((byte) 2);		//否	几厅
		param.setHouseWei((byte) 2);		//否	几卫
		param.setHouseYang((byte) 1);		//否	阳台
		param.setHouseDirect((byte) 1);	//	否	朝向，DD：HOUSE_DIRECT
		param.setHouseArea(BigDecimal.valueOf(104));		//否	建筑面积
		param.setHouseInnerarea(BigDecimal.valueOf(89));	//	否	套内面积
		param.setBuildRoof("2");		//是	栋座
		param.setBuildUnit("4");		//是	单元
		System.out.println(postNewErp(param,"businesstools/buildDic/updateRoomInfo"));
	}
	
	/**
	 * 通过栋座+单元获取房间列表
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 * @return
	 */
	@Test
	public void getRoomInfoList() throws Exception {
		ErpBuildingSetRoomParam param = new ErpBuildingSetRoomParam();
		param.setBuildId(2043987);		//是	楼盘ID
		param.setBuildRoof("2");		//是	栋座
		param.setBuildUnit("4");		//是	单元
		System.out.println(postNewErp(param,"businesstools/buildDic/getRoomInfoList"));
	}

	/**
	 * 获取楼盘栋座列表
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 * @return
	 */
	@Test
	public void getBuildRoofList() throws Exception {
		ErpBuildingSetParam param = new ErpBuildingSetParam();
		param.setBuildId(2043987);		//是	楼盘ID
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildRoofList"));
	}
	
	/**
	 * 获取楼盘单元列表
	 * @author 张宏利
	 * @since 2017年8月21日
	 * @param param
	 * @return
	 */
	@Test
	public void getBuildUnitList() throws Exception {
		ErpBuildingSetParam param = new ErpBuildingSetParam();
		param.setBuildId(2043987);		//是	楼盘ID
		param.setBuildRoof("2");		//是	栋座
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildUnitList"));
	}
	
	/**
	 * 删除栋座
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座 
	 * @return
	 */
	@Test
	public void delBuildRoofById() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2043987");
		pMap.put("buildRoof", "2");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/delBuildRoofById"));
	}
	
	/**
	 * 删除单元
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元
	 * @return
	 */
	@Test
	public void delBuildUnitById() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2010090");
		pMap.put("buildRoof", "2");
		pMap.put("buildUnit", "3");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/delBuildUnitById"));
	}
	
	/**
	 * 删除房间
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元  sysRoomId前端计算出的房间号...
	 * @return
	 */
	@Test
	public void delBuildRoomById() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2010090");
		pMap.put("buildRoof", "2");
		pMap.put("roomFloors", "2");
		pMap.put("buildUnit", "4");
		pMap.put("sysRoomIds", "4");
		pMap.put("roomId", "4");
		pMap.put("houseRoom", "3");
		pMap.put("houseHall", "2");
		pMap.put("houseWei", "2");
		pMap.put("houseYang", "4");
		pMap.put("houseDirect", "7");
		pMap.put("houseArea", "114");
		pMap.put("houseInnerarea", "104");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/delBuildRoomById"));
	}
	
	/**
	 * 取消合并房间
	 * @return
	 */
	@Test
	public void cancelMergeRoomInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2010090");
		pMap.put("buildRoof", "2");
		pMap.put("buildUnit", "4");
		pMap.put("mergeRoom", "4");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/cancelMergeRoomInfo"));
	}
	
	/**
	 * 合并房间
	 * @return
	 */
	@Test
	public void mergeRoomInfo() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2010090");
		pMap.put("buildRoof", "2");
		pMap.put("buildUnit", "4");
		pMap.put("roomFloors", "2,2");
		pMap.put("sysRoomIds", "3,4");
		pMap.put("roomIds", "3,4");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/mergeRoomInfo"));
	}

	/**
	 * 获取单元、栋号、房间数
	 * @author 张宏利
	 * @since 2017年8月25日
	 * @param param
	 * @return
	 */
	@Test
	public void getRoofUnitRoomCount() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2039175");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/getRoofUnitRoomCount"));
	}
	
	/**
	 * 修改楼盘楼层名
	 * @author 张宏利
	 * @since 2017年10月10日
	 * @param param
	 * @return
	 */
	@Test
	public void updateBuildFloor() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2010090");
		pMap.put("buildRoof", "2");
		pMap.put("buildUnit", "4");
		pMap.put("sysBuildFloor", "4");
		pMap.put("buildFloor", "3.5");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/updateBuildFloor"));
	}
	
	/**
	 * 获取楼盘楼层名
	 * @author 张宏利
	 * @since 2017年10月10日
	 * @param param
	 * @return
	 */
	@Test
	public void getBuildFloorList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2010090");
		pMap.put("buildRoof", "2");
		pMap.put("buildUnit", "4");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/getBuildFloorList"));
	}

	@Test
	public void getSaleLeaseCount() throws Exception{
		ErpBuildingSetFloorParam erpBuildingSetFloorParam = new ErpBuildingSetFloorParam();
		erpBuildingSetFloorParam.setCaseRoof("测试租售");
		erpBuildingSetFloorParam.setCaseUnit("1");
		erpBuildingSetFloorParam.setBuildId(2044871);
		System.out.println(postNewErp(erpBuildingSetFloorParam,"/businesstools/buildDic/getSaleLeaseCount"));
	}
	@Test
	public void getSaleList() throws Exception{
		ErpBuildingSetFloorParam erpBuildingSetFloorParam = new ErpBuildingSetFloorParam();
		erpBuildingSetFloorParam.setCaseRoof("2");
		erpBuildingSetFloorParam.setCaseUnit("1");
		erpBuildingSetFloorParam.setCaseFloor("1");
		erpBuildingSetFloorParam.setBuildId(2017540);
		System.out.println(postNewErp(erpBuildingSetFloorParam,"/businesstools/buildDic/getSaleList"));
	}
	@Test
	public void getLeaseList() throws Exception{
		ErpBuildingSetFloorParam erpBuildingSetFloorParam = new ErpBuildingSetFloorParam();
		erpBuildingSetFloorParam.setCaseRoof("2");
		erpBuildingSetFloorParam.setCaseUnit("1");
		erpBuildingSetFloorParam.setCaseFloor("1");
		erpBuildingSetFloorParam.setBuildId(2017540);
		System.out.println(postNewErp(erpBuildingSetFloorParam,"/businesstools/buildDic/getLeaseList"));
	}
	@Test
	public void getHouseTotalData() throws Exception{
		ErpBuildingSetFloorParam erpBuildingSetFloorParam = new ErpBuildingSetFloorParam();
		erpBuildingSetFloorParam.setBuildId(2017540);
		erpBuildingSetFloorParam.setCaseRoof("2");
		erpBuildingSetFloorParam.setCaseUnit("2");
		System.out.println(postNewErp(erpBuildingSetFloorParam,"/businesstools/buildDic/getHouseTotalData"));
	}

	/**
	 * 云房获取价格走势
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/16
	 */
	@Test
	public void getBuildPriceTrend() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", "2033435");
		pMap.put("buildName", "百草路");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/getBuildPriceTrend"));
	}

	/**
	 * 清空楼盘规则
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	@Test
	public void delBuildById() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId",2000879);
		pMap.put("buildLock",0);
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/delBuildById"));
	}

	/**
	 * 新增楼盘字典
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/8
	 */	
	@Test
	public void insertComBuild() throws Exception{
		/*
		* {"buildName":"来咯哦哦哦哦哦","cityId":1,"buildRound":"2","userId":20319578,"positionX":"104.0754743126196","sectionId":"36716","buildRegion":"3210","positionY":"30.5396951857113","buildAddr":"天府软件园D区内,天府软件园-D6座附近21米"}
		* */
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildName","来咯哦哦哦哦哦");
		pMap.put("cityId",1);
		pMap.put("buildRound",2);
		pMap.put("userId","20319578");
		pMap.put("positionX","104.0754743126196");
		pMap.put("sectionId","36716");
		pMap.put("buildRegion","3210");
		pMap.put("positionY","30.5396951857113");
		pMap.put("buildAddr","天府软件园D区内,天府软件园-D6座附近21米");
		System.out.println(postNewErp(pMap,"/businesstools/buildDic/insertComBuild"));
	}

	/**
	 * 修改栋信息
	 * @author czq
	 * @since 2018年12月11日
	 */
	@Test
	public void updateBuildRoofNew() throws Exception {
		ErpBuildingSetRoofParam param = new ErpBuildingSetRoofParam();
		param.setBuildingSetRoofId(1);
		param.setBuildId(1);
		param.setBuildRoof("测试楼座");
		param.setHouseStruct(2);
		param.setHouseYear(2);
		param.setHouseType(2);
		param.setHouseUseage(2);
		param.setBuildLandAge(2);
		param.setBuildLandNature(2);
		param.setBuildRightNature(2);
		param.setBuildingManagerId(2);
		System.out.println(postNewErp(param,"businesstools/buildDic/updateBuildRoof"));
	}
	/**
	 * 获取楼盘规则列表
	 *
	 * @param param buildId 楼盘ID isLock 规则是否锁定
	 * @return
	 * @throws Exception
	 * @author 黄建海
	 * @since 2018年12月17日
	 */
	@Test
	public void getBuildingRuleListTest() throws Exception {
		ErpRegisterBuildingSetRoofparam param=new ErpRegisterBuildingSetRoofparam();
		param.setBuildId(2036965);
		param.setHouseUseage(2);
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildingRuleList"));
	}
	/**
	 * 房源登记中通过栋座,单元获取楼层房间列表
	 *
	 * @param
	 * @return
	 * @throws Exception
	 * @author 黄建海
	 * @since 2018年12月17日
	 */
	@Test
	public void getBuildFloorAndRoomListTest() throws Exception {
		JSONObject param=new JSONObject();
		param.put("buildId","2030289");
		param.put("buildingSetRoofId","18546");
		param.put("buildingSetUnitId","115696");
//        param.put("floorUseage", 1);
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildFloorAndRoomList"));
	}
	/**
	 * 通过栋座,房间id获取户型图列表
	 *
	 * @param
	 * @return
	 * @throws Exception
	 * @author 黄建海
	 * @since 2018年12月17日
	 */
	@Test
	public void getBuildingSetRoomLaYouTListTest() throws Exception {
		JSONObject param=new JSONObject();
		param.put("buildId","2033819");
		param.put("buildingSetRoomId","78981");
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildingSetRoomLaYouTList"));
	}
	/**
	 * 通过栋座获取单元列表
	 *
	 * @param
	 * @return
	 * @throws Exception
	 * @author 黄建海
	 * @since 2018年12月18日
	 */
	@Test
	public void getBuildSetUnitByRoofIdTest() throws Exception {
		JSONObject param=new JSONObject();
		param.put("buildingSetRoofId","2037207");
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildSetUnitByRoofId"));
	}
	/**
	 * 楼盘锁定返回数据
	 *
	 * @param
	 * @return
	 * @throws Exception
	 * @author 黄建海
	 * @since 2018年12月20日
	 */
	@Test
	public void getBuildingLockData() throws Exception {
		JSONObject param=new JSONObject();
		param.put("buildId","112725");
		param.put("buildRoof","测试别墅");
		param.put("buildUnit","U1");
		param.put("buildFloor","4");
		param.put("buildRoom","3,2");
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildingLockData"));
	}
}

