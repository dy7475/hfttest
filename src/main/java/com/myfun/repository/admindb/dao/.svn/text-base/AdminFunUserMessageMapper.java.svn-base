package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;

public interface AdminFunUserMessageMapper extends BaseMapper<AdminFunUserMessage, Integer> {

    public void deleteMessage(@Param("caseId")Integer caseId,@Param("caseType") Integer caseType, @Param("msgModule")Integer msgModule, @Param("moduleType")Integer moduleType,@Param("archiveId")Integer archiveId);

    void deleteMessageByCondition(@Param("archiveId")Integer archiveId, @Param("caseId")Integer caseId, @Param("caseType")Byte caseType,@Param("msgModule") Integer msgModule);

    List<AdminFunUserMessage> getMessageBaseInfoList(@Param("archiveId")Integer archiveId);

    List<AdminFunUserMessage> getMessageRichInfoList(@Param("archiveId")Integer archiveId, @Param("msgModule")Integer msgModule);
}