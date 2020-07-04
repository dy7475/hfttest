package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.erpWeb.managecenter.userOpers.param.UpdatePermissionTemplateParam;
import com.myfun.erpWeb.managecenter.userOpers.param.UpdateRolePermissionTemplateParam;
import com.myfun.erpWeb.managecenter.userOpers.vo.FunOpersVO;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.ErpCompRoleOpers;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpCompRoleOpersService extends BaseMapper<ErpCompRoleOpers, ErpCompRoleOpers>{
	
    void updateCompRoleOpers(Integer cityId, Integer compId, Integer compType, Integer currentUserId, Integer currentDeptId,
                             Integer effectRange, String roleId, Set<String> ptOperAdd,
                             Set<String> ptOperDel, String[] queryParam, Integer isNewSetOper, Integer isCompRole, Byte partStatistCount);
    
    public String [] parseQueryColumnByCompOpers(String roleId, ErpFunUsers model,Integer compId, Integer cityId) throws Exception;
    
    public Map<String, Set<String>> getCurrRoleCompOpersByRangId(String roleId,Integer compId, Integer cityId)throws Exception;
    
    
    void updateCompRoleTemplateOpers(Operator operator,String[] queryParam,Set<String> ptOperAdd,Set<String> deleteOpers,UpdatePermissionTemplateParam param);

	void updateRolePermissionTemplate(Integer cityId, Integer compId, UpdateRolePermissionTemplateParam param);

    void updateCompRoleOpersNewOrg(Integer cityId, Integer compId, Integer currentUserId, Integer currentDeptId,
                                   Integer effectRange, String roleId, List<FunOpersVO> updateOpersList, Integer isNewSetOper,
                                   Integer isCompRole, Integer organizationId, Set<String> operId,String userName);

    void dealRoleOpersDefId(Integer cityId, Integer compId, String roleId, Set<ErpFunOpersDto> funOpersPOList, Boolean modelFlag);
    void dealRoleOpersDefId2(Integer cityId, Integer compId, String roleId, List<ErpUserOpersDto> funOpersPOList, Boolean modelFlag);
}
