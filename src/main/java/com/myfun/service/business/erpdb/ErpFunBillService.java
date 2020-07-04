package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.param.QueryPrintBuillInfoParam;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.erpdb.po.ErpFunEarbestMoney;
import com.myfun.repository.erpdb.po.ErpProcessFinanc;
import com.myfun.repository.support.param.GeneralParam;

import java.util.List;

public interface ErpFunBillService {
	public void printBill(QueryPrintBuillInfoParam param) throws Exception;

	public void saveBillPhoto(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, Integer earbestId,
			Integer financId,Integer dealId , Integer depositId, String photoUrl ,String billNo);

	public void delBillPhoto(Integer cityId, Integer compId, Integer deptId, Integer userId, String userName, Integer earbestId,
			Integer financId,Integer dealId , Integer depositId, String billNo);

	void createBill(GeneralParam generalParam, Integer dealId, String contractNo, Byte dealType, String billWay, List<ErpProcessFinanc> processList, List<ErpFunEarbestMoney> earbestMoneyList, ErpFunDeposit deposit, boolean b);

	void createBill(Integer cityId, Integer compId, Integer areaId, Integer regId, Integer deptId, Integer grId, Integer userId, Integer dealId, String contractNo , Byte dealType, Byte billWay,
					List<ErpProcessFinanc> processFinancPO , List<ErpFunEarbestMoney> earbestMoneyList, ErpFunDeposit deposit, boolean isPrint);

	/**
	 * 检查票据单号在诚意表及订单表是否使用了该单号
	 * @param cityId
	 * @param compId
	 * @param codeNo 票据单号
	 * @param useCancellation 是否检查已作废单号
	 * @return
	 */
	boolean checkBillCodeRepeat(Integer cityId, Integer compId, String codeNo);

	/**
	 *
	 * @param cityId
	 * @param compId
	 * @param codeNo 票据单号
	 * @param useCancellation 是否检查已作废单号
	 * @param specialTable 只检查特定表 1诚意金表 2订单表
	 * @return
	 */
	boolean checkBillRepeatSpecialTable(Integer cityId, Integer compId,String codeNo,boolean useCancellation,Byte specialTable);
}
