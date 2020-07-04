package com.myfun.erpWeb.task.api;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.build.param.UploadBuildingPhotoParam;
import com.myfun.erpWeb.build.vo.ErpBuildingPhotoListVO;
import com.myfun.erpWeb.task.param.*;
import com.myfun.erpWeb.task.vo.*;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.support.constant.Const;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "任务模块控制器", value = "任务模块控制器")
@RequestMapping(value = "/mlTask")
public interface TaskApi {
    @ApiOperation(value = "发布任务")
    @ApiImplicitParam(dataTypeClass = SendTaskParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "发送成功", response = SendTaskVO.class) })
    @PostMapping("/sendTask")
    ResponseJson sendTask(@RequestBody SendTaskParam sendTaskParam) throws Exception;

    @ApiOperation(value = "任务详情")
    @ApiImplicitParam(dataTypeClass = TaskDetailParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "", response = TaskDetailVO.class) })
    @PostMapping("/taskDetail")
    ResponseJson taskDetail(@RequestBody TaskDetailParam taskDetailParam) throws Exception;

    @ApiOperation(value = "结束任务")
    @ApiImplicitParam(dataTypeClass = CompleteTaskParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = CompleteTaskVO.class) })
    @PostMapping("/completeTask")
    ResponseJson completeTask(@RequestBody CompleteTaskParam completeTaskParam) throws Exception;

    @ApiOperation(value = "任务执行情况")
    @ApiImplicitParam(dataTypeClass = CompleteTaskParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "成功", response = TaskDetailTaskVO.class) })
    @PostMapping("/getTaskExceteCase")
    ResponseJson getTaskExceteCase(@RequestBody GetTaskExceteCaseParam completeTaskParam) throws Exception;

    @ApiOperation(value = "任务列表")
    @ApiImplicitParam(dataTypeClass = TaskListParam.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "", response = TaskListVO.class) })
    @PostMapping("/taskList")
    ResponseJson taskList(@RequestBody TaskListParam taskListParam) throws Exception;
}
