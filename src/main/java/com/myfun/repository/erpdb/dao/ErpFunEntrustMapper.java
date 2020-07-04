package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.mlEntrustManage.param.SelectEntrusListParam;
import com.myfun.erpWeb.managecenter.mlEntrustManage.vo.EntrusListVO;
import com.myfun.repository.erpdb.po.ErpFunEntrust;
import com.myfun.repository.erpdb.po.ErpFunEntrustExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ErpFunEntrustMapper extends BaseMapper<ErpFunEntrust, ErpFunEntrust> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunEntrustExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunEntrustExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunEntrust> selectByExample(ErpFunEntrustExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunEntrust record,@Param("example") ErpFunEntrustExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunEntrust record,@Param("example") ErpFunEntrustExample example);

	/**
	 * 查询委托列表
	 * @author HuangJiang
	 * @since 2019年11月26日 19:05
	 * @param param
	 * @return java.util.List<com.myfun.erpWeb.managecenter.mlEntrustManage.vo.SelectEntrusListVO>
	 * Modified XXX HuangJiang 2019年11月26日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    List<EntrusListVO> selectEntrustList(@Param("shardCityId") Integer cityId, @Param("param") SelectEntrusListParam param);
    
	/**
	 * 修改委托信息
	 * @author HuangJiang
	 * @since 2019年11月27日 20:35
	 * @param erpFunEntrust
	 * @return void
	 * Modified XXX HuangJiang 2019年11月27日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void updateEntrustInfo(ErpFunEntrust erpFunEntrust);
    
	/**
	 * 清空备案
	 * @author HuangJiang
	 * @since 2019年11月28日 13:54
	 * @param erpFunEntrustUpdate
	 * @return void
	 * Modified XXX HuangJiang 2019年11月28日
	 */
	@SwitchDB(type = SwitchDBType.CITY_ID)
    void clearEntrustRecord(ErpFunEntrust erpFunEntrustUpdate);	
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunEntrust> selectByCaseId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseType")Byte caseType,@Param("caseId")Integer caseId,
									   @Param("saleId")Integer saleId,@Param("leaseId")Integer leaseId,@Param("isSaleLease")Byte isSaleLease, @Param("isEffective")Byte isEffective, @Param("shareEntrustData")Byte shareEntrustData);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	int insertNewEntrustJudgeRepeat(ErpFunEntrust erpFunEntrust);	
	
	/**  电子委托通过合同查询委托信息
	* @author 蔡春林
	* @date 2020/1/3 0003
	* @param cityId
	* @param contractId
	* @return ErpFunEntrust
	*/
	@SwitchDB(type = SwitchDBType.CITY_ID)
	ErpFunEntrust selectByContractId(@Param("shardCityId")Integer cityId,@Param("contractId")String contractId);

	/**
	 * @param
	 * @return java.lang.String
	 * @author 蔡春林 查询最的一条电子委托 的委托编号
	 * @date 2020/1/7 0007
	 */
	String selectByEntrustType(@Param("shardCityId") Integer cityId, @Param("electronicEntrustType") Byte electronicEntrustType);

	List<Map<String,Object>> countCroupeByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("rate") BigDecimal rate, @Param("cityRate") BigDecimal cityRate, @Param("organizationId")Integer organizationId, @Param("position")String position, @Param("userId")Integer userId);
	
	@SwitchDB(type = SwitchDBType.CITY_ID)
	void updateEntrust(ErpFunEntrust erpFunEntrust);

	List<ErpFunEntrust> selectSupplementaryDataRecordNo(@Param("shardCityId") Integer cityId);
	}
