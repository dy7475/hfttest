/**
 * @author 方李骥
 * @since 2016年9月2日
 */
package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.house.param.ProxyTemplateParam;
import com.myfun.repository.erpdb.po.ErpFunProxyTemplate;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunProxyTemplateService extends BaseMapper<ErpFunProxyTemplate, ErpFunProxyTemplate> {


	void saveProxyTemplate(Integer cityId, Integer compId,Integer id, Byte templateType,Byte caseType, String templateContent);

	void resetTemplateContent(Integer cityId, ProxyTemplateParam param);

}
