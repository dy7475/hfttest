package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.agencydb.param.VStoreEntrustParam;
import com.myfun.repository.agencydb.vo.EntrustVO;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyVipQueue;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyVipQueueMapper extends BaseMapper<AgencyVipQueue, Integer> {
	
	/**
	 * 查询委托列表信息
	 * @author 陈文超
	 * @date 2016年6月15日 下午3:25:27
	 */
	List<AgencyVipQueue> queryVipQueueList(AgencyVipQueue vipQueue) throws Exception;
	/**
	 * 查询委托列表
	 * @author 何传强
	 * @since 2017年8月17日
	 * @param map
	 * @return
	 */
	List<EntrustVO> getVipQueueList(@Param("param") VStoreEntrustParam param);

}