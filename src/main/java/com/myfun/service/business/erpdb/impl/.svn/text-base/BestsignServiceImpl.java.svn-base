package com.myfun.service.business.erpdb.impl;

import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpAuditTemplateMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustFilesMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustMapper;
import com.myfun.repository.erpdb.dao.ErpFunEntrustOwnersMapper;
import com.myfun.repository.erpdb.po.*;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.erpdb.BestsignContractService;
import com.myfun.service.business.erpdb.BestsignService;
import com.myfun.utils.*;
import com.myfun.utils.ssq.param.BestsignCredential;
import com.myfun.utils.ssq.param.BestsignPerson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@Component(value="bestsignService")
@Transactional
public class BestsignServiceImpl implements BestsignService{
	@Autowired
	BestsignContractService bestsignContractService;
	@Autowired
	ErpFunEntrustMapper erpFunEntrustMapper;
    @Autowired
    private ErpFunEntrustFilesMapper erpFunEntrustFilesMapper;
    @Autowired
    private ErpFunEntrustOwnersMapper erpFunEntrustOwnersMapper;
    @Autowired
    private ErpAuditTemplateMapper erpAuditTemplateMapper;
    
	@Override
	public String bestsignPerReg(ErpFunEntrustOwners erpFunEntrustOwners) throws Exception {
        //注册返回异步申请证书任务id
        String taskId = null;
		try {
			BestsignPerson bestsignPerson = new BestsignPerson();
			bestsignPerson.setAccount(erpFunEntrustOwners.getCardNo());
			bestsignPerson.setApplyCert("1");//1表示申请证书
			BestsignCredential credential = new BestsignCredential(); 
			credential.setIdentity(erpFunEntrustOwners.getCardNo());
			credential.setContactMobile(erpFunEntrustOwners.getOwnerPhone());
			credential.setIdentityType("0");//证件类型  因为 系统业务情况存在香港 委托的情况 所有在本系统重此参数必填
			
			bestsignPerson.setCredential(credential);
			bestsignPerson.setMail("");
			bestsignPerson.setMobile(erpFunEntrustOwners.getOwnerPhone());
			bestsignPerson.setName(erpFunEntrustOwners.getOwnerName());
			bestsignPerson.setUserType("1");  //1表示个人
			// 校验必填项
			if(StringUtils.isEmpty(bestsignPerson.getAccount())) {
				throw new Exception("上上签个人用户注册时账户不能为空");
			}
			if(StringUtils.isEmpty(bestsignPerson.getName())) {
				throw new Exception("上上签个人用户注册时姓名不能为空");
			}
			if(StringUtils.isEmpty(bestsignPerson.getUserType())) {
				throw new Exception("上上签个人用户注册时注册类型不能为空");
			}
			if(bestsignPerson.getCredential()==null||StringUtils.isEmpty(bestsignPerson.getCredential().getIdentity())) {
				throw new Exception("上上签个人用户注册时证件号码不能为空");
			}
			if(StringUtils.isEmpty(bestsignPerson.getAccount())) {
				throw new Exception("上上签个人用户注册时证件类型不能为空");
			}
			taskId = BestsignOpenApiClient.userPersonalReg(bestsignPerson);
			//查询任务状态
	        System.out.println("account="+bestsignPerson.getAccount()+" taskId:"+taskId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上上签个人用户注册异常  "+e.getMessage());
		}
		return taskId;
	}

	@Override
	public String accountCheck(String account, String taskId) {
		String applyCertCheck =null;
		try {
			 applyCertCheck = BestsignOpenApiClient.applyCertCheck(account, taskId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上上签个人用户注册  异步注册校验异常 :"+e.getMessage());
		}
		return applyCertCheck;
	}

	@Override
	public Map<String, String> getIdentity3Vcode(String account, String name, String identity, String identityType,
			String mobile) {
		Map<String, String> Identity3VcodeMap =null;
		try {
			Identity3VcodeMap = BestsignOpenApiClient.getIdentity3Vcode(account, name, identity, identityType, mobile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上上签个人用户注册  发送个人三要素验证短信异常 :"+e.getMessage());
		}
		return Identity3VcodeMap;
	}

	@Override
	public Map<String, String> identity3VcodeCheck(String vcode, String personalIdentity3Key) {
		Map<String, String> Identity3VcodeMap =null;
		try {
			Identity3VcodeMap = BestsignOpenApiClient.identity3VcodeCheck(vcode, personalIdentity3Key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("上上签个人用户注册  发送个人三要素验证短信异常 :"+e.getMessage());
		}
		return Identity3VcodeMap;
	}

	@Override
	public Map<String, String> templateCreateContractPdf(String account, String tid, Map<String, String> templateValues,
			String expireTime) {
		//1创建合同
		try {
			Map<String, String> template = BestsignOpenApiClient.templateCreateContractPdf(account, tid ,templateValues);
			if(template==null||!"0".equals(template.get("code"))) {//生成失败
				return template;
			}
			//createByTemplate
			String templateToken  = template.get("msg");
			String title="电子委托书";
			String description="";
			Map<String, String> contract = BestsignOpenApiClient.contractCreateByTemplate(account, tid ,templateToken,expireTime,title,description);
			return contract;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, String> contractSend(String account, String contractId, String tid, String varNames,String expireTime, Boolean isvcodeMobile, Integer cityId) {
		String vcodeMobile=null;
		try {
			if(isvcodeMobile) {
				Map<String, String> personal = BestsignOpenApiClient.getPersonalCredential(account);
				vcodeMobile = personal.get("contactMobile");//校验手机号;  非必填
			}
			
			/*
			account	用户账号	String	用户注册账号
			name	姓名	String	姓名
			identity	证件号码	String	证件号码
			identityType	证件类型	String	枚举值：0-身份证，目前仅支持身份证
			contactMail	联系邮箱	String	电子邮箱
			contactMobile	联系手机号码	String	手机号码
			province	所在省份	String	省份
			city	所在城市	String	城市
			address	联系地址	String	地址
			*/
			//签署后的回掉地址 页面跳转用 需要带上合同号和签署人account 标识  是谁签署了合同 account
			String pushUrl =AppConfig.getErpWebUrl()+"openApi/mlEntrustApi/perSignComplete?key="+contractId+"_"+account+"&cityId="+cityId;//异步推送地址     mlEntrustApi/perRegPage
			String isDrawSignatureImage = "2"; //手动签署时是否手绘签名  0点击签名图片不会触发手写面板（禁止手写）。 1点击签名图片能触发手写面板（既可手写也可使用默认签名）。
			String returnUrl ="";
			String isAllowChangeSignaturePosition = "0";//是否允许拖动签名位置 （0：不允许，1：允许）
			String signatureImageName = "default";
			String version = "2";
			Map<String, String> contractmsg = BestsignOpenApiClient.contractSendByTemplate(contractId, tid ,account,varNames,isAllowChangeSignaturePosition,returnUrl,vcodeMobile,isDrawSignatureImage,signatureImageName,pushUrl,version,expireTime);
			return contractmsg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, String> contractCancel(String contractId) {
		// TODO Auto-generated method stub
		try {
			Map<String, String> contractmsg = BestsignOpenApiClient.contractCancel(contractId);
			return contractmsg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, String> contractSignTemplate(String contractId, String tid,Integer shardCityId, String account) {
		//自动签署信息
		String varsJson=AppConfig.getProperty(tid+"_company");
		ErpFunEntrust erpFunEntrust = erpFunEntrustMapper.selectByContractId(shardCityId, contractId);
		if (erpFunEntrust == null) {
			throw new BusinessException("委托已失效！");
		}
		ErpFunEntrustOwners erpFunEntrustOwners = erpFunEntrustOwnersMapper.selectByEntrustIdAndOwnerCardNo(shardCityId, erpFunEntrust.getEntrustId(), account);
		//查询业主修改业主的状态
		if (erpFunEntrustOwnersMapper.updateByOwnerId(shardCityId, erpFunEntrustOwners.getId(), erpFunEntrust.getEntrustId(), " ") <= 0) {
			throw new BusinessException("请勿重复提交！");
		}
		try {
			Map<String, String> SignerStatusMsg= BestsignOpenApiClient.getContractSignerStatus(contractId);
			Collection<String> values = SignerStatusMsg.values();
			for (String string : values) {
				if("1".equals(string)) {// 只要有一个 未签署  不锁定  
					Map<String, String> map =new HashMap<String, String>();
					map.put("code", "6");
					map.put("msg", "ok");
					return map;
				}
			}
			//自动签章
			Map<String, String> contractmsg = BestsignOpenApiClient.contractSignTemplate(contractId, tid, varsJson);

			if(contractmsg==null||(!"0".equals(contractmsg.get("code") )&& !"241423".equals(contractmsg.get("code")))) {//失败 直接返回
				return contractmsg;
			}
			//锁定合同
			Map<String, String> lockMsg = BestsignOpenApiClient.contractLock(contractId);
			if(contractmsg==null||(!"0".equals(contractmsg.get("code"))&& !"241423".equals(contractmsg.get("code")))) {//失败 直接返回
				return lockMsg;
			}	
			byte[] contractDownload = BestsignOpenApiClient.contractDownload(contractId);
			String uri = "mlwy_mr_shenzhen/images/broker/houseElectronicData/"+ MLDateUtil.convertDateToStr(new Date(), "yyyy")+"/"+MLDateUtil.convertDateToStr(new Date(), "yyyyMM");
			
			String pdfFilePath = uri;
			String pdfFileName=contractId+".pdf"; 
			System.err.println("pdfFileName:"+uri+pdfFileName);
			
			File file = new File(pdfFilePath + pdfFileName);
			//判断文件是否存在，存在则不往下走。
			if(file.exists()) {
				Map<String, String> rultmap =new HashMap<String, String>();
				rultmap.put("code", "0");
				rultmap.put("msg", "ok");
				return rultmap;
			}
			MLFileUtil.byte2File(contractDownload, pdfFilePath,pdfFileName);
			System.err.println(" pdfFileName:"+uri+pdfFileName);
			Float imageScale=2.5f;  
			
			//图片清晰度 imageScale 
			List<String> pdfToImagePath  = MLFileUtil.pdfToImagePath(new File(pdfFilePath+pdfFileName), pdfFilePath+"/pdf_img"+contractId,imageScale);
			// PDF转图片 签署确定只有一页 所以取第一张图片 就够了
			String imagePath = pdfToImagePath.get(0);
			System.out.println("imagePath"+imagePath);
			// 基础图片
			byte[] bytes = MLFileUtil.fileToBytes(imagePath);
			
//
			
//			final String fileName = contractId+".jpg";
//			final String suffix = fileName.substring(fileName.lastIndexOf("."));
//			List<ImageAttribute> list = ImageUtil.getCompreeSizeList();
//			ImageAttribute imgattr = new ImageAttribute(2000, 2000, true);// 房产资料的图片增加2000X2000的尺寸
//			list.add(imgattr);
//			String fileId = ImageUtil.compressSave(contractId, bytes, pdfFilePath, suffix, list);
			String fileUrl = FileUtil.uploadFile("委托合同书.png", bytes);
			//删除pdf文件
			File picPdf = new File(pdfFilePath+pdfFileName);
			if(picPdf.exists()) {
				picPdf.delete();
			}

			//计算图片大小
			String fileSizeCn = MLFileUtil.pathSize(AppConfig.getPicDomainUrl() + fileUrl);
			//1.添加对应房产资料的  委托书文件 
			ErpFunEntrustFiles erpFunEntrustFiles = new ErpFunEntrustFiles();
			erpFunEntrustFiles.setShardCityId(shardCityId);
			erpFunEntrustFiles.setEntrustId(erpFunEntrust.getEntrustId());	//房产资料ID
			erpFunEntrustFiles.setFilePath(fileUrl);
			erpFunEntrustFiles.setFileSizeCn(fileSizeCn);
			erpFunEntrustFiles.setFileType((byte)1);
			erpFunEntrustFiles.setFileName("委托合同书.png");	 
			erpFunEntrustFiles.setUpdateTime(new Date());
			erpFunEntrustFiles.setFileExt("png");
			erpFunEntrustFilesMapper.insertSelective(erpFunEntrustFiles);
			
//			2.房产资料设置状态为待审核状态
//			erpFunEntrust.setAuditStatus((byte)0);
//			erpFunEntrust.setShardCityId(shardCityId);
			//将所有业主的信息改为已签署
			//修改委托状态
			ErpFunEntrust erpFunEntrustUpdate = new ErpFunEntrust();
			erpFunEntrustUpdate.setShardCityId(shardCityId);
			erpFunEntrustUpdate.setCityId(shardCityId);
			erpFunEntrustUpdate.setEntrustId(erpFunEntrust.getEntrustId());
			erpFunEntrustUpdate.setSignStatus((byte) 1);
			erpFunEntrustUpdate.setSignFinashDate(new Date());
			// 如果是在待签署的状态下，最后一位业主签约，则将状态更新为正常
			if (erpFunEntrust.getEntrustStatus() == 11) {
				erpFunEntrustUpdate.setEntrustStatus((byte) 1);
			}

			// 判断是否配置了审核流程，如果配置了则需要走审核流程，如果没有配置，则不需要审核这个步骤
			ErpAuditTemplate erpAuditTemplate = erpAuditTemplateMapper.selectByAuditType(shardCityId, erpFunEntrust.getCompId(), (byte) 1, Const.DIC_TRACK_TYPE_ENTRUST_DATA.intValue(), erpFunEntrust.getCaseType().intValue());
			boolean needAudit = false;
			if (null != erpAuditTemplate && erpAuditTemplate.getNeedAudit() == 1) {
				needAudit = true;
			}
			if (!needAudit) { // 没有审核流程，则默认审核通过
				erpFunEntrustUpdate.setShardCityId(shardCityId);
				erpFunEntrustUpdate.setEntrustId(erpFunEntrust.getEntrustId());
				erpFunEntrustUpdate.setAuditStatus((byte) 2); // 审核状态（0=待审核 1=审核拒绝 2=审核完成）
				erpFunEntrustUpdate.setAuditDate(new Date());
				erpFunEntrustUpdate.setAuditUserId(999);
			}

			int i = erpFunEntrustMapper.updateByPrimaryKeySelective(erpFunEntrustUpdate);
			// 创建跟进（发起审核） 调用houseWeb接口
			Map<String, Object> paramData = new HashMap<>();
			paramData.put("entrustId", erpFunEntrust.getEntrustId());
			paramData.put("cityId", shardCityId);
			HttpUtil.postJson(AppConfig.getHouseWebUrl() + "/openApi/mlEntrust/entrustCreateTrackInfo", paramData);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BestsignServiceImpl.contractSignTemplate  error :"+ e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		Map<String, String> map =new HashMap<String, String>();
		map.put("msg", "ok");
		return map;
	}
	
	@Override
	public Map<String, String> createContractSend2perTemplate(String tidPrefix, Map<String, String> templateValues,List<ErpFunEntrustOwners> erpFunEntrustOwnersList,Integer cityId) {
		Map<String, String> relut=new HashMap<String, String>();
		// 先遍历注册   由于签署合同人数太多签名会无法  排列开所以先判断数量是否超过 
		if(StringUtils.isEmpty(tidPrefix)) { 
			relut.put("code", "1");
			relut.put("msg", "模板前缀为空");
			return relut;
		}
		//获得对应签署人数量的模板id   找不到则证明不能创建                                                         
		String tid = AppConfig.getProperty(tidPrefix+erpFunEntrustOwnersList.size());
		if(StringUtils.isEmpty(tid)) {
			//找不到人数对应模板
			relut.put("code", "1");
			relut.put("msg", "未找到对应模板 ："+tidPrefix+erpFunEntrustOwnersList.size());
			return relut;
		}
		//获得对应模板的 需要签署控件列表
		String varNames = AppConfig.getProperty(tid+"_per"); //需要签署的控件列表  对应合同模板编号 ;  分割
		String[] split = varNames.split(";");
		if(erpFunEntrustOwnersList.size()!=split.length) {
			//异常情况
			relut.put("code", "1");
			relut.put("msg", "签署合同人数 与 签名数量不符");
			return relut;
		}
		//创建一个线程池
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        //创建有两个返回值的线程
        List<Future<Map<String, Object>>> futureList=new ArrayList<Future<Map<String, Object>>>();
        for (ErpFunEntrustOwners erpFunEntrustOwners : erpFunEntrustOwnersList) {
        	Future<Map<String, Object>> future=executorService.submit(new BestsignPerReg(erpFunEntrustOwners));
        	futureList.add(future);
		}
        for (Future<Map<String, Object>> future : futureList) {
        	try {
				Map<String, Object> map = future.get();
				if((Integer) map.get("code")!=0) {
					relut.put("code", "1");
					relut.put("msg", "上上签注册失败:" + map.get("msg"));
					return relut;
				}
			} catch (Exception e) {
				e.printStackTrace();
				//异常情况
				relut.put("code", "500");
				relut.put("msg", "注册异常");
				return relut;
			} 
		}
        //关闭线程池
        executorService.shutdown();
        
    	//创建者信息（合同发起方）
        String account = AppConfig.getProperty("common.ssq.Bestsign_account");
        
        Map<String, String> checkMap = this.templateCreateContractPdf(account,tid,templateValues,null);
		if(checkMap==null||!"0".equals(checkMap.get("code"))) {
			//异常情况
			relut.put("code", "501");
			relut.put("msg", "操作失败");
			return relut;
		}
		String contractId = checkMap.get("msg");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s = sdf.format(new Date());
		Date nextDay;
		String expireTime=null;
		try {
			Date date = sdf.parse(s);
			//创建第二天起  往后推三天   3+1 =4
			nextDay = MLDateUtil.getNextDay(date, 4);
			expireTime=nextDay.getTime()/1000L+"";//格式为秒级的unix时间戳   不填默认七天
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			//异常情况
			relut.put("code", "500");
			relut.put("msg", "合同发起异常");
			return relut;
		}
		//获得签署链接
		for (int j = 0; j < erpFunEntrustOwnersList.size(); j++) {
			try {
				Map<String, String> contractSendMap = this.contractSend(erpFunEntrustOwnersList.get(j).getCardNo(), contractId, tid, split[j],expireTime,true,cityId);
				if(contractSendMap==null||!"0".equals(contractSendMap.get("code"))) {
					//异常情况
					//生成签署链接异常  直接抛出异常  撤销合同  所有签署链接必须全部成功 合同才能创建成功
					throw new Exception("创建签署链接人异常： "+contractSendMap);
				}
				String shortUrl=contractSendMap.get("shortUrl");
				String longUrl=contractSendMap.get("longUrl");
				
				//上上签电子委托签署 客户记录 保存签署链接到对应业主
				BestsignContract bestsignContract= new BestsignContract();
				//业务处理
				bestsignContract.setShardCityId(cityId);
				bestsignContract.setContractId(contractId);
				bestsignContract.setShortUrl(shortUrl);
				bestsignContract.setLongUrl(longUrl);
				bestsignContract.setExpireTime(nextDay);
				bestsignContract.setBestsignPerAccount(erpFunEntrustOwnersList.get(j).getCardNo());
				bestsignContract.setTid(tid);
				bestsignContract.setSignState("0");
				bestsignContract.setId(UUID.randomUUID().toString());
				String MLuri = "/openApi/mlEntrustApi/perRegPage?contractId="+contractId+"&ownerId="+erpFunEntrustOwnersList.get(j).getId() + "&cityId=" + cityId;
				bestsignContract.setMLuri(MLuri);
				bestsignContract.setBestsignPerPhone(erpFunEntrustOwnersList.get(j).getOwnerPhone());
				bestsignContract.setSMS("2");//默认已经通知  为减少 数据库操作
				bestsignContract.setCreateTime(new Date());
				bestsignContractService.addEntity(bestsignContract);
			} catch (Exception e) {
				//异常情况需要撤销合同
				System.out.println("创建合同异常 ："+e.getMessage());
				//撤销合同
				Map<String, String> contractCancel = this.contractCancel(contractId);
				System.out.println(contractCancel);
				relut.put("code", "501");
				relut.put("msg", "操作失败");
				return relut;
			}
		}
		relut.put("code", "0");
		relut.put("msg", contractId);
		return relut;
	}
	
	class BestsignPerReg  implements Callable<Map<String, Object>>{
		
		Map<String, Object> relut=new HashMap<String, Object>();
		
		private ErpFunEntrustOwners erpFunEntrustOwners;
		
		BestsignPerReg(ErpFunEntrustOwners erpFunEntrustOwners) {
			this.erpFunEntrustOwners	= erpFunEntrustOwners;
		}

		@Override
		public Map<String, Object> call() throws Exception {
			
			try {
				String taskId = bestsignPerReg(erpFunEntrustOwners);
				if(StringUtils.isEmpty(taskId)) {
					//异常情况
					relut.put("code", 501);
					relut.put("msg", "注册失败");
					return relut;
				}
				int loopCount=0;
				//最多循环20次  每次间隔 0.5 秒 
				while (true) {
					if(loopCount>20) {
						//异常情况
						relut.put("code", 501);
						relut.put("msg", "注册失败");
						return relut;
					}
					loopCount++;
					
					String accountCheck = accountCheck(erpFunEntrustOwners.getCardNo(), taskId);
					//证书申请状态 1：新申请 2：申请中 3：超时 4：申请失败 5：成功 6：失败重试 -1：无效的申请（系统异常） 0：taskId不存在或已过期
					if("5".equals(accountCheck)) {//成功则标识通过
//						bestsignPersonService.deleteByAccount(bestsignPerson.getAccount());
//						bestsignPersonService.addEntity(bestsignPerson);
						//异常情况
						relut.put("code", 0);
						relut.put("msg", "注册成功");
						return relut;
					}
					if("4".equals(accountCheck)) {//失败跳出
						//异常情况
						relut.put("code", 501);
						relut.put("msg", "4：申请失败");
						return relut;
					}
					if("-1".equals(accountCheck)) {//异常退出
						//异常情况
						relut.put("code", 501);
						relut.put("msg", "-1：无效的申请（系统异常）");
						return relut;
					}
					if("0".equals(accountCheck)) {//异常退出
						//异常情况
						relut.put("code", 501);
						relut.put("msg", " 0：taskId不存在或已过期");
						return relut;
					}
					Thread.sleep(500);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//异常情况
				relut.put("code", 502);
				relut.put("msg", "注册失败");
				return relut;
			}
		}
	}
}
