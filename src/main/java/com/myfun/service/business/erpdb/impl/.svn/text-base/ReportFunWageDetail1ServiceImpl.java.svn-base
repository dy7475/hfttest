package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunAssessmentStatisticsMapper;
import com.myfun.repository.erpdb.param.ErpPerformanceAssessmentCountParam;
import com.myfun.repository.reportdb.dao.ReportFunWageDetail1Mapper;
import com.myfun.repository.reportdb.po.ReportFunWageDetail1;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ReportFunWageDetail1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ReportFunWageDetail1ServiceImpl extends AbstractService<ReportFunWageDetail1, Long> implements ReportFunWageDetail1Service {
	static Map<Integer, String> wageColumnMap = new HashMap<>();
	static{
		wageColumnMap.put(1, "FXZ_COUNT"); // 房源新增
		wageColumnMap.put(2, "KXZ_COUNT"); // 客源新增
		wageColumnMap.put(3, "BZWT_COUNT"); // 普通委托
		wageColumnMap.put(4, "PTWT_COUNT"); // 普通委托
		wageColumnMap.put(5, "XSWT_COUNT"); // 限时委托
		wageColumnMap.put(6, "DJWT_COUNT"); // 独家委托
		wageColumnMap.put(7, "GJ_COUNT"); // 普通更进
		wageColumnMap.put(8, "FK_COUNT"); // 房堪
		wageColumnMap.put(9, "YJ_COUNT"); // 议价
		wageColumnMap.put(10, "TPSC_COUNT"); // 图片房源
		wageColumnMap.put(11, "SPSC_COUNT"); // 视频房源
		wageColumnMap.put(12, "VRSC_COUNT"); // VR房源
		wageColumnMap.put(13, "ZFY_COUNT"); // 真房源
		wageColumnMap.put(14, "IPCALL_COUNT"); // ip电话拨打房源量
		wageColumnMap.put(15, "DK_COUNT"); // 带看客户
		wageColumnMap.put(16, "KFDP_COUNT"); // 空看
		wageColumnMap.put(17, "HBFX_COUNT"); // 海报分享
		wageColumnMap.put(18, "YSTJ_COUNT"); // 钥匙
	}


	@Autowired
	private ReportFunWageDetail1Mapper reportFunWageDetail1Mapper;
	@Autowired
	private ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = reportFunWageDetail1Mapper;
	}

	/**
	 * @Title 先吧标记修改了，然后扣除对应的有效量
	 * @Author lcb
	 * @Date 2018/2/2
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer updateWorkCount(Integer cityId, Integer compId, ErpPerformanceAssessmentCountParam param) {
		Integer validFlag = param.getValidFlag();

		param.setCityId(cityId);
		Integer itemCount = reportFunWageDetail1Mapper.updateCountById(cityId, param);

		// 更新工作量
		String fieldName = wageColumnMap.get(param.getCountType());
		erpFunAssessmentStatisticsMapper.updateDataById(cityId, param.getId(), fieldName, itemCount, validFlag);


		return itemCount;
	}
}
