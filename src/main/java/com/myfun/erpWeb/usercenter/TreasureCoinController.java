package com.myfun.erpWeb.usercenter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.usercenter.vo.TreasureCoinRankingVo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 夺宝币相关接口
 * @author 张宏利
 * @since 2017年3月21日
 */
@Api(tags ="夺宝币模块")
@Controller
@RequestMapping("/usercenter/treasureCoin")
public class TreasureCoinController extends BaseController{
	
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private CacheUtil cacheUtil;
	
	/**
	 * 获取夺宝币排行榜
	 * @author 张宏利
	 * @since 2017年4月6日
	 * @param param
	 * @return
	 */
	@ApiOperation("获取夺宝币排行榜")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = TreasureCoinRankingVo.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/getTreasureCoinRanking")
	public ErpResponseJson getTreasureCoinRanking(@Valid @RequestBody BaseMapParam param) {
		List<AdminFunArchiveDto> archiveList = (List<AdminFunArchiveDto>) cacheUtil.get(Const.CacheStructure.treasureCoin_Ranking_Last);
		if(archiveList == null || archiveList.isEmpty()) {
			archiveList = adminFunArchiveMapper.getTreasureCoinRanking();
			for (int i = 0; i < archiveList.size(); i++) {
				archiveList.get(i).setCoinRanking(i+1);
			}
			cacheUtil.put(Const.CacheStructure.treasureCoin_Ranking_Last, archiveList, 60*10);
		}
		Map<Integer, AdminFunArchiveDto> oldMap = (Map<Integer, AdminFunArchiveDto>) cacheUtil.get(Const.CacheStructure.treasureCoin_Ranking_Old);
		if(oldMap == null) {
			oldMap = new HashMap<>();
			for (AdminFunArchiveDto adminFunArchive : archiveList) {
				oldMap.put(adminFunArchive.getArchiveId(), adminFunArchive);
			}
			if(!oldMap.isEmpty()) {
				// 放入缓存，10分钟
			    cacheUtil.put(Const.CacheStructure.treasureCoin_Ranking_Old, oldMap, 60*30);
			}
			// 之前没有缓存时清空，让下面找不到对比对象，然后就是上升状态
			oldMap.clear();
		}
		for (AdminFunArchiveDto adminFunArchiveDto : archiveList) {
			AdminFunArchiveDto oldDto = oldMap.get(adminFunArchiveDto.getArchiveId());
			// 上期排名
			if(oldDto != null) {
				if(oldDto.getCoinRanking() > adminFunArchiveDto.getCoinRanking()) {
					adminFunArchiveDto.setCoinRanking(1);// 上升
				} else if(oldDto.getCoinRanking() < adminFunArchiveDto.getCoinRanking()) {
					adminFunArchiveDto.setCoinRanking(2);// 下降
				} else {
					adminFunArchiveDto.setCoinRanking(3);// 持平
				}
			} else {
				adminFunArchiveDto.setCoinRanking(1);// 上升
			}
			// 头像地址
			adminFunArchiveDto.setUserPhoto(CommonUtil.getBbsPhoto(adminFunArchiveDto.getUserPhoto()));
		}
		AdminFunArchiveDto selfArchive = adminFunArchiveMapper.getSelfTreasureCoinRanking(getOperator().getArchiveId());
		List<Map<String, Object>> resultList = new LinkedList<>();
		Map<String, Object> resultMap = new HashMap<>();
		resultList.add(resultMap);
		resultMap.put("totalRanking", archiveList);
		if(selfArchive != null) {
			// 没夺宝币时排名也赋值0
			if(selfArchive.getTreasureCoin() <= 0) {
				selfArchive.setCoinRanking(0);
			}
			resultMap.put("selfRanking", selfArchive);
		}
		return ErpResponseJson.ok(resultMap);
	}
}

