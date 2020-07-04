package com.myfun.repository.admindb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.usercenter.param.CrmFunContractParam;
import com.myfun.repository.admindb.dto.SoftContractDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.dto.AdminCrmFunContrackDto;
import com.myfun.repository.admindb.param.AdminCrmFunContrackParam;
import com.myfun.repository.admindb.po.AdminCrmFunContract;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminCrmFunContractExample;

public interface AdminCrmFunContractMapper extends BaseMapper<AdminCrmFunContract, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminCrmFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminCrmFunContractExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminCrmFunContract> selectByExampleWithBLOBs(AdminCrmFunContractExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminCrmFunContract> selectByExample(AdminCrmFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminCrmFunContract record,
			@Param("example") AdminCrmFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleWithBLOBs(@Param("record") AdminCrmFunContract record,
			@Param("example") AdminCrmFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminCrmFunContract record,
			@Param("example") AdminCrmFunContractExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminCrmFunContract record);

	/**
     * 查询合同
     * @param deptId
     * @return
     */
	AdminCrmFunContract selectContract(Integer deptId);
	
	/**
	 * 删除合同
	 * @param deptId
	 */
	void deleteByDeptId(Integer deptId);
	
	/**
	 * 查询合同列表
	 * @param adminCrmFunContrackParam
	 * @return
	 */
	List<AdminCrmFunContrackDto> query(AdminCrmFunContrackParam adminCrmFunContrackParam);
	
	/**
	 * 根据门店Id获取门店信息
	 * @param deptid
	 * @return
	 */
	AdminCrmFunContract selectByPrimaryByDeptId(String deptid);
	
	/**
	 * 修改合同信息
	 * @param adminCrmFunContract
	 */
	void updateBydeptId(AdminCrmFunContract adminCrmFunContract);
	
	/**
	 * 赠?增值服?
	 * @param compNo
	 * @param deptNo
	 * @param giftMonth
	 * @param reason
	 * @param userId
	 * @return
	 */
	int call_PROC_SPEC_RECORD_COMGIFT( Map<String, Object> param);
	
	/**
	 * 升级会员存储过程
	 * @param parms
	 * @return
	 */
	int call_PROC_SPEC_RECORD_CUST_LEVEL(Map<String, Object> parms);
	
	/**
	 * 删除公司?对应的所有合?
	 * @param compId
	 */
	void deleteRecordsByCompId(Integer compId);
	
	/**
	 * 执行升级操作
	 * @param parms
	 */
	void call_proc_upgradeVersion(Map<String, Object> parms);
	
	/**
	 * 生成合同编号
	 * @param string
	 * @return
	 */
	AdminCrmFunContract generatNo(String pref);
	
	/**
	 * ?通微信公众号代理商返?
	 * @param parms
	 */
	String call_proc_pay4Weixin(Map<String, Object> parms);
	
	/**
	 * 购买增?服?
	 * @param parms
	 */
	void call_proc_buyVip(Map<String, Object> parms);
	
	/**
	 * ?通空?
	 * @param parms
	 */
	void call_proc_restore_space(Map<String, Object> parms);
	
	/**
	 * ?通Oto续费
	 * @param parms
	 */
	void call_proc_restore_o2o(Map<String, Object> parms);

	/**
	 * 修改合同签订的门店id
	 * @param deptIdNew
	 * @param deptIdOld
	 */
	void updateDeptIdByDeptId(@Param("deptIdNew") Integer deptIdNew, @Param("deptIdOld") Integer deptIdOld);

	/**
	 * 修改admin库新门店的付款信?
	 * @param deptIdNew
	 * @param deptIdOld
	 */
	void updatePayment(@Param("deptIdNew") Integer deptIdNew, @Param("deptIdOld") Integer deptIdOld);

	/**
	 *  回访赠?查询合同情?
	 * @param deptId
	 * @return
	 */
	AdminCrmFunContract selectSendGiftContract(Integer deptId);
	
	/**
	 * 修改很痛赠送信息
	 * @param adminCrmFunContract
	 */
	void updateContract(AdminCrmFunContract adminCrmFunContract);
	
	/**
	 *  向ERP用户帐户写入信息
	 * @param parms
	 */
	void call_proc_Crm_Virement(Map<String, Object> parms);

    void insertForFastDfs(@Param("dfsParamList") List<Map<String, Object>> pMap);

    SoftContractDto getSoftContract(@Param("adminDeptId")Integer adminDeptId);

	List<AdminCrmFunContrackDto> getDeptListForContract(@Param("param")CrmFunContractParam param);
}