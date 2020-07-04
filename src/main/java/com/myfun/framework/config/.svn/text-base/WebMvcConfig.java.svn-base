package com.myfun.framework.config;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.MultipartConfigElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.dianping.cat.servlet.CatFilter;
import com.myfun.framework.httpMessageConvert.EncryptionHttpMessageConvert;
import com.myfun.framework.web.MockTestFilter;
import com.myfun.framework.web.exceptionResolver.GlobalHandlerExceptionResolver;
import com.myfun.framework.web.filter.StringNotBlankPropertyFilter;
import com.myfun.framework.web.interceptor.FrontUnitTestInterceptor;
import com.myfun.framework.web.interceptor.OpenApiSecurityInterceptor;
import com.myfun.framework.web.interceptor.SaveRequestInterceptor;
import com.myfun.framework.web.interceptor.UserSecurityInterceptor;

/**
 * mvc 配置
 * 
 * @ClassName: WebMvcConfig
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月25日 下午4:27:51
 *
 */
@Component
@Configuration
@Import(MockTestFilter.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	private transient static final Logger LOGGER = LoggerFactory.getLogger(WebMvcConfig.class);
	@Autowired
	private UserSecurityInterceptor userSecurityInterceptor;
	@Autowired
	private FrontUnitTestInterceptor frontUnitTestInterceptor;
	@Autowired
	private GlobalHandlerExceptionResolver globalHandlerExceptionResolver;
	@Autowired
	private MappingJackson2HttpMessageConverter httpMessageConverter;
	@Autowired
	private SaveRequestInterceptor saveRequestInterceptor;
	@Autowired
	private OpenApiSecurityInterceptor openApiSecurityInterceptor;
	@Autowired
	private EncryptionHttpMessageConvert encryptionHttpMessageConvert;
//	@Autowired
//	private MarketingEditionInterceptor marketingEditionInterceptor;
	@Autowired
	MockTestFilter mockTestFilter;

	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userSecurityInterceptor);
//		registry.addInterceptor(marketingEditionInterceptor);
		registry.addInterceptor(saveRequestInterceptor);
		registry.addInterceptor(openApiSecurityInterceptor);
		registry.addInterceptor(frontUnitTestInterceptor);
	}

	@Bean
	public FilterRegistrationBean mockTestFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(mockTestFilter);
		registration.addUrlPatterns("/*");
		registration.setName("mockTest-filter");
		registration.setOrder(2);
		return registration;
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(globalHandlerExceptionResolver);
		LOGGER.debug("初始化异常解析器");
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(true);
		httpMessageConverter.getObjectMapper().setDateFormat(format);
		DateFormatter dateFormatter = new DateFormatter();
		dateFormatter.setPattern("yyyy-MM-dd HH:mm:ss");
		dateFormatter.setLenient(true);
		registry.addFormatter(dateFormatter);
		super.addFormatters(registry);
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("1024MB");
		factory.setMaxRequestSize("1024MB");
		return factory.createMultipartConfig();
	}
	
	@Bean
	public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(new MediaType("application", "json", Charset.forName("UTF-8")));
		fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteDateUseDateFormat);
		fastJsonConfig.setSerializeFilters(new StringNotBlankPropertyFilter());
		fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		return fastJsonHttpMessageConverter;
	}

	// @Bean
	// public MessageSource messageSource() {
	// ResourceBundleMessageSource messageSource = new
	// ResourceBundleMessageSource();
	// messageSource.setBasename("i18n/i18n");
	// return messageSource;
	// }

	/*
	 * @Beanpublic FilterRegistrationBean filterRegistrationBean() {
	 * FilterRegistrationBean filterRegistrationBean = new
	 * FilterRegistrationBean(); filterRegistrationBean.setFilter(new
	 * WebStatFilter()); filterRegistrationBean.addUrlPatterns("/*");
	 * filterRegistrationBean.addInitParameter("exclusions",
	 * "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*"); return
	 * filterRegistrationBean; }
	 */

	@Bean
	public ServletRegistrationBean druidServlet() {
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0, encryptionHttpMessageConvert);
		converters.add(1, fastJsonHttpMessageConverter());
		super.configureMessageConverters(converters);
	}

	@Bean
	public FilterRegistrationBean catFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		CatFilter filter = new CatFilter();
		registration.setFilter(filter);
		registration.addUrlPatterns("/*");
		registration.setName("cat-filter");
		registration.setOrder(1);
		return registration;
	}

}

