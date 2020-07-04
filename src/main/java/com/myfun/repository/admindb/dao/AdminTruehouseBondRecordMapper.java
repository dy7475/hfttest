package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminTruehouseBondRecord;
import com.myfun.repository.admindb.po.AdminTruehouseBondRecordExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminTruehouseBondRecordMapper extends BaseMapper<AdminTruehouseBondRecord, Integer> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminTruehouseBondRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminTruehouseBondRecordExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminTruehouseBondRecord> selectByExample(AdminTruehouseBondRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminTruehouseBondRecord record, @Param("example") AdminTruehouseBondRecordExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminTruehouseBondRecord record, @Param("example") AdminTruehouseBondRecordExample example);

	/**
	 * 获取真房源保证金充值记录
	 * @author 张宏利
	 * @since 2018年3月19日
	 * @param archiveId 档案ID
	 * @param useStatus 状态：1=有效 2=退款 3=转给c端
	 * @return
	 */
	List<AdminTruehouseBondRecord> getTrueHousePiadList(@Param("archiveId") Integer archiveId, @Param("useStatus") Integer useStatus);
	
	/**
	 * 获取点亮中的真房源记录条数
	 * @author 张宏利
	 * @since 2018年4月4日
	 * @param archiveId
	 * @return
	 */
	Integer getValidTureCount(@Param("archiveId") Integer archiveId);
}