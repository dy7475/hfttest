package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dao.ErpFunContractIndexMapper;
import com.myfun.repository.erpdb.po.ErpFunContractIndex;
import com.myfun.repository.erpdb.po.ErpFunContractIndexExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunContractIndexService;
import com.myfun.utils.Constants_DIC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class ErpFunContractIndexServiceImpl extends AbstractService<ErpFunContractIndex, ErpFunContractIndex> implements ErpFunContractIndexService{

	@Autowired
	ErpFunContractIndexMapper erpFunContractIndexMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunContractIndexMapper;
	}

	/**
	 * 添加修改模板的指标参数
	 * **/
	@Transactional
	@Override
	public String addOrEditTemplate(Integer cityId, Integer compId, List<ErpFunContractIndex> paramList) {

		String ids = "";
		//先做判重
		Integer sameNameCount = getSameNameCount(paramList, cityId, compId);
		if(sameNameCount == 0) {
			for (ErpFunContractIndex erpFunContractIndex : paramList) {
				erpFunContractIndex.setShardCityId(cityId);
				if(null != erpFunContractIndex.getIndexId()) {

					erpFunContractIndexMapper.updateByPrimaryKeySelective(erpFunContractIndex);
				}else{
					// 新增
					erpFunContractIndex.setCreationTime(new Date());
					erpFunContractIndex.setCompId(compId);
					erpFunContractIndex.setIndexStatus(new Byte(Constants_DIC.DIC_CONTRACT_INDEX_STATUS_1));
					erpFunContractIndexMapper.insertSelective(erpFunContractIndex);
					ids += erpFunContractIndex.getIndexId() +",";
				}
			}
		}else{
			// 跑出重名异常
			throw new BusinessException("对不起,指标名重复!");
		}
		return ids.contains(",")? ids.substring(0, ids.length()-1):"";
	}

	/**
	 * 指标名字判断重
	 * **/
	private Integer getSameNameCount(List<ErpFunContractIndex> paramList, Integer cityId, Integer compId){
		Integer res = 0;
		Set<String> indexNameList = new HashSet<>();
		// 思路: 如果没有id 作为新增只根据name条件判重   如果有id 则根据id+name为条件查数量 如果=1 不判重   =0 则将name作为条件判重
		for (ErpFunContractIndex funContractIndexPO : paramList) {
			// 判重名
			if(!indexNameList.contains(funContractIndexPO.getIndexName())) {

				if(null != funContractIndexPO.getIndexId()) {
					ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
					erpFunContractIndexExample.setShardCityId(cityId);
					erpFunContractIndexExample.createCriteria().andIndexNameEqualTo(funContractIndexPO.getIndexName()).
							andIndexIdEqualTo(funContractIndexPO.getIndexId()).andCompIdEqualTo(compId);
					int count = erpFunContractIndexMapper.countByExample(erpFunContractIndexExample);
					if(count == 1) {
						continue;
					}else{
						indexNameList.add(funContractIndexPO.getIndexName());
					}
				}else{
					indexNameList.add(funContractIndexPO.getIndexName());
				}
			}else{
				return 1;
			}
		}
		if(indexNameList.size() > 0) {
			ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
			erpFunContractIndexExample.setShardCityId(cityId);
			erpFunContractIndexExample.createCriteria().andIndexNameIn(new ArrayList<>(indexNameList)).
					andIndexStatusEqualTo(new Byte(Constants_DIC.DIC_CONTRACT_INDEX_STATUS_1)).andCompIdEqualTo(compId);
			res = erpFunContractIndexMapper.countByExample(erpFunContractIndexExample);
		}

		return res;
	}
}
