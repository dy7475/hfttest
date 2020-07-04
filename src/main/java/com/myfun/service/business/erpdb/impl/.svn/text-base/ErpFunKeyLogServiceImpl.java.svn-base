package com.myfun.service.business.erpdb.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.erpdb.dao.ErpFunKeyLogMapper;
import com.myfun.repository.erpdb.dao.ErpFunKeyMapper;
import com.myfun.repository.erpdb.dao.ErpFunLeaseMapper;
import com.myfun.repository.erpdb.dao.ErpFunSaleMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpSystemSettingLogsMapper;
import com.myfun.repository.erpdb.dto.ErpFunKeyLogDto;
import com.myfun.repository.erpdb.po.ErpFunKeyLog;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunKeyLogService;
import com.myfun.service.business.erpdb.bean.param.DestroyKeyParam;
import com.myfun.utils.BeanUtilsHelper;
@Service
public class ErpFunKeyLogServiceImpl extends AbstractService<ErpFunKeyLog, ErpFunKeyLog> implements ErpFunKeyLogService{
	@Autowired
	ErpFunKeyLogMapper erpFunKeyLogMapper;
	@Autowired
	ErpFunKeyMapper erpFunKeyMapper;
	@Autowired
	ErpFunSaleMapper erpFunSaleMapper;
	@Autowired
	ErpFunLeaseMapper erpFunLeaseMapper;
	@Autowired 
	ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
	@Autowired 
	ErpFunUsersMapper erpFunUsersMapper;
	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunKeyLogMapper;
	}
	@Override
	public ErpFunKeyLog getErpFunKeyLogById(Integer cityId,Integer logId) {
		ErpFunKeyLog key = new ErpFunKeyLog();
		key.setShardCityId(cityId);
		key.setKeyLogId(logId);
		return erpFunKeyLogMapper.selectByPrimaryKey(key);
	}
	/**
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId 城市ID
	 * @param keyId 钥匙ID
	 * @param pageOffSet 页数
	 * @param pageRows 每页多少条
	 * @return
	 * @throws Exception 
	 */
	@Override
	public PageInfo<ErpFunKeyLogDto> getKeyLogList(Integer cityId, Integer keyId, Integer pageOffSet, Integer pageRows) throws Exception {
		PageHelper.startPage(pageOffSet,pageRows, true);
		List<ErpFunKeyLogDto> list = erpFunKeyLogMapper.getKeyLogList(cityId,keyId);
		Set<Integer> userIds = new HashSet<Integer>();
		for(ErpFunKeyLogDto keyDto:list ){
			if(keyDto.getBorrowUser()!=null){
				userIds.add(keyDto.getBorrowUser());
			}
			if(keyDto.getLendUser()!=null){
				userIds.add(keyDto.getLendUser());
			}
			if(keyDto.getReturnUser()!=null){
				userIds.add(keyDto.getReturnUser());
			}
			if(keyDto.getConfirmUser()!=null){
				userIds.add(keyDto.getConfirmUser());
			}
		}
		if(!userIds.isEmpty()){
			List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByUserIds(cityId,userIds);
			Map<Object,ErpFunUsers> userMap = BeanUtilsHelper.listToMapObjectOffKeyType(userList,"userId");
			for(ErpFunKeyLogDto keyDto:list ){
				if(keyDto.getBorrowUser()!=null){
					ErpFunUsers usersPo = userMap.get(keyDto.getBorrowUser());
					if(usersPo!=null){
						keyDto.setBorrowUserName(usersPo.getUserName());
					}
				}
				if(keyDto.getLendUser()!=null){
					ErpFunUsers usersPo = userMap.get(keyDto.getLendUser());
					if(usersPo!=null){
						keyDto.setLendUserName(usersPo.getUserName());
					}
				}
				if(keyDto.getReturnUser()!=null){
					ErpFunUsers usersPo = userMap.get(keyDto.getReturnUser());
					if(usersPo!=null){
						keyDto.setReturnUserName(usersPo.getUserName());
					}
				}
				if(keyDto.getConfirmUser()!=null){
					ErpFunUsers usersPo = userMap.get(keyDto.getConfirmUser());
					if(usersPo!=null){
						keyDto.setConfirmUserName(usersPo.getUserName());
					}
				}
			}
		}
		PageInfo<ErpFunKeyLogDto> pageInfo = new PageInfo<ErpFunKeyLogDto>(list);
		return pageInfo;
	}
	/**
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param param
	 */
	@Override
	public void deleteFunKeyLog(DestroyKeyParam param) {
		erpFunKeyLogMapper.deleteFunKeyLog( param.getCityId(),param.getKeyId());
	}

	/**
	 * 钥匙日志
	 * **//*
	@Override
	public PageInfo<ErpFunKeyDto> getKeyBorrowLog(BaseMapParam param) {
		
		return new PageInfo<>(resList);
	}*/
	@Override
	public List<ErpFunKeyLog> getErpFunKeyLogByIds(Integer cityId,
			Set<Integer> logIds) {
		List<ErpFunKeyLog> listKeyDto = erpFunKeyLogMapper.getErpFunKeyLogByIds(cityId, logIds);
		return listKeyDto;
	}
	@Override
	public void deleteFunKeyLogByKeyIds(Integer cityId, Integer compId,
			Object[] keyIds) {
		erpFunKeyLogMapper.deleteFunKeyLogByKeyIds(cityId,compId,keyIds);
	}
}
