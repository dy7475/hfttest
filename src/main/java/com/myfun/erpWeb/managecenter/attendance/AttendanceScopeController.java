package com.myfun.erpWeb.managecenter.attendance;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunDeptsExample;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunAttendanceScopeDto;
import com.myfun.repository.erpdb.param.ErpAttendanceModuleParam;
import com.myfun.repository.erpdb.param.ErpAttendanceScopeParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeService;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeWifiService;
import com.myfun.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 管理中心-考勤地点范围模块
 * @author lcb
 * @2017-11-22
 */
@RestController
@RequestMapping("/managerCenter/attendanceScopeModule")
public class AttendanceScopeController extends BaseController {

	@Autowired
	private ErpFunAttendanceScopeMapper erpFunAttendanceScopeMapper;
	@Autowired
	private ErpFunAttendanceScopeBizMapper erpFunAttendanceScopeBizMapper;
	@Autowired
	private ErpFunAttendanceScopeBizPersonMapper erpFunAttendanceScopeBizPersonMapper;
	@Autowired
	private ErpFunAttendanceScopeService erpFunAttendanceScopeService;
	@Autowired
	private ErpFunAttendanceScopeWifiMapper erpFunAttendanceScopeWifiMapper;
	@Autowired
	ErpFunAttendanceScopeWifiService erpFunAttendanceScopeWifiService;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	/**
	 * @Title 查询考勤地点列表
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param
	 **/
	@RequestMapping("/getAttendanceScopeList")
	public ResponseJson getList(@Valid @RequestBody ErpAttendanceModuleParam attendanceModuleParam) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		PageHelper.startPage(attendanceModuleParam.getPageOffset(), attendanceModuleParam.getPageRows(), attendanceModuleParam.isNeedCount());
		List<ErpFunAttendanceScopeDto> resList = erpFunAttendanceScopeMapper.getAttendanceScopeList(cityId, operator.getCompId(), operator.getDeptId(), attendanceModuleParam.getKeyWords());

		// 查询关联bizList
		Set<Integer> bizList = resList.stream().collect(Collectors.mapping(ErpFunAttendanceScopeDto::getAttScopeId, Collectors.toSet()));
		if(bizList.size() > 0) {
			// 根据权限查询范围内的人员
			// 公司、大区、片区、门店
			List<ErpFunAttendanceScopeBizPerson> erpFunAttendanceScopeBizPeopleList = erpFunAttendanceScopeBizPersonMapper.getUserList(cityId, bizList);
			Map<Integer, List<ErpFunAttendanceScopeBizPerson>> resHouselistMap = erpFunAttendanceScopeBizPeopleList.stream().collect(Collectors.groupingBy(ErpFunAttendanceScopeBizPerson::getAttScopeId));

			ErpFunAttendanceScopeWifiExample erpFunAttendanceScopeWifiExample = new ErpFunAttendanceScopeWifiExample();
			erpFunAttendanceScopeWifiExample.setShardCityId(cityId);
			erpFunAttendanceScopeWifiExample.createCriteria().andCompIdEqualTo(compId).andAttScopeIdIn(new ArrayList<>(bizList)).andWifiStatusNotEqualTo((byte)2);
			erpFunAttendanceScopeWifiExample.setOrderByClause(" WIFI_STATUS DESC, UPDATE_TIME DESC");

			// 查询关联wifi
			List<ErpFunAttendanceScopeWifi> wifiList = erpFunAttendanceScopeWifiMapper.selectByExample(erpFunAttendanceScopeWifiExample);
			Map<Integer, List<ErpFunAttendanceScopeWifi>> wifiListMap = new HashMap<>();
			if(wifiList.size() > 0) {
				wifiListMap = wifiList.stream().collect(Collectors.groupingBy(ErpFunAttendanceScopeWifi::getAttScopeId));
			}

			for (ErpFunAttendanceScopeDto erpFunAttendanceScopeDto : resList) {
				List<ErpFunAttendanceScopeBizPerson> erpFunAttendanceScopeBizPeople = resHouselistMap.get(erpFunAttendanceScopeDto.getAttScopeId());
				if (null != erpFunAttendanceScopeDto && erpFunAttendanceScopeBizPeople != null) {
					Set<Integer> userIdSet = erpFunAttendanceScopeBizPeople.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
					List<Integer> removeUserList = getRemoveUserList(userIdSet);
					if (removeUserList != null && removeUserList.size() > 0) {
						erpFunAttendanceScopeBizPeople = erpFunAttendanceScopeBizPeople.stream()
								.filter(val -> !removeUserList.contains(val.getUserId())).collect(Collectors.toList());
					}
					erpFunAttendanceScopeDto.setScopeUserList(erpFunAttendanceScopeBizPeople);
				}
				List<ErpFunAttendanceScopeWifi> erpFunAttendanceScopeWifis = wifiListMap.get(erpFunAttendanceScopeDto.getAttScopeId());
				if(null != erpFunAttendanceScopeDto) {
					erpFunAttendanceScopeDto.setScopeWifiList(erpFunAttendanceScopeWifis);
				}
			}
		}
		return ErpResponseJson.ok(new PageInfo<>(resList));
	}

	/**
	 * 查询考勤地点详情
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAttendanceScopeDetail")
	public ResponseJson getDetail(@Valid @RequestBody ErpAttendanceModuleParam attendanceModuleParam) {

		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String compNo = operator.getCompNo();
		ErpFunAttendanceScopeBizExample erpFunAttendanceScopeBizExample = new ErpFunAttendanceScopeBizExample();
		erpFunAttendanceScopeBizExample.setShardCityId(operator.getCityId());

		erpFunAttendanceScopeBizExample.createCriteria().andAttScopeIdEqualTo(attendanceModuleParam.getAttScopeId()).andIsDelEqualTo((byte) 0);
		List<ErpFunAttendanceScopeBiz> erpFunAttendanceScopeBizs = erpFunAttendanceScopeBizMapper.selectByExample(erpFunAttendanceScopeBizExample);
		//1：门店 2：分组 3：个体人
		Map<Integer, List<ErpFunAttendanceScopeBiz>> erpFunAttendanceScopeBizsMap =
				erpFunAttendanceScopeBizs.stream().collect(Collectors.groupingBy(val -> val.getChooseType()));
		Set<Integer> choseTypeSet = erpFunAttendanceScopeBizsMap.keySet();
		for (Integer type : choseTypeSet) {
			if (type == 1) {
				List<ErpFunAttendanceScopeBiz> deptAttendanceScopeBizs = erpFunAttendanceScopeBizsMap.get(type);
				Set<Integer> deptIdSet = deptAttendanceScopeBizs.stream().collect(Collectors.mapping(val -> val.getBizId(), Collectors.toSet()));
				if (deptIdSet.isEmpty()) {
					break;
				}
				List<Integer> stopDeptIds = getStopDeptIds(deptIdSet);
				erpFunAttendanceScopeBizs = erpFunAttendanceScopeBizs.stream().filter(val -> !stopDeptIds.contains(val.getBizId())).collect(Collectors.toList());
			} else if (type == 2) {
				List<ErpFunAttendanceScopeBiz> groupAttendanceScopeBizs = erpFunAttendanceScopeBizsMap.get(type);
				Set<Integer> grIdSet = groupAttendanceScopeBizs.stream().collect(Collectors.mapping(val -> val.getBizId(), Collectors.toSet()));
				if (grIdSet.isEmpty()) {
					break;
				}
				ErpFunDeptsgroupExample deptsgroupExample = new ErpFunDeptsgroupExample();
				deptsgroupExample.setShardCityId(cityId);
				deptsgroupExample.createCriteria().andCompIdEqualTo(compId).andGrIdIn(new ArrayList<>(grIdSet));
				List<ErpFunDeptsgroup> deptsgroupList = erpFunDeptsgroupMapper.selectByExample(deptsgroupExample);
				if (deptsgroupList.isEmpty()) {
					break;
				}
				Set<Integer> deptIdSet = deptsgroupList.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toSet()));
				List<Integer> stopDeptIds = getStopDeptIds(deptIdSet);
				List<Integer> stopGrIds = deptsgroupList.stream().filter(val -> stopDeptIds.contains(val.getDeptId()))
						.collect(Collectors.mapping(val -> val.getGrId(), Collectors.toList()));
				//处理已经删除的分组
				stopGrIds.addAll(deptsgroupList.stream().filter(val->val.getIsDel()==1).collect(Collectors.mapping(val->val.getGrId(),Collectors.toList())));
				erpFunAttendanceScopeBizs = erpFunAttendanceScopeBizs.stream().filter(val -> !stopGrIds.contains(val.getBizId())).collect(Collectors.toList());
			} else if (type == 3) {
				List<ErpFunAttendanceScopeBiz> userAttendanceScopeBizs = erpFunAttendanceScopeBizsMap.get(type);
				Set<Integer> userIdSet = userAttendanceScopeBizs.stream().collect(Collectors.mapping(val -> val.getBizId(), Collectors.toSet()));
				List<Integer> stopUserIds =getRemoveUserList(userIdSet);
				if (stopUserIds!=null&&stopUserIds.size()>0){
					erpFunAttendanceScopeBizs = erpFunAttendanceScopeBizs.stream().filter(val -> !stopUserIds.contains(val.getBizId())).collect(Collectors.toList());
				}
			}
		}
		return ErpResponseJson.ok(erpFunAttendanceScopeBizs);
	}

	private List<Integer> getRemoveUserList(Set<Integer> userIdSet) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		List<Integer> removeUserList = new ArrayList<>();
		if (userIdSet.isEmpty()) {
			return removeUserList;
		}
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(new ArrayList<>(userIdSet));
		List<ErpFunUsers> funUsersList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		if (funUsersList.isEmpty()) {
			return removeUserList;
		}
		Set<Integer> deptIdSet = funUsersList.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toSet()));
		List<Integer> stopDeptIds = getStopDeptIds(deptIdSet);
		removeUserList = funUsersList.stream().filter(val -> stopDeptIds.contains(val.getDeptId()))
				.collect(Collectors.mapping(val -> val.getUserId(), Collectors.toList()));
		//处理已经注销的用户
		removeUserList.addAll(funUsersList.stream().filter(val -> val.getUserWriteoff()).collect(Collectors.mapping(val -> val.getUserId(), Collectors.toList())));
		return removeUserList;
	}

	private List<Integer> getStopDeptIds(Set<Integer> deptIdSet) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String compNo = operator.getCompNo();
		List<Integer> stopDeptIds = new ArrayList<>();
		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andDeptIdIn(new ArrayList<>(deptIdSet)).andCompIdEqualTo(compId);
		List<ErpFunDepts> deptsList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		if (deptsList.isEmpty()) {
			return stopDeptIds;
		}
		//停用
		List<ErpFunDepts> stopDeptList = deptsList.stream().filter(val -> val.getDeptFlag() == 0).collect(Collectors.toList());
		//试用
		List<ErpFunDepts> tryUseDeptsList = deptsList.stream().filter(val -> val.getDeptFlag() == 1).collect(Collectors.toList());
		if (tryUseDeptsList.size()>0){
			List<String> deptNos = tryUseDeptsList.stream().collect(Collectors.mapping(val -> val.getDeptNo(),
					Collectors.toList()));
			List<ErpFunDepts> stopDeptList2 = erpFunDeptsMapper.getStopDeptList(cityId, compId, compNo, deptNos);
			if (stopDeptList2 != null && stopDeptList2.size() > 0) {
				stopDeptList.addAll(stopDeptList2);
			}
		}
		stopDeptIds = stopDeptList.stream().collect(Collectors.mapping(val -> val.getDeptId(), Collectors.toList()));
		return stopDeptIds;
	}

	/**
	 * @Title 新增编辑考勤地点
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param 
	 **/
	@RequestMapping("/addEditAttendanceScope")
	public ResponseJson addEditAttendanceScope(@Valid @RequestBody ErpAttendanceScopeParam erpAttendanceScopeParam) {
		Assert.isBlankThrow(erpAttendanceScopeParam.getAttScopeX(),"获取定位失败，请联系在线客服");
		Assert.isBlankThrow(erpAttendanceScopeParam.getAttScopeY(),"获取定位失败，请联系在线客服");
		Operator operator = getOperator();
		Integer res = erpFunAttendanceScopeService.addEditDetail(operator.getCityId(), operator.getCompId(), operator.getDeptId(), erpAttendanceScopeParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 新增编辑考勤地点
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param
	 **/
	@RequestMapping("/delAttendanceScope")
	public ResponseJson delAttendanceScope(@Valid @RequestBody ErpAttendanceScopeParam erpAttendanceScopeParam) {
		Operator operator = getOperator();
		Integer res = erpFunAttendanceScopeService.delAttendanceScope(operator.getCityId(), operator.getCompId(), erpAttendanceScopeParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 * @Title 更新wifi的开启关闭状态
	 * @Author lcb
	 * @Date 2017/11/22
	 * @Param
	 **/
	@RequestMapping("/updateScopeWifiStatus")
	public ResponseJson updateScopeWifiStatus(@Valid @RequestBody ErpAttendanceScopeParam erpAttendanceScopeParam) {
		Operator operator = getOperator();
		Integer res = erpFunAttendanceScopeWifiService.updateScopeWifiStatus(operator.getCityId(), operator.getCompId(), erpAttendanceScopeParam);
		return ErpResponseJson.ok(res);
	}
}
