package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunRecruitmentChannelMapper;
import com.myfun.repository.erpdb.po.ErpFunRecruitmentChannel;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunRecruitmentChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunRecruitmentChannelServiceImpl  extends AbstractService<ErpFunRecruitmentChannel, ErpFunRecruitmentChannel> implements ErpFunRecruitmentChannelService {
	@Autowired
	ErpFunRecruitmentChannelMapper erpFunRecruitmentChannelMapper;

	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunRecruitmentChannelMapper;
	}

	/**
	 * @tag 对招聘渠道排序
	 * @author 邓永洪
	 * @since 2018/5/18
	 */
	@Transactional
	@Override
	public void changeChannelSeq(ErpFunRecruitmentChannel funRecruitmentChannel, BaseMapParam param) {
		Integer cityId=param.getInteger("cityId");
		Integer compId=param.getInteger("compId");
		Integer seq=funRecruitmentChannel.getSeq();
		Integer operateType=param.getInteger("operateType");
		funRecruitmentChannel.setShardCityId(cityId);
		if (seq==null){
			Integer maxChannelSeqNO = getMaxChannelSeqNO(cityId,compId,null);
			funRecruitmentChannel.setSeq(maxChannelSeqNO);
			erpFunRecruitmentChannelMapper.updateByPrimaryKeySelective(funRecruitmentChannel);
		}else {
			if (operateType==1){
				Integer maxChannelSeqNO = getMaxChannelSeqNO(cityId,compId,seq);
				funRecruitmentChannel.setSeq(maxChannelSeqNO);
				erpFunRecruitmentChannelMapper.updateByPrimaryKeySelective(funRecruitmentChannel);
				erpFunRecruitmentChannelMapper.updateFunRecruitmentChannelSeqDown(cityId,seq,funRecruitmentChannel.getChannelId());
			}else {
				Integer minChannelSeqNO=getMinChannelSeqNO(cityId,compId,seq);
				funRecruitmentChannel.setSeq(minChannelSeqNO);
				erpFunRecruitmentChannelMapper.updateByPrimaryKeySelective(funRecruitmentChannel);
				erpFunRecruitmentChannelMapper.updateFunRecruitmentChannelSeqUp(cityId,seq,funRecruitmentChannel.getChannelId());
			}
		}
	}


	/**
	 * @tag 增加修改入职渠道
	 * @author 邓永洪
	 * @since 2018/5/18
	 */
	@Override
	public void addOrEditRecruitmentChannel(Integer cityId, Integer compId, List<ErpFunRecruitmentChannel> paramList) {
		Integer maxChannelSeqNO = getMaxChannelSeqNO(cityId,compId,null);
		for (ErpFunRecruitmentChannel funRecruitmentChannel:paramList){
			if (funRecruitmentChannel!=null){
				funRecruitmentChannel.setShardCityId(cityId);
				if (funRecruitmentChannel.getChannelId()!=null){
					erpFunRecruitmentChannelMapper.updateByPrimaryKeySelective(funRecruitmentChannel);
				}else {
					funRecruitmentChannel.setSeq(maxChannelSeqNO);
					funRecruitmentChannel.setCreationTime(new Date());
					funRecruitmentChannel.setCompId(compId);
					erpFunRecruitmentChannelMapper.insertSelective(funRecruitmentChannel);
					maxChannelSeqNO++;
				}
			}
		}
	}

	private Integer getMinChannelSeqNO(Integer cityId, Integer compId, Integer seq) {
		Integer minSeq=erpFunRecruitmentChannelMapper.getMinChannelSeqNO(cityId,compId,seq);
		Integer minSeqInt = 1;
		if(minSeq!=null) {
			minSeqInt = minSeq;
		}
		return minSeqInt;
	}

	private Integer getMaxChannelSeqNO(Integer cityId, Integer compId,Integer seq) {
		Integer maxSeqInt = 1;
		if (seq==null){
			Integer maxSeq=erpFunRecruitmentChannelMapper.getMaxChannelSeqNO(cityId,compId,seq);
			if(null!=maxSeq) {
				maxSeqInt =  maxSeq+1;
			}
		}else {
			Integer maxSeq=erpFunRecruitmentChannelMapper.getMaxChannelSeqNO(cityId,compId,seq);
			if(null!=maxSeq) {
				maxSeqInt =  maxSeq;
			}
		}
		return maxSeqInt;
	}


}
