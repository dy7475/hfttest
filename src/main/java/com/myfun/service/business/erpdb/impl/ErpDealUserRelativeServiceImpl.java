package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpDealUserRelativeMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpDealUserRelative;
import com.myfun.repository.erpdb.po.ErpDealUserRelativeExample;
import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpDealUserRelativeService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ErpDealUserRelativeServiceImpl extends AbstractService<ErpDealUserRelative, ErpDealUserRelative> implements ErpDealUserRelativeService {
	@Autowired
	ErpDealUserRelativeMapper erpDealUserRelativeMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpFunOrganizationService erpFunOrganizationService;

	@Override
	public void setBaseMapper() {
		super.baseMapper=erpDealUserRelativeMapper;
	}

	@Transactional
	@Override
	public void createDealUserRelative(Integer cityId, Integer compId, ErpFunDeal funDeal) {
		if (funDeal==null){
			return;
		}
		ErpDealUserRelativeExample dealUserRelativeExample=new ErpDealUserRelativeExample();
		dealUserRelativeExample.setShardCityId(cityId);
		dealUserRelativeExample.createCriteria().andCompIdEqualTo(compId).andDealIdEqualTo(funDeal.getDealId()).andRelateTypeNotEqualTo(Const.DIC_RELATE_TYPE_STEPUSER);
		erpDealUserRelativeMapper.deleteByExample(dealUserRelativeExample);
		Integer creator = funDeal.getCreatorUid();
		Integer dealUser = funDeal.getDealUserId();
		Integer signUser = funDeal.getSignUserId();
		Integer signManage = funDeal.getSignManagerId();
		Integer houseUser = funDeal.getHouseUserUid();
		Integer custUser = funDeal.getCustUserUid();
		ErpFunUsers funUsers=null;
		List<ErpDealUserRelative> list = new ArrayList<>();
		if (null!=creator){
			funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, creator);
			ErpDealUserRelative dealUserRelative=new ErpDealUserRelative();
			dealUserRelative.setCompId(compId);
			dealUserRelative.setArchiveId(funUsers.getArchiveId());
			dealUserRelative.setAreaId(funUsers.getAreaId());
			dealUserRelative.setDealId(funDeal.getDealId());
			dealUserRelative.setRegId(funUsers.getRegId());
			dealUserRelative.setDeptId(funUsers.getDeptId());
			dealUserRelative.setGrId(funUsers.getGrId());
			dealUserRelative.setRelateType(Const.DIC_RELATE_TYPE_CREATOR);
			dealUserRelative.setUserId(creator);
			dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
			dealUserRelative.setOrg1(funUsers.getOrg1());
			dealUserRelative.setOrg2(funUsers.getOrg2());
			dealUserRelative.setOrg3(funUsers.getOrg3());
			dealUserRelative.setOrg4(funUsers.getOrg4());
			dealUserRelative.setOrg5(funUsers.getOrg5());
			dealUserRelative.setOrg6(funUsers.getOrg6());
			dealUserRelative.setOrg7(funUsers.getOrg7());
			dealUserRelative.setOrg8(funUsers.getOrg8());
			dealUserRelative.setOrg9(funUsers.getOrg9());
			dealUserRelative.setOrg10(funUsers.getOrg10());
			dealUserRelative.setOrg11(funUsers.getOrg11());
			dealUserRelative.setOrg12(funUsers.getOrg12());
			dealUserRelative.setOrg13(funUsers.getOrg13());
			dealUserRelative.setOrg14(funUsers.getOrg14());
			list.add(dealUserRelative);
		}
		if(dealUser!=null){
			funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, dealUser);
			ErpDealUserRelative dealUserRelative = new ErpDealUserRelative();
			dealUserRelative.setCompId(compId);
			dealUserRelative.setArchiveId(funUsers.getArchiveId());
			dealUserRelative.setAreaId(funUsers.getAreaId());
			dealUserRelative.setDealId(funDeal.getDealId());
			dealUserRelative.setRegId(funUsers.getRegId());
			dealUserRelative.setDeptId(funUsers.getDeptId());
			dealUserRelative.setGrId(funUsers.getGrId());
			dealUserRelative.setRelateType(Const.DIC_RELATE_TYPE_DEALUSER);
			dealUserRelative.setUserId(dealUser);
			dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
			dealUserRelative.setOrg1(funUsers.getOrg1());
			dealUserRelative.setOrg2(funUsers.getOrg2());
			dealUserRelative.setOrg3(funUsers.getOrg3());
			dealUserRelative.setOrg4(funUsers.getOrg4());
			dealUserRelative.setOrg5(funUsers.getOrg5());
			dealUserRelative.setOrg6(funUsers.getOrg6());
			dealUserRelative.setOrg7(funUsers.getOrg7());
			dealUserRelative.setOrg8(funUsers.getOrg8());
			dealUserRelative.setOrg9(funUsers.getOrg9());
			dealUserRelative.setOrg10(funUsers.getOrg10());
			dealUserRelative.setOrg11(funUsers.getOrg11());
			dealUserRelative.setOrg12(funUsers.getOrg12());
			dealUserRelative.setOrg13(funUsers.getOrg13());
			dealUserRelative.setOrg14(funUsers.getOrg14());
			list.add(dealUserRelative);
		}
		if(null!=signUser){
			funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, signUser);
			ErpDealUserRelative dealUserRelative = new ErpDealUserRelative();
			dealUserRelative.setCompId(compId);
			dealUserRelative.setArchiveId(funUsers.getArchiveId());
			dealUserRelative.setAreaId(funUsers.getAreaId());
			dealUserRelative.setDealId(funDeal.getDealId());
			dealUserRelative.setRegId(funUsers.getRegId());
			dealUserRelative.setDeptId(funUsers.getDeptId());
			dealUserRelative.setGrId(funUsers.getGrId());
			dealUserRelative.setRelateType(Const.DIC_RELATE_TYPE_SIGNUSER);
			dealUserRelative.setUserId(signUser);
			dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
			dealUserRelative.setOrg1(funUsers.getOrg1());
			dealUserRelative.setOrg2(funUsers.getOrg2());
			dealUserRelative.setOrg3(funUsers.getOrg3());
			dealUserRelative.setOrg4(funUsers.getOrg4());
			dealUserRelative.setOrg5(funUsers.getOrg5());
			dealUserRelative.setOrg6(funUsers.getOrg6());
			dealUserRelative.setOrg7(funUsers.getOrg7());
			dealUserRelative.setOrg8(funUsers.getOrg8());
			dealUserRelative.setOrg9(funUsers.getOrg9());
			dealUserRelative.setOrg10(funUsers.getOrg10());
			dealUserRelative.setOrg11(funUsers.getOrg11());
			dealUserRelative.setOrg12(funUsers.getOrg12());
			dealUserRelative.setOrg13(funUsers.getOrg13());
			dealUserRelative.setOrg14(funUsers.getOrg14());
			list.add(dealUserRelative);
		}
		if(null!=signManage){
			funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, signManage);
			ErpDealUserRelative dealUserRelative = new ErpDealUserRelative();
			dealUserRelative.setCompId(compId);
			dealUserRelative.setArchiveId(funUsers.getArchiveId());
			dealUserRelative.setAreaId(funUsers.getAreaId());
			dealUserRelative.setDealId(funDeal.getDealId());
			dealUserRelative.setRegId(funUsers.getRegId());
			dealUserRelative.setDeptId(funUsers.getDeptId());
			dealUserRelative.setGrId(funUsers.getGrId());
			dealUserRelative.setRelateType(Const.DIC_RELATE_TYPE_SIGNMANAGE);
			dealUserRelative.setUserId(signManage);
			dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
			dealUserRelative.setOrg1(funUsers.getOrg1());
			dealUserRelative.setOrg2(funUsers.getOrg2());
			dealUserRelative.setOrg3(funUsers.getOrg3());
			dealUserRelative.setOrg4(funUsers.getOrg4());
			dealUserRelative.setOrg5(funUsers.getOrg5());
			dealUserRelative.setOrg6(funUsers.getOrg6());
			dealUserRelative.setOrg7(funUsers.getOrg7());
			dealUserRelative.setOrg8(funUsers.getOrg8());
			dealUserRelative.setOrg9(funUsers.getOrg9());
			dealUserRelative.setOrg10(funUsers.getOrg10());
			dealUserRelative.setOrg11(funUsers.getOrg11());
			dealUserRelative.setOrg12(funUsers.getOrg12());
			dealUserRelative.setOrg13(funUsers.getOrg13());
			dealUserRelative.setOrg14(funUsers.getOrg14());
			list.add(dealUserRelative);
		}
		if(null!=houseUser && houseUser > 0){
			funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, houseUser);
			ErpDealUserRelative dealUserRelative = new ErpDealUserRelative();
			dealUserRelative.setCompId(compId);
			dealUserRelative.setArchiveId(funUsers.getArchiveId());
			dealUserRelative.setAreaId(funUsers.getAreaId());
			dealUserRelative.setDealId(funDeal.getDealId());
			dealUserRelative.setRegId(funUsers.getRegId());
			dealUserRelative.setDeptId(funUsers.getDeptId());
			dealUserRelative.setGrId(funUsers.getGrId());
			dealUserRelative.setRelateType(Const.DIC_RELATE_TYPE_HOUSEUSER);
			dealUserRelative.setUserId(houseUser);
			dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
			dealUserRelative.setOrg1(funUsers.getOrg1());
			dealUserRelative.setOrg2(funUsers.getOrg2());
			dealUserRelative.setOrg3(funUsers.getOrg3());
			dealUserRelative.setOrg4(funUsers.getOrg4());
			dealUserRelative.setOrg5(funUsers.getOrg5());
			dealUserRelative.setOrg6(funUsers.getOrg6());
			dealUserRelative.setOrg7(funUsers.getOrg7());
			dealUserRelative.setOrg8(funUsers.getOrg8());
			dealUserRelative.setOrg9(funUsers.getOrg9());
			dealUserRelative.setOrg10(funUsers.getOrg10());
			dealUserRelative.setOrg11(funUsers.getOrg11());
			dealUserRelative.setOrg12(funUsers.getOrg12());
			dealUserRelative.setOrg13(funUsers.getOrg13());
			dealUserRelative.setOrg14(funUsers.getOrg14());
			list.add(dealUserRelative);
		}
		if(null!=custUser && custUser > 0){
			funUsers = erpFunUsersMapper.getFunUserByUserId(cityId, custUser);
			ErpDealUserRelative dealUserRelative = new ErpDealUserRelative();
			dealUserRelative.setCompId(compId);
			dealUserRelative.setArchiveId(funUsers.getArchiveId());
			dealUserRelative.setAreaId(funUsers.getAreaId());
			dealUserRelative.setDealId(funDeal.getDealId());
			dealUserRelative.setRegId(funUsers.getRegId());
			dealUserRelative.setDeptId(funUsers.getDeptId());
			dealUserRelative.setGrId(funUsers.getGrId());
			dealUserRelative.setRelateType(Const.DIC_RELATE_TYPE_CUSTUSER);
			dealUserRelative.setUserId(custUser);
			dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
			dealUserRelative.setOrg1(funUsers.getOrg1());
			dealUserRelative.setOrg2(funUsers.getOrg2());
			dealUserRelative.setOrg3(funUsers.getOrg3());
			dealUserRelative.setOrg4(funUsers.getOrg4());
			dealUserRelative.setOrg5(funUsers.getOrg5());
			dealUserRelative.setOrg6(funUsers.getOrg6());
			dealUserRelative.setOrg7(funUsers.getOrg7());
			dealUserRelative.setOrg8(funUsers.getOrg8());
			dealUserRelative.setOrg9(funUsers.getOrg9());
			dealUserRelative.setOrg10(funUsers.getOrg10());
			dealUserRelative.setOrg11(funUsers.getOrg11());
			dealUserRelative.setOrg12(funUsers.getOrg12());
			dealUserRelative.setOrg13(funUsers.getOrg13());
			dealUserRelative.setOrg14(funUsers.getOrg14());
			list.add(dealUserRelative);
		}
		if(list.size()>0){
			for (ErpDealUserRelative dealUserRelative:list) {
				dealUserRelative.setShardCityId(cityId);
				erpDealUserRelativeMapper.insertSelective(dealUserRelative);
			}
		}
	}

	@Transactional
	@Override
	public void createDealUserRelativeOffStep(Integer cityId, Integer compId, Integer dealId, Set<Integer> userIds, Byte relateType) {
		if(userIds==null||userIds.isEmpty()){
			return;
		}
		List<ErpDealUserRelative> list = new ArrayList<ErpDealUserRelative>();
		userIds.stream().forEach(userId->{
			if (userId!=null){
				ErpFunUsers funUsers=erpFunUsersMapper.getUserInfoByUserId(cityId,userId);
				ErpDealUserRelative dealUserRelative=new ErpDealUserRelative();
				dealUserRelative.setCompId(compId);
				dealUserRelative.setShardArchiveId(funUsers.getArchiveId());
				dealUserRelative.setAreaId(funUsers.getAreaId());
				dealUserRelative.setRegId(funUsers.getRegId());
				dealUserRelative.setDealId(dealId);
				dealUserRelative.setDeptId(funUsers.getDeptId());
				dealUserRelative.setGrId(funUsers.getGrId());
				dealUserRelative.setRelateType(relateType);
				dealUserRelative.setUserId(userId);
				dealUserRelative.setArchiveId(funUsers.getArchiveId());
				dealUserRelative.setOrganizationPath(funUsers.getTissueLine());
				dealUserRelative.setOrg1(funUsers.getOrg1());
				dealUserRelative.setOrg2(funUsers.getOrg2());
				dealUserRelative.setOrg3(funUsers.getOrg3());
				dealUserRelative.setOrg4(funUsers.getOrg4());
				dealUserRelative.setOrg5(funUsers.getOrg5());
				dealUserRelative.setOrg6(funUsers.getOrg6());
				dealUserRelative.setOrg7(funUsers.getOrg7());
				dealUserRelative.setOrg8(funUsers.getOrg8());
				dealUserRelative.setOrg9(funUsers.getOrg9());
				dealUserRelative.setOrg10(funUsers.getOrg10());
				dealUserRelative.setOrg11(funUsers.getOrg11());
				dealUserRelative.setOrg12(funUsers.getOrg12());
				dealUserRelative.setOrg13(funUsers.getOrg13());
				dealUserRelative.setOrg14(funUsers.getOrg14());
				list.add(dealUserRelative);
			}
		});
		if (list.size()>0){
			for (ErpDealUserRelative dealUserRelative:list) {
				erpDealUserRelativeMapper.insertSelective(dealUserRelative);
			}
		}
	}
}
