package com.myfun.service.business.erpdb;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.house.vo.FunSaleDto;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateOrInsertDealTaxesParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpBulletHouseDto;
import com.myfun.repository.erpdb.dto.HouseCaseIdDto;
import com.myfun.repository.erpdb.dto.houseAuditDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.QueryHouseCustListParam;
import com.myfun.repository.erpdb.param.houseAuditParam;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.PageParam;

public interface ErpFunSaleService extends BaseMapper<ErpFunSale, ErpFunSale> {
	/**
	 * 查询房源审核列表
	 * @param pageNum
	 * @param shardCityId
	 * @param param
	 * @return
	 */
	public Page<houseAuditDto> getHouseSaleList(int pageNum, String shardCityId, houseAuditParam param);
	
	/**
	 * 審核房源
	 * @param fPubId
	 * @param oldPublishSite
	 * @param houseId
	 * @param publishSite
	 * @param userId
	 * @param desc
	 * @param cityId
	 */
	public void updatePublishCheck(String fPubId, String oldPublishSite, String houseId, 
			String publishSite, String userId, String desc, String cityId);
	/**
	 * 查询房源详细信息
	 * */
	public Map<String, Object> getFunSaleDetailInfo(Integer housId, Integer cityId, Byte funType);
	
	public ErpFunSale getFunSale(Integer housId, Integer cityId);
	/**
	 * 查询出有效的并可以发布到网络上的出售数据
	 * @author 陈文超
	 * @date 2016年6月3日 上午11:37:54
	 */
	public ErpFunSale getFunSale4OtherWeb(Integer housId, Integer cityId);
	/**
	 * 房源详情过期时查询出两条未过期数据
	 * @author 陈文超
	 * @date 2016年6月3日 下午2:54:18
	 */
	public PageInfo<ErpFunSale> getFunSaleList4YouYouInfo(Integer cityId ,PageParam pageParam);
	/**
	 * 用于优优出售数据的查询
	 * @author 陈文超
	 * @date 2016年6月6日 下午2:21:38
	 */
	public ErpFunSale getFunSaleInfo4YouYouInfo(Integer housId, Integer cityId);

	public void updateTrueFlag(Integer cityId, Integer[] saleIds, Byte trueFlag);

	public List<ErpFunSale> getSaleList(Integer cityId, String saleIds);
	
	public List<ErpBulletHouseDto> getSaleListForCreateBullet(Integer compId, Integer cityId, String[] saleIds);

	public void updateCancleTrueHouse(Short cityId, Integer caseId);

	public boolean countShareHouse(Integer cityId, Integer compId);

	public void updateHouseRunModelForPrivate(Integer cityId, Integer compId);

	public void updateHousePlateTypeByRunModel(Integer cityId, Integer compId);

	public void updateHouseActionTimeBySysPara(Integer cityId, Integer compId);

	public void updateHouseTrackTime(Integer cityId, Integer compId,
			String string);

	public void updateHousePublicTime(Integer cityId, Integer compId);

	public void updateHouseSourceNotCooperate(Integer cityId, Integer compId);

	/**
	 * 依据规则修改真房源标记
	 * @author 臧铁
	 * @param cityId  切库标记
	 * @param caseId  房客源ID
	 * @since 2017年5月15日
	 * @return
	 */
	public Byte updateHouseTrueFlag(Integer cityId,Integer caseId, ErpFunSale erpFunSale);

	/**
	 * 出售房源匹配求购客户
	 * @author 臧铁
	 * @param param  caseId 房客源ID  date 时间范围 deptId 门店ID matchType   SOURCE_DEPT_ID
	 * @param param  bound 匹配范围 0 全公司【本公司】 范围 1 共享圈 范围 3 好友圈 范围 CITY_SHARE 匹配城市公盘，排除本公司范围
	 * @param param  plateType 盘别 1抢盘2私盘3公盘  orderBy 排序方式
	 * @since 2017年5月23日
	 * @return
	 */
	List<?> getMatchBuyCustomerList(BaseMapParam param) throws Exception;
	
	public Byte judgeTrueHouseForChangeInfo(Integer panoramaMap, Integer photoMap, Byte trueFlag, Integer videoNum);
	
	public Integer[] getCurrentArchiveId(Integer cityId,Integer caseId, Integer caseType);
	
	public void cancelAds(Integer cityId,Integer compId,Integer caseId,String caseNo);
	
	/**
	 * 获取重复房源信息
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @return
	 */
	public Map<String, String> getAddrRepetCount(Integer cityId, Integer compId, Integer caseId,
			Integer caseType, String judgeRepetWithAll, Integer buildId, String roof, String unit,
			String floor, String num, String tradeAddr, Byte useage, boolean isPersonalVersion, Integer selfUserId,
			Integer houseAreaId, Integer houseRegId, Integer houseDeptId, Integer houseGrId);
	
	/**
	 * 获取电话重复信息
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @return
	 */
	public Map<String, String> detectPhoneRepeat(Integer cityId, Integer compId, Integer caseId, Integer caseType, String[] phoneArr, 
			String judgeRepetWithAll, boolean isPersonalVersion, Integer selfUserId, Integer selfDeptId, 
			Integer houseAreaId, Integer houseRegId, Integer houseDeptId, Integer houseGrId);
	
	/**
	 * 测试执行sql
	 * @author 张宏利
	 * @since 2018年1月24日
	 * @param i
	 * @return
	 */
	public List<Map<String, Object>> testSaleSql(int cityId, Integer allColumn);

	/**
	 * 测试执行sql
	 * @author 张宏利
	 * @since 2018年1月24日
	 * @param cityId
	 * @return
	 */
	public List<Map<String, Object>> testLeaseSql(int cityId, Integer allColumn);
	
	/**
	 * 公盘房源数据移交
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param param
	 */
	public void createTrack4TransData(ErpCreateTrackInfoParam param);
	
	/**
	 * 精英版下架客户在推广的“真房源”，“竞价房源”，“小区专家”，“新盘顾问”
	 */
	public void updateHouseExtension(Integer cityId, Integer archiveId, String endTime, String nowDate, Integer compId);
	
	/**
	 * 门店版下架在推广的“真房源”，“竞价房源”，“小区专家”，“新盘顾问”
	 */
	public void updateHouseExtensionDept(Integer compId, Integer deptId, Integer cityId, String endTime, String nowDate);
	
	/**
	 * 数据移交
	 * @author 张宏利
	 * @since 2018年4月23日
	 * @param param
	 */
	public void dataTranslate(ErpFunSale updateModel, ErpFunUsers acceptUser, List<ErpFunSale> casePOListTmp, DataTranslateParam param);
	
	/**
	 * 数据中是否存在已经成交或注销的信息
	 * @author 邓永洪
	 * @since 2018年5月4日
	 * @param param
	 * @param caseIds
	 * @return
	 */
	public boolean detectTransData(DataTranslateParam param, String caseIds);
	
	/**
	 * 判断指定员工的所有信息中是否存在已成交或注销信息
	 * @author 邓永洪
	 * @since 2018年5月4日
	 * @param param
	 * @return
	 */
	public boolean detectTransDataByDeptIdAndUserId(DataTranslateParam param);

	public PageInfo<FunSaleDto> getHouseSaleList(QueryHouseCustListParam param);
	
	/**
	 * 判断数据是否合同锁定
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/7
	 * @return
	 *
	 */
	boolean dealInfoIsLock(Object object, Integer cityId, Integer compId, Integer userId);


	void updateHouseSourceInfoByDealTaxes(UpdateOrInsertDealTaxesParam param, ErpFunSale sale, String oldCellphone, String newCellphone);

	void synchronizeSaleLeaseHouse(Integer caseId, Byte caseType, ErpFunSale erpFunSale) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;

	boolean countShareHouseByPartner(Integer cityId, Integer compId, Integer partnerId);

	void updateHouseActionTimeBySysParaByOrg(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds);

	void updateHousePublicTimeByOrg(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateHouseSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds);

    void downHouseFormWebSite(ErpFunUsers funUsersSel, List<HouseCaseIdDto> saleIds, List<HouseCaseIdDto> leaseIds);
}
