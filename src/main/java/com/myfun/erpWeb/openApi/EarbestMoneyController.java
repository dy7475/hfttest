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

import com.myfun.erpWeb.openApi.InnerDealTrackController.DealVideoThread;
import com.myfun.erpWeb.openApi.photoDeal.param.PhotoDealParam;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.ErpDealTrackMapper;
import com.myfun.repository.erpdb.dao.ErpEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpDealTrack;
import com.myfun.repository.erpdb.po.ErpEarbestMoney;
import com.myfun.repository.erpdb.po.ErpEarbestMoneyExample;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunTrack;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.FileUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

@Controller
@RequestMapping(value = "/openApi/dealEarbestMoney")
public class EarbestMoneyController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(InnerDealTrackController.class);
	@Autowired ErpFunDealMapper erpFunDealMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunTrackMapper erpFunTrackMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired ErpEarbestMoneyMapper erpEarbestMoneyMapper;
	@Autowired ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	
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
				new DealVideoThread(1, shardDbName).start();
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
	@RequestMapping(value="/dealEarbestMoney")
	public String dealEarbestMoney(HttpServletRequest request, HttpServletResponse response) throws Exception{
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
				ErpEarbestMoneyExample example = new ErpEarbestMoneyExample();
				example.setShardDbName(shardDbName);
				example.createCriteria().andIsDelEqualTo(new Byte("0"));
				List<ErpEarbestMoney> earbestMoneyList = erpEarbestMoneyMapper.selectByExample(example);
				for	(ErpEarbestMoney erpEarbestMoney:earbestMoneyList)	{
					if ("1".equals(erpEarbestMoney.getPerformanceName())) {
						ErpFunBuyCustomer id = new ErpFunBuyCustomer();
						id.setBuyCustId(erpEarbestMoney.getCustId());
						id.setShardDbName(shardDbName);
						ErpEarbestMoney updateModel = new ErpEarbestMoney();
						updateModel.setShardDbName(shardDbName);
						updateModel.setEarbestId(erpEarbestMoney.getEarbestId());
						if(StringUtils.isNotBlank(erpEarbestMoney.getCustIdcard()) && erpEarbestMoney.getCustIdcard().contains("****")){
							ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.selectByPrimaryKey(id);
							if (erpFunBuyCustomer != null) {
								String idCard = erpFunBuyCustomer.getIdCard();
								if (StringUtils.isNotBlank(idCard)) {
									idCard = EnCodeHelper.decode(idCard);
									updateModel.setCustIdcardDecode(idCard);
									if(idCard.length()>3){
										updateModel.setCustIdcard(idCard.substring(0, 4)+"**************");
									} else {
										updateModel.setCustIdcard(idCard+"***************");
									}
								}
							}
						} else {
							updateModel.setCustIdcardDecode(erpEarbestMoney.getCustIdcard());
						}
						updateModel.setIntelligentSearch(erpEarbestMoney.getCustName()+","+erpEarbestMoney.getReceiptNo()+","+updateModel.getCustIdcardDecode());
						erpEarbestMoneyMapper.updateByPrimaryKeySelective(updateModel);
					} else if("2".equals(erpEarbestMoney.getPerformanceName())) {
						ErpEarbestMoney updateModel = new ErpEarbestMoney();
						updateModel.setShardDbName(shardDbName);
						updateModel.setEarbestId(erpEarbestMoney.getEarbestId());
						if(StringUtils.isNotBlank(erpEarbestMoney.getCustIdcard()) && erpEarbestMoney.getCustIdcard().contains("****")){
							ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerInfoByCustId(shardDbName,erpEarbestMoney.getCustId());
							if (erpFunRentCustomer != null) {
								String idCard = erpFunRentCustomer.getIdCard();
								if (StringUtils.isNotBlank(idCard)) {
									idCard = EnCodeHelper.decode(idCard);
									updateModel.setCustIdcardDecode(idCard);
									if(idCard.length()>3){
										updateModel.setCustIdcard(idCard.substring(0, 4)+"**************");
									} else {
										updateModel.setCustIdcard(idCard+"***************");
									}
								}
							}
						} else {
 							updateModel.setCustIdcardDecode(erpEarbestMoney.getCustIdcard());
						}
						updateModel.setIntelligentSearch(erpEarbestMoney.getCustName()+","+erpEarbestMoney.getReceiptNo()+","+updateModel.getCustIdcardDecode());
						erpEarbestMoneyMapper.updateByPrimaryKeySelective(updateModel);
					}
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
