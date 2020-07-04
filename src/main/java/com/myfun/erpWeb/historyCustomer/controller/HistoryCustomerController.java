package com.myfun.erpWeb.historyCustomer.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.historyCustomer.api.HistoryCustomerApi;
import com.myfun.erpWeb.historyCustomer.param.HistoryCustomerListParam;
import com.myfun.erpWeb.historyCustomer.param.TransferDataParam;
import com.myfun.erpWeb.historyCustomer.param.TransferRecordListParam;
import com.myfun.erpWeb.historyCustomer.vo.TransferRecordListVO;
import com.myfun.erpWeb.task.param.SendTaskParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunHistoryDealCustMapper;
import com.myfun.repository.erpdb.dao.ErpFunHistoryDealRecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.StringUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.myfun.erpWeb.historyCustomer.api.HistoryCustomerApi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HistoryCustomerController extends BaseController implements HistoryCustomerApi {
    @Autowired
    private ErpFunHistoryDealCustMapper erpFunHistoryDealCustMapper;
    @Autowired
    private ErpFunHistoryDealRecordMapper erpFunHistoryDealRecordMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;

    @Override
    public ResponseJson historyCustomerList(@RequestBody HistoryCustomerListParam historyCustomerListParam) throws Exception {
        Operator operator = getOperator();
        Integer curUserId = operator.getUserId();
        Integer cityId = operator.getCityId();

        //先判断用户是否有权限查看改组织的数据
//        boolean hasRight = true;
//        if(!true){//没有权限
//            throw  new BusinessException("没有权限查看改组织下的数据");
//        }else{
            PageHelper.startPage(historyCustomerListParam.getPageOffset(),historyCustomerListParam.getPageRows());
            List<ErpFunHistoryDealCust> historyDealCustList = erpFunHistoryDealCustMapper.getHistoryDealCustList(cityId, historyCustomerListParam);
            PageInfo pageInfo = new PageInfo(historyDealCustList);
            return new ErpResponseJson().ok(pageInfo) ;
//        }
    }

    @Override
    public ResponseJson transferRecordList(@RequestBody TransferRecordListParam transferRecordListParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer funHistoryDealCustId = transferRecordListParam.getFunHistoryDealCustId();
        ErpFunHistoryDealRecordExample erpFunHistoryDealRecordExample = new ErpFunHistoryDealRecordExample();
        erpFunHistoryDealRecordExample.setShardCityId(cityId);
        erpFunHistoryDealRecordExample.setOrderByClause("FUN_HISTORY_DEAL_RECORD_ID DESC");
        erpFunHistoryDealRecordExample.createCriteria().andFunHistoryDealCustIdEqualTo(funHistoryDealCustId);
        List<ErpFunHistoryDealRecord> erpFunHistoryDealRecords = erpFunHistoryDealRecordMapper.selectByExample(erpFunHistoryDealRecordExample);
        List<TransferRecordListVO> vo = new ArrayList<>();
        for (ErpFunHistoryDealRecord erpFunHistoryDealRecord : erpFunHistoryDealRecords) {
            TransferRecordListVO transferRecordListVO = new TransferRecordListVO();
            BeanUtils.copyProperties(erpFunHistoryDealRecord,transferRecordListVO);
            vo.add(transferRecordListVO);
        }
        return new ErpResponseJson().ok(vo);
    }

    @Override
    public ResponseJson transferData(@RequestBody TransferDataParam transferDataParam) throws Exception {
        Operator operator = getOperator();
        Integer cityId = operator.getCityId();
        Integer userId = operator.getUserId();
        String funHistoryDealCustIds = transferDataParam.getFunHistoryDealCustId();
        String afterChangeUserId = transferDataParam.getAfterChangeUserId();
        String afterChangeUserName = transferDataParam.getAfterChangeUserName();
        String afterChangeOrgName = transferDataParam.getAfterChangeOrgName();
        String afterChangeOrgId = transferDataParam.getAfterChangeOrgId();
        String beforeChangeOrgId = transferDataParam.getBeforeChangeOrgId();
        String beforeChangeUserId = transferDataParam.getBeforeChangeUserId();
        String beforeChangeOrgName = transferDataParam.getBeforeChangeOrgName();
        String beforeChangeUserName = transferDataParam.getBeforeChangeUserName();
        Date now = new Date();
        ErpFunOrganization organization = new ErpFunOrganization();
        organization.setShardCityId(cityId);
        organization.setOrganizationId(Integer.valueOf(afterChangeOrgId));
        ErpFunOrganization organization1 = erpFunOrganizationMapper.selectByPrimaryKey(organization);
        String organizationPath = organization1.getOrganizationPath();
        if(funHistoryDealCustIds.equals("ALL")){
            ErpFunHistoryDealCustExample erpFunHistoryDealCustExample = new ErpFunHistoryDealCustExample();
            erpFunHistoryDealCustExample.setShardCityId(cityId);
            erpFunHistoryDealCustExample.createCriteria().andBelongUserIdEqualTo(Integer.valueOf(beforeChangeUserId));
            ErpFunHistoryDealCust funHistoryDealCust = new ErpFunHistoryDealCust();
            funHistoryDealCust.setUpdatedTime(now);
            funHistoryDealCust.setUpdatedUserId(userId);
            funHistoryDealCust.setBelongUserId(Integer.valueOf(afterChangeUserId));
            funHistoryDealCust.setBelongUserName(afterChangeUserName);
            funHistoryDealCust.setBelongOrgId(Integer.valueOf(afterChangeOrgId));
            funHistoryDealCust.setBelongOrgName(afterChangeOrgName);
            funHistoryDealCust.setBelongOrgPath(organizationPath);
            erpFunHistoryDealCustMapper.updateByExampleSelective(funHistoryDealCust,erpFunHistoryDealCustExample);
            List<ErpFunHistoryDealCust> erpFunHistoryDealCusts = erpFunHistoryDealCustMapper.selectByExample(erpFunHistoryDealCustExample);
            if(erpFunHistoryDealCusts==null&&erpFunHistoryDealCusts.size()==0){
                throw new BusinessException("被移交人没有数据，不需要移交");
            }else{
                List<Integer> hisIds = erpFunHistoryDealCusts.stream().map(ErpFunHistoryDealCust::getFunHistoryDealCustId).collect(Collectors.toList());
                List<ErpFunHistoryDealRecord> list = new ArrayList<>();
                for (Integer hisId : hisIds) {
                    ErpFunHistoryDealRecord record = new ErpFunHistoryDealRecord();
                    record.setShardCityId(cityId);
                    record.setFunHistoryDealCustId(Integer.valueOf(hisId));
                    record.setBeforeChangeUserId(Integer.valueOf(beforeChangeUserId));
                    record.setBeforeChangeUserName(beforeChangeUserName);
                    record.setBeforeChangeOrgId(Integer.valueOf(beforeChangeOrgId));
                    record.setBeforeChangeOrgName(beforeChangeUserName);
                    //变动后
                    record.setAfterChangeUserId(Integer.valueOf(afterChangeUserId));
                    record.setAfterChangeUserName(afterChangeOrgName);
                    record.setAfterChangeOrgId(Integer.valueOf(afterChangeOrgId));
                    record.setAfterChangeOrgName(beforeChangeOrgName);
                }
                erpFunHistoryDealRecordMapper.insertRecordBatch(cityId,list);
            }

        }else{
            String[] split = funHistoryDealCustIds.split(",");
            for (String funHistoryDealCustId:split) {
                ErpFunHistoryDealCust funHistoryDealCust = new ErpFunHistoryDealCust();
                funHistoryDealCust.setFunHistoryDealCustId(Integer.valueOf(funHistoryDealCustId));
                funHistoryDealCust.setBelongUserId(Integer.valueOf(afterChangeUserId));
                funHistoryDealCust.setBelongUserName(afterChangeUserName);
                funHistoryDealCust.setBelongOrgName(afterChangeOrgName);
                funHistoryDealCust.setBelongOrgPath(organizationPath);
                funHistoryDealCust.setBelongOrgId(Integer.valueOf(afterChangeOrgId));
                funHistoryDealCust.setUpdatedTime(new Date());
                erpFunHistoryDealCustMapper.updateByPrimaryKeySelective(funHistoryDealCust);
                ErpFunHistoryDealRecord record = new ErpFunHistoryDealRecord();
                record.setShardCityId(cityId);
                record.setFunHistoryDealCustId(Integer.valueOf(funHistoryDealCustId));
                record.setBeforeChangeUserId(Integer.valueOf(beforeChangeUserId));
                record.setBeforeChangeUserName(beforeChangeUserName);
                record.setBeforeChangeOrgId(Integer.valueOf(beforeChangeOrgId));
                record.setBeforeChangeOrgName(beforeChangeUserName);
                //变动后
                record.setAfterChangeUserId(Integer.valueOf(afterChangeUserId));
                record.setAfterChangeUserName(afterChangeOrgName);
                record.setAfterChangeOrgId(Integer.valueOf(afterChangeOrgId));
                record.setAfterChangeOrgName(beforeChangeOrgName);
                erpFunHistoryDealRecordMapper.insertSelective(record);
            }
        }


        return new ErpResponseJson().ok();
    }


}
