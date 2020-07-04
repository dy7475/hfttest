package com.myfun.erpWeb.managecenter.financialLoan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import com.myfun.erpWeb.managecenter.financialLoan.param.FinanceInfoPhotoParam;
import com.myfun.erpWeb.managecenter.financialLoan.vo.JrFinancePhotoVo;
import com.myfun.erpWeb.managecenter.transaction.vo.ErpFunDealCodeVO;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminCrmUserMapper;
import com.myfun.repository.admindb.dao.AdminJrFinanceInfoMapper;
import com.myfun.repository.admindb.dao.AdminJrFinancePhotoMapper;
import com.myfun.repository.admindb.param.EditOrCreateFnanceRecordParam;
import com.myfun.repository.admindb.param.QueryFinancialListParam;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.admindb.AdminJrFinanceInfoService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.StringUtil;

/**
 * 金融贷款控制器
 *
 * @author 方李骥
 * @since 2017年06月27日
 */
@RestController
@RequestMapping(value = "/managecenter/financialLoan")
public class FinancialLoanController extends BaseController {
    @Autowired
    AdminJrFinanceInfoMapper adminJrFinanceInfoMapper;
    @Autowired
    AdminJrFinanceInfoService adminJrFinanceInfoService;
    @Autowired
    AdminJrFinancePhotoMapper adminJrFinancePhotoMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    AdminCrmUserMapper adminCrmUserMapper;

    /**
     * 金融贷款列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getFinanceRecordList")
    public ResponseJson getFinanceRecordList(@Valid @RequestBody QueryFinancialListParam param) throws Exception {
        param.setCompId(getOperator().getCompId());
        param.setCompNo(getOperator().getCompNo());
        param.setDeptNo(getOperator().getDeptNo());
        if (StringUtils.isNotBlank(param.getLoadUserName())) {
            param.setLoadUserName("%" + param.getLoadUserName() + "%");
        }
        if (StringUtils.isNotBlank(param.getBuildName())) {
            param.setBuildName("%" + param.getBuildName() + "%");
        }
        if (StringUtils.isNotBlank(param.getApplyTime())) {
            String[] timeArr = DateUtil.getTimeRange(param.getApplyTime());
            param.setStartTime(timeArr[0]);
            param.setEndTime(timeArr[1]);
        }
        if (param.getUserId() != null) { // 经纪人
            ErpFunUsers erpFunUser = erpFunUsersMapper.getUserInfoByUserId(getOperator().getCityId(), param.getUserId());
            param.setArchiveId(erpFunUser.getArchiveId());
        }
        if (StringUtils.isNotBlank(param.getLoadAmountEnum())) { // 贷款金额
            String[] amount = param.getLoadAmountEnum().split(",");
            if (amount.length == 2) {
                param.setPriceMin(amount[0]);
                param.setPriceMax(amount[1]);
            } else {
                param.setPriceMin(amount[0]);
            }
        }
        if (StringUtils.isNotBlank(param.getBuildIds())) {
            param.setBuildIdList(Arrays.asList(param.getBuildIds().split(",")));
        }
        PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        List<Map<String, Object>> list = adminJrFinanceInfoMapper.getFinanceRecordList(param);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(list);
        Set<Integer> deptIds = new HashSet<>();
        for (Map<String, Object> data : list) {
            if (!deptIds.contains(data.get("erpDeptId"))) {
                deptIds.add(StringUtil.parseInteger(String.valueOf(data.get("erpDeptId")), 0));
            }
        }
        if (deptIds.size() > 0) {
            List<ErpFunDepts> ErpFunDepts = erpFunDeptsMapper.getDeptListByDeptIds(getOperator().getCityId(), deptIds);
            for (Map<String, Object> data : list) {
                for (ErpFunDepts dept : ErpFunDepts) {
                    if (String.valueOf(dept.getDeptId()).equals(String.valueOf(data.get("erpDeptId")))) {
                        data.put("erpRegId", dept.getRegionId());
                    }
                }
            }
        }
        return ErpResponseJson.ok(pageInfo);
    }

    /**
     * 金融贷款详情
     * flj
     */
    @RequestMapping(value = "/getFinanceRecordDetail")
    public ResponseJson getFinanceRecordDetail(@Valid @RequestBody BaseMapParam param) throws Exception {
        Integer id = param.getInteger("id");
        AdminJrFinanceInfoExample example = new AdminJrFinanceInfoExample();
        example.createCriteria().andIdEqualTo(id).andCityIdEqualTo(getOperator().getCityId());
        List<AdminJrFinanceInfo> list = adminJrFinanceInfoMapper.selectByExample(example);
        if (!list.isEmpty()) {
            AdminJrFinanceInfo adminJrFinanceInfo = list.get(0);
            Map<String, Object> resultMap = BeanUtil.objToKeyMap(adminJrFinanceInfo);
            List<String> crmUserId = new ArrayList<>();
            // 办单员
            if (adminJrFinanceInfo.getDealUserId() != null) {
                crmUserId.add(adminJrFinanceInfo.getDealUserId().toString());
            }
            // 评估员
            if (adminJrFinanceInfo.getAssessmentUserId() != null) {
                crmUserId.add(adminJrFinanceInfo.getAssessmentUserId().toString());
            }
            // 业务员
            if (adminJrFinanceInfo.getBusinessUserId() != null) {
                crmUserId.add(adminJrFinanceInfo.getBusinessUserId().toString());
            }
            // 抵押员
            if (adminJrFinanceInfo.getPledgeEmployee() != null) {
                crmUserId.add(adminJrFinanceInfo.getPledgeEmployee().toString());
            }
            // 过户员
            if (adminJrFinanceInfo.getTransferEmployee() != null) {
                crmUserId.add(adminJrFinanceInfo.getTransferEmployee().toString());
            }
            if (!crmUserId.isEmpty()) {
                List<AdminCrmUser> crmUserList = adminCrmUserMapper.getCrmUserListByIds(crmUserId);
                for (AdminCrmUser crmUser : crmUserList) {
                    String userId = crmUser.getUserId().toString();
                    if (userId.equals(String.valueOf(resultMap.get("dealUserId")))) {
                        resultMap.put("dealUserName", crmUser.getUserName());
                        resultMap.put("dealUserMobile", crmUser.getUserMobile());
                    }
                    if (userId.equals(String.valueOf(resultMap.get("assessmentUserId")))) {
                        resultMap.put("assessmentUserName", crmUser.getUserName());
                        resultMap.put("assessmentUserMobile", crmUser.getUserMobile());
                    }
                    if (userId.equals(String.valueOf(resultMap.get("businessUserId")))) {
                        resultMap.put("businessUserName", crmUser.getUserName());
                        resultMap.put("businessUserMobile", crmUser.getUserMobile());
                    }
                    if (userId.equals(String.valueOf(resultMap.get("pledgeEmployee")))) {
                        resultMap.put("pledgeEmployeeName", crmUser.getUserName());
                        resultMap.put("pledgeEmployeeMobile", crmUser.getUserMobile());
                    }
                    if (userId.equals(String.valueOf(resultMap.get("transferEmployee")))) {
                        resultMap.put("transferEmployeeName", crmUser.getUserName());
                        resultMap.put("transferEmployeeMobile", crmUser.getUserMobile());
                    }
                }
            }

            List<Map<String, String>> photoList = adminJrFinancePhotoMapper.getPhotoListByFinanceId(id);
            for (Map<String, String> photo : photoList) {
                String photoAddr = photo.get("PHOTO_PATH");
                photo.put("PHOTO_PATH", CommonUtil.getHousePhoto(photoAddr));
            }
            resultMap.put("photoList", JSON.toJSONString(photoList));
            return ErpResponseJson.ok(resultMap);
        }
        return ErpResponseJson.ok();
    }

    /**
     * 金融贷款新增
     * flj
     *
     * @throws Exception
     */
    @RequestMapping(value = "/addEditPaFinanceRecord")
    public ResponseJson addEditPaFinanceRecord(@Valid @RequestBody EditOrCreateFnanceRecordParam param) throws Exception {
        // 添加公司门店信息
        Map<String, Object> pMap = new HashMap<String, Object>();
        pMap.put("currentDeptId", getOperator().getDeptId());
        pMap.put("compId", getOperator().getCompId());
        pMap.put("cityId", getOperator().getCityId());
        pMap.put("currentArchiveId", getOperator().getArchiveId());
        pMap.put("source", "1"); // 来源 erp
        String financeInfoId = "";
        if (param.getId() == null) {
            param.setCompNo(getOperator().getCompNo());
            param.setArchiveId(getOperator().getArchiveId());
            param.setDeptNo(getOperator().getDeptNo());
            param.setErpCompId(getOperator().getCompId());
            param.setErpDeptId(getOperator().getDeptId());
            param.setBrokerDeptName(getOperator().getDeptName());
            param.setBrokerUserName(getOperator().getUserName());
            param.setBrokerUserMobile(getOperator().getUserMobile());
            param.setErpAudit(Byte.valueOf("0")); // 未审核
            param.setCustType(Byte.valueOf("1"));
            // 判断加盟店/非加盟点
            if (getOperator().isYouJiaUser()) {
                param.setCustType(new Byte("0"));
            }
            param.setSource(Byte.valueOf("1"));
            param.setCreateUserId(getOperator().getUserId());
            param.setCreateTime(new Date());
            param.setCreateUserName(getOperator().getUserName());
            param.setCityId(getOperator().getCityId());
            param.setErpAreaId(getOperator().getAreaId());
        } else {
            financeInfoId = param.getId().toString();
        }
        String post = HttpUtil.post(AppConfig.getCrmWebUrl() + "/financeLoan/loanManageForWechat/addLoanInfo", pMap);
        JSONObject jsonObject = JSON.parseObject(post);
        Object errorCode = jsonObject.get("code");
        if (null != errorCode && !"200".equals(errorCode.toString())) {
            throw new BusinessException(jsonObject.get("msg").toString());
        } else {
            financeInfoId = jsonObject.get("data").toString();
        }
        return ErpResponseJson.ok(financeInfoId);
    }

    /**
     * 注销
     * flj
     *
     * @throws Exception
     */
    @RequestMapping(value = "/canclePaFinanceRecord")
    public ResponseJson canclePaFinanceRecord(@Valid @RequestBody BaseMapParam param) throws Exception {
        Map<String, Object> pMap = new HashMap<>();
        pMap.put("ids", param.getString("ids"));
        pMap.put("currentDeptId", getOperator().getDeptId());
        pMap.put("compId", getOperator().getCompId());
        pMap.put("cityId", getOperator().getCityId());
        pMap.put("currentArchiveId", getOperator().getArchiveId());
        pMap.put("source", "1"); // 来源 erp
        String post = HttpUtil.post(AppConfig.getCrmWebUrl() + "financeLoan/loanManageForWechat/cancleLoad", pMap);
        JSONObject jsonObject = JSON.parseObject(post);
        Object errorCode = jsonObject.get("code");
        if (null != errorCode && !"200".equals(errorCode.toString())) {
            throw new BusinessException(jsonObject.get("msg").toString());
        }
        return ErpResponseJson.ok();
    }

    /**
     * 获取金融贷款图片数据
     * hukun
     *
     * @throws Exception
     */
    @ApiOperation("获取金融贷款图片数据")
    @ApiResponses(value = {
            @ApiResponse(code = Const.ResponseCode.SUCCESS, response = JrFinancePhotoVo.class, message = "成功")
    })
    @RequestMapping(value = "/getFinanceInfoPhotoList")
    public ResponseJson getFinanceInfoPhotoList(@Valid @RequestBody FinanceInfoPhotoParam param) throws Exception {
        Integer financeId = param.getFinanceId();
        Integer photoType = param.getPhotoType();

        AdminJrFinancePhotoExample example = new AdminJrFinancePhotoExample();
        example.createCriteria().andFinanceIdEqualTo(financeId).andDeleteFlagEqualTo(false);
        if (null != photoType) {
            example.createCriteria().andPhotoTypeEqualTo(photoType.byteValue());
        }
        List<AdminJrFinancePhoto> resList = adminJrFinancePhotoMapper.selectByExample(example);
        for (AdminJrFinancePhoto photo : resList) {
            String photoAddr = photo.getPhotoPath();
            photo.setPhotoPath(CommonUtil.getHousePhoto(photoAddr));
        }
        JrFinancePhotoVo resultVo = new JrFinancePhotoVo();
        resultVo.setList(resList);
        return ErpResponseJson.ok(resultVo);
    }
}
