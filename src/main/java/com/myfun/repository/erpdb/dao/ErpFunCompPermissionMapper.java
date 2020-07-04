package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.po.ErpFunCompPermission;
import com.myfun.repository.erpdb.po.ErpFunCompPermissionExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface ErpFunCompPermissionMapper extends BaseMapper<ErpFunCompPermission, ErpFunCompPermission> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunCompPermissionExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunCompPermissionExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunCompPermission> selectByExample(ErpFunCompPermissionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunCompPermission record, @Param("example") ErpFunCompPermissionExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunCompPermission record, @Param("example") ErpFunCompPermissionExample example);

    
	List<ErpFunCompPermission> getCheckedCommonMapOpers(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("column")String column,
			@Param("columnValue") String columnValue, @Param("templateId") Integer templateId, @Param("operType") Integer operType);

	void deleteByDynamincId2(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("templateId") Integer templateId,
			@Param("columnName")String columnName, @Param("columnValue")String columnValue, @Param("operIds")Set<String> repeatUpdateOperIds);
	
	
	void deleteByDynamincId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,  @Param("templateId") Integer templateId,
			@Param("columnName")String columnName, @Param("columnValue")String columnValue, @Param("operIds")Set<String> repeatUpdateOperIds);

	void insertByDynamicId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,
						   @Param("columnName")String columnName, @Param("columnValue")String columnValue, @Param("templateId")Integer templateId,
						   @Param("operId")String operId, @Param("operType") Integer operType);

	List<ErpFunCompPermission> parseQueryColumnForUserOpers(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("templateId")Integer templateId);

	List<ErpFunOpersDto> getTemplateOperList(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("templateId")Integer templateId);
}