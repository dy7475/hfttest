package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.erpWeb.managecenter.transaction.param.UpdateOrInsertDealTaxesParam;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @author 方李骥
 * @since 2016年8月29日
 */
public interface ErpFunBuyCustomerService extends BaseMapper<ErpFunBuyCustomer, ErpFunBuyCustomer>{

	ErpFunBuyCustomer getFunBuyCustomer(Integer cityId,Integer buyCustId);

	boolean countShareHouse(Integer cityId, Integer compId);

	void updateHouseRunModelForPrivate(Integer cityId, Integer compId);

	void updateHousePlateTypeByRunModel(Integer cityId, Integer compId);

	void updateHouseActionTimeBySysPara(Integer cityId, Integer compId);

	void updateHouseTrackTime(Integer cityId, Integer compId, String string);

	void updateHousePublicTime(Integer cityId, Integer compId);

	void updateCustomerSourceNotCooperate(Integer cityId, Integer compId);
	
	/**
	 * 获取身份证是否重复
	 * @author 张宏利
	 * @since 2017年10月24日
	 * @param cityId
	 * @param compId
	 * @param selfUserId
	 * @param custId
	 * @param isPersonalVersion
	 * @param caseType
	 * @param idCard
	 * @return
	 */
	public boolean getIdCardRepeat(Integer cityId, Integer compId, Integer selfUserId, Integer custId, 
			boolean isPersonalVersion, Integer caseType, String idCard, Integer idCardType);

	/**
	 * 公盘房源数据移交
	 * @author 张宏利
	 * @since 2018年1月19日
	 * @param param
	 */
	public void createTrack4TransData(ErpCreateTrackInfoParam param);

	/**
	 * 数据移交
	 * 
	 * @author 张宏利
	 * @since 2018年4月23日
	 * @param param
	 */
	public void dataTranslate(Integer cityId, ErpFunBuyCustomer updateModel, ErpFunUsers acceptUser,
			List<Integer> caseIds, String[] caseNos, DataTranslateParam param);

	void updateCustomerSourceInfoByDealTaxes(UpdateOrInsertDealTaxesParam param, ErpFunBuyCustomer updateModel, String oldCellphone, String newCellPhone);

	void updateHouseActionTimeBySysParaByOrg(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateHouseTrackTimeByOrg(Integer cityId, Integer compId, String string, List<Integer> orgIds, Integer custIntention);

	void updateHousePublicTimeByOrg(Integer cityId, Integer compId, List<Integer> orgIds);

	void updateCustomerSourceNotCooperateByPartner(Integer cityId, Integer compId, List<Integer> orgIds);

}
