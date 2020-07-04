package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunEntrustOwners;

import java.util.List;
import java.util.Map;

public interface BestsignService {

	/**
	 * 用户注册
	 * @return taskId  异步任务ID 
	 * @throws Exception 
	 */
	public String bestsignPerReg(ErpFunEntrustOwners erpFunEntrustOwners) throws Exception;
	
	/**
	 *  用户状态检查
	 */
	public String accountCheck(String account, String taskId);


	/**
	 * 个人三要素验证码发送 
	 * @param account
	 * @param name
	 * @param identity
	 * @param identityType
	 * @param mobile
	 * @return 短信验证码对应key / 发送失败原因 
	 */
	public  Map<String, String> getIdentity3Vcode(String account, String name, String identity, String identityType, String mobile);

	/**
	 * 个人三要素验证码校验   
	 * @param vcode
	 * @param personalIdentity3Key
	 * @return 校验结果
	 */
	public Map<String, String> identity3VcodeCheck(String vcode, String personalIdentity3Key);

	/**
	 * 通过模版生成合同文件 返回合同ID
	 * @param account
	 * @param tid
	 * @param templateValues
	 * @param expireTime
	 * @return
	 */
	public Map<String, String> templateCreateContractPdf(String account, String tid, Map<String, String> templateValues, String expireTime);

	/**
	 *  指定签署人签署位置  获得对应签署链接
	 * @param account 签署账号
	 * @param contractId  合同号
	 * @param tid  模板编号
	 * @param varNames  签署控件名称
	 * @param expireTime unix时间戳格式。超过此时间则无法打开签署链接，需要获取新的签署链接。格式为秒级的unix时间戳， 注：并不是合同的可签署到期时间，只是此签署链接的有效期。 由于返回的是短链接，如果没有设置则默认是30分钟，如果设置了以设置的为准，但有效期最大不能超过7天。
	 * @param isvcodeMobile  签署时是否需要手机号码校验
	 * @param cityId 城市库ID
	 * @return
	 */
	public Map<String, String> contractSend(String account, String contractId, String tid, String varNames, String expireTime, Boolean isvcodeMobile, Integer cityId);

	/**
	 * 撤销合同   
	 * @param contractId 
	 */
	public Map<String, String> contractCancel(String contractId);

	/**
	 * 自动签署  合同 并锁定
	 *
	 * @param contractId 合同ID
	 * @param tid        模板ID
	 * @param cityId
	 * @param account 账户业主的证件号码
	 * @return
	 */
	public Map<String, String> contractSignTemplate(String contractId, String tid, Integer cityId, String account);
	
	/**
	 * 创建并发送合同
	 * @param tidPrefix   模板前缀
	 * @param templateValues  模板对应的MAP
	 * @param erpFunEntrustOwnersList  签署人列表
	 * @param cityId  城市ID 用于区分城市配置的参数
	 * @return
	 */
	public Map<String, String> createContractSend2perTemplate(String tidPrefix, Map<String, String> templateValues, List<ErpFunEntrustOwners> erpFunEntrustOwnersList, Integer cityId);
}

