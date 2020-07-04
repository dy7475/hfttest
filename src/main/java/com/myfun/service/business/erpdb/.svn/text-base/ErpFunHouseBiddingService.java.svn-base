package com.myfun.service.business.erpdb;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.houseBidding.ReqHouseBiddPageParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.DataTranslateParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dto.ErpFunHouseBiddingDto;
import com.myfun.repository.erpdb.po.ErpFunHouseBidding;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;
import java.util.Map;

public interface ErpFunHouseBiddingService extends BaseMapper<ErpFunHouseBidding, ErpFunHouseBidding>{

	/** 查询推广账户信息 **/
	Map<String,Object> getUserAccountInfo(Map<String, Object> param);
	/** 查询历史价格 **/
    Map<String,Object> getHistoryBiddPrice(Map<String, Object> pMap) throws Exception;

    Map<String,Object> getHouseInfoSEQ(Map<String, Object> pMap) throws Exception;

	PageInfo<ErpFunHouseBiddingDto> getHouseBiddingList(ReqHouseBiddPageParam pMap);
	
	/**
	 * 获取本人楼盘房源数量
	 * @author 张宏利
	 * @since 2017年3月9日
	 * @param cityId 城市ID
	 * @param userId 用户ID
	 * @param buildId 楼盘ID
	 * @param archiveId 档案ID
	 * @return
	 */
	Map<String, Object> getBuildHouseCount(Integer cityId, Integer userId, Integer buildId, Integer archiveId) throws BusinessException;

	/**
	 * 优优竞价  下架逻辑并 写房源跟进
	 * @author 臧铁
	 * @param downType  1:熄灭优优 2:熄灭真房源 3:加密 4:封盘  5:内成家 6:外成交 7:注销 8:删除视频 9:删除图片 10:数据移交
	 * @since 2017年5月19日
	 * @return
	 */
	void downBiddingYY(Integer cityId,Integer caseId, Integer caseType, String caseNo, Integer downType) ;
	
	List<ErpFunHouseBiddingDto> getBuildBiddInfo(Map<String, Object> pMap);

    void updateHouse4TransDataArchiveId(Integer dicCaseTypeSaleFun, List<Integer> caseIds,  DataTranslateParam param);

	List<ErpFunHouseBidding> getBiddingListByCaseIds(List<Integer> ids, Integer cityId, Integer saleLease, Integer yyStatus);
	
	public Map<String, String> updateHouseBidding(Integer cityId,Boolean personalVersion,Map<String, Object> pMap) throws Exception;
}
