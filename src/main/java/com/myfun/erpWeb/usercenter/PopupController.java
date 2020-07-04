package com.myfun.erpWeb.usercenter;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myfun.framework.web.controller.BaseController;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.po.AdminSysPara;
import com.myfun.repository.erpdb.dao.ErpFunPrologsMapper;
import com.myfun.service.business.admindb.AdminFunBuildAuditPushService;
import com.myfun.service.business.admindb.AdminSysParaService;
import com.myfun.service.business.erpdb.ErpFunPrologsService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;

/**
 * 获取首页弹窗
 * @author 何传强
 * @since 2017年6月27日
 */
@Controller
@RequestMapping("/usercenter")
public class PopupController extends BaseController{
	
	@Autowired
	private AdminFunBuildAuditPushService adminFunBuildAuditPushService;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private ErpFunPrologsMapper erpFunPrologsMapper;
	
	/**
	 * 首页获取弹窗页面
	 * @author 何传强
	 * @since 2017年6月27日
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/getSecFirstShowAD")
	public ErpResponseJson getSecFirstShowAD() throws Exception{
		List<Map<String, String>> list=new ArrayList<Map<String, String>>();
		Map<String, String> tmp = new HashMap<String, String>();
		tmp.put("width", "767");
		tmp.put("height", "532");
		//开通 腾讯站点的才做一下的弹窗
		if(Constants_DIC.DIC_QQ_PUBLISH_SITE_ONLINE_INT.equals(getOperator().getQQPublish())
				&&adminFunBuildAuditPushService.pushWindowShow(getOperator().getArchiveId())){
			tmp.put("action", "indexPush");
			tmp.put("flag", "1");//FLAG 等于0 不弹窗  1要弹窗
		}else{
			Map<String, String> resultMap = commonShowAd();
			tmp.put("action", "indexTuiguang");// treasureCoin、indexTuiguang:首页网页广告，暂时是夺宝币广告
			tmp.put("flag", resultMap.get("flag"));//FLAG 等于0 不弹窗  1要弹窗
			tmp.put("zhiye", resultMap.get("zhiYe"));//知业 0=不弹 1=要弹 
		}
		//分享功能的链接
		String sinaWeiboUrl = "http://service.weibo.com/share/share.php?type=button&language=zh_cn&appkey=2854803066&searchPic=false&style=simple&title=#TITLE#&pic=#PIC#&url=#URL#";
		String qqWeiboUrl = "http://share.v.t.qq.com/index.php?c=share&a=index&appkey=801244520&title=#TITLE#&pic=#PIC#&url=#URL#";
		String qqZoneUrl = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?url=#URL#&pics=#PIC#&title=#TITLE#&summary=#DESC#";
		String qqpengyouUrl = "http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?to=pengyou&url=#URL#&pics=#PIC#&title=#TITLE#&summary=#DESC#";
		tmp.put("sinaweibo", replaceUrl(sinaWeiboUrl));
		tmp.put("qqweibo", replaceUrl(qqWeiboUrl));
		tmp.put("qqzone", replaceUrl(qqZoneUrl));
		tmp.put("qqpengyou", replaceUrl(qqpengyouUrl));
		list.add(tmp);
		return ErpResponseJson.ok(list);
	}
	
	/**
	 * 普通的弹窗广告
	 * @author 何传强
	 * @since 2017年6月27日
	 * @return
	 * @throws Exception 
	 */
	private Map<String, String> commonShowAd() throws Exception{
		HashMap<String, String> resultMap = new HashMap<>();
		String[] paramIds = new String[] { 
				"INDEX_PAGE_AD_FLAG", "INDEX_PAGE_AD_FLAG_SOFTVER", "INDEX_PAGE_AD_ENDTIME",
				"ZHIYE_AD_SHOW"
		};
		List<AdminSysPara> adminSysParas = adminSysParaMapper.getAdminSysPara(paramIds);
		Map<String, String> adminSysPara = new HashMap<>();
		for (AdminSysPara adminSysPa : adminSysParas) {
			adminSysPara.put(adminSysPa.getParamId(), adminSysPa.getParamValue());
		}
		String viewCityFlag = adminSysPara.get("INDEX_PAGE_AD_FLAG");
		String softVer = adminSysPara.get("INDEX_PAGE_AD_FLAG_SOFTVER");// 弹窗的版本-ALL：全部、ERP：门店版、PER：精英版
		String endTime = adminSysPara.get("INDEX_PAGE_AD_ENDTIME");// 广告停止展示结束的时间
		String zhiYe = adminSysPara.get("ZHIYE_AD_SHOW");// 知业弹窗 0=不弹 1=每次登陆弹 2=首次登陆弹
		if (StringUtils.isEmpty(viewCityFlag)) {
			resultMap.put("flag", "0");
		} else if ("-1".equals(viewCityFlag)) {
			resultMap.put("flag", "0");
		} else if ("0".equals(viewCityFlag)) {// 所有城市都开放
			resultMap.put("flag", "1");
		} else {
			// 分城市控制的
			String[] viewCitys = viewCityFlag.split("#");
			for (String viewCityId : viewCitys) {
				// 等于当前城市
				if (viewCityId.equals(getOperator().getCityId().toString())) {
					resultMap.put("flag", "1");
					break;
				}
			}
		}
		if(resultMap.get("flag").equals("1")){
			if(getOperator().isPersonalVersion() && "ERP".equals(softVer)){
				resultMap.put("flag", "0");
			}else if(!getOperator().isPersonalVersion() && "PER".equals(softVer)){
				resultMap.put("flag", "0");
			}
		}
		//每人每天之弹出一次
		Integer compId = getOperator().getCompId();
		Integer userId = getOperator().getUserId();
		Integer cityId = getOperator().getCityId();
		// 年月日的格式，查询当天的
		String dateStr = DateTimeHelper.formatDatetoString(new Date());
		int todayLoginCount = erpFunPrologsMapper.countModelData(cityId, DateTimeHelper.parseToDate(dateStr), compId, userId);
		// 0:表示不限制结束时间
		if (!"0".equals(endTime)) {
			if (todayLoginCount > 1) {
				resultMap.put("flag", "0");
			}
			// 当前的系统时间大于广告弹窗时间时，结束弹窗广告！
			if ("1".equals(resultMap.get("flag")) && DateTimeHelper.getSystemTime() > DateTimeHelper.parseToDate(endTime, "yyyy-MM-dd HH:mm").getTime()) {
				resultMap.put("flag", "0");
			}
		}
		resultMap.put("zhiYe", zhiYe);
		if ("2".equals(zhiYe)) {// 首次登陆弹
			if (todayLoginCount > 1) {// 不是首次登陆
				resultMap.put("zhiYe", "0");// 不弹
			} else {
				resultMap.put("zhiYe", "1");
			}
		}
		return resultMap;
	}
	
	/**
	 * 地址替换
	 * @param url
	 * @return
	 */
	private String replaceUrl(String url) {
		String urlRoot = "http://b.haofang.net";
		String desc = "太好用了！大福利！经纪人最好用的APP“掌上好房通”腾讯好房通联合出品的免费下载啦！";
		String title = "猛戳链接b.haofang.net";
		String pic = "http://erp1.myfun7.com/hftWebService/indexTuiguang/share/hft_share_page.jpg";
		try {
			url = url.replace("#URL#", URLEncoder.encode(urlRoot,"UTF-8"));
			url = url.replace("#DESC#", URLEncoder.encode(desc,"UTF-8"));
			url = url.replace("#TITLE#", URLEncoder.encode(title,"UTF-8"));
			url = url.replace("#PIC#", URLEncoder.encode(pic,"UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
}
