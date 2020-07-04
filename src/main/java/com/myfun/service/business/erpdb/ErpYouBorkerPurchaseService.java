package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.dto.ErpYouBorkerPurchaseDto;
import com.myfun.repository.erpdb.po.ErpYouBorkerPurchase;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouBorkerPurchaseService extends BaseMapper<ErpYouBorkerPurchase, ErpYouBorkerPurchase>{

	List<ErpYouBorkerPurchaseDto> getPurchaseRecords(ErpYouBorkerPurchase borkerPurchase);

	void sendMsgToParticipant(Integer caseType, Integer cityId, Byte status);

}
