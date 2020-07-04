package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminCityshareBorkerComplaint;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.admindb.bean.param.CityshareBorkerComplaintParam;

public interface AdminCityshareBorkerComplaintService extends BaseMapper<AdminCityshareBorkerComplaint, Integer>{

	/**
	 * 城市公盘写投诉
	 * @author 朱科
	 * @since 2018年4月9日
	 * @return
	 */
	public void addCityshareBorkerComplaint(Integer selfArchiveId, Integer selfUserId, Integer selfCompId, Integer selfDeptId, Integer cityId, CityshareBorkerComplaintParam param);
}
