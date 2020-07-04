package com.myfun.erpWeb.openApi.other;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.erpWeb.openApi.photoDeal.param.PhotoDealParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuildrulequerylimitMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuildrulequerylimittempMapper;
import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimittemp;
import com.myfun.service.business.erpdb.ErpFunBuildrulequerylimitService;
import com.myfun.service.business.erpdb.ErpFunBuildrulequerylimittempService;
import com.myfun.utils.StringUtil;

@Controller
@RequestMapping(value = "/openApi/buildRuleLimitDeal")
public class FunBuildRuleLimitDealController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(FunBuildRuleLimitDealController.class);
	@Autowired ErpFunBuildrulequerylimitMapper erpFunBuildrulequerylimitMapper;
	@Autowired ErpFunBuildrulequerylimitService erpFunBuildrulequerylimitService;
	@Autowired ErpFunBuildrulequerylimittempService erpFunBuildrulequerylimittempService;
	@Autowired ErpFunBuildrulequerylimittempMapper erpFunBuildrulequerylimittempMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;

	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();
	
	static{
	}
	
	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/createSwitch")
	public ErpResponseJson createSwitch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String needUpdateParam = request.getParameter("needUpdateParam");// 是否需要修改参数
		if(!"1".equals(needUpdateParam)) {
			return ErpResponseJson.ok(photoDealParam);
		}
		Long tempSleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		if(tempSleepTime <= 50) {
			tempSleepTime = 50L;
		}
		photoDealParam.setSleepTime(tempSleepTime);
		int copySwitch = StringUtil.paseInteger(request.getParameter("copySwitch"), 0);// 是否启动
		if(copySwitch == 1) {
			photoDealParam.setCopySwitch(true);
		} else {
			photoDealParam.setCopySwitch(false);
		}
		int dealCount = StringUtil.paseInteger(request.getParameter("dealCount"), 1);// 每次请求处理循环多少次
		photoDealParam.setDealCount(dealCount);
		String dbName = request.getParameter("threadDbName");
		if(StringUtils.isNotBlank(dbName)) {
			int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
			if(threadCount <= 0) {
				threadCount = 1;
			} else if(threadCount > 20) {
				threadCount = 10;
			}
			photoDealParam.getDealThreadCount().put(dbName, threadCount);
		}
		return ErpResponseJson.ok(photoDealParam);
	}
	
	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copyLimitRuleToTempAction")
	public ErpResponseJson copyLimitRuleToTempAction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		if(photoDealParam.getIsStart()) {
			return ErpResponseJson.warn("执行中，请先停止再尝试开启");
		}
		photoDealParam.setIsStart(true);
		photoDealParam.setCopySwitch(true);
		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每个库一个线程
		for (int i = 0; i < configs.size(); i++) {
			final String shardDbName = configs.get(i);
			logger.error("-----create thread---");
			new DealLimitRuleThread(photoDealParam.getDealCount(), shardDbName).start();
		}
		return new ErpResponseJson();
	}
	
	/**
	 * 处理图片的线程
	 * @author 张宏利
	 * @since 2017年4月27日
	 */
	public class DealLimitRuleThread extends Thread{
		
		int dealSize = 0;
		String shardDbName = null;
		public DealLimitRuleThread(int dealSize, String shardDbName){
			this.dealSize = dealSize;
			this.shardDbName = shardDbName;
		}
		
		@Override
		public void run() {
			try {
				for (int i = 0; i < dealSize; i++) {
					// 动态停止
					if(!photoDealParam.getCopySwitch()) {
						break;
					}
					List<ErpFunBuildrulequerylimittemp> queryList = erpFunBuildrulequerylimitService.addFunBuildrulequerylimitList(shardDbName);
					if(!queryList.isEmpty()){
						erpFunBuildrulequerylimittempMapper.insertList(shardDbName, queryList);
					}
					photoDealParam.setIsStart(true);// 有在执行中则一直会被改为处理中
					Thread.sleep(photoDealParam.getSleepTime());
				}
				logger.error("-----deal over---");
			} catch (Exception e) {
				logger.error("-----error,over---");
				e.printStackTrace();
			}
			photoDealParam.setIsStart(false);// 一个完了就改为处理完了，如果还有处理的在方法里面会被改为处理中
		}
	}
}
