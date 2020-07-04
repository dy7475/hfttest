package com.myfun.erpWeb.openApi;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunStatisticDetailMapper;
import com.myfun.repository.erpdb.dao.ErpFunTrackMapper;
import com.myfun.repository.reportdb.dao.ReportHouseorcustFlowAnalysistotalMapper;
import com.myfun.repository.reportdb.po.ReportHouseorcustFlowAnalysistotal;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;

/**
* 补合同跟进数据
* @author 方李骥
* @since 2017年4月17日
*/
@Controller
@RequestMapping(value = "/openApi/flowRepair")
public class HouseOrCustFlowRepairController extends BaseController{
private static final Logger logger = LoggerFactory.getLogger(HouseOrCustFlowRepairController.class);
	
	@Autowired ErpFunCompMapper erpFunCompMapper;
	@Autowired ErpFunTrackMapper erpFunTrackMapper;
	@Autowired ErpFunStatisticDetailMapper erpFunStatisticDetailMapper;
	@Autowired AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired ReportHouseorcustFlowAnalysistotalMapper reportHouseorcustFlowAnalysistotalMapper;
	
	private volatile static PhotoDealParam photoDealParam = new PhotoDealParam();
	
	private volatile static Map<String, Integer> dealThreadCount = new HashMap<>();
	private static Map<String,String> columnMap = new HashMap<String,String>();
	private static Map<String,Map<String,String>> dateMap = new HashMap<String,Map<String,String>>();
	
	static {
		Map<String, String> date = new HashMap<String, String>();
		date.put("startTime", "2016-03-01");
		date.put("endTime", "2016-03-31 23:59:59");
		dateMap.put("1", date);
		Map<String, String> date1 = new HashMap<String, String>();
		date1.put("startTime", "2016-04-01");
		date1.put("endTime", "2016-04-30 23:59:59");
		dateMap.put("2", date1);
		Map<String, String> date2 = new HashMap<String, String>();
		date2.put("startTime", "2016-05-01");
		date2.put("endTime", "2016-05-31 23:59:59");
		dateMap.put("3", date2);
		Map<String, String> date3 = new HashMap<String, String>();
		date3.put("startTime", "2016-06-01");
		date3.put("endTime", "2016-06-30 23:59:59");
		dateMap.put("4", date3);
		Map<String, String> date4 = new HashMap<String, String>();
		date4.put("startTime", "2016-07-01");
		date4.put("endTime", "2016-07-31 23:59:59");
		dateMap.put("5", date4);
		Map<String, String> date6 = new HashMap<String, String>();
		date6.put("startTime", "2016-08-01");
		date6.put("endTime", "2016-08-31 23:59:59");
		dateMap.put("7", date6);
		Map<String, String> date7 = new HashMap<String, String>();
		date7.put("startTime", "2016-09-01");
		date7.put("endTime", "2016-09-30 23:59:59");
		dateMap.put("8", date7);
		Map<String, String> date8 = new HashMap<String, String>();
		date8.put("startTime", "2016-10-01");
		date8.put("endTime", "2016-10-31 23:59:59");
		dateMap.put("9", date8);
		Map<String, String> date9 = new HashMap<String, String>();
		date9.put("startTime", "2016-11-01");
		date9.put("endTime", "2016-11-30 23:59:59");
		dateMap.put("10", date9);
		Map<String, String> date10 = new HashMap<String, String>();
		date10.put("startTime", "2016-12-01");
		date10.put("endTime", "2016-12-31 23:59:59");
		dateMap.put("11", date10);
		Map<String, String> date11 = new HashMap<String, String>();
		date11.put("startTime", "2017-01-01");
		date11.put("endTime", "2017-01-31 23:59:59");
		dateMap.put("12", date11);
		Map<String, String> date12 = new HashMap<String, String>();
		date12.put("startTime", "2017-02-01");
		date12.put("endTime", "2017-02-28 23:59:59");
		dateMap.put("13", date12);
		Map<String, String> date14 = new HashMap<String, String>();
		date14.put("startTime", "2017-03-01");
		date14.put("endTime", "2017-03-31 23:59:59");
		dateMap.put("15", date14);
		Map<String, String> date15 = new HashMap<String, String>();
		date15.put("startTime", "2017-04-01");
		date15.put("endTime", "2017-04-30 23:59:59");
		dateMap.put("16", date15);
		Map<String, String> date16 = new HashMap<String, String>();
		date16.put("startTime", "2017-05-01");
		date16.put("endTime", "2017-05-31 23:59:59");
		dateMap.put("17", date16);
		Map<String, String> date17 = new HashMap<String, String>();
		date17.put("startTime", "2017-06-01");
		date17.put("endTime", "2017-06-30 23:59:59");
		dateMap.put("18", date17);
		Map<String, String> date18 = new HashMap<String, String>();
		date18.put("startTime", "2017-07-01");
		date18.put("endTime", "2017-07-31 23:59:59");
		dateMap.put("19", date18);
	}
	
	static {
		columnMap.put("1", "effectiveSaveCount");
		columnMap.put("2", "sealingplateSaveCount");
		columnMap.put("4", "bookSaveCount");
		columnMap.put("5", "innderdealSaveCount");
		columnMap.put("6", "outdealSaveCount");
		columnMap.put("101", "transfertosaleSaveCount");
		columnMap.put("102", "transfertoleaseSaveCount");
		columnMap.put("7", "cancellSaveCount");
		columnMap.put("105", "transfertoshareSaveCount");
		columnMap.put("106", "transfertopublicSaveCount");
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
	public ErpResponseJson copySwitch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String needUpdateParam = request.getParameter("needUpdateParam");// 是否需要修改参数
		if (!"1".equals(needUpdateParam)) {
			return ErpResponseJson.ok(photoDealParam);
		}
		Long tempSleepTime = StringUtil.parseLong(request.getParameter("sleepTime"), 50);// 暂停时间
		if (tempSleepTime <= 50) {
			tempSleepTime = 50L;
		}
		photoDealParam.setSleepTime(tempSleepTime);
		int copySwitch = StringUtil.paseInteger(request.getParameter("copySwitch"), 0);// 是否启动
		if (copySwitch == 1) {
			photoDealParam.setCopySwitch(true);
		} else {
			photoDealParam.setCopySwitch(false);
		}
		int dealCount = StringUtil.paseInteger(request.getParameter("dealCount"), 1);// 每次请求处理循环多少次
		photoDealParam.setDealCount(dealCount);
		String dbName = request.getParameter("threadDbName");
		if (StringUtils.isNotBlank(dbName)) {
			int threadCount = StringUtil.paseInteger(request.getParameter("threadCount"), 1);// 线程数
			if (threadCount <= 0) {
				threadCount = 1;
			} else if (threadCount > 20) {
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
	@RequestMapping(value = "/startCopy")
	public ErpResponseJson startCopy(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		if (photoDealParam.getIsStart()) {
//			return ErpResponseJson.warn("执行中，请先停止再尝试开启");
//		}
//		photoDealParam.setIsStart(true);
		photoDealParam.setCopySwitch(true);
//		List<String> configs = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		// 每个库一个线程
//		for (int i = 0; i < configs.size(); i++) {
//			final String shardDbName = configs.get(i);
//			// 每个库增加不同的线程数
//			Integer threadCount = dealThreadCount.get(shardDbName.toLowerCase());
//			if (threadCount == null) {
//				threadCount = 1;
//			}
//			for (int j = 0; j < threadCount; j++) {
				String dbName = request.getParameter("threadDbName");
				if(StringUtils.isBlank(dbName)) {
					return ErpResponseJson.warn("库名必传");
				}
				logger.error("-----create thread---");
				new DealVideoThread(dbName).start();
//			}
//		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 处理视频的线程
	 * 
	 */
	public class DealVideoThread extends Thread{
		String shardDbName = null;

		public DealVideoThread(String shardDbName) {
			this.shardDbName = shardDbName;
		}
		
		@Override
		public void run() {
			try {
				boolean flag = false;
				List<Integer> cityIds = erpFunCompMapper.getCityIdsGroup(shardDbName);//查询城市
				for (Integer cityId : cityIds) {
					if(!flag && "198".equals(cityId)) {
						flag = true;
					}
					if(!flag) {
						continue;
					}
					System.out.println(shardDbName + "-cityId:->" + cityId);
					//查询每个城市下的公司
					List<Integer> compIds = erpFunCompMapper.selectCompIdsByCityId(shardDbName, cityId);
					for (Integer compId : compIds) {
						System.out.println(shardDbName + "-cityId:->" + cityId + "compId" + compId);
						//每个公司按时间拆分
						for (String keyDate : dateMap.keySet()) {
							if (!photoDealParam.getCopySwitch()) {
								return;// 动态停止
							}
							Map<String, String> timeMap = dateMap.get(keyDate);
							Date startTime = DateTimeHelper.parseToDate(timeMap.get("startTime"));
							Date endTime = DateTimeHelper.parseToDate(timeMap.get("endTime"));
							for (int i = 0; i < 35; i++) {
								if(DateTimeHelper.compareTwoDate(startTime, endTime) < 0) {
									break;
								}
								String startTimeStr = DateTimeHelper.formatDateTimetoString(startTime);
								String endTimeStr = DateTimeHelper.formatDateTimetoString(startTime, "yyyy-MM-dd 23:59:59");
								//查询每个时间下对应房源的状态变更情况
								List<Map<String, Object>> dealList = erpFunStatisticDetailMapper.getNeedRepairHouseCustFlowAnalysisCountList(shardDbName, cityId, compId, startTimeStr, endTimeStr);
								//查询对应跟进的修改状态
								List<Map<String, Object>> trackList = erpFunStatisticDetailMapper.getNeedRepairHouseCustFlowAnalysisTrackList(shardDbName, cityId, compId, startTimeStr, endTimeStr);
								Calendar calendar = Calendar.getInstance();
								calendar.setTime(startTime);
								calendar.add(Calendar.DAY_OF_MONTH, 1);
								startTime = calendar.getTime();
								Map<String, Map<String, Object>> trackMap = BeanUtil.listMapObjecttoMap(trackList,"trackId");
								Map<String, Map<String, Object>> returnDataMap = new HashMap<>();
								for (Map<String, Object> dataMap : dealList) {
									Object key = dataMap.get("keyWord");
									Object maxTrackId = dataMap.get("maxId");
									Object minTrackId = dataMap.get("minId");
									//获取最大的跟进和最小的跟进
									if (key == null || minTrackId == null || maxTrackId ==null) {
										continue;
									}
									String keyStr = key.toString();//key代表每人每月的标识符
									String minTrackIdStr = minTrackId.toString();//获取第一次修改
									String maxTrackIdStr = maxTrackId.toString();//获取第二次修改
									String caseStatusStr = null;
									if (!minTrackIdStr.equals(maxTrackIdStr)) {//如果不是同一个修改
										Map<String, Object> minTrackData = trackMap.get(minTrackId);
										Map<String, Object> maxTrackData = trackMap.get(maxTrackId);
										if (minTrackData != null && maxTrackData != null) {
											//获取前后两次状态进行对比
											Object minTrackStatus = minTrackData.get("caseStaus");
											Object maxTrackStatus = maxTrackData.get("caseStaus");
											if (minTrackStatus != null && maxTrackStatus != null) {
												String minTrackStatusStr = minTrackStatus.toString();
												String maxTrackStatusStr = maxTrackStatus.toString();
												//两次状态不一次，说明发生了状态变更，那么用最后一次状态做为计算量，累加到每人每月的对应的字段量上去
												if (!minTrackStatusStr.equals(maxTrackStatusStr)) {
													caseStatusStr = maxTrackStatusStr;
												}
											}
										}
									} else {
										Map<String, Object> minTrackData = trackMap.get(minTrackId);
										if(minTrackData != null) {
											Object caseStatus = minTrackData.get("caseStaus");
											if (caseStatus != null) {
												caseStatusStr = caseStatus.toString();
											}
										}
									}
									if(caseStatusStr == null) {
										continue;
									}
									String columnName = columnMap.get(caseStatusStr);
									if (StringUtils.isNotBlank(columnName)) {
										Map<String, Object> data = returnDataMap.get(keyStr);
										if (data != null) {
											data.put(columnName,StringUtil.parseInteger(String.valueOf(data.get(columnName)), 0)+ 1);
										} else {
											data = new HashMap<String, Object>();
											data.put(columnName, 1);
											data.putAll(dataMap);
											returnDataMap.put(keyStr, data);
										}
									}
								}
								// 以timedate为key将caseStatus和对应的数量组装放入resultMap
								for (Entry<String, Map<String, Object>> entry : returnDataMap.entrySet()) {
									String key = entry.getKey();
									Map<String, Object> dataMap = entry.getValue();
									//查一下这个key在数据库中有没有数据了，如果有了则是更新，否则新增，这里是补存量，数据有的是当月新增的，同一个人每月有一条记录，上面不同的字段记录当月新增，和存量的状态量
									ReportHouseorcustFlowAnalysistotal reportHouseorcustFlowAnalysistotal = reportHouseorcustFlowAnalysistotalMapper.selectHouseorcustFlowAnalysistotal(shardDbName, dataMap.get("cityId"),key);
									ReportHouseorcustFlowAnalysistotal record = new ReportHouseorcustFlowAnalysistotal();
									record.setShardDbName(shardDbName);
									if (dataMap.get("effectiveSaveCount") != null) {
										record.setEffectiveSaveCount(StringUtil.parseInteger(dataMap.get("effectiveSaveCount")));
									}
									if (dataMap.get("sealingplateSaveCount") != null) {
										record.setEffectiveAddCount(StringUtil.parseInteger(dataMap.get("sealingplateSaveCount")));
									}
									if (dataMap.get("bookSaveCount") != null) {
										record.setSealingplateSaveCount(StringUtil.parseInteger(dataMap.get("bookSaveCount")));
									}
									if (dataMap.get("innderdealSaveCount") != null) {
										record.setInnderdealSaveCount(StringUtil.parseInteger(dataMap.get("innderdealSaveCount")));
									}
									if (dataMap.get("outdealSaveCount") != null) {
										record.setOutdealSaveCount(StringUtil.parseInteger(dataMap.get("outdealSaveCount")));
									}
									if (dataMap.get("transfertosaleSaveCount") != null) {
										record.setTransfertosaleSaveCount(StringUtil.parseInteger(dataMap.get("transfertosaleSaveCount")));
									}
									if (dataMap.get("transfertoleaseSaveCount") != null) {
										record.setTransfertoleaseSaveCount(StringUtil.parseInteger(dataMap.get("transfertoleaseSaveCount")));
									}
									if (dataMap.get("cancellSaveCount") != null) {
										record.setCancellSaveCount(StringUtil.parseInteger(dataMap.get("cancellSaveCount")));
									}
									if (dataMap.get("transfertoshareSaveCount") != null) {
										record.setTransfertoshareSaveCount(StringUtil.parseInteger(dataMap.get("transfertoshareSaveCount")));
									}
									if (dataMap.get("transfertopublicSaveCount") != null) {
										record.setTransfertopublicSaveCount(StringUtil.parseInteger(dataMap.get("transfertopublicSaveCount")));
									}
									record.setCityId(StringUtil.parseInteger(dataMap.get("cityId")));
									if (reportHouseorcustFlowAnalysistotal != null) {
										record.setId(reportHouseorcustFlowAnalysistotal.getId());
										reportHouseorcustFlowAnalysistotalMapper.updateByPrimaryKeyAndCityIdSelective(record);
									} else {
										record.setCompId(StringUtil.parseInteger(dataMap.get("compId")));
										record.setAreaId(StringUtil.parseInteger(dataMap.get("areaId")));
										record.setRegId(StringUtil.parseInteger(dataMap.get("regId")));
										record.setDeptId(StringUtil.parseInteger(dataMap.get("deptId")));
										record.setGrId(StringUtil.parseInteger(dataMap.get("grId")));
										record.setUserId(StringUtil.parseInteger(dataMap.get("userId")));
										record.setArchiveId(StringUtil.parseInteger(dataMap.get("archiveId")));
										record.setCaseType(StringUtil.parseByte(dataMap.get("caseType").toString()));
										record.setCreationTime(DateTimeHelper.parseToDate(dataMap.get("creationTime").toString()));
										reportHouseorcustFlowAnalysistotalMapper.insertSelective(record);
									}
								}
							}
						}
					}
				}
				logger.error("------------------over------------------");
			} catch (Exception e) {
				logger.error("!!!!!!!!!!!!!!!!!!!error,over!!!!!!!!!!!!!!!!!!!");
				e.printStackTrace();
			}
			photoDealParam.setIsStart(false);// 一个完了就改为处理完了，如果还有处理的在方法里面会被改为处理中
		}
	}
}
