package com.myfun.service.business.agencydb;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.param.AgencyDistributeAdsparam;
import com.myfun.repository.agencydb.po.AgencyDistributeAds;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月10日 上午10:43:47 
 * 楼盘分销广告
*/
public interface AgencyDistributeAdsService extends BaseMapper<AgencyDistributeAds, Integer> {
	/**
	 * 查询分销广告列表
	 * @param adminDistributeAdsparam
	 * @return
	 */
	public PageInfo<AgencyDistributeAds> getBuildAdvList(AgencyDistributeAdsparam agencyDistributeAdsparam);
	
	/**
	 * 创建广告信息
	 * @param adminCrmUser
	 * @param ads
	 * @return
	 */
	public int create(AdminCrmUser adminCrmUser, AgencyDistributeAds ads);
	
	/**
	 * 修改广告
	 * @param adminCrmUser
	 * @param ads
	 * @return
	 */
	public int updateDisTributeAds(AdminCrmUser adminCrmUser, AgencyDistributeAds ads, String oldseqNo);
	
	
}
