package com.myfun.repository.admindb.dao;

import com.myfun.erpWeb.common.vo.AdminTrackCommonLanguageVo;
import com.myfun.repository.admindb.po.AdminTrackCommonLanguage;
import com.myfun.repository.admindb.po.AdminTrackCommonLanguageExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminTrackCommonLanguageMapper extends BaseMapper<AdminTrackCommonLanguage, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminTrackCommonLanguageExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminTrackCommonLanguageExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminTrackCommonLanguage> selectByExample(AdminTrackCommonLanguageExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminTrackCommonLanguage record, @Param("example") AdminTrackCommonLanguageExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminTrackCommonLanguage record, @Param("example") AdminTrackCommonLanguageExample example);

    List<AdminTrackCommonLanguageVo> getTrackCommonLanuageVoList();
}