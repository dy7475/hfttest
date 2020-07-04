/**
 * @author 方李骥
 * @since 2016年9月5日
 */
package com.myfun.erpWeb;

/**
 * 设置域名和clientKey
 * @author 方李骥
 * @since 2016年9月5日
 */
public final class UnitTest {
	private volatile static UnitTest newInstance;
	/**archiveId**/
	private String archiveId;
	/**clientKey**/
	private String clientKey;
	/**域名**/
	private String host;
	/**结果集**/
	private String result;
	/**账号电话号码**/
	/**url**/
	private String userMobile;
	/**模拟登陆url**/
	private String simulatedLandingUrl = "http://test.51vfang.cn/hftWebService/web/api/authentication/per.do";

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the simulatedLandingUrl
	 */
	public String getSimulatedLandingUrl() {
		return simulatedLandingUrl;
	}
	/**
	 * @param simulatedLandingUrl the simulatedLandingUrl to set
	 */
	public void setSimulatedLandingUrl(String simulatedLandingUrl) {
		this.simulatedLandingUrl = simulatedLandingUrl;
	}
	/**
	 * @return the userMobile
	 */
	public String getUserMobile() {
		return userMobile;
	}
	/**
	 * @param userMoile the userMoile to set
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	/**
	 * @return the clientKey
	 */
	public String getClientKey() {
		return clientKey;
	}
	/**
	 * @param clientKey the clientKey to set
	 */
	public void setClientKey(String clientKey) {
		this.clientKey = clientKey;
	}
	private UnitTest(){
		
	}
	public static UnitTest getNewInstance(){
		synchronized (UnitTest.class) {
			if(newInstance==null){
				return new UnitTest();
			}
			return newInstance;
		}
	}
	public String getArchiveId() {
		return archiveId;
	}
	/**
	 * @param clientKey the clientKey to set
	 */
	public void setArchiveId(String archiveId) {
		this.archiveId = archiveId;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
}
