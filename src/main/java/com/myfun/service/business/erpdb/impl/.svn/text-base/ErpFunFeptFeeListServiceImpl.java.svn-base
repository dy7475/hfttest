package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.erpWeb.managecenter.financialStatements.param.UpdateDeptFeeStatusParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunDeptFeeListMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptFeeRecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsgroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dto.ErpFunDeptFeeListDto;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeListParam;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeModifyParam;
import com.myfun.repository.erpdb.param.ErpFunDeptFeeParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDeptFeeListService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpFunFeptFeeListServiceImpl extends AbstractService<ErpFunDeptFeeList, ErpFunDeptFeeList> implements ErpFunDeptFeeListService {
    @Autowired
    private ErpFunDeptFeeListMapper erpFunDeptFeeListMapper;
    @Autowired
    private ErpFunDeptsMapper erpFunDeptsMapper;
    @Autowired
    private ErpFunDeptFeeRecordMapper erpFunDeptFeeRecordMapper;
    @Autowired
    private ErpFunUsersService erpFunUsersService;
    @Autowired
    private ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
    @Autowired
    private ErpFunOrganizationMapper erpFunOrganizationMapper;
    @Autowired
    private ErpFunUsersMapper erpFunUsersMapper;

    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpFunDeptFeeListMapper;
    }

    /**
     * 添加门店费用
     *
     * @param
     * @return
     * @author 李成兵
     * @since 2018/6/9
     */
    @Transactional
    @Override
    public void addFunDeptFee(Integer cityId, Integer compId, Integer userId, String userName, Integer currentUserDeptId, ErpFunDeptFeeListParam param) {
        List<ErpFunDepts> deptListByDeptIds = new ArrayList<>();
        Set<Integer> deptIdList = new HashSet<>();
        if (StringUtils.isBlank(param.getDeptIds()) && StringUtils.isNotBlank(param.getGrIds())) {
            // 跟进分组ID查找门店列表
            List<String> grIds = Arrays.asList(param.getGrIds().split(","));
            // grIdSet
            Set<Integer> grIdSet = grIds.stream().map(Integer::valueOf).collect(Collectors.toSet());

            List<ErpFunDeptsgroup> erpFunDeptsgroups = erpFunDeptsgroupMapper.getGroupListByGrIdSet(cityId, compId, grIdSet);


            deptIdList = erpFunDeptsgroups.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toSet()));

            deptListByDeptIds = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdList);

            // 查询门店列表
            Map<Integer, ErpFunDepts> funDeptsMap = deptListByDeptIds.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val));

            // 解析门店费用(id,name,amount)
            List<ErpFunDeptFeeParam> erpFunDeptFees = JSON.parseObject(param.getDeptFeeList(), new TypeReference<List<ErpFunDeptFeeParam>>() {
            });

            if (erpFunDeptFees.size() == 0) {
                throw new BusinessException("请选择费用");
            }

            erpFunDeptsgroups.forEach(deptsgroup -> {
                ErpFunDepts erpFunDepts = funDeptsMap.get(deptsgroup.getDeptId());
                if (null == erpFunDepts) {
                    return;
                }

                erpFunDeptFees.forEach(funDeptFee -> {
                    ErpFunDeptFeeList erpFunDeptFeeList = new ErpFunDeptFeeList();
                    erpFunDeptFeeList.setCompId(compId);
                    erpFunDeptFeeList.setAreaId(erpFunDepts.getAreaId());
                    erpFunDeptFeeList.setRegId(erpFunDepts.getRegId());
                    erpFunDeptFeeList.setDeptId(deptsgroup.getDeptId());
                    erpFunDeptFeeList.setAuditStatus((byte) 0);
                    erpFunDeptFeeList.setCountTime(DateUtil.StringToDate(param.getCountTimeStr()));
                    erpFunDeptFeeList.setCreateTime(new Date());
                    erpFunDeptFeeList.setCreateUid(userId);
                    erpFunDeptFeeList.setGrId(deptsgroup.getGrId());
                    erpFunDeptFeeList.setFeeId(funDeptFee.getFeeId());
                    erpFunDeptFeeList.setFeeName(funDeptFee.getFeeName());
                    erpFunDeptFeeList.setFeeAmount(funDeptFee.getFeeAmount());
                    erpFunDeptFeeList.setFeeNote(param.getFeeNote());
                    erpFunDeptFeeList.setShardCityId(cityId);
                    //对字段做空处理
                    String billPicUrl = funDeptFee.getBillPicUrl();
                    if (billPicUrl != null) {
                        if ("null".equals(billPicUrl) || "".equals(billPicUrl) || billPicUrl.length() == 0) {
                            billPicUrl = null;
                        }
                    }
                    erpFunDeptFeeList.setBillPicUrl(billPicUrl);
                    erpFunDeptFeeList.setPartnerId(param.getPartnerId());
                    erpFunDeptFeeListMapper.insertSelective(erpFunDeptFeeList);
                    // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
                    String currUserName = erpFunUsersService.getCurrUserName(cityId, userId, deptsgroup.getDeptId());
                    currUserName += " 新增了门店费用";
                    insertRecord(cityId, compId, deptsgroup.getDeptId(), deptsgroup.getGrId(), erpFunDeptFeeList.getFeeDetailListId(), currUserName, (byte) 4, userId, userName);
                });
            });
        } else if (StringUtils.isNotBlank(param.getDeptIds()) && StringUtils.isBlank(param.getGrIds())) {
            List<String> deptStrList = Arrays.asList(param.getDeptIds().split(","));
            deptIdList = deptStrList.stream().map(Integer::valueOf).collect(Collectors.toSet());
            deptListByDeptIds = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdList);


            // 查询门店列表

            Map<Integer, ErpFunDepts> funDeptsMap = deptListByDeptIds.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val));

            // 解析门店费用(id,name,amount)
            List<ErpFunDeptFeeParam> erpFunDeptFees = JSON.parseObject(param.getDeptFeeList(), new TypeReference<List<ErpFunDeptFeeParam>>() {
            });

            if (erpFunDeptFees.size() == 0) {
                throw new BusinessException("请选择费用");
            }

            deptIdList.forEach(deptId -> {
                ErpFunDepts erpFunDepts = funDeptsMap.get(deptId);
                if (null == erpFunDepts) {
                    return;
                }

                erpFunDeptFees.forEach(funDeptFee -> {
                    ErpFunDeptFeeList erpFunDeptFeeList = new ErpFunDeptFeeList();
                    erpFunDeptFeeList.setCompId(compId);
                    erpFunDeptFeeList.setAreaId(erpFunDepts.getAreaId());
                    erpFunDeptFeeList.setRegId(erpFunDepts.getRegId());
                    erpFunDeptFeeList.setDeptId(deptId);
                    erpFunDeptFeeList.setAuditStatus((byte) 0);
                    erpFunDeptFeeList.setCountTime(DateUtil.StringToDate(param.getCountTimeStr()));
                    erpFunDeptFeeList.setCreateTime(new Date());
                    erpFunDeptFeeList.setCreateUid(userId);
                    erpFunDeptFeeList.setGrId(funDeptFee.getGrId());
                    erpFunDeptFeeList.setFeeId(funDeptFee.getFeeId());
                    erpFunDeptFeeList.setFeeName(funDeptFee.getFeeName());
                    erpFunDeptFeeList.setFeeAmount(funDeptFee.getFeeAmount());
                    erpFunDeptFeeList.setFeeNote(param.getFeeNote());
                    erpFunDeptFeeList.setShardCityId(cityId);
                    //对字段做空处理
                    String billPicUrl = funDeptFee.getBillPicUrl();
                    if (billPicUrl != null) {
                        if ("null".equals(billPicUrl) || "".equals(billPicUrl) || billPicUrl.length() == 0) {
                            billPicUrl = null;
                        }
                    }
                    erpFunDeptFeeList.setBillPicUrl(billPicUrl);
                    erpFunDeptFeeList.setPartnerId(param.getPartnerId());
                    erpFunDeptFeeListMapper.insertSelective(erpFunDeptFeeList);
                    // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
                    String currUserName = erpFunUsersService.getCurrUserName(cityId, userId, deptId);
                    currUserName += " 新增了门店费用";
                    insertRecord(cityId, compId, deptId, funDeptFee.getGrId(), erpFunDeptFeeList.getFeeDetailListId(), currUserName, (byte) 4, userId, userName);
                });
            });
        } else {
            throw new BusinessException("请选择需要增加费用的门店或分组");
        }
    }

    /**
     * 门店费用批量导入
     *
     * @param
     * @return
     * @auther 胡坤
     * @since 2018/7/17
     */
    @Transactional
    @Override
    public Integer importDeptFee(Integer cityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeListParam param, Integer partnerId) {
        String deptFeeListJson = param.getDeptFeeListJson();
        List<ErpFunDepts> deptListByDeptIds = new ArrayList<>();
        Set<Integer> deptIdList = new HashSet<>();
        Integer index = 0;

        if (deptFeeListJson != null) {
            List<ErpFunDeptFeeListDto> list = JSON.parseArray(deptFeeListJson, ErpFunDeptFeeListDto.class);
            for (ErpFunDeptFeeListDto erpFunDeptFeeListDto : list) {
                if (StringUtils.isBlank(erpFunDeptFeeListDto.getDeptIds()) && StringUtils.isNotBlank(erpFunDeptFeeListDto.getGrIds())) {
                    // 跟进分组ID查找门店列表
                    List<String> grIds = Arrays.asList(erpFunDeptFeeListDto.getGrIds().split(","));
                    // grIdSet
                    Set<Integer> grIdSet = grIds.stream().map(Integer::valueOf).collect(Collectors.toSet());

                    List<ErpFunDeptsgroup> erpFunDeptsgroups = erpFunDeptsgroupMapper.getGroupListByGrIdSet(cityId, compId, grIdSet);

                    deptIdList = erpFunDeptsgroups.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toSet()));

                    deptListByDeptIds = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdList);

                    // 查询门店列表
                    Map<Integer, ErpFunDepts> funDeptsMap = deptListByDeptIds.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, val -> val));

                    for (ErpFunDeptsgroup erpFunDeptsgroup : erpFunDeptsgroups) {
                        ErpFunDepts erpFunDepts = funDeptsMap.get(erpFunDeptsgroup.getDeptId());
                        if (null == erpFunDepts) {
                            continue;
                        }
                        //非本公司门店不导入
                        if (!erpFunDepts.getCompId().equals(compId)) {
                            continue;
                        }
                        ErpFunDeptFeeList erpFunDeptFeeList = new ErpFunDeptFeeList();
                        erpFunDeptFeeList.setCompId(compId);
                        erpFunDeptFeeList.setAreaId(erpFunDepts.getAreaId());
                        erpFunDeptFeeList.setRegId(erpFunDepts.getRegId());
                        erpFunDeptFeeList.setDeptId(erpFunDeptsgroup.getDeptId());
                        erpFunDeptFeeList.setAuditStatus((byte) 0);
                        erpFunDeptFeeList.setStatus((byte) 0);
                        erpFunDeptFeeList.setCountTime(DateUtil.StringToDate(erpFunDeptFeeListDto.getCountTimeStr()));
                        erpFunDeptFeeList.setCreateTime(new Date());
                        erpFunDeptFeeList.setCreateUid(userId);
                        erpFunDeptFeeList.setGrId(erpFunDeptsgroup.getGrId());
                        erpFunDeptFeeList.setFeeAmount(erpFunDeptFeeListDto.getFeeAmount());
                        erpFunDeptFeeList.setFeeId(erpFunDeptFeeListDto.getFeeId());
                        erpFunDeptFeeList.setFeeName(erpFunDeptFeeListDto.getFeeName());
                        erpFunDeptFeeList.setFeeNote(erpFunDeptFeeListDto.getFeeNote());
                        erpFunDeptFeeList.setShardCityId(cityId);
                        //对字段做空处理
                        String billPicUrl = erpFunDeptFeeListDto.getBillPicUrl();
                        if (billPicUrl != null) {
                            if ("null".equals(billPicUrl) || "".equals(billPicUrl) || billPicUrl.length() == 0) {
                                billPicUrl = null;
                            }
                        }
                        erpFunDeptFeeList.setBillPicUrl(billPicUrl);
                        erpFunDeptFeeList.setPartnerId(partnerId);
                        erpFunDeptFeeListMapper.insertSelective(erpFunDeptFeeList);
                        // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
                        String currUserName = erpFunUsersService.getCurrUserName(cityId, userId, erpFunDeptsgroup.getDeptId());
                        currUserName += " 新增了门店费用";
                        insertRecord(cityId, compId, erpFunDeptsgroup.getDeptId(), erpFunDeptsgroup.getGrId(), erpFunDeptFeeList.getFeeDetailListId(), currUserName, (byte) 4, userId, userName);
                        index++;
                    }
                } else if (StringUtils.isNotBlank(erpFunDeptFeeListDto.getDeptIds()) && StringUtils.isBlank(erpFunDeptFeeListDto.getGrIds())) {
                    List<String> deptStrList = Arrays.asList(erpFunDeptFeeListDto.getDeptIds().split(","));
                    deptIdList = deptStrList.stream().map(Integer::valueOf).collect(Collectors.toSet());
                    deptListByDeptIds = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIdList);

                    for (ErpFunDepts erpFunDepts : deptListByDeptIds) {
                        //非本公司门店不导入
                        if (!erpFunDepts.getCompId().equals(compId)) {
                            continue;
                        }
                        ErpFunDeptFeeList erpFunDeptFeeList = new ErpFunDeptFeeList();
                        erpFunDeptFeeList.setCompId(compId);
                        erpFunDeptFeeList.setAreaId(erpFunDepts.getAreaId());
                        erpFunDeptFeeList.setRegId(erpFunDepts.getRegId());
                        erpFunDeptFeeList.setDeptId(erpFunDepts.getDeptId());
                        erpFunDeptFeeList.setAuditStatus((byte) 0);
                        erpFunDeptFeeList.setStatus((byte) 0);
                        erpFunDeptFeeList.setCountTime(DateUtil.StringToDate(erpFunDeptFeeListDto.getCountTimeStr()));
                        erpFunDeptFeeList.setCreateTime(new Date());
                        erpFunDeptFeeList.setCreateUid(userId);
                        erpFunDeptFeeList.setFeeAmount(erpFunDeptFeeListDto.getFeeAmount());
                        erpFunDeptFeeList.setFeeId(erpFunDeptFeeListDto.getFeeId());
                        erpFunDeptFeeList.setFeeName(erpFunDeptFeeListDto.getFeeName());
                        erpFunDeptFeeList.setFeeNote(erpFunDeptFeeListDto.getFeeNote());
                        erpFunDeptFeeList.setShardCityId(cityId);
                        //对字段做空处理
                        String billPicUrl = erpFunDeptFeeListDto.getBillPicUrl();
                        if (billPicUrl != null) {
                            if ("null".equals(billPicUrl) || "".equals(billPicUrl) || billPicUrl.length() == 0) {
                                billPicUrl = null;
                            }
                        }
                        erpFunDeptFeeList.setBillPicUrl(billPicUrl);
                        erpFunDeptFeeList.setPartnerId(partnerId);
                        erpFunDeptFeeListMapper.insertSelective(erpFunDeptFeeList);
                        // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
                        String currUserName = erpFunUsersService.getCurrUserName(cityId, userId, erpFunDepts.getDeptId());
                        currUserName += " 新增了门店费用";
                        insertRecord(cityId, compId, erpFunDepts.getDeptId(), null, erpFunDeptFeeList.getFeeDetailListId(), currUserName, (byte) 4, userId, userName);
                        index++;
                    }
                } else {
                    throw new BusinessException("导入门店或分组编号不能为空");
                }
            }
        }
        return index;
    }

    /**
     * 门店费用修改
     *
     * @param
     * @return
     * @auther 黎桂良
     * @since 2019/7/27
     */
    @Transactional
    @Override
    public Integer modifyDeptFee(Integer shardCityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeModifyParam param) {
        Integer feeDetailListId = param.getFeeDetailListId();

        Date countTime = DateTimeHelper.parseToDate(param.getCountTimeStr());
        BigDecimal feeAmount = param.getFeeAmount();

        String feeNote = param.getFeeNote();

        return erpFunDeptFeeListMapper.updateInfoByPrimaryKey(shardCityId, countTime, feeAmount, feeNote, feeDetailListId);
    }

    /**
     * 门店费用修改票据地址
     *
     * @param
     * @return
     * @auther 黎桂良
     * @since 2019/7/27
     */
    @Transactional
    @Override
    public Integer updateDeptFeeBillPic(Integer shardCityId, Integer compId, Integer userId, String userName, Integer deptId, ErpFunDeptFeeModifyParam param) {
        Integer feeDetailListId = param.getFeeDetailListId();

        String billPicUrl = param.getBillPicUrl();
        //空处理
        if (billPicUrl != null) {
            if ("null".equals(billPicUrl) || "".equals(billPicUrl) || billPicUrl.length() == 0) {
                billPicUrl = null;
            }
        }
        return erpFunDeptFeeListMapper.updateDeptFeeBillPic(shardCityId, billPicUrl, feeDetailListId);
    }

    @Override
    public Integer auditDeptFee(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, ErpFunDeptFeeListParam param) {
        String deptFeeListId = param.getDeptFeeListIds();
        if (StringUtils.isBlank(deptFeeListId)) {
            throw new BusinessException("请选择审核项");
        }
        List<String> deptFeeListIdsStr = Arrays.asList(deptFeeListId.split(","));
        Set<Integer> deptFeeListIdSet = deptFeeListIdsStr.stream().map(Integer::valueOf).collect(Collectors.toSet());
        // 反审核
        param.setDeptFeeListIdSet(deptFeeListIdSet);
        String opTypeStr = "";
        Byte opType = null;
        if (0 == param.getAuditStatus()) {
            opTypeStr = "撤销审核";
            opType = 3;
        } else if (1 == param.getAuditStatus()) {
            opTypeStr = "审核";
            opType = 2;
            // 审核
            param.setAuditTime(new Date());
            param.setAuditUid(userId);
            param.setAuditUserName(userName);
        }

        ErpFunDeptFeeListExample erpFunDeptFeeListExample = new ErpFunDeptFeeListExample();
        erpFunDeptFeeListExample.setShardCityId(cityId);
        erpFunDeptFeeListExample.createCriteria().andFeeDetailListIdIn(new ArrayList<>(deptFeeListIdSet));
        List<ErpFunDeptFeeList> erpFunDeptFeeLists = erpFunDeptFeeListMapper.selectByExample(erpFunDeptFeeListExample);
        Map<Integer, ErpFunDeptFeeList> collect = erpFunDeptFeeLists.stream().collect(Collectors.toMap(ErpFunDeptFeeList::getFeeDetailListId, val -> val));


        for (Integer feeListId : deptFeeListIdSet) {
            ErpFunDeptFeeList erpFunDeptFeeList = collect.get(feeListId);
            // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
            String currUserName = erpFunUsersService.getCurrUserName(cityId, userId, deptId);
            currUserName += " " + opTypeStr + "了门店费用";
            insertRecord(cityId, compId, erpFunDeptFeeList.getDeptId(), null, feeListId, currUserName, opType, userId, userName);
        }

        return erpFunDeptFeeListMapper.audtiDeptFeeById(cityId, param);
    }

    @Override
    public Integer updateDeptFee(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, UpdateDeptFeeStatusParam param, Integer partnerId) {
        String deptFeeListId = param.getDeptFeeListIds();
        if (StringUtils.isBlank(deptFeeListId)) {
            throw new BusinessException("请选择要删除的项");
        }
        List<String> deptFeeListIdsStr = Arrays.asList(deptFeeListId.split(","));
        Set<Integer> deptFeeListIdSet = deptFeeListIdsStr.stream().map(Integer::valueOf).collect(Collectors.toSet());
        param.setDeptFeeListIdSet(deptFeeListIdSet);


        ErpFunDeptFeeListExample erpFunDeptFeeListExample = new ErpFunDeptFeeListExample();
        erpFunDeptFeeListExample.setShardCityId(cityId);

        erpFunDeptFeeListExample.createCriteria().andFeeDetailListIdIn(new ArrayList<>(deptFeeListIdSet)).andPartnerIdEqualTo(partnerId);

        ErpFunDeptFeeList erpFunDeptFeeList = new ErpFunDeptFeeList();
        erpFunDeptFeeList.setStatus(param.getStatus());


        ErpFunDeptFeeListExample erpFunDeptFeeListExample2 = new ErpFunDeptFeeListExample();
        erpFunDeptFeeListExample2.setShardCityId(cityId);
        erpFunDeptFeeListExample2.createCriteria().andFeeDetailListIdIn(new ArrayList<>(deptFeeListIdSet)).andPartnerIdEqualTo(partnerId);
        List<ErpFunDeptFeeList> erpFunDeptFeeLists = erpFunDeptFeeListMapper.selectByExample(erpFunDeptFeeListExample2);
        Map<Integer, ErpFunDeptFeeList> collect = erpFunDeptFeeLists.stream().collect(Collectors.toMap(ErpFunDeptFeeList::getFeeDetailListId, val -> val));

        for (Integer feeListId : deptFeeListIdSet) {
            ErpFunDeptFeeList erpFunDeptFeeList1 = collect.get(feeListId);
            // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
            String currUserName = erpFunUsersService.getCurrUserName(cityId, userId, deptId);
            currUserName += " 删除了门店费用";
            insertRecord(cityId, compId, erpFunDeptFeeList1.getDeptId(), erpFunDeptFeeList1.getGrId(), feeListId, currUserName, (byte) 5, userId, userName);
        }


        return erpFunDeptFeeListMapper.updateByExampleSelective(erpFunDeptFeeList, erpFunDeptFeeListExample);

    }


    private void insertRecord(Integer cityId, Integer compId, Integer deptId, Integer grId, Integer feeListId, String content, Byte recordType, Integer userId, String userName) {
        // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
        ErpFunDeptFeeRecord erpFunDeptFeeRecord = new ErpFunDeptFeeRecord();
        erpFunDeptFeeRecord.setShardCityId(cityId);
        erpFunDeptFeeRecord.setCompId(compId);
        erpFunDeptFeeRecord.setCreationTime(new Date());
        erpFunDeptFeeRecord.setDeptFeeId(feeListId);
        erpFunDeptFeeRecord.setRecordContent(content);
        erpFunDeptFeeRecord.setRecordType(recordType);
        erpFunDeptFeeRecord.setUserId(userId);
        erpFunDeptFeeRecord.setUserName(userName);
        erpFunDeptFeeRecord.setDeptId(deptId);
        erpFunDeptFeeRecord.setGrId(grId);
        erpFunDeptFeeRecordMapper.insertSelective(erpFunDeptFeeRecord);
    }
    
    private void insertRecord4NewOrg(Integer cityId, Integer compId, Integer deptId, Integer grId, Integer feeListId, String content, Byte recordType, Integer userId, String userName, Integer orgId) {
    	// 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
    	ErpFunDeptFeeRecord erpFunDeptFeeRecord = new ErpFunDeptFeeRecord();
    	erpFunDeptFeeRecord.setShardCityId(cityId);
    	erpFunDeptFeeRecord.setCompId(compId);
    	erpFunDeptFeeRecord.setCreationTime(new Date());
    	erpFunDeptFeeRecord.setDeptFeeId(feeListId);
    	erpFunDeptFeeRecord.setRecordContent(content);
    	erpFunDeptFeeRecord.setRecordType(recordType);
    	erpFunDeptFeeRecord.setUserId(userId);
    	erpFunDeptFeeRecord.setUserName(userName);
    	erpFunDeptFeeRecord.setDeptId(deptId);
    	erpFunDeptFeeRecord.setGrId(grId);
    	erpFunDeptFeeRecord.setOrganizationId(orgId);
    	erpFunDeptFeeRecordMapper.insertSelective(erpFunDeptFeeRecord);
    }

	@Override
	public void addOrganizationFee(Integer cityId, Integer compId, Integer userId, String userName, Integer deptId,
			ErpFunDeptFeeListParam param) {
		if(StringUtil.isNotBlank(param.getOrganizationIds())){
			String[] organizationIdList = param.getOrganizationIds().split(",");
			List<Integer> idList = new ArrayList<>();
			for (String id : organizationIdList) {
				idList.add(StringUtil.parseInteger(id));
			}
			
			ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
			erpFunOrganizationExample.createCriteria().andOrganizationIdIn(idList);
			List<ErpFunOrganization> erpFunOrganizations = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
			
			List<ErpFunDeptFeeParam> erpFunDeptFees = JSON.parseObject(param.getDeptFeeList(), new TypeReference<List<ErpFunDeptFeeParam>>() {});
			erpFunOrganizations.forEach(organization -> {
				erpFunDeptFees.forEach(funDeptFee -> {
					ErpFunDeptFeeList erpFunDeptFeeList = new ErpFunDeptFeeList();
                    erpFunDeptFeeList.setCompId(compId);
                    //erpFunDeptFeeList.setAreaId(erpFunDepts.getAreaId());
                    //erpFunDeptFeeList.setRegId(erpFunDepts.getRegId());
                    //erpFunDeptFeeList.setDeptId(deptsgroup.getDeptId());
                    erpFunDeptFeeList.setAuditStatus((byte) 0);
                    erpFunDeptFeeList.setCountTime(DateUtil.StringToDate(param.getCountTimeStr()));
                    erpFunDeptFeeList.setCreateTime(new Date());
                    erpFunDeptFeeList.setCreateUid(userId);
                    //erpFunDeptFeeList.setGrId(deptsgroup.getGrId());
                    erpFunDeptFeeList.setFeeId(funDeptFee.getFeeId());
                    erpFunDeptFeeList.setFeeName(funDeptFee.getFeeName());
                    erpFunDeptFeeList.setFeeAmount(funDeptFee.getFeeAmount());
                    erpFunDeptFeeList.setFeeNote(param.getFeeNote());
                    erpFunDeptFeeList.setShardCityId(cityId);
                    erpFunDeptFeeList.setOrganizationPath(organization.getOrganizationPath());
                    //对字段做空处理
                    String billPicUrl = funDeptFee.getBillPicUrl();
                    if (billPicUrl != null) {
                        if ("null".equals(billPicUrl) || "".equals(billPicUrl) || billPicUrl.length() == 0) {
                            billPicUrl = null;
                        }
                    }
                    erpFunDeptFeeList.setBillPicUrl(billPicUrl);
                    erpFunDeptFeeList.setPartnerId(param.getPartnerId());
                    erpFunDeptFeeListMapper.insertSelective(erpFunDeptFeeList);
                    // 写一条日志 1:修改 2:审核 3:反审核 4：新增 5删除
                    String currUserName = erpFunUsersService.getCurrUserName(cityId, userId, null);
                    currUserName += " 新增了门店费用";
                    insertRecord4NewOrg(cityId, compId, null, null, erpFunDeptFeeList.getFeeDetailListId(), currUserName, (byte) 4, userId, userName, organization.getOrganizationId());
				});
			});
		}
	}
}
