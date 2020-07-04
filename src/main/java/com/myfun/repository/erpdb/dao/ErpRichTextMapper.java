package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpRichText;
import com.myfun.repository.erpdb.po.ErpRichTextKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.erpdb.po.ErpRichTextExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Param;

public interface ErpRichTextMapper extends BaseMapper<ErpRichText, ErpRichTextKey> {

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(ErpRichText record);
	
	/**
	 * 获取房源富文本
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/7
	 * @return
	 *
	 */
	ErpRichText getHouseRichText(@Param("shardCityId") Integer cityId,@Param("caseId") Integer caseId,@Param("caseType") Integer caseType);
}