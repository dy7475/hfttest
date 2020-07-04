 package com.myfun.service.business.erpdb.impl;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunSalaryTypeMapper;
import com.myfun.repository.erpdb.dao.ErpSalaryTypeRelativeMapper;
import com.myfun.repository.erpdb.dao.ErpTaskAssessmentTargetMapper;
import com.myfun.repository.erpdb.param.ErpFunSalaryTypeParam;
import com.myfun.repository.erpdb.po.ErpFunSalaryType;
import com.myfun.repository.erpdb.po.ErpSalaryTypeRelative;
import com.myfun.repository.erpdb.po.ErpSalaryTypeRelativeExample;
import com.myfun.repository.erpdb.po.ErpTaskAssessmentTarget;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunSalaryTypeService;

@Service
public class ErpFunSalaryTypeServiceImpl extends AbstractService<ErpFunSalaryType, ErpFunSalaryType> implements ErpFunSalaryTypeService{
	
	@Autowired private ErpFunSalaryTypeMapper erpFunSalaryTypeMapper;
	@Autowired private ErpTaskAssessmentTargetMapper erpTaskAssessmentTargetMapper;
	@Autowired private ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunSalaryTypeMapper;
	}

	/**
	 * 新增工资方案
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param  
	 * stanrdassessmentTargetId:原有标准id
	 * salaryTypeName：方案名称    salaryMoney：基本薪资
	 * taskPercent：任务比例            tragetProfit：目标业绩
	 * @return
	 */
	@Transactional
	@Override
	public void insertSalaryType(ErpFunSalaryTypeParam param) {
		Integer count = erpFunSalaryTypeMapper.countBySalaryTypeName(param);
		if (count != null && count > 0) {
			throw new BusinessException("方案名称重复");
		}
		param.setCreationTime(new Date());
		param.setDelFlag(0);// 0=有效 1=删除
		// 先插入薪资考核方案表
		erpFunSalaryTypeMapper.insertSelective(param);
		// 再通过前端stanrdassessmentTargetId获取 任务目标考核对象（前端缓存的6种通用标准）
		if (param.getStanrdassessmentTargetId() != null) {
			ErpTaskAssessmentTarget erpTaskAssessmentTarget = new ErpTaskAssessmentTarget();
			erpTaskAssessmentTarget.setId(param.getStanrdassessmentTargetId());
			erpTaskAssessmentTarget.setShardCityId(param.getShardCityId());
			erpTaskAssessmentTarget = erpTaskAssessmentTargetMapper.selectByPrimaryKey(erpTaskAssessmentTarget);
			// 最后关联薪资考核方案表插入任务目标考核表（设置公司自己的标准）
			if (erpTaskAssessmentTarget != null) {
				erpTaskAssessmentTarget.setShardCityId(param.getShardCityId());
				erpTaskAssessmentTarget.setCreationTime(new Date());
				erpTaskAssessmentTarget.setId(null);//自增长id需要清空后插入
				erpTaskAssessmentTarget.setCompId(param.getCompId());//compId=0 为6种通用标准之一   需要更改为当前公司  以后就是当前公司模板
				erpTaskAssessmentTarget.setSalaryTypeId(param.getId());//关联薪资考核方案表
				erpTaskAssessmentTargetMapper.insertSelective(erpTaskAssessmentTarget);
			}
		}
	}

	/**
	 * 删除工资方案
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param  id：主键id  confirm:确定删除标记 1=确定
	 * @return countFlag:有几个人在使用该工资方案
	 */
	@Transactional
	@Override
	public Integer delSalaryTypeById(ErpFunSalaryTypeParam param) {
		ErpFunSalaryType id = new ErpFunSalaryType();
		id.setShardCityId(param.getShardCityId());
		id.setId(param.getId());
		ErpFunSalaryType erpFunSalaryType = erpFunSalaryTypeMapper.selectByPrimaryKey(id);
		//查询考核方案人员关联表是否有人在使用  返回countFlag给前端进行提示
		ErpSalaryTypeRelativeExample erpSalaryTypeRelativeExample = new ErpSalaryTypeRelativeExample();
		erpSalaryTypeRelativeExample.createCriteria().andCompIdEqualTo(param.getCompId()).andSalaryTypeIdEqualTo(param.getId());
		erpSalaryTypeRelativeExample.setShardCityId(param.getShardCityId());
		Integer countFlag = erpSalaryTypeRelativeMapper.countByExample(erpSalaryTypeRelativeExample);
		// 没有人使用或者前端传来确定删除标记 则直接删除
		if ((countFlag != null && countFlag == 0) || "1".equals(param.getConfirm())) {
			// 逻辑删除关联表
			ErpSalaryTypeRelative erpSalaryTypeRelative = new ErpSalaryTypeRelative();
			erpSalaryTypeRelative.setShardCityId(param.getShardCityId());
			erpSalaryTypeRelative.setSalaryTypeId(param.getId());
			erpSalaryTypeRelative.setCompId(param.getCompId());
			erpSalaryTypeRelative.setDelFlag(1);// 0=有效 1=已删除
			erpSalaryTypeRelative.setDelTime(new Date());
			Date createDate = erpFunSalaryType.getCreationTime();
			Date dateNow = new Date();
			// 判断是否在同一个月
			if(dateNow.getYear() == createDate.getYear() && dateNow.getMonth() == createDate.getMonth()) {
				erpSalaryTypeRelativeMapper.deleteByExample(erpSalaryTypeRelativeExample);
				erpFunSalaryTypeMapper.deleteByPrimaryKey(id);
				
			}else{				
				erpSalaryTypeRelativeMapper.delSalaryTypeRelativeById(erpSalaryTypeRelative);
				param.setDelFlag(1);// 0=有效 1=已删除
				erpFunSalaryTypeMapper.updateByPrimaryKeySelective(param);
			}
			//55
			// 逻辑删除
			return null;
		}
		return countFlag;
	}
}
