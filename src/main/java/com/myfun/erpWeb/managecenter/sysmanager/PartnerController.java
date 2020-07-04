package com.myfun.erpWeb.managecenter.sysmanager;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.AddPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DelPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.EditPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.QueryDealLinkedDetailParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SaveDealLinkedParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.SearchPartnerParam;
import com.myfun.erpWeb.managecenter.sysmanager.vo.AllPartnerListVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.ErpFunPartnerVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.FunDealLinkedVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.FunPartnerDeptVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.UserInfoVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunDealLinkedMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerDeptMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerMapper;
import com.myfun.repository.erpdb.dao.ErpFunPartnerOrgMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunDealLinked;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsExample;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunPartner;
import com.myfun.repository.erpdb.po.ErpFunPartnerDept;
import com.myfun.repository.erpdb.po.ErpFunPartnerDeptExample;
import com.myfun.repository.erpdb.po.ErpFunPartnerLog;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.erpdb.ErpFunPartnerService;
import com.myfun.utils.Assert;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
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

import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: desc
 */
@Api(tags = "加盟商管理")
@RestController
@RequestMapping("/managerCenter/organization/partner/")
public class PartnerController extends BaseController {


    @Autowired
    private ErpFunPartnerMapper erpFunPartnerMapper;
    @Autowired
    private ErpFunPartnerLogMapper erpFunPartnerLogMapper;
    @Autowired
    private ErpFunDealLinkedMapper erpFunDealLinkedMapper;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private ErpFunPartnerDeptMapper erpFunPartnerDeptMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;
    @Autowired
    private ErpFunPartnerService erpFunPartnerService;
    @Autowired
    private ErpFunPartnerOrgMapper erpFunPartnerOrgMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;

    @ApiOperation(value = "添加加盟商")
    @PostMapping("/addPartner")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "添加盟商", response = ErpResponseJson.class)})
    public ErpResponseJson addPartner(@RequestBody AddPartnerParam param) {
        Operator op = getOperator();
        //a.校验信用代码
        if (StringUtil.isNotBlank(param.getEnterpriseCreditCode())) {
            checkCreditCode(op.getCityId(), param.getEnterpriseCreditCode());
        }
        checkPartnerName(op.getCityId(),param.getPartnerName());
        //b.校验负责人及管理员不能与其他加盟商重复
        addCheckUsers(param, op);
        param.setCityId(op.getCityId());
        param.setCompId(op.getCompId());
        param.setUserId(op.getUserId());
        param.setUserName(op.getUserName());
        ErpFunPartner partner = null;
        if (op.newOrganizationType()) {
            //无限组织机构情况下
            partner = erpFunPartnerService.addPartnerForNewOrg(param);
        }else {
            partner = erpFunPartnerService.addPartner(param);
        }
        ErpFunPartnerVo vo = new ErpFunPartnerVo();
        BeanUtils.copyProperties(partner, vo);
        vo.setPartnerId(partner.getId());
        return ErpResponseJson.ok(vo);
    }


    //修改加盟商 只能修改负责人及管理员
    @ApiOperation(value = "改")
    @PostMapping("/updatePartner")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "更新加盟商信息", response = ErpResponseJson.class)})
    public ErpResponseJson updatePartner(@RequestBody EditPartnerParam param) {
        Operator op = getOperator();
        // 获取原记录
        ErpFunPartner record = erpFunPartnerMapper.selectById(op.getCityId(), op.getCompId(), param.getPartnerId());
        Assert.isNullThrow(record, "原分组不存在!");
        //b.校验负责人及管理员不能与其他加盟商重复
        updateCheckUsers(param, op, record);
        //c.写数据记录，写日志
        ErpFunPartner updated = new ErpFunPartner();
        Optional.ofNullable(param.getUserId()).ifPresent(updated::setUserId);
        Optional.ofNullable(param.getManagerUserId()).ifPresent(updated::setManagerUserId);
        BeanUtils.copyProperties(param, updated);
        updated.setUpdateTime(new Date());
        updated.setShardCityId(op.getCityId());
        erpFunPartnerMapper.updateByPrimaryKeySelective(updated);
        //FUN_PARTNER_LOG FunPartnerLog
        String content = MessageFormat.format("{0}修改了分组[{1}]", op.getUserName(), param.getPartnerName());
        writeLog(content, op, record, updated, record.getId());
        return ErpResponseJson.ok();
    }

    @ApiOperation(value = "删")
    @PostMapping("/deletePartner")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "删除加盟商", response = ErpResponseJson.class)})
    public ErpResponseJson deletePartner(@RequestBody DelPartnerParam param) {
        Assert.isNullThrow(param.getId(), "请指定要删除的分组id");
        Operator op = getOperator();
        ErpFunPartner partner = erpFunPartnerMapper.selectById(op.getCityId(), op.getCompId(), param.getId());
        Assert.isNullThrow(partner, "该分组不存在!");
        Date now = new Date();
        if (op.newOrganizationType()) {
            //无限组织机构
            int count = erpFunPartnerOrgMapper.countByPartnerId(op.getCityId(), op.getCompId(), param.getId());
            if (count > 0) {
                throw new BusinessException("请将该分组下的组织调出后再删除!");
            }
        }else {
            //原门店模式
            int count = erpFunPartnerDeptMapper.countByPartnerId(op.getCityId(), op.getCompId(), param.getId());
            if (count > 0) {
                throw new BusinessException("请将该分组下的门店调出后再删除!");
            }
        }

        ErpFunPartner updated = new ErpFunPartner();
        updated.setIsDel((byte) 1);
        updated.setDelUserId(op.getUserId());
        updated.setUpdateTime(new Date());
        updated.setShardCityId(op.getCityId());
        updated.setId(partner.getId());
        erpFunPartnerMapper.updateByPrimaryKeySelective(updated);
        String content = MessageFormat.format("{0}删除了分组[{1}]", op.getUserName(), partner.getPartnerName());
        writeLog(content, op, partner, null, partner.getId());
        erpFunPartnerService.deletePartnerSysParam(op.getCityId(),op.getCompId(),partner.getId());
        //适应erp前端
        ErpFunPartnerVo erpFunPartnerVo = new ErpFunPartnerVo();
        erpFunPartnerVo.setPartnerId(partner.getId());
        return ErpResponseJson.ok(erpFunPartnerVo);
    }


    @ApiOperation(value = "公司所有加盟商")
    @PostMapping("/allPartnerList")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "公司所有加盟商", response = AllPartnerListVo.class)})
    public ErpResponseJson allPartnerList() {
        Operator operator = getOperator();
        List<ErpFunPartner> list = erpFunPartnerMapper.selectAllPartner(operator.getCityId(), operator.getCompId());
        if (list.isEmpty()) {
            return ErpResponseJson.ok(list);
        }
        List<ErpFunPartnerVo> result = list.stream().map(this::toPartnerVo).collect(Collectors.toList());
        AllPartnerListVo vo = new AllPartnerListVo();
        vo.setPartnerList(result);
        return ErpResponseJson.ok(vo);
    }

    /**
     * 筛选条件：加盟商、负责人、门店
     *
     * @return
     */
    @ApiOperation(value = "条件查询")
    @PostMapping("/partnerList")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "条件查询", response = ErpFunPartnerVo.class)})
    public ErpResponseJson partnerList(@RequestBody SearchPartnerParam param) {

        Operator op = getOperator();
        param.setCompId(op.getCompId());
        if (StringUtils.isNotBlank(param.getStartTime()) && StringUtils.isNotBlank(param.getEndTime())) {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(param.getStartTime(), pattern);
            Instant start = startDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
            LocalDate endDate = LocalDate.parse(param.getEndTime(), pattern);
            Instant end = endDate.atStartOfDay().plusDays(1).plusSeconds(-1).atZone(ZoneId.systemDefault()).toInstant();
            param.setStartDate(Date.from(start));
            param.setEndDate(Date.from(end));
        }
        if (StringUtil.isBlank(param.getFuzzySearch())) {
            param.setFuzzySearch(null);
        }
        if (op.newOrganizationType()) {
            PageInfo<ErpFunPartnerVo> pageInfo = getErpFunPartnerResultForOrg(param, op);
            return ErpResponseJson.ok(pageInfo);
        }else {
            PageInfo<ErpFunPartnerVo> pageInfo = getErpFunPartnerResultForDept(param, op);
            return ErpResponseJson.ok(pageInfo);
        }
    }

    /**
     * 无限组织机构
     * @param param
     * @param op
     * @return
     */
    private PageInfo<ErpFunPartnerVo> getErpFunPartnerResultForOrg(SearchPartnerParam param, Operator op) {
        //分页查询加盟商列表
        PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        List<ErpFunPartner> list = erpFunPartnerMapper.selectPartnersForOrg(op.getCityId(), param);
        //门店及负责人，管理员相关信息
        Map<Integer, List<ErpFunOrganization>> partner2OrgList = Collections.emptyMap();
        Map<Integer, ErpFunUsers> userId2Po = Collections.emptyMap();
        if (!list.isEmpty()) {
            List<Integer> partnerIds = list.stream().map(ErpFunPartner::getId).collect(Collectors.toList());
            List<ErpFunOrganization> organizationList = erpFunOrganizationMapper.selectByPartnerIds(op.getCityId(), op.getCompId(), partnerIds);
            partner2OrgList = organizationList.stream().collect(Collectors.groupingBy(ErpFunOrganization::getPartnerId));
            Set<Integer> userIds = list.stream().flatMap(obj -> Stream.of(obj.getUserId(), obj.getManagerUserId())).filter(Objects::nonNull).collect(Collectors.toSet());
            if (!userIds.isEmpty()) {
                List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(op.getCityId(), userIds);
                userId2Po = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
            }
        }
        //返回结果处理
        List<ErpFunPartnerVo> resultList = list.stream().map(this::toPartnerVo).collect(Collectors.toList());
        for (ErpFunPartnerVo vo : resultList) {
            Integer partnerId = vo.getPartnerId();
            List<ErpFunOrganization> organizationList = partner2OrgList.get(partnerId);
            List<Integer> deptIds = Optional.ofNullable(organizationList).orElse(Collections.emptyList()).stream().map(ErpFunOrganization::getOrganizationId).collect(Collectors.toList());
            //相关门店使用简称
            String names = Optional.ofNullable(organizationList).orElse(Collections.emptyList()).stream().map(ErpFunOrganization::getOrganizationName).collect(Collectors.joining("、"));
            vo.setDeptIds(deptIds);
            vo.setDeptNames(names);
            if (null != userId2Po.get(vo.getUserId())) {
                ErpFunUsers user = userId2Po.get(vo.getUserId());
                vo.setUserName(user.getUserName());
                //联系电话
                if (StringUtils.isBlank(vo.getPartnerTele())) {
                    vo.setPartnerTele(user.getUserMobile());
                }
            }
            Optional.ofNullable(userId2Po.get(vo.getManagerUserId())).ifPresent((u)->vo.setManagerUserName(u.getUserName()));
        }
        //分页结果信息
        PageInfo<ErpFunPartner> pageInfoDto = new PageInfo<>(list);
        PageInfo<ErpFunPartnerVo> pageInfo = new PageInfo<>(resultList);
        pageInfo.setTotal(pageInfoDto.getTotal());
        pageInfo.setPages(pageInfoDto.getPages());
        pageInfo.setPageSize(pageInfoDto.getPageSize());
        pageInfo.setPageNum(pageInfoDto.getPageNum());
        return pageInfo;
    }

    /**
     * 原门店版
     * @param param
     * @param op
     * @return
     */
    private PageInfo<ErpFunPartnerVo> getErpFunPartnerResultForDept(@RequestBody SearchPartnerParam param, Operator op) {
        //分页查询加盟商列表
        PageHelper.startPage(param.getPageOffset(), param.getPageRows());
        List<ErpFunPartner> list = erpFunPartnerMapper.selectPartners(op.getCityId(), param);
        //门店及负责人，管理员相关信息
        Map<Integer, List<ErpFunDepts>> partner2DeptList = Collections.emptyMap();
        Map<Integer, ErpFunUsers> userId2Po = Collections.emptyMap();
        if (!list.isEmpty()) {
            List<Integer> partnerIds = list.stream().map(ErpFunPartner::getId).collect(Collectors.toList());
            List<ErpFunDepts> deptList = erpFunDeptsMapper.selectByPartnerIds(op.getCityId(), op.getCompId(), partnerIds);
            partner2DeptList = deptList.stream().collect(Collectors.groupingBy(ErpFunDepts::getPartnerId));
            Set<Integer> userIds = list.stream().flatMap(obj -> Stream.of(obj.getUserId(), obj.getManagerUserId())).filter(Objects::nonNull).collect(Collectors.toSet());
            if (!userIds.isEmpty()) {
                List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(op.getCityId(), userIds);
                userId2Po = userList.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, Function.identity()));
            }
        }
        //返回结果处理
        List<ErpFunPartnerVo> resultList = list.stream().map(this::toPartnerVo).collect(Collectors.toList());
        for (ErpFunPartnerVo vo : resultList) {
            Integer partnerId = vo.getPartnerId();
            List<ErpFunDepts> deptList = partner2DeptList.get(partnerId);
            List<Integer> deptIds = Optional.ofNullable(deptList).orElse(Collections.emptyList()).stream().map(ErpFunDepts::getDeptId).collect(Collectors.toList());
            //相关门店使用简称
            String names = Optional.ofNullable(deptList).orElse(Collections.emptyList()).stream().map(ErpFunDepts::getDeptCname).collect(Collectors.joining("、"));
            vo.setDeptIds(deptIds);
            vo.setDeptNames(names);
            if (null != userId2Po.get(vo.getUserId())) {
                ErpFunUsers user = userId2Po.get(vo.getUserId());
                vo.setUserName(user.getUserName());
                //联系电话
                if (StringUtils.isBlank(vo.getPartnerTele())) {
                    vo.setPartnerTele(user.getUserMobile());
                }
            }
            Optional.ofNullable(userId2Po.get(vo.getManagerUserId())).ifPresent((u)->vo.setManagerUserName(u.getUserName()));
        }
        //分页结果信息
        PageInfo<ErpFunPartner> pageInfoDto = new PageInfo<>(list);
        PageInfo<ErpFunPartnerVo> pageInfo = new PageInfo<>(resultList);
        pageInfo.setTotal(pageInfoDto.getTotal());
        pageInfo.setPages(pageInfoDto.getPages());
        pageInfo.setPageSize(pageInfoDto.getPageSize());
        pageInfo.setPageNum(pageInfoDto.getPageNum());
        return pageInfo;
    }

//---------------合同主体------------------------------------------------

    @ApiOperation(value = "修改保存合同主体")
    @PostMapping("/updateDealLinked")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "合同主体", response = ErpResponseJson.class)})
    public ErpResponseJson updateDealLinked(@RequestBody SaveDealLinkedParam param) {
        Operator op = getOperator();
        Integer partnerId = 0;//TODO一期暂时不隔离配置 二期放开分开配置
        ErpFunDealLinked dbDealLinked = erpFunDealLinkedMapper.selectByPartnerId(op.getCityId(), op.getCompId(), partnerId);
        if (Objects.isNull(dbDealLinked)) {
            //insert
            dbDealLinked = new ErpFunDealLinked();
            BeanUtils.copyProperties(param,dbDealLinked);
            dbDealLinked.setCompId(op.getCompId());
            dbDealLinked.setPartnerId(partnerId);
            dbDealLinked.setShardCityId(op.getCityId());
            erpFunDealLinkedMapper.insertSelective(dbDealLinked);
        }else {
            BeanUtils.copyProperties(param,dbDealLinked, BeanUtil.getNullPropertyNames(param));
            dbDealLinked.setCompId(op.getCompId());
            dbDealLinked.setPartnerId(partnerId);
            dbDealLinked.setShardCityId(op.getCityId());
            erpFunDealLinkedMapper.updateByPrimaryKeySelective(dbDealLinked);
        }
        //同步加盟商表
        if (partnerId > 0 &&(StringUtil.isNotBlank(param.getPartnerAddr()) || StringUtil.isNotBlank(param.getPartnerTele()))) {
            ErpFunPartner partner = new ErpFunPartner();
            partner.setShardCityId(op.getCityId());
            partner.setPartnerAddr(param.getPartnerAddr());
            partner.setPartnerTele(param.getPartnerTele());
            erpFunPartnerMapper.updateByPrimaryKeySelective(partner);
        }
        return ErpResponseJson.ok();
    }

    @ApiOperation(value = "查询合同主体")
    @PostMapping("/getDealLinked")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "查询合同主体", response = ErpFunDealLinked.class)})
    public ErpResponseJson getDealLinked(@RequestBody QueryDealLinkedDetailParam param) {
        Integer partnerId = param.getPartnerId();

        Operator operator = getOperator();
        ErpFunDealLinked dbDealLinked = erpFunDealLinkedMapper.selectByPartnerId(operator.getCityId(), operator.getCompId(), partnerId);
        FunDealLinkedVo vo = new FunDealLinkedVo();
        if (Objects.nonNull(dbDealLinked)) {
            BeanUtils.copyProperties(dbDealLinked, vo);
        }
        return ErpResponseJson.ok(vo);
    }

    private void checkPartnerName(Integer cityId,String partnerName) {
        if (Objects.isNull(partnerName)) {
            return;
        }
        if (partnerName.length() > 20) {
            throw new BusinessException("企业名称长度超出限制!");
        }
        int count = erpFunPartnerMapper.countPartnerName(cityId, partnerName);
        if (count > 0) {
            throw new BusinessException("企业名称已存在!");
        }
    }
    /**
     * 企业信用代码唯一
     *
     * @param code code
     */
    private void checkCreditCode(Integer cityId, String code) {
        if (Objects.isNull(code)) {
            return;
        }
        if (code.length() > 20) {
            throw new BusinessException("企业信用代码长度超出限制!");
        }
        int count = erpFunPartnerMapper.countEnterpriseCreditCode(cityId, code);
        if (count > 0) {
            throw new BusinessException("企业信用代码已被使用!");
        }
    }

    private void writeLog(String content, Operator op, ErpFunPartner old, ErpFunPartner updated, Integer partnerId) {
        String oldJson = JSON.toJSONString(old);
        String newJson = JSON.toJSONString(updated);
        ErpFunPartnerLog log = new ErpFunPartnerLog();
        log.setPartnerId(partnerId);
        log.setCompId(op.getCompId());
        log.setModular((byte) 0);
        log.setCreateUid(op.getUserId());
        log.setBeforeModification(oldJson);
        log.setAfterModification(newJson);
        log.setLogContent(content);
        log.setCreateTime(new Date());
        log.setShardCityId(op.getCityId());
        erpFunPartnerLogMapper.insertSelective(log);
    }

    private ErpFunPartnerVo toPartnerVo(ErpFunPartner partner) {
        ErpFunPartnerVo vo = new ErpFunPartnerVo();
        BeanUtils.copyProperties(partner, vo);
        vo.setPartnerId(partner.getId());
        return vo;
    }

    private void addCheckUsers(AddPartnerParam param, Operator op) {
        List<ErpFunPartner> list = erpFunPartnerMapper.selectByUserId(op.getCityId(), op.getCompId(), param.getUserId());
        if (!list.isEmpty()) {
            throw new BusinessException("负责人已负责或管理其他分组!");
        }
        list = erpFunPartnerMapper.selectByUserId(op.getCityId(), op.getCompId(), param.getManagerUserId());
        if (!list.isEmpty()) {
            throw new BusinessException("管理员已负责或管理其他分组!");
        }
    }

    private void updateCheckUsers(EditPartnerParam param, Operator op, ErpFunPartner record) {
        if (Objects.nonNull(param.getUserId()) && !Objects.equals(record.getUserId(), param.getUserId())) {
            ErpFunUsers user = erpFunUsersMapper.selectDataByUserId(op.getCityId(), op.getCompId(), param.getUserId());
            Assert.isNullThrow(user,"指定的负责人不存在,请重新选择!");
            List<ErpFunPartner> list = erpFunPartnerMapper.selectByUserId(op.getCityId(), op.getCompId(), param.getUserId());
            if (!list.isEmpty()) {
                throw new BusinessException("负责人已负责或管理其他分组!");
            }
        }
        if (Objects.nonNull(param.getManagerUserId()) && !Objects.equals(record.getManagerUserId(), param.getManagerUserId())) {
            ErpFunUsers user = erpFunUsersMapper.selectDataByUserId(op.getCityId(), op.getCompId(), param.getManagerUserId());
            Assert.isNullThrow(user,"指定的管理员不存在,请重新选择!");
            List<ErpFunPartner> list = erpFunPartnerMapper.selectByUserId(op.getCityId(), op.getCompId(), param.getManagerUserId());
            if (!list.isEmpty()) {
                throw new BusinessException("管理员已负责或管理其他分组!");
            }
        }
    }



}
