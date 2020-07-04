package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.userOpers.vo.GetPermissionTemplateScopeVO;
import com.myfun.repository.erpdb.po.ErpFunCompPermissionTemplate;
import com.myfun.repository.erpdb.po.ErpFunCompPermissionTemplateExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunCompPermissionTemplateMapper extends BaseMapper<ErpFunCompPermissionTemplate, ErpFunCompPermissionTemplate> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunCompPermissionTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunCompPermissionTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunCompPermissionTemplate> selectByExample(ErpFunCompPermissionTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunCompPermissionTemplate record, @Param("example") ErpFunCompPermissionTemplateExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunCompPermissionTemplate record, @Param("example") ErpFunCompPermissionTemplateExample example);

	ErpFunCompPermissionTemplate getByTemplateId(@Param("shardCityId")Integer cityId, 
			@Param("templateId")Integer templateId);

	List<GetPermissionTemplateScopeVO> getPermissionTemplateScope(@Param("shardCityId") Integer cityId, @Param("compId") Integer compId);

}