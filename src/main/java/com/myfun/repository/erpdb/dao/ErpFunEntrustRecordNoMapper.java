package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunEntrustRecordNo;
import com.myfun.repository.erpdb.po.ErpFunEntrustRecordNoExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunEntrustRecordNoMapper extends BaseMapper<ErpFunEntrustRecordNo, ErpFunEntrustRecordNo> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpFunEntrustRecordNoExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpFunEntrustRecordNoExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpFunEntrustRecordNo> selectByExample(ErpFunEntrustRecordNoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpFunEntrustRecordNo record, @Param("example") ErpFunEntrustRecordNoExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpFunEntrustRecordNo record, @Param("example") ErpFunEntrustRecordNoExample example);


    /**
     * @brief 根据委托ID物理删除掉备案编号，因为之前都是置为NULL，所以就物理删除了
     * @detail [2020/5/25 0025] l.x.t  需求ID：story#12328 5.20上线 PC&APP审核页面、系统监控-类型增加新增房源、建筑面积修改、委托资料
     * @param 未知
     * @return 未知
     * @author l.x.t
     * @note
     **/
    @SwitchDB(type = SwitchDBType.CITY_ID)
    void deleteByEntrustId(@Param("shardCityId")Integer cityId,@Param("entrustId") Integer entrustId);

    /**
     * @brief 根据备案编号精准查询出房源ID
     * @detail [2020/5/25 0025] l.x.t  需求ID：story#12328 5.20上线 PC&APP审核页面、系统监控-类型增加新增房源、建筑面积修改、委托资料
     * @param 未知
     * @return 未知
     * @author l.x.t
     * @note
     **/
    @SwitchDB(type = SwitchDBType.CITY_ID)
    List<Integer> selectByRecordNo(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId,@Param("caseNo") String caseNo);
}