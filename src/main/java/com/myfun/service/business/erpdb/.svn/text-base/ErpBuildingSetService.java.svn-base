/**
 * @author 方李骥
 * @since 2016年9月2日
 */
package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.businesstools.builddic.param.CopyTempParam;
import com.myfun.repository.erpdb.param.ErpBuildingSetParam;
import com.myfun.repository.erpdb.po.ErpBuildingSet;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @author 方李骥
 * @since 2016年9月2日
 */
public interface ErpBuildingSetService extends BaseMapper<ErpBuildingSet, ErpBuildingSet> {
	
	void updateLockBuildRule(ErpBuildingSet conditionModel, Integer lockFlag,Integer userId, Integer deptId);
	
	void batchImporFunBuildRules(ErpBuildingSetParam param);
	
	/**
	 * 重新计算栋、单元、房间数
	 * @author 张宏利
	 * @since 2017年8月28日
	 * @param param
	 */
	void createBuildRoofunitdoors(ErpBuildingSetParam param);

	/**
	 * 删除栋座
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座 
	 * @return
	 */
	void delBuildRoofById(ErpBuildingSetParam param);

	/**
	 * 删除单元
	 * @author 臧铁
	 * @since 2017年8月25日
	 * @param param compId buildId  buildRoof栋座   buildUnit单元
	 * @return
	 */
	void delBuildUnitById(ErpBuildingSetParam param);
	
	/**
	 * 修改单元信息
	 * @author 张宏利
	 * @since 2017年9月7日
	 * @param param
	 */
	void updateBuildRule(ErpBuildingSetParam param);
	
	/**
	 * 修改栋信息
	 * @author 张宏利
	 * @since 2017年9月7日
	 * @param param
	 */
	void updateBuildRoof(ErpBuildingSetParam param);
	
	void copyTempBuildRule(CopyTempParam param, Integer cityId, Integer compId, Integer userId, String compNo, Integer provenceId);

	/**
	 * 删除规则
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/8/6
	 */
	void delBuildById(ErpBuildingSetParam param);
}
