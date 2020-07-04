package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.house.vo.EntrustCertificateVO;
import com.myfun.repository.erpdb.po.ErpFunEntrustCertificate;
import com.myfun.repository.erpdb.po.ErpFunEntrustCertificateExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ErpFunEntrustCertificateMapper extends BaseMapper<ErpFunEntrustCertificate, ErpFunEntrustCertificate> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEntrustCertificateExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEntrustCertificateExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunEntrustCertificate> selectByExample(ErpFunEntrustCertificateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunEntrustCertificate record,
			@Param("example") ErpFunEntrustCertificateExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunEntrustCertificate record,
			@Param("example") ErpFunEntrustCertificateExample example);

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<EntrustCertificateVO> selectByEntrustIds(@Param("shardCityId") Integer cityId, @Param("entrustIds") List<Integer> entrustIds);
    
	/**
	 * 修改产证号信息
	 * @author HuangJiang
	 * @since 2019年11月27日 21:16
	 * @param erpFunEntrustCertificate
	 * @return void
	 * Modified XXX HuangJiang 2019年11月27日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void updateCertificateInfo(ErpFunEntrustCertificate erpFunEntrustCertificate);
}