package com.myfun.erpWeb.onlinepay.controller;

import com.myfun.erpWeb.onlinepay.api.BankApi;
import com.myfun.erpWeb.onlinepay.param.QueryBankCodeParam;
import com.myfun.erpWeb.onlinepay.vo.QueryBankCodeVO;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminBankDetailInfoMapper;
import com.myfun.repository.admindb.po.AdminBankDetailInfo;
import com.myfun.repository.admindb.po.AdminBankDetailInfoExample;
import com.myfun.utils.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @title 在线收款账户模块
 * @author lcb
 * @since 2019/8/24
 * @param 
 * @return
 */
@RestController
public class BankController extends BaseController implements BankApi {

    @Autowired
    AdminBankDetailInfoMapper adminBankDetailInfoMapper;

    @Override
    public ResponseJson queryBankCode(@RequestBody QueryBankCodeParam param) {
        String openBankName = param.getOpenBankName();

        Assert.isBlankThrow(openBankName, "开户行名称不可为空");
        openBankName = openBankName.trim();
        AdminBankDetailInfoExample adminBankDetailInfoExample = new AdminBankDetailInfoExample();
        adminBankDetailInfoExample.createCriteria().andBankDetailNameEqualTo(openBankName);
        adminBankDetailInfoExample.setOrderByClause(" ID ");
        List<AdminBankDetailInfo> adminBankDetailInfos = adminBankDetailInfoMapper.selectByExample(adminBankDetailInfoExample);

        QueryBankCodeVO queryBankCodeVO = new QueryBankCodeVO();

        // 只允许一条数据存在，如果有多条数据都需要处理
        if(adminBankDetailInfos.size() > 0) {
            queryBankCodeVO.setAdminBankDetailInfo(adminBankDetailInfos.get(0));
        }
        return ErpResponseJson.ok(queryBankCodeVO);
    }

}
