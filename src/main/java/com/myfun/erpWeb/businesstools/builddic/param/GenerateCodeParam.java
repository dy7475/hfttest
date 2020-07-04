package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2020/2/7
 */
public class GenerateCodeParam implements EncryParamIfc {

    @ApiModelProperty(value = "生成什么层级的唯一编码 1=街道地区(例如华南地区) 2=街道省份 3=街道城市 4=街道行政区 5=街道商圈 6=街道")
    private Byte dataRange;

    @ApiModelProperty(value = "组装的简称中文(名字应该详情上都有)，地区：地区简称如西南" +
            "省：省份简称如四川" +
            "市：省份简称市简称 如四川成都" +
            "区：省份简称+市简称+区简称 如四川成都高新" +
            "街道：市简称" +
            "商圈：市简称")
    private String dataName;

    public Byte getDataRange() {
        return dataRange;
    }

    public void setDataRange(Byte dataRange) {
        this.dataRange = dataRange;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }
}