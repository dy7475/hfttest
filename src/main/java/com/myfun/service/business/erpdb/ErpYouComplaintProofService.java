package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.repository.erpdb.po.ErpYouComplaintProof;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpYouComplaintProofService extends BaseMapper<ErpYouComplaintProof, ErpYouComplaintProof>{

	List<ErpYouComplaintProof> getComplaintProosList(Integer cityId, Integer complainId);

}
