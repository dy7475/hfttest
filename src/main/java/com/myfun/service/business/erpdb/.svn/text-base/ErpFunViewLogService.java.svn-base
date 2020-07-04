package com.myfun.service.business.erpdb;

import java.util.Map;

import com.myfun.repository.erpdb.po.ErpFunViewLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunViewLogService extends BaseMapper<ErpFunViewLog, ErpFunViewLog>{
	
	/**
	 * 获取查看条数
	 * @author 张宏利
	 * @since 2017年10月30日
	 * @param cityId
	 * @param selfUserId
	 * @param caseId
	 * @param caseType
	 * @return
	 * @throws Exception 
	 */
	Map<String,Object> detectViewLog(Integer cityId, Integer viewUserId, Integer infoUserId,
			Integer caseId, Integer caseType, Integer saleLeaseId, boolean isGeneralManager,
			Integer compId, Integer deptId,  Integer ownerId, String caseNo, Byte plateType,
			Integer targetDept, String pcname, Byte caseStatus, String currUserName, Integer caseDeptId ,
			Integer trackFromType, Integer selfUserId, String trackContract, Integer isMobileApi);
	
	/**
	 * 写查看日志
	 * @author 方李骥
	 * @since 2017年11月01日
	 * @return
	 * @throws Exception 
	 */
	public ErpFunViewLog createViewLog(Integer cityId, Integer compId, Integer deptId, Integer viewUserId, 
			Integer ownerId, Integer caseId, Byte caseType, String caseNo, Byte plateType,
			Integer targetDept, String pcname, Byte viewStatus, Integer isMobileApi);
}
