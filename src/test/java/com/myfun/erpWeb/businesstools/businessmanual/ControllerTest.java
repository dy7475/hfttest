/**
 * @author 方李骥
 * @since 2016年9月7日
 */
package com.myfun.erpWeb.businesstools.businessmanual;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.myfun.erpWeb.BaseTestController;
import com.myfun.service.business.erpdb.bean.param.ErpFunKeyParam;
import com.myfun.service.business.erpdb.bean.param.QueryBuildingListParam;

/**
 * @author 方李骥
 * @since 2016年9月7日
 */
public class ControllerTest extends BaseTestController {
	@Before
	public void init(){
//		init("http://192.168.0.183:8081/erpWeb", "http://192.168.0.246:8080/hftWebService/web/api/authentication/per.do", "507446", "18348451854");
		init("http://192.168.5.182:8080/erpWeb", "http://192.168.5.182:80/hftWebService/web/api/authentication/per.do", "394072", "15228861532");

	}
	/**
	 * 获取业务手册列表
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getBizMnaualList() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("dicValue", "1");
		System.out.println(postNewErp(param,"businessManual/getBizMnaualList"));
	}
	/**
	 * insertBizManualData
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void insertBizManualData() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("menualName", "你是我的眼，让我看见这世界就在我眼前");
		param.put("menualType", "1");
		param.put("menualSourse", "soso");
		param.put("menualNo", "soso");
		param.put("menualContent", "helloworld");
		System.out.println(postNewErp(param,"businessManual/insertBizManualData"));
	}
	/**
	 * insertBizManualData
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void insertBizManualData1() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("menualName", "你是我的眼，让我看见这世界就在我眼前111");
		param.put("menualType", "1");
		param.put("menualSourse", "soso");
		param.put("menualNo", "soso");
		param.put("menualContent", "helloworld");
		System.out.println(postNewErp(param,"businessManual/insertBizManualData"));
	}
	/**
	 * insertBizManualData
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void updateBizManualData1() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("muId","92114");
		param.put("menualName", "你是我的眼，让我看见这世界就在我眼前111");
		param.put("menualType", "1");
		param.put("menualSourse", "soso");
		param.put("menualNo", "soso");
		param.put("menualContent", "helloworld");
		System.out.println(postNewErp(param,"businessManual/updateBizManualData1"));
	}
	/**
	 * insertBizManualData
	 * @author 方李骥
	 * @since 2016年9月2日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Test
	public void deleteBizManualData() throws Exception{
		Map<String,String> param = new HashMap<String,String>();
		param.put("muId", "92114");
		System.out.println(postNewErp(param,"businessManual/deleteBizManualData"));
	}

	/**
	 * 搜索户型图
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/14
	 */
	@Test
	public void getKjlFloorplanList() throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("pageOffset",1);
		System.out.println(postNewErp(param,"/businesstools/kujialePlan/getKjlFloorplanList"));
	}
	
	
}
