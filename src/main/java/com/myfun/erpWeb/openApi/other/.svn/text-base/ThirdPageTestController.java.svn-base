package com.myfun.erpWeb.openApi.other;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeExtMapper;
import com.myfun.repository.erpdb.dao.ErpFunPerformanceTypeMapper;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExample;
import com.myfun.repository.erpdb.po.ErpFunPerformanceTypeExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.framework.web.controller.BaseController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 其他测试的一些控制器
 * @author 张宏利
 * @since 2017年4月17日
 */
@Controller
@RequestMapping(value = "/openApi/test")
public class ThirdPageTestController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ThirdPageTestController.class);
	@Autowired
	private AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired
	private ErpFunPerformanceTypeMapper erpFunPerformanceTypeMapper;
	@Autowired
	private ErpFunPerformanceTypeExtMapper erpFunPerformanceTypeExtMapper;
	/**
	 * 知页测试页面
	 * @author 张宏利
	 * @since 2017年5月11日
	 * @return
	 */
	@RequestMapping(value = "/zhiyePageTest")
	public String uploadFileTest() {
		return "openApi/other/zhiyePageTest";
	}

	@RequestMapping(value = "/initializeTheCommissioningConfiguration")
	@Transactional
	public ResponseJson initializeTheCommissioningConfiguration() {
		List<String> datasourceNameGroupBy = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		for (String dbName : datasourceNameGroupBy) {
			PageInfo<Integer> pageInfo = initDataPage(1, dbName);
			if(!pageInfo.getList().isEmpty()){
				initData(pageInfo.getList(),dbName);
				while(pageInfo.isHasNextPage()){
					pageInfo = initDataPage(pageInfo.getNextPage(),dbName);
					if (!pageInfo.getList().isEmpty()) {
						initData(pageInfo.getList(),dbName);
					}
				}
			}
		}
		return ErpResponseJson.ok();
	}

	@RequestMapping(value = "/initializeTheCommissioningConfigurationNew")
	@Transactional
	public ResponseJson initializeTheCommissioningConfigurationNew() {
		List<String> datasourceNameGroupBy = adminFunDatasourceConfigMapper.getDatasourceNameGroupBy();
		for (String dbName : datasourceNameGroupBy) {
			PageInfo<Integer> pageInfo = initDataPage(1, dbName);
			if(!pageInfo.getList().isEmpty()){
				initDataNew(pageInfo.getList(),dbName);
				while(pageInfo.isHasNextPage()){
					pageInfo = initDataPage(pageInfo.getNextPage(),dbName);
					if (!pageInfo.getList().isEmpty()) {
						initDataNew(pageInfo.getList(),dbName);
					}
				}
			}
		}
		return ErpResponseJson.ok();
	}

	private void initDataNew(List<Integer> list, String dbName){
		for (Integer compId : list) {
			erpFunPerformanceTypeMapper.insertFunPerforManceTypeForInit(dbName,compId);
		}
	}

	private void initData(List<Integer> list, String dbName){
		Date date = new Date();
		for (Integer compId : list) {
			ErpFunPerformanceTypeExample erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
			erpFunPerformanceTypeExample.setShardDbName(dbName);
			erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo((byte)2).andCommissionTypeEqualTo((byte)1)
					.andPerformanceNameEqualTo("钥匙提交人");
			ErpFunPerformanceType keyAuthor = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
			if(keyAuthor==null){
				keyAuthor = new ErpFunPerformanceType();
				keyAuthor.setShardDbName(dbName);
				keyAuthor.setEnMsg("KEY");
				keyAuthor.setPerformanceName("钥匙提交人");
				keyAuthor.setIsAuto((byte)1);
				keyAuthor.setCompId(compId);
				keyAuthor.setCreateTime(date);
				keyAuthor.setIsDel((byte)0);
				keyAuthor.setCanDel(0);
				keyAuthor.setCollectionType((byte)2);
				keyAuthor.setCommissionType((byte)1);
				keyAuthor.setAlias("钥匙");
				keyAuthor.setPerformanceProportion(new BigDecimal(5));
				erpFunPerformanceTypeMapper.insertSelective(keyAuthor);
			}
			erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
			erpFunPerformanceTypeExample.setShardDbName(dbName);
			erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo((byte)2).andCommissionTypeEqualTo((byte)2)
					.andPerformanceNameEqualTo("房源议价人");
			ErpFunPerformanceType bargainer = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
			if(bargainer==null){
				bargainer = new ErpFunPerformanceType();
				bargainer.setShardDbName(dbName);
				bargainer.setEnMsg("YIJIA");
				bargainer.setPerformanceName("房源议价人");
				bargainer.setIsAuto((byte)1);
				bargainer.setCompId(compId);
				bargainer.setCreateTime(date);
				bargainer.setIsDel((byte)0);
				bargainer.setCanDel(2);
				bargainer.setCollectionType((byte)2);
				bargainer.setCommissionType((byte)2);
				bargainer.setAlias("促成");
				bargainer.setPerformanceProportion(new BigDecimal(25));
				erpFunPerformanceTypeMapper.insertSelective(bargainer);
			}
			erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
			erpFunPerformanceTypeExample.setShardDbName(dbName);
			erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo((byte)2).andCommissionTypeEqualTo((byte)1)
					.andPerformanceNameEqualTo("独家委托");
			ErpFunPerformanceType exclusiveCommission = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);
			erpFunPerformanceTypeExample = new ErpFunPerformanceTypeExample();
			erpFunPerformanceTypeExample.setShardDbName(dbName);
			erpFunPerformanceTypeExample.createCriteria().andCompIdEqualTo(compId).andCollectionTypeEqualTo((byte)2).andCommissionTypeEqualTo((byte)1)
					.andPerformanceNameEqualTo("限时委托");
			ErpFunPerformanceType limitedTimeCommission = erpFunPerformanceTypeMapper.selectOneByExample(erpFunPerformanceTypeExample);

			//独家委托超出部分从钥匙拆分5%；客源促成拆分10%
			ErpFunPerformanceTypeExt erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
			erpFunPerformanceTypeExt.setShardDbName(dbName);
			erpFunPerformanceTypeExt.setPerformanceId(exclusiveCommission.getPerformanceId());
			erpFunPerformanceTypeExt.setCompId(compId);
			erpFunPerformanceTypeExt.setExtType((byte)2);
			erpFunPerformanceTypeExt.setTargetPerformanceId(keyAuthor.getPerformanceId());
			erpFunPerformanceTypeExt.setIdDel((byte)0);
			erpFunPerformanceTypeExt.setPerformanceProportion(new BigDecimal(5));
			erpFunPerformanceTypeExt.setCreateTime(date);
			erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
			erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
			erpFunPerformanceTypeExt.setShardDbName(dbName);
			erpFunPerformanceTypeExt.setPerformanceId(exclusiveCommission.getPerformanceId());
			erpFunPerformanceTypeExt.setCompId(compId);
			erpFunPerformanceTypeExt.setExtType((byte)2);
			erpFunPerformanceTypeExt.setTargetPerformanceId(bargainer.getPerformanceId());
			erpFunPerformanceTypeExt.setIdDel((byte)0);
			erpFunPerformanceTypeExt.setPerformanceProportion(new BigDecimal(10));
			erpFunPerformanceTypeExt.setCreateTime(date);
			erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
			//限时委托超出部分从钥匙拆分5%；客源促成拆分10%
			erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
			erpFunPerformanceTypeExt.setShardDbName(dbName);
			erpFunPerformanceTypeExt.setPerformanceId(limitedTimeCommission.getPerformanceId());
			erpFunPerformanceTypeExt.setCompId(compId);
			erpFunPerformanceTypeExt.setExtType((byte)2);
			erpFunPerformanceTypeExt.setTargetPerformanceId(keyAuthor.getPerformanceId());
			erpFunPerformanceTypeExt.setIdDel((byte)0);
			erpFunPerformanceTypeExt.setPerformanceProportion(new BigDecimal(5));
			erpFunPerformanceTypeExt.setCreateTime(date);
			erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
			erpFunPerformanceTypeExt = new ErpFunPerformanceTypeExt();
			erpFunPerformanceTypeExt.setShardDbName(dbName);
			erpFunPerformanceTypeExt.setPerformanceId(limitedTimeCommission.getPerformanceId());
			erpFunPerformanceTypeExt.setCompId(compId);
			erpFunPerformanceTypeExt.setExtType((byte)2);
			erpFunPerformanceTypeExt.setTargetPerformanceId(bargainer.getPerformanceId());
			erpFunPerformanceTypeExt.setIdDel((byte)0);
			erpFunPerformanceTypeExt.setPerformanceProportion(new BigDecimal(10));
			erpFunPerformanceTypeExt.setCreateTime(date);
			erpFunPerformanceTypeExtMapper.insertSelective(erpFunPerformanceTypeExt);
		}
	};

	private PageInfo<Integer> initDataPage(Integer pageNum, String dbName){
		PageHelper.startPage(pageNum, 20, true);
		List<Integer> allCompId = erpFunPerformanceTypeMapper.getAllCompId(dbName);
		return new PageInfo<Integer>(allCompId);
	}
}

