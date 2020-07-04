package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.erpWeb.house.param.DeletePanoramaPhotoParam;
import com.myfun.erpWeb.house.param.PanoramaPhotoListParam;
import com.myfun.erpWeb.house.vo.ErpFunPanoramaPhotoVo;
import com.myfun.repository.erpdb.po.ErpFunPanoramaPhoto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunPanoramaPhotoService extends BaseMapper<ErpFunPanoramaPhoto, ErpFunPanoramaPhoto> {
	
	/**
	 * 根据视频ID查询一个有效的全景图片
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:19:35
	 */
	ErpFunPanoramaPhoto getValidPanoramaPhotoByPhotoId(Integer photoId,Integer cityId) throws Exception;
	
	/**
	 * 根据CASE_ID 查询有效的全景图片
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:21:48
	 */
	List<ErpFunPanoramaPhoto> getValidPanoramaPhotosByCondition(Integer caseId , Byte caseType , Integer cityId) throws Exception;

	/**
	 * 获取720图片列表
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型
	 * @since 2017年5月11日
	 * @return
	 */
	List<ErpFunPanoramaPhotoVo> getPanoramaPhotoList(PanoramaPhotoListParam param);

	/**
	 * 删除720图片
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型  photoId被删除的图片ID
	 * @since 2017年5月11日
	 * @return
	 */
	void deletePanoramaPhoto(DeletePanoramaPhotoParam param) throws Exception;
}
