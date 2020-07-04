package com.myfun.erpWeb.task.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("任务详情")
public class TaskDetailParam implements EncryParamIfc {
    @ApiModelProperty(value="任务ID")
    private Integer taskId;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
