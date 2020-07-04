package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.house.vo.FunKeyDetailDto;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpFunKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.BorrowOrReturnKeyParam;
import com.myfun.service.business.erpdb.bean.param.CreateHouseKeyParam;
import com.myfun.service.business.erpdb.bean.param.DestroyKeyParam;

import java.util.Map;

public interface ErpFunKeyService extends BaseMapper<ErpFunKey, ErpFunKey>{

	/**
	 * 门店版创建钥匙跟进
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param param
	 * @throws BusinessException 
	 * @throws Exception 
	 */
	void createHouseKeyTrack(Integer cityId,Integer compId,CreateHouseKeyParam param) throws Exception;
	/**
	 * 精英版创建钥匙跟进
	 * @author 方李骥
	 * @since 2016年8月29日
	 * @param cityId
	 * @param param
	 * @throws BusinessException 
	 * @throws Exception 
	 */
	void createHouseKeyTrackPer(Integer cityId,Integer compId,CreateHouseKeyParam param) throws Exception;
	/**
	 * 门店版创建没有钥匙的跟进说明
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param param
	 */
	void createNoKeyTrack(Integer cityId,Integer compId, CreateHouseKeyParam param) ;
	
	/**
	 * 判断钥匙是否已经提交
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 */
	public void detectHouseKey(Integer cityId, Integer compId, Integer caseId, Byte caseType);

	/**
	 * 判断是否可以归还钥匙
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param cityId
	 * @param compId
	 * @param caseId
	 * @param caseType
	 */
	public void judgeDestroyHouseKey(Integer cityId, Integer compId, Integer caseId, Byte caseType, Integer saleLeaseId);
	
	/**
	 * 判断钥匙是否已经存在
	 * @author 张宏利
	 * @since 2017年10月25日
	 * @param cityId
	 * @param compId
	 * @param deptId
	 * @param keyNum
	 */
	public void detectKeyNum(Integer cityId, Integer compId, Integer deptId, String keyNum);
	
	/**
	 * 精英版创建没有钥匙的跟进说明
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param param
	 */
	void createNoKeyTrackPer(Integer cityId,Integer compId, CreateHouseKeyParam param) ;
	/**
	 * 门店版退还钥匙跟进说明
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param param
	 */
	void returnHouseKey(Integer cityId, Integer compId, BorrowOrReturnKeyParam param) throws Exception;
	/**
	 * 门店版注销钥匙说明
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @throws Exception 
	 */
	void destroyKey(DestroyKeyParam param) throws Exception;
	/**
	 * 精英版注销钥匙说明
	 * @author 方李骥
	 * @since 2016年8月30日
	 * @param cityId
	 * @param compId
	 * @param param
	 * @throws Exception 
	 */
	void destroyKeyPer(BorrowOrReturnKeyParam param) throws Exception;
	/**
	 * 门店版借用钥匙说明
	 * @author 方李骥
	 * @since 2016年9月6日
	 * @param param
	 * @throws Exception 
	 */
	void borrowKey(BorrowOrReturnKeyParam param) throws Exception;

	/**
	 * 查询钥匙编号
	 * @author 臧铁
	 * @since 2017年7月13日
	 * @param caseId
	 * @param caseType
	 * @param trackKey 0=查询已有钥匙编号 1=查询新钥匙编号
	 * @param curCompId 经纪人公司ID
	 * @param keyDeptId 以提交钥匙申请人的DEPTID和USERID为主  钥匙的所在门店
	 * @param cityId 
	 * @return
	 */
	String getKeyNum(Integer caseId, Byte caseType, Integer trackKey, Integer curCompId,Integer keyDeptId,Integer cityId) ;
	
	/**
	 * 获取新的钥匙编号
	 *
	 * @return
	 * @author 张宏利
	 * @since 2017年12月22日
	 */
	String getNewKeyNum(Integer cityId, Integer compId, Integer deptId, String deptNo,Integer userId);

	FunKeyDetailDto getKeyDetail(ErpCreateTrackInfoParam param,Integer cityId,Integer currentUserId,Integer currentDeptId);
	
	/**
	 * 精英版钥匙判断重
	 * @param
	 * @auther 胡坤
	 * @since 2018/5/4
	 * @return
	 *
	 */
	void delectPersonlVersionKeyNum(Integer cityId, Integer compId, Integer createAuditUid, String keyNum);
	
	/**
	 * 验证当前登录人能否查看钥匙凭证（钥匙提交人或有房源文件查看权的人才可看）
	 * @param cityId
	 * @param currenUserId
	 * @param caseType
	 * @param caseId
	 * @since 2019-11-09 20:16:00
	 * @author chenfeng
	 * @return
	 */
	boolean judgeCanViewKeyVoucher(Integer cityId, Integer currenUserId, Integer caseType, Integer caseId);
}
