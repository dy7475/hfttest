package com.myfun.erpWeb.house;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.myfun.erpWeb.house.vo.AddCaseFavoriteVo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.session.Operator;
import com.myfun.framework.web.aspect.NotBlank;
import com.myfun.repository.erpdb.dao.ErpFunCaseFavoriteMapper;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.AlertUtil;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.framework.web.json.ResponseJson;
import com.myfun.repository.erpdb.param.CaseFavoriteParam;
import com.myfun.service.business.admindb.AdminCompGiftCoinRecordService;
import com.myfun.service.business.erpdb.ErpFunCaseFavoriteService;

/**
 * 房源收藏控制器
 */
@Api(tags ="房源收藏控制器")
@Controller
@RequestMapping(value="/house",method= RequestMethod.POST)
public class CaseFavoriteController extends BaseController{
	
	@Autowired
	private ErpFunCaseFavoriteService erpFunCaseFavoriteService;
	@Autowired
	private ErpFunCaseFavoriteMapper erpFunCaseFavoriteMapper;
	@Autowired
	private AdminCompGiftCoinRecordService adminCompGiftCoinRecordService;
	
	
	/**
	 * 添加收藏房客源
	 * @author 臧铁
	 * @since 2017年5月9日
	 * @return
	 */
	@ApiOperation("添加收藏房客源")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = AddCaseFavoriteVo.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/addCaseFavorite")
	@NotBlank({"caseId"})
	public ResponseJson addCaseFavorite(@Valid @RequestBody CaseFavoriteParam param) {
		Operator operator = getOperator();
		Integer currentUserId = operator.getUserId();
		Integer cityId = operator.getCityId();
		Integer compId = operator.getCompId();
        Integer maxFavoriteCount = 5;
        String isUserRight = "1";
        int remain = -1;
        int count = 0;
        Integer caseType = param.getCaseType().intValue();
//        if (!isUserRight.equals(operator.getUserRight())){
//            count = erpFunCaseFavoriteMapper.countByUserId(compId,cityId,currentUserId,caseType);
//            if (count >= maxFavoriteCount){
//            	String alterMsg = adminCompGiftCoinRecordService.getAlterMsg(operator.getCompType(), operator.getCompNo(), operator.getDeptNo());
//				throw new BusinessException("收藏条数已经用完！请先实名认证！", Const.ResponseErrorCode.USER_VALIDATE, AlertUtil.realNameAuthenticationAlert("收藏数据，轻松快捷查看","您只可收藏5条数据，实名认证通过后即可收藏海量数据，实时轻松快捷查看" + (StringUtil.isNotBlank(alterMsg) ? "，" + alterMsg : alterMsg)));
//            }else {
//                remain = maxFavoriteCount - count;
//            }
//        }
		param.setCityId(getOperator().getCityId());
		param.setCompId(getOperator().getCompId());
		param.setFavoriteUid(getOperator().getUserId());
		Integer favoriteId = erpFunCaseFavoriteService.insertFunCaseFavorite(param);
		List<Map<String, Object>> resultList = new LinkedList<>();
		Map<String, Object> resultMap = new HashMap<>(1);
		resultMap.put("favoriteId", favoriteId);
        //放入返回对象里面
        if (remain != -1){
            resultMap.put("remain", remain - 1);
        }
		resultList.add(resultMap);
		return new ErpResponseJson(resultList);
	}

	/**
	 * 删除收藏房客源
	 * @author 臧铁
	 * @since 2017年5月9日
	 * @return
	 */
	@ApiOperation("删除收藏房客源")
	@ApiResponses(value = {
			@ApiResponse(code = Const.ResponseCode.SUCCESS, response = ErpResponseJson.class, message = "成功")
	})
	@ResponseBody
	@RequestMapping("/delCaseFavorite")
	public ResponseJson delCaseFavorite(@Valid @RequestBody CaseFavoriteParam param) throws Exception {
		param.setCityId(getOperator().getCityId());
		erpFunCaseFavoriteService.delCaseFavorite(param);
		return ErpResponseJson.ok();
	}

}
