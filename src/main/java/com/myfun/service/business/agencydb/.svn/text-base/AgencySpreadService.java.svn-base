package com.myfun.service.business.agencydb;

import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.AgencySpreadDto;
import com.myfun.repository.agencydb.param.AgencySpreadParam;
import com.myfun.repository.agencydb.po.AgencySpread;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月9日 下午3:42:12 
 * 类说明 
*/
public interface AgencySpreadService extends BaseMapper<AgencySpread, Integer> {
	
	/**
	 * 获取推广审核列表
	 * @param agencySpreadParam
	 * @return
	 */
	PageInfo<AgencySpread> getList(AgencySpreadParam agencySpreadParam);
	
	/**
	 * 查询推广统计
	 * @param timeStart
	 * @param timeEnd
	 * @return
	 */
	AgencySpreadDto getCountSpread(String timeStart, String timeEnd);
	
	/**
	 * 修改状态
	 * @param adminCrmUser
	 * @param agencySpread
	 * @return
	 */
	int updateStatus(AdminCrmUser adminCrmUser, AgencySpread agencySpread);

	PageInfo<AgencySpreadDto> getDistSystemMessage(BaseMapParam param);

}
