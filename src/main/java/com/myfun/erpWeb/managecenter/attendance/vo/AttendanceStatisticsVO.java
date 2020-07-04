package com.myfun.erpWeb.managecenter.attendance.vo;

import com.myfun.repository.erpdb.dto.ErpFunAttendanceStatisticsDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @create by 程二狗 on 2019/3/12 0012
 **/
@ApiModel
public class AttendanceStatisticsVO implements Serializable{
    @ApiModelProperty("考勤明细数据")
    private List<ErpFunAttendanceStatisticsDto> result;

    public List<ErpFunAttendanceStatisticsDto> getResult() {
        return result;
    }

    public void setResult(List<ErpFunAttendanceStatisticsDto> result) {
        this.result = result;
    }
}
