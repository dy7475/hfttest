package com.myfun.service.business.erpdb.impl;

import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.buildData.param.FunBuildDataParam;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.DateTimeHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.BusinessException;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBuildrulequerylimitService;
import com.myfun.utils.StringUtil;
@Service
public class ErpFunBuildrulequerylimitServiceImpl extends AbstractService<ErpFunBuildrulequerylimit, ErpFunBuildrulequerylimit> implements ErpFunBuildrulequerylimitService{
	@Autowired ErpFunBuildrulequerylimitMapper erpFunBuildrulequerylimitMapper;
	@Autowired ErpFunBuildrulequerylimittempMapper erpFunBuildrulequerylimittempMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpBuildLogMapper erpBuildLogMapper;

	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunBuildrulequerylimitMapper;
	}
	
	/**
	 * 补历史数据
	 * @param shardDbName
	 */
	@Override
	public List<ErpFunBuildrulequerylimittemp> addFunBuildrulequerylimitList(String shardDbName) throws Exception {
		Integer limitId = erpFunBuildrulequerylimittempMapper.selectLastLimitId(shardDbName);
		List<ErpFunBuildrulequerylimit> querLimitList = erpFunBuildrulequerylimitMapper.getQueryLimitList(shardDbName, limitId);
		List<ErpFunBuildrulequerylimittemp> limitTempList = new LinkedList<ErpFunBuildrulequerylimittemp>();
		for (ErpFunBuildrulequerylimit erpFunBuildrulequerylimit : querLimitList) {
			Integer oldlimitId = erpFunBuildrulequerylimit.getLimitId();
			String regx = erpFunBuildrulequerylimit.getRuleRegEx();
			String[] floorAdresses = regx.split("_");
			String roofs = floorAdresses[0];
			String units = floorAdresses[1];
			String nums = floorAdresses[2];
			String houses = floorAdresses[3];
			int outIndex = 0;
			int innerIndex = 0;
			if(!units.equals("[0-9]+?")){
				if (units.matches("[0-9]+?")) {
					outIndex = Integer.parseInt(units);
				}
			}
			if(!nums.equals("[0-9]+?")){
				if (nums.matches("[0-9]+?")) {
					innerIndex = Integer.parseInt(nums);
				}
			}
			if (outIndex == 0 && innerIndex>0) {
				for(int i = 0;i<innerIndex;i++){
					ErpFunBuildrulequerylimittemp temp = new ErpFunBuildrulequerylimittemp();
					BeanUtils.copyProperties(erpFunBuildrulequerylimit, temp);
					temp.setRuleRegEx(roofs + "_" + units + "_" + i + "_" + houses);
					temp.setRuleStr(roofs+"#"+units+"#"+i);
					temp.setOldLimitId(oldlimitId);
					limitTempList.add(temp);
				}
			} else if (outIndex >0 && innerIndex==0) {
				for(int i = 0;i<outIndex;i++){
					ErpFunBuildrulequerylimittemp temp = new ErpFunBuildrulequerylimittemp();
					BeanUtils.copyProperties(erpFunBuildrulequerylimit, temp);
					temp.setRuleRegEx(roofs + "_" + i + "_" + nums + "_" + houses);
					temp.setRuleStr(roofs+"#"+i+"#"+nums);
					temp.setOldLimitId(oldlimitId);
					limitTempList.add(temp);
				}
			} else if (outIndex >0 && innerIndex >0) {
				for(int i = 0;i<=outIndex;i++){
					for(int j = 0;j<innerIndex;j++){
						ErpFunBuildrulequerylimittemp temp = new ErpFunBuildrulequerylimittemp();
						BeanUtils.copyProperties(erpFunBuildrulequerylimit, temp);
						temp.setRuleRegEx(roofs + "_" + i + "_" + j + "_" + houses);
						temp.setRuleStr(roofs+"#"+i+"#"+j);
						temp.setOldLimitId(oldlimitId);
						limitTempList.add(temp);
					}
				}
			}
		}
		return limitTempList;
	}

	@Transactional
	@Override
	public void setMgrUserViewRight(Integer cityId, Integer compId,Integer userId,String userName,String deptName, FunBuildDataParam param) throws Exception{

		String eHourRange = param.geteHour();
		String roof =param.getRoof();
		String unit = param.getUnit();
		String floor = param.getFloor();
		String buildName = param.getBuildName();
		String userIdStr = param.getUserId();

		ErpFunBuildrulequerylimit model = new ErpFunBuildrulequerylimit();
		model.setBuildId(param.getBuildId());
		if ("".equals(eHourRange)) {
			eHourRange = "0";
		}
		// 转码在保存
		buildName = URLDecoder.decode(buildName, "UTF-8");
		//栋单元楼户(默认) 例如:"[0]*?[1-9]+?_[0]*?[1-9]+?_[0]*?[1-9]+?_[0-9]+?"
		// 数字，默认的是全部
		String roofExt = roof;
		String unitExt = unit;
		String floorExt = floor;
		if ("ALL".equals(roof)) {
			roofExt = "[A-Za-z0-9]+?";
		}
		if ("ALL".equals(unit)) {
			unitExt = "[0-9]+?";
		}
		if ("ALL".equals(floor)) {
			floorExt = "[0-9]+?";
		}
		// 计算使用时间
		String currDate = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "yyyy-MM-dd");
		String sHour = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "HH");
		String sMinute = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(), "mm");
		String sTime = currDate + " " + sHour + ":" + sMinute + ":00";
		String eTime = DateTimeHelper.formatDateTimetoString(DateTimeHelper.addHours(DateTimeHelper.parseToDate(sTime), Integer.parseInt(eHourRange)));
		eTime = DateTimeHelper.formatDateTimetoString(eTime, "yyyy-MM-dd HH:mm:00");
		model.setRuleStr(roof + "#" + unit + "#" + floor);
		model.setRuleRegEx(roofExt + "_" + unitExt + "_" + floorExt + "_[0-9]+?");
		model.setStartTime(sTime);
		model.setEndTime(eTime);
		model.setCreateUser(userName);
		model.setCreateUserId(userId);
		model.setStatus((byte)1);

		String[] userIds = userIdStr.split(" ");
		Boolean insertFlag = false;
		List<ErpFunUsers> userList = erpFunUsersMapper.getUserListByStringUserIds(cityId, Arrays.asList(userIds));
		Map<Integer,ErpFunUsers> usersMap = userList.stream().collect(Collectors.toMap(val -> val.getUserId(), val -> val));
		String userNames = "";
		for (String idStr : userIds) {
			if(StringUtils.isBlank(idStr)) {
				continue;
			}
			model.setUserId(StringUtil.paseInteger(idStr));
			model.setLimitId(null);
			model.setCompId(compId);
			model.setShardCityId(cityId);
			ErpFunBuildrulequerylimit buildrulequerylimit = erpFunBuildrulequerylimitMapper.getBuildrulequerylimit(model);
			if (buildrulequerylimit == null){
				insertFlag = true;
				model.setBuildName(buildName);
				erpFunBuildrulequerylimitMapper.insertSelective(model);
			}else {
				model.setLimitId(buildrulequerylimit.getLimitId());
				erpFunBuildrulequerylimitMapper.updateByPrimaryKeySelective(model);
			}
			ErpFunUsers users = usersMap.get(Integer.valueOf(idStr));
			userNames += users.getUserName() +"、";
		}
		if (userNames.length() >1) {
			userNames = userNames.substring(0,userNames.length() -1);
		}
		if(insertFlag) {
			String  content = deptName + "店"+userName+"分配给"+ userNames + "使用";
			ErpBuildLog log = new ErpBuildLog();
			log.setShardCityId(cityId);
			log.setCompId(compId);
			log.setUpdateUserId(userId);
			log.setUpdateUser(userName);
			log.setBuildId(param.getBuildId());
			log.setCreationTime(new Date());
			log.setTrackTime(new Date());
			log.setTrackConten(content);
			erpBuildLogMapper.insertSelective(log);
		}
	}

	/**
	 * 删除用户的楼盘资料查看权限
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	@Override
	public void deleteBuildrulequerylimits(Integer cityId, Integer compId, String limitIds) {
		if (StringUtil.isBlank(limitIds)) {
			throw new BusinessException("参数错误！");
		}
		String[] ids = limitIds.split(",");
		erpFunBuildrulequerylimitMapper.deleteBuildrulequerylimits(cityId, compId, ids);
	}

}
