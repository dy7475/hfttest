package com.myfun.service.business.erpdb;

import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.erpdb.param.CaseFavoriteParam;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpFunCaseFavorite;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunCaseFavoriteService extends BaseMapper<ErpFunCaseFavorite, ErpFunCaseFavorite> {
    /**
     * 添加收藏房客源
     * @author 臧铁
     * @param param  compId 公司ID  creationTime 收藏时间  favoriteUid 收藏人 favoriteStatus 收藏状态 1收藏中 ...
     * @since 2017年5月9日
     * @return
     */

	public Integer insertFunCaseFavorite(CaseFavoriteParam param);

	/**
	 * 删除收藏房客源
	 * 
	 * @author 臧铁
	 * @param param
	 *            favoriteId 主键
	 * @since 2017年5月9日
	 * @return
	 */
	public void delCaseFavorite(CaseFavoriteParam param) throws Exception;

	/**
	 * 发送消息给收藏方
	 * @author 张宏利
	 * @since 2017年11月13日
	 * @param cityId
	 * @param compId
	 * @param caseType
	 * @param caseId
	 * @param trackType
	 * @param param 
	 */
	public void sendMsgToFavoriteUser(Integer cityId, Integer compId, Integer selfArchiveId, Integer caseType, Integer caseId, 
			Byte trackType, ErpCreateTrackInfoParam param);
}
