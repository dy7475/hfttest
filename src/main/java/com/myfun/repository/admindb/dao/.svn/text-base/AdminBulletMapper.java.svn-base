package com.myfun.repository.admindb.dao;
import java.util.List;
import java.util.Map;

import com.myfun.erpWeb.bulletin.param.BulletinListParam;
import com.myfun.repository.support.annotation.AccessReadonlyDb;
import org.apache.ibatis.annotations.Param;
import com.myfun.repository.admindb.dto.AdminBulletDto;
import com.myfun.repository.admindb.param.AdminBulletParam;
import com.myfun.repository.admindb.param.BulletListParam;
import com.myfun.repository.admindb.po.AdminBullet;
import com.myfun.repository.admindb.po.AdminBulletWithBLOBs;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminBulletExample;

public interface AdminBulletMapper extends BaseMapper<AdminBullet, Integer> {
    /**
	 * @mbggenerated
	 */
	int countByExample(AdminBulletExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminBulletExample example);

	/**
	 * @mbggenerated
	 */List<AdminBullet> selectByExampleWithBLOBs(AdminBulletExample example);

	/**
	 * @mbggenerated
	 */List<AdminBullet> selectByExample(AdminBulletExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminBullet record,@Param("example") AdminBulletExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleWithBLOBs(@Param("record") AdminBullet record,@Param("example") AdminBulletExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminBullet record,@Param("example") AdminBulletExample example);

	/**
	 * @mbggenerated
	 */
	int updateByPrimaryKeyWithBLOBs(AdminBullet record);

	List<AdminBullet> getCrmBulletList(BulletListParam param);

	AdminBulletDto getBulletByBulletId(Integer bulletId);
	
	// 更新回复率
	Integer updateClearReply(Integer bulletId);

	Integer updateReplyCount(Integer bulletId);
	
	// 新增
	Integer insertAdminBullet(AdminBulletParam adminBulletParam);

	/**
	 * @TODO ERP 公告帖子查询
	 * @author lcb
	 * 
	 */
	@AccessReadonlyDb
	List<AdminBulletDto> getBulletList(BulletinListParam pMap);
	
	@AccessReadonlyDb
	List<AdminBulletDto> getBulletListNewOrg(BulletinListParam pMap);
	
	
	@AccessReadonlyDb
	Integer getBulletListCount(BulletinListParam pMap);
	
	@AccessReadonlyDb
	Integer getBulletListCountNewOrg(BulletinListParam pMap);

	/**
	 * 增加查看量
	 * @author 张宏利
	 * @since 2016年10月13日
	 * @param bulletId
	 */
	void addClick(Integer bulletId);
	
	AdminBulletWithBLOBs selectByBulletId(@Param("param")Map<String, Object> param);
	/**
	 * 发布喜报
	 * @author 熊刚
	 * @since 2017年6月30日
	 * @param cityId
	 * @param bulletIdList
	 * @param pMap
	 */
	void updateBulletByPrimaryKeys(@Param("shardCityId")Integer cityId,@Param("bulletIdList")List<String> bulletIdList,@Param("pMap")Map<String, Object> pMap);

    List<Map<String,Object>> selectBulletList(@Param("bulletIds")List<Integer> bulletIds);
}