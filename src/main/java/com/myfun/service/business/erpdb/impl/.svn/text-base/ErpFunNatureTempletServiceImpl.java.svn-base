package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunNatureTempletMapper;
import com.myfun.repository.erpdb.po.ErpFunNatureTemplet;
import com.myfun.repository.erpdb.po.ErpFunNatureTempletExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunNatureTempletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class ErpFunNatureTempletServiceImpl extends AbstractService<ErpFunNatureTemplet, ErpFunNatureTemplet> implements ErpFunNatureTempletService {

	@Autowired private ErpFunNatureTempletMapper erpFunNatureTempletMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunNatureTempletMapper;
	}


	/**
	 * title ：a
	 * athor：lcb
	 * date  : 2017/11/4
	 */
	@Transactional
	@Override
	public Integer addOrEditNatureTemplet(Integer cityId, Integer compId, Integer deptId, ErpFunNatureTemplet erpFunNatureTemplet) throws Exception{
		erpFunNatureTemplet.setShardCityId(cityId);
		// 新增
		if(null == erpFunNatureTemplet.getId()) {
			// 判断个数
			ErpFunNatureTempletExample erpFunNatureTempletExample = new ErpFunNatureTempletExample();
			erpFunNatureTempletExample.setShardCityId(cityId);
			erpFunNatureTempletExample.createCriteria().andCompIdEqualTo(compId);
			Integer count = erpFunNatureTempletMapper.countByExample(erpFunNatureTempletExample);

			if(count < 10) {
				erpFunNatureTemplet.setCompId(compId);
				erpFunNatureTemplet.setDeptId(deptId);
				erpFunNatureTemplet.setCreateTime(new Date());
				return erpFunNatureTempletMapper.insertSelective(erpFunNatureTemplet);
			}else {
				throw new BusinessException("仅能创建10个税费模板！");
			}
			// 编辑
		}else {
			return erpFunNatureTempletMapper.updateByPrimaryKeySelective(erpFunNatureTemplet);
		}
	}
}
