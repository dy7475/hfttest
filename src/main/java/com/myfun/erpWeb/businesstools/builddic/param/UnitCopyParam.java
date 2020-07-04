package com.myfun.erpWeb.businesstools.builddic.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author czq
 * @since 2019/3/20
 */
public class UnitCopyParam implements EncryParamIfc {

    @ApiModelProperty(value = "楼盘ID")
    private Integer buildId;

    @ApiModelProperty(value = "被拷贝的单元ID")
    private Integer copyBuildingSetUnitId;

    @ApiModelProperty(value = "单元名称")
    private String buildUnit;

    @ApiModelProperty(value = "楼层起(地下楼层传负数,例如地下2层: -2)")
    private Integer floorStart;

    @ApiModelProperty(value = "楼层止")
    private Integer floorEnd;

    @ApiModelProperty(value = "房号规则 1=按楼层排号，2=按单元排号")
    private Byte numberRule;

    @ApiModelProperty(value = "多单元通排")
    private Byte addedByAllUnits;

    @ApiModelProperty(value = "组成规则 1(无)=户号，2(楼层)=楼层+户号")
    private Byte compriseRule;

    @ApiModelProperty(value = "组成规则 数字,字母")
    private Byte numberType;

    @ApiModelProperty(value = "梯")
    private String buildLadder;

    @ApiModelProperty(value = "户")
    private String buildDoors;


}