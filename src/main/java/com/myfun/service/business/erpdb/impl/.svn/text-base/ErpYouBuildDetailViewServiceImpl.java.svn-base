package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpYouBorkerPurchaseMapper;
import com.myfun.repository.erpdb.dao.ErpYouBuildDetailViewMapper;
import com.myfun.repository.erpdb.dto.ErpYouBorkerPurchaseDto;
import com.myfun.repository.erpdb.param.ErpFunRentCustomerParam;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpYouBorkerPurchase;
import com.myfun.repository.erpdb.po.ErpYouBuildDetailView;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpYouBorkerPurchaseService;
import com.myfun.service.business.erpdb.ErpYouBuildDetailViewService;
import com.myfun.utils.Constants_DIC;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ErpYouBuildDetailViewServiceImpl extends AbstractService<ErpYouBuildDetailView, ErpYouBuildDetailView> implements ErpYouBuildDetailViewService {

	@Autowired
	ErpYouBuildDetailViewMapper erpYouBuildDetailViewMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpYouBuildDetailViewMapper;
	}

	@Override
	public void updateYouJia4TransferSystem(ErpFunRentCustomerParam erpFunRentCustomer, Integer caseType, String no) {
		Integer cityId=erpFunRentCustomer.getCityId();
		Integer compId=erpFunRentCustomer.getCompId();
		Integer userId=erpFunRentCustomer.getCreatorUid();
		Integer detailId=erpFunRentCustomer.getDetailId();
		Integer deptId=erpFunRentCustomer.getDeptId();
		if(detailId==null){
			throw new BusinessException("房屋ID不能为空");
		}
		ErpYouBuildDetailView youBuildDetailViewPO = erpYouBuildDetailViewMapper.getYouBuildDetailView(cityId,compId,userId,detailId);
		if(youBuildDetailViewPO == null || youBuildDetailViewPO.getShowPhone()!=1){
			throw new BusinessException("尚未购买明文电话，不能转入系统");
		}
//		ErpYouBuildDetailView updateModel = new ErpYouBuildDetailView();
//		updateModel.setCaseId(erpFunRentCustomer.getRentCustId());
//		updateModel.setCaseType(caseType.byteValue());
//		// 出租写入3，出售写入4
//		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
//			updateModel.setViewStatus(Const.DIC_YOU_BUILD_VIEW_STATUS_3);
//		} else {
//			updateModel.setViewStatus(Const.DIC_YOU_BUILD_VIEW_STATUS_4);
//		}
//		//dao.update(updateModel, condition);
		erpYouBuildDetailViewMapper.updateYouBuildDetailView(cityId,compId,deptId,userId,detailId,erpFunRentCustomer.getRentCustId(),caseType);
	}
}
