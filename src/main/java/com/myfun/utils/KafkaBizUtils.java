package com.myfun.utils;

import com.alibaba.fastjson.JSONObject;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.util.SpringContextUtil;
import com.myfun.repository.support.constant.Const;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * lcb
 * **/
public class KafkaBizUtils {

	/***
	 * 房源同步出售
	 */
	private static final LinkedBlockingQueue<JSONObject> ERP_FUN_SALE_TOPIC = new LinkedBlockingQueue<JSONObject>();
	
	
	/***
	 * 房源同步出租
	 */
	private static final LinkedBlockingQueue<JSONObject> ERP_FUN_LEASE_TOPIC = new LinkedBlockingQueue<JSONObject>();

	/***
	 * 超时通知
	 */
	private static final LinkedBlockingQueue<JSONObject> REQUEST_TIME_OUT = new LinkedBlockingQueue<>();

	/**
	 * 消息推送
	 */
	private static final LinkedBlockingQueue<JSONObject> PUSH_MSG_BLOCKING_QUERY = new LinkedBlockingQueue<JSONObject>();

	/***
	 * 栋座,单元生成房间
	 */
	private static final LinkedBlockingQueue<JSONObject> ERP_BUILDING_SET_ROOF_TOPIC = new LinkedBlockingQueue<>();

	/***
	 * 客源同步出售
	 */
	private static final ArrayBlockingQueue<JSONObject> ERP_FUN_BUY_TOPIC = new ArrayBlockingQueue<JSONObject>(1000);

	/***
	 * 客源同步出售
	 */
	private static final ArrayBlockingQueue<JSONObject> ERP_FUN_RENT_TOPIC = new ArrayBlockingQueue<JSONObject>(1000);
	
	/***
	 * 楼盘图片
	 */
	private static final LinkedBlockingQueue<JSONObject> ERP_BUILD_PHOTO_TOPIC = new LinkedBlockingQueue<JSONObject>(1000);
	
	
	public void initKafkaThread() {
		new KafkaErpFunSaleSysncTopicThread().start();
		new KafkaErpFunLeaseSysncTopicThread().start();
		new KafkaRequestTimeOutTopicThread().start();
		new KafkaErpBuildingSetRoofSysncTopicThread().start();
		new PushMsgThread().start();
		new KafkaRentCustSysncTopicThread().start();
		new KafkaBuyCustSysncTopicThread().start();
		new KafkaBuildPhotoSysncTopicThread().start();
	}

	/**
	 * 
	 * @param cityId
	 * @param provinceId
	 * @param caseId
	 * @param caseType
	 * @param dealType 处理类型1新增2修改3删除
	 */
	public static void syncFunSale(Integer cityId, Integer caseId, Integer caseType, Byte dealType) {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("cityId", cityId);
		jsonobject.put("caseId", caseId);
		jsonobject.put("caseType", caseType);
		jsonobject.put("tableName", "FUN_SALE");
		jsonobject.put("dealType", dealType);
		ERP_FUN_SALE_TOPIC.offer(jsonobject);
	}
	
	/**
	 * 
	 * @param cityId 
	 * @param provinceId
	 * @param caseId
	 * @param caseType
	 * @param dealType 处理类型1新增2修改3删除
	 */
	public static void syncFunLease(Integer cityId, Integer caseId, Integer caseType, Byte dealType) {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("cityId", cityId);
		jsonobject.put("caseId", caseId);
		jsonobject.put("caseType", caseType);
		jsonobject.put("tableName", "FUN_LEASE");
		jsonobject.put("dealType", dealType);
		ERP_FUN_LEASE_TOPIC.offer(jsonobject);
	}

	/**
	* @Title: 请求超时链接发送kafka
	* @Description: ${todo}(这里用一句话描述这个方法的作用)
	* @param opType: 超时报警， 2：断路报警
	* @return ${return_type}    返回类型
	* @author lcb
	* @Date 2018/12/22 15:04
	* @throws
	*/
	public static void projectWarmingMsg(String projectName, String warningMsg, String msgContent) {
		JSONObject jsonobject = new JSONObject();
		// 超过3条丢掉
		if(REQUEST_TIME_OUT.size() < 2) {
			jsonobject.put("projectName", projectName);
			jsonobject.put("msgContent", msgContent);
			jsonobject.put("warningMsg", warningMsg);
			REQUEST_TIME_OUT.offer(jsonobject);
		}
	}

	public static void syncHouse(Integer cityId, Integer caseId, Integer caseType) {
		if (Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			syncFunSale(cityId, caseId, caseType, (byte) 2);
		} else if (Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			syncFunLease(cityId, caseId, caseType, (byte) 2);
		}
	}

	/**
	 *
	 * @param cityId Integer
	 * @param compId Integer
	 * @param buildId Integer
	 * @param caseType Integer  1: 栋座 2:单元
	 * @param ids ids
	 * @param dealType 处理类型1新增2修改3删除
	 */
	public static void syncGenerateRoom(Integer cityId, Integer compId, Integer buildId, Integer caseType, String ids, Byte dealType) {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("cityId", cityId);
		jsonobject.put("compId", 0);
		jsonobject.put("buildId", buildId);
		jsonobject.put("caseType", caseType);
		jsonobject.put("ids", ids);
		jsonobject.put("dealType", dealType);
		ERP_BUILDING_SET_ROOF_TOPIC.offer(jsonobject);
	}

	public class KafkaErpFunSaleSysncTopicThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;

		@SuppressWarnings("unchecked")
		public KafkaErpFunSaleSysncTopicThread() {
			System.out.println("启动kafka统计平台线程.........KafkaErpFunSaleSysncTopicThread");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}

		@Override
		public void run() {
			while (true) {
				try {
					JSONObject jsonObj = ERP_FUN_SALE_TOPIC.take();
					if (jsonObj != null) {
						kafkaTemplate.send("erpFunSaleSysncTopic", jsonObj.toJSONString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class KafkaErpFunLeaseSysncTopicThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;

		@SuppressWarnings("unchecked")
		public KafkaErpFunLeaseSysncTopicThread() {
			System.out.println("启动kafka统计平台线程.........KafkaErpFunLeaseSysncTopicThread");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}

		@Override
		public void run() {
			while (true) {
				try {
					JSONObject jsonObj = ERP_FUN_LEASE_TOPIC.take();
					if (jsonObj != null) {
						kafkaTemplate.send("erpFunLeaseSysncTopic", jsonObj.toJSONString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public class KafkaRequestTimeOutTopicThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;

		@SuppressWarnings("unchecked")
		public KafkaRequestTimeOutTopicThread() {
			System.out.println("启动请求链接超时通知.........KafkaRequestTimeOutTopicThread");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}

		@Override
		public void run() {
			while (true) {
				try {
					JSONObject jsonObj = REQUEST_TIME_OUT.take();
					if (jsonObj != null) {
						kafkaTemplate.send("commonProjectWarmTopic", jsonObj.toJSONString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 消息推送
	 * @author Administrator
	 *
	 */
	public class PushMsgThread extends Thread {
        private KafkaTemplate<String, String> kafkaTemplate;
        @SuppressWarnings("unchecked")
        public PushMsgThread() {
            System.out.println("im消息日志线程.........");
            kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
        }

        @Override
        public void run() {
            while (true) {
                try {
                	JSONObject jsonObj = PUSH_MSG_BLOCKING_QUERY.take();
                	if (jsonObj != null) {
                        kafkaTemplate.send("imPushMsgTopic", jsonObj.toJSONString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

	public class KafkaErpBuildingSetRoofSysncTopicThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;

		@SuppressWarnings("unchecked")
		KafkaErpBuildingSetRoofSysncTopicThread() {
			System.out.println("启动kafka统计平台线程.........KafkaErpBuildingSetRoofSysncTopicThread");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}

		@Override
		public void run() {
			while (true) {
				try {
					JSONObject jsonObj = ERP_BUILDING_SET_ROOF_TOPIC.take();
					kafkaTemplate.send("erpBuildingSetRoofTopic1", jsonObj.toJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public class KafkaBuyCustSysncTopicThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;
		@SuppressWarnings("unchecked")
		public KafkaBuyCustSysncTopicThread() {
			System.out.println("启动请求链接超时通知.........KafkaRequestTimeOutTopicThread");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}

		@Override
		public void run() {
			while (true) {
				try {
					JSONObject jsonObj = ERP_FUN_BUY_TOPIC.take();
					if (jsonObj != null) {
						kafkaTemplate.send("erpFunBuyCustSysncTopic", jsonObj.toJSONString());
					}
				} catch (Exception e) {
				}
			}
		}
	}

	public class KafkaRentCustSysncTopicThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;
		@SuppressWarnings("unchecked")
		public KafkaRentCustSysncTopicThread() {
			System.out.println("启动请求链接超时通知.........KafkaRequestTimeOutTopicThread");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}


		@Override
		public void run() {
			while (true) {
				try {
					JSONObject jsonObj = ERP_FUN_RENT_TOPIC.take();
					if (jsonObj != null) {
						kafkaTemplate.send("erpFunRentCustSysncTopic", jsonObj.toJSONString());
					}
				} catch (Exception e) {
				}
			}
		}
	}
	
		 /***
     * 推送消息
     * @param jsonobject
     */
    public static void pushMsgByTemplate(JSONObject jsonobject) {
    	try {
	    	JSONObject paramObject = new JSONObject();
	    	paramObject.put("paramExt", jsonobject.toJSONString());
	    	HttpUtil.postJson(AppConfig.getPushWebDomain() + "openApi/kafka/pushMsg", paramObject.toJSONString());
    	} catch (Exception e) {
    		
    	}
    }
    
    /**
	 * 客源  dealType 处理类型1新增2修改3删除
	 * **/
	public static void syncCustomer(Integer cityId, Integer caseId, Integer caseType ,Integer dealType) {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("cityId", cityId);
		jsonobject.put("caseId", caseId);
		jsonobject.put("caseType", caseType);
		String tableName = "FUN_BUY_CUSTOMER";
		if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			tableName = "FUN_RENT_CUSTOMER";
		}
		jsonobject.put("tableName", tableName);
		jsonobject.put("dealType", dealType);
		if (Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			ERP_FUN_BUY_TOPIC.offer(jsonobject);
		} else if (Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			ERP_FUN_RENT_TOPIC.offer(jsonobject);
		}
	}
	
		/**
	 * @Title 楼盘图片
	 * @Author lcb
	 * @Time 2019/1/7
	 **/
	public static void updateBuildPhoto(Integer cityId, Integer buildId, String dealType) {
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("cityId", cityId);
		jsonobject.put("photoId", buildId);
		jsonobject.put("tableName", "BUILDING_PHOTO");
		jsonobject.put("dealType", dealType);
		ERP_BUILD_PHOTO_TOPIC.offer(jsonobject);
	}

	public class KafkaBuildPhotoSysncTopicThread extends Thread {
		private KafkaTemplate<String, String> kafkaTemplate;

		@SuppressWarnings("unchecked")
		KafkaBuildPhotoSysncTopicThread() {
			System.out.println("启动kafka统计平台线程.........KafkaErpBuildingSetRoofSysncTopicThread");
			kafkaTemplate = SpringContextUtil.getBean(KafkaTemplate.class);
		}

		@Override
		public void run() {
			while (true) {
				try {
					JSONObject jsonObj = ERP_BUILD_PHOTO_TOPIC.take();
					kafkaTemplate.send("erpBuildPhotoSysncTopic", jsonObj.toJSONString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
