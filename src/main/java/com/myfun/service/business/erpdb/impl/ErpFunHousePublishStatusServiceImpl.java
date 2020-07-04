package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.houseBidding.vo.HousePubFlagAllDto;
import com.myfun.repository.admindb.dao.AdminFunHouseBiddingMapper;
import com.myfun.repository.erpdb.dao.ErpFunHouseBiddingMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunHousePublishStatusMapper;
import com.myfun.repository.erpdb.po.ErpFunHousePublishStatus;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunHousePublishStatusService;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErpFunHousePublishStatusServiceImpl extends AbstractService<ErpFunHousePublishStatus, ErpFunHousePublishStatus> implements ErpFunHousePublishStatusService{
	@Autowired
	private ErpFunHousePublishStatusMapper erpFunHousePublishStatusMapper;
	@Autowired
	private ErpFunHouseBiddingMapper erpFunHouseBiddingMapper;
	@Autowired
	private ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	private ErpFunLeaseMapper erpFunLeaseMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunHousePublishStatusMapper;
	}

	@Override
	public ErpFunHousePublishStatus getDataObject(ErpFunHousePublishStatus obj) {
		return erpFunHousePublishStatusMapper.getDataObject(obj);
	}
	
	/**
	 * 获取库存
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/12
	 * @return
	 *
	 */
	@Override
	public HousePubFlagAllDto getHousePubFlagAll(Integer cityId, Integer archiveId, Integer userId, Integer compId,Integer qqPublish) {
		
		Integer extensionNumber = 0; // 上架数
		//查询已推广
		Integer shelfNumber =erpFunHouseBiddingMapper.getShelfNumber(cityId,archiveId);
		if (shelfNumber==null){
			shelfNumber=0;
		}
		
		//已上架
		Integer saleNumber =erpFunSaleMapper.getExtensionNumber(compId,cityId,archiveId,1,false);
		Integer pubNumLeaseNumber=erpFunLeaseMapper.getPubNumLeaseNumber(compId,cityId,archiveId,1,false);
		
		//上架数
		if(saleNumber!=null && pubNumLeaseNumber!=null){
			extensionNumber = saleNumber + pubNumLeaseNumber;
		}
		//出售数
		Integer saleNumber2 =erpFunSaleMapper.getExtensionNumber(compId,cityId,archiveId,null,true);
		if (saleNumber2==null){
			saleNumber2=0;
		}
		// 出租数
		Integer pubNumLeaseNumber2=erpFunLeaseMapper.getPubNumLeaseNumber(compId,cityId,archiveId,null,true);
		if (pubNumLeaseNumber2==null){
			pubNumLeaseNumber2=0;
		}
		
		if (0 == qqPublish){
			shelfNumber = 0;
			extensionNumber = 0;
		}
		HousePubFlagAllDto housePubFlagAllDto = new HousePubFlagAllDto();
		housePubFlagAllDto.setShelfNumBer(shelfNumber);// 推广数
		housePubFlagAllDto.setExtensionNumber(extensionNumber);// 上架数
		housePubFlagAllDto.setHouseNumber(saleNumber2+pubNumLeaseNumber2);// 房源条数
		return housePubFlagAllDto;
	}
	
}
