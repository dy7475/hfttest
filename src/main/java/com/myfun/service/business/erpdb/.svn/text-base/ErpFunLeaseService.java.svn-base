package com.myfun.service.business.erpdb;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.repository.erpdb.dto.ErpBulletHouseDto;
import com.myfun.repository.erpdb.dto.houseAuditDto;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.param.houseAuditParam;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.PageParam;

public interface ErpFunLeaseService extends BaseMapper<ErpFunLease, ErpFunLease>{
	/**
	 * 出租列表查询
	 * @param pageNum
	 * @param shardCityId
	 * @param param
	 * @return
	 */
	public Page<houseAuditDto> getHouseLeaseList(int pageNum, String shardCityId, houseAuditParam param);
	
	/**
	 * 房源审核
	 * @param pubId
	 * @param oldPublishSite
	 * @param houseId
	 * @param publishSite
	 * @param userId
	 * @param desc
	 * @param cityId
	 */
	public void updatePublishCheck(String pubId, String oldPublishSite, String houseId, String publishSite,
			String userId, String desc, String cityId);
	
	/**
	 * 查询房源详细信息
	 * */
	public Map<String, Object> getFunLeaseDetailInfo(Integer housId, Integer cityId, Byte funType);
	
	public ErpFunLease getFunLease(Integer housId, Integer cityId);
	/**
	 * 查询出有效的并可以发布到网络上的出租数据
	 * @author 陈文超
	 * @date 2016年6月3日 上午11:37:54
	 */
	public ErpFunLease getFunLease4OtherWeb(Integer housId, Integer cityId);
	/**
	 * 房源详情过期时查询出两条未过期数据
	 * @author 陈文超
	 * @date 2016年6月3日 下午2:54:18
	 */
	public PageInfo<ErpFunLease> getFunLeaseList4YouYouInfo(Integer cityId, PageParam pageParam);
	/**
	 * 用于优优出租数据的查询
	 * @author 陈文超
	 * @date 2016年6月6日 下午2:21:38
	 */
	public ErpFunLease getFunLeaseInfo4YouYouInfo(Integer housId, Integer cityId);

	public List<ErpFunLease> getLeaseList(Integer cityId, String leaseIds);

	public void updateCancleTrueHouse(Short cityId, Integer caseId);

	public List<ErpBulletHouseDto> getLeaseListForCreateBullet(Integer compId, Integer cityId, String[] caseIds);

	public boolean countShareHouse(Integer cityId,Integer compId);

	public void updateHouseRunModelForPrivate(Integer cityId, Integer compId);

	public void updateHousePlateTypeByRunModel(Integer cityId, Integer compId);

	public void updateHouseActionTimeBySysPara(Integer cityId, Integer compId);

	public void updateHouseTrackTime(Integer cityId, Integer compId,
			String string);

	public void updateHousePublicTime(Integer cityId, Integer compId);

	public void updateHouseSourceNotCooperate(Integer cityId, Integer compId);

	public List<ErpBulletHouseDto> getLeaseListForBullet(Integer compId, Integer cityId, String[] caseIds);
	
	public void updateTrueFlag(Integer cityId, Integer[] leaseIds, Byte trueFlag);
	/**
	 * 依据规则修改真房源标记
	 * @author 臧铁
	 * @param cityId  切库标记
	 * @param caseId  房客源ID
	 * @since 2017年5月15日
	 * @return
	 */
	public Byte updateHouseTrueFlag(Integer cityId, Integer caseId, ErpFunLease erpFunLease);

	public Byte judgeTrueHouseForChangeInfo(Integer panoramaMap, Integer photoMap, Byte trueFlag, Integer videoNum);
	
	public void cancelAds(Integer cityId,Integer compId,Integer caseId,String caseNo);
	
	/**
	 * 公盘房源数据移交
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param param
	 */
	public void createTrack4TransData(ErpCreateTrackInfoParam param);
	
	/**
	 * 判断是否符合真房源规则
	 * @author 朱科
	 * @since 2018年1月22日
	 * @param panoramaMap
	 * @param photoMap
	 * @param trueFlag
	 * @param videoNum
	 * @return
	 */
	public Byte judgeTrueHouseChangeInfo(Integer photoMap, Byte trueFlag);

	/**
	 * 数据移交
	 * @author 张宏利
	 * @since 2018年4月23日
	 * @param param
	 */
	public void dataTranslate(ErpFunLease updateModel, ErpFunUsers acceptUser, List<ErpFunLease> casePOListTmp, DataTranslateParam param);

	/**
	 * 验证移交数据中是否存在已成交或注销的数据
	 * @author 邓永洪
	 * @since 2018年5月4日
	 * @param param
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

	public void synchronizeSaleLeaseHouse(Integer caseId, Byte caseType, ErpFunLease erpFunLease) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;

	boolean countShareHouseByPartner(Integer cityId, Integer compId, Integer partnerId);

	void updateHouseActionTimeBySysParaByOrg(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds);

	void updateHousePublicTimeByPartner(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateHouseSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds);
	
}
