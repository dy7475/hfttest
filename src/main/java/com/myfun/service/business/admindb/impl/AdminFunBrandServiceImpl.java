package com.myfun.service.business.admindb.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dao.AdminFunBrandCityMapper;
import com.myfun.repository.admindb.dao.AdminFunBrandMapper;
import com.myfun.repository.admindb.dao.AdminFunWebtransInfoMapper;
import com.myfun.repository.admindb.dto.AdminFunBrandCityDto;
import com.myfun.repository.admindb.dto.AdminFunBrandDto;
import com.myfun.repository.admindb.param.AdminFunBrandParam;
import com.myfun.repository.admindb.param.FunBrandCityOrderParam;
import com.myfun.repository.admindb.po.AdminFunBrand;
import com.myfun.repository.admindb.po.AdminFunBrandCity;
import com.myfun.repository.admindb.po.AdminFunWebtransInfo;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunBrandService;
import com.myfun.utils.StringUtil;

/**
 * 经纪人挖掘
 * @author lcb
 *
 */
@Service
public class AdminFunBrandServiceImpl extends AbstractService<AdminFunBrand, Integer> implements AdminFunBrandService {
	@Autowired
	private AdminFunBrandMapper adminFunBrandMapper;
	@Autowired
	private AdminFunBrandCityMapper adminFunBrandCityMapper;
	@Autowired
	private AdminFunWebtransInfoMapper adminFunWebtransInfoMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminFunBrandMapper;
	}
	
	/**
	 * @Title: enclosing_method 
	 * @Description: 经纪人挖掘列表
	 * @param tags
	 * @return return_type    返回类型 
	 * @throws 
	 * @author lcb
	 */
	@Override
	public PageInfo<AdminFunBrand> getAdminFunBrandShowList(AdminFunBrandParam adminFunBrandParam) {
		PageHelper.startPage(adminFunBrandParam.getPageNum(), adminFunBrandParam.getPageSize(), true);
		List<AdminFunBrand> resList = adminFunBrandMapper.getAdminFunBrandList(adminFunBrandParam);
		return new PageInfo<>(resList);
	}

	@Transactional
	@Override
	public Integer updateFunbrand(AdminFunBrand funBrand, String selectIds) {
		Integer res = 0;
		res = adminFunBrandMapper.updateByPrimaryKeySelective(funBrand);
		if(!StringUtil.isBlank(selectIds)) {
			// 把数据查询出来
			List<String> cityIds = Arrays.asList(selectIds.split(","));
			if(null != cityIds && cityIds.size() > 0) {
				//将全部城市下线
				Map<String, Object> paramMap2 = new HashMap<>();
				paramMap2.put("brandId", funBrand.getBrandId());
				paramMap2.put("cityIds", selectIds);
				paramMap2.put("updateTime", new Date());
				Integer res2 = adminFunBrandCityMapper.updateFunBrandCityToOff(paramMap2);
				// 写修改日志
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("brandId", funBrand.getBrandId());
				paramMap.put("cityIds", selectIds);
				List<AdminFunBrandCity> resList = adminFunBrandCityMapper.getFunBrandCityByCityIds(paramMap);
				List<String> newCityId = new ArrayList<>();
				// 遍历新增数据
				if(resList.size() > 0) {
					for (String cityId : cityIds) {
						for (AdminFunBrandCity adminFunBrandCity : resList) {
							if(!cityId.equals(adminFunBrandCity.getCityId().toString())) {
								newCityId.add(cityId);
							}
						}
					}
				}else{
					newCityId.addAll(cityIds);
				}
				if(newCityId.size() > 0) {
					for (String city : newCityId) {
						AdminFunBrandCity afbc = new AdminFunBrandCity();
						afbc.setBrandId(funBrand.getBrandId());
						afbc.setCityId(Integer.parseInt(city));
						afbc.setOnlineFlag(new Short("1"));					
						afbc.setUpdateTime(new Date());
						adminFunBrandCityMapper.insertSelective(afbc);
						// 写新增日志
						addFunWebTransInfo("FUN_BRAND_CITY" , funBrand.getBrandId() + "" , 1, Integer.parseInt(city));
					}
				}
			}
		}
		return res;
	}
	
	@Override
	public AdminFunBrand getAdminFunBrandById(Integer brandId) {
		// TODO Auto-generated method stub
		return adminFunBrandMapper.selectByPrimaryKey(brandId);
	}

	/**
	 * 根据品牌id查询城市
	 * **/
	@Override
	public List<AdminFunBrandCityDto> getFunBrandCityByBrandId(Integer brandId) {
		// 根据
		return adminFunBrandCityMapper.getAdminFunBrandCityByBrandId(brandId);
	}

	@Transactional
	@Override
	public Integer insertFunBrand(AdminFunBrand adminFunBrand, String cityIds) {
		Integer res  = adminFunBrandMapper.insertSelective(adminFunBrand);
		if(res > 0) {
			// 写入多条记录
			addFunBrandCity(cityIds, adminFunBrand.getBrandId());
			addFunWebTransInfo("FUN_BRAND",adminFunBrand.getBrandId() + "", 0, null);
		}
		return res;
	}
	
	/**
	 * 添加跟进日志
	 * **/
	private void addFunWebTransInfo(String tbName, String brandId, Integer dealType, Integer cityId) {
		AdminFunWebtransInfo afwi = new AdminFunWebtransInfo();
		afwi.setProcessFlag(0);
		afwi.setCreationTime(new Date());
		afwi.setCaseId(brandId);
		afwi.setDealType(dealType);
		afwi.setCityId(cityId);
		afwi.setDbName("hft_admindb");
		afwi.setTableName(tbName);
		adminFunWebtransInfoMapper.insertSelective(afwi);
	}
	
	
	/**
	 * 添加城市信息
	 * **/
	private void addFunBrandCity(String cityIds, Integer brandId) {
		String[] ids = cityIds.split(",");
		if(null != ids && ids.length > 0) {
			AdminFunBrandCity abc = null;
			Date nowDate = new Date();
			for (String cityId : ids) {
				abc = new AdminFunBrandCity();
				abc.setBrandId(brandId);
				abc.setCityId(Integer.parseInt(cityId));
				abc.setOnlineFlag(new Short("1"));
				abc.setUpdateTime(nowDate);
				adminFunBrandCityMapper.insertSelective(abc);
			}
		}
	}

	@Override
	public PageInfo<AdminFunBrandDto> getAdminFunBrandCityOrder(FunBrandCityOrderParam brandCityOrderParam) {
		PageHelper.startPage(brandCityOrderParam.getPageNum(), brandCityOrderParam.getPageSize(), true);
		List<AdminFunBrandDto> resList = adminFunBrandMapper.getAdminFunBrandCityOrder(brandCityOrderParam.getCityId());
		return new PageInfo<>(resList);
	}

	/**
	 * 更新排序
	 * **/
	@Transactional
	@Override
	public Integer updateFunBrandCityOrder(String paramString) {
		String[] seqStrArr = paramString.split("#");
		Integer res = 0;
		if(seqStrArr.length > 0) {
			Date nowDate = new Date();
			for(int i = 0;i<seqStrArr.length;i++){
				String[] seqStr = seqStrArr[i].split(",");
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("brandId", seqStr[1]);
				paramMap.put("cityId", seqStr[2]);
				paramMap.put("seqNo", seqStr[0].equals("")?null:seqStr[0]);
				paramMap.put("updateTime", nowDate);
				res = adminFunBrandCityMapper.updateAdminFunBrandCity(paramMap);
				Map<String, Object> pMap = new HashMap<>();
				pMap.put("brandId", seqStr[1]);
				pMap.put("cityId", seqStr[2]);
				AdminFunBrandCity afbc = adminFunBrandCityMapper.getFunBrandCityByCityIdAndBrandId(paramMap);
				if(null != afbc) {
					addFunWebTransInfo("FUN_BRAND_CITY", afbc.getBcId() + "", 1, Integer.parseInt(seqStr[2]));
				}
			}
		}
		return res;
	}
	
}
