package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.businesstools.builddic.param.*;
import com.myfun.erpWeb.businesstools.builddic.vo.BuildUnitDetailsInMobileVo;
import com.myfun.erpWeb.businesstools.builddic.vo.BuildUnitRuleInMobileVo;
import com.myfun.erpWeb.businesstools.builddic.vo.ErpbuildingSetUnitByRoofIdListVO;
import com.myfun.erpWeb.businesstools.builddic.vo.UnitDetailsVo;
import com.myfun.repository.erpdb.po.ErpBuildingSetUnit;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

/**
 * @author czq
 * @since 2018/12/17
 */
public interface ErpBuildingSetUnitService extends BaseMapper<ErpBuildingSetUnit, ErpBuildingSetUnit> {

    /**
     * 根据楼栋ID获取楼盘栋座信息
     *
     * @param param ErpBuildingGetRoomInfoListIdParam
     * @author czq
     * @since 2018年12月17日
     */
    void delBuildUnit(ErpBuildingSetUnitIdParam param, Integer cityId, Integer compId, Integer userId);

    /**
     * 编辑单元
     *
     * @param param ErpBuildingSetUnitParam
     * @author czq
     * @since 2018年12月18日
     */
    String updateBuildUnit(ErpBuildingSetUnitParam param, Integer cityId, Integer compId, Integer userId);

    /**
     *
     * @param param
     * @param
     * @author 黄建海
     * @since 2018年12月18日
     */
    ErpbuildingSetUnitByRoofIdListVO getBuildSetUnitByRoofId(ErpbuildingSetUnitByRoofIdParam param, Integer compId,Integer cityId);

    /**
     * 添加单元
     *
     * @param param ErpBuildingSetUnitAddParam
     * @author czq
     * @since 2018年12月19日
     */
    String addBuildUnit(ErpBuildingSetUnitAddParam param, Integer cityId, Integer compId, Integer userId, Integer provinceId, String compNo);

    void updateLockBuildRule(Integer cityId, Integer compId,String compNo,Integer provinceId, Integer buildId ,Integer buildLock, Integer userId, Integer deptId);

    /**
     * 增加单元或者号位
     *
     * @param param        UnitSingleAddParam
     * @param generalParam GeneralParam
     * @return units 用逗号分隔开的单元ID的字符串
     * @author czq
     * @since 2019年3月26日
     */
    String addBuildUnitV2(UnitSingleAddParam param, GeneralParam generalParam, boolean isCopy);

    /**
     * 编辑单元
     *
     * @param param        UnitEditParam
     * @param generalParam GeneralParam
     * @return units 用逗号分隔开的单元ID的字符串
     * @author czq
     * @since 2019年3月27日
     */
    String updateBuildUnitV2(UnitEditParam param, GeneralParam generalParam);

    /**
     * 获取单元或者号位详情(编辑或者复制时使用)
     *
     * @param param        GetBuildUnitRuleParam
     * @param generalParam GeneralParam
     * @return RoofDetailsVo
     * @author czq
     * @since 2019年3月28日
     */
    UnitDetailsVo getBuildUnitRuleV2(GetBuildUnitRuleParam param, GeneralParam generalParam);

    /**
     * 首次创建号位
     *
     * @param param        GetBuildUnitRuleParam
     * @param generalParam GeneralParam
     * @return RoofDetailsVo
     * @author czq
     * @since 2019年3月28日
     */
    String addBuildUnitRule(BuildUnitRuleAddParam param, GeneralParam generalParam);

    /**
     * 移动端获取号位规则列表
     *
     * @param param        BuildIdInMobileParam
     * @param generalParam GeneralParam
     * @return BuildUnitRuleInMobileVo
     * @author czq
     * @since 2019年4月8日
     */
    BuildUnitRuleInMobileVo getBuildUnitListInMobile(BuildIdInMobileParam param, GeneralParam generalParam);

    /**
     * 移动端获取号位详情
     *
     * @param param        BuildIdInMobileParam
     * @param generalParam GeneralParam
     * @return BuildUnitDetailsInMobileVo
     * @author czq
     * @since 2019年4月8日
     */
    BuildUnitDetailsInMobileVo getBuildUnitDetailsInMobile(BuildUnitIdParam param, GeneralParam generalParam);

}