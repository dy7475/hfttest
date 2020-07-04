package com.myfun.service.business.admindb;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.common.param.DeleteCompParam;
import com.myfun.erpWeb.common.param.UpdateChileCompParam;
import com.myfun.repository.admindb.dto.AdminFunCompDto;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunCompService extends BaseMapper<AdminFunComp, Integer> {

	Integer updateAdminFunComp(Integer brandId);

	PageInfo<AdminFunCompDto> getCompManageList(String compNo, Integer openStatus, Integer type, Integer pageNum, Integer pageSize, Map<String, Object> paramMap);

	Integer updateFunComp(Integer compId, Integer manageFlag);

	AdminFunComp getFunCompByCompId(Integer compId);
	
	/**
	 * 验证是否是房基地的直销模式
	 * @param adminCompId
	 * @return
	 */
	boolean judgerIsFangjidi(Integer adminCompId);
	

	boolean judgerIsMeiLian(Integer adminCompId,String compNo);

	boolean judgeRequestFromNewVersionIn930(boolean isMobileApi, String appVersionNo, String appSource, String deviceType, Integer erpVersionNo);

	String createSubComp(AdminFunComp adminFunComp, AdminFunDepts adminFunDepts) throws Exception ;

    String updateCompInfo(UpdateChileCompParam param);

}
