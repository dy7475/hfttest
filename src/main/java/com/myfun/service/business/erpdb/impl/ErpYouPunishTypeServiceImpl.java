package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.ErpYouComplaintTypeMapper;
import com.myfun.repository.admindb.dao.ErpYouPunishTypeMapper;
import com.myfun.repository.admindb.po.ErpYouComplaintType;
import com.myfun.repository.admindb.po.ErpYouPunishType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpYouPunishTypeService;

@Service
public class ErpYouPunishTypeServiceImpl extends AbstractService<ErpYouPunishType, Integer> implements ErpYouPunishTypeService {
	@Autowired
	private ErpYouPunishTypeMapper erpYouPunishTypeMapper;
	@Autowired
	private ErpYouComplaintTypeMapper erpYouComplaintTypeMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper=erpYouPunishTypeMapper;
	}

	@Override
	public List<ErpYouPunishType> getPunishTypeList(String owner) {
		return erpYouPunishTypeMapper.getPunishTypeList(owner);
	}

	@Override
	public List<ErpYouPunishType> getYouPunishTypeList(Byte complainType) {
		return erpYouPunishTypeMapper.getByComplainType(Integer.parseInt(String.valueOf(complainType)));
	}

	@Override
	public int delComplainType(Integer yptId) {
		ErpYouComplaintType complaintType = new ErpYouComplaintType();
		complaintType.setDelFlag(Byte.valueOf("1"));
		complaintType.setYctId(yptId);
		return erpYouComplaintTypeMapper.updateByPrimaryKeySelective(complaintType);
	}

	@Transactional
	@Override
	public int saveYouComplainType(String data) {
		ErpYouComplaintType complaintType = new ErpYouComplaintType();
		ErpYouPunishType punishType = new ErpYouPunishType(); 
		
		String[] yctDatas = data.split("\\$");
		for (String yctData : yctDatas) {
			String yct=yctData.split("\\;")[0];
			String ypts=yctData.split("\\;")[1];
			
			String[] param = yct.split("\\,");
			if("NO".equals(param[0])){
				complaintType.setYctName(param[1]);
				complaintType.setYctDesc(param[1]);
				complaintType.setYctOwner(Byte.valueOf(param[2]));
				complaintType.setDelFlag((byte) 0);
				erpYouComplaintTypeMapper.insertSelective(complaintType);
			}else{
				complaintType.setYctId(Integer.parseInt(param[0]));
				complaintType.setYctName(param[1]);
				complaintType.setYctDesc(param[1]);
				complaintType.setYctOwner(Byte.valueOf(param[2]));
				complaintType.setDelFlag((byte) 0);
				erpYouComplaintTypeMapper.updateByPrimaryKeySelective(complaintType);
			}
			
			String[] yptDatas =ypts.split("\\|");
			for (String yptData : yptDatas) {
				String[] yptParam = yptData.split("\\,");
				if("NO".equals(yptParam[0])){
					punishType.setYctComplainType(complaintType.getYctId());
					punishType.setYptIntegral(Integer.valueOf(yptParam[1]));
					punishType.setYptStopDays(Integer.valueOf(yptParam[2]));
					punishType.setYptStopObject(Byte.valueOf(yptParam[4]));
					punishType.setDelFlag((byte) 0);
					if("0".equals(param[2])){
						punishType.setYptReturnObject(Byte.valueOf(yptParam[5]));
						punishType.setYptShareFlag(Byte.valueOf(yptParam[6]));
					}else{
						punishType.setYptReturnObject((byte) 0);
						punishType.setYptShareFlag((byte) 0);
					}
					erpYouPunishTypeMapper.insertSelective(punishType);
				}else{
					punishType.setYptId(Integer.parseInt(yptParam[0]));
					punishType.setYctComplainType(complaintType.getYctId());
					punishType.setYptIntegral(Integer.valueOf(yptParam[1]));
					punishType.setYptStopDays(Integer.valueOf(yptParam[2]));
					punishType.setYptStopObject(Byte.valueOf(yptParam[4]));
					punishType.setDelFlag((byte) 0);
					if("0".equals(param[2])){
						punishType.setYptReturnObject(Byte.valueOf(yptParam[5]));
						punishType.setYptShareFlag(Byte.valueOf(yptParam[6]));
					}else{
						punishType.setYptReturnObject((byte) 0);
						punishType.setYptShareFlag((byte) 0);
					}
					erpYouPunishTypeMapper.updateByPrimaryKeySelective(punishType);
				}
				
			}
		}
		return 1;
	}

	@Override
	public int delPunishType(Integer yptId) {
		ErpYouPunishType punishType = new ErpYouPunishType();
		punishType.setDelFlag(Byte.valueOf("1"));
		punishType.setYptId(yptId);
		return erpYouPunishTypeMapper.updateByPrimaryKeySelective(punishType);
	}
	
	

}
