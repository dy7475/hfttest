package com.myfun.erpWeb.businesstools.renovation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunTaskMapper;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerTrackMapper;
import com.myfun.repository.erpdb.po.ErpFunTask;
import com.myfun.repository.erpdb.po.ErpFunTaskExample;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrack;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrackExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpRenovationTrackService;

@RestController
@RequestMapping("/renovation")
public class RenovationTrackController extends BaseController{

	@Autowired
	private ErpRenovationCustomerTrackMapper erpRenovationCustomerTrackMapper;
	@Autowired
	private ErpFunTaskMapper erpFunTaskMapper;
	@Autowired
	private ErpRenovationTrackService erpRenovationTrackService;
	/**
	 * 装修客户写跟进
	 * @author 张宏利
	 * @param
	 * @since 2018年2月26日
	 */
	@RequestMapping("/createTrack")
	public ResponseJson createTrack(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer archiveId = operator.getArchiveId();
		erpRenovationTrackService.createTrack(cityId, compId, userId, archiveId, param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 获取装修客户跟进列表
	 * @author 张宏利
	 * @since 2018年2月26日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getTrackList")
	public ResponseJson getTrackList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer renovationCustomerId = param.getInteger("id");
		ErpRenovationCustomerTrackExample example = new ErpRenovationCustomerTrackExample();
		example.createCriteria().andRenovationCustomerIdEqualTo(renovationCustomerId).andCompIdEqualTo(operator.getCompId());
		example.setShardCityId(operator.getCityId());
		example.setOrderByClause("CREATION_TIME DESC");
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpRenovationCustomerTrack> trackList = erpRenovationCustomerTrackMapper.selectByExample(example);
		PageInfo<ErpRenovationCustomerTrack> pageInfo = new PageInfo<ErpRenovationCustomerTrack>(trackList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 获取装修客户提醒列表
	 * @author 张宏利
	 * @since 2018年2月26日
	 * @param param
	 * @return
	 */
	@RequestMapping("/getWarnList")
	public ResponseJson getWarnList(@RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer caseId = param.getInteger("id");
		ErpFunTaskExample example = new ErpFunTaskExample();
		example.createCriteria().andCaseIdEqualTo(caseId).andCompIdEqualTo(operator.getCompId())
				.andTaskTypeEqualTo(Const.DIC_TASK_TYPE_RENOVATION_REMIND);
		example.setShardCityId(operator.getCityId());
		example.setOrderByClause("CREATION_TIME DESC");
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunTask> erpFunTask = erpFunTaskMapper.selectByExample(example);
		PageInfo<ErpFunTask> pageInfo = new PageInfo<ErpFunTask>(erpFunTask);
		return ErpResponseJson.ok(pageInfo);
	}
	
}


