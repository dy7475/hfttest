package com.myfun.service.business.admindb;

import com.myfun.repository.admindb.po.AdminCompGiftCoinRecord;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminCompGiftCoinRecordService extends BaseMapper<AdminCompGiftCoinRecord, Integer> {

	/**
	 * 赠送好房豆
	 * @author 尹振兴
	 * @since 2018年5月31日
	 * @param archiveId
	 */
	public void giftCompCoin(Integer archiveId);

	/***
	 * 拼接营销版是否赠送好房豆文案
	 * @author 尹振兴
	 * @since 2018年6月2日
	 * @param compType
	 * @param compNo
	 * @param deptNo
	 */
	public String getAlterMsg(Integer compType,String compNo,String deptNo);

}