package com.myfun.service.business.admindb.impl;

import com.myfun.framework.config.AppConfig;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunScoreStandardMonthService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.HttpUtil;
import com.myfun.utils.rest.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
public class AdminFunScoreStandardMonthServiceImpl extends AbstractService<AdminFunScoreStandardMonth, Integer> implements AdminFunScoreStandardMonthService {
	@Autowired
	private AdminFunScoreStandardMonthMapper adminFunScoreStandardMonthMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminFunUseScoreStandardMapper adminFunUseScoreStandardMapper;
	@Autowired
	private AdminFunUseScoreRecoreMapper adminFunUseScoreRecoreMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunScoreStandardMonthMapper;
	}

	@Override
	public List<AdminFunScoreStandardMonth> selectCondition(Map<String, Object> pMap) {
		return adminFunScoreStandardMonthMapper.selectCondition(pMap);
	}

	@Override
	public void update(AdminFunScoreStandardMonth adminFunScoreStandardMonth) {
		adminFunScoreStandardMonthMapper.updateByPrimaryKeySelective(adminFunScoreStandardMonth);
	}

	@Transactional
	@Override
	public void insertAdminFunUseScoreRecore(Integer scoreType, GeneralParam generalParam) {
		if(scoreType==null){
			return;
		}
		boolean isPersonalVersion=generalParam.isPersonalVersion();
		String compNo=generalParam.getCompNo();
		String deptNo=generalParam.getDeptNo();
		Integer compId=generalParam.getCompId();
		Integer deptId=generalParam.getDeptId();
		Integer cityId=generalParam.getCityId();
		Integer areaId=generalParam.getAreaId();
		Integer regId=generalParam.getRegId();
		Integer grId=generalParam.getGrId();
		Integer userId=generalParam.getUserId();
		String clientKey = generalParam.getClientKey();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime=DateUtil.dateToStr(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		String endTime=DateUtil.dateToStr(calendar.getTime());
		Map<String, Object> pMap=new HashMap<>();
		pMap.put("cityId",cityId);
		pMap.put("compId",compId);
		pMap.put("deptId",deptId);
		pMap.put("startTime",startTime);
		pMap.put("endTime",endTime);
		List<AdminFunScoreStandardMonth> adminFunScoreStandardMonthList = adminFunScoreStandardMonthMapper.selectCondition(pMap);

		// 门店标贴打印,水单打印要统计门店指数
		boolean needStatistic = !isPersonalVersion && (Const.ScoreTypeDIC.SCORE_TYPE_5.equals(scoreType) || Const.ScoreTypeDIC.SCORE_TYPE_4.equals(scoreType));
		if (needStatistic) {

			Map<String, Object> param = new HashMap<>();
            // 1=个人名片分享，2=微店分享，3=税费打印，4=标贴打印，5=营销推广微信问候，6=营销锦囊分享统计
			param.put("subOptionType", Const.ScoreTypeDIC.SCORE_TYPE_5.equals(scoreType) ? 4 : 3);
			try {
				// http://192.168.5.167:80/mobileWeb
				HttpUtil.postHftMobileUrlBody(AppConfig.getHftMoblieUrl() + "/target/DeptTarget/addCountOption", null, clientKey, param);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 门店版标贴打印
		if(Const.ScoreTypeDIC.SCORE_TYPE_5.equals(scoreType) && !isPersonalVersion) {
			AdminFunDepts deptByDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
			//修改报错判断，将数字类型放前面，==会进行拆箱，所以空会报错 flj 2020-06-09
			if (null != deptByDeptNo && Byte.valueOf("1").equals(deptByDeptNo.getScoreFlag())) {
				AdminFunScoreStandardMonth adminFunScoreStandardMonthPO=null;
				if(null != adminFunScoreStandardMonthList && adminFunScoreStandardMonthList.size()>0) {
					adminFunScoreStandardMonthPO=adminFunScoreStandardMonthList.get(0);
					adminFunScoreStandardMonthPO.setPrintLabel(adminFunScoreStandardMonthPO.getPrintLabel());

					adminFunScoreStandardMonthMapper.updateByPrimaryKeySelective(adminFunScoreStandardMonthPO);
				}else {
					adminFunScoreStandardMonthPO = new AdminFunScoreStandardMonth();
					adminFunScoreStandardMonthPO.setPrintLabel(1);
					this.setAdminFunScoreStandardMonthParam(adminFunScoreStandardMonthPO,cityId,compId,areaId,regId,deptId,grId,userId,compNo,deptNo);
					adminFunScoreStandardMonthMapper.insertSelective(adminFunScoreStandardMonthPO);
				}

			}
		}else if(Const.ScoreTypeDIC.SCORE_TYPE_1.equals(scoreType) && !isPersonalVersion) {
			AdminFunDepts deptByDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
			if (null != deptByDeptNo && deptByDeptNo.getScoreFlag()==1) {
				AdminFunScoreStandardMonth adminFunScoreStandardMonthPO=null;
				if(null != adminFunScoreStandardMonthList && adminFunScoreStandardMonthList.size()>0) {
					adminFunScoreStandardMonthPO=adminFunScoreStandardMonthList.get(0);
					adminFunScoreStandardMonthPO.setHouseCustMatching(adminFunScoreStandardMonthPO.getHouseCustMatching());

					adminFunScoreStandardMonthMapper.updateByPrimaryKeySelective(adminFunScoreStandardMonthPO);
				}else {
					adminFunScoreStandardMonthPO = new AdminFunScoreStandardMonth();
					adminFunScoreStandardMonthPO.setHouseCustMatching(1);
					this.setAdminFunScoreStandardMonthParam(adminFunScoreStandardMonthPO,cityId,compId,areaId,regId,deptId,grId,userId,compNo,deptNo);

					adminFunScoreStandardMonthMapper.insertSelective(adminFunScoreStandardMonthPO);
				}

			}
			// 税单打印
		}else if(Const.ScoreTypeDIC.SCORE_TYPE_4.equals(scoreType) && !isPersonalVersion) {
			AdminFunDepts deptByDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
			if (null != deptByDeptNo && deptByDeptNo.getScoreFlag()==1) {
				AdminFunScoreStandardMonth adminFunScoreStandardMonthPO=null;
				if(null != adminFunScoreStandardMonthList && adminFunScoreStandardMonthList.size()>0) {
					adminFunScoreStandardMonthPO=adminFunScoreStandardMonthList.get(0);
					adminFunScoreStandardMonthPO.setPrintTaxation(adminFunScoreStandardMonthPO.getPrintTaxation());

					adminFunScoreStandardMonthMapper.updateByPrimaryKeySelective(adminFunScoreStandardMonthPO);
				}else {
					adminFunScoreStandardMonthPO = new AdminFunScoreStandardMonth();
					adminFunScoreStandardMonthPO.setPrintTaxation(1);
					this.setAdminFunScoreStandardMonthParam(adminFunScoreStandardMonthPO,cityId,compId,areaId,regId,deptId,grId,userId,compNo,deptNo);

					adminFunScoreStandardMonthMapper.insertSelective(adminFunScoreStandardMonthPO);
				}

			}
		}else if(Const.ScoreTypeDIC.SCORE_TYPE_12.equals(scoreType) && !isPersonalVersion) {
			AdminFunDepts deptByDeptNo = adminFunDeptsMapper.getDeptByCompNoAndDeptNo(compNo, deptNo);
			if (null != deptByDeptNo && deptByDeptNo.getScoreFlag()==1) {
				Date date = DateTimeHelper.addMonths(new Date(), -1);
				startTime=DateUtil.dateToStr(date, "yyyy-MM-dd HH:mm:ss");
				AdminFunComp adminFunCompPO = adminFunCompMapper.getAdminFunCompByComNoAndStartTime(compNo,startTime);
				if (adminFunCompPO!=null){
					AdminFunUseScoreStandard adminFunUseScoreStandardPO = adminFunUseScoreStandardMapper.selectCondition(pMap);
					if(null != adminFunUseScoreStandardPO) {
						if(1!=adminFunUseScoreStandardPO.getEditSoftParam()) {
							adminFunUseScoreStandardPO.setEditSoftParam(1);
							adminFunUseScoreStandardMapper.updateByPrimaryKeySelective(adminFunUseScoreStandardPO);
						}else {
							adminFunUseScoreStandardPO = new AdminFunUseScoreStandard();
							adminFunUseScoreStandardPO.setCityId(cityId);
							adminFunUseScoreStandardPO.setCompId(compId);
							adminFunUseScoreStandardPO.setDeptId(deptId);
							adminFunUseScoreStandardPO.setCompNo(compNo);
							adminFunUseScoreStandardPO.setDeptNo(deptNo);
							adminFunUseScoreStandardPO.setCreationTime(new Date());
							adminFunUseScoreStandardPO.setEditSoftParam(1);
							adminFunUseScoreStandardMapper.insertSelective(adminFunUseScoreStandardPO);
						}
					}
				}


			}
		}else {
			AdminFunUseScoreRecore adminFunUseScoreRecorePO = new AdminFunUseScoreRecore();
			adminFunUseScoreRecorePO.setScoreType(scoreType);
			adminFunUseScoreRecorePO.setCityId(cityId);
			adminFunUseScoreRecorePO.setCompId(compId);
			adminFunUseScoreRecorePO.setCompNo(compNo);
			adminFunUseScoreRecorePO.setAreaId(areaId);
			adminFunUseScoreRecorePO.setRegId(regId);
			adminFunUseScoreRecorePO.setDeptId(deptId);
			adminFunUseScoreRecorePO.setGrId(grId);
			adminFunUseScoreRecorePO.setUserId(userId);
			adminFunUseScoreRecorePO.setArchiveId(generalParam.getArchiveId());
			adminFunUseScoreRecorePO.setDeptNo(deptNo);
			adminFunUseScoreRecorePO.setCreationTime(new Date());
			adminFunUseScoreRecoreMapper.insertSelective(adminFunUseScoreRecorePO);
		}
	}

	/**
	 * 参数设置
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/14
	 */
	private void setAdminFunScoreStandardMonthParam(AdminFunScoreStandardMonth adminFunScoreStandardMonthPO,Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, String compNo, String deptNo) {
		adminFunScoreStandardMonthPO.setCityId(cityId);
		adminFunScoreStandardMonthPO.setCompId(compId);
		adminFunScoreStandardMonthPO.setAreaId(areaId);
		adminFunScoreStandardMonthPO.setRegId(regId);
		adminFunScoreStandardMonthPO.setDeptId(deptId);
		adminFunScoreStandardMonthPO.setGrId(grId);
		adminFunScoreStandardMonthPO.setUserId(userId);
		adminFunScoreStandardMonthPO.setCompNo(compNo);
		adminFunScoreStandardMonthPO.setDeptNo(deptNo);
		adminFunScoreStandardMonthPO.setCreationTime(new Date());
	}


}
