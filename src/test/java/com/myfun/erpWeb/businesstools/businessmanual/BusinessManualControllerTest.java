package com.myfun.erpWeb.businesstools.businessmanual;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;

public class BusinessManualControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.0.179:8001/erpWeb", "http://192.168.0.179:80/hftWebService/web/api/authentication/per.do", "508357", "18016148677");
	}
	/**
	 * 
	 * @author 熊刚
	 * @since 2017年7月7日
	 * @throws Exception
	 */
	@Test
	public void getBizAllMnaualCheckFlag() throws Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("buildId","123456");
		
		System.out.println(postNewErp(paramMap,"businesstools/buildDic/getBizAllMnaualCheckFlag"));
	}
	
	/**
	 * 修改楼盘
	 * @author 熊刚
	 * @since 2017年7月7日
	 * @throws Exception
	 */
	@Test
	public void updateBizAllMnaual() throws Exception{
		BuildingInfoTmpParam buildingInfoTmpParam =new BuildingInfoTmpParam();
		buildingInfoTmpParam.setBuildName("蓝谷地");
		buildingInfoTmpParam.setBuildAddr("锦江区国槐街");
		buildingInfoTmpParam.setBuildId(123456);
		buildingInfoTmpParam.setArchiveId(508357);
		buildingInfoTmpParam.setProvinceId(123);
		System.out.println(postNewErp(buildingInfoTmpParam,"businesstools/buildDic/updateBizAllMnaual"));
	}
	
	/**
	 * 获取列表（锁定）
	 * @author 熊刚
	 * @since 2017年7月7日
	 * @throws Exception
	 */
	@Test
	public void getBuildingList() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		System.out.println(postNewErp(param,"businesstools/buildDic/getBuildingList"));
	}
}
