package com.myfun.erpWeb.managecenter.deal;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.constract.param.ProcessCompareLogParam;
import com.myfun.erpWeb.managecenter.constract.vo.CompareLogListVo;
import com.myfun.erpWeb.managecenter.deal.param.DealParam;
import com.myfun.erpWeb.managecenter.deal.vo.FunProcessRecordDTO;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunDealRecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunProcessRecordMapper;
import com.myfun.repository.erpdb.dto.ErpFunDealRecordDto;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunProcessRecord;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.ErpFunDeptsService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.bean.vo.UserOrganizationInfoVO;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 合同日志相关
 * 
 * @author 张宏利
 * @since 2017年9月21日
 */
@Api("合同日志相关")
@RestController
@RequestMapping(value = "/managecenter/deal", method = RequestMethod.POST)
public class DealLogRecordController extends BaseController {
	@Autowired
	ErpFunProcessRecordMapper erpFunProcessRecordMapper;
	@Autowired
	ErpFunDealRecordMapper erpFunDealRecordMapper;
	@Autowired
	private ErpFunDeptsService erpFunDeptsService;
	@Autowired
	private ErpFunUsersService erpFunUsersService;

	/**
	 * 查询合同日志列表
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 */
	@NotBlank("dealId")
	@RequestMapping("/getMgrDealNoteList")
	public ResponseJson getMgrDealNoteList(@RequestBody DealParam param) {
		return getMgrDealNoteList(param, 1);
	}
	
	/**
	 * 查询应收实收日志列表
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 */
	@NotBlank("dealId")
	@RequestMapping("/getMgrDealProcessFianacNoteList")
	public ResponseJson getMgrDealProcessFianacNoteList(@RequestBody DealParam param) {
		return getMgrDealNoteList(param, 2);
	}
	
	/**
	 * 查询业绩日志列表
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 */
	@NotBlank("dealId")
	@RequestMapping("/getMgrDealProfitNoteList")
	public ResponseJson getMgrDealProfitNoteList(@RequestBody DealParam param) {
		return getMgrDealNoteList(param, 3);
	}
	
	/**
	 * 查询税费日志列表
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 */
	@NotBlank("dealId")
	@RequestMapping("/getMgrDealTaxesNoteList")
	public ResponseJson getMgrDealTaxesNoteList(@RequestBody DealParam param) {
		return getMgrDealNoteList(param, 4);
	}
	
	public ResponseJson getMgrDealNoteList(DealParam param, Integer logType) {
		String dealId = param.getDealId();// 老版本里面不是必传，不知道为什么，改为必传了
		Integer compId = getOperator().getCompId();
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<ErpFunDealRecordDto> recordList = erpFunDealRecordMapper.getMgrDealNoteList(getOperator().getCityId(), dealId, compId, logType);
		Set<Integer> deptIds = recordList.parallelStream().map(ErpFunDealRecordDto::getDeptId).collect(Collectors.toSet());
 		List<ErpFunDepts> deptListByDeptIds = erpFunDeptsService.getDeptListByDeptIds(getOperator().getCityId(), deptIds);
		HashMap<Integer, String> deptNameMap = deptListByDeptIds.parallelStream().collect(HashMap::new, (m, p) -> m.put(p.getDeptId(), p.getDeptName()), Map::putAll);
		// story#11536 PC跨城管理-查询人员的组织信息
		if (!recordList.isEmpty()) {
			List<Integer> userIdList = recordList.stream().map(ErpFunDealRecordDto :: getUpdateUid).collect(Collectors.toList());
			if (!userIdList.isEmpty()) {
				Map<Integer, UserOrganizationInfoVO> userOrganizationInfoMap = erpFunUsersService.getUserOrganizationInfoByUserIds(getOperator().getCityId(), userIdList);
				if (null != userOrganizationInfoMap) {
					recordList.stream().forEach(a -> {
						Integer userId = a.getUpdateUid();
						UserOrganizationInfoVO userOrganizationInfoVO = userOrganizationInfoMap.get(userId);
						if (null != userOrganizationInfoVO) {
							a.setOrganizationId(userOrganizationInfoVO.getOrganizationId());
							a.setOrganizationName(userOrganizationInfoVO.getOrganizationName());
							a.setCompName(userOrganizationInfoVO.getCompName());
						}
					});
				}
			}
		}
		for (ErpFunDealRecordDto dto : recordList) {
			// 合同指标修改类型暂不显示详情
			if("3".equals(dto.getUpdateType())) {
				dto.setFrontRecordId(null);
			}
			dto.setDeptName(deptNameMap.get(dto.getDeptId()));
			if (StringUtils.isNotEmpty(dto.getUpdateClassic()) && !dto.getUpdateClassic().startsWith("【") && !dto.getUpdateClassic().endsWith("】")) {
				dto.setUpdateClassic("【" + dto.getUpdateClassic() + "】");
			}
		}
		PageInfo<ErpFunDealRecordDto> pageInfo = new PageInfo<>(recordList);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 查询合同流程日志列表
	 * @author 张宏利
	 * @since 2017年9月21日
	 * @param param
	 * @return
	 */
	@NotBlank("dealId")
	@RequestMapping("/getMgrDealProcessLogList")
	public ResponseJson getMgrDealProcessLogList(@RequestBody DealParam param) throws InvocationTargetException, IllegalAccessException {
		Integer dealId = Integer.valueOf(param.getDealId());// 老版本里面不是必传，不知道为什么，改为必传了
		Integer compId = getOperator().getCompId();
		PageHelper.startPage(param.getPageOffset(), param.getPageRows());
		List<ErpFunProcessRecord> recordList = erpFunProcessRecordMapper.getMgrDealProcessLogList(getOperator().getCityId(), dealId, compId);
		Set<Integer> deptIds = recordList.stream().map(ErpFunProcessRecord::getDeptId).collect(Collectors.toSet());
		List<ErpFunDepts> deptListByDeptIds = erpFunDeptsService.getDeptListByDeptIds(getOperator().getCityId(), deptIds);
		HashMap<Integer, String> deptNameMap = deptListByDeptIds.parallelStream().collect(HashMap::new, (m, p) -> m.put(p.getDeptId(), p.getDeptName()), Map::putAll);

		List<FunProcessRecordDTO> dtoList = new ArrayList<>();
		for (ErpFunProcessRecord erpFunProcessRecord : recordList) {
			FunProcessRecordDTO dto = new FunProcessRecordDTO();
			BeanUtils.copyProperties(erpFunProcessRecord, dto);
			dto.setDeptName(deptNameMap.get(dto.getDeptId()));
			if (StringUtils.isNotEmpty(erpFunProcessRecord.getUpdateClassic()) && !erpFunProcessRecord.getUpdateClassic().startsWith("【") && !erpFunProcessRecord.getUpdateClassic().endsWith("】")) {
				dto.setUpdateClassic("【" + dto.getUpdateClassic() + "】");
			}
			dtoList.add(dto);
		}
		// story#11536 PC跨城管理-查询人员的组织信息
		if (!dtoList.isEmpty()) {
			List<Integer> userIdList = dtoList.stream().map(FunProcessRecordDTO :: getUpdateUid).collect(Collectors.toList());
			if (!userIdList.isEmpty()) {
				Map<Integer, UserOrganizationInfoVO> userOrganizationInfoMap = erpFunUsersService.getUserOrganizationInfoByUserIds(getOperator().getCityId(), userIdList);
				if (null != userOrganizationInfoMap) {
					dtoList.stream().forEach(a -> {
						Integer userId = a.getUpdateUid();
						UserOrganizationInfoVO userOrganizationInfoVO = userOrganizationInfoMap.get(userId);
						if (null != userOrganizationInfoVO) {
							a.setOrganizationId(userOrganizationInfoVO.getOrganizationId());
							a.setOrganizationName(userOrganizationInfoVO.getOrganizationName());
							a.setCompName(userOrganizationInfoVO.getCompName());
						}
					});
				}
			}
		}
		PageInfo pageInfo = new PageInfo<>(recordList);
		ErpResponseJson ok = ErpResponseJson.ok(pageInfo);
		ok.setData(dtoList);
		return ok;
	}
	
	/**
	 * 查询合同流程对比日志列表
	 * @author 熊刚
	 * @since 2017年9月23日
	 * @param param
	 * @return
	 */
	@ApiOperation("查询合同流程对比日志列表")
	@ApiResponse(code = Const.ResponseCode.SUCCESS, response = CompareLogListVo.class, message = "成功")
	@PostMapping("/getMgrDealProcessCompareLogList")
	public ResponseJson getMgrDealProcessCompareLogList(@RequestBody ProcessCompareLogParam param) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Integer cityId = getOperator().getCityId();
		Integer dealId = param.getDealId();
		Integer compId = getOperator().getCompId();
		Integer recordId = param.getRecordId();
		
		ErpFunProcessRecord erpFunProcessRecord = erpFunProcessRecordMapper.getMgrDealProcessLog(cityId, dealId, compId,recordId);
		String updateContent = erpFunProcessRecord.getUpdateContent();
		if(StringUtil.isNotEmpty(updateContent)){
			Map<String, Object> jsonMap = (Map<String, Object>) JSON.parse(updateContent);
			Map<String, String> paramMap = (Map<String, String>) jsonMap.get("PROCESS_RUNTIME_STEP");
			returnMap.put("newVal", paramMap);
		}
		Integer frontRecordId = erpFunProcessRecord.getFrontRecordId();
		if(frontRecordId != null){
			erpFunProcessRecord = erpFunProcessRecordMapper.getMgrDealProcessLog(cityId, dealId, compId,frontRecordId);
			updateContent = erpFunProcessRecord.getUpdateContent();
			Map<String, Object> jsonMap = (Map<String, Object>) JSON.parse(updateContent);
			Map<String, String> paramMap = (Map<String, String>) jsonMap.get("PROCESS_RUNTIME_STEP");
			returnMap.put("oldVal", paramMap);
		}
		return ErpResponseJson.ok(returnMap);
	}
}


