package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunPersonnelLevelsMapper;
import com.myfun.repository.erpdb.dao.ErpFunRecruitmentChannelMapper;
import com.myfun.repository.erpdb.po.ErpFunPersonnelLevels;
import com.myfun.repository.erpdb.po.ErpFunRecruitmentChannel;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPersonnelLevelsService;
import com.myfun.service.business.erpdb.ErpFunRecruitmentChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunPersonnelLevelsServiceImpl extends AbstractService<ErpFunPersonnelLevels, ErpFunPersonnelLevels> implements ErpFunPersonnelLevelsService {
	@Autowired
	ErpFunPersonnelLevelsMapper erpFunPersonnelLevelsMapper;

	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunPersonnelLevelsMapper;
	}


	/**
	 * @tag 增加员工职级和底薪配置
	 * @author 胡坤
	 * @since 2018/5/18
	 */
	@Transactional
	@Override
	public void changeLevelsSeq(ErpFunPersonnelLevels funPersonnelLevels, BaseMapParam param) {
		Integer cityId=param.getInteger("cityId");
		Integer compId=param.getInteger("compId");
		Integer seq=funPersonnelLevels.getSeq();
		Integer operateType=param.getInteger("operateType");
		funPersonnelLevels.setShardCityId(cityId);
		if (seq==null){
			Integer maxChannelSeqNO = getMaxLevelsSeqNO(cityId,compId,null);
			funPersonnelLevels.setSeq(maxChannelSeqNO);
			erpFunPersonnelLevelsMapper.updateByPrimaryKeySelective(funPersonnelLevels);
		}else {
			if (operateType==1){
				Integer maxChannelSeqNO = getMaxLevelsSeqNO(cityId,compId,seq);
				funPersonnelLevels.setSeq(maxChannelSeqNO);
				erpFunPersonnelLevelsMapper.updateByPrimaryKeySelective(funPersonnelLevels);
				erpFunPersonnelLevelsMapper.updateFunPersonnelLeveLsSeqDown(cityId,seq,funPersonnelLevels.getLevelsId());
			}else {
				Integer minChannelSeqNO=getMinLevelsSeqNO(cityId,compId,seq);
				funPersonnelLevels.setSeq(minChannelSeqNO);
				erpFunPersonnelLevelsMapper.updateByPrimaryKeySelective(funPersonnelLevels);
				erpFunPersonnelLevelsMapper.updateFunPersonnelLevelsSeqUp(cityId,seq,funPersonnelLevels.getLevelsId());
			}
		}
	}

	@Transactional
	@Override
	public void addOrEditPersonnelLevel(Integer cityId, Integer compId, List<ErpFunPersonnelLevels> paramList) {
		Integer maxLevelsSeqNO = this.getMaxLevelsSeqNO(cityId,compId,null);
		for (ErpFunPersonnelLevels funPersonnelLevels:paramList){
			if (funPersonnelLevels!=null){
				funPersonnelLevels.setShardCityId(cityId);
				if (funPersonnelLevels.getLevelsId()!=null){
					erpFunPersonnelLevelsMapper.updateByPrimaryKeySelective(funPersonnelLevels);
				}else {
					funPersonnelLevels.setSeq(maxLevelsSeqNO);
					funPersonnelLevels.setCreationTime(new Date());
					funPersonnelLevels.setCompId(compId);
					erpFunPersonnelLevelsMapper.insertSelective(funPersonnelLevels);
					maxLevelsSeqNO++;
				}
			}
		}
	}

	private Integer getMinLevelsSeqNO(Integer cityId, Integer compId, Integer seq) {
		Integer minSeq=erpFunPersonnelLevelsMapper.getMinLevelsSeqNO(cityId,compId,seq);
		Integer minSeqInt = 1;
		if(minSeq!=null) {
			minSeqInt = minSeq;
		}
		return minSeqInt;
	}

	private Integer getMaxLevelsSeqNO(Integer cityId, Integer compId,Integer seq) {
		Integer maxSeqInt = 1;
		if (seq==null){
			Integer maxSeq=erpFunPersonnelLevelsMapper.getMaxLevelsSeqNO(cityId,compId,seq);
			if(null!=maxSeq) {
				maxSeqInt =  maxSeq+1;
			}
		}else {
			Integer maxSeq=erpFunPersonnelLevelsMapper.getMaxLevelsSeqNO(cityId,compId,seq);
			if(null!=maxSeq) {
				maxSeqInt =  maxSeq;
			}
		}
		return maxSeqInt;
	}

}
