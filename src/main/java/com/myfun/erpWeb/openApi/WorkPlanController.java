package com.myfun.erpWeb.openApi;

import com.myfun.erpWeb.homepage.param.AppWorkAchieveParam;
import com.myfun.erpWeb.homepage.vo.AppWorkCountResultDto;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunWorkcountTargetMapper;
import com.myfun.repository.reportdb.dao.ReportFunStatisticTotleMapper;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.StatisticDetailType;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 外部文件上传
 * @author 张宏利
 * @since 2017年4月17日
 */
@RestController
@RequestMapping(value = "/openApi/workPlan")
public class WorkPlanController{
	private static final Logger logger = LoggerFactory.getLogger(WorkPlanController.class);
	@Autowired private ErpFunWorkcountTargetMapper erpFunWorkcountTargetMapper;
	@Autowired private ReportFunStatisticTotleMapper reportFunStatisticTotleMapper;

	/**
	 * 手机端工作情况
	 * @author 朱科
	 * @since 2018年7月31日
	 * @return
	 */
	@ApiOperation("掌通工作详情")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AppWorkCountResultDto.class, message = "成功")
	})
	@ResponseBody
	@PostMapping("/getAppWorkCountStatistic")
	public ResponseJson getAppWorkCountStatistic(@RequestBody AppWorkAchieveParam param) {
		// 参考接口 /getWorkCountStatistic
	
		Integer compId = param.getCompId();
		Integer cityId = param.getCityId();
		Integer rangeType =6; // 2:大区3：片区 4：门店 5：分组 6：到人
		String rangeIds = param.getRangeIds(); // 排名范围id userId
		//加吧，加吧，查询时间段,
		String startTime = DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd") +" 00:00:00";
		String endTime= DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd") + " 23:59:59";
		Integer dateType =1; // 考核类型，1=日考核2=周考核3=月考核
		Set<Integer> rangeIdset = new HashSet<>(); // 查询的范围Ids
		String[] idArr = rangeIds.split(",");
		for (String ids : idArr) {
			Integer rangeId = StringUtil.parseInteger(ids, 0);
			rangeIdset.add(rangeId);
		}
		
		Integer deptId = param.getDeptId(); // 查询分组的时候传
		// 指定查询哪些工作量
		List<String> workColumns = new ArrayList<>();
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), DJ_COUNT, 0))),0) houseAdd"); // 房增
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), DJ_COUNT, 0))),0) customerAdd"); // 客增
		workColumns.add("ISNULL((SUM(FK_COUNT)),0) fkCount"); // 房堪
		workColumns.add("ISNULL((SUM(FDK_COUNT)),0) fdkCount"); // 带看
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), GJ_COUNT, 0))),0) gjHouseCount"); // 房源跟进
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), GJ_COUNT, 0))),0) gjCustomerCount"); // 客源跟进
		workColumns.add("ISNULL((SUM(YSTJ_COUNT)),0) ystjCount"); // 钥匙提交
		workColumns.add("ISNULL((SUM(KFDP_COUNT)),0) kfdpCount"); // 看房点评（空看）
		workColumns.add("ISNULL((SUM(WT_COUNT) + SUM(XSWT_COUNT) + SUM(DJWT_COUNT) + SUM(BZWT_COUNT) + SUM(PTWT_COUNT)),0) wtCount"); // 委托
		workColumns.add("ISNULL((SUM(CJ_COUNT)),0) cjCount"); // 签约
		workColumns.add("ISNULL((SUM(TPSC_COUNT)),0) tpscCount"); // 图片上传
		workColumns.add("ISNULL((SUM(VR_COUNT)),0) vrCount");// VR上传量
		workColumns.add("ISNULL((SUM(SPSC_COUNT)),0) spscCount"); // 视频上传
//		workColumns.add("ISNULL((SUM(CKDH_COUNT)),0) ckdhCount"); // 查看电话
		workColumns.add("ISNULL((SUM(QFTG_COUNT)),0) qftgCount"); // 群发推广
		workColumns.add("ISNULL((SUM(PYQ_COUNT)),0) pyqCount"); // 朋友圈分享
//		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount");
		workColumns.add("ISNULL((SUM(iif(case_type in (1,2), MT_COUNT, 0))),0) mtHouseCount"); // 房源面谈
		workColumns.add("ISNULL((SUM(iif(case_type in (3,4), MT_COUNT, 0))),0) mtCustomerCount"); // 客源面谈
		workColumns.add("ISNULL((SUM(YJ_COUNT)),0) yjCount"); // 议价
		workColumns.add("ISNULL((SUM(KYYK_COUNT)),0) kyykCount"); // 约看
		workColumns.add("ISNULL((SUM(IPCALL_COUNT)),0) ipcallCount"); // 隐号拨打
		// 查询完成数据
		List<LinkedHashMap<String, Object>> statistcMap  = reportFunStatisticTotleMapper.getUcenterWorkCountMap(cityId, compId, rangeType, rangeIdset, workColumns, startTime, deptId, endTime, false,null);
		// 为空时补数据
		if (statistcMap == null || statistcMap.isEmpty()) {
//			statistcMap = new LinkedHashMap<>();
			LinkedHashMap<String, Object> dataMap = new LinkedHashMap<>();
//			dataMap.put("rangeId", compId);
			dataMap.put("houseAdd", 0);
			dataMap.put("customerAdd", 0);
			dataMap.put("fkCount", 0);
			dataMap.put("fdkCount", 0);
			dataMap.put("gjHouseCount", 0);
//			dataMap.put("ipcallCount", 0);
			dataMap.put("gjCustomerCount", 0);
			dataMap.put("ystjCount", 0);
			dataMap.put("kfdpCount", 0);
			dataMap.put("wtCount", 0);
			dataMap.put("cjCount", 0);
			dataMap.put("tpscCount", 0);
			dataMap.put("vrCount", 0);
			dataMap.put("spscCount", 0);
//			dataMap.put("ckdhCount", 0);
			dataMap.put("qftgCount", 0);

			dataMap.put("pyqCount", 0);
			dataMap.put("mtHouseCount", 0);
			dataMap.put("mtCustomerCount", 0);
			dataMap.put("yjCount", 0);
			dataMap.put("kyykCount", 0);
			dataMap.put("ipcallCount", 0);

			statistcMap.add(dataMap);
		}
		Map<String, Object> targetMap = erpFunWorkcountTargetMapper.getAppSumWorkCountTargetList(cityId, compId, deptId, rangeType, rangeIdset, dateType, startTime, endTime, false,null);
		if (targetMap==null){
			targetMap=new HashMap<>();
		}
		List<Map<String, Object>> resultList = new ArrayList<>();
		for(LinkedHashMap<String, Object> dataMap : statistcMap){
			dataMap.remove("rangeId");
			for (String key : dataMap.keySet()) {
				Map<String, Object> map = new HashMap<>();
//			map.put("rangeType", rangeType);
//			map.put("rangeId", rangeId);
				Object count = dataMap.get(key);
				map.put("count", count == null ? 0 : count);
				Object countT = targetMap.get(key + "T");
				map.put("countT", countT == null ? 0 : countT);
				lookRankTypeProcess(map, key);
				if("gjHouseCount".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 9);
				} else if("gjCustomerCount".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 9);
				} else if("houseAdd".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 1);
				} else if("customerAdd".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 1);
				} else if("mtHouseCount".equals(key)){
					map.put("funCust", 1);
					map.put("lookRankType", 46);
				} else if("mtCustomerCount".equals(key)){
					map.put("funCust", 2);
					map.put("lookRankType", 46);
				}
				resultList.add(map);
			}
		}
		//掌通需要这样返回
		Map<String,Object> result=new HashMap<>();
		result.put("list",resultList);
		return ErpResponseJson.ok(result);
	}
	
	private void lookRankTypeProcess(Map<String, Object> map, String key) {
		switch (key) {
			default:
				StatisticDetailType detailType = StatisticDetailType.serachIndexByName(key);
				if (detailType != null) {
					map.put("lookRankType", detailType.getIndex());
				}
			break;
		}
	}
}

