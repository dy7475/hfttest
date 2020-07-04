package com.myfun.service.business.agencydb;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.AgencyFunCompRealDto;
import com.myfun.repository.agencydb.param.AgencyFunCompRealParam;
import com.myfun.repository.agencydb.po.AgencyFunCompReal;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyFunCompRealService extends BaseMapper<AgencyFunCompReal, Integer> {

	/**
	 * 查询开发商列表
	 * @param agencyFunCompReal
	 * @param pageNumber
	 * @return
	 */
	Page<AgencyFunCompReal> getCompRealList(AgencyFunCompReal agencyFunCompReal, Integer pageNumber);

	/**
	 * 编辑、新增开发商
	 * @param funCompReal
	 * @return
	 */
	boolean updateAndAddCompReal(AgencyFunCompReal funCompReal);

	PageInfo<AgencyFunCompRealDto> getFunCompRealList(AgencyFunCompRealParam adminFunCompRealParam);

	Integer addOrUpdateFunCompReal(AgencyFunCompReal agencyFunCompReal, AdminCrmUser adminCrmUser, String oldMobile, String createTime);

	AgencyFunCompRealDto getFunCompRealListByDevelopId(Integer devloperId);

	List<AgencyFunCompReal> getDeveloperList(String developerName, AdminCrmUser adminCrmUser);

	/**
	 * @TODO 获取开发商列表
	 * @author lcb
	 * @2016-9-20 上午10:48:17
	 */
	PageInfo<AgencyFunCompReal> getFunCompRealList(BaseMapParam param);

	Integer setDistCompRealAdmin(BaseMapParam param);

	AgencyFunCompReal getFunCompRealInfo(BaseMapParam param);

}
