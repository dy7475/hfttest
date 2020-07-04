package com.myfun.repository.erpdb.dao;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpFunRecruitmentChannel;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ErpFunRecruitmentChannelMapper extends BaseMapper<ErpFunRecruitmentChannel, ErpFunRecruitmentChannel> {

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunRecruitmentChannel> selectListByCondition(ErpFunRecruitmentChannel recruitmentChannel);

	Integer getMaxChannelSeqNO(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("seq")Integer seq);

	void updateFunRecruitmentChannelSeq(@Param("shardCityId")Integer cityId,@Param("seq") Integer seq,@Param("channelId") Integer channelId,@Param("symbol")String symbol);

	Integer getMinChannelSeqNO(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("seq")Integer seq);

	void updateFunRecruitmentChannelSeqUp(@Param("shardCityId")Integer cityId,@Param("seq") Integer seq,@Param("channelId") Integer channelId);

	void updateFunRecruitmentChannelSeqDown(@Param("shardCityId")Integer cityId,@Param("seq") Integer seq,@Param("channelId") Integer channelId);
}