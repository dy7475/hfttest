package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpFunBillCodeMapper;
import com.myfun.repository.erpdb.dao.ErpFunBillCodelogMapper;
import com.myfun.repository.erpdb.dao.ErpFunBillMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.param.FunBillModuleParam;
import com.myfun.repository.erpdb.po.ErpFunBillCode;
import com.myfun.repository.erpdb.po.ErpFunBillCodelog;
import com.myfun.repository.erpdb.po.ErpFunBillCodelogExample;
import com.myfun.repository.erpdb.po.ErpFunBillExample;
import com.myfun.repository.erpdb.po.ErpFunBillExample.Criteria;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBillCodeService;

@Service
public class ErpFunBillCodeServiceImpl extends AbstractService<ErpFunBillCode, ErpFunBillCode> implements ErpFunBillCodeService {

	@Autowired
	ErpFunBillCodeMapper erpFunBillCodeMapper;
	@Autowired
	ErpFunBillCodelogMapper erpFunBillCodelogMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunBillMapper erpFunBillMapper;
	@Autowired
	private CacheUtil cacheUtil;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunBillCodeMapper;
	}

	/**
	 * @Title 修改试用规则
	 * @Author lcb
	 * @Date 2017/12/8
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer updateBillCodeRule(Integer cityId, Integer compId, FunBillModuleParam param) {
		ErpSysPara erpSysPara0 = new ErpSysPara();
		erpSysPara0.setCompId(compId);
		erpSysPara0.setShardCityId(cityId);
		erpSysPara0.setParamId("EARBEST_DEAL_BILL_REPEAT");
		erpSysPara0.setParamValue(param.getEarbestDealBillRepeat());
		erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara0);
		ErpSysPara erpSysPara1 = new ErpSysPara();
		erpSysPara1.setCompId(compId);
		erpSysPara1.setShardCityId(cityId);
		erpSysPara1.setParamId("ALLOW_USE_BILLNO_ISBYHAND");
		erpSysPara1.setParamValue(param.getAllowUseBillnoIsbyhand());
		erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara1);
		ErpSysPara erpSysPara2 = new ErpSysPara();
		erpSysPara2.setCompId(compId);
		erpSysPara2.setShardCityId(cityId);
		erpSysPara2.setParamId("INVALID_BILLNO_CAN_USE_AGAIN");
		erpSysPara2.setParamValue(param.getInvalidBillnoCanUseAgain());
		erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara2);
		ErpSysPara erpSysPara3 = new ErpSysPara();
		erpSysPara3.setCompId(compId);
		erpSysPara3.setShardCityId(cityId);
		erpSysPara3.setParamId("BILL_PRINT_WAY");
		erpSysPara3.setParamValue(param.getBillPrintWay());
		erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara3);
		cacheUtil.del(CacheStructure.hfterpdb_sysParaCache_map_by_CompId + compId + "_CITY_ID_" + cityId);
//		ErpSysPara erpSysPara4 = new ErpSysPara();
//		erpSysPara4.setCompId(compId);
//		erpSysPara4.setShardCityId(cityId);
//		erpSysPara4.setParamId("BILL_PRINT_TEMPLET");
//		erpSysPara4.setParamValue(param.getBillPrintTemplet());
//		erpSysParaMapper.updateByPrimaryKeySelective(erpSysPara4);

		if("1".equals(param.getInvalidBillnoCanUseAgain())) {
			// 恢复已用的号
			//首先应该先按编号进行groupBy,过滤点有效的,作废里面还有有效的
			List<Map<String,Object>> notEffctiveBillNoList = erpFunBillMapper.selectNotEffctiveBillNoList(cityId,compId);
			Set<String> billNoSet = notEffctiveBillNoList.stream().collect(Collectors.mapping(map->map.get("billNo").toString(), Collectors.toSet()));
			// 根据票据号查询详细
			if(billNoSet.size() > 0) {
				ErpFunBillCodelogExample erpFunBillCodelogExample = new ErpFunBillCodelogExample();
				erpFunBillCodelogExample.setShardCityId(cityId);
				erpFunBillCodelogExample.createCriteria().andCodeNoIn(new ArrayList<>(billNoSet)).andUseStatusEqualTo((byte)1);
				List<ErpFunBillCodelog> codelogList = erpFunBillCodelogMapper.selectByExample(erpFunBillCodelogExample);

				// 根据codeId分组
				Map<Integer, List<ErpFunBillCodelog>> groupBy = codelogList.stream().collect(Collectors.groupingBy(ErpFunBillCodelog::getCodeId));

				Set<Integer> codeIdSet = codelogList.stream().collect(Collectors.mapping(ErpFunBillCodelog::getCodeId, Collectors.toSet()));

				for (Integer codeId : codeIdSet) {
					List<ErpFunBillCodelog> codelogList1 = groupBy.get(codeId);
					ErpFunBillCodelog erpFunBillCodelog = new ErpFunBillCodelog();
					erpFunBillCodelog.setUseStatus((byte)0);
					erpFunBillCodelogExample = new ErpFunBillCodelogExample();
					erpFunBillCodelogExample.setShardCityId(cityId);
					Set<String> codeNoSet = codelogList1.stream().collect(Collectors.mapping(ErpFunBillCodelog::getCodeNo, Collectors.toSet()));
					erpFunBillCodelogExample.createCriteria().andCodeNoIn(new ArrayList<>(codeNoSet)).andUseStatusEqualTo((byte)1);
					erpFunBillCodelogMapper.updateByExampleSelective(erpFunBillCodelog, erpFunBillCodelogExample);

					ErpFunBillCode erpFunBillCode = new ErpFunBillCode();
					erpFunBillCode.setShardCityId(cityId);
					erpFunBillCode.setCodeId(codeId);
					erpFunBillCode = erpFunBillCodeMapper.selectByPrimaryKey(erpFunBillCode);
					erpFunBillCode.setUsedCount(erpFunBillCode.getUsedCount() - codelogList1.size());
					erpFunBillCode.setShardCityId(cityId);
					erpFunBillCodeMapper.updateByPrimaryKeySelective(erpFunBillCode);
				}
			}


		}
		return null;
	}

	/**
	 * @Title 启用停用号段规则
	 * @Author lcb
	 * @Date 2017/12/8
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer updateBillCode(Integer cityId, Integer compId, FunBillModuleParam param) {
		Byte status = param.getStatus();

		Integer res = 0;
		ErpFunBillCode erpFunBillCode = new ErpFunBillCode();
		erpFunBillCode.setCodeId(param.getCodeId());
		erpFunBillCode.setShardCityId(cityId);
		// 处理详情号表
		ErpFunBillCodelogExample erpFunBillCodelogExample = new ErpFunBillCodelogExample();
		erpFunBillCodelogExample.setShardCityId(cityId);
		ErpFunBillCodelogExample.Criteria criteria = erpFunBillCodelogExample.createCriteria();
		criteria.andCodeIdEqualTo(param.getCodeId());
		if(null == status) {
			res = erpFunBillCodeMapper.deleteByPrimaryKey(erpFunBillCode);
			erpFunBillCodelogMapper.deleteByExample(erpFunBillCodelogExample);
		}else {
			erpFunBillCode.setStatus(param.getStatus());
			res = erpFunBillCodeMapper.updateByPrimaryKeySelective(erpFunBillCode);

			ErpFunBillCodelog erpFunBillCodelog = new ErpFunBillCodelog();

			// 启用
			if(1 == param.getStatus().intValue()) {
				erpFunBillCodelog.setUseStatus((byte) 0);
				criteria.andUseStatusEqualTo((byte)2);
				// 停用
			}else {
				criteria.andUseStatusEqualTo((byte)0);
				erpFunBillCodelog.setUseStatus((byte) 2);
			}
			erpFunBillCodelogMapper.updateByExampleSelective(erpFunBillCodelog, erpFunBillCodelogExample);
		}

		return res;
	}

	/**
	 * @Title 号段分配
	 * @Author lcb
	 * @Date 2017/12/8
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer createBillCode(Integer cityId, Integer compId, Integer userId, String userName, FunBillModuleParam param) {

		// 判断是否 票据编码分配和已分配的编码重复
		Integer codeLength = (param.getCodePrefix()+param.getCodeEnd()).length();
		Integer codeLogCount = erpFunBillCodelogMapper.countCodeLog(cityId, compId, param, codeLength);
		if(codeLogCount > 0){
			throw new BusinessException("票据编码分配和已分配的编码重复!");
		}
        StringBuilder stringBuilder = new StringBuilder("");
        codeLength = param.getCodeEnd().length() - param.getCodeStart().length();
        for (Integer i=0; i< codeLength; i++) {
            stringBuilder.append("0");
        }
        param.setCodeStart(stringBuilder.toString()+param.getCodeStart());
        param.setCompId(compId);
        param.setShardCityId(cityId);
        param.setStatus((byte) 1);
        param.setCreateTime(new Date());
        param.setTotalCount((Integer.valueOf(param.getCodeEnd())-Integer.valueOf(param.getCodeStart()))+1);
        param.setUserId(userId);
        param.setUserName(userName);
        param.setUsedCount(0);
		erpFunBillCodeMapper.insertSelective(param);

		// 处理详情的码表
        createFunDealCodeLogList(cityId, param, stringBuilder.toString());
		return param.getCodeId();
	}

	/**
	 * @Title 获取票据号
	 * @Author lcb
	 * @Date 2017/12/11
	 * @Param
	 **/
	@Override
	public ErpFunBillCodelog getBillCodeLog(Integer cityId, Integer compId, Integer deptId, Byte billType, Byte billWay) {

		ErpFunBillCodelog erpFunBillCodelog = erpFunBillCodelogMapper.getOneBillCodeLog(cityId, compId, deptId, billType, billWay);
		return erpFunBillCodelog;
	}

	/**
	 * @Title
	 * @Author lcb
	 * @Date 2017/12/11
	 * @Param type:1 使用 2：恢复
	 * @Return -2 号段停用 -1 查询不到编码 1：成功 0：异常
	 **/
	@Transactional
	@Override
	public Integer updateBillCodeLogStatus(Integer cityId, Integer compId, Integer deptId, String codeNo, Integer type) {

		ErpFunBillCodelogExample erpFunBillCodelogExample = new ErpFunBillCodelogExample();
		erpFunBillCodelogExample.setShardCityId(cityId);
		ErpFunBillCodelogExample.Criteria criteria = erpFunBillCodelogExample.createCriteria();
		criteria.andCompIdEqualTo(compId).andCodeNoEqualTo(codeNo);

		List<ErpFunBillCodelog> codelogList = erpFunBillCodelogMapper.selectByExample(erpFunBillCodelogExample);
		if(codelogList.size() == 0) {
			return -1;
		}
		ErpFunBillCodelog erpFunBillCodelog = codelogList.get(0);
		erpFunBillCodelog.setShardCityId(cityId);
		ErpFunBillCode erpFunBillCode = new ErpFunBillCode();
		erpFunBillCode.setShardCityId(cityId);
		erpFunBillCode.setCodeId(erpFunBillCodelog.getCodeId());
		erpFunBillCode = erpFunBillCodeMapper.selectByPrimaryKey(erpFunBillCode);
		erpFunBillCode.setShardCityId(cityId);
		if(erpFunBillCode.getStatus().intValue() == 0) {
			return -2;
		}
		if(1 == type.intValue()) {
			erpFunBillCodelog.setUseStatus((byte)1);
			erpFunBillCodelogMapper.updateByPrimaryKeySelective(erpFunBillCodelog);
			Integer usedCount = erpFunBillCode.getUsedCount();
			erpFunBillCode.setUsedCount(usedCount + 1);
			erpFunBillCodeMapper.updateByPrimaryKeySelective(erpFunBillCode);
		}else if(2 == type.intValue()){
			// 判断参数 是否作废启用
			// 获取系统参数
			String erpSysParas = erpSysParaMapper.getParamValue(cityId, compId, "INVALID_BILLNO_CAN_USE_AGAIN");
			if(StringUtils.isBlank(erpSysParas) || "0".equals(erpSysParas)) {
				return 1;
			}else {
				ErpFunBillExample countExample = new ErpFunBillExample();
				countExample.setShardCityId(cityId);
				countExample.createCriteria().andCompIdEqualTo(compId).andBillNoEqualTo(codeNo).andBillStatusNotEqualTo(Byte.valueOf("2"));
				int count = erpFunBillMapper.countByExample(countExample);
				if (count==0) {
					erpFunBillCodelog.setUseStatus((byte) 0);
					erpFunBillCodelogMapper.updateByPrimaryKeySelective(erpFunBillCodelog);
					Integer usedCount = erpFunBillCode.getUsedCount();
					erpFunBillCode.setUsedCount(usedCount - 1);
					erpFunBillCodeMapper.updateByPrimaryKeySelective(erpFunBillCode);
				}
			}
		}
		return null;
	}

	private void createFunDealCodeLogList(Integer cityId, FunBillModuleParam param, String zeroStr) {
        String codePrefix = param.getCodePrefix();
        String codeStart = param.getCodeStart().substring(zeroStr.length());
        int start = Integer.valueOf(codeStart);
        String codeEnd = param.getCodeEnd();
        int end = Integer.valueOf(codeEnd);
        int codeLength = codeEnd.length();
        List<ErpFunBillCodelog> list = new ArrayList<>();
        String zeroaddStr="";
        for(int i = 0;i<=(end-start);i++){
            ErpFunBillCodelog fdclp = new ErpFunBillCodelog();
            String codeCount = String.valueOf(start+i);
            zeroaddStr="";
            for(int j=1;j<=(codeLength-codeCount.length());j++){
                zeroaddStr+="0";
            }
            fdclp.setCodeId(param.getCodeId());
            fdclp.setCodeNo(codePrefix+zeroaddStr+(start+i));
            fdclp.setCodeCount(start+i);
            fdclp.setCodePrefix(codePrefix);
            fdclp.setCompId(param.getCompId());
            fdclp.setDeptId(param.getDeptId());
            fdclp.setUseStatus((byte)0);
			fdclp.setOrganizationId(param.getOrganizationId());
            list.add(fdclp);
        }

        while (list.size() > 0) {
			List<ErpFunBillCodelog> erpFunBillCodelogs;
			if(list.size() > 200) {
				erpFunBillCodelogs = list.subList(0, 200);
			}else {
				erpFunBillCodelogs = list;
			}
			erpFunBillCodelogMapper.insertBatch(cityId, erpFunBillCodelogs);
			list.removeAll(erpFunBillCodelogs);
		}

    }

	/**
	 * 判断编号是否重复
	 */
	@Override
	public Integer judgeBillCodeLogIsReapt(Integer cityId, Integer compId, Integer deptId, Byte billType, Byte billWay,
			Integer billCodeId, List<Integer> fianacIds, String billNo ) {
		Integer result = 0;
		//诚意金、合同票据号分开判重 1是0否
		String earbestDealBillRepeat = erpSysParaMapper.getParamValue(cityId, compId, "EARBEST_DEAL_BILL_REPEAT");
		//作废的合同,诚意金票据可以重新使用 1是0否
		String invalidBillNoCanUseAgain = erpSysParaMapper.getParamValue(cityId, compId, "INVALID_BILLNO_CAN_USE_AGAIN");
		ErpFunBillExample example = new ErpFunBillExample();
		example.setShardCityId(cityId);
		Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if ("1".equals(earbestDealBillRepeat)) {
			if (Byte.valueOf("0").equals(billType)) {
				criteria.andBillTypeEqualTo(billType);
			} else {
				criteria.andBillTypeNotEqualTo(Byte.valueOf("0"));
			}
		}
		if ("1".equals(invalidBillNoCanUseAgain)) {
			criteria.andBillStatusNotEqualTo(Byte.valueOf("2"));
		}
		criteria.andBillNoEqualTo(billNo);
		if (fianacIds!=null) {
			criteria.andFianacIdNotIn(fianacIds);
		}
		result = erpFunBillMapper.countByExample(example);
		return result;
	}


	public static void main(String[] args) {
		List<Integer> resList = new ArrayList<>();
		for (Integer i =0 ;i<2001;i++) {
			resList.add(i);
		}

		while (resList.size() > 0) {
			System.out.println(resList.size());
			List<Integer> erpFunBillCodelogs;
			if(resList.size() > 1500) {
				erpFunBillCodelogs = resList.subList(0, 1500);
			}else {
				erpFunBillCodelogs = resList;
			}
			resList.removeAll(erpFunBillCodelogs);
		}
	}
}
