package com.myfun.erpWeb.businesstools.vcard;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.erpWeb.businesstools.vcard.param.PerCreateEcardsParam;
import com.myfun.erpWeb.businesstools.vcard.param.PerEcardsParam;
import com.myfun.erpWeb.businesstools.vcard.param.PerUpdateEcardsParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.service.business.erpdb.bean.param.QueryVcardListParam;
import com.myfun.utils.JsonHelper;

public class FunVcardControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.183:8081/erpWeb", "http://192.168.0.183:8080/hftWebService/web/api/authentication/per.do", "387", "15884586730");
		init("http://192.168.5.173:8080/erpWeb", "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do", "508049", "13026529969");
	}
	/**
	 * 获取出售钥匙管理列表
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getEcardsByData() throws Exception{
		String jsonParamStr = "{\"ecardId\":\"1974324\"}";
		BaseMapParam param = new BaseMapParam();
		param.setParam(JsonHelper.parseMap(jsonParamStr));
		System.out.println(postNewErp(param,"vCard/getEcardsByData"));
	}
	
	/**
	 * 获取出售钥匙管理列表
	 * @author 方李骥
	 * @since 2016年8月27日
	 * @return
	 * @throws Exception 
	 */
	@Test
	public void getBusinessTooleCardList() throws Exception{
		String jsonParamStr = "{\"areaId\":\"\",\"deptId\":\"\",\"grId\":\"\",\"orderBy\":\"CREATE_TIME DESC\",\"pageOffset\":\"1\",\"pageRows\":\"50\",\"regId\":\"\",\"queryFor\":\"comp\",\"queryKey\":\"\"}";
		QueryVcardListParam query = JSON.parseObject(jsonParamStr, QueryVcardListParam.class);
		System.out.println(postNewErp(query,"vCard/getBusinessTooleCardList"));
	}
	
	/**
	 * 获取员工通讯录列表
	 * @author 张宏利
	 * @since 2017年9月29日
	 * @param param
	 * userStatus	1=在职，2=注销，3=调店
	 * serchRange	查询范围 COMP,AREA,REG,DEPT
	 * serchRangeId	查询范围ID
	 * matchStr	模糊匹配字符串
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getCommunicationList() throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userStatus", "1");
		paramMap.put("serchRange", "COMP");
		paramMap.put("serchRangeId", "12001");
		paramMap.put("matchStr", "");
		System.out.println(postNewErp(paramMap, "/businesstools/vCard/getCommunicationList"));
	}

	
	@Test
	public void createEcards() throws Exception {
		PerCreateEcardsParam param = new PerCreateEcardsParam();
		param.setPhone("15789994676");
		param.setEcardId(1975605);
		System.out.println(postNewErp(param, "/businesstools/vCard/createEcards"));
	}
	
	@Test
	public void updateEcardsPublic() throws Exception {
		PerUpdateEcardsParam param = new PerUpdateEcardsParam();
		param.setEcardId(1975611);
		param.setIsPublic(true);
		System.out.println(postNewErp(param, "/businesstools/vCard/updateEcardsPublic"));
	}
	
	@Test
	public void getEcardsLists() throws Exception {
		PerEcardsParam param = new PerEcardsParam();
		param.setQueryFor("comp");
		param.setQueryKey("张");
		System.out.println(postNewErp(param, "/businesstools/vCard/getEcardsLists"));
	}
}


