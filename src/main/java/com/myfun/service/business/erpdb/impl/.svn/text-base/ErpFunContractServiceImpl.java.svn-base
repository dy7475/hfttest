package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.deal.vo.ShareDealVo;
import com.myfun.erpWeb.managecenter.constract.param.ShareDealParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminCrmCompMapper;
import com.myfun.repository.admindb.dao.AdminCustomLeaguesMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminCrmComp;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunIndexValueDto;
import com.myfun.repository.erpdb.param.ErpFunContractTemplaeParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunContractService;
import com.myfun.service.business.erpdb.bean.param.PushEntrustMsgParam;
import com.myfun.service.business.erpdb.bean.param.SendMsgParam;
import com.myfun.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

@Service
public class ErpFunContractServiceImpl extends AbstractService<ErpFunContract, ErpFunContract> implements ErpFunContractService{

	@Autowired
	ErpFunContractMapper erpFunContractMapper;
	@Autowired
	ErpFunDealMapper erpFunDealMapper;
	@Autowired
	ErpFunContractTemplaeMapper erpFunContractTemplaeMapper;
	@Autowired
	ErpFunContractIndexMapper erpFunContractIndexMapper;
	@Autowired
	ErpFunContractDealMapper erpFunContractDealMapper;
	@Autowired
	ErpFunIndexValueMapper erpFunIndexValueMapper;
	@Autowired
	ErpFunDealRecordMapper erpFunDealRecordMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	AdminCrmCompMapper adminCrmCompMapper;
	@Resource
	private ErpSsqContractMapper erpSsqContractMapper;
	@Resource
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AdminFunCompService adminFunCompService;
	@Autowired
	private AdminCustomLeaguesMapper adminCustomLeaguesMapper;
	

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunContractMapper;
	}

	/**
	 * @Title 优家的生成合同
	 * @Author lcb
	 * @Date 2018/3/5
	 * @Param
	 **/
	@Transactional
	@Override
	public List<Map<String, Object>> generatorContract(ErpFunContractTemplaeParam param, Integer cityId, Integer userId, String userName) {

		Integer caseType = param.getCaseType();
		List<Map<String, Object>> resMapList = new ArrayList<>();



		Integer crmCompId = param.getCrmCompId();

		List<ErpFunContractTemplae> erpFunContractTemplaes = null;
		if(null != crmCompId) {
			AdminCrmComp adminCrmComp = adminCrmCompMapper.selectByPrimaryKey(crmCompId);
			if(!adminCrmComp.getSuperComp()) {
				erpFunContractTemplaes = getContractTemplateList(cityId, caseType, param.getCompId());
			}else {
				erpFunContractTemplaes = getContractTemplateList(cityId, caseType, 0);
			}
		}else {
			erpFunContractTemplaes = getContractTemplateList(cityId, caseType, 0);
		}

		if(null == erpFunContractTemplaes || erpFunContractTemplaes.size() == 0) {
			throw new BusinessException("您所在城市还未设置模板，请联系客服");
		}

		ErpFunDeal funDealPO = new ErpFunDeal();
		funDealPO.setDealId(param.getDealId());
		funDealPO.setShardCityId(cityId);
		ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(funDealPO);

		List<ErpFunIndexValueDto> contractIndexListTem = new ArrayList<>();
		Integer dealContractId = null;
		// 查询合同模板ID 查询指标
		List<ErpFunContractIndex> contractIndexList = erpFunContractIndexMapper.getList(cityId, caseType);

		for (ErpFunContractTemplae erpFunContractTemplae : erpFunContractTemplaes) {
			Map<String, Object> resMap = new HashMap<>();
			ErpFunContract funContractPO = new ErpFunContract();
			funContractPO.setShardCityId(cityId);
			// 存在合同的 不在做内容修改
			funContractPO.setCompId(param.getCompId());
			funContractPO.setContractContent(erpFunContractTemplae.getTemplateContent());
			funContractPO.setCreationTime(new Date());
			funContractPO.setCreationUid(userId);
			funContractPO.setDeptId(param.getDeptId());
			funContractPO.setLineHeight(new BigDecimal(10));
			funContractPO.setSealPosition("0,0");
			funContractPO.setLogoPosition("0,0");
			funContractPO.setTemletId(erpFunContractTemplae.getTemplateId());
			funContractPO.setTemplateName(erpFunContractTemplae.getTemplateName());
			erpFunContractMapper.insertSelective(funContractPO);
			// 写关联表
			ErpFunContractDeal erpFunContractDeal = new ErpFunContractDeal();
			erpFunContractDeal.setContractId(funContractPO.getContractId());
			erpFunContractDeal.setContractType(erpFunContractTemplae.getContentType());
			erpFunContractDeal.setDealId(param.getDealId());
			erpFunContractDeal.setShardCityId(cityId);
			erpFunContractDeal.setCaseType(erpFunContractTemplae.getTemplateType());
			erpFunContractDealMapper.insertSelective(erpFunContractDeal);
			List<ErpFunIndexValueDto> valueList = new ArrayList<>();

			// 写入关联关系
			for (ErpFunContractIndex erpFunContractIndex : contractIndexList) {

				if(erpFunContractTemplae.getTemplateId().equals(erpFunContractIndex.getTemplateId())) {
					ErpFunIndexValueDto erpFunIndexValue = new ErpFunIndexValueDto();
					erpFunIndexValue.setIndexId(erpFunContractIndex.getIndexId());
					erpFunIndexValue.setContractId(funContractPO.getContractId());
					erpFunIndexValue.setCreationTime(new Date());
					erpFunIndexValue.setIndexValueOriginal(erpFunIndexValue.getIndexValue());
					erpFunIndexValue.setShardCityId(cityId);

					erpFunIndexValue.setIndexName(erpFunContractIndex.getIndexName());
					erpFunIndexValue.setIndexType(erpFunContractIndex.getIndexType());
					erpFunIndexValue.setIndexFormat(erpFunContractIndex.getIndexFormat());
					erpFunIndexValue.setIndexUnit(erpFunContractIndex.getIndexUnit());
					erpFunIndexValue.setUnderLine(erpFunContractIndex.getUnderLine().intValue());
					erpFunIndexValue.setOther(erpFunContractIndex.getOther());
					erpFunIndexValue.setRequired(erpFunContractIndex.getRequired().intValue());
					erpFunIndexValue.setUniqueKey(erpFunContractIndex.getUniqueKey());

					if(StringUtils.isNotBlank(erpFunContractIndex.getFunDealField())) {
						erpFunIndexValue.setFunDealField(StringUtil.changeUnderLine(erpFunContractIndex.getFunDealField()));
						// 设置默认值
						try {
							String funDealField = erpFunContractIndex.getFunDealField();
							funDealField = StringUtil.changeUnderLine(funDealField);

							// 得到类对象
							Class<?> clazzSrc = erpFunDeal.getClass();
							Field field1=clazzSrc.getDeclaredField(funDealField);
							PropertyDescriptor pd=new PropertyDescriptor(field1.getName(),clazzSrc);
							Method getMethod=pd.getReadMethod();
							Object invoke = getMethod.invoke(erpFunDeal);
							if(null != invoke) {
								erpFunIndexValue.setIndexValue(invoke.toString());
							}

						}catch (Exception e) {
						}
					}

					erpFunIndexValueMapper.insertSelective(erpFunIndexValue);
					valueList.add(erpFunIndexValue);
				}


			}
			if(new Byte("1").equals(erpFunContractTemplae.getContentType())) {
				dealContractId = funContractPO.getContractId();
			}
			resMap.put("contract", funContractPO);
			resMap.put("indexList", valueList);
			contractIndexListTem = valueList;
			resMapList.add(resMap);
		}
		String content = erpFunUsersMapper.getCurrUserName(cityId, userId, param.getDeptId()) + "生成了合同";
		writeFunDealRecord(param.getDealId(), param.getCompId(), param.getDeptId(),
				userId, userName, content, Constants_DIC.DIC_DEAL_UPDATE_CLASSIC_ADDCONTRACT, new Byte("3"), JSON.toJSONString(contractIndexListTem), cityId);

		// 更新数据
		erpFunDeal.setContractId(dealContractId);
		erpFunDeal.setShardCityId(cityId);
		erpFunDealMapper.updateByPrimaryKeySelective(erpFunDeal);

		return resMapList;
	}

	private List<ErpFunContractTemplae> getContractTemplateList(Integer cityId, Integer caseType, Integer compId) {
		ErpFunContractTemplaeExample erpFunContractTemplaeExample = new ErpFunContractTemplaeExample();
		erpFunContractTemplaeExample.setOrderByClause("TEMPLATE_ID asc");
		erpFunContractTemplaeExample.setShardCityId(cityId);
		erpFunContractTemplaeExample.createCriteria().andIsYoujiaTemplateEqualTo(new Byte("1")).andCompIdEqualTo(compId).
				andTemplateTypeEqualTo(caseType.byteValue()).andCityIdEqualTo(cityId);
		return erpFunContractTemplaeMapper.selectByExampleWithBLOBs(erpFunContractTemplaeExample);
	}

	@Override
	public void deleteLink(Integer cityId, Integer dealId) {
		ErpFunContractDealExample erpFunContractDealExample = new ErpFunContractDealExample();
		erpFunContractDealExample.setShardCityId(cityId);
		erpFunContractDealExample.createCriteria().andDealIdEqualTo(dealId);
		erpFunContractDealMapper.deleteByExample(erpFunContractDealExample);
	}

	private void writeFunDealRecord(Integer agreementNo , Integer compId, Integer deptId, Integer userId,
									String userName, String content, String classic, Byte type , String indexList, Integer cityId) {
		ErpFunDealRecord erpFunDealRecord = new ErpFunDealRecord();
		erpFunDealRecord.setShardCityId(cityId);
		erpFunDealRecord.setAgreementNo(agreementNo + "");
		erpFunDealRecord.setCompId(compId);
		erpFunDealRecord.setDeptId(deptId);
		erpFunDealRecord.setTrackContent(content);
		erpFunDealRecord.setUpdateClassic(classic);
		erpFunDealRecord.setUpdateDate(DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		erpFunDealRecord.setUpdateType(type); // 指标
		erpFunDealRecord.setUpdateUid(userId);
		erpFunDealRecord.setUpdateUserName(userName);
		if(StringUtils.isNotBlank(indexList)) {
			List<Map<String, Object>> resList = new ArrayList<>();
			Map<String, String> pMap = new HashMap<>();
			List<ErpFunIndexValue> paramList = JSON.parseArray(indexList, ErpFunIndexValue.class);
			Set<Integer> indexValueId = new HashSet<>();
			for (ErpFunIndexValue erpFunIndexValue : paramList) {
				indexValueId.add(erpFunIndexValue.getIndexId());
			}
			List<ErpFunContractIndex> erpFunContractIndices = new ArrayList<>();
			if(indexValueId.size() > 0) {
				ErpFunContractIndexExample erpFunContractIndexExample = new ErpFunContractIndexExample();
				erpFunContractIndexExample.setShardCityId(cityId);
				erpFunContractIndexExample.createCriteria().andIndexIdIn(new ArrayList<>(indexValueId));
				erpFunContractIndices = erpFunContractIndexMapper.selectByExample(erpFunContractIndexExample);
			}
			for (ErpFunIndexValue erpFunIndexValue : paramList) {

				for (ErpFunContractIndex erpFunContractIndex : erpFunContractIndices) {
					if(erpFunIndexValue.getIndexId().equals(erpFunContractIndex.getIndexId())) {
						Map<String, Object> objMap = BeanUtil.object2Map(erpFunContractIndex);
						if(null != erpFunContractIndex) {
							objMap.put("INDEX_NAME", erpFunContractIndex.getIndexName());
						}
						resList.add(objMap);
					}
				}

			}
			pMap.put("FUN_DEAL", JSON.toJSON(resList)+"");
			erpFunDealRecord.setUpdateContent(JSON.toJSONString(pMap));
		}
		ErpFunDealRecord erpFunDealRecord1 = erpFunDealRecordMapper.getLastRecordId(cityId, agreementNo, type,null);
		if(null != erpFunDealRecord1) {
			erpFunDealRecord.setFrontRecordId(erpFunDealRecord1.getRecordId());
		}
		erpFunDealRecordMapper.insertSelective(erpFunDealRecord);
	}

//	public static void main(String[] args) {
//		try {
//
//			String funDealField = "";
//			funDealField = StringUtil.changeUnderLine(funDealField);
//
//			ErpFunDeal erpFunDeal = new ErpFunDeal();
//
//
//			// 得到类对象
//			Class<?> clazzSrc = erpFunDeal.getClass();
//			Field field1=clazzSrc.getDeclaredField(funDealField);
//			PropertyDescriptor pd=new PropertyDescriptor(field1.getName(),clazzSrc);
//			Method getMethod=pd.getReadMethod();
//			Object invoke = getMethod.invoke(erpFunDeal);
//			System.out.println(getMethod.getName()+"---"+invoke);
//			if(null != invoke) {
//				System.out.println(invoke.toString());;
//			}
//
//		}catch (Exception e) {
//
//			e.printStackTrace();
//		}
//	}

	@Override
	public ShareDealVo shareDeal(ShareDealParam param) {
		Integer cityId = param.getCityId();
		Integer dealId = param.getDealId();
		String mobile = param.getMobile();

		ShareDealVo shareDealVo = new ShareDealVo();

		ErpFunDeal deal = new ErpFunDeal(cityId, dealId);
		ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(deal);

		// 合同没有找到
		if (erpFunDeal == null) {
			shareDealVo.setCode(500);
			return shareDealVo;
		}

		// 买方电话(客户电话) 手机:15283357666
		String buyCustomerPhone = erpFunDeal.getBuyCustomerPhone();
		// 卖方电话(业主电话) 手机:15283357666
		String sellOwnerPhone = erpFunDeal.getSellOwnerPhone();
		boolean buyCustomerPhoneMatch = false;
        boolean sellOwnerPhoneMatch = false;

        if (StringUtils.isNotEmpty(buyCustomerPhone) && buyCustomerPhone.contains(":")) {
            if (buyCustomerPhone.split(":")[1].equals(mobile)) {
                // 乙方(买方) 微信OPEN_ID
				erpFunDeal.setBuyOwnerWxOpenId(param.getOpenId());
                // 乙方(买方) 微信USER_ID
				erpFunDeal.setBuyOwnerWxUserId(param.getUserId());
                buyCustomerPhoneMatch = true;
            }
        }

		if (StringUtils.isNotEmpty(sellOwnerPhone) && sellOwnerPhone.contains(":")) {
            if (sellOwnerPhone.split(":")[1].equals(mobile)) {
                // 甲方(卖方) 微信OPEN_ID
				erpFunDeal.setSellOwnerWxOpenId(param.getOpenId());
                // 甲方(卖方) 微信USER_ID
				erpFunDeal.setSellOwnerWxUserId(param.getUserId());
                sellOwnerPhoneMatch = true;
            }
		}

		if (!buyCustomerPhoneMatch && !sellOwnerPhoneMatch) {
			shareDealVo.setCode(500);
			return shareDealVo;
		}

		erpFunDeal.setShardCityId(cityId);
		erpFunDealMapper.updateByPrimaryKeySelective(erpFunDeal);

		shareDealVo.setCode(200);
		return shareDealVo;
	}

	/**
	 * 撤销和作废合同给用户推送微信模板消息和短信
	 **/
	@Override
	public void sendMsg(Integer cityId, Integer dealId, Integer auditType) {
		// 合同作废 撤销初审
		List<Integer> continues = Arrays.asList(4, 5);
		if (!continues.contains(auditType)) {
			return;
		}

		ErpSsqContractExample erpSsqContractExample = new ErpSsqContractExample();
		erpSsqContractExample.setShardCityId(cityId);
		erpSsqContractExample.createCriteria().andDealIdEqualTo(dealId).andIsDelEqualTo((byte) 0);
		List<ErpSsqContract> ssqContracts = erpSsqContractMapper.selectByExample(erpSsqContractExample);

		if (CollectionUtils.isEmpty(ssqContracts)) {
		    return;
		}

		ErpSsqContract erpSsqContract = ssqContracts.get(0);
        // 将上上签合同改为删除状态
        erpSsqContract.setShardCityId(cityId);
        erpSsqContract.setIsDel((byte) 1);
        erpSsqContractMapper.updateByPrimaryKeySelective(erpSsqContract);

        ErpFunDeal updateDeal = new ErpFunDeal(cityId, dealId);
        updateDeal.setSsqContractId("");
        erpFunDealMapper.updateByPrimaryKeySelective(updateDeal);

		ErpFunDeal deal = new ErpFunDeal(cityId, dealId);
		ErpFunDeal erpFunDeal = erpFunDealMapper.selectByPrimaryKey(deal);

		if (erpFunDeal != null) {
			// 更新签名标记
			erpFunDealMapper.updateSignType(cityId, dealId);
			
			// 乙方(买方) 微信OPEN_ID
			String buyOwnerWxOpenId = erpFunDeal.getBuyOwnerWxOpenId();
			// 乙方(买方) 微信USER_ID
			String buyOwnerWxUserId = erpFunDeal.getBuyOwnerWxUserId();
			// 甲方(卖方) 微信OPEN_ID
			String sellOwnerWxOpenId = erpFunDeal.getSellOwnerWxOpenId();
			// 甲方(卖方) 微信USER_ID
			String sellOwnerWxUserId = erpFunDeal.getSellOwnerWxUserId();

			Integer deptId = erpFunDeal.getDeptId();

			ErpFunDepts funDepts = new ErpFunDepts(cityId, deptId);
			ErpFunDepts erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(funDepts);
			Byte supportPropertyFlag = 0;
			// 支持物业标记 0=不支持 1=支持 默认0
			if (erpFunDepts != null) {
				supportPropertyFlag = erpFunDepts.getSupportPropertyFlag();
			}

			// 给甲方(卖方)发送微信模板消息 外部合作的时候不发
			if (StringUtils.isNotBlank(sellOwnerWxOpenId) && erpFunDeal.getHouseUserUid() != null) {
				Map<String, Object> param = getWxMap(cityId, erpFunDeal, auditType, sellOwnerWxOpenId, sellOwnerWxUserId, supportPropertyFlag, false);
                String result = HttpUtil.post(AppConfig.getProperty("common.kdbWeb.wapDomainUrl") + "api/PushMessage/messagePushPort", param);
                if (StringUtils.isNotEmpty(result)) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    if (jsonObject.containsKey("code")) {
                        Integer code = jsonObject.getInteger("code");
                        // 微信发送失败则发送短信
                        if (code != 200) {
                            String sellOwnerPhone = erpFunDeal.getSellOwnerPhone();
                            if (StringUtils.isNotEmpty(sellOwnerPhone) && sellOwnerPhone.startsWith("手机") && !sellOwnerPhone.contains("*")) {
                                // 给甲方(卖方)发送短信消息
                                Map<String, Object> paramMap = getSmsMap(erpFunDeal, auditType, sellOwnerPhone.split(":")[1], false, supportPropertyFlag);
                                System.out.println("paramMap " + JSON.toJSONString(paramMap));
                                String smsResult = HttpUtil.postJson(AppConfig.getAdminWebUrl() + "/hftMsgCenter/sendMsgNew", paramMap);
                                System.out.println(AppConfig.getAdminWebUrl() + "/hftMsgCenter/sendMsgNew smsResult " + smsResult);
                            }
                        }
                    }
				}
				System.out.println("partyAWxOpenId result " + result);
			}

			// 给乙方(买方)发送微信模板消息 外部合作的时候不发
			if (StringUtils.isNotBlank(buyOwnerWxOpenId) && erpFunDeal.getCustUserUid() != null) {
				Map<String, Object> param = getWxMap(cityId, erpFunDeal, auditType, buyOwnerWxOpenId, buyOwnerWxUserId, supportPropertyFlag, true);
				String result = HttpUtil.post(AppConfig.getProperty("common.kdbWeb.wapDomainUrl") + "api/PushMessage/messagePushPort", param);
                if (StringUtils.isNotEmpty(result)) {
                    JSONObject jsonObject = JSONObject.parseObject(result);
                    if (jsonObject.containsKey("code")) {
                        Integer code = jsonObject.getInteger("code");
                        // 微信发送失败则发送短信
                        if (code != 200) {
                            String buyCustomerPhone = erpFunDeal.getBuyCustomerPhone();
                            if (StringUtils.isNotEmpty(buyCustomerPhone) && buyCustomerPhone.startsWith("手机") && !buyCustomerPhone.contains("*")) {
                                // 给乙方(买方)发送短信消息
                                Map<String, Object> paramMap = getSmsMap(erpFunDeal, auditType, buyCustomerPhone.split(":")[1], true, supportPropertyFlag);
                                System.out.println("paramMap " + JSON.toJSONString(paramMap));
                                String smsResult = HttpUtil.postJson(AppConfig.getAdminWebUrl() + "/hftMsgCenter/sendMsgNew", paramMap);
                                System.out.println(AppConfig.getAdminWebUrl() + "/hftMsgCenter/sendMsgNew result " + smsResult);
                            }
                        }
                    }
                }
				System.out.println("partyBWxOpenId result " + result);
			}
		}
	}

	/**
	 * 手机:13646949944 座机:02887760798 座机:02****66 手机:152****1722 境外:690029
	 * [优选好房]您#{addr}的#{contractType}合同已撤销审核，请仔细确认后再重新签署。如有疑问请咨询经纪人${userName}-${mobile}    DX1566368451345
	 * [子弹找房]您#{addr}的#{contractType}合同已撤销审核，请仔细确认后再重新签署。如有疑问请咨询经纪人${userName}-${mobile}    DX1566368507889
	 * [优选好房]您#{addr}的#{contractType}合同已作废，如有疑问请联系经纪人${userName}-${mobile}。 		DX1566368598389
	 * [子弹找房]您#{addr}的#{contractType}合同已作废，如有疑问请联系经纪人${userName}-${mobile}。 		DX1566368633875
	 * 物业合同是子弹找房的短信模板
	 */
	private Map<String, Object> getSmsMap(ErpFunDeal erpFunDeal, Integer auditDealType, String phone, boolean isBuy, Byte supportPropertyFlag) {
		String sellAddress = erpFunDeal.getSellAddress();
		Byte dealType = erpFunDeal.getDealType();

		// Const.AUDIT_DEAL_TYPE_MAP
		List<Integer> cancels = Collections.singletonList(5);

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("action", "sendSms");
		paramMap.put("phone", phone);
		paramMap.put("reqProject", "1");

		// 放置短信的内容
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap.put("addr", sellAddress);
		jsonMap.put("contractType", dealType == 101 ? "出售" : "出租");

		if (isBuy) {
			// 买方经纪人信息
			jsonMap.put("userName", erpFunDeal.getCustUsername());
			jsonMap.put("mobile", erpFunDeal.getBuyCallPhone());
		} else {
			// 卖方经纪人信息
			jsonMap.put("userName", erpFunDeal.getHouseUsername());
			jsonMap.put("mobile", erpFunDeal.getSellCallPhone());
		}

		// 撤销初审
		if (cancels.contains(auditDealType)) {
			if (supportPropertyFlag == 0) {
				paramMap.put("key", "DX1566368451345");
			} else if (supportPropertyFlag == 1) {
				paramMap.put("key", "DX1566368507889");
			}

			paramMap.put("paramJson", jsonMap);
		} else if (auditDealType == 4) {
			// 合同作废
			if (supportPropertyFlag == 0) {
				paramMap.put("key", "DX1566368598389");
			} else if (supportPropertyFlag == 1) {
				paramMap.put("key", "DX1566368633875");
			}

			paramMap.put("paramJson", jsonMap);
		}

		return paramMap;
	}

	/**
	 * 温馨提示：您的合同已作废，如有疑问请联系经纪人
	 * 合同编号：合同编号
	 * 合同信息：物业地址的买卖/租赁合同
	 * 交易金额：款项：金额
	 */
	private Map<String, Object> getWxMap(Integer cityId, ErpFunDeal erpFunDeal, Integer auditDealType,
										 String openId, String userId, Byte supportPropertyFlag, boolean isBuy) {
		Byte dealType = erpFunDeal.getDealType();
		// Const.AUDIT_DEAL_TYPE_MAP
		List<Integer> cancels = Collections.singletonList(5);

		JSONObject miniJson = new JSONObject();
		// 撤销初审
		if (cancels.contains(auditDealType)) {
			miniJson.put("paramOne", "您的合同已撤销审核，请仔细确认后再签署");
		} else if (auditDealType == 4) {
			// 合同作废
			miniJson.put("paramOne", "您的合同已作废，如有疑问请联系经纪人");
		}

		miniJson.put("paramTwo", erpFunDeal.getContractNo());
		if (StringUtils.isNotEmpty(erpFunDeal.getSellAddress())) {
			miniJson.put("paramThree", dealType == 101 ? erpFunDeal.getSellAddress() + "的买卖合同" : erpFunDeal.getSellAddress() + "的租赁合同");
		}
		if (erpFunDeal.getBuyCustomerCommsion() != null) {
			miniJson.put("paramFour", "佣金：" + erpFunDeal.getBuyCustomerCommsion() + "元");
		}

		miniJson.put("openId", openId);
		miniJson.put("userId", userId);
		if (isBuy) {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFunDeal.getCustUserUid());
			String param = "dealId=" + erpFunDeal.getDealId() + "&cityId=" + cityId +
					"&userId=" + erpFunDeal.getCustUserUid() + "&archiveId=" + erpFunUsers.getArchiveId();
			miniJson.put("page", "packageShare/pages/contractInfo/contractInfo?" + param);
		} else {
			ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, erpFunDeal.getHouseUserUid());
			String param = "dealId=" + erpFunDeal.getDealId() + "&cityId=" + cityId + "&userId=" +
					erpFunDeal.getHouseUserUid() + "&archiveId=" + erpFunUsers.getArchiveId();
			miniJson.put("page", "packageShare/pages/contractInfo/contractInfo?" + param);
		}
		miniJson.put("templateType", "ELECTRONIC_CONTRACT_SIGNING");
		miniJson.put("fromSource", "mlhf");
		Map<String, Object> param = new HashMap<>();
		param.put("type", "mini");
		param.put("isPushGzhMessage", 0);

		JSONObject miniParams = new JSONObject();
		miniParams.put("miniParams", miniJson);
		param.put("params", miniParams);
		return param;
	}

	// {"phone":"18108264227","paramJson":{"contractType":"出售","addr":"听我好压抑",
	// "url":"packageShare/pages/contractInfo/contractInfo?77cc6d77a24d6aca283fbfecc09409f0f24bf677b7c6646111df8c8a37406bfcdab850b1fd80b66a"},
	// "action":"sendSms","reqProject":"1","key":"DX1566368451345"}
	public static void main2(String[] args) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("phone", "13408505238");
		paramMap.put("action", "sendSms");
		paramMap.put("key", "DX1566368451345");
		paramMap.put("reqProject", "1");
		Map<String, String> jsonMap = new HashMap<>();
		jsonMap.put("addr", "英郡");
		jsonMap.put("contractType", "出售");
		jsonMap.put("userName", "陈志强");
		jsonMap.put("mobile", "12300000001");
		jsonMap.put("url", "packageShare/pages/contractInfo/contractInfo");
		paramMap.put("paramJson", jsonMap);
		String result = HttpUtil.postJson("http://test.51vfang.cn/adminWeb/hftMsgCenter/sendMsgNew", paramMap);
		System.out.println(result);
	}

	public static void main3(String[] args) {
		JSONObject gzhJson = new JSONObject();
		gzhJson.put("paramOne", "您的合同已撤销审核，请仔细确认后再签署");
		gzhJson.put("paramTwo", "NO123");
		gzhJson.put("paramThree", "英郡的买卖合同");
		gzhJson.put("paramFour", "佣金：1000元");

		Map<String, Object> param = new HashMap<>();
		param.put("type", "mini");
		param.put("isPushGzhMessage", 0);
		param.put("openId", "oS-p1w9Zxvj1x06WmQwNKrBRybI");
		param.put("userId", "oS-p1w9Zxvj1x06WmQwNKrBRdbI");
		param.put("page", "http://uuweb.hftsoft.com/B/Home/ZtContract/contractMsgTips");
		param.put("templateType", "ELECTRONIC_CONTRACT_SIGNING");
		param.put("fromSource", "yxhf");
//		param.put("miniParams", gzhJson.toJSONString());

		Map<String, Object> miniParam = new HashMap<>();
		miniParam.put("miniParams", gzhJson.toJSONString());
		param.put("params", miniParam);

		String s = HttpUtil.postJson("http://192.168.200.163:8033/pushWeb/systemApi/wapMsg/sendNew", JSONObject.toJSONString(param));
		System.out.println(s);
	}

	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<>();
		param.put("type", "mini");
		param.put("isPushGzhMessage", 0);

		JSONObject miniParams = new JSONObject();
		JSONObject miniParam = new JSONObject();
		miniParam.put("paramOne", "您的合同已撤销审核，请仔细确认后再签署");
		miniParam.put("paramTwo", "NO123");
		miniParam.put("paramThree", "英郡的买卖合同");
		miniParam.put("paramFour", "佣金：1000元");
		miniParam.put("openId", "oS-p1w9Zxvj1x06WmQwNKrBRybI");
		miniParam.put("userId", "222");
		miniParam.put("page", "http://uuweb.hftsoft.com/B/Home/ZtContract/contractMsgTips");
		miniParam.put("templateType", "ELECTRONIC_CONTRACT_SIGNING");
		miniParam.put("fromSource", "yxhf");

		miniParams.put("miniParams", miniParam);
		param.put("params", miniParams);

		System.out.println(JSONObject.toJSONString(param));
		String result = HttpUtil.post("http://lwj.kdb.com/api/PushMessage/messagePushPort", param);
		System.out.println("partyAWxOpenId result " + result);
	}


}
