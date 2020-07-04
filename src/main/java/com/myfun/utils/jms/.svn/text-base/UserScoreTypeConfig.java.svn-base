package com.myfun.utils.jms;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HeWei
 * @since 2018年7月23日 下午6:35:04
 * Modified XXX HeWei 2018年7月23日
 */
public class UserScoreTypeConfig {
	public static Map<Integer, UserScoreType> scoreMap = new HashMap<>();
	public enum UserScoreType {
		FDJ_SCORE	(1,  10, 100),			//房源登记分数--工作量统计中做的
		FK_SCORE	(2,  10, 100),			//房堪分数
		KFDP_SCORE	(3,  10, 100),			//看房点评（空看）分数
		SPSC_SCORE	(4,  10, 100),			//房源微拍（视频上传）分数
		VR_SCORE	(5,  10, 100),			//VR上传分数
		TPSC_SCORE	(6,  10, 100),			//图片上传分数
		YSTJ_SCORE	(7,  10, 100),			//钥匙提交分数
		FXG_SCORE	(8,  10, 100),			//房源维护（修改）分数
		FGJ_SCORE	(9,  10, 100),			//房源跟进分数
		KDJ_SCORE	(10, 10, 100),			//客源登记分数
		DK_SCORE	(11, 10, 100),			//带看分数
		SPDK_SCORE	(12, 10, 100),			//视频带看分数
		KXG_SCORE	(13, 10, 100),			//客源维护（修改）分数
		KGJ_SCORE	(14, 10, 100),			//客源跟进分数
		XQZJ_SCORE	(15, 10, 100),			//小区专家分数
		FYTG_SCORE	(16, 10, 100),			//房源推广分数
		ZFY_SCORE	(17, 10, 100),			//点亮真房源分数
		YXTG_SCORE	(18, 10, 100),			//营销推广分数
		YYHF_SCORE	(19, 10, 100),			//真房源发布到优优好房分数
		FYQF_SCORE	(20, 10, 100),			//房源群发分数
		DTFX_SCORE	(21, 10, 100),			//多图分享分数
		GXHZ_SCORE	(22, 10, 100),			//共享合作房源分数
		WXHP_SCORE	(23, 10, 100),			//优优好房五星好评分数
		PAPH_SCORE	(24, 10, 100),			//平安普惠贷款成功分数
		CJ_SCORE	(25, 10, 100),			//成交分数
		YXYG_SCORE	(26, 10, 100),			//微店入选优秀员工分数
		YJDB_SCORE	(27, 10, 100),			//本月业绩达标分数
		SMRZ_SCORE	(28, 10, 100),			//实名认证分数
		SJDL_SCORE	(29, 10, 100),			//手机app连续25天登录分数
		FSDB_SCORE	(30, 10, 100);			//经验值在xx分以上分数（分数达标）
		
		/**跑分对应分数*/
		private Integer score;
		/**最高可得分数*/
		private Integer maxScore;
		/**分数类型*/
		private Integer scoreType;
		
		/**
		 * 通过类型获取配置
		 * @author 张宏利
		 * @since 2017年3月23日
		 * @param scoreType
		 * @return
		 */
		public static UserScoreType getScoreType(int scoreType){
			return scoreMap.get(scoreType);
		}
		
		UserScoreType(Integer scoreType, Integer score, Integer maxScore) {
			this.scoreType = scoreType;
			this.score = score;
			this.maxScore = maxScore;
			scoreMap.put(scoreType, this);
		}
	
		public Integer getScore() {
			return score;
		}
	
		public void setScore(Integer score) {
			this.score = score;
		}
	
		public Integer getMaxScore() {
			return maxScore;
		}
	
		public void setMaxScore(Integer maxScore) {
			this.maxScore = maxScore;
		}
	
		public Integer getScoreType() {
			return scoreType;
		}
	
		public void setScoreType(Integer scoreType) {
			this.scoreType = scoreType;
		}
	
		@Override
		public String toString() {
			return String.valueOf(getScoreType());
		}
	}
}

