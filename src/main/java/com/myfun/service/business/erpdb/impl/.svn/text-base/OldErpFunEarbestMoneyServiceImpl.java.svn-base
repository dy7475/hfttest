package com.myfun.service.business.erpdb.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.managecenter.transaction.param.updateDealFunEarbestParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuyCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyMapper;
import com.myfun.repository.erpdb.dao.ErpFunEarbestMoneyrecordMapper;
import com.myfun.repository.erpdb.dao.ErpFunRentCustomerMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpPosPaymentOrderMapper;
import com.myfun.repository.erpdb.dto.ErpFunEarbestMoneyDto;
import com.myfun.repository.erpdb.po.ErpEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunBill;
import com.myfun.repository.erpdb.po.ErpFunBillExample;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoneyrecord;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBillCodeService;
import com.myfun.service.business.erpdb.ErpFunBillCodelogService;
import com.myfun.service.business.erpdb.ErpFunBillService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpUserOpersService;
import com.myfun.service.business.erpdb.OldErpFunEarbestMoneyService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateEarbestMoneyParam;
import com.myfun.service.business.erpdb.bean.param.QueryErpEarbestMoneyListParam;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.EnCodeHelper;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OldErpFunEarbestMoneyServiceImpl extends AbstractService<ErpFunEarbestMoney, ErpFunEarbestMoney> implements OldErpFunEarbestMoneyService {
	@Autowired
    ErpFunEarbestMoneyMapper erpFunEarbestMoneyMapper;
	@Autowired
    ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
    ErpFunUsersService erpFunUsersService;
	@Autowired
    ErpUserOpersService erpUserOpersService;
	@Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
    ErpFunEarbestMoneyrecordMapper erpFunEarbestMoneyrecordMapper;
	@Autowired
    ErpPosPaymentOrderMapper erpPosPaymentOrderMapper;
	@Autowired
    ErpFunBillMapper erpFunBillMapper;
	@Autowired
    ErpFunBillCodeService erpFunBillCodeService;
	@Autowired
    ErpFunBuyCustomerMapper erpFunBuyCustomerMapper;
	@Autowired
    ErpFunRentCustomerMapper erpFunRentCustomerMapper;
	@Autowired
    ErpFunBillService erpFunBillService;
	@Autowired
    ErpFunBillCodelogService erpFunBillCodelogService;


	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunEarbestMoneyMapper;
	}
	
	/**
	 * 查询诚意金列表需要分页时调用的方法
	 */
	@Override
	public PageInfo<ErpFunEarbestMoneyDto> getEarbestMoneyList(
			QueryErpEarbestMoneyListParam param) throws Exception {
		if(StringUtils.isNotBlank(param.getReceiptNo())){
			param.setReceiptNo("%"+param.getReceiptNo()+"%");
		}
		if(StringUtils.isNotBlank(param.getBuildId())){
			param.setBuildIds(param.getBuildId().split(","));
			param.setBuildName(null);
		}else if(StringUtils.isNotBlank(param.getBuildName())){
			param.setBuildName("%"+param.getBuildName()+"%");
		}
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getStartTime(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getEndTime(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("A."+param.getDateType()+" DESC,A.EARBEST_ID DESC");
		param.setDateType("A."+param.getDateType());
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunEarbestMoneyDto> list =  erpFunEarbestMoneyMapper.selectEarbestMoneyList(param.getCityId(),param);
		PageInfo<ErpFunEarbestMoneyDto> page = new PageInfo<>(list);
		return page;
	}
	
	/**
	 * 导出诚意金列表时调用的方法
	 */
	@Override
	public List<ErpFunEarbestMoneyDto> getEarbestMoneyListExport(
			QueryErpEarbestMoneyListParam param) throws Exception {
		if(StringUtils.isNotBlank(param.getReceiptNo())){
			param.setReceiptNo("%"+param.getReceiptNo()+"%");
		}
		if(StringUtils.isNotBlank(param.getBuildId())){
			param.setBuildIds(param.getBuildId().split(","));
			param.setBuildName(null);
		}else if(StringUtils.isNotBlank(param.getBuildName())){
			param.setBuildName("%"+param.getBuildName()+"%");
		}
		param.setStartTime(DateTimeHelper.formatDateTimetoString(param.getStartTime(), "yyyy-MM-dd 00:00:00"));
		param.setEndTime(DateTimeHelper.formatDateTimetoString(param.getEndTime(), "yyyy-MM-dd 23:59:59"));
		param.setOrderBy("A."+param.getDateType()+" DESC,A.EARBEST_ID DESC");
		param.setDateType("A."+param.getDateType());
		List<ErpFunEarbestMoneyDto> list =  erpFunEarbestMoneyMapper.selectEarbestMoneyList(param.getCityId(),param);
		return list;
	}
	/**
	 * 新增诚意金
	 */
	@Transactional
	@Override
	public void createDealFunEarbestMoney(CreateOrUpdateEarbestMoneyParam param) throws Exception {
		Date date = new Date();
		ErpFunEarbestMoney erpFunEarbestMoney = new ErpFunEarbestMoney();
		BeanUtils.copyProperties(param, erpFunEarbestMoney);
		erpFunEarbestMoney.setShardCityId(param.getCityId());
		erpFunEarbestMoney.setCompId(param.getCompId());
		erpFunEarbestMoney.setCreateUser(param.getUserId());
		erpFunEarbestMoney.setCreateUserName(param.getUserName());
		erpFunEarbestMoney.setDeptId(param.getDeptId());
		erpFunEarbestMoney.setCreateTime(date);
		erpFunEarbestMoney.setIsDel((byte) 0);////0代表未删除，1代表已删除
		erpFunEarbestMoney.setUpdateTime(date);
        erpFunEarbestMoney.setPaymentType(param.getPaymentType());
		erpFunEarbestMoney.setEarbestStatus((byte) 0);
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(param.getCityId(),erpFunEarbestMoney.getReceiptUserId());
		ErpFunDepts id = new ErpFunDepts();
		id.setShardCityId(param.getCityId());
		id.setDeptId(erpFunUsers.getDeptId());
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.selectByPrimaryKey(id);
		erpFunEarbestMoney.setReceiptDeptId(erpFunUsers.getDeptId());
		erpFunEarbestMoney.setReceiptDeptName(erpFunDepts.getDeptCname());
		if(checkDealReceiptNoRepeat(erpFunEarbestMoney)){
			throw new BusinessException("该收据编号重复！");
		}

		if ("1".equals(param.getPerformanceName()) && StringUtils.isBlank(param.getCustIdcard()) && null != param.getCustId()) {
			ErpFunBuyCustomer erpFunBuyCustomer = erpFunBuyCustomerMapper.getFunBuyCustomer(param.getCityId(), param.getCustId());
			if (erpFunBuyCustomer != null && StringUtils.isNotBlank(erpFunBuyCustomer.getIdCard())) {
				String idCard = EnCodeHelper.decode(erpFunBuyCustomer.getIdCard());
				erpFunEarbestMoney.setCustIdcardDecode(idCard);
				if (idCard.length() > 3) {
					erpFunEarbestMoney.setCustIdcard(idCard.substring(0, 4) + "**************");
				} else {
					erpFunEarbestMoney.setCustIdcard(idCard + "***************");
				}
			}
		} else if ("2".equals(param.getPerformanceName()) &&   StringUtils.isBlank(param.getCustIdcard()) && null != param.getCustId()) {
			ErpFunRentCustomer erpFunRentCustomer = erpFunRentCustomerMapper.getRentCustomerByCustId(param.getCityId(), param.getCustId());
			if (erpFunRentCustomer != null && !StringUtils.isBlank(erpFunRentCustomer.getIdCard())) {
				String idCard = EnCodeHelper.decode(erpFunRentCustomer.getIdCard());
				erpFunEarbestMoney.setCustIdcardDecode(idCard);
				if (idCard.length() > 3) {
					erpFunEarbestMoney.setCustIdcard(idCard.substring(0, 4) + "**************");
				} else {
					erpFunEarbestMoney.setCustIdcard(idCard + "***************");
				}
			}
		} else {
			erpFunEarbestMoney.setCustIdcardDecode(erpFunEarbestMoney.getCustIdcard());
		}
		StringBuilder sb = new StringBuilder("");
		if(StringUtils.isNotBlank(erpFunEarbestMoney.getCustName())) {
            sb.append(erpFunEarbestMoney.getCustName()).append(",");
        }
		if(StringUtils.isNotBlank(erpFunEarbestMoney.getReceiptNo())) {
            sb.append(erpFunEarbestMoney.getReceiptNo()).append(",");
        }
		if(StringUtils.isNotBlank(erpFunEarbestMoney.getCustIdcardDecode())) {
            sb.append(erpFunEarbestMoney.getCustIdcardDecode()).append(",");
        }
		erpFunEarbestMoney.setIntelligentSearch(sb.toString());
		erpFunEarbestMoneyMapper.insertSelective(erpFunEarbestMoney);

		List<ErpFunEarbestMoney> earbestMoneyList = new ArrayList<>();
		earbestMoneyList.add(erpFunEarbestMoney);
		erpFunBillService.createBill(param.getCityId(), param.getCompId(), param.getAreaId(), param.getRegId(), param.getDeptId(), param.getDeptId(), param.getUserId(),
				null, null, null, null, null, earbestMoneyList, null,true);
	}
	
	/**
	 * 判断编号是否重复
	 * @return
	 * @throws Exception
	 */
	private boolean checkDealReceiptNoRepeat(ErpFunEarbestMoney param) throws Exception {
		ErpEarbestMoney erpEarbestMoney = new ErpEarbestMoney();
		erpEarbestMoney.setCompId(param.getCompId());
		erpEarbestMoney.setIsDel(Byte.valueOf("0"));
		erpEarbestMoney.setReceiptNo(param.getReceiptNo());
		Integer count = erpFunEarbestMoneyMapper.count(param.getShardCityId(),erpEarbestMoney);
		if(count > 0){
			return true;//true 代表重复
		}
		return false;
	}
	
	/**
	 * 判断编号是否重复
	 * @return
	 * @throws Exception
	 */
	@Override
	public void deleteEarbestMoney(BaseMapParam param) throws Exception {
		ErpFunEarbestMoney erpFunEarbestMoney = new ErpFunEarbestMoney();
		erpFunEarbestMoney.setShardCityId(param.getInteger("cityId"));
		erpFunEarbestMoney.setEarbestId(param.getInteger("earbestId"));
		erpFunEarbestMoney.setIsDel(Byte.valueOf("1"));//1代表删除
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(erpFunEarbestMoney);
	}
	
	/**
	 * 修改诚意金状态（0待确认,1已收,2已退,3转定金）
	 * @return
	 * @throws Exception
	 */
	@Override
	public void updateEarbestMoneyStatus(BaseMapParam param) throws Exception {
		ErpFunEarbestMoney erpFunEarbestMoney = new ErpFunEarbestMoney();
		Date date = DateTimeHelper.getSystemDate();
		erpFunEarbestMoney.setShardCityId(param.getInteger("cityId"));
		erpFunEarbestMoney.setEarbestId(param.getInteger("earbestId"));
		erpFunEarbestMoney.setEarbestStatus(Byte.valueOf(param.getString("status")));
		erpFunEarbestMoney.setUpdateTime(date);
		if("1".equals(param.getString("status"))){
			erpFunEarbestMoney.setConfirmDeptId(param.getInteger("deptId"));
			erpFunEarbestMoney.setConfirmDeptName(param.getString("deptName"));
			erpFunEarbestMoney.setConfirmUserId(param.getInteger("userId"));
			erpFunEarbestMoney.setConfirmUserName(param.getString("userName"));
			erpFunEarbestMoney.setConfirmTime(date);
		}else if("2".equals(param.getString("status"))){
			erpFunEarbestMoney.setRefundDeptId(param.getInteger("deptId"));
			erpFunEarbestMoney.setRefundDeptName(param.getString("deptName"));
			erpFunEarbestMoney.setRefundUserId(param.getInteger("userId"));
			erpFunEarbestMoney.setRefundUserName(param.getString("userName"));
			erpFunEarbestMoney.setRefundTime(date);
			erpFunEarbestMoney.setRefundExplain(param.getString("refundExplain"));
		}else if("3".equals(param.getString("status"))){
			erpFunEarbestMoney.setDepositDeptId(param.getInteger("deptId"));
			erpFunEarbestMoney.setDepositDeptName(param.getString("deptName"));
			erpFunEarbestMoney.setDepositUserId(param.getInteger("userId"));
			erpFunEarbestMoney.setDepositUserName(param.getString("userName"));
			erpFunEarbestMoney.setDepositTime(date);
			erpFunEarbestMoney.setDealId(param.getInteger("dealId"));
			erpFunEarbestMoney.setDealNo(param.getString("dealNo"));
		}
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(erpFunEarbestMoney);
	}
	
	@Override
	public ErpFunEarbestMoneyDto getDealFunEarbestMoneyDetail(BaseMapParam param) {
		return erpFunEarbestMoneyMapper.selectEarbestMoneyDetail(param.getInteger("cityId"),param.getInteger("earbestId"));
	}
	
	/**
	 * 更新诚意金
	 * flj
	 * 2017-10-12
	 */
	@Transactional
	@Override
	public void updateEarbestMoney(CreateOrUpdateEarbestMoneyParam param, ErpFunEarbestMoney updateEarbestMoney) {
		Integer cityId = param.getCityId();
		Byte status = param.getStatus();
		Integer earbestId = param.getEarbestId();
		Date currentDate = new Date();
		ErpFunEarbestMoney erpFunEarbestMoney = erpFunEarbestMoneyMapper.selectEarbestMoneyDetail(cityId, earbestId);
		updateEarbestMoney.setEarbestStatus(status);
		updateEarbestMoney.setUpdateTime(currentDate);
		String currUserName = erpFunUsersService.getCurrUserName(cityId, param.getUserId(), param.getDeptId());
		String logContent =  " 修改了诚意金";
		if(null != status){
			if(1 == status.intValue()){
				updateEarbestMoney.setConfirmDeptId(param.getDeptId());
				updateEarbestMoney.setConfirmDeptName(param.getDeptName());
				updateEarbestMoney.setConfirmUserId(param.getUserId());
				updateEarbestMoney.setConfirmUserName(param.getUserName());
				updateEarbestMoney.setConfirmTime(currentDate);
				ErpFunBill erpFunBill = new ErpFunBill();
				erpFunBill.setBillStatus((byte) 1);
				ErpFunBillExample billExample = new ErpFunBillExample();
				billExample.setShardCityId(cityId);
				billExample.createCriteria().andEarbestIdEqualTo(earbestId);
				erpFunBillMapper.updateByExampleSelective(erpFunBill, billExample);
				logContent = " 于今日收讫了该诚意金";
			}else if(2 == status.intValue()){
				updateEarbestMoney.setRefundDeptId(param.getDeptId());
				updateEarbestMoney.setRefundDeptName(param.getDeptName());
				updateEarbestMoney.setRefundUserId(param.getUserId());
				updateEarbestMoney.setRefundUserName(param.getUserName());
				updateEarbestMoney.setRefundTime(currentDate);
				updateEarbestMoney.setRefundExplain(param.getRefundExplain());
				ErpFunBill erpFunBill = new ErpFunBill();
				erpFunBill.setBillStatus((byte) 2);
				ErpFunBillExample billExample = new ErpFunBillExample();
				billExample.setShardCityId(cityId);
				billExample.createCriteria().andEarbestIdEqualTo(earbestId);
				erpFunBillMapper.updateByExampleSelective(erpFunBill, billExample);
				// 票据号
				if (StringUtils.isNotBlank(erpFunEarbestMoney.getReceiptNo())) {
					erpFunBillCodelogService.updateBillCodeLogStatus(cityId, param.getCompId(), erpFunEarbestMoney.getReceiptNo(), "2");
				}
				if (StringUtils.isNotBlank(param.getRefundExplain())) {
					logContent = " 于今日操作了退款, 退款说明:"+ param.getRefundExplain();
				}else {
					logContent = " 于今日操作了退款。";
				}
			}else if(3 == status.intValue()){
				updateEarbestMoney.setDepositUserId(param.getUserId());
				updateEarbestMoney.setDepositDeptId(param.getDeptId());
				updateEarbestMoney.setDepositDeptName(param.getDepositDeptName());
				updateEarbestMoney.setDepositUserName(param.getUserName());
				updateEarbestMoney.setDepositTime(currentDate);
				updateEarbestMoney.setDealId(param.getDealId());
				updateEarbestMoney.setDealNo(param.getDealNo());
				// 关联的合同编号到票据上
				if(null != param.getDealId() && StringUtils.isNotBlank(param.getDealNo())) {
					ErpFunBill erpFunBill = new ErpFunBill();
					erpFunBill.setDealId(param.getDealId());
					erpFunBill.setContractNo(param.getDealNo());
					ErpFunBillExample billExample = new ErpFunBillExample();
					billExample.setShardCityId(cityId);
					billExample.createCriteria().andEarbestIdEqualTo(earbestId).andBillTypeEqualTo((byte) 0).andCompIdEqualTo(param.getCompId());
					erpFunBillMapper.updateByExampleSelective(erpFunBill, billExample);
				}
				logContent = " 于今日操作了转定金";
			}
		}
		// 收据编号
		if((StringUtil.isBlank(param.getReceiptNo()) && StringUtil.isNotBlank(erpFunEarbestMoney.getReceiptNo()))
				||(StringUtil.isNotBlank(param.getReceiptNo()) && !param.getReceiptNo().equals(erpFunEarbestMoney.getReceiptNo()))){
			String newReceiptNo = param.getReceiptNo();
			updateEarbestMoney.setReceiptNo(newReceiptNo);
			String oldReceiptNo = erpFunEarbestMoney.getReceiptNo();
			if(StringUtil.isBlank(oldReceiptNo)){
				oldReceiptNo = "空";
			}
			if(StringUtil.isBlank(newReceiptNo)){
				newReceiptNo = "空";
			}
			logContent = logContent + " " + "收据编号:" + oldReceiptNo + " >> " + newReceiptNo;
		}
		// 收款金额
		if((param.getReceiptMoney() == null && erpFunEarbestMoney.getReceiptMoney() != null)
				|| (param.getReceiptMoney() != null && !param.getReceiptMoney().equals(erpFunEarbestMoney.getReceiptMoney()))){
			Integer oldReceiptMoney = erpFunEarbestMoney.getReceiptMoney() == null ?0:erpFunEarbestMoney.getReceiptMoney();
			Integer newReceiptMoney = param.getReceiptMoney() == null ?0:param.getReceiptMoney();
			updateEarbestMoney.setReceiptMoney(param.getReceiptMoney());
			logContent = logContent + " " + "收款金额:" + oldReceiptMoney + " >> " + newReceiptMoney;
		}
		// 出票方式  0电子票据 1纸质票薄 2手动录入
		if((param.getBillWay() == null && erpFunEarbestMoney.getBillWay() != null)
				|| (param.getBillWay() != null && !param.getBillWay().equals(erpFunEarbestMoney.getBillWay()))){
			String oldBillWay = getBillWayString(erpFunEarbestMoney.getBillWay());
			String newBillWay = getBillWayString(param.getBillWay());
			updateEarbestMoney.setBillWay(param.getBillWay().byteValue());
			logContent = logContent + " " + "出票方式:" + oldBillWay + " >> " + newBillWay;
		}
		// 房源编号
		if((StringUtil.isBlank(param.getCaseNo()) && StringUtil.isNotBlank(erpFunEarbestMoney.getCaseNo()))
				||(StringUtil.isNotBlank(param.getCaseNo()) && !param.getCaseNo().equals(erpFunEarbestMoney.getCaseNo()))){
			String newCaseNo = param.getCaseNo();
			String oldCaseNo = erpFunEarbestMoney.getCaseNo();
			updateEarbestMoney.setCaseNo(newCaseNo);
			if(StringUtil.isBlank(oldCaseNo)){
				oldCaseNo = "空";
			}
			if(StringUtil.isBlank(newCaseNo)){
				newCaseNo = "空";
			}
			logContent = logContent + " " + "房源编号:" + oldCaseNo + " >> " + newCaseNo;
		}
		// 客源编号
//		if((StringUtil.isBlank(param.getCustNo()) && StringUtil.isNotBlank(erpFunEarbestMoney.getCustNo())) 
//				||(StringUtil.isNotBlank(param.getCustNo()) && !param.getCustNo().equals(erpFunEarbestMoney.getCustNo()))){
//			String newCustNo = param.getCustNo();
//			String oldCustNo = erpFunEarbestMoney.getCustNo();
//			updateEarbestMoney.setCustNo(newCustNo);
//			if(StringUtil.isBlank(newCustNo)){
//				newCustNo = "空";
//			}
//			if(StringUtil.isBlank(oldCustNo)){
//				oldCustNo = "空";
//			}
//			logContent = logContent + " " + "客源编号:" + oldCustNo + ">>" + newCustNo;
//		}
		// 备注
		if((StringUtil.isBlank(param.getEarbestRemark()) && StringUtil.isNotBlank(erpFunEarbestMoney.getEarbestRemark()))
				||(StringUtil.isNotBlank(param.getEarbestRemark()) && !param.getEarbestRemark().equals(erpFunEarbestMoney.getEarbestRemark()))){
			String newEarbestRemark = param.getEarbestRemark();
			String oldEarbestRemark = erpFunEarbestMoney.getEarbestRemark();
			updateEarbestMoney.setEarbestRemark(newEarbestRemark);
			if(StringUtil.isBlank(oldEarbestRemark)){
				oldEarbestRemark = "空";
			}
			if(StringUtil.isBlank(newEarbestRemark)){
				newEarbestRemark = "空";
			}
			logContent = logContent + " " + "备注:" + oldEarbestRemark + " >> " + newEarbestRemark;
		}
		updateEarbestMoney.setEarbestId(earbestId);
		updateEarbestMoney.setShardCityId(cityId);
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(updateEarbestMoney);
		// 写日志
		ErpFunEarbestMoneyrecord erpFunEarbestMoneyrecord = new ErpFunEarbestMoneyrecord();
		erpFunEarbestMoneyrecord.setCompId(param.getCompId());
		erpFunEarbestMoneyrecord.setEarbestId(earbestId);
		erpFunEarbestMoneyrecord.setCreateTime(currentDate);
		erpFunEarbestMoneyrecord.setCreateUser(param.getUserId());
		erpFunEarbestMoneyrecord.setLogContent(currUserName + logContent);
		erpFunEarbestMoneyrecord.setShardCityId(cityId);
		erpFunEarbestMoneyrecordMapper.insertSelective(erpFunEarbestMoneyrecord);
	}
	
	private String getBillWayString(Byte billWay){
		String billWayName = "电子票据";
		if(1 == billWay){
			billWayName = "纸质票簿";
		} else if(2 == billWay){
			billWayName = "手动录入";
		}
		return billWayName;
	} 
	
	/**
	 * 创建票据.如果是更新票据，那么则将以前的票据状态标记为删除，并且将
	 * @throws Exception
	 */
	private void createBill(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, ErpFunEarbestMoney erpEarbestMoney, Byte billWay, String billCodeNo) {
		if (StringUtils.isBlank(erpEarbestMoney.getReceiptNo())) {
			return ;
		}
		if (erpEarbestMoney.getEarbestId()!=null) {
			if (!billCodeNo.equals(erpEarbestMoney.getReceiptNo()) || !erpEarbestMoney.getBillWay().equals(billWay)) {
				//删除关联，修改状态
				ErpFunBillExample example = new ErpFunBillExample();
				example.setShardCityId(cityId);
				example.createCriteria().andCompIdEqualTo(erpEarbestMoney.getCompId()).andEarbestIdEqualTo(erpEarbestMoney.getEarbestId());
				ErpFunBill updateModel = new ErpFunBill();
				updateModel.setBillStatus(Byte.valueOf("2"));
				erpFunBillMapper.updateByExampleSelective(updateModel, example);
				erpFunBillMapper.deleteEarbestBillPrintRelative(cityId, erpEarbestMoney.getCompId(), erpEarbestMoney.getEarbestId());
				erpFunBillCodeService.updateBillCodeLogStatus(cityId, compId, deptId, billCodeNo,2);
				int count = erpFunBillCodeService.judgeBillCodeLogIsReapt(cityId, compId, deptId, Byte.valueOf("0"), billWay, erpEarbestMoney.getBillCodeId(),null, erpEarbestMoney.getReceiptNo());
				if (count > 0) {
					throw new BusinessException("该票据号已经被使用！");
				}
				ErpFunBill record = new ErpFunBill();
				record.setShardCityId(cityId);
				record.setCompId(compId);
				record.setAreaId(areaId);
				record.setRegId(regId);
				record.setDeptId(deptId);
				record.setGrId(grId);
				record.setUserId(userId);
				record.setEarbestId(erpEarbestMoney.getEarbestId());
				record.setCreationTime(new Date());
				record.setBillNo(erpEarbestMoney.getReceiptNo());
				record.setBillStatus(Byte.valueOf("0"));//设置为未确认
				record.setBillType(Byte.valueOf("0"));//这里是诚意金
				record.setPayCustomer(erpEarbestMoney.getCustName());
				record.setPayMoney(new BigDecimal(erpEarbestMoney.getReceiptMoney()));
				record.setIntelligentSearch(erpEarbestMoney.getReceiptNo()+","+(StringUtils.isBlank(erpEarbestMoney.getCustName())?"":erpEarbestMoney.getCustName()));
				record.setReceiptMoneyDept(erpEarbestMoney.getReceiptDeptId());
				record.setReceiptMoneyUser(erpEarbestMoney.getReceiptUserId());
				record.setReceiptTime(erpEarbestMoney.getReceiptTime());
				erpFunBillMapper.insertSelective(record);
				erpFunBillCodeService.updateBillCodeLogStatus(cityId, compId, deptId, erpEarbestMoney.getReceiptNo(),1);

			} 
		}
	}
	
	/**
	 * 创建日志对比记录 flj 2017-10-12
	 * @param param
	 * @param erpFunEarbestMoney
	 * @return
	 */
	private String buildCompareEarbestMoneyContent(CreateOrUpdateEarbestMoneyParam param,
                                                   ErpFunEarbestMoney erpFunEarbestMoney) {
		String updateContent = "";
		String newReceiptNo = param.getReceiptNo();
		String oldReceiptNo = erpFunEarbestMoney.getReceiptNo();
		Integer newReceiptMoney = param.getReceiptMoney();
		Integer oldReceiptMoney = erpFunEarbestMoney.getReceiptMoney();
		if (!oldReceiptNo.equals(newReceiptNo)) {
			updateContent += " 收据编号：" + oldReceiptNo + "->" + newReceiptNo;
		}
		if (!oldReceiptMoney.equals(newReceiptMoney)) {
			updateContent += " 收款金额：" + oldReceiptMoney + "->" + newReceiptMoney;
		}
		if (param.getCaseNo() != null && !param.getCaseNo().equals(erpFunEarbestMoney.getCaseNo())) {
			updateContent += " 意向房源：" + erpFunEarbestMoney.getCaseNo() + "->" + param.getCaseNo();
		}
		if (param.getEarbestRemark() != null && !param.getEarbestRemark().equals(erpFunEarbestMoney.getEarbestRemark())) {
			updateContent += " 备注：" + erpFunEarbestMoney.getEarbestRemark() + "->" + param.getEarbestRemark();
		}
		return updateContent;
	}

	/**
	 * @tag 删除诚意金
	 * @author 邓永洪
	 * @since 2018/5/30
	 */
	@Transactional
	@Override
	public void deleteDealFunEarbestMoney(GeneralParam generalParam, Integer earbestId) {
		Integer cityId = generalParam.getCityId();
		ErpFunEarbestMoney earbestMoney = new ErpFunEarbestMoney();
		earbestMoney.setShardCityId(cityId);
		earbestMoney.setEarbestId(earbestId);
		earbestMoney.setIsDel((byte) 1);
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(earbestMoney);
		erpFunBillMapper.DelByEarbestId(cityId, earbestId);
		earbestMoney = erpFunEarbestMoneyMapper.selectByPrimaryKey(earbestMoney);
		if (earbestMoney != null && StringUtils.isNotBlank(earbestMoney.getReceiptNo())) {
			erpFunBillCodeService.updateBillCodeLogStatus(cityId, generalParam.getCompId(), generalParam.getDeptId(), earbestMoney.getReceiptNo(), 2);
		}
	}

	/**
	 * @tag 修改诚意金状态
	 * @author wangchun
	 * @since 2018/11/26
	 */
	@Transactional
	@Override
	public void updateDealFunEarbestMoney(updateDealFunEarbestParam param, ErpFunEarbestMoney earbestMoney, String currUserName) {
		Byte status = param.getStatus();
		ErpFunEarbestMoney updateModel=new ErpFunEarbestMoney();
		Date now = new Date();
		updateModel.setShardCityId(param.getCityId());
		updateModel.setEarbestStatus(status);
		updateModel.setUpdateTime(now);
		ErpFunBillExample billExample=new ErpFunBillExample();
		billExample.setShardCityId(param.getCityId());
		ErpFunBillExample.Criteria billExampleCriteria = billExample.createCriteria();
		Integer earbestId = param.getEarbestId();
		billExampleCriteria.andEarbestIdEqualTo(earbestId);
		String logContent =  " 于今日修改了诚意金";

		if(1==status){
			updateModel.setConfirmDeptId(param.getDeptId());
			updateModel.setConfirmDeptName(param.getDeptName());
			updateModel.setConfirmUserId(param.getUserId());
			updateModel.setConfirmUserName(param.getUserName());
			updateModel.setConfirmTime(now);
			ErpFunBill funBill=new ErpFunBill();
			funBill.setShardCityId(param.getCityId());
			funBill.setBillStatus((byte)1);
			erpFunBillMapper.updateByExampleSelective(funBill,billExample);
			logContent = " 于今日收讫了该诚意金";
		}else if (2==status){
			updateModel.setRefundDeptId(param.getDeptId());
			updateModel.setRefundDeptName(param.getDeptName());
			updateModel.setRefundUserId(param.getUserId());
			updateModel.setRefundUserName(param.getUserName());
			updateModel.setRefundTime(now);
			String refundExplain = param.getRefundExplain();
			updateModel.setRefundExplain(refundExplain);
			ErpFunBill funBill=new ErpFunBill();
			funBill.setShardCityId(param.getCityId());
			funBill.setBillStatus((byte)2);
			erpFunBillMapper.updateByExampleSelective(funBill,billExample);
			if (StringUtils.isNotBlank(earbestMoney.getReceiptNo())) {
				erpFunBillCodelogService.updateBillCodeLogStatus(param.getCityId(), param.getCompId(), earbestMoney.getReceiptNo(), "2");
			}
			logContent = " 于今日操作了退款, 退款说明:"+ refundExplain;
		}else if (3==status){
			updateModel.setDepositDeptId(param.getDeptId());
			updateModel.setDepositDeptName(param.getDeptName());
			updateModel.setDepositUserId(param.getUserId());
			updateModel.setDepositUserName(param.getUserName());
			updateModel.setDepositTime(now);
			Integer dealId = param.getDealId();
			String dealNo = param.getDealNo();
			updateModel.setDealId(dealId);
			updateModel.setDealNo(dealNo);
			// 关联的合同编号到票据上
			billExampleCriteria.andCompIdEqualTo(param.getCompId()).andBillTypeEqualTo((byte)0);
			ErpFunBill funBill=new ErpFunBill();
			funBill.setShardCityId(param.getCityId());
			funBill.setDealId(dealId);
			funBill.setContractNo(dealNo);
			erpFunBillMapper.updateByExampleSelective(funBill,billExample);
			logContent = " 于今日操作了转定金";
		}
		updateModel.setEarbestId(earbestId);
		erpFunEarbestMoneyMapper.updateByPrimaryKeySelective(updateModel);
		// 写日志
		ErpFunEarbestMoneyrecord insertModel = new ErpFunEarbestMoneyrecord();
		insertModel.setCompId(param.getCompId());
		insertModel.setEarbestId(earbestId);
		insertModel.setCreateTime(now);
		insertModel.setCreateUser(param.getUserId());
		insertModel.setLogContent(currUserName + logContent);
		insertModel.setShardCityId(param.getCityId());
		erpFunEarbestMoneyrecordMapper.insertSelective(insertModel);
	}


}
