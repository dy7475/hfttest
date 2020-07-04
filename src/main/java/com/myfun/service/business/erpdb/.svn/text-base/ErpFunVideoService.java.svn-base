package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.erpWeb.house.param.DeleteVideoParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.po.ErpFunVideo;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunVideoService extends BaseMapper<ErpFunVideo, ErpFunVideo> {
	
	/**
	 * 根据视频ID查询一个有效视频
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:19:35
	 */
	ErpFunVideo getValidVideoByVideoId(Integer photoId,Integer cityId) throws Exception;
	
	/**
	 * 根据CASE_ID 查询有效视频
	 * @author 陈文超
	 * @date 2016年6月2日 下午4:21:48
	 */
	List<ErpFunVideo> getValidVideoByCondition(Integer caseId , Byte caseType , Integer cityId) throws Exception;

	List<ErpFunVideo> getVideoListOrderByVideoIdDesc(String shardDbName, Integer lastVideoId);

	/**
	 * 删除视频
	 * @author 臧铁
	 * @param param  caseId 房客源ID  caseType 房客源类型  videoId 视频Id caseNo 房客源编号 uploadDeptName uploadUserName cancelTrueFlag
	 * @since 2017年5月18日
	 * @return
	 */
	void deleteVideo(DeleteVideoParam param) throws Exception;
}
