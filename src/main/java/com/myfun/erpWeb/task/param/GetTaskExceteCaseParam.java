package com.myfun.erpWeb.task.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("任务执行情况")
public class GetTaskExceteCaseParam extends AbstractEncryParam {
    @ApiModelProperty(value="任务ID")
    private Integer taskId;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
