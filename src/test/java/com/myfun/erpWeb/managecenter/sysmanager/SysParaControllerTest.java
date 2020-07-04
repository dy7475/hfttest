package com.myfun.erpWeb.managecenter.sysmanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.managecenter.sysmanager.param.*;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统参数控制接口
 * 
 * @author 张宏利
 * @since 2017年10月16日
 */
public class SysParaControllerTest extends BaseTestController {
	@Before
	public void init() {
		init("http://192.168.200.163:8068/erpWeb", "http://mldev.51vfang.cn/erpWeb/usercenter/session/openLogin",
				"1281583", "15884586732");

	}

	@Test
	public void getCompanyData() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("compId", 47964);
		System.out.println(postNewErp(pMap,"/managerCenter/sysPara/getMgrPlotSwitch"));
	}
	
	/**
	 * 系统参数-获取系统模式能否转换
	 * @author ZangTie
	 * @since 2018年7月24日 下午9:20:14
	 * @param param
	 * @return
	 * Modified XXX ZangTie 2018年7月24日
	 */
	@Test
	public void getMgrSysParaModelConvertEnable() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("runModel", "PUBFUN");
		System.out.println(postNewErp(pMap,"/managerCenter/sysPara/getMgrSysParaModelConvertEnable"));
	}
	
	@Test
	public void getSysParamList() throws Exception{
		System.out.println(postNewErp(null,"managerCenter/sysPara/getSysParamList"));
	}

	@Test
	public void sysParamConfigInPartner() throws Exception {
		SysParamConfigInPartnerListParam listParam = new SysParamConfigInPartnerListParam();
		List<SysParamConfigInPartnerParam> list = new ArrayList<>();
		SysParamConfigInPartnerParam param = new SysParamConfigInPartnerParam();
		param.setModule((byte) 4);
		param.setSelfConfig((byte) 1);
		list.add(param);
		SysParamConfigInPartnerParam param2 = new SysParamConfigInPartnerParam();
		param2.setModule((byte) 5);
		param2.setSelfConfig((byte) 1);
		list.add(param2);
		listParam.setConfigs(list);
		System.out.println(postNewErp(listParam, "/managerCenter/sysPara/sysParamConfigInPartner"));
	}

    @Test
    public void getSysParamListTest() throws Exception {
        GetSysParamListParam param = new GetSysParamListParam();
		param.setOrganizationBussinessType(1);
        System.out.println(postNewErp(param, "/managerCenter/sysPara/getSysParams"));
    }

	@Test
	public void getMgrPlotSwitch() throws Exception {
		GetSysParamListParam param = new GetSysParamListParam();

		System.out.println(postNewErp(param, "/managerCenter/sysPara/getMgrPlotSwitch"));
	}

	@Test
	public void getSelfCompSysParamList() throws Exception {
		GetSysParamListParam param = new GetSysParamListParam();
		System.out.println(postNewErp(param, "/managerCenter/sysPara/getSelfCompSysParamList"));
	}

	@Test
	public void updateMgrParameter() throws Exception {
		String jsonStr = "{\"paramColl\":\"{\"VIEW_CUST_COUNT_OTHER_APP\":\"5\",\"SHARE_HOUSE_RANGE\":\"2\",\"ALLOW_INPUT_PHONE\":\"1\",\"SPECIAL_PROTECT_DAYS\":\"24\",\"ALLOW_PER_VIEWPHONE\":\"1\",\"SHARE_FUN_CORE_DEPT\":\"100\",\"IS_OPEN_HIDEPHONE\":\"1\",\"PUBLIC_NOTGET_CANCEL_SELL\":\"19\",\"LATE_TIME_SKIP\":\"1\",\"CLIENTKEY\":\"7d0e08550ca9e636d2b7a78d22989537\",\"DUTY_OFF_TIME\":\"21:00\",\"INFO_MAX_COMMEND_DAYS\":\"8\",\"IS_INPUT_PHONE_CHANGE\":\"0\",\"PUBLIC_HOUSE_TRANSFER\":\"1\",\"TRACKCONTENT_LENGTH\":\"8\",\"UPDATE_WAGE_CONFIG_EFFECTIVE\":\"31\",\"IS_OPEN_HIDE_SELF_PHONE_CUSTOMER\":\"1\",\"PUBLIC_CANCEL_LEASE\":\"18\",\"IS_SHOW_PROFIT_DATA\":\"0\",\"PUBLIC_CUST_RANGE\":\"3\",\"PUBLIC_NOTGET_CANCEL_RENT\":\"19\",\"SALE_LIMIT\":\"3\",\"FANGKAN_RED_BUY\":\"11\",\"DEPT_COMMEND_RECORDS\":\"14\",\"GET_PUBLIC_RED_BUY\":\"16\",\"EARLY_OFF_TIME\":\"15:00\",\"RED_TRACK_PUBLIC_LEASE\":\"14\",\"VIEW_HOUSE_COUNT_SELF\":\"210\",\"CUSTDATA_MUSTBE_ONLYONE\":\"0\",\"IS_COOPERATE_CHANGE\":\"0\",\"CUST_REPEAT_RANGE\":\"1\",\"HOUSEDATA_MUSTBE_ONLYONE\":\"1\",\"RED_TRACK_PUBLIC_SELL\":\"14\",\"LOOK_HOUSE_RANGE\":\"2\",\"VIEW_HOUSE_COUNT_OTHER\":\"8\",\"SHARE_CUST_CORE_DEPT\":\"100\",\"NEW_USER_WAGE_ASSESSMENT\":\"3\",\"PUBLIC_NOTGET_CANCEL_LEASE\":\"19\",\"SCHEDULE_PROTECT_DAYS\":\"11\",\"EARLY_TIME_SKIP\":\"1\",\"GET_PUBLIC_BUY\":\"15\",\"FANGKAN_RED_SELL\":\"33\",\"GET_RED_TRACK_PUBLIC_LEASE\":\"17\",\"PASSWORD_RECORDS\":\"6\",\"GET_RED_TRACK_PUBLIC_SELL\":\"17\",\"MODIFY_PRICE_SHOW_DAY\":\"5\",\"GET_RED_TRACK_PUBLIC_RENT\":\"17\",\"GET_PUBLIC_RED_LEASE\":\"16\",\"IS_OPEN_HIDE_SELF_PHONE_HOUSE\":\"1\",\"FANGKAN_RED_RENT\":\"11\",\"SHARE_FUN_CORE_OTHER\":\"5\",\"IS_SHOW_HOUSE_ROOF\":\"1\",\"PUBLIC_CUST_TRANSFER\":\"1\",\"INFO_MAX_FOCUS_DAYS\":\"6\",\"HOUSE_TRANSFER_FOR_WHO\":\"0\",\"AUTO_TO_RESPITE\":\"86\",\"PRIVATE_HOUSE_TRANSFER\":\"0\",\"IPCALL_AREA_HIDEPHONE_COUNT\":\"20\",\"PUBLIC_CANCEL_BUY\":\"18\",\"RED_TRACK_PUBLIC_BUY\":\"14\",\"FANGKAN_RED_LEASE\":\"14\",\"GET_PUBLIC_RENT\":\"15\",\"HOUSE_REPEAT_RANGE\":\"4\",\"UPDATE_ORG_USER_COUNT_BELONG\":\"2\",\"IS_SYSMODEL_CHANGE\":\"0\",\"SHOP_WAREHOUSE_REPEAT_TYPE\":\"1\",\"PUBLIC_CANCEL_RENT\":\"18\",\"COMMON_ON_TIME\":\"9:00\",\"SYSTEM_RUN_MODEL\":\"PRIVATE\",\"GET_PUBLIC_SELL\":\"15\",\"IS_SHOW_HOUSE_UNIT\":\"1\",\"VIEW_CUST_COUNT_SELF\":\"100\",\"MAX_BORROW_HOUR\":\"24\",\"ATTENDANCE_DATE\":\"1\",\"PRIVATE_CUST_TRANSFER_PUBLIC\":\"1\",\"PRIVATE_HOUSE_TRANSFER_PUBLIC\":\"1\",\"DEAL_WILL_SHOW_PHONENUM\":\"1\",\"GET_RED_TRACK_PUBLIC_BUY\":\"17\",\"ALLOW_QUERY_ROOF\":\"1\",\"TRACK_RED_BUY\":\"13\",\"RED_FANGKAN_PUBLIC_LEASE\":\"12\",\"INDEX_PROFIT_SHOW_TYPE\":\"0\",\"PUBLIC_CANCEL_SELL\":\"18\",\"INFO_MAX_SECRECY\":\"11\",\"ALLOW_CITY_COOPERATE\":\"1\",\"TRACK_RED_SELL\":\"13\",\"APP_LOGIN_EXAMIN\":\"0\",\"RED_FANGKAN_PUBLIC_SELL\":\"12\",\"COMMON_OFF_TIME\":\"18:00\",\"HF_AMOUNT_CANUSE\":\"8\",\"GET_PUBLIC_RED_RENT\":\"16\",\"BORROW_KEY_PRICE\":\"1\",\"VOIP_USE_COMP_MONEY\":\"30\",\"RED_TRACK_PUBLIC_RENT\":\"14\",\"COMMEND_RECORDS\":\"9\",\"ONLY_INPUT_LOCK_BUILD_ROOM\":\"1\",\"LEASE_LIMIT\":\"4\",\"RED_FANGKAN_PUBLIC_RENT\":\"12\",\"DUTY_ON_TIME\":\"9:30\",\"GET_PUBLIC_LEASE\":\"15\",\"PUBLIC_NOTGET_CANCEL_BUY\":\"19\",\"WARMDAY_OF_RENTDUE\":\"13\",\"VIEW_HOUSE_COUNT_OTHER_APP\":\"5\",\"VIEW_CUST_COUNT_OTHER\":\"5\",\"IS_SHOW_HOUSE_NUM\":\"1\",\"LATE_ON_TIME\":\"12:00\",\"SHARE_CUST_CORE_OTHER\":\"5\",\"TRACK_RED_LEASE\":\"13\",\"IPCALL_HIDEPHONE_COUNT\":\"20\",\"TRACK_RED_RENT\":\"13\",\"RED_FANGKAN_PUBLIC_BUY\":\"12\",\"GET_PUBLIC_RED_SELL\":\"16\",\"RESPITE_PROTECT_DAYS\":\"13\",\"SHARE_CUST_RANGE\":\"2\",\"LOOK_CUST_RANGE\":\"3\",\"PUBLIC_HOUSE_RANGE\":\"3\"}\",\"personalVersion\":\"false\"}";
		BaseMapParam param = new BaseMapParam();
		Map<String, Object> parseObject = JSON.parseObject(jsonStr, new TypeReference<Map<String, Object>>(){});
		param.setParam(parseObject);
		System.out.println(postNewErp(param, "/managerCenter/sysPara/getSelfCompSysParamList"));
	}

	@Test
	public void sysParamConfigInMeiLian() throws Exception {
		SysParamConfigInMeiLianParam param = new SysParamConfigInMeiLianParam();
		param.setBusinessApart((byte) 1);
		System.out.println(postNewErp(param, "/managerCenter/sysPara/sysParamConfigInMeiLian"));
	}

	@Test
	public void updatePlotSwitch() throws Exception {
		UpdatePlotSwitchParam param = new UpdatePlotSwitchParam();
		param.setPlotSwitch(0);
		System.out.println(postNewErp(param, "/managerCenter/sysPara/updatePlotSwitch"));
	}

	@Test
	public void getStrategyParams() throws Exception {
		GetStrategyParamsParam param = new GetStrategyParamsParam();
		param.setOrganizationId(894723);
		System.out.println(postNewErp(param, "/managerCenter/sysPara/getStrategyParams"));
	}

	@Test
	public void updateStrategyParam() throws Exception {
		UpdateStrategyParam param = new UpdateStrategyParam();
		System.out.println(postNewErp(param, "/managerCenter/sysPara/updateStrategyParam"));
	}
}
