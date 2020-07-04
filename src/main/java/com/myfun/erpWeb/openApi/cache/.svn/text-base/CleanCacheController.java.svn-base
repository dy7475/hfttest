package com.myfun.erpWeb.openApi.cache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.myfun.utils.HttpUtil;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const.CacheStructure;
import com.myfun.utils.Assert;

/**
 * 缓存清理控制器
 * @author 张宏利
 * @since 2017年9月8日
 */
@Controller
@RequestMapping(value = "/openApi/cache")
public class CleanCacheController extends BaseController {

	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;

	/**
	 * 通过公司编号清除公司系统参数缓存
	 * @param compNos 公司编号，多个以英文逗号分隔
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cleanSysParamByCompNos")
	public ErpResponseJson getProvinceList(@NotBlank String compNos) {
		Assert.isNullThrow(compNos);
		String[] compNoArr = compNos.split(",");
		for (String compNo : compNoArr) {
			ErpFunComp erpFunComp = erpFunCompMapper.getCompByCompNo(compNo);
			if(erpFunComp != null) {
			    cacheUtil.del(CacheStructure.hfterpdb_sysParaCache_map_by_CompId
						+ erpFunComp.getCompId() + "_CITY_ID_" + erpFunComp.getCityId());
			}
		}
		return ErpResponseJson.ok();
	}
	
	/**
	 * 清除门店用户缓存
	 * @param cityId
	 * @param erpDeptId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cleanSysParamByDept")
	public ErpResponseJson getProvinceList(Integer cityId, String compNo, String deptNo) {
		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		erpFunDeptsExample.createCriteria().andCompNoEqualTo(compNo).andDeptNoEqualTo(deptNo);
		List<ErpFunDepts> list = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
		ErpFunDepts erpFunDepts = list.get(0);
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andDeptIdEqualTo(erpFunDepts.getDeptId()).andUserWriteoffEqualTo(false);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		for (int i = 0; i < userList.size(); i++) {
			cacheUtil.del(CacheStructure.ARCHIVE_ID_OPERATOR + userList.get(i).getArchiveId());
		}
		return ErpResponseJson.ok();
	}

	public static void main(String[] args) {
		String depts="D1,D2,D3,D4,D5,D6,D7,D8,D9,E0,E1,E2,E3,E4,E5,E6,E7,E8,E9,F0,F1,F2,F3,F4,F5,F6,F7,F8,F9,G0,G1,G2,G3,G4,G5,G6,G7,G8,G9,H0,H1,H2,H3,H4,H5,H6,H7,H8,H9,I0,I1,I2,I3,I4,I5,I6,I7,I8,I9,J0,J1,J2,J3,J4,J5,J6,J7,J8,J9,K0,K1,K2,K3,K4,K5,K6,K7,K8,K9,L0,L1,L2,L3,L4,L5,L6,L7,L8,L9,M0,M1,M2,M3,M4,M5,M6,M7,M8,M9,N0,N1,N2,N3,N4,N5,N6,N7,N8,N9,O0,O1,O2,O3,O4,O5,O6,O7,O8,O9";
		String[] deptArr = depts.split(",");
		for(String deptNo : deptArr){
			String url = "http://erpweb.myfun7.com/erpWeb/openApi/cache/cleanSysParamByDept";
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("cityId", 61);
			paramMap.put("compNo", "E1D4");
			paramMap.put("deptNo", deptNo);
			HttpUtil.postJson(url, paramMap);
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("清理完毕");
	}



}
