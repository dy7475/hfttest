package com.myfun.erpWeb.house;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import com.myfun.erpWeb.BaseTestController;

public class FunTrackControllerTest extends BaseTestController{
	@Before
	public void init(){
		init("http://192.168.5.175:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
	}

	@Test
	public void getTrackVideoImageList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("trackId", "45022774");
		System.out.println(postNewErp(pMap,"/house/getTrackVideoImageList"));
	}

	/**
	 * 查询置顶跟进
	 * @author lcb
	 * @date 2018/6/7
	 * @return
	 */
	@Test
	public void getStickTrackList() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("caseId", "6638710");
		pMap.put("caseType", "1");
		System.out.println(postNewErp(pMap,"/house/getStickTrackList"));
	}

	/**
	 * 新增/取消置顶跟进
	 * @author lcb
	 * @date 2018/6/7
	 * @return
	 */
	@Test
	public void updateStickTrack() throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("trackId", "45299014");
		pMap.put("opType", "1");
		System.out.println(postNewErp(pMap,"/house/updateStickTrack"));
	}
}
