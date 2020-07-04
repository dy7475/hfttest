package com.myfun.erpWeb.managecenter.attendance;

import com.myfun.erpWeb.managecenter.attendance.vo.AttendanceGroupDto;
import com.myfun.erpWeb.managecenter.attendance.vo.MaxApplyClassVo;
import com.myfun.erpWeb.managecenter.param.MaxApplyClassParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceClassMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceGroupMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceStatisticsMapper;
import com.myfun.repository.erpdb.dao.ErpFunAttendanceUserClassDetailMapper;
import com.myfun.repository.erpdb.dto.ErpFunAttendanceClassDto;
import com.myfun.repository.erpdb.param.ErpAttendanceModuleParam;
import com.myfun.repository.erpdb.param.ErpFunAttendanceClassParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.ErpFunAttendanceClassService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.MapUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 管理中心-新版考勤班次模块
 * @author lcb
 * @2017-11-22
 */
@RestController
@RequestMapping("/managerCenter/attendanceClassModule/")
public class AttendanceClassController extends BaseController {

	@Autowired
	private ErpFunAttendanceClassMapper attendanceClassMapper;
	@Autowired
	private ErpFunAttendanceClassService erpFunAttendanceClassService;
	@Autowired
	private ErpFunAttendanceUserClassDetailMapper erpFunAttendanceUserClassDetailMapper;
	@Autowired
	private ErpFunAttendanceGroupMapper erpFunAttendanceGroupMapper;
	@Autowired
	ErpFunAttendanceStatisticsMapper erpFunAttendanceStatisticsMapper;

	/**
	 * 查询班次列表
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAttendanceClassList")
	public ResponseJson getList(@Valid @RequestBody ErpAttendanceModuleParam param) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		String keyWords = param.getKeyWords();

		List<ErpFunAttendanceClassDto> resList = attendanceClassMapper.getAttendanceClassList(cityId, compId, keyWords);
		List<AttendanceGroupDto> attenGroupList = erpFunAttendanceGroupMapper.getAttenGroupList(cityId, compId);
		//如果没有班次则直接返回  没有考勤组的时候不用继续封装数据 也直接返回
		if (CollectionUtils.isEmpty(resList) || CollectionUtils.isEmpty(attenGroupList)) {
			return ErpResponseJson.ok(resList);
		}

		Map<Integer, AttendanceGroupDto> groupMap = attenGroupList.stream().collect(Collectors.toMap(v -> v.getId(), v -> v));
		//人员排班里不重复的班次和组
		List<ErpFunAttendanceUserClassDetail> classAndGr = erpFunAttendanceGroupMapper.getUserClassDetailList(cityId, compId);
		Map<Integer, Set<Integer>> classAndGrMap = classAndGr.stream().collect(Collectors.groupingBy(v -> v.getAttClassId(), Collectors.mapping(v -> v.getAttGrId(), Collectors.toSet())));

		//封装考勤组信息 现在排班制和固定班制不会重复 既attenGroupList 和 classAndGr里不会出现相同的考勤组，但是还是先取出来去下重比较保险 万一以后改了或者出现脏数据呢
		for (ErpFunAttendanceClassDto dto : resList) {
			Set<ErpFunAttendanceGroup> grSet = new HashSet<>();
			Set<Integer> grIds = new HashSet<>();
			for (AttendanceGroupDto gr : attenGroupList){
				if (gr.getAttClassId().contains(dto.getId().toString())) {
					grIds.add(gr.getId());
				}
			}
			if (CollectionUtils.isNotEmpty(classAndGr)) {
				Set<Integer> set = classAndGrMap.get(dto.getId());
				if (CollectionUtils.isNotEmpty(set)) {
					grIds.addAll(set);
				}
			}
			for (Integer grId : grIds){
				if (groupMap.get(grId) != null) {
					ErpFunAttendanceGroup attendanceGroup = new ErpFunAttendanceGroup();
					BeanUtils.copyProperties(groupMap.get(grId),attendanceGroup);
					grSet.add(attendanceGroup);
				}
			}
			dto.setGroupList(grSet);
		}
		return ErpResponseJson.ok(resList);
	}

	/**
	 * 查询班次详情
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAttendanceClassDetail")
	public ResponseJson getDetail(@Valid @RequestBody ErpAttendanceModuleParam param) throws Exception{
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();

		ErpFunAttendanceClass erpFunAttendanceClass = new ErpFunAttendanceClass();
		erpFunAttendanceClass.setShardCityId(cityId);
		erpFunAttendanceClass.setId(param.getId());
		erpFunAttendanceClass = attendanceClassMapper.selectByPrimaryKey(erpFunAttendanceClass);

		Map<String, Object> map = MapUtil.objectToMap(erpFunAttendanceClass);
		if(null != map) {
			Integer attendanceClassApplyCount = getAttendanceClassApplyCount(cityId, operator.getCompId(), erpFunAttendanceClass.getId());
			map.put("applyCount", attendanceClassApplyCount);
		}
		return ErpResponseJson.ok(map);
	}

	/**
	 *  新增编辑班次
	 * @author lcb
	 * @Date 2017-11-22
	 * @return 如果是修改 就返回修改条数 ，如果是新增就返回新增的对象ID
	 * @throws Exception
	 */
	@RequestMapping("/addEditAttendanceClass")
	public ResponseJson addEditDetail(@Valid @RequestBody ErpFunAttendanceClassParam erpFunAttendanceClassParam) {
		Operator operator = getOperator();
		Integer res = erpFunAttendanceClassService.addEditAttendance(operator.getCityId(), operator.getCompId(), operator.getDeptId(), erpFunAttendanceClassParam);
		return ErpResponseJson.ok(res);
	}

	/**
	 *  删除班次
	 * @author lcb
	 * @Date 2017-11-22
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delAttendanceClass")
	public ResponseJson delAttendanceClass(@Valid @RequestBody ErpFunAttendanceClassParam erpFunAttendanceClassParam) {
		Operator operator = getOperator();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
		Integer attendanceClassApplyCount = getAttendanceClassApplyCount(cityId, compId, erpFunAttendanceClassParam.getId());
		if (attendanceClassApplyCount > 0) {
			throw new BusinessException("当前班次正在使用中,无法删除");
		}
		Integer res = erpFunAttendanceClassService.delAttendanceClass(operator.getCityId(), operator.getCompId(), erpFunAttendanceClassParam);
		return ErpResponseJson.ok(res);
	}


	private Integer getAttendanceClassApplyCount(Integer cityId, Integer compId, Integer attendanceClassId) {
		// 排班
		/*ErpFunAttendanceUserClassDetailExample erpFunAttendanceUserClassDetailExample = new ErpFunAttendanceUserClassDetailExample();
		erpFunAttendanceUserClassDetailExample.setShardCityId(cityId);
		erpFunAttendanceUserClassDetailExample.createCriteria().andCompIdEqualTo(compId)
				.andAttClassIdEqualTo(attendanceClassId).andIsDelEqualTo((byte) 0);
		Integer count = erpFunAttendanceUserClassDetailMapper.countByExample(erpFunAttendanceUserClassDetailExample);*/
		Integer count = erpFunAttendanceUserClassDetailMapper.countHshApplied(cityId,compId,attendanceClassId);
		// 行政班
		count += erpFunAttendanceGroupMapper.countHshApplied(cityId,
				compId, attendanceClassId);
		return count;
	}


	/**
	 *  新增编辑班次
	 * @author lcb
	 * @Date 2017-11-22
	 * @return 如果是修改 就返回修改条数 ，如果是新增就返回新增的对象ID
	 * @throws Exception
	 */
	@RequestMapping("/getAttendanceClassApplyCount")
	public ResponseJson getAttendanceClassApplyCount(@Valid @RequestBody ErpFunAttendanceClassParam erpFunAttendanceClassParam) {
		Integer compId = getOperator().getCompId();
		Integer cityId = getOperator().getCityId();
		Integer classId = erpFunAttendanceClassParam.getId();
		Integer attendanceClassApplyCount = getAttendanceClassApplyCount(cityId, compId, classId);
		return ErpResponseJson.ok(attendanceClassApplyCount);
	}

	/**
	 * 获取公司应用最大的打卡次数
	 * @param
	 * @return
	 */
	@ApiOperation(value = "获取公司应用最大的打卡次数",httpMethod = "POST")
	@ApiResponses({@ApiResponse(code = 200,response = MaxApplyClassVo.class,message = "success")})
	@RequestMapping("/getMaxApplyClass")
	public ResponseJson getMaxApplyClass(@RequestBody MaxApplyClassParam maxApplyClassParam) {

		MaxApplyClassVo vo = new MaxApplyClassVo();
		String attMonth = maxApplyClassParam.getAttMonth() == null || "".equals(maxApplyClassParam.getAttMonth()) ? DateTimeHelper.formatDateTimetoString(new Date()) : maxApplyClassParam.getAttMonth();
		String attDateStart = DateTimeHelper.getFirstDayOfMonth(attMonth);
		String attDateEnd = DateTimeHelper.getLastDayOfMonth(attMonth);
		//查询当月公司打卡最大轮次
		Integer maxCount = erpFunAttendanceStatisticsMapper.getMaxAttSumCountOfMonth(getOperator().getCityId(), getOperator().getCompId(), attDateStart, attDateEnd);
		vo.setMaxCount(maxCount == null ? 3 : maxCount);

		return ErpResponseJson.ok(vo);
	}
}
