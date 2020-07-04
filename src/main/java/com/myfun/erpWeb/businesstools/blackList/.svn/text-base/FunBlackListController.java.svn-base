package com.myfun.erpWeb.businesstools.blackList;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.erpWeb.businesstools.blackList.param.GetBlackListParam;
import com.myfun.erpWeb.businesstools.blackList.vo.GetBlackListVo;
import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.dao.ErpFunBlackListMapper;
import com.myfun.repository.erpdb.param.ErpFunBlackListParam;
import com.myfun.repository.erpdb.po.ErpFunBlackList;
import com.myfun.repository.support.constant.Const;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * 黑名单控制器
 * @author 臧铁
 * @since 2017年8月23日
 */
@RequestMapping(value="/businesstools/blackList",method=RequestMethod.POST)
@RestController
public class FunBlackListController  extends BaseController{
	@Autowired private ErpFunBlackListMapper erpFunBlackListMapper;
	
	/**
	 * 查询黑名单列表
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @param param keywordQuery ：关键字 电话1和电话2和名字和公司的模糊查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBlackList")
	@ApiOperation("查询黑名单列表，作者：臧铁")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = GetBlackListVo.class, message = "成功")
	})
	@ResponseBody
	public ResponseJson getBlackList(@RequestBody GetBlackListParam param) throws Exception{
		Integer cityId = getOperator().getCityId();
		Integer compId = getOperator().getCompId();
		param.setCompId(compId);
		String keywordQuery = param.getKeywordQuery();
		if (StringUtils.isNotBlank(keywordQuery)) {
			param.setKeywordQuery("%" + keywordQuery + "%");
		}
		PageHelper.startPage(param.getPageOffset(),param.getPageRows(),true);
		List<ErpFunBlackList> blackLists = erpFunBlackListMapper.getBlackList(cityId, param);
		PageInfo<ErpFunBlackList> pageInfo = new PageInfo<ErpFunBlackList>(blackLists);
		return ErpResponseJson.ok(pageInfo);
	}
	
	/**
	 * 获取黑名单详情
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("获取黑名单详情，作者：臧铁")
	@RequestMapping("/getBlackListByData")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpFunBlackList.class, message = "成功")
	})
	public ResponseJson getBlackListByData(@RequestBody ErpFunBlackListParam param) throws Exception{
		param.setShardCityId(getOperator().getCityId());
		ErpFunBlackList returnData = erpFunBlackListMapper.selectByPrimaryKey(param);
		return ErpResponseJson.ok(returnData);
	}
	
	/**
	 * 插入黑名单
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("插入黑名单，作者：臧铁")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ResponseJson.class, message = "成功")
	})
	@RequestMapping("/insertBlackList")
	public ResponseJson insertBlackList(@RequestBody ErpFunBlackListParam param) throws Exception{
		param.setCompId(getOperator().getCompId());
		param.setShardCityId(getOperator().getCityId());
		param.setCreateUid(getOperator().getUserId());
		param.setUpdateTime(new Date());
		param.setCreationTime(new Date());
		param.setKeywordQuery(param.getUserName() + "," + param.getPhone1() + "," + param.getPhone2() + "," + param.getBlackComp());
		erpFunBlackListMapper.insertSelective(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 修改黑名单
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("修改黑名单，作者：臧铁")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ResponseJson.class, message = "成功")
	})
	@RequestMapping("/editBlackList")
	public ResponseJson editBlackList(@RequestBody ErpFunBlackListParam param) throws Exception{
		param.setShardCityId(getOperator().getCityId());
		param.setUpdateTime(new Date());
		param.setKeywordQuery(param.getUserName() + "," + param.getPhone1() + "," + param.getPhone2() + "," + param.getBlackComp());
		erpFunBlackListMapper.updateById(param);
		return ErpResponseJson.ok();
	}
	
	/**
	 * 删除黑名单
	 * @author 臧铁
	 * @since 2017年8月23日
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@ApiOperation("删除黑名单，作者：臧铁")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ResponseJson.class, message = "成功")
	})
	@RequestMapping("/delBlackListById")
	public ResponseJson delEcardsById(@RequestBody ErpFunBlackListParam param) throws Exception{
		param.setShardCityId(getOperator().getCityId());
		erpFunBlackListMapper.deleteByPrimaryKey(param);
		return ErpResponseJson.ok();
	}
}
