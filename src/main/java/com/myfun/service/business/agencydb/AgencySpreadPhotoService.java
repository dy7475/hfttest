package com.myfun.service.business.agencydb;

import com.myfun.repository.agencydb.po.AgencySpreadPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月9日 下午7:11:08 
 * 类说明 
*/
public interface AgencySpreadPhotoService extends BaseMapper<AgencySpreadPhoto, Integer> {
	/**
	 * 查询图片地址
	 * @param spreadId
	 * @return
	 */
	public AgencySpreadPhoto getPhotoBySpreadId(String spreadId);
}
