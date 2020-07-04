package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpBuildingInfoDto;
import com.myfun.repository.erpdb.param.ErpFunBuildRuleParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.erpdb.ErpFunSectionService;
import com.myfun.utils.*;
import org.apache.activemq.broker.UserIDBroker;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBuildRuleService;

import static com.myfun.utils.DateTimeHelper.getTimeNow;

@Service
public class ErpFunBuildRuleServiceImpl extends AbstractService<ErpFunBuildRule, ErpFunBuildRule> implements ErpFunBuildRuleService {
	@Autowired ErpFunBuildTrackMapper erpFunBuildTrackMapper;
	@Autowired ErpFunBuildRuleMapper erpFunBuildRuleMapper;
	@Autowired ErpFunSelfbuildMapper erpFunSelfbuildMapper;
	@Autowired ErpBuildingInfoMapper erpBuildingInfoMapper;
	@Autowired ErpFunSectionService erpFunSectionService;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpFunBuildrulequerylimitMapper erpFunBuildrulequerylimitMapper;
	@Autowired ErpBuildLogMapper erpBuildLogMapper;
	@Autowired ErpBuildAllotMapper erpBuildAllotMapper;

	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public void deleteAllBuildData(Integer cityId, Map<String, Object> pMap) {
		Integer compId = (Integer)pMap.get("compId");
		Integer buildId = Integer.valueOf((String)pMap.get("buildId"));
		//删掉楼盘对应跟进任务的数据
		erpFunBuildTrackMapper.deleteBuildTrackbyBuild(cityId, pMap);
		//删除楼盘资料对应的所有数据
		erpFunBuildRuleMapper.deleteBuildRuleByBuild(cityId, pMap);
		erpFunSelfbuildMapper.deleteSelfbuildByBuild(cityId, pMap);
		//删除楼盘分配到门店的数据
		ErpBuildAllotExample allotExample = new ErpBuildAllotExample();
		allotExample.setShardCityId(cityId);
		allotExample.createCriteria().andBuildIdEqualTo(buildId).andCompIdEqualTo(compId).andIsDelEqualTo((byte)1);
		erpBuildAllotMapper.deleteByExample(allotExample);
		//删除日志记录
		ErpBuildLogExample logExample =  new ErpBuildLogExample();
		logExample.setShardCityId(cityId);
		logExample.createCriteria().andCompIdEqualTo(compId).andBuildIdEqualTo(buildId);
		erpBuildLogMapper.deleteByExample(logExample);

		}

	/**
	 * 单独更新或者添加一条栋座规则信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/19
	 */
	@Transactional
	@Override
	public void insertOrUpdateBuildRule(GeneralParam generalParam, ErpFunBuildRuleParam param) {
		ErpFunBuildRule erpFunBuildRule=param;
		Integer cityId=generalParam.getCityId();
		Integer compId=generalParam.getCompId();
		String tmpRoof = param.getRoof();
		String tmpUnit = param.getUnit();
		String tmpNum = param.getNum();
		String tmpHouse = param.getHouse();
		Integer buildId = param.getBuildId();
		String sectionName=param.getSectionName();
		Integer sectionId=param.getSectionId();
		Integer saleRegion=param.getSaleRegion();


		ErpBuildingInfoDto erpBuildingInfoDto=erpBuildingInfoMapper.getErpBuildInfoByid(cityId,buildId);
		erpFunBuildRule.setBuildCode(erpBuildingInfoDto.getBuildCode());
		erpFunBuildRule.setBuildName(erpBuildingInfoDto.getBuildName());
		Integer entityId = param.getEntityId();
		String sameFlag = tmpRoof + "_" + tmpUnit + "_" + tmpNum + "_" + tmpHouse;
		String cellPhoneSel = null;
		String shareCellPhoneSel = null;
		//状态 1已转入 0  已查看
		Byte status = null;
		// 参考谢总那边的片区添加规则
		if (entityId==null) {
			int i = erpFunBuildRuleMapper.countFunBuildRuleByCondition(cityId,compId,buildId,sameFlag);
			if (i > 0) {
				throw new BusinessException("此楼盘栋座信息已经存在请检查!");
			}
			if (StringUtil.isNotBlank(sectionName) && sectionId == null) {
				erpFunBuildRule.setSectionId(erpFunSectionService.getSectionIdBySectionName(cityId,sectionName,saleRegion,buildId));
			}
		} else {
			ErpFunBuildRule funBuildRule=new ErpFunBuildRule();
			funBuildRule.setEntityId(entityId);
			funBuildRule.setShardCityId(cityId);
			ErpFunBuildRule buildRuleSel = erpFunBuildRuleMapper.selectByPrimaryKey(funBuildRule);
			cellPhoneSel = buildRuleSel.getCellPhone();
			shareCellPhoneSel=buildRuleSel.getShareCellPhone();
			status = buildRuleSel.getStatus();
		}
		String address = "";
		if(StringUtil.isNotBlank(tmpRoof) && StringUtil.isNotBlank(tmpUnit) && StringUtil.isNotBlank(tmpNum) && StringUtil.isNotBlank(tmpHouse)){
			address = tmpRoof + "栋" + tmpUnit + "单元" + tmpNum + "楼" + tmpHouse +"号";
		}
		erpFunBuildRule.setAddress(address);
		Byte saleStreet = param.getHouseStreet();
		saleStreet=saleStreet==null?5:saleStreet;
		erpFunBuildRule.setHouseStreet(saleStreet);
		//房屋总价
		String stprice =StringUtil.toString(param.getSaleTotalPrice());
		if(stprice == null || !stprice.matches("^\\d+?[\\d|\\.]*\\d*?$")){
			stprice = "";
		}
		stprice = StringUtils.isBlank(stprice) ? "0" : stprice;
		erpFunBuildRule.setSaleTotalPrice(new BigDecimal(stprice));

		erpFunBuildRule.setSameFlag(sameFlag);
		//将电话单独写加密
		String phoneReq = param.getCellPhone();
		if (StringUtil.isNotBlank(phoneReq)) {
			erpFunBuildRule.setCellPhone(this.getEncryptPhone(phoneReq,cellPhoneSel));
		}

		String SharePhoneRqe = param.getShareCellPhone();
		if (StringUtil.isNotBlank(SharePhoneRqe)){
			erpFunBuildRule.setShareCellPhone(this.getEncryptPhone(SharePhoneRqe,shareCellPhoneSel));
		}


		// 如果为空说明是创建操作,否则为更新操作.
		String entityIdStr=StringUtil.toString(entityId);
		erpFunBuildRule.setShardCityId(cityId);
		if (entityIdStr==null) {
			erpFunBuildRule.setCompId(compId);
			String nowTime = getTimeNow();
			// 添加创建时间，目的是为了回显的 时候排序
			erpFunBuildRule.setCreationTime(nowTime);
			erpFunBuildRule.setUserId(generalParam.getUserId());
			erpFunBuildRule.setStatus(status);
			erpFunBuildRuleMapper.insertSelective(erpFunBuildRule);
			// 添加到自己的公司楼盘中
			ErpFunSelfbuild selfbuildPO =erpFunSelfbuildMapper.getFunSelfOneByBuildId(cityId,compId,buildId);
			Map<String,Integer> buildCountMap = erpFunBuildRuleMapper.countTotalRoomAndSaleAndLease(cityId,compId,buildId);
			List<ErpFunBuildRule> buildRules = erpFunBuildRuleMapper.countBuildTotalRoof(cityId,compId,buildId);
			if (selfbuildPO == null) {
				String buildCode =  Pinyin4jUtil.converterToFirstSpell(erpFunBuildRule.getBuildName());
				ErpFunSelfbuild funSelfbuildPO = new ErpFunSelfbuild ();
				funSelfbuildPO.setBuildName(erpFunBuildRule.getBuildName());
				funSelfbuildPO.setCompId(compId);
				funSelfbuildPO.setBuildId(buildId);
				funSelfbuildPO.setBuildCode(buildCode);
				funSelfbuildPO.setShardCityId(cityId);
				if (buildCountMap != null && buildCountMap.size() > 0) {
					funSelfbuildPO.setRooms(buildCountMap.get("totalRoom")); //总户数
					funSelfbuildPO.setYetIn(buildCountMap.get("yetTotal"));//已转入
					funSelfbuildPO.setChangeRent(buildCountMap.get("changeLeaseCount"));//转租
					funSelfbuildPO.setChangeSale(buildCountMap.get("changeSaleCount"));//转售
				}
				if (!CollectionUtils.isEmpty(buildRules)) {
					funSelfbuildPO.setRoofs(buildRules.size()); //总栋数
				}
				erpFunSelfbuildMapper.insertSelective(funSelfbuildPO);
			} else {
				if (buildCountMap != null && buildCountMap.size() > 0) {
					selfbuildPO.setShardCityId(cityId);
					selfbuildPO.setBuildId(buildId);
					selfbuildPO.setRooms(buildCountMap.get("totalRoom")); //总户数
					selfbuildPO.setYetIn(buildCountMap.get("yetTotal"));//已转入
					selfbuildPO.setChangeRent(buildCountMap.get("changeLeaseCount"));//转租
					selfbuildPO.setChangeSale(buildCountMap.get("changeSaleCount"));//转售
					if (!CollectionUtils.isEmpty(buildRules)) {
						selfbuildPO.setRoofs(buildRules.size()); //总栋数
					}
					erpFunSelfbuildMapper.updateByPrimaryKeySelective(selfbuildPO);
				}
			}

			//写楼盘的登记日志
			String content = generalParam.getDeptName() + "店" + generalParam.getUserName() + "登记了1条楼盘资料";
			ErpBuildLog  log = new ErpBuildLog();
			log.setTrackTime(new Date());
			log.setTrackConten(content);
			log.setCreationTime(new Date());
			log.setBuildId(param.getBuildId());
			log.setCompId(compId);
			log.setUpdateUser(generalParam.getUserName());
			log.setUpdateUserId(generalParam.getUserId());
			log.setShardCityId(cityId);
			erpBuildLogMapper.insertSelective(log);

		} else if (entityIdStr!=null && entityIdStr.matches("[0-9]+")) {
			erpFunBuildRuleMapper.updateByPrimaryKeySelective(erpFunBuildRule);
			//如果更改了栋号，总栋数需要重新统计
			List<ErpFunBuildRule> buildRules = erpFunBuildRuleMapper.countBuildTotalRoof(cityId,compId,buildId);
			if (!CollectionUtils.isEmpty(buildRules)) {
				ErpFunSelfbuild funSelfbuildPO = new ErpFunSelfbuild ();
				funSelfbuildPO.setRoofs(buildRules.size()); //总栋数
				funSelfbuildPO.setShardCityId(cityId);
				funSelfbuildPO.setCompId(compId);
				funSelfbuildPO.setBuildId(erpFunBuildRule.getBuildId());
				erpFunSelfbuildMapper.updateByPrimaryKeySelective(funSelfbuildPO);
				//写房号资料跟进修改日志
				ErpFunBuildTrack track = new ErpFunBuildTrack();
				track.setShardCityId(cityId);
				track.setCompId(compId);
				track.setBuildRuleId(entityId);
				track.setTrackContent(generalParam.getUserName()+ "修改了房号资料");
				track.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-dd HH:mm:ss.S"));
				track.setCreateUid(generalParam.getUserId());
				erpFunBuildTrackMapper.insertSelective(track);
			}
		}
	}

	@Transactional
	@Override
	public void deleteBuildRuleBat(Integer cityId, Integer compId, String[] entityIds) {
		erpFunBuildRuleMapper.deleteBuildRuleByIds(cityId,entityIds);
		erpFunSelfbuildMapper.deleteSelfBuild(cityId,compId);
		//批量删除数据的跟进信息
		erpFunBuildTrackMapper.deleteTrack(cityId,entityIds);
	}

	
	/**
	 *  excel导入楼盘资料
	 * @param
	 * @param deptId
	 * @param userId
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/26
	 */	
	@Transactional
	@Override
	public List<Map<String,Integer>> importBuildRules(String buildListJson, Integer cityId, Integer compId,String userName,String deptName, Integer deptId, Integer userId) {
		List<Map<String,Integer>> returnList = new ArrayList<>();
		Map<String,Integer> returnMap = new HashMap<>();
		returnList.add(returnMap);
		if(StringUtil.isNotBlank(buildListJson)){
			List<ErpFunBuildRule> list = JSON.parseArray(buildListJson, ErpFunBuildRule.class);
			Integer index = 0;
			Integer flag = 0;// 用于比较list的size，不能用index
			if (!list.isEmpty()) {
				ErpFunBuildRule funBuildRulePO = list.get(0);
				List<ErpFunBuildRule> funBuildRule = erpFunBuildRuleMapper.selectByDeptId(cityId, compId, deptId, funBuildRulePO.getBuildId());
				if (funBuildRule.isEmpty()) {
					ErpBuildAllotExample allotExample = new ErpBuildAllotExample();
					allotExample.setShardCityId(cityId);
					allotExample.createCriteria().andBuildIdEqualTo(funBuildRulePO.getBuildId()).andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andIsDelEqualTo(Byte.valueOf("1"));
					List<ErpBuildAllot> buildAllotList = erpBuildAllotMapper.selectByExample(allotExample);
					//楼盘分配
					if (buildAllotList.isEmpty()) {
						ErpBuildAllot buildAllot = new ErpBuildAllot();
						buildAllot.setBuildId(funBuildRulePO.getBuildId());
						buildAllot.setCompId(compId);
						buildAllot.setCreateTime(new Date());
						buildAllot.setCreateUser(userName);
						buildAllot.setCreateUserId(userId);
						buildAllot.setDeptId(deptId);
						buildAllot.setDeptName(deptName);
						buildAllot.setIsDel((byte) 1);
						buildAllot.setShardCityId(cityId);
						erpBuildAllotMapper.insertSelective(buildAllot);
					}
				}
			}
			for (ErpFunBuildRule funBuildRulePO : list) {

				flag++;
				String sameFlag = funBuildRulePO.getRoof() + "_" + funBuildRulePO.getUnit() +  "_" + funBuildRulePO.getNum() + "_" + funBuildRulePO.getHouse();
				funBuildRulePO.setSameFlag(sameFlag);
				StringBuilder addressSb = new StringBuilder();
				if (!StringUtils.isBlank(funBuildRulePO.getRoof())) {
					addressSb.append(funBuildRulePO.getRoof()).append("栋");
				}
				if (!StringUtils.isBlank(funBuildRulePO.getUnit())) {
					addressSb.append(funBuildRulePO.getUnit()).append("单元");
				}
				if (!StringUtils.isBlank(funBuildRulePO.getNum())) {
					addressSb.append(funBuildRulePO.getNum()).append("楼");
				}
				if (!StringUtils.isBlank(funBuildRulePO.getHouse())) {
					addressSb.append(funBuildRulePO.getHouse()).append("号");
				}
				funBuildRulePO.setAddress(addressSb.toString());
				if (!StringUtils.isBlank(funBuildRulePO.getRoof()) && !StringUtils.isBlank(funBuildRulePO.getUnit())
						&& !StringUtils.isBlank(funBuildRulePO.getNum()) && !StringUtils.isBlank(funBuildRulePO.getHouse())){
					if(!"0".equals(funBuildRulePO.getRoof()) && !"0".equals(funBuildRulePO.getUnit()) && !"0".equals(funBuildRulePO.getNum()) && !"0".equals(funBuildRulePO.getHouse())){
						ErpFunBuildRule buildRulePO = erpFunBuildRuleMapper.getFunBuildRuleOneByBuildId(cityId,compId,funBuildRulePO.getBuildId(),sameFlag);
						if (buildRulePO != null) {
							continue;
						}
					}
				}
				index++;
				funBuildRulePO.setShardCityId(cityId);
				String cellPhone = funBuildRulePO.getCellPhone();
				if (StringUtil.isNotBlank(cellPhone)) {
					String phone = "&&&";
					String[] phones = StringHelper.split(cellPhone, " ");
					for (int i = 0; i < phones.length; i++) {
						String[] phoneValues = StringHelper.split(phones[i], ":");
						phoneValues[1] = EnCodeHelper.encode(phoneValues[1]);
						phone += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
					}
					funBuildRulePO.setCellPhone(phone);
				}
				String shareCellPhone = funBuildRulePO.getShareCellPhone();
				if (StringUtil.isNotBlank(shareCellPhone)) {
					String phone = "&&&";
					String[] phones = StringHelper.split(shareCellPhone, " ");
					for (int i = 0; i < phones.length; i++) {
						String[] phoneValues = StringHelper.split(phones[i], ":");
						phoneValues[1] = EnCodeHelper.encode(phoneValues[1]);
						phone += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
					}
					funBuildRulePO.setShareCellPhone(phone);
				}
				funBuildRulePO.setCompId(compId);
				String nowTime = getTimeNow();
				//添加创建时间，目的是为了回显的 时候排序
				funBuildRulePO.setCreationTime(nowTime);
				funBuildRulePO.setDeptId(deptId);
				funBuildRulePO.setUserId(userId);
                funBuildRulePO.setStatus(null);
				erpFunBuildRuleMapper.insertSelective(funBuildRulePO);
				//添加到自己的公司楼盘中
				ErpFunSelfbuild selfbuildPO = erpFunSelfbuildMapper.getFunSelfOneByBuildId(cityId,compId,funBuildRulePO.getBuildId());
				Map<String,Integer> buildCountMap = erpFunBuildRuleMapper.countTotalRoomAndSaleAndLease(cityId,compId,funBuildRulePO.getBuildId());
				List<ErpFunBuildRule> buildRules = erpFunBuildRuleMapper.countBuildTotalRoof(cityId,compId,funBuildRulePO.getBuildId());
				if (selfbuildPO == null) {
					String buildCode =  Pinyin4jUtil.converterToFirstSpell(funBuildRulePO.getBuildName());
					ErpFunSelfbuild funSelfbuildPO = new ErpFunSelfbuild ();
					funSelfbuildPO.setBuildName(funBuildRulePO.getBuildName());
					funSelfbuildPO.setCompId(compId);
					funSelfbuildPO.setBuildId(funBuildRulePO.getBuildId());
					funSelfbuildPO.setBuildCode(buildCode);
					funSelfbuildPO.setShardCityId(cityId);
					if (buildCountMap != null && buildCountMap.size() > 0) {
						funSelfbuildPO.setRooms(buildCountMap.get("totalRoom")); //总户数
						funSelfbuildPO.setYetIn(buildCountMap.get("yetTotal"));//已转入
						funSelfbuildPO.setChangeRent(buildCountMap.get("changeLeaseCount"));//转租
						funSelfbuildPO.setChangeSale(buildCountMap.get("changeSaleCount"));//转售
					}
					if (!CollectionUtils.isEmpty(buildRules)) {
						funSelfbuildPO.setRoofs(buildRules.size()); //总栋数
					}
					erpFunSelfbuildMapper.insertSelective(funSelfbuildPO);
				} else {
					if (flag == list.size()) {
						if (buildCountMap != null && buildCountMap.size() > 0) {
							selfbuildPO.setRooms(buildCountMap.get("totalRoom")); //总户数
							selfbuildPO.setYetIn(buildCountMap.get("yetTotal"));//已转入
							selfbuildPO.setChangeRent(buildCountMap.get("changeLeaseCount"));//转租
							selfbuildPO.setChangeSale(buildCountMap.get("changeSaleCount"));//转售
						}
						if (!CollectionUtils.isEmpty(buildRules)) {
							selfbuildPO.setRoofs(buildRules.size()); //总栋数
						}
						selfbuildPO.setShardCityId(cityId);
						erpFunSelfbuildMapper.updateByPrimaryKeySelective(selfbuildPO);
					}
				}
			}
			returnMap.put("importCount", index);
			//添加楼盘登记日志
			if (index > 0) {
				String content = deptName + "店" + userName + "登记了" + index + "条楼盘资料";
				ErpBuildLog  log = new ErpBuildLog();
				log.setShardCityId(cityId);
				log.setTrackTime(new Date());
				log.setTrackConten(content);
				log.setCreationTime(new Date());
				log.setBuildId(list.get(0).getBuildId());
				log.setCompId(compId);
				log.setUpdateUser(userName);
				log.setUpdateUserId(userId);
				erpBuildLogMapper.insertSelective(log);
			}
		}
		return returnList;
	}

	/**
	 * 批量添加单元栋坐信息
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/26
	 */	
	@Transactional
	@Override
	public void insertFloorUnitMgr(Integer cityId,Integer deptId,Integer compId,Integer userId,String deptName,String userName, BaseMapParam param) throws Exception{
		Map<String, Object> map=param.getMap();
		String numS = param.getString("multiNum");
		Integer buildId=param.getInteger("buildId");
		Integer buildRuleCompId=param.getInteger("compId");
		String houseRound=param.getString("houseRound");
		Byte houseStreet=param.getByte("houseStreet");
		String buildName=param.getString("buildName");
		//批量添加多个规则
		int mulit = Integer.parseInt(numS);
		//验证产生的结果集的数量是否大于设置的边界. 例如 单元工10 每单元10楼 每楼5户. 10 * 10 * 5 = 500 如果大于500就不生成的话就抛出异常.
		int unitSum = 0;
		int floorSum = 0;
		int homeSum = 0;
		int sum=0;
		Byte street =5;
		ErpBuildingInfo erpBuildingInfoPO = erpBuildingInfoMapper.getBuildInfoById(cityId,StringUtil.toString(buildId));
		map.put("buildCode",erpBuildingInfoPO.getBuildCode());
		map.put("buildName",erpBuildingInfoPO.getBuildName());
		ErpFunBuildRule funBuildRulePo = new ErpFunBuildRule();
		BeanUtils.copyProperties(funBuildRulePo, map);


		funBuildRulePo.setShardCityId(cityId);

		String nowTime = getTimeNow();
		//判断栋座规则设置是否过多
		for(int index=1;index<=mulit;index++){
			String roof = (String) map.get("ruleRoof"+String.valueOf(index));
			String unit = (String) map.get("ruleUnit"+String.valueOf(index));
			String floor = (String) map.get("ruleFloor"+String.valueOf(index));
			String home = (String) map.get("ruleHome"+String.valueOf(index));
			String flag = unit + floor + home;
			if(!"".equals(roof) && !"".equals(unit) && !"".equals(floor) && !"".equals(home) && flag.matches("[0-9]+")){
				unitSum =  Integer.parseInt(unit);
				floorSum =  Integer.parseInt(floor);
				homeSum = Integer.parseInt(home);
				sum = sum + (unitSum * floorSum * homeSum);
				if(sum>10000){
					throw new BusinessException("栋座规则设置过多,请减少部分栋座规则!");
				}
			}else{
				throw new BusinessException("栋座规则请正确输入!");
			}
		}
		if(sum == 0){
			throw new BusinessException("栋座规则不能为空!");
		}
		List<ErpFunBuildRule> addPoList = new ArrayList<>();
		//保存楼盘规则
		for(int index=1;index<=mulit;index++){
			String roof = (String) map.get("ruleRoof"+String.valueOf(index));
			String unit = (String) map.get("ruleUnit"+String.valueOf(index));
			String floor = (String) map.get("ruleFloor"+String.valueOf(index));
			String home = (String) map.get("ruleHome"+String.valueOf(index));
			unitSum =  Integer.parseInt(unit);
			floorSum =  Integer.parseInt(floor);
			homeSum = Integer.parseInt(home);
			List<String> list = new ArrayList<>();
			for(int i=1;i<=unitSum;i++){
				for(int j=1;j<=floorSum;j++){
					for(int k=1;k<=homeSum;k++){
						//生成唯一的楼盘标志
						String sameFlag = roof + '_' + i + '_' + j + '_' + k;
						list.add(sameFlag);
					}
				}
			}
			StringBuilder samFlagStr =new StringBuilder();
			for(int i=0;i<list.size();i++){
				String samFlag = list.get(i);
				if(i==list.size()-1){
					samFlagStr.append("'"+samFlag+"'");
					continue;
				}
				samFlagStr.append("'"+samFlag+"',");
			}
			List <ErpFunBuildRule> funBuildRulePOLists = erpFunBuildRuleMapper.getSamFlag(cityId,buildRuleCompId,buildId,StringUtil.toString(samFlagStr));
			int mark=0;
			int total=homeSum*floorSum*unitSum;
			if(total > 1000) {
				throw new BusinessException("添加的数据过多，请分批次添加！");
			}
			boolean flagMark = false;

			for(int i=1;i<=unitSum&&flagMark!=true;i++){
				for(int j=1;j<=floorSum&&flagMark!=true;j++){
					for(int k=1;k<=homeSum&&flagMark!=true;k++){
						String sameFlag = roof + '_' + i + '_' + j + '_' + k;
						//匹配楼盘资料
						boolean flag =false;
						//看是否已经存在了楼盘资料
						for(ErpFunBuildRule funBuildRule:funBuildRulePOLists){
							if(funBuildRule.getSameFlag().equals(sameFlag)){
								flag = true;
							}
						}
						if(flag==true){
							total--;
							continue;
						}
						mark++;
						String address = roof + "栋" + i + "单元" + j + "楼" + k + "号";
						ErpFunBuildRule insertPo = new ErpFunBuildRule();
						BeanUtils.copyProperties(insertPo, funBuildRulePo);
						insertPo.setRoof(roof);
						insertPo.setUnit(String.valueOf(i));
						insertPo.setNum(String.valueOf(j));
						insertPo.setHouse(String.valueOf(k));
						insertPo.setAddress(address);
						insertPo.setHouseRound(houseRound!=null?houseRound:"");
						insertPo.setSameFlag(sameFlag);
						insertPo.setCompId(compId);
						insertPo.setDeptId(deptId);
						insertPo.setHouseStreet(houseStreet!=null?houseStreet:street);
						insertPo.setCreationTime(nowTime);
						addPoList.add(insertPo);
//						if(mark%1500==0){
//							erpFunBuildRuleMapper.insertSelective(funBuildRulePo);
//							if(total==mark){
//								flagMark=true;
//								continue;
//							}
//						}
					}
				}
			}
//			if(flagMark==true){
//				continue;
//			}
//			erpFunBuildRuleMapper.insertSelective(funBuildRulePo);
		}

		if(addPoList.size() > 0) {
			if(addPoList.size() <= 30) {
				erpFunBuildRuleMapper.insertBatch(cityId, addPoList);
			}else {
				Integer pageTotal = (addPoList.size() + 30 -1) / 30;
				for (Integer page=0; page < pageTotal; page ++) {

					if((page+1) == pageTotal) {
						List<ErpFunBuildRule> erpFunBuildRules = addPoList.subList(page*30, addPoList.size());
						if(erpFunBuildRules.size() > 0) {
							erpFunBuildRuleMapper.insertBatch(cityId, erpFunBuildRules);
						}
					}else {
						List<ErpFunBuildRule> erpFunBuildRules = addPoList.subList(page*30, (page+1)*30);

						if(erpFunBuildRules.size() > 0) {
							erpFunBuildRuleMapper.insertBatch(cityId, erpFunBuildRules);
						}
					}

				}
			}
			//添加到自己的公司楼盘中
			ErpFunSelfbuild selfbuildPO = erpFunSelfbuildMapper.getFunSelfOneByBuildId(cityId,compId,buildId);
			Map<String,Integer> buildCountMap = erpFunBuildRuleMapper.countTotalRoomAndSaleAndLease(cityId,compId,buildId);
			List<ErpFunBuildRule> buildRules = erpFunBuildRuleMapper.countBuildTotalRoof(cityId,compId,buildId);
			if (selfbuildPO == null) {
				String buildCode =  Pinyin4jUtil.converterToFirstSpell(buildName);
				ErpFunSelfbuild funSelfbuildPO = new ErpFunSelfbuild ();
				funSelfbuildPO.setBuildName(buildName);
				funSelfbuildPO.setCompId(compId);
				funSelfbuildPO.setBuildId(buildId);
				funSelfbuildPO.setBuildCode(buildCode);
				funSelfbuildPO.setShardCityId(cityId);
				if (buildCountMap != null && buildCountMap.size() > 0) {
					funSelfbuildPO.setRooms(buildCountMap.get("totalRoom")); //总户数
					funSelfbuildPO.setYetIn(buildCountMap.get("yetTotal"));//已转入
					funSelfbuildPO.setChangeRent(buildCountMap.get("changeLeaseCount"));//转租
					funSelfbuildPO.setChangeSale(buildCountMap.get("changeSaleCount"));//转售
				}
				if (!CollectionUtils.isEmpty(buildRules)) {
					funSelfbuildPO.setRoofs(buildRules.size()); //总栋数
				}
				erpFunSelfbuildMapper.insertSelective(funSelfbuildPO);
			} else {
				if (buildCountMap != null && buildCountMap.size() > 0) {
					selfbuildPO.setRooms(buildCountMap.get("totalRoom")); //总户数
					selfbuildPO.setYetIn(buildCountMap.get("yetTotal"));//已转入
					selfbuildPO.setChangeRent(buildCountMap.get("changeLeaseCount"));//转租
					selfbuildPO.setChangeSale(buildCountMap.get("changeSaleCount"));//转售
				}
				if (!CollectionUtils.isEmpty(buildRules)) {
					selfbuildPO.setRoofs(buildRules.size()); //总栋数
				}
				selfbuildPO.setShardCityId(cityId);
				erpFunSelfbuildMapper.updateByPrimaryKeySelective(selfbuildPO);
			}
			//添加楼盘资料登记日志
			String content = deptName + "店" + userName + "登记了" + addPoList.size() + "条楼盘资料";
			ErpBuildLog  log = new ErpBuildLog();
			log.setShardCityId(cityId);
			log.setTrackTime(new Date());
			log.setTrackConten(content);
			log.setCreationTime(new Date());
			log.setBuildId(buildId);
			log.setCompId(compId);
			log.setUpdateUser(userName);
			log.setUpdateUserId(userId);
            erpBuildLogMapper.insertSelective(log);
		}
	}
	
	/**
	 * 电话加密处理
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/25
	 */
	private String getEncryptPhone(String phoneReq, String cellPhoneSel) {
		String phone = "&&&";
		cellPhoneSel = StringUtils.isBlank(cellPhoneSel) ? "" : cellPhoneSel;
		String[] phones = StringHelper.split(phoneReq, " ");
		String[] phonesOld = StringHelper.split(cellPhoneSel, "&&&");
		for (int i = 0; i < phones.length; i++) {
			String[] phoneValues = StringHelper.split(phones[i], ":");
			if (phoneValues.length < 2) {
				continue;
			}
			// 处理前端还是*的电话
			if (phoneValues[1].indexOf("*") >= 0 && phonesOld.length > i && StringUtils.isNotBlank(phonesOld[i])) {
				phone += phonesOld[i] + "&&&";
			} else {
				phoneValues[1] = EnCodeHelper.encode(phoneValues[1]);
				phone += phoneValues[0] + "|||" + phoneValues[1] + "&&&";
			}
		}
		return phone;
	}

	@Transactional
	@Override
	public void updateFunBuildRule(String[] ids, ErpFunBuildRule erpFunBuildRule, Integer cityId, Integer compId, Integer userId, String userName) {
		for (String entityId:ids){
			erpFunBuildRule.setEntityId(StringUtil.paseInteger(entityId));
			erpFunBuildRuleMapper.updateByPrimaryKeySelective(erpFunBuildRule);
			//写房号资料跟进修改日志
			ErpFunBuildTrack track = new ErpFunBuildTrack();
			track.setShardCityId(cityId);
			track.setCompId(compId);
			track.setBuildRuleId(Integer.valueOf(entityId));
			track.setTrackContent(userName+ "修改了房号资料");
			track.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-dd HH:mm:ss.S"));
			track.setCreateUid(userId);
			erpFunBuildTrackMapper.insertSelective(track);
		}
	}

	@Override
	public ErpFunBuildRule getMgrSingleFloorData(Integer cityId, Integer compId,Integer userId,String userName,Boolean isGener, Integer entityId) {

		ErpFunBuildRule funBuildRule = new ErpFunBuildRule();
		funBuildRule.setShardCityId(cityId);
		funBuildRule.setEntityId(entityId);
		funBuildRule = erpFunBuildRuleMapper.selectByPrimaryKey(funBuildRule);
		if (funBuildRule == null) {
			return null;
		}
        //写房号资料跟进查看电话号码日志(一个人一天一个楼盘只生成一条一条查看电话记录)
        //获取最新今日当前登录人的最新一条日志记录
        String trackContent = "%查看了该电话%";
		String date = DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-dd");
		String startTime = date + " 00:00:00";
		String endTime = date + " 23:59:59";
		//查询出房号今天最新的一条日志
        ErpFunBuildTrack track = erpFunBuildTrackMapper.getRcentCallPhoneLog(cityId,compId,trackContent,userId,entityId,startTime,endTime);
        //如果该日志是当前登录人写的，就不需要再写
        if (track != null){
            //此时不需要写日志
        } else {
            ErpFunBuildTrack insertTrack = new ErpFunBuildTrack();
            insertTrack.setShardCityId(cityId);
            insertTrack.setCompId(compId);
            insertTrack.setBuildRuleId(entityId);
            insertTrack.setTrackContent(userName + "查看了该电话");
            insertTrack.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-dd HH:mm:ss.S"));
            insertTrack.setCreateUid(userId);
            erpFunBuildTrackMapper.insertSelective(insertTrack);
        }

		// 电话号码的解码
		String cellPhone = funBuildRule.getCellPhone();
		String shareCellPhone = funBuildRule.getShareCellPhone();
		String value = erpSysParaMapper.getParamValue(cityId, compId, "BUILD_IMPLICIT_CALL");
		if ("1".equals(value)) {
			if (isGener) {
				if (StringUtil.isNotBlank(cellPhone)){
					funBuildRule.setCellPhone(this.getPhone(cellPhone));
				}
				if (StringUtil.isNotBlank(shareCellPhone)){
					funBuildRule.setShareCellPhone(this.getPhone(shareCellPhone));
				}
			} else {
				if (StringUtil.isNotBlank(cellPhone)){
					funBuildRule.setCellPhone(SyncUtil.decodePhoneForHouseDetail(cellPhone, true));
				}
				if (StringUtil.isNotBlank(shareCellPhone)){
					funBuildRule.setShareCellPhone(SyncUtil.decodePhoneForHouseDetail(shareCellPhone, true));
				}
			}
		} else {
			if (StringUtil.isNotBlank(cellPhone)){
				funBuildRule.setCellPhone(this.getPhone(cellPhone));
			}
			if (StringUtil.isNotBlank(shareCellPhone)){
				funBuildRule.setShareCellPhone(this.getPhone(shareCellPhone));
			}
		}
		List<ErpFunBuildrulequerylimit> erpFunBuildrulequerylimits = erpFunBuildrulequerylimitMapper.getBuildLimitByBuildId(cityId,compId,funBuildRule.getBuildId());
		String userIds = erpFunBuildrulequerylimits.stream().collect(Collectors.mapping(val -> (val.getUserId()+ ""),Collectors.joining(",")));
       if (userIds.contains(userId + "") && funBuildRule.getCheckTime() == null){
		   ErpFunBuildRule funBuildRuleUpdate = new ErpFunBuildRule();
		   funBuildRuleUpdate.setShardCityId(cityId);
		   funBuildRuleUpdate.setEntityId(entityId);
		   funBuildRuleUpdate.setCheckTime(new Date());
		   //修改状态为 0 已查看
		   funBuildRuleUpdate.setStatus((byte)0);
		   erpFunBuildRuleMapper.updateByPrimaryKeySelective(funBuildRuleUpdate);
	   }
		funBuildRule.getBuildId();

		return  funBuildRule;
	}
	/**
	 * 获取电话
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/25
	 */
	private String getPhone(String cellPhone) {
		String[] phones = StringHelper.split(cellPhone, "&&&");
		String phone = "";
		for (int j = 0; j < phones.length; j++) {
			String[] phoneValues = StringHelper.split(phones[j], "|||");
			phoneValues[1] = EnCodeHelper.decode(phoneValues[1]);
			phone += phoneValues[0] + ":" + phoneValues[1] + " ";
		}
		return phone;
	}

}
