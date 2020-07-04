package com.myfun.erpWeb.managecenter.transaction.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class UpdateCommissioningRulesListParam implements EncryParamIfc {
    @ApiModelProperty(value = "业绩类别Json数据 例：[{\\\"erpFunPerformanceType\\\": {\\ \t\t\"alias\\\": \\\"(string)别名\\\",\\ \t\t\"canDel\\\": \\\"(int32)能否删除：0否、1能\\\",\\ \t\t\"collectionType\\\": \\\"(byte)收款类型 1二手房佣金 2租赁佣金 3新房佣金\\\",\\ \t\t\"commissionType\\\": \\\"(byte)收款方 1房源 2客源 3交易服务\\\",\\ \t\t\"compId\\\": \\\"(int32)公司id\\\",\\ \t\t\"createTime\\\": \\\"(date-time)创建时间\\\",\\ \t\t\"enMsg\\\": \\\"(string)null\\\",\\ \t\t\"isAuto\\\": \\\"(byte)是否使用该比例分配业绩1=是 0=否\\\",\\ \t\t\"isDel\\\": \\\"(byte)是否删除\\\",\\ \t\t\"performanceId\\\": \\\"(int32)主键id,自增\\\",\\ \t\t\"performanceName\\\": \\\"(string)业绩类型名称\\\",\\ \t\t\"performanceProportion\\\": \\\"(number)业绩分配比例\\\",\\ \t\t\"seqNo\\\": \\\"(int32)排序no\\\" \t}, \\\"list\\\": [{\\ \t\"commissionType\\\": \\\"(byte)\\\",\\ \t\"compId\\\": \\\"(int32)公司ID\\\",\\ \t\"createTime\\\": \\\"(date-time)创建时间\\\",\\ \t\"enMsg\\\": \\\"(string)null\\\",\\ \t\"extId\\\": \\\"(int32)主键自增\\\",\\ \t\"extType\\\": \\\"(byte)扩展类型 1=当主业绩类别无所属人时执行当天逻辑,2=从目标业绩类别中扣除\\\",\\ \t\"idDel\\\": \\\"(byte)是否删除\\\",\\ \t\"performanceId\\\": \\\"(int32)业绩类别 ID\\\",\\ \t\"performanceProportion\\\": \\\"(number)比例，仅针对EXT_TYPE=2时有效\\\",\\ \t\"targetPerformanceId\\\": \\\"(int32)目标业绩类别ID\\\",\\ \t\"unionStr\\\": \\\"(string)\\\" }] }, {\\ \t\"erpFunPerformanceType\\\": {\\ \t\"alias\\\": \\\"(string)别名\\\",\\ \t\"canDel\\\": \\\"(int32)能否删除：0否、1能\\\",\\ \t\"collectionType\\\": \\\"(byte)收款类型 1二手房佣金 2租赁佣金 3新房佣金\\\",\\ \t\"commissionType\\\": \\\"(byte)收款方 1房源 2客源 3交易服务\\\",\\ \t\"compId\\\": \\\"(int32)公司id\\\",\\ \t\"createTime\\\": \\\"(date-time)创建时间\\\",\\ \t\"enMsg\\\": \\\"(string)null\\\",\\ \t\"isAuto\\\": \\\"(byte)是否使用该比例分配业绩1=是 0=否\\\",\\ \t\"isDel\\\": \\\"(byte)是否删除\\\",\\ \t\"performanceId\\\": \\\"(int32)主键id,自增\\\",\\ \t\"performanceName\\\": \\\"(string)业绩类型名称\\\",\\ \t\"performanceProportion\\\": \\\"(number)业绩分配比例\\\",\\ \t\"seqNo\\\": \\\"(int32)排序no\\\" }, \\\"list\\\": [{\\ \"commissionType\\\": \\\"(byte)\\\",\\ \"compId\\\": \\\"(int32)公司ID\\\",\\ \"createTime\\\": \\\"(date-time)创建时间\\\",\\ \"enMsg\\\": \\\"(string)null\\\",\\ \"extId\\\": \\\"(int32)主键自增\\\",\\ \"extType\\\": \\\"(byte)扩展类型 1=当主业绩类别无所属人时执行当天逻辑,2=从目标业绩类别中扣除\\\",\\ \"idDel\\\": \\\"(byte)是否删除\\\",\\ \"performanceId\\\": \\\"(int32)业绩类别 ID\\\",\\ \"performanceProportion\\\": \\\"(number)比例，仅针对EXT_TYPE=2时有效\\\",\\ \"targetPerformanceId\\\": \\\"(int32)目标业绩类别ID\\\",\\ \"unionStr\\\": \\\"(string)\\\" }] }]")
    private String performanceJson;
    @ApiModelProperty(value = "抽取总业绩")
    private String paramValue;

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getPerformanceJson() {
        return performanceJson;
    }

    public void setPerformanceJson(String performanceJson) {
        this.performanceJson = performanceJson;
    }
}
