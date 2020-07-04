package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.axn.param.PhoneBillListParam;
import com.myfun.erpWeb.managecenter.axn.vo.PhoneBillListVO;
import com.myfun.erpWeb.managecenter.axn.vo.PhoneBillVO;
import com.myfun.repository.erpdb.po.ErpAliyunTelephoneBill;
import com.myfun.repository.erpdb.po.ErpAliyunTelephoneBillExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpAliyunTelephoneBillMapper extends BaseMapper<ErpAliyunTelephoneBill, ErpAliyunTelephoneBill> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(ErpAliyunTelephoneBillExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(ErpAliyunTelephoneBillExample example);

    /**
     *
     * @mbggenerated
     */
    List<ErpAliyunTelephoneBill> selectByExample(ErpAliyunTelephoneBillExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ErpAliyunTelephoneBill record, @Param("example") ErpAliyunTelephoneBillExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ErpAliyunTelephoneBill record, @Param("example") ErpAliyunTelephoneBillExample example);
    
    /**
     * 查询话费列表
     * @author HuangJiang
     * @since 2019年12月24日 15:26
     * @param shardCompId
     * @param param
     * @return java.util.List<com.myfun.erpWeb.managecenter.axn.vo.PhoneBillVO>
     * Modified XXX HuangJiang 2019年12月24日
     */
    @SwitchDB(type= SwitchDBType.COMP_ID)
    List<PhoneBillVO> getPhoneBillList(@Param("shardCompId") Integer shardCompId, @Param("param") PhoneBillListParam param);
    
    @SwitchDB(type= SwitchDBType.CITY_ID)
    ErpAliyunTelephoneBill getPhoneBillByMonth(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("suffix") String suffix, @Param("xPhone") String xPhone);
    
    @SwitchDB(type= SwitchDBType.COMP_ID)
    PhoneBillListVO getPhoneBillTotal(@Param("shardCompId") Integer shardCompId, @Param("param") PhoneBillListParam param);
}