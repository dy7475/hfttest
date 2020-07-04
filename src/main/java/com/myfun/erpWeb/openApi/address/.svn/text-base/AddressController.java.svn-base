package com.myfun.erpWeb.openApi.address;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunProvinceMapper;
import com.myfun.repository.admindb.dao.AdminFunRegMapper;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunProvince;
import com.myfun.repository.admindb.po.AdminFunReg;
import com.myfun.service.business.erpdb.ErpSysParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/openApi/adress")
public class AddressController extends BaseController {

    @Autowired
    private AdminFunProvinceMapper adminFunProvinceMapper;
    @Autowired
    private AdminFunCityMapper adminFunCityMapper;
    @Autowired
    private AdminFunRegMapper adminFunRegMapper;
    @Autowired
    private ErpSysParaService erpSysParaService;

    /**
     * 获取所有省份
     *
     * @return
     * @throws Exception
     * @author 何传强
     * @since 2017年6月19日
     */
    @ResponseBody
    @RequestMapping(value = "/getProvinceList")
    public ErpResponseJson getProvinceList(HttpServletResponse response) {
        List<AdminFunProvince> provinceList = adminFunProvinceMapper.getProvinceAll(null);
        return ErpResponseJson.ok(provinceList);
    }

   /**
    * @title 查询城市
    * @author lcb
    * @date 2019/12/24
    *
    **/
    @ResponseBody
    @RequestMapping(value = "/getCityList")
    public ErpResponseJson getCityList(HttpServletResponse response, Integer provinceId) {
        List<AdminFunCity> cityList = adminFunCityMapper.getCityByProviceId(provinceId);
        return ErpResponseJson.ok(cityList);
    }

    /**
     * 根据城市ID获取该城市下的所有区县(区县ID,区县名称)
     *
     * @param param
     * @param cityId
     * @return
     * @throws Exception
     * @author 何传强
     * @since 2017年6月19日
     */
    @ResponseBody
    @RequestMapping(value = "/getRegList")
    public ErpResponseJson getRegList(HttpServletResponse response, Integer cityId) {
        if (cityId != null) {
            List<AdminFunReg> regList = adminFunRegMapper.getRegByCityId(cityId);
            return ErpResponseJson.ok(regList);
        }
        return ErpResponseJson.ok();
    }

    /**
     * 生成MD5码，提供给顾总导数据等使用
     *
     * @param cityId
     * @return
     * @author 张宏利
     * @since 2017年12月4日
     */
    @ResponseBody
    @RequestMapping(value = "/createAddrMd5")
    public ErpResponseJson createAddrMd5(String roof, String unit, String floor, String num,
                                         Integer buildId, Byte useage, String tradeAddr, Integer cityId, Integer compId) {
        List<String> encodeToMD5 = erpSysParaService.encodeToMD5(roof, unit, floor, num, buildId, useage, tradeAddr, cityId, compId);
        return ErpResponseJson.ok(encodeToMD5);
    }
}
