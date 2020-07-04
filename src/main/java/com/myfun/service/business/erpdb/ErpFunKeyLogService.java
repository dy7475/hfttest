package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dto.ErpFunKeyLogDto;
import com.myfun.repository.erpdb.po.ErpFunKeyLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.DestroyKeyParam;

public interface ErpFunKeyLogService extends BaseMapper<ErpFunKeyLog,ErpFunKeyLog>{
	public ErpFunKeyLog getErpFunKeyLogById(Integer cityId,Integer logId);

	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId 城市ID
	 * @param keyId 钥匙ID
	 * @param pageOffSet 页数
	 * @param pageRows 每页多少条
	 * @return
	 * @throws Exception 
	 */
	public PageInfo<ErpFunKeyLogDto> getKeyLogList(Integer cityId, Integer keyId,Integer pageOffSet,Integer pageRows) throws Exception;

	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param param
	 */
	
	
	public void deleteFunKeyLog(DestroyKeyParam param);


	public List<ErpFunKeyLog> getErpFunKeyLogByIds(Integer cityId,
			Set<Integer> logIds);

	public void deleteFunKeyLogByKeyIds(Integer cityId, Integer compId,
			Object[] keyIds);
}
