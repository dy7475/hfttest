package com.myfun.repository.erpdb.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.houseBidding.ReqHouseBiddPageParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

import com.myfun.repository.erpdb.dto.ErpFunHouseBiddingDto;
import com.myfun.repository.erpdb.mapper.sqlProvider.ErpFunHouseBiddingMapperProvider;
import com.myfun.repository.erpdb.po.ErpFunHouseBidding;
import com.myfun.repository.erpdb.po.ErpFunHouseBiddingExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunHouseBiddingMapper extends BaseMapper<ErpFunHouseBidding, ErpFunHouseBidding> {

    /**
	 * @mbggenerated
	 */
	int countByExample(ErpFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunHouseBidding> selectByExample(ErpFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunHouseBidding record,
			@Param("example") ErpFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunHouseBidding record,
			@Param("example") ErpFunHouseBiddingExample example);

	Map<String, Object> getHistoryPrice(@Param("shardCityId") Integer cityId, @Param("saleLease") Integer saleLease, @Param("houseId") Integer houseId);

    @SelectProvider(type=ErpFunHouseBiddingMapperProvider.class, method="compareBiddPrice")
    @ResultType(Map.class)
    @SwitchDB(type = SwitchDBType.CITY_ID)
    Map<String,Object> compareBiddPrice(@Param("shardCityId")Integer cityId, @Param("saleLease")Integer saleLease, @Param("buildId")Integer buildId,
                                        @Param("biddMoney")Double biddMoney, @Param("houseRoom")Integer houseRoom);
   
 
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunHouseBiddingDto> getHouseBiddingList(@Param("shardCityId")Integer cityId,@Param("pMap")ReqHouseBiddPageParam pMap);

    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<ErpFunHouseBiddingDto> getHouseBiddingListByArchiveId(@Param("shardCityId")Integer cityId,@Param("archiveId")Integer archiveId,@Param("nowTime")String nowTime);
    
    /**
     * 正常优优竞价数量
     * @author 臧铁
     * @since 2017年5月19日
     * @return
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
	Integer count(@Param("shardCityId")Integer cityId, @Param("caseId")Integer caseId, @Param("caseType")Integer caseType);

    /**
     * 通过条件查询竞价列表
     * @author 臧铁
     * @since 2017年7月13日
     * @param erpFunHouseBidding 
     * @return
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunHouseBidding> getBiddingListByCondition(ErpFunHouseBidding erpFunHouseBidding);
    public void updateBiddingEndTime(@Param("shardCityId")Integer cityId,@Param("caseId")Integer caseId,@Param("caseType")Integer caseType,@Param("nowTime")String nowTime);
    
    /**
     * 下架 竞价房源
     * @param cityId
     * @param archiveId
     * @param toLastTime
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void updateBiddingEndTimeToLastTime(@Param("shardCityId")Integer cityId, @Param("archiveIds")List<Integer> archiveIds, @Param("endTime")String endTime, @Param("nowDate")String nowDate);
	
    /**
     * 获取已推广数
     * @param
     * @auther 胡坤
     * @since 2018/4/12
     * @return
     *
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
	Integer getShelfNumber(@Param("shardCityId") Integer cityId, @Param("archiveId") Integer archiveId);

    List<ErpFunHouseBidding> getFunHouseBiddingList(@Param("shardCityId")Integer cityId,@Param("yyStatus") Integer yyStatus,@Param("caseType") Integer caseType,@Param("ids") List<Integer> ids);
	
    /**
     * 查询推广情况
     * @param
     * @auther 胡坤
     * @since 2018/5/7
     * @return
     *
     */
    @SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunHouseBidding> getBiddingListByCaseIds(@Param("shardCityId")Integer cityId,@Param("ids") Integer[] ids,@Param("caseType") Integer caseType,@Param("yyStatus") Integer yyStatus,@Param("date") Date date);

	void updateFunHouseBiddingYyStatus(@Param("shardCityId")Integer cityId, @Param("caseType")Integer caseType,@Param("caseId") Integer caseId,@Param("archiveId") Integer archiveId);

	List<Map<String, Object>>  biddSeqData(@Param("shardCityId")Integer cityId,@Param("caseType") Integer caseType,@Param("houseIds") String houseIds);
}