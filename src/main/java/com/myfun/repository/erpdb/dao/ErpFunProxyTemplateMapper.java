package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.house.param.ProxyTemplateParam;
import com.myfun.repository.erpdb.po.ErpFunProxyTemplate;
import com.myfun.repository.erpdb.po.ErpFunProxyTemplateExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunProxyTemplateMapper extends BaseMapper<ErpFunProxyTemplate, ErpFunProxyTemplate> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunProxyTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunProxyTemplateExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunProxyTemplate> selectByExample(ErpFunProxyTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunProxyTemplate record,
								 @Param("example") ErpFunProxyTemplateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunProxyTemplate record,
						@Param("example") ErpFunProxyTemplateExample example);


	List<ErpFunProxyTemplate> getFunProxyTemplateByCompId(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("templateType") Byte templateType,@Param("caseType") Byte caseType);

	int resetTemplateContent(@Param("shardCityId")Integer cityId,@Param("param") ProxyTemplateParam param);
}