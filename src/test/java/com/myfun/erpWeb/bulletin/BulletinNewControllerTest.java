package com.myfun.erpWeb.bulletin;

import java.util.HashMap;
import java.util.Map;

import com.myfun.erpWeb.bulletin.param.BulletBaseInfoParam;
import com.myfun.erpWeb.bulletin.param.CreateBulletParam;
import io.swagger.annotations.ApiModelProperty;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myfun.erpWeb.BaseTestController;

/**
 * 帖子相关
 * 
 * @author 张宏利
 * @since 2018年2月6日
 */
@Controller
@RequestMapping("/bulletinNew")
public class BulletinNewControllerTest extends BaseTestController {

	@Before
	public void init(){
		//init("http://192.168.5.175:8080/erpWeb", "http://172.16.140.101:8080/hftWebService/web/api/authentication/per.do", "670087", "18782920347");
		init("http://192.168.5.169:8080/erpWeb", "http://192.168.5.169:8090/hftWebService/web/api/authentication/per.do", "673247", "15211111110");

	}
	
	/**
	 * 创建公告信息
	 * @author 张宏利
	 * @since 2018年2月6日
	 * @return
	 */
	@Test
	public void createBullet() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("isvote", 0);
		param.put("showPhone", 0);
		// 发布范围，多个逗号分隔，0 本店信息 1=本公司 2=同城交流 3=经纪天地 4=商家信息 5=业务知识 7=加盟圈 8=喜报
		param.put("bounds", "0,1");
		// 附件信息，长这样：HfClear.exe,oss/online/tmp/2018/02/07/b9c1e96fb76b412f9c88cf891e123299.exe;HfClear.exe,oss/online/tmp/2018/02/07/017185eff9d34aea9a29c7bb947ef686.exe
		param.put("bulletinPs", "HfClear.exe,oss/online/tmp/2018/02/07/b9c1e96fb76b412f9c88cf891e123299.exe");
		// 标题
		param.put("bulletSubject", "测试发个帖子");
		// 内容
		param.put("bulletContent", "lalallaalallalal我是卖报的小行家！");
		System.out.println(postNewErp(param, "/bulletinNew/createBullet"));
	}

	/**
	 * 置顶帖子
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/7/9
	 */
	@Test
	public void updateBulletStick() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("bulletId", 2000864);
		param.put("stick", 0);
		System.out.println(postNewErp(param, "/bulletinNew/updateBulletStick?bulletId=2000864&stick=0"));
	}
	
	/**
	 * 获取帖子列表
	 * @author 张宏利
	 * @since 2018年2月6日
	 * @param bound 范围
	 * @param keyWord 关键字
	 * @return
	 */
	@Test
	public void getBulletinList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("pageOffset", 1);
		param.put("pageRows", 20);
		param.put("isViewStatus", 1);
		System.out.println(postNewErp(param, "/bulletinNew/getBulletinList"));
	}
	/**
	 * 获取帖子列表
	 * @author 张宏利
	 * @since 2018年2月6日
	 * @param bound 范围
	 * @param keyWord 关键字
	 * @return
	 */
	@Test
	public void getBulletinListForApp() throws Exception {
		Map<String, Object> param = new HashMap<>();
//		param.put("bound", 1);
//		param.put("keyWord", "SpringCloud");
//		param.put("bulletType", 3);
		System.out.println(postNewErp(param, "/bulletinNew/getBulletinListForApp"));
	}

	@Test
	public void getBulletinInfo() throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("bulletId", 2000864);
		System.out.println(postNewErp(param, "/bulletinNew/getBulletinInfo"));
	}

	/**
	  * 查询登陆小秘书
	  * @author 李成兵
	  * @since 2018/5/23
	  * @param
	  * @return
	  */
	@Test
	public void getMsgList() throws Exception {
		Map<String, Object> param = new HashMap<>();
		System.out.println(postNewErp(param, "/bulletinNew/getMsgList"));
	}

	/**
	 * app端发公告测试
	 * @throws Exception
	 */
	@Test
	public void createBulletNew() throws Exception{
		CreateBulletParam param = new CreateBulletParam();
		param.setIsvote(0);
		param.setShowPhone(0);
		param.setBounds(0);
		param.setReplyStatus((byte)0);
		param.setStick(false);
		param.setBulletinPs("附件信息");
		param.setBulletType((byte)1);
        param.setBulletSubject("恭喜张无忌成功签单500万第二次");
        param.setBulletContent("建发鹭洲里，张无忌11.20号成功签单，让我们恭喜他！！");

		System.out.println(postNewErp(param, "bulletinNew/app/createBullet"));
	}

	/**
	 * app端修改公告测试
	 * @throws Exception
	 */
	@Test
	public void updateBulletNew() throws Exception{
		CreateBulletParam param = new CreateBulletParam();
		param.setBulletId(2001121);
		param.setIsvote(0);
		param.setShowPhone(0);
		param.setBounds(0);
		param.setReplyStatus((byte)0);
		param.setStick(true);
		param.setBulletinPs("附件信息");
		param.setBulletType((byte)2);
		param.setBulletSubject("恭喜张无忌成功签单500万");
		param.setBulletContent("恭喜张无忌成功签单！！！");

		System.out.println(postNewErp(param, "bulletinNew/app/createBullet"));
	}

	/**
	 * app端修改公告基础信息测试（删除、置顶、开启评论）
	 * @throws Exception
	 */
	@Test
	public void updateBulletBaseInfo() throws Exception{
		BulletBaseInfoParam param = new BulletBaseInfoParam();
		param.setIsDelete(null);
		param.setBulletId(2001111);
		param.setStick(null);
		param.setReplyStatus(1);
		System.out.println(postNewErp(param, "bulletinNew/app/updateBulletBaseInfo"));
	}

}

