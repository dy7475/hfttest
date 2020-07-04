package com.myfun.erpWeb.openApi;

import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.BestsignContractMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustOwnersMapper;
import com.myfun.repository.erpdb.po.BestsignContract;
import com.myfun.repository.erpdb.po.ErpFunEntrustOwners;
import com.myfun.service.business.erpdb.BestsignContractService;
import com.myfun.service.business.erpdb.BestsignService;
import com.myfun.utils.StringUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  电子委托开放接口
 * @author v-wuzhengkang
 *
 */
@RestController
@RequestMapping(value = "/openApi/mlEntrustApi")
@Api(tags = "电子委托开放接口控制器", value = "alipayHouseBiz")
public class OpenApiMlEntrustApiController {
    @Autowired
    private BestsignService bestsignService;
    @Autowired
    private BestsignContractMapper bestsignContractMapper;
    @Autowired
    private BestsignContractService bestsignContractService;
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunEntrustOwnersMapper;
    
    @GetMapping(value = "/getContractId")
    public String getContractId() throws Exception{
    	Map<String, String> templateValues = new HashMap<String, String>();
    	templateValues.put("text","123123123");
    	List<ErpFunEntrustOwners> entrustOwnerList = new ArrayList<ErpFunEntrustOwners>();
    	ErpFunEntrustOwners erpFunEntrustOwners = new ErpFunEntrustOwners();
    		erpFunEntrustOwners.setAddress("地址");
    		erpFunEntrustOwners.setCardNo("431121199108237317");
    		erpFunEntrustOwners.setEntrustId(4);
    		erpFunEntrustOwners.setId(4);
    		erpFunEntrustOwners.setIdType((byte)1);
    		erpFunEntrustOwners.setIsSign((byte)0);
    		erpFunEntrustOwners.setNativePlace((byte)1);
    		erpFunEntrustOwners.setOwnerName("库里");
    		erpFunEntrustOwners.setOwnerPhone("15999663324");
//    		erpFunEntrustOwners.setShardArchiveId(shardArchiveId);
//    		erpFunEntrustOwners.setShardCityId(shardCityId);
//    		erpFunEntrustOwners.setShardCompId(shardCompId);
//    		erpFunEntrustOwners.setShardDbName(shardDbName);
    		erpFunEntrustOwners.setSignDate(null);
    		erpFunEntrustOwners.setSignPicAddr(null);
    		entrustOwnerList.add(erpFunEntrustOwners);
    	
    	Map resultMap = bestsignService.createContractSend2perTemplate("Electronic_delegate_Template_", templateValues, entrustOwnerList, 1);
    	if(resultMap == null || (resultMap.get("code") != null && !String.valueOf(resultMap.get("code")).equals("0"))) {
    		System.out.println("-------------创建并发送合同失败"+resultMap.get("msg"));
    		throw new RuntimeException(String.valueOf(resultMap.get("msg")+""));
    	}
    	String contractId = String.valueOf(resultMap.get("msg")+"");
    	return contractId;
    }
	
    @GetMapping(value = "/perRegPage")
    public ModelAndView perRegPage(ModelAndView model,@RequestParam String contractId,@RequestParam Integer cityId,@RequestParam Integer ownerId) throws Exception{
		Map<String, Object> map =new HashMap<String, Object>();
		map.put("contractId", contractId);
		map.put("shardCityId", cityId);
//		BestsignContract contract = bestsignContractMapper.getListByparam(map);
		ErpFunEntrustOwners entrustOwners = erpFunEntrustOwnersMapper.selectByPrimaryKey(new ErpFunEntrustOwners(cityId,ownerId));
		if (entrustOwners == null|| StringUtil.isBlank(entrustOwners.getCardNo())) {
			throw new BusinessException("业主信息不存在!");
		}
		BestsignContract contract = bestsignContractMapper.getByContractId(cityId,contractId,entrustOwners.getCardNo());
		if (contract == null) {
			throw new BusinessException("合同不存在!");
		}
		//如果合同已签署，直接跳到合同预览界面
		if(contract.getSignState().equals("1")) {
			return new ModelAndView("redirect:"+contract.getLongUrl());
		}
		model.addObject("id", contractId);
		model.addObject("cityId", cityId);
		model.addObject("ownerId", ownerId);
		model.addObject("entrustOwners", entrustOwners);
		model.addObject("contract", contract);
		model.addObject("erpWebUrl", AppConfig.getErpWebUrl());
		//TODO  二维码外网访问路径没配
		model.addObject("outUrl", AppConfig.getProperty("Bestsign_outurl"));
		model.setViewName("house/perRegPage");
		return model;
    }
    
    
    @RequestMapping(value = "/getIdentity3Vcode")
    public ResponseJson getIdentity3Vcode(@RequestParam String contractId,@RequestParam Integer cityId,@RequestParam Integer ownerId) throws Exception{
		ErpFunEntrustOwners entrustOwners = erpFunEntrustOwnersMapper.selectByPrimaryKey(new ErpFunEntrustOwners(cityId,ownerId));
		BestsignContract contract = bestsignContractMapper.getByContractId(cityId,contractId,entrustOwners.getCardNo());
		if(contract==null) {
			return ErpResponseJson.warn("合同不存在");
		}
    	
		String account = entrustOwners.getCardNo();
		String name = entrustOwners.getOwnerName();
		String cardNo = entrustOwners.getCardNo();
		String identityType = "0"; //证件类型，默认为“0居民身份证”
		String mobile = entrustOwners.getOwnerPhone();
		
		Map<String, String> identity3VcodeMap = bestsignService.getIdentity3Vcode(account, name, cardNo, identityType, mobile);
		if(identity3VcodeMap==null) {
			return ErpResponseJson.warn("发送验证码失败");
		}
    	return ErpResponseJson.ok(identity3VcodeMap.get("msg"));
    }
    
    @RequestMapping("/identity3VcodeCheck")
	public ResponseJson identity3VcodeCheck(String contractId, Integer cityId, String vcode,String personalIdentity3Key,Integer ownerId) {
		ErpFunEntrustOwners entrustOwners = erpFunEntrustOwnersMapper.selectByPrimaryKey(new ErpFunEntrustOwners(cityId,ownerId));
    	BestsignContract contract = bestsignContractMapper.getByContractId(cityId,contractId,entrustOwners.getCardNo());
		if(contract==null) {
			//异常情况
			return ErpResponseJson.warn("合同失效");
		}
		Map<String, String> checkMap = bestsignService.identity3VcodeCheck(vcode, personalIdentity3Key);
		if(checkMap==null||!"0".equals(checkMap.get("code"))) {
			//异常情况
			return ErpResponseJson.warn("操作失败");
		}
		return ErpResponseJson.ok(contract.getShortUrl());
	}
 
    /**
	 * 用户签署  回掉接口 
	 *  
	 * @return
	 */
	@RequestMapping("/perSignComplete")
	public ResponseJson perSignComplete(HttpServletRequest request,HttpServletResponse response) {
		Map<String, String> paramMap = getParameterMap(request);
		String string = paramMap.get("key");
		Integer cityId = Integer.parseInt(paramMap.get("cityId"));
		String[] split = string.split("_");
		String contractId=split[0];
		String account=split[1];
		Map<String, String> map =new HashMap<String, String>();
		map.put("account", account);
		map.put("contractId", contractId);
		map.put("shardCityId", paramMap.get("cityId"));
		System.out.println("上上签签署回掉 key ： "+string);
		BestsignContract byParam = bestsignContractMapper.getListByparam(map);
		if(byParam!=null) {
			bestsignContractService.updateSignStateById(cityId,byParam.getId());
		}else {
			//异常情况
			ErpResponseJson.warn("null 记录不存在");
		}
		Map<String, String> contractSignTemplate = bestsignService.contractSignTemplate(contractId, byParam.getTid(),cityId,account);
		return ErpResponseJson.ok(contractSignTemplate.get("msg"));
	}
	
	/**
	 * 获取参数Map
	 * @author 张宏利
	 * @since 2018年3月6日
	 * @param request
	 * @return
	 */
	public Map<String, String> getParameterMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		for (Object key : request.getParameterMap().keySet()) {
			String[] object = request.getParameterMap().get(key);
			if (object != null) {
				paramMap.put(key.toString(), object[0]);
			}
		}
		return paramMap;
	}
}
