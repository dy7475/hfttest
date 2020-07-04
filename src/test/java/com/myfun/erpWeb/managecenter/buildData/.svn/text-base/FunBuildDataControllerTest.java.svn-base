package com.myfun.erpWeb.managecenter.buildData;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.managecenter.buildData.param.*;
import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;

public class FunBuildDataControllerTest extends BaseTestController{

	@Before
	public void init(){
//		init("http://192.168.0.179:8001/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
//		init("http://192.168.5.174:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "506970", "18782920347");
//		init("http://192.168.5.169:8080/erpWeb", "http://erpverify.51vfang.cn/hftWebService/web/api/authentication/per.do", "1278843", "15025835456");//总经理账号
//		init("http://192.168.5.208:8080/erpWeb", "http://192.168.5.208:8080/hftWebService/web/api/authentication/per.do", "670483", "18381306721");//总经理账号
		init("http://192.168.5.245:8080/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "671968", "15025835456");//总经理账号

	}
	
	/**
	 * 
	 * @author xionggang
	 * @since 2017年8月13日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void deleteAllBuildData() throws Exception{
		Map<String, Object> param =new HashMap<>();
		param.put("buildId", "123456");
		System.out.println(postNewErp(param,"manageCenter/buildData/deleteAllBuildData"));
	}
	
	/**
	 * 楼盘资料统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @throws Exception
	 */
	@Test
	public void getBuildDataIpCallList() throws Exception{
		Map<String, Object> param = new HashMap<>();
//		param.put("buildId", "123456");
//		param.put("serchRange", "COMP");
//		param.put("serchRangeId", "12001");
		param.put("userId", "2001");
		param.put("countName", "ipAllCount");
		System.out.println(postNewErp(param,"manageCenter/buildData/getBuildDataIpCallList"));
	}
	
	/**
	 * 楼盘资料统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @throws Exception
	 */
	@Test
	public void getBuildDataTrackList() throws Exception{
		Map<String, Object> param = new HashMap<>();
//		param.put("buildId", "123456");
		param.put("userId", 2001);
		param.put("countName", "trackCount");
		param.put("serchRange", "");
		param.put("serchRangeId", "");
		param.put("startTime", "2016-05-19 00:00:00");
		param.put("endTime", "2019-04-28 23:59:59");
		param.put("pageOffset", "1");
		param.put("pageRows", "50");
		System.out.println(postNewErp(param,"manageCenter/buildData/getBuildDataTrackList"));
	}

	@Test
	public void getBuildDataTrackDataList() throws Exception{
		Map<String, Object> param = new HashMap<>();
//		param.put("buildId", "123456");
		param.put("userId", 2001);
		param.put("countName", "trackCount");
		param.put("serchRange", "");
		param.put("serchRangeId", "");
		param.put("startTime", "2016-05-19 00:00:00");
		param.put("endTime", "2019-04-28 23:59:59");
		param.put("pageOffset", "1");
		param.put("pageRows", "20");
		System.out.println(postNewErp(param,"manageCenter/buildData/getBuildDataTrackDataList"));
	}

	@Test
	public void getBuildDataHouseListV2() throws Exception{
		Map<String, Object> param = new HashMap<>();
//		param.put("buildId", "123456");
		param.put("userId", 20322814);
		param.put("countName", "transSaleCount");
		param.put("caseType", "2");
		param.put("serchRange", "");
		param.put("serchRangeId", "");
		param.put("startTime", "2016-05-19 00:00:00");
		param.put("endTime", "2019-04-28 23:59:59");
		param.put("pageOffset", "1");
		param.put("pageRows", "50");
		System.out.println(postNewErp(param,"manageCenter/buildData/getBuildDataHouseListV2"));
	}

	@Test
	public void getIpCallDataList() throws Exception{
		Map<String, Object> param = new HashMap<>();
//		param.put("buildId", "123456");
//		param.put("userId", 2001);
//		param.put("serchRange", "DEPT_ID");
//		param.put("serchRangeId", "12001");
		param.put("startTime", "2016-05-19 00:00:00");
		param.put("endTime", "2019-04-28 23:59:59");
//		param.put("pageOffset", "1");
//		param.put("pageRows", "50");
//		param.put("buildId", "21");
		param.put("userId", "2001");
		param.put("countName", "ipAllCount");
		System.out.println(postNewErp(param,"manageCenter/buildData/getIpCallDataList"));
	}

	/**
	 * 楼盘资料统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @throws Exception
	 */
	@Test
	public void getBuildDataStatistic() throws Exception{
		Map<String, Object> param = new HashMap<>();
//		param.put("buildId", "123456");
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		System.out.println(postNewErp(param,"manageCenter/buildData/getBuildDataStatistic"));
	}
	
	/**
	 * 楼盘资料统计
	 * @author 张宏利
	 * @since 2017年11月23日
	 * @throws Exception
	 */
	@Test
	public void getBuildDataHouseList() throws Exception{
		Map<String, Object> param = new HashMap<>();
//		param.put("buildId", "123456");
		param.put("caseType", "1");
		param.put("serchRange", "COMP");
		param.put("serchRangeId", "12001");
		System.out.println(postNewErp(param,"manageCenter/buildData/getBuildDataHouseList"));
	}
	
	/**
	 * 获取可查看的楼盘资料列表
	 * @author 张宏利
	 * @since 2018年4月8日
	 * @throws Exception
	 */
	@Test
	public void getUserViewBuilds() throws Exception{
		Map<String, Object> param = new HashMap<>();
		param.put("caseType", "1");
		System.out.println(postNewErp(param,"manageCenter/buildData/getUserViewBuilds"));
	}

	/**
	 * @author 邓永洪
	 * @since 2018/4/16
	 * @tag 楼盘资料-获取楼盘资料管理员
	 */
	@Test
	public void getMgrFloorDataManager() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("deptId", "12001");
		System.out.println(postNewErp(param,"manageCenter/buildData/getMgrFloorDataManager"));
	}

	/**
	 * @tag 获取楼盘资料列表
	 * @author 邓永洪
	 * @since 2018/5/4
	 */
	@Test
	public void getMgrFloorDataList() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("buildId",21);
		param.put("house","ALL");
		param.put("num","ALL");
		param.put("roof","ALL");
		param.put("unit","ALL");
		param.put("queryType","INIT");
		param.put("cellPhone","");

		System.out.println(postNewErp(param,"manageCenter/buildData/getMgrFloorDataList"));
	}

	/**
	 * @tag 楼盘资料-获取楼盘列表
	 * @author 邓永洪
	 * @since 2018/6/4
	 */
	@Test
	public void getMgrFloorList() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("buildName","a");
		System.out.println(postNewErp(param,"manageCenter/buildData/getMgrFloorList"));
	}

	/**
	 *	楼盘资料-开启或关闭隐号拨打
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/16
	 */
	@Test
	public void openOrCloseImplicitCall() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("openFlag",1);
		System.out.println(postNewErp(param,"manageCenter/buildData/openOrCloseImplicitCall"));
	}

	/**
	 * 批量导入楼盘数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/20
	 */
	@Test
	public void importBuildInfos() throws Exception {
		/*
        [{\"buildCode\":\"BQ\",\"buildId\":\"2022889\",\"buildName\":\"八区\",\"cellPhone\":\"手机:18161228699\",\"cellPhone2\":\"\",\"floor\":\"5\",\"floors\":\"18\",\"hall\":\"1\",\"house\":\"102\",\"houseArea\":\"70\",\"houseRound\":\"郊县\",\"houseStruct\":\"1\",\"houseType\":\"1\",\"houseYear\":\"2013\",\"num\":\"5\",\"owner\":\"杜\",\"regionId\":\"10\",\"roof\":\"1\",\"room\":\"\",\"roundDd\":\"6\",\"rowCount\":\"2\",\"sectionId\":\"564\",\"shareCellPhone\":\"手机:18161228644\",\"shareUser\":\"陈\",\"unit\":\"2\",\"useage\":\"1\",\"wei\":\"1\",\"yang\":\"1\"}]
        * */
		Map<String,Object> param=new HashMap<>();
//		param.put("buildlistJson","[{\"buildCode\":\"BQ\",\"buildId\":\"1025484\",\"buildName\":\"八区\",\"cellPhone\":\"手机:18161228691\",\"cellPhone2\":\"\",\"floor\":\"6\",\"floors\":\"18\",\"hall\":\"1\",\"house\":\"102\",\"houseArea\":\"70\",\"houseRound\":\"郊县\",\"houseStruct\":\"1\",\"houseType\":\"1\",\"houseYear\":\"2013\",\"num\":\"5\",\"owner\":\"杜\",\"regionId\":\"10\",\"roof\":\"1\",\"room\":\"\",\"roundDd\":\"6\",\"rowCount\":\"2\",\"sectionId\":\"564\",\"shareCellPhone\":\"手机:18161228644\",\"shareUser\":\"陈\",\"unit\":\"2\",\"useage\":\"1\",\"wei\":\"1\",\"yang\":\"1\"}]");
		param.put("buildlistJson","[{\"buildCode\":\"BQ\",\"buildId\":\"1025484\",\"buildName\":\"八区\",\"cellPhone\":\"手机:18161228696\",\"cellPhone2\":\"\",\"floor\":\"7\",\"floors\":\"17\",\"hall\":\"1\",\"house\":\"106\",\"houseArea\":\"70\",\"houseRound\":\"郊县\",\"houseStruct\":\"1\",\"houseType\":\"1\",\"houseYear\":\"2013\",\"num\":\"5\",\"owner\":\"杜\",\"regionId\":\"10\",\"roof\":\"1\",\"room\":\"\",\"roundDd\":\"6\",\"rowCount\":\"2\",\"sectionId\":\"564\",\"shareCellPhone\":\"手机:18161228644\",\"shareUser\":\"陈\",\"unit\":\"2\",\"useage\":\"1\",\"wei\":\"1\",\"yang\":\"1\",\"phoneType\":1,\"sharePhoneType\":1,\"phoneTypeTwo\":1,\"houseDirect\":2}]");
		
		System.out.println(postNewErp(param,"manageCenter/buildData/importBuildInfos"));
	}

	/**
	 * 楼盘资料-批量删除楼盘数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/20
	 */
	@Test
	public void deleteMgrMultiFloorData() throws Exception {
		Map<String,Object> param=new HashMap<>();
		param.put("ids","151211,151209");
		System.out.println(postNewErp(param,"manageCenter/buildData/deleteMgrMultiFloorData"));
	}

	/**
	 * 获取楼盘下拉列表
	 * @throws Exception
	 */
	@Test
	public void getMgrFloorListTest() throws Exception {
		Map<String,Object> param=new HashMap<>();
//		param.put("regId","4");
		param.put("buildFlag","1");
		System.out.println(postNewErp(param,"manageCenter/buildData/getMgrFloorList"));
	}
	/**
	 * 获取楼盘资料列表
	 * @throws Exception
	 */
	@Test
	public void getBuildListTest() throws Exception {
		BuildListParam param =  new BuildListParam();
		param.setRegId(4);
		System.out.println(postNewErp(param,"manageCenter/buildData/getBuildList"));
	}

    /**
	 * 获取房号资料列表
	 * @throws Exception
	 */
	@Test
	public void getMgrFloorDataListTest() throws Exception {
		FloorDataParam param =  new FloorDataParam();
		param.setBuildId(2044897);
		param.setHouse("ALL");
		param.setNum("ALL");
		param.setRoof("ALL");
		param.setUnit("ALL");
		param.setQueryType("INIT");
		System.out.println(postNewErp(param,"manageCenter/buildData/getMgrFloorDataList"));
	}

	/**
	 * 获取使用记录列表
	 * @throws Exception
	 */
	@Test
	public void getMgrUserViewRight() throws Exception {
		MgrUserViewRightParam param =  new MgrUserViewRightParam();
		param.setBuildId(2044968);
		param.setEndTime("2019-02-26 23:59:59");
		param.setStartTime("2019-02-19 00:00:00");

		System.out.println(postNewErp(param,"manageCenter/buildData/getMgrUserViewRight"));
	}

	/**
	 * 查看范围(楼盘使用权分配到门店)
	 * @throws Exception
	 */
	@Test
	public void saveBuildDeptsTest() throws Exception {
		saveBuildDeptsParam param =  new saveBuildDeptsParam();
		param.setBuildId(2044897);
		param.setDeptIds("12001,893295");

		System.out.println(postNewErp(param,"manageCenter/buildData/saveBuildDepts"));
	}

	/**
	 * 使用记录暂停
	 * @throws Exception
	 */
	@Test
	public void deleteViewBuildRule() throws Exception {
		DeleteViewBuildRuleParam param =  new DeleteViewBuildRuleParam();
		param.setIds(2669);
		param.setStatus((byte)0);

		System.out.println(postNewErp(param,"manageCenter/buildData/deleteViewBuildRule"));
	}
}


