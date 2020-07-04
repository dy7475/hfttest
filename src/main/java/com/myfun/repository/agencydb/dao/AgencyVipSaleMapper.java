package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.dto.AgencyCommentDto;
import com.myfun.repository.agencydb.dto.AgencyVipSaleDto;
import com.myfun.repository.agencydb.param.AgencyVipSaleParam;
import com.myfun.repository.agencydb.param.AgencyVipSaleParam4Create;
import com.myfun.repository.agencydb.po.AgencyVipSale;
import com.myfun.repository.agencydb.po.AgencyVipSaleKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.agencydb.po.AgencyVipSaleExample;

public interface AgencyVipSaleMapper extends BaseMapper<AgencyVipSale, AgencyVipSaleKey> {
	/**
	 * 张卓 分页查询数据
	 * 
	 * @param vipSale
	 * @return
	 */
	public List<AgencyVipSaleDto> getAgencyVipSaleDtoList(AgencyVipSaleParam vipSale);

	/**
	 */
	public int createRecord(AgencyVipSaleParam4Create vipSaleParam);

	/**
	 * 张卓 查询直供信息
	 * 
	 * @return
	 */
	public AgencyVipSaleDto getVipInfo(@Param("tableName") String tableName, @Param("fieldId") String fieldId, @Param("cityId") Short cityId, @Param("vipId") Integer vipId);

	/**
	 * 获取id
	 */
	public Integer getId();

	/**
	 * 获取委托信息
	 * 
	 * @param cityId
	 * @param caseId
	 * @param caseType
	 * @return
	 * @throws Exception
	 */
	public AgencyCommentDto getCaseInfo(@Param("tableName") String tableName, @Param("fieldName") String fieldName, @Param("cityId") String cityId, @Param("caseId") Integer caseId);

	/**
	 * 
	 * @param vipSaleParam
	 * @return
	 */
	List<AgencyVipSale> getEntrustBuildList(AgencyVipSaleParam vipSaleParam);

	/**
	 * @Title: getVipSaleDetail 
	 * @描述: 详情
	 * @author lcb
	 * @2016-5-31 下午3:01:00
	 * @param cityId 
	 **/
	AgencyVipSale getVipSaleDetail(@Param("caseId")String caseId, @Param("cityId")String cityId);
	/**
	 * 查询优优委托数据
	 * @author 陈文超
	 * @date 2016年6月17日 下午5:27:29
	 */
	List<AgencyVipSale> getYouYouEntrustInfoList(@Param("caseIds")List<Integer> caseIds, @Param("cityId")Short cityId) throws Exception;
	/**
	 * 判断房源信息是否重复
	 * @param agencyVipSale
	 * @return
	 */
	int countHouse(AgencyVipSale agencyVipSale);

	/**
	 * 查看条数加一
	 * @author 张宏利
	 * @since 2016年8月31日
	 * @param tableName
	 * @param cityId
	 * @param fieldName
	 * @param caseId
	 */
	void addPurchaseCount(@Param("tableName")String tableName,@Param("cityId") int cityId,@Param("fieldName") String fieldName, @Param("caseId")Integer caseId);
	/**
	 * 获取出售房源信息
	 * @author 何传强
	 * @since 2017年8月22日
	 * @param caseId
	 * @param cityId
	 * @return
	 */
	public AgencyVipSaleDto getVipSaleInfo(@Param("caseId")String caseId, @Param("cityId")String cityId);
}