package com.myfun.erpWeb.managecenter.billManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.myfun.erpWeb.managecenter.transaction.param.BillPhotoParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.param.QueryPrintBuillInfoParam;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunBillCodeService;
import com.myfun.service.business.erpdb.ErpFunBillService;

/**
 * 管理中心-票据管理模块
 * @author flj
 * @2017-12-11
 */
@RestController
@RequestMapping("/managerCenter/funBillModule")
public class FunBillController extends BaseController{

	@Autowired ErpFunBillMapper erpFunBillMapper;
	@Autowired ErpFunBillService erpFunBillService;
	@Autowired ErpFunBillPrintMapper erpFunBillPrintMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpProcessFinancMapper erpProcessFinancMapper;
	@Autowired ErpFunDealMapper erpFunDealMapper;
	@Autowired ErpFunDealRecordMapper erpFunDealRecordMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunEarbestMoneyrecordMapper erpFunEarbestMoneyrecordMapper;
	@Autowired ErpFunBillCodeService erpFunBillCodeService;
	@Autowired
	ErpFunBillCodelogMapper erpFunBillCodelogMapper;

	 /**
     * 查询票据明细列表
     * @author flj
     * @Date 2017-12-13
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectFunBillList")
    public ResponseJson selectFunBillList(@Valid @RequestBody BaseMapParam param) {
    	Operator operator = getOperator();
    	Integer cityId = operator.getCityId();
    	Integer compId = operator.getCompId();
		param.setInteger("compId", compId);
//    	Integer deptId = param.getInteger("deptId");//门店id
//    	Integer userId = param.getInteger("userId");//员工id
//    	Integer grId = param.getInteger("grId");// 分组ID
//    	Integer billType = param.getInteger("billType");//票据类型 0 诚意金 1 出售合同 2 出租合同
//    	Integer billStatus = param.getInteger("billStatus");//0未确认 1确认 2作废
//    	Integer billWay = param.getInteger("billWay");//出票方式  0电子票据 1纸质票薄 2手动录入
//    	String startTime = param.getString("startTime");//开始时间
//    	String endTime = param.getString("endTime");//结束时间
//    	String intelligentSearch = param.getString("intelligentSearch");//智能检索，包含付款人，合同号，票据检索
//    	ErpFunBillExample example = new ErpFunBillExample();
//    	example.setShardCityId(cityId);
//    	Criteria criteria = example.createCriteria();
//    	criteria.andCompIdEqualTo(compId);
//    	if (deptId!=null) {
//    		criteria.andReceiptMoneyDeptEqualTo(deptId);
//    	}
//    	if (userId!=null) {
//    		criteria.andReceiptMoneyUserEqualTo(userId);
//    	}
//    	if (billType!=null) {
//    		criteria.andBillTypeEqualTo(billType.byteValue());
//    	}
//    	if (billStatus!=null) {
//    		criteria.andBillStatusEqualTo(billStatus.byteValue());
//    	}
//    	if (billWay!=null) {
//    		criteria.andBillWayEqualTo(billWay.byteValue());
//    	}
//    	if (StringUtils.isNotBlank(intelligentSearch)) {
//    		criteria.andIntelligentSearchLike("%"+ intelligentSearch +"%");
//    	}
//    	criteria.andReceiptTimeBetween(DateTimeHelper.parseToDate(startTime), DateTimeHelper.parseToDate(endTime + " 23:59:59"));
    	PageHelper.startPage(param.getPageOffset(), param.getPageRows(), "CREATION_TIME desc");
//    	List<ErpFunBill> billList = erpFunBillMapper.selectByExample(example);
    	param.setString("isNewOrganization", getOperator().newOrganizationType() ? "1" : "0");
		List<ErpFunBill> billList = erpFunBillMapper.getBillList(cityId, param.getMap());
    	billList.forEach(bill->{
    		String photoAddrStr = bill.getBillPhoto();
			bill.setBillPhoto(CommonUtil.getHousePhoto(photoAddrStr));
    	});
    	PageInfo<ErpFunBill> pageInfo = new PageInfo<>(billList);
    	return ErpResponseJson.ok(pageInfo);
    }
    
    /**
	 * 票据打印预览
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getPrintContentInfo")
	public ResponseJson getPrintContentInfo(@Valid @RequestBody QueryPrintBuillInfoParam param) {
		Byte billWay = param.getBillWay();//获取取票方式 出票方式  0电子票据 1纸质票薄 2手动录入
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		Integer dealId = param.getDealId();
		Integer deptId = param.getDeptId();
		ErpFunDeal dealBaseInfo = null;
		ErpFunBillCodelog erpFunBillCodelog = null;
		Byte billType = Byte.valueOf("0");
		if (dealId!=null) {
			dealBaseInfo = erpFunDealMapper.selectByDealId(cityId, dealId, null);
			if (Const.DIC_CASE_TYPE_SALE_DEAL.equals(dealBaseInfo.getDealType().intValue())) {
				billType = Byte.valueOf("1");
			} else if (Const.DIC_CASE_TYPE_RENT_DEAL.equals(dealBaseInfo.getDealType().intValue())) {
				billType = Byte.valueOf("2");
			}
		}
		String earBestMoneyIds = param.getEarBestMoneyIds();
		String financIds = param.getFinancIds();
		String[] financIdArr = null;
		String[] earBestIdArr = null;
		if (StringUtils.isNotBlank(earBestMoneyIds)|| StringUtils.isNotBlank(param.getDepositIds())) {
			List<Map<String, Object>> printContent = getPrintInfo(param, cityId, compId, earBestMoneyIds, param.getDepositIds());
			//诚意金及定金不用再关系其他逻辑
			return ErpResponseJson.ok(printContent);
		} else if (StringUtils.isNotBlank(financIds)) {
			financIdArr = financIds.split(",");
		}
		String billPrintWay = erpSysParaMapper.getParamValue(cityId, compId, "BILL_PRINT_WAY");
		List<Map<String,Object>> printContent = erpFunBillMapper.selectPrintContentInfo(cityId, compId, financIdArr , earBestIdArr ,null,param.getPrintType(),billPrintWay);
		//0没有打印过 1是打印过的
		if (Byte.valueOf("0").equals(param.getPrintType())) {
			if (Byte.valueOf("0").equals(billWay) && (dealId!=null)) {
				erpFunBillCodelog = erpFunBillCodelogMapper.getOneBillCodeLog(cityId, compId, deptId, billType, billWay);
			}
		} 
		for (Map<String,Object> printMap:printContent) {
			printMap.put("billType", billType);
			if (erpFunBillCodelog!=null) {
				Integer codeId = erpFunBillCodelog.getCodeId();
				String billNo = erpFunBillCodelog.getCodeNo();
				if (codeId!=null) {
					printMap.put("billCodeId", codeId);
					printMap.put("billNo", billNo);
				}
			}
			if (dealId != null) {
				//没有合同编号
				String contractNo = dealBaseInfo.getContractNo();
				String buyIdCard = dealBaseInfo.getBuyIdCard();
				String sellIdCard = dealBaseInfo.getSellIdCard();
				String buyOwnerName = dealBaseInfo.getBuyOwnerName();
				String sellOwnerName = dealBaseInfo.getSellOwnerName();
				String sellAddress = dealBaseInfo.getSellAddress();
				String pfPayer = printMap.get("pfPayer").toString();
				printMap.put("contractNo", contractNo);
				printMap.put("dealType", dealBaseInfo.getDealType());
				printMap.put("sellAddress", sellAddress);	//产权地址
				printMap.put("sellName", sellOwnerName);	//卖方业主姓名
				printMap.put("buyName", buyOwnerName);		//卖方业主姓名
				if ("1".equals(pfPayer)) {
					printMap.put("custIdcard", buyIdCard);
					printMap.put("payCustomer", buyOwnerName);
				} else {
					printMap.put("custIdcard", sellIdCard);
					printMap.put("payCustomer", sellOwnerName);
				}
			}
		}
		return ErpResponseJson.ok(printContent);
	}

	/**
	 * 诚意金及定金打印
	 * @param param
	 * @param cityId
	 * @param compId
	 * @param earBestMoneyIds
	 * @param depositIds
	 * @return
	 */
	private List<Map<String, Object>> getPrintInfo( QueryPrintBuillInfoParam param, Integer cityId, Integer compId, String earBestMoneyIds,String depositIds) {

		String[] depositIdArr = null;
		String[] earBestIdArr = null;
		if (null != earBestMoneyIds) {
			earBestIdArr = earBestMoneyIds.replaceAll("\\s","").split(",");
		}else{
			depositIdArr = depositIds.replaceAll("\\s",",").split(",");
		}
		String billPrintWay = erpSysParaMapper.getParamValue(cityId, compId, "BILL_PRINT_WAY");
		List<Map<String,Object>> printContent = erpFunBillMapper.selectPrintContentInfo(cityId, compId, null , earBestIdArr , depositIdArr,param.getPrintType(),billPrintWay);
		Set<Integer> ids = printContent.stream().map(map -> map.get("printCountUser")).filter(Objects::nonNull).map(Object::toString).map(Integer::parseInt).collect(Collectors.toSet());
        List<ErpFunUsers> list = Collections.emptyList();
        if (!ids.isEmpty()) {
            list = erpFunUsersMapper.getUserListByUserIds(cityId, ids);
        }
		Map<Integer, String> userMap = list.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, ErpFunUsers::getUserName, (e1, e2) -> e2));
		printContent.forEach(map->{
			map.put("lastPrintUserName", userMap.get(map.get("printCountUser")));
			Object propertyAddress = map.get("propertyAddress");
			if (Objects.isNull(propertyAddress)) {
				map.put("propertyAddress", map.get("buildName"));
			}
		});
		return printContent;
	}
	
	 /**
	 * 票据打印
	 * @author flj
	 * @Date 2017-12-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/printBill")
	public ResponseJson printBill(@Valid @RequestBody QueryPrintBuillInfoParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer areaId = operator.getAreaId();
		Integer regId = operator.getRegId();
		Integer deptId = operator.getDeptId();
		Integer grId = operator.getGrId();
		Integer userId = operator.getUserId();
		String userName = operator.getUserName();
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setAreaId(areaId);
		param.setRegId(regId);
		param.setDeptId(deptId);
		param.setGrId(grId);
		param.setUserId(userId);
		param.setUserName(userName);
		erpFunBillService.printBill(param);
		return ErpResponseJson.ok();
	}

	/**
	 * 票据打印
	 * @author flj
	 * @Date 2017-12-11
	 * @return
	 */
	@RequestMapping("/saveBillPhoto")
	public ResponseJson saveBillPhoto(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer deptId = operator.getDeptId();
		Integer userId = operator.getUserId();
		String userName = operator.getUserName();
		Integer earbestId = param.getInteger("earbestId");
		Integer financId = param.getInteger("financId");
		Integer depositId = param.getInteger("depositId");
		String photoUrl = param.getString("photoUrl");
		String billNo = param.getString("billNo");
		Integer dealId = param.getInteger("dealId");
		erpFunBillService.saveBillPhoto(cityId, compId, deptId, userId, userName, earbestId, financId, dealId, depositId, photoUrl, billNo);
		return ErpResponseJson.ok();
	}

    @RequestMapping("/saveBillPhotoInMobile")
    @ApiOperation("移动端实收款项上传票据")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
    })
    public ResponseJson saveBillPhotoInMobile(@Valid @RequestBody BillPhotoParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer deptId = operator.getDeptId();
        Integer userId = operator.getUserId();
        String userName = operator.getUserName();
        Integer earbestId = param.getEarbestId();
        Integer financId = param.getFinancId();
        String photoUrl = param.getPhotoUrl();
        String billNo = param.getBillNo();
        Integer dealId = param.getDealId();
        erpFunBillService.saveBillPhoto(cityId, compId, deptId, userId, userName, earbestId, financId, dealId,null, photoUrl, billNo);
        return ErpResponseJson.ok();
    }

	/**
	 * 删除票据
	 * @author flj
	 * @Date 2017-12-11
	 * @return
	 */
	@RequestMapping("/delBillPhoto")
	public ResponseJson delBillPhoto(@Valid @RequestBody BaseMapParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer deptId = operator.getDeptId();
		Integer userId = operator.getUserId();
		String userName = operator.getUserName();
		Integer earbestId = param.getInteger("earbestId");
		Integer financId = param.getInteger("financId");
		Integer depositId = param.getInteger("depositId");
		String billNo = param.getString("billNo");
		Integer dealId = param.getInteger("dealId");
		erpFunBillService.delBillPhoto(cityId, compId, deptId, userId, userName, earbestId, financId , dealId ,depositId, billNo);
		return ErpResponseJson.ok();
	}

	@ApiOperation("移动端实收款项删除票据")
	@RequestMapping("/delBillPhotoInMobile")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
    public ResponseJson delBillPhotoInMobile(@Valid @RequestBody BillPhotoParam param) {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer deptId = operator.getDeptId();
        Integer userId = operator.getUserId();
        String userName = operator.getUserName();
        Integer earbestId = param.getEarbestId();
        Integer financId = param.getFinancId();
        String billNo = param.getBillNo();
        Integer dealId = param.getDealId();
        erpFunBillService.delBillPhoto(cityId, compId, deptId, userId, userName, earbestId, financId, dealId, null, billNo);
        return ErpResponseJson.ok();
    }
	
	/**
	 * 票据判重
	 * @author flj
	 * @Date 2017-12-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/judgeBillNoRepeat")
	public ResponseJson judgeBillNoRepeat(@Valid @RequestBody BaseMapParam param) throws Exception {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer deptId = operator.getDeptId();
		Byte billType = param.getByte("billType");
		Byte billWay = param.getByte("billWay");
		String billNo = param.getString("billNo");
		Integer count = erpFunBillCodeService.judgeBillCodeLogIsReapt(cityId, compId, deptId, billType, billWay, null, null, billNo);
		Map<String,Integer> returnMap = new HashMap<>();
		returnMap.put("count", count);
		return ErpResponseJson.ok(returnMap);
	}
}
