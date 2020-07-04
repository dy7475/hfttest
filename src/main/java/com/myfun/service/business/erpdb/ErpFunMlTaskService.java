package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.task.param.SendTaskParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.erpdb.po.ErpFunMlTask;
import com.myfun.repository.erpdb.po.ErpFunMsg;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.Date;
import java.util.List;

public interface ErpFunMlTaskService extends BaseMapper<ErpFunMlTask, ErpFunMlTask> {
    Integer insertSendNowTask(Operator operator, SendTaskParam sendTaskParam);
    void insertTimedTask(Operator operator, SendTaskParam sendTaskParam);
    void appSendMsg(ErpFunOrganization organization, List<ErpFunMlTask> erpFunMlTaskList);
	void completeTask(Integer cityId, Integer compId, Integer userId, Date taskCompleteTime, ErpFunMlTask erpFunMlTask);
}
