package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.po.ErpFunPersonnelLevels;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunPersonnelLevelsMapper extends BaseMapper<ErpFunPersonnelLevels, ErpFunPersonnelLevels> {

	@SwitchDB(type = SwitchDBType.CITY_ID)
	List<ErpFunPersonnelLevels> selectListByCondition(ErpFunPersonnelLevels erpFunPersonnelLevels);

    Integer getMaxLevelsSeqNO(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("seq")Integer seq);


    Integer getMinLevelsSeqNO(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("seq")Integer seq);

    void updateFunPersonnelLevelsSeqUp(@Param("shardCityId")Integer cityId,@Param("seq") Integer seq,@Param("levelsId") Integer levelsId);

    void updateFunPersonnelLeveLsSeqDown(@Param("shardCityId")Integer cityId,@Param("seq") Integer seq,@Param("levelsId") Integer levelsId);
}