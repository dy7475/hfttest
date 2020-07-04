package com.myfun.erpWeb.openApi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.agencydb.dao.AgencyVipQueueMapper;
import com.myfun.repository.agencydb.dao.AgencyWfPushLogMapper;
import com.myfun.repository.agencydb.param.VStoreEntrustParam;
import com.myfun.repository.agencydb.po.AgencyWfPushLog;
import com.myfun.repository.agencydb.vo.EntrustVO;
import com.myfun.utils.StringUtil;
import com.myfun.utils.rest.DateUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取委托列表接口提到 OpenApi
 *
 * @author czq
 * @since 2019/8/14
 */
@RestController
@RequestMapping("/openApi/vStore")
public class VStoreOpenApiController {

    @Resource
    private AgencyWfPushLogMapper agencyWfPushLogMapper;
    @Resource
    private AgencyVipQueueMapper agencyVipQueueMapper;

    @ApiOperation("网站获取委托列表")
    @ApiResponses(value = {@ApiResponse(code = 200, response = EntrustVO.class, responseContainer = "List", message = "成功")})
    @PostMapping("/getVStoreEntrustList")
    @ResponseBody
    public ResponseJson getVStoreEntrustList(@RequestBody VStoreEntrustParam entrustParam) {
        String startTime = entrustParam.getStartTime();
        if (StringUtil.isNotBlank(startTime)) {
            entrustParam.setStartTime(startTime + " 00:00:00");
        }
        String endTime = entrustParam.getEndTime();
        if (StringUtil.isNotBlank(endTime)) {
            entrustParam.setEndTime(endTime + " 00:00:00");
        }

        // 获取委托记录列表
        PageHelper.startPage(entrustParam.getPageOffset(), entrustParam.getPageRows(), true);
        List<EntrustVO> entrusts = agencyVipQueueMapper.getVipQueueList(entrustParam);

        List<Integer> wfIds = entrusts.stream().map(EntrustVO::getWfId).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(wfIds)) {
            List<AgencyWfPushLog> logs = agencyWfPushLogMapper.getWfPushLogByIds(wfIds);

            for (EntrustVO entrust : entrusts) {
                Integer wfId = entrust.getWfId();
                long count = logs.stream().filter(it -> it.getVipQueueId() != null && it.getVipQueueId().equals(wfId)).count();
                entrust.setLogCount(count);

                Date creationTime = entrust.getCreationTime();
                if (creationTime != null) {
                    String wtTime = DateUtil.dateToStr(creationTime, "yyyy-MM-dd HH:mm:ss");
                    entrust.setWtTime(wtTime);
                }
            }
        }

        PageInfo<EntrustVO> pageInfo = new PageInfo<>(entrusts);
        return ErpResponseJson.ok(pageInfo);
    }

}