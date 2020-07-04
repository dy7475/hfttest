package com.myfun.service.business.erpdb;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.businesstools.builddic.param.InsertComBuildParam;
import com.myfun.erpWeb.businesstools.builddic.vo.BuildingListInMobileVo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.param.ErpBuildingInfoParam;
import com.myfun.repository.erpdb.param.QueryBuildingListParam;
import com.myfun.repository.erpdb.po.ErpBuildingInfo;
import com.myfun.repository.erpdb.po.ErpBuildingInfoTmp;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.bean.param.BuildingInfoTmpParam;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateBuildInfoParam;

public interface ErpBuildInfoService extends BaseMapper<ErpBuildingInfo, ErpBuildingInfo>{

	/**
	 * 查询列表数据
	 * @param num
	 * @param buildingInfo
	 * @return
	 */
	PageInfo<ErpBuildingInfo> getModelList(ErpBuildingInfoParam buildingInfoParam);

	/**
	 * 验证楼盘名是否重复
	 * @param buildingInfo
	 * @return
	 */
	public int checkBuildName(ErpBuildingInfo buildingInfo);

	/**
	 * 将楼盘移到另外一个城市
	 * @param buildingInfo
	 * @param oldCityId
	 * @param oldProvinceId
	 */
	Integer moveBuildToCity(ErpBuildingInfo buildingInfo, Short oldCityId);

	/**
	 * 设置首图
	 * @param provinceId
	 * @param userId
	 * @param photos
	 * @param photoType
	 * @param cityId
	 * @param buildId
	 */
	void setFirst(Integer provinceId, Integer userId, String photos, String photoType, Short cityId,
			Integer buildId, boolean flag);

	/**
	 * 上架到腾讯
	 * @param provinceId
	 * @param photos
	 * @param photoType
	 * @param cityId
	 * @param buildId
	 */
	void examinPhoto(Integer provinceId, String photos, String photoType, Short cityId, Integer buildId);

	/**
	 *
	 * **/
	List<ErpBuildingInfoDto> getErpBuildingInfo(Short cityId, String buildCode);

//	/**
//	 * 获取楼盘信息
//	 * @param cityId
//	 * @param buildId
//	 * @return
//	 */
//	ErpBuildingInfoDto getErpBuildInfoByid(String cityId, String buildId);

	/**
	 * @author 方李骥
	 * @since 2016年8月31日
	 * @param cityId
	 * @param param
	 */
	CreateOrUpdateBuildInfoParam updateBuildTmpInfo(Integer cityId, CreateOrUpdateBuildInfoParam param);

	/**
	 * @author 方李骥
	 * @since 2016年10月10日
	 * @param cityId
	 * @param param
	 * @throws Exception
	 */
	Object createBuildInfo(Integer cityId,CreateOrUpdateBuildInfoParam param);

	/**
	 * @author wangchun
	 * @since 2018-12-27
	 */
	Object insertComBuild(Integer cityId, InsertComBuildParam param, Operator operator);

	/**
	 * 获取楼盘资料
	 * @author 臧铁
	 * @since 2017年5月31日
	 * @return
	 */
	ErpBuildingInfoDto getErpBuildInfoByid(String cityId,String buildId);

	ErpBuildingInfoDto getBuildInfoById(String buildId, Integer valueOf);
	/**
	 *
	 * @param  * @param param
	 * @author 黄建海
	 * @since 2018/12/27 0027
	 */
    PageInfo<ErpBuildingInfoDto> getBuildingListOffsetPages(QueryBuildingListParam param);

	BuildingListInMobileVo getBuildingListInMobile(QueryBuildingListParam param, GeneralParam generalParam, Integer buildingFlag);
}
