package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminTemplateFunVideo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminTemplateFunVideoMapper {
    /**
     *
     * @mbggenerated
     */
    int insert(AdminTemplateFunVideo record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(AdminTemplateFunVideo record);

    List<AdminTemplateFunVideo> getList();

    void insertForFastDfs(@Param("dfsParamList")List<Map<String, Object>> fastdfsFileList);
}