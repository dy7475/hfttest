package com.myfun;

import com.extension.framework.cat.annotation.EnableCat;
import com.extension.framework.codis.annotation.EnableCodis;
import com.extension.framework.datasource.annotation.*;
import com.extension.framework.filter.cat.annotation.EnableCatFilter;
import com.extension.framework.filter.fusing.annotation.EnableRequestFusing;
import com.extension.framework.filter.overflow.annotation.EnableRequestOverflowWarning;
import com.extension.framework.monitor.annotation.EnableProjectMonitor;
import com.extension.framework.mq.annotation.EnableActiveMq;
import com.extension.framework.redis.monitor.annotation.EnableRedisMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 程序启动器
 *
 * @author jiangsonggui
 * @ClassName: Application
 * @Description: TODO
 * @date 2015年11月25日 下午5:26:33
 */

@SpringBootApplication(exclude = {SolrAutoConfiguration.class, KafkaAutoConfiguration.class})
@EnableEurekaClient
@EnableRequestFusing
@EnableRequestOverflowWarning
@EnableRedisMonitor
@EnableCodis
@EnableActiveMq
@EnableReportDatasource
@EnableErpDatasource
@EnableAdminDatasource
@EnableAgencyDatasource
@EnableCommDatasource
@EnableAdminRptDatasource
@EnableFafunDatasource
@EnableSearch2Datasource
@EnableSearchDatasource
@EnableCat
@EnableProjectMonitor
@EnableCatFilter
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.out.println("启动完成");
    }
}
