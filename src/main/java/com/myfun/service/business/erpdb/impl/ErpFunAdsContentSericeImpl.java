package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunAdsContentDto;
import com.myfun.repository.erpdb.param.FunAdsParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAdsContentService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpFunAdsContentSericeImpl extends AbstractService<ErpFunAdsContent, ErpFunAdsContent> implements ErpFunAdsContentService {
    @Autowired
    ErpFunAdsContentMapper erpFunAdsContentMapper;
    @Autowired
    ErpFunTrackMapper erpFunTrackMapper;
    @Autowired
    ErpFunSaleMapper erpFunSaleMapper;
    @Autowired
    ErpFunLeaseMapper erpFunLeaseMapper;
    @Autowired
    ErpFunUsersMapper erpFunUsersMapper;

    @Override
    @PostConstruct
    public void setBaseMapper() {
        super.baseMapper = erpFunAdsContentMapper;

    }

    @Override
    public PageInfo<ErpFunAdsContentDto> getAdsContentList(BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("compId", param.getInteger("compId"));
        pMap.put("date1", pMap.get("date1") + " 00:00:00");
        pMap.put("date2", pMap.get("date2") + " 23:59:59");
        PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
        List<ErpFunAdsContentDto> resList = erpFunAdsContentMapper.getAdsList(pMap, param.getInteger("cityId"));
        return new PageInfo<>(resList);
    }

    @Override
    public List<ErpFunAdsContentDto> getAdsCaseListForExport(BaseMapParam param) {
        Map<String, Object> pMap = param.getMap();
        pMap.put("compId", param.getInteger("compId"));
        pMap.put("date1", pMap.get("date1") + " 00:00:00");
        pMap.put("date2", pMap.get("date2") + " 23:59:59");
        List<ErpFunAdsContentDto> resList = erpFunAdsContentMapper.getAdsList(pMap, param.getInteger("cityId"));
        return resList;
    }

    @Transactional
    @Override
    public void creatFunAds(Integer cityId, FunAdsParam param) throws BusinessException {
        Integer updateResult = 0;
        Integer caseId = param.getCaseId();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("compId", param.getCompId());
        map.put("deptId", param.getDeptId());
        Integer count = erpFunAdsContentMapper.getPerCompAdsCaseCount(cityId, map);
        if (count < 2) {
            ErpFunAdsContent erpFunAdsContent = new ErpFunAdsContent();
            erpFunAdsContent.setShardCityId(cityId);
            erpFunAdsContent.setAdsContent(param.getAdsContent());
            erpFunAdsContent.setAdsStatus((byte) 1);
            erpFunAdsContent.setCaseType(param.getCaseType().byteValue());
            erpFunAdsContent.setUserId(param.getUserId());
            erpFunAdsContent.setCompId(param.getCompId());
            erpFunAdsContent.setCaseId(param.getCaseId());
            erpFunAdsContent.setCaseNo(param.getCaseNo());
            erpFunAdsContent.setDeptId(param.getDeptId());
            erpFunAdsContent.setCreationTime(new Date());
            erpFunAdsContent.setUserId(param.getUserId());
            erpFunAdsContent.setRecommendPrice(new BigDecimal(param.getRecommendPrice()));
            String newspaperTel = param.getNewspapperTel();
            if (newspaperTel != null) {
                if (newspaperTel.length() > 20) {
                    throw new BusinessException("手机号过长!");
                }
                if ("null".equals(newspaperTel) || "".equals(newspaperTel) || newspaperTel.length() == 0) {
                    newspaperTel = null;
                }
            }
            erpFunAdsContent.setNewspapperTel(newspaperTel);
            erpFunAdsContentMapper.insertSelective(erpFunAdsContent);

            if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType() + "")) {
                ErpFunSale erpFunSale = new ErpFunSale();
                erpFunSale.setShardCityId(cityId);
                erpFunSale.setSaleId(caseId);
                erpFunSale.setAdsFlag((byte) 1);
                updateResult = erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
            } else {
                ErpFunLease erpFunLease = new ErpFunLease();
                erpFunLease.setShardCityId(cityId);
                erpFunLease.setAdsFlag((byte) 1);
                erpFunLease.setLeaseId(caseId);
                updateResult = erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
            }
            /** 跟进日志 **/
            if (updateResult > 0) {
                String content = erpFunUsersMapper.getCurrUserName(cityId, param.getUserId(), param.getDeptId()) + " 将该房源设置为广告房源";
                ErpFunTrack createFunTrack = createFunTrack(cityId, param.getCompId(), param.getDeptId(), param.getUserId(), param.getCaseId(), param.getCaseType().intValue(),
                        erpFunAdsContent.getCaseNo(), content);
                erpFunTrackMapper.insertFunTrack(createFunTrack);
            }
        } else {
            throw new BusinessException("每个店只能操作两条广告房源!");
        }
    }

    /**
     * 撤销单个
     *
     * @param cityId
     * @param param
     * @throws Exception
     * @author 熊刚
     * @since 2017年6月20日
     */
    @Transactional
    @Override
    public void cancelFunAds(Integer cityId, FunAdsParam param) throws Exception {
        int adsFlag = 0;
        int caseId = param.getCaseId();
        Map<String, Object> map = new HashMap<String, Object>();
        String nowTime = DateUtil.DateToString(new Date());
        map.put("caseId", param.getCaseId());
        map.put("caseType", param.getCaseType());
        map.put("cancleTime", nowTime);
        map.put("compId", param.getCompId());
        map.put("adsFlag", 0);
        erpFunAdsContentMapper.updateAds(cityId, map);
        if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType().toString())) {
            ErpFunSale erpFunSale = new ErpFunSale();
            erpFunSale.setShardCityId(cityId);
            erpFunSale.setSaleId(caseId);
            erpFunSale.setAdsFlag((byte) 0);
            erpFunSaleMapper.updateByPrimaryKeySelective(erpFunSale);
        } else {
            ErpFunLease erpFunLease = new ErpFunLease();
            erpFunLease.setShardCityId(cityId);
            erpFunLease.setAdsFlag((byte) 0);
            erpFunLease.setLeaseId(caseId);
            erpFunLeaseMapper.updateByPrimaryKeySelective(erpFunLease);
        }
        String content = erpFunUsersMapper.getCurrUserName(cityId, param.getUserId(), param.getDeptId()) + " 撤销该广告房源";
        ErpFunTrack erpFunTrack = createFunTrack(cityId, param.getCompId(), param.getDeptId(), param.getUserId(), param.getCaseId(),
                param.getCaseType(), param.getCaseNo(), content);
        erpFunTrackMapper.insertFunTrack(erpFunTrack);
    }

    /**
     * 选择撤销
     *
     * @param cityId
     * @param param
     * @throws Exception
     * @author 熊刚
     * @since 2017年6月20日
     */
    @Transactional
    @Override
    public void cancelListFunAds(Integer cityId, FunAdsParam param) throws Exception {
        Integer updateResult = 0;
        int adsFlag = 0;
        List<String> caseIdList = new ArrayList<>();
        caseIdList.add(param.getCaseId().toString());
        String adsContentIds = param.getAdsContentIds();

        String[] arr = adsContentIds.split(",");

        if (null == arr || arr.length <= 0) {
            return;
        }

        List<String> adsContentIdList = Arrays.asList(arr);
        Date date = DateTimeHelper.getSystemDate();
        String nowTime = DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMddHHmmssS);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("caseId", param.getCaseId());
        map.put("caseType", param.getCaseType());
        map.put("cancleTime", nowTime);
        map.put("adsContentIds", adsContentIds);
        map.put("adsContentIdList", adsContentIdList);
        erpFunAdsContentMapper.updateAdsList(cityId, map, adsContentIdList);
        if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(param.getCaseType() + "")) {
            List<ErpFunAdsContent> erpFunAdsContentList = erpFunAdsContentMapper.getAdsSaleLists(cityId, adsContentIdList);
            for (ErpFunAdsContent erpFunAdsContent : erpFunAdsContentList) {
                String content = erpFunUsersMapper.getCurrUserName(cityId, param.getUserId(), param.getDeptId()) + " 撤销该广告房源";
                ErpFunTrack erpFunTrack = createFunTrack(cityId, param.getCompId(), param.getDeptId(), param.getUserId(), param.getCaseId(), param.getCaseType().intValue(), param.getCaseNo(), content);
                erpFunTrackMapper.insertFunTrack(erpFunTrack);
            }
            updateResult = erpFunSaleMapper.updateFunAsdSalHouseList(cityId, caseIdList, adsFlag);
        } else {
            List<ErpFunAdsContent> erpFunAdsContentList = erpFunAdsContentMapper.getAdsSaleLists(cityId, adsContentIdList);
            for (ErpFunAdsContent erpFunAdsContent : erpFunAdsContentList) {
                String content = erpFunUsersMapper.getCurrUserName(cityId, param.getUserId(), param.getDeptId()) + " 撤销该广告房源";
                ErpFunTrack erpFunTrack = createFunTrack(cityId, param.getCompId(), param.getDeptId(), param.getUserId(), param.getCaseId(), param.getCaseType().intValue(),
                        param.getCaseNo(), content);
                erpFunTrackMapper.insertFunTrack(erpFunTrack);

            }
            updateResult = erpFunLeaseMapper.updateFunAsdleaseHouseList(cityId, caseIdList, adsFlag);
        }
    }

    /**
     * 撤销全部
     *
     * @param cityId
     * @param param
     * @throws Exception
     * @author 熊刚
     * @since 2017年6月20日
     */
    @Transactional
    @Override
    public void cancelAllFunAds(Integer cityId, FunAdsParam param) throws Exception {
        Integer updateResult = 0;
        int adsFlag = 0;
        List<String> caseIdList = new ArrayList<>();
        caseIdList.add(param.getCaseId().toString());
        Date date = DateTimeHelper.getSystemDate();
        String nowTime = DateTimeHelper.formatDateTimetoString(date, DateTimeHelper.FMT_yyyyMMddHHmmssS);
        if (StringUtil.isNotBlank(param.getDate1()) && StringUtil.isNotBlank(param.getDate2())) {
            param.setDate1(param.getDate1() + " 00:00:00");
            param.setDate2(param.getDate2() + " 23:59:59");
        }
        param.setOperateType("OPERATE_USER");
        List<ErpFunAdsContent> erpFunAdsContentList = erpFunAdsContentMapper.getAdsLists(cityId, param);
        if (1 == param.getCaseType()) {
            for (ErpFunAdsContent erpFunAdsContent : erpFunAdsContentList) {
                String content = erpFunUsersMapper.getCurrUserName(cityId, param.getUserId(), param.getDeptId()) + " 撤销该广告房源";
                ErpFunTrack erpFunTrack = createFunTrack(cityId, param.getCompId(), param.getDeptId(), param.getUserId(), param.getCaseId(),
                        param.getCaseType().intValue(), param.getCaseNo(), content);

                erpFunTrackMapper.insertFunTrack(erpFunTrack);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("caseId", erpFunAdsContent.getCaseId());
                map.put("caseType", param.getCaseType());
                map.put("cancleTime", nowTime);
                map.put("adsFlag", 0);
                map.put("adsContentId", erpFunAdsContent.getAdsContentId());
                erpFunAdsContentMapper.updateAdsByprimaryKey(cityId, map);
            }
            updateResult = erpFunSaleMapper.updateFunAsdSalHouseList(cityId, caseIdList, adsFlag);
        } else {
            for (ErpFunAdsContent erpFunAdsContent : erpFunAdsContentList) {
                String content = erpFunUsersMapper.getCurrUserName(cityId, param.getUserId(), param.getDeptId()) + " 撤销该广告房源";
                ErpFunTrack erpFunTrack = createFunTrack(cityId, param.getCompId(), param.getDeptId(), param.getUserId(), param.getCaseId(), param.getCaseType().intValue(), param.getCaseNo(), content);
                erpFunTrackMapper.insertFunTrack(erpFunTrack);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("caseId", param.getCaseId());
                map.put("caseType", param.getCaseType());
                map.put("cancleTime", nowTime);
                map.put("adsFlag", 0);
                map.put("adsContentId", erpFunAdsContent.getAdsContentId());
                erpFunAdsContentMapper.updateAdsByprimaryKey(cityId, map);
            }
            updateResult = erpFunLeaseMapper.updateFunAsdleaseHouseList(cityId, caseIdList, adsFlag);
        }
    }

    /**
     * @tag 修改广告语表
     * @author 邓永洪
     * @since 2018/5/31
     */
    public int cancleAdsContent(Integer cityId, Integer caseId, Integer caseType) {
        ErpFunAdsContentExample adsContentExample = new ErpFunAdsContentExample();
        adsContentExample.setShardCityId(cityId);
        adsContentExample.createCriteria().andCaseIdEqualTo(caseId).andCaseTypeEqualTo(caseType.byteValue());
        ErpFunAdsContent updateModel = new ErpFunAdsContent();
        updateModel.setAdsStatus(Const.DIC_ADS_CASE_STATUS_0);
        updateModel.setCancleTime(new Date());
        return erpFunAdsContentMapper.updateByExampleSelective(updateModel, adsContentExample);
    }

    /**
     * 跟进日志
     **/
    private ErpFunTrack createFunTrack(Integer cityId, Integer compId, Integer deptId, Integer userId, Integer caseId, Integer caseType, String caseNo, String content) {
        Integer caseUserId = null, caseDeptId = null;
        if (Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType + "")) {
            ErpFunSale erpFunSale = erpFunSaleMapper.getFunSaleBySaleId(cityId, caseId);
            if (null != erpFunSale) {
                caseUserId = erpFunSale.getUserId();
                caseDeptId = erpFunSale.getDeptId();
            }
        } else if (Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType + "")) {
            ErpFunLease erpFunLease = erpFunLeaseMapper.getFunLeaseByLeaseId(cityId, caseId);
            if (null != erpFunLease) {
                caseUserId = erpFunLease.getUserId();
                caseDeptId = erpFunLease.getDeptId();
            }
        }
        ErpFunTrack erpFunTrack = new ErpFunTrack();
        erpFunTrack.setCaseId(caseId);
        erpFunTrack.setCaseNo(caseNo);
        erpFunTrack.setCreationTime(DateUtil.getTime(new Date()));
        erpFunTrack.setCreatorUid(userId);
        erpFunTrack.setCompId(compId);
        erpFunTrack.setDeptId(deptId);
        erpFunTrack.setTrackContent(content);
        erpFunTrack.setTrackType(Const.DIC_TRACK_TYPE_ADSCASE);
        erpFunTrack.setCaseType(caseType.byteValue());
        erpFunTrack.setCaseUserId(caseUserId);
        erpFunTrack.setCaseDeptId(caseDeptId);
        erpFunTrack.setTrackWarm(false);
        erpFunTrack.setTrackClassic(Const.DIC_TASK_SUBJECT_HEAD_24);
        erpFunTrack.setShardCityId(cityId);
        return erpFunTrack;
    }

}
