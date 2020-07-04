package com.myfun.framework.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JiangSongGui
 * @since 2017年11月28日 下午5:17:54
 * Modified XXX JiangSongGui 2017年11月28日
 */
@Configuration
@EnableSwagger2
@ConditionalOnExpression("!'${spring.profiles.active}'.equals('online')")
public class Swagger2 {
	
	@Bean
	public Docket createRestApi() {
		Predicate<String> paths = PathSelectors.any();
		//Predicate<String> paths = AppConfig.isOnline() ? PathSelectors.none() : PathSelectors.any();
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(Predicates.or(
						RequestHandlerSelectors.basePackage("com.myfun.erpWeb"),
						RequestHandlerSelectors.withClassAnnotation(Api.class))) //不支持接口
				.paths(paths)
				.build()
				.globalOperationParameters(setHeaderToken());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("erpWeb接口文档")
				.description("欢迎使用")
				.termsOfServiceUrl("http://blog.didispace.com/")
				.version("1.0")
				.build();
	}

	private List<Parameter> setHeaderToken() {
		ParameterBuilder archiveIdPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		archiveIdPar.name("CLIENTKEY")
				.description("CLIENTKEY")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build();
		pars.add(archiveIdPar.build());
		return pars;
	}
}

