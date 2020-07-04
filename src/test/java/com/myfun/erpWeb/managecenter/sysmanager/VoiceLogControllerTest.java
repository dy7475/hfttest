package com.myfun.erpWeb.managecenter.sysmanager;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.BaseTestController;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;

public class VoiceLogControllerTest extends BaseTestController{
	@Before
	public void init(){
//		init("http://192.168.0.183:8081/erpWeb", "http://192.168.0.246:8080/hftWebService/web/api/authentication/per.do", "387", "15884586730");
        init("http://localhost:9001/erpWeb", "http://dev.51vfang.cn/hftWebService/web/api/authentication/per.do", "1279612", "14411114444");

	}
	/**
	 * 查询系统监控安装列表
	 * @author 方李骥
	 * @since 2016年10月21日
	 * @return
	 * @throws Exception
	 */
	@Test
	public void getMgrVoiceNoteLog() throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("callDeptId","");
		param.put("pageOffset",1);
		param.put("pageRows",50);
		//param.put("sourceDeptId","12001");
		param.put("targetType",1);
		param.put("time1","2018-06-01");
		param.put("time2", "2018-08-15");
		//param.put("userId",10090611);
		param.put("timeLowerLimit", "");
		param.put("timeUpperLimit", "");
		param.put("timeLengthType", "");
		param.put("total", "0");
		param.put("userId", "");

		System.out.println(postNewErp(param,"/managerCenter/voiceLog/getMgrVoiceNoteLog"));
	}

	/**
	 * 系统监控-获取语音播放地址
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/14
	 */
	@Test
	public void getMgrVoiceUrl() throws Exception{
		Map<String,Object> param = new HashMap<>();
		param.put("logId","0005340a2711e79a5a20");
		System.out.println(postNewErp(param,"/managerCenter/voiceLog/getMgrVoiceUrl"));
	}
}
