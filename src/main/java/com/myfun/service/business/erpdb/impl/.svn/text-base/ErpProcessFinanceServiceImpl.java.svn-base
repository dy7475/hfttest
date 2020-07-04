package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.myfun.service.business.erpdb.*;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.myfun.erpWeb.managecenter.constract.param.InsertDealInfoParam;
import com.myfun.erpWeb.managecenter.constract.param.SaveBrokerageParamAndVo;
import com.myfun.erpWeb.managecenter.transaction.param.FinaDataOfReceivableParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpFunFinancPaymentMapper;
import com.myfun.repository.erpdb.dao.ErpFunFinancStatusMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeExtMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeMapper;
import com.myfun.repository.erpdb.dao.ErpFunProfitMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpPosPaymentOrderMapper;
import com.myfun.repository.erpdb.dao.ErpProcessFinancMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.dto.ErpFunProfitDto;
import com.myfun.repository.erpdb.dto.ErpProcessFinancDto;
import com.myfun.repository.erpdb.po.ErpFunBrokerage;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunFinancPayment;
import com.myfun.repository.erpdb.po.ErpFunFinancPaymentExample;
import com.myfun.repository.erpdb.po.ErpFunFinancStatus;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExample;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExt;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExtExample;
import com.myfun.repository.erpdb.po.ErpFunProfit;
import com.myfun.repository.erpdb.po.ErpFunProfitExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.erpdb.po.ErpProcessFinancExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;


@Service
public class ErpProcessFinanceServiceImpl extends AbstractService<ErpProcessFinanc, ErpProcessFinanc> implements ErpProcessFinanceService {
	private static final Logger logger = LoggerFactory.getLogger(ErpProcessFinanceServiceImpl.class);

	@Autowired
	ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunFinancPaymentMapper erpFunFinancPaymentMapper;
	@Autowired
	ErpFunBrokerageService erpFunBrokerageService;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunDealRecordService erpFunDealRecordService;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpFunTaskService erpFunTaskService;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunProfitMapper erpFunProfitMapper;
	@Autowired
	ErpFunBillPrintService erpFunBillPrintService;
	@Autowired
	ErpFunBillMapper erpFunBillMapper;
	@Autowired
	ErpFunBillService erpFunBillService;
	@Autowired
	ErpPosPaymentOrderMapper erpPosPaymentOrderMapper;
	@Autowired
	ErpFunFinancStatusMapper erpFunFinancStatusMapper;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired
	ErpFunPerformanceTypeExtMapper erpFunPerformanceTypeExtMapper;
	@Autowired
	ErpFunBrokerageIncomeService erpFunBrokerageIncomeServie;
	@Autowired
	AdminFunCompService adminFunCompService;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;

	@Override
	public void setBaseMapper() {
		super.baseMapper = erpProcessFinancMapper;
	}

	/**
	 * @tag 根据合同成交金额和佣金计算比例生成默认的财务收付
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	@Transactional
	@Override
	public void createDefaultFinancForDeal(InsertDealInfoParam param, ErpFunDeal funDeal) {
		ErpProcessFinancExample processFinancExample = new ErpProcessFinancExample();
		processFinancExample.setShardCityId(param.getCityId());
		processFinancExample.createCriteria().andCompIdEqualTo(param.getSelfCompId()).andDealIdEqualTo(funDeal.getDealId());
		// 先清除原本的财务数据
		erpProcessFinancMapper.deleteByExample(processFinancExample);
		Integer houseUserId = funDeal.getHouseUserUid();//房源经纪人
		if (funDeal.getHousePlate() != null && Const.DIC_PLATE_TYPE_SHARE.byteValue() == funDeal.getHousePlate()) {//公盘数据将总经理作为经纪人
			houseUserId = erpFunUsersMapper.getGeneralUserByArchiveId(param.getCityId(), param.getSelfArchiveId()).getUserId();
		}
		Integer custUserId = funDeal.getCustUserUid();//客源经纪人
		if (funDeal.getCustPlate() != null && Const.DIC_PLATE_TYPE_SHARE.byteValue() == funDeal.getCustPlate()) {//公盘数据将总经理作为经纪人
			custUserId = erpFunUsersMapper.getGeneralUserByArchiveId(param.getCityId(), param.getSelfArchiveId()).getUserId();
		}
		//无房源经纪人
		if (null == houseUserId) {
			//客源经济人
			if (null == custUserId) {
				//双方都是外部合作不做任何操作
			} else {
				//无房源经纪人有客源经纪人，创建客源房的财务收付
				insertCustFinanc(param, funDeal);
			}
		} else {
			if (null == custUserId) {//有房源经纪人、无客源经纪人，创建房源方的财务收付
				insertHouseFinanc(param, funDeal);
			} else {//有房源经纪人、有客源经纪人，创建房客源房的财务收付
				insertCustFinanc(param, funDeal);
				insertHouseFinanc(param, funDeal);
			}
		}
	}

	@Transactional
	@Override
	public void finaDataReceived(List<ErpProcessFinanc> paramList, GeneralParam generalParam) {
		Integer compId=generalParam.getCompId();
		Integer cityId=generalParam.getCityId();
		Integer userId=generalParam.getUserId();
		Integer deptId=generalParam.getDeptId();
		Boolean personalVersion=generalParam.isPersonalVersion();
		String deptName=generalParam.getDeptName();
		String userName=generalParam.getUserName();
		Integer compType=generalParam.getCompType();
		if (paramList != null&&!paramList.isEmpty()) {
			ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getBaseDealInfo(cityId,paramList.get(0).getDealId());
			for (ErpProcessFinanc processFinancPO :paramList) {
				processFinancPO.setPfId(null);
				processFinancPO.setAuditStatus("0");
				processFinancPO.setCompId(compId);
				processFinancPO.setBillWay(null);
				processFinancPO.setBillCodeId(null);
				processFinancPO.setShardCityId(cityId);
				erpProcessFinancMapper.insertSelective(processFinancPO);
				String currentDeptUserName = this.getCurrUserName(compType,userName,deptName,personalVersion);
				//款项  金额 日期 备注
				String trackContent = currentDeptUserName+" 操作了收讫：  "+processFinancPO.getPfName()+" "+processFinancPO.getPayAmount()+" "+DateTimeHelper.formatDateTimetoString(processFinancPO.getPfTime(),DateTimeHelper.FMT_yyyyMMdd)+" "+(StringUtils.isBlank(processFinancPO.getPfDesc())?"":processFinancPO.getPfDesc());
				erpFunDealRecordService.writeDealRecord(generalParam,processFinancPO.getDealId(), null,
						Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACUPDATE, (byte)1, trackContent, 1,
						(byte)1, false,null);
				String taskType = Const.DIC_TASK_TYPE_CONTRACT_REMIND_STR;

				List<ErpFunUsers> taskUserList = erpFunUsersService.getTaskUserList(cityId,processFinancPO.getDealId(), 2, compId, userId);
				String taskSubJect = taskType + " " + currentDeptUserName+" 修改了编号"+funBaseInfoDealPo.getContractNo()+"的合同的财务";
//				erpFunTaskService.createDealWarmTask(funBaseInfoDealPo.getDealType(),processFinancPO.getDealId(),funBaseInfoDealPo.getContractNo(),
//						taskUserList, taskSubJect,  Const.DIC_TASK_TYPE_CONTRACT_REMIND, trackContent,
//						userId, cityId,deptId ,compId);
			}
			this.updateNeedandRealIncomeOffDeal(cityId,compId,funBaseInfoDealPo.getDealId());
		}
	}

	@Transactional
	@Override
	public String insertOrUpdateFinacList(GeneralParam generalParam,FinaDataOfReceivableParam param) {
		Integer dealId=param.getDealId();
		String jsonStr = param.getFinancJson();
		String delFinancIds = param.getDelFinancIds();//需要删除财务ids ProcessFinancDao
		Integer pfActual=param.getPfActual();

		Integer cityId=generalParam.getCityId();
		Integer compId=generalParam.getCompId();
		List<ErpProcessFinanc> hasFinancList =erpProcessFinancMapper.getHasFinancList(cityId,compId,dealId);
		Map<Integer,ErpProcessFinanc> financMap =hasFinancList.stream().collect(Collectors.toMap(ErpProcessFinanc::getPfId, val->val));
		List<ErpProcessFinanc> needCreateBillList = new ArrayList<>();
		List<String> delBillRelativeIds = new ArrayList<>();
		String[] delFinancIdArr = null;
		if (StringUtils.isNotBlank(delFinancIds)) {
			delFinancIdArr = delFinancIds.split(",");
			delBillRelativeIds.addAll(Arrays.asList(delFinancIdArr));
		}
		BigDecimal sellOwnerCommsion = new BigDecimal(0.0);
		BigDecimal buyCustomerCommsion = new BigDecimal(0.0);
		ErpFunDeal funBaseInfoDealPo = erpFunDealMapper.getBaseDealInfo(cityId,dealId);
		List<ErpProcessFinanc> list = JSON.parseArray(jsonStr, ErpProcessFinanc.class);
		BigDecimal allPayAmount = new BigDecimal(0.0);
		Integer falg  = 0;
		List<Integer> ptids = new ArrayList<Integer>();
		if(delBillRelativeIds.size() >0){
			for (String idStr : delBillRelativeIds) {
				if(StringUtil.isNotEmpty(idStr)){
					ptids.add(StringUtil.parseInteger(idStr));
				}
			}
		}
		for (ErpProcessFinanc erpProcessFinanc : list) {
			if("1".equals(erpProcessFinanc.getPfActual().toString())){
				falg = 1;
			}
			if(erpProcessFinanc.getPfId()!= null){
				ptids.add(erpProcessFinanc.getPfId());
			}
			if("2".equals(erpProcessFinanc.getPerformanceType().toString())
					||"4".equals(erpProcessFinanc.getPerformanceType().toString())){
				allPayAmount = allPayAmount.add(erpProcessFinanc.getPayAmount());
			}
		}
		
		
		 //判断是否是房基地
        if(adminFunCompService.judgerIsFangjidi(generalParam.getAdminCompId())){
        	if(falg == 0){
        		//兼容手机端【手机端每次只修改一个，要查询出剩下的】
        		
        		ErpProcessFinancExample erpProcessFinancExample = new ErpProcessFinancExample();
        		erpProcessFinancExample.setShardCityId(cityId);
        		ErpProcessFinancExample.Criteria criteria = erpProcessFinancExample.createCriteria();
        		criteria.andCompIdEqualTo(compId).andDealIdEqualTo(dealId)
        		.andPfActualEqualTo((byte)0);
        		if(ptids.size() > 0){
        			criteria.andPfIdNotIn(ptids);
        		}
        		List<ErpProcessFinanc> erpProcessFinancs = erpProcessFinancMapper.selectByExample(erpProcessFinancExample);
	        		if(erpProcessFinancs != null && erpProcessFinancs.size() > 0){
	        			for (ErpProcessFinanc erpProcessFinanc2 : erpProcessFinancs) {
	        				if("2".equals(erpProcessFinanc2.getPerformanceType().toString())
		        					||"4".equals(erpProcessFinanc2.getPerformanceType().toString())){
		        				allPayAmount = allPayAmount.add(erpProcessFinanc2.getPayAmount());
		        			}
						}
	        			
	        		}
        		
	        	if(funBaseInfoDealPo.getDealBuyStyle() !=null && "0".equals(funBaseInfoDealPo.getDealBuyStyle().toString())
	        			&&funBaseInfoDealPo.getDealSellStyle()!=null && "0".equals(funBaseInfoDealPo.getDealSellStyle().toString())){ //都是內部合作
		        	//判断佣金是否小于总共的90%
		        	if(!chackCommission(cityId,generalParam.getCompId(),funBaseInfoDealPo.getDealType(),funBaseInfoDealPo.getSellDealMoney(),funBaseInfoDealPo.getRentDealMoney(),funBaseInfoDealPo.getRentPriceUnit(), funBaseInfoDealPo.getArea(),allPayAmount,null)){
		        		throw new BusinessException("业主与客户付佣的总金额 不能低于 业主与客户付佣金额标准的90%！");
		        	}
	        	}
        	}
        }
		boolean financFlag = false;
		// 财务Id集合,移动端接口需要
		List<Integer> pfIds = new ArrayList<>();
		for (ErpProcessFinanc processFinancPO : list) {
			processFinancPO.setCompId(compId);
			Integer receiptMoneyUser = processFinancPO.getReceiptMoneyUser();
			Integer receiptMoneyDept = processFinancPO.getReceiptMoneyDept();
			if (receiptMoneyDept==null && receiptMoneyUser!=null) {
				ErpFunUsers userPo = erpFunUsersMapper.getUserInfoByUserId(cityId,receiptMoneyUser);
				if (userPo!=null) {
					processFinancPO.setReceiptMoneyDept(userPo.getDeptId());
				}
			}
			processFinancPO.setShardCityId(cityId);
			if (processFinancPO.getPfId()==null){// 主键存在时是更新记录，不存在是新增记录
				financFlag = true;
				processFinancPO.setAuditStatus("0");//默认未审核
				processFinancPO.setDealId(dealId);
				erpProcessFinancMapper.insertSelective(processFinancPO);
//				processFinancPO.setPfId(erpProcessFinancMapper.insertSelective(processFinancPO));
				System.out.println("pf_id: " + processFinancPO.getPfId());
				pfIds.add(processFinancPO.getPfId());
				//这个时候的收据方式  0电子票据 1纸质票薄 2手动录入
				if (StringUtils.isNotBlank(processFinancPO.getBillCodeNo())) {
					if (processFinancPO.getBillWay() != null && processFinancPO.getBillWay() == 0) {
						throw new BusinessException("电子票据只能在打印时生成");
					}
					needCreateBillList.add(processFinancPO);
				}
			}else {
				Integer pfId = processFinancPO.getPfId();
				if (financMap != null) {
					ErpProcessFinanc financDatafinanc = financMap.get(pfId);
					if (financDatafinanc != null) {
						String billNo = financDatafinanc.getBillCodeNo();
						if (StringUtils.isNotBlank(billNo)) {
							if (StringUtils.isBlank(processFinancPO.getBillCodeNo())) {
								delBillRelativeIds.add(StringUtil.toString(pfId));
							} else {
								if (!billNo.equals(processFinancPO.getBillCodeNo())) {
									needCreateBillList.add(processFinancPO);
									delBillRelativeIds.add(StringUtil.toString(pfId));
								}
							}
						}else {// 修改了票据号
							if (StringUtils.isNotBlank(processFinancPO.getBillCodeNo())) {
								needCreateBillList.add(processFinancPO);
							}
						}
					}else {
						if (StringUtils.isNotBlank(processFinancPO.getBillCodeNo())) {
							needCreateBillList.add(processFinancPO);
						}
					}
				}
				pfIds.add(pfId);
				processFinancPO.setPfId(pfId);
				erpProcessFinancMapper.updateByPrimaryKeySelective(processFinancPO);
			}
		}
		this.clearInvalidFinancByDealId(generalParam,dealId,delFinancIdArr, needCreateBillList,delBillRelativeIds, funBaseInfoDealPo, pfActual, financMap);//清除掉本合同无效的财务

		if (financFlag) {
			if("已结清".equals(funBaseInfoDealPo.getFinancName())){
				Map<String,Object> dealUpdateMap = new HashMap<>();
				this.createDealFinancStatus(generalParam,dealUpdateMap,"待结清");
				erpFunDealMapper.updateDealStatusByDealId(cityId, dealId,dealUpdateMap);
			}
		}
		Boolean personalVersion=generalParam.isPersonalVersion();
		String deptName = generalParam.getOrganizationName();
		String userName=generalParam.getUserName();
		Integer compType=generalParam.getCompType();
		Integer userId=generalParam.getUserId();
		Integer deptId=generalParam.getDeptId();
		String currentDeptUserName = this.getCurrUserName(compType,userName,deptName,personalVersion);
		String taskType = Const.DIC_TASK_TYPE_CONTRACT_REMIND_STR;
		List<ErpFunUsers> taskUserList = erpFunUsersService.getTaskUserList(cityId,dealId, 2, compId, userId);
		int count = erpProcessFinancMapper.countProcessFinanc(cityId,compId,pfActual,dealId,delFinancIdArr);
		if (count == 0) {
			String trackContent = currentDeptUserName + " 删除了应收财务款项";
			if (pfActual==1) {
				trackContent = currentDeptUserName + " 删除了实收财务款项";
			}
			erpFunDealRecordService.writeDealRecord(generalParam,dealId, null,
					Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACDEL, (byte)1, trackContent, 1,
					pfActual.byteValue(), true,null);
		} else {
			String trackContent = currentDeptUserName + " 更新了财务款项列表信息";
			erpFunDealRecordService.writeDealRecord(generalParam,dealId, null,
					Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSFIANACDEL, (byte)1, trackContent, 1,
					pfActual.byteValue(), true,null);
			if (pfActual==0) {
				ErpProcessFinancDto erpProcessFinancDto=erpProcessFinancMapper.getProcessFinancByDealId(cityId,compId,dealId);
				BigDecimal sellOwnerCommsionNew = erpProcessFinancDto.getSellOwnerCommsion();
				BigDecimal buyCustomerCommsionNew = erpProcessFinancDto.getBuyCustomerCommsion();
				if (sellOwnerCommsionNew.compareTo(sellOwnerCommsion) != 0
						|| buyCustomerCommsionNew.compareTo(buyCustomerCommsion) != 0) {
					trackContent = currentDeptUserName + " 修改了佣金财务款项";
					String dealContent = this.getCurrUserName(compType,userName,deptName,personalVersion) + " 创建了该合同";
					erpFunDealRecordService.writeDealRecord(generalParam,dealId, null,
							Const.DIC_DEAL_UPDATE_CLASSIC_PROCESSCOMMSIONCHANGE, (byte)0, trackContent, 1,
							null, false,null);
				}
			}
		}
		String taskSubJect = taskType + " " +currentDeptUserName+" 修改了编号"+funBaseInfoDealPo.getContractNo()+"的合同的财务";

//		erpFunTaskService.createDealWarmTask(funBaseInfoDealPo.getDealType(), dealId, funBaseInfoDealPo.getContractNo(),
//				taskUserList, taskSubJect, Const.DIC_TASK_TYPE_BARGAIN_REMIND, taskSubJect,
//				userId, cityId, deptId,compId);
		this.updateNeedandRealIncomeOffDeal(cityId,compId,dealId);

		return StringUtils.join(pfIds, ",");
	}

	/**
	 * 清除掉本合同无效的财务
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/12
	 */
	private void clearInvalidFinancByDealId(GeneralParam generalParam,Integer dealId, String[] pfIds, List<ErpProcessFinanc> processList, List<String> delBillRelativeIds, ErpFunDeal funBaseInfoDealPo, Integer pfActual, Map<Integer,ErpProcessFinanc> financMap) {
		Integer cityId=generalParam.getCityId();
		Integer compId=generalParam.getCompId();
		if (pfActual==1) {
			erpFunBillPrintService.deleteRelativeIdsByFinancIds(cityId,compId,delBillRelativeIds, financMap);
			erpFunBillService.createBill(generalParam,dealId, funBaseInfoDealPo.getContractNo(), funBaseInfoDealPo.getDealType(),null, processList, null, null, false);
		}
		//这里加一个作废关联的财务票据
		if (pfIds==null){
			return;
		}
		erpProcessFinancMapper.delProcessFinanc(cityId,compId,dealId,pfIds,pfActual);
		// 清除无效订单
		erpPosPaymentOrderMapper.updateByDealId(cityId,dealId,pfIds,3);
	}

	/**
	 * 更新应收实收数据
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/12
	 */	
	public void updateNeedandRealIncomeOffDeal(Integer cityId,Integer compId,Integer dealId) {
		ErpProcessFinancDto erpProcessFinancDto =erpProcessFinancMapper.getProcessFinancDtoByDealId(cityId,dealId);
		BigDecimal bigDecimal=new BigDecimal(0);
		Map<String,Object> dealUpdateMap=new HashMap<>();
		BigDecimal transferNeedPerformance =bigDecimal;
		BigDecimal transferRealPerformance =bigDecimal;
		BigDecimal secondhandNeedPerformance =bigDecimal;
		BigDecimal secondhandRealPerformance =bigDecimal;
		BigDecimal newHouseNeedPerformance =bigDecimal;
		BigDecimal newHouseRealPerformance =bigDecimal;
		BigDecimal leaseNeedPerformance =bigDecimal;
		BigDecimal leaseRealPerformance =bigDecimal;
		BigDecimal financeNeedPerformance =bigDecimal;
		BigDecimal financeRealPerformance =bigDecimal;

		if (erpProcessFinancDto!=null){
			transferNeedPerformance = Optional.ofNullable(erpProcessFinancDto.getTransferNeedPerformance()).orElse(bigDecimal);
			transferRealPerformance = Optional.ofNullable(erpProcessFinancDto.getTransferRealPerformance()).orElse(bigDecimal);
			secondhandNeedPerformance =Optional.ofNullable(erpProcessFinancDto.getSecondhandNeedPerformance()).orElse(bigDecimal);
			secondhandRealPerformance = Optional.ofNullable(erpProcessFinancDto.getSecondhandRealPerformance()).orElse(bigDecimal);
			newHouseNeedPerformance = Optional.ofNullable(erpProcessFinancDto.getNewhouseNeedPerformance()).orElse(bigDecimal);
			newHouseRealPerformance = Optional.ofNullable(erpProcessFinancDto.getNewhouseRealPerformance()).orElse(bigDecimal);
			leaseNeedPerformance = Optional.ofNullable(erpProcessFinancDto.getLeaseNeedPerformance()).orElse(bigDecimal);
			leaseRealPerformance = Optional.ofNullable(erpProcessFinancDto.getLeaseRealPerformance()).orElse(bigDecimal);
			financeNeedPerformance = Optional.ofNullable(erpProcessFinancDto.getFinanceNeedPerformance()).orElse(bigDecimal);
			financeRealPerformance = Optional.ofNullable(erpProcessFinancDto.getFinanceRealPerformance()).orElse(bigDecimal);

			BigDecimal totalNeedPerformance = Optional.ofNullable(erpProcessFinancDto.getTotalNeedPerformance()).orElse(bigDecimal);
			BigDecimal totalRealPerformance = Optional.ofNullable(erpProcessFinancDto.getTotalRealPerformance()).orElse(bigDecimal);
			BigDecimal totalNeedIncome = Optional.ofNullable(erpProcessFinancDto.getTotalNeedIncome()).orElse(bigDecimal);
			BigDecimal totalRealIncome = Optional.ofNullable(erpProcessFinancDto.getTotalRealIncome()).orElse(bigDecimal);

			dealUpdateMap.put("transferNeedPerformance",transferNeedPerformance);
			dealUpdateMap.put("transferRealPerformance",transferRealPerformance);
			dealUpdateMap.put("secondhandNeedPerformance",secondhandNeedPerformance);
			dealUpdateMap.put("secondhandRealPerformance",secondhandRealPerformance);
			dealUpdateMap.put("newhouseNeedPerformance",newHouseNeedPerformance);
			dealUpdateMap.put("newhouseRealPerformance",newHouseRealPerformance);
			dealUpdateMap.put("leaseNeedPerformance",leaseNeedPerformance);
			dealUpdateMap.put("leaseRealPerformance",leaseRealPerformance);
			dealUpdateMap.put("financeNeedPerformance",financeNeedPerformance);
			dealUpdateMap.put("financeRealPerformance",financeRealPerformance);
			dealUpdateMap.put("totalNeedPerformance",totalNeedPerformance);
			dealUpdateMap.put("totalRealPerformance",totalRealPerformance);
			dealUpdateMap.put("totalNeedIncome",totalNeedIncome);
			dealUpdateMap.put("totalRealIncome",totalRealIncome);
		}else {
			dealUpdateMap.put("transferNeedPerformance",bigDecimal);
			dealUpdateMap.put("transferRealPerformance",bigDecimal);
			dealUpdateMap.put("secondhandNeedPerformance",bigDecimal);
			dealUpdateMap.put("secondhandRealPerformance",bigDecimal);
			dealUpdateMap.put("newhouseNeedPerformance",bigDecimal);
			dealUpdateMap.put("newhouseRealPerformance",bigDecimal);
			dealUpdateMap.put("leaseNeedPerformance",bigDecimal);
			dealUpdateMap.put("leaseRealPerformance",bigDecimal);
			dealUpdateMap.put("financeNeedPerformance",bigDecimal);
			dealUpdateMap.put("financeRealPerformance",bigDecimal);
			dealUpdateMap.put("totalNeedPerformance",bigDecimal);
			dealUpdateMap.put("totalRealPerformance",bigDecimal);
			dealUpdateMap.put("totalNeedIncome",bigDecimal);
			dealUpdateMap.put("totalRealIncome",bigDecimal);
		}
		/***更新合同表所有类型应收实收数据***/
		erpFunDealMapper.updateDealStatusByDealId(cityId,dealId,dealUpdateMap);
		
		/***判断是否玛雅房基地定制***/
		byte maYaModel = 0;
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		if(null != erpFunComp){
			if(null != erpFunComp.getCompNo()){
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
				if(null != adminFunComp){
					if(adminFunComp.getCompManagementModel() == 2 && adminFunComp.getCustomizedType() == 1){
						maYaModel = 1;
					}
				}
			}
		}

		/**控制员工业绩分佣比例显示规则参数 0 = 按照总业绩计算显示比例 1 = 按照扣除公司业绩的部分计算显示比例**/
		String paramValue = erpSysParaMapper.getParamValue(cityId,compId,"PROFIT_PERCENT_RULE");
		if(maYaModel == 1) {
			paramValue = "2";	//玛雅房基地模式
		}
		this.createUpdatePerformanceSqlBySysPara(cityId,paramValue, dealId, transferRealPerformance, transferNeedPerformance, "1", compId);
		this.createUpdatePerformanceSqlBySysPara(cityId,paramValue, dealId, secondhandRealPerformance  , secondhandNeedPerformance, "2", compId);
		this.createUpdatePerformanceSqlBySysPara(cityId,paramValue, dealId, newHouseRealPerformance, newHouseNeedPerformance, "3", compId);
		this.createUpdatePerformanceSqlBySysPara(cityId,paramValue, dealId, leaseRealPerformance, leaseNeedPerformance, "4", compId);
		this.createUpdatePerformanceSqlBySysPara(cityId,paramValue, dealId, financeRealPerformance,financeNeedPerformance, "5", compId);

	}

	/**
	 * 
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/12
	 * @realPerformance 实收总额
	 * @needPerformance	应收总额
	 * @performanceType	业绩类别 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 业绩类别
	 * @BY XIONG CAI 2019-09-04
	 */	
	private void createUpdatePerformanceSqlBySysPara(Integer cityId,String paramValue,Integer dealId,BigDecimal realPerformance,BigDecimal needPerformance,String performanceType, Integer compId) {
		if("0".equals(paramValue)){
			erpFunProfitMapper.updatePerformanceBySysPara(cityId,dealId,realPerformance,needPerformance,performanceType,paramValue);
		}else if("1".equals(paramValue)){
			ErpFunProfitDto erpFunProfitDto =erpFunProfitMapper.getPerformanceDto(cityId,dealId,realPerformance,needPerformance,performanceType);
			BigDecimal realcompProfitMoney = BigDecimal.ZERO;
			BigDecimal needcompReceivableMoney = BigDecimal.ZERO;
			if (erpFunProfitDto != null){
				realcompProfitMoney=erpFunProfitDto.getRealcompProfitMoney();
				needcompReceivableMoney=erpFunProfitDto.getNeedcompReceivableMoney();
			}
			erpFunProfitMapper.updatePerformance(cityId,dealId,realPerformance,needPerformance,realcompProfitMoney,needcompReceivableMoney,performanceType);
			erpFunProfitMapper.updatePerformanceBySysPara(cityId,dealId,realPerformance,needPerformance,performanceType,paramValue);
		}else if("2".equals(paramValue)){	//玛雅房基地模式，如果后期新增其他业绩类别的财务款项，那么需要新增该类型的业绩
			if(needPerformance.doubleValue() > 0 || realPerformance.doubleValue() > 0) {
				//1.获取公司平台扣除比例（从已有的公司平台业绩记录中获取比例，如果直接从系统参数中获取，可能会导致前后公司扣除比例不一致）
				ErpFunProfitExample profitExample = new ErpFunProfitExample();
				profitExample.setShardCityId(cityId);
				profitExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andProfitTypeEqualTo((byte) 1);
				List<ErpFunProfit> erpFunProfits = erpFunProfitMapper.selectByExample(profitExample);
				BigDecimal compProfitProportion = BigDecimal.ZERO;
				if(null != erpFunProfits && erpFunProfits.size() > 0) {
					compProfitProportion = erpFunProfits.get(0).getProfitProportion();
				}
				//2.判断当前业绩类别是否有业绩记录，且应收金额大于0
				ErpFunProfitExample typeProfitExample = new ErpFunProfitExample();
				typeProfitExample.setShardCityId(cityId);
				typeProfitExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andPerformanceTypeEqualTo(StringUtil.parseByte(performanceType));
				int hasProfitRecord = erpFunProfitMapper.countByExample(typeProfitExample);
				if(hasProfitRecord == 0) {
					//3.获取该业绩类别下所有类别数据的分佣比例以及分佣扩展配置数据
					ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
					erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo((byte) 0).andCollectionTypeEqualTo(StringUtil.parseByte(performanceType)).andConfigAbleEqualTo((byte) 1);
					erpFunPerformanceTypeExample.setShardCityId(cityId);
					List<ErpFunPerformanceType> erpFunPerformanceTypes = erpFunPerformanceTypeMapper.selectByExample(erpFunPerformanceTypeExample);
					
					ErpFunPerformanceTypeExtExample erpFunPerformanceTypeExtExample = new ErpFunPerformanceTypeExtExample();
					erpFunPerformanceTypeExtExample.createCriteria().andIdDelEqualTo((byte) 0).andCompIdEqualTo(compId).andExtTypeIsNotNull();
					erpFunPerformanceTypeExtExample.setShardCityId(cityId);
					List<ErpFunPerformanceTypeExt> erpFunPerformanceTypeExts = erpFunPerformanceTypeExtMapper.selectByExample(erpFunPerformanceTypeExtExample);
					//Map<Integer, ErpFunPerformanceTypeExt> performanceExtMap = erpFunPerformanceTypeExts.stream().collect(Collectors.toMap(ErpFunPerformanceTypeExt::getPerformanceId, ErpFunPerformanceTypeExt->ErpFunPerformanceTypeExt));
					
					//4.根据配置以及扩展配置，计算出所有类别项目的最终分佣比例
//					if(!erpFunPerformanceTypeExts.isEmpty()) {
//						for (ErpFunPerformanceType erpFunPerformanceType : erpFunPerformanceTypes) {
//							for (ErpFunPerformanceTypeExt erpFunPerformanceTypeExt : erpFunPerformanceTypeExts) {
//								if(null != erpFunPerformanceTypeExt) {
//									if(erpFunPerformanceTypeExt.getExtType() == 1 && null != erpFunPerformanceTypeExt.getTargetPerformanceId()) {
//										if(erpFunPerformanceTypeExt.getTargetPerformanceId().equals(erpFunPerformanceType.getPerformanceId())) {
//											for (ErpFunPerformanceType targetPerformanceType : erpFunPerformanceTypes) {
//												if(null != targetPerformanceType.getPerformanceId() && erpFunPerformanceTypeExt.getTargetPerformanceId().equals(targetPerformanceType.getPerformanceId())) {
//													targetPerformanceType.setPerformanceProportion(targetPerformanceType.getPerformanceProportion().add(erpFunPerformanceType.getPerformanceProportion()));
//												}
//											}
//											if(null == erpFunPerformanceType.getPerformanceProportion()) {
//												erpFunPerformanceType.setPerformanceProportion(BigDecimal.ZERO);
//											}
//										}
//									}else if(erpFunPerformanceTypeExt.getExtType() == 2 && null != erpFunPerformanceTypeExt.getPerformanceProportion()) {
//										if(null == erpFunPerformanceType.getPerformanceProportion()) {
//											erpFunPerformanceType.setPerformanceProportion(BigDecimal.ZERO);
//										}else {
//											erpFunPerformanceType.setPerformanceProportion(erpFunPerformanceType.getPerformanceProportion().subtract(erpFunPerformanceTypeExt.getPerformanceProportion()));
//										}
//									}
//								}
//							}
//						}
//					}
					
					if(erpFunPerformanceTypes.size() > 0) {
						//6.首先插入业绩信息（插入，compId,dealId,PROFIT_PROPORTION,DEAL_TYPE,PERFORMANCE_ID,PERFORMANCE_NAME,PROFIT_TYPE,PERFORMANCE_TYPE）
						for (ErpFunPerformanceType erpFunPerformanceType : erpFunPerformanceTypes) {
							this.addFinanceProfit(erpFunPerformanceType,compId, dealId,cityId, (byte) 2);
						}
						
						//7.插入公司业绩信息
						ErpFunPerformanceType compPerformanceType = new ErpFunPerformanceType();
						compPerformanceType.setPerformanceProportion(compProfitProportion);
						compPerformanceType.setPerformanceName("公司平台收费");
						compPerformanceType.setCollectionType(StringUtil.parseByte(performanceType));
						this.addFinanceProfit(compPerformanceType,compId, dealId,cityId, (byte) 1);
					}
				}
				//5.根据公司平台扣除比例，计算出该业绩类别需要扣除的公司平台费用
				BigDecimal compNeedProfitMoney = needPerformance.multiply(compProfitProportion).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
				BigDecimal compRealProfitMoney = realPerformance.multiply(compProfitProportion).divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
				
				ErpFunProfit erpCompFunProfit = new ErpFunProfit();
				erpCompFunProfit.setReceivableMoney(compNeedProfitMoney);
				erpCompFunProfit.setProfitMoney(compRealProfitMoney);
				ErpFunProfitExample compExample = new ErpFunProfitExample();
 				compExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(dealId).andProfitTypeEqualTo((byte) 1);
				compExample.setShardCityId(cityId);
				//更新公司业绩明细表
				erpFunProfitMapper.updateByExampleSelective(erpCompFunProfit, compExample);
				//8.更新所有该业绩类别的业绩信息
				erpFunProfitMapper.updateHouseBasePerformanceBySysPara(cityId,dealId,realPerformance.subtract(compRealProfitMoney),needPerformance.subtract(compNeedProfitMoney),performanceType,paramValue);
			}
		}
	}



	private void addFinanceProfit(ErpFunPerformanceType erpFunPerformanceType, Integer compId, Integer dealId, Integer cityId, Byte profitType) {
		ErpFunDeal erpFunDeal = erpFunDealMapper.getFunDealById(cityId, compId, dealId);
		ErpFunProfit insertModel = new ErpFunProfit();
		if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(erpFunDeal.getDealType().intValue())) {
			insertModel.setPerformanceType((byte) 2);//二手佣金
		} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(erpFunDeal.getDealType().intValue())) {
			insertModel.setPerformanceType((byte) 4);//租赁佣金
		}
		insertModel.setCompId(compId);
		insertModel.setDiscount(new BigDecimal(100));//默认折扣比例100%
		insertModel.setDealId(erpFunDeal.getDealId());
		insertModel.setAgreementNo(erpFunDeal.getAgreementNo());
		insertModel.setProfitProportion(erpFunPerformanceType.getPerformanceProportion());
		insertModel.setReceivableMoney(BigDecimal.ZERO);
		insertModel.setProfitMoney(BigDecimal.ZERO);
		
		insertModel.setSettleFlag(Const.SETTLE_FLAG_NOCHECK);
		insertModel.setDealType(erpFunDeal.getDealType());
		insertModel.setCreateDate(new Date());
		insertModel.setPerformanceName(erpFunPerformanceType.getPerformanceName());
		insertModel.setPerformanceId(erpFunPerformanceType.getPerformanceId());
		insertModel.setPerformanceType(erpFunPerformanceType.getCollectionType());
		insertModel.setShardCityId(cityId);
		insertModel.setProfitType(profitType);
		erpFunProfitMapper.insertSelective(insertModel);
	}

		/**
		 * 通用的获取部门加用户名的方法
		 * @param
		 * @return
		 * @auther 胡坤
		 * @since 2018/7/11
		 */
	private String getCurrUserName(Integer compType, String userName, String deptName, Boolean personalVersion) {
		// 不是纯精英版也不是专业版 才写门店名称
		if (!Constants_DIC.DIC_COMP_TYPE_2.equals(compType) && !personalVersion) {
			userName = deptName + " " + userName;
		}
		return userName;
	}

	/**
	 * 参数设置
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/11
	 */
	private void createDealFinancStatus(GeneralParam generalParam,Map<String,Object> dealUpdateMap, String type) {
		ErpFunFinancStatus erpFunFinancStatus =erpFunFinancStatusMapper.getFunFinancStatus(generalParam.getCityId(),generalParam.getCompId(),type);
		if(erpFunFinancStatus!=null){
			dealUpdateMap.put("financStatusId",erpFunFinancStatus.getFinancStatusId());
			dealUpdateMap.put("financName",type);
		}
	}

	/**
	 * @tag 创建房源方的应收财务
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	public BigDecimal insertHouseFinanc(InsertDealInfoParam param, ErpFunDeal funDeal) {
		Integer cityId=param.getCityId();
		Integer compId=param.getSelfCompId();
		ErpProcessFinanc insertModel = new ErpProcessFinanc();
		Integer dealType = funDeal.getDealType().intValue();
		if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)){
			insertModel.setPfName("佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("佣金",cityId,compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
		}else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)){
			insertModel.setPfName("租赁佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("租赁佣金", cityId, compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
		}
		insertModel.setCompId(param.getSelfCompId());
		insertModel.setDealId(funDeal.getDealId());
		insertModel.setIsProfit((byte)1);
		insertModel.setPfActual((byte)0);
		//单门店直接审核
		if(param.getDeptType() != null && param.getDeptType() == 6) {
			insertModel.setAuditStatus("1");
		} else {
			insertModel.setAuditStatus("0");
		}

		insertModel.setPfPayer(Const.DIC_PFMAN_SELL);
		insertModel.setPfGeter(Const.DIC_PFMAN_BROKER);
		BigDecimal amount = getPayAmount(cityId,compId,funDeal,"HOUSE_USER");
		insertModel.setPayAmount(amount);
		insertModel.setPfTime(new Date());
		insertModel.setDiscount(new BigDecimal(100));
		if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(funDeal.getDealType().intValue())){
			insertModel.setPerformanceType((byte)2);//二手佣金
		}else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(funDeal.getDealType().intValue())){
			insertModel.setPerformanceType((byte)4);//租赁佣金
		}
		insertModel.setShardCityId(cityId);
		erpProcessFinancMapper.insertSelective(insertModel);

		//如果是单门店版，直接创建实收
		if (param.getDeptType() != null && param.getDeptType() == 6) {
			insertModel.setPfId(null);
			insertModel.setShardCityId(cityId);
			insertModel.setAuditStatus("1");
			insertModel.setPfActual((byte)1);
			erpProcessFinancMapper.insertSelective(insertModel);
			this.updateNeedandRealIncomeOffDeal(cityId,compId,funDeal.getDealId());
		}

		return amount;
	}

	/**
	 * @tag 获取应收取的佣金
	 * @author 邓永洪
	 * @since 2018/5/31
	 */
	private BigDecimal getPayAmount(Integer cityId, Integer compId, ErpFunDeal funDeal, String caseType) {
		BigDecimal result=new BigDecimal(0);
		ErpFunBrokerage brokerage = erpFunBrokerageService.getBrokerageByCompId(cityId,compId, funDeal.getDealType());
		if(null != brokerage) {
			BigDecimal brokerageRate = brokerage.getBrokerageRate();
            if(Const.DIC_BROKERAGE_TYPE_RATE.equals(brokerage.getBrokerageCountType())){
//                brokerageRate=new BigDecimal(brokerageRate.doubleValue()/100);
                funDeal.setCommissionRate(brokerageRate);
            }else{
                funDeal.setCommissionRate(new BigDecimal(brokerageRate.doubleValue()*100));
            }
		}else {
            funDeal.setCommissionRate(BigDecimal.ZERO);
        }

		BigDecimal sellOwnerCommsion = funDeal.getSellOwnerCommsion();
		BigDecimal buyCustomerCommsion =funDeal.getBuyCustomerCommsion();
		// TODO getOperator().setAttribute("COMMISSION_RECEIVABLE", totalMoneyStr);
		BigDecimal totalMoney=sellOwnerCommsion.add(buyCustomerCommsion);
		String StandardCommission =new DecimalFormat("0.##").format(totalMoney);
		funDeal.setStandardCommission(new BigDecimal(StandardCommission));
		if("HOUSE_USER".equals(caseType)){
			result = sellOwnerCommsion;
//			logger.info("卖方付佣: " + sellOwnerCommsion+" = " + result);
		}else if("CUST_USER".equals(caseType)){
			 result = buyCustomerCommsion;
//			logger.info("买方付佣: " + buyCustomerCommsion + " = " + result);
		}
		funDeal.setTotalNeedIncome(totalMoney);
		funDeal.setTotalNeedPerformance(totalMoney);
		funDeal.setSecondhandNeedPerformance(funDeal.getTotalNeedIncome());
		funDeal.setSecondhandRealPerformance(funDeal.getTotalRealIncome());
		return result;
	}

	private ErpFunFinancPayment getDefaultProcessFinanc(String name, Integer cityId, Integer compId) {
		ErpFunFinancPaymentExample funFinancPaymentExample = new ErpFunFinancPaymentExample();
		funFinancPaymentExample.setShardCityId(cityId);
		funFinancPaymentExample.createCriteria().andCompIdEqualTo(compId).andCanDelEqualTo(0).andPaymentNameEqualTo(name);
		List<ErpFunFinancPayment> erpFunFinancPayments = erpFunFinancPaymentMapper.selectByExample(funFinancPaymentExample);
		if(erpFunFinancPayments.size() > 0) {
			return erpFunFinancPayments.get(0);
		}
		return null;
	}

	/**
	 * @tag 创建客源方的应收财务
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	private BigDecimal insertCustFinanc(InsertDealInfoParam param, ErpFunDeal funDeal) {
		Integer cityId=param.getCityId();
		Integer compId=param.getSelfCompId();
		ErpProcessFinanc insertModel = new ErpProcessFinanc();
		Integer dealType = funDeal.getDealType().intValue();
		if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealType)){
			insertModel.setPfName("佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("佣金",cityId,compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
		}else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealType)){
			insertModel.setPfName("租赁佣金");
			ErpFunFinancPayment erpFunFinancPayment = getDefaultProcessFinanc("租赁佣金",cityId,compId);
			if(null != erpFunFinancPayment) {
				insertModel.setPaymentId(erpFunFinancPayment.getPaymentId());
				insertModel.setPfGeter(erpFunFinancPayment.getBeneficiary() + "");
			}
		}
		insertModel.setCompId(param.getSelfCompId());
		insertModel.setDealId(funDeal.getDealId());
		insertModel.setIsProfit((byte)1);
		insertModel.setPfActual((byte)0);
		if (param.getDeptType() != null && param.getDeptType() == 6){
			insertModel.setAuditStatus("1");
		} else {
			insertModel.setAuditStatus("0");
		}
		insertModel.setPfPayer(Const.DIC_PFMAN_BUY);
		// 收款方
		insertModel.setPfGeter(Const.DIC_PFMAN_BROKER);
		BigDecimal amount = getPayAmount(cityId,compId,funDeal,"CUST_USER");
		insertModel.setPayAmount(amount);
		insertModel.setPfTime(new Date());
		insertModel.setDiscount(new BigDecimal(100));
		if(Const.DIC_CASE_TYPE_SALE_DEAL.equals(funDeal.getDealType().intValue())){
			insertModel.setPerformanceType((byte)2);//二手佣金
		}else if(Const.DIC_CASE_TYPE_RENT_DEAL.equals(funDeal.getDealType().intValue())){
			insertModel.setPerformanceType((byte)4);//租赁佣金
		}
		insertModel.setShardCityId(cityId);
		erpProcessFinancMapper.insertSelective(insertModel);

		//如果是单门店版，直接创建实收
		if (param.getDeptType() != null && param.getDeptType() == 6) {
			insertModel.setPfId(null);
			insertModel.setShardCityId(cityId);
			insertModel.setAuditStatus("1");
			insertModel.setPfActual((byte)1);
			erpProcessFinancMapper.insertSelective(insertModel);
			this.updateNeedandRealIncomeOffDeal(cityId,compId,funDeal.getDealId());
		}

		return amount;
	}

	
	public Boolean chackCommission(Integer cityId, Integer compId,Byte dealType, BigDecimal sellDealMoney, BigDecimal rentDealMoney, Byte rentPriceUnit,BigDecimal area,
			BigDecimal sellOwnerCommsion, BigDecimal buyCustomerCommsion) {
    	
    	 SaveBrokerageParamAndVo resultVo = new SaveBrokerageParamAndVo();
         resultVo = erpFunBrokerageIncomeServie.getBrokerageByComp(cityId,compId);	
         if(resultVo == null){
        	 return true;
         }
         BigDecimal totalMoney = BigDecimal.ZERO; 
         if("101".equals(dealType.toString())){ //出售
        	 totalMoney = sellDealMoney;
        	 ErpFunBrokerage saleBrokerage = resultVo.getSaleBrokerage();
        	 if(saleBrokerage !=null && saleBrokerage.getBrokerageRate() !=null){//存在佣金比例
        		 totalMoney = totalMoney.multiply(saleBrokerage.getBrokerageRate()).divide(new BigDecimal(100));
        	 }else{
        		 totalMoney = BigDecimal.ZERO; 
        	 }
        	 
         }else if("102".equals(dealType.toString())){ //出租
        	 if("1".equals(rentPriceUnit.toString())){ //单位 元/月
        		 totalMoney = rentDealMoney;
        	 }else if("2".equals(rentPriceUnit.toString())){ //元/天
        		 totalMoney = rentDealMoney.multiply(new BigDecimal(30));
        	 }else if("3".equals(rentPriceUnit.toString())){ //	元/平米*月
        		 totalMoney = rentDealMoney.multiply(area);
        	 }else if("4".equals(rentPriceUnit.toString())){ //	元/平米*天
        		 totalMoney = rentDealMoney.multiply(new BigDecimal(30)).multiply(area);
        	 }else if("5".equals(rentPriceUnit.toString())){ //	元/年
        		 totalMoney = rentDealMoney.divide(new BigDecimal(12)).setScale(2, BigDecimal.ROUND_HALF_UP);
        	 }
        	 ErpFunBrokerage leaseBrokerage = resultVo.getLeaseBrokerage();
        	 if(leaseBrokerage != null && leaseBrokerage.getBrokerageRate() !=null){
        		//存在佣金比例
        		 totalMoney = totalMoney.multiply(leaseBrokerage.getBrokerageRate());
        	 }else{
        		 totalMoney = BigDecimal.ZERO; 
        	 }
         }
         
         
        BigDecimal allCommission = BigDecimal.ZERO; 
        if(sellOwnerCommsion != null){
        	allCommission = allCommission.add(sellOwnerCommsion);
        }
        if(buyCustomerCommsion != null){
        	allCommission = allCommission.add(buyCustomerCommsion);
        }
        Double data = totalMoney.multiply(new BigDecimal(0.9)).doubleValue();
        Double data1 = allCommission.doubleValue();
        if(totalMoney.multiply(new BigDecimal(0.9)).doubleValue() > allCommission.doubleValue()){
        	return false;
        } 
         
        return true;
	}
}
