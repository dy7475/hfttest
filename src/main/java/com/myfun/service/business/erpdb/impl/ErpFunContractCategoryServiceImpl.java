package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.erpdb.dao.ErpFunContractCategoryMapper;
import com.myfun.repository.erpdb.po.ErpFunContractCategory;
import com.myfun.repository.erpdb.po.ErpFunContractCategoryExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunContractCategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErpFunContractCategoryServiceImpl extends AbstractService<ErpFunContractCategory, ErpFunContractCategory> implements ErpFunContractCategoryService {
	@Autowired
	ErpFunContractCategoryMapper erpFunContractCategoryMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunContractCategoryMapper;
	}

	@Transactional
	@Override
	public Integer createOrUpdateFunContractCategory(Integer cityId, Integer compId, List<ErpFunContractCategory> paramList) {
		int index = 0;
		for(ErpFunContractCategory funContractCategoryPO : paramList){

			if(StringUtils.isBlank(funContractCategoryPO.getCategoryName())){
				continue;
			}

			index++;
			funContractCategoryPO.setSeqNo(index);
			funContractCategoryPO.setUpdateTime(new Date());
			funContractCategoryPO.setCompId(compId);
			funContractCategoryPO.setIsDel(new Byte("0"));
			funContractCategoryPO.setShardCityId(cityId);
			if(null == funContractCategoryPO.getCategoryId()){// 不存在时新增
				Integer cateGoryId = getHasFunContractCategory(cityId, compId, funContractCategoryPO.getCategoryName());
				if(null == cateGoryId){
					erpFunContractCategoryMapper.insertSelective(funContractCategoryPO);
				}else{
					funContractCategoryPO.setCategoryId(cateGoryId);
					funContractCategoryPO.setSeqNo(index);
					erpFunContractCategoryMapper.updateByPrimaryKeySelective(funContractCategoryPO);
				}
			} else {// 存在时通过主键修改
				erpFunContractCategoryMapper.updateByPrimaryKeySelective(funContractCategoryPO);
			}
		}
		return null;
	}

	private Integer getHasFunContractCategory(Integer cityId, Integer compId, String categoryName)  {

		ErpFunContractCategoryExample erpFunContractCategoryExample = new ErpFunContractCategoryExample();
		erpFunContractCategoryExample.setShardCityId(cityId);
		erpFunContractCategoryExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(new Byte("0")).andCategoryNameEqualTo(categoryName);

		List<ErpFunContractCategory> erpFunContractCategories = erpFunContractCategoryMapper.selectByExample(erpFunContractCategoryExample);
		if(erpFunContractCategories.size() > 0){
			return erpFunContractCategories.get(0).getCategoryId();
		}else{
			return null;
		}

	}

}
