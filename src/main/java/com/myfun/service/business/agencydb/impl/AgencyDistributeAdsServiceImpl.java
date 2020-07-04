package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dao.AgencyDistributeAdsMapper;
import com.myfun.repository.agencydb.param.AgencyDistributeAdsparam;
import com.myfun.repository.agencydb.po.AgencyDistributeAds;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyDistributeAdsService;
import com.myfun.utils.StringUtil;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月10日 上午10:44:31 
 * 类说明 
*/
@Service
public class AgencyDistributeAdsServiceImpl extends AbstractService<AgencyDistributeAds, Integer>implements AgencyDistributeAdsService {
	@Autowired
	private AgencyDistributeAdsMapper agencyDistributeAdsMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyDistributeAdsMapper;
	}

	@Override
	public PageInfo<AgencyDistributeAds> getBuildAdvList(AgencyDistributeAdsparam agencyDistributeAdsparam) {
		PageHelper.startPage(agencyDistributeAdsparam.getPageNum(), Const.PAGE_NUMBER, true);
		List<AgencyDistributeAds> list = agencyDistributeAdsMapper.getBuildAdvList(agencyDistributeAdsparam);
		return new PageInfo(list);
	}

	@Transactional
	@Override
	public int create(AdminCrmUser adminCrmUser, AgencyDistributeAds ads) {
		ads.setPublishComp(adminCrmUser.getCompId());
		ads.setPublishUser(adminCrmUser.getUserId());
		ads.setPublishTime(new Date());
		int count = agencyDistributeAdsMapper.countSeqNo(ads.getAdvType(), ads.getPublishCity());
		int seqNo = ads.getSeqNo();
		if(count == 0){
			seqNo = 1;
		}else{
			int maxSeqNo = count;
			if(seqNo>maxSeqNo){
				seqNo = maxSeqNo + 1;
			}else{
				//修改排序
				agencyDistributeAdsMapper.updateSeqNo(ads.getAdvType(), ads.getPublishCity(), String.valueOf(ads.getSeqNo()));
			}
		}
		
		ads.setSeqNo(StringUtil.parseByte(String.valueOf(seqNo)));
		Integer photoId = agencyDistributeAdsMapper.getMaxid() +1;
		ads.setPhotoId(photoId);
		agencyDistributeAdsMapper.insertSelective(ads);
		return 1;
	}

	@Transactional
	@Override
	public int updateDisTributeAds(AdminCrmUser adminCrmUser, AgencyDistributeAds ads, String oldSeqNo) {
		int seqNo = ads.getSeqNo();
		if(String.valueOf(ads.getSeqNo()).equals(oldSeqNo)){
			int count = agencyDistributeAdsMapper.countSeqNo(ads.getAdvType(), ads.getPublishCity());
			if(count == 0){
				seqNo = 1;
			}else{
				int maxSeqNo = count;
				if(seqNo >= maxSeqNo){
					seqNo = maxSeqNo;
					agencyDistributeAdsMapper.updateSeqNo1(ads.getAdvType(), ads.getPublishCity(), String.valueOf(ads.getSeqNo()));
				}else {
					if(seqNo > StringUtil.parseInteger(oldSeqNo)){
						agencyDistributeAdsMapper.updateSeqNo2(ads.getAdvType(), ads.getPublishCity(), oldSeqNo, String.valueOf(ads.getSeqNo()));
					}else{
						//修改排序
						agencyDistributeAdsMapper.updateSeqNo3(ads.getAdvType(), ads.getPublishCity(), oldSeqNo, String.valueOf(ads.getSeqNo()));
					}
				}
			}
		}
		ads.setUpdateUser(adminCrmUser.getUserId());
		ads.setUpdateTime(new Date());
		ads.setSeqNo(StringUtil.parseByte(String.valueOf(seqNo)));
		agencyDistributeAdsMapper.updateByPrimaryKeySelective(ads);
		return 1;
	}

	
}
