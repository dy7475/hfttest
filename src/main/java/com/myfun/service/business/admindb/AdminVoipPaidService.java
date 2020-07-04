package com.myfun.service.business.admindb;

import java.util.Date;

import com.myfun.repository.admindb.po.AdminVoipPaid;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminVoipPaidService extends BaseMapper<AdminVoipPaid, Integer> {
	/**
	 * 拨打电话回掉
	 * 
	 * @param connId
	 *            数据库连接
	 * @param callId
	 *            呼叫的唯一标识（沿用原来机制，由sdk组件生成）
	 * @param length
	 *            拨打时长（秒）
	 * @param reason
	 *            挂机原因描述，0：正常挂断；1：余额不足；2：媒体超时；3：无法接通；4：拒接；5：超时未接；6：拒接或超时未接；7：
	 *            平台服务器网络错误；8：用户请求取消通话；9：第三方鉴权错误；255：其他原因。
	 * @param subreason
	 *            挂机原因补充描述，1：主叫挂断；2：被叫挂断；目前当reason=0时有效。
	 * @param recordurl
	 *            通话录音完整下载地址，默认为空。 //取地址需要加密
	 * @param startTime
	 *            开始通话时间。时间格式如：2014-06-16 16:47:28
	 * @param stopTime
	 *            结束通话时间。时间格式如：2014-06-16 17:31:14
	 */
	public void voipCallBack(String connId, String callId, Integer length, Byte reason, Byte subreason,
			String recordurl, Date startTime, Date stopTime);
}
