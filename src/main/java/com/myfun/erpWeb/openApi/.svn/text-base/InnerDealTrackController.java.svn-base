package com.myfun.erpWeb.openApi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.csource.FastdfsManager;
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
import com.myfun.repository.erpdb.dao.ErpDealTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpDealTrack;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.service.business.erpdb.ErpFunDealService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.FileUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
* 补合同跟进数据
* @author 方李骥
* @since 2017年4月17日
*/
@Controller
@RequestMapping(value = "/openApi/dealDealTrack")
public class InnerDealTrackController extends BaseController{
private static final Logger logger = LoggerFactory.getLogger(InnerDealTrackController.class);
	
	@Autowired ErpFunDealMapper erpFunDealMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunTrackMapper erpFunTrackMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired ErpDealTrackMapper erpDealTrackMapper;
	
	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();
	
	private volatile static boolean dealDealTrack = true;
	private volatile static long sleepTime = 50;
	private volatile static Map<String, Integer> dealThreadCount = new HashMap<>();
	
	static{
		// 暂时单个库不增加多线程处理
		//dealThreadCount.put("hft_erpdb_cd", 5);
		//dealThreadCount.put("hft_erpdb_zz", 20);
	}
	/**
	 * 将以前的图片拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/copySwitch")
	public ErpResponseJson copySwitch(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
	@RequestMapping(value="/startCopy")
	public ErpResponseJson startCopy(HttpServletRequest request, HttpServletResponse response) throws Exception{
		if(photoDealParam.getIsStart()) {
			return ErpResponseJson.warn("执行中，请先停止再尝试开启");
		}
		photoDealParam.setIsStart(true);
		photoDealParam.setCopySwitch(true);
		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每个库一个线程
		for (int i = 0; i < configs.size(); i++) {
			final String shardDbName = configs.get(i);
			// 每个库增加不同的线程数
			Integer threadCount = dealThreadCount.get(shardDbName.toLowerCase());
			if(threadCount == null){
				threadCount = 1;
			}
			for (int j = 0; j < threadCount; j++) {
				logger.error("-----create thread---");
				new DealVideoThread(100, shardDbName).start();
			}
		}
		return ErpResponseJson.ok();
	}
	/**
	 * 处理没有写成交跟进的合同
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/dealFunDealTrackSwitch")
	public String dealFunDealTrackSwitch(HttpServletRequest request, HttpServletResponse response) throws Exception{
		sleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		int switchVal = StringUtil.paseInteger(request.getParameter("switch"), 0);// 是否启动
		if(switchVal == 1) {
			dealDealTrack = true;
		} else {
			dealDealTrack = false;
		}
		String dbName = request.getParameter("threadDbName");
		if(StringUtils.isNotBlank(dbName)) {
			int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
			if(threadCount <= 0) {
				threadCount = 1;
			}
			dealThreadCount.put(dbName, threadCount);
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("暂停时间", sleepTime);
		resultMap.put("开启状态", dealDealTrack);
		resultMap.put("线程数", dealThreadCount);
		return new ErpResponseJson(resultMap).toJson();
	}

	
	/**
	 * 将以前的视频拷贝到fastdfs中
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/dealTrack")
	public String copyFunVideoToFastdfs(HttpServletRequest request, HttpServletResponse response) throws Exception{
		final int dealSize = StringUtil.paseInteger(request.getParameter("dealSize"), 1);// 每个库处理多少次
		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每个库一个线程
		for (int i = 0; i < configs.size(); i++) {
			final String shardDbName = configs.get(i);
			// 每个库增加不同的线程数
			Integer threadCount = dealThreadCount.get(shardDbName.toLowerCase());
			if(threadCount == null){
				threadCount = 1;
			}
			for (int j = 0; j < threadCount; j++) {
				logger.error("-----create thread---");
				new DealVideoThread(dealSize, shardDbName).start();
			}
		}
		return new ErpResponseJson().toJson();
	}
	/**
	 * 处理视频的线程
	 * 
	 */
	public class DealVideoThread extends Thread{
		
		int dealSize = 0;
		String shardDbName = null;
		public DealVideoThread(int dealSize, String shardDbName){
			this.dealSize = dealSize;
			this.shardDbName = shardDbName;
		}
		
		@Override
		public void run() {
			for (int i = 0; i < dealSize; i++) {
			try {
					// 动态停止
					if(!photoDealParam.getCopySwitch()) {
						break;
					}
					Integer lastDealId = null;
					List<ErpFunDeal> dealList = null;
					synchronized(InnerDealTrackController.class){
						dealList = erpFunDealMapper.getDealListOrderByDealIdDesc(shardDbName, lastDealId);
						List<ErpDealTrack> dealTrackList = new LinkedList<>();
						for (ErpFunDeal erpDeal : dealList) {
							ErpDealTrack dealTrack = new ErpDealTrack();
							dealTrack.setDealId(erpDeal.getDealId());
							dealTrackList.add(dealTrack);
						}
						if(!dealTrackList.isEmpty()){
							erpDealTrackMapper.insertList(shardDbName, dealTrackList);
						}
					
					}
					// 没有数据时退出循环
					if(dealList == null || dealList.size() <= 0) {
						logger.error("-----no data,return---");
						break;
					}
					//遍历合同
					for (ErpFunDeal erpFunDeal : dealList) {
						ErpFunTrack houseTrack = null;
						ErpFunTrack custTrack = null;
						String houseType = null;
						String custType = null;
						Integer houseCaseUserId = null;
						Integer houseCaseDeptId = null;
						Integer custCaseUserId = null;
						Integer custCaseDeptId = null;
						if (Constants_DIC.DIC_CASE_TYPE_RENT_DEAL.equals(erpFunDeal.getDealType().toString())) {
							//判断是否有房源id，如果没有房源id那么该合同房源是外部合作的不写跟进
							houseCaseUserId = erpFunDeal.getHouseUserUid();
							houseCaseDeptId = erpFunDeal.getHouseDeptId();
							custCaseUserId = erpFunDeal.getCustUserUid();
							custCaseDeptId = erpFunDeal.getCustDeptId();
							if(erpFunDeal.getDealHouseId()!=null){
								//查询合同创建那一天是否已经有了跟进
								houseTrack = erpFunTrackMapper.getTrackDeal(shardDbName, "2" , erpFunDeal.getDealHouseId(), erpFunDeal.getSystemRecordTime());
								houseType = Constants_DIC.DIC_CASE_TYPE_LEASE_FUN;
							}
							//判断是否有客源id，如果没有客 源id那么该合同客源是外部合作的不写跟进
							if(erpFunDeal.getDealCustomerId()!=null){
								custTrack = erpFunTrackMapper.getTrackDeal(shardDbName,"4", erpFunDeal.getDealCustomerId(), erpFunDeal.getSystemRecordTime());
								custType = Constants_DIC.DIC_CASE_TYPE_RENT_CUST;
							}
						} else if (Constants_DIC.DIC_CASE_TYPE_SALE_DEAL.equals(erpFunDeal.getDealType().toString())){
							//判断是否有房源id，如果没有房源id那么该合同房源是外部合作的不写跟进
							if(erpFunDeal.getDealHouseId()!=null){
								houseTrack = erpFunTrackMapper.getTrackDeal(shardDbName, "1" , erpFunDeal.getDealHouseId(), erpFunDeal.getSystemRecordTime());
								houseType = Constants_DIC.DIC_CASE_TYPE_SALE_FUN;
							}
							//判断是否有客源id，如果没有客 源id那么该合同客源是外部合作的不写跟进
							if(erpFunDeal.getDealCustomerId()!=null){
								custTrack = erpFunTrackMapper.getTrackDeal(shardDbName,"3", erpFunDeal.getDealCustomerId(), erpFunDeal.getSystemRecordTime());
								custType = Constants_DIC.DIC_CASE_TYPE_BUY_CUST;
							}						
						}
						if(erpFunDeal.getDealHouseId()!=null){
							//为空，则那一天没有创建，就开始补跟进
							if (houseTrack == null) {
								//doNothing
							}else{
								houseTrack.setDealId(erpFunDeal.getDealId());
								houseTrack.setShardDbName(shardDbName);
								erpFunTrackMapper.updateByPrimaryKeySelective(houseTrack);
							}
						}
						if(erpFunDeal.getDealCustomerId()!=null){
							if (custTrack == null) {
								//doNothing
							}else{
								custTrack.setDealId(erpFunDeal.getDealId());
								custTrack.setShardDbName(shardDbName);
								erpFunTrackMapper.updateByPrimaryKeySelective(custTrack);
							}
						}
						// 拷贝文件
						if(lastDealId == null || lastDealId > erpFunDeal.getDealId()) {
							lastDealId = erpFunDeal.getDealId();
						}
						Thread.sleep(sleepTime);
					}
				logger.error("-----deal over---");
				} catch (Exception e) {
					logger.error("-----error,over---");
					e.printStackTrace();
				}
			}
			photoDealParam.setIsStart(false);// 一个完了就改为处理完了，如果还有处理的在方法里面会被改为处理中
		}
	}
}
