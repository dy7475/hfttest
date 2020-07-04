package com.myfun.framework.web.interceptor;

import com.myfun.erpWeb.marketEdition.MarketEditionStaticDataController;
import com.myfun.framework.session.Operator;
import com.myfun.framework.session.ThreadLocalHelper;
import com.myfun.repository.reportdb.dao.ReportMarketEditionStaticDataMapper;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

/**
  * 营销版静态数据获取
  * @author 李成兵
  * @since 2018/5/29
  * @param
  * @return
  */
//@Component
public class MarketingEditionInterceptor implements HandlerInterceptor {

	@Autowired
	ReportMarketEditionStaticDataMapper reportMarketEditionStaticDataMapper;

	@Autowired
	MarketEditionStaticDataController marketEditionStaticDataController;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String servletPath = request.getServletPath();
		if(servletPath.contains("openApi")) {
			return true;
		}
		Operator operator = ThreadLocalHelper.getOperator();
		Hashtable<String, Object> allAtrtibute = operator.getAllAtrtibute();

		String path = servletPath.substring(servletPath.lastIndexOf("/") + 1);

		if(null != operator && (4 == operator.getCompType() || 5 == operator.getCompType()) ) {


//			Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
//			String jsonStr = IOUtils.toString(request.getInputStream(), DEFAULT_CHARSET);
//			//System.out.println("message转换器："+jsonStr);
//			// 暂时不允许json格式数据，全部是需要加密的，解密失败就不管了
//			// 之后会加验证才能使用纯json格式
//			//if(!jsonStr.startsWith("{")){
//			try {
//				jsonStr = AESHelper.decode(jsonStr);
//			} catch (Exception e) {
//				throw new HttpMessageNotReadableException("Unrecognized field \"xparam\"");
//			}
//			//

			String s = marketEditionStaticDataController.needQueryData(path, allAtrtibute);
			if(StringUtil.isNotEmpty(s)) {
				returnData(response, allAtrtibute, s);
				return false;
			}
		}
		return true;
	}

	private void returnData(HttpServletResponse response, Hashtable<String, Object> allAtrtibute, String object) throws IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(object);
		writer.flush();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
