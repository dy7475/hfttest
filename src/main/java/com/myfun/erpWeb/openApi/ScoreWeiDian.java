package com.myfun.erpWeb.openApi;

import com.myfun.framework.web.json.DefaultResponseJson;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.po.AdminFunScoreStandardMonth;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.admindb.AdminFunScoreStandardMonthService;
import com.myfun.service.business.erpdb.ErpFunCompService;
import com.myfun.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by lcb on 2017-02-13.
 */
@Controller
@RequestMapping("/openApi/score4WeiDian")
public class ScoreWeiDian {

    @Autowired
    ErpFunCompService erpFunCompService;

    /**
     * 刷新优秀员工
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/setExcellentExp")
    public ResponseJson SetExcellentExp(Integer cityId, String compNo, String deptNo, Integer type) {
        erpFunCompService.setExcellent(cityId, compNo, deptNo);
        return ErpResponseJson.ok();
    }

}
