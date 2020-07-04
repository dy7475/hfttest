package com.myfun.service.business.erpdb.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunScoreStandardMonth;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dto.ErpFunCompDto;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunScoreStandardMonthService;
import com.myfun.service.business.erpdb.ErpFunCompService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;

@Service
public class ErpFunCompServiceImpl extends AbstractService<ErpFunComp, ErpFunComp>implements ErpFunCompService {
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	AdminFunScoreStandardMonthService adminFunScoreStandardMonthService;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunCompMapper;
	}


	@Override
	public ErpFunComp getUserByCompNo(String compNo) {
		ErpFunComp object = erpFunCompMapper.getCompByCompNo(compNo);
		return object;
	}


	@Override
	public ErpFunCompDto getCompInfoByCompNo(Integer cityId, String compNo) {
		return erpFunCompMapper.getCompInfoByCompNo(cityId, compNo);
	}


	@Override
	public ErpFunComp getCompByCompId(ErpFunComp comp) {
		return erpFunCompMapper.getCompInfoByCompId(comp);
	}


	/**
	 * @TODO 查询公司信息
	 * @author lcb
	 * @2016-10-19 上午11:24:14
	 */
	@Override
	public ErpFunComp getCompanyData(BaseMapParam param) {
		ErpFunComp erpFunComp = new ErpFunComp(param.getInteger("cityId"), Integer.valueOf(param.getMap().get("compId")+""));
		return erpFunCompMapper.selectByPrimaryKey(erpFunComp);
	}

	@Transactional
	@Override
	public void setExcellent(Integer cityId, String compNo, String deptNo) {
		// 查询是否开始跑分
        AdminFunDepts deptByCompNoAndDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
        if(null != deptByCompNoAndDeptNo && null != deptByCompNoAndDeptNo.getScoreFlag() && 1 == deptByCompNoAndDeptNo.getScoreFlag().intValue()) {
            // 刷新公司层面的数据
            Map<String, Object> pMap = new HashMap<>();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.MONTH, 1);
            pMap.put("endTime", DateUtil.DateToString(calendar.getTime(), "yyyy-MM-dd 00:00:00"));
            calendar.add(Calendar.MONTH, -1);
            pMap.put("startTime", DateUtil.DateToString(calendar.getTime(), "yyyy-MM-dd 00:00:00"));
            pMap.put("compNo", compNo);
            pMap.put("deptNo", deptNo);
            List<AdminFunScoreStandardMonth> resList = adminFunScoreStandardMonthService.selectCondition(pMap);
            if(null != resList && resList.size() > 0) {
                    AdminFunScoreStandardMonth adminFunScoreStandardMonth = resList.get(0);
                    adminFunScoreStandardMonth.setExcellentSetting(adminFunScoreStandardMonth.getExcellentSetting()+1);
                    adminFunScoreStandardMonthService.update(adminFunScoreStandardMonth);
            }else {
                AdminFunScoreStandardMonth adminFunScoreStandardMonth = new AdminFunScoreStandardMonth();
                // 查询基础数据
                ErpFunDepts depts = erpFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
                if(null != depts) {
                    adminFunScoreStandardMonth.setCompId(depts.getCompId());
                    adminFunScoreStandardMonth.setAreaId(depts.getAreaId());
                    adminFunScoreStandardMonth.setCityId(cityId);
                    adminFunScoreStandardMonth.setRegId(depts.getRegId());
                    adminFunScoreStandardMonth.setDeptId(depts.getDeptId());
                    adminFunScoreStandardMonth.setCompNo(depts.getCompNo());
                    adminFunScoreStandardMonth.setDeptNo(depts.getDeptNo());
                    adminFunScoreStandardMonth.setCreationTime(new Date());
                    adminFunScoreStandardMonth.setExcellentSetting(1);
                    adminFunScoreStandardMonthService.insertSelective(adminFunScoreStandardMonth);
                }

            }
        }


	}


	@Override
	public void chgRegist(Integer cityId, Integer compId,String compNo,Integer registFlag) {
		ErpFunComp erpFunComp = erpFunCompMapper.getCompInfoByCompNo(cityId, compNo);
		erpFunComp.setRegistFlag(registFlag == 1);
		erpFunComp.setShardCityId(cityId);
		erpFunComp.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMddHHmmss));
		erpFunCompMapper.updateByCompNo(erpFunComp);
	}

	/**
	 * @tag 通过crmCompId 获取erpCompIds
	 * @author 邓永洪
	 * @since 2018/7/13
	 */
	@Override
	public List<Integer> getErpCompIdListByCrmCompId(Integer cityId, Integer crmCompId) {
		return erpFunCompMapper.getErpCompIdListByCrmCompId(cityId,crmCompId);
	}

	@Override
	public Boolean judgeHjCustomer(Integer cityId, Integer compId) {
		return true;
//		return  (132 == cityId && 10213 == compId) || (1 == cityId && 12001 == compId);
	}
}
