package com.myfun.erpWeb.managecenter.sysmanager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.FunDeptsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerDeptsParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.PartnerOrgParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.QueryPartnerDeptParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.QueryPartnerOrgParam;
import com.myfun.erpWeb.managecenter.sysmanager.vo.PartnerDeptListVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.QueryPartnerOrgVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.agencydb.param.AgencyFunUsersParam;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationDefinitionMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationManagerMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerOrgMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.PartnerDeptDto;
import com.myfun.repository.erpdb.dto.PartnerOrgDto;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinition;
import com.myfun.repository.erpdb.po.ErpFunOrganizationDefinitionExample;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManager;
import com.myfun.repository.erpdb.po.ErpFunOrganizationManagerExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.reportdb.dao.ReportFunBuyCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunLeaseMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunRentCustomerMinMapper;
import com.myfun.repository.reportdb.dao.ReportFunSaleMinMapper;
import com.myfun.repository.reportdb.po.ReportFunBuyCustomerMinExample;
import com.myfun.repository.reportdb.po.ReportFunLeaseMinExample;
import com.myfun.repository.reportdb.po.ReportFunRentCustomerMinExample;
import com.myfun.repository.reportdb.po.ReportFunSaleMin;
import com.myfun.repository.reportdb.po.ReportFunSaleMinExample;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunPartnerDeptService;
import com.myfun.service.business.erpdb.ErpFunPartnerService;
import com.myfun.service.business.report.ReportFunSaleMinService;
import com.myfun.utils.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 */
@Api(tags = "加盟商门店管理")
@RestController
@RequestMapping("/managerCenter/organization/partner")
public class PartnerDeptController extends BaseController {


    @Autowired
    private ErpFunPartnerService erpFunPartnerService;
    @Autowired
    private ErpFunPartnerDeptService erpFunPartnerDeptService;
    @Autowired
    private ErpFunPartnerMapper erpFunPartnerMapper;
    @Autowired
    private AdminFunDeptsMapper adminFunDeptsMapper;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private ErpFunDeptsService erpFunDeptsService;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private ReportFunSaleMinService reportFunSaleMinService;
    @Autowired
    private ErpFunCompMapper erpFunCompMapper;
    @Autowired
    private ReportFunSaleMinMapper reportFunSaleMinMapper;
    @Autowired
    private ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
    @Autowired
    private ErpFunPartnerOrgMapper erpFunPartnerOrgMapper;
    @Autowired
    private ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;
    @Autowired
    private ReportFunLeaseMinMapper reportFunLeaseMinMapper;
    @Autowired
    private ReportFunBuyCustomerMinMapper reportFunBuyCustomerMinMapper;
    @Autowired
    private ReportFunRentCustomerMinMapper reportFunRentCustomerMinMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;

    @ApiOperation(value = "修改门店")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "修改门店", response = ErpResponseJson.class)})
    @PostMapping("/updatePartnerDept")
    public ErpResponseJson updatePartnerDept(@RequestBody PartnerDeptsParam param) {
        param.setSelfUserId(getOperator().getUserId());
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setCompNo(getOperator().getCompNo());
        param.setUserName(getOperator().getUserName());

        ErpFunDepts beforeDepts = erpFunDeptsMapper.getByDeptId(param.getCityId(), param.getDeptId());
        Assert.isNullThrow(beforeDepts,"门店不存在!");
        //数据量检查
        judgeCanChangeDeptModel(param);
        //原组织机构逻辑  修改大区片区时需要把门店下的所有经纪人人的大区片区修改
        if (Objects.nonNull(param.getRegId()) && Objects.nonNull(param.getAreaId())
                && !Objects.equals(beforeDepts.getRegId(), param.getRegId())) {
            FunDeptsParam funDeptsParam = new FunDeptsParam();
            BeanUtils.copyProperties(param, funDeptsParam);
            erpFunDeptsService.updateDept(funDeptsParam);
        }
        //加盟商相关修改
        erpFunPartnerDeptService.updatePartnerInfo(param);
        return ErpResponseJson.ok();
    }



    /**
     * 判断修改表的最大数据量
     * @param param p
     */
    private void judgeCanChangeDeptModel(PartnerDeptsParam param) {
        List<ErpFunUsers> users = erpFunUsersMapper.getUserListByDeptId(param.getCityId(), param.getDeptId());
        ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(param.getCityId(), param.getCompId());
        List<String> userIds = users.stream().map(ErpFunUsers::getUserId).map(Object::toString).collect(Collectors.toList());
        if (!userIds.isEmpty()) {
            reportFunSaleMinService.judgeOperatorTransferShop(erpFunComp.getCompNo(), param.getCityId(), param.getCompId(),
                    String.join(",", userIds), 5, null,null);
        }
    }

    @ApiOperation(value = "门店列表")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "门店列表", response = PartnerDeptListVo.class)})
    @PostMapping("/partnerDeptList")
    public ErpResponseJson partnerDeptList(@RequestBody QueryPartnerDeptParam param) {
        Operator op = getOperator();
        param.setCompId(op.getCompId());
        List<AdminFunDepts> adminDepts = Collections.emptyList();
        if (StringUtils.isNotBlank(param.getAvailableTime())) {
            //到期时间需要到admin库查询
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Instant availableTime = LocalDate.parse(param.getAvailableTime(), pattern).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            Date availableDate = Date.from(availableTime);
            adminDepts = adminFunDeptsMapper.selectByEndTime(op.getCompNo(), availableDate);
            if (adminDepts.isEmpty()) {
                return ErpResponseJson.ok(new PageInfo<>(Collections.emptyList()));
            }
            List<String> adminDeptNos = adminDepts.stream().map(AdminFunDepts::getDeptNo).collect(Collectors.toList());
            param.setDeptNos(adminDeptNos);
        }
        PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        List<PartnerDeptDto> dtos = erpFunPartnerMapper.selectPartnerDeptList(op.getCityId(), param);
        if (dtos.isEmpty()) {
            return ErpResponseJson.ok(new PageInfo<>(Collections.emptyList()));
        }
        if (adminDepts.isEmpty()) {
            //未指定时间时查询admin
            List<String> deptNos = dtos.stream().map(PartnerDeptDto::getDeptNo).collect(Collectors.toList());
            adminDepts = adminFunDeptsMapper.selectByDeptNos(op.getCompNo(), deptNos);
        }
        Map<String, AdminFunDepts> noToObj = adminDepts.stream().collect(Collectors.toMap(AdminFunDepts::getDeptNo, Function.identity(), (e1, e2) -> e2));
        //trans vo
        List<PartnerDeptListVo> result = dtos.stream().map(dto -> {
            PartnerDeptListVo vo = new PartnerDeptListVo();
            BeanUtils.copyProperties(dto, vo);
            AdminFunDepts adminFunDepts = noToObj.get(dto.getDeptNo());
            if (Objects.nonNull(adminFunDepts)) {
                vo.setDeptContact(adminFunDepts.getDeptContact());
                if (Objects.nonNull(adminFunDepts.getOtoEnd())) {
                    vo.setDueDate(adminFunDepts.getOtoEnd());
                } else {
                    vo.setDueDate(adminFunDepts.getTryEnd());
                }
            }
            //加盟模式 0.直营，1.加盟，2.总部
            return vo;
        }).collect(Collectors.toList());
        //
        PageInfo<PartnerDeptDto> dtoPageInfo = new PageInfo<>(dtos);
        PageInfo<PartnerDeptListVo> resultPageInfo = new PageInfo<>();
        resultPageInfo.setTotal(dtoPageInfo.getTotal());
        resultPageInfo.setPageNum(dtoPageInfo.getPageNum());
        resultPageInfo.setPageSize(dtoPageInfo.getSize());
        resultPageInfo.setPages(dtoPageInfo.getPages());
        resultPageInfo.setList(result);
        return ErpResponseJson.ok(resultPageInfo);
    }


    //---------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------无限组织加盟商-------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------



    @ApiOperation(value = "组织列表,未指定加盟商层级时列表为空")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "组织列表", response = PartnerDeptListVo.class)})
    @PostMapping("partnerOrganizationList")
    ErpResponseJson partnerOrganizationList(QueryPartnerOrgParam param) {
        Operator operator = getOperator();
        if (!operator.newOrganizationType()) {
            return ErpResponseJson.ok(Collections.emptyList());
        }
        //查询加盟商所在层级
        ErpFunOrganizationDefinitionExample ex = new ErpFunOrganizationDefinitionExample();
        ex.setShardCityId(operator.getCityId());
        ex.createCriteria().andCompIdEqualTo(operator.getCompId()).andPartnerLevelEqualTo(Byte.valueOf("1")).andDelFlagEqualTo(Byte.valueOf("0"));
        List<ErpFunOrganizationDefinition> odList = erpFunOrganizationDefinitionMapper.selectByExample(ex);
        if (odList.isEmpty()) {
            return ErpResponseJson.ok(Collections.emptyList());
        }
        ErpFunOrganizationDefinition definition = odList.get(0);
        Integer definitionLevel = definition.getDefinitionLevel();
        //根据层级查询所有组织
        PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        List<PartnerOrgDto> list = erpFunPartnerOrgMapper.selectPartnerOrgList(operator.getCityId(), param);
        //查询主管
        Map<Integer, String> usersHashMap = Collections.emptyMap();
        Map<Integer, List<ErpFunOrganizationManager>> manageMap =  Collections.emptyMap();
        if (!list.isEmpty()) {
            List<Integer> ids = list.stream().map(PartnerOrgDto::getOrganizationId).collect(Collectors.toList());
            ErpFunOrganizationManagerExample ome = new ErpFunOrganizationManagerExample();
            ome.setShardCityId(operator.getCityId());
            ome.createCriteria().andCompIdEqualTo(operator.getCompId()).andOrganizationIdIn(ids);
            List<ErpFunOrganizationManager> managers = erpFunOrganizationManagerMapper.selectByExample(ome);
            manageMap = managers.stream().collect(Collectors.groupingBy(ErpFunOrganizationManager::getOrganizationId));
            List<Integer> userIds = managers.stream().map(ErpFunOrganizationManager::getUserId).collect(Collectors.toList());
            if(!userIds.isEmpty()) {
                List<ErpFunUsers> erpFunUsers = erpFunUsersMapper.selectUserListByIds(operator.getCityId(), operator.getCompId(), userIds);
                usersHashMap = erpFunUsers.stream().collect(HashMap::new, (m, e) -> m.put(e.getUserId(), e.getUserName()), Map::putAll);
            }
        }
        //主管名
        for (PartnerOrgDto dto : list) {
            List<ErpFunOrganizationManager> managers = manageMap.get(dto.getOrganizationId());
            if (Objects.nonNull(managers)) {
                String names = managers.stream().map(usersHashMap::get).filter(Objects::nonNull).collect(Collectors.joining("、"));
                dto.setUserNames(names);
            }
        }
        List<QueryPartnerOrgVo> voList = list.stream().map(obj -> {
            QueryPartnerOrgVo vo = new QueryPartnerOrgVo();
            BeanUtils.copyProperties(obj, vo);
            return vo;
        }).collect(Collectors.toList());

        //分页结果信息
        PageInfo<PartnerOrgDto> pageInfoDto = new PageInfo<>(list);
        PageInfo<QueryPartnerOrgVo> pageInfo = new PageInfo<>(voList);
        pageInfo.setTotal(pageInfoDto.getTotal());
        pageInfo.setPages(pageInfoDto.getPages());
        pageInfo.setPageSize(pageInfoDto.getPageSize());
        pageInfo.setPageNum(pageInfoDto.getPageNum());
        return ErpResponseJson.ok(pageInfo);
    }


    //切换组织运营模式
    @ApiOperation(value = "修改门店")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "修改部门", response = ErpResponseJson.class)})
    @PostMapping("/updatePartnerOrg")
    public ErpResponseJson updatePartnerOrg(@RequestBody PartnerOrgParam param) {
        param.setSelfUserId(getOperator().getUserId());
        param.setCityId(getOperator().getCityId());
        param.setCompId(getOperator().getCompId());
        param.setSelfCompNo(getOperator().getCompNo());
        param.setUserName(getOperator().getUserName());
        Assert.isNullThrow(param.getOrganizationId(), "请指定修改的部门ID");
        ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrgId(param.getCityId(), param.getCompId(), param.getOrganizationId());
        Assert.isNullThrow(organization,"部门不存在!");
        param.setOrganizationPath(organization.getOrganizationPath());
        //数据量检查
        judgeCanChangeOrgModel(param);
        //加盟商相关修改
        erpFunPartnerDeptService.updateOrgPartnerInfo(param);
        return ErpResponseJson.ok();
    }


    /**
     * 判断房客源数据量是否超过3000 超过3000提醒晚上执行
     * @param param
     */
    private void judgeCanChangeOrgModel(PartnerOrgParam param) {

        LocalDateTime timeFlag = LocalDate.now().atStartOfDay().plusHours(20);
        if (LocalDateTime.now().isAfter(timeFlag)) {
            return;
        }
        // 查询房，客源，数量的情况
        String descStr = "由于数据处理量太大，为了确保您公司业务正常进行，请晚上20点以后再进行[修改部门运营模式]操作！";
        ReportFunSaleMinExample reportFunSaleMinExample = new ReportFunSaleMinExample();
        reportFunSaleMinExample.createCriteria().andCityIdEqualTo(param.getCityId()).andCompIdEqualTo(param.getCompId()).andTissueLineLike(param.getOrganizationPath());
        int countSale = reportFunSaleMinMapper.countByExample(reportFunSaleMinExample);
        if (countSale >= 3000) {
            throw new BusinessException(descStr, "-1");
        }
        ReportFunLeaseMinExample reportFunLeaseMinExample = new ReportFunLeaseMinExample();
        reportFunLeaseMinExample.createCriteria().andCityIdEqualTo(param.getCityId()).andCompIdEqualTo(param.getCompId()).andTissueLineLike(param.getOrganizationPath());
        int countLease = reportFunLeaseMinMapper.countByExample(reportFunLeaseMinExample);
        if (countLease >= 3000) {
            throw new BusinessException(descStr, "-1");
        }
        ReportFunBuyCustomerMinExample reportFunBuyCustomerMinExample = new ReportFunBuyCustomerMinExample();
        reportFunBuyCustomerMinExample.createCriteria().andCityIdEqualTo(param.getCityId()).andCompIdEqualTo(param.getCompId()).andTissueLineLike(param.getOrganizationPath());
        int countBuyCustomer = reportFunBuyCustomerMinMapper.countByExample(reportFunBuyCustomerMinExample);
        if (countBuyCustomer >= 3000) {
            throw new BusinessException(descStr, "-1");
        }
        ReportFunRentCustomerMinExample reportFunRentCustomerMinExample = new ReportFunRentCustomerMinExample();
        reportFunRentCustomerMinExample.createCriteria().andCityIdEqualTo(param.getCityId()).andCompIdEqualTo(param.getCompId()).andTissueLineLike(param.getOrganizationPath());
        int countRentCustomer = reportFunRentCustomerMinMapper.countByExample(reportFunRentCustomerMinExample);
        if (countRentCustomer >= 3000) {
            throw new BusinessException(descStr, "-1");
        }

    }

}
