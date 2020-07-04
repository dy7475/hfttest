package com.myfun.erpWeb.managecenter.transaction;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunDealMapper;
import com.myfun.repository.erpdb.dao.ErpPosPaymentOrderMapper;
import com.myfun.repository.erpdb.dto.ErpPosPaymentOrderDto;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpPosPaymentOrder;
import com.myfun.repository.erpdb.po.ErpPosPaymentOrderExample;
import com.myfun.repository.jms.JmsPublisher;
import com.myfun.service.business.erpdb.ErpFunDealService;
import com.myfun.service.business.erpdb.ErpPosPaymentOrderService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/managerCenter/transaction/posPay")
public class PosPayController extends BaseController{

    @Autowired
    ErpFunDealService erpFunDealService;
    @Autowired
    ErpPosPaymentOrderMapper erpPosPaymentOrderMapper;
    @Autowired
    ErpPosPaymentOrderService erpPosPaymentOrderService;

    /**
     * title ：erp发起pose支付
      author：lcb
     * date  : 2017/10/23
     * @param param 1:诚意金 2：合同
     */
    @RequestMapping("/initiationOfPayments")
    @ResponseBody
    public ErpResponseJson getEarbestMoneyListForExport(@Valid @RequestBody BaseMapParam param) throws Exception {
        String financeType = param.getString("financeType");
        String financeIds = param.getString("financeIds");
        Integer dealId = param.getInteger("dealId");
        Operator operator = getOperator();
        String deptName = operator.getDeptName();
        Map<String, Object> resMap =  erpFunDealService.initiationOfPayments(financeType, financeIds, dealId, operator.getCityId(),
                operator.getCompId(), operator.getDeptId(), operator.getUserId(), operator.getUserName(), deptName);

//        // 估计会提到JMS里面去
//        if(null != resMap) {
//            try{
//                // 请求移动端
//                Map<String, Object> postParam = new HashMap<>();
//                if("1".equals(financeType)) {
//                    postParam.put("orderId", financeIds);
//                }else {
//                    postParam.put("orderId", dealId);
//                }
//                postParam.put("financeType", financeType);
//                postParam.put("compId",operator.getCompId());
//                postParam.put("pfIds", financeIds);
//                postParam.put("deptId", resMap.get("deptId"));
//                String tips = "";
//                if(null != resMap.get("buildName")) {
//                    tips = resMap.get("buildName")+" ";
//                }
//                tips = tips + resMap.get("financeNames") +",共计"+ resMap.get("totalAmount") + " 元";
//                postParam.put("cityId", operator.getCityId());
//                postParam.put("tips", tips);
//                System.out.println(HttpUtil.post("http://192.168.0.189:8080/mobileWeb/approveOpenApi/erpBizServer/notifyForCollection", postParam));;
//            }catch (Exception e) {
//
//            }
//        }
        return ErpResponseJson.ok();
    }

    /**
     * title ：订单列表
      author：lcb
     * date  : 2017/10/23
     * @param param 1:诚意金 2：合同
     */
    @RequestMapping("/getOrderList")
    @ResponseBody
    public ErpResponseJson getPosOrderList(@Valid @RequestBody BaseMapParam param) throws Exception {

        Operator operator = getOperator();
        Integer compId = operator.getCompId();
        Integer deptId = param.getInteger("deptId");
        Integer payStatus = param.getInteger("payStatus");
        Integer isGroupByContract = param.getInteger("isGroupByContract");
        String queryTimeStartStr = param.getString("queryTimeStart") + " 00:00:00";
        String queryTimeEndStr = param.getString("queryTimeEnd") + " 23:59:59";
        Date queryTimeStart = DateUtil.StringToDate(queryTimeStartStr);
        Date queryTimeEnd = DateUtil.StringToDate(queryTimeEndStr);
        Integer queryTimeType = param.getInteger("queryTimeType");
        String keyWords = param.getString("keyWords");
        String isExport = param.getString("isExport");
        Integer paymentId = param.getInteger("paymentId");

        if(StringUtils.isBlank(isExport) || !"1".equals(isExport)) {
            PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        }
        List<ErpPosPaymentOrderDto> resList = erpPosPaymentOrderMapper.getPosOrderList(operator.getCityId(), compId, deptId,
                payStatus, queryTimeType, queryTimeStart, queryTimeEnd, isGroupByContract, keyWords, paymentId);
        return ErpResponseJson.ok(new PageInfo<>(resList));
    }

    /**
     * title ：成功支付回调，现在暂时放在老版里
     * author：lcb
     * date  : 2017/10/23
     */
    @RequestMapping("/posAsynchronousNotify")
    @ResponseBody
    @Deprecated
    public ErpResponseJson asynchronousNotify(String orderNo, Integer cityId, Integer payStatus, Integer financeType,
                                              Integer compId, Integer deptId, String paymentTime, String financeIds,
                                              String posMachineId, String financeMoney) throws Exception {
        // 根据款项类型查询各款项信息
        // 根据信息写成功支付的信息
//        Map<String, Object> param = new HashMap<>();
//        param.put("orderNo", "12001");
//        param.put("cityId", "1");
//        param.put("payStatus", "1");
//        param.put("financeType", "1");
//        param.put("compId", "12001");
//        param.put("deptId", "12001");
//        param.put("paymentTime", "2017-08-08 20:00:00");
//        // param.put("payAccount", "xxxxxx");
//        param.put("financeIds", "1,2");
        erpPosPaymentOrderService.asynchronousNotify(orderNo, cityId, payStatus, financeType, compId, deptId,
                paymentTime, financeIds, posMachineId, financeMoney);
        return ErpResponseJson.ok();
    }

    /**
     * title ：POS机汇总
     author：lcb
     * date  : 2017/10/23
     */
    @RequestMapping("/countPosOrderList")
    @ResponseBody
    public ErpResponseJson countPosOrderList(@Valid @RequestBody BaseMapParam param) throws Exception {
        Integer deptIdParam = param.getInteger("deptId");
        String startTime = param.getString("startTime");
        String endTime = param.getString("endTime");
        // 格式化数据
        if(StringUtils.isNotBlank(startTime)) {
            startTime = startTime + " 00:00:00";
        }
        if(StringUtils.isNotBlank(endTime)) {
            endTime = endTime + " 23:59:59";
        }
        Date startTimeDate = DateUtil.StringToDate(startTime, "yyyy-MM-dd HH:mm:ss");
        Date endTimeDate = DateUtil.StringToDate(endTime, "yyyy-MM-dd HH:mm:ss");
        Operator operator = getOperator();
        List<Map<String, Object>> resList = new ArrayList<>();


        List<Map<String, Object>> contractResList = erpPosPaymentOrderMapper.countPosOrderList2(operator.getCityId(), operator.getCompId(), deptIdParam, startTimeDate, endTimeDate);
        List<Map<String, Object>> cyjList = erpPosPaymentOrderMapper.countPosOrderList(operator.getCityId(), operator.getCompId(), deptIdParam, startTimeDate, endTimeDate);
        // 未支付
        List<Map<String, Object>> notPayList = erpPosPaymentOrderMapper.countPosOrderList3(operator.getCityId(), operator.getCompId(), deptIdParam, startTimeDate, endTimeDate);

        Set<String> hasDeal = new HashSet<>();

        for (Map<String, Object> m : contractResList) {
            String  deptId = m.get("deptId") + "" ;
            if(hasDeal.contains(deptId)) {
                continue;
            }
            hasDeal.add(deptId);
            Map<String, Object> paramMap = new HashMap<>();

            // 处理逻辑
            paramMap.put("deptId", deptId);
            for (Map<String, Object> dataDealMap : contractResList) {
                String paymentId = dataDealMap.get("paymentId") + "";
                String money = dataDealMap.get("money") + "";
                paramMap .put(paymentId, money);

            }

            // 处理诚意金数据
            for (Map<String, Object> dataCyjMap : cyjList) {
                // 门店相等
                if(deptId.equals(dataCyjMap.get("deptId") + "")) {
                    String paymentId = dataCyjMap.get("paymentId") + "";
                    String money = dataCyjMap.get("money") + "";
                    paramMap .put(paymentId, money);
                }
            }

            // 未支付数据
            for (Map<String, Object> dataCyjMap : notPayList) {
                // 门店相等
                if(deptId.equals(dataCyjMap.get("deptId") + "")) {
                    String paymentId = dataCyjMap.get("paymentId") + "";
                    String money = dataCyjMap.get("money") + "";
                    paramMap .put(paymentId, money);
                }
            }
            resList.add(paramMap);

        }


        if(resList.size() == 0 && cyjList.size() > 0) {
            // 处理诚意金数据
            for (Map<String, Object> m : cyjList) {

                String  deptId = m.get("deptId") + "" ;
                if(hasDeal.contains(deptId)) {
                    continue;
                }

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("deptId", deptId);
                for (Map<String, Object> dataCyjMap : cyjList) {
                    String paymentId = dataCyjMap.get("paymentId") + "";
                    String money = dataCyjMap.get("money") + "";
                    paramMap .put(paymentId, money);
                    resList.add(paramMap);
                }

                // 未支付
                for (Map<String, Object> dataCyjMap : notPayList) {
                    // 门店相等
                    if(deptId.equals(dataCyjMap.get("deptId") + "")) {
                        String paymentId = dataCyjMap.get("paymentId") + "";
                        String money = dataCyjMap.get("money") + "";
                        paramMap .put(paymentId, money);
                        resList.add(paramMap);
                    }
                }

            }
        }

        if(cyjList.size() == 0 && notPayList.size() > 0) {
            // 处理诚意金数据
            for (Map<String, Object> m : notPayList) {

                String  deptId = m.get("deptId") + "" ;
                if(hasDeal.contains(deptId)) {
                    continue;
                }

                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("deptId", deptId);

                // 未支付
                for (Map<String, Object> dataCyjMap : notPayList) {
                    // 门店相等
                    if(deptId.equals(dataCyjMap.get("deptId") + "")) {
                        String paymentId = dataCyjMap.get("paymentId") + "";
                        String money = dataCyjMap.get("money") + "";
                        paramMap .put(paymentId, money);
                        resList.add(paramMap);
                    }
                }

            }
        }
        return ErpResponseJson.ok(new PageInfo<>(resList));
    }

    /**
     * title ：查看详情
     author：lcb
     * date  : 2017/10/23
     */
    @RequestMapping("/getAmountDetail")
    @ResponseBody
    public ErpResponseJson getAmountDetail(@Valid @RequestBody BaseMapParam param) throws Exception {

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer compId = operator.getCompId();
        Integer deptId = param.getInteger("deptId");
        String paymentId = param.getString("paymentId");
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<Map<String, Object>> resList = new ArrayList<>();
        // 诚意金
        if("-1".equals(paymentId)) {
            resList = erpPosPaymentOrderMapper.getCyjOrderDetail(cityId, compId, deptId);
            // 普通收款
        }else if ("-2".equals(paymentId)) {
            resList = erpPosPaymentOrderMapper.getCommonFinance(cityId, compId, deptId);
        }else if ("-3".equals(paymentId)) { // 未支付
            resList = erpPosPaymentOrderMapper.getNotPay(cityId, compId, deptId);
        }else {
            // 合同款项
            resList = erpPosPaymentOrderMapper.getDealFinanceDetail(cityId, compId, deptId, paymentId);
        }

        return ErpResponseJson.ok(new PageInfo<>(resList));
    }

    /**
     * title ：单条记录删除pos机订单
     author：lcb
     * date  : 2017/10/23
     */
    @RequestMapping("/delPosOrder")
    @ResponseBody
    public ErpResponseJson delPosOrder(@Valid @RequestBody BaseMapParam param) throws Exception {

        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer orderId = param.getInteger("orderId");
        Integer financeId = param.getInteger("financeId");
        erpPosPaymentOrderService.delPosOrder(cityId, orderId, financeId);
        return ErpResponseJson.ok();
    }
}
