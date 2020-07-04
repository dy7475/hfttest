package com.myfun.erpWeb.managecenter.financialStatements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.financialStatements.param.FinancialStatementsMonthlyShopReportParam;
import com.myfun.erpWeb.managecenter.financialStatements.param.PaySettlementListParam;
import com.myfun.erpWeb.managecenter.financialStatements.param.ProfitPercentParam;
import com.myfun.erpWeb.managecenter.financialStatements.param.UpdateDeptFeeStatusParam;
import com.myfun.erpWeb.managecenter.financialStatements.vo.ErpFunDealFinanceVo;
import com.myfun.erpWeb.managecenter.financialStatements.vo.FinancialStatementsMonthlyShopReportVo;
import com.myfun.erpWeb.managecenter.financialStatements.vo.PaySettlementListVo;
import com.myfun.erpWeb.managecenter.financialStatements.vo.PercentProfitListVo;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunDealDto;
import com.myfun.repository.erpdb.dto.ErpFunDealVo;
import com.myfun.repository.erpdb.dto.ErpFunDeptFeeListDto;
import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeListParam;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeModifyParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunDeptFeeListService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;


/**
  *财务相关模块
  * @author 李成兵
  * @since 2018/6/9
  * @param
  * @return
  */
@Api(tags = "财务相关模块")
@RequestMapping(value="/managecenter/financeModule",method=RequestMethod.POST)
@RestController
public class FinanceModuleController extends BaseController{

	@Autowired
	ErpFunDeptFeeListService erpFunDeptFeeListService;
	@Autowired
	ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
	@Autowired
	ErpFunDeptFeeListMapper erpFunDeptFeeListMapper;
	@Autowired
	ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
	ErpFunDeptFeeMapper erpFunDeptFeeMapper;
	@Autowired
	ErpFunDeptFeeDetailMapper erpFunDeptFeeDetailMapper;
	@Autowired
	ErpFunDeptFeeRecordMapper erpFunDeptFeeRecordMapper;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;

	/**
	  * 添加门店费用
	  * @author 李成兵
	  * @since 2018/6/9
	  * @param
	  * @return
	  */
	@RequestMapping("/addDeptFee")
	public ResponseJson getSalaryType(@RequestBody ErpFunDeptFeeListParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		param.setPartnerId(operator.getPartnerId());
		param.setIsNewOrganization(getOperator().newOrganizationType());
		if(!getOperator().newOrganizationType()){
			erpFunDeptFeeListService.addFunDeptFee(cityId, compId, userId, operator.getUserName(), operator.getDeptId(), param);
		}else{
			erpFunDeptFeeListService.addOrganizationFee(cityId, compId, userId, operator.getUserName(), operator.getDeptId(), param);
		}
		return new ErpResponseJson();
	}


    /**
     * 修改门店费用
     *
     * @param
     * @return
     * @author 黎桂良
     * @since 2019/7/27
     */
    @RequestMapping("/modifyDeptFee")
    public ResponseJson modifyDeptFee(@RequestBody ErpFunDeptFeeModifyParam param) {

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        erpFunDeptFeeListService.modifyDeptFee(cityId, compId, userId, operator.getUserName(), operator.getDeptId(), param);
        return new ErpResponseJson();
    }

    /**
     * 单独修改门店费用图片
     *
     * @param
     * @return
     * @author 黎桂良
     * @since 2019/7/27
     */
    @RequestMapping("/updateDeptFeeBillPic")
    public ResponseJson updateDeptFeeBillPic(@RequestBody ErpFunDeptFeeModifyParam param) {

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer userId = operator.getUserId();
        erpFunDeptFeeListService.updateDeptFeeBillPic(cityId, compId, userId, operator.getUserName(), operator.getDeptId(), param);
        return new ErpResponseJson();
    }

	/**
	 * 门店费用批量导入
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/17
	 */
	@RequestMapping("/importDeptFee")
	public ResponseJson importDeptFee(@RequestBody ErpFunDeptFeeListParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer userId = operator.getUserId();
		Integer res=erpFunDeptFeeListService.importDeptFee(cityId, compId, userId, operator.getUserName(), operator.getDeptId(), param, operator.getPartnerId());
		List<Map<String,Integer>> returnList = new ArrayList<>();
		Map<String,Integer> returnMap = new HashMap<>();
		returnMap.put("importCount",res);
		returnList.add(returnMap);
		return new ErpResponseJson(returnMap);
	}

	/**
	 * 门店月报列表
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/10
	 */
	@ApiOperation("门店月报列表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = FinancialStatementsMonthlyShopReportVo.class, message = "成功")
	})
	@PostMapping("/getFinancialStatementsMonthlyShopReport")
	public ResponseJson getFinancialStatementsMonthlyShopReport(@RequestBody FinancialStatementsMonthlyShopReportParam param) throws Exception {
		Integer cityId = getOperator().getCityId();

		String dateType = param.getDateType();//获取统计时间类型
		param.setCompId(getOperator().getCompId());
		param.setDateType("A." + dateType);
		String date = param.getCountDate();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(date + "-01 00:00:00"));
		String nowDateStr = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		Map<String, String> map = this.buildPaymentIdString();
		String buildPaymentIdString = map.get("TRANS_COLUMN");
		String transfer = map.get("TRANSFER");
		String commission = map.get("COMMISSION");
		param.setTransfer(transfer);
		param.setCommission(commission);

		param.setNowDateStr(nowDateStr);
		param.setBuildPaymentIdString(buildPaymentIdString);
		String[] timeArr = createMonthTimeRange(date);
		String countDateStart = timeArr[0];
		String countDateEnd = timeArr[1];
		param.setCountDateStart(countDateStart);
		param.setCountDateEnd(countDateEnd);
		if(getOperator().newOrganizationType()){
			param.setIsNewOrganization(true);
		}
		List<Map<String, ErpFunFinancPayment>> list = erpFunDealMapper.getFinancialStatementsMonthlyShopReport(cityId, param);
		return new ErpResponseJson(list);
	}

	/**
	 * 获取业绩核算表
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/10
	 */
	@ApiOperation("获取业绩核算表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = PaySettlementListVo.class, message = "成功")
	})
	@PostMapping("/getPayAccountingList")
	public ResponseJson getPayAccountingList(@RequestBody PaySettlementListParam param)  {
		//获取账务列表和合同数据
		Map<String, Object> hm=this.getProcessFinancListAndMerge(param,0);//0：获取业绩核算表数据  1：获取收款结算表数据
		Integer total=(Integer)hm.get("total");
		hm.remove("total");
		List<Map<String, Object>> returnList = new ArrayList<>();
		returnList.add(hm);
		ErpResponseJson responseJson = new ErpResponseJson(returnList);
		responseJson.setTotal(total.longValue());
		return responseJson;
	}



	/**
	 * 获取收款结算表数据
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/14
	 */
	@ApiOperation("获取收款结算表数据")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = PaySettlementListVo.class, message = "成功")
	})
	@PostMapping("/getPaySettlementList")
	public ResponseJson getPaySettlementList(@RequestBody PaySettlementListParam param){
		Map<String, Object> hm=this.getProcessFinancListAndMerge(param,1);//0：获取业绩核算表数据  1：获取收款结算表数据
		Integer total=(Integer)hm.get("total");
		hm.remove("total");
		List<Map<String, Object>> returnList = new ArrayList<>();
		returnList.add(hm);
		ErpResponseJson responseJson = new ErpResponseJson(returnList);
		responseJson.setTotal(total.longValue());
		return responseJson;
	}

	/**
	 * 构建业绩来源 行转利 列条件
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/10
	 * @return
	 *
	 */
	public Map<String,String> buildPaymentIdString() throws Exception{
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		List<ErpFunFinancPayment> funFinancPaymentList = erpFunFinancPaymentMapper.buildSystemDefinitionFinancPayment(cityId,compId);
		StringBuilder sb = new StringBuilder();
		String commissionSumStr = "";
		String transferSumStr = "";
		for (ErpFunFinancPayment po : funFinancPaymentList) {
			if(Const.DIC_DEAL_PAYMENT_COMMISSION.equals(po.getEnName())){
				sb.append("[A_" + po.getPaymentId() + "_COUNT" + "],");
				commissionSumStr = commissionSumStr+"isnull(B.A_"+po.getPaymentId() + "_COUNT,0)+";
			}else if(Const.DIC_DEAL_PAYMENT_MORTGAGE.equals(po.getEnName())){
				sb.append("[A_" + po.getPaymentId() + "_COUNT" + "],");
				transferSumStr = transferSumStr+"isnull(B.A_"+po.getPaymentId() + "_COUNT,0)+";
			}else if(Const.DIC_DEAL_PAYMENT_TRANSFER.equals(po.getEnName())){
				sb.append("[A_"+ po.getPaymentId()+"_COUNT" + "],");
				transferSumStr = transferSumStr+"isnull(B.A_"+po.getPaymentId() + "_COUNT,0)+";
			}
		}
		commissionSumStr = commissionSumStr.substring(0, commissionSumStr.length()-1);
		transferSumStr = transferSumStr.substring(0, transferSumStr.length()-1);
		Map<String,String> map = new HashMap<String,String>();
		String transColumn = sb.toString();
		transColumn = transColumn.substring(0, transColumn.lastIndexOf(","));
		map.put("TRANS_COLUMN",transColumn);
		map.put("TRANSFER", transferSumStr);
		map.put("COMMISSION", commissionSumStr);
		return map;
	}

	/**
	 * 创建一个月的起始时间和结束时间
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/10
	 * @return
	 *
	 */
	private String[] createMonthTimeRange(String date) throws Exception {
		String[] timeArr = new String[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeHelper.parseToDate(date+"-01 00:00:00"));
		timeArr[0] = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.add(Calendar.MONTH,1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		timeArr[1] = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd)+" 23:59:59";
		return timeArr;
	}


	/**
	  * 门店费用列表
	  * @author 李成兵
	  * @since 2018/6/9
	  * @param
	  * @return
	  */
	@RequestMapping("/getDeptFeeList")
	public ResponseJson getDeptFeeList(@RequestBody ErpFunDeptFeeListParam param) {

		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		param.setPartnerId(operator.getPartnerId());
		param.setOpenPartner(operator.openPartner());
		param.setIsNewOrganization(getOperator().newOrganizationType());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), param.isNeedCount());
		List<ErpFunDeptFeeListDto> resList = erpFunDeptFeeListMapper.getFunDeptFeeList(cityId,compId, param);
        resList.stream().forEach(a -> {
            if (StringUtil.isNotBlank(a.getBillPicUrl())) {
                a.setBillPicUrl(AppConfig.getHousePicDomainPath(a.getBillPicUrl()));
            }
        });
		return new ErpResponseJson(new PageInfo<>(resList));
	}

    /**
      * 门店费用审核
      * @author 李成兵
      * @since 2018/5/10
      * @param
      * @return
      */
    @ApiOperation("门店费用审核")
	@ApiResponses({@ApiResponse(code = 200,message = "success")})
    @PostMapping("/auditDeptFee")
    public ResponseJson auditDeptFee(@RequestBody ErpFunDeptFeeListParam param) {

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        String userName = operator.getUserName();
        Integer userId = operator.getUserId();
        Integer deptId = operator.getDeptId();
        Integer compId = operator.getCompId();

        erpFunDeptFeeListService.auditDeptFee(cityId,compId, deptId,  userId,userName, param);
        return new ErpResponseJson();
    }

    /**
      * 修改门店费用详细
      * @author 李成兵
      * @since 2018/5/10
      * @param
      * @return
      */
	@ApiOperation("修改门店费用详细")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
    @PostMapping("/updateDeptFee")
    public ResponseJson updateDeptFeeStatus(@RequestBody UpdateDeptFeeStatusParam param) {

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        Integer deptId = operator.getDeptId();
        Integer compId = operator.getCompId();
        String userName = operator.getUserName();

        Integer res = erpFunDeptFeeListService.updateDeptFee(cityId, compId,deptId, userId, userName, param, operator.getPartnerId());
        return new ErpResponseJson(res);
    }

    /**
     * 门店费用审核
     * @author 李成兵
     * @since 2018/5/10
     * @param
     * @return
     */
    @RequestMapping("/summaryFunFeeList")
    public ResponseJson summaryFunFeeList(@RequestBody ErpFunDeptFeeListParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        param.setPartnerId(operator.getPartnerId());
        param.setOpenPartner(operator.openPartner());
        // 查询数据列表，查询出来需要合并数据
        param.setIsNewOrganization(getOperator().newOrganizationType());
        List<ErpFunDeptFeeList> erpFunDeptFeeLists = erpFunDeptFeeListMapper.summaryFunFeeList(cityId, compId, param);
        return new ErpResponseJson(erpFunDeptFeeLists);
    }

    /**
     * @tag 查询门店费用模板表
     * @author 邓永洪
     * @since 2018/5/11
     */
	@RequestMapping("/getSysDeptFeeList")
	public ResponseJson getSysDeptFeeList(@RequestBody BaseMapParam param){
		ErpFunDeptFeeExample erpFunDeptFeeExample=new ErpFunDeptFeeExample();
		erpFunDeptFeeExample.setShardCityId(getOperator().getCityId());
		erpFunDeptFeeExample.setOrderByClause("SEQ_NO DESC");
		erpFunDeptFeeExample.createCriteria().andCompIdEqualTo(getOperator().getCompId()).andStatusEqualTo((byte)0);
		List<ErpFunDeptFee> list=erpFunDeptFeeMapper.selectByExample(erpFunDeptFeeExample);
		return ErpResponseJson.ok(list);
	}

	/**
	 * @tag 删除店费用配置
	 * @author 邓永洪
	 * @since 2018/5/11
	 */
	@RequestMapping("/delSysDeptFee")
	public ResponseJson delSysDeptFee(@RequestBody BaseMapParam param) throws ParseException {
		Integer feeId=param.getInteger("feeId");
		if (Integer.valueOf(1).equals(getOperator().openPartner()) && null != getOperator().getPartnerId() && getOperator().getPartnerId() > 0) {// 加盟商不能删除店费用模板表
			throw new BusinessException("不能删除门店费用配置");
		}
		ErpFunDeptFee funDeptFee=new ErpFunDeptFee();
		funDeptFee.setFeeId(feeId);
		funDeptFee.setStatus((byte)1);
		funDeptFee.setShardCityId(getOperator().getCityId());
		erpFunDeptFeeMapper.updateByPrimaryKeySelective(funDeptFee);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date currentTime=calendar.getTime();
		erpFunDeptFeeMapper.updateFunDeptFee(getOperator().getCityId(),currentTime,feeId);
		writeDeptFeeDetailRecord(feeId,currentTime);
		return ErpResponseJson.ok();
	}

    /**
     * @tag 修改增加门店费用配置
     * @author 邓永洪
     * @since 2018/5/11
     */
	@RequestMapping("/addEditSysFunDept")
	public ResponseJson addEditSysFunDept(@RequestBody ErpFunDeptFeeListParam param) {
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer partnerId = getOperator().getPartnerId();
		if (Integer.valueOf(1).equals(getOperator().openPartner()) && null != getOperator().getPartnerId() && getOperator().getPartnerId() > 0) {// 加盟商不能修改、增加店费用模板表
			throw new BusinessException("不能操作门店费用配置");
		}
		// 解析门店费用(id,name,amount)
		List<ErpFunDeptFee> deptFeeList = JSON.parseObject(param.getDeptFeeList(), new TypeReference<List<ErpFunDeptFee>>() {});
		List<ErpFunDeptFee> insertList = new ArrayList<>();
		List<ErpFunDeptFee> updateList = new ArrayList<>();
		// 查重/排序
		Integer seq;
		seq = deptFeeList.size();
		for (Integer i = 0; i < deptFeeList.size(); i++) {
			ErpFunDeptFee funDeptFeePO = deptFeeList.get(i);
			// 新增数据判重
			if (funDeptFeePO.getFeeId() == null) {
				// 老数据
				ErpFunDeptFee funDeptFee = erpFunDeptFeeMapper.getDeptFeeByName(cityId, compId, funDeptFeePO.getFeeName());
				if (null != funDeptFee) {
					funDeptFee.setSeqNo(seq);
					BigDecimal amount = new BigDecimal(0);
					if (funDeptFeePO.getFeeAmount() != null) {
						amount = funDeptFeePO.getFeeAmount();
					}
					funDeptFee.setFeeAmount(amount);
					funDeptFee.setStatus((byte) 0);
					updateList.add(funDeptFee);
				} else {
					funDeptFeePO.setSeqNo(seq);
					funDeptFeePO.setCreationTime(new Date());
					funDeptFeePO.setCompId(compId);
					insertList.add(funDeptFeePO);
				}
			} else {
				funDeptFeePO.setSeqNo(seq);
				updateList.add(funDeptFeePO);
			}
			seq = seq - 1;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date currentTime=calendar.getTime();
		// 后期优化
		if (insertList.size() > 0) {
			Integer feeId = null;
			for (ErpFunDeptFee deptFeePO : insertList) {
				deptFeePO.setShardCityId(cityId);
				erpFunDeptFeeMapper.insertSelective(deptFeePO);
				feeId= erpFunDeptFeeMapper.getDeptFeeByName(cityId, compId, deptFeePO.getFeeName()).getFeeId();

				ErpFunDeptFeeDetailExample feeDetailExample = new ErpFunDeptFeeDetailExample();
				feeDetailExample.setShardCityId(cityId);
				feeDetailExample.createCriteria().andCompIdEqualTo(compId).andCountTimeEqualTo(currentTime);
				List<ErpFunDeptFeeDetail> detailList = erpFunDeptFeeDetailMapper.selectByExample(feeDetailExample);
				for (ErpFunDeptFeeDetail funDeptFeeDetailPO : detailList) {
					ErpFunDeptFeeList deptFeeListPO = new ErpFunDeptFeeList();
					deptFeeListPO.setShardCityId(cityId);
					deptFeeListPO.setDeptFeeId(funDeptFeeDetailPO.getDeptFeeId());
					deptFeeListPO.setDeptId(funDeptFeeDetailPO.getDeptId());
					deptFeeListPO.setFeeAmount(deptFeePO.getFeeAmount());
					deptFeeListPO.setFeeId(feeId);
					deptFeeListPO.setFeeName(deptFeePO.getFeeName());
					deptFeeListPO.setSeqNo(deptFeePO.getSeqNo());
					deptFeeListPO.setPartnerId(partnerId);
					erpFunDeptFeeListMapper.insertSelective(deptFeeListPO);
				}
			}
			writeDeptFeeDetailRecord(feeId, currentTime);
		}
		if (updateList.size() > 0) {
			Integer feeId = null;
			for (ErpFunDeptFee funDeptFeePO : updateList) {
				feeId = funDeptFeePO.getFeeId();
				funDeptFeePO.setShardCityId(cityId);
				erpFunDeptFeeMapper.updateByPrimaryKeySelective(funDeptFeePO);
				erpFunDeptFeeListMapper.updateFunDeptFeeList(cityId, funDeptFeePO.getFeeAmount(), currentTime, feeId, partnerId);
			}
			writeDeptFeeDetailRecord(feeId, currentTime);
		}
		return ErpResponseJson.ok();
	}

	/**
	 * @tag 配置项修改后批量写入修改日志
	 * @author 邓永洪
	 * @since 2018/5/11
	 */
	private void writeDeptFeeDetailRecord(Integer feeId, Date currentTime) {
		Operator operator = getOperator();
		List<ErpFunDeptFeeDetail> resList = erpFunDeptFeeDetailMapper.getFunDeptFeeDetailList(operator.getCityId(), feeId, currentTime);
		for (ErpFunDeptFeeDetail funDeptFeeDetailPO : resList) {
			String content = operator.getDeptName() + " " + operator.getUserName() + " 修改了门店费用";
			ErpFunDeptFeeRecord deptFeeRecordPO = new ErpFunDeptFeeRecord();
			deptFeeRecordPO.setShardCityId(operator.getCityId());
			deptFeeRecordPO.setCompId(operator.getCompId());
			deptFeeRecordPO.setCreationTime(new Date());
			deptFeeRecordPO.setDeptId(operator.getDeptId());
			deptFeeRecordPO.setRecordContent(content);
			deptFeeRecordPO.setRecordType((byte) 1);
			deptFeeRecordPO.setUserId(operator.getUserId());
			deptFeeRecordPO.setUserName(operator.getUserName());
			deptFeeRecordPO.setDeptFeeId(funDeptFeeDetailPO.getDeptFeeId());
			erpFunDeptFeeRecordMapper.insertSelective(deptFeeRecordPO);
		}
	}


	/**
	 * @tag 业绩提成报表
	 * @author 邓永洪
	 * @since 2018/5/10
	 */
	@ApiOperation("业绩提成报表")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = PercentProfitListVo.class, message = "成功")
	})
	@RequestMapping("/getPercentProfitList")
	public ResponseJson getPercentProfitList(@RequestBody ProfitPercentParam param) {
		Map<String,Object> result=new HashMap<>();
		String contractNo = param.getContractNo();
		Integer cityId=getOperator().getCityId();
		Integer compId=getOperator().getCompId();
		Integer serchRangeId=param.getSerchRangeId();
		String searchRange=param.getSerchRange();
		serchRangeId = "COMP".equals(param.getSerchRange()) ? getOperator().getCompId() : serchRangeId;
		param.setSerchRangeId(serchRangeId);
		param.setCompId(compId);
		param.setPerformanceColumn(buildPerformanceTypeString());
		if (StringUtils.isNotBlank(param.getShowType())){
			result.put("extra",param.getShowType());
		}
		List<ErpFunPerformanceType> perforManceTypeList=erpFunPerformanceTypeMapper.getDataListByCompId(cityId,compId);
		if ("USER".equals(searchRange)){
			ErpFunUsers funUserByUserId = erpFunUsersMapper.getFunUserByUserId(cityId, serchRangeId);
			serchRangeId = funUserByUserId.getArchiveId();
			param.setSerchRange("D.ARCHIVE_ID");
		}else {
			if ("GROUP".equals(param.getSerchRange())) {
				param.setSerchRange("D.GR_ID");
			}else {
				param.setSerchRange("D." +searchRange+ "_ID");
			}
		}
		if(StringUtil.isNotBlank(contractNo)){
			contractNo = "%" + contractNo + "%";
			param.setContractNo(contractNo);
		}
		param.setSerchRangeId(serchRangeId);
		List<Map<String, String>> profitList = new ArrayList<>();
		if(getOperator().newOrganizationType()){	//新组织架构逻辑
			GetSelectNmaesParam getSelectNmaesParam = new GetSelectNmaesParam();
			getSelectNmaesParam.setDefId(param.getDefId());
			getSelectNmaesParam.setCityId(cityId);
			getSelectNmaesParam.setCompId(compId);
			if (getSelectNmaesParam.getDefId() != null && getSelectNmaesParam.getDefId() == -2){
				getSelectNmaesParam.setSelectName("USER_ID");
			}
			String groupby  = erpFunOrganizationService.getSelectNames(getSelectNmaesParam);
			groupby = "D."+groupby.replaceAll("\\,",",D.");
			String concatStr = erpFunOrganizationService.getConcatNames(groupby);
			param.setGroupBy(groupby + concatStr);
			param.setQueryColStr(groupby);
			GetSelectWhereParam getSelectWhereParam = new GetSelectWhereParam();
			getSelectWhereParam.setOrganizationId(param.getOrganizationId());
			getSelectWhereParam.setCityId(cityId);
			getSelectWhereParam.setUserId(param.getUserId());
			getSelectWhereParam.setPrefix("D.");
			String whereStr = erpFunOrganizationService.getSelectWhere(getSelectWhereParam);
			param.setWhereStr(whereStr);

			profitList = erpFunDealMapper.getPercentProfitListNewOrg(cityId,param);
		}else{
			profitList = erpFunDealMapper.getPercentProfitList(cityId,param);
		}

		result.put("dynamicColumn",perforManceTypeList);
		result.put("profitList",profitList);
		return ErpResponseJson.ok(result);
	}


	/**
	 * @tag 构建业绩来源 行转利 列条件
	 * @author 邓永洪
	 * @since 2018/5/10
	 */
	public String[] buildPerformanceTypeString(){
		List<ErpFunPerformanceType> perforManceTypeList = erpFunPerformanceTypeMapper.getDataListByCompId(getOperator().getCityId(),getOperator().getCompId());
		Map<Integer, ErpFunPerformanceType> funPerformanceTypeMap = perforManceTypeList.stream().collect(Collectors.toMap(ErpFunPerformanceType::getPerformanceId, val -> val));
		StringBuilder sb = new StringBuilder();
		StringBuilder sbProfit = new StringBuilder();
		Iterator<Integer> funPerformanceTypeIt = funPerformanceTypeMap.keySet().iterator();
		while (funPerformanceTypeIt.hasNext()) {
			Integer tempStr = funPerformanceTypeIt.next();
			sb.append("[" + tempStr + "Count" + "],");
			sbProfit.append("[" + tempStr + "RatioCount" + "],");
		}
		return new String[]{sb.toString().replaceAll(",$", ""), sbProfit.toString().replaceAll(",$", "")};
	}

	/**
	 * 获取账务列表数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/29
	 */
	private Map<String, Object> getProcessFinancListAndMerge(PaySettlementListParam param,Integer dataType) {
		String paymentId=param.getPaymentId();
		String contractNo = param.getContractNo();
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		param.setCityId(cityId);
		param.setCompId(compId);
		List<ErpFunDealFinanceVo> dealList = null;
		param.setStartTime(param.getStartTime()+" 00:00:00");
		param.setEndTime(param.getEndTime()+" 23:59:59");
		if(param.getUserId() !=null){
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, param.getUserId());
			if(erpFunUsers !=null){
				param.setUserLevel(erpFunUsers.getUserLevel() + 2);
				param.setArchiveId(erpFunUsers.getArchiveId());
			}
		}
		
		if (param.getIsExport() != 1) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		}
		if(StringUtil.isNotBlank(contractNo)){
			contractNo = "%" + contractNo + "%";
			param.setContractNo(contractNo);
		}
		param.setIsNewOrganization(getOperator().newOrganizationType());
		dealList = erpFunDealMapper.getDealListByTableName(cityId, param);
		
		PageInfo<ErpFunDealFinanceVo> pageInfo = new PageInfo<ErpFunDealFinanceVo>(dealList);
		Map<String, Object> hm = new HashMap<>();
		hm.put("dealList", dealList);
		hm.put("total", param.getIsExport() != 1 ? Optional.ofNullable(pageInfo.getTotal()).orElse(0L).intValue() : dealList.size());
		if (dealList != null && dealList.size() > 0) {
			List<Integer> dealIds=dealList.stream().map(ErpFunDeal::getDealId).collect(Collectors.toList());
			param.setDealIds(dealIds);
			if (StringUtil.isNotBlank(paymentId)){
				if("commission".equals(paymentId)){
					List<Integer> paymentIds = erpFunFinancPaymentMapper.getPaymentIdsList(cityId, compId);
					param.setPaymentIds(paymentIds);
				}
			}
			List<ErpProcessFinanc> poList = erpProcessFinancMapper.getProcessFinancList(cityId, param);
			Map<String, ErpProcessFinanc> poMap = new HashMap<>();
			List<ErpProcessFinancDto> resultList = new LinkedList<>();
			// 不同支付类型  && 同一付款方 && 同一合同  && 同一付款方 && 同一财务款项ID 的财务合并到一条记录
			for (ErpProcessFinanc fPO : poList) {
				boolean isNeed = false;
				if (fPO.getPfActual() == 0) {
					isNeed = true;
				}
				String keyGet = (isNeed ? "1" : "0") + "_" + fPO.getPfPayer() + "_" + fPO.getDealId() + "_" + fPO.getPaymentId();
				ErpProcessFinanc poGet = poMap.get(keyGet);
				if (poGet == null) {
					String keyPut = fPO.getPfActual() + "_" + fPO.getPfPayer() + "_" + fPO.getDealId() + "_" + fPO.getPaymentId();
					poMap.put(keyPut, fPO);
				} else {// 配对成功
					ErpProcessFinanc erpProcessFinanc = isNeed ? fPO : poGet;
					ErpProcessFinancDto erpProcessFinancDto=new ErpProcessFinancDto();
					BeanUtils.copyProperties(erpProcessFinanc,erpProcessFinancDto);
					erpProcessFinancDto.setYingshouMoney(erpProcessFinanc.getPayAmount());
					erpProcessFinanc = isNeed ?  poGet : fPO;
					erpProcessFinancDto.setShishouMoney(erpProcessFinanc.getPayAmount());
					resultList.add(erpProcessFinancDto);
					poMap.remove(keyGet);
				}
			}
			// 没配对成功的也放进来
			for (ErpProcessFinanc po : poMap.values()) {
				ErpProcessFinancDto erpProcessFinancDto=new ErpProcessFinancDto();
			/*	try {
					BeanUtilsHelper.copyProperties(erpProcessFinancDto,po);
				}catch (Exception e) {
					e.printStackTrace();
				}*/
				BeanUtils.copyProperties(po,erpProcessFinancDto);
				if (po.getPfActual() == 0) {
					erpProcessFinancDto.setYingshouMoney(po.getPayAmount());
				} else {
					erpProcessFinancDto.setShishouMoney(po.getPayAmount());
				}
				resultList.add(erpProcessFinancDto);
			}
			hm.put("processfinancList", resultList);
			if (dataType==0){
				List<ErpFunProfit> erpFunProfitList = erpFunProfitMapper.getProfitListByDealIds(cityId, compId, param);
				hm.put("profitList", erpFunProfitList);
			}
		}
		return hm;
	}
}
