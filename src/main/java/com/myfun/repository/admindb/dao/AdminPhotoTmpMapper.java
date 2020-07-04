package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminPhotoTmp;
import com.myfun.repository.admindb.po.AdminPhotoTmpExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPhotoTmpMapper extends BaseMapper<AdminPhotoTmp, String> {
    /**
     *
     * @mbggenerated
     */
    int countByExample(AdminPhotoTmpExample example);

    /**
     *
     * @mbggenerated
     */
    int deleteByExample(AdminPhotoTmpExample example);

    /**
     *
     * @mbggenerated
     */
    List<AdminPhotoTmp> selectByExample(AdminPhotoTmpExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AdminPhotoTmp record, @Param("example") AdminPhotoTmpExample example);

    /**
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AdminPhotoTmp record, @Param("example") AdminPhotoTmpExample example);

	void deleteByEcardAddr(@Param("ecardAddr") String ecardAddr);
	
	/**
	 * 根据地址获取列表
	 * @author 熊刚
	 * @since 2017年10月27日
	 * @param urlsArr
	 * @return
	 */
	List<AdminPhotoTmp> getErpFunPhotoTmpList(@Param("urlsArr")String[] urlsArr);
	
	void updatePhotoTmp(@Param("urlsArr")String[] urlsArr);
}